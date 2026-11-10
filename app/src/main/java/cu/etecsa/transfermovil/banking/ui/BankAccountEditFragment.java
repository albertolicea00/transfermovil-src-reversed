package cu.etecsa.transfermovil.banking.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.transfermovil.banking.ui.bfi.BankingAccountValidatorFragment;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI */
public class BankAccountEditFragment extends BankingAccountValidatorFragment {
    public static final int PICK_CONTACT_REQUEST = 1;
    public ArrayAdapter<CharSequence> adapter;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    public List<Client> clientsList;
    private Uri contactUri;
    public Context context;
    public String cuenta;
    public CuentaBanco cuentaBanco;
    public String cuentaCaracteres;
    private AutoCompleteTextView inputCuenta;
    private EditText inputDescricion;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutDescripcion;
    private TextInputLayout inputLayoutMovil;
    private TextInputLayout inputLayoutSpinnerCliente;
    private AutoCompleteTextView inputMovil;
    public int keyDel;
    public boolean lock;
    public String mensajeCuentaOrigen;
    public int posCliente;
    public jN13TOyLMX spinnerCliente;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bfi;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_clasica;
    public Drawable tarjeta_clasica_emp;
    public Drawable tarjeta_metro;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public boolean lista_vacia = false;
    public boolean editMode = false;
    public boolean isConfirm = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.10
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
            oaewezanai.posCliente = position + 1;
            oaewezanai.id_cliente_select = oaewezanai.clientsList.get(oaewezanai.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.uetdwqrbhz75w, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.inputLayoutSpinnerCliente = (TextInputLayout) rootView.findViewById(R.id.input__layout_cliente);
        this.inputLayoutCuenta = (TextInputLayout) rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) rootView.findViewById(R.id.input_cuenta);
        this.spinnerCliente = (jN13TOyLMX) rootView.findViewById(R.id.spinnerCliente);
        this.inputLayoutDescripcion = (TextInputLayout) rootView.findViewById(R.id.input__layout_descripcion);
        this.inputDescricion = (EditText) rootView.findViewById(R.id.input_descripcion);
        this.inputLayoutMovil = (TextInputLayout) rootView.findViewById(R.id.input__layout_gnumero);
        this.inputMovil = (AutoCompleteTextView) rootView.findViewById(R.id.input_gnumero);
        this.clientsList = unYp8VQThY.getInstance().getAllClientLists();
        List<String> titles = new ArrayList<>();
        for (Client c : this.clientsList) {
            try {
                if (c.getName().length() != 0) {
                    titles.add(c.getName());
                }
            } catch (Exception e) {
            }
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, titles);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCliente.setAdapter(adapter1);
        if (getArguments() != null) {
            this.toolbar_title.setText("Editar Cuenta");
            int id = Integer.parseInt(getArguments().get("cuenta_id").toString());
            unYp8VQThY.init(this.context);
            CuentaBanco cuentaListWithId = unYp8VQThY.getInstance().getCuentaListWithId(id);
            this.cuentaBanco = cuentaListWithId;
            String temp = getCuentaFormateada(cuentaListWithId.getCuenta());
            this.inputCuenta.setText(temp);
            this.inputDescricion.setText(this.cuentaBanco.getDescripcion());
            this.inputMovil.setText(this.cuentaBanco.getMovil());
            if (this.cuentaBanco.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.cuentaBanco.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText("Nueva cuenta");
            this.cuentaBanco = new CuentaBanco();
        }
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        initSeparator();
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.btn_buscar_contacto_image);
        this.btnBskContacto = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BankAccountEditFragment.this.busk_contactos(v);
            }
        });
        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BankAccountEditFragment.this.submitForm();
            }
        });
        return rootView;
    }

    public void submitForm() {
        String strTrim = this.inputCuenta.getText().toString().trim();
        this.cuenta = strTrim;
        if (strTrim.contains("-")) {
            this.cuenta = this.cuenta.replace("-", BuildConfig.FLAVOR);
        }
        if (!validateCuenta(this.cuenta) || !validateNumber()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
                    oaewezanai.lista_vacia = true;
                    oaewezanai.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    BankAccountEditFragment.this.lista_vacia = false;
                }
            });
            builder.show();
            return;
        }
        execute_commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute_commit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.msg_reponsabilidad_cuenta_usuario);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(BankAccountEditFragment.this.context);
                BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
                oaewezanai.cuentaBanco.setCuenta(oaewezanai.cuenta);
                if (BankAccountEditFragment.this.inputDescricion.getText().toString().length() > 0) {
                    BankAccountEditFragment oaewezanai2 = BankAccountEditFragment.this;
                    oaewezanai2.cuentaBanco.setDescripcion(oaewezanai2.inputDescricion.getText().toString().trim());
                }
                BankAccountEditFragment oaewezanai3 = BankAccountEditFragment.this;
                int i = oaewezanai3.id_cliente_select;
                if (i != 0 && i != -1) {
                    oaewezanai3.cuentaBanco.setId_client(i);
                }
                if (BankAccountEditFragment.this.inputMovil.getText().toString().length() > 0) {
                    BankAccountEditFragment oaewezanai4 = BankAccountEditFragment.this;
                    oaewezanai4.cuentaBanco.setMovil(oaewezanai4.inputMovil.getText().toString());
                }
                if (BankAccountEditFragment.this.editMode) {
                    unYp8VQThY.getInstance().updateCuentaBanco(BankAccountEditFragment.this.cuentaBanco);
                } else {
                    unYp8VQThY.getInstance().addCuentaBanco(BankAccountEditFragment.this.cuentaBanco);
                }
                if (BankAccountEditFragment.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) BankAccountEditFragment.this.getActivity()).UpdateMenu();
                } else if (BankAccountEditFragment.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) BankAccountEditFragment.this.getActivity()).UpdateMenu();
                }
                BankAccountEditFragment.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateCuenta(String ccuenta) {
        if (ccuenta.isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (ccuenta.length() != 16) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputCuenta);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !ccuenta.contains(this.cuentaBanco.getCuenta()))) {
            if (unYp8VQThY.getInstance().getCuentaListsWithAccount(ccuenta).size() != 0) {
                this.inputLayoutCuenta.setError(this.context.getString(R.string.err_msg_num_cuenta_existe));
                requestFocus(this.inputCuenta);
                return false;
            }
        } else {
            this.inputLayoutCuenta.setErrorEnabled(false);
        }
        if (!validateCuentaOrigen(ccuenta) && !this.isConfirm) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Advertencia");
            builder.setMessage(this.mensajeCuentaOrigen);
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
                    oaewezanai.isConfirm = true;
                    oaewezanai.submitForm();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            return false;
        }
        return true;
    }

    private boolean validateSpinnerCliente() {
        if (this.spinnerCliente.getText().toString().trim().isEmpty()) {
            return false;
        }
        this.lista_vacia = true;
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private void initSeparator() {
        loadDrawables();
        cuentaOnListeners();
    }

    private void loadDrawables() {
        try {
            Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_bpa);
            Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
            this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
            Drawable drBANDEC = getResources().getDrawable(R.drawable.tarjeta_bandec);
            Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
            this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
            Drawable drMETRO = getResources().getDrawable(R.drawable.tarjeta_metro);
            Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
            this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
            Drawable drBFI = getResources().getDrawable(R.drawable.tarjeta_bfi);
            Bitmap bitmapBFI = Bitmap.createBitmap(drBFI.getIntrinsicWidth(), drBFI.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapBFI);
            drBFI.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drBFI.draw(canvas);
            this.tarjeta_bfi = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBFI, 80, 60, true));
            Drawable drClasica = getResources().getDrawable(R.drawable.tarjeta_clasica);
            Bitmap bitmapClasica = ((BitmapDrawable) drClasica).getBitmap();
            Resources resources = getResources();
            Bitmap bitmapBPA2 = Bitmap.createScaledBitmap(bitmapClasica, 80, 60, true);
            this.tarjeta_clasica = new BitmapDrawable(resources, bitmapBPA2);
            Drawable drClasicaE = getResources().getDrawable(R.drawable.tarjeta_clasica_empresarial);
            Bitmap bitmapClasicaE = ((BitmapDrawable) drClasicaE).getBitmap();
            this.tarjeta_clasica_emp = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapClasicaE, 80, 60, true));
        } catch (Exception ex) {
            Log.e("ERROR-FOTO_CUENTA", ex.getMessage());
        }
    }

    private void cuentaOnListeners() {
        this.inputCuenta.setOnKeyListener(new View.OnKeyListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.8
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    try {
                        BankAccountEditFragment.this.keyDel = 1;
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }
        });
        this.inputCuenta.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.BankAccountEditFragment.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (count == 16) {
                        BankAccountEditFragment.this.inputCuenta.setText(BankAccountEditFragment.this.getCuentaFormateada(s.toString()));
                        return;
                    }
                    if (count == 0) {
                        BankAccountEditFragment.this.keyDel = 1;
                    }
                    boolean flag = true;
                    String[] eachBlock = BankAccountEditFragment.this.inputCuenta.getText().toString().split("-");
                    for (String str : eachBlock) {
                        if (str.length() > 4) {
                            flag = false;
                        }
                    }
                    if (!flag) {
                        BankAccountEditFragment.this.inputCuenta.setText(BankAccountEditFragment.this.cuentaCaracteres);
                        return;
                    }
                    BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
                    if (oaewezanai.keyDel != 0) {
                        oaewezanai.cuentaCaracteres = oaewezanai.inputCuenta.getText().toString();
                        BankAccountEditFragment.this.keyDel = 0;
                        return;
                    }
                    int length = oaewezanai.inputCuenta.getText().length() + 1;
                    float length2 = (BankAccountEditFragment.this.inputCuenta.getText().length() + 1) % 5;
                    if ((BankAccountEditFragment.this.inputCuenta.getText().length() + 1) % 5 == 0 && BankAccountEditFragment.this.inputCuenta.getText().toString().split("-").length <= 3) {
                        BankAccountEditFragment.this.inputCuenta.setText(((Object) BankAccountEditFragment.this.inputCuenta.getText()) + "-");
                        BankAccountEditFragment.this.inputCuenta.setSelection(BankAccountEditFragment.this.inputCuenta.getText().length());
                    }
                    BankAccountEditFragment oaewezanai2 = BankAccountEditFragment.this;
                    oaewezanai2.cuentaCaracteres = oaewezanai2.inputCuenta.getText().toString();
                } catch (Exception ex) {
                    Log.e("ERROR-SEPARADOR_CUENTA", ex.getMessage());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BankAccountEditFragment oaewezanai = BankAccountEditFragment.this;
                oaewezanai.mostrarTarjeta(oaewezanai.inputCuenta, BankAccountEditFragment.this.inputCuenta.getText().toString());
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    /* JADX WARN: Code duplicated, block: B:37:0x0080  */
    public void mostrarTarjeta(AutoCompleteTextView inputField, String tarjeta) {
        int tipoBanco = 0;
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 4) {
                    String bancoCode = tarjeta.substring(5, 7);
                    if ("12".equals(bancoCode)) tipoBanco = 1;
                    else if ("06".equals(bancoCode)) tipoBanco = 2;
                    else if ("95".equals(bancoCode)) tipoBanco = 3;
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
                    tipoBanco = 4;
                } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
                    tipoBanco = 6;
                } else {
                    String bancoCode = tarjeta.substring(0, 2);
                    if ("12".equals(bancoCode)) tipoBanco = 1;
                    else if ("06".equals(bancoCode)) tipoBanco = 2;
                    else if ("05".equals(bancoCode)) tipoBanco = 3;
                    else if ("03".equals(bancoCode)) tipoBanco = 5;
                }
            }

            Drawable icon = null;
            switch (tipoBanco) {
                case 1: icon = this.tarjeta_bpa; break;
                case 2: icon = this.tarjeta_bandec; break;
                case 3: icon = this.tarjeta_metro; break;
                case 4: icon = this.tarjeta_clasica; break;
                case 5: icon = this.tarjeta_bfi; break;
                case 6: icon = this.tarjeta_clasica_emp; break;
                default: break;
            }
            inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, icon, null);
        } catch (Exception ignored) {
            // The source leaves the current drawable untouched for malformed PAN input.
        }
    }

    private boolean validateNumber() {
                    if (!this.inputMovil.getText().toString().trim().isEmpty() && this.inputMovil.getText().toString().trim().length() != 8) {
                        this.inputLayoutMovil.setError(this.context.getString(R.string.err_msg_num_cel_eight));
                        requestFocus(this.inputMovil);
                        return false;
                    }
                    this.inputLayoutMovil.setErrorEnabled(false);
                    return true;
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
                }

                private String getPhone(Uri uri) {
                    String phone = null;
                    String id = null;
                    try {
                        Cursor contactCursor = this.context.getContentResolver().query(uri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, null, null, null);
                        if (contactCursor.moveToFirst()) {
                            id = contactCursor.getString(0);
                        }
                        contactCursor.close();
                        Cursor phoneCursor = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = ? AND data2= 2", new String[]{id}, null);
                        if (phoneCursor.moveToFirst()) {
                            phone = phoneCursor.getString(0);
                        }
                        phoneCursor.close();
                    } catch (Exception e) {
                    }
                    return phone;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public String getCuentaFormateada(String cuentaData) {
                    String temp = BuildConfig.FLAVOR;
                    for (int i = 0; i < 16; i++) {
                        temp = temp + Character.toString(cuentaData.charAt(i));
                        if ((temp.length() + 1) % 5 == 0 && temp.split("-").length <= 3) {
                            temp = temp + "-";
                        }
                    }
                    return temp;
                }

                private boolean validateCuentaOrigen(String cuenta) {
                    BankingAccountValidatorFragment.DatosTarjeta datosTarjeta = validarCuenta(cuenta);
                    this.mensajeCuentaOrigen = BuildConfig.FLAVOR;
                    if (!datosTarjeta.isValidBank) {
                        this.mensajeCuentaOrigen = this.context.getString(R.string.alert_msg_no_bank);
                        return false;
                    }
                    return true;
                }
            }
