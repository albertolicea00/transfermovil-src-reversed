package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class QfruhfaN5Z implements Serializable {
    private static final long serialVersionUID = 1;
    public String TITULO = "Parte ";
    public boolean enviado;
    public int noPaquete;
    public String titulo;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = this.TITULO + titulo;
    }

    public boolean isEnviado() {
        return this.enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public int getNoPaquete() {
        return this.noPaquete;
    }

    public void setNoPaquete(int noPaquete) {
        this.noPaquete = noPaquete;
    }

    public String getTITULO() {
        return this.TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }
}
