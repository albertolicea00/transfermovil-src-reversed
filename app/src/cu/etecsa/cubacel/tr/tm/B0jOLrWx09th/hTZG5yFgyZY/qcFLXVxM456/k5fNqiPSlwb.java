package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456;

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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k5fNqiPSlwb extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapter;
    public ImageButton btSearchAccount;
    public ImageButton btSearchONAT;
    private Button btnAceptar;
    public Context context;
    public List<String> facList;
    public List<Factura> facturasLists;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutOnatAux;
    public TextInputLayout inputLayoutTipo;
    private AutoCompleteTextView inputOnatAux;
    public TextInputLayout lyCI;
    public pAzq93vIl3 manager;
    public List<ServicioPublico> onatList;
    public View rootView;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerTipo;
    public String[] titles;
    public List<String> tributoList;
    public AutoCompleteTextView txCI;
    public int spinnerPositionSelect = 0;
    public ArrayList<String> itemsBuscar = new ArrayList<>();
    public ArrayList<String> itemsBuscarONAT = new ArrayList<>();
    public boolean isAGTelecom = false;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener btnTipoServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            k5fNqiPSlwb.this.inputLayoutOnatAux.setVisibility(8);
            k5fNqiPSlwb.this.inputLayoutCuenta.setHint(k5fNqiPSlwb.this.context.getString(R.string.hint_identificar_servicio));
            k5fNqiPSlwb.this.btSearchAccount.setVisibility(0);
            switch (position) {
                case 0:
                    k5fNqiPSlwb.this.loadDataFacturas(0);
                    break;
                case 1:
                    k5fNqiPSlwb.this.loadDataFacturas(1);
                    break;
                case 2:
                    k5fNqiPSlwb.this.loadDataFacturas(2);
                    break;
                case 3:
                    k5fNqiPSlwb.this.loadDataFacturas(3);
                    break;
                case 4:
                    k5fNqiPSlwb.this.loadDataFacturas(2);
                    break;
                default:
                    k5fNqiPSlwb.this.inputLayoutOnatAux.setVisibility(8);
                    k5fNqiPSlwb.this.inputLayoutCuenta.setHint(k5fNqiPSlwb.this.context.getString(R.string.hint_identificar_servicio));
                    break;
            }
            k5fNqiPSlwb k5fnqipslwb = k5fNqiPSlwb.this;
            k5fnqipslwb.spinnerPositionSelect = position;
            k5fnqipslwb.inputCuenta.setText(BuildConfig.FLAVOR);
            k5fNqiPSlwb.this.inputOnatAux.setText(BuildConfig.FLAVOR);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.paajyn57pxcmh, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k5fNqiPSlwb.this.submitForm();
            }
        });
        this.titles = getResources().getStringArray(R.array.array_servicios_bolsa);
        this.inputLayoutTipo = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_cuenta);
        this.spinnerTipo = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoNautaCuenta);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_bolsa, android.R.layout.simple_list_item_1);
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
                case "agua":
                    this.spinnerPositionSelect = 2;
                    this.spinnerTipo.setText(this.titles[2]);
                    break;
                case "gas":
                    this.spinnerPositionSelect = 3;
                    this.spinnerTipo.setText(this.titles[3]);
                    break;
                case "onat":
                    configureLayoutTipoPago(y2Cht3lmjg.ParcialFijoMensual);
                    this.spinnerPositionSelect = 4;
                    this.spinnerTipo.setText(this.titles[4]);
                    break;
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = k5fNqiPSlwb.this.facturasLists;
                if (list != null && list.size() > 0) {
                    k5fNqiPSlwb.this.spinnerDialog.showSpinerDialog();
                    return;
                }
                List<ServicioPublico> list2 = k5fNqiPSlwb.this.onatList;
                if (list2 != null && list2.size() > 0) {
                    k5fNqiPSlwb.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(k5fNqiPSlwb.this.context, "No hay elementos para mostrar", 0).show();
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
        if (!validateTipoCuenta() || !validateCuenta()) {
            return;
        }
        nuevoDatos();
        int i = this.spinnerPositionSelect;
        if (i == 1) {
        }
        if (i == 2) {
            idTipo = "AGUAHABANA";
        } else if (i == 3) {
            idTipo = "GASM";
        } else if (i == 4) {
            idTipo = "AGUAVARADERO";
        } else {
            String idTipo2 = String.valueOf(i + 1);
            idTipo = idTipo2;
        }
        String factura = this.inputCuenta.getText().toString().trim();
        String msg = "Desea consultar la deuda del servicio: " + factura;
        String cadena = idTipo + "*" + factura;
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "47", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "47", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
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
        if (this.inputCuenta.getText().toString().trim().length() != 12 && this.spinnerPositionSelect == 3) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_12_metro));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() <= 15 || this.spinnerPositionSelect != 5) {
            return true;
        }
        this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_almenos_15));
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb$6, reason: invalid class name */
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = k5fNqiPSlwb.this.facturasLists.get(position);
                    k5fNqiPSlwb.this.inputCuenta.setText(cuenta.getFactura());
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb.5
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    ServicioPublico cuenta = k5fNqiPSlwb.this.onatList.get(position);
                    k5fNqiPSlwb.this.inputCuenta.setText(cuenta.getValor());
                }
            });
        } catch (Exception e2) {
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
