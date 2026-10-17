package cu.etecsa.transfermovil.ui.home;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.S5yJNkLr85
 * @fingerprint POJO for home screen operation grid item. Maps DB Operation entity
 *              to display model with title, subtitle, icons (operation + parent bank),
 *              sort order, and fragment route.
 */
public class OperationMenuItem {
    public int iconoOperacion;
    public int iconoPadre;
    public int id;
    public int orden;
    public String ruta_fragment;
    public String subtitulo;
    public String titulo;

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getSubtitulo() { return this.subtitulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }

    public int getIconoOperacion() { return this.iconoOperacion; }
    public void setIconoOperacion(int iconoOperacion) { this.iconoOperacion = iconoOperacion; }

    public int getIconoPadre() { return this.iconoPadre; }
    public void setIconoPadre(int iconoPadre) { this.iconoPadre = iconoPadre; }

    public int getOrden() { return this.orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getRuta_fragment() { return this.ruta_fragment; }
    public void setRuta_fragment(String ruta_fragment) { this.ruta_fragment = ruta_fragment; }
}
