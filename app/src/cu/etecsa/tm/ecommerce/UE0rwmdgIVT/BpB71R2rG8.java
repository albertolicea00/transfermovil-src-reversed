package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.JpFlOZXEDx;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.cyVKjSmMxV;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.L8gvrPUGKT;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BpB71R2rG8 {
    public Context context;
    public String HEAD_LOG = "BpB71R2rG8";
    private List<JpFlOZXEDx> itemsList = new ArrayList();

    public BpB71R2rG8(Context context) {
        this.context = context;
    }

    public L8gvrPUGKT getUsers(String key) {
        L8gvrPUGKT response = new L8gvrPUGKT();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().getUsers(key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getUsers(apiResponseBase.getJsonObject());
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

    public ME8KWex9OS getUserChild(int id, String key) {
        ME8KWex9OS response = new ME8KWex9OS();
        try {
            PxQtH5HO6p request = new PxQtH5HO6p();
            request.setId(id);
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().getUserChild(request, key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getUserChild(apiResponseBase.getJsonObject());
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

    public ToUwD5xX9T getPermisoChildTodos(int id, String key) {
        ImIDy2TQHP perfilCU = new ImIDy2TQHP(this.context);
        ToUwD5xX9T response = new ToUwD5xX9T();
        try {
            ToUwD5xX9T permisosTotal = perfilCU.getPermisosOtorgar(key);
            if (permisosTotal != null) {
                ToUwD5xX9T permisosChildResponse = getPermisoChild(id, key);
                if (permisosChildResponse.isOK()) {
                    if (permisosChildResponse.getListPermisos() != null && permisosChildResponse.getListPermisos().size() > 0) {
                        for (cyVKjSmMxV item : permisosChildResponse.getListPermisos()) {
                            for (int i = 0; i < permisosTotal.getListPermisos().size(); i++) {
                                if (permisosTotal.getListPermisos().get(i).getCodigo() == item.getCodigo()) {
                                    permisosTotal.getListPermisos().get(i).setEstado(true);
                                }
                            }
                        }
                        return permisosTotal;
                    }
                    return permisosTotal;
                }
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo los permisos"));
                response.setHttpCode(500);
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Error obteniendo los permisos"));
                response.setHttpCode(500);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "Exception:" + e.getMessage()));
            response.setOK(false);
            return response;
        }
    }

    public ToUwD5xX9T getPermisoChild(int id, String key) {
        ToUwD5xX9T response = new ToUwD5xX9T();
        try {
            PxQtH5HO6p request = new PxQtH5HO6p();
            request.setId(id);
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().getPermisos(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getPermisos(apiResponseBase.getJsonObject());
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

    public kf1rAJ1MG4 userChildCREATE(qwlqFYH8aO request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().createUser(request, key);
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

    public kf1rAJ1MG4 userChildUPDATE(qwlqFYH8aO request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().updateUser(request, key);
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

    public kf1rAJ1MG4 userChildDELETE(int id, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        PxQtH5HO6p request = new PxQtH5HO6p();
        request.setId(id);
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().deleteUser(request, key);
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

    public kf1rAJ1MG4 userChildEstado(PxQtH5HO6p request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().activarUsuario(request, key);
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

    public L8gvrPUGKT getUsers(JSONObject json) throws JSONException {
        JpFlOZXEDx item;
        String code = BuildConfig.FLAVOR;
        L8gvrPUGKT responseUsers = new L8gvrPUGKT();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject dt = json.getJSONObject("dt");
                        int recordsFiltered = dt.getInt("recordsFiltered");
                        if (recordsFiltered > 0) {
                            JSONArray jsonArray = dt.getJSONArray("rows");
                            int i = 0;
                            while (i < jsonArray.length()) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                JpFlOZXEDx item2 = new JpFlOZXEDx();
                                if (object.isNull("id")) {
                                    item = item2;
                                } else {
                                    item = item2;
                                    item.setIdUser(object.getInt("id"));
                                }
                                if (!object.isNull("username")) {
                                    item.setNombre(object.getString("username"));
                                }
                                if (!object.isNull("email")) {
                                    item.setCorreo(object.getString("email"));
                                }
                                if (!object.isNull("created_at")) {
                                    item.setCreado(object.getString("created_at"));
                                }
                                if (!object.isNull("updated_at")) {
                                    item.setUpdateAt(object.getString("updated_at"));
                                }
                                if (!object.isNull("banned")) {
                                    int banneado = object.getInt("banned");
                                    if (banneado == 0) {
                                        item.setActivo(true);
                                    } else {
                                        item.setActivo(false);
                                    }
                                }
                                item.setAvatar(UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + object.getString("id"));
                                this.itemsList.add(item);
                                i++;
                                dt = dt;
                            }
                        }
                        responseUsers.setOK(true);
                        responseUsers.setItemsList(this.itemsList);
                    } catch (Exception ex) {
                        responseUsers.setOK(false);
                        responseUsers.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    responseUsers.setOK(false);
                    responseUsers.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_USERS_GET, code));
                }
            } else {
                responseUsers.setOK(false);
                responseUsers.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
            }
        } else {
            responseUsers.setOK(false);
            responseUsers.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        }
        return responseUsers;
    }

    public ME8KWex9OS getUserChild(JSONObject json) throws JSONException {
        ME8KWex9OS.YjMcWATWMD item;
        njwILmSkGJ provincia;
        String code = BuildConfig.FLAVOR;
        ME8KWex9OS response = new ME8KWex9OS();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject user = json.getJSONObject("user");
                        ME8KWex9OS.YjMcWATWMD item2 = new ME8KWex9OS.YjMcWATWMD();
                        if (user.isNull("id")) {
                            item = item2;
                        } else {
                            item = item2;
                            item.setId(user.getInt("id"));
                        }
                        if (!user.isNull("username")) {
                            item.setUsername(user.getString("username"));
                        }
                        if (!user.isNull("email")) {
                            item.setEmail(user.getString("email"));
                        }
                        if (!user.isNull("dni")) {
                            item.setDni(user.getString("dni"));
                        }
                        if (!user.isNull("phone")) {
                            item.setPhone(user.getString("phone"));
                        }
                        if (!user.isNull("address")) {
                            item.setAddress(user.getString("address"));
                        }
                        if (!user.isNull("updated_at")) {
                            item.setUpdateAt(user.getString("updated_at"));
                        }
                        KQ1TrOYV2S.getInstance().getRegionRepo().loadData(this.context);
                        if (!user.isNull("province") && (provincia = KQ1TrOYV2S.getInstance().getRegionRepo().getProvincia(user.getString("province"), this.context)) != null) {
                            item.setProvince(provincia);
                        }
                        if (!user.isNull("municipality") && user.getString("municipality").length() == 4) {
                            I7Szcu2IgpM municipio = KQ1TrOYV2S.getInstance().getRegionRepo().getMunicipio(user.getString("municipality"), this.context);
                            String smunicipio = user.getString("municipality").substring(2, 4);
                            Log.i("a", smunicipio);
                            if (municipio != null) {
                                item.setMunicipality(municipio);
                            }
                        }
                        if (!user.isNull("photo")) {
                            item.setPhoto(UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + user.getString("id"));
                        }
                        response.setUser(item);
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
        } else {
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        }
        return response;
    }

    public ToUwD5xX9T getPermisos(JSONObject json) throws JSONException {
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
                                String value = jsonArray.get(i).toString();
                                cyVKjSmMxV item = new cyVKjSmMxV();
                                item.setCodigo(Integer.valueOf(value).intValue());
                                permisoList.add(item);
                            }
                            permisosResponse.setListPermisos(permisoList);
                            permisosResponse.setOK(true);
                        } else {
                            permisosResponse.setOK(true);
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

    public kf1rAJ1MG4 permisosUpdate(u5mpEjsROy request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getUsersRepoAPI().updatePermisos(request, key);
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
}
