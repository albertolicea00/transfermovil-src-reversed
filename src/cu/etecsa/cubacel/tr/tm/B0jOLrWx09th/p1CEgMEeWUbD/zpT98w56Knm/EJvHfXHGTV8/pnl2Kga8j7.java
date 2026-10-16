package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class pnl2Kga8j7 extends Agg55uYctq {
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public List<String> facList;
    public List<Factura> facturasLists;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    private EditText inputMonto;
    public int keyDel;
    public View rootView;
    public SpinnerDialog spinnerDialog;
    public final CharSequence[] itemsOpcion = {"Pago Total", "Pago Parcial"};
    public boolean pagoTotal = false;
    public ArrayList<String> items = new ArrayList<>();
    public String cuentaCaracteres = BuildConfig.FLAVOR;
    public boolean lock = false;
    private String current = BuildConfig.FLAVOR;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.n6pdizr7icbh4, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(0);
        this.facList = new ArrayList();
        for (Factura wl : this.facturasLists) {
            this.facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                pnl2Kga8j7.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (EditText) this.rootView.findViewById(R.id.input_monto);
        this.inputLayoutMonto.setHint(getString(R.string.monto_moneda_de_factura));
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.Metropolitano);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pnl2Kga8j7.this.submitForm();
            }
        });
        showDialogWithCheckBox();
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = pnl2Kga8j7.this.facturasLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(pnl2Kga8j7.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    pnl2Kga8j7.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    private void loadSearchSpinner() {
        try {
            List<Factura> list = this.facturasLists;
            if (list != null && list.size() > 0) {
                for (Factura uyh0pxs9m37in : this.facturasLists) {
                    String facura = uyh0pxs9m37in.getFactura();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getFactura();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getFactura();
                    }
                    this.items.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = pnl2Kga8j7.this.facturasLists.get(position);
                    pnl2Kga8j7.this.inputCuenta.setText(cuenta.getFactura());
                }
            });
        } catch (Exception e2) {
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String msg;
        super.submitForm();
        if (!validateCuenta() || !validateMonto() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monedaFactura = "NO ES POSIBLE IDENTIFICAR LA MONEDA";
        try {
            if (cuenta.charAt(2) == '1') {
                monedaFactura = "CUP";
            } else if (cuenta.charAt(2) == '2') {
                monedaFactura = "CUC";
            }
        } catch (Exception e) {
        }
        String monto = "0";
        String msg2 = "Desea realizar el pago total de la cuenta: " + cuenta;
        if (this.pagoTotal) {
            msg = msg2;
        } else {
            monto = this.inputMonto.getText().toString().trim();
            String msg3 = "¿ Desea pagar la cuenta: " + cuenta + ", con el monto: " + monto + " " + monedaFactura + " ?.";
            msg = msg3;
        }
        String cadena = cuenta + "*" + monto + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "42", "03", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "42", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 15 && this.inputCuenta.getText().toString().trim().length() != 14) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!this.inputCuenta.getText().toString().trim().substring(0, 2).contains("01")) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.inputMonto.getText().toString().trim().isEmpty()) {
                this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.inputMonto);
                return false;
            }
            this.inputLayoutMonto.setErrorEnabled(false);
            return true;
        }
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(0);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    private void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setSingleChoiceItems(this.itemsOpcion, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                pnl2Kga8j7.this.formVisibility(i);
            }
        });
        builder.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(true);
        alert.setCancelable(false);
        alert.show();
    }

    public void formVisibility(int opcion) {
        if (opcion != 0) {
            this.inputLayoutMonto.setEnabled(true);
            this.inputMonto.setEnabled(true);
            this.inputMonto.setVisibility(0);
            this.inputLayoutMonto.setVisibility(0);
            this.pagoTotal = false;
            return;
        }
        this.inputLayoutMonto.setEnabled(false);
        this.inputMonto.setEnabled(false);
        this.inputMonto.setVisibility(8);
        this.inputLayoutMonto.setVisibility(8);
        this.pagoTotal = true;
    }

    private void importeOnListeners() {
        this.inputMonto.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    pnl2Kga8j7.this.keyDel = 1;
                    return false;
                }
                return false;
            }
        });
        this.inputMonto.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.8
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                pnl2Kga8j7.this.inputMonto.setText("503");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void montoOnListeners() {
        this.inputMonto.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.9
            public String caracter = BuildConfig.FLAVOR;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });
        this.inputMonto.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.pnl2Kga8j7.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String first;
                if (s.toString().length() > 0 && !s.toString().equals(BuildConfig.FLAVOR)) {
                    pnl2Kga8j7.this.inputMonto.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[ ,.]", BuildConfig.FLAVOR);
                    double parsed = Double.parseDouble(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance().format(parsed / 100.0d).replaceAll("[ ,]", BuildConfig.FLAVOR);
                    if (formatted.contains("$")) {
                        StringTokenizer tokens = new StringTokenizer(formatted, "$");
                        first = tokens.nextToken();
                    } else if (formatted.contains("€")) {
                        StringTokenizer tokens2 = new StringTokenizer(formatted, "€");
                        first = tokens2.nextToken();
                    } else if (formatted.contains("£")) {
                        StringTokenizer tokens3 = new StringTokenizer(formatted, "£");
                        first = tokens3.nextToken();
                    } else if (formatted.contains("₤")) {
                        StringTokenizer tokens4 = new StringTokenizer(formatted, "₤");
                        first = tokens4.nextToken();
                    } else {
                        first = formatted.substring(1);
                    }
                    pnl2Kga8j7.this.inputMonto.setText(first);
                    pnl2Kga8j7.this.inputMonto.setSelection(first.length());
                    pnl2Kga8j7.this.inputMonto.addTextChangedListener(this);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private String formatoResultado(String digits) {
        if (digits.length() > 2) {
            String pound = digits.substring(0, digits.length() - 2);
            String pence = digits.substring(digits.length() - 2);
            String string = BuildConfig.FLAVOR + pound + "." + pence;
            return string;
        }
        if (digits.length() == 1) {
            String string2 = BuildConfig.FLAVOR + "0.0" + digits;
            return string2;
        }
        if (digits.length() != 2) {
            return BuildConfig.FLAVOR;
        }
        String string3 = BuildConfig.FLAVOR + "0." + digits;
        return string3;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }

    public class DecimalDigitsInputFilter implements InputFilter {
        public Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
            StringBuilder sb = new StringBuilder();
            sb.append("[0-9]{0,");
            sb.append(digitsBeforeZero - 1);
            sb.append("}+((\\.[0-9]{0,");
            sb.append(digitsAfterZero - 1);
            sb.append("})?)||(\\.)?");
            this.mPattern = Pattern.compile(sb.toString());
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher matcher = this.mPattern.matcher(dest);
            if (!matcher.matches()) {
                return BuildConfig.FLAVOR;
            }
            return null;
        }
    }
}
