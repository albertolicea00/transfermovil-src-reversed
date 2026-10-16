package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class Tributo implements ITMDataDatabase {

    @DatabaseField
    public String abreviatura;

    @DatabaseField(id = true)
    public String cod_tributo;

    @DatabaseField
    public String moneda;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public String tipo;

    @DatabaseField
    public String tipoPersona;

    public String getCod_tributo() {
        return this.cod_tributo;
    }

    public void setCod_tributo(String cod_tributo) {
        this.cod_tributo = cod_tributo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String toString() {
        return this.cod_tributo + " - " + this.abreviatura;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("Nauta");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 cod_tributo = new z9CJ2fIAs7();
        cod_tributo.setNombre("cod_tributo");
        cod_tributo.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(cod_tributo);
        z9CJ2fIAs7 nombre = new z9CJ2fIAs7();
        nombre.setNombre("nombre");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        nombre.setTipo(cqi3wj0jbl);
        camposList.add(nombre);
        z9CJ2fIAs7 abreviatura = new z9CJ2fIAs7();
        abreviatura.setNombre("abreviatura");
        abreviatura.setTipo(cqi3wj0jbl);
        camposList.add(abreviatura);
        z9CJ2fIAs7 moneda = new z9CJ2fIAs7();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        z9CJ2fIAs7 tipo = new z9CJ2fIAs7();
        tipo.setNombre("nombre");
        tipo.setTipo(cqi3wj0jbl);
        camposList.add(tipo);
        z9CJ2fIAs7 tipoPersona = new z9CJ2fIAs7();
        tipoPersona.setNombre("tipoPersona");
        tipoPersona.setTipo(cqi3wj0jbl);
        camposList.add(tipoPersona);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
