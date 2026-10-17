package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SjZHfPJPwX
 * @extends GVEefrRz76 (→ BaseWalletObserverFragment with UssdResponseObserver)
 * @fingerprint 419 lines. Bill payment and mobile recharge via wallet.
 *              Recharge type selector, MCBank account adapter, contact picker.
 *              Currency CUC/CUP hint. USSD dispatch for factura/pago/recarga.
 */
public class WalletBillPaymentFragment extends Fragment {

    public Activity activity;
    public ArrayAdapter<CharSequence> adapterTipoRecarga;
    private Button btnAceptar;
    private ImageButton btnBskContacto;
}
