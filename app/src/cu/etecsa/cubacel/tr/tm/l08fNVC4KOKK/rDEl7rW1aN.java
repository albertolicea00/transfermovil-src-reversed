package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import AFm1GraXBXUkpF1hmOdV.Tz34gww2TFwrsuT8ukpL;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsMessage;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import ar.com.daidalos.afiledialog.FileChooserDialog;
import au.com.bytecode.opencsv.CSVReader;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.b9Y4DfRgnv;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.kR22DOzTiB;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.LZkPyWnV4b;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AgentService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.BancoService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class rDEl7rW1aN extends AppCompatActivity {
    public static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    public static final int NOTIFICATION_ID_RECEIVED = 4641;
    public static String code_version = "372653282298718711";
    public static String cv = "708091521823824654864548452244";
    public ProgressDialog bar;
    public Context contextoFile;
    public boolean fileImport = false;
    private FileChooserDialog.OnFileSelectedListener onFileSelectedListener = new FileChooserDialog.OnFileSelectedListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.3
        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File file) {
            source.hide();
            rDEl7rW1aN b = new rDEl7rW1aN();
            b.showCustomDialog(file, source.getContext(), b9Y4DfRgnv.Todos);
        }

        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File folder, String name) {
            source.hide();
            Toast toast = Toast.makeText(rDEl7rW1aN.this.getApplicationContext(), "File created: " + folder.getName() + "/" + name, 1);
            toast.show();
        }
    };
    private FileChooserDialog.OnFileSelectedListener onFileSelectedListenerImport = new FileChooserDialog.OnFileSelectedListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.4
        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File file) {
            source.hide();
            String path = file.getParent();
            String name = file.getName();
            File exportDir = new File(path, name);
            if (rDEl7rW1aN.this.importar(exportDir, source.getContext())) {
                rDEl7rW1aN.this.helpAlertGestionAndCloseApp(source.getContext(), "Debe cerrar la aplicación para completar los cambios de la importación");
            }
        }

        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File folder, String name) {
            source.hide();
            Toast toast = Toast.makeText(source.getContext(), "File created: " + folder.getName() + "/" + name, 1);
            toast.show();
        }
    };
    private FileChooserDialog.OnFileSelectedListener onFileSelectedListenerExportSMS = new FileChooserDialog.OnFileSelectedListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.5
        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File file) {
            source.hide();
            rDEl7rW1aN b = new rDEl7rW1aN();
            b.showCustomDialog(file, source.getContext(), b9Y4DfRgnv.RecordSMS);
        }

        @Override // ar.com.daidalos.afiledialog.FileChooserDialog.OnFileSelectedListener
        public void onFileSelected(Dialog source, File folder, String name) {
            source.hide();
            Toast toast = Toast.makeText(rDEl7rW1aN.this.getApplicationContext(), "File created: " + folder.getName() + "/" + name, 1);
            toast.show();
        }
    };
    public String crude_code = "10000110101100011000100100100000110010001100000011100010100110010001010010100010111110001100010000011000010101100000000110001100101010100100011000000101110001100001100010001011110001100010100001000110000001101000101001001101001000001000010001100100011010010111001000110011110010001001100001000100000010000111001000110000101110100001111110011000001000110010000111110001100001111111000110011000101001100101000110001000111100011000101011101011111100111010100010111101000110000110011000110011100011000100111000101000011100010100111000011101100011000010101010000010101000100010100011001010101101000110001011101100011001001101101001111100011000000100010001100100010110101000110110000110000101000100011000000010100000010010001101011011100010110001110001001011100000110110001100001000011001011010100101100010001100100011110100011000011000110001100101010110101011110001100010000101000110001001101010010001001110001000010110110001100100111010001101101000110010010110001000110101000011110110000011101000110001001001100100010010000001111000110010011101110001100000001011000110000100011001111101000110000010010100011000110111100101100101011001100000010011000110000000001000100111100011000101101000100100000100010010101000100011100011000001101110001110011000101001";
    public final BroadcastReceiver mReceivedSMSReceiver = new BroadcastReceiver() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.18
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundle;
            String action = intent.getAction();
            if (rDEl7rW1aN.ACTION.equals(action) && (bundle = intent.getExtras()) != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    return;
                }
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }
                String sender = messages[0].getOriginatingAddress();
                if (sender.equals("PAGOxMOVIL")) {
                    String message = sb.toString();
                    rDEl7rW1aN.this.displayAlert(message);
                }
            }
        }
    };

    public void clearForm(ViewGroup group) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText(BuildConfig.FLAVOR);
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                clearForm((ViewGroup) view);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void mensaje(String text) {
        Toast toast = Toast.makeText(getBaseContext(), text, 0);
        toast.show();
    }

    public void mensaje(String text, Context cn) {
        Toast toast = Toast.makeText(cn, text, 0);
        toast.show();
    }

    public void showCustomDialog(File file, final Context context, final b9Y4DfRgnv entidades) {
        final File exportDir = new File(file.getAbsolutePath());
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.fganjaowthboc, (ViewGroup) null);
        final EditText titleBox = (EditText) v.findViewById(R.id.editTextEmail);
        builder.setView(v).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                b9Y4DfRgnv b9y4dfrgnv = entidades;
                b9Y4DfRgnv b9y4dfrgnv2 = b9Y4DfRgnv.Clientes;
                if (b9y4dfrgnv == b9y4dfrgnv2) {
                    String Texto = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task = new LZkPyWnV4b(context, b9y4dfrgnv2, exportDir, Texto);
                    task.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv3 = b9Y4DfRgnv.Pines;
                if (b9y4dfrgnv == b9y4dfrgnv3) {
                    String Texto2 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task2 = new LZkPyWnV4b(context, b9y4dfrgnv3, exportDir, Texto2);
                    task2.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv4 = b9Y4DfRgnv.Fijos;
                if (b9y4dfrgnv == b9y4dfrgnv4) {
                    String Texto3 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task3 = new LZkPyWnV4b(context, b9y4dfrgnv4, exportDir, Texto3);
                    task3.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv5 = b9Y4DfRgnv.Moviles;
                if (b9y4dfrgnv == b9y4dfrgnv5) {
                    String Texto4 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task4 = new LZkPyWnV4b(context, b9y4dfrgnv5, exportDir, Texto4);
                    task4.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv6 = b9Y4DfRgnv.Nautas;
                if (b9y4dfrgnv == b9y4dfrgnv6) {
                    String Texto5 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task5 = new LZkPyWnV4b(context, b9y4dfrgnv6, exportDir, Texto5);
                    task5.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv7 = b9Y4DfRgnv.Todos;
                if (b9y4dfrgnv == b9y4dfrgnv7) {
                    String Texto6 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task6 = new LZkPyWnV4b(context, b9y4dfrgnv7, exportDir, Texto6);
                    task6.execute(new String[0]);
                    return;
                }
                b9Y4DfRgnv b9y4dfrgnv8 = b9Y4DfRgnv.RecordSMS;
                if (b9y4dfrgnv == b9y4dfrgnv8) {
                    String Texto7 = String.valueOf(titleBox.getText());
                    LZkPyWnV4b task7 = new LZkPyWnV4b(context, b9y4dfrgnv8, exportDir, Texto7);
                    task7.execute(new String[0]);
                } else {
                    b9Y4DfRgnv b9y4dfrgnv9 = b9Y4DfRgnv.Facturas;
                    if (b9y4dfrgnv == b9y4dfrgnv9) {
                        String Texto8 = String.valueOf(titleBox.getText());
                        LZkPyWnV4b task8 = new LZkPyWnV4b(context, b9y4dfrgnv9, exportDir, Texto8);
                        task8.execute(new String[0]);
                    }
                }
            }
        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setTitle("Introduzca el nombre del fichero a crear");
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void imporDialogFile(Context contex) {
        this.contextoFile = contex;
        FileChooserDialog dialog = new FileChooserDialog(contex);
        dialog.addListener(this.onFileSelectedListener);
        dialog.setFolderMode(true);
        dialog.show();
    }

    public void exporSMSFile(Context contex) {
        this.contextoFile = contex;
        FileChooserDialog dialog = new FileChooserDialog(contex);
        dialog.addListener(this.onFileSelectedListenerExportSMS);
        dialog.setFolderMode(true);
        dialog.show();
    }

    public void exportDialogFile(Context contex) {
        FileChooserDialog dialog = new FileChooserDialog(contex);
        dialog.addListener(this.onFileSelectedListenerImport);
        dialog.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:70:0x01ed  */
    public boolean importar(File file, Context context) {
        boolean z;
        if (!file.exists()) {
            file.mkdirs();
        }
        char c = 1;
        try {
            try {
                CSVReader cSVReader = new CSVReader(new FileReader(file));
                int iAddClientGetID = -1;
                int i = 0;
                while (true) {
                    try {
                        String[] next = cSVReader.readNext();
                        if (next == null) {
                            Toast.makeText(context, "Se han importado los registros seleccionado", 1).show();
                            if (i > 0) {
                                Toast.makeText(context, "Existen datos duplicados: " + i + " Registros no fueron importados", 1).show();
                            }
                        } else {
                            try {
                                if (next[0].contains("TF")) {
                                    if (unYp8VQThY.getInstance().getFijoListsWithPhoneNumber(next[c]).size() == 0) {
                                        TelfFijo telfFijo = new TelfFijo();
                                        telfFijo.setNumber(next[c]);
                                        if (iAddClientGetID != -1) {
                                            telfFijo.setId_client(iAddClientGetID);
                                        }
                                        unYp8VQThY.getInstance().addTelfFijo(telfFijo);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("TM")) {
                                    if (unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(next[c]).size() == 0) {
                                        TeflMovil teflMovil = new TeflMovil();
                                        teflMovil.setNumber(next[c]);
                                        if (iAddClientGetID != -1) {
                                            teflMovil.setId_client(iAddClientGetID);
                                        }
                                        unYp8VQThY.getInstance().addTelfMovil(teflMovil);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("NA")) {
                                    if (unYp8VQThY.getInstance().getNautaListsWithAccount(next[c], Integer.valueOf(next[2]).intValue()).size() == 0) {
                                        Nauta nauta = new Nauta();
                                        nauta.setCuenta(next[c]);
                                        nauta.setTipo_cuenta(Integer.valueOf(next[2]).intValue());
                                        if (iAddClientGetID != -1) {
                                            nauta.setId_client(iAddClientGetID);
                                        }
                                        unYp8VQThY.getInstance().addNauta(nauta);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("PI")) {
                                    if (unYp8VQThY.getInstance().getPinListsWithNumPin(next[c]).size() == 0) {
                                        Pin pin = new Pin();
                                        pin.setPin(next[c]);
                                        pin.setDescripcion(next[2]);
                                        unYp8VQThY.getInstance().addPin(pin);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("FA")) {
                                    if (unYp8VQThY.getInstance().getFacturaListsWithFactura(next[2]).size() == 0) {
                                        Factura factura = new Factura();
                                        factura.setTipo_Factura(Integer.valueOf(next[c]).intValue());
                                        factura.setFactura(next[2]);
                                        factura.setCodFactura(next[3]);
                                        if (iAddClientGetID != -1) {
                                            factura.setId_client(iAddClientGetID);
                                        }
                                        unYp8VQThY.getInstance().addFactura(factura);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("CL")) {
                                    if (unYp8VQThY.getInstance().getClientListsWithName(next[1]).size() == 0) {
                                        Client client = new Client();
                                        client.setName(next[1]);
                                        client.setCi(next[2]);
                                        client.setPhone(next[1]);
                                        client.setAddress(next[3]);
                                        iAddClientGetID = unYp8VQThY.getInstance().addClientGetID(client);
                                    } else {
                                        i++;
                                    }
                                }
                                if (next[0].contains("RS")) {
                                    RecordSMS recordSMS = new RecordSMS();
                                    recordSMS.setIdTransaccion(next[1]);
                                    try {
                                        recordSMS.setFecha(new SimpleDateFormat("yyyy-MM-dd \nhh:mm:ss").parse(next[2]));
                                    } catch (Exception e) {
                                    }
                                    recordSMS.setCuenta(next[3]);
                                    recordSMS.setMonto(next[4]);
                                    recordSMS.setMoneda(next[5]);
                                    recordSMS.setServicio(next[6]);
                                    recordSMS.setMostrar(true);
                                    if (next.length > 7) {
                                        switch (next[7]) {
                                            case "Agentes":
                                                recordSMS.setTipo_servicio(KYTjPlWScT.Agentes);
                                                break;
                                            case "BancoMetro":
                                                recordSMS.setTipo_servicio(KYTjPlWScT.BancoMetro);
                                                break;
                                            case "BancoBANDEC":
                                                recordSMS.setTipo_servicio(KYTjPlWScT.BancoBANDEC);
                                                break;
                                            case "BancoBPA":
                                                recordSMS.setTipo_servicio(KYTjPlWScT.BancoBPA);
                                                break;
                                            default:
                                                recordSMS.setTipo_servicio(KYTjPlWScT.Agentes);
                                                break;
                                        }
                                    } else {
                                        recordSMS.setTipo_servicio(KYTjPlWScT.Agentes);
                                    }
                                    unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                                }
                                if (!next[0].contains("TF") && !next[0].contains("TM") && !next[0].contains("MA") && !next[0].contains("CL")) {
                                    if (next.length == 2) {
                                        Pin pin2 = new Pin();
                                        pin2.setPin(next[0]);
                                        if (next[1].contains("CUC") || next[1].contains("CUP")) {
                                            pin2.setDescripcion(next[1]);
                                        } else {
                                            pin2.setDescripcion(BuildConfig.FLAVOR);
                                        }
                                        unYp8VQThY.getInstance().addPin(pin2);
                                    }
                                    if (next.length == 4) {
                                        Client client2 = new Client();
                                        client2.setName(next[0]);
                                        client2.setCi(next[2]);
                                        client2.setAddress(next[3]);
                                        int iAddClientGetID2 = unYp8VQThY.getInstance().addClientGetID(client2);
                                        if (!next[1].isEmpty() && unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(next[1]).size() == 0) {
                                            TelfFijo telfFijo2 = new TelfFijo();
                                            telfFijo2.setNumber(next[1]);
                                            telfFijo2.setId_client(iAddClientGetID2);
                                            unYp8VQThY.getInstance().addTelfFijo(telfFijo2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            c = 1;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        z = true;
                        try {
                            Toast.makeText(context, "ERROR! Formato de archivo incorrecto", 1).show();
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            e.printStackTrace();
                            Toast.makeText(context, "ERROR! Fichero no encontrado", z ? 1 : 0).show();
                        }
                    }
                    z = true;
                    return z;
                }
            } catch (Exception e5) {
                Log.d("ERROR", e5.toString());
                z = true;
                Toast.makeText(context, "ERROR! El fichero no compatible", 1).show();
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            z = true;
        }
    }

    public void helpAlertGestion(Context cn, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cn);
        builder.setTitle("Ayuda!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void helpAlertGestionAndCloseApp(Context cn, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cn);
        builder.setTitle("Aviso!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                System.exit(0);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public String getCodeVersionApp() {
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() <= 0) {
            return null;
        }
        AppConfig app = appConfigList.get(0);
        String version = app.getNumber();
        return version;
    }

    public AgentService getCodeAgent() {
        List<AgentService> agentServiceLists = unYp8VQThY.getInstance().getAllAgentServiceLists();
        if (agentServiceLists.size() <= 0) {
            return null;
        }
        AgentService code = agentServiceLists.get(0);
        return code;
    }

    public boolean sms_actualizar_bd(ContentResolver cs) {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return false;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                RecordSMS recordSMS = parseSMS.parse(sms.get(i));
                if (recordSMS != null) {
                    recordSMS.setFecha(sms.get(i).getDate());
                    List<RecordSMS> c_list = unYp8VQThY.getInstance().getRecordSMSwithIDTransactionByType(recordSMS.getIdTransaccion(), recordSMS.getTipo_servicio());
                    if (c_list != null) {
                        if (c_list.size() == 0) {
                            unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                        }
                    } else {
                        unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }

    public boolean sms_actualizar_bd_datos_app(ContentResolver cs) {
        try {
            Fr52O1uSYF app = new Fr52O1uSYF();
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return false;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                if (parseSMS.parse_fill_sms_data(sms.get(i).getBody())) {
                    app.setPhone(parseSMS.getNumero_telefonico(), getBaseContext());
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return false;
        }
    }

    public String sms_code_agente(ContentResolver cs) {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return BuildConfig.FLAVOR;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                if (parseSMS.parse_fill_sms_data(sms.get(i).getBody()) && !parseSMS.getCode_agent().isEmpty()) {
                    String code = parseSMS.getCode_agent();
                    return code;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String sms_code_bank(ContentResolver cs) {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return BuildConfig.FLAVOR;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                if (parseSMS.parse_fill_sms_data(sms.get(i).getBody()) && !parseSMS.getCode_bank().isEmpty()) {
                    String code = parseSMS.getCode_bank();
                    return code;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String sms_code_bulevar(ContentResolver cs) {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return BuildConfig.FLAVOR;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                if (parseSMS.parse_fill_sms_data(sms.get(i).getBody()) && !parseSMS.getCode_bulevar().isEmpty()) {
                    String code = parseSMS.getCode_bulevar();
                    return code;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String sms_code_boleto(ContentResolver cs) {
        try {
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            if (sms == null) {
                return BuildConfig.FLAVOR;
            }
            g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
            for (int i = 0; i < sms.size(); i++) {
                if (parseSMS.parse_fill_sms_data(sms.get(i).getBody()) && !parseSMS.getCode_boleto().isEmpty()) {
                    String code = parseSMS.getCode_boleto();
                    return code;
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public void actionCallUSSD(String codeAcc, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String cadena = "tel:*" + codeAcc + "*" + codeService + "*" + codeToSend + Uri.encode("#");
        Log.d("code", cadena);
        final Uri number = Uri.parse(cadena);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent dial = new Intent("android.intent.action.CALL", number);
                rDEl7rW1aN.this.startActivity(dial);
                rDEl7rW1aN.this.clearForm(group);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void actionCallUSSD(String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String cadena = "tel:*" + codeToSend + Uri.encode("#");
        Log.d("code", cadena);
        final Uri number = Uri.parse(cadena);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent dial = new Intent("android.intent.action.CALL", number);
                rDEl7rW1aN.this.startActivity(dial);
                rDEl7rW1aN.this.clearForm(group);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void actionCallUSSD(String codeService) {
        String codeAcceso;
        getString(R.string.codigoAcceso);
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
        } else {
            codeAcceso = getString(R.string.codigoAcceso);
        }
        String cadena = "tel:*" + codeAcceso + "*" + codeService + Uri.encode("#");
        Log.d("code", cadena);
        Uri number = Uri.parse(cadena);
        Intent dial = new Intent("android.intent.action.CALL", number);
        startActivity(dial);
    }

    public void actionCallUSSD(String codeService, String codeToSend) {
        String codeAcceso;
        String version;
        getString(R.string.codigoAcceso);
        getString(R.string.version_transfermovil);
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        } else {
            codeAcceso = getString(R.string.codigoAcceso);
            version = getString(R.string.version_transfermovil);
        }
        String codeSendTo = code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("code", cadena);
        Uri number = Uri.parse(cadena);
        Intent dial = new Intent("android.intent.action.CALL", number);
        startActivity(dial);
    }

    public void actionCallUSSD(String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String codeAcceso;
        String version;
        getString(R.string.codigoAcceso);
        getString(R.string.version_transfermovil);
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        } else {
            codeAcceso = getString(R.string.codigoAcceso);
            version = getString(R.string.version_transfermovil);
        }
        String codeSendTo = code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    rDEl7rW1aN.this.startActivity(dial);
                } catch (Exception e) {
                }
                rDEl7rW1aN.this.clearForm(group);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void actionCallUSSDBack(String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, int idfragment) {
        String codeAcceso;
        String version;
        getString(R.string.codigoAcceso);
        getString(R.string.version_transfermovil);
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        } else {
            codeAcceso = getString(R.string.codigoAcceso);
            version = getString(R.string.version_transfermovil);
        }
        String codeSendTo = code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    rDEl7rW1aN.this.startActivity(dial);
                } catch (Exception e) {
                }
                rDEl7rW1aN.this.clearForm(group);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void actionCallUSSDCodeAccess(String codeAccess, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group) {
        String version;
        getString(R.string.version_transfermovil);
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            version = appConfigList.get(0).getNumber();
        } else {
            version = getString(R.string.version_transfermovil);
        }
        String codeSendTo = code(codeToSend);
        String cadena = "tel:*" + codeAccess + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("code", cadena);
        final Uri number = Uri.parse(cadena);
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent dial = new Intent("android.intent.action.CALL", number);
                rDEl7rW1aN.this.startActivity(dial);
                rDEl7rW1aN.this.clearForm(group);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public String code(String cadena) {
        char c;
        String cod_ram;
        int i;
        String code_codif;
        String lenght_string;
        String cod_ram2;
        String[] splitCode = cadena.split("\\*");
        int[] lenght_original_list = new int[splitCode.length];
        boolean is_item_old_version = false;
        for (int i2 = 0; i2 < splitCode.length; i2++) {
            String item_code = String.valueOf(splitCode[i2]);
            if (esEntero(item_code)) {
                lenght_original_list[i2] = splitCode[i2].length();
            } else {
                lenght_original_list[i2] = 0;
                is_item_old_version = true;
            }
        }
        new ArrayList();
        List<String> codeSplit = Arrays.asList(splitCode);
        List<String> code_nauta = new ArrayList<>();
        List<String> code_numbers = new ArrayList<>();
        List<String> code_Salida = new ArrayList<>();
        if (!is_item_old_version) {
            Tz34gww2TFwrsuT8ukpL cd = new Tz34gww2TFwrsuT8ukpL(code_version, this.crude_code);
            code_Salida = cd.aSHV52SplNh3HfZBSmJe(codeSplit);
            c = 0;
            if (code_Salida.get(0).length() == 1) {
                cod_ram = "0" + code_Salida.get(0);
            } else {
                String cod_ram3 = code_Salida.get(0);
                cod_ram = cod_ram3;
            }
        } else {
            for (int pos_item = 0; pos_item < lenght_original_list.length; pos_item++) {
                if (lenght_original_list[pos_item] == 0) {
                    code_nauta.add(codeSplit.get(pos_item));
                } else {
                    code_numbers.add(codeSplit.get(pos_item));
                }
            }
            Tz34gww2TFwrsuT8ukpL cd2 = new Tz34gww2TFwrsuT8ukpL(code_version, this.crude_code);
            List<String> code_n = cd2.aSHV52SplNh3HfZBSmJe(code_numbers);
            if (code_n.get(0).length() == 1) {
                cod_ram2 = "0" + code_n.get(0);
            } else {
                String cod_ram4 = code_n.get(0);
                cod_ram2 = cod_ram4;
            }
            int contador_code_n = 0;
            kR22DOzTiB d = new kR22DOzTiB();
            List<String> code_nau = d.getCodes(code_nauta);
            int contador_code_nau = 0;
            String cod_ram5 = cod_ram2;
            int i3 = 0;
            for (int length = lenght_original_list.length; i3 < length; length = length) {
                int pos_l = lenght_original_list[i3];
                if (pos_l == 0) {
                    code_Salida.add(code_nau.get(contador_code_nau));
                    contador_code_nau++;
                } else {
                    code_Salida.add(code_n.get(contador_code_n + 1));
                    contador_code_n++;
                }
                i3++;
            }
            cod_ram = cod_ram5;
            c = 0;
        }
        String lenght = String.valueOf(lenght_original_list[c]).length() == 1 ? "0" + String.valueOf(lenght_original_list[c]) : String.valueOf(lenght_original_list[c]);
        if (is_item_old_version && code_numbers.size() == 0) {
            code_codif = "00" + lenght + code_Salida.get(0);
            i = 1;
        } else if (is_item_old_version) {
            code_codif = cod_ram + lenght + code_Salida.get(0);
            i = 1;
        } else {
            i = 1;
            code_codif = splitCode.length > 1 ? cod_ram : cod_ram + lenght + code_Salida.get(1);
        }
        if (splitCode.length > i) {
            for (int i4 = 1; i4 < code_Salida.size(); i4++) {
                if (is_item_old_version) {
                    lenght_string = String.valueOf(lenght_original_list[i4]);
                } else {
                    lenght_string = String.valueOf(lenght_original_list[i4 - 1]);
                }
                String lenght2 = lenght_string.length() == 1 ? "0" + String.valueOf(lenght_string) : String.valueOf(lenght_string);
                if (is_item_old_version) {
                    code_codif = code_codif + "*" + lenght2 + code_Salida.get(i4);
                } else if (i4 == 1) {
                    code_codif = code_codif + lenght2 + code_Salida.get(i4);
                } else {
                    code_codif = code_codif + "*" + lenght2 + code_Salida.get(i4);
                }
            }
        }
        return code_codif;
    }

    public boolean esEntero(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            if (!Character.isDigit(cad.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String encryption(String strNormalText) {
        try {
            SecretKey k = V5FFEZ0Qrr0.generateKey(cv);
            String normalTextEnc = V5FFEZ0Qrr0.encryptMsg(strNormalText, k);
            return normalTextEnc;
        } catch (Exception ex) {
            Log.d("ERROR", ex.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public String decryption(String strEncryptedText) {
        try {
            SecretKey k = V5FFEZ0Qrr0.generateKey(cv);
            String strDecryptedText = V5FFEZ0Qrr0.decryptMsg(strEncryptedText, k);
            return strDecryptedText;
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public boolean setqrcodeBk(R1sDOSqZ2z agencyEntity, String argP) {
        BancoService bancoService;
        try {
            String encrypted = encryption(argP);
            int bancos = unYp8VQThY.getInstance().getAllBancoServiceLists().size();
            if (bancos != 0) {
                bancoService = unYp8VQThY.getInstance().getAllBancoServiceLists().get(0);
            } else {
                bancoService = new BancoService();
            }
            switch (AnonymousClass21.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[agencyEntity.ordinal()]) {
                case 1:
                    bancoService.setPmetro(encrypted);
                    break;
                case 2:
                    bancoService.setPbpa(encrypted);
                    break;
                case 3:
                    bancoService.setPbandec(encrypted);
                    break;
                default:
                    return false;
            }
            if (bancos == 0) {
                unYp8VQThY.getInstance().addBancoService(bancoService);
                return true;
            }
            unYp8VQThY.getInstance().updateBancoService(bancoService);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN$21, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass21 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.Metropolitano.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public String getqrcodeBk(R1sDOSqZ2z agencyEntity) {
        String code = BuildConfig.FLAVOR;
        switch (AnonymousClass21.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[agencyEntity.ordinal()]) {
            case 1:
                code = unYp8VQThY.getInstance().getAllBancoServiceLists().get(0).getPmetro();
                break;
            case 2:
                code = unYp8VQThY.getInstance().getAllBancoServiceLists().get(0).getPbpa();
                break;
            case 3:
                code = unYp8VQThY.getInstance().getAllBancoServiceLists().get(0).getPbandec();
                break;
        }
        if (code.isEmpty() || code == BuildConfig.FLAVOR) {
            return BuildConfig.FLAVOR;
        }
        String encrypted = code;
        try {
            String data = decryption(encrypted);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public void displayAlert(String mensaje) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Nuevo mensaje");
        builder.setMessage(mensaje).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.19
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        androidx.appcompat.app.AlertDialog alert = builder.create();
        alert.show();
    }

    public class DownloadNewVersion extends AsyncTask<String, Integer, Boolean> {
        public Context context;
        public String url_sha;

        public DownloadNewVersion(Context context, String url) {
            this.context = context;
            this.url_sha = url;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            rDEl7rW1aN.this.bar = new ProgressDialog(this.context);
            rDEl7rW1aN.this.bar.setCancelable(false);
            rDEl7rW1aN.this.bar.setMessage("Descargando...");
            rDEl7rW1aN.this.bar.setIndeterminate(true);
            rDEl7rW1aN.this.bar.setCanceledOnTouchOutside(false);
            rDEl7rW1aN.this.bar.show();
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            String msg;
            super.onProgressUpdate((Object[]) progress);
            rDEl7rW1aN.this.bar.setIndeterminate(false);
            rDEl7rW1aN.this.bar.setMax(100);
            rDEl7rW1aN.this.bar.setProgress(progress[0].intValue());
            if (progress[0].intValue() > 99) {
                msg = "Finalizando... ";
            } else {
                msg = "Descargando... " + progress[0] + "%";
            }
            rDEl7rW1aN.this.bar.setMessage(msg);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            rDEl7rW1aN.this.bar.dismiss();
            if (!result.booleanValue()) {
                Toast.makeText(rDEl7rW1aN.this.getApplicationContext(), "Error: Prueba de nuevo", 0).show();
            }
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... arg0) {
            Boolean flag = false;
            try {
                String URL_TO_DOWNLOAD = "http://www.etecsa.cu/descargas/transfermovil/?d=" + this.url_sha;
                URL url = new URL(Uri.parse(URL_TO_DOWNLOAD).toString());
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(false);
                c.connect();
                String PATH = Environment.getExternalStorageDirectory() + "/Download/";
                File file = new File(PATH);
                file.mkdirs();
                File outputFile = new File(file, "transfermovil_new_version.apk");
                if (outputFile.exists()) {
                    try {
                        outputFile.delete();
                    } catch (Exception e) {
                    }
                }
                InputStream is = c.getInputStream();
                int total_size = c.getContentLength();
                byte[] buffer = new byte[RecyclerView.ViewHolder.FLAG_ADAPTER_FULLUPDATE];
                int downloaded = 0;
                FileOutputStream fos = new FileOutputStream(outputFile);
                while (true) {
                    int len1 = is.read(buffer);
                    String URL_TO_DOWNLOAD2 = URL_TO_DOWNLOAD;
                    Boolean flag2 = flag;
                    if (len1 != -1) {
                        try {
                            fos.write(buffer, 0, len1);
                            downloaded += len1;
                            int per = (downloaded * 100) / total_size;
                            publishProgress(Integer.valueOf(per));
                            URL_TO_DOWNLOAD = URL_TO_DOWNLOAD2;
                            flag = flag2;
                        } catch (Exception e2) {
                        }
                    } else {
                        fos.close();
                        is.close();
                        rDEl7rW1aN.this.OpenNewVersion(PATH);
                        return true;
                    }
                    return false;
                }
            } catch (Exception e3) {
            }
        }
    }

    public void OpenNewVersion(String location) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(location + "transfermovil_new_version.apk")), "application/vnd.android.package-archive");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void ShowMessageADialog(String title, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(mensaje).setCancelable(true).setPositiveButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
