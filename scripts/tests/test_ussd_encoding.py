"""Compare BaseMainActivity.code with the original numeric/mixed USSD encoder."""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


def java_method(source, signature):
    start = source.index(signature)
    brace = source.index("{", start)
    depth = 0
    for end in range(brace, len(source)):
        if source[end] == "{":
            depth += 1
        elif source[end] == "}":
            depth -= 1
            if depth == 0:
                return source[start:end + 1]
    raise AssertionError(f"Unclosed method: {signature}")


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class UssdEncodingTest(unittest.TestCase):
    def test_original_encoder_and_packet_format(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-ussd-code-") as directory:
            root = Path(directory)

            def write(name, content):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(content)

            raw_path = ROOT / "src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/rDEl7rW1aN.java"
            clean_path = ROOT / "app/src/main/java/cu/etecsa/transfermovil/base/BaseMainActivity.java"
            raw, clean = raw_path.read_text(), clean_path.read_text()
            raw_code = java_method(raw, "public String code(String cadena)")
            raw_integer = java_method(raw, "public boolean esEntero(String cad)")
            clean_code = java_method(clean, "public String code(String cadena)")
            clean_integer = java_method(clean, "public boolean esEntero(String cad)")
            import re
            version = re.search(r"public static String code_version = .*?;", raw).group(0)
            binary = re.search(r"public String crude_code = .*?;", raw).group(0)
            write("raw/Encoder.java", f"""
package raw;
import java.util.*;
import AFm1GraXBXUkpF1hmOdV.Tz34gww2TFwrsuT8ukpL;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB;
public class Encoder {{ {version} {binary} {raw_code} {raw_integer} }}
""")
            version = re.search(r"public static String code_version = .*?;", clean).group(0)
            binary = re.search(r"public String crude_code = .*?;", clean).group(0)
            write("clean/Encoder.java", f"""
package clean;
import java.util.*;
import cu.etecsa.transfermovil.crypto.ussd.UssdCipherOrchestrator;
import cu.etecsa.transfermovil.config.NautaCodeEncoder;
public class Encoder {{ {version} {binary} {clean_code} {clean_integer} }}
""")

            raw_helpers = ROOT / "src/AFm1GraXBXUkpF1hmOdV"
            for name in ("Tz34gww2TFwrsuT8ukpL", "YzK9tTZsYVnC5kFxSie",
                         "hKRRh7lnIpNaVleqsuo", "ytpPfHi93O3gQEyZrT9r"):
                helper = (raw_helpers / f"{name}.java").read_text()
                helper = helper.replace("new Random().nextInt(100)", "42")
                if name == "hKRRh7lnIpNaVleqsuo":
                    helper = helper.replace("public List f3aSHV52SplNh3HfZBSmJe;",
                                            "public List<Integer> f3aSHV52SplNh3HfZBSmJe;")
                write(f"AFm1GraXBXUkpF1hmOdV/{name}.java", helper)
            write("cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/kR22DOzTiB.java",
                  (ROOT / "src/cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/kR22DOzTiB.java").read_text())
            write("cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/EKB7Plln4L.java",
                  (ROOT / "src/cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/EKB7Plln4L.java").read_text())
            clean_helpers = ROOT / "app/src/main/java/cu/etecsa/transfermovil/crypto/ussd"
            for name in ("UssdCipherOrchestrator", "SubstitutionTableBuilder",
                         "DigitSubstituter", "XorCipherStep"):
                helper = (clean_helpers / f"{name}.java").read_text()
                helper = helper.replace("new Random().nextInt(100)", "42")
                write(f"cu/etecsa/transfermovil/crypto/ussd/{name}.java", helper)
            for name in ("NautaCodeEncoder", "CharacterCodeDictionary"):
                write(f"cu/etecsa/transfermovil/config/{name}.java",
                      (ROOT / f"app/src/main/java/cu/etecsa/transfermovil/config/{name}.java").read_text())
            write("com/github/paolorotolo/appintro/BuildConfig.java", """
package com.github.paolorotolo.appintro;
public class BuildConfig { public static final String FLAVOR=""; }
""")
            write("android/net/Uri.java", """
package android.net;
public class Uri { public static String encode(String value) { return value.equals("#")?"%23":value; } }
""")
            write("UssdEncodingCheck.java", HARNESS)
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(path) for path in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "UssdEncodingCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("USSD encoding comparisons passed", result.stdout)


HARNESS = r"""
import java.util.*;
public class UssdEncodingCheck {
 static int cases;
 static void compare(String input) {
  Object original, reconstructed;
  try { original=new raw.Encoder().code(input); }
  catch(Exception e) { original="throws:"+e.getClass().getName(); }
  try { reconstructed=new clean.Encoder().code(input); }
  catch(Exception e) { reconstructed="throws:"+e.getClass().getName(); }
  if(!Objects.equals(original,reconstructed))
   throw new AssertionError(input+" => "+original+" / "+reconstructed);
  cases++;
 }
 public static void main(String[] args) {
  for(String value:new String[]{"0","00","7","12","123","12345","00012345","123456789"}) compare(value);
  for(String a:new String[]{"1","12","12345","00012345"})
   for(String b:new String[]{"0","9","67","89012"}) {
    compare(a+"*"+b); compare(a+"*"+b+"*123");
   }
  for(String input:new String[]{"12345*user@nauta.cu*67890","nauta*123*abc","user@nauta.cu*abc",
      "123**45","1*ñá*22","a1b2c","","***","12345*12345*12345*12345*12345"}) compare(input);
  System.out.println("USSD encoding comparisons passed: "+cases);
 }
}
"""
