"""Compare the canonical activation validator with the original algorithm."""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class ActivationCodeTest(unittest.TestCase):
    def test_original_algorithm(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-activation-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            original = "cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/hY5P1xQ5h8.java"
            text = (ROOT / "src" / original).read_text()
            # JADX omitted this catch accumulator declaration. Restore only its
            # lexical declaration so the original method can compile as an oracle.
            text = text.replace("public String en_version(int random, String version_number, String aphone_number) {",
                                "public String en_version(int random, String version_number, String aphone_number) { Exception ex;")
            write(original, text)
            clean = "cu/etecsa/transfermovil/config/ActivationCodeValidator.java"
            write(clean, (ROOT / "app/src/main/java" / clean).read_text())
            write("com/github/paolorotolo/appintro/BuildConfig.java", """
package com.github.paolorotolo.appintro;
public class BuildConfig { public static final String FLAVOR=""; }
""")
            write("ActivationCheck.java", HARNESS)
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            checked = subprocess.run(["java", "-cp", str(root / "classes"), "ActivationCheck"],
                                     capture_output=True, text=True, timeout=60)
            self.assertEqual(checked.returncode, 0, checked.stdout + checked.stderr)
            self.assertIn("Activation comparisons passed", checked.stdout)


HARNESS = r"""
import java.util.*;
import java.lang.reflect.*;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.transfermovil.config.ActivationCodeValidator;
public class ActivationCheck {
    static int cases;
    static Object run(Object object,String method,Class<?>[] types,Object... args) throws Exception {
        try { return object.getClass().getMethod(method,types).invoke(object,args); }
        catch(InvocationTargetException e) { return "throws:"+e.getCause().getClass().getName(); }
    }
    static void compare(Object a,Object b,String method,Class<?>[] types,Object... args) throws Exception {
        Object expected=run(a,method,types,args), actual=run(b,method,types,args);
        if(!Objects.equals(expected,actual)) throw new AssertionError(method+Arrays.toString(args)+": "+expected+" / "+actual);
        cases++;
    }
    public static void main(String[] args) throws Exception {
        Object raw=new hY5P1xQ5h8(),clean=new ActivationCodeValidator();
        String[] phones={null,"","1234567","51234567","+5351234567","5351234567","15123456789","abcdefgh"};
        String[] versions={"1260416","1234567","","123","abcdefg",null};
        for(String phone:phones) {
            compare(raw,clean,"corregir_numero_telefonico",new Class<?>[]{String.class},phone);
            for(int seed=-1;seed<10;seed++) {
                compare(raw,clean,"rotar_phone",new Class<?>[]{String.class,int.class},phone,seed);
                for(String version:versions) {
                    compare(raw,clean,"en_version",new Class<?>[]{int.class,String.class,String.class},seed,version,phone);
                    for(String code:new String[]{null,"","-1","012345678","invalid"})
                        compare(raw,clean,"check_code_activation",new Class<?>[]{String.class,String.class,String.class},code,version,phone);
                }
            }
        }
        for(int seed=0;seed<8;seed++) {
            String code=((hY5P1xQ5h8)raw).en_version(seed,"1260416","51234567");
            compare(raw,clean,"check_code_activation",new Class<?>[]{String.class,String.class,String.class},code,"1260416","51234567");
        }
        System.out.println("Activation comparisons passed: "+cases);
    }
}
"""
