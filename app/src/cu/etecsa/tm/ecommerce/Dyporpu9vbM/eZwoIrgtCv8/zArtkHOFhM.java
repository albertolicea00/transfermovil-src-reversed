package cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.ZxjGjcZ9UR;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zArtkHOFhM implements qL2BfhKUbD {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC getCuentas(String key, Context context) {
        zDPt4FP8OC dummy = new zDPt4FP8OC();
        dummy.setCodigoHTTP(200);
        dummy.setError(false);
        dummy.setMenssaje("Test OK");
        String jsonLocation = loadJSONFromAsset("cuentasDummy.json", context);
        try {
            JSONObject jsonobject = new JSONObject(jsonLocation);
            dummy.setJsonObject(jsonobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dummy;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC getCuentasNegocio(String key, Context context) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC createCuenta(ZxjGjcZ9UR request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC updateCuenta(ZxjGjcZ9UR request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC deleteCuenta(ZxjGjcZ9UR request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC activarCuenta(ZxjGjcZ9UR request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD
    public zDPt4FP8OC desactivarCuenta(ZxjGjcZ9UR request, String key) {
        return null;
    }

    public String loadJSONFromAsset(String nameJson, Context context) {
        try {
            InputStream is = context.getAssets().open(nameJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            return json;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
