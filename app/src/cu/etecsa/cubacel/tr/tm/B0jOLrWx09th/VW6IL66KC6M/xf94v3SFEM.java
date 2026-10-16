package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class xf94v3SFEM extends Fragment {
    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    public R1sDOSqZ2z agencia;
    private Button btnAceptar;
    public Context context;
    private AutoCompleteTextView inputClave;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutClave;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutTipoMoneda;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    private AutoCompleteTextView inputMonto;
    public String noProveedor;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public jN13TOyLMX spinnerTipoMonedaImporte;
    public String[] tipomoneda;
    public int spinnerPositionSelect = 0;
    public int moneda = 1;
    public String aux = "1";
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xf94v3SFEM.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            xf94v3SFEM.this.moneda = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.xkj2aiu8ydzjr, container, false);
        this.context = container.getContext();
        this.activity = getActivity();
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_notransaccion);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_notransaccion);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.tipomoneda = getResources().getStringArray(R.array.currency_no_usd);
        this.inputLayoutTipoMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerMonedaTransaccion);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency_no_usd, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        Bundle arg = getArguments();
        R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
        this.agencia = r1sDOSqZ2z;
        if (r1sDOSqZ2z == R1sDOSqZ2z.BANDEC) {
            this.inputLayoutTipoMoneda.setVisibility(8);
        }
        if (this.agencia == R1sDOSqZ2z.Metropolitano) {
            this.inputLayoutClave.setHint(getString(R.string.pin_tarjeta_telebanca));
        }
        if (arg.containsKey("APK_VALUE")) {
            String qrdata = arg.getString("APK_VALUE");
            JSONCompleteFields(qrdata);
            TEXTPLAINCompleteFields(qrdata);
            putData();
        }
        completarQR();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xf94v3SFEM.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xf94v3SFEM.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem uyh0pxs9m37in = menu.findItem(R.id.qrsgen);
        uyh0pxs9m37in.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
        saveData();
        switch (uyh0pxs9m37in.getItemId()) {
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                    return true;
                }
                OJ3XxacXOT qr = new OJ3XxacXOT();
                qr.setArguments(arg);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        int idCurrencyCuenta;
        if (!validateClave() || !validateCuenta() || !validateMonto()) {
            return;
        }
        if ((this.agencia != R1sDOSqZ2z.BANDEC && !validateTipoMoneda()) || !validateTipoMonedaImporte()) {
            return;
        }
        if (this.spinnerPositionSelect == 0) {
            idCurrencyCuenta = 1;
        } else {
            idCurrencyCuenta = 2;
        }
        String agency = "0";
        switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
            case 1:
                agency = "01";
                break;
            case 2:
                agency = "02";
                break;
            case 3:
                agency = "03";
                break;
        }
        String pin = this.inputClave.getText().toString().trim();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        if (this.aux.contains("11200301")) {
            String cadena = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.moneda + "*" + this.noProveedor + "*0";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            FBsQzP3Zfj.actionCallUSSDNOBack(this.context, this.activity, "30", cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
            return;
        }
        String cadena2 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.moneda + "*" + this.noProveedor + "*" + this.aux;
        ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "30", cadena2, "¿Desea proceder con el pago?", group2, getFragmentManager());
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xf94v3SFEM$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputMonto.getText().toString().trim().isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        return true;
    }

    private boolean validateTipoMoneda() {
        if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMoneda);
            return false;
        }
        this.inputLayoutTipoMoneda.setErrorEnabled(false);
        return true;
    }

    private boolean validateTipoMonedaImporte() {
        if (this.spinnerTipoMonedaImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoMonedaImporte.setError("Seleccione el tipo de moneda");
            requestFocus(this.spinnerTipoMonedaImporte);
            return false;
        }
        this.inputLayoutTipoMonedaImporte.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void completarQR() {
        putData();
        try {
            if (getArguments() != null) {
                Bundle arg = getArguments();
                if (arg.containsKey("QRData")) {
                    String qrdata = arg.getString("QRData");
                    JSONCompleteFields(qrdata);
                    TEXTPLAINCompleteFields(qrdata);
                }
            }
        } catch (Exception ex) {
            Log.i("TRANSFER_ERROR", ex.getMessage());
        }
    }

    private void TEXTPLAINCompleteFields(String qrdata) {
        if (isTextPlainValid(qrdata)) {
            String[] parametros = qrdata.split(",");
            this.inputCuenta.setText(parametros[0]);
            float monto = Float.parseFloat(parametros[1]);
            this.inputMonto.setText(String.valueOf(monto));
            String moneda = parametros[2];
            if (moneda.contains("CUP") || moneda.contains("1")) {
                this.spinnerPositionSelect = 0;
                this.spinnerTipoMonedaImporte.setText("CUP");
            } else if (moneda.contains("CUC") || moneda.contains("2")) {
                this.spinnerPositionSelect = 1;
                this.spinnerTipoMonedaImporte.setText("CUC");
            }
            this.noProveedor = parametros[3];
            this.aux = parametros[4];
        }
    }

    private void JSONCompleteFields(String qrdata) {
        if (isJSONValid(qrdata)) {
            try {
                JSONObject jsonObj = new JSONObject(qrdata);
                if (jsonObj.has("id_transaccion")) {
                    this.inputCuenta.setText(String.valueOf(jsonObj.get("id_transaccion")));
                }
                if (jsonObj.has("importe")) {
                    double importe = Double.parseDouble(String.valueOf(jsonObj.get("importe")));
                    this.inputMonto.setText(String.valueOf(importe));
                }
                if (jsonObj.has("moneda")) {
                    String moneda = (String) jsonObj.get("moneda");
                    if (moneda.contains("CUP") || moneda.contains("1")) {
                        this.spinnerPositionSelect = 0;
                        this.spinnerTipoMonedaImporte.setText("CUP");
                    } else if (moneda.contains("CUC") || moneda.contains("2")) {
                        this.spinnerPositionSelect = 1;
                        this.spinnerTipoMonedaImporte.setText("CUC");
                    }
                }
                if (jsonObj.has("numero_proveedor")) {
                    this.noProveedor = String.valueOf(jsonObj.get("numero_proveedor"));
                }
                if (jsonObj.has("version")) {
                    String p = String.valueOf(jsonObj.get("version"));
                    if (!p.isEmpty()) {
                        this.aux = String.valueOf(jsonObj.get("version"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(this.context, "ERROR no es posible leer el Código QR.", 1);
            }
        }
    }

    public boolean isJSONValid(String jpo48jtycgtsp) {
        try {
            new JSONObject(jpo48jtycgtsp);
            return true;
        } catch (JSONException e) {
            try {
                new JSONArray(jpo48jtycgtsp);
                return true;
            } catch (JSONException e2) {
                return false;
            }
        }
    }

    public boolean isTextPlainValid(String jpo48jtycgtsp) {
        if (!jpo48jtycgtsp.contains("TRANSFERMOVIL_ETECSA") || !jpo48jtycgtsp.contains("PAGO_EXTERNO")) {
            return false;
        }
        try {
            String[] parametros = jpo48jtycgtsp.split(",");
            return parametros.length == 5;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateClave() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_empty_clve_banco));
            requestFocus(this.inputClave);
            return false;
        }
        if (this.inputClave.getText().toString().trim().length() != 4 && this.inputClave.getText().toString().trim().length() != 5) {
            this.inputLayoutClave.setError(getString(R.string.err_msg_len_clave_banco_mixto));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClave.setErrorEnabled(false);
        return true;
    }

    private void saveData() {
        U6ucOCBccJ.pmoneda = this.moneda;
        String p = this.inputClave.getText().toString().trim();
        U6ucOCBccJ.pdata = p;
    }

    private void putData() {
        try {
            int i = U6ucOCBccJ.pmoneda;
            this.moneda = i;
            String pin = U6ucOCBccJ.pdata;
            if (i == 1) {
                this.spinnerPositionSelect = 0;
                this.spinnerTipoMoneda.setText("CUP");
            } else if (i == 2) {
                this.spinnerPositionSelect = 1;
                this.spinnerTipoMoneda.setText("CUC");
            }
            if (pin.length() > 0) {
                this.inputClave.setText(pin);
            }
        } catch (Exception e) {
        }
    }

    public void finAPP() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", "hi");
        this.activity.setResult(-1, returnIntent);
        this.activity.finish();
    }

    private void showDialogCerrarApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("Solicitud enviada, debe retornar a la aplicación donde realizó la compra");
        builder.setPositiveButton("Retornar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xf94v3SFEM.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "ok");
                xf94v3SFEM.this.activity.setResult(-1, returnIntent);
                xf94v3SFEM.this.activity.finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
