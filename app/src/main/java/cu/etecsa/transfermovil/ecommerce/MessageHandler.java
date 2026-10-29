package cu.etecsa.transfermovil.ecommerce;

import android.content.Context;
import android.util.Log;
import cu.etecsa.transfermovil.R;

/**
 * Translates HTTP and operation-specific error codes to the original messages.
 * The getErrorMessage body was recovered from smali because JADX failed to
 * reconstruct its nested switches. See mappings/evidence/ecommerce-errors.json.
 *
 * @obfuscated_class cu.etecsa.tm.ecommerce.qHBfDCWv13G.IGxV3uh9sw
 * @original_apk_version 1.260416
 */
public class MessageHandler {
    private static Context context;
    private static boolean isDebug = true;
    private static final MessageHandler ourInstance = new MessageHandler();

    public static MessageHandler getInstance(Context aContext) {
        context = aContext;
        return ourInstance;
    }

    public String getMessage(int code) {
        return code == 401 ? "No autorizado." : context.getString(R.string.default_error_msg);
    }

    public String getMessage(int code, String headMessage, String message) {
        Log.e("BULEVAR-ERROR", headMessage + ": " + message);
        return getMessage(code);
    }

    public void WriteLog(int code, String headMessage, String message) {
        Log.e("BULEVAR-ERROR", headMessage + ": CODE [" + String.valueOf(code) + "]" + message);
    }

    public String getErrorMessage(ErrorType type, String code) {
        switch (type) {
            case ESTADISTICAS:
                // The original switch has no ESTADISTICAS entry and returns "".
                return "";
            case LOGIN_SIMPLE:
                switch (code) {
                    case "-1":
                        return context.getString(R.string.err_login_1);
                    case "-4":
                        return context.getString(R.string.err_login_2);
                    case "-5":
                        return context.getString(R.string.err_login_5);
                    case "401":
                        return "No autorizado.";
                    default:
                        return context.getString(R.string.default_error_msg);
                }
            default:
                switch (code) {
                    case "1":
                        return context.getString(R.string.tx_no_item_mostrar);
                    case "100":
                        return context.getString(R.string.error_msg_no_permiso);
                    case "401":
                        return "No autorizado.";
                    case "09":
                        if (type == ErrorType.DEVOLVER_PAGO) {
                            return "Ya existe una devolución pendiente con el identificador de pago solicitado.";
                        }
                        return context.getString(R.string.default_error_msg);
                    default:
                        return context.getString(R.string.default_error_msg);
                }
        }
    }
}
