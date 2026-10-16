package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class hqPCcU1E8u extends Agg55uYctq {
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public int banco;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public List<String> facList;
    public List<TarjetaPropia> facturasLists;
    public Float importe;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lySerie;
    public String monedaSerie;
    public String serie;
    public SpinnerDialog spinnerDialog;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txSerie;
    public boolean serieCorrecto = true;
    public ArrayList<String> items = new ArrayList<>();
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            hqPCcU1E8u.this.submitForm();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.kbiew5lygc0iz, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agencyL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agencyL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agencyL = "03";
                    break;
            }
        }
        loadViewUI(this.rootView);
        initComponentesCuentas(this.rootView, this.agencia);
        if (getArguments() != null && getArguments().containsKey("cuenta_id")) {
            try {
                int cuentaID = getArguments().getInt("cuenta_id");
                TarjetaPropia tarjeta = unYp8VQThY.getInstance().getPropiaListWithID(cuentaID);
                this.txSerie.setText(tarjeta.getSerie());
            } catch (Exception e) {
            }
        }
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<TarjetaPropia> list = hqPCcU1E8u.this.facturasLists;
                if (list == null || list.size() <= 0) {
                    Toast.makeText(hqPCcU1E8u.this.context, "No hay elementos para mostrar", 0).show();
                } else {
                    hqPCcU1E8u.this.spinnerDialog.showSpinerDialog();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void loadViewUI(View v) {
        this.txSerie = (AutoCompleteTextView) v.findViewById(R.id.txSerie);
        this.lySerie = (TextInputLayout) v.findViewById(R.id.lySerie);
        this.txSerie.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                hqPCcU1E8u.this.txMonedaImporte.setText(BuildConfig.FLAVOR);
                hqPCcU1E8u.this.lySerie.setErrorEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String serie = hqPCcU1E8u.this.txSerie.getText().toString().trim();
                if (serie.length() >= 3) {
                    char caracter = serie.charAt(2);
                    switch (caracter) {
                        case '5':
                            hqPCcU1E8u hqpccu1e8u = hqPCcU1E8u.this;
                            hqpccu1e8u.serieCorrecto = true;
                            hqpccu1e8u.txMonedaImporte.setText("CUP");
                            break;
                        case '6':
                            hqPCcU1E8u hqpccu1e8u2 = hqPCcU1E8u.this;
                            hqpccu1e8u2.serieCorrecto = true;
                            hqpccu1e8u2.txMonedaImporte.setText("CUP");
                            break;
                        default:
                            hqPCcU1E8u hqpccu1e8u3 = hqPCcU1E8u.this;
                            hqpccu1e8u3.serieCorrecto = false;
                            hqpccu1e8u3.txMonedaImporte.setText(BuildConfig.FLAVOR);
                            hqPCcU1E8u.this.validateSerieIncorrecto();
                            break;
                    }
                }
            }
        });
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        this.lyMonto = (TextInputLayout) v.findViewById(R.id.lyMonto);
        this.txMonedaImporte = (AutoCompleteTextView) v.findViewById(R.id.txMonedaImporte);
        this.lyMonedaImporte = (TextInputLayout) v.findViewById(R.id.lyMonedaImporte);
        this.txMonedaImporte.setText("CUP");
        unYp8VQThY.init(this.context);
        this.facturasLists = unYp8VQThY.getInstance().getAllPropiaLists();
        this.facList = new ArrayList();
        for (TarjetaPropia wl : this.facturasLists) {
            this.facList.add(wl.getSerie());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.facList);
        this.txSerie.setAdapter(adapter);
        this.txSerie.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    hqPCcU1E8u.this.txSerie.showDropDown();
                }
            }
        });
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    private boolean isFieldsOK() {
        return validateSerie() && validateMonto() && validateSelectionAccounts();
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (isFieldsOK()) {
            try {
                nuevoDatos();
                enviarUSSD();
            } catch (Exception e) {
            }
        }
    }

    private void enviarUSSD() {
        this.serie = this.txSerie.getText().toString().trim();
        this.importe = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
        this.monedaSerie = this.txMonedaImporte.getText().toString().trim();
        String cadena = this.serie + "*" + String.valueOf(this.importe) + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        String numberAsString = String.format("%.2f", this.importe);
        String msg = "Confirme los siguientes datos de la tarjeta propia a recargar: Serie: " + this.serie + " importe a recargar: " + numberAsString + " " + this.monedaSerie + ".";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "77", cadena, msg, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "77", this.agencyL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
        }
    }

    private boolean validateSerie() {
        if (this.txSerie.getText().toString().trim().isEmpty()) {
            this.lySerie.setError("El campo no puede estar vacio");
            requestFocus(this.txSerie);
            return false;
        }
        if (this.txSerie.getText().toString().trim().length() != 12) {
            this.lySerie.setError(getString(R.string.err_msg_len_serie_12_propia));
            requestFocus(this.txSerie);
            return false;
        }
        if (!this.serieCorrecto) {
            this.lySerie.setError("Número de serie incorrecto");
            requestFocus(this.txSerie);
            return false;
        }
        this.lySerie.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateSerieIncorrecto() {
        this.lySerie.setError("Número de serie incorrecto");
        requestFocus(this.txSerie);
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        this.lyMonto.setErrorEnabled(false);
        try {
            Float importe = Float.valueOf(Float.parseFloat(this.txMonto.getText().toString().trim()));
            if (importe.floatValue() < 1.0f) {
                this.lyMonto.setError("El monto no debe ser inferior al valor de 1 CUP.");
                requestFocus(this.txMonto);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.lyMonto.setError("Monto incorrecto");
            requestFocus(this.txMonto);
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x003b  */
    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
        try {
            String serie = this.txSerie.getText().toString();
            List<TarjetaPropia> c_list = unYp8VQThY.getInstance().getTarjetaPropiaWithSerie(serie);
            if (c_list.size() == 0) {
                TarjetaPropia c = new TarjetaPropia();
                c.setDescripcion("Nueva");
                c.setSerie(serie);
                switch (this.txMonedaImporte.getText().toString().trim()) {
                    case "CUP":
                        c.setTipo_moneda(qTDVwLFEjE.CUP);
                        break;
                    case "CUC":
                        c.setTipo_moneda(qTDVwLFEjE.CUC);
                        break;
                }
                unYp8VQThY.getInstance().addPropia(c);
            }
        } catch (Exception e) {
        }
    }

    private void loadSearchSpinner() {
        String facura;
        try {
            List<TarjetaPropia> list = this.facturasLists;
            if (list != null && list.size() > 0) {
                for (TarjetaPropia uyh0pxs9m37in : this.facturasLists) {
                    uyh0pxs9m37in.getSerie();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getSerie();
                        } else {
                            facura = uyh0pxs9m37in.getDescripcion() + " " + uyh0pxs9m37in.getSerie();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getSerie();
                    }
                    this.items.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u.5
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    TarjetaPropia cuenta = hqPCcU1E8u.this.facturasLists.get(position);
                    hqPCcU1E8u.this.txSerie.setText(cuenta.getSerie());
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
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
