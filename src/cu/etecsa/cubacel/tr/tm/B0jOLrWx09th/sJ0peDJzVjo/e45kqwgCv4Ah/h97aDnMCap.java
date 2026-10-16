package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.j256.ormlite.field.FieldType;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class h97aDnMCap extends Agg55uYctq {
    public static final int PICK_CONTACT_REQUEST = 1;
    public R1sDOSqZ2z agencia;
    public Button btnAceptar;
    public ImageButton btnContacts;
    private Uri contactUri;
    public TextInputLayout lyBeneficiario;
    public TextInputLayout lyMonto;
    public String movil;
    public AutoCompleteTextView txBeneficiario;
    public AutoCompleteTextView txMonto;
    public int banco = 0;
    public String agenciaL = BuildConfig.FLAVOR;
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.h97aDnMCap.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            h97aDnMCap.this.submitForm();
            if (h97aDnMCap.this.isFieldsOK()) {
                try {
                    h97aDnMCap.this.enviarUSSD();
                } catch (Exception e) {
                }
            }
        }
    };
    private View.OnClickListener btnContactosOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.h97aDnMCap.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            h97aDnMCap.this.busk_contactos(v);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.t71h4xlk1k3pgs, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass3.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    this.agenciaL = "01";
                    break;
                case 2:
                    this.banco = 2;
                    this.agenciaL = "02";
                    break;
                case 3:
                    this.banco = 3;
                    this.agenciaL = "03";
                    break;
            }
        }
        loadViewUI(this.rootView);
        initComponentesCuentas(this.rootView, this.agencia);
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.h97aDnMCap$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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
        this.txBeneficiario = (AutoCompleteTextView) v.findViewById(R.id.txBeneficiario);
        this.lyBeneficiario = (TextInputLayout) v.findViewById(R.id.lyBeneficiario);
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        this.lyMonto = (TextInputLayout) v.findViewById(R.id.lyMonto);
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btnContacts);
        this.btnContacts = imageButton;
        imageButton.setOnClickListener(this.btnContactosOnClick);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enviarUSSD() {
        try {
            float importe = Float.parseFloat(this.txMonto.getText().toString().trim());
            String numberAsString = String.format("%.2f", Float.valueOf(importe));
            String cadena = "0000*" + importe + "*1*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
            String msg = "Confirme que desea comprar un cupón de combustible por el importe de " + numberAsString + " CUP.";
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
            if (!this.isPartialUSSD) {
                FBsQzP3Zfj.actionCallUSSDBack(this.context, "35", cadena, msg, group, getFragmentManager());
            } else {
                this.manager.principalEnviarUSSD(this.context, "110", "35", this.agenciaL, this.MAX_PARAMETERS_PQUETE, cadena, msg, group, getFragmentManager());
            }
        } catch (Exception e) {
            Toast.makeText(this.context, "Error intentelo de nuevo", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsOK() {
        return validateMonto() && validateSelectionAccounts();
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
            this.txBeneficiario.setText(telf);
        } catch (Exception e) {
        }
    }

    private String getPhone(Uri uri) {
        String id = null;
        String phone = null;
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
        return phone;
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
