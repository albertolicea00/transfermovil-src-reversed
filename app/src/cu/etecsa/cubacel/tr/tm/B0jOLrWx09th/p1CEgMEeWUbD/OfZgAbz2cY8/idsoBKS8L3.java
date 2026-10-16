package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class idsoBKS8L3 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public Context context;
    public List<String> facList;
    public List<Factura> facturasLists;
    public int id_tipo_cuenta;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutOnatAux;
    public TextInputLayout inputLayoutTipo;
    private AutoCompleteTextView inputOnatAux;
    public TextInputLayout lyCI;
    public List<ServicioPublico> onatList;
    public int pos_tipo;
    public View rootView;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerTipo;
    public String tipoCuenta;
    public String[] titles;
    public List<String> tributoList;
    public AutoCompleteTextView txCI;
    public final CharSequence[] items = {"Factura Telefónica", "Factura Eléctrica"};
    public int spinnerPositionSelect = 0;
    public ArrayList<String> itemsBuscar = new ArrayList<>();
    public ArrayList<String> itemsBuscarONAT = new ArrayList<>();
    public boolean isSellos = false;
    public jN13TOyLMX.OnItemClickListener btnTipoServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            idsoBKS8L3 idsobks8l3 = idsoBKS8L3.this;
            idsobks8l3.isSellos = false;
            idsobks8l3.inputLayoutCuenta.setVisibility(0);
            idsoBKS8L3.this.lyCI.setVisibility(8);
            idsoBKS8L3.this.inputLayoutOnatAux.setVisibility(8);
            idsoBKS8L3.this.inputLayoutCuenta.setHint(idsoBKS8L3.this.context.getString(R.string.hint_identificar_servicio));
            idsoBKS8L3.this.btSearchAccount.setVisibility(0);
            idsoBKS8L3 idsobks8l4 = idsoBKS8L3.this;
            idsobks8l4.spinnerPositionSelect = position;
            idsobks8l4.inputCuenta.setText(BuildConfig.FLAVOR);
            idsoBKS8L3.this.inputOnatAux.setText(BuildConfig.FLAVOR);
            switch (position) {
                case 0:
                    idsoBKS8L3.this.loadDataFacturas(0);
                    break;
                case 1:
                    idsoBKS8L3.this.loadDataFacturas(1);
                    break;
                case 2:
                    idsoBKS8L3.this.loadDataONAT();
                    idsoBKS8L3.this.inputLayoutCuenta.setHint("Inserte RC05");
                    idsoBKS8L3.this.inputLayoutOnatAux.setVisibility(8);
                    idsoBKS8L3.this.inputLayoutOnatAux.setHint("Inserte el código de barra");
                    break;
                case 3:
                    idsoBKS8L3.this.loadDataONAT();
                    idsoBKS8L3.this.inputLayoutCuenta.setHint("Inserte RC05");
                    idsoBKS8L3.this.inputLayoutOnatAux.setVisibility(0);
                    idsoBKS8L3.this.inputLayoutOnatAux.setHint("Inserte RC04A");
                    break;
                case 4:
                    idsoBKS8L3.this.loadDataFacturas(3);
                    break;
                case 5:
                    idsoBKS8L3.this.loadDataFacturas(2);
                    break;
                case 6:
                    idsoBKS8L3.this.loadDataFacturas(2);
                    break;
                case 7:
                    idsoBKS8L3.this.loadSellos();
                    break;
                case 8:
                    idsoBKS8L3.this.loadDataFacturas(2);
                    break;
                default:
                    idsoBKS8L3.this.inputLayoutOnatAux.setVisibility(8);
                    idsoBKS8L3.this.inputLayoutCuenta.setHint(idsoBKS8L3.this.context.getString(R.string.hint_identificar_servicio));
                    break;
            }
            idsoBKS8L3 idsobks8l5 = idsoBKS8L3.this;
            idsobks8l5.spinnerPositionSelect = position;
            idsobks8l5.inputCuenta.setText(BuildConfig.FLAVOR);
            idsoBKS8L3.this.inputOnatAux.setText(BuildConfig.FLAVOR);
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
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.txCI = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.lyCI.setVisibility(8);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                idsoBKS8L3.this.submitForm();
            }
        });
        this.titles = getResources().getStringArray(R.array.array_servicios_banco_bandec);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_banco_bandec, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        this.spinnerTipo.setOnItemClickListener(this.btnTipoServicio);
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
            String tipo = getArguments().get("tipo").toString();
            switch (tipo) {
                case "telefono":
                    this.spinnerTipo.setText(this.titles[0]);
                    this.id_tipo_cuenta = 0;
                    break;
                case "electrica":
                    this.spinnerTipo.setText(this.titles[1]);
                    this.id_tipo_cuenta = 1;
                    break;
                case "onat":
                    showDialogFormadePagoONAT();
                    this.id_tipo_cuenta = 1;
                    break;
                case "gas":
                    this.spinnerTipo.setText(this.titles[4]);
                    this.id_tipo_cuenta = 4;
                    break;
                case "agua":
                    this.spinnerTipo.setText(this.titles[5]);
                    this.id_tipo_cuenta = 5;
                    break;
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = idsoBKS8L3.this.facturasLists;
                if (list != null && list.size() > 0) {
                    idsoBKS8L3.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                List<ServicioPublico> list2 = idsoBKS8L3.this.onatList;
                if (list2 != null && list2.size() > 0) {
                    idsoBKS8L3.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(idsoBKS8L3.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        this.btSearchAccount.setVisibility(8);
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

    public void loadDataONAT() {
        unYp8VQThY.init(this.context);
        this.onatList = unYp8VQThY.getInstance().getAllServicioPublicoLists();
        this.tributoList = new ArrayList();
        for (ServicioPublico wl : this.onatList) {
            this.tributoList.add(wl.getValor());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.tributoList);
        this.inputCuenta.setAdapter(adapter1);
        loadSearchSpinnerONAT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String idTipo;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        int i = this.spinnerPositionSelect;
        if (i == 7) {
            enviarUSSDSellos();
            return;
        }
        if (i != 2 && i != 3) {
            if (!validateTipoCuenta()) {
                return;
            }
            String idTipo2 = String.valueOf(this.spinnerPositionSelect + 1);
            if (idTipo2.contains("6")) {
                idTipo2 = "AGUAHABANA";
            }
            if (idTipo2.contains("7")) {
                idTipo2 = "AGUAPROVINCIAS";
            }
            if (!idTipo2.contains("9")) {
                idTipo = idTipo2;
            } else {
                idTipo = "AGUAVARADERO";
            }
            nuevoDatos();
            String factura = this.inputCuenta.getText().toString().trim();
            String msg = "Desea consultar la deuda de la factura: " + factura;
            String cadena = idTipo + "*" + factura;
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "47", cadena, msg, group, getFragmentManager());
            return;
        }
        if (i == 2) {
            if (!validatePagoParcialMensual()) {
                return;
            }
            String rc05 = this.inputCuenta.getText().toString().trim();
            String cadena2 = rc05 + "*00000";
            String msg2 = "Desea realizar la consulta para ONAT Completa, del siguente RC05: " + rc05;
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "56", cadena2, msg2, group, getFragmentManager());
            return;
        }
        if (i != 3 || !validatePagoParcialAnual()) {
            return;
        }
        String rc06 = this.inputCuenta.getText().toString().trim();
        String rcAux = this.inputOnatAux.getText().toString().trim();
        String cadena3 = rc06 + "*" + rcAux;
        String msg3 = "Desea realizar la consulta para ONAT del siguente RC05: " + rc06 + " con RC04A: " + rcAux;
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "56", cadena3, msg3, group, getFragmentManager());
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
        if (this.inputCuenta.getText().toString().trim().length() != 13 && this.pos_tipo == 1) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() == 16 || this.inputCuenta.getText().toString().trim().length() == 14 || this.pos_tipo != 6) {
            return true;
        }
        this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_almenos_aguaprovincias));
        requestFocus(this.inputCuenta);
        return false;
    }

    private boolean validatePagoParcialMensual() {
        this.inputLayoutCuenta.setErrorEnabled(false);
        this.inputLayoutOnatAux.setErrorEnabled(false);
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() < 11 || this.inputCuenta.getText().toString().trim().length() > 16) {
            this.inputLayoutCuenta.setError("Código de RC05 inválido");
            requestFocus(this.inputCuenta);
            return false;
        }
        return true;
    }

    private boolean validatePagoParcialAnual() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() < 11 || this.inputCuenta.getText().toString().trim().length() > 16) {
            this.inputLayoutCuenta.setError("Código de RC05 inválido");
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputOnatAux.getText().toString().trim().length() != 5) {
            this.inputLayoutOnatAux.setError("Código de RC04 inválido");
            requestFocus(this.inputOnatAux);
            return false;
        }
        return true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSellos() {
        this.lyCI.setVisibility(0);
        this.inputLayoutCuenta.setVisibility(8);
        this.btSearchAccount.setVisibility(8);
        this.isSellos = true;
    }

    private boolean enviarUSSDSellos() {
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
            c.setFactura(edit_factura);
            int posReal = 0;
            switch (this.spinnerPositionSelect) {
                case 0:
                    posReal = 0;
                    break;
                case 1:
                    posReal = 1;
                    break;
                case 2:
                    posReal = 4;
                    break;
                case 3:
                    posReal = 4;
                    break;
                case 4:
                    posReal = 3;
                    break;
                case 5:
                    posReal = 2;
                    break;
                case 6:
                    posReal = 2;
                    break;
            }
            c.setTipo_Factura(posReal);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    public void createAlertDialog(String mensaje_dialog, ViewGroup group, final Uri number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm).setMessage(Html.fromHtml(mensaje_dialog)).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    idsoBKS8L3.this.getFragmentManager().popBackStack();
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    idsoBKS8L3.this.startActivity(dial);
                } catch (Exception e) {
                }
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    private void showDialogFormadePagoONAT() {
        CharSequence[] items = {"Servicio ONAT Completo", "Servicio ONAT con RC04"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de consulta a realizar:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new Bundle();
                FragmentManager mFragmentManager = idsoBKS8L3.this.getActivity().getSupportFragmentManager();
                mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        idsoBKS8L3.this.configureLayoutTipoPago(2);
                        idsoBKS8L3 idsobks8l3 = idsoBKS8L3.this;
                        idsobks8l3.spinnerPositionSelect = 2;
                        idsobks8l3.spinnerTipo.setText(idsobks8l3.titles[2]);
                        break;
                    case 1:
                        idsoBKS8L3.this.configureLayoutTipoPago(3);
                        idsoBKS8L3 idsobks8l4 = idsoBKS8L3.this;
                        idsobks8l4.spinnerPositionSelect = 3;
                        idsobks8l4.spinnerTipo.setText(idsobks8l4.titles[3]);
                        break;
                }
            }
        });
        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = idsoBKS8L3.this.facturasLists;
                if (list != null && list.size() > 0) {
                    idsoBKS8L3.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(idsoBKS8L3.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureLayoutTipoPago(int tipo) {
        switch (tipo) {
            case 2:
                this.inputLayoutCuenta.setHint("Inserte RC05");
                this.inputLayoutOnatAux.setVisibility(8);
                break;
            case 3:
                this.inputLayoutCuenta.setHint("Inserte RC05");
                this.inputLayoutOnatAux.setVisibility(0);
                this.inputLayoutOnatAux.setHint("Inserte el RC04A");
                break;
            default:
                this.inputLayoutOnatAux.setVisibility(8);
                this.inputLayoutCuenta.setHint(this.context.getString(R.string.hint_identificar_servicio));
                break;
        }
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.9
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = idsoBKS8L3.this.facturasLists.get(position);
                    idsoBKS8L3.this.inputCuenta.setText(cuenta.getFactura());
                }
            });
        } catch (Exception e2) {
        }
    }

    private void loadSearchSpinnerONAT() {
        try {
            this.itemsBuscarONAT = new ArrayList<>();
            List<ServicioPublico> list = this.onatList;
            if (list != null && list.size() > 0) {
                for (ServicioPublico uyh0pxs9m37in : this.onatList) {
                    String facura = uyh0pxs9m37in.getValor();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getValor();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getValor();
                    }
                    this.itemsBuscarONAT.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.itemsBuscarONAT, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.idsoBKS8L3.10
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    ServicioPublico cuenta = idsoBKS8L3.this.onatList.get(position);
                    idsoBKS8L3.this.inputCuenta.setText(cuenta.getValor());
                }
            });
        } catch (Exception e2) {
        }
    }
}
