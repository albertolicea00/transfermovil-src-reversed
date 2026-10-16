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
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bKpfdtiEWm extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    private EditText inputCNauta;
    private TextInputLayout inputLayoutCNauta;
    private TextInputLayout inputLayoutSpinnerCliente;
    private TextInputLayout inputLayoutSpinnerTCuenta;
    public Nauta nauta;
    public jN13TOyLMX spinnerCliente;
    public jN13TOyLMX spinnerTCuenta;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public int tipo_cuenta;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public boolean editMode = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            bKpfdtiEWm bkpfdtiewm = bKpfdtiEWm.this;
            bkpfdtiewm.id_cliente_select = bkpfdtiewm.clientsList.get(bkpfdtiewm.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.texuhmuue6oel, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutCNauta = (TextInputLayout) rootView.findViewById(R.id.input__layout_cnauta);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputCNauta = (EditText) rootView.findViewById(R.id.input_cnauta);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.spinnerTCuenta = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoCuenta);
        this.inputLayoutSpinnerTCuenta = (TextInputLayout) rootView.findViewById(R.id.input__layout_gtipocuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cuenta_nauta, android.R.layout.simple_list_item_1);
        this.tcuentaAdapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTCuenta.setAdapter(this.tcuentaAdapter);
        this.clientsList = unYp8VQThY.getInstance().getAllClientLists();
        List<String> titles = new ArrayList<>();
        for (Client c : this.clientsList) {
            if (c.getName().length() != 0) {
                titles.add(c.getName());
            }
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, titles);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCliente.setAdapter(adapter1);
        if (getArguments() != null) {
            this.toolbar_title.setText(getContext().getResources().getText(R.string.tx_titke_cuenta_nauta));
            int idTelefono = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            Nauta nautaListWithId = unYp8VQThY.getInstance().getNautaListWithId(idTelefono);
            this.nauta = nautaListWithId;
            this.inputCNauta.setText(nautaListWithId.getCuenta());
            if (this.nauta.getId_client() > 0) {
                try {
                    Client cl = unYp8VQThY.getInstance().getClientListWithId(this.nauta.getId_client());
                    this.spinnerCliente.setText(cl.getName());
                    this.id_cliente_select = cl.getId();
                } catch (Exception e) {
                }
            }
            if (this.nauta.getTipo_cuenta() == 1) {
                this.spinnerTCuenta.setText(this.tcuentaAdapter.getItem(0).toString());
            } else {
                this.spinnerTCuenta.setText(this.tcuentaAdapter.getItem(1).toString());
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText(getContext().getText(R.string.tx_nueva_cuenta_nauta));
            this.nauta = new Nauta();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bKpfdtiEWm.this.submitForm();
            }
        });
        return rootView;
    }

    public void submitForm() {
        if (!validateTipoCuentaNauta()) {
            return;
        }
        if (this.spinnerTCuenta.getText().length() == 24) {
            this.tipo_cuenta = 1;
        }
        if (this.spinnerTCuenta.getText().length() == 19) {
            this.tipo_cuenta = 2;
        }
        if (!validateCuenta()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bKpfdtiEWm bkpfdtiewm = bKpfdtiEWm.this;
                    bkpfdtiewm.lista_vacia = true;
                    bkpfdtiewm.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bKpfdtiEWm.this.lista_vacia = false;
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(bKpfdtiEWm.this.context);
                bKpfdtiEWm bkpfdtiewm = bKpfdtiEWm.this;
                bkpfdtiewm.nauta.setCuenta(bkpfdtiewm.inputCNauta.getText().toString());
                bKpfdtiEWm bkpfdtiewm2 = bKpfdtiEWm.this;
                bkpfdtiewm2.nauta.setTipo_cuenta(bkpfdtiewm2.tipo_cuenta);
                bKpfdtiEWm bkpfdtiewm3 = bKpfdtiEWm.this;
                int i = bkpfdtiewm3.id_cliente_select;
                if (i != 0 && i != -1) {
                    bkpfdtiewm3.nauta.setId_client(i);
                }
                if (bKpfdtiEWm.this.editMode) {
                    unYp8VQThY.getInstance().updateNauta(bKpfdtiEWm.this.nauta);
                } else {
                    unYp8VQThY.getInstance().addNauta(bKpfdtiEWm.this.nauta);
                }
                if (bKpfdtiEWm.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) bKpfdtiEWm.this.getActivity()).UpdateMenu();
                } else if (bKpfdtiEWm.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) bKpfdtiEWm.this.getActivity()).UpdateMenu();
                }
                bKpfdtiEWm.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCNauta.getText().toString().trim().split(" ");
        if (this.inputCNauta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCNauta.setError(this.context.getString(R.string.err_msg_nauta_cuenta));
            requestFocus(this.inputCNauta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCNauta.setError("Su cuenta no debe tener espacios en blanco");
            requestFocus(this.inputCNauta);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !this.inputCNauta.getText().toString().contains(this.nauta.getCuenta()))) {
            if (unYp8VQThY.getInstance().getNautaListsWithAccount(this.inputCNauta.getText().toString().trim(), this.tipo_cuenta).size() != 0) {
                this.inputLayoutCNauta.setError("Cuenta de usuario ya existe!");
                requestFocus(this.inputCNauta);
                return false;
            }
        } else {
            this.inputLayoutCNauta.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateTipoCuentaNauta() {
        if (this.spinnerTCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutSpinnerTCuenta.setError(getContext().getString(R.string.tx_selecione_tipo_cuenta_nauta));
            requestFocus(this.spinnerTCuenta);
            return false;
        }
        this.inputLayoutSpinnerTCuenta.setErrorEnabled(false);
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
