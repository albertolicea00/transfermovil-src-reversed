package cu.etecsa.transfermovil.banking.ui.bpa;

import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.IixhA1yamp
 * @fingerprint BPA registration fragment (362 lines). USSD code "49".
 *              Fields: nombre, apellido, CI, cuenta. Shows bank card images (BPA/BANDEC/Metro).
 *              Implements UssdResponseObserver for async USSD response handling.
 */
public class BpaRegistrationFragment extends Fragment {
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    // USSD: actionCallUSSDBack(context, "49", cadena, "Desea registrarse en el sistema", group, ...)
    // Layout: R.layout.qeuk96upbfs2v
}
