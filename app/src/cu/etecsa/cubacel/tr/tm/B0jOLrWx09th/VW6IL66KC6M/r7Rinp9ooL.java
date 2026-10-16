package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M;

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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.F1fDSmu2Acf;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.f9CS9TjtF3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r7Rinp9ooL extends LgiFGRpiEl {
    private static final int MAX_LENGHT = 130;
    private static final int MAX_LENGHT_ID = 15;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isDirectScan = false;
    public pAzq93vIl3 manager;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.k2sklwn5hsfmv, container, false);
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
        R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
        this.agencia = r1sDOSqZ2z;
        initComponentesCuentas(this.rootView, r1sDOSqZ2z);
        R1sDOSqZ2z r1sDOSqZ2z2 = this.agencia;
        R1sDOSqZ2z r1sDOSqZ2z3 = R1sDOSqZ2z.Metropolitano;
        if (r1sDOSqZ2z2 == r1sDOSqZ2z3) {
            this.inputLayoutClave.setHint(getString(R.string.pin_tarjeta_telebanca));
        }
        R1sDOSqZ2z r1sDOSqZ2z4 = this.agencia;
        if (r1sDOSqZ2z4 == r1sDOSqZ2z3 || r1sDOSqZ2z4 == R1sDOSqZ2z.BPA) {
            InputFilter[] fArray = {new InputFilter.LengthFilter(4)};
            this.inputClave.setFilters(fArray);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r7Rinp9ooL.this.submitForm();
            }
        });
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
        int idCurrencyCuenta;
        String movilConfirmar;
        int idCurrencyCuenta2;
        String movilConfirmar2;
        String cadena;
        super.submitForm();
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
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
        if (!validateSelectionAccounts() || !validateTipoMonedaImporte()) {
            return;
        }
        int idCurrencyCuenta3 = 1;
        int i = this.spinnerPositionSelect;
        if (i == 0) {
            idCurrencyCuenta3 = 1;
        } else if (i == 1) {
            idCurrencyCuenta3 = 2;
        } else if (i == 2) {
            idCurrencyCuenta3 = 3;
        }
        String agency = "0";
        switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
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
        if (this.tipoQR != f9CS9TjtF3.ESTATICO) {
            if (this.aux.contains("11200301")) {
                if (this.isEnviarAuxDat) {
                    String movilConfirmar3 = "0000";
                    if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                        movilConfirmar3 = this.txPhoneConfirm.getText().toString().trim();
                    }
                    cadena = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta3 + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*0*" + this.cuentaOrigen + "*" + movilConfirmar3;
                } else {
                    cadena = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta3 + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*0*" + this.cuentaOrigen;
                }
                ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                if (!this.isPartialUSSD) {
                    FBsQzP3Zfj.actionCallUSSDNOBack(this.context, this.activity, "30", cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
                } else {
                    this.manager.principalEnviarUSSD(this.context, "110", "30", agency, this.MAX_PARAMETERS_PQUETE, cadena, "¿Desea proceder con el pago?", group, getFragmentManager());
                }
                return;
            }
            int idCurrencyCuenta4 = idCurrencyCuenta3;
            ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
            U6ucOCBccJ.pmoneda = 0;
            U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
            if (this.isEnviarAuxDat) {
                String movilConfirmar4 = "0";
                if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                    movilConfirmar4 = this.txPhoneConfirm.getText().toString().trim();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(agency);
                sb.append("*");
                sb.append(pin);
                sb.append("*");
                sb.append(cuenta);
                sb.append("*");
                sb.append(monto);
                sb.append("*");
                idCurrencyCuenta2 = idCurrencyCuenta4;
                sb.append(idCurrencyCuenta2);
                sb.append("*");
                sb.append(this.monedaTarjeta);
                sb.append("*");
                sb.append(this.noProveedor);
                sb.append("*");
                sb.append(this.aux);
                sb.append("*");
                sb.append(this.cuentaOrigen);
                sb.append("*");
                sb.append(movilConfirmar4);
                String cadena2 = sb.toString();
                if (FBsQzP3Zfj.callLenght(this.context, cadena2) >= MAX_LENGHT) {
                    if (cuenta.length() > 15) {
                        cuenta = cuenta.substring(cuenta.length() - 15);
                    }
                    cadena2 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta2 + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen + "*" + movilConfirmar4;
                    Log.d("TMDESA", "FINAL CUT USSD[" + cadena2 + "] LENGHT[" + cadena2.length() + "]");
                }
                movilConfirmar2 = cadena2;
            } else {
                idCurrencyCuenta2 = idCurrencyCuenta4;
                String cadena3 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta2 + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen;
                if (FBsQzP3Zfj.callLenght(this.context, cadena3) < MAX_LENGHT) {
                    movilConfirmar2 = cadena3;
                } else {
                    if (cuenta.length() > 15) {
                        cuenta = cuenta.substring(cuenta.length() - 15);
                    }
                    String cadena4 = agency + "*" + pin + "*" + cuenta + "*" + monto + "*" + idCurrencyCuenta2 + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + this.cuentaOrigen;
                    Log.d("TMDESA", "FINAL CUT USSD[" + cadena4 + "] LENGHT[" + cadena4.length() + "]");
                    movilConfirmar2 = cadena4;
                }
            }
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "30", movilConfirmar2, "¿Desea proceder con el pago?", group2, getFragmentManager());
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "30", agency, this.MAX_PARAMETERS_PQUETE, movilConfirmar2, "¿Desea proceder con el pago?", group2, getFragmentManager());
            }
            return;
        }
        int idCurrencyCuenta5 = idCurrencyCuenta3;
        String monto2 = this.txStImporte.getText().toString().trim();
        if (this.txDescripcion.getText().toString().isEmpty()) {
            descripcion = "0000";
        } else {
            String descripcion2 = this.txDescripcion.getText().toString().trim();
            descripcion = descripcion2;
        }
        ViewGroup group3 = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        if (this.isEnviarAuxDat) {
            String movilConfirmar5 = "0";
            if (this.txPhoneConfirm.getText().toString().trim().length() > 0) {
                movilConfirmar5 = this.txPhoneConfirm.getText().toString().trim();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(agency);
            sb2.append("*");
            sb2.append(pin);
            sb2.append("*");
            sb2.append(cuenta);
            sb2.append("*");
            sb2.append(monto2);
            sb2.append("*");
            idCurrencyCuenta = idCurrencyCuenta5;
            sb2.append(idCurrencyCuenta);
            sb2.append("*");
            sb2.append(this.monedaTarjeta);
            sb2.append("*");
            sb2.append(this.noProveedor);
            sb2.append("*");
            sb2.append(this.aux);
            sb2.append("*");
            sb2.append(descripcion);
            sb2.append("*");
            sb2.append(this.cuentaOrigen);
            sb2.append("*");
            sb2.append(movilConfirmar5);
            sb2.append("*");
            sb2.append(this.idQR);
            String cadena5 = sb2.toString();
            if (FBsQzP3Zfj.callLenght(this.context, cadena5) >= MAX_LENGHT) {
                if (cuenta.length() > 15) {
                    cuenta = cuenta.substring(cuenta.length() - 15);
                }
                cadena5 = agency + "*" + pin + "*" + cuenta + "*" + monto2 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*" + this.cuentaOrigen + "*" + movilConfirmar5 + "*" + this.idQR;
                Log.d("TMDESA", "FINAL CUT USSD[" + cadena5 + "] LENGHT[" + cadena5.length() + "]");
            }
            movilConfirmar = cadena5;
        } else {
            idCurrencyCuenta = idCurrencyCuenta5;
            String cadena6 = agency + "*" + pin + "*" + cuenta + "*" + monto2 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*" + this.cuentaOrigen;
            if (FBsQzP3Zfj.callLenght(this.context, cadena6) < MAX_LENGHT) {
                movilConfirmar = cadena6;
            } else {
                if (cuenta.length() > 8) {
                    cuenta = cuenta.substring(cuenta.length() - 8);
                }
                String cadena7 = agency + "*" + pin + "*" + cuenta + "*" + monto2 + "*" + idCurrencyCuenta + "*" + this.monedaTarjeta + "*" + this.noProveedor + "*" + this.aux + "*" + descripcion + "*" + this.cuentaOrigen;
                Log.d("TMDESA", "FINAL CUT USSD[" + cadena7 + "] LENGHT[" + cadena7.length() + "]");
                movilConfirmar = cadena7;
            }
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "31", movilConfirmar, "¿Desea proceder con el pago?", group3, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "31", agency, this.MAX_PARAMETERS_PQUETE, movilConfirmar, "¿Desea proceder con el pago?", group3, getFragmentManager());
        }
    }

    private void tratarQREstatico() {
    }

    private boolean validateLongitudDescripcion() {
        if (!this.txDescripcion.getText().toString().trim().isEmpty()) {
            String descripcion = this.txDescripcion.getText().toString().trim();
            Pattern pattern = Pattern.compile("^[0-9]*$");
            Matcher matcher = pattern.matcher(descripcion);
            if (matcher.matches()) {
                if (descripcion.length() <= 11) {
                    this.lyLayoutDescripcion.setError("Logitud maxima debe ser de menor o igual de 11 digitos");
                    requestFocus(this.txDescripcion);
                    return false;
                }
                this.lyLayoutDescripcion.setErrorEnabled(false);
            } else {
                if (descripcion.length() <= 6) {
                    this.lyLayoutDescripcion.setError("Logitud maxima debe ser de menor o igual de 6 caracteres");
                    requestFocus(this.txDescripcion);
                    return false;
                }
                this.lyLayoutDescripcion.setErrorEnabled(false);
            }
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
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
        String montoStr = this.inputMonto.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.inputLayoutMonto.setError("No se permiten ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.inputLayoutMonto.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.inputLayoutMonto.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.inputMonto);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
            requestFocus(this.inputMonto);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.inputLayoutMonto.setError("El monto debe ser mayor a 0");
                requestFocus(this.inputMonto);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.inputLayoutMonto.setError("Monto inválido");
            requestFocus(this.inputMonto);
            return false;
        }
    }

    private boolean validateImporteEscrito() {
        String montoStr = this.txStImporte.getText().toString().trim();
        if (montoStr.isEmpty()) {
            this.lyStImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.matches("^0[0-9]+.*$") && !montoStr.matches("^0\\.[0-9]+$")) {
            this.lyStImporte.setError("No se permiten ceros a la izquierda");
            requestFocus(this.txStImporte);
            return false;
        }
        if (!montoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
            this.lyStImporte.setError("Formato de monto inválido");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.matches("^0+[1-9]+\\.$")) {
            this.lyStImporte.setError("Formato inválido. Use un número válido sin ceros a la izquierda");
            requestFocus(this.txStImporte);
            return false;
        }
        if (!montoStr.matches("^\\d+$") && !montoStr.matches("^\\d+\\.\\d{1,2}$") && !montoStr.matches("^0\\.[0-9]{1,2}$")) {
            this.lyStImporte.setError("Formato de monto inválido. Use enteros o decimales con hasta 2 dígitos");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.endsWith(".")) {
            this.lyStImporte.setError("Formato inválido. Use un número válido (ej: 10 o 10.50)");
            requestFocus(this.txStImporte);
            return false;
        }
        if (montoStr.equals("0") || montoStr.equals("0.")) {
            this.lyStImporte.setError("El monto debe ser mayor a 0");
            requestFocus(this.txStImporte);
            return false;
        }
        try {
            BigDecimal monto = new BigDecimal(montoStr);
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                this.lyStImporte.setError("El monto debe ser mayor a 0");
                requestFocus(this.txStImporte);
                return false;
            }
            if (monto.scale() > 2) {
                this.lyStImporte.setError("Solo se permiten hasta 2 decimales");
                requestFocus(this.txStImporte);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            this.lyStImporte.setError("Monto inválido");
            requestFocus(this.txStImporte);
            return false;
        }
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl
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
        String cuenta = BuildConfig.FLAVOR;
        U6ucOCBccJ.pmoneda = this.monedaTarjeta;
        String p = this.inputClave.getText().toString().trim();
        U6ucOCBccJ.pdata = p;
        jceCwl8l2R jcecwl8l2r = this.seleccionCuenta;
        U6ucOCBccJ.pseleccionCuenta = jcecwl8l2r;
        switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jcecwl8l2r.ordinal()]) {
            case 1:
                if (validateCuentaSpOrigen()) {
                    cuenta = this.miCuentaSeleccion;
                    U6ucOCBccJ.pTextoSpMisCuentas = this.spinnerMisCuentas.getText().toString();
                }
                break;
            case 2:
                cuenta = this.inputCuentaWrite.getText().toString().trim();
                if (this.cuentaOrigen.contains("-")) {
                    cuenta = this.cuentaOrigen.replace("-", BuildConfig.FLAVOR);
                }
                break;
        }
        U6ucOCBccJ.pcuenta = cuenta;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R;

        static {
            int[] iArr = new int[jceCwl8l2R.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R = iArr;
            try {
                iArr[jceCwl8l2R.MIS_CUENTAS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[jceCwl8l2R.NUEVA_CUENTA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr2;
            try {
                iArr2[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void putData() {
        try {
            int i = U6ucOCBccJ.pmoneda;
            this.monedaTarjeta = i;
            String pin = U6ucOCBccJ.pdata;
            jceCwl8l2R seleccion = U6ucOCBccJ.pseleccionCuenta;
            String str = U6ucOCBccJ.pcuenta;
            if (i == 1) {
                this.spinnerPositionSelect = 0;
                this.spinnerTipoMoneda.setText("CUP");
            } else if (i == 2) {
                this.spinnerPositionSelect = 1;
                this.spinnerTipoMoneda.setText("CUC");
            } else if (i == 3) {
                this.spinnerPositionSelect = 2;
                this.spinnerTipoMoneda.setText("USD");
            }
            if (pin.length() > 0) {
                this.inputClave.setText(pin);
            }
            switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$jceCwl8l2R[seleccion.ordinal()]) {
                case 1:
                    this.monedaTarjeta = 0;
                    this.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                    this.inputLayoutMisCuentas.setVisibility(0);
                    this.inputLayoutCuentaWrite.setVisibility(8);
                    this.miCuentaSeleccion = U6ucOCBccJ.pcuenta;
                    this.spinnerTipoMoneda.setText("-MIS CUENTAS-");
                    break;
                case 2:
                    this.monedaTarjeta = 0;
                    this.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    this.inputLayoutMisCuentas.setVisibility(8);
                    this.inputLayoutCuentaWrite.setVisibility(0);
                    this.mcBankArrayAdapter = null;
                    this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    this.cuentaOrigen = U6ucOCBccJ.pcuenta;
                    this.spinnerTipoMoneda.setText("-INSERTAR CUENTA-");
                    this.inputCuentaWrite.setText(this.cuentaOrigen);
                    break;
                default:
                    this.seleccionCuenta = jceCwl8l2R.MONEDA;
                    this.inputLayoutMisCuentas.setVisibility(8);
                    this.inputLayoutCuentaWrite.setVisibility(8);
                    this.mcBankArrayAdapter = null;
                    this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        } catch (Exception e) {
        }
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
