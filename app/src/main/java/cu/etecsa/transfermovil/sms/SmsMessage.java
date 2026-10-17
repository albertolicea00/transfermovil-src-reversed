package cu.etecsa.transfermovil.sms;

import java.util.Date;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rIgmgP6JXL
 * @fingerprint POJO for SMS inbox entries (address, body, date, person, type)
 */
public class SmsMessage {
    private String address;
    private String body;
    private Date date;
    private String date_no_convert;
    private String person;
    private String type;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate_no_convert() {
        return this.date_no_convert;
    }

    public void setDate_no_convert(String date_no_convert) {
        this.date_no_convert = date_no_convert;
    }
}
