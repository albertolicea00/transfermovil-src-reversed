package cu.etecsa.transfermovil.ui.qr;

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
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.core.BankType;
import cu.etecsa.transfermovil.core.OperationType;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.MnAVcheERX
 * @fingerprint Generates QR codes for bank transfer operations.
 *              Format: "TRANSFERMOVIL_ETECSA,TRANSFERENCIA,<16-digit-account>,<phone>,"
 *              Validates 16-digit account numbers and 8/10-digit phone numbers.
 *              Uses QrCodeGenerator.ProductLogo() with ETECSA logo overlay.
 */
public class QrTransferGeneratorFragment extends Fragment {

    public String HEADER_TRANSFER = "TRANSFERMOVIL_ETECSA,TRANSFERENCIA";
    public BankType agencia;          // R1sDOSqZ2z
    public Bitmap bitmap;
    public Button button;
    public Context context;
    public EditText editText;
    public String EditTextValue;
    private CheckBox guardarDatosCheck;
    public ImageView imageView;
    private TextInputLayout inputLayoutNumeroDestinatario;
    private TextInputLayout inputLayoutPAM;
    private TextInputLayout inputLayoutPass;
    private AutoCompleteTextView inputNumeroDestinatario;
    private AutoCompleteTextView inputPAM;
    private EditText inputPass;
    public OperationType operacion;   // Nl0yptXmjQ
    public View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.cgvyvxsykrvfz, container, false);
        this.context = container.getContext();
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("Nl0yptXmjQ")) {
                this.operacion = (OperationType) arg.getSerializable("Nl0yptXmjQ");
            }
            if (arg.containsKey("R1sDOSqZ2z")) {
                this.agencia = (BankType) arg.getSerializable("R1sDOSqZ2z");
            }
        }
        this.imageView = (ImageView) this.rootView.findViewById(R.id.imageView);
        this.inputNumeroDestinatario = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_phone_confirm);
        this.inputLayoutNumeroDestinatario = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_phone_confirm);
        this.inputPAM = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_pfnumero);
        this.inputLayoutPAM = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_pfnumero);
        this.guardarDatosCheck = (CheckBox) this.rootView.findViewById(R.id.checkGuardar);
        if (OperationType.Transferencia == this.operacion) {
            QRGenAutoTransferencia();
        }
        this.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog settingsDialog = new Dialog(QrTransferGeneratorFragment.this.getActivity());
                View v = QrTransferGeneratorFragment.this.getActivity().getLayoutInflater().inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
                ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
                Bitmap bm = ((BitmapDrawable) QrTransferGeneratorFragment.this.imageView.getDrawable()).getBitmap();
                iv.setImageBitmap(bm);
                settingsDialog.getWindow().requestFeature(1);
                settingsDialog.setContentView(v);
                settingsDialog.show();
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.button = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (OperationType.Transferencia == QrTransferGeneratorFragment.this.operacion
                        && QrTransferGeneratorFragment.this.validateCuenta()
                        && QrTransferGeneratorFragment.this.validateNumber()
                        && !QrTransferGeneratorFragment.this.QRGenNewTransferencia()) {
                    Toast.makeText(QrTransferGeneratorFragment.this.context,
                            "Ha ocurrido un error, chequee los datos insertados", Toast.LENGTH_LONG);
                }
            }
        });
        return this.rootView;
    }

    public void generarQR(String text) {
        Bitmap icon = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.etecsa);
        this.imageView.setImageBitmap(QrCodeGenerator.ProductLogo(icon, text, false, R.color.primaryDarkColor));
    }

    public void QRGenAutoTransferencia() {
        try {
            DatabaseHelper.init(this.context);
            // rDEl7rW1aN → BankCodeAccessor: gets saved QR bank code per BankType
            // bs.getqrcodeBk(agencia) retrieves stored 16-digit account for this bank
            String code = ""; // TODO: BankCodeAccessor.getqrcodeBk(this.agencia)
            if (!code.isEmpty()) {
                String movil = DatabaseHelper.getInstance().getAllAppConfigLists().get(0).getPhone();
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
                movil = "";
            }
            String cadena = this.HEADER_TRANSFER + "," + code + "," + movil + ",";
            generarQR(cadena);
            if (!this.guardarDatosCheck.isChecked()) {
                return true;
            }
            DatabaseHelper.init(this.context);
            // TODO: BankCodeAccessor.setqrcodeBk(this.agencia, code)
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean validateNumber() {
        String num = this.inputNumeroDestinatario.getText().toString().trim();
        if (num.length() != 8 && num.length() != 10 && !num.isEmpty()) {
            this.inputLayoutNumeroDestinatario.setError(this.context.getString(R.string.err_msg_num_cel_eight));
            requestFocus(this.inputNumeroDestinatario);
            return false;
        }
        this.inputLayoutNumeroDestinatario.setErrorEnabled(false);
        return true;
    }

    boolean validateCuenta() {
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
