package cu.etecsa.transfermovil.config;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.transfermovil.util.Sha256Util;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM
 * @fingerprint PIN-pad fragment for agent activation. Digits 0-9 buttons append to code1.
 *              On "Aceptar", SHA-256(code1) is compared against 14 hardcoded hashes
 *              (code2..code14 + universal). Match → navigate to U4uiCgRvr6 (registration).
 *              No match → "Codigo Invalido" toast.
 *
 * Dependencies:
 *   - UkO3Y6TcHD → Sha256Util (l08fNVC4KOKK)
 *   - U4uiCgRvr6 → RegistrationFragment (oEpx7i6I9Bq)
 *   - Client → data entity (ZNRpoHwtLXM.MZUDJuUoMJL)
 */
public class ActivationPinPadFragment extends Fragment {
    private Button button0, button1, button2, button3, button4;
    private Button button5, button6, button7, button8, button9;
    private Button clearBtn;
    private Button btnAceptar;
    // public Client cliente;
    private EditText codeEdit;
    public Context context;
    public TextView toolbarTitle;

    public String code1 = "";
    public String code2 = "6613c28d4045f9f7dfbb740c3e54724f220719620502c29b22fe96ef20c9b585";
    public String code3 = "6e092fbf4ba82a31a6041fb765b0b0d672b460eb6222cd0bc2b0999d73a72801";
    public String code4 = "b484767f274dab1fa6bed3fa95f99b044ae174390693b27ed8eeca0d688e7851";
    public String code5 = "a01f929ed340c7f45aacc6c5f4f33180fe0483c47d55f3d46e742f7cc2562df4";
    public String code6 = "a1b40bf56b6cdf465cc1aafb61a12f173ba8f39560f91d6f96efeaa264a01904";
    public String code7 = "1e8ca0e81402900fe142b5355a1723cf7d3fa196a7e239393f2bb61011676763";
    public String universal = "2d8e2633b04cee57eaead8737301330bd40a8482d3b1c4b5862dc6218accc938";
    public String code8 = "f248c07a334ffcbb633895b01722d87613fa31f083d768c644d3829f961541ef";
    public String code9 = "efbfb0e6ec1e7b516e7be93098729b012d0ed73a5e805c2b11a6f68544ac15e9";
    public String code10 = "920ef8938a9afcb782aa970b594156b9cade539c6138858fcacc6dc0ee1aa4ec";
    public String code11 = "92128c7fc22f3f685e9914450a0bd855e258aafff9351663260b080a4a7c5188";
    public String code12 = "f46575a329a230b15f81527dbee5186f23ed7dbd381ad6c00662e5655083cc34";
    public String code13 = "c0ed2d7859d1938feef9fd0c7ab231fb0e3366f4fb75ef82b9c95ccf6160bbd0";
    public String code14 = "b55c5134f66d2f0562339be311e902679dd75ed42f7f215c22583564ffe32dbf";
    public boolean editMode = false;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // View rootView = inflater.inflate(R.layout.h5kgnjnkxu0hcd, container, false);
        // context = container.getContext();
        // toolbarTitle = rootView.findViewById(R.id.toolbar_title);
        // codeEdit = rootView.findViewById(R.id.editTextCode);
        //
        // btnAceptar = rootView.findViewById(R.id.buttonAceptar);
        // btnAceptar.setOnClickListener(v -> {
        //     code1 = Sha256Util.generateSHA256(code1);
        //     if (code1.equals(code2) || code1.equals(code3) || code1.equals(code4)
        //         || code1.equals(code5) || code1.equals(code6) || code1.equals(code7)
        //         || code1.equals(code8) || code1.equals(code9) || code1.equals(code10)
        //         || code1.equals(code11) || code1.equals(code12) || code1.equals(code13)
        //         || code1.equals(code14) || code1.equals(universal)) {
        //         FragmentManager fm = getActivity().getSupportFragmentManager();
        //         fm.beginTransaction()
        //           .replace(R.id.containerView, new RegistrationFragment())
        //           .addToBackStack(null).commit();
        //     } else {
        //         Toast.makeText(container.getContext(), "Codigo Invalido", Toast.LENGTH_LONG).show();
        //     }
        // });
        //
        // clearBtn = rootView.findViewById(R.id.buttonClear);
        // clearBtn.setOnClickListener(v -> { code1 = ""; check(); });
        //
        // setupDigitButton(rootView, R.id.button0, "0");
        // setupDigitButton(rootView, R.id.button1, "1");
        // ... (buttons 2-9 same pattern)
        //
        // return rootView;
        return null;
    }

    private void check() {
        // codeEdit.setText("");
        // codeEdit.setText(code1);
    }
}
