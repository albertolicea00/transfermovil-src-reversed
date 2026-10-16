package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

/* JADX INFO: loaded from: classes.dex */
public class yHdVJARBHM {
    public int icono;
    private int id;
    private boolean marcado;
    private String subtitulo;
    private String titulo;

    public int getIcono() {
        return this.icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public yHdVJARBHM(int id, String titulo, String subtitulo, boolean active) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.marcado = active;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isMarcado() {
        return this.marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
}
