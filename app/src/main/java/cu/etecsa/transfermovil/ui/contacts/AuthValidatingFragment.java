package cu.etecsa.transfermovil.ui.contacts;

import androidx.fragment.app.Fragment;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.AuthSession;
import cu.etecsa.transfermovil.core.enums.OperationType;
import java.util.Calendar;
import java.util.Date;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.puGDXabehz
 * @fingerprint Abstract fragment with 30-minute auth session validation.
 *              Checks AOperKey (AuthSession) table for valid session within 30 mins.
 */
public abstract class AuthValidatingFragment extends Fragment {

    public enum AUTH_STATUS {
        NO_REGISTRADO,
        AUTH_OK,
        NO_AUTH,
        ERRO_AUTH
    }

    public AUTH_STATUS validateAuth(OperationType operationEntity) {
        AuthSession operKey = DatabaseHelper.getInstance().getAOperKey(operationEntity);
        if (operKey != null) {
            if (operKey.isAuth()) {
                try {
                    Date dateToCompare = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(operKey.getAuthDate());
                    c.add(Calendar.MINUTE, 30);
                    Date date2 = c.getTime();
                    if (dateToCompare.compareTo(operKey.getAuthDate()) >= 0
                            && dateToCompare.compareTo(date2) <= 0) {
                        return AUTH_STATUS.AUTH_OK;
                    }
                    return AUTH_STATUS.NO_AUTH;
                } catch (Exception e) {
                    return AUTH_STATUS.ERRO_AUTH;
                }
            }
            return AUTH_STATUS.NO_AUTH;
        }
        return AUTH_STATUS.NO_REGISTRADO;
    }
}
