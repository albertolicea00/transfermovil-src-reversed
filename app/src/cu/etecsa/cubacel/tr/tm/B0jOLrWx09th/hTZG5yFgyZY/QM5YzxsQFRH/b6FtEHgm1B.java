package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.F1fDSmu2Acf;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.f9CS9TjtF3;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b6FtEHgm1B extends LgiFGRpiEl {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    private TextInputLayout lyBolsas;
    public pAzq93vIl3 manager;
    public List<MCBank> misCuentas;
    public jN13TOyLMX spBolsas;
    public int tipoBolsa = 0;
    public boolean seleccionTransferencia = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.b6FtEHgm1B.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            b6FtEHgm1B b6ftehgm1b = b6FtEHgm1B.this;
            b6ftehgm1b.tipoBolsa = position + 1;
            switch (position) {
                case 2:
                    if (!b6ftehgm1b.cargarMisCuentas()) {
                        b6FtEHgm1B.this.showDialogNoTieneCuentas();
                        b6FtEHgm1B.this.inputLayoutMisCuentas.setVisibility(8);
                        b6FtEHgm1B.this.seleccionTransferencia = false;
                    } else {
                        b6FtEHgm1B b6ftehgm1b2 = b6FtEHgm1B.this;
                        b6ftehgm1b2.seleccionTransferencia = true;
                        b6ftehgm1b2.inputLayoutMisCuentas.setVisibility(0);
                    }
                    break;
                default:
                    b6ftehgm1b.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    b6FtEHgm1B b6ftehgm1b3 = b6FtEHgm1B.this;
                    b6ftehgm1b3.seleccionTransferencia = false;
                    b6ftehgm1b3.inputLayoutMisCuentas.setVisibility(8);
                    b6FtEHgm1B.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickMisCuentas = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.b6FtEHgm1B.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            MCBank mcBank = (MCBank) b6FtEHgm1B.this.mcBankArrayAdapter.getItem(position);
            b6FtEHgm1B.this.miCuentaSeleccion = mcBank.getCuenta();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.s4livgswznoyfr, container, false);
        this.context = container.getContext();
        this.activity = getActivity();
        this.manager = new pAzq93vIl3(this.context, this);
        initComponents();
        this.isShareQR = false;
        this.inputLayoutClave = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_clave);
        this.inputClave = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_clave);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_notransaccion);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_notransaccion);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.txTitulo = (TextView) this.rootView.findViewById(R.id.txTitulo);
        this.lyStImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_stimporte);
        this.txStImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_stimporte);
        this.lyLayoutDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_descripcion);
        this.txDescripcion = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_descripcion);
        this.tipoQR = f9CS9TjtF3.DINAMICO;
        this.lyStImporte.setVisibility(8);
        this.lyLayoutDescripcion.setVisibility(8);
        this.txTitulo.setVisibility(8);
        ((LgiFGRpiEl) this).tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMonedaImporte = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMonedaImporte = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerMonedaTransaccion);
        Bundle arg = getArguments();
        this.agencia = R1sDOSqZ2z.CLASICAEMP;
        InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
        this.inputClave.setFilters(fArray);
        if (arg.containsKey("APK_VALUE")) {
            String qrdata = arg.getString("APK_VALUE");
            JSONCompleteFields(qrdata);
            TEXTPLAINCompleteFields(qrdata);
            putData();
        }
        completarQR();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.b6FtEHgm1B.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b6FtEHgm1B.this.submitForm();
            }
        });
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_mas_mis_cuentas, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        this.spinnerMisCuentas = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCuentas);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input_layout_mis_cuentas);
        this.inputLayoutMisCuentas = textInputLayout;
        textInputLayout.setVisibility(8);
        if (getArguments() != null && getArguments().containsKey("returning_to_a")) {
            try {
                this.isDirectScan = getArguments().getBoolean("returning_to_a");
            } catch (Exception e) {
            }
        }
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem uyh0pxs9m37in = menu.findItem(R.id.qrsgen);
        uyh0pxs9m37in.setVisible(false);
        MenuItem itemCargarLink = menu.findItem(R.id.itemCargarLink);
        itemCargarLink.setVisible(true);
        MenuItem itemShare = menu.findItem(R.id.qrshare);
        itemShare.setVisible(true);
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
            case R.id.itemCargarLink /* 2131297006 */:
                showLinkDialog();
                return true;
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                } else {
                    OJ3XxacXOT qr = new OJ3XxacXOT();
                    qr.setArguments(arg);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                }
                return true;
            case R.id.qrshare /* 2131297281 */:
                if (this.isShareQR.booleanValue()) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction("android.intent.action.SEND");
                    sendIntent.putExtra("android.intent.extra.TEXT", "He compartido con usted desde Transfermóvil un link para la compra en línea: " + this.dataSendQR + " ");
                    sendIntent.setType("text/plain");
                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                } else {
                    Toast.makeText(this.context, "QR vacio o incompleto.", 1).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String descripcion;
        String cadena;
        String cadena2;
        String cadena3;
        String cadena4;
        boolean isPartialUSSD = false;
        try {
            isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!validateClave() || !validateCuenta()) {
            return;
        }
        if (this.tipoQR == f9CS9TjtF3.DINAMICO) {
            if (!validateMonto()) {
                return;
            }
        } else if (!validateImporteEscrito()) {
            return;
        }
        if (!validateSpBolsa()) {
            return;
        }
        if ((this.seleccionTransferencia && !validateCuentaOrigen()) || !validateTipoMonedaImporte()) {
            return;
        }
        int idCurrencyCuenta = 1;
        int i = this.spinnerPositionSelect;
        if (i == 0) {
            idCurrencyCuenta = 1;
        } else if (i == 1) {
            idCurrencyCuenta = 2;
        } else if (i == 2) {
            idCurrencyCuenta = 3;
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
            case 4:
                agency = "04";
                break;
        }
        String pin = this.inputClave.getText().toString().trim();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monto = this.inputMonto.getText().toString().trim();
        if (this.tipoQR == f9CS9TjtF3.ESTATICO) {
            String monto2 = this.txStImporte.getText().toString().trim();
            if (this.txDescripcion.getText().toString().isEmpty()) {
                descripcion = "0000";
            } else {
                String descripcion2 = this.txDescripcion.getText().toString().trim();
                descripcion = descripcion2;
            }
            if (this.isEnviarAuxDat) {
                String movilConfirmar = "0000";
                if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                    movilConfirmar = this.txPhoneConfirm.getText().toString().trim();
                }
                cadena = agency + "*" + pin + "*" + cuenta + "*" + monto2 + "*" + idCurrencyCuenta + "*" + this.tipoBolsa + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*0000*" + movilConfirmar + "*" + this.idQR;
            } else {
                cadena = agency + "*" + pin + "*" + cuenta + "*" + monto2 + "*" + idCurrencyCuenta + "*" + this.tipoBolsa + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*0000";
            }
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            if (this.miCuentaSeleccion.isEmpty()) {
                cadena2 = cadena;
            } else {
                cadena2 = cadena + "*" + this.miCuentaSeleccion;
            }
            Log.i("CADENATM", cadena2);
            if (!isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "31", cadena2, "¿Desea proceder con el pago?", group, getFragmentManager());
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "31", agency, this.MAX_PARAMETERS_PQUETE, cadena2, "¿Desea proceder con el pago?", group, getFragmentManager());
            }
            return;
        }
        if (this.aux.contains("11200301")) {
            if (this.isEnviarAuxDat) {
                String movilConfirmar2 = "0000";
                if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                    movilConfirmar2 = this.txPhoneConfirm.getText().toString().trim();
                }
                String cadena5 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.tipoBolsa + "*" + this.noProveedor + "*0*0000*" + movilConfirmar2;
                cadena4 = cadena5;
            } else {
                String cadena6 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + this.tipoBolsa + "*" + this.noProveedor + "*0*0000";
                cadena4 = cadena6;
            }
            ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            Log.i("CADENATM", cadena4);
            FBsQzP3Zfj.actionCallUSSDNOBack(this.context, this.activity, "30", cadena4, "¿Desea proceder con el pago?", group2, getFragmentManager());
        } else {
            if (this.isEnviarAuxDat) {
                String movilConfirmar3 = "0000";
                if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                    movilConfirmar3 = this.txPhoneConfirm.getText().toString().trim();
                }
                cadena3 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + String.valueOf(this.tipoBolsa) + "*" + this.noProveedor + "*" + this.aux + "*0000*" + movilConfirmar3;
                String cadena7 = this.miCuentaSeleccion;
                if (!cadena7.isEmpty()) {
                    cadena3 = cadena3 + "*" + this.miCuentaSeleccion;
                }
            } else {
                cadena3 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta + "*" + String.valueOf(this.tipoBolsa) + "*" + this.noProveedor + "*" + this.aux + "*0000";
                String cadena8 = this.miCuentaSeleccion;
                if (!cadena8.isEmpty()) {
                    cadena3 = cadena3 + "*0*" + this.miCuentaSeleccion;
                }
            }
            ViewGroup group3 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            Log.i("CADENATM", cadena3);
            if (!isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "30", cadena3, "¿Desea proceder con el pago?", group3, getFragmentManager());
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "30", agency, this.MAX_PARAMETERS_PQUETE, cadena3, "¿Desea proceder con el pago?", group3, getFragmentManager());
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.b6FtEHgm1B$4, reason: invalid class name */
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
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
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

    private boolean validateImporteEscrito() {
        if (this.txStImporte.getText().toString().trim().isEmpty()) {
            this.lyStImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txStImporte);
            return false;
        }
        return true;
    }

    private boolean validateTipoMonedaImporte() {
        return true;
    }

    private boolean validateCuentaOrigen() {
        if (this.spinnerMisCuentas.getText().toString().trim().isEmpty()) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        if (this.miCuentaSeleccion.length() != 16) {
            this.inputLayoutMisCuentas.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.spinnerMisCuentas);
            return false;
        }
        this.inputLayoutMisCuentas.setErrorEnabled(false);
        return true;
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
        } catch (Exception e) {
        }
    }

    private void TEXTPLAINCompleteFields(String qrdata) {
        if (isTextPlainValid(qrdata)) {
            this.dataSendQR = BuildConfig.FLAVOR;
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
            } else if (moneda.contains("USD") || moneda.contains("3")) {
                this.spinnerPositionSelect = 2;
                this.spinnerTipoMonedaImporte.setText("USD");
            }
            this.noProveedor = parametros[3];
            this.aux = parametros[4];
            this.dataSendQR = this.DEEP_LINK_URL + String.format("id_transaccion=%s&importe=%f&moneda=%s&numero_proveedor=%d", parametros[0], Float.valueOf(monto), moneda, this.noProveedor);
            this.isShareQR = true;
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
        String p = this.inputClave.getText().toString().trim();
        U6ucOCBccJ.pdata = p;
        U6ucOCBccJ.pcuenta = BuildConfig.FLAVOR;
    }

    private void putData() {
    }

    private void showLinkDialog() {
        DialogFragment dialogFrag = new F1fDSmu2Acf();
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String dataLink;
        if (requestCode == 1 && resultCode == 1) {
            try {
                String dataLink2 = data.getStringExtra("link");
                if (isJSONValid(dataLink2)) {
                    JSONCompleteFields(dataLink2);
                    putData();
                } else {
                    List<String> list = extractUrls(dataLink2);
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                dataLink2 = list.get(0);
                            }
                        } catch (Exception e) {
                            dataLink = data.getStringExtra("link");
                        }
                    }
                    dataLink = dataLink2;
                    if (dataLink != null && dataLink.length() > 0 && ((dataLink.contains("https") && dataLink.contains("transfermovil")) || dataLink.contains("transfermovil://tm_compra_en_linea/action"))) {
                        Uri dataURI = Uri.parse(dataLink);
                        String id_transaccion = dataURI.getQueryParameter("id_transaccion");
                        String importe = dataURI.getQueryParameter("importe");
                        String moneda = dataURI.getQueryParameter("moneda");
                        String numero_proveedor = dataURI.getQueryParameter("numero_proveedor");
                        JSONObject obj = new JSONObject();
                        String importe2 = importe.replace(",", ".");
                        try {
                            obj.put("id_transaccion", id_transaccion);
                            obj.put("importe", new Double(importe2));
                            try {
                                obj.put("moneda", moneda);
                                try {
                                    obj.put("numero_proveedor", new Integer(numero_proveedor));
                                    obj.put("version", BuildConfig.FLAVOR);
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                }
                            } catch (JSONException e3) {
                                e = e3;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                        }
                        JSONCompleteFields(obj.toString());
                        putData();
                    } else {
                        Toast.makeText(this.context, "Enlace incorrecto", 0).show();
                    }
                }
            } catch (Exception e5) {
                Toast.makeText(this.context, "Enlace incorrecto", 0).show();
            }
        }
        if (requestCode == 1 && data != null) {
            Uri data2 = data.getData();
            this.contactUri = data2;
            renderContact(data2);
        }
    }

    public static List<String> extractUrls(String text) {
        List<String> containedUrls = new ArrayList<>();
        Pattern pattern = Pattern.compile("((https):((//transfermovil.app/action?))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", 2);
        Matcher urlMatcher = pattern.matcher(text);
        while (urlMatcher.find()) {
            containedUrls.add(text.substring(urlMatcher.start(0), urlMatcher.end(0)));
        }
        return containedUrls;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(R1sDOSqZ2z.MiTransfer);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.misCuentas = list;
            this.mcBankArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (MCBank uyh0pxs9m37in : list) {
                this.mcBankArrayAdapter.add(uyh0pxs9m37in);
            }
            this.mcBankArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerMisCuentas.setAdapter(this.mcBankArrayAdapter);
            this.spinnerMisCuentas.setOnItemClickListener(this.spClickMisCuentas);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
