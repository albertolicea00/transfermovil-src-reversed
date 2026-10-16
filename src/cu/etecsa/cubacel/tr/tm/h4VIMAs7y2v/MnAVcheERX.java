package cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class MnAVcheERX extends Fragment {
    public String EditTextValue;
    public String HEADER_TRANSFER = "TRANSFERMOVIL_ETECSA,TRANSFERENCIA";
    public R1sDOSqZ2z agencia;
    public Bitmap bitmap;
    public Button button;
    public Context context;
    public EditText editText;
    private CheckBox guardarDatosCheck;
    public ImageView imageView;
    private TextInputLayout inputLayoutNumeroDestinatario;
    private TextInputLayout inputLayoutPAM;
    private TextInputLayout inputLayoutPass;
    private AutoCompleteTextView inputNumeroDestinatario;
    private AutoCompleteTextView inputPAM;
    private EditText inputPass;
    public Nl0yptXmjQ operacion;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.cgvyvxsykrvfz, container, false);
        this.context = container.getContext();
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("Nl0yptXmjQ")) {
                this.operacion = (Nl0yptXmjQ) arg.getSerializable("Nl0yptXmjQ");
            }
            if (arg.containsKey("R1sDOSqZ2z")) {
                this.agencia = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
            }
        }
        this.imageView = (ImageView) this.rootView.findViewById(R.id.imageView);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_phone_confirm);
        this.inputPAM = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pfnumero);
        this.inputLayoutPAM = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pfnumero);
        this.guardarDatosCheck = (CheckBox) this.rootView.findViewById(R.id.checkGuardar);
        if (Nl0yptXmjQ.Transferencia == this.operacion) {
            QRGenAutoTransferencia();
        }
        this.imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.MnAVcheERX.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog settingsDialog = new Dialog(MnAVcheERX.this.getActivity());
                View v = MnAVcheERX.this.getActivity().getLayoutInflater().inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
                ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
                Bitmap bm = ((BitmapDrawable) MnAVcheERX.this.imageView.getDrawable()).getBitmap();
                iv.setImageBitmap(bm);
                settingsDialog.getWindow().requestFeature(1);
                settingsDialog.setContentView(v);
                settingsDialog.show();
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.button = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.MnAVcheERX.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Nl0yptXmjQ nl0yptXmjQ = Nl0yptXmjQ.Transferencia;
                MnAVcheERX mnAVcheERX = MnAVcheERX.this;
                if (nl0yptXmjQ == mnAVcheERX.operacion && mnAVcheERX.validateCuenta() && MnAVcheERX.this.validateNumber() && !MnAVcheERX.this.QRGenNewTransferencia()) {
                    Toast.makeText(MnAVcheERX.this.context, "Ha ocurrido un error, chequee los datos insertados", 1);
                }
            }
        });
        return this.rootView;
    }

    public void generarQR(String text) {
        Bitmap icon = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.etecsa);
        this.imageView.setImageBitmap(ZUoEY89WdA.ProductLogo(icon, text, false, R.color.primaryDarkColor));
    }

    public void QRGenAutoTransferencia() {
        try {
            unYp8VQThY.init(this.context);
            rDEl7rW1aN bs = new rDEl7rW1aN();
            String code = bs.getqrcodeBk(this.agencia);
            if (code != BuildConfig.FLAVOR) {
                String movil = unYp8VQThY.getInstance().getAllAppConfigLists().get(0).getPhone();
                String cadena = this.HEADER_TRANSFER + "," + code + "," + movil + ",";
                generarQR(cadena);
                this.inputPAM.setText(code);
                this.inputNumeroDestinatario.setText(movil);
            }
        } catch (Exception e) {
        }
    }

    public boolean QRGenNewTransferencia() {
        try {
            String code = this.inputPAM.getText().toString().trim();
            if (code.length() != 16) {
                return false;
            }
            String movil = this.inputNumeroDestinatario.getText().toString();
            if (movil.length() != 8 && movil.length() != 10) {
                movil = BuildConfig.FLAVOR;
            }
            String cadena = this.HEADER_TRANSFER + "," + code + "," + movil + ",";
            generarQR(cadena);
            if (!this.guardarDatosCheck.isChecked()) {
                return true;
            }
            unYp8VQThY.init(this.context);
            rDEl7rW1aN bs = new rDEl7rW1aN();
            return bs.setqrcodeBk(this.agencia, code);
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateNumber() {
        if (this.inputNumeroDestinatario.getText().toString().trim().length() != 8 && this.inputNumeroDestinatario.getText().toString().trim().length() != 10 && !this.inputNumeroDestinatario.getText().toString().trim().isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateCuenta() {
        if (this.inputPAM.getText().toString().trim().isEmpty()) {
            this.inputLayoutPAM.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputPAM);
            return false;
        }
        if (this.inputPAM.getText().toString().trim().length() != 16) {
            this.inputLayoutPAM.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(this.inputPAM);
            return false;
        }
        this.inputLayoutPAM.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
