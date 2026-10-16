package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.QfruhfaN5Z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.Ax4arraYwv;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.O7xyZJJBFWg;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.TVYvUziTDv;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.w9YDCnqpz8I;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.tuqYe4EsPvj.T0kxbcahAZJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class pAzq93vIl3 implements IixRWvtdZG.CommunicadorDialogListener, TVYvUziTDv {
    public Activity activity;
    public String[] cadenaList;
    public Context context;
    public IixRWvtdZG dialogUSSD;
    public FragmentManager fragmentManager;
    public String idsecuencia;
    private ImageView imgArrow;
    private UssdResponseObserver observer;
    public int MAX_PARAMETERS_TO_PACKAGE = 6;
    public int MAX_PARAMETERS_TOTAL = 52;
    public rDEl7rW1aN base = new rDEl7rW1aN();
    public int posicion = 0;
    public int fallas = 0;
    public int cantidadPaqueteEnviar = 0;
    public int MAX_FALLAS_USSD = 3;
    private boolean isRecyclerViewVisible = true;
    private boolean isDialogUSSDShowing = false;

    public interface ConfirmDialogListener {
        void onDialogResult(boolean z);
    }

    public interface UssdResponseObserver {
        void onCloseAndBack();

        void onUssdResponseReceived(String str);
    }

    public pAzq93vIl3(Context context, UssdResponseObserver observer) {
        this.context = context;
        this.observer = observer;
        Ax4arraYwv.getInstance().setCallback(this);
    }

    public void principalEnviarUSSD(final Context context, final String codeService, final String codeOper, final String agency, int maxParametersXPqte, final String secuencia, final String mensajeDialog, final ViewGroup group, final FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.cantidadPaqueteEnviar = 0;
        this.posicion = 0;
        this.fallas = 0;
        this.MAX_PARAMETERS_TO_PACKAGE = maxParametersXPqte;
        showConfirmDialog(context, mensajeDialog, new ConfirmDialogListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.1
            @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.ConfirmDialogListener
            public void onDialogResult(boolean confirmed) {
                if (confirmed) {
                    pAzq93vIl3.this.empaquetarUSSD(context, codeService, codeOper, agency, secuencia, mensajeDialog, group, fragmentManager);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void empaquetarUSSD(final Context context, String codeService, String codeOper, String agency, String secuencia, String mensajeDialog, ViewGroup group, FragmentManager fragmentManager) {
        this.idsecuencia = generarSecuenciaBasica();
        String secuenciaOriginal = encodeUSSD(secuencia);
        String[] strArrEncpackageUSSDByLimitChar = encpackageUSSDByLimitChar(codeService, codeOper, agency, secuenciaOriginal);
        this.cadenaList = strArrEncpackageUSSDByLimitChar;
        if (Build.VERSION.SDK_INT >= 26) {
            final T0kxbcahAZJ progressDialog = new T0kxbcahAZJ(context);
            progressDialog.showProgress(0, this.cadenaList.length);
            MX9gh9mLxd ussdHelper = new MX9gh9mLxd(context, new MX9gh9mLxd.UssdCallbackListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.2
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdResponse(String request, String response) {
                    Log.d("IHVTCBmiLV", "USSD Respondió: " + response);
                }

                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdError(String request, int errorCode) {
                    Log.e("IHVTCBmiLV", "Error en USSD (" + request + "): Código " + errorCode);
                }

                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdResponseData(boolean enviado, int posicion, boolean completado, String request, String errorCode) {
                    if (completado) {
                        Toast.makeText(context, "Envio completado", 0).show();
                        progressDialog.showCompletedAndClose();
                        pAzq93vIl3.this.retornarFragmentBack();
                    } else if (enviado) {
                        progressDialog.showProgress(posicion, pAzq93vIl3.this.cadenaList.length);
                    } else {
                        progressDialog.showErrorAndClose();
                        pAzq93vIl3.this.retornarFragmentBack();
                    }
                }
            });
            ussdHelper.sendUssdRequests(this.cadenaList);
            return;
        }
        if (strArrEncpackageUSSDByLimitChar.length == 1) {
            FBsQzP3Zfj.actionCallUSSDBack(context, codeOper, secuencia, mensajeDialog, group, fragmentManager);
        } else {
            showDialogoEnvioUSSD();
        }
    }

    public void principalEnviarUSSD(final Context context, String codeService, String codeOper, String agency, String secuencia, String mensajeDialog, ViewGroup group, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.cantidadPaqueteEnviar = 0;
        this.posicion = 0;
        this.fallas = 0;
        this.MAX_PARAMETERS_TO_PACKAGE = countGroups(secuencia, this.MAX_PARAMETERS_TOTAL);
        this.idsecuencia = generarSecuenciaBasica();
        String secuenciaOriginal = encodeUSSD(secuencia);
        String[] strArrEncpackageUSSDByLimitChar = encpackageUSSDByLimitChar(codeService, codeOper, agency, secuenciaOriginal);
        this.cadenaList = strArrEncpackageUSSDByLimitChar;
        int length = strArrEncpackageUSSDByLimitChar.length;
        if (Build.VERSION.SDK_INT >= 26) {
            final T0kxbcahAZJ progressDialog = new T0kxbcahAZJ(context);
            MX9gh9mLxd ussdHelper = new MX9gh9mLxd(context, new MX9gh9mLxd.UssdCallbackListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.3
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdResponse(String request, String response) {
                    Log.d("IHVTCBmiLV", "USSD Respondió: " + response);
                }

                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdError(String request, int errorCode) {
                    Log.e("IHVTCBmiLV", "Error en USSD (" + request + "): Código " + errorCode);
                }

                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.MX9gh9mLxd.UssdCallbackListener
                public void onUssdResponseData(boolean enviado, int posicion, boolean completado, String request, String errorCode) {
                    if (completado) {
                        Toast.makeText(context, "Envio completado", 0).show();
                        progressDialog.showCompletedAndClose();
                    } else {
                        progressDialog.showProgress(posicion, pAzq93vIl3.this.cadenaList.length);
                    }
                }
            });
            ussdHelper.sendUssdRequests(this.cadenaList);
            return;
        }
        showDialogoEnvioUSSD();
    }

    private void showConfirmDialog(Context context, String message, final ConfirmDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ConfirmDialogListener confirmDialogListener = listener;
                if (confirmDialogListener != null) {
                    confirmDialogListener.onDialogResult(true);
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ConfirmDialogListener confirmDialogListener = listener;
                if (confirmDialogListener != null) {
                    confirmDialogListener.onDialogResult(false);
                }
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void showDialogoEnvioUSSD() {
        try {
            IixRWvtdZG.ObjRequest request = new IixRWvtdZG.ObjRequest();
            List<QfruhfaN5Z> datas = new ArrayList<>();
            for (int i = 0; i < this.cadenaList.length; i++) {
                QfruhfaN5Z uyh0pxs9m37in = new QfruhfaN5Z();
                uyh0pxs9m37in.setEnviado(false);
                uyh0pxs9m37in.setNoPaquete(i);
                uyh0pxs9m37in.setTitulo(String.valueOf(i + 1));
                datas.add(uyh0pxs9m37in);
            }
            request.data = datas;
            IixRWvtdZG iixRWvtdZGNewInstance = IixRWvtdZG.newInstance(request, this);
            this.dialogUSSD = iixRWvtdZGNewInstance;
            if (iixRWvtdZGNewInstance.getDialog() != null) {
                this.dialogUSSD.getDialog().setCanceledOnTouchOutside(true);
            }
            this.dialogUSSD.show(this.fragmentManager, "fragment_ticket");
        } catch (Exception e) {
            this.isDialogUSSDShowing = false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.CommunicadorDialogListener
    public void initUSSDAutomatic() {
        Log.i("NF_LOG", " initUSSDAutomatic");
        if (startListening()) {
            this.posicion = 1;
            this.cantidadPaqueteEnviar = this.cadenaList.length + 1;
            sendDataUSSD(0);
            return;
        }
        Toast.makeText(this.context, "Conceda los permisos de accesibilidad necesarios", 0).show();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x.TVYvUziTDv
    public void onUssdReceived() {
        Log.i("NF_LOG", " onUssdReceived");
        if (this.posicion < this.cantidadPaqueteEnviar - 1) {
            Log.i("NF_LOG", " llego");
            Log.i("NF_LOG", " posicion" + this.posicion);
            sendDataUSSD(this.posicion);
            this.posicion = this.posicion + 1;
            return;
        }
        stopListening(this.context);
        try {
            this.dialogUSSD.dismiss();
        } catch (Exception ex) {
            Log.e("NF_LOG", ex.getMessage());
        }
        Toast.makeText(this.context, "Envios completados", 0).show();
        retornarFragmentBack();
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.CommunicadorDialogListener
    public void onSendUSSD(IixRWvtdZG.ObjResponse data) {
        Log.i("NF_LOG", " onSendUSSD");
        if (data != null) {
            sendDataUSSD(data.data.noPaquete);
        }
    }

    private void sendDataUSSD(int posicion) {
        String ussdCode = this.cadenaList[posicion] + Uri.encode("#");
        String ussdUri = "tel:" + ussdCode;
        Intent ussdIntent = new Intent("android.intent.action.CALL", Uri.parse(ussdUri));
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") != 0) {
            return;
        }
        this.dialogUSSD.cambiarEstadoSwitch(posicion, true);
        this.context.startActivity(ussdIntent);
    }

    private String encodeUSSD(String candenaPl) {
        return this.base.code(candenaPl);
    }

    private String[] encpackageUSSD(String codeService, String numeroOperacion, String agency, String cadena) {
        pAzq93vIl3 pazq93vil3 = this;
        String[] cadenasArr = cadena.split("\\*");
        int count = cadenasArr.length;
        int maxPackage = (int) Math.ceil(((double) count) / ((double) pazq93vil3.MAX_PARAMETERS_TO_PACKAGE));
        String[] cadenasArrOUT = new String[maxPackage];
        int posicion = 0;
        int posicionArreglo = 0;
        int j = 0;
        while (j < maxPackage) {
            StringBuilder cadenaConcat = new StringBuilder();
            for (int i = 0; i < pazq93vil3.MAX_PARAMETERS_TO_PACKAGE && posicion < count; i++) {
                if (i > 0) {
                    cadenaConcat.append("*");
                }
                cadenaConcat.append(cadenasArr[posicion]);
                posicion++;
            }
            String cadenasConcatenadas = cadenaConcat.toString();
            String codeAcceso = BuildConfig.FLAVOR;
            String version = BuildConfig.FLAVOR;
            unYp8VQThY.init(pazq93vil3.context);
            List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigList.size() > 0) {
                codeAcceso = appConfigList.get(0).getCodigo();
                version = appConfigList.get(0).getNumber();
            }
            int p = j + 1;
            String[] cadenasArr2 = cadenasArr;
            int count2 = count;
            String positionS = String.valueOf(p).length() == 1 ? "0" + String.valueOf(p) : String.valueOf(p);
            int posicion2 = posicion;
            String maxPackageS = String.valueOf(maxPackage).length() == 1 ? "0" + String.valueOf(maxPackage) : String.valueOf(maxPackage);
            String banderaEmpaquetado = positionS + maxPackageS + "*" + pazq93vil3.idsecuencia;
            String cadenaCodificadada = banderaEmpaquetado + "*" + numeroOperacion + "*" + agency + "*" + cadenasConcatenadas;
            String cadenaCompleta = "*" + codeAcceso + "*" + codeService + "*" + cadenaCodificadada + "*" + version;
            cadenasArrOUT[posicionArreglo] = cadenaCompleta;
            posicionArreglo++;
            j++;
            pazq93vil3 = this;
            count = count2;
            cadenasArr = cadenasArr2;
            posicion = posicion2;
        }
        return cadenasArrOUT;
    }

    public String[] encpackageUSSDByLimitChar(String codeService, String numeroOperacion, String agency, String cadena) {
        String positionS;
        String maxPackageS;
        int CADENAS_DE_CONTROL_MAXIMA;
        String itemAtom;
        pAzq93vIl3 pazq93vil3 = this;
        int CADENAS_DE_CONTROL_MAXIMA2 = 32;
        String[] cadenasArr = cadena.split("\\*");
        int cantidadParametros = cadenasArr.length;
        int posicionArreglo = 0;
        ArrayList<String> lista = new ArrayList<>();
        boolean banderaCrearNuevoElemento = true;
        String itemAtom2 = BuildConfig.FLAVOR;
        int cantidadItemInsertados = 0;
        int j = 0;
        while (j < cantidadParametros) {
            String itemArr = cadenasArr[j];
            int itemCharCount = itemArr.length();
            if (itemCharCount <= 0) {
                CADENAS_DE_CONTROL_MAXIMA = CADENAS_DE_CONTROL_MAXIMA2;
            } else {
                int itemAtomLenght = itemAtom2.length();
                int sumaAux = itemCharCount + itemAtomLenght + CADENAS_DE_CONTROL_MAXIMA2;
                if (itemAtom2.isEmpty()) {
                    CADENAS_DE_CONTROL_MAXIMA = CADENAS_DE_CONTROL_MAXIMA2;
                    itemAtom = "*" + itemArr;
                    cantidadItemInsertados++;
                } else {
                    CADENAS_DE_CONTROL_MAXIMA = CADENAS_DE_CONTROL_MAXIMA2;
                    int CADENAS_DE_CONTROL_MAXIMA3 = pazq93vil3.MAX_PARAMETERS_TOTAL;
                    if (sumaAux <= CADENAS_DE_CONTROL_MAXIMA3) {
                        itemAtom = itemAtom2 + "*" + itemArr;
                        cantidadItemInsertados++;
                    } else {
                        lista.add(itemAtom2);
                        itemAtom = "*" + itemArr;
                    }
                }
                if (j == cantidadParametros - 1) {
                    lista.add(itemAtom);
                }
                itemAtom2 = itemAtom;
            }
            j++;
            CADENAS_DE_CONTROL_MAXIMA2 = CADENAS_DE_CONTROL_MAXIMA;
        }
        int CADENAS_DE_CONTROL_MAXIMA4 = lista.size();
        String[] cadenasArrOUT = new String[CADENAS_DE_CONTROL_MAXIMA4];
        int i = 0;
        while (i < lista.size()) {
            String codeAcceso = BuildConfig.FLAVOR;
            String version = BuildConfig.FLAVOR;
            unYp8VQThY.init(pazq93vil3.context);
            List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigList.size() > 0) {
                codeAcceso = appConfigList.get(0).getCodigo();
                version = appConfigList.get(0).getNumber();
            }
            int p = i + 1;
            String[] cadenasArr2 = cadenasArr;
            int cantidadParametros2 = cantidadParametros;
            if (String.valueOf(p).length() == 1) {
                positionS = "0" + String.valueOf(p);
            } else {
                positionS = String.valueOf(p);
            }
            int tammannoList = lista.size();
            boolean banderaCrearNuevoElemento2 = banderaCrearNuevoElemento;
            String itemAtom3 = itemAtom2;
            if (String.valueOf(tammannoList).length() == 1) {
                maxPackageS = "0" + String.valueOf(tammannoList);
            } else {
                maxPackageS = String.valueOf(tammannoList);
            }
            String banderaEmpaquetado = positionS + maxPackageS + "*" + pazq93vil3.idsecuencia;
            String cadenaCodificadada = banderaEmpaquetado + "*" + numeroOperacion + "*" + agency + lista.get(i);
            String cadenaCompleta = "*" + codeAcceso + "*" + codeService + "*" + cadenaCodificadada + "*" + version;
            cadenasArrOUT[posicionArreglo] = cadenaCompleta;
            posicionArreglo++;
            i++;
            pazq93vil3 = this;
            cantidadParametros = cantidadParametros2;
            cadenasArr = cadenasArr2;
            itemAtom2 = itemAtom3;
            banderaCrearNuevoElemento = banderaCrearNuevoElemento2;
        }
        return cadenasArrOUT;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private String generarSecuenciaBasica() {
        Date ahora = new Date();
        SimpleDateFormat formatoMinutos = new SimpleDateFormat("mm", Locale.getDefault());
        SimpleDateFormat formatoSegundos = new SimpleDateFormat("ss", Locale.getDefault());
        int minutosNum = Integer.parseInt(formatoMinutos.format(ahora));
        String minutos = String.valueOf(minutosNum);
        String segundos = formatoSegundos.format(ahora);
        String resultado = minutos + segundos;
        return resultado;
    }

    private String generarSecuencia() {
        if (Build.VERSION.SDK_INT >= 26) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMHHmss");
            String secuencia = formatter.format(ahora);
            String ultimoDigitoAnio = String.valueOf(ahora.getYear() % 10);
            Random random = new Random();
            int numeroAleatorio = random.nextInt(10);
            return secuencia + ultimoDigitoAnio + numeroAleatorio;
        }
        Random random2 = new Random();
        int numeroAleatorio2 = random2.nextInt(999);
        String secuencia2 = String.valueOf(numeroAleatorio2);
        return secuencia2;
    }

    public void retornarFragmentBack() {
        this.observer.onCloseAndBack();
    }

    private boolean startListening() {
        boolean isServiceEnabled = w9YDCnqpz8I.isAccessibilityServiceEnabled(this.context, O7xyZJJBFWg.class);
        if (!isServiceEnabled) {
            O7xyZJJBFWg.showAccessibilityServiceDialog(this.context);
            return false;
        }
        Intent intent = new Intent("START_LISTENING");
        this.context.sendBroadcast(intent);
        return true;
    }

    private void stopListening(Context context) {
        Intent intent = new Intent("STOP_LISTENING");
        context.sendBroadcast(intent);
        O7xyZJJBFWg service = new O7xyZJJBFWg();
        service.stopAccessibilityService(context);
        Log.i("NF_LOG", "Listening stopped and service disabled.");
    }

    public int countGroups(String input, int maxLength) {
        if (input == null || input.isEmpty() || maxLength <= 0) {
            throw new IllegalArgumentException("Entrada inválida o longitud máxima no válida.");
        }
        int groupCount = 0;
        StringBuilder currentGroup = new StringBuilder();
        for (char c : input.toCharArray()) {
            currentGroup.append(c);
            if (c == '*' && currentGroup.length() > maxLength) {
                groupCount++;
                currentGroup.setLength(1);
            }
        }
        if (currentGroup.length() > 0) {
            return groupCount + 1;
        }
        return groupCount;
    }
}
