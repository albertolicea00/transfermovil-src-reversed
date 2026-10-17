package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf
 * @extends QGQCqILT4b (→ BaseWalletQueryFragment) implements UssdResponseObserver
 * @fingerprint 432 lines. Wallet transfer/payment/recharge combined fragment.
 *              Recharge type selector, MCBank account handling, contact picker.
 *              CUC/CUP currency hint. USSD dispatch for transfer/pago/recarga/factura.
 */
public class WalletTransferFragment extends Fragment {

    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoRecarga;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
}
