package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.olmTMXRAbf;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.ho8G382dwNt.fHZ2PXN4o9;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Q94Igo6JT0 {
    public List<Client> clientList;
    public List<olmTMXRAbf> dataList;
    public Map<Integer, Integer> mapNewIDClient = new HashMap();
    public List<gwHFUMMDRu> squemaList;

    public FqBpCTmUog importData(Context context, Intent resultData) {
        FqBpCTmUog response = new FqBpCTmUog();
        if (resultData != null) {
            Uri uri = resultData.getData();
            try {
                InputStream inputStream = context.getContentResolver().openInputStream(uri);
                StringWriter writer = new StringWriter();
                IOUtils.copy(inputStream, writer, "UTF-8");
                String data = writer.toString();
                response = convertAndExport(data);
                inputStream.close();
                return response;
            } catch (FileNotFoundException e) {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Archivo no encontrado");
            } catch (IOException e2) {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Ha ocurrido un error mientras se intentaba leer el fichero");
            } catch (Exception e3) {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Ha ocurrido un error inesperado");
            }
        } else {
            response.isSuccess = false;
            response.setSuccess(false);
            response.setCode(-1);
            response.setMensaje("Datos vacios");
        }
        return response;
    }

    private FqBpCTmUog convertAndExport(String data) {
        FqBpCTmUog response = new FqBpCTmUog();
        try {
            fHZ2PXN4o9 enjoyData = new fHZ2PXN4o9();
            String json = decode(enjoyData.invertData(data));
            if (json != null) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    readSqueme(jsonObject);
                    readBruteData(jsonObject);
                    processData();
                    response.setSuccess(true);
                    response.setCode(0);
                    response.setMensaje("OK");
                } catch (JSONException e) {
                    response.setSuccess(false);
                    response.setCode(-1);
                    response.setMensaje("Error: Ha ocurrido un error inesperado");
                } catch (Exception e2) {
                    response.setSuccess(false);
                    response.setCode(-1);
                    response.setMensaje("Error: Ha ocurrido un error inesperado");
                }
            } else {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Ha ocurrido un error inesperado");
            }
        } catch (Exception e3) {
            response.setSuccess(false);
            response.setCode(-1);
            response.setMensaje("Error: Ha ocurrido un error inesperado");
        }
        return response;
    }

    private String decode(String data) {
        return data;
    }

    private void readSqueme(JSONObject json) {
        String str;
        String str2;
        String str3;
        cQi3wj0jBL tipo;
        String str4 = "tipo";
        String str5 = "camposSquemas";
        if (json != null && !json.isNull("scheme")) {
            this.squemaList = new ArrayList();
            try {
                JSONArray jsonArray = json.getJSONArray("scheme");
                int i = 0;
                while (i < jsonArray.length()) {
                    gwHFUMMDRu esquema = new gwHFUMMDRu();
                    List<z9CJ2fIAs7> camposList = new ArrayList<>();
                    JSONObject object = jsonArray.getJSONObject(i);
                    String tabla = object.getString("tabla_name");
                    esquema.setTabla_name(tabla);
                    if (object.isNull(str5)) {
                        str = str4;
                        str2 = str5;
                    } else {
                        JSONArray jsonFields = object.getJSONArray(str5);
                        int j = 0;
                        while (j < jsonFields.length()) {
                            z9CJ2fIAs7 campoSquema = new z9CJ2fIAs7();
                            JSONObject campo = jsonFields.getJSONObject(j);
                            if (!campo.isNull("nombre")) {
                                campoSquema.setNombre(campo.getString("nombre"));
                            }
                            if (campo.isNull(str4)) {
                                str3 = str4;
                            } else {
                                String tipoStr = campo.getString(str4);
                                byte b = -1;
                                switch (tipoStr.hashCode()) {
                                    case 2245:
                                        str3 = str4;
                                        if (tipoStr.equals("FK")) {
                                            b = 2;
                                        }
                                        break;
                                    case 2555:
                                        str3 = str4;
                                        if (tipoStr.equals("PK")) {
                                            b = 1;
                                        }
                                        break;
                                    case 2090922:
                                        str3 = str4;
                                        if (tipoStr.equals("DATA")) {
                                            b = 0;
                                        }
                                        break;
                                    case 646865086:
                                        str3 = str4;
                                        if (tipoStr.equals("IDENTITY")) {
                                            b = 3;
                                        }
                                        break;
                                    default:
                                        str3 = str4;
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        tipo = cQi3wj0jBL.DATA;
                                        break;
                                    case 1:
                                        tipo = cQi3wj0jBL.PK;
                                        break;
                                    case 2:
                                        tipo = cQi3wj0jBL.FK;
                                        break;
                                    case 3:
                                        tipo = cQi3wj0jBL.IDENTITY;
                                        break;
                                    default:
                                        tipo = cQi3wj0jBL.OTHER;
                                        break;
                                }
                                campoSquema.setTipo(tipo);
                            }
                            if (!campo.isNull("campoForaneo")) {
                                campoSquema.setCampoForaneo(campo.getString("campoForaneo"));
                            }
                            if (!campo.isNull("tablaForanea")) {
                                campoSquema.setTablaForanea(campo.getString("tablaForanea"));
                            }
                            camposList.add(campoSquema);
                            j++;
                            str5 = str5;
                            str4 = str3;
                        }
                        str = str4;
                        str2 = str5;
                    }
                    esquema.setCamposSquemas(camposList);
                    this.squemaList.add(esquema);
                    i++;
                    str5 = str2;
                    str4 = str;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void readBruteData(JSONObject json) {
        if (json != null && !json.isNull("datos")) {
            this.dataList = new ArrayList();
            try {
                JSONArray jsonArray = json.getJSONArray("datos");
                for (int i = 0; i < jsonArray.length(); i++) {
                    olmTMXRAbf importSqueme = new olmTMXRAbf();
                    JSONObject object = jsonArray.getJSONObject(i);
                    String tabla = object.getString("tabla");
                    if (!object.isNull("dataJSON")) {
                        JSONArray jsonFields = object.getJSONArray("dataJSON");
                        importSqueme.setListaDatos(jsonFields);
                    }
                    importSqueme.setTabla(tabla);
                    this.dataList.add(importSqueme);
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private void processData() throws Exception {
        Iterator<gwHFUMMDRu> it;
        Iterator<gwHFUMMDRu> it2;
        gwHFUMMDRu squemeItem;
        JSONArray listaArray;
        String datoCampo;
        JSONObject object;
        Iterator<z9CJ2fIAs7> it3;
        String campos;
        int idForaneo;
        Iterator<gwHFUMMDRu> it4 = this.squemaList.iterator();
        while (it4.hasNext()) {
            gwHFUMMDRu squemeItem2 = it4.next();
            String tabla = squemeItem2.getTabla_name().toLowerCase();
            if (!unYp8VQThY.getInstance().checkIfTableExists(tabla)) {
                it = it4;
            } else {
                Iterator<olmTMXRAbf> it5 = this.dataList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        it = it4;
                        break;
                    }
                    olmTMXRAbf datasTable = it5.next();
                    if (datasTable.getTabla().toLowerCase().contains(tabla)) {
                        if (!tabla.contains("client")) {
                            if (!tabla.contains("recordsms")) {
                                if (!tabla.contains("tcticket")) {
                                    JSONArray listaArray2 = datasTable.getListaDatos();
                                    int i = 0;
                                    while (i < listaArray2.length()) {
                                        try {
                                            JSONObject object2 = listaArray2.getJSONObject(i);
                                            String valores = BuildConfig.FLAVOR;
                                            Iterator<z9CJ2fIAs7> it6 = squemeItem2.getCamposSquemas().iterator();
                                            boolean isExistInDB = false;
                                            String valores2 = BuildConfig.FLAVOR;
                                            while (it6.hasNext()) {
                                                z9CJ2fIAs7 campo = it6.next();
                                                String nombreCampo = campo.getNombre().toLowerCase();
                                                cQi3wj0jBL tipo = campo.getTipo();
                                                campo.getCampoForaneo();
                                                campo.getTablaForanea();
                                                it2 = it4;
                                                if (!object2.isNull(nombreCampo)) {
                                                    squemeItem = squemeItem2;
                                                    try {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append("'");
                                                        listaArray = listaArray2;
                                                        try {
                                                            sb.append(object2.getString(nombreCampo));
                                                            sb.append("'");
                                                            datoCampo = sb.toString();
                                                        } catch (JSONException e) {
                                                            e = e;
                                                            e.printStackTrace();
                                                            i++;
                                                            squemeItem2 = squemeItem;
                                                            it4 = it2;
                                                            listaArray2 = listaArray;
                                                        }
                                                    } catch (JSONException e2) {
                                                        e = e2;
                                                        listaArray = listaArray2;
                                                    }
                                                } else {
                                                    squemeItem = squemeItem2;
                                                    listaArray = listaArray2;
                                                    datoCampo = null;
                                                }
                                                if (datoCampo == null) {
                                                    object = object2;
                                                    it3 = it6;
                                                } else {
                                                    object = object2;
                                                    if (tipo == cQi3wj0jBL.FK) {
                                                        String campos2 = valores2 + "," + nombreCampo;
                                                        try {
                                                            String valorId = datoCampo.replace("'", BuildConfig.FLAVOR);
                                                            campos = campos2;
                                                            try {
                                                                idForaneo = this.mapNewIDClient.get(Integer.valueOf(valorId)).intValue();
                                                            } catch (Exception e3) {
                                                                ex = e3;
                                                                Log.e("TM_ERR", ex.getMessage());
                                                                idForaneo = 0;
                                                            }
                                                        } catch (Exception e4) {
                                                            ex = e4;
                                                            campos = campos2;
                                                        }
                                                        valores = valores + "," + String.valueOf(idForaneo);
                                                        it3 = it6;
                                                        valores2 = campos;
                                                    } else if (tipo == cQi3wj0jBL.PK) {
                                                        it3 = it6;
                                                    } else if (tipo == cQi3wj0jBL.DATA || tipo == cQi3wj0jBL.OTHER) {
                                                        String campos3 = valores2 + "," + nombreCampo;
                                                        if (datoCampo.matches("^[a-zA-Z]+\\s(0?[1-9]|[12][0-9]|3[01]),\\s[0-9]+\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}(\\.[0-9]{1,3})?\\s[a-zA-Z]+$")) {
                                                            try {
                                                                it3 = it6;
                                                                try {
                                                                    SimpleDateFormat formatter4 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.ENGLISH);
                                                                    String aux = datoCampo.replace("'", BuildConfig.FLAVOR);
                                                                    Date dateAux = formatter4.parse(aux);
                                                                    datoCampo = "datetime('" + getCurrentTimeStamp(dateAux) + "')";
                                                                } catch (Exception e5) {
                                                                    ex = e5;
                                                                    Log.e("e", ex.getMessage());
                                                                }
                                                            } catch (Exception e6) {
                                                                ex = e6;
                                                                it3 = it6;
                                                            }
                                                        } else {
                                                            it3 = it6;
                                                        }
                                                        valores = valores + "," + datoCampo;
                                                        valores2 = campos3;
                                                    } else if (tipo == cQi3wj0jBL.DATE) {
                                                        it3 = it6;
                                                    } else if (tipo != cQi3wj0jBL.IDENTITY) {
                                                        it3 = it6;
                                                    } else {
                                                        boolean isExistInDB2 = unYp8VQThY.getInstance().checkIdentityData(tabla, nombreCampo, datoCampo);
                                                        valores2 = valores2 + "," + nombreCampo;
                                                        isExistInDB = isExistInDB2;
                                                        valores = valores + "," + datoCampo;
                                                        it3 = it6;
                                                    }
                                                }
                                                squemeItem2 = squemeItem;
                                                it4 = it2;
                                                listaArray2 = listaArray;
                                                object2 = object;
                                                it6 = it3;
                                            }
                                            it2 = it4;
                                            squemeItem = squemeItem2;
                                            listaArray = listaArray2;
                                            if (!isExistInDB) {
                                                String campos4 = valores2.substring(1);
                                                unYp8VQThY.getInstance().insertData(tabla, campos4, valores.substring(1));
                                            } else {
                                                Log.i("Q94Igo6JT0", "Dato ya insertado");
                                            }
                                        } catch (JSONException e7) {
                                            e = e7;
                                            it2 = it4;
                                            squemeItem = squemeItem2;
                                            listaArray = listaArray2;
                                        }
                                        i++;
                                        squemeItem2 = squemeItem;
                                        it4 = it2;
                                        listaArray2 = listaArray;
                                    }
                                    it = it4;
                                    break;
                                }
                                it = it4;
                                setTickets(datasTable.getListaDatos());
                                break;
                            }
                            it = it4;
                            setSMS(datasTable.getListaDatos());
                            break;
                        }
                        it = it4;
                        setClients(datasTable.getListaDatos());
                        break;
                    }
                }
            }
            it4 = it;
        }
    }

    public String getCurrentTimeStamp(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
    }

    private void setClients(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject object = jsonArray.getJSONObject(i);
                if (!object.isNull("name") && unYp8VQThY.getInstance().getClientListsWithName(object.getString("name")).size() == 0) {
                    Client client = new Client();
                    client.setName(object.getString("name"));
                    if (!object.isNull("phone")) {
                        client.setPhone(object.getString("phone"));
                    }
                    if (!object.isNull("ci")) {
                        client.setCi(object.getString("ci"));
                    }
                    if (!object.isNull("address")) {
                        client.setAddress(object.getString("address"));
                    }
                    int idClient = unYp8VQThY.getInstance().addClientID(client);
                    try {
                        Client aux = unYp8VQThY.getInstance().getClientListsWithName(object.getString("name")).get(0);
                        this.mapNewIDClient.put(Integer.valueOf(object.getInt("id")), Integer.valueOf(aux.getId()));
                    } catch (Exception e) {
                        this.mapNewIDClient.put(Integer.valueOf(object.getInt("id")), Integer.valueOf(idClient));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    private void setSMS(JSONArray jsonArray) throws Exception {
        String str;
        String str2 = "fecha";
        int i = 0;
        while (i < jsonArray.length()) {
            try {
                try {
                    JSONObject object = jsonArray.getJSONObject(i);
                    if (object.isNull("idTransaccion")) {
                        str = str2;
                    } else if (unYp8VQThY.getInstance().getRecordSMSwithIDTransaction(object.getString("idTransaccion")).size() != 0) {
                        str = str2;
                    } else {
                        RecordSMS recordSMS = new RecordSMS();
                        if (!object.isNull("cuenta")) {
                            recordSMS.setCuenta(object.getString("cuenta"));
                        }
                        if (object.isNull(str2)) {
                            str = str2;
                        } else {
                            String fecha = object.getString(str2);
                            if (fecha.matches("^[a-zA-Z]+\\s(0?[1-9]|[12][0-9]|3[01]),\\s[0-9]+\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}(\\.[0-9]{1,3})?\\s[a-zA-Z]+$")) {
                                try {
                                    str = str2;
                                    try {
                                        SimpleDateFormat formatter4 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.ENGLISH);
                                        Date dateAux = formatter4.parse(fecha);
                                        recordSMS.setFecha(dateAux);
                                    } catch (Exception e) {
                                        ex = e;
                                        Log.e("e", ex.getMessage());
                                    }
                                } catch (Exception e2) {
                                    ex = e2;
                                    str = str2;
                                }
                            } else {
                                str = str2;
                                recordSMS.setFecha(new Date());
                            }
                        }
                        if (!object.isNull("idTransaccion")) {
                            recordSMS.setIdTransaccion(object.getString("idTransaccion"));
                        }
                        if (!object.isNull("moneda")) {
                            recordSMS.setMoneda(object.getString("moneda"));
                        }
                        if (!object.isNull("monto")) {
                            recordSMS.setMonto(object.getString("monto"));
                        }
                        if (!object.isNull("mostrar")) {
                            recordSMS.setMostrar(Boolean.valueOf(object.getBoolean("mostrar")));
                        }
                        if (!object.isNull("servicio")) {
                            recordSMS.setServicio(object.getString("servicio"));
                        }
                        if (!object.isNull("tipo_servicio")) {
                            recordSMS.setTipo_servicio(KYTjPlWScT.valueOf(object.getString("tipo_servicio")));
                        }
                        unYp8VQThY.getInstance().addRecordSMS(recordSMS);
                    }
                    i++;
                    str2 = str;
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    return;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private void setTickets(JSONArray jsonArray) {
        String str;
        String str2;
        String str3 = "fecha";
        String str4 = "serie";
        int i = 0;
        while (i < jsonArray.length()) {
            try {
                try {
                    JSONObject object = jsonArray.getJSONObject(i);
                    if (object.isNull(str4)) {
                        str = str3;
                        str2 = str4;
                    } else if (unYp8VQThY.getInstance().getTCTicketWithSerie(object.getString(str4)).size() != 0) {
                        str = str3;
                        str2 = str4;
                    } else {
                        TCTicket ticket = new TCTicket();
                        if (!object.isNull(str4)) {
                            ticket.setSerie(object.getString(str4));
                        }
                        if (object.isNull(str3)) {
                            str = str3;
                            str2 = str4;
                        } else {
                            String fecha = object.getString(str3);
                            str = str3;
                            if (fecha.matches("^[a-zA-Z]+\\s(0?[1-9]|[12][0-9]|3[01]),\\s[0-9]+\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}(\\.[0-9]{1,3})?\\s[a-zA-Z]+$")) {
                                try {
                                    str2 = str4;
                                    try {
                                        SimpleDateFormat formatter4 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.ENGLISH);
                                        Date dateAux = formatter4.parse(fecha);
                                        ticket.setFecha(dateAux);
                                    } catch (Exception e) {
                                        ex = e;
                                        Log.e("e", ex.getMessage());
                                    }
                                } catch (Exception e2) {
                                    ex = e2;
                                    str2 = str4;
                                }
                            } else {
                                str2 = str4;
                                ticket.setFecha(new Date());
                            }
                        }
                        if (!object.isNull("alias")) {
                            ticket.setAlias(object.getString("alias"));
                        }
                        if (!object.isNull("moneda")) {
                            ticket.setMoneda(object.getString("moneda"));
                        }
                        if (!object.isNull("importe")) {
                            ticket.setImporte(Float.parseFloat(object.getString("importe")));
                        }
                        if (!object.isNull("data")) {
                            ticket.setData(object.getString("data"));
                        }
                        if (!object.isNull("idbank")) {
                            ticket.setIdBank(object.getString("idbank"));
                        }
                        if (!object.isNull("idtM")) {
                            ticket.setIdTM(object.getString("idtM"));
                        }
                        if (!object.isNull("consumido")) {
                            ticket.setConsumido(object.getBoolean("consumido"));
                        }
                        if (!object.isNull("deleted")) {
                            ticket.setDeleted(object.getBoolean("deleted"));
                        }
                        unYp8VQThY.getInstance().addTCTicket(ticket);
                    }
                    i++;
                    str3 = str;
                    str4 = str2;
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    return;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        }
    }
}
