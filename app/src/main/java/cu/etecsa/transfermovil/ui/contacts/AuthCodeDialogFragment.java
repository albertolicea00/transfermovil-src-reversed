package cu.etecsa.transfermovil.ui.contacts;

import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import cu.etecsa.transfermovil.core.enums.AuthAction;
import cu.etecsa.transfermovil.core.enums.OperationType;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R
 * @fingerprint DialogFragment for auth code entry. Validates code via AES encryption,
 *              stores AuthSession (AOperKey) with 30-minute expiry.
 *              Uses V5FFEZ0Qrr0 for PIN encryption with hardcoded key.
 */
public class AuthCodeDialogFragment extends DialogFragment {
    public AuthAction actionEntity;
    public Button btnAceptarCodigo;
    public OperationType operationEntity;

    // onCreateDialog: builds AlertDialog with code input field
    // btnAceptarCodigo: encrypts entered PIN, stores AuthSession, navigates to operation
}
