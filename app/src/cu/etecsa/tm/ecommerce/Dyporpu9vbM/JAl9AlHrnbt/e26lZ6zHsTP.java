package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;

/* JADX INFO: loaded from: classes.dex */
public class e26lZ6zHsTP implements u4TIG1AFbY {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUsers(String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/childusers/list", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUsers(String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/childusers/list", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUserChild(PxQtH5HO6p request, String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/get", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC createUser(qwlqFYH8aO request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/store", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC updateUser(qwlqFYH8aO request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/update", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC deleteUser(PxQtH5HO6p request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/destroy", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getPermisos(PxQtH5HO6p request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/childusers/grants", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC activarUsuario(PxQtH5HO6p request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/banned", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC updatePermisos(u5mpEjsROy request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/childusers/update/grants", request, key);
    }
}
