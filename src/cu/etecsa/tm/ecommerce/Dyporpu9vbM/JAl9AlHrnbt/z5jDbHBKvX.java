package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN;

/* JADX INFO: loaded from: classes.dex */
public class z5jDbHBKvX implements ii95c4ZHJp {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC getDevoluciones(String key, Context context) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC getDevoluciones(YbN03uYqWN filtro, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/refunds/analisis", filtro, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC devolverPago(FhtwnBtOAx request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/refunds/store", request, key);
    }
}
