package cu.etecsa.transfermovil.ecommerce.domain.entity;

import cu.etecsa.transfermovil.ecommerce.domain.enums.PaymentStatus;
import cu.etecsa.transfermovil.ecommerce.domain.enums.BankCode;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku
 * @original_apk_version 1.260416
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

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getTmCode() {
        return this.tmCode;
    }

    public void setTmCode(String tmCode) {
        this.tmCode = tmCode;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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
