package cu.etecsa.transfermovil.stats;

import cu.etecsa.transfermovil.core.enums.AgentSource;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.FlNVShJWtm;
import java.util.List;

/**
 * Monthly statistical record grouped by agency source.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B21UyndcVvF.Y9aAL2BCAI
 * @fingerprint Model holding year, month, agency source, and list of statistical operations for a period
 */
public class StatsMonthlyRecord {
    private AgentSource agencia;
    public int anno;
    public int mes;
    private List<FlNVShJWtm> operacionesEstaditicas;

    public int getAnno() {
        return this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public AgentSource getAgencia() {
        return this.agencia;
    }

    public void setAgencia(AgentSource agencia) {
        this.agencia = agencia;
    }

    public List<FlNVShJWtm> getOperacionesEstaditicas() {
        return this.operacionesEstaditicas;
    }

    public void setOperacionesEstaditicas(List<FlNVShJWtm> operacionesEstaditicas) {
        this.operacionesEstaditicas = operacionesEstaditicas;
    }
}
