package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.cyVKjSmMxV;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.UOcddKaEob;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.K1a8LCEmAD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.L9hiDpmAir;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.XMAvvl35Dj;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OUl0pYQl8g;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.gC3MfWqxUy;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ImIDy2TQHP {
    public String HEAD_LOG = "BULEVAR_PerfilCU";
    public Context context;

    public ImIDy2TQHP(Context context) {
        this.context = context;
    }

    public gC3MfWqxUy login(String user, String pass, String factor) throws JSONException {
        gC3MfWqxUy response = new gC3MfWqxUy();
        if (factor.length() == 0) {
            XMAvvl35Dj loginRequest = new XMAvvl35Dj();
            loginRequest.setEmail(user);
            loginRequest.setPassword(pass);
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getProfileRepo().login(loginRequest, BuildConfig.FLAVOR);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getLoginJSON(apiResponseBase.getJsonObject());
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
        } else {
            L9hiDpmAir loginFactorRequest = new L9hiDpmAir();
            loginFactorRequest.setEmail(user);
            loginFactorRequest.setPassword(pass);
            loginFactorRequest.setFactor(Integer.valueOf(factor).intValue());
            zDPt4FP8OC apiResponseBase2 = KQ1TrOYV2S.getInstance().getProfileRepo().loginFactor(loginFactorRequest, BuildConfig.FLAVOR);
            if (apiResponseBase2 != null) {
                if (apiResponseBase2.getCodigoHTTP() == 200) {
                    gC3MfWqxUy result = getLoginFactorJSON(apiResponseBase2.getJsonObject());
                    if (result.isOK()) {
                        UhA7J2923N.getInstance().setAccess_token(result.getToken());
                        UhA7J2923N.getInstance().setUserid(String.valueOf(result.getIdUser()));
                        UhA7J2923N.getInstance().setUsername(result.getUserName());
                        String permisos = BuildConfig.FLAVOR;
                        if (result.getItemPermisos() != null) {
                            for (cyVKjSmMxV item : result.getItemPermisos()) {
                                permisos = permisos + item.getCodigo() + "|";
                            }
                            UhA7J2923N.getInstance().setGrants(permisos.substring(0, permisos.length() - 1));
                        }
                    }
                    return result;
                }
                int code2 = apiResponseBase2.getCodigoHTTP();
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(code2));
                response.setHttpCode(code2);
                if (!apiResponseBase2.getMenssaje().isEmpty()) {
                    UhA7J2923N.getInstance().WriteLog(code2, this.HEAD_LOG, apiResponseBase2.getMenssaje());
                }
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500));
                response.setHttpCode(500);
                if (!apiResponseBase2.getMenssaje().isEmpty()) {
                    UhA7J2923N.getInstance().WriteLog(500, this.HEAD_LOG, "zDPt4FP8OC is NUll: " + apiResponseBase2.getMenssaje());
                }
            }
        }
        return response;
    }

    public gC3MfWqxUy getLoginJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        gC3MfWqxUy response = new gC3MfWqxUy();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    response.setOK(true);
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LOGIN_SIMPLE, code));
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x00b5  */
    public gC3MfWqxUy getLoginFactorJSON(JSONObject json) throws JSONException {
        UOcddKaEob rol;
        String code = BuildConfig.FLAVOR;
        gC3MfWqxUy response = new gC3MfWqxUy();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject dt = json.getJSONObject("row");
                        List<cyVKjSmMxV> permisosList = new ArrayList<>();
                        JSONArray jsonArray = dt.getJSONArray("grants");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            String value = jsonArray.get(i).toString();
                            cyVKjSmMxV item = new cyVKjSmMxV();
                            item.setCodigo(Integer.valueOf(value).intValue());
                            permisosList.add(item);
                        }
                        if (!dt.isNull("userid")) {
                            response.setIdUser(dt.getInt("userid"));
                        }
                        if (!dt.isNull("username")) {
                            response.setUserName(dt.getString("username"));
                        }
                        if (!dt.isNull("token")) {
                            response.setToken(dt.getString("token"));
                        }
                        JSONArray jsonArrayRol = dt.getJSONArray("rol");
                        int i2 = 0;
                        while (true) {
                            if (i2 < jsonArrayRol.length()) {
                                String value2 = jsonArrayRol.get(i2).toString();
                                if (value2 != null && value2.length() > 0) {
                                    switch (value2) {
                                        case "21":
                                            rol = UOcddKaEob.PROPIETARIO;
                                            break;
                                        case "22":
                                            rol = UOcddKaEob.VENDEDOR;
                                            break;
                                        case "1":
                                            rol = UOcddKaEob.ADMIN;
                                            break;
                                        default:
                                            rol = UOcddKaEob.OTROS;
                                            break;
                                    }
                                    UhA7J2923N.getInstance().setUserRol(rol.name());
                                }
                                i2++;
                            } else {
                                response.setItemPermisos(permisosList);
                                response.setOK(true);
                                response.setMenssage("OK");
                            }
                        }
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LOGIN_SIMPLE, code));
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

    public ToUwD5xX9T getPermisosOtorgar(String key) {
        ToUwD5xX9T response = new ToUwD5xX9T();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getProfileRepo().listarPermisosDar(key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getPermisosOtorgar(apiResponseBase.getJsonObject());
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

    private ToUwD5xX9T getPermisosOtorgar(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        ToUwD5xX9T permisosResponse = new ToUwD5xX9T();
        List<cyVKjSmMxV> permisoList = new ArrayList<>();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONArray jsonArray = json.getJSONArray("grants");
                        if (jsonArray != null && jsonArray.length() > 0) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                cyVKjSmMxV item = new cyVKjSmMxV();
                                JSONObject object = jsonArray.getJSONObject(i);
                                if (!object.isNull("id")) {
                                    item.setCodigo(Integer.valueOf(object.getString("id")).intValue());
                                }
                                if (!object.isNull("grant")) {
                                    item.setDescripcion(object.getString("grant"));
                                }
                                permisoList.add(item);
                            }
                            permisosResponse.setListPermisos(permisoList);
                            permisosResponse.setOK(true);
                        } else {
                            permisosResponse.setOK(false);
                            permisosResponse.setMenssage("No hay elementos a mostrar");
                        }
                    } catch (Exception ex) {
                        permisosResponse.setOK(false);
                        permisosResponse.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    permisosResponse.setOK(false);
                    permisosResponse.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.GET_PERMISOS, code));
                }
            } else {
                permisosResponse.setOK(false);
                permisosResponse.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
            }
        } else {
            permisosResponse.setOK(false);
            permisosResponse.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        }
        return permisosResponse;
    }

    public OUl0pYQl8g getProfile(String key) {
        OUl0pYQl8g response = new OUl0pYQl8g();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getProfileRepo().getProfile(key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getUserProfile(apiResponseBase.getJsonObject());
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

    public kf1rAJ1MG4 updateProfile(w4DRczPYeb request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getProfileRepo().updateProfile(request, key);
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

    public kf1rAJ1MG4 changePassword(K1a8LCEmAD request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getProfileRepo().cambioPassword(request, key);
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

    public OUl0pYQl8g getUserProfile(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        OUl0pYQl8g response = new OUl0pYQl8g();
        if (json == null) {
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        } else if (!json.isNull("code")) {
            try {
                code = json.getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (code.contains("Ok")) {
                try {
                    JSONObject user = json.getJSONObject("user");
                    if (!user.isNull("id")) {
                        response.setId(user.getInt("id"));
                    }
                    if (!user.isNull("username")) {
                        response.setUsername(user.getString("username"));
                    }
                    if (!user.isNull("email")) {
                        response.setEmail(user.getString("email"));
                    }
                    if (!user.isNull("dni")) {
                        response.setDni(user.getString("dni"));
                    }
                    if (!user.isNull("phone")) {
                        response.setPhone(user.getString("phone"));
                    }
                    if (!user.isNull("address")) {
                        response.setAddress(user.getString("address"));
                    }
                    if (!user.isNull("updated_at")) {
                        response.setUpdateAt(user.getString("updated_at"));
                    }
                    KQ1TrOYV2S.getInstance().getRegionRepo().loadData(this.context);
                    if (!user.isNull("province")) {
                        njwILmSkGJ provincia = KQ1TrOYV2S.getInstance().getRegionRepo().getProvincia(user.getString("province"), this.context);
                        if (provincia != null) {
                            response.setProvince(provincia);
                        }
                        if (!user.isNull("municipality")) {
                            if (user.getString("municipality").length() == 4) {
                                I7Szcu2IgpM municipio = KQ1TrOYV2S.getInstance().getRegionRepo().getMunicipio(user.getString("municipality"), this.context);
                                String smunicipio = user.getString("municipality").substring(2, 4);
                                Log.i("a", smunicipio);
                                if (municipio != null) {
                                    response.setMunicipality(municipio);
                                }
                            } else {
                                String municipioCode = user.getString("province") + user.getString("municipality");
                                I7Szcu2IgpM municipio2 = KQ1TrOYV2S.getInstance().getRegionRepo().getMunicipio(municipioCode, this.context);
                                if (municipio2 != null) {
                                    response.setMunicipality(municipio2);
                                }
                            }
                        }
                    }
                    if (!user.isNull("photo")) {
                        response.setPhoto(UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + user.getString("id"));
                    }
                    response.setOK(true);
                } catch (Exception ex) {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                }
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_USERS_GET, code));
            }
        } else {
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
        }
        return response;
    }
}
