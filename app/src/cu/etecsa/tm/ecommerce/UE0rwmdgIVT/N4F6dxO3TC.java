package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.ZxjGjcZ9UR;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class N4F6dxO3TC {
    public Context context;
    public String HEAD_LOG = "N4F6dxO3TC";
    private List<LWt69JQUoH> itemsList = new ArrayList();

    public N4F6dxO3TC(Context context) {
        this.context = context;
    }

    public kf1rAJ1MG4 createCuenta(ZxjGjcZ9UR request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().createCuenta(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    JSONObject json = apiResponseBase.getJsonObject();
                    if (json != null && !json.isNull("code")) {
                        try {
                            if (json.getString("code").contains("Ok")) {
                                response.setOK(true);
                                response.setMenssage("ok");
                                response.setHttpCode(200);
                                return response;
                            }
                        } catch (JSONException e) {
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, e.getMessage()));
                            response.setHttpCode(500);
                            return response;
                        }
                    }
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo el code"));
                    response.setHttpCode(500);
                } else {
                    int code = apiResponseBase.getCodigoHTTP();
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(code));
                    response.setHttpCode(code);
                    if (!apiResponseBase.getMenssaje().isEmpty()) {
                        UhA7J2923N.getInstance().WriteLog(code, this.HEAD_LOG, apiResponseBase.getMenssaje());
                    }
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
        } catch (Exception e2) {
            e2.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e2.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public kf1rAJ1MG4 updateCuenta(ZxjGjcZ9UR request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().updateCuenta(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    JSONObject json = apiResponseBase.getJsonObject();
                    if (json != null && !json.isNull("code")) {
                        try {
                            if (json.getString("code").contains("Ok")) {
                                response.setOK(true);
                                response.setMenssage("ok");
                                response.setHttpCode(200);
                                return response;
                            }
                        } catch (JSONException e) {
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, e.getMessage()));
                            response.setHttpCode(500);
                            return response;
                        }
                    }
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo el code"));
                    response.setHttpCode(500);
                } else {
                    int code = apiResponseBase.getCodigoHTTP();
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(code));
                    response.setHttpCode(code);
                    if (!apiResponseBase.getMenssaje().isEmpty()) {
                        UhA7J2923N.getInstance().WriteLog(code, this.HEAD_LOG, apiResponseBase.getMenssaje());
                    }
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
        } catch (Exception e2) {
            e2.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e2.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public kf1rAJ1MG4 deleteCuenta(ZxjGjcZ9UR request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().deleteCuenta(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    JSONObject json = apiResponseBase.getJsonObject();
                    if (json != null && !json.isNull("code")) {
                        try {
                            if (json.getString("code").contains("Ok")) {
                                response.setOK(true);
                                response.setMenssage("ok");
                                response.setHttpCode(200);
                                return response;
                            }
                        } catch (JSONException e) {
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, e.getMessage()));
                            response.setHttpCode(500);
                            return response;
                        }
                    }
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo el code"));
                    response.setHttpCode(500);
                } else {
                    int code = apiResponseBase.getCodigoHTTP();
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(code));
                    response.setHttpCode(code);
                    if (!apiResponseBase.getMenssaje().isEmpty()) {
                        UhA7J2923N.getInstance().WriteLog(code, this.HEAD_LOG, apiResponseBase.getMenssaje());
                    }
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
        } catch (Exception e2) {
            e2.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e2.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public kf1rAJ1MG4 estadoCuenta(boolean estadoCuenta, String source, String key) {
        zDPt4FP8OC apiResponseBase;
        ZxjGjcZ9UR request = new ZxjGjcZ9UR();
        request.setSource(source);
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            if (estadoCuenta) {
                apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().activarCuenta(request, key);
            } else {
                apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().desactivarCuenta(request, key);
            }
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    JSONObject json = apiResponseBase.getJsonObject();
                    if (json != null && !json.isNull("code")) {
                        try {
                            if (json.getString("code").contains("Ok")) {
                                response.setOK(true);
                                response.setMenssage("ok");
                                response.setHttpCode(200);
                                return response;
                            }
                        } catch (JSONException e) {
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, e.getMessage()));
                            response.setHttpCode(500);
                            return response;
                        }
                    }
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo el code"));
                    response.setHttpCode(500);
                } else {
                    int code = apiResponseBase.getCodigoHTTP();
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(code));
                    response.setHttpCode(code);
                    if (!apiResponseBase.getMenssaje().isEmpty()) {
                        UhA7J2923N.getInstance().WriteLog(code, this.HEAD_LOG, apiResponseBase.getMenssaje());
                    }
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
        } catch (Exception e2) {
            e2.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e2.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public sR8QMZUZBy getCuentas(String key) {
        sR8QMZUZBy response = new sR8QMZUZBy();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().getCuentas(key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getCuentasJSON(apiResponseBase.getJsonObject());
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

    public sR8QMZUZBy getCuentasJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        sR8QMZUZBy response = new sR8QMZUZBy();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONArray jsonArray = json.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            LWt69JQUoH item = new LWt69JQUoH();
                            if (!object.isNull("id")) {
                                item.setId(Integer.valueOf(object.getString("id")).intValue());
                            }
                            if (!object.isNull("source")) {
                                item.setSource(object.getString("source"));
                            }
                            if (!object.isNull("currency")) {
                                item.setCurrency(object.getString("currency"));
                            }
                            if (!object.isNull("user_id")) {
                                item.setUser_id(object.getString("user_id"));
                            }
                            if (!object.isNull("name")) {
                                item.setName(object.getString("name"));
                            }
                            this.itemsList.add(item);
                        }
                        response.setOK(true);
                        response.setItemsList(this.itemsList);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_CUENTAS_GET, code));
                }
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
            }
        } else {
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        }
        return response;
    }
}
