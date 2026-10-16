package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xoZnbyoSLT extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public Context context;
    public List<String> facList;
    public List<Factura> facturasLists;
    public String idTipo;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutOnatAux;
    public TextInputLayout inputLayoutTipo;
    private AutoCompleteTextView inputOnatAux;
    public TextInputLayout lyCI;
    public int pos_tipo;
    public View rootView;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public String[] titles;
    public AutoCompleteTextView txCI;
    public final CharSequence[] items = {"Factura Telefónica", "Factura Eléctrica"};
    public int id_tipo_cuenta = -1;
    public ArrayList<String> itemsBuscar = new ArrayList<>();
    public boolean isSellos = false;
    public jN13TOyLMX.OnItemClickListener spClickServicios = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            xoZnbyoSLT xoznbyoslt = xoZnbyoSLT.this;
            xoznbyoslt.isSellos = false;
            xoznbyoslt.inputLayoutCuenta.setVisibility(0);
            xoZnbyoSLT.this.lyCI.setVisibility(8);
            xoZnbyoSLT.this.idTipo = String.valueOf(position + 1);
            xoZnbyoSLT xoznbyoslt2 = xoZnbyoSLT.this;
            xoznbyoslt2.pos_tipo = position;
            xoznbyoslt2.btSearchAccount.setVisibility(0);
            xoZnbyoSLT.this.inputCuenta.setText(BuildConfig.FLAVOR);
            switch (position) {
                case 0:
                    xoZnbyoSLT.this.loadDataFacturas(0);
                    break;
                case 1:
                    xoZnbyoSLT.this.loadDataFacturas(1);
                    break;
                case 2:
                    xoZnbyoSLT.this.loadDataFacturas(2);
                    break;
                case 3:
                    xoZnbyoSLT.this.loadDataFacturas(3);
                    break;
                case 4:
                    xoZnbyoSLT.this.loadDataFacturas(2);
                    break;
                case 5:
                    xoZnbyoSLT.this.loadSellos();
                    break;
                case 6:
                    xoZnbyoSLT.this.loadDataFacturas(2);
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.paajyn57pxcmh, container, false);
        this.context = container.getContext();
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutOnatAux = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_onat_rc04);
        this.inputOnatAux = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_onat_rc04);
        this.inputLayoutOnatAux.setVisibility(8);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = xoZnbyoSLT.this.facturasLists;
                if (list != null && list.size() > 0) {
                    xoZnbyoSLT.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(xoZnbyoSLT.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        this.btSearchAccount.setVisibility(8);
        this.titles = getResources().getStringArray(R.array.array_servicios_banco_bpa);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_banco_bpa, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        this.spinnerTipo.setOnItemClickListener(this.spClickServicios);
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
            String tipo = getArguments().get("tipo").toString();
            switch (tipo) {
                case "telefono":
                    this.pos_tipo = 0;
                    this.spinnerTipo.setText(this.titles[0]);
                    this.id_tipo_cuenta = 0;
                    break;
                case "electrica":
                    this.pos_tipo = 1;
                    this.spinnerTipo.setText(this.titles[1]);
                    this.id_tipo_cuenta = 1;
                    break;
                case "agua":
                    this.pos_tipo = 2;
                    this.id_tipo_cuenta = 2;
                    this.spinnerTipo.setText(this.titles[2]);
                    break;
                case "gas":
                    this.pos_tipo = 3;
                    this.id_tipo_cuenta = 3;
                    this.spinnerTipo.setText(this.titles[3]);
                    break;
                case "agua_provincias":
                    this.pos_tipo = 4;
                    this.id_tipo_cuenta = 4;
                    this.spinnerTipo.setText(this.titles[4]);
                    break;
            }
            this.idTipo = String.valueOf(this.pos_tipo + 1);
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (xoZnbyoSLT.this.idTipo.contains("6")) {
                    xoZnbyoSLT.this.enviarUSSDSellos();
                } else {
                    xoZnbyoSLT.this.submitForm();
                }
            }
        });
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.txCI = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.lyCI.setVisibility(8);
        return this.rootView;
    }

    public void loadDataFacturas(int servicio) {
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(servicio);
        this.facList = new ArrayList();
        for (Factura wl : this.facturasLists) {
            this.facList.add(wl.getFactura());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.inputCuenta.setAdapter(adapter1);
        loadSearchSpinner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateTipoCuenta() || !validateCuenta()) {
            return;
        }
        nuevoDatos();
        if (this.idTipo.contains("3")) {
            this.idTipo = "11";
        }
        if (this.idTipo.contains("3")) {
            this.idTipo = "AGUAHABANA";
        }
        if (this.idTipo.contains("5")) {
            this.idTipo = "AGUAPROVINCIAS";
        }
        if (this.idTipo.contains("7")) {
            this.idTipo = "AGUAVARADERO";
        }
        String factura = this.inputCuenta.getText().toString().trim();
        String msg = "Desea consultar la deuda de la factura: " + factura;
        String cadena = this.idTipo + "*" + factura;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "47", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCuenta.getText().toString().trim().split(" ");
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() < 8) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_espacions_en_blanco));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 15 && this.inputCuenta.getText().toString().trim().length() != 14 && this.pos_tipo == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!this.inputCuenta.getText().toString().trim().substring(0, 2).contains("01") && this.pos_tipo == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() == 13 || this.pos_tipo != 1) {
            return true;
        }
        this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta));
        requestFocus(this.inputCuenta);
        return false;
    }

    private boolean validateTipoCuenta() {
        if (this.spinnerTipo.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipo.setError("Seleccione el tipo de servicio");
            requestFocus(this.spinnerTipo);
            return false;
        }
        this.inputLayoutTipo.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            if (this.pos_tipo == 4) {
                c.setTipo_Factura(2);
            } else {
                c.setTipo_Factura(this.spinnerTipo.getPosition_select());
            }
            c.setFactura(edit_factura);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSellos() {
        this.lyCI.setVisibility(0);
        this.inputLayoutCuenta.setVisibility(8);
        this.btSearchAccount.setVisibility(8);
        this.isSellos = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enviarUSSDSellos() {
        if (!validateCi()) {
            return false;
        }
        try {
            String ci = this.txCI.getText().toString().trim();
            String cadena = ci + "*1";
            String msg = "¿Desea consultar los últimos sellos para el carné de identidad: " + ci + " ?";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "22", cadena, msg, group, getFragmentManager());
            return true;
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
            return true;
        }
    }

    private boolean validateCi() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_len_ci_all));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    private void loadSearchSpinner() {
        try {
            this.itemsBuscar = new ArrayList<>();
            List<Factura> list = this.facturasLists;
            if (list != null && list.size() > 0) {
                for (Factura uyh0pxs9m37in : this.facturasLists) {
                    String facura = uyh0pxs9m37in.getFactura();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getFactura();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getFactura();
                    }
                    this.itemsBuscar.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.itemsBuscar, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = xoZnbyoSLT.this.facturasLists.get(position);
                    xoZnbyoSLT.this.inputCuenta.setText(cuenta.getFactura());
                }
            });
        } catch (Exception e2) {
        }
    }
}
