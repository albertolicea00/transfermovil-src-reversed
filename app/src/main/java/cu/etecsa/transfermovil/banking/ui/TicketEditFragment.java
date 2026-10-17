package cu.etecsa.transfermovil.banking.ui;

import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq
 * @fingerprint Fuel ticket (TCTicket) detail/edit fragment. Implements AccountsResultCallback.
 *              Shows ticket info, consumption status, QR code data.
 */
public class TicketEditFragment extends Fragment implements AccountsResultCallback {
    private Button btnAceptar;
    // public TCTicket ticket;
    public TextView toolbar_title;

    @Override
    public void onCuentasResult(Boolean success, int count, String message) {}

    @Override
    public void onSetProgressBarVisibility(int visibility) {}
}
