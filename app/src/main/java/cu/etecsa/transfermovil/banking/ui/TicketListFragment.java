package cu.etecsa.transfermovil.banking.ui;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV
 * @fingerprint Transport/fuel ticket (TCTicket) list fragment. Extends AuthValidator (puGDXabehz)
 *              for 30-min auth session. Implements AccountsResultCallback for fuel SMS import.
 *              Uses khginYXYg6 adapter.
 */
public class TicketListFragment extends AuthValidator implements AccountsResultCallback {
    // implements khginYXYg6.ViewHolder.ClickListener
    // public RecyclerView rvTickets;

    @Override
    public void onCuentasResult(Boolean success, int count, String message) {
        // Refresh ticket list after SMS import
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        // Show/hide progress bar
    }
}
