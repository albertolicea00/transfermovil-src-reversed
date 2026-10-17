package cu.etecsa.transfermovil.data.model;

/**
 * Gas station reference entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalGas
 * @fingerprint codigoPovincia typo preserved from original; toString returns titulo
 */
public class GasStation {

    /** Typo preserved from original: "Povincia" instead of "Provincia". */
    private String codigoPovincia;
    private String dpa;
    private String titulo;

    public String getCodigoPovincia() {
        return codigoPovincia;
    }

    public void setCodigoPovincia(String codigoPovincia) {
        this.codigoPovincia = codigoPovincia;
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
        return titulo;
    }
}
