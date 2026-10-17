package cu.etecsa.transfermovil.promo;

import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.SmsPromotion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI.BOf8kgNm7V
 * @fingerprint Filters active daily SMS promotions from DB. Disables expired promos.
 */
public class DailyPromoProvider {

    public List<SmsPromotion> getPromosDia() throws ParseException {
        List<SmsPromotion> result = null;
        List<SmsPromotion> allPromos = DatabaseHelper.getInstance().getAllPromoSMSLists();
        if (allPromos != null && allPromos.size() > 0) {
            result = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (SmsPromotion promo : allPromos) {
                if (promo.getFecha_fin() == null) {
                    result.add(promo);
                } else {
                    Date fechaFin = promo.getFecha_fin();
                    Date today = new Date();
                    try {
                        fechaFin = sdf.parse(sdf.format(fechaFin));
                        today = sdf.parse(sdf.format(today));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (fechaFin.after(today) || today.equals(fechaFin)) {
                        result.add(promo);
                    } else {
                        promo.setHabilitado(false);
                        DatabaseHelper.getInstance().updatePromoSMS(promo);
                    }
                }
            }
        }
        return result;
    }
}
