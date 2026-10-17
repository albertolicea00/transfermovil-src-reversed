package cu.etecsa.transfermovil.banking.ui.bpa;

import androidx.fragment.app.Fragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.l2i2DeDgof
 * @fingerprint BPA phone bill payment fragment (172 lines). USSD code "42".
 *              Fields: cuenta (phone account), monto, moneda, pagoTotal flag.
 *              Uses Factura entity for account autocomplete.
 */
public class BpaPhonePaymentFragment extends Fragment {
    public boolean pagoTotal = false;
    // USSD: actionCallUSSDBack(context, "42", cadena, msg, group, ...)
}
