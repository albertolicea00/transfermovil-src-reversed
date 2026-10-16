package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q9DNC6bnexm extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public Context context;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutTipo;
    public final CharSequence[] items = {"Factura Telefónica", "Factura Eléctrica"};
    public String mensagConfirmacion = BuildConfig.FLAVOR;
    public String operacion = BuildConfig.FLAVOR;
    public int pos_tipo;
    public View rootView;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public p3NpwYhcUs3 tipoOperacion;
    public String[] titles;
    public TextView toolbarTitle;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.h2hbei4efp2gmd, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        List<Factura> facturasLists = unYp8VQThY.getInstance().getAllFacurasLists();
        List<String> facList = new ArrayList<>();
        for (Factura wl : facturasLists) {
            facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, facList);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputCuenta = autoCompleteTextView;
        autoCompleteTextView.setAdapter(adapter1);
        this.toolbarTitle = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.q9DNC6bnexm.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q9DNC6bnexm.this.submitForm();
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.q9DNC6bnexm$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
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
        switch (AnonymousClass4.$SwitchMap$cu$etecsa$cubacel$tr$tm$B0jOLrWx09th$p1CEgMEeWUbD$OfZgAbz2cY8$p3NpwYhcUs3[this.tipoOperacion.ordinal()]) {
            case 1:
                this.toolbarTitle.setText(R.string.serv_contr_add);
                this.btnAceptar.setText(R.string.serv_contr_agregar);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_add);
                this.operacion = "1";
                break;
            case 2:
                this.toolbarTitle.setText(R.string.serv_contr_pagar_factura);
                this.btnAceptar.setText(R.string.serv_contr_pay);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_pago);
                this.inputCuenta.setVisibility(8);
                this.inputLayoutCuenta.setVisibility(8);
                this.operacion = "4";
                break;
            case 3:
                this.toolbarTitle.setText(R.string.serv_contr_consultar_factura);
                this.btnAceptar.setText(R.string.serv_contr_consultar);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_consultar);
                this.inputCuenta.setVisibility(8);
                this.inputLayoutCuenta.setVisibility(8);
                this.operacion = "3";
                break;
            case 4:
                this.toolbarTitle.setText(R.string.serv_contr_delete_fact);
                this.btnAceptar.setText(R.string.serv_contr_delete);
                this.mensagConfirmacion = this.context.getString(R.string.serv_contr_confirm_delete);
                this.operacion = "2";
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String idTipo;
        String msg;
        if (!validateTipoCuenta()) {
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
        String cadena = this.operacion + "*" + idTipo + "*" + factura;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "52", cadena, msg, group, getFragmentManager());
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

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

    public void createAlertDialog(String mensaje_dialog, ViewGroup group, final Uri number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.q9DNC6bnexm.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    q9DNC6bnexm.this.getFragmentManager().popBackStack();
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    q9DNC6bnexm.this.startActivity(dial);
                } catch (Exception e) {
                }
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.q9DNC6bnexm.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }
}
