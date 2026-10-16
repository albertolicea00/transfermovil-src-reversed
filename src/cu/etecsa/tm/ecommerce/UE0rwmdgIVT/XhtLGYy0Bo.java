package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.v7emp5gRyD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.hJ45hA3s7Q;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.xc7SYjTCzp;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class XhtLGYy0Bo {
    public Context context;
    public String HEAD_LOG = "XhtLGYy0Bo";
    private List<v7emp5gRyD> itemNegocios = new ArrayList();
    private List<HD5RIUn7tB> itemCuentaNegocios = new ArrayList();

    public XhtLGYy0Bo(Context context) {
        this.context = context;
    }

    public xc7SYjTCzp getNegociosCuentas(String key) {
        xc7SYjTCzp response = new xc7SYjTCzp();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getCuentasRepo().getCuentasNegocio(key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getNegociosCuentasJSON(apiResponseBase.getJsonObject());
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

    public kf1rAJ1MG4 createNegocio(hJ45hA3s7Q request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getNegociosRepo().createNegocio(request, key);
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

    public kf1rAJ1MG4 updateNegocio(hJ45hA3s7Q request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getNegociosRepo().updateNegocio(request, key);
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

    public kf1rAJ1MG4 deleteNegocio(hJ45hA3s7Q request, String key) {
        kf1rAJ1MG4 response = new kf1rAJ1MG4();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getNegociosRepo().deleteNegocio(request, key);
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

    public xc7SYjTCzp getNegociosJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        xc7SYjTCzp response = new xc7SYjTCzp();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONArray jsonArray = json.getJSONArray("business");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            v7emp5gRyD item = new v7emp5gRyD();
                            if (!object.isNull("id")) {
                                item.setId(object.getString("id"));
                            }
                            if (!object.isNull("description")) {
                                item.setTitulo(object.getString("description"));
                            }
                            this.itemNegocios.add(item);
                        }
                        response.setOK(true);
                        response.setItemsList(this.itemNegocios);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_NEGOCIOS_GET, code));
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

    public xc7SYjTCzp getNegociosCuentasJSON(JSONObject json) throws JSONException {
        JSONObject jsonNodes;
        HD5RIUn7tB item;
        String str;
        List<HD5RIUn7tB> cuentaNegocios;
        String descripcion = "active";
        String code = BuildConfig.FLAVOR;
        xc7SYjTCzp response = new xc7SYjTCzp();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        if (json.has("total_business") && json.getInt("total_business") > 0) {
                            JSONObject jsonNodes2 = json.getJSONObject("business");
                            Iterator<String> itKeys = jsonNodes2.keys();
                            while (itKeys.hasNext()) {
                                v7emp5gRyD itemNegocio = new v7emp5gRyD();
                                List<HD5RIUn7tB> cuentaNegocios2 = new ArrayList<>();
                                String key = itKeys.next();
                                JSONArray itemArray = jsonNodes2.getJSONArray(key);
                                String descripcion2 = "negocio";
                                int i = 0;
                                while (true) {
                                    jsonNodes = jsonNodes2;
                                    if (i < itemArray.length()) {
                                        JSONArray itemArray2 = itemArray;
                                        JSONObject object = itemArray2.getJSONObject(i);
                                        HD5RIUn7tB item2 = new HD5RIUn7tB();
                                        itemArray = itemArray2;
                                        if (object.isNull("descriptionbusiness")) {
                                            item = item2;
                                        } else {
                                            descripcion2 = object.getString("descriptionbusiness");
                                            item = item2;
                                            item.setTituloNegocio(object.getString("descriptionbusiness"));
                                        }
                                        if (object.isNull("source")) {
                                            str = descripcion;
                                            cuentaNegocios = cuentaNegocios2;
                                        } else {
                                            if (!object.isNull("source_id")) {
                                                item.setId(object.getInt("source_id"));
                                            }
                                            if (!object.isNull("descriptionsource")) {
                                                item.setDescripcion(object.getString("descriptionsource"));
                                            }
                                            if (object.isNull(descripcion)) {
                                                str = descripcion;
                                            } else {
                                                str = descripcion;
                                                if (object.getInt(descripcion) == 1) {
                                                    item.setActivo(true);
                                                } else {
                                                    item.setActivo(false);
                                                }
                                            }
                                            if (!object.isNull("currency")) {
                                                item.setMoneda(object.getString("currency"));
                                            }
                                            if (!object.isNull("source")) {
                                                item.setSource(object.getString("source"));
                                            }
                                            if (!object.isNull("id")) {
                                                item.setIdNegocio(object.getInt("id"));
                                            }
                                            if (!object.isNull("descriptionbusiness")) {
                                                descripcion2 = object.getString("descriptionbusiness");
                                            }
                                            if (!object.isNull("created_at")) {
                                                item.setFechaCreacion(object.getString("created_at"));
                                            }
                                            cuentaNegocios = cuentaNegocios2;
                                            cuentaNegocios.add(item);
                                        }
                                        i++;
                                        cuentaNegocios2 = cuentaNegocios;
                                        jsonNodes2 = jsonNodes;
                                        itKeys = itKeys;
                                        descripcion = str;
                                    }
                                }
                                itemNegocio.setId(key);
                                itemNegocio.setCuentasList(cuentaNegocios2);
                                itemNegocio.setTitulo(descripcion2);
                                this.itemNegocios.add(itemNegocio);
                                jsonNodes2 = jsonNodes;
                                itKeys = itKeys;
                                descripcion = descripcion;
                            }
                            response.setOK(true);
                            response.setItemsList(this.itemNegocios);
                        } else {
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_NEGOCIOS_GET, "1"));
                        }
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_NEGOCIOS_GET, code));
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
