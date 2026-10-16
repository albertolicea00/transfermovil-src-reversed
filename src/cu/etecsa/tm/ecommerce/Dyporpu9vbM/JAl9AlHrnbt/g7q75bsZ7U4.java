package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.MlJJtXnfZh;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ;

/* JADX INFO: loaded from: classes.dex */
public class g7q75bsZ7U4 implements iXb3TXled5 {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getPagos(String key, Context context) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getPagos(zKgYf9THHQ filtro, String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/payment/analisis", filtro, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC sendPagoDinamico(Ph6mQUZRw4 filtro, String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/payment/store", filtro, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getTrazaPago(MlJJtXnfZh filtro, String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/payment_refunds/list", filtro, key);
    }
}
