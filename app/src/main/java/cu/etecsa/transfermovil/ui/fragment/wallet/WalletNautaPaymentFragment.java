package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.yJCgdDviIu
 * @fingerprint 439 lines. Nauta payment with currency selection via wallet.
 *              Account type selector (Nauta/NautaHogar), currency type selector,
 *              contact picker, amount input. USSD dispatch for nauta recharge.
 */
public class WalletNautaPaymentFragment extends Fragment {

    public ArrayAdapter<CharSequence> adapterTipoCuenta;
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private TextInputEditText inputImporte;
}
