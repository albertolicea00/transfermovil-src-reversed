package cu.etecsa.transfermovil.ecommerce.domain.entity;

import cu.etecsa.transfermovil.ecommerce.domain.enums.BankCode;
import cu.etecsa.transfermovil.ecommerce.domain.enums.PaymentStatus;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku
 *
 * Individual payment transaction record.
 */
public class TransactionRecord {
    public String bank;
    public String bankCode;
    public String description;
    public PaymentStatus estadoPago;
    public String externalCode;
    public String fecha;
    public String idPago;
    public float importe;
    public String moneda;
    public String movil;
    public String resultMsg;
    public String source;
    public String tmCode;
    public String user;
    public BankCode bankRef;

    public String getIdPago() { return idPago; }
    public void setIdPago(String idPago) { this.idPago = idPago; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public float getImporte() { return importe; }
    public void setImporte(float importe) { this.importe = importe; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }
    public String getBankCode() { return bankCode; }
    public void setBankCode(String bankCode) { this.bankCode = bankCode; }
    public String getTmCode() { return tmCode; }
    public void setTmCode(String tmCode) { this.tmCode = tmCode; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getExternalCode() { return externalCode; }
    public void setExternalCode(String externalCode) { this.externalCode = externalCode; }
    public String getMovil() { return movil; }
    public void setMovil(String movil) { this.movil = movil; }
    public String getResultMsg() { return resultMsg; }
    public void setResultMsg(String resultMsg) { this.resultMsg = resultMsg; }
    public PaymentStatus getEstadoPago() { return estadoPago; }
    public void setEstadoPago(PaymentStatus estadoPago) { this.estadoPago = estadoPago; }
    public BankCode getBankRef() { return bankRef; }
    public void setBankRef(BankCode bankRef) { this.bankRef = bankRef; }
}
