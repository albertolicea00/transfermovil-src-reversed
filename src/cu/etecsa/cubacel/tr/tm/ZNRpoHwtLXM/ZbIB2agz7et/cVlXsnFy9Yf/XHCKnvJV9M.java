package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.V7zVJ66kDf;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.ho8G382dwNt.fHZ2PXN4o9;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.xNWgXsOsGx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class XHCKnvJV9M {
    public FqBpCTmUog exportData(Context context, Intent resultData) {
        FqBpCTmUog response = new FqBpCTmUog();
        if (resultData != null) {
            Uri uri = resultData.getData();
            try {
                OutputStream outputStream = context.getContentResolver().openOutputStream(uri);
                xNWgXsOsGx saveData = new xNWgXsOsGx(context);
                V7zVJ66kDf data = saveData.getDataScheme();
                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                String dataJSON = gson.toJson(data);
                String dataJSON2 = dataJSON.replace("\\\"", "\"").replace("\"[", "[").replace("]\"", "]");
                try {
                    fHZ2PXN4o9 enjoyData = new fHZ2PXN4o9();
                    outputStream.write(enjoyData.convertData(dataJSON2).getBytes());
                    response.setSuccess(true);
                    response.setCode(0);
                    response.setMensaje("OK");
                } catch (Exception e) {
                    response.setSuccess(false);
                    response.setCode(-1);
                    response.setMensaje("Error: Ha ocurrido un error inesperado");
                }
                outputStream.close();
                return response;
            } catch (FileNotFoundException e2) {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Archivo no encontrado");
            } catch (IOException e3) {
                response.setSuccess(false);
                response.setCode(-1);
                response.setMensaje("Error: Ha ocurrido un error mientras se intentaba leer el fichero");
            } catch (Exception e4) {
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
}
