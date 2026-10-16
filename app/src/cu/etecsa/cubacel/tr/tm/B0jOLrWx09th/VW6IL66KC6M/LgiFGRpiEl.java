package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.f9CS9TjtF3;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class LgiFGRpiEl extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public Activity activity;
    public R1sDOSqZ2z agencia;
    public Button btnAceptar;
    public ImageButton btnContacts;
    public CheckBox chConfirmPhone;
    public Uri contactUri;
    public String displayContact;
    public AutoCompleteTextView inputClave;
    public AutoCompleteTextView inputCuenta;
    public TextInputLayout inputLayoutClave;
    public TextInputLayout inputLayoutCuenta;
    public TextInputLayout inputLayoutMonto;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    public AutoCompleteTextView inputMonto;
    public Boolean isShareQR;
    public boolean isValidateDescWithRegularExtresion;
    public TextInputLayout lyLayoutDescripcion;
    public TextInputLayout lyPhoneConfirm;
    public TextInputLayout lyStImporte;
    public ConstraintLayout modalConfirmarPago;
    public String noProveedor;
    public String obldesc;
    public Pattern patternDescription;
    public jN13TOyLMX spinnerTipoMonedaImporte;
    public f9CS9TjtF3 tipoQR;
    public String[] tipomoneda;
    public TextView txContacto;
    public AutoCompleteTextView txDescripcion;
    public AutoCompleteTextView txPhoneConfirm;
    public AutoCompleteTextView txStImporte;
    public TextView txTitulo;
    public int spinnerPositionSelect = 0;
    public String aux = "1";
    public int varContacto = 1;
    public String DEEP_LINK_URL = "https://transfermovil.app/action?";
    public String dataSendQR = BuildConfig.FLAVOR;
    public boolean isEnviarAuxDat = false;
    public String idQR = "0000";
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            try {
                if (b) {
                    LgiFGRpiEl.this.modalConfirmarPago.setVisibility(0);
                    LgiFGRpiEl.this.isEnviarAuxDat = true;
                } else {
                    LgiFGRpiEl.this.modalConfirmarPago.setVisibility(8);
                    LgiFGRpiEl.this.isEnviarAuxDat = false;
                }
            } catch (Exception e) {
            }
        }
    };
    private View.OnClickListener btnContactsOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.LgiFGRpiEl.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                if (Build.VERSION.SDK_INT < 23 || LgiFGRpiEl.this.context.checkSelfPermission("android.permission.READ_CONTACTS") != -1) {
                    LgiFGRpiEl.this.busk_contactos(v);
                } else {
                    LgiFGRpiEl.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            } catch (Exception e) {
            }
        }
    };

    public void initComponents() {
        try {
            this.chConfirmPhone = (CheckBox) this.rootView.findViewById(R.id.chConfirmPhone);
            this.modalConfirmarPago = (ConstraintLayout) this.rootView.findViewById(R.id.modalConfirmarPago);
            this.lyPhoneConfirm = (TextInputLayout) this.rootView.findViewById(R.id.lyPhoneConfirm);
            this.txPhoneConfirm = (AutoCompleteTextView) this.rootView.findViewById(R.id.txPhoneConfirm);
            ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnContacts);
            this.btnContacts = imageButton;
            imageButton.setOnClickListener(this.btnContactsOnClick);
            this.txContacto = (TextView) this.rootView.findViewById(R.id.txContacto);
            this.chConfirmPhone.setOnCheckedChangeListener(this.onCheckedChangeListener);
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[Catch: Exception -> 0x0134, TRY_LEAVE, TryCatch #7 {Exception -> 0x0134, blocks: (B:6:0x001b, B:15:0x003d, B:17:0x0043), top: B:98:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:58:0x010e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0122  */
    /* JADX WARN: Code duplicated, block: B:69:0x012c A[Catch: Exception -> 0x003a, TRY_LEAVE, TryCatch #5 {Exception -> 0x003a, blocks: (B:9:0x0025, B:11:0x0028, B:67:0x0124, B:69:0x012c), top: B:94:0x0025 }] */
    public boolean manipulateExtraQRData(String extraData, String idTransaccion, String noProveedor) {
        boolean isOk;
        Date fAhora;
        boolean isVencida;
        boolean isOk2 = true;
        try {
            String data = procesarExtra(extraData, noProveedor, idTransaccion);
            if (data != null) {
                String description = BuildConfig.FLAVOR;
                String regularExpresion = BuildConfig.FLAVOR;
                String fechaCompleta = BuildConfig.FLAVOR;
                try {
                    String[] parts = data.split(",");
                    if (parts != null) {
                        try {
                            if (parts.length > 0) {
                                description = parts[0];
                                regularExpresion = parts[1];
                                fechaCompleta = parts[2];
                                this.idQR = parts[3];
                            }
                            if (description.length() > 0) {
                                isOk = true;
                            } else {
                                this.lyLayoutDescripcion.setHint(description);
                                isOk = true;
                                try {
                                    this.txDescripcion.setEnabled(true);
                                    this.lyLayoutDescripcion.setEnabled(true);
                                } catch (Exception e) {
                                    e = e;
                                    isOk2 = isOk;
                                    try {
                                        e.printStackTrace();
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                            regularExpresion.length();
                            if (fechaCompleta.length() <= 0 && fechaCompleta.length() == 16) {
                                boolean isNoVigente = false;
                                String fechaIni = fechaCompleta.substring(0, 8);
                                String fechaFin = fechaCompleta.substring(8, 16);
                                boolean isVencida2 = false;
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Date fAhora2 = sdf.parse(sdf.format(new Date()));
                                try {
                                    if (fechaIni.contains("00000000")) {
                                        fAhora = fAhora2;
                                    } else {
                                        Date fInit = new SimpleDateFormat("ddMMyyyy").parse(fechaIni);
                                        fAhora = fAhora2;
                                        try {
                                            if (!fAhora.after(fInit) && !fAhora.equals(fInit)) {
                                                isNoVigente = true;
                                                Toast.makeText(this.context, "QR no disponible", 1).show();
                                            }
                                        } catch (Exception e3) {
                                            ex = e3;
                                            Log.e("EXC", ex.getMessage());
                                        }
                                    }
                                } catch (Exception e4) {
                                    ex = e4;
                                    fAhora = fAhora2;
                                }
                                try {
                                    if (!fechaFin.contains("00000000")) {
                                        Date fFin = new SimpleDateFormat("ddMMyyyy").parse(fechaFin);
                                        if (!fAhora.before(fFin) && !fAhora.equals(fFin)) {
                                            isVencida = true;
                                            try {
                                                Toast.makeText(this.context, "QR vencido", 1).show();
                                            } catch (Exception e5) {
                                                ex = e5;
                                                isVencida2 = true;
                                                Log.e("EXC", ex.getMessage());
                                                isVencida = isVencida2;
                                            }
                                        } else {
                                            isVencida = false;
                                        }
                                    } else {
                                        isVencida = false;
                                    }
                                } catch (Exception e6) {
                                    ex = e6;
                                }
                                if (isNoVigente || isVencida) {
                                    isOk2 = false;
                                } else {
                                    isOk2 = isOk;
                                }
                            } else {
                                isOk2 = isOk;
                            }
                            if (this.idQR.length() > 0) {
                                this.isEnviarAuxDat = true;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            e.printStackTrace();
                            return isOk2;
                        }
                    } else {
                        if (description.length() > 0) {
                            isOk = true;
                        } else {
                            this.lyLayoutDescripcion.setHint(description);
                            isOk = true;
                            this.txDescripcion.setEnabled(true);
                            this.lyLayoutDescripcion.setEnabled(true);
                        }
                        regularExpresion.length();
                        if (fechaCompleta.length() <= 0) {
                            isOk2 = isOk;
                        } else {
                            isOk2 = isOk;
                        }
                        if (this.idQR.length() > 0) {
                            this.isEnviarAuxDat = true;
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            }
        } catch (Exception e9) {
        }
        return isOk2;
    }

    public boolean validateDescriptionRegularExtrepresion(JSONObject jsonData) {
        try {
            this.isValidateDescWithRegularExtresion = false;
            if (jsonData.has("regexdesc") && !jsonData.isNull("regexdesc")) {
                String regexdesc = String.valueOf(jsonData.get("regexdesc"));
                try {
                    this.patternDescription = Pattern.compile(regexdesc, 2);
                    this.isValidateDescWithRegularExtresion = true;
                } catch (Exception e) {
                }
                return true;
            }
        } catch (Exception e2) {
        }
        return false;
    }

    public void JSONCompleteFields(String qrdata) {
        if (isJSONValid(qrdata)) {
            this.dataSendQR = BuildConfig.FLAVOR;
            String idTransaccion = BuildConfig.FLAVOR;
            try {
                try {
                    JSONObject jsonObj = new JSONObject(qrdata);
                    String importe = "0";
                    String moneda = "CUP";
                    if (jsonObj.has("id_transaccion")) {
                        idTransaccion = String.valueOf(jsonObj.get("id_transaccion"));
                        this.inputCuenta.setText(idTransaccion);
                    }
                    if (jsonObj.has("numero_proveedor")) {
                        this.noProveedor = String.valueOf(jsonObj.get("numero_proveedor"));
                    }
                    if (jsonObj.has("extra") && !jsonObj.isNull("extra")) {
                        Log.d("EXTRAQR", jsonObj.get("extra").toString());
                        String extra = String.valueOf(jsonObj.get("extra"));
                        if (!manipulateExtraQRData(extra, idTransaccion, this.noProveedor)) {
                            this.inputCuenta.setText(BuildConfig.FLAVOR);
                            this.noProveedor = BuildConfig.FLAVOR;
                            return;
                        }
                    }
                    if (jsonObj.has("importe")) {
                        String importeBruto = String.valueOf(jsonObj.get("importe"));
                        String importe2 = formatImporte(importeBruto);
                        this.inputMonto.setText(importe2);
                        importe = importe2;
                    }
                    if (jsonObj.has("moneda")) {
                        String moneda2 = (String) jsonObj.get("moneda");
                        if (moneda2.contains("CUP") || moneda2.contains("1")) {
                            this.spinnerPositionSelect = 0;
                            this.spinnerTipoMonedaImporte.setText("CUP");
                        } else if (moneda2.contains("CUC") || moneda2.contains("2")) {
                            this.spinnerPositionSelect = 1;
                            this.spinnerTipoMonedaImporte.setText("CUC");
                        } else if (moneda2.contains("USD") || moneda2.contains("3")) {
                            this.spinnerPositionSelect = 2;
                            this.spinnerTipoMonedaImporte.setText("USD");
                        }
                        moneda = moneda2;
                    }
                    if (jsonObj.has("version")) {
                        String p = String.valueOf(jsonObj.get("version"));
                        if (!p.isEmpty()) {
                            this.aux = String.valueOf(jsonObj.get("version"));
                        }
                    }
                    if (jsonObj.has("titulo") && !jsonObj.isNull("titulo")) {
                        String titulo = String.valueOf(jsonObj.get("titulo"));
                        this.txTitulo.setVisibility(0);
                        if (titulo.length() < 40) {
                            this.txTitulo.setText(titulo);
                        } else {
                            this.txTitulo.setText(titulo.subSequence(0, 19));
                        }
                    }
                    if (Double.parseDouble(importe) == 0.0d) {
                        this.lyStImporte.setVisibility(0);
                        if (this.agencia != R1sDOSqZ2z.BFI) {
                            this.lyLayoutDescripcion.setVisibility(0);
                        }
                        this.tipoQR = f9CS9TjtF3.ESTATICO;
                        this.inputLayoutMonto.setVisibility(8);
                        this.inputLayoutCuenta.setVisibility(8);
                        if (jsonObj.has("descripcion")) {
                            String desc = jsonObj.getString("descripcion");
                            if (desc.length() > 0) {
                                this.txDescripcion.setText(desc);
                                this.txDescripcion.setEnabled(false);
                            }
                        }
                    } else if (idTransaccion.contains("ESTATICO")) {
                        if (this.agencia != R1sDOSqZ2z.BFI) {
                            this.lyLayoutDescripcion.setVisibility(0);
                        }
                        this.txDescripcion.setVisibility(0);
                        this.tipoQR = f9CS9TjtF3.ESTATICO;
                        this.inputLayoutCuenta.setVisibility(8);
                        if (jsonObj.has("importe")) {
                            this.txStImporte.setText(String.valueOf(importe));
                            this.txStImporte.setEnabled(false);
                        }
                        if (jsonObj.has("descripcion") && jsonObj.has("descripcion")) {
                            String desc2 = jsonObj.getString("descripcion");
                            if (desc2.length() > 0) {
                                this.txDescripcion.setText(desc2);
                                this.txDescripcion.setEnabled(false);
                            }
                        }
                    }
                    this.dataSendQR = this.DEEP_LINK_URL + String.format("id_transaccion=%s&importe=%s&moneda=%s&numero_proveedor=%s", idTransaccion, importe, moneda, this.noProveedor);
                    this.isShareQR = true;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                } catch (Exception e2) {
                    ex = e2;
                    ex.printStackTrace();
                    Toast.makeText(this.context, "ERROR no es posible leer el Código QR.", 1);
                    this.isShareQR = false;
                }
            } catch (JSONException e3) {
                e = e3;
            } catch (Exception e4) {
                ex = e4;
            }
        }
    }

    public String formatImporte(String importeBruto) {
        if (U6ucOCBccJ.isNotacionCientifica(importeBruto)) {
            BigDecimal bigDecimalValue = new BigDecimal(importeBruto);
            double importe = bigDecimalValue.doubleValue();
            String formato = "#." + new String(new char[String.valueOf(importe).length() - 3]).replace((char) 0, '#');
            DecimalFormat df = new DecimalFormat(formato);
            String importeFormato = df.format(importe);
            return importeFormato;
        }
        Double.parseDouble(importeBruto);
        return importeBruto;
    }

    public boolean isJSONValid(String jpo48jtycgtsp) {
        try {
            new JSONObject(jpo48jtycgtsp);
            return true;
        } catch (JSONException e) {
            try {
                new JSONArray(jpo48jtycgtsp);
                return true;
            } catch (JSONException e2) {
                return false;
            }
        }
    }

    public static boolean esNotacionCientifica(String numero) {
        return Pattern.matches("^[+-]?\\d+\\.?\\d*([eE][+-]?\\d+)?$", numero);
    }

    public String procesarExtra(String code, String source, String idTransaccion) throws NoSuchAlgorithmException {
        try {
            byte[] passwordByte = new byte[0];
            byte[] ivByte = new byte[0];
            try {
                passwordByte = V5FFEZ0Qrr0.shKey(source);
                ivByte = V5FFEZ0Qrr0.shKey(idTransaccion);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String ps = V5FFEZ0Qrr0.toHex(passwordByte).substring(0, 16);
            Locale locale = Locale.ROOT;
            String ps2 = ps.toLowerCase(locale);
            String ivps = V5FFEZ0Qrr0.toHex(ivByte).substring(0, 16).toLowerCase(locale);
            byte[] passBytesSimples = new byte[16];
            for (int i = 0; i < 16; i++) {
                passBytesSimples[i] = Byte.parseByte(Integer.toHexString((byte) ps2.charAt(i)));
            }
            byte[] ivBytesSimples = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                ivBytesSimples[i2] = Byte.parseByte(Integer.toHexString((byte) ivps.charAt(i2)));
            }
            String valorSalida = V5FFEZ0Qrr0.decryptAES(code, ps2, ivps);
            return valorSalida;
        } catch (Exception e2) {
            return BuildConfig.FLAVOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void busk_contactos(View v) {
        this.varContacto = 1;
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

    public void renderContact(Uri uri) {
        try {
            String telf = getPhone(uri);
            if (telf != null) {
                String telf2 = telf.replace(" ", BuildConfig.FLAVOR).trim();
                if (telf2.contains("+")) {
                    telf2 = telf2.substring(1);
                }
                if (telf2.charAt(0) == '0') {
                    telf2 = telf2.substring(1);
                }
                if ((telf2.substring(0, 3).toString().contains("535") || telf2.substring(0, 3).toString().contains("536")) && telf2.length() == 10) {
                    telf2 = telf2.substring(2);
                }
                this.txPhoneConfirm.setText(telf2);
                String str = this.displayContact;
                if (str != null && str.length() > 0) {
                    this.txContacto.setText(this.displayContact);
                    this.txContacto.setVisibility(0);
                    this.displayContact = BuildConfig.FLAVOR;
                }
            }
        } catch (Exception e) {
            this.displayContact = BuildConfig.FLAVOR;
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
        try {
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
        } catch (Exception e) {
            return null;
        }
    }
}
