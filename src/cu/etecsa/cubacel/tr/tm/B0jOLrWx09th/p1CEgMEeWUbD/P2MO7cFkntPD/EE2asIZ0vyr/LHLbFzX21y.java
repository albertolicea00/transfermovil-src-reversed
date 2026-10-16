package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LHLbFzX21y extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapterRegionPago;
    public ArrayAdapter<CharSequence> adapterTipoPago;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public List<String> facList;
    public List<Factura> facturasLists;
    public int idRegionPago;
    public int idTipoPago;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout lyMonto;
    public TextInputLayout lyRegionPago;
    public TextInputLayout lyTipoPago;
    public jN13TOyLMX spRegionPago;
    public jN13TOyLMX spTipoPago;
    public SpinnerDialog spinnerDialog;
    public TextView titulo;
    private EditText txMonto;
    public int bandera_varadero = 0;
    public ArrayList<String> items = new ArrayList<>();
    public float importe = 0.0f;
    public jN13TOyLMX.OnItemClickListener spClickRegionPago = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            LHLbFzX21y lHLbFzX21y = LHLbFzX21y.this;
            lHLbFzX21y.idRegionPago = position + 1;
            lHLbFzX21y.lyMonto.setVisibility(8);
            LHLbFzX21y lHLbFzX21y2 = LHLbFzX21y.this;
            lHLbFzX21y2.importe = 0.0f;
            if (position == 0) {
                lHLbFzX21y2.bandera_varadero = 0;
                lHLbFzX21y2.lyTipoPago.setVisibility(0);
                LHLbFzX21y lHLbFzX21y3 = LHLbFzX21y.this;
                lHLbFzX21y3.adapterTipoPago = ArrayAdapter.createFromResource(lHLbFzX21y3.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
                LHLbFzX21y lHLbFzX21y4 = LHLbFzX21y.this;
                lHLbFzX21y4.spTipoPago.setAdapter(lHLbFzX21y4.adapterTipoPago);
                return;
            }
            if (position == 2) {
                lHLbFzX21y2.bandera_varadero = 1;
                lHLbFzX21y2.lyTipoPago.setVisibility(0);
                LHLbFzX21y lHLbFzX21y5 = LHLbFzX21y.this;
                lHLbFzX21y5.adapterTipoPago = ArrayAdapter.createFromResource(lHLbFzX21y5.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
                LHLbFzX21y lHLbFzX21y6 = LHLbFzX21y.this;
                lHLbFzX21y6.spTipoPago.setAdapter(lHLbFzX21y6.adapterTipoPago);
                return;
            }
            lHLbFzX21y2.bandera_varadero = 0;
            lHLbFzX21y2.lyTipoPago.setVisibility(8);
            LHLbFzX21y lHLbFzX21y7 = LHLbFzX21y.this;
            lHLbFzX21y7.adapterTipoPago = ArrayAdapter.createFromResource(lHLbFzX21y7.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
            LHLbFzX21y lHLbFzX21y8 = LHLbFzX21y.this;
            lHLbFzX21y8.spTipoPago.setAdapter(lHLbFzX21y8.adapterTipoPago);
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickTipoPago = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            LHLbFzX21y lHLbFzX21y = LHLbFzX21y.this;
            if (lHLbFzX21y.bandera_varadero == 0) {
                int i = position + 1;
                lHLbFzX21y.idTipoPago = i;
                if (i != 2) {
                    lHLbFzX21y.lyMonto.setVisibility(8);
                    return;
                } else {
                    lHLbFzX21y.idTipoPago = 3;
                    lHLbFzX21y.lyMonto.setVisibility(0);
                    return;
                }
            }
            int i2 = position + 1;
            lHLbFzX21y.idTipoPago = i2;
            if (i2 == 2) {
                lHLbFzX21y.lyMonto.setVisibility(0);
            } else {
                lHLbFzX21y.lyMonto.setVisibility(8);
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.mupc307hzj3de, container, false);
        this.context = container.getContext();
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.titulo = textView;
        textView.setText(R.string.title_pago_agua);
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(2);
        this.facList = new ArrayList();
        for (Factura wl : this.facturasLists) {
            this.facList.add(wl.getFactura());
        }
        this.lyRegionPago = (TextInputLayout) this.rootView.findViewById(R.id.lyRegionPago);
        this.spRegionPago = (jN13TOyLMX) this.rootView.findViewById(R.id.spRegionPago);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_agua_region, android.R.layout.simple_list_item_1);
        this.adapterRegionPago = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spRegionPago.setAdapter(this.adapterRegionPago);
        this.spRegionPago.setOnItemClickListener(this.spClickRegionPago);
        this.lyTipoPago = (TextInputLayout) this.rootView.findViewById(R.id.lyTipoPago);
        this.spTipoPago = (jN13TOyLMX) this.rootView.findViewById(R.id.spTipoPago);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource2 = ArrayAdapter.createFromResource(this.context, R.array.array_agua_tipo_pago, android.R.layout.simple_list_item_1);
        this.adapterTipoPago = arrayAdapterCreateFromResource2;
        arrayAdapterCreateFromResource2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spTipoPago.setAdapter(this.adapterTipoPago);
        this.spTipoPago.setOnItemClickListener(this.spClickTipoPago);
        this.lyTipoPago.setVisibility(8);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (EditText) this.rootView.findViewById(R.id.txMonto);
        this.lyMonto.setVisibility(8);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter);
        this.inputLayoutCuenta.setHint(getString(R.string.txt_id_de_cajero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LHLbFzX21y.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LHLbFzX21y.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = LHLbFzX21y.this.facturasLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(LHLbFzX21y.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    LHLbFzX21y.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateRegion()) {
            return;
        }
        if (this.idRegionPago == 1) {
            if (!validateTipoPago()) {
                return;
            }
            if (this.idTipoPago == 3 && !validateMonto()) {
                return;
            }
        }
        if (!validateCuenta() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String msg = "¿ Desea pagar la cuenta de agua: " + cuenta + " ?";
        String cadena = this.idRegionPago + "*" + cuenta + "*" + this.importe + "*" + this.idTipoPago + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmElectricidad);
        int i = this.idRegionPago;
        if (i == 1) {
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "19", cadena, msg, group, getFragmentManager());
                return;
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "19", "05", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
                return;
            }
        }
        if (i == 2) {
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "51", cadena, msg, group, getFragmentManager());
                return;
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "51", "05", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
                return;
            }
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "21", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "21", "05", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateRegion() {
        if (this.spRegionPago.getText().toString().trim().isEmpty()) {
            this.lyRegionPago.setError(getString(R.string.err_msg_selecione_regionpago));
            requestFocus(this.spRegionPago);
            return false;
        }
        this.lyRegionPago.setErrorEnabled(false);
        return true;
    }

    private boolean validateTipoPago() {
        if (this.spTipoPago.getText().toString().trim().isEmpty()) {
            this.lyTipoPago.setError(getString(R.string.tx_err_tipo_pago));
            requestFocus(this.spTipoPago);
            return false;
        }
        this.lyRegionPago.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        try {
            this.importe = Float.parseFloat(this.txMonto.getText().toString());
            return true;
        } catch (Exception e) {
            this.importe = 0.0f;
            return true;
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y.6
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = LHLbFzX21y.this.facturasLists.get(position);
                    LHLbFzX21y.this.inputCuenta.setText(cuenta.getFactura());
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
