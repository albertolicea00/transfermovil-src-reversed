package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.cT6z0jcLEG;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV;

/* JADX INFO: loaded from: classes.dex */
public class mxDKBoiAGg implements Pb8vvZarL8 {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8
    public zDPt4FP8OC getMontoPagos(cT6z0jcLEG request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/home/getmonto", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8
    public zDPt4FP8OC pagoEstadistica(cT6z0jcLEG request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/home/pagoDiario", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8
    public zDPt4FP8OC devolucionEstadistica(cT6z0jcLEG request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/home/Devoluciongetdata", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8
    public zDPt4FP8OC estadisticaCuadre(tVwkzUCBeV request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/payment/sumOfsales", request, key);
    }
}
