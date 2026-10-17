package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL
 * @extends QGQCqILT4b (→ BaseWalletQueryFragment)
 * @fingerprint 300 lines. TFA (Telefonía Fija Alternativa) recharge via wallet.
 *              Recharge type selector, MCBank account handling, contact picker.
 *              CUC/CUP currency hint. USSD dispatch for TFA/factura/pago/recarga.
 */
public class WalletTfaRechargeFragment extends Fragment {

    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoRecarga;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
}
