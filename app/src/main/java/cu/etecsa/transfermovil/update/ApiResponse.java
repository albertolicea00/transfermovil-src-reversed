package cu.etecsa.transfermovil.update;

import org.json.JSONObject;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.Q9fJ7WbVwMB
 * @fingerprint HTTP response wrapper for update API calls. Holds HTTP code, error flag,
 *              parsed JSON body, and message.
 */
public class ApiResponse {

    public int httpCode;
    public boolean isError;
    public JSONObject jsonObject;
    public String menssaje;

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

    public int getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public boolean isError() {
        return this.isError;
    }

    public void setError(boolean error) {
        this.isError = error;
    }
}
