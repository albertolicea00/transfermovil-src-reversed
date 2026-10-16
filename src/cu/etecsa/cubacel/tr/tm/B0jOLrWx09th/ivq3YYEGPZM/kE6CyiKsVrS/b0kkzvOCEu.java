package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;

/* JADX INFO: loaded from: classes.dex */
public class b0kkzvOCEu extends Fragment {
    private Button btnAceptar;
    public ImageButton btnQR;
    public Context context;
    private EditText inputClave;
    private TextInputLayout inputLayoutClaver;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.bnr245wzxfvn3, container, false);
        this.context = container.getContext();
        this.inputLayoutClaver = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_gclavebono);
        this.inputClave = (EditText) this.rootView.findViewById(R.id.input_gclavebono);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnQRScan);
        this.btnQR = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b0kkzvOCEu.this.getQR();
            }
        });
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                b0kkzvOCEu.this.submitForm();
            }
        });
        completarQR();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (validateAutentificacion()) {
            String cadena = "662*" + this.inputClave.getText().toString();
            String msg = "Verifique la clave del bono antes de afectuar la recarga:  " + this.inputClave.getText().toString();
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRecargarMovil);
            rDEl7rW1aN bs = new rDEl7rW1aN();
            if (bs.getCodeAgent() != null) {
                if (bs.getCodeAgent().getCode().contains("-1")) {
                    ((S9ycHcoxAzy) getActivity()).actionCallUSSD(cadena, msg, group);
                    return;
                } else {
                    ((IHVTCBmiLV) getActivity()).actionCallUSSD(cadena, msg, group);
                    return;
                }
            }
            ((S9ycHcoxAzy) getActivity()).actionCallUSSD(cadena, msg, group);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQR() {
        FragmentActivity activity = getActivity();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Recarga_Cupon);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.ETECSA);
        if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
            return;
        }
        OJ3XxacXOT qr = new OJ3XxacXOT();
        qr.setArguments(arg);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
    }

    private boolean validateAutentificacion() {
        if (this.inputClave.getText().toString().trim().isEmpty()) {
            this.inputLayoutClaver.setError(this.context.getString(R.string.err_msg_clave_bono_invalid));
            requestFocus(this.inputClave);
            return false;
        }
        this.inputLayoutClaver.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void completarQR() {
        String data = BuildConfig.FLAVOR;
        if (getArguments() != null) {
            Bundle arg = getArguments();
            if (arg.containsKey("QRData")) {
                String qrdata = arg.getString("QRData");
                if (!qrdata.matches("^[0-9]+$")) {
                    for (int i = 0; i < qrdata.length(); i++) {
                        if (Character.isDigit(qrdata.charAt(i))) {
                            data = data + qrdata.charAt(i);
                        }
                    }
                } else {
                    data = qrdata;
                }
                if (qrdata.length() > 0) {
                    this.inputClave.setText(data);
                }
            }
        }
    }
}
