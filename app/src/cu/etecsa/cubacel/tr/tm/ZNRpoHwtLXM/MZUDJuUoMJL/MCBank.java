package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MCBank implements ITMDataDatabase {

    @DatabaseField
    private R1sDOSqZ2z agencia;

    @DatabaseField
    private String alias;

    @DatabaseField
    private String cuenta;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String movil_notificar;

    @DatabaseField
    private qTDVwLFEjE tipo_moneda;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public qTDVwLFEjE getTipo_moneda() {
        return this.tipo_moneda;
    }

    public void setTipo_moneda(qTDVwLFEjE tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getCuenta() {
        rDEl7rW1aN baseActivity = new rDEl7rW1aN();
        return baseActivity.decryption(this.cuenta);
    }

    public void setCuenta(String cuenta) {
        rDEl7rW1aN baseActivity = new rDEl7rW1aN();
        this.cuenta = baseActivity.encryption(cuenta);
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public R1sDOSqZ2z getAgencia() {
        return this.agencia;
    }

    public void setAgencia(R1sDOSqZ2z agencia) {
        this.agencia = agencia;
    }

    public String getMovil_notificar() {
        return this.movil_notificar;
    }

    public void setMovil_notificar(String movil_notificar) {
        this.movil_notificar = movil_notificar;
    }

    public String toString() {
        rDEl7rW1aN baseActivity = new rDEl7rW1aN();
        String textCuenta = baseActivity.decryption(this.cuenta);
        return this.alias.toUpperCase() + " - " + textCuenta.substring(12);
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("MCBank");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 tipoMoneda = new z9CJ2fIAs7();
        tipoMoneda.setNombre("tipo_moneda");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        tipoMoneda.setTipo(cqi3wj0jbl);
        camposList.add(tipoMoneda);
        z9CJ2fIAs7 cuenta = new z9CJ2fIAs7();
        cuenta.setNombre("cuenta");
        cuenta.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(cuenta);
        z9CJ2fIAs7 alias = new z9CJ2fIAs7();
        alias.setNombre("alias");
        alias.setTipo(cqi3wj0jbl);
        camposList.add(alias);
        z9CJ2fIAs7 agencia = new z9CJ2fIAs7();
        agencia.setNombre("agencia");
        agencia.setTipo(cqi3wj0jbl);
        camposList.add(agencia);
        z9CJ2fIAs7 movil = new z9CJ2fIAs7();
        movil.setNombre("movil_notificar");
        movil.setTipo(cqi3wj0jbl);
        camposList.add(movil);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
