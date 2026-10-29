"""Check recovered error messages against an oracle evaluated from smali."""

import importlib.util
import json
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
FIXTURE = ROOT / "mappings/evidence/ecommerce-errors.json"
SPEC = importlib.util.spec_from_file_location("message_evidence", ROOT / "scripts/message-handler-evidence.py")
MODULE = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(MODULE)


class MessageEvidenceTest(unittest.TestCase):
    def test_smali_fixture_is_reproducible(self):
        if not (ROOT / MODULE.RELATIVE).is_file():
            self.skipTest("Local smali input is absent; JVM test uses the recorded bytecode evidence")
        self.assertEqual(json.loads(FIXTURE.read_text()), MODULE.evidence(ROOT))

    @unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
    def test_java_matches_bytecode_evidence(self):
        evidence = json.loads(FIXTURE.read_text())
        with tempfile.TemporaryDirectory(prefix="transfermovil-errors-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            for name in ("MessageHandler", "ErrorType"):
                relative = "cu/etecsa/transfermovil/ecommerce/" + name + ".java"
                write(relative, (ROOT / "app/src/main/java" / relative).read_text())
            resources = ["default_error_msg", "tx_no_item_mostrar", "error_msg_no_permiso",
                         "err_login_1", "err_login_2", "err_login_5"]
            constants = "".join(f"public static final int {name}={index};" for index, name in enumerate(resources))
            write("cu/etecsa/transfermovil/R.java", "package cu.etecsa.transfermovil; public class R { public static class string {" + constants + "}}")
            literals = ",".join(json.dumps("@string/" + name) for name in resources)
            write("android/content/Context.java", "package android.content; public class Context { public String getString(int id) { return new String[]{" + literals + "}[id]; }}")
            write("android/util/Log.java", """
package android.util;
public class Log {
    public static String last;
    public static int e(String tag,String message) { last=tag+":"+message; return 0; }
}
""")
            calls = []
            for row in evidence["rows"]:
                calls.append("check(h,ErrorType." + row["operation"] + "," + json.dumps(row["code"]) +
                             "," + json.dumps(row.get("value"), ensure_ascii=False) + "," +
                             ("true" if "throws" in row else "false") + ");")
            write("ErrorCheck.java", HARNESS.replace("CASES", "\n".join(calls)))
            build = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(build.returncode, 0, build.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "ErrorCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("126 bytecode cases passed", result.stdout)


HARNESS = r"""
import android.content.Context;
import android.util.Log;
import cu.etecsa.transfermovil.ecommerce.*;
public class ErrorCheck {
    static int cases;
    static void check(MessageHandler h,ErrorType type,String code,String expected,boolean throwsNull) {
        cases++;
        try {
            String actual=h.getErrorMessage(type,code);
            if(throwsNull || !java.util.Objects.equals(actual,expected))
                throw new AssertionError(type+"/"+code+": "+actual+" expected "+expected);
        } catch(NullPointerException e) { if(!throwsNull) throw e; }
    }
    public static void main(String[] args) {
        Context context=new Context();
        MessageHandler h=MessageHandler.getInstance(context);
        if(h!=MessageHandler.getInstance(context)) throw new AssertionError("singleton");
        CASES
        try { h.getErrorMessage(null,"1"); throw new AssertionError("null enum"); }
        catch(NullPointerException expected) {}
        for(int code:new int[]{-1,0,200,401,402,403,404,405,422,500,503}) {
            String expected=code==401?"No autorizado.":"@string/default_error_msg";
            if(!h.getMessage(code).equals(expected)) throw new AssertionError("HTTP "+code);
            if(!h.getMessage(code,"head","body").equals(expected)) throw new AssertionError("HTTP overload");
            if(!Log.last.equals("BULEVAR-ERROR:head: body")) throw new AssertionError("error log");
            h.WriteLog(code,"head","body");
            if(!Log.last.equals("BULEVAR-ERROR:head: CODE ["+code+"]body")) throw new AssertionError("code log");
        }
        System.out.println(cases+" bytecode cases passed");
    }
}
"""
