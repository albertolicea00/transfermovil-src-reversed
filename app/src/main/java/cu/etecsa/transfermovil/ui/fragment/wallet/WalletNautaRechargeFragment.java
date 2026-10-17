package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6
 * @extends Agg55uYctq (→ BaseWalletOperationFragment)
 * @fingerprint 609 lines. Nauta account recharge/payment.
 *              Account type selector (Nauta/NautaHogar), SpinnerDialog for account search,
 *              amount input, currency selector. USSD dispatch for nauta recharge.
 */
public class WalletNautaRechargeFragment extends Fragment {

    public ArrayAdapter<CharSequence> adapterTipoCuenta;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    private ImageButton btnContacts;
    private TextInputEditText inputImporte;
}
