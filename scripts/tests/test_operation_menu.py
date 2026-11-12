"""Compare reconstructed menus with JADX under an isolated JVM dependency harness.

This compiles real reconstructed entities, enums and menu code. Android, ORMLite
annotations, JSON fixtures and the DAO facade are substitutes, not an app build.
"""

import re
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
CLEAN = ROOT / "app/src/main/java"
PACKAGE = "cu.etecsa.transfermovil"
SOURCE = ROOT / "src/cu/etecsa/cubacel/tr/tm/ZNRpoHwtLXM/nljtDl5MIf.java"


# Reviewed navigation migrations. Check each identity annotation before adapting
# the oracle's class-name literal; all other menu data remains byte-for-byte.
MIGRATED_DESTINATIONS = (
    "banking.ui.bpa.BpaExtendedTransferFragment",
    "ui.fragment.banking.bandec.auth.BandecRegistrationFragment",
    "banking.ui.wallet.WalletEnrollmentFragment",
    "ui.fragment.NautaUserFragment",
    "banking.ui.wallet.WalletClassicAccountAssociationFragment",
)


def migrate_reference_destinations(text):
    for suffix in MIGRATED_DESTINATIONS:
        clean_name = PACKAGE + "." + suffix
        path = CLEAN / (clean_name.replace(".", "/") + ".java")
        annotations = re.findall(r"@obfuscated_class\s+([\w.]+)", path.read_text())
        if len(annotations) != 1:
            raise ValueError(f"Expected one source identity for {clean_name}")
        original = annotations[0]
        if not (ROOT / "src" / (original.replace(".", "/") + ".java")).is_file():
            raise ValueError(f"Missing source for {clean_name}: {original}")
        literal = '"' + original + '"'
        if literal not in text:
            raise ValueError(f"Original menu lacks destination {original}")
        text = text.replace(literal, '"' + clean_name + '"')
    return text


def reference_source():
    """Adapt dependencies and reviewed routes; retain menu behavior and data."""
    text = migrate_reference_destinations(SOURCE.read_text())
    text = re.sub(r"^package .*?;|^import cu\..*?;", "", text, flags=re.MULTILINE)
    names = {"nljtDl5MIf": "ReferenceMenu", "unYp8VQThY": "DatabaseHelper",
             "FdonIAFI9w": "BankOperationCode", "R1sDOSqZ2z": "BankType",
             "Operacion": "Operation", "Municipio": "Municipality",
             "Provincia": "Province", "Tributo": "TaxRecord"}
    tokens = r'"(?:\\.|[^"\\])*"|/\*[\s\S]*?\*/|//[^\n]*|\b\w+\b'
    text = re.sub(tokens, lambda m: names.get(m[0], m[0]), text)
    return (f"package {PACKAGE}.data;\nimport {PACKAGE}.R;\n"
            f"import {PACKAGE}.data.entity.*;\nimport {PACKAGE}.banking.BankOperationCode;\n"
            f"import {PACKAGE}.core.enums.BankType;\n" + text)


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "JDK required")
class OperationMenuTest(unittest.TestCase):
    def test_operation_enum_order(self):
        original = SOURCE.with_name("FdonIAFI9w.java").read_text()
        clean = (CLEAN / "cu/etecsa/transfermovil/banking/BankOperationCode.java").read_text()

        def values(text):
            text = re.sub(r"/\*[\s\S]*?\*/|//[^\n]*", "", text)
            return [v.strip() for v in text.split("{", 1)[1].rsplit("}", 1)[0].split(",")]

        self.assertEqual(values(original), values(clean))

    def test_jadx_behavior(self):
        with tempfile.TemporaryDirectory(prefix="transfermovil-menu-") as directory:
            root = Path(directory)

            def write(name, content):
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(content)

            for name in (
                "data/OperationMenuBuilder.java", "data/entity/Operation.java",
                "data/entity/Province.java", "data/entity/Municipality.java",
                "data/entity/TaxRecord.java", "data/ITMDataDatabase.java",
                "data/TableMetadata.java", "data/FieldSchema.java", "data/FieldType.java",
                "banking/BankOperationCode.java", "core/enums/BankType.java",
            ):
                relative = "cu/etecsa/transfermovil/" + name
                write(relative, (CLEAN / relative).read_text())
            write("cu/etecsa/transfermovil/data/ReferenceMenu.java", reference_source())
            resources = {}
            for kind, name in re.findall(r"R\.(\w+)\.(\w+)", SOURCE.read_text()):
                resources.setdefault(kind, set()).add(name)
            resource_text = f"package {PACKAGE}; public class R {{"
            for kind, names in sorted(resources.items()):
                resource_text += f"public static class {kind} {{"
                for number, name in enumerate(sorted(names), 1):
                    resource_text += f"public static final int {name}={number};"
                resource_text += "}"
            write("cu/etecsa/transfermovil/R.java", resource_text + "}")
            write("android/content/Context.java", """
package android.content;
public class Context {
    public String getString(int id) { return "string:" + id; }
    public android.content.res.AssetManager getAssets() {
        return new android.content.res.AssetManager();
    }
}
""")
            write("android/content/res/AssetManager.java", """
package android.content.res;
public class AssetManager {
    public java.io.InputStream open(String name) throws java.io.IOException {
        if (name.equals("missing.json")) throw new java.io.IOException("fixture missing");
        return new java.io.ByteArrayInputStream(name.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
}
""")
            write("android/util/Log.java", """
package android.util;
public class Log {
    public static int e(String tag, String msg) { return i(tag, msg); }
    public static int i(String tag, String msg) {
        cu.etecsa.transfermovil.data.DatabaseHelper.events.add("log:"+tag+":"+msg); return 0;
    }
}
""")
            write("com/github/paolorotolo/appintro/BuildConfig.java", """
package com.github.paolorotolo.appintro;
public class BuildConfig { public static final String FLAVOR=""; }
""")
            write("com/j256/ormlite/field/DatabaseField.java", """
package com.j256.ormlite.field;
public @interface DatabaseField { boolean generatedId() default false; boolean id() default false; }
""")
            write("com/j256/ormlite/table/DatabaseTable.java", """
package com.j256.ormlite.table;
public @interface DatabaseTable { String tableName() default ""; }
""")
            write("org/json/JSONException.java", """
package org.json;
public class JSONException extends Exception { public JSONException(String s) { super(s); } }
""")
            write("org/json/JSONObject.java", """
package org.json;
public class JSONObject {
    private final String value;
    public JSONObject(String value) throws JSONException { this.value=value; }
    public JSONArray getJSONArray(String key) throws JSONException { return new JSONArray(key); }
    public String getString(String key) throws JSONException { return value+":"+key; }
}
""")
            write("org/json/JSONArray.java", """
package org.json;
public class JSONArray {
    private final String key;
    public JSONArray(String key) { this.key=key; }
    public int length() { return 3; }
    public Object get(int index) throws JSONException {
        if (index==1) throw new JSONException("malformed fixture row");
        return new JSONObject(key+":"+index);
    }
}
""")
            write("cu/etecsa/transfermovil/data/DatabaseHelper.java", DAO)
            write("cu/etecsa/transfermovil/data/MenuCheck.java", HARNESS)
            sources = sorted(str(p) for p in root.rglob("*.java"))
            build = subprocess.run(["javac", "-d", str(root / "classes"), *sources],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(build.returncode, 0, build.stderr)
            check = subprocess.run(["java", "-cp", str(root / "classes"),
                                    PACKAGE + ".data.MenuCheck"],
                                   capture_output=True, text=True, timeout=60)
            self.assertEqual(check.returncode, 0, check.stdout + check.stderr)
            self.assertIn("Compared 85 method/scenario pairs", check.stdout)


DAO = """
package cu.etecsa.transfermovil.data;
import java.util.*;
import cu.etecsa.transfermovil.data.entity.*;
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.core.enums.BankType;
public class DatabaseHelper {
    public static List<String> events = new ArrayList<>();
    public static Map<BankOperationCode,List<Operation>> rows = new LinkedHashMap<>();
    private static final DatabaseHelper INSTANCE = new DatabaseHelper();
    private static int fail;
    public static DatabaseHelper getInstance() { return INSTANCE; }
    public static void reset(int scenario) {
        rows.clear(); events.clear(); fail=scenario>=3 ? scenario-2 : 0;
        if (scenario>0) for (BankOperationCode code : BankOperationCode.values()) {
            ArrayList<Operation> entries=new ArrayList<>();
            for (int i=0; i<(scenario==2?2:1); i++) {
                Operation op=new Operation(); op.setOperacion(code); op.setId(i+1000);
                op.setActivo(false); op.setOrder(77); op.setTitulo("saved-title");
                op.setSubtitulo("saved-subtitle"); op.setImagen(-99);
                op.setFragment_name("saved-fragment"); op.setTipo_serivicio(BankType.CLASICA);
                entries.add(op);
            }
            rows.put(code, entries);
        }
    }
    public static String snapshot(Operation op) {
        if (op==null) return "null";
        return Arrays.asList(op.getOperacion(),op.getId(),op.getTitulo(),op.getSubtitulo(),
            op.getImagen(),op.getFragment_name(),op.getTipo_serivicio(),op.getOrder(),op.isActivo()).toString();
    }
    public Operation getOperacion(BankOperationCode code) {
        events.add("get:"+code);
        if (code==BankOperationCode.BPAAutenticarse && fail>0) {
            if(fail==1) fail=0; throw new IllegalStateException("fixture lookup failure");
        }
        List<Operation> entries=rows.get(code);
        return entries==null || entries.isEmpty() ? null : entries.get(0);
    }
    public int getCountOperacion(BankOperationCode code) {
        events.add("count:"+code); return rows.getOrDefault(code,Collections.emptyList()).size();
    }
    public List<Operation> getListOperacion(BankOperationCode code) {
        events.add("list:"+code); return new ArrayList<>(rows.getOrDefault(code,Collections.emptyList()));
    }
    public void addOperacion(Operation op) {
        events.add("add:"+snapshot(op)); rows.computeIfAbsent(op.getOperacion(),k->new ArrayList<>()).add(op);
    }
    public void updateOperacion(Operation op) { events.add("update:"+snapshot(op)); }
    public boolean deleteOperacion(Operation op) {
        events.add("delete:"+snapshot(op));
        return op!=null && rows.get(op.getOperacion()).remove(op);
    }
    public void addProvincia(Province p) {
        events.add("province:"+p.getCod_provincia()+":"+p.getNombre()+":"+p.getAbreviatura());
    }
    public void addMunicipio(Municipality p) {
        events.add("municipality:"+p.getCod_municipio()+":"+p.getCod_provincia()+":"+p.getNombre()+":"+p.getAbreviatura());
    }
    public void addTributo(TaxRecord p) {
        events.add("tax:"+p.getCod_tributo()+":"+p.getNombre()+":"+p.getAbreviatura()+":"+p.getTipo()+":"+p.getTipoPersona()+":"+p.getMoneda());
    }
}
"""

HARNESS = """
package cu.etecsa.transfermovil.data;
import java.util.*;
import java.lang.reflect.*;
import android.content.Context;
import cu.etecsa.transfermovil.data.entity.*;
import cu.etecsa.transfermovil.banking.BankOperationCode;
public class MenuCheck {
    static String run(Class<?> type, Method method, int scenario) throws Exception {
        DatabaseHelper.reset(scenario);
        Object builder=type.getConstructor().newInstance();
        type.getField("context").set(builder,new Context());
        Object[] args=new Object[method.getParameterCount()];
        for(int i=0;i<args.length;i++) args[i]=method.getParameterTypes()[i]==Context.class
            ? new Context() : method.getParameterTypes()[i]==int.class ? 162 : "dpa.json";
        String result="void";
        try { result=String.valueOf(type.getMethod(method.getName(),method.getParameterTypes()).invoke(builder,args)); }
        catch(InvocationTargetException e) { result="throws:"+e.getCause().getClass().getName(); }
        StringBuilder out=new StringBuilder(result).append(DatabaseHelper.events);
        for(var entry:DatabaseHelper.rows.entrySet())
            for(Operation op:entry.getValue()) out.append(DatabaseHelper.snapshot(op));
        for(String field:new String[]{"listGenerales","listAgente","listBPA","listBANDEC","listMETRO","listBolsa"})
            for(Object op:(List<?>)type.getField(field).get(builder)) out.append(DatabaseHelper.snapshot((Operation)op));
        return out.toString();
    }
    public static void main(String[] args) throws Exception {
        int cases=0;
        for(Method method:ReferenceMenu.class.getDeclaredMethods()) {
            if(!Modifier.isPublic(method.getModifiers())) continue;
            for(int scenario=0;scenario<5;scenario++) {
                String expected=run(ReferenceMenu.class,method,scenario);
                String actual=run(OperationMenuBuilder.class,method,scenario);
                if(!expected.equals(actual)) throw new AssertionError(method.getName()+" scenario "+scenario);
                cases++;
            }
        }
        if(BankOperationCode.values().length!=332) throw new AssertionError("enum size");
        TaxRecord tax=new TaxRecord();
        if(!tax.getMetadata().getTabla_name().equals("Nauta")) throw new AssertionError("metadata table");
        if(!tax.getMetadata().getCamposSquemas().get(4).getNombre().equals("nombre"))
            throw new AssertionError("metadata tipo descriptor");
        System.out.println("Compared "+cases+" method/scenario pairs");
    }
}
"""
