#!/usr/bin/env python3
"""Evaluate the small, pure smali error-message method that JADX failed to emit.

This deliberately supports only the instructions present in this method and
fails on others. It is not a general Dalvik emulator. Resource lookups are
represented as @string/name so results can be compared without Android.
"""

import argparse
import hashlib
import json
import re
from pathlib import Path

RELATIVE = "smali/cu/etecsa/tm/ecommerce/qHBfDCWv13G/IGxV3uh9sw.smali"
ENUM_NAMES = ["LISTAR_USERS_GET", "LISTAR_USERS_SET", "LISTAR_CUENTAS_GET", "LOGIN_SIMPLE",
              "PAGO_DINAMICO_POST", "LISTAR_NEGOCIOS_GET", "DEVOLVER_PAGO", "GET_PERMISOS", "ESTADISTICAS"]


class MessageMethod:
    def __init__(self, source, ordinal_values):
        self.ordinal_values = ordinal_values
        self.method = source[source.index(".method public getErrorMessage"):].split(".end method", 1)[0]
        self.code, self.labels, self.switches = [], {}, {}
        lines = [line.strip() for line in self.method.splitlines() if line.strip()]
        index = 0
        while index < len(lines):
            line = lines[index]
            if line.startswith(":"):
                self.labels[line] = len(self.code)
                if index + 1 < len(lines) and lines[index + 1].startswith((".packed-switch", ".sparse-switch")):
                    declaration = lines[index + 1]
                    packed = declaration.startswith(".packed-switch")
                    key = int(declaration.split()[1], 0) if packed else 0
                    table = {}
                    index += 2
                    while not lines[index].startswith(".end "):
                        if packed:
                            table[key] = lines[index]
                            key += 1
                        else:
                            value, target = lines[index].split(" -> ")
                            table[int(value, 0)] = target
                        index += 1
                    self.switches[line] = table
            elif not line.startswith((".", "#")):
                self.code.append(line)
            index += 1

    def evaluate(self, operation, value):
        regs = {"p1": ENUM_NAMES.index(operation), "p2": value}
        result, pc = None, 0
        for _ in range(1000):
            line = self.code[pc]
            pc += 1
            instruction, _, args = line.partition(" ")
            if instruction == "const-string":
                register, literal = args.split(", ", 1)
                regs[register] = json.loads(literal)
            elif instruction.startswith("const/"):
                register, literal = args.split(", ")
                regs[register] = int(literal, 0)
            elif instruction == "sget-object":
                register, reference = args.split(", ", 1)
                regs[register] = self.ordinal_values if "$SwitchMap$" in reference else "context"
            elif instruction == "sget":
                register, reference = args.split(", ", 1)
                regs[register] = "@string/" + re.search(r"->(\w+):I", reference)[1]
            elif instruction == "invoke-virtual":
                registers = re.search(r"\{([^}]+)\}", args)[1].split(", ")
                values = [regs[r] for r in registers]
                if "->ordinal()" in args:
                    result = values[0]
                elif "->hashCode()" in args:
                    if values[0] is None:
                        return {"throws": "NullPointerException"}
                    result = 0
                    for char in values[0]:
                        result = (result * 31 + ord(char)) & 0xffffffff
                    if result >= 0x80000000:
                        result -= 0x100000000
                elif "->equals(" in args:
                    result = int(values[0] == values[1])
                elif "->getString(" in args:
                    result = values[1]
                else:
                    raise ValueError("Unsupported invoke: " + line)
            elif instruction in ("move-result", "move-result-object"):
                regs[args] = result
            elif instruction == "aget":
                target, array, key = args.split(", ")
                regs[target] = regs[array][regs[key]]
            elif instruction in ("packed-switch", "sparse-switch"):
                register, label = args.split(", ")
                target = self.switches[label].get(regs[register])
                if target:
                    pc = self.labels[target]
            elif instruction.startswith("goto"):
                pc = self.labels[args]
            elif instruction == "if-eqz":
                register, label = args.split(", ")
                if not regs[register]:
                    pc = self.labels[label]
            elif instruction == "return-object":
                return {"value": regs[args]}
            elif instruction != "nop":
                raise ValueError("Unsupported instruction: " + line)
        raise ValueError("Instruction limit exceeded")


def evidence(root):
    path = root / RELATIVE
    source = path.read_text()
    switch_path = path.with_name("IGxV3uh9sw$1.smali")
    switch_source = switch_path.read_text()
    assignments = re.findall(
        r"sget-object v\d+, Lcu/etecsa/tm/ecommerce/qHBfDCWv13G/UZsizlaDNk;->(\w+):"
        r".*?const(?:/4|/16) v\d+, (0x[0-9a-f]+).*?aput", switch_source, re.DOTALL)
    switch_map = {name: int(value, 0) for name, value in assignments}
    if set(switch_map) != set(ENUM_NAMES[:-1]):
        raise ValueError("Unexpected enum switch assignments")
    method = MessageMethod(source, [switch_map.get(name, 0) for name in ENUM_NAMES])
    cases = [None, "", "0", "1", "09", "100", "401", "-1", "-4", "-5", "402", "xyz", "0NO", "3NP"]
    return {
        "apk": "cu.etecsa.cubacel.tr.tm-v162.apk",
        "apk_sha256": "b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a",
        "source": RELATIVE, "source_sha256": hashlib.sha256(path.read_bytes()).hexdigest(),
        "switch_source_sha256": hashlib.sha256(switch_path.read_bytes()).hexdigest(),
        "method": "getErrorMessage(ErrorType,String)",
        "rows": [{"operation": op, "code": code, **method.evaluate(op, code)}
                 for op in ENUM_NAMES for code in cases],
    }


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--output", type=Path, required=True)
    args = parser.parse_args()
    result = evidence(args.root)
    args.output.parent.mkdir(parents=True, exist_ok=True)
    args.output.write_text(json.dumps(result, indent=2, ensure_ascii=False) + "\n")
    print(f"Recovered {len(result['rows'])} error-message cases from smali")


if __name__ == "__main__":
    main()
