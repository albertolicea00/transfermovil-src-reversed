package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yww1pS0VKU extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public ArrayAdapter<CharSequence> adapterTipoCuenta;
    public R1sDOSqZ2z agencia;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnContacts;
    public Switch ckDeudaNautaHogar;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    public float importe;
    private AutoCompleteTextView inputCuenta;
    private TextInputEditText inputImporte;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutImporte;
    private TextInputLayout inputLayoutNumeroDestinatario;
    public TextInputLayout inputLayoutTipoCuenta;
    private AutoCompleteTextView inputNumeroDestinatario;
    private TextInputLayout lyBolsas;
    public List<String> nautaCuentas;
    public List<Nauta> nautaLists;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public jN13TOyLMX spinnerTipoCuenta;
    public Switch swNautaHogar;
    public String[] tipos;
    public TextView toolbarTitle;
    public TextView txContacto;
    public int banco = 0;
    public String cuenta = BuildConfig.FLAVOR;
    public int tipoCuenta = 0;
    public String nombreTipoCuenta = BuildConfig.FLAVOR;
    public String movil = "0000000";
    public int tipoBolsa = 0;
    public ArrayList<String> items = new ArrayList<>();
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.5
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            yww1pS0VKU.this.submitForm();
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || yww1pS0VKU.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    yww1pS0VKU.this.busk_contactos(v);
                } else {
                    yww1pS0VKU.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };
    private jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            yww1pS0VKU.this.tipoCuenta = position + 1;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            yww1pS0VKU.this.tipoBolsa = 2;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.w6hep05cybwcjt, container, false);
        this.context = container.getContext();
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbarTitle = textView;
        textView.setText(getString(R.string.title_nauta_recarga_agente));
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView2;
        textView2.setVisibility(8);
        this.ckDeudaNautaHogar = (Switch) this.rootView.findViewById(R.id.ckDeudaNautaHogar);
        Switch r0 = (Switch) this.rootView.findViewById(R.id.swNautaHogar);
        this.swNautaHogar = r0;
        r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                yww1pS0VKU.this.ckDeudaNautaHogar.setChecked(false);
                if (b) {
                    yww1pS0VKU.this.ckDeudaNautaHogar.setVisibility(8);
                } else {
                    yww1pS0VKU.this.ckDeudaNautaHogar.setVisibility(8);
                }
            }
        });
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass11.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    break;
                case 2:
                    this.banco = 2;
                    break;
                case 3:
                    this.banco = 3;
                    break;
            }
        }
        loadViewUI(this.rootView);
        loadData();
        this.tipos = getResources().getStringArray(R.array.array_tipo_cuenta_nauta);
        if (getArguments() != null && getArguments().containsKey("pago")) {
            String cuentaNauta = getArguments().get("pago").toString();
            String[] arr = cuentaNauta.split("@");
            this.inputCuenta.setText(arr[0]);
            this.cuenta = arr[0];
            if (arr[1].contains(".com.cu")) {
                this.tipoCuenta = 1;
                this.spinnerTipoCuenta.setText(this.tipos[0]);
            } else if (arr[1].contains(".co.cu")) {
                this.tipoCuenta = 2;
                this.spinnerTipoCuenta.setText(this.tipos[1]);
            }
        }
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Nauta> list = yww1pS0VKU.this.nautaLists;
                if (list != null && list.size() > 0) {
                    yww1pS0VKU.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(yww1pS0VKU.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        loadSearchSpinner();
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU$11, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {
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

    private void loadSearchSpinner() {
        try {
            List<String> list = this.nautaCuentas;
            if (list != null && list.size() > 0) {
                for (String uyh0pxs9m37in : this.nautaCuentas) {
                    this.items.add(uyh0pxs9m37in);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.3
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(yww1pS0VKU.this.nautaLists.get(position).getCuenta());
                    yww1pS0VKU.this.inputCuenta.setText(nautaCuenta.get(0).getCuenta());
                    if (nautaCuenta.size() == 2) {
                        yww1pS0VKU yww1ps0vku = yww1pS0VKU.this;
                        yww1ps0vku.showDialogWithCheckBox(yww1ps0vku.tipos);
                        return;
                    }
                    Nauta item_nauta = nautaCuenta.get(0);
                    if (item_nauta.getTipo_cuenta() == 1) {
                        yww1pS0VKU yww1ps0vku2 = yww1pS0VKU.this;
                        yww1ps0vku2.tipoCuenta = 1;
                        yww1ps0vku2.spinnerTipoCuenta.setText(yww1ps0vku2.tipos[0]);
                    } else {
                        yww1pS0VKU yww1ps0vku3 = yww1pS0VKU.this;
                        yww1ps0vku3.tipoCuenta = 2;
                        yww1ps0vku3.spinnerTipoCuenta.setText(yww1ps0vku3.tipos[1]);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    public void loadViewUI(View v) {
        this.inputCuenta = (AutoCompleteTextView) v.findViewById(R.id.inputCuenta);
        this.inputLayoutCuenta = (TextInputLayout) v.findViewById(R.id.inputLayoutCuenta);
        this.spinnerTipoCuenta = (jN13TOyLMX) v.findViewById(R.id.spinnerTipoCuenta);
        this.inputLayoutTipoCuenta = (TextInputLayout) v.findViewById(R.id.inputLayoutTipoCuenta);
        this.inputImporte = (TextInputEditText) v.findViewById(R.id.inputImporte);
        this.inputLayoutImporte = (TextInputLayout) v.findViewById(R.id.inputLayoutImporte);
        this.inputNumeroDestinatario = (AutoCompleteTextView) v.findViewById(R.id.inputNumeroDestinatario);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) v.findViewById(R.id.inputLayoutNumeroDestinatario);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_tipo_cuenta_nauta, android.R.layout.simple_list_item_1);
        this.adapterTipoCuenta = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoCuenta.setAdapter(this.adapterTipoCuenta);
        this.spinnerTipoCuenta.setOnItemClickListener(this.spClickTipo);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactsOnClick);
    }

    private void loadData() {
        try {
            this.nautaCuentas = new ArrayList();
            unYp8VQThY.init(this.context);
            this.nautaLists = unYp8VQThY.getInstance().getAllNautaLists();
            List<String> cuentas_nautas = new ArrayList<>();
            List<Integer> tipos_cuentas = new ArrayList<>();
            for (Nauta c : this.nautaLists) {
                String nom_cuenta = c.getCuenta();
                if (!cuentas_nautas.contains(nom_cuenta)) {
                    cuentas_nautas.add(nom_cuenta);
                }
                tipos_cuentas.add(Integer.valueOf(c.getTipo_cuenta()));
                String cuentaCompleta = nom_cuenta;
                if (c.getTipo_cuenta() == 1) {
                    cuentaCompleta = cuentaCompleta + "@nauta.com.cu";
                } else if (c.getTipo_cuenta() == 2) {
                    cuentaCompleta = cuentaCompleta + "@nauta.co.cu";
                }
                this.nautaCuentas.add(cuentaCompleta);
            }
            ArrayAdapter<String> adapterCuentas = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, cuentas_nautas);
            this.inputCuenta.setAdapter(adapterCuentas);
            this.inputCuenta.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    List<Nauta> nautaCuenta = unYp8VQThY.getInstance().getNautaListsWithAccount(yww1pS0VKU.this.inputCuenta.getText().toString());
                    if (nautaCuenta.size() == 2) {
                        yww1pS0VKU yww1ps0vku = yww1pS0VKU.this;
                        yww1ps0vku.showDialogWithCheckBox(yww1ps0vku.tipos);
                        return;
                    }
                    Nauta item_nauta = nautaCuenta.get(0);
                    if (item_nauta.getTipo_cuenta() == 1) {
                        yww1pS0VKU yww1ps0vku2 = yww1pS0VKU.this;
                        yww1ps0vku2.tipoCuenta = 1;
                        yww1ps0vku2.spinnerTipoCuenta.setText(yww1ps0vku2.tipos[0]);
                    } else {
                        yww1pS0VKU yww1ps0vku3 = yww1pS0VKU.this;
                        yww1ps0vku3.tipoCuenta = 2;
                        yww1ps0vku3.spinnerTipoCuenta.setText(yww1ps0vku3.tipos[1]);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    private void enviarUSSD() {
        if (!this.swNautaHogar.isChecked()) {
            this.cuenta.toLowerCase();
            if (!this.cuenta.contains("ERROR")) {
                this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
                String cadena = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*0*" + this.movil + "*" + this.tipoBolsa + "*1";
                String msgUser = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
                String msPin = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
                String msTipoCuenta = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
                String msg = "Confirme los siguientes datos de la cuenta Nauta a recargar: " + msgUser + msPin + msTipoCuenta;
                ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "14", cadena, msg, group, getFragmentManager());
                return;
            }
            Log.d("CADENA", "cadena vacia");
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        if (!this.ckDeudaNautaHogar.isChecked()) {
            this.cuenta.toLowerCase();
            if (!this.cuenta.contains("ERROR")) {
                this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
                String cadena2 = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*0*" + this.movil + "*" + this.tipoBolsa + "*2";
                String msgUser2 = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
                String msPin2 = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
                String msTipoCuenta2 = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
                String msg2 = "Nauta Hogar. Confirme los siguientes datos de la cuenta a recargar: " + msgUser2 + msPin2 + msTipoCuenta2;
                ViewGroup group2 = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "15", cadena2, msg2, group2, getFragmentManager());
                return;
            }
            Log.d("CADENA", "cadena vacia");
            helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
            return;
        }
        this.cuenta.toLowerCase();
        if (!this.cuenta.contains("ERROR")) {
            this.nombreTipoCuenta = this.spinnerTipoCuenta.getText().toString();
            String cadena3 = this.cuenta + "*" + this.tipoCuenta + "*" + String.valueOf(this.importe) + "*0*" + this.movil + "*" + this.tipoBolsa + "*3";
            String msgUser3 = "<br/><font color=#212121>" + this.context.getString(R.string.title_nauta_user) + "</font><font color=#f44336> " + this.inputCuenta.getText().toString() + "</font>";
            String msPin3 = "<br/><font color=#212121>Importe: </font><font color=#f44336>" + this.importe + " CUP </font>";
            String msTipoCuenta3 = "<br/><font color=#212121>Tipo de cuenta:</font><font color=#f44336><br/> " + this.nombreTipoCuenta + "</font>";
            String msg3 = "Pago de deudas pendientes en el servicio de Nauta Hogar. Confirme los siguientes datos de la cuenta a pagar: " + msgUser3 + msPin3 + msTipoCuenta3;
            ViewGroup group3 = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "86", cadena3, msg3, group3, getFragmentManager());
            return;
        }
        Log.d("CADENA", "cadena vacia");
        helpAlertGestion(getString(R.string.Err_MSG_Caracteres));
    }

    private boolean isFieldsOK() {
        return validateCuenta() && validateTipoCuentaNauta() && validateMonto() && validateMovil() && validateSpBolsa();
    }

    private boolean validateCuenta() {
        String[] espacios = this.inputCuenta.getText().toString().trim().split(" ");
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_nauta_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (espacios.length > 1) {
            this.inputLayoutCuenta.setError("Su cuenta no debe tener espacios en blanco");
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().contains("@")) {
            this.inputLayoutCuenta.setError("Debe teclear el usuario sin el dominio (@nauta.com.cu)");
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        this.cuenta = this.inputCuenta.getText().toString().trim();
        return true;
    }

    private boolean validateTipoCuentaNauta() {
        if (this.spinnerTipoCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoCuenta.setError("Seleccione un tipo de cuenta Nauta");
            requestFocus(this.spinnerTipoCuenta);
            return false;
        }
        this.inputLayoutTipoCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.inputImporte.getText().toString().trim().isEmpty()) {
            this.inputLayoutImporte.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.inputImporte);
            return false;
        }
        this.inputLayoutImporte.setErrorEnabled(false);
        try {
            float f = Float.parseFloat(this.inputImporte.getText().toString().trim());
            this.importe = f;
            if (f < 1.0f) {
                this.inputLayoutImporte.setError(getString(R.string.err_msg_importe_inferior));
                requestFocus(this.inputImporte);
                return false;
            }
            return true;
        } catch (Exception e) {
            this.inputLayoutImporte.setError("Monto incorrecto");
            requestFocus(this.inputImporte);
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

    private boolean validateMovil() {
        if (!this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8) {
                this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
                requestFocus(this.inputNumeroDestinatario);
                return false;
            }
            this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
            if (!this.inputNumeroDestinatario.getText().toString().trim().substring(0, 1).contains("5") && !this.inputNumeroDestinatario.getText().toString().trim().substring(0, 1).contains("6")) {
                this.inputLayoutNumeroDestinatario.setError("Numero de movil incorrecto");
                requestFocus(this.inputNumeroDestinatario);
                return false;
            }
            this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
            this.movil = this.inputNumeroDestinatario.getText().toString().trim();
        }
        return true;
    }

    public void submitForm() {
        if (isFieldsOK()) {
            try {
                enviarUSSD();
                nuevoDatos();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogWithCheckBox(final String[] items) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context).setTitle("La cuenta tiene dos tipos de cuentas, Seleccione una:").setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    yww1pS0VKU yww1ps0vku = yww1pS0VKU.this;
                    yww1ps0vku.tipoCuenta = 1;
                    yww1ps0vku.spinnerTipoCuenta.setText(items[0]);
                } else {
                    yww1pS0VKU yww1ps0vku2 = yww1pS0VKU.this;
                    yww1ps0vku2.tipoCuenta = 2;
                    yww1ps0vku2.spinnerTipoCuenta.setText(items[1]);
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void helpAlertGestion(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ERROR!!!");
        builder.setMessage(msg);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        Intent i = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            Uri data2 = data.getData();
            this.contactUri = data2;
            renderContact(data2);
        }
    }

    private void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri).replace(" ", BuildConfig.FLAVOR).trim();
            if (telf.contains("+")) {
                telf = telf.substring(1);
            }
            if (telf.charAt(0) == '0') {
                telf = telf.substring(1);
            }
            if ((telf.substring(0, 3).toString().contains("535") || telf.substring(0, 3).toString().contains("536")) && telf.length() == 10) {
                telf = telf.substring(2);
            }
            this.inputNumeroDestinatario.setText(telf);
            String str = this.displayContact;
            if (str != null && str.length() > 0) {
                this.txContacto.setVisibility(0);
                this.txContacto.setText(this.displayContact);
                this.displayContact = BuildConfig.FLAVOR;
                return;
            }
            this.txContacto.setVisibility(8);
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
            this.txContacto.setVisibility(8);
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        this.displayContact = BuildConfig.FLAVOR;
        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
        if (contactCursor.moveToFirst()) {
            id = contactCursor.getString(0);
        }
        contactCursor.close();
        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "display_name"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
        if (phoneCursor.moveToFirst()) {
            phone = phoneCursor.getString(0);
            this.displayContact = phoneCursor.getString(1);
        }
        phoneCursor.close();
        return phone;
    }

    public void nuevoDatos() {
        String edit_nauta = this.inputCuenta.getText().toString();
        int tipo = this.tipoCuenta;
        List<Nauta> c_list = unYp8VQThY.getInstance().getNautaListsWithAccount(edit_nauta, tipo);
        if (c_list.size() == 0) {
            Nauta c = new Nauta();
            c.setCuenta(edit_nauta);
            c.setTipo_cuenta(this.tipoCuenta);
            unYp8VQThY.getInstance().addNauta(c);
        }
        String edit_telef = this.inputNumeroDestinatario.getText().toString();
        List<TeflMovil> c_list_dest = unYp8VQThY.getInstance().getMovilListsWithPhoneNumber(edit_telef);
        if (c_list_dest.size() == 0) {
            TeflMovil c2 = new TeflMovil();
            c2.setNumber(edit_telef);
            unYp8VQThY.getInstance().addTelfMovil(c2);
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
