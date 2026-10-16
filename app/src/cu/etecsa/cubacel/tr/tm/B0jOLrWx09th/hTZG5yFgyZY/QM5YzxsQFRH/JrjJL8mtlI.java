package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

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
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JrjJL8mtlI extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public Context context;
    public List<String> facList;
    public List<TarjetaPropia> facturasLists;
    public Float importe;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyMonedaImporte;
    private TextInputLayout lyMonto;
    private TextInputLayout lySerie;
    public pAzq93vIl3 manager;
    public String monedaSerie;
    public String nombreCuenta;
    public View rootView;
    public String serie;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    private AutoCompleteTextView txMonedaImporte;
    private AutoCompleteTextView txMonto;
    private AutoCompleteTextView txSerie;
    public boolean serieCorrecto = true;
    public int tipoBolsa = 0;
    public ArrayList<String> items = new ArrayList<>();
    public int MAX_PARAMETERS_PQUETE = 4;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            JrjJL8mtlI jrjJL8mtlI = JrjJL8mtlI.this;
            jrjJL8mtlI.tipoBolsa = 2;
            switch (2) {
                case 1:
                    jrjJL8mtlI.nombreCuenta = "USD";
                    break;
                case 2:
                    jrjJL8mtlI.nombreCuenta = "CUP";
                    break;
            }
        }
    };
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            JrjJL8mtlI.this.submitForm();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.h4b0ojwcjzxjst, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        loadViewUI(this.rootView);
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
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<TarjetaPropia> list = JrjJL8mtlI.this.facturasLists;
                if (list != null && list.size() > 0) {
                    JrjJL8mtlI.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(JrjJL8mtlI.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.txSerie = (AutoCompleteTextView) v.findViewById(R.id.txSerie);
        this.lySerie = (TextInputLayout) v.findViewById(R.id.lySerie);
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
        this.txSerie.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    JrjJL8mtlI.this.txSerie.showDropDown();
                }
            }
        });
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    private boolean isFieldsOK() {
        return validateSerie() && validateMonto() && validateSpBolsa();
    }

    public void submitForm() {
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
        String cadena = this.serie + "*" + String.valueOf(this.importe) + "*" + this.tipoBolsa;
        String numberAsString = String.format("%.2f", this.importe);
        String msg = "Confirme los datos de la tarjeta propia que desea recargar: Serie: " + this.serie + " importe a recargar: " + numberAsString + " " + this.monedaSerie + ".";
        String cuenta = " Utilizando la cuenta <font color=#212121>" + this.nombreCuenta + "</font>";
        String msg2 = msg + cuenta;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        try {
            this.isPartialUSSD = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarussdparcial();
        } catch (Exception e) {
        }
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "77", cadena, msg2, group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "77", "04", this.MAX_PARAMETERS_PQUETE, cadena, msg2, group, getFragmentManager());
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

    private void validateSerieIncorrecto() {
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

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x003b  */
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

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
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
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.JrjJL8mtlI.5
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    TarjetaPropia cuenta = JrjJL8mtlI.this.facturasLists.get(position);
                    JrjJL8mtlI.this.txSerie.setText(cuenta.getSerie());
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
