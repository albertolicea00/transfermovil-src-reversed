package cu.etecsa.transfermovil.core;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import java.util.Objects;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.upY36rhCRL
 * @fingerprint Wraps ActivityResultLauncher for single-permission requests.
 *              Registers result callback then immediately launches the permission dialog.
 */
public class PermissionRequester {

    public void startpermissionrequest(FragmentActivity fr, final PermissionGrantCallback callback, String manifest) {
        ActivityResultContracts.RequestPermission contract = new ActivityResultContracts.RequestPermission();
        Objects.requireNonNull(callback);
        ActivityResultLauncher<String> resultPermissionLauncher = fr.registerForActivityResult(
                contract,
                result -> callback.inGranted(result)
        );
        resultPermissionLauncher.launch(manifest);
    }
}
