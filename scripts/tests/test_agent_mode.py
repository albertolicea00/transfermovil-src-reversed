"""Compare GlobalState's agent mode check with the original smali-backed source."""

import re
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


def method(source, signature):
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
class AgentModeTest(unittest.TestCase):
    def test_original_agent_mode_decision(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-agent-mode-") as directory:
            root = Path(directory)

            def write(name, content):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(content)

            raw_state = (ROOT / "src/cu/etecsa/cubacel/tr/tm/l08fNVC4KOKK/U6ucOCBccJ.java").read_text()
            clean_state = (ROOT / "app/src/main/java/cu/etecsa/transfermovil/core/GlobalState.java").read_text()
            write("raw/AgentModeOracle.java", """
package raw;
import android.content.Context;
import android.util.Log;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
public class AgentModeOracle { METHOD }
""".replace("METHOD", method(raw_state, "public static boolean isAGTelecom(Context context)")))
            write("clean/AgentMode.java", """
package clean;
import android.content.Context;
import android.util.Log;
import cu.etecsa.transfermovil.data.SharedPreferencesAccessor;
import cu.etecsa.transfermovil.config.ActivationCodeValidator;
public class AgentMode { METHOD }
""".replace("METHOD", method(clean_state, "public static boolean isAGTelecom(Context context)")))

            write("android/content/Context.java", """
package android.content;
public class Context {
 public String code, version="1260416", phone="51234567", fail;
 public Context(String c) { code=c; }
}
""")
            write("android/util/Log.java", """
package android.util;
public class Log { public static int e(String tag,String message) { return 0; } }
""")
            write("cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/Fr52O1uSYF.java", accessor("Fr52O1uSYF"))
            write("cu/etecsa/transfermovil/data/SharedPreferencesAccessor.java", accessor("SharedPreferencesAccessor"))
            write("cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/hY5P1xQ5h8.java",
                  (ROOT / "src/cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/hY5P1xQ5h8.java").read_text()
                  .replace("public String en_version(int random, String version_number, String aphone_number) {",
                           "public String en_version(int random, String version_number, String aphone_number) { Exception ex;"))
            write("cu/etecsa/transfermovil/config/ActivationCodeValidator.java",
                  (ROOT / "app/src/main/java/cu/etecsa/transfermovil/config/ActivationCodeValidator.java").read_text())
            write("com/github/paolorotolo/appintro/BuildConfig.java", """
package com.github.paolorotolo.appintro;
public class BuildConfig { public static final String FLAVOR=""; }
""")
            write("AgentModeCheck.java", HARNESS)
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            checked = subprocess.run(["java", "-cp", str(root / "classes"), "AgentModeCheck"],
                                     capture_output=True, text=True, timeout=60)
            self.assertEqual(checked.returncode, 0, checked.stdout + checked.stderr)
            self.assertIn("Agent mode comparisons passed", checked.stdout)


def accessor(name):
    return f"""
package {"cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM" if name == "Fr52O1uSYF" else "cu.etecsa.transfermovil.data"};
import android.content.Context;
public class {name} {{
 public String getCodigoAgente(Context c) {{ if("code".equals(c.fail)) throw new RuntimeException("dao"); return c.code; }}
 public String getVersion(Context c) {{ if("version".equals(c.fail)) throw new RuntimeException("dao"); return c.version; }}
 public String getPhone(Context c) {{ if("phone".equals(c.fail)) throw new RuntimeException("dao"); return c.phone; }}
}}
"""


HARNESS = r"""
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.transfermovil.config.ActivationCodeValidator;
public class AgentModeCheck {
 static int cases;
 static void compare(String code,String version,String phone,String fail) {
  android.content.Context c=new android.content.Context(code); c.version=version; c.phone=phone; c.fail=fail;
  boolean a=raw.AgentModeOracle.isAGTelecom(c), b=clean.AgentMode.isAGTelecom(c);
  if(a!=b) throw new AssertionError(code+"/"+version+"/"+phone+"/"+fail+": "+a+" / "+b);
  cases++;
 }
 public static void main(String[] args) {
  compare(null,"1260416","51234567",null); compare("","1260416","51234567",null);
  compare("-1","1260416","51234567",null); compare("invalid","1260416","51234567",null);
  for(int seed=0;seed<8;seed++) {
   String code=new hY5P1xQ5h8().en_version(seed,"1260416","51234567");
   compare(code,"1260416","51234567",null);
   compare(code,"1260416","51234568",null);
   compare(code,"1260417","51234567",null);
  }
  for(String fail:new String[]{"code","version","phone"}) compare("012345678","1260416","51234567",fail);
  System.out.println("Agent mode comparisons passed: "+cases);
 }
}
"""
