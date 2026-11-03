"""Compile original and reconstructed models and compare schemas and accessors.

Uses lightweight runtime annotations and a JSONObject stand-in; no database or
Gson implementation is exercised by these JVM comparisons.
"""

import os
import re
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
    (ENTITIES + "AOperKey", "data.entity.AuthSession"),
    ("cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ", "core.enums.OperationType"),
    ("cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.IuGdvowIct", "banking.ui.RefreshCallback"),
    ("cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme", "banking.ui.OffersResultCallback"),
    ("cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E", "banking.ui.AccountsResultCallback"),
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
    (ECOMMERCE + "l1i6XXWOfGBF.zMnpbxBIN5", "ecommerce.model.dto.PaymentRecord"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV", "ecommerce.model.request.BalanceFilterRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p", "ecommerce.model.request.BanUserRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN", "ecommerce.model.request.PaginatedPaymentListRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ", "ecommerce.model.request.PaginatedTransactionListRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx", "ecommerce.model.request.PaymentStoreRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4", "ecommerce.model.request.RefundRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb", "ecommerce.model.request.UserProfileRequest"),
    (ECOMMERCE + "UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5", "ecommerce.model.response.QrPaymentResponse"),
    (ECOMMERCE + "UE0rwmdgIVT.kf1rAJ1MG4", "ecommerce.model.BaseApiResult"),
]


def ecommerce_models():
    """Include every model and its source-declared local type dependencies."""
    known = {}
    for path in (CLEAN / "cu/etecsa/transfermovil/ecommerce").rglob("*.java"):
        text = path.read_text()
        tag = re.search(r"@obfuscated_class\s+([\w.]+)", text)
        package = re.search(r"^package ([\w.]+);", text, re.MULTILINE)
        if tag and package:
            known[tag[1]] = (path, package[1] + "." + path.stem)
    pending = [key for key, (path, _) in known.items()
               if any(part in str(path) for part in ("/model/", "/domain/", "/data/geo/"))]
    selected = set()
    while pending:
        original = pending.pop()
        if original in selected:
            continue
        selected.add(original)
        raw = (ROOT / "src" / Path(*original.split(".")).with_suffix(".java")).read_text()
        for dependency in re.findall(r"^import (cu\.[\w.]+);", raw, re.MULTILINE):
            if dependency not in known:
                raise AssertionError(f"Unmapped model dependency: {dependency}")
            pending.append(dependency)
        for sibling in known:
            if sibling.rsplit(".", 1)[0] == original.rsplit(".", 1)[0]:
                if re.search(r"\b" + re.escape(sibling.rsplit(".", 1)[1]) + r"\b", raw):
                    pending.append(sibling)
    return [(original, known[original][1].removeprefix("cu.etecsa.transfermovil."))
            for original in sorted(selected)]


PAIRS = list(dict(PAIRS + ecommerce_models()).items())


def database_models():
    known = {}
    for path in (CLEAN / "cu/etecsa/transfermovil").rglob("*.java"):
        text = path.read_text()
        tag = re.search(r"@obfuscated_class\s+([\w.]+)", text)
        package = re.search(r"^package ([\w.]+);", text, re.MULTILINE)
        if tag and package:
            known[tag[1]] = (path, package[1] + "." + path.stem)
    selected = {original for original, (path, _) in known.items() if "/data/entity/" in str(path)}
    for original in list(selected):
        raw = (ROOT / "src" / Path(*original.split(".")).with_suffix(".java")).read_text()
        for dependency in re.findall(r"^import (cu\.[\w.]+);", raw, re.MULTILINE):
            if dependency.endswith(".rDEl7rW1aN"):
                continue  # Encryption calls are modeled by an explicit facade fixture.
            if dependency not in known:
                raise AssertionError(f"Unmapped entity dependency: {dependency}")
            selected.add(dependency)
    return [(original, known[original][1].removeprefix("cu.etecsa.transfermovil."))
            for original in sorted(selected)]


PAIRS = list(dict(PAIRS + database_models()).items())


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class ModelParityTest(unittest.TestCase):
    def test_schemas_and_accessors(self):
        self.compare_models()

    def test_json_wire_payloads(self):
        jar = Path(os.environ.get("TRANSFERMOVIL_GSON_JAR", str(
            Path.home() / ".m2/repository/com/google/code/gson/gson/2.9.1/gson-2.9.1.jar")))
        if not jar.is_file():
            self.skipTest("Set TRANSFERMOVIL_GSON_JAR to a local Gson jar to test wire payloads")
        self.compare_models(jar)

    def compare_models(self, gson_jar=None):
        with tempfile.TemporaryDirectory(prefix="transfermovil-models-") as directory:
            root = Path(directory)

            def write(name, value):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(value)

            for original, relative in PAIRS:
                raw_path = Path(*original.split(".")).with_suffix(".java")
                clean_path = Path("cu/etecsa/transfermovil", *relative.split(".")).with_suffix(".java")
                raw_text = (ROOT / "src" / raw_path).read_text()
                if original.endswith(".CompraPlanesCubacel"):
                    # JADX duplicates three declarations; the smali has four
                    # distinct fields and constructor self-assignments only.
                    seen = set()

                    def declaration(match):
                        name = match[1]
                        if name in seen:
                            return ""
                        seen.add(name)
                        return match[0]

                    raw_text = re.sub(r"@DatabaseField(?:\([^\n]*\))?\n    private \w+ (\w+)[^;\n]*;", declaration, raw_text)
                write(str(raw_path), raw_text)
                write(str(clean_path), (CLEAN / clean_path).read_text())
            write("com/j256/ormlite/field/DatabaseField.java", """
package com.j256.ormlite.field;
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DatabaseField {
    boolean generatedId() default false; boolean id() default false;
    boolean unique() default false; boolean canBeNull() default true;
    String columnName() default ""; String defaultValue() default "";
}
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
            if gson_jar:
                (root / "com/google/gson/annotations/SerializedName.java").unlink()
            for package, name in (
                ("cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK", "rDEl7rW1aN"),
                ("cu.etecsa.transfermovil.base", "BaseMainActivity"),
            ):
                write(package.replace(".", "/") + "/" + name + ".java",
                      "package " + package + "; public class " + name + " { " + CIPHER_FIXTURE + " }")
            write("org/json/JSONObject.java", """
package org.json;
public class JSONObject { public String toString() { return "json-fixture"; } }
""")
            write("com/github/paolorotolo/appintro/BuildConfig.java", """
package com.github.paolorotolo.appintro;
public class BuildConfig { public static final String FLAVOR=""; }
""")
            write("cu/etecsa/cubacel/tr/tm/B21UyndcVvF/QV8ylwbhfB.java", """
package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;
public class QV8ylwbhfB {
    public static final int ITEM_TYPE_RECYCLER_WIDTH=1000, ITEM_TYPE_ACTION_WIDTH=1001;
}
""")
            pairs = ",\n".join('{"' + raw + '","cu.etecsa.transfermovil.' + clean + '"}'
                               for raw, clean in PAIRS)
            wire = ("equal(new com.google.gson.Gson().toJsonTree(a), "
                    "new com.google.gson.Gson().toJsonTree(b), context+\" JSON payload\");") if gson_jar else ""
            write("ModelCheck.java", HARNESS.replace("PAIRS_PLACEHOLDER", pairs).replace("WIRE_PLACEHOLDER", wire))
            classpath = ["-cp", str(gson_jar)] if gson_jar else []
            built = subprocess.run(["javac", *classpath, "-d", str(root / "classes"),
                                    *sorted(str(p) for p in root.rglob("*.java"))],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(built.returncode, 0, built.stderr)
            runtime = str(root / "classes") + (os.pathsep + str(gson_jar) if gson_jar else "")
            result = subprocess.run(["java", "-cp", runtime, "ModelCheck"],
                                    capture_output=True, text=True, timeout=60)
            self.assertEqual(result.returncode, 0, result.stdout + result.stderr)
            self.assertIn(f"Compared {len(PAIRS) + 6} model pairs", result.stdout)


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
        if(o instanceof Date) return "date:"+((Date)o).getTime();
        if(o instanceof Enum<?>) return ((Enum<?>)o).name();
        if(o instanceof org.json.JSONObject) return o.toString();
        if(o.getClass().isArray()) {
            List<String> data=new ArrayList<>();
            for(int i=0;i<Array.getLength(o);i++) data.add(snapshot(Array.get(o,i)));
            return data.toString();
        }
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
                +":"+(db==null?"none":db.id()+":"+db.generatedId()+":"+db.unique()+":"+db.canBeNull()+":"+db.columnName()+":"+db.defaultValue())
                +":"+(json==null?"none":json.value()));
        }
        List<String> interfaces=new ArrayList<>();
        for(Class<?> i:c.getInterfaces()) interfaces.add(type(i));
        DatabaseTable db=c.getAnnotation(DatabaseTable.class);
        Set<String> methods=new TreeSet<>();
        for(Method m:c.getDeclaredMethods()) if(Modifier.isPublic(m.getModifiers()) && !m.isSynthetic()) {
            List<String> args=new ArrayList<>();
            for(Class<?> p:m.getParameterTypes()) args.add(type(p));
            methods.add(m.getName()+args+":"+type(m.getReturnType()));
        }
        String table=db==null?"none":db.tableName().isEmpty()?c.getSimpleName():db.tableName();
        if(db==null) for(Field f:c.getDeclaredFields())
            if(f.getAnnotation(DatabaseField.class)!=null) { table=c.getSimpleName(); break; }
        return fields+":"+interfaces+":"+(c.getSuperclass()==null?"none":type(c.getSuperclass()))
            +":"+table+":"+methods;
    }
    static Object create(Class<?> c) throws Exception {
        if(c.isMemberClass() && !Modifier.isStatic(c.getModifiers()))
            return c.getConstructor(c.getEnclosingClass()).newInstance(create(c.getEnclosingClass()));
        return c.getConstructor().newInstance();
    }
    static Object sample(Class<?> c, int number) throws Exception {
        if(number==5 && !c.isPrimitive()) return null;
        if(c==String.class) return new String[]{"", "ñá*|@", "123456", "CUP", "COMPRA", "unused"}[number];
        if(c==int.class || c==Integer.class) return new int[]{-1,0,Integer.MAX_VALUE}[number%3];
        if(c==float.class || c==Float.class) return new float[]{-1.5f,0f,12345.75f}[number%3];
        if(c==double.class || c==Double.class) return new double[]{-1.5,0,12345.75}[number%3];
        if(c==long.class || c==Long.class) return new long[]{-1,0,Long.MAX_VALUE}[number%3];
        if(c==Boolean.class) return number!=0;
        if(c==boolean.class) return number!=0;
        if(c.isEnum()) return c.getEnumConstants()[number%c.getEnumConstants().length];
        if(c==List.class) return new ArrayList<>();
        if(c==Date.class) return new Date(1700000000000L+number);
        if(c.isArray()) {
            Object a=Array.newInstance(c.getComponentType(),number);
            for(int i=0;i<number;i++) Array.set(a,i,sample(c.getComponentType(),i));
            return a;
        }
        return create(c);
    }
    static void equal(Object a,Object b,String context) {
        if(!Objects.equals(a,b)) throw new AssertionError(context+"\n"+a+"\n"+b);
    }
    static void wire(Object a,Object b,String context) {
        WIRE_PLACEHOLDER
    }
    static String getters(Object instance) throws Exception {
        Map<String,String> result=new TreeMap<>();
        for(Method m:instance.getClass().getDeclaredMethods())
            if(Modifier.isPublic(m.getModifiers()) && m.getParameterCount()==0 && !m.isSynthetic())
                try { result.put(m.getName(),snapshot(m.invoke(instance))); }
                catch(InvocationTargetException e) { result.put(m.getName(),"throws:"+e.getCause().getClass().getName()); }
        return result.toString();
    }
    public static void main(String[] args) throws Exception {
        for(String[] pair:pairs) { names.put(pair[0],pair[1]); names.put(pair[1],pair[1]); }
        List<String[]> expanded=new ArrayList<>(Arrays.asList(pairs));
        for(String[] pair:pairs) {
            Class<?> raw=Class.forName(pair[0]),clean=Class.forName(pair[1]);
            for(Class<?> nested:raw.getDeclaredClasses()) {
                String simple=nested.getSimpleName();
                if(simple.equals("MyPOJO")) simple="QrData";
                if(simple.equals("Pago")) simple="PaymentInner";
                if(simple.equals("YjMcWATWMD")) simple="User";
                String target=clean.getName()+"$"+simple;
                names.put(nested.getName(),target); names.put(target,target);
                expanded.add(new String[]{nested.getName(),target});
            }
        }
        for(String[] pair:expanded) {
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
            Object a=create(raw),b=create(clean);
            equal(snapshot(a),snapshot(b),pair[0]+" defaults");
            wire(a,b,pair[0]+" defaults");
            equal(getters(a),getters(b),pair[0]+" initial getters");
            for(Method method:raw.getDeclaredMethods()) if(method.getName().startsWith("set")) {
                Class<?> param=method.getParameterTypes()[0];
                Class<?> target=param.isPrimitive()?param:Class.forName(type(param));
                Method setter=clean.getMethod(method.getName(),target);
                for(int n=0;n<6;n++) {
                    String rawError=null,cleanError=null;
                    try { method.invoke(a,sample(param,n)); }
                    catch(InvocationTargetException e) { rawError=e.getCause().getClass().getName()+":"+e.getCause().getMessage(); }
                    try { setter.invoke(b,sample(target,n)); }
                    catch(InvocationTargetException e) { cleanError=e.getCause().getClass().getName()+":"+e.getCause().getMessage(); }
                    equal(rawError,cleanError,pair[0]+" setter failure "+method.getName());
                    equal(snapshot(a),snapshot(b),pair[0]+" "+method.getName());
                    wire(a,b,pair[0]+" "+method.getName());
                    equal(getters(a),getters(b),pair[0]+" getters after "+method.getName());
                }
            }
        }
        System.out.println("Compared "+expanded.size()+" model pairs");
    }
}
"""

# Tests delegate account encryption through a deterministic marker. Actual AES
# behavior is checked separately; these fixtures verify entity delegation only.
CIPHER_FIXTURE = r"""
    public String encryption(String value) { return value==null?"":"encoded:"+value; }
    public String decryption(String value) { return value!=null && value.startsWith("encoded:")?value.substring(8):""; }
"""
