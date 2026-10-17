package cu.etecsa.transfermovil.banking.ui;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.oaEWezaNAI
 * @fingerprint Bank account (CuentaBanco) add/edit form. Extends EV9Tu0zIL4 (contact picker base).
 *              Fields: account number (encrypted), description, client spinner.
 *              Account numbers masked with character substitution.
 *
 * @security Account stored AES/ECB encrypted. Plaintext visible in UI during editing.
 */
public class BankAccountEditFragment extends Fragment {
    // extends EV9Tu0zIL4 (contact picker base fragment)
    private Button btnAceptar;
    private ImageButton btnBskContacto;
    // public CuentaBanco cuentaBanco;
    public String cuenta;
    public String cuentaCaracteres;
    private EditText inputDescricion;
}
