package cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.ZxjGjcZ9UR;

/* JADX INFO: loaded from: classes.dex */
public class yKRmUtDUiP implements qL2BfhKUbD {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC getCuentas(String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/user/sources", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC getCuentasNegocio(String key, Context context) {
        return y6NQQxH0NI.getInstance().processPOST("/api/business/getBusiness", key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC createCuenta(ZxjGjcZ9UR request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/source/storeSource", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC updateCuenta(ZxjGjcZ9UR request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/source/updateSource", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC deleteCuenta(ZxjGjcZ9UR request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/source/deleteSource", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC activarCuenta(ZxjGjcZ9UR request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/source/activarSource", request, key);
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC desactivarCuenta(ZxjGjcZ9UR request, String key) {
        return y6NQQxH0NI.getInstance().processPOST("/api/source/desactivarSource", request, key);
    }
}
