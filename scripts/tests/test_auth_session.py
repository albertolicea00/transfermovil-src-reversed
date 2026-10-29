"""Compare auth state transitions, expiry boundaries, and DAO failures to JADX.

Both test copies replace the single Date() clock read with the same fixed time;
production clock and behavior are unchanged. DAO and Fragment are substitutes.
"""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class AuthSessionTest(unittest.TestCase):
    def test_original_auth_transitions(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-auth-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            for relative in ["banking/AuthValidator.java", "data/entity/AuthSession.java",
                             "core/enums/OperationType.java", "data/ITMDataDatabase.java",
                             "data/FieldType.java", "data/FieldSchema.java", "data/TableMetadata.java"]:
                name = "cu/etecsa/transfermovil/" + relative
                text = (ROOT / "app/src/main/java" / name).read_text()
                write(name, text.replace("new Date()", "new Date(test.Clock.now)"))
            raw = (ROOT / "src/cu/etecsa/cubacel/tr/tm/c69cvBqjXKw/puGDXabehz.java").read_text()
            for old, new in {
                "package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;": "package cu.etecsa.transfermovil.banking;",
                "cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey": "cu.etecsa.transfermovil.data.entity.AuthSession",
                "cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY": "cu.etecsa.transfermovil.data.DatabaseHelper",
                "cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ": "cu.etecsa.transfermovil.core.enums.OperationType",
                "puGDXabehz": "ReferenceAuth", "AOperKey ": "AuthSession ",
                "unYp8VQThY.": "DatabaseHelper.", "Nl0yptXmjQ ": "OperationType ",
                "new Date()": "new Date(test.Clock.now)",
            }.items():
                raw = raw.replace(old, new)
            write("cu/etecsa/transfermovil/banking/ReferenceAuth.java", raw)
            write("androidx/fragment/app/Fragment.java", "package androidx.fragment.app; public class Fragment {}")
            write("com/j256/ormlite/field/DatabaseField.java", "package com.j256.ormlite.field; public @interface DatabaseField { boolean generatedId() default false; }")
            write("com/j256/ormlite/table/DatabaseTable.java", 'package com.j256.ormlite.table; public @interface DatabaseTable { String tableName() default ""; }')
            write("test/Clock.java", "package test; public class Clock { public static long now=1700000000000L; }")
            write("cu/etecsa/transfermovil/data/DatabaseHelper.java", DAO)
            write("AuthCheck.java", HARNESS)
            build = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(build.returncode, 0, build.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "AuthCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("Compared 517 auth transitions", result.stdout)


DAO = r"""
package cu.etecsa.transfermovil.data;
import cu.etecsa.transfermovil.data.entity.AuthSession;
import cu.etecsa.transfermovil.core.enums.OperationType;
public class DatabaseHelper {
    static final DatabaseHelper INSTANCE=new DatabaseHelper();
    public static AuthSession key;
    public static int mode,updates;
    public static String requested;
    public static DatabaseHelper getInstance() { return INSTANCE; }
    public AuthSession getAOperKey(OperationType operation) {
        requested=String.valueOf(operation);
        if(mode==7) throw new IllegalStateException("fixture query failure");
        return key;
    }
    public void updateAOperKey(AuthSession value) {
        updates++; if(mode==8) throw new IllegalStateException("fixture update failure");
    }
}
"""

HARNESS = r"""
import java.util.*;
import java.lang.reflect.*;
import cu.etecsa.transfermovil.banking.*;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.AuthSession;
import cu.etecsa.transfermovil.core.enums.OperationType;
public class AuthCheck {
    static void reset(int mode) {
        DatabaseHelper.mode=mode; DatabaseHelper.updates=0; DatabaseHelper.requested=null;
        if(mode==0) { DatabaseHelper.key=null; return; }
        AuthSession key=new AuthSession(); key.setAuth(mode!=1 && mode!=9);
        key.setPin("saved-pin"); key.setOperacion(OperationType.Pago);
        long offset=mode==4?-1800000:mode==5 || mode==8?-1800001:mode==6?1:mode==10?-1799999:0;
        key.setAuthDate(mode==2 || mode==9?null:new Date(test.Clock.now+offset));
        DatabaseHelper.key=key;
    }
    static String run(Object validator,OperationType operation,int mode) throws Exception {
        reset(mode); Object result;
        try { result=validator.getClass().getMethod("validateAuth",OperationType.class).invoke(validator,operation); }
        catch(InvocationTargetException e) { result="throws:"+e.getCause().getClass().getName(); }
        AuthSession key=DatabaseHelper.key;
        return result+":"+DatabaseHelper.requested+":"+DatabaseHelper.updates+":"+(key==null?"null":
            key.isAuth()+":"+(key.getAuthDate()==null?"null":key.getAuthDate().getTime())+":"+key.getPin()+":"+key.getOperacion());
    }
    public static void main(String[] args) throws Exception {
        Object raw=new ReferenceAuth(){},clean=new AuthValidator(){};
        List<OperationType> operations=new ArrayList<>(Arrays.asList(OperationType.values()));
        operations.add(null); int count=0;
        for(OperationType operation:operations) for(int mode=0;mode<11;mode++) {
            String a=run(raw,operation,mode),b=run(clean,operation,mode);
            if(!a.equals(b)) throw new AssertionError(operation+"/"+mode+": "+a+" / "+b);
            count++;
        }
        String boundary=run(clean,OperationType.Pago,4);
        if(!boundary.startsWith("AUTH_OK:Pago:0:true:")) throw new AssertionError("inclusive expiry boundary");
        String expired=run(clean,OperationType.Pago,5);
        if(!expired.startsWith("NO_AUTH:Pago:1:false:null:")) throw new AssertionError("expiry must persist cleared session");
        System.out.println("Compared "+count+" auth transitions");
    }
}
"""
