package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.widget.Button;
import android.widget.ImageButton;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u
 * @extends Agg55uYctq (→ BaseWalletOperationFragment)
 * @fingerprint 354 lines. External payment (PCC/factura) via wallet.
 *              SpinnerDialog for account search, 12-digit card series validation,
 *              amount input. USSD dispatch for factura/PCC/recarga.
 */
public class WalletExternalPaymentFragment extends Fragment {

    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public SpinnerDialog spinnerDialog;
}
