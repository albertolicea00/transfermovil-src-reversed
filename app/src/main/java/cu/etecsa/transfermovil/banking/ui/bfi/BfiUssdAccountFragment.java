package cu.etecsa.transfermovil.banking.ui.bfi;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;

/**
 * Shared BFI form base. Account selection and card rendering come from the
 * reconstructed two-account base; USSD callbacks match Agg55uYctq.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
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
