"""Compile real cipher helpers extracted from both activity sources and compare.

Only the two activity helper methods and four original AES helper methods are
extracted. This does not compile the rest of the Android activity or prove the
other cipher schemes; JCE runs real AES, with an Android Base64 compatibility shim.
"""

import re
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


def method(text, signature):
    start = text.index(signature)
    opening = text.index("{", start)
    depth = 1
    end = opening + 1
    while depth:
        depth += (text[end] == "{") - (text[end] == "}")
        end += 1
    return text[start:end]


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class AccountCryptoTest(unittest.TestCase):
    def test_original_activity_cipher_helpers(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-account-crypto-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            for package, name, path, dependency in [
                ("cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK", "rDEl7rW1aN",
                 "src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java", "V5FFEZ0Qrr0"),
                ("cu.etecsa.transfermovil.base", "BaseMainActivity",
                 "app/src/main/java/cu/etecsa/transfermovil/base/BaseMainActivity.java",
                 "cu.etecsa.transfermovil.crypto.CryptoProvider"),
            ]:
                source = (ROOT / path).read_text()
                field = re.search(r"public static String cv = [^;]+;", source)[0]
                bodies = "\n".join(method(source, "public String " + operation + "(")
                                   for operation in ("encryption", "decryption"))
                imports = "import javax.crypto.SecretKey; import android.util.Log; import com.github.paolorotolo.appintro.BuildConfig;"
                if "." in dependency:
                    imports += "import " + dependency + ";"
                write(package.replace(".", "/") + "/" + name + ".java",
                      "package " + package + ";" + imports + "public class " + name + " {" + field + bodies + "}")
            source = (ROOT / "src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/V5FFEZ0Qrr0.java").read_text()
            imports = "\n".join(re.findall(r"^import (?:java\.|javax\.|android\.util\.Base64)[^\n]+", source, re.MULTILINE))
            bodies = "\n".join(method(source, signature) for signature in (
                "public static byte[] shKey(String", "public static SecretKey generateKey(String",
                "public static String encryptMsg(", "public static String decryptMsg("))
            write("cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/V5FFEZ0Qrr0.java",
                  "package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;\n" + imports + "\npublic class V5FFEZ0Qrr0 {" + bodies + "}")
            relative = "cu/etecsa/transfermovil/crypto/CryptoProvider.java"
            write(relative, (ROOT / "app/src/main/java" / relative).read_text())
            write("android/util/Base64.java", BASE64)
            write("android/util/Log.java", "package android.util; public class Log { public static int d(String tag,String value) { return 0; } }")
            write("com/github/paolorotolo/appintro/BuildConfig.java", 'package com.github.paolorotolo.appintro; public class BuildConfig { public static final String FLAVOR=""; }')
            write("CryptoCheck.java", HARNESS)
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "CryptoCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("Original AES helpers and round trips matched", result.stdout)


BASE64 = r"""
package android.util;
public class Base64 {
    public static final int NO_WRAP=2;
    public static String encodeToString(byte[] value,int flags) {
        return flags==NO_WRAP?java.util.Base64.getEncoder().encodeToString(value):
            java.util.Base64.getMimeEncoder(76,new byte[]{10}).encodeToString(value)+"\n";
    }
    public static byte[] decode(String value,int flags) { return java.util.Base64.getMimeDecoder().decode(value); }
    public static byte[] decode(byte[] value,int flags) { return java.util.Base64.getMimeDecoder().decode(value); }
}
"""

HARNESS = r"""
import java.util.*;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import cu.etecsa.transfermovil.base.BaseMainActivity;
public class CryptoCheck {
    public static void main(String[] args) {
        rDEl7rW1aN raw=new rDEl7rW1aN(); BaseMainActivity clean=new BaseMainActivity();
        for(String value:new String[]{null,"","0000000000000001","12345678","ñá😀", "A".repeat(200)}) {
            String a=raw.encryption(value),b=clean.encryption(value);
            if(!Objects.equals(a,b)) throw new AssertionError("ciphertext differs");
            if(b.contains("\n")) throw new AssertionError("Base64 must not wrap");
            if(value!=null) {
                if(b.isEmpty()) throw new AssertionError("encryption placeholder remains");
                if(!clean.decryption(b).equals(value)) throw new AssertionError("round trip");
                if(!raw.decryption(b).equals(value)) throw new AssertionError("original round trip");
            }
        }
        for(String value:new String[]{null,"","QQ==","invalid","%%%"})
            if(!Objects.equals(raw.decryption(value),clean.decryption(value))) throw new AssertionError("error fallback");
        if(!clean.encryption("same").equals(clean.encryption("same"))) throw new AssertionError("original deterministic ECB");
        System.out.println("Original AES helpers and round trips matched");
    }
}
"""
