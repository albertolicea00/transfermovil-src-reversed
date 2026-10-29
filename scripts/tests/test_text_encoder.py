"""Compare complete character maps and text encoding behavior to original Java."""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class TextEncoderTest(unittest.TestCase):
    def test_original_dictionary_and_encoding(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-encoder-") as directory:
            root = Path(directory)

            def write(name, text):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)

            for name in ["EKB7Plln4L", "kR22DOzTiB"]:
                relative = "cu/etecsa/cubacel/tr/tm/F0VSiFomrqH/" + name + ".java"
                write(relative, (ROOT / "src" / relative).read_text())
            for name in ["CharacterCodeDictionary", "NautaCodeEncoder"]:
                relative = "cu/etecsa/transfermovil/config/" + name + ".java"
                write(relative, (ROOT / "app/src/main/java" / relative).read_text())
            write("com/github/paolorotolo/appintro/BuildConfig.java", 'package com.github.paolorotolo.appintro; public class BuildConfig { public static final String FLAVOR=""; }')
            write("android/net/Uri.java", r"""
package android.net;
public class Uri { public static String encode(String value) {
    if(value.equals("#")) return "%23";
    throw new AssertionError("Unmodeled Uri.encode argument: "+value);
} }
""")
            write("EncoderCheck.java", HARNESS)
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "EncoderCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("Dictionary and encoder comparisons passed", result.stdout)


HARNESS = r"""
import java.util.*;
import java.lang.reflect.*;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.*;
import cu.etecsa.transfermovil.config.*;
public class EncoderCheck {
    static Object run(Object object,String method,Class<?> arg,Object value) throws Exception {
        try { return object.getClass().getMethod(method,arg).invoke(object,value); }
        catch(InvocationTargetException e) { return "throws:"+e.getCause().getClass().getName(); }
    }
    public static void main(String[] args) throws Exception {
        EKB7Plln4L rawDictionary=new EKB7Plln4L();
        CharacterCodeDictionary dictionary=new CharacterCodeDictionary();
        if(!rawDictionary.dictionaryCode.equals(dictionary.dictionaryCode)) throw new AssertionError("dictionary entries");
        kR22DOzTiB raw=new kR22DOzTiB(); NautaCodeEncoder clean=new NautaCodeEncoder();
        List<String> cases=new ArrayList<>(Arrays.asList(null,"","1","12","123","a1b","1a","a12b","a123b",
            "user_123@nauta.com.cu","ñáÉÜ.#%& /","unsupported:!","\u0661\u0662","\uff11", "\ud83d\ude00"));
        cases.addAll(rawDictionary.dictionaryCode.keySet());
        for(String a:rawDictionary.dictionaryCode.keySet()) {
            cases.add(a+"1"); cases.add("1"+a); cases.add(a+"12"+a); cases.add(a+"123"+a);
        }
        for(String input:cases) {
            Object a=run(raw,"coding_message",String.class,input),b=run(clean,"coding_message",String.class,input);
            if(!Objects.equals(a,b)) throw new AssertionError("coding_message "+input+": "+a+" / "+b);
            a=run(rawDictionary,"getCode",String.class,input); b=run(dictionary,"getCode",String.class,input);
            if(!Objects.equals(a,b)) throw new AssertionError("getCode "+input);
        }
        for(List<String> input:Arrays.asList(null,Collections.<String>emptyList(),
            Arrays.asList("ab","12","ñ"),Arrays.asList("!",null),Arrays.asList("!","\ud83d\ude00"))) {
            Object a=run(raw,"getCodes",List.class,input),b=run(clean,"getCodes",List.class,input);
            if(!Objects.equals(a,b)) throw new AssertionError("getCodes "+input);
        }
        if(!clean.coding_message("1").equals("%231")) throw new AssertionError("single digit marker");
        if(!clean.coding_message("12").equals("%2312%23")) throw new AssertionError("digit run marker");
        if(!clean.getCodes(Arrays.asList("!")).equals(Arrays.asList("null"))) throw new AssertionError("unknown dictionary concatenation");
        System.out.println("Dictionary and encoder comparisons passed: "+cases.size()+" input strings");
    }
}
"""
