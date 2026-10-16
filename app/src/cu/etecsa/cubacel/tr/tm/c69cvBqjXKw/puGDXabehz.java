package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import androidx.fragment.app.Fragment;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class puGDXabehz extends Fragment {

    public enum AUTH_STATUS {
        NO_REGISTRADO,
        AUTH_OK,
        NO_AUTH,
        ERRO_AUTH
    }

    public AUTH_STATUS validateAuth(Nl0yptXmjQ operationEntity) {
        AOperKey operKey = unYp8VQThY.getInstance().getAOperKey(operationEntity);
        if (operKey != null) {
            if (operKey.isAuth()) {
                try {
                    Date dateToCompare = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(operKey.getAuthDate());
                    c.add(12, 30);
                    Date date2 = c.getTime();
                    if (dateToCompare.compareTo(operKey.getAuthDate()) >= 0 && dateToCompare.compareTo(date2) <= 0) {
                        return AUTH_STATUS.AUTH_OK;
                    }
                    operKey.setAuth(false);
                    operKey.setAuthDate(null);
                    unYp8VQThY.getInstance().updateAOperKey(operKey);
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
