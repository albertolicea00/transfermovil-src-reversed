package cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.MlJJtXnfZh;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m1OGkT0zRws implements iXb3TXled5 {
    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getPagos(String key, Context context) {
        zDPt4FP8OC dummy = new zDPt4FP8OC();
        dummy.setCodigoHTTP(200);
        dummy.setError(false);
        dummy.setMenssaje("Test OK");
        String jsonLocation = loadJSONFromAsset("pagosDummy.json", context);
        try {
            JSONObject jsonobject = new JSONObject(jsonLocation);
            dummy.setJsonObject(jsonobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dummy;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getPagos(zKgYf9THHQ filtro, String key, Context context) {
        zDPt4FP8OC dummy = new zDPt4FP8OC();
        dummy.setCodigoHTTP(200);
        dummy.setError(false);
        dummy.setMenssaje("Test OK");
        Gson gson = new Gson();
        String dataJSON = gson.toJson(filtro);
        Log.i("PAGOS_DUMMY", "JSON FILTRO: " + dataJSON);
        String jsonLocation = loadJSONFromAsset("pagosDummy.json", context);
        try {
            JSONObject jsonobject = new JSONObject(jsonLocation);
            dummy.setJsonObject(jsonobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dummy;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC sendPagoDinamico(Ph6mQUZRw4 filtro, String key, Context context) {
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5
    public zDPt4FP8OC getTrazaPago(MlJJtXnfZh filtro, String key, Context context) {
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
