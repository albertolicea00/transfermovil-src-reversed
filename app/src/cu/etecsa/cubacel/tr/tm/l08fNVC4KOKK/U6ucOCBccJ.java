package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.Y9aAL2BCAI;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class U6ucOCBccJ {
    public static String pTextoSpMisCuentas;
    public static String pcuenta;
    public static jceCwl8l2R pseleccionCuenta;
    public static List<Y9aAL2BCAI> itemsOperacionList = null;
    public static boolean isDebug = false;
    public static String pdata = BuildConfig.FLAVOR;
    public static int pmoneda = 0;
    public static String pEntidad = BuildConfig.FLAVOR;
    public static Provincia pProvincia = new Provincia();
    public static Municipio pMunicipio = new Municipio();
    public static String pSucursal = BuildConfig.FLAVOR;
    public static SucursalCadeca pSucursalCadeca = new SucursalCadeca();
    public static int ptipoServicio = 0;
    public static String ptipoServicioBanco = BuildConfig.FLAVOR;
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
                buf.append((CharSequence) mensaje);
                buf.newLine();
                buf.close();
            } catch (IOException e) {
            }
        }
    }

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

    public static boolean isAGTelecom(Context context) {
        try {
            Fr52O1uSYF msap = new Fr52O1uSYF();
            try {
                if (msap.getCodigoAgente(context) == null) {
                    return false;
                }
                hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                String codigo_activacion = msap.getCodigoAgente(context);
                if (codigo_activacion.contains("-1") || codigo_activacion.isEmpty()) {
                    return false;
                }
                String version = msap.getVersion(context);
                String phone = msap.getPhone(context);
                if (!ac.check_code_activation(codigo_activacion, version, phone)) {
                    return false;
                }
                return true;
            } catch (Exception ex) {
                Log.e("TM_SPLASH", "Exception generalVsAgentVersion: " + ex.getMessage());
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNotacionCientifica(String numero) {
        return Pattern.matches("[+-]?\\d+\\.\\d*[eE][+-]?\\d+", numero);
    }
}
