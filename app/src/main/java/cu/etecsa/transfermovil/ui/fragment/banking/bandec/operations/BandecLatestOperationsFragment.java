package cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.gaJlF6dT3z */
public class BandecLatestOperationsFragment extends BandecAccountSelectionFragment {
    private Button btnAceptar;
    public String tipoServicio = "0";
    public TextView toolbar_title;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.jozkrainwpt1o, container, false);
        Context context = container.getContext();
        this.context = context;
        DatabaseHelper.init(context);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.title_consultar_ultimas_oper_banco);
        initComponentesCuentas(this.rootView, BankType.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.gaJlF6dT3z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BandecLatestOperationsFragment.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // BandecAccountSelectionFragment
    public void submitForm() {
        super.submitForm();
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cadena = this.tipoServicio + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        UssdDispatcher.actionCallUSSDBack(this.context, "48", cadena, "¿Desea ver las últimas operaciones realizadas?", group, getFragmentManager());
    }

    @Override // BandecAccountSelectionFragment
    public void nuevoDatos() {
    }
}
