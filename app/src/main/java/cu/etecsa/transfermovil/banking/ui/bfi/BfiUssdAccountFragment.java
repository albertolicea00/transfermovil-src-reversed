package cu.etecsa.transfermovil.banking.ui.bfi;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/**
 * Shared BFI helper for two-account forms. It adds callback and packet state
 * to the clean account base; it is not a one-to-one APK source class.
 */
public abstract class BfiUssdAccountFragment extends BaseTwoAccountFragment
        implements pAzq93vIl3.UssdResponseObserver {

    public pAzq93vIl3 manager;
    public int MAX_PARAMETERS_PQUETE = 4;

    @Override
    public void onUssdResponseReceived(String response) {
        // The original base has no response-side behavior.
    }

    @Override
    public void onCloseAndBack() {
        try {
            FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.popBackStack();
        } catch (Exception ignored) {
            try {
                getActivity().onBackPressed();
            } catch (Exception ignoredAgain) {
                // Match the source's best-effort fallback.
            }
        }
    }
}
