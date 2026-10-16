package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm;

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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class hJhf3aumcr extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    public ImageButton btSearchAccount;
    public ImageButton btSearchONAT;
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
    public jN13TOyLMX.OnItemClickListener btnTipoServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            hJhf3aumcr hjhf3aumcr = hJhf3aumcr.this;
            hjhf3aumcr.isSellos = false;
            hjhf3aumcr.inputLayoutCuenta.setVisibility(0);
            hJhf3aumcr.this.lyCI.setVisibility(8);
            hJhf3aumcr.this.inputLayoutOnatAux.setVisibility(8);
            hJhf3aumcr.this.inputLayoutCuenta.setHint(hJhf3aumcr.this.context.getString(R.string.hint_identificar_servicio));
            hJhf3aumcr.this.btSearchAccount.setVisibility(0);
            switch (position) {
                case 0:
                    hJhf3aumcr.this.loadDataFacturas(0);
                    break;
                case 1:
                    hJhf3aumcr.this.loadDataFacturas(1);
                    break;
                case 2:
                    hJhf3aumcr.this.loadDataFacturas(2);
                    break;
                case 3:
                    hJhf3aumcr.this.loadDataFacturas(3);
                    break;
                case 4:
                    hJhf3aumcr.this.inputLayoutCuenta.setHint("Inserte RC05");
                    hJhf3aumcr.this.inputLayoutOnatAux.setVisibility(0);
                    hJhf3aumcr.this.inputLayoutOnatAux.setHint("Inserte el código de barra");
                    hJhf3aumcr.this.loadDataONAT();
                    break;
                case 5:
                    hJhf3aumcr.this.loadDataFacturas(2);
                    break;
                case 6:
                    hJhf3aumcr.this.loadSellos();
                    break;
                case 7:
                    hJhf3aumcr.this.loadDataFacturas(2);
                    break;
                default:
                    hJhf3aumcr.this.inputLayoutOnatAux.setVisibility(8);
                    hJhf3aumcr.this.inputLayoutCuenta.setHint(hJhf3aumcr.this.context.getString(R.string.hint_identificar_servicio));
                    break;
            }
            hJhf3aumcr hjhf3aumcr2 = hJhf3aumcr.this;
            hjhf3aumcr2.spinnerPositionSelect = position;
            hjhf3aumcr2.inputCuenta.setText(BuildConfig.FLAVOR);
            hJhf3aumcr.this.inputOnatAux.setText(BuildConfig.FLAVOR);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hJhf3aumcr.this.submitForm();
            }
        });
        this.titles = getResources().getStringArray(R.array.array_servicios_banco_metro);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_banco_metro, android.R.layout.simple_list_item_1);
        this.adapter = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipo.setAdapter(this.adapter);
        this.spinnerTipo.setOnItemClickListener(this.btnTipoServicio);
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
            String tipo = getArguments().get("tipo").toString();
            switch (tipo) {
                case "telefono":
                    this.spinnerPositionSelect = 0;
                    this.spinnerTipo.setText(this.titles[0]);
                    break;
                case "electrica":
                    this.spinnerPositionSelect = 1;
                    this.spinnerTipo.setText(this.titles[1]);
                    break;
                case "onat":
                    configureLayoutTipoPago(y2Cht3lmjg.ParcialFijoMensual);
                    this.spinnerPositionSelect = 4;
                    this.spinnerTipo.setText(this.titles[4]);
                    break;
                case "agua":
                    this.spinnerPositionSelect = 2;
                    this.spinnerTipo.setText(this.titles[2]);
                    break;
                case "gas":
                    this.spinnerPositionSelect = 3;
                    this.spinnerTipo.setText(this.titles[3]);
                    break;
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = hJhf3aumcr.this.facturasLists;
                if (list != null && list.size() > 0) {
                    hJhf3aumcr.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                List<ServicioPublico> list2 = hJhf3aumcr.this.onatList;
                if (list2 != null && list2.size() > 0) {
                    hJhf3aumcr.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(hJhf3aumcr.this.context, "No hay elementos para mostrar", 0).show();
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
        String idTipo2;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        int i = this.spinnerPositionSelect;
        if (i == 6) {
            enviarUSSDSellos();
            return;
        }
        if (i != 4) {
            if (!validateTipoCuenta() || !validateCuenta()) {
                return;
            }
            nuevoDatos();
            int i2 = this.spinnerPositionSelect;
            if (i2 == 3) {
                idTipo = String.valueOf(11);
            } else {
                idTipo = String.valueOf(i2 + 1);
            }
            if (idTipo.contains("3")) {
                idTipo = "AGUAHABANA";
            }
            if (idTipo.contains("6")) {
                idTipo = "AGUAPROVINCIAS";
            }
            if (!idTipo.contains("8")) {
                idTipo2 = idTipo;
            } else {
                idTipo2 = "AGUAVARADERO";
            }
            String factura = this.inputCuenta.getText().toString().trim();
            String msg = "Desea consultar la deuda del servicio: " + factura;
            String cadena = idTipo2 + "*" + factura;
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "47", cadena, msg, group, getFragmentManager());
            return;
        }
        if (i != 4 || !validatePagoParcialMensual()) {
            return;
        }
        String rc05 = this.inputCuenta.getText().toString().trim();
        String rcAux = this.inputOnatAux.getText().toString().trim();
        String cadena2 = rc05 + "*" + rcAux;
        String msg2 = "Desea realizar la consulta para ONAT del vector fiscal, del siguente RC05: " + rc05 + "  Código de barra: " + rcAux;
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "56", cadena2, msg2, group, getFragmentManager());
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

    private boolean validateCuenta() {
        this.inputLayoutCuenta.setErrorEnabled(false);
        this.inputLayoutOnatAux.setErrorEnabled(false);
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
        if (this.inputCuenta.getText().toString().trim().length() != 15 && this.inputCuenta.getText().toString().trim().length() != 14 && this.spinnerPositionSelect == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_tel));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (!this.inputCuenta.getText().toString().trim().substring(0, 2).contains("01") && this.spinnerPositionSelect == 0) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 13 && this.spinnerPositionSelect == 1) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_metro));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 11 && this.spinnerPositionSelect == 2) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_agua));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() == 12 || this.spinnerPositionSelect != 3) {
            return true;
        }
        this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_12_metro));
        requestFocus(this.inputCuenta);
        return false;
    }

    private boolean validatePagoParcialAnual() {
        this.inputLayoutCuenta.setErrorEnabled(false);
        this.inputLayoutOnatAux.setErrorEnabled(false);
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() < 11 || this.inputCuenta.getText().toString().trim().length() > 16) {
            this.inputLayoutCuenta.setError(getString(R.string.tx_alert_longitud_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputOnatAux.getText().toString().trim().isEmpty()) {
            this.inputLayoutOnatAux.setError("Indique el valor del campo solicitado");
            requestFocus(this.inputOnatAux);
            return false;
        }
        if (this.inputOnatAux.getText().toString().trim().length() != 7) {
            this.inputLayoutOnatAux.setError(getString(R.string.tx_alert_longitud_tributo));
            requestFocus(this.inputOnatAux);
            return false;
        }
        return true;
    }

    private boolean validatePagoParcialMensual() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() < 11 || this.inputCuenta.getText().toString().trim().length() > 16) {
            this.inputLayoutCuenta.setError(getString(R.string.tx_alert_longitud_rc05));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputOnatAux.getText().toString().trim().length() != 5) {
            this.inputLayoutOnatAux.setError(getString(R.string.tx_alert_longitud_rc04));
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
            if (this.spinnerPositionSelect == 5) {
                c.setTipo_Factura(2);
            } else {
                c.setTipo_Factura(this.spinnerTipo.getPosition_select());
            }
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg;

        static {
            int[] iArr = new int[y2Cht3lmjg.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg = iArr;
            try {
                iArr[y2Cht3lmjg.ParcialFijoMensual.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[y2Cht3lmjg.ParcialFijoAnual.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private void configureLayoutTipoPago(y2Cht3lmjg tipo) {
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$y2Cht3lmjg[tipo.ordinal()]) {
            case 1:
                this.inputLayoutCuenta.setHint("Inserte RC05");
                this.inputLayoutOnatAux.setVisibility(0);
                this.inputLayoutOnatAux.setHint("Inserte el código de barra");
                break;
            case 2:
                this.inputLayoutCuenta.setHint("Inserte RC05");
                this.inputLayoutOnatAux.setVisibility(0);
                this.inputLayoutOnatAux.setHint("Inserte el código de tributo");
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = hJhf3aumcr.this.facturasLists.get(position);
                    hJhf3aumcr.this.inputCuenta.setText(cuenta.getFactura());
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.hJhf3aumcr.5
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    ServicioPublico cuenta = hJhf3aumcr.this.onatList.get(position);
                    hJhf3aumcr.this.inputCuenta.setText(cuenta.getValor());
                }
            });
        } catch (Exception e2) {
        }
    }
}
