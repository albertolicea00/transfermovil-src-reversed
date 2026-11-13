"""Check complete restored BPA/adapter bodies against exact source identities."""
from collections import defaultdict
from pathlib import Path
import re
import unittest

ROOT = Path(__file__).resolve().parents[2]
JAVA = ROOT / "app/src/main/java"
SCREENS = (
    "BpaAccountMenuFragment", "BpaSessionMenuFragment", "BpaModifyLimitsFragment",
    "BpaGeneratePinFragment", "BpaRecoverPinFragment", "BpaReprintCardFragment",
    "BpaConvertCucToCupFragment", "BpaUsdAccountOpenFragment",
    "OperationListAdapter", "OperationActionAdapter", "StatsCategoryAdapter",
)
TOKEN = re.compile(r'"(?:\\.|[^"\\])*"|\'(?:\\.|[^\'\\])*\'|/\*[\s\S]*?\*/|//[^\n]*|\b\w+\b|[^\s]')


def normalized(text, names):
    text = re.sub(r"^package .*?;|^import .*?;", "", text, flags=re.MULTILINE)
    # Qualification of a nested holder is required in a superclass type argument.
    text = re.sub(r"\b(?:OperationListAdapter|OperationActionAdapter|StatsCategoryAdapter)\.InnerViewHolder", "InnerViewHolder", text)
    return tuple(names.get(value, value) for value in TOKEN.findall(text)
                 if not value.startswith(("/*", "//")))


class RestoredSourceBodiesTest(unittest.TestCase):
    def test_full_statements_literals_and_listener_bindings(self):
        paths = list(JAVA.rglob("*.java"))
        candidates = defaultdict(set)
        for path in paths:
            for identity in re.findall(r"@obfuscated_class\s+([\w.]+)", path.read_text()):
                candidates[identity.rsplit(".", 1)[-1]].add(path.stem)
        names = {original: next(iter(clean)) for original, clean in candidates.items()
                 if len(clean) == 1}
        names.update(a2dVPTG0kZc="InnerViewHolder", a2dvptg0kzc="holder")
        for screen in SCREENS:
            with self.subTest(screen=screen):
                matches = [path for path in paths if path.stem == screen]
                self.assertEqual(1, len(matches))
                clean = matches[0].read_text()
                identities = re.findall(r"@obfuscated_class\s+([\w.]+)", clean)
                self.assertEqual(1, len(identities))
                source = (ROOT / "src" / (identities[0].replace(".", "/") + ".java")).read_text()
                self.assertEqual(normalized(source, names), normalized(clean, names))
