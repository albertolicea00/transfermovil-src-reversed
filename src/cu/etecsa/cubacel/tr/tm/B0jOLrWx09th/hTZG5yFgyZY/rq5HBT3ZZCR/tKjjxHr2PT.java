package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HPuMiTypoW;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class tKjjxHr2PT extends Fragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    private ArrayAdapter adapterPaquetes;
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public R1sDOSqZ2z agencia;
    public AppCompatImageView btReload;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    public int comprapaquetes;
    private Uri contactUri;
    public Context context;
    public String displayContact;
    private TextInputLayout inputLayoutCuenta;
    private AutoCompleteTextView inputMovil;
    public V9s8rJIDplX jsonFilesManager;
    private List<CompraPlanesCubacel> listDatabase;
    private List<CompraPlanesCubacel> listaPaquetes;
    private TextInputLayout lyBolsas;
    private TextInputLayout lyPaquetes;
    public qTDVwLFEjE monedaBolsa;
    private CompraPlanesCubacel paqueteSeleccionado;
    private ProgressDialog progressDialog;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public jN13TOyLMX spPaquetes;
    public TextView toolbarTitle;
    public TextView txContacto;
    public int tipoBolsa = 0;
    public String codeService = "10";
    private Handler handler = new Handler();
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            tKjjxHr2PT.this.tipoBolsa = 2;
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickPaquetes = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            if (tKjjxHr2PT.this.listDatabase != null && position < tKjjxHr2PT.this.listDatabase.size()) {
                tKjjxHr2PT tkjjxhr2pt = tKjjxHr2PT.this;
                tkjjxhr2pt.paqueteSeleccionado = (CompraPlanesCubacel) tkjjxhr2pt.listDatabase.get(position);
                tKjjxHr2PT tkjjxhr2pt2 = tKjjxHr2PT.this;
                tkjjxhr2pt2.spPaquetes.setText((CharSequence) tkjjxhr2pt2.paqueteSeleccionado.getNombre(), false);
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.b6zyvqtxstmmge, container, false);
        this.context = container.getContext();
        this.jsonFilesManager = new V9s8rJIDplX();
        this.comprapaquetes = unYp8VQThY.getInstance().getAllAppConfigLists().get(0).getComprapaquetes();
        this.toolbarTitle = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        TextView textView = (TextView) this.rootView.findViewById(R.id.txContacto);
        this.txContacto = textView;
        textView.setVisibility(8);
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputMovil = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.tx_movil_recarga));
        this.inputMovil.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                tKjjxHr2PT.this.inputMovil.showDropDown();
            }
        });
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        this.lyPaquetes = (TextInputLayout) this.rootView.findViewById(R.id.lyPaquetes);
        jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spPaquetes);
        this.spPaquetes = jn13toylmx;
        jn13toylmx.setOnItemClickListener(this.spClickPaquetes);
        this.btReload = (AppCompatImageView) this.rootView.findViewById(R.id.btReload);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tKjjxHr2PT.this.submitForm();
            }
        });
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT < 23 || tKjjxHr2PT.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    tKjjxHr2PT.this.busk_contactos(v);
                } else {
                    tKjjxHr2PT.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            }
        });
        this.btReload.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                tKjjxHr2PT.this.getActivity().getWindow().setFlags(16, 16);
                tKjjxHr2PT.this.progressDialog = new ProgressDialog(tKjjxHr2PT.this.context);
                tKjjxHr2PT.this.progressDialog.setMessage("Actualizando paquetes disponibles...");
                tKjjxHr2PT.this.progressDialog.setCancelable(false);
                tKjjxHr2PT.this.progressDialog.show();
                new HPuMiTypoW(tKjjxHr2PT.this.context.getContentResolver()).execute(new Void[0]);
                tKjjxHr2PT.this.handler.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (tKjjxHr2PT.this.progressDialog != null && tKjjxHr2PT.this.progressDialog.isShowing()) {
                            tKjjxHr2PT.this.progressDialog.dismiss();
                        }
                        tKjjxHr2PT.this.getActivity().getWindow().clearFlags(16);
                        Toast.makeText(tKjjxHr2PT.this.context, "Actualización completada", 0).show();
                        if (tKjjxHr2PT.this.adapterPaquetes != null) {
                            tKjjxHr2PT.this.cargarPaquetesDatabase();
                            tKjjxHr2PT.this.adapterPaquetes.notifyDataSetChanged();
                            tKjjxHr2PT tkjjxhr2pt = tKjjxHr2PT.this;
                            tkjjxhr2pt.spPaquetes.setAdapter(tkjjxhr2pt.adapterPaquetes);
                        }
                    }
                }, 10000L);
            }
        });
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            this.agencia = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
        }
        int i = this.comprapaquetes;
        if (i == 0 || i == 1) {
            cargarPaquetes();
        } else {
            cargarPaquetesDatabase();
        }
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        return this.rootView;
    }

    public void submitForm() {
        if (!validateCuenta() || !validateSpBolsa() || !validateSpPaquete()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputMovil.getText().toString().trim();
        switch (this.tipoBolsa) {
            case 1:
                this.monedaBolsa = qTDVwLFEjE.USD;
                break;
            case 2:
                this.monedaBolsa = qTDVwLFEjE.CUP;
                break;
        }
        String msg = "¿ Desea seleccionar la opción " + this.paqueteSeleccionado.getNombre() + " para el móvil " + cuenta + " ?";
        if (this.tipoBolsa == 1) {
            msg = "¿ Desea comprar un paquete al móvil " + cuenta + " usando la cuenta USD ?";
        }
        String str = this.codeService;
        if (str != null && str.length() > 0) {
            String cadena = cuenta + "*" + this.paqueteSeleccionado.getId() + "*" + this.paqueteSeleccionado.getVersion_ussd() + "*" + this.monedaBolsa + "*" + this.tipoBolsa;
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
            FBsQzP3Zfj.actionCallUSSDBack(this.context, this.codeService, cadena, msg, group, getFragmentManager());
            return;
        }
        Toast.makeText(this.context, "Ha ocurrido un error", 1).show();
    }

    private boolean validateCuenta() {
        if (this.inputMovil.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputMovil);
            return false;
        }
        if (this.inputMovil.getText().toString().trim().length() != 8 && this.inputMovil.getText().toString().trim().length() != 10) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_movil_numero));
            requestFocus(this.inputMovil);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
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

    public boolean validateSpPaquete() {
        if (this.spPaquetes.getText().toString().trim().isEmpty()) {
            this.lyPaquetes.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spPaquetes);
            return false;
        }
        this.lyPaquetes.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

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
            this.inputMovil.setText(telf);
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
        this.spPaquetes.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.7
            @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
            public void onItemClick(View view, int position) {
                if (tKjjxHr2PT.this.listaPaquetes != null && position < tKjjxHr2PT.this.listaPaquetes.size()) {
                    tKjjxHr2PT tkjjxhr2pt = tKjjxHr2PT.this;
                    tkjjxhr2pt.paqueteSeleccionado = (CompraPlanesCubacel) tkjjxhr2pt.listaPaquetes.get(position);
                    tKjjxHr2PT tkjjxhr2pt2 = tKjjxHr2PT.this;
                    tkjjxhr2pt2.spPaquetes.setText((CharSequence) tkjjxhr2pt2.paqueteSeleccionado.getNombre(), false);
                    tKjjxHr2PT.this.lyPaquetes.setErrorEnabled(false);
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
            this.spPaquetes.setOnItemClickListener(new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT.8
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
                public void onItemClick(View view, int position) {
                    if (tKjjxHr2PT.this.listDatabase != null && position < tKjjxHr2PT.this.listDatabase.size()) {
                        tKjjxHr2PT tkjjxhr2pt = tKjjxHr2PT.this;
                        tkjjxhr2pt.paqueteSeleccionado = (CompraPlanesCubacel) tkjjxhr2pt.listDatabase.get(position);
                        tKjjxHr2PT tkjjxhr2pt2 = tKjjxHr2PT.this;
                        tkjjxhr2pt2.spPaquetes.setText((CharSequence) tkjjxhr2pt2.paqueteSeleccionado.getNombre(), false);
                        tKjjxHr2PT.this.lyPaquetes.setErrorEnabled(false);
                    }
                }
            });
            this.spPaquetes.setImportantForAccessibility(1);
            return;
        }
        cargarPaquetes();
    }
}
