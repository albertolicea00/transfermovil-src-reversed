package cu.etecsa.transfermovil.ecommerce;

import org.json.JSONObject;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.zDPt4FP8OC
 * @original_apk_version 1.260416
 */
public class ApiResponse {
    public int codigoHTTP = 0;
    public boolean isError;
    public JSONObject jsonObject;
    public String menssaje;

    public boolean isError() {
        return this.isError;
    }

    public void setError(boolean error) {
        this.isError = error;
    }

    public int getCodigoHTTP() {
        return this.codigoHTTP;
    }

    public void setCodigoHTTP(int codigoHTTP) {
        this.codigoHTTP = codigoHTTP;
    }

    public String getMenssaje() {
        return this.menssaje;
    }

    public void setMenssaje(String menssaje) {
        this.menssaje = menssaje;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
