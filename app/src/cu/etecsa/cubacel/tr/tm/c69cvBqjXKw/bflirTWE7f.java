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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bflirTWE7f extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    private TextInputLayout inputLayoutSpinnerCliente;
    private TextInputLayout inputLayoutTFijo;
    private EditText inputTFijo;
    public jN13TOyLMX spinnerCliente;
    public TelfFijo tfijo;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public boolean editMode = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            bflirTWE7f bflirtwe7f = bflirTWE7f.this;
            bflirtwe7f.id_cliente_select = bflirtwe7f.clientsList.get(bflirtwe7f.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.s3g5zil8kplsnd, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutTFijo = (TextInputLayout) rootView.findViewById(R.id.input__layout_tfijo);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputTFijo = (EditText) rootView.findViewById(R.id.input_tfijo);
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
            this.toolbar_title.setText(R.string.txt_head_editar_telefono);
            int idTelefono = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            TelfFijo fijoListWithId = unYp8VQThY.getInstance().getFijoListWithId(idTelefono);
            this.tfijo = fijoListWithId;
            this.inputTFijo.setText(fijoListWithId.getNumber());
            if (this.tfijo.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.tfijo.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText(R.string.tx_head_nuevo_telefono);
            this.tfijo = new TelfFijo();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bflirTWE7f.this.submitForm();
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
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bflirTWE7f bflirtwe7f = bflirTWE7f.this;
                    bflirtwe7f.lista_vacia = true;
                    bflirtwe7f.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bflirTWE7f.this.lista_vacia = false;
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(bflirTWE7f.this.context);
                bflirTWE7f bflirtwe7f = bflirTWE7f.this;
                bflirtwe7f.tfijo.setNumber(bflirtwe7f.inputTFijo.getText().toString());
                bflirTWE7f bflirtwe7f2 = bflirTWE7f.this;
                int i = bflirtwe7f2.id_cliente_select;
                if (i != 0 && i != -1) {
                    bflirtwe7f2.tfijo.setId_client(i);
                }
                if (bflirTWE7f.this.editMode) {
                    unYp8VQThY.getInstance().updateFijo(bflirTWE7f.this.tfijo);
                } else {
                    unYp8VQThY.getInstance().addTelfFijo(bflirTWE7f.this.tfijo);
                }
                ((IHVTCBmiLV) bflirTWE7f.this.getActivity()).UpdateMenu();
                bflirTWE7f.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validatePhone() {
        if (this.inputTFijo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTFijo.setError(getString(R.string.err_msg_empty_numero));
            requestFocus(this.inputTFijo);
            return false;
        }
        if (this.inputTFijo.getText().toString().trim().length() != 8) {
            this.inputLayoutTFijo.setError(getString(R.string.err_msg_len_numero));
            requestFocus(this.inputTFijo);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !this.inputTFijo.getText().toString().contains(this.tfijo.getNumber()))) {
            if (unYp8VQThY.getInstance().getFijoListsWithPhoneNumber(this.inputTFijo.getText().toString().trim()).size() != 0) {
                this.inputLayoutTFijo.setError(this.context.getString(R.string.err_msg_num_existe));
                requestFocus(this.inputTFijo);
                return false;
            }
            return true;
        }
        this.inputLayoutTFijo.setErrorEnabled(false);
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
