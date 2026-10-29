"""Ensure progress increases and decreases as TODO scope changes."""

import importlib.util
import unittest
from pathlib import Path

SPEC = importlib.util.spec_from_file_location(
    "progress", Path(__file__).resolve().parents[1] / "update-progress.py")
MODULE = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(MODULE)
README = ('# Project\n\n<!-- 50 blocks --> ' + MODULE.MARKER + '\n'
          '<span><code>[old] 47%</code></span>\n\n## Overview\nKeep this.\n')


class ProgressTest(unittest.TestCase):
    def test_scope_growth_and_completion(self):
        half = MODULE.update(README, "- [x] Done\n- [ ] Pending\n")
        self.assertIn("] 50%", half)
        more_scope = MODULE.update(half, "- [x] Done\n- [ ] Pending\n- [ ] Added\n")
        self.assertIn("] 33%", more_scope)
        all_done = MODULE.update(more_scope, "- [x] Done\n- [X] Done too\n")
        self.assertIn("] 100%", all_done)
        self.assertIn("2/2 completed; 0 pending", all_done)
        self.assertEqual(all_done.count(MODULE.MARKER), 1)
        self.assertTrue(all_done.endswith("## Overview\nKeep this.\n"))

    def test_idempotent_and_rounds_down(self):
        tasks = "- [x] Done\n" + "- [ ] Pending\n" * 2
        once = MODULE.update(README, tasks)
        self.assertEqual(once, MODULE.update(once, tasks))
        self.assertIn("█" * 16 + "░" * 34, once)

    def test_missing_inputs_fail(self):
        with self.assertRaises(ValueError):
            MODULE.update(README, "# No tasks")
        with self.assertRaises(ValueError):
            MODULE.update("# No marker", "- [ ] Pending\n")
        with self.assertRaises(ValueError):
            MODULE.update(README + README, "- [ ] Pending\n")


if __name__ == "__main__":
    unittest.main()
