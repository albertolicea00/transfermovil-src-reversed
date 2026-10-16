package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.cSs8O7U2kmm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/* JADX INFO: loaded from: classes.dex */
public class Z4cR6n2oFo extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public Button btnAceptar;
    public Context context;
    public pAzq93vIl3 manager;
    public View rootView;
    public TextView titleToolbar;
    public String cadena = "1*9295959595989295*456*888*678*7778*999*258*9775";
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.cSs8O7U2kmm.Z4cR6n2oFo.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Z4cR6n2oFo.this.enviarUSSD();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.rbfc5lowvmijd, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        this.manager = new pAzq93vIl3(this.context, this);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.titleToolbar = (TextView) v.findViewById(R.id.titleToolbar);
        Button button = (Button) v.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
    }
}
