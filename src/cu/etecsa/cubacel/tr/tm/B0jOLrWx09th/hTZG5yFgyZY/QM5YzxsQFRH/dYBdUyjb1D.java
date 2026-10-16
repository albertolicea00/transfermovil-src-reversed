package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;

/* JADX INFO: loaded from: classes.dex */
public class dYBdUyjb1D extends Fragment {
    private Button btnAceptar;
    public Context context;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyCorreo;
    private TextInputLayout lyIdReserva;
    public View rootView;
    private jN13TOyLMX spBolsas;
    private AutoCompleteTextView txCorreo;
    private AutoCompleteTextView txIdReserva;
    private int tipoBolsa = 0;
    private int opcion = 0;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dYBdUyjb1D.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            dYBdUyjb1D.this.tipoBolsa = position + 1;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.m9p1g3a9vaood, container, false);
        this.context = container.getContext();
        this.lyIdReserva = (TextInputLayout) this.rootView.findViewById(R.id.lyIdReserva);
        this.lyCorreo = (TextInputLayout) this.rootView.findViewById(R.id.lyCorreo);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.txIdReserva = (AutoCompleteTextView) this.rootView.findViewById(R.id.txIdReserva);
        this.txCorreo = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCorreo);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> adapterTipoBolsa = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        adapterTipoBolsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dYBdUyjb1D.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dYBdUyjb1D.this.submitForm();
            }
        });
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("Opcion")) {
                int iIntValue = ((Integer) arg.getSerializable("Opcion")).intValue();
                this.opcion = iIntValue;
                if (iIntValue == 1) {
                    this.lyIdReserva.setVisibility(8);
                } else {
                    this.lyIdReserva.setVisibility(0);
                }
            }
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateCorreo() || !validateSpBolsa()) {
            return;
        }
        String idRes = "0000";
        if (this.opcion == 2) {
            if (!validateIdReserva()) {
                return;
            } else {
                idRes = this.txIdReserva.getText().toString();
            }
        }
        String cadena = this.opcion + "*" + this.txCorreo.getText().toString() + "*" + idRes + "*" + this.tipoBolsa;
        String msg = "¿Desea consultar sus visitas? El resultado será  enviado al siguiente correo electrónico: " + this.txCorreo.getText().toString() + ". Esta operación realiza un cobro de comisión a la cuenta seleccionada.";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTranferencia);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "9", cadena, msg, group, getFragmentManager());
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    private boolean validateCorreo() {
        if (this.txCorreo.getText().toString().trim().isEmpty()) {
            this.lyCorreo.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txCorreo);
            return false;
        }
        if (!this.txCorreo.getText().toString().contains("@") || !this.txCorreo.getText().toString().contains(".")) {
            this.lyCorreo.setError(this.context.getString(R.string.hint_email_valido));
            requestFocus(this.txCorreo);
            return false;
        }
        if (!this.txCorreo.getText().toString().contains(".cu")) {
            this.lyCorreo.setError(this.context.getString(R.string.hint_email_cuba));
            requestFocus(this.txCorreo);
            return false;
        }
        this.lyCorreo.setErrorEnabled(false);
        return true;
    }

    private boolean validateIdReserva() {
        if (this.txIdReserva.getText().toString().trim().isEmpty()) {
            this.lyIdReserva.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txIdReserva);
            return false;
        }
        this.lyIdReserva.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
