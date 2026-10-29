package cu.etecsa.transfermovil.banking;

import androidx.fragment.app.Fragment;
import cu.etecsa.transfermovil.core.enums.OperationType;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.AuthSession;
import java.util.Calendar;
import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.puGDXabehz
 * @fingerprint abstract Fragment, validateAuth() with Calendar.add(12, 30)
 *
 * Abstract base fragment for banking operations that require authentication.
 * Implements local session validation: checks AOperKey table for auth state,
 * enforces a 30-minute session timeout by comparing current time against
 * authDate + 30 minutes.
 *
 * Auth states:
 *   NO_REGISTRADO — no AOperKey record exists for this operation (first use)
 *   AUTH_OK       — authenticated and within 30-minute window
 *   NO_AUTH       — record exists but not authenticated, or session expired
 *   ERRO_AUTH     — exception while checking/updating an authenticated session
 *
 * Session expiry: when time exceeds authDate + 30min, auth flag is cleared
 * and authDate set to null in AOperKey table (persisted via DatabaseHelper).
 *
 * NOTE: This is LOCAL session management only — no server-side session exists.
 * The 30-minute window controls how often the user must re-enter their bank PIN,
 * which is then embedded in the USSD code sent via tel: intent.
 */
public abstract class AuthValidator extends Fragment {

    public enum AuthStatus {
        NO_REGISTRADO,
        AUTH_OK,
        NO_AUTH,
        ERRO_AUTH
    }

    /**
     * Validates banking auth for a given operation type.
     *
     * Flow:
     *   1. Look up AOperKey record for this operation
     *   2. If null → NO_REGISTRADO (user needs to register bank first)
     *   3. If isAuth() == false → NO_AUTH (needs PIN entry)
     *   4. If isAuth() == true, check time window:
     *      - authDate ≤ now ≤ authDate + 30min → AUTH_OK
     *      - Otherwise → clear auth, persist, return NO_AUTH
     *   5. Exceptions inside the authenticated-session check → ERRO_AUTH
     *
     * @param operationType the banking operation enum value
     * @return auth status determining whether operation can proceed
     */
    public AuthStatus validateAuth(OperationType operationType) {
        AuthSession key = DatabaseHelper.getInstance().getAOperKey(operationType);
        if (key != null) {
            if (key.isAuth()) {
                try {
                    Date now = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(key.getAuthDate());
                    calendar.add(Calendar.MINUTE, 30);
                    Date expiry = calendar.getTime();
                    if (now.compareTo(key.getAuthDate()) >= 0 && now.compareTo(expiry) <= 0) {
                        return AuthStatus.AUTH_OK;
                    }
                    key.setAuth(false);
                    key.setAuthDate(null);
                    DatabaseHelper.getInstance().updateAOperKey(key);
                    return AuthStatus.NO_AUTH;
                } catch (Exception e) {
                    return AuthStatus.ERRO_AUTH;
                }
            }
            return AuthStatus.NO_AUTH;
        }
        return AuthStatus.NO_REGISTRADO;
    }
}
