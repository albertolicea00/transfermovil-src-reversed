package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.dyNtEg2NFV;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.q5eErW0HcCa;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.cT6z0jcLEG;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OSQajAAbpl;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.luC26d6Wdp;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class yl2MWOolvQ {
    public String HEAD_LOG = "yl2MWOolvQ";
    public Context context;

    public yl2MWOolvQ(Context context) {
        this.context = context;
    }

    public OSQajAAbpl getPagos(String key, cT6z0jcLEG request) {
        OSQajAAbpl response = new OSQajAAbpl();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getEstadisticaRepo().getMontoPagos(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getPagosJSON(apiResponseBase.getJsonObject());
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

    public OSQajAAbpl getCantidadPagos(String key, cT6z0jcLEG request) {
        OSQajAAbpl response = new OSQajAAbpl();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getEstadisticaRepo().pagoEstadistica(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getCantidadPagosJSON(apiResponseBase.getJsonObject());
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

    public OSQajAAbpl getCantidadDevoluciones(String key, cT6z0jcLEG request) {
        OSQajAAbpl response = new OSQajAAbpl();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getEstadisticaRepo().devolucionEstadistica(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getCantidadDevolucionesJSON(apiResponseBase.getJsonObject());
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

    public OSQajAAbpl getPagosJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        OSQajAAbpl response = new OSQajAAbpl();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject jsonStats = json.getJSONObject("stats");
                        if (!jsonStats.isNull("day")) {
                            response.setStatsDay(Float.valueOf(jsonStats.getString("day")).floatValue());
                        }
                        if (!jsonStats.isNull("week")) {
                            response.setStatsWeek(Float.valueOf(jsonStats.getString("week")).floatValue());
                        }
                        if (!jsonStats.isNull("month")) {
                            response.setStatsMonth(Float.valueOf(jsonStats.getString("month")).floatValue());
                        }
                        if (!jsonStats.isNull("year")) {
                            response.setStatsYear(Float.valueOf(jsonStats.getString("year")).floatValue());
                        }
                        response.setOK(true);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.ESTADISTICAS, code));
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

    public OSQajAAbpl getCantidadPagosJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        OSQajAAbpl response = new OSQajAAbpl();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject jsonYear = json.getJSONObject("year");
                        if (!jsonYear.isNull("confirmed")) {
                            response.setYearConfirm(Integer.valueOf(jsonYear.getString("confirmed")).intValue());
                        }
                        if (!jsonYear.isNull("aborted")) {
                            response.setYearAbort(Integer.valueOf(jsonYear.getString("aborted")).intValue());
                        }
                        if (!jsonYear.isNull("pending")) {
                            response.setYearPend(Integer.valueOf(jsonYear.getString("pending")).intValue());
                        }
                        JSONObject jsonDiarias = json.getJSONObject("Diarias");
                        if (!jsonDiarias.isNull("confirmed")) {
                            response.setDayConfirm(Integer.valueOf(jsonDiarias.getString("confirmed")).intValue());
                        }
                        if (!jsonDiarias.isNull("aborted")) {
                            response.setDayAbort(Integer.valueOf(jsonDiarias.getString("aborted")).intValue());
                        }
                        if (!jsonDiarias.isNull("pending")) {
                            response.setDayPend(Integer.valueOf(jsonDiarias.getString("pending")).intValue());
                        }
                        JSONObject jsonMes = json.getJSONObject("mes");
                        if (!jsonMes.isNull("confirmed")) {
                            response.setMesConfirm(Integer.valueOf(jsonMes.getString("confirmed")).intValue());
                        }
                        if (!jsonMes.isNull("aborted")) {
                            response.setMesAbort(Integer.valueOf(jsonMes.getString("aborted")).intValue());
                        }
                        if (!jsonMes.isNull("pending")) {
                            response.setMesPend(Integer.valueOf(jsonMes.getString("pending")).intValue());
                        }
                        response.setOK(true);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.ESTADISTICAS, code));
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

    public OSQajAAbpl getCantidadDevolucionesJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        OSQajAAbpl response = new OSQajAAbpl();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        JSONObject jsonMes = json.getJSONObject("mesDevolucion");
                        if (!jsonMes.isNull("refounded")) {
                            response.setDevMesConfirm(Integer.valueOf(jsonMes.getString("refounded")).intValue());
                        }
                        if (!jsonMes.isNull("aborted")) {
                            response.setDevMesAbort(Integer.valueOf(jsonMes.getString("aborted")).intValue());
                        }
                        if (!jsonMes.isNull("refound_pending")) {
                            response.setDevMesPend(Integer.valueOf(jsonMes.getString("refound_pending")).intValue());
                        }
                        JSONObject jsonDiarias = json.getJSONObject("DiariasDevolucion");
                        if (!jsonDiarias.isNull("refounded")) {
                            response.setDevDayConfim(Integer.valueOf(jsonDiarias.getString("refounded")).intValue());
                        }
                        if (!jsonDiarias.isNull("aborted")) {
                            response.setDevDayAbort(Integer.valueOf(jsonDiarias.getString("aborted")).intValue());
                        }
                        if (!jsonDiarias.isNull("refound_pending")) {
                            response.setDevDayPend(Integer.valueOf(jsonDiarias.getString("refound_pending")).intValue());
                        }
                        JSONObject jsonYear = json.getJSONObject("yearDevolucion");
                        if (!jsonYear.isNull("refounded")) {
                            response.setDevYearConfirm(Integer.valueOf(jsonYear.getString("refounded")).intValue());
                        }
                        if (!jsonYear.isNull("aborted")) {
                            response.setDevYearAbort(Integer.valueOf(jsonYear.getString("aborted")).intValue());
                        }
                        if (!jsonYear.isNull("refound_pending")) {
                            response.setDevYearPend(Integer.valueOf(jsonYear.getString("refound_pending")).intValue());
                        }
                        response.setOK(true);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.ESTADISTICAS, code));
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

    public luC26d6Wdp getCuadre(String key, tVwkzUCBeV request) {
        luC26d6Wdp response = new luC26d6Wdp();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getEstadisticaRepo().estadisticaCuadre(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getCuadreJSON(apiResponseBase.getJsonObject());
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

    public luC26d6Wdp getCuadreJSON(JSONObject json) throws JSONException {
        dyNtEg2NFV item;
        JSONObject jSONObject = json;
        String str = "count";
        String monedaUnica = "create_user";
        String str2 = "currency";
        String code = BuildConfig.FLAVOR;
        luC26d6Wdp response = new luC26d6Wdp();
        List<q5eErW0HcCa> listParents = new ArrayList<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = json.keys();
                while (itKeys.hasNext()) {
                    q5eErW0HcCa itemNegocio = new q5eErW0HcCa();
                    List<dyNtEg2NFV> estadisticaChildCuadres = new ArrayList<>();
                    String key = itKeys.next();
                    JSONArray itemArray = jSONObject.getJSONArray(key);
                    int cantidadUsuarios = 0;
                    int cantidadVentasTotales = 0;
                    float importeVentaTotal = 0.0f;
                    String monedaUnica2 = "CUP";
                    int i = 0;
                    while (i < itemArray.length()) {
                        cantidadUsuarios = i + 1;
                        JSONObject object = itemArray.getJSONObject(i);
                        dyNtEg2NFV item2 = new dyNtEg2NFV();
                        if (object.isNull(monedaUnica)) {
                            item = item2;
                        } else {
                            try {
                                String string = object.getString(monedaUnica);
                                item = item2;
                                item.setUser(string);
                            } catch (Exception e) {
                                ex = e;
                                response.setOK(false);
                                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                return response;
                            }
                        }
                        if (!object.isNull(str)) {
                            int cantidadItem = object.getInt(str);
                            cantidadVentasTotales += cantidadItem;
                            item.setCantidad(String.valueOf(cantidadItem));
                        }
                        if (!object.isNull(str2)) {
                            item.setMoneda(object.getString(str2));
                            monedaUnica2 = object.getString(str2);
                        }
                        if (!object.isNull("amount")) {
                            try {
                                String result = String.format(Locale.US, "%.2f", Double.valueOf(object.getDouble("amount")));
                                Float resultado = Float.valueOf(Float.parseFloat(result));
                                float importeVentaTotal2 = resultado.floatValue() + importeVentaTotal;
                                item.setImporte(String.valueOf(resultado));
                                importeVentaTotal = importeVentaTotal2;
                            } catch (Exception e2) {
                                ex = e2;
                                response.setOK(false);
                                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                return response;
                            }
                        }
                        estadisticaChildCuadres.add(item);
                        i++;
                        monedaUnica = monedaUnica;
                        str = str;
                        str2 = str2;
                        code = code;
                    }
                    itemNegocio.setVentas(estadisticaChildCuadres);
                    itemNegocio.setCuenta(key);
                    itemNegocio.setCantidadTotal(String.valueOf(cantidadVentasTotales));
                    DecimalFormat df = new DecimalFormat("0.00");
                    itemNegocio.setImporteTotal(String.valueOf(df.format(importeVentaTotal)) + " " + monedaUnica2);
                    itemNegocio.setCantidadUsuarios(String.valueOf(cantidadUsuarios));
                    listParents.add(itemNegocio);
                    jSONObject = json;
                    monedaUnica = monedaUnica;
                    str = str;
                    str2 = str2;
                    code = code;
                }
                response.setOK(true);
                response.setListNegocios(listParents);
            } catch (Exception e3) {
                ex = e3;
            }
        } else {
            response.setOK(false);
            response.setHttpCode(200);
            response.setMenssage("No hay elementos a mostrar.");
        }
        return response;
    }
}
