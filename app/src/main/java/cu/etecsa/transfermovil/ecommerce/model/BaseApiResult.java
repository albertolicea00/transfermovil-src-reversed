package cu.etecsa.transfermovil.ecommerce.model;

import org.json.JSONObject;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4
 *
 * Base response wrapper for all e-commerce API task results.
 */
public class BaseApiResult {
    public int httpCode;
    public boolean isOK;
    public JSONObject jsonObject;
    public String menssage;

    public boolean isOK() { return isOK; }
    public void setOK(boolean OK) { this.isOK = OK; }
    public String getMenssage() { return menssage; }
    public void setMenssage(String menssage) { this.menssage = menssage; }
    public JSONObject getJsonObject() { return jsonObject; }
    public void setJsonObject(JSONObject jsonObject) { this.jsonObject = jsonObject; }
    public int getHttpCode() { return httpCode; }
    public void setHttpCode(int httpCode) { this.httpCode = httpCode; }
}
