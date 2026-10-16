package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.K1a8LCEmAD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.L9hiDpmAir;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.XMAvvl35Dj;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb;

/* JADX INFO: loaded from: classes.dex */
public class sAzoBGHkpK implements slJjVOMGPF {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC login(XMAvvl35Dj request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/loginapk", request);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC loginFactor(L9hiDpmAir request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/loginfactorapk", request);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC listarPermisosDar(String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/roles/childgrants", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC getProfile(String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/current", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC updateProfile(w4DRczPYeb request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/profile/update", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF
    public zDPt4FP8OC cambioPassword(K1a8LCEmAD request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/profile/password", request, key);
    }
}
