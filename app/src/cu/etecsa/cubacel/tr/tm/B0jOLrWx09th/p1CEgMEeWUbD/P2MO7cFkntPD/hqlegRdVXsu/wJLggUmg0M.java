package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TipoPrelacion;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class wJLggUmg0M extends QGQCqILT4b {
    private Button btnAceptar;
    public TextInputLayout lyPrelacion;
    public TipoPrelacion prelacion;
    public ArrayAdapter<TipoPrelacion> prelacionArrayAdapter;
    public List<TipoPrelacion> prelacionList;
    private jN13TOyLMX spPrelacion;
    public TextView toolbar_title;
    public String tipoServicio = "0";
    public jN13TOyLMX.OnItemClickListener spPrelacionOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.wJLggUmg0M.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            wJLggUmg0M wjlggumg0m = wJLggUmg0M.this;
            wjlggumg0m.prelacion = wjlggumg0m.prelacionArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.qsm2zf232m3bm, container, false);
        this.context = container.getContext();
        this.lyPrelacion = (TextInputLayout) this.rootView.findViewById(R.id.lyPrelacion);
        this.spPrelacion = (jN13TOyLMX) this.rootView.findViewById(R.id.spPrelacion);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        loadPrelacion();
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.wJLggUmg0M.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wJLggUmg0M.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validatePrelacion() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cadena = this.prelacion.getCode() + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "27", cadena, "¿Desea realizar la modificación de la prelación de pago?", group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    private boolean loadPrelacion() {
        try {
            this.prelacionList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<TipoPrelacion> list = jsonFilesManager.loadDataPrelacion(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.prelacionArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (TipoPrelacion uyh0pxs9m37in : list) {
                this.prelacionArrayAdapter.add(uyh0pxs9m37in);
                this.prelacionList.add(uyh0pxs9m37in);
            }
            this.prelacionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spPrelacion.setAdapter(this.prelacionArrayAdapter);
            this.spPrelacion.setOnItemClickListener(this.spPrelacionOnClickListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validatePrelacion() {
        this.lyPrelacion.setErrorEnabled(false);
        if (this.spPrelacion.getText().toString().trim().isEmpty() || this.prelacion == null) {
            this.lyPrelacion.setError("Seleccione la opción");
            requestFocus(this.spPrelacion);
            return false;
        }
        this.lyPrelacion.setErrorEnabled(false);
        return true;
    }
}
