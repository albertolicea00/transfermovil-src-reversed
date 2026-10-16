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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bJaiFoVYfK extends Fragment {
    public Factura Factura;
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    private EditText inputCFactura;
    private TextInputLayout inputLayoutCFactura;
    private TextInputLayout inputLayoutSpinnerCliente;
    private TextInputLayout inputLayoutSpinnerTCuenta;
    public jN13TOyLMX spinnerCliente;
    public jN13TOyLMX spinnerTCuenta;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public int tipo_cuenta = -1;
    public int edit_tipo_cuenta = -1;
    public boolean editMode = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            bJaiFoVYfK bjaifovyfk = bJaiFoVYfK.this;
            bjaifovyfk.id_cliente_select = bjaifovyfk.clientsList.get(bjaifovyfk.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vr5lijojrgj2t, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutCFactura = (TextInputLayout) rootView.findViewById(R.id.input__layout_cFactura);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputCFactura = (EditText) rootView.findViewById(R.id.input_cFactura);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.spinnerTCuenta = (jN13TOyLMX) rootView.findViewById(R.id.spinnerTipoFactura);
        this.inputLayoutSpinnerTCuenta = (TextInputLayout) rootView.findViewById(R.id.input__layout_gtipocuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios, android.R.layout.simple_list_item_1);
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
            this.toolbar_title.setText(R.string.editar_factura);
            int idfactura = Integer.parseInt(getArguments().get("Id").toString());
            unYp8VQThY.init(this.context);
            Factura facturaListWithId = unYp8VQThY.getInstance().getFacturaListWithId(idfactura);
            this.Factura = facturaListWithId;
            this.inputCFactura.setText(facturaListWithId.getFactura());
            if (this.Factura.getId_client() > 0) {
                try {
                    Client cl = unYp8VQThY.getInstance().getClientListWithId(this.Factura.getId_client());
                    this.spinnerCliente.setText(cl.getName());
                    this.id_cliente_select = cl.getId();
                } catch (Exception e) {
                }
            }
            this.spinnerTCuenta.setText(this.tcuentaAdapter.getItem(this.Factura.getTipo_Factura()).toString());
            this.tipo_cuenta = this.Factura.getTipo_Factura();
            this.editMode = true;
        } else {
            this.toolbar_title.setText(R.string.nueva_factura);
            this.Factura = new Factura();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bJaiFoVYfK.this.submitForm();
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
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bJaiFoVYfK bjaifovyfk = bJaiFoVYfK.this;
                    bjaifovyfk.lista_vacia = true;
                    bjaifovyfk.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    bJaiFoVYfK.this.lista_vacia = false;
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(bJaiFoVYfK.this.context);
                bJaiFoVYfK bjaifovyfk = bJaiFoVYfK.this;
                bjaifovyfk.Factura.setFactura(bjaifovyfk.inputCFactura.getText().toString().trim());
                bJaiFoVYfK bjaifovyfk2 = bJaiFoVYfK.this;
                bjaifovyfk2.Factura.setTipo_Factura(bjaifovyfk2.tipo_cuenta);
                bJaiFoVYfK bjaifovyfk3 = bJaiFoVYfK.this;
                int i = bjaifovyfk3.id_cliente_select;
                if (i != 0 && i != -1) {
                    bjaifovyfk3.Factura.setId_client(i);
                }
                if (bJaiFoVYfK.this.editMode) {
                    unYp8VQThY.getInstance().updateFactura(bJaiFoVYfK.this.Factura);
                } else {
                    unYp8VQThY.getInstance().addFactura(bJaiFoVYfK.this.Factura);
                }
                if (bJaiFoVYfK.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) bJaiFoVYfK.this.getActivity()).UpdateMenu();
                } else if (bJaiFoVYfK.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) bJaiFoVYfK.this.getActivity()).UpdateMenu();
                }
                bJaiFoVYfK.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCFactura.getText().toString().trim().split(" ");
        if (this.inputCFactura.getText().toString().trim().isEmpty()) {
            this.inputLayoutCFactura.setError(this.context.getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCFactura);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCFactura.setError(this.context.getString(R.string.err_msg_espacions_en_blanco));
            requestFocus(this.inputCFactura);
            return false;
        }
        if (this.inputCFactura.getText().toString().trim().length() != 15 && this.inputCFactura.getText().toString().trim().length() != 14 && this.tipo_cuenta == 0) {
            this.inputLayoutCFactura.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCFactura);
            return false;
        }
        if (!this.inputCFactura.getText().toString().trim().substring(0, 2).contains("01") && this.tipo_cuenta == 0) {
            this.inputLayoutCFactura.setError(getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCFactura);
            return false;
        }
        if (this.inputCFactura.getText().toString().trim().length() != 13 && this.tipo_cuenta == 1) {
            this.inputLayoutCFactura.setError(getString(R.string.err_msg_len_cuenta));
            requestFocus(this.inputCFactura);
            return false;
        }
        if (this.inputCFactura.getText().toString().trim().length() != 12 && this.tipo_cuenta == 3) {
            this.inputLayoutCFactura.setError(getString(R.string.err_msg_len_cuenta_12_metro));
            requestFocus(this.inputCFactura);
            return false;
        }
        boolean z = this.editMode;
        if ((z && (!z || this.inputCFactura.getText().toString().contains(this.Factura.getFactura().toString().trim()))) || unYp8VQThY.getInstance().getFacturaListsWithFactura(this.inputCFactura.getText().toString().trim()).size() == 0) {
            return true;
        }
        this.inputLayoutCFactura.setError(getString(R.string.err_txt_num_factura_existe));
        requestFocus(this.inputCFactura);
        return false;
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
        if (!getResources().getStringArray(R.array.array_servicios)[this.Factura.getTipo_Factura()].contains(this.spinnerTCuenta.getText())) {
            int position_select = this.spinnerTCuenta.getPosition_select();
            this.tipo_cuenta = position_select;
            Log.d("SPIN", String.valueOf(position_select));
            return true;
        }
        this.tipo_cuenta = this.Factura.getTipo_Factura();
        return true;
    }

    private boolean validateSpinnerCliente() {
        if (this.spinnerCliente.getText().toString().trim().isEmpty()) {
            return false;
        }
        this.id_cliente_select = this.clientsList.get(this.spinnerCliente.getPosition_select()).getId();
        this.lista_vacia = true;
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
