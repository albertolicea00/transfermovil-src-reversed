package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Q2PhPnBLWf extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    private TextInputLayout inputLayoutSpinnerCliente;
    private TextInputLayout inputLayoutTMovil;
    private EditText inputTMovil;
    public jN13TOyLMX spinnerCliente;
    public TeflMovil tmovil;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public boolean editMode = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Q2PhPnBLWf.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            Q2PhPnBLWf q2PhPnBLWf = Q2PhPnBLWf.this;
            q2PhPnBLWf.id_cliente_select = q2PhPnBLWf.clientsList.get(q2PhPnBLWf.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.difolefpmdn8i, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutTMovil = (TextInputLayout) rootView.findViewById(R.id.input__layout_tmovil);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputTMovil = (EditText) rootView.findViewById(R.id.input_tmovil);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.clientsList = unYp8VQThY.getInstance().getAllClientLists();
        List<String> titles = new ArrayList<>();
        for (Client c : this.clientsList) {
            try {
                if (c.getName().length() != 0) {
                    titles.add(c.getName());
                }
            } catch (Exception e) {
            }
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, titles);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCliente.setAdapter(adapter1);
        if (getArguments() != null) {
            this.toolbar_title.setText(R.string.head_title_ag_update_movil);
            int idTelefono = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            TeflMovil movilListWithId = unYp8VQThY.getInstance().getMovilListWithId(idTelefono);
            this.tmovil = movilListWithId;
            this.inputTMovil.setText(movilListWithId.getNumber());
            if (this.tmovil.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.tmovil.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText(R.string.head_title_ag_new_movil);
            this.tmovil = new TeflMovil();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Q2PhPnBLWf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Q2PhPnBLWf.this.submitForm();
            }
        });
        return rootView;
    }

    public void submitForm() {
        if (!validatePhone()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Q2PhPnBLWf.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    Q2PhPnBLWf q2PhPnBLWf = Q2PhPnBLWf.this;
                    q2PhPnBLWf.lista_vacia = true;
                    q2PhPnBLWf.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Q2PhPnBLWf.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    Q2PhPnBLWf.this.lista_vacia = false;
                }
            });
            builder.show();
            return;
        }
        execute_commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute_commit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Q2PhPnBLWf.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(Q2PhPnBLWf.this.context);
                Q2PhPnBLWf q2PhPnBLWf = Q2PhPnBLWf.this;
                q2PhPnBLWf.tmovil.setNumber(q2PhPnBLWf.inputTMovil.getText().toString());
                Q2PhPnBLWf q2PhPnBLWf2 = Q2PhPnBLWf.this;
                int i = q2PhPnBLWf2.id_cliente_select;
                if (i != 0 && i != -1) {
                    q2PhPnBLWf2.tmovil.setId_client(i);
                }
                if (Q2PhPnBLWf.this.editMode) {
                    unYp8VQThY.getInstance().updateMovil(Q2PhPnBLWf.this.tmovil);
                } else {
                    unYp8VQThY.getInstance().addTelfMovil(Q2PhPnBLWf.this.tmovil);
                }
                ((IHVTCBmiLV) Q2PhPnBLWf.this.getActivity()).UpdateMenu();
                Q2PhPnBLWf.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validatePhone() {
        if (this.inputTMovil.getText().toString().trim().isEmpty()) {
            this.inputLayoutTMovil.setError(getString(R.string.err_msg_empty_numero));
            requestFocus(this.inputTMovil);
            return false;
        }
        if (this.inputTMovil.getText().toString().trim().length() != 8) {
            this.inputLayoutTMovil.setError(getString(R.string.err_msg_len_numero));
            requestFocus(this.inputTMovil);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !this.inputTMovil.getText().toString().contains(this.tmovil.getNumber()))) {
            if (unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(this.inputTMovil.getText().toString().trim()).size() != 0) {
                this.inputLayoutTMovil.setError(this.context.getString(R.string.err_msg_num_existe));
                requestFocus(this.inputTMovil);
                return false;
            }
            return true;
        }
        this.inputLayoutTMovil.setErrorEnabled(false);
        return true;
    }

    private boolean validateSpinnerCliente() {
        if (this.spinnerCliente.getText().toString().trim().isEmpty()) {
            return false;
        }
        this.lista_vacia = true;
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
