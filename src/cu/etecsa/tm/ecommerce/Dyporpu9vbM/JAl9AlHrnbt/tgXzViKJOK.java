package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.hJ45hA3s7Q;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.l2LU222Exdh;

/* JADX INFO: loaded from: classes.dex */
public class tgXzViKJOK implements YRajWCKfyB {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB
    public zDPt4FP8OC getNegocios(String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/business/getData", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB
    public zDPt4FP8OC createNegocio(hJ45hA3s7Q request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/business/storeBusiness", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB
    public zDPt4FP8OC updateNegocio(hJ45hA3s7Q request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/business/updateBusiness", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB
    public zDPt4FP8OC deleteNegocio(hJ45hA3s7Q request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/business/deleteBusiness", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB
    public zDPt4FP8OC getHastags(l2LU222Exdh request, String key) {
        return y6NQQxH0NI.getInstance().processGET("/api/business/gethashtag", key);
    }
}
