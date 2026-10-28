"""Exercise conflicting evidence and empty input without Android dependencies."""

import importlib.util
import json
import tempfile
import unittest
from pathlib import Path

SPEC = importlib.util.spec_from_file_location(
    "inventory", Path(__file__).resolve().parents[1] / "reconstruction-inventory.py")
MODULE = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(MODULE)


class InventoryTest(unittest.TestCase):
    def test_conflicting_evidence_is_preserved(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            files = {
                "src/original/A.java": "package original; class A {}",
                "src/original/B.java": "package original; class B {}",
                "src/original/C.java": "package original; class C {}",
                "app/src/main/java/clean/One.java":
                    "package clean; /** @obfuscated_class original.A */ class One {}",
                "app/src/main/java/clean/Two.java":
                    "package clean; /** @obfuscated_class original.A */ class Two {}",
                "app/src/main/java/clean/Three.java": "package clean; class Three {}",
                "app/src/main/java/clean/Unknown.java":
                    "package clean; /** @obfuscated_class original.Missing */ class Unknown {}",
            }
            for name, text in files.items():
                path = root / name
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_text(text)
            (root / "mappings").mkdir()
            (root / "mappings/classes.json").write_text(json.dumps({"classes": {
                "original.B": {"clean": "clean.One"},
                "original.Missing": {"clean": "clean.Absent"},
            }}))
            report = MODULE.inventory(root)
            records = {r["original"]: r for r in report["sources"]}
            self.assertEqual(len(records["original.A"]["candidates"]), 2)
            self.assertEqual(records["original.B"]["link_status"], "single_candidate")
            self.assertEqual(records["original.C"]["link_status"], "unlinked")
            self.assertEqual({i["issue"] for i in report["mapping_issues"]}, {
                "annotation_conflict", "source_not_found", "clean_not_found"})
            self.assertEqual(report["summary"]["clean_without_annotation"], 1)
            self.assertEqual(report["summary"]["unresolved_annotations"], 1)
            self.assertEqual(report, MODULE.inventory(root))

    def test_empty_trees(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            (root / "mappings").mkdir()
            (root / "mappings/classes.json").write_text('{"classes": {}}')
            self.assertEqual(MODULE.inventory(root)["summary"]["source_files"], 0)


if __name__ == "__main__":
    unittest.main()
