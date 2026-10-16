package cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class M0cQEZKnN5 implements u4TIG1AFbY {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUsers(String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUsers(String key, Context context) {
        zDPt4FP8OC dummy = new zDPt4FP8OC();
        dummy.setCodigoHTTP(200);
        dummy.setError(false);
        dummy.setMenssaje("Test OK");
        String jsonLocation = loadJSONFromAsset("usersDummy.json", context);
        try {
            JSONObject jsonobject = new JSONObject(jsonLocation);
            dummy.setJsonObject(jsonobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dummy;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getUserChild(PxQtH5HO6p request, String key, Context context) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC createUser(qwlqFYH8aO request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC updateUser(qwlqFYH8aO request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC deleteUser(PxQtH5HO6p request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC getPermisos(PxQtH5HO6p request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC activarUsuario(PxQtH5HO6p request, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY
    public zDPt4FP8OC updatePermisos(u5mpEjsROy request, String key) {
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
