package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.p3NpwYhcUs3;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g7yG4Frdxy extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutTipo;
    public final CharSequence[] items = {"Factura Telefónica", "Factura Eléctrica"};
    public String mensagConfirmacion = BuildConfig.FLAVOR;
    public String operacion = BuildConfig.FLAVOR;
    public int pos_tipo;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public p3NpwYhcUs3 tipoOperacion;
    public String[] titles;
    public TextView toolbarTitle;
    public View zcomponentCuentasBanco;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.cd26ypses8fyd, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(this.context);
        List<Factura> facturasLists = unYp8VQThY.getInstance().getAllFacurasLists();
        List<String> facList = new ArrayList<>();
        for (Factura wl : facturasLists) {
            facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        View viewFindViewById = this.rootView.findViewById(R.id.zcomponent_cuentas);
        this.zcomponentCuentasBanco = viewFindViewById;
        viewFindViewById.setVisibility(8);
        this.inputCuenta.setAdapter(adapter1);
        this.toolbarTitle = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.g7yG4Frdxy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g7yG4Frdxy.this.submitForm();
            }
        });
        this.titles = getResources().getStringArray(R.array.array_servicios_banco);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_banco, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        if (getArguments() != null) {
            this.tipoOperacion = (p3NpwYhcUs3) getArguments().getSerializable("p3NpwYhcUs3");
        }
        initComponents();
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.g7yG4Frdxy$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3;

        static {
            int[] iArr = new int[p3NpwYhcUs3.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3 = iArr;
            try {
                iArr[p3NpwYhcUs3.Agregar.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3[p3NpwYhcUs3.Pago.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3[p3NpwYhcUs3.Consulta.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3[p3NpwYhcUs3.Eliminar.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void initComponents() {
        switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3[this.tipoOperacion.ordinal()]) {
            case 1:
                this.toolbarTitle.setText(R.string.serv_contr_add);
                this.btnAceptar.setText(R.string.serv_contr_agregar);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_add);
                this.operacion = "1";
                this.zcomponentCuentasBanco.setVisibility(8);
                break;
            case 2:
                this.toolbarTitle.setText(R.string.serv_contr_pagar_factura);
                this.btnAceptar.setText(R.string.serv_contr_pay);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_pago);
                this.inputCuenta.setVisibility(8);
                this.inputLayoutCuenta.setVisibility(8);
                this.zcomponentCuentasBanco.setVisibility(0);
                this.operacion = "4";
                break;
            case 3:
                this.toolbarTitle.setText(R.string.serv_contr_consultar_factura);
                this.btnAceptar.setText(R.string.serv_contr_consultar);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_consultar);
                this.inputCuenta.setVisibility(8);
                this.inputLayoutCuenta.setVisibility(8);
                this.operacion = "3";
                this.zcomponentCuentasBanco.setVisibility(8);
                break;
            case 4:
                this.toolbarTitle.setText(R.string.serv_contr_delete_fact);
                this.btnAceptar.setText(R.string.serv_contr_delete);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_delete);
                this.operacion = "2";
                this.zcomponentCuentasBanco.setVisibility(8);
                break;
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String idTipo;
        String msg;
        super.submitForm();
        if (!validateTipoCuenta() || !validateSelectionAccounts()) {
            return;
        }
        int position_select = this.spinnerTipo.getPosition_select();
        this.pos_tipo = position_select;
        if (position_select == 0) {
            idTipo = "1";
        } else {
            idTipo = "2";
        }
        String factura = "000";
        p3NpwYhcUs3 p3npwyhcus3 = this.tipoOperacion;
        if (p3npwyhcus3 == p3NpwYhcUs3.Agregar || p3npwyhcus3 == p3NpwYhcUs3.Eliminar) {
            if (!validateCuenta()) {
                return;
            }
            factura = this.inputCuenta.getText().toString().trim();
            String msg2 = this.mensagConfirmacion + factura;
            msg = msg2;
        } else {
            String msg3 = this.mensagConfirmacion + ((Object) this.spinnerTipo.getText());
            msg = msg3;
        }
        nuevoDatos();
        String cadena = this.operacion + "*" + idTipo + "*" + factura + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "52", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "52", "02", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCuenta.getText().toString().trim().split(" ");
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_espacions_en_blanco));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 15 && this.pos_tipo == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!this.inputCuenta.getText().toString().trim().substring(0, 2).contains("01") && this.pos_tipo == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() == 13 || this.pos_tipo != 1) {
            return true;
        }
        this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta));
        requestFocus(this.inputCuenta);
        return false;
    }

    private boolean validateTipoCuenta() {
        if (this.spinnerTipo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipo.setError("Seleccione el tipo de servicio");
            requestFocus(this.spinnerTipo);
            return false;
        }
        this.inputLayoutTipo.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(this.spinnerTipo.getPosition_select());
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
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
