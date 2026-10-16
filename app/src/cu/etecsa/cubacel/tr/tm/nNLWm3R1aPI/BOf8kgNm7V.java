package cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI;

import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BOf8kgNm7V {
    public List<PromoSMS> getPromosDia() throws ParseException {
        Date date;
        Date date2;
        List<PromoSMS> arrayList = null;
        List<PromoSMS> allPromoSMSLists = unYp8VQThY.getInstance().getAllPromoSMSLists();
        if (allPromoSMSLists != null && allPromoSMSLists.size() > 0) {
            arrayList = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (PromoSMS promoSMS : allPromoSMSLists) {
                if (promoSMS.getFecha_fin() == null) {
                    arrayList.add(promoSMS);
                } else {
                    Date fecha_fin = promoSMS.getFecha_fin();
                    Date date3 = new Date();
                    try {
                        fecha_fin = simpleDateFormat.parse(simpleDateFormat.format(fecha_fin));
                        date = simpleDateFormat.parse(simpleDateFormat.format(date3));
                        date2 = fecha_fin;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        date2 = fecha_fin;
                        date = date3;
                    }
                    if (date2.after(date) || date.equals(date2)) {
                        arrayList.add(promoSMS);
                    } else {
                        promoSMS.setHabilitado(false);
                        unYp8VQThY.getInstance().updatePromoSMS(promoSMS);
                    }
                }
            }
        }
        return arrayList;
    }
}
