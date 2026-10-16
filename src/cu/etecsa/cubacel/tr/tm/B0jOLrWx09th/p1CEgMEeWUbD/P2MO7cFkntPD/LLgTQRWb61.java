package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LLgTQRWb61 extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    public Context context;
    private TextInputLayout inputLayoutMonto;
    private TextInputLayout inputLayoutRC04;
    private TextInputLayout inputLayoutRC05;
    public TextInputLayout inputLayoutTipoMoneda;
    private AutoCompleteTextView inputMonto;
    private AutoCompleteTextView inputRC04;
    private AutoCompleteTextView inputRC05;
    public View rootView;
    public jN13TOyLMX spinnerTipoMoneda;
    public String[] tipomoneda;
    public y2Cht3lmjg tiposOnat;
    public int monedaTarjeta = 1;
    private jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            LLgTQRWb61.this.monedaTarjeta = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.va8n98hpxnf15, container, false);
        this.context = container.getContext();
        this.inputLayoutRC04 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc04);
        this.inputRC04 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc04);
        this.inputLayoutRC05 = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_rc05);
        this.inputRC05 = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_rc05);
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_monto);
        this.tipomoneda = getResources().getStringArray(R.array.currency);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoMoneda = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("y2Cht3lmjg")) {
                y2Cht3lmjg y2cht3lmjg = (y2Cht3lmjg) arg.getSerializable("y2Cht3lmjg");
                this.tiposOnat = y2cht3lmjg;
                configureLayoutTipoPago(y2cht3lmjg);
            } else {
                showDialogFormadePagoONAT();
            }
            if (arg.containsKey("servicio")) {
                this.inputRC05.setText(getArguments().get("servicio").toString());
            }
        }
        unYp8VQThY.init(this.context);
        List<ServicioPublico> servLists = unYp8VQThY.getInstance().getFacturasListsTipoServicio(0);
        List<String> onatList = new ArrayList<>();
        for (ServicioPublico wl : servLists) {
            onatList.add(wl.getValor());
        }
        if (onatList.size() > 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, onatList);
            this.inputRC05.setAdapter(adapter);
            this.inputRC05.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    LLgTQRWb61.this.inputRC05.showDropDown();
                }
            });
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LLgTQRWb61.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg;

        static {
            int[] iArr = new int[y2Cht3lmjg.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg = iArr;
            try {
                iArr[y2Cht3lmjg.ParcialFijoMensual.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[y2Cht3lmjg.ParcialFijoAnual.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[y2Cht3lmjg.ParcilFijoImporte.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureLayoutTipoPago(y2Cht3lmjg tipo) {
        this.tiposOnat = tipo;
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[tipo.ordinal()]) {
            case 1:
                this.inputLayoutMonto.setVisibility(8);
                this.inputLayoutRC04.setHint(getString(R.string.input_cod_barras));
                this.inputLayoutTipoMoneda.setVisibility(0);
                break;
            case 2:
                this.inputLayoutRC04.setHint(getString(R.string.input_cod_tributo));
                this.inputLayoutMonto.setVisibility(8);
                this.inputLayoutTipoMoneda.setVisibility(0);
                break;
            case 3:
                this.inputLayoutRC04.setHint(getString(R.string.input_cod_barras));
                this.inputLayoutMonto.setVisibility(0);
                this.inputLayoutTipoMoneda.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateLicencia() || !validateMonto() || !validateTipoMoneda()) {
            return;
        }
        nuevoDatos();
        String formaPago = BuildConfig.FLAVOR;
        String rc04 = "0000";
        String rc05 = this.inputRC05.getText().toString().trim();
        String codTributo = "0000";
        String importe = "0000";
        String moneda = String.valueOf(this.monedaTarjeta);
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[this.tiposOnat.ordinal()]) {
            case 1:
                formaPago = "1";
                rc04 = this.inputRC04.getText().toString().trim();
                break;
            case 2:
                formaPago = "1";
                codTributo = this.inputRC04.getText().toString().trim();
                break;
            case 3:
                formaPago = "2";
                rc04 = this.inputRC04.getText().toString().trim();
                importe = this.inputMonto.getText().toString().trim();
                break;
        }
        String cadena = formaPago + "*" + rc04 + "*" + rc05 + "*" + codTributo + "*" + importe + "*" + moneda;
        String msg = "Desea realizar el pago del impuesto con el siguiente RC05: " + rc05;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmOnat);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "43", cadena, msg, group, getFragmentManager());
    }

    private boolean validateLicencia() {
        if (this.inputRC04.getText().toString().trim().isEmpty()) {
            this.inputLayoutRC04.setError("Indique el valor del campo solicitado");
            requestFocus(this.inputRC04);
            return false;
        }
        if (this.tiposOnat == y2Cht3lmjg.ParcialFijoAnual) {
            if (this.inputRC04.getText().toString().trim().length() != 7) {
                this.inputLayoutRC04.setError("Código de tributo invalido");
                requestFocus(this.inputRC04);
                return false;
            }
        } else if (this.inputRC04.getText().toString().trim().length() != 5) {
            this.inputLayoutRC04.setError("Código de barra invalido");
            requestFocus(this.inputRC04);
            return false;
        }
        if (this.inputRC05.getText().toString().trim().isEmpty()) {
            this.inputLayoutRC05.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputRC05);
            return false;
        }
        if (this.inputRC05.getText().toString().trim().length() != 11 && this.inputRC05.getText().toString().trim().length() != 16) {
            this.inputLayoutRC05.setError("Código de RC05 invalido");
            requestFocus(this.inputRC05);
            return false;
        }
        this.inputLayoutRC04.setErrorEnabled(false);
        this.inputLayoutRC05.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.tiposOnat == y2Cht3lmjg.ParcilFijoImporte) {
            if (this.inputMonto.getText().toString().trim().isEmpty()) {
                this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.inputMonto);
                return false;
            }
            if (Float.valueOf(this.inputMonto.getText().toString().trim()).floatValue() == 0.0f) {
                this.inputLayoutMonto.setError("Indique un monto superior cuentaCaracteres cero");
                requestFocus(this.inputMonto);
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean validateTipoMoneda() {
        if (this.tiposOnat == y2Cht3lmjg.ParcilFijoImporte) {
            if (this.spinnerTipoMoneda.getText().toString().trim().isEmpty()) {
                this.inputLayoutTipoMoneda.setError("Seleccione el tipo de moneda");
                requestFocus(this.spinnerTipoMoneda);
                return false;
            }
            this.inputLayoutTipoMoneda.setErrorEnabled(false);
            return true;
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_onat = this.inputRC05.getText().toString();
        List<ServicioPublico> c_list = unYp8VQThY.getInstance().getServicioPublicoListsWithValor(edit_onat);
        if (c_list.size() == 0) {
            ServicioPublico s = new ServicioPublico();
            s.setTipo_servicio(0);
            s.setCod_servicio("RC05");
            s.setValor(edit_onat);
            unYp8VQThY.getInstance().addServicioPublico(s);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    private void showDialogFormadePagoONAT() {
        CharSequence[] items = {"Parcial Fijo Mensual", "Parcial Fijo Anual", "Parcial con Importe Declarado"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la forma de Pago Parcial:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new Bundle();
                FragmentManager mFragmentManager = LLgTQRWb61.this.getActivity().getSupportFragmentManager();
                mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        LLgTQRWb61.this.configureLayoutTipoPago(y2Cht3lmjg.ParcialFijoMensual);
                        break;
                    case 1:
                        LLgTQRWb61.this.configureLayoutTipoPago(y2Cht3lmjg.ParcialFijoAnual);
                        break;
                    case 2:
                        LLgTQRWb61.this.configureLayoutTipoPago(y2Cht3lmjg.ParcilFijoImporte);
                        break;
                }
            }
        });
        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.LLgTQRWb61.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
