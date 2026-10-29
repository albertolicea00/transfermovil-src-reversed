package cu.etecsa.transfermovil.ecommerce.domain.entity;

import cu.etecsa.transfermovil.ecommerce.domain.enums.PaymentStatus;
import cu.etecsa.transfermovil.ecommerce.domain.enums.BankCode;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20
 * @original_apk_version 1.260416
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
    // Gson uses the original member name as its JSON key.
    public BankCode wnGiwuD0kT;

    public String getIdPago() {
        return this.idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return this.importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public PaymentStatus getEstadoPago() {
        return this.estadoPago;
    }

    public void setEstadoPago(PaymentStatus estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getMovil() {
        return this.movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getBanco() {
        return this.Banco;
    }

    public void setBanco(String banco) {
        this.Banco = banco;
    }

    public String getIdDevolucion() {
        return this.idDevolucion;
    }

    public void setIdDevolucion(String idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getIdTMDevolucion() {
        return this.idTMDevolucion;
    }

    public void setIdTMDevolucion(String idTMDevolucion) {
        this.idTMDevolucion = idTMDevolucion;
    }

    public String getIdBankDevolcuin() {
        return this.idBankDevolcuin;
    }

    public void setIdBankDevolcuin(String idBankDevolcuin) {
        this.idBankDevolcuin = idBankDevolcuin;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public BankCode getBBancoEnum() {
        return this.wnGiwuD0kT;
    }

    public void setBBancoEnum(BankCode bankCode) {
        this.wnGiwuD0kT = bankCode;
    }

    public String getExternalCode() {
        return this.externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
