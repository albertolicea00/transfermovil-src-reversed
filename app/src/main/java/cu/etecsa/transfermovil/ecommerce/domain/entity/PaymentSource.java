package cu.etecsa.transfermovil.ecommerce.domain.entity;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH
 * @original_apk_version 1.260416
 */
public class PaymentSource {
    public String currency;
    public int id;
    public String name;
    public String source;
    public String user_id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String toString() {
        return this.source + " - " + this.name;
    }
}
