package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.n1lAq5KrpfE;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.qkUMT7ePEQ;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class cAnuWG2fly extends Fragment {
    private Button btnAceptar;
    public Client cliente;
    public Context context;
    private EditText inputAddress;
    private EditText inputCi;
    private TextInputLayout inputLayoutAddress;
    private TextInputLayout inputLayoutCi;
    private TextInputLayout inputLayoutName;
    private TextInputLayout inputLayoutPhone;
    private EditText inputName;
    private EditText inputPhone;
    public TextView toolbar_title;
    public boolean editMode = false;
    public int IdCliente = -1;
    public int cantidad_fijos = 0;
    public int cantidad_moviles = 0;
    public int cantidad_nauta = 0;
    public int cantidad_facturas = 0;
    public boolean clientOrPropert = true;
    public n1lAq5KrpfE.OnItemClickListener onItemClickClientsListener = new n1lAq5KrpfE.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.cAnuWG2fly.2
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.n1lAq5KrpfE.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = cAnuWG2fly.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            Bundle c = new Bundle();
            c.putString("IdCliente", String.valueOf(cAnuWG2fly.this.IdCliente));
            if (cAnuWG2fly.this.clientOrPropert) {
                switch (position) {
                    case 0:
                        e0KJzgOJUI fijos = new e0KJzgOJUI();
                        fijos.setArguments(c);
                        mFragmentTransaction.replace(R.id.containerView, fijos).addToBackStack(null).commit();
                        break;
                    case 1:
                        ENqS9qPLC9 moviles = new ENqS9qPLC9();
                        moviles.setArguments(c);
                        mFragmentTransaction.replace(R.id.containerView, moviles).addToBackStack(null).commit();
                        break;
                    case 2:
                        YhCZLEFD5F nauta = new YhCZLEFD5F();
                        nauta.setArguments(c);
                        mFragmentTransaction.replace(R.id.containerView, nauta).addToBackStack(null).commit();
                        break;
                    case 3:
                        u4cIRj4DZJT facturasFragments = new u4cIRj4DZJT();
                        facturasFragments.setArguments(c);
                        mFragmentTransaction.replace(R.id.containerView, facturasFragments).addToBackStack(null).commit();
                        break;
                }
            }
            switch (position) {
                case 0:
                    u4cIRj4DZJT facturasFragments2 = new u4cIRj4DZJT();
                    facturasFragments2.setArguments(c);
                    mFragmentTransaction.replace(R.id.containerView, facturasFragments2).addToBackStack(null).commit();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dtjgyroqsv4cz, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutName = (TextInputLayout) rootView.findViewById(R.id.input__layout_name);
        this.inputName = (EditText) rootView.findViewById(R.id.input_name);
        this.inputLayoutCi = (TextInputLayout) rootView.findViewById(R.id.input__layout_ci);
        this.inputCi = (EditText) rootView.findViewById(R.id.input_ci);
        this.inputLayoutAddress = (TextInputLayout) rootView.findViewById(R.id.input__layout_address);
        this.inputAddress = (EditText) rootView.findViewById(R.id.input_address);
        try {
            if (getActivity() instanceof IHVTCBmiLV) {
                this.clientOrPropert = true;
            } else if (getActivity() instanceof S9ycHcoxAzy) {
                this.clientOrPropert = false;
            }
            if (getArguments() != null) {
                if (this.clientOrPropert) {
                    this.toolbar_title.setText(R.string.title_edit_cliente);
                } else {
                    this.toolbar_title.setText(R.string.title_edit_propietario);
                }
                this.IdCliente = Integer.parseInt(getArguments().get("Id").toString());
                unYp8VQThY.init(this.context);
                Client clientListWithId = unYp8VQThY.getInstance().getClientListWithId(this.IdCliente);
                this.cliente = clientListWithId;
                this.inputName.setText(clientListWithId.getName());
                this.inputCi.setText(this.cliente.getCi());
                this.inputAddress.setText(this.cliente.getAddress());
                this.editMode = true;
            } else {
                if (this.clientOrPropert) {
                    this.toolbar_title.setText(R.string.title_new_cliente);
                } else {
                    this.toolbar_title.setText(R.string.title_new_propietario);
                }
                this.cliente = new Client();
            }
        } catch (Exception e) {
        }
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.context);
        rv.setLayoutManager(llm);
        rv.setNestedScrollingEnabled(false);
        List<qkUMT7ePEQ> items = new ArrayList<>();
        try {
            count_operation_asoc();
            if (this.clientOrPropert) {
                qkUMT7ePEQ factura = new qkUMT7ePEQ();
                factura.setTitulo("Telefonos Fijos Asociados");
                factura.setSubtitulo(this.context.getString(R.string.OP_Consulat_Deuda));
                factura.setIcono(R.drawable.ico_agent_pagar_fact);
                factura.setCantidad(String.valueOf(this.cantidad_fijos));
                items.add(factura);
                qkUMT7ePEQ movil = new qkUMT7ePEQ();
                movil.setTitulo("Moviles Asociados");
                movil.setSubtitulo(this.context.getString(R.string.OP_Recg_movil));
                movil.setIcono(R.drawable.ico_agent_recargar);
                movil.setCantidad(String.valueOf(this.cantidad_moviles));
                items.add(movil);
                qkUMT7ePEQ nauta = new qkUMT7ePEQ();
                nauta.setTitulo("Cuentas Nautas Asociadas");
                nauta.setSubtitulo("Recargar cuentas nautas");
                nauta.setIcono(R.drawable.ico_agente_nauta);
                nauta.setCantidad(String.valueOf(this.cantidad_nauta));
                items.add(nauta);
            }
            Fr52O1uSYF msap = new Fr52O1uSYF();
            if (!msap.getCodigoBanco().contains("-1") && !msap.getCodigoBanco().isEmpty()) {
                qkUMT7ePEQ factura_banco = new qkUMT7ePEQ();
                factura_banco.setTitulo("Facturas Asociadas");
                factura_banco.setSubtitulo("Pagar facturas");
                factura_banco.setIcono(R.drawable.ico_agent_consultar_factura);
                factura_banco.setCantidad(String.valueOf(this.cantidad_facturas));
                items.add(factura_banco);
            }
            n1lAq5KrpfE clienteAdapter = new n1lAq5KrpfE(this.context, items);
            rv.setAdapter(clienteAdapter);
            clienteAdapter.setOnItemClickListener(this.onItemClickClientsListener);
        } catch (Exception e2) {
        }
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.cAnuWG2fly.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cAnuWG2fly.this.submitForm();
            }
        });
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateName() || !validateCi()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.cAnuWG2fly.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(cAnuWG2fly.this.context);
                cAnuWG2fly canuwg2fly = cAnuWG2fly.this;
                canuwg2fly.cliente.setName(canuwg2fly.inputName.getText().toString());
                cAnuWG2fly canuwg2fly2 = cAnuWG2fly.this;
                canuwg2fly2.cliente.setCi(canuwg2fly2.inputCi.getText().toString());
                cAnuWG2fly canuwg2fly3 = cAnuWG2fly.this;
                canuwg2fly3.cliente.setAddress(canuwg2fly3.inputAddress.getText().toString());
                if (cAnuWG2fly.this.editMode) {
                    unYp8VQThY.getInstance().updateClient(cAnuWG2fly.this.cliente);
                } else {
                    unYp8VQThY.getInstance().addClient(cAnuWG2fly.this.cliente);
                }
                if (cAnuWG2fly.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) cAnuWG2fly.this.getActivity()).UpdateMenu();
                } else if (cAnuWG2fly.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) cAnuWG2fly.this.getActivity()).UpdateMenu();
                }
                cAnuWG2fly.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateName() {
        if (this.inputName.getText().toString().trim().isEmpty()) {
            this.inputLayoutName.setError(getString(R.string.err_msg_empty_nombre));
            requestFocus(this.inputName);
            return false;
        }
        this.inputLayoutName.setErrorEnabled(false);
        return true;
    }

    private boolean validateCi() {
        if (!this.inputCi.getText().toString().trim().isEmpty() && this.inputCi.getText().toString().trim().length() != 11) {
            this.inputLayoutCi.setError(getString(R.string.err_msg_len_ci));
            requestFocus(this.inputCi);
            return false;
        }
        this.inputLayoutCi.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private void count_operation_asoc() {
        List<TelfFijo> fijos = unYp8VQThY.getInstance().getFijoListsWithCliente(this.IdCliente);
        List<TeflMovil> moviles = unYp8VQThY.getInstance().getMovilListsWithCliente(this.IdCliente);
        List<Nauta> nautas = unYp8VQThY.getInstance().getNautaListsWithClient(this.IdCliente);
        List<Factura> facturas = unYp8VQThY.getInstance().getFacturasListsWithCliente(this.IdCliente);
        if (fijos.size() > 0) {
            this.cantidad_fijos = fijos.size();
        }
        if (moviles.size() > 0) {
            this.cantidad_moviles = moviles.size();
        }
        if (nautas.size() > 0) {
            this.cantidad_nauta = nautas.size();
        }
        if (facturas.size() > 0) {
            this.cantidad_facturas = facturas.size();
        }
    }
}
