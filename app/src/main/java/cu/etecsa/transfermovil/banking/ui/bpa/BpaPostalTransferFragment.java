package cu.etecsa.transfermovil.banking.ui.bpa;

import androidx.fragment.app.Fragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.A3HXMd4hA0h
 * @fingerprint BPA postal transfer (giro postal) fragment (188 lines).
 *              Fields: CI, monto, tipo_giro (dropdown from R.array.tipo_giro), moneda.
 *              Calculates wire transfer fee via GlobalState.calculate_importe_giro().
 */
public class BpaPostalTransferFragment extends Fragment {
    public String[] tipogiro;
    // Layout: R.layout.c6qtx7siox18wl
    // Msg: "Desea realizar un giro al propietario del carnet de identidad: [CI], monto: [X] CUP"
}
