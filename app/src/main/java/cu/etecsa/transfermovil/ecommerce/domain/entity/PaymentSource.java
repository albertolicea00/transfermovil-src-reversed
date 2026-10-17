package cu.etecsa.transfermovil.ecommerce.domain.entity;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH
 *
 * A payment source (bank account) linked to a user.
 */
public class PaymentSource {
    public String currency;
    public int id;
    public String name;
    public String source;
    public String user_id;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
}
