package cu.etecsa.transfermovil.ui.fragment.banking.common;

import android.widget.AutoCompleteTextView;
import androidx.fragment.app.Fragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.B1joQfx53b
 * @fingerprint Billing payment fragment with account input, amount, currency spinner.
 *              Contacts permission for account lookup. Supports pagoTotal flag.
 */
public class BillingPaymentFragment extends Fragment {
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputMonto;
    public boolean pagoTotal = false;
    public String tipoCuenta;
}
