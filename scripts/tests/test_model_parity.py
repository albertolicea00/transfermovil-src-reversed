"""Compile original and reconstructed models and compare schemas and accessors.

Uses lightweight runtime annotations and a JSONObject stand-in; no database or
Gson implementation is exercised by these JVM comparisons.
"""

import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
CLEAN = ROOT / "app/src/main/java"
ENTITIES = "cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL."
ECOMMERCE = "cu.etecsa.tm.ecommerce."
METADATA = "cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC."
PAIRS = [
    (ENTITIES + "TarjetaPropia", "data.entity.OwnCard"),
    (ENTITIES + "TeflMovil", "data.entity.MobilePhone"),
    (ENTITIES + "TelfFijo", "data.entity.LandlinePhone"),
    (ENTITIES + "ITMDataDatabase", "data.ITMDataDatabase"),
    (METADATA + "cQi3wj0jBL", "data.FieldType"),
    (METADATA + "gwHFUMMDRu", "data.TableMetadata"),
    (METADATA + "z9CJ2fIAs7", "data.FieldSchema"),
    ("cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE", "core.enums.Currency"),
    (ECOMMERCE + "Dyporpu9vbM.tQvDIr4mUHh.XpLbwNXtZPa.fGYt3sYXbt", "ecommerce.model.BaseRequest"),
    (ECOMMERCE + "Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC", "ecommerce.ApiResponse"),
    (ECOMMERCE + "qHBfDCWv13G.ThptISKBHA", "ecommerce.GrantPermission"),
    (ECOMMERCE + "qHBfDCWv13G.UZsizlaDNk", "ecommerce.ErrorType"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.XMAvvl35Dj", "ecommerce.model.request.LoginRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.L9hiDpmAir", "ecommerce.model.request.TwoFactorLoginRequest"),
]


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class ModelParityTest(unittest.TestCase):
    def test_schemas_and_accessors(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-models-") as directory:
            root = Path(directory)

            def write(name, value):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(value)

            for original, relative in PAIRS:
                raw_path = Path(*original.split(".")).with_suffix(".java")
                clean_path = Path("cu/etecsa/transfermovil", *relative.split(".")).with_suffix(".java")
                write(str(raw_path), (ROOT / "src" / raw_path).read_text())
                write(str(clean_path), (CLEAN / clean_path).read_text())
            write("com/j256/ormlite/field/DatabaseField.java", """
package com.j256.ormlite.field;
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DatabaseField { boolean generatedId() default false; boolean id() default false; }
""")
            write("com/j256/ormlite/table/DatabaseTable.java", """
package com.j256.ormlite.table;
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DatabaseTable { String tableName() default ""; }
""")
            write("com/google/gson/annotations/SerializedName.java", """
package com.google.gson.annotations;
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface SerializedName { String value(); }
""")
            write("org/json/JSONObject.java", """
package org.json;
public class JSONObject { public String toString() { return "json-fixture"; } }
""")
            write("cu/etecsa/cubacel/tr/tm/B21UyndcVvF/QV8ylwbhfB.java", """
package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;
public class QV8ylwbhfB {
    public static final int ITEM_TYPE_RECYCLER_WIDTH=1000, ITEM_TYPE_ACTION_WIDTH=1001;
}
""")
            pairs = ",\n".join('{"' + raw + '","cu.etecsa.transfermovil.' + clean + '"}'
                               for raw, clean in PAIRS)
            write("ModelCheck.java", HARNESS.replace("PAIRS_PLACEHOLDER", pairs))
            built = subprocess.run(["javac", "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            result = subprocess.run(["java", "-cp", str(root / "classes"), "ModelCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn("Compared 14 model pairs", result.stdout)


HARNESS = r"""
import java.util.*;
import java.lang.reflect.*;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.google.gson.annotations.SerializedName;
public class ModelCheck {
    static String[][] pairs={ PAIRS_PLACEHOLDER };
    static Map<String,String> names=new HashMap<>();
    static String type(Class<?> c) { return names.getOrDefault(c.getName(),c.getName()); }
    static String snapshot(Object o) throws Exception {
        if(o==null) return "null";
        if(o instanceof String || o instanceof Number || o instanceof Boolean) return o.toString();
        if(o instanceof Enum<?>) return ((Enum<?>)o).name();
        if(o instanceof org.json.JSONObject) return o.toString();
        if(o instanceof List<?>) {
            List<String> data=new ArrayList<>(); for(Object item:(List<?>)o) data.add(snapshot(item));
            return data.toString();
        }
        Map<String,String> result=new TreeMap<>();
        for(Field f:o.getClass().getDeclaredFields()) if(!f.isSynthetic() && !Modifier.isStatic(f.getModifiers())) {
            f.setAccessible(true); result.put(f.getName(),snapshot(f.get(o)));
        }
        return type(o.getClass())+result;
    }
    static String schema(Class<?> c) {
        Map<String,String> fields=new TreeMap<>();
        for(Field f:c.getDeclaredFields()) if(!f.isSynthetic() && !Modifier.isStatic(f.getModifiers())) {
            DatabaseField db=f.getAnnotation(DatabaseField.class);
            SerializedName json=f.getAnnotation(SerializedName.class);
            fields.put(f.getName(),type(f.getType())+":"+Modifier.toString(f.getModifiers())
                +":"+(db==null?"none":db.id()+":"+db.generatedId())+":"+(json==null?"none":json.value()));
        }
        List<String> interfaces=new ArrayList<>();
        for(Class<?> i:c.getInterfaces()) interfaces.add(type(i));
        DatabaseTable db=c.getAnnotation(DatabaseTable.class);
        return fields+":"+interfaces+":"+(db==null?"none":db.tableName().isEmpty()?c.getSimpleName():db.tableName());
    }
    static Object sample(Class<?> c, int number) throws Exception {
        if(c==String.class) return new String[]{"", "ñá*|@", "123456"}[number];
        if(c==int.class) return new int[]{-1,0,Integer.MAX_VALUE}[number];
        if(c==boolean.class) return number!=0;
        if(c.isEnum()) return c.getEnumConstants()[number%c.getEnumConstants().length];
        if(c==List.class) return new ArrayList<>();
        return c.getConstructor().newInstance();
    }
    static void equal(Object a,Object b,String context) {
        if(!Objects.equals(a,b)) throw new AssertionError(context+"\n"+a+"\n"+b);
    }
    static String getters(Object instance) throws Exception {
        Map<String,String> result=new TreeMap<>();
        for(Method m:instance.getClass().getDeclaredMethods())
            if(Modifier.isPublic(m.getModifiers()) && m.getParameterCount()==0 && !m.isSynthetic())
                result.put(m.getName(),snapshot(m.invoke(instance)));
        return result.toString();
    }
    public static void main(String[] args) throws Exception {
        for(String[] pair:pairs) { names.put(pair[0],pair[1]); names.put(pair[1],pair[1]); }
        for(String[] pair:pairs) {
            Class<?> raw=Class.forName(pair[0]),clean=Class.forName(pair[1]);
            if(raw.isEnum()) {
                equal(Arrays.toString(raw.getEnumConstants()),Arrays.toString(clean.getEnumConstants()),pair[0]+" enum order");
                if(raw.getSimpleName().equals("ThptISKBHA")) {
                    Object[] a=raw.getEnumConstants(), b=clean.getEnumConstants();
                    for(int i=0;i<a.length;i++) equal(raw.getMethod("getNumVal").invoke(a[i]),
                        clean.getMethod("getNumVal").invoke(b[i]),"grant ID "+i);
                }
                continue;
            }
            equal(schema(raw),schema(clean),pair[0]+" schema");
            if(raw.isInterface()) continue;
            Object a=raw.getConstructor().newInstance(),b=clean.getConstructor().newInstance();
            equal(snapshot(a),snapshot(b),pair[0]+" defaults");
            equal(getters(a),getters(b),pair[0]+" initial getters");
            for(Method method:raw.getDeclaredMethods()) if(method.getName().startsWith("set")) {
                Class<?> param=method.getParameterTypes()[0];
                Class<?> target=param.isPrimitive()?param:Class.forName(type(param));
                Method setter=clean.getMethod(method.getName(),target);
                for(int n=0;n<3;n++) {
                    method.invoke(a,sample(param,n)); setter.invoke(b,sample(target,n));
                    equal(snapshot(a),snapshot(b),pair[0]+" "+method.getName());
                    equal(getters(a),getters(b),pair[0]+" getters after "+method.getName());
                }
            }
        }
        System.out.println("Compared "+pairs.length+" model pairs");
    }
}
"""
