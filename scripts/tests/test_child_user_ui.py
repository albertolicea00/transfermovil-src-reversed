"""JVM check for the clean-list/legacy-editor model boundary (no Android UI)."""
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
CLEAN = ROOT / 'app/src/main/java'
RAW = ROOT / 'src'


def extract_method(source, signature):
    start = source.index(signature)
    opening = source.index('{', start)
    depth = 1
    end = opening + 1
    while depth:
        depth += (source[end] == '{') - (source[end] == '}')
        end += 1
    return source[start:end]


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class ChildUserUiBoundaryTest(unittest.TestCase):
    def test_editor_conversion_preserves_all_fields_and_optional_regions(self):
        screen = CLEAN / 'cu/etecsa/transfermovil/ecommerce/ChildUserListFragment.java'
        method = extract_method(screen.read_text(), 'private static ME8KWex9OS.YjMcWATWMD toLegacyUser(')
        sources = [
            CLEAN / 'cu/etecsa/transfermovil/ecommerce/model/response/UserWithRolesResponse.java',
            CLEAN / 'cu/etecsa/transfermovil/ecommerce/model/BaseApiResult.java',
            CLEAN / 'cu/etecsa/transfermovil/ecommerce/data/geo/Province.java',
            CLEAN / 'cu/etecsa/transfermovil/ecommerce/data/geo/Municipality.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/XiLHuwQSoCT/ME8KWex9OS.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/kf1rAJ1MG4.java',
            RAW / 'cu/etecsa/tm/ecommerce/Dyporpu9vbM/G6liG5If2lu/njwILmSkGJ.java',
            RAW / 'cu/etecsa/tm/ecommerce/Dyporpu9vbM/G6liG5If2lu/I7Szcu2IgpM.java',
        ]
        harness = '''
import java.lang.reflect.Field;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
public class BoundaryCheck {
METHOD
    static void fill(Object value) throws Exception {
        for (Field field : value.getClass().getFields()) {
            if (field.getType() == String.class) field.set(value, field.getName() + "-value");
            else if (field.getType() == int.class) field.setInt(value, 73);
            else { Object nested = field.getType().getConstructor().newInstance();
                fill(nested); field.set(value, nested); }
        }
    }
    static void compare(Object clean, Object raw) throws Exception {
        for (Field field : clean.getClass().getFields()) {
            Object expected = field.get(clean);
            Object actual = raw.getClass().getField(field.getName()).get(raw);
            if (expected == null) {
                if (actual != null) throw new AssertionError(field.getName());
            } else if (expected instanceof String || expected instanceof Integer) {
                if (!expected.equals(actual)) throw new AssertionError(field.getName());
            } else compare(expected, actual);
        }
    }
    public static void main(String[] args) throws Exception {
        UserWithRolesResponse.User user = new UserWithRolesResponse.User();
        fill(user);
        compare(user, toLegacyUser(user));
        user.setProvince(null);
        compare(user, toLegacyUser(user));
        user.setMunicipality(null);
        compare(user, toLegacyUser(user));
        compare(new UserWithRolesResponse.User(), toLegacyUser(new UserWithRolesResponse.User()));
    }
}
'''.replace('METHOD', method)
        with tempfile.TemporaryDirectory() as directory:
            temp = Path(directory)
            stub = temp / 'org/json/JSONObject.java'
            stub.parent.mkdir(parents=True)
            stub.write_text('package org.json; public class JSONObject {}')
            main = temp / 'BoundaryCheck.java'
            main.write_text(harness)
            subprocess.run(['javac', '-d', directory, str(stub), str(main), *map(str, sources)],
                           check=True, capture_output=True, text=True)
            subprocess.run(['java', '-cp', directory, 'BoundaryCheck'], check=True,
                           capture_output=True, text=True)
