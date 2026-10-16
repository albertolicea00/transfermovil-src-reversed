package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.wnGiwuD0kT;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.qztlzqkyWH;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class eLrApWcG9O {
    public Context context;
    public String HEAD_LOG = "eLrApWcG9O";
    private List<nzfmd7tb20> itemsList = new ArrayList();

    public eLrApWcG9O(Context context) {
        this.context = context;
    }

    public PYjuxvJ5mg getDevoluciones(String key) {
        PYjuxvJ5mg response = new PYjuxvJ5mg();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getDevRepo().getDevoluciones(key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getDevJSON(apiResponseBase.getJsonObject());
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

    public PYjuxvJ5mg getDevoluciones(String key, YbN03uYqWN filtro) {
        PYjuxvJ5mg response = new PYjuxvJ5mg();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getDevRepo().getDevoluciones(filtro, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getDevJSON(apiResponseBase.getJsonObject());
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

    public qztlzqkyWH devolverPago(String key, FhtwnBtOAx request) throws JSONException {
        qztlzqkyWH response = new qztlzqkyWH();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getDevRepo().devolverPago(request, key);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    String code = "500";
                    JSONObject json = apiResponseBase.getJsonObject();
                    if (json != null && !json.isNull("code")) {
                        try {
                            code = json.getString("code");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (code.contains("Ok")) {
                        if (!json.isNull("refund")) {
                            response.setRefund(json.getString("refund"));
                        }
                        response.setOK(true);
                        response.setHttpCode(200);
                        response.setMenssage("Ok");
                    } else {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.DEVOLVER_PAGO, code));
                    }
                    return response;
                }
                int code2 = apiResponseBase.getCodigoHTTP();
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(code2));
                response.setHttpCode(code2);
                if (!apiResponseBase.getMenssaje().isEmpty()) {
                    UhA7J2923N.getInstance().WriteLog(code2, this.HEAD_LOG, apiResponseBase.getMenssaje());
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:66:0x0172  */
    public PYjuxvJ5mg getDevJSON(JSONObject json) {
        String code;
        String code2;
        PYjuxvJ5mg response;
        String code3;
        PYjuxvJ5mg response2;
        nzfmd7tb20 item;
        PYjuxvJ5mg response3;
        String str = "currency";
        String str2 = "external_code";
        String str3 = "payment_code";
        String str4 = "banck";
        PYjuxvJ5mg response4 = new PYjuxvJ5mg();
        String str5 = "create_user";
        if (json == null) {
            response4.setOK(false);
            response4.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
            return response4;
        }
        if (json.isNull("code")) {
            response4.setOK(false);
            response4.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
            return response4;
        }
        try {
            String code4 = json.getString("code");
            code = code4;
        } catch (JSONException e) {
            e.printStackTrace();
            code = BuildConfig.FLAVOR;
        }
        if (code.contains("Ok")) {
            try {
                JSONObject dt = json.getJSONObject("dt");
                int recordsFiltered = dt.getInt("recordsFiltered");
                code2 = code;
                try {
                    int recordsTotal = dt.getInt("recordsTotal");
                    String str6 = "tm_reference_refund";
                    PYjuxvJ5mg response5 = response4;
                    try {
                        response5.setRecordFiltered(recordsFiltered);
                        response5.setRecordTotal(recordsTotal);
                        try {
                            if (recordsFiltered > 0) {
                                try {
                                    JSONArray jsonArray = dt.getJSONArray("rows");
                                    int i = 0;
                                    while (true) {
                                        int recordsFiltered2 = recordsFiltered;
                                        if (i < jsonArray.length()) {
                                            JSONObject object = jsonArray.getJSONObject(i);
                                            nzfmd7tb20 item2 = new nzfmd7tb20();
                                            if (object.isNull(str3)) {
                                                item = item2;
                                            } else {
                                                try {
                                                    String string = object.getString(str3);
                                                    item = item2;
                                                    item.setIdPago(string);
                                                } catch (Exception e2) {
                                                    ex = e2;
                                                    this = this;
                                                    response = response5;
                                                }
                                            }
                                            if (!object.isNull(str2)) {
                                                item.setExternalCode(object.getString(str2));
                                            }
                                            if (!object.isNull(str)) {
                                                item.setMoneda(object.getString(str));
                                            }
                                            if (object.isNull("amount")) {
                                                response3 = response5;
                                            } else {
                                                response3 = response5;
                                                try {
                                                    String result = String.format(Locale.US, "%.2f", Double.valueOf(object.getDouble("amount")));
                                                    item.setImporte(Float.parseFloat(result));
                                                } catch (Exception e3) {
                                                    ex = e3;
                                                    this = this;
                                                    response = response3;
                                                    response.setOK(false);
                                                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                                    code3 = code2;
                                                    return response;
                                                }
                                            }
                                            if (!object.isNull("created_at")) {
                                                item.setFecha(object.getString("created_at"));
                                            }
                                            if (!object.isNull("cellphone")) {
                                                item.setMovil(object.getString("cellphone"));
                                            }
                                            if (!object.isNull("source")) {
                                                item.setSource(object.getString("source"));
                                            }
                                            if (!object.isNull(str4)) {
                                                item.setBanco(object.getString(str4));
                                                switch (object.getInt(str4)) {
                                                    case 1:
                                                        item.setBBancoEnum(wnGiwuD0kT.BPA);
                                                        break;
                                                    case 2:
                                                        item.setBBancoEnum(wnGiwuD0kT.BANDEC);
                                                        break;
                                                    case 3:
                                                        item.setBBancoEnum(wnGiwuD0kT.METRO);
                                                        break;
                                                }
                                            }
                                            if (!object.isNull("result_msg")) {
                                                item.setResultMsg(object.getString("result_msg"));
                                            }
                                            if (!object.isNull("status")) {
                                                switch (object.getString("status")) {
                                                    case "pending":
                                                        item.setEstadoPago(SHYgXB9Dco.PENDIENTE);
                                                        break;
                                                    case "confirmed":
                                                        item.setEstadoPago(SHYgXB9Dco.PAGADO);
                                                        break;
                                                    case "aborted":
                                                        item.setEstadoPago(SHYgXB9Dco.FALLIDO);
                                                        break;
                                                    case "canceled":
                                                        item.setEstadoPago(SHYgXB9Dco.CANCELADO);
                                                        break;
                                                    case "refounded":
                                                        item.setEstadoPago(SHYgXB9Dco.DEVUELTO);
                                                        break;
                                                    case "refound_pending":
                                                        item.setEstadoPago(SHYgXB9Dco.DEVUELTO_PENDIENTE);
                                                        break;
                                                    default:
                                                        item.setEstadoPago(SHYgXB9Dco.NO_DEFINIDO);
                                                        break;
                                                }
                                            }
                                            if (!object.isNull("refund_code")) {
                                                item.setIdDevolucion(object.getString("refund_code"));
                                            }
                                            if (!object.isNull("reference_refund")) {
                                                item.setIdBankDevolcuin(object.getString("reference_refund"));
                                            }
                                            String str7 = str6;
                                            if (!object.isNull(str7)) {
                                                item.setIdTMDevolucion(object.getString(str7));
                                            }
                                            String str8 = str5;
                                            if (!object.isNull(str8)) {
                                                item.setUser(object.getString(str8));
                                            }
                                            String str9 = str4;
                                            this = this;
                                            try {
                                                this.itemsList.add(item);
                                                i++;
                                                str6 = str7;
                                                str5 = str8;
                                                str4 = str9;
                                                recordsFiltered = recordsFiltered2;
                                                jsonArray = jsonArray;
                                                str = str;
                                                str3 = str3;
                                                str2 = str2;
                                                response5 = response3;
                                            } catch (Exception e4) {
                                                ex = e4;
                                                response = response3;
                                                response.setOK(false);
                                                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                                code3 = code2;
                                                return response;
                                            }
                                        } else {
                                            response2 = response5;
                                        }
                                        response.setOK(false);
                                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                        code3 = code2;
                                    }
                                } catch (Exception e5) {
                                    ex = e5;
                                    this = this;
                                    response = response5;
                                }
                            } else {
                                response2 = response5;
                            }
                            response.setOK(true);
                            response.setItemsList(this.itemsList);
                        } catch (Exception e6) {
                            ex = e6;
                            response.setOK(false);
                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                        }
                        response = response2;
                    } catch (Exception e7) {
                        ex = e7;
                        this = this;
                        response = response5;
                    }
                } catch (Exception e8) {
                    ex = e8;
                    this = this;
                    response = response4;
                }
            } catch (Exception e9) {
                ex = e9;
                this = this;
                code2 = code;
                response = response4;
            }
            code3 = code2;
        } else {
            response = response4;
            response.setOK(false);
            code3 = code;
            response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_USERS_GET, code3));
        }
        return response;
    }
}
