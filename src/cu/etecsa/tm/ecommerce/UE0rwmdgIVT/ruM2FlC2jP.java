package cu.etecsa.tm.ecommerce.UE0rwmdgIVT;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.jxtoYnTPbp;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.n8AvCp2wNR;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.scwi3AAgLR;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.wnGiwuD0kT;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.MlJJtXnfZh;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ALtYP1fGkI;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.j670rPXODo;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ruM2FlC2jP {
    public Context context;
    public String HEAD_LOG = "ruM2FlC2jP";
    private List<s5BkGOZ35ku> itemsList = new ArrayList();

    public ruM2FlC2jP(Context context) {
        this.context = context;
    }

    public j670rPXODo getPagos(String key, zKgYf9THHQ filtro) {
        this.HEAD_LOG += " j670rPXODo getPagos:";
        j670rPXODo response = new j670rPXODo();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getPagosRepo().getPagos(filtro, key, this.context);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:68:0x0192  */
    public j670rPXODo getPagosJSON(JSONObject json) {
        j670rPXODo response;
        String code;
        String code2;
        String code3;
        s5BkGOZ35ku item;
        String str = "currency";
        String str2 = "payment_code";
        String str3 = "external_code";
        StringBuilder sb = new StringBuilder();
        String str4 = "banck_code";
        sb.append(this.HEAD_LOG);
        sb.append(" j670rPXODo getPagosJSON:");
        this.HEAD_LOG = sb.toString();
        j670rPXODo response2 = new j670rPXODo();
        if (json != null) {
            if (!json.isNull("code")) {
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
                            response = response2;
                            try {
                                response.setRecordFiltered(recordsFiltered);
                                response.setRecordTotal(recordsTotal);
                                response2 = response;
                                if (recordsFiltered > 0) {
                                    try {
                                        JSONArray jsonArray = dt.getJSONArray("rows");
                                        int i = 0;
                                        while (true) {
                                            int recordsFiltered2 = recordsFiltered;
                                            if (i < jsonArray.length()) {
                                                JSONObject object = jsonArray.getJSONObject(i);
                                                s5BkGOZ35ku item2 = new s5BkGOZ35ku();
                                                if (object.isNull(str2)) {
                                                    item = item2;
                                                } else {
                                                    try {
                                                        item = item2;
                                                        item.setIdPago(object.getString(str2));
                                                    } catch (Exception e2) {
                                                        ex = e2;
                                                        this = this;
                                                        response = response2;
                                                    }
                                                }
                                                if (!object.isNull(str)) {
                                                    item.setMoneda(object.getString(str));
                                                }
                                                if (!object.isNull("amount")) {
                                                    String result = String.format(Locale.US, "%.2f", Double.valueOf(object.getDouble("amount")));
                                                    item.setImporte(Float.parseFloat(result));
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
                                                if (!object.isNull("banck")) {
                                                    item.setBank(object.getString("banck"));
                                                    switch (object.getInt("banck")) {
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
                                                if (!object.isNull("create_user")) {
                                                    item.setUser(object.getString("create_user"));
                                                }
                                                if (!object.isNull("description")) {
                                                    item.setDescription(object.getString("description"));
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
                                                        default:
                                                            item.setEstadoPago(SHYgXB9Dco.NO_DEFINIDO);
                                                            break;
                                                    }
                                                }
                                                if (!object.isNull("tm_code")) {
                                                    item.setTmCode(object.getString("tm_code"));
                                                }
                                                String str5 = str4;
                                                if (!object.isNull(str5)) {
                                                    item.setBankCode(object.getString(str5));
                                                }
                                                String str6 = str3;
                                                if (!object.isNull(str6)) {
                                                    item.setExternalCode(object.getString(str6));
                                                }
                                                this = this;
                                                str4 = str5;
                                                response = response2;
                                                try {
                                                    this.itemsList.add(item);
                                                    i++;
                                                    response2 = response;
                                                    str3 = str6;
                                                    recordsFiltered = recordsFiltered2;
                                                    jsonArray = jsonArray;
                                                    str = str;
                                                    recordsTotal = recordsTotal;
                                                    str2 = str2;
                                                } catch (Exception e3) {
                                                    ex = e3;
                                                }
                                            } else {
                                                response = response2;
                                            }
                                            ex = e3;
                                            response.setOK(false);
                                            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                                            code3 = code2;
                                        }
                                    } catch (Exception e4) {
                                        ex = e4;
                                        this = this;
                                        response = response2;
                                    }
                                } else {
                                    response = response2;
                                }
                                response.setOK(true);
                                response.setItemsList(this.itemsList);
                            } catch (Exception e5) {
                                ex = e5;
                                this = this;
                            }
                        } catch (Exception e6) {
                            ex = e6;
                            this = this;
                        }
                    } catch (Exception e7) {
                        ex = e7;
                        this = this;
                        code2 = code;
                        response = response2;
                    }
                    code3 = code2;
                } else {
                    response = response2;
                    response.setOK(false);
                    code3 = code;
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.LISTAR_USERS_GET, code3));
                }
            } else {
                response = response2;
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
            }
            return response;
        }
        response = response2;
        response.setOK(false);
        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "kf1rAJ1MG4 Vacio"));
        return response;
    }

    public IIvRN9WfE5 enviarPagoDin(String key, Ph6mQUZRw4 request) {
        IIvRN9WfE5 response = new IIvRN9WfE5();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getPagosRepo().sendPagoDinamico(request, key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return sendPagoJSON(apiResponseBase.getJsonObject());
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

    public IIvRN9WfE5 sendPagoJSON(JSONObject json) throws JSONException {
        String code = BuildConfig.FLAVOR;
        IIvRN9WfE5 response = new IIvRN9WfE5();
        if (json != null) {
            if (!json.isNull("code")) {
                try {
                    code = json.getString("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code.contains("Ok")) {
                    try {
                        Gson gson = new Gson();
                        IIvRN9WfE5.MyPOJO pago = (IIvRN9WfE5.MyPOJO) gson.fromJson(json.getString("qr"), IIvRN9WfE5.MyPOJO.class);
                        pago.setVersion("5");
                        response.setQrResponse(pago);
                        response.setOK(true);
                    } catch (Exception ex) {
                        response.setOK(false);
                        response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                    }
                } else {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.PAGO_DINAMICO_POST, code));
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

    public ALtYP1fGkI getTrazaPgo(String key, MlJJtXnfZh request) {
        this.HEAD_LOG += " ALtYP1fGkI getTrazaPgo:";
        ALtYP1fGkI response = new ALtYP1fGkI();
        try {
            zDPt4FP8OC apiResponseBase = KQ1TrOYV2S.getInstance().getPagosRepo().getTrazaPago(request, key, this.context);
            if (apiResponseBase != null) {
                if (apiResponseBase.getCodigoHTTP() == 200) {
                    return getTrazaPagoJSON(apiResponseBase.getJsonObject());
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:117:0x0290 A[PHI: r19
      0x0290: PHI (r19v8 java.lang.String) = 
      (r19v1 java.lang.String)
      (r19v2 java.lang.String)
      (r19v3 java.lang.String)
      (r19v4 java.lang.String)
      (r19v5 java.lang.String)
      (r19v6 java.lang.String)
      (r19v9 java.lang.String)
     binds: [B:115:0x028c, B:112:0x0282, B:109:0x0278, B:106:0x026b, B:103:0x0261, B:100:0x0254, B:98:0x0249] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0168  */
    public ALtYP1fGkI getTrazaPagoJSON(JSONObject json) throws JSONException {
        String str;
        byte b;
        s5BkGOZ35ku pago;
        this.HEAD_LOG += " ALtYP1fGkI getTrazaPagoJSON:";
        Log.i("ruM2FlC2jP Traza Pago", json.toString());
        String code = BuildConfig.FLAVOR;
        ALtYP1fGkI response = new ALtYP1fGkI();
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
                    Log.i("PAGOQR", gson.toJson(json));
                    n8AvCp2wNR pagoEntity = (n8AvCp2wNR) new GsonBuilder().setPrettyPrinting().create().fromJson(json.toString(), n8AvCp2wNR.class);
                    List<jxtoYnTPbp> pagoEntities = pagoEntity.getPayment();
                    List<scwi3AAgLR> refundEntities = pagoEntity.getRefunds();
                    List<s5BkGOZ35ku> pagoList = new ArrayList<>();
                    List<nzfmd7tb20> devList = new ArrayList<>();
                    Iterator<jxtoYnTPbp> it = pagoEntities.iterator();
                    while (true) {
                        String str2 = "3";
                        Gson gson2 = gson;
                        if (it.hasNext()) {
                            jxtoYnTPbp item = it.next();
                            s5BkGOZ35ku pago2 = new s5BkGOZ35ku();
                            if (item.getUpdated_at() != null) {
                                pago = pago2;
                                pago.setFecha(item.getUpdated_at());
                            } else {
                                pago = pago2;
                            }
                            if (item.getBanck_code() != null) {
                                pago.setBankCode(item.getBanck_code());
                            }
                            switch (item.getBanck()) {
                                case 1:
                                    pago.setBank("1");
                                    pago.setBBancoEnum(wnGiwuD0kT.BPA);
                                    break;
                                case 2:
                                    pago.setBank("2");
                                    pago.setBBancoEnum(wnGiwuD0kT.BANDEC);
                                    break;
                                case 3:
                                    pago.setBank("3");
                                    pago.setBBancoEnum(wnGiwuD0kT.METRO);
                                    break;
                            }
                            pago.setImporte(item.getAmount());
                            if (item.getCurrency() != null) {
                                pago.setMoneda(item.getCurrency());
                            }
                            if (item.getDescription() != null) {
                                pago.setDescription(item.getDescription());
                            }
                            if (item.getResult_msg() != null) {
                                pago.setResultMsg(item.getResult_msg());
                            }
                            if (item.getPayment_code() != null) {
                                pago.setIdPago(item.getPayment_code());
                            }
                            if (item.getTm_code() != null) {
                                pago.setTmCode(item.getTm_code());
                            }
                            if (item.getSource() != null) {
                                pago.setSource(item.getSource());
                            }
                            if (item.getExternal_code() != null) {
                                pago.setExternalCode(item.getExternal_code());
                            }
                            switch (item.getStatus()) {
                                case "pending":
                                    pago.setEstadoPago(SHYgXB9Dco.PENDIENTE);
                                    break;
                                case "confirmed":
                                    pago.setEstadoPago(SHYgXB9Dco.PAGADO);
                                    break;
                                case "aborted":
                                    pago.setEstadoPago(SHYgXB9Dco.CANCELADO);
                                    break;
                                default:
                                    pago.setEstadoPago(SHYgXB9Dco.NO_DEFINIDO);
                                    break;
                            }
                            pagoList.add(pago);
                            gson = gson2;
                            pagoEntity = pagoEntity;
                            pagoEntities = pagoEntities;
                        } else {
                            for (scwi3AAgLR item2 : refundEntities) {
                                nzfmd7tb20 pago3 = new nzfmd7tb20();
                                switch (item2.getBanck()) {
                                    case 1:
                                        pago3.setBanco("1");
                                        pago3.setBBancoEnum(wnGiwuD0kT.BPA);
                                        break;
                                    case 2:
                                        pago3.setBanco("2");
                                        pago3.setBBancoEnum(wnGiwuD0kT.BANDEC);
                                        break;
                                    case 3:
                                        pago3.setBanco(str2);
                                        pago3.setBBancoEnum(wnGiwuD0kT.METRO);
                                        break;
                                }
                                pago3.setImporte(item2.getAmount());
                                if (item2.getCurrency() != null) {
                                    pago3.setMoneda(item2.getCurrency());
                                }
                                if (item2.getResult_msg() != null) {
                                    pago3.setResultMsg(item2.getResult_msg());
                                }
                                if (item2.getPayment_code() != null) {
                                    pago3.setIdPago(item2.getPayment_code());
                                }
                                if (item2.getTm_reference_refund() != null) {
                                    pago3.setIdTMDevolucion(item2.getTm_reference_refund());
                                }
                                if (item2.getReference_refund() != null) {
                                    pago3.setIdBankDevolcuin(item2.getReference_refund());
                                }
                                if (item2.getRefund_code() != null) {
                                    pago3.setIdDevolucion(item2.getRefund_code());
                                }
                                String status = item2.getStatus();
                                switch (status.hashCode()) {
                                    case -1194777649:
                                        str = str2;
                                        if (status.equals("aborted")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -804109473:
                                        str = str2;
                                        if (status.equals("confirmed")) {
                                            b = 1;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -786365817:
                                        str = str2;
                                        if (status.equals("refound_pending")) {
                                            b = 5;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -682587753:
                                        str = str2;
                                        if (status.equals("pending")) {
                                            b = 0;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -635834866:
                                        str = str2;
                                        if (status.equals("refounded")) {
                                            b = 4;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    case -123173735:
                                        str = str2;
                                        if (status.equals("canceled")) {
                                            b = 3;
                                        } else {
                                            b = -1;
                                        }
                                        break;
                                    default:
                                        str = str2;
                                        b = -1;
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        pago3.setEstadoPago(SHYgXB9Dco.PENDIENTE);
                                        break;
                                    case 1:
                                        pago3.setEstadoPago(SHYgXB9Dco.PAGADO);
                                        break;
                                    case 2:
                                        pago3.setEstadoPago(SHYgXB9Dco.FALLIDO);
                                        break;
                                    case 3:
                                        pago3.setEstadoPago(SHYgXB9Dco.CANCELADO);
                                        break;
                                    case 4:
                                        pago3.setEstadoPago(SHYgXB9Dco.DEVUELTO);
                                        break;
                                    case 5:
                                        pago3.setEstadoPago(SHYgXB9Dco.DEVUELTO_PENDIENTE);
                                        break;
                                    default:
                                        pago3.setEstadoPago(SHYgXB9Dco.NO_DEFINIDO);
                                        break;
                                }
                                devList.add(pago3);
                                str2 = str;
                            }
                            response.setPagoList(pagoList);
                            response.setDevList(devList);
                            response.setOK(true);
                        }
                    }
                } catch (Exception ex) {
                    response.setOK(false);
                    response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, ex.getMessage()));
                }
            } else {
                response.setOK(false);
                response.setMenssage(UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.PAGO_DINAMICO_POST, code));
            }
        } else {
            response.setOK(false);
            response.setMenssage(UhA7J2923N.getInstance().getMessage(500, this.HEAD_LOG, "JSON parametro code Vacio"));
        }
        return response;
    }
}
