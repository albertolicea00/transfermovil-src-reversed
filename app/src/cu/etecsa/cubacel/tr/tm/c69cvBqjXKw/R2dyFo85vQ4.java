package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class R2dyFo85vQ4 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    private EditText inputCFactura;
    private TextInputLayout inputLayoutCFactura;
    private TextInputLayout inputLayoutSpinnerCliente;
    private TextInputLayout inputLayoutSpinnerTCuenta;
    public ServicioPublico servicioPublico;
    public jN13TOyLMX spinnerCliente;
    public jN13TOyLMX spinnerTCuenta;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public int tipo_cuenta = -1;
    public int edit_tipo_cuenta = -1;
    public boolean editMode = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            R2dyFo85vQ4 r2dyFo85vQ4 = R2dyFo85vQ4.this;
            r2dyFo85vQ4.id_cliente_select = r2dyFo85vQ4.clientsList.get(r2dyFo85vQ4.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ji0jctdb3zh9f, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutCFactura = (TextInputLayout) rootView.findViewById(R.id.input__layout_cFactura);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputCFactura = (EditText) rootView.findViewById(R.id.input_cFactura);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.spinnerTCuenta = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoFactura);
        this.inputLayoutSpinnerTCuenta = (TextInputLayout) rootView.findViewById(R.id.input__layout_gtipocuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_publicos, android.R.layout.simple_list_item_1);
        this.tcuentaAdapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTCuenta.setAdapter(this.tcuentaAdapter);
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
            this.toolbar_title.setText("Editar Servicio Público");
            int idfactura = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            ServicioPublico servicioListWithId = unYp8VQThY.getInstance().getServicioListWithId(idfactura);
            this.servicioPublico = servicioListWithId;
            this.inputCFactura.setText(servicioListWithId.getValor());
            if (this.servicioPublico.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.servicioPublico.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.spinnerTCuenta.setText(this.tcuentaAdapter.getItem(this.servicioPublico.getTipo_servicio()).toString());
            this.tipo_cuenta = this.servicioPublico.getTipo_servicio();
            this.editMode = true;
        } else {
            this.toolbar_title.setText("Nuevo Servicio Público");
            this.servicioPublico = new ServicioPublico();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                R2dyFo85vQ4.this.submitForm();
            }
        });
        return rootView;
    }

    public void submitForm() {
        this.edit_tipo_cuenta = this.spinnerTCuenta.getPosition_select();
        if (!validateTipoCuentaFactura() || !validateCuenta()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    R2dyFo85vQ4 r2dyFo85vQ4 = R2dyFo85vQ4.this;
                    r2dyFo85vQ4.lista_vacia = true;
                    r2dyFo85vQ4.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    R2dyFo85vQ4.this.lista_vacia = false;
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(R2dyFo85vQ4.this.context);
                R2dyFo85vQ4 r2dyFo85vQ4 = R2dyFo85vQ4.this;
                r2dyFo85vQ4.servicioPublico.setValor(r2dyFo85vQ4.inputCFactura.getText().toString().trim());
                R2dyFo85vQ4.this.servicioPublico.setTipo_servicio(0);
                R2dyFo85vQ4 r2dyFo85vQ5 = R2dyFo85vQ4.this;
                int i = r2dyFo85vQ5.id_cliente_select;
                if (i != 0 && i != -1) {
                    r2dyFo85vQ5.servicioPublico.setId_client(i);
                }
                if (R2dyFo85vQ4.this.editMode) {
                    unYp8VQThY.getInstance().updateServicioPublico(R2dyFo85vQ4.this.servicioPublico);
                } else {
                    unYp8VQThY.getInstance().addServicioPublico(R2dyFo85vQ4.this.servicioPublico);
                }
                if (R2dyFo85vQ4.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) R2dyFo85vQ4.this.getActivity()).UpdateMenu();
                } else if (R2dyFo85vQ4.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) R2dyFo85vQ4.this.getActivity()).UpdateMenu();
                }
                R2dyFo85vQ4.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCuenta() {
        this.inputCFactura.getText().toString().trim().split(" ");
        if (this.inputCFactura.getText().toString().trim().isEmpty()) {
            this.inputLayoutCFactura.setError(this.context.getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCFactura);
            return false;
        }
        return true;
    }

    private boolean validateTipoCuentaFactura() {
        if (!this.editMode) {
            if (this.spinnerTCuenta.getText().toString().trim().isEmpty()) {
                this.inputLayoutSpinnerTCuenta.setError(this.context.getString(R.string.msg_seleccione_tipo_factura));
                requestFocus(this.spinnerTCuenta);
                return false;
            }
            this.tipo_cuenta = this.spinnerTCuenta.getPosition_select();
            this.inputLayoutSpinnerTCuenta.setErrorEnabled(false);
            return true;
        }
        if (!getResources().getStringArray(R.array.array_servicios_publicos)[this.servicioPublico.getTipo_servicio()].contains(this.spinnerTCuenta.getText())) {
            int position_select = this.spinnerTCuenta.getPosition_select();
            this.tipo_cuenta = position_select;
            Log.d("SPIN", String.valueOf(position_select));
            return true;
        }
        this.tipo_cuenta = this.servicioPublico.getTipo_servicio();
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
