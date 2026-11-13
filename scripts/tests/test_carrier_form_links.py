"""Check exact carrier/ticket source bodies, allowing reviewed identity changes."""
import re
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
PAIRS = (
    ("NautaPlusRechargeFragment", "HZgbT8IXPf"),
    ("OwnCardPaymentFragment", "JrjJL8mtlI"),
    ("TicketReservationViewFragment", "x12rSjPY6pZ"),
)


def normalized(text, original, clean):
    # Preserve strings; rewrite only identifier tokens outside comments/literals.
    text = re.sub(r"^package .*?;|^import .*?;", "", text, flags=re.MULTILINE)
    tokens = r'"(?:\\.|[^"\\])*"|/\*[\s\S]*?\*/|//[^\n]*|\b\w+\b'
    names = {original: clean, "FBsQzP3Zfj": "UssdDispatcher", "RiZsr8xXRC": "AccountType"}
    def replace(match):
        value = match[0]
        return "" if value.startswith(("/*", "//")) else names.get(value, value)
    return re.sub(r"\s+", " ", re.sub(tokens, replace, text)).strip()


class CarrierFormLinksTest(unittest.TestCase):
    def test_complete_bodies_and_source_identity(self):
        for clean, original in PAIRS:
            with self.subTest(screen=clean):
                identity = ("cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY."
                            "QM5YzxsQFRH." + original)
                source = (ROOT / "src" / (identity.replace(".", "/") + ".java")).read_text()
                candidate = (ROOT / "app/src/main/java/cu/etecsa/transfermovil/ui/fragment"
                             / (clean + ".java")).read_text()
                self.assertEqual(re.findall(r"@obfuscated_class\s+([\w.]+)", candidate), [identity])
                self.assertEqual(normalized(source, original, clean),
                                 normalized(candidate, original, clean))
