package cu.etecsa.transfermovil.stats;

import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;

/**
 * Display item for an operation in a RecyclerView list.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02
 * @fingerprint Model with title, subtitle, icon, favorite flag, operation reference, and view type for list display
 */
public class OperationListItem {
    public boolean fav;
    public int icono;
    public FdonIAFI9w operacion;
    public String subtitulo;
    public String titulo;
    public Integer type;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isFav() {
        return this.fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public FdonIAFI9w getOperacion() {
        return this.operacion;
    }

    public void setOperacion(FdonIAFI9w operacion) {
        this.operacion = operacion;
    }
}
