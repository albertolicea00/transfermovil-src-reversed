package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class Xh70Rdjfpc extends QGQCqILT4b {
    private Button btnAceptar;
    public String tipoServicio = "0";
    public TextView toolbar_title;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.y2c4tmczn3yyyt, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText("Convertir Cuenta CUC a CUP");
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.Xh70Rdjfpc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Xh70Rdjfpc.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String msg = "¿Desea cambiar su cuenta en CUC a CUP?";
        if (this.swCuentasBanco.isChecked() && this.cuentaOrigen != "0000") {
            msg = "¿Desea cambiar su cuenta " + this.cuentaOrigen + " en CUC a CUP?";
        }
        String cadena = this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "87", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }
}
