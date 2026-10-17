package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.qHxc7HcCDX
 * @extends QGQCqILT4b (→ BaseWalletQueryFragment)
 * @fingerprint 81 lines. Abstract base for OFA (Obligaciones Fiscales) operations.
 *              SpinnerDialog for ZPC (tax obligation) search, code input field.
 *              Subclasses implement specific OFA operation types.
 */
public abstract class WalletOfaBaseFragment extends Fragment {

    public ImageButton btSearchZPC;
    public SpinnerDialog spinnerDialog;
    public ArrayAdapter zpcArrayAdapter;
}
