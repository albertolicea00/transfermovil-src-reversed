package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yiqT29TYTb extends Agg55uYctq {
    private ArrayAdapter<CharSequence> adapterTipoPago;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public List<String> facList;
    public List<Factura> facturasLists;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout lyTipoPago;
    private jN13TOyLMX spTipoPago;
    public SpinnerDialog spinnerDialog;
    public TextView title;
    private int idTipoPago = 0;
    public ArrayList<String> items = new ArrayList<>();
    public jN13TOyLMX.OnItemClickListener spClickTipoPago = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            yiqT29TYTb.this.idTipoPago = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.z8grbrod1gsgx, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(3);
        this.facList = new ArrayList();
        for (Factura wl : this.facturasLists) {
            this.facList.add(wl.getFactura());
        }
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.title = textView;
        textView.setText("Pago del Gas");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoPago);
        this.lyTipoPago = textInputLayout;
        textInputLayout.setVisibility(0);
        this.spTipoPago = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoPago);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_gas_tipo_pago, android.R.layout.simple_list_item_1);
        this.adapterTipoPago = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTipoPago.setAdapter(this.adapterTipoPago);
        this.spTipoPago.setOnItemClickListener(this.spClickTipoPago);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                yiqT29TYTb.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.Metropolitano);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                yiqT29TYTb.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = yiqT29TYTb.this.facturasLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(yiqT29TYTb.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    yiqT29TYTb.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String msg = "Desea pagar la cuenta del gas: " + cuenta;
        String cadena = cuenta + "*0*" + this.monedaTarjeta + "*" + this.idTipoPago + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "67", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "67", "03", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 12) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_12_metro));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(3);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.yiqT29TYTb.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = yiqT29TYTb.this.facturasLists.get(position);
                    yiqT29TYTb.this.inputCuenta.setText(cuenta.getFactura());
                }
            });
        } catch (Exception e2) {
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
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
