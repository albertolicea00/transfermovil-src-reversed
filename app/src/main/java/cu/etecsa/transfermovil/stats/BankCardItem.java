package cu.etecsa.transfermovil.stats;

import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/**
 * Display item for a bank card/account in a list.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.K5ksEKSUSh
 * @fingerprint Model with id, bank enum, account number, currency, title, and subtitle for bank card display
 */
public class BankCardItem {
    public R1sDOSqZ2z banco;
    public String cuenta;
    public int id;
    public String moneda;
    public String subtitulo;
    public String titulo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public R1sDOSqZ2z getBanco() {
        return this.banco;
    }

    public void setBanco(R1sDOSqZ2z banco) {
        this.banco = banco;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
}
