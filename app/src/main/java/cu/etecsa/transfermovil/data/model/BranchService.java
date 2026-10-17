package cu.etecsa.transfermovil.data.model;

/**
 * Branch service mapping entry.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioSucursal
 * @fingerprint codDpa, codServicio, nomServicio fields; toString returns nomServicio
 */
public class BranchService {

    private String codDpa;
    private String codServicio;
    private String nomServicio;

    public String getCodDpa() {
        return codDpa;
    }

    public void setCodDpa(String codDpa) {
        this.codDpa = codDpa;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public String getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }

    @Override
    public String toString() {
        return nomServicio;
    }
}
