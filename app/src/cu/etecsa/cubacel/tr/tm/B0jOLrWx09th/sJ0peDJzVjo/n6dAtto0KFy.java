package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HPuMiTypoW;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n6dAtto0KFy extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public AccessibilityManager accessibilityManager;
    public Activity activity;
    private ArrayAdapter adapterPaquetes;
    public R1sDOSqZ2z agencia;
    public String agencyL;
    public int banco;
    public AppCompatImageView btReload;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    public int comprapaquetes;
    private Uri contactUri;
    public String displayContact;
    public V9s8rJIDplX jsonFilesManager;
    private List<CompraPlanesCubacel> listDatabase;
    private List<CompraPlanesCubacel> listaPaquetes;
    private TextInputLayout lyCuenta;
    private TextInputLayout lyPaquetes;
    private CompraPlanesCubacel paqueteSeleccionado;
    private ProgressDialog progressDialog;
    public jN13TOyLMX spPaquetes;
    public TipoRecargaEnum tipo;
    public TextView txContacto;
    private AutoCompleteTextView txCuenta;
    private Handler handler = new Handler();
    public jN13TOyLMX.OnItemClickListener spClickTipoRecarga = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            n6dAtto0KFy.this.inputLayoutCuentaWrite.setVisibility(8);
            n6dAtto0KFy.this.inputLayoutMisCuentas.setVisibility(8);
            n6dAtto0KFy.this.mcBankArrayAdapter = null;
            n6dAtto0KFy.this.spinnerMisCuentas.setText(BuildConfig.FLAVOR);
            n6dAtto0KFy.this.spinnerTipoMoneda.setText(BuildConfig.FLAVOR);
            if (n6dAtto0KFy.this.bancoEntity != null && n6dAtto0KFy.this.bancoEntity == R1sDOSqZ2z.BANDEC) {
                n6dAtto0KFy.this.swCuentasBanco.setChecked(false);
            }
            n6dAtto0KFy.this.miCuentaSeleccion = BuildConfig.FLAVOR;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickPaquetes = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.8
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            if (n6dAtto0KFy.this.listDatabase != null && position < n6dAtto0KFy.this.listDatabase.size()) {
                n6dAtto0KFy n6datto0kfy = n6dAtto0KFy.this;
                n6datto0kfy.paqueteSeleccionado = (CompraPlanesCubacel) n6datto0kfy.listDatabase.get(position);
                n6dAtto0KFy n6datto0kfy2 = n6dAtto0KFy.this;
                n6datto0kfy2.spPaquetes.setText((CharSequence) n6datto0kfy2.paqueteSeleccionado.getNombre(), false);
            }
        }
    };

    public enum TipoRecargaEnum {
        Movil,
        MovilPlus
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
        this.rootView = inflater.inflate(R.layout.yedxmsnhy6r6h, container, false);
        this.manager = new pAzq93vIl3(this.context, this);
        this.jsonFilesManager = new V9s8rJIDplX();
        this.comprapaquetes = unYp8VQThY.getInstance().getAllAppConfigLists().get(0).getComprapaquetes();
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass11.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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
        initComponentesCuentas(this.rootView, this.agencia);
        this.lyCuenta = (TextInputLayout) this.rootView.findViewById(R.id.lyCuenta);
        this.txCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCuenta);
        this.lyPaquetes = (TextInputLayout) this.rootView.findViewById(R.id.lyPaquetes);
        jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spPaquetes);
        this.spPaquetes = jn13toylmx;
        jn13toylmx.setOnItemClickListener(this.spClickPaquetes);
        this.btReload = (AppCompatImageView) this.rootView.findViewById(R.id.btReload);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.txCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                n6dAtto0KFy.this.txCuenta.showDropDown();
            }
        });
        if (getArguments() != null && getArguments().containsKey("factura")) {
            this.txCuenta.setText(getArguments().get("factura").toString());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n6dAtto0KFy.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setImageResource(R.drawable.ico_contacts);
        this.btnBskContacto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || n6dAtto0KFy.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    n6dAtto0KFy.this.busk_contactos(v);
                } else {
                    n6dAtto0KFy.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        this.btReload.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                n6dAtto0KFy.this.getActivity().getWindow().setFlags(16, 16);
                n6dAtto0KFy.this.progressDialog = new ProgressDialog(n6dAtto0KFy.this.context);
                n6dAtto0KFy.this.progressDialog.setMessage("Actualizando paquetes disponibles...");
                n6dAtto0KFy.this.progressDialog.setCancelable(false);
                n6dAtto0KFy.this.progressDialog.show();
                new HPuMiTypoW(n6dAtto0KFy.this.context.getContentResolver()).execute(new Void[0]);
                n6dAtto0KFy.this.handler.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n6dAtto0KFy.this.progressDialog != null && n6dAtto0KFy.this.progressDialog.isShowing()) {
                            n6dAtto0KFy.this.progressDialog.dismiss();
                        }
                        n6dAtto0KFy.this.getActivity().getWindow().clearFlags(16);
                        Toast.makeText(n6dAtto0KFy.this.context, "Actualización completada", 0).show();
                        if (n6dAtto0KFy.this.adapterPaquetes != null) {
                            n6dAtto0KFy.this.cargarPaquetesDatabase();
                            n6dAtto0KFy.this.adapterPaquetes.notifyDataSetChanged();
                            n6dAtto0KFy n6datto0kfy = n6dAtto0KFy.this;
                            n6datto0kfy.spPaquetes.setAdapter(n6datto0kfy.adapterPaquetes);
                        }
                    }
                }, 10000L);
            }
        });
        int i = this.comprapaquetes;
        if (i == 0 || i == 1) {
            cargarPaquetes();
        } else {
            cargarPaquetesDatabase();
        }
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy$11, reason: invalid class name */
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

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        super.submitForm();
        if (!validateCuenta() || !validateSelectionAccounts() || !validateSpPaquete()) {
            return;
        }
        nuevoDatos();
        String monedaFactura = "NO ES POSIBLE IDENTIFICAR LA MONEDA";
        boolean isMoneda = true;
        try {
            switch (this.monedaTarjeta) {
                case 1:
                    monedaFactura = "CUP";
                    break;
                case 2:
                    monedaFactura = "CUC";
                    break;
                case 3:
                    monedaFactura = "USD";
                    break;
                default:
                    isMoneda = false;
                    monedaFactura = "Cuenta de banco seleccionada";
                    break;
            }
        } catch (Exception e) {
        }
        String cuenta = this.txCuenta.getText().toString().trim();
        String msg = "¿ Desea seleccionar la opción " + this.paqueteSeleccionado.getNombre() + " para el móvil " + cuenta + " ?";
        if (isMoneda) {
            msg = msg + " La moneda seleccionada: (" + monedaFactura + ") corresponde a la moneda de su cuenta.";
        } else if (this.cuentaOrigen != "0000") {
            msg = msg + " La moneda seleccionada esta en correspondencia a la naturaleza de la cuenta especificada: (" + this.cuentaOrigen + ").";
        }
        String cadena = cuenta + "*" + this.paqueteSeleccionado.getId() + "*" + this.paqueteSeleccionado.getVersion_ussd() + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "6", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void showDialogNoTieneCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_hint_aviso));
        builder.setMessage(this.context.getString(R.string.err_no_tiene_cuentas));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean validateCuenta() {
        if (this.txCuenta.getText().toString().trim().isEmpty()) {
            this.lyCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCuenta);
            return false;
        }
        if (this.txCuenta.getText().toString().trim().length() != 8 && this.txCuenta.getText().toString().trim().length() != 10) {
            this.lyCuenta.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.txCuenta);
            return false;
        }
        this.lyCuenta.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
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
            this.txCuenta.setText(telf);
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

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.7
            @Override // java.lang.Runnable
            public void run() {
                new androidx.appcompat.app.AlertDialog.Builder(n6dAtto0KFy.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    public boolean validateSpPaquete() {
        if (this.spPaquetes.getText().toString().trim().isEmpty()) {
            this.lyPaquetes.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spPaquetes);
            return false;
        }
        this.lyPaquetes.setErrorEnabled(false);
        return true;
    }

    private void cargarPaquetes() {
        this.listaPaquetes = this.jsonFilesManager.loadCompraPlanesCubacel(this.context);
        int i = this.comprapaquetes;
        if (i == 0 || i == 1) {
            if (unYp8VQThY.getInstance().deleteAllPaquetes()) {
                for (CompraPlanesCubacel lista : this.listaPaquetes) {
                    unYp8VQThY.getInstance().addPaquetes(lista);
                }
                AppConfig ap = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                ap.setComprapaquetes(this.listaPaquetes.get(0).getVersion_ussd());
                unYp8VQThY.getInstance().updateAppConfig(ap);
            } else {
                Toast.makeText(this.context, "Ha ocurrido un error al actualizar los paquetes", 1).show();
            }
        }
        List<String> nombresPaquetes = new ArrayList<>();
        for (CompraPlanesCubacel paquete : this.listaPaquetes) {
            nombresPaquetes.add(paquete.getNombre());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, android.R.layout.simple_dropdown_item_1line, nombresPaquetes);
        this.adapterPaquetes = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spPaquetes.setAdapter(this.adapterPaquetes);
        this.spPaquetes.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.9
            @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
            public void onItemClick(View view, int position) {
                if (n6dAtto0KFy.this.listaPaquetes != null && position < n6dAtto0KFy.this.listaPaquetes.size()) {
                    n6dAtto0KFy n6datto0kfy = n6dAtto0KFy.this;
                    n6datto0kfy.paqueteSeleccionado = (CompraPlanesCubacel) n6datto0kfy.listaPaquetes.get(position);
                    n6dAtto0KFy n6datto0kfy2 = n6dAtto0KFy.this;
                    n6datto0kfy2.spPaquetes.setText((CharSequence) n6datto0kfy2.paqueteSeleccionado.getNombre(), false);
                    n6dAtto0KFy.this.lyPaquetes.setErrorEnabled(false);
                }
            }
        });
    }

    public void cargarPaquetesDatabase() {
        List<CompraPlanesCubacel> allPaquetesLists = unYp8VQThY.getInstance().getAllPaquetesLists();
        this.listDatabase = allPaquetesLists;
        if (allPaquetesLists != null && !allPaquetesLists.isEmpty()) {
            List<String> nombresPaquetes = new ArrayList<>();
            for (CompraPlanesCubacel paquete : this.listDatabase) {
                if (paquete.getNombre() != null && !paquete.getNombre().isEmpty()) {
                    nombresPaquetes.add(paquete.getNombre());
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, android.R.layout.simple_dropdown_item_1line, nombresPaquetes);
            this.adapterPaquetes = arrayAdapter;
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spPaquetes.setAdapter(this.adapterPaquetes);
            this.spPaquetes.setThreshold(1);
            this.spPaquetes.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy.10
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
                public void onItemClick(View view, int position) {
                    if (n6dAtto0KFy.this.listDatabase != null && position < n6dAtto0KFy.this.listDatabase.size()) {
                        n6dAtto0KFy n6datto0kfy = n6dAtto0KFy.this;
                        n6datto0kfy.paqueteSeleccionado = (CompraPlanesCubacel) n6datto0kfy.listDatabase.get(position);
                        n6dAtto0KFy n6datto0kfy2 = n6dAtto0KFy.this;
                        n6datto0kfy2.spPaquetes.setText((CharSequence) n6datto0kfy2.paqueteSeleccionado.getNombre(), false);
                        n6dAtto0KFy.this.lyPaquetes.setErrorEnabled(false);
                    }
                }
            });
            this.spPaquetes.setImportantForAccessibility(1);
            return;
        }
        cargarPaquetes();
    }
}
