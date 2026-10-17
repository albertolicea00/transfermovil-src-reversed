package cu.etecsa.transfermovil.ui.fragment.wallet;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU
 * @extends QGQCqILT4b (→ BaseWalletQueryFragment)
 * @fingerprint 580 lines. Traffic fine (multa transito) detail/payment via wallet.
 *              Article type, hazard level, traffic violation incidents adapters.
 *              Date picker, fine format suggestion. USSD dispatch for multa payment.
 */
public class WalletTrafficFineDetailFragment extends Fragment {

    public Activity activity;
    public ArrayAdapter<CharSequence> adapterArticulosMulta;
    public ArrayAdapter<CharSequence> adapterTipoPeligrosidad;
    public Button btn_aceptar;
    public DatePickerDialog datePicker;
}
