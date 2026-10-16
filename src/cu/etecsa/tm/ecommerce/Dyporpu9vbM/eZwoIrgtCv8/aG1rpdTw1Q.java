package cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class aG1rpdTw1Q implements ii95c4ZHJp {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC getDevoluciones(String key, Context context) {
        zDPt4FP8OC dummy = new zDPt4FP8OC();
        dummy.setCodigoHTTP(200);
        dummy.setError(false);
        dummy.setMenssaje("Test OK");
        String jsonLocation = loadJSONFromAsset("devolucionesDummy.json", context);
        try {
            JSONObject jsonobject = new JSONObject(jsonLocation);
            dummy.setJsonObject(jsonobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dummy;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC getDevoluciones(YbN03uYqWN filtro, String key) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp
    public zDPt4FP8OC devolverPago(FhtwnBtOAx request, String key) {
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
