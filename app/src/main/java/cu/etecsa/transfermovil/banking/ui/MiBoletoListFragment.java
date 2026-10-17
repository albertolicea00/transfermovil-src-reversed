package cu.etecsa.transfermovil.banking.ui;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.x5ijzOU4VE
 * @fingerprint MiBoleto ticket list fragment. Extends AuthValidator (puGDXabehz)
 *              for auth session. Implements OffersResultCallback for offers SMS import.
 *              Uses DmvQBLZLbV adapter.
 */
public class MiBoletoListFragment extends AuthValidator implements OffersResultCallback {
    // public RecyclerView rvBoletos;

    @Override
    public void onOfertasResult(boolean success, int count, String message) {
        // Refresh offers list
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {}
}
