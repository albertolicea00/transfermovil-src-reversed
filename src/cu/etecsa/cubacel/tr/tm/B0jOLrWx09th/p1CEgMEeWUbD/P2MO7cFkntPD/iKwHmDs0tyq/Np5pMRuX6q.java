package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Np5pMRuX6q extends Agg55uYctq {
    private Button btnAceptar;
    public TextInputLayout inputLayoutTipo;
    public TextView toolbar_title;
    public jN13TOyLMX.OnItemClickListener btnUltOper = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Np5pMRuX6q.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMoneda = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Np5pMRuX6q.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    if (Np5pMRuX6q.this.cargarMisCuentas()) {
                        Np5pMRuX6q.this.monedaTarjeta = 0;
                        Np5pMRuX6q.this.seleccionCuenta = jceCwl8l2R.MIS_CUENTAS;
                        Np5pMRuX6q.this.inputLayoutMisCuentas.setVisibility(0);
                        Np5pMRuX6q.this.inputLayoutCuentaWrite.setVisibility(8);
                    } else {
                        showDialogNoTieneCuentas();
                    }
                    break;
                case 1:
                    Np5pMRuX6q.this.monedaTarjeta = 0;
                    Np5pMRuX6q.this.seleccionCuenta = jceCwl8l2R.NUEVA_CUENTA;
                    Np5pMRuX6q.this.inputLayoutMisCuentas.setVisibility(8);
                    Np5pMRuX6q.this.inputLayoutCuentaWrite.setVisibility(0);
                    Np5pMRuX6q.this.mcBankArrayAdapter = null;
                    Np5pMRuX6q.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Np5pMRuX6q.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
                default:
                    Np5pMRuX6q.this.seleccionCuenta = jceCwl8l2R.MONEDA;
                    Np5pMRuX6q.this.monedaTarjeta = position + 1;
                    Np5pMRuX6q.this.inputLayoutMisCuentas.setVisibility(8);
                    Np5pMRuX6q.this.inputLayoutCuentaWrite.setVisibility(8);
                    Np5pMRuX6q.this.mcBankArrayAdapter = null;
                    Np5pMRuX6q.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
                    Np5pMRuX6q.this.miCuentaSeleccion = BuildConfig.FLAVOR;
                    break;
            }
        }

        public void showDialogNoTieneCuentas() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Np5pMRuX6q.this.context);
            builder.setTitle(Np5pMRuX6q.this.context.getString(R.string.tx_hint_aviso));
            builder.setMessage(Np5pMRuX6q.this.context.getString(R.string.err_no_tiene_cuentas));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Np5pMRuX6q.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.qvckpf0qoz8lm, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.title_consultar_ultimas_oper_banco);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.inputLayoutTipo = textInputLayout;
        textInputLayout.setVisibility(8);
        unYp8VQThY.init(this.context);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Np5pMRuX6q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Np5pMRuX6q.this.submitForm();
            }
        });
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.accounts, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoMoneda.setAdapter(this.adapterTipoMoneda);
        this.spinnerTipoMoneda.setOnItemClickListener(this.spClickMoneda);
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cadena = this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "48", cadena, "Desea consultar las ultimas operaciones ", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "48", "05", this.MAX_PARAMETERS_PQUETE, cadena, "Desea consultar las ultimas operaciones ", group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public boolean cargarMisCuentas() {
        try {
            List<MCBank> list = unYp8VQThY.getInstance().getMCBankByAgency(this.bancoEntity);
            if (list == null || list.size() <= 0) {
                return false;
            }
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
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
