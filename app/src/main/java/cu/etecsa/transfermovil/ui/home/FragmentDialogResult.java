package cu.etecsa.transfermovil.ui.home;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.O2oXWQuRDi
 * @fingerprint POJO holding a Fragment + AlertDialog.Builder pair.
 *              Used by UssdDispatcher.goToFragment() to return either a fragment
 *              to navigate to or a dialog to display.
 */
public class FragmentDialogResult {
    public Fragment fragment;
    public AlertDialog.Builder dialogo;

    public FragmentDialogResult() {
        this.fragment = null;
        this.dialogo = null;
    }

    public FragmentDialogResult(Fragment fragment, AlertDialog.Builder dialogo) {
        this.fragment = fragment;
        this.dialogo = dialogo;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public AlertDialog.Builder getDialogo() {
        return this.dialogo;
    }

    public void setDialogo(AlertDialog.Builder dialogo) {
        this.dialogo = dialogo;
    }
}
