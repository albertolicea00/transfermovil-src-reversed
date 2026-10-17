package cu.etecsa.transfermovil.core;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import cu.etecsa.transfermovil.core.enums.AccountSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ
 * @fingerprint Global mutable state: current transaction params, selected province/municipality,
 *              debug logging to /sdcard/transfermovil/log.txt, wire transfer fee calculator,
 *              agent activation check.
 *
 * @security writeLog writes to external storage unencrypted when isDebug=true.
 *           isAGTelecom checks agent activation code against version+phone — weak validation.
 *
 * Dependencies (obfuscated references):
 *   - Y9aAL2BCAI → OperationItem (list items for operation menu)
 *   - Fr52O1uSYF → SharedPreferencesAccessor
 *   - hY5P1xQ5h8 → ActivationCodeValidator
 *   - Provincia, Municipio, SucursalCadeca → ORMLite entities
 */
public class GlobalState {
    public static String pTextoSpMisCuentas;
    public static String pcuenta;
    public static AccountSelection pseleccionCuenta;
    // public static List<OperationItem> itemsOperacionList = null;
    public static boolean isDebug = false;
    public static String pdata = "";
    public static int pmoneda = 0;
    public static String pEntidad = "";
    // public static Provincia pProvincia = new Provincia();
    // public static Municipio pMunicipio = new Municipio();
    public static String pSucursal = "";
    // public static SucursalCadeca pSucursalCadeca = new SucursalCadeca();
    public static int ptipoServicio = 0;
    public static String ptipoServicioBanco = "";
    public static boolean pIsEnviar = false;

    public static void writeLog(String mensaje) {
        if (isDebug) {
            String outFileName = Environment.getExternalStorageDirectory() + "/transfermovil/log.txt";
            File logFile = new File(outFileName);
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                } catch (IOException eio) {
                    eio.printStackTrace();
                }
            }
            try {
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                buf.append(mensaje);
                buf.newLine();
                buf.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * Calculates total wire transfer cost: base amount + 3% fee + 2 CUP per 300-CUP tranche.
     */
    public static double calculate_importe_giro(double importe_giro) {
        double importe_x = 3.0d * importe_giro;
        double importe_x2 = importe_x / 100.0d;
        int cantidad_giros = 1;
        if (importe_giro > 300.0d) {
            Double a = Double.valueOf(importe_giro / 300.0d);
            cantidad_giros = a.intValue();
            if (importe_giro % 300.0d > 0.0d) {
                cantidad_giros++;
            }
        }
        double importe_calculado = ((double) (cantidad_giros * 2)) + importe_giro + importe_x2;
        return Math.round(importe_calculado * 100.0d) / 100.0d;
    }

    /**
     * Checks whether current device is registered as a telecom agent.
     * Validates activation code against version and phone number.
     */
    public static boolean isAGTelecom(Context context) {
        try {
            // Fr52O1uSYF msap = new Fr52O1uSYF(); // SharedPreferencesAccessor
            // String codigo_activacion = msap.getCodigoAgente(context);
            // if (codigo_activacion == null) return false;
            // hY5P1xQ5h8 ac = new hY5P1xQ5h8(); // ActivationCodeValidator
            // if (codigo_activacion.contains("-1") || codigo_activacion.isEmpty()) return false;
            // String version = msap.getVersion(context);
            // String phone = msap.getPhone(context);
            // return ac.check_code_activation(codigo_activacion, version, phone);
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNotacionCientifica(String numero) {
        return Pattern.matches("[+-]?\\d+\\.\\d*[eE][+-]?\\d+", numero);
    }
}
