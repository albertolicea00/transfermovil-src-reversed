package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.l2LU222Exdh;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.p0XuqX2hWag;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Nm2a3aUwFB {
    public String HEAD_LOG = "Nm2a3aUwFB";
    public Context context;

    public Nm2a3aUwFB(Context context) {
        this.context = context;
    }

    public p0XuqX2hWag getHashtags(String key) {
        p0XuqX2hWag response = new p0XuqX2hWag();
        try {
            l2LU222Exdh request = new l2LU222Exdh();
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getNegociosRepo().getHastags(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getHashTagJSON(apiResponseBase.getJsonObject());
                }
                int code = apiResponseBase.getCodigoHTTP();
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(code));
                response.setHttpCode(code);
                if (!apiResponseBase.getMenssaje().isEmpty()) {
                    UhA7J2923N.getInstance().WriteLog(code, this.HEAD_LOG, apiResponseBase.getMenssaje());
                }
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500));
                response.setHttpCode(500);
                if (!apiResponseBase.getMenssaje().isEmpty()) {
                    UhA7J2923N.getInstance().WriteLog(500, this.HEAD_LOG, "zDPt4FP8OC is NUll: " + apiResponseBase.getMenssaje());
                }
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public p0XuqX2hWag getHashTagJSON(JSONObject json) throws JSONException {
        this.HEAD_LOG += " Nm2a3aUwFB getHashTagJSON:";
        Log.i("Nm2a3aUwFB JSON", json.toString());
        String code = BuildConfig.FLAVOR;
        p0XuqX2hWag response = new p0XuqX2hWag();
        response.setOK(false);
        if (!json.isNull("code")) {
            try {
                code = json.getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (code.contains("Ok")) {
                try {
                    response.setOK(true);
                    Gson gson = new Gson();
                    Log.i("Nm2a3aUwFB", gson.toJson(json));
                    p0XuqX2hWag hash = (p0XuqX2hWag) new GsonBuilder().setPrettyPrinting().create().fromJson(json.toString(), p0XuqX2hWag.class);
                    response = hash;
                    response.setOK(true);
                    return response;
                } catch (Exception ex) {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    return response;
                }
            }
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.PAGO_DINAMICO_POST, code));
            return response;
        }
        response.setOK(false);
        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
        return response;
    }
}
