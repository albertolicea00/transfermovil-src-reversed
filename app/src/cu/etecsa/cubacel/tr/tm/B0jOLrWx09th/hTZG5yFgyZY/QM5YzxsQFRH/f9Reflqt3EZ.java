package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.EntidadEfectivo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f9Reflqt3EZ extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public AccessibilityManager accessibilityManager;
    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    public Context context;
    public EntidadEfectivo entidad;
    public ArrayAdapter<EntidadEfectivo> entidadArrayAdapter;
    public List<EntidadEfectivo> entidadCUPList;
    public List<EntidadEfectivo> entidadUSDList;
    private TextInputLayout lyBolsas;
    public TextInputLayout lyEntidad;
    public TextInputLayout lyMonendaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyProvincia;
    public pAzq93vIl3 manager;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public View rootView;
    public jN13TOyLMX spBolsas;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    public boolean pagoTotal = false;
    public int tipoBolsa = 0;
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f9Reflqt3EZ f9reflqt3ez = f9Reflqt3EZ.this;
            f9reflqt3ez.tipoBolsa = position + 1;
            f9reflqt3ez.entidad = null;
            f9reflqt3ez.spEntidad.setText(BuildConfig.FLAVOR);
            if (position == 0) {
                f9Reflqt3EZ.this.spEntidad.setClickable(true);
                f9Reflqt3EZ.this.lyEntidad.setEnabled(true);
                f9Reflqt3EZ.this.spEntidad.setEnabled(true);
                f9Reflqt3EZ.this.txMonedaImporte.setText("USD");
                f9Reflqt3EZ.this.loadSpinnerEntidades("USD");
                return;
            }
            if (position == 1) {
                f9Reflqt3EZ.this.spEntidad.setClickable(true);
                f9Reflqt3EZ.this.spEntidad.setEnabled(true);
                f9Reflqt3EZ.this.spEntidad.setEnabled(true);
                f9Reflqt3EZ.this.txMonedaImporte.setText("CUP");
                f9Reflqt3EZ.this.loadSpinnerEntidades("CUP");
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spSpinnerEntidades = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f9Reflqt3EZ f9reflqt3ez = f9Reflqt3EZ.this;
            f9reflqt3ez.entidad = (f9reflqt3ez.tipoBolsa == 1 ? f9reflqt3ez.entidadUSDList : f9reflqt3ez.entidadCUPList).get(position);
            if (f9Reflqt3EZ.this.entidad.getCode().equals("22098")) {
                f9Reflqt3EZ.this.lyProvincia.setVisibility(0);
                f9Reflqt3EZ.this.lyMunicipio.setVisibility(0);
                f9Reflqt3EZ.this.loadProvincias();
            } else {
                f9Reflqt3EZ f9reflqt3ez2 = f9Reflqt3EZ.this;
                f9reflqt3ez2.municipio = null;
                f9reflqt3ez2.provincia = null;
                f9reflqt3ez2.lyProvincia.setVisibility(8);
                f9Reflqt3EZ.this.lyMunicipio.setVisibility(8);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f9Reflqt3EZ f9reflqt3ez = f9Reflqt3EZ.this;
            f9reflqt3ez.provincia = f9reflqt3ez.provinciasArrayAdapter.getItem(position);
            f9Reflqt3EZ f9reflqt3ez2 = f9Reflqt3EZ.this;
            f9reflqt3ez2.municipio = null;
            f9reflqt3ez2.spMunicipio.setText(BuildConfig.FLAVOR);
            f9Reflqt3EZ f9reflqt3ez3 = f9Reflqt3EZ.this;
            f9reflqt3ez3.loadMunicipio(f9reflqt3ez3.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            f9Reflqt3EZ f9reflqt3ez = f9Reflqt3EZ.this;
            f9reflqt3ez.municipio = f9reflqt3ez.municipioArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = container.getContext();
        this.context = context;
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.manager = new pAzq93vIl3(this.context, this);
        try {
            if (this.accessibilityManager.isTouchExplorationEnabled()) {
                this.rootView = inflater.inflate(R.layout.clzxr5x2ngy02, container, false);
            } else {
                this.rootView = inflater.inflate(R.layout.clzxr5x2ngy02, container, false);
            }
        } catch (Exception e) {
            this.rootView = inflater.inflate(R.layout.clzxr5x2ngy02, container, false);
        }
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.spEntidad = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
        this.lyMonto = (TextInputLayout) this.rootView.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonto);
        this.lyMonto.setHint(getString(R.string.hint_xmonto));
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f9Reflqt3EZ.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f9Reflqt3EZ f9reflqt3ez = f9Reflqt3EZ.this;
                f9reflqt3ez.mensajeAyuda("Ayuda", f9reflqt3ez.context.getString(R.string.tx_help_extraccion_wallet_cup));
            }
        });
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        TextInputLayout textInputLayout = (TextInputLayout) this.rootView.findViewById(R.id.lyMonedaImporte);
        this.lyMonendaImporte = textInputLayout;
        textInputLayout.setVisibility(0);
        this.txMonedaImporte = (AutoCompleteTextView) this.rootView.findViewById(R.id.txMonedaImporte);
        loadEntidades();
        return this.rootView;
    }

    public void submitForm() {
        String municipioSeleccionado;
        String msg;
        if (!validateMonto() || !validateMoneda() || !validateEntidad()) {
            return;
        }
        String source = this.entidad.getCode();
        String monto = this.txMonto.getText().toString().trim();
        String moneda = this.txMonedaImporte.getText().toString().trim();
        if (this.provincia == null || this.municipio == null) {
            municipioSeleccionado = "0";
        } else {
            String municipioSeleccionado2 = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
            municipioSeleccionado = municipioSeleccionado2;
        }
        String msg2 = "¿ Desea solicitar un ticket para la extracción en " + this.entidad.getNombre() + " de su cuenta " + moneda + ", con el importe en " + moneda + ": " + monto + "?";
        if (moneda.equals("USD")) {
            msg = msg2 + " Al monto indicado se le aplicará la tasa de cambio correspondiente a CUP.";
        } else if (!moneda.equals("CUP")) {
            msg = msg2;
        } else {
            msg = msg2 + " En la cuenta especificada se realizará un descuento con el monto indicado.";
        }
        String cadena = source + "*" + monto + "*" + moneda + "*" + municipioSeleccionado + this.tipoBolsa;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (this.isPartialUSSD) {
            this.manager.principalEnviarUSSD(this.context, "110", "95", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        } else {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "95", cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateMoneda() {
        if (this.txMonedaImporte.getText().toString().trim().isEmpty()) {
            this.lyMonendaImporte.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txMonedaImporte);
            return false;
        }
        return true;
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.txMonto.getText().toString().trim().isEmpty()) {
                this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.txMonto);
                return false;
            }
            try {
                float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
                if (importe < 1.0f) {
                    this.lyMonto.setError(getString(R.string.err_msg_importe_inferior));
                    requestFocus(this.txMonto);
                    return false;
                }
                this.lyMonto.setErrorEnabled(false);
                return true;
            } catch (Exception e) {
                this.lyMonto.setError("Monto incorrecto");
                requestFocus(this.txMonto);
                return false;
            }
        }
        return true;
    }

    private boolean validateEntidad() {
        this.lyEntidad.setErrorEnabled(false);
        if (this.spEntidad.getText().toString().trim().isEmpty()) {
            this.lyEntidad.setError(getString(R.string.tx_soleccione_entidad));
            requestFocus(this.spEntidad);
            return false;
        }
        this.lyEntidad.setErrorEnabled(false);
        return true;
    }

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.3
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(f9Reflqt3EZ.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.f9Reflqt3EZ.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadMunicipio(String codigo) {
        try {
            List<Municipio> list = unYp8VQThY.getInstance().getAllMunipiosLists(codigo);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.municipiosList = list;
            this.municipioArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipioArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipioArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spMunicipio.setAdapter(this.municipioArrayAdapter);
            this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
            this.municipioArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean loadEntidades() {
        try {
            this.entidadCUPList = new ArrayList();
            this.entidadUSDList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<EntidadEfectivo> list = jsonFilesManager.loadDataEntidadEfectivo(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (EntidadEfectivo uyh0pxs9m37in : list) {
                if (uyh0pxs9m37in.getMoneda().contains("CUP")) {
                    this.entidadCUPList.add(uyh0pxs9m37in);
                } else if (uyh0pxs9m37in.getMoneda().contains("USD")) {
                    this.entidadUSDList.add(uyh0pxs9m37in);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadProvincias() {
        try {
            List<Provincia> list = unYp8VQThY.getInstance().getAllProvinciasLists();
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.provinciaList = list;
            this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Provincia uyh0pxs9m37in : list) {
                this.provinciasArrayAdapter.add(uyh0pxs9m37in);
            }
            this.provinciasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spProvincia.setAdapter(this.provinciasArrayAdapter);
            this.spProvincia.setOnItemClickListener(this.spClickProvincias);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadSpinnerEntidades(String moneda) {
        List<EntidadEfectivo> list;
        try {
            if (moneda.contains("CUP")) {
                list = this.entidadCUPList;
            } else if (moneda.contains("USD")) {
                list = this.entidadUSDList;
            } else {
                list = null;
            }
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.entidadArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (EntidadEfectivo uyh0pxs9m37in : list) {
                this.entidadArrayAdapter.add(uyh0pxs9m37in);
            }
            this.entidadArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spEntidad.setAdapter(this.entidadArrayAdapter);
            this.spEntidad.setOnItemClickListener(this.spSpinnerEntidades);
            this.entidadArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
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
