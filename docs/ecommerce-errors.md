# E-commerce error messages

Target: `cu.etecsa.cubacel.tr.tm-v162.apk`, version 1.260416 (162), SHA-256
`b18475eb6911209d21e99d72e6ca888b29236a5b1e470acc70238e05a44f160a`.

`MessageHandler` reconstructs `cu.etecsa.tm.ecommerce.qHBfDCWv13G.IGxV3uh9sw`.
JADX failed to emit `getErrorMessage`; its partial Java is not a complete oracle.
The implementation was recovered from the original smali method and its synthetic
enum switch map, then checked in an isolated JVM.

## HTTP messages

`getMessage(int)` returns `No autorizado.` for HTTP 401 and the
`default_error_msg` string resource for all other status values. The overload
with a heading/body logs `BULEVAR-ERROR` before returning the same message.
`WriteLog` preserves the original `head: CODE [code]body` format.

## Operation codes

| Operation | Code | Result |
| --- | --- | --- |
| All mapped operations except LOGIN_SIMPLE | `1` | `tx_no_item_mostrar` resource |
| All mapped operations except LOGIN_SIMPLE | `100` | `error_msg_no_permiso` resource |
| All eight mapped operations | `401` | `No autorizado.` |
| LOGIN_SIMPLE | `-1` | `err_login_1` resource |
| LOGIN_SIMPLE | `-4` | `err_login_2` resource |
| LOGIN_SIMPLE | `-5` | `err_login_5` resource |
| DEVOLVER_PAGO | `09` | `Ya existe una devolución pendiente con el identificador de pago solicitado.` |
| All other codes in mapped operations | Any other string | `default_error_msg` resource |
| ESTADISTICAS | Any value, including null | Empty string |

The mapped operations are LISTAR_USERS_GET, LISTAR_USERS_SET,
LISTAR_CUENTAS_GET, LOGIN_SIMPLE, PAGO_DINAMICO_POST, LISTAR_NEGOCIOS_GET,
DEVOLVER_PAGO, and GET_PERMISOS. ESTADISTICAS has no entry in the original
synthetic switch array, so execution returns the initial empty string.
A null operation throws NullPointerException; a null code also throws for
the eight mapped operations. The reconstruction preserves these behaviors.

## Reproduction and validation

With the matching local smali input, run:

```sh
python3 scripts/message-handler-evidence.py --output mappings/evidence/ecommerce-errors.json
make test-reconstruction
```

The evaluator supports only the small instruction subset present in this pure
lookup method and fails on unsupported instructions. It follows the original
labels, hash switches, equals checks, enum switch map, constants, and resource
lookups. Resource lookups become symbolic `@string/name` results.

The tracked evidence includes APK identity, bytecode source hashes, and 126
operation/code cases, including unknown/null values and strings colliding with
the Java hashes of `100` and `401`. JVM tests compare the reconstructed class
against this evidence and check HTTP/logging behavior. They do not send network
requests. If smali is unavailable, the JVM test still runs against recorded
evidence; regeneration verification is explicitly skipped.
