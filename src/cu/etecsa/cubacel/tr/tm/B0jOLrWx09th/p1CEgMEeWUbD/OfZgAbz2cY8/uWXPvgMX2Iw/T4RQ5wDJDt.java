package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw;

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
import com.google.android.material.textfield.TextInputEditText;
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
public class T4RQ5wDJDt extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapterRegionPago;
    public ArrayAdapter<CharSequence> adapterTipoPago;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public List<String> facList;
    public List<Factura> facturasLists;
    public int idRegionPago;
    public int idTipo;
    public String importe;
    private AutoCompleteTextView inputCuenta;
    public TextInputEditText inputImporte;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutImporte;
    public TextInputLayout inputLayoutTipoPago;
    public TextInputLayout lyRegionPago;
    public jN13TOyLMX spRegionPago;
    public jN13TOyLMX spTipoPago;
    public SpinnerDialog spinnerDialog;
    public TextView title;
    public int bandera_varadero = 0;
    public ArrayList<String> items = new ArrayList<>();
    public jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            T4RQ5wDJDt t4RQ5wDJDt = T4RQ5wDJDt.this;
            int i = position + 1;
            t4RQ5wDJDt.idTipo = i;
            if (i == 2) {
                t4RQ5wDJDt.idTipo = 3;
                t4RQ5wDJDt.inputLayoutImporte.setVisibility(0);
            } else {
                t4RQ5wDJDt.inputLayoutImporte.setVisibility(8);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickRegionPago = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            T4RQ5wDJDt t4RQ5wDJDt = T4RQ5wDJDt.this;
            t4RQ5wDJDt.idRegionPago = position + 1;
            t4RQ5wDJDt.inputLayoutImporte.setVisibility(8);
            if (position == 0) {
                T4RQ5wDJDt t4RQ5wDJDt2 = T4RQ5wDJDt.this;
                t4RQ5wDJDt2.bandera_varadero = 0;
                t4RQ5wDJDt2.inputLayoutTipoPago.setVisibility(0);
                T4RQ5wDJDt t4RQ5wDJDt3 = T4RQ5wDJDt.this;
                t4RQ5wDJDt3.adapterTipoPago = ArrayAdapter.createFromResource(t4RQ5wDJDt3.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
                T4RQ5wDJDt t4RQ5wDJDt4 = T4RQ5wDJDt.this;
                t4RQ5wDJDt4.spTipoPago.setAdapter(t4RQ5wDJDt4.adapterTipoPago);
                return;
            }
            if (position == 1) {
                T4RQ5wDJDt t4RQ5wDJDt5 = T4RQ5wDJDt.this;
                t4RQ5wDJDt5.bandera_varadero = 0;
                t4RQ5wDJDt5.inputLayoutTipoPago.setVisibility(8);
                T4RQ5wDJDt t4RQ5wDJDt6 = T4RQ5wDJDt.this;
                t4RQ5wDJDt6.adapterTipoPago = ArrayAdapter.createFromResource(t4RQ5wDJDt6.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
                T4RQ5wDJDt t4RQ5wDJDt7 = T4RQ5wDJDt.this;
                t4RQ5wDJDt7.spTipoPago.setAdapter(t4RQ5wDJDt7.adapterTipoPago);
                return;
            }
            T4RQ5wDJDt.this.inputLayoutTipoPago.setVisibility(0);
            T4RQ5wDJDt t4RQ5wDJDt8 = T4RQ5wDJDt.this;
            t4RQ5wDJDt8.bandera_varadero = 1;
            t4RQ5wDJDt8.adapterTipoPago = ArrayAdapter.createFromResource(t4RQ5wDJDt8.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
            T4RQ5wDJDt t4RQ5wDJDt9 = T4RQ5wDJDt.this;
            t4RQ5wDJDt9.spTipoPago.setAdapter(t4RQ5wDJDt9.adapterTipoPago);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.btxx0bjgfahdh, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        this.importe = "0";
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(2);
        this.facList = new ArrayList();
        for (Factura wl : this.facturasLists) {
            this.facList.add(wl.getFactura());
        }
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.title = textView;
        textView.setText(R.string.title_pago_agua);
        this.lyRegionPago = (TextInputLayout) this.rootView.findViewById(R.id.lyRegionPago);
        this.spRegionPago = (jN13TOyLMX) this.rootView.findViewById(R.id.spRegionPago);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_agua_region, android.R.layout.simple_list_item_1);
        this.adapterRegionPago = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spRegionPago.setAdapter(this.adapterRegionPago);
        this.spRegionPago.setOnItemClickListener(this.spClickRegionPago);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputLayoutImporte = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutImporte);
        this.inputImporte = (TextInputEditText) this.rootView.findViewById(R.id.inputImporte);
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                T4RQ5wDJDt.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_pago);
        this.inputLayoutTipoPago = textInputLayout;
        textInputLayout.setVisibility(0);
        this.inputLayoutTipoPago.setHint("Tipo de pago");
        this.spTipoPago = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoPago);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
        this.adapterTipoPago = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTipoPago.setAdapter(this.adapterTipoPago);
        this.spTipoPago.setOnItemClickListener(this.spClickTipo);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                T4RQ5wDJDt.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = T4RQ5wDJDt.this.facturasLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(T4RQ5wDJDt.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    T4RQ5wDJDt.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateRegion() || !validateCuenta()) {
            return;
        }
        if (this.inputLayoutTipoPago.getVisibility() == 0 && !validateTipo()) {
            return;
        }
        if (this.idTipo == 3) {
            this.importe = this.inputImporte.getText().toString().trim();
            if (!validateMonto()) {
                return;
            }
        }
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String msg = "Desea pagar la cuenta del agua: " + cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        int i = this.idRegionPago;
        if (i == 1) {
            String cadena = this.idRegionPago + "*" + cuenta + "*" + this.importe + "*" + this.idTipo + "*0*" + this.cuentaOrigen;
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "19", cadena, msg, group, getFragmentManager());
                return;
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "19", "02", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
                return;
            }
        }
        if (i == 2) {
            String cadena2 = this.idRegionPago + "*" + cuenta + "*" + this.importe + "*" + this.idTipo + "*" + this.cuentaOrigen;
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "51", cadena2, msg, group, getFragmentManager());
                return;
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "51", "02", this.MAX_PARAMETERS_PQUETE, cadena2, msg, group, getFragmentManager());
                return;
            }
        }
        String cadena3 = this.idRegionPago + "*" + cuenta + "*" + this.importe + "*" + this.idTipo + "*0*" + this.cuentaOrigen;
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "21", cadena3, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "21", "02", this.MAX_PARAMETERS_PQUETE, cadena3, msg, group, getFragmentManager());
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

    private boolean validateTipo() {
        if (this.spTipoPago.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoPago.setError("Seleccione el tipo pago a ejecutar");
            requestFocus(this.spTipoPago);
            return false;
        }
        this.inputLayoutTipoPago.setErrorEnabled(false);
        return true;
    }

    private boolean validateRegion() {
        if (this.spRegionPago.getText().toString().trim().isEmpty()) {
            this.lyRegionPago.setError("Seleccione la región de pago");
            requestFocus(this.spRegionPago);
            return false;
        }
        this.lyRegionPago.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(2);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    private boolean validateMonto() {
        if (this.inputImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputImporte);
            return false;
        }
        try {
            Float.parseFloat(this.inputImporte.getText().toString().trim());
            this.inputLayoutImporte.setErrorEnabled(false);
            return true;
        } catch (Exception e) {
            this.inputLayoutImporte.setError("Monto incorrecto");
            requestFocus(this.inputImporte);
            return false;
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.T4RQ5wDJDt.6
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = T4RQ5wDJDt.this.facturasLists.get(position);
                    T4RQ5wDJDt.this.inputCuenta.setText(cuenta.getFactura());
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
