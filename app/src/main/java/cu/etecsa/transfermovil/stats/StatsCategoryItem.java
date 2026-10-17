package cu.etecsa.transfermovil.stats;

/**
 * Display item for a statistics category with icon and count.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.qkUMT7ePEQ
 * @fingerprint Model with title, subtitle, icon resource, and count string for category-level stats display
 */
public class StatsCategoryItem {
    public String cantidad;
    public int icono;
    public String subtitulo;
    public String titulo;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getIcono() {
        return this.icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
}
