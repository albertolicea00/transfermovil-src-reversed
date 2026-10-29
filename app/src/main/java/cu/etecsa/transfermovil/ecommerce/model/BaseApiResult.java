package cu.etecsa.transfermovil.ecommerce.model;

import org.json.JSONObject;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4
 * @original_apk_version 1.260416
 */
public class BaseApiResult {
    public int httpCode;
    public boolean isOK;
    public JSONObject jsonObject;
    public String menssage;

    public boolean isOK() {
        return this.isOK;
    }

    public void setOK(boolean OK) {
        this.isOK = OK;
    }

    public String getMenssage() {
        return this.menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
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
}
