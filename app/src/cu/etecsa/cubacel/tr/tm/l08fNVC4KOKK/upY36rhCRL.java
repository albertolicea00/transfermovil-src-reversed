package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.fragment.app.FragmentActivity;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class upY36rhCRL {
    public void startpermissionrequest(FragmentActivity fr, final WfyP4YvyPu fs, String manifest) {
        ActivityResultContracts$RequestPermission activityResultContracts$RequestPermission = new ActivityResultContracts$RequestPermission();
        Objects.requireNonNull(fs);
        ActivityResultLauncher<String> resultPermissionLauncher = fr.registerForActivityResult(activityResultContracts$RequestPermission, new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.upY36rhCRL$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                fs.inGranted(((Boolean) obj).booleanValue());
            }
        });
        resultPermissionLauncher.launch(manifest);
    }
}
