package cu.etecsa.transfermovil.data.model;

/**
 * CADECA exchange office branch entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca
 * @fingerprint codigoPovincia typo preserved from original; toString returns titulo
 */
public class CadecaBranch {

    private String cod_mun;
    /** Typo preserved from original: "Povincia" instead of "Provincia". */
    private String codigoPovincia;
    private String dpa;
    private String titulo;

    public String getCod_mun() {
        return cod_mun;
    }

    public void setCod_mun(String cod_mun) {
        this.cod_mun = cod_mun;
    }

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
