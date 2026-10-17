package cu.etecsa.transfermovil.ecommerce.domain.entity;

import cu.etecsa.transfermovil.ecommerce.domain.enums.BankCode;
import cu.etecsa.transfermovil.ecommerce.domain.enums.PaymentStatus;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20
 *
 * Refund/devolution record with payment and bank references.
 */
public class RefundRecord {
    public String Banco;
    public PaymentStatus estadoPago;
    public String externalCode;
    public String fecha;
    public String idBankDevolcuin;
    public String idDevolucion;
    public String idPago;
    public String idTMDevolucion;
    public float importe;
    public String moneda;
    public String movil;
    public String resultMsg;
    public String source;
    public String user;
    public BankCode bankCode;

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
    public String getBanco() { return Banco; }
    public void setBanco(String banco) { this.Banco = banco; }
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
    public BankCode getBankCode() { return bankCode; }
    public void setBankCode(BankCode bankCode) { this.bankCode = bankCode; }
    public String getIdDevolucion() { return idDevolucion; }
    public void setIdDevolucion(String idDevolucion) { this.idDevolucion = idDevolucion; }
    public String getIdBankDevolcuin() { return idBankDevolcuin; }
    public void setIdBankDevolcuin(String idBankDevolcuin) { this.idBankDevolcuin = idBankDevolcuin; }
    public String getIdTMDevolucion() { return idTMDevolucion; }
    public void setIdTMDevolucion(String idTMDevolucion) { this.idTMDevolucion = idTMDevolucion; }
}
