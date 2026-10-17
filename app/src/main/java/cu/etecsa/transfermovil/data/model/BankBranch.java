package cu.etecsa.transfermovil.data.model;

/**
 * Bank branch reference entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalBancaria
 * @fingerprint codigoSucursal, dpa, titulo fields; toString returns "code - title"
 */
public class BankBranch {

    private String codigoSucursal;
    private String dpa;
    private String titulo;

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getDpa() {
        return dpa;
    }

    public void setDpa(String dpa) {
        this.dpa = dpa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return codigoSucursal + " - " + titulo;
    }
}
