package cu.etecsa.transfermovil.data;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7
 * @fingerprint nombre, tipo (FieldType), tablaForanea, campoForaneo
 *
 * Describes one column in a table schema. For foreign keys, {@code tablaForanea}
 * and {@code campoForaneo} identify the referenced table and column.
 */
public class FieldSchema {

    public String nombre;
    public FieldType tipo;
    public String tablaForanea;
    public String campoForaneo;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FieldType getTipo() {
        return this.tipo;
    }

    public void setTipo(FieldType tipo) {
        this.tipo = tipo;
    }

    public String getTablaForanea() {
        return this.tablaForanea;
    }

    public void setTablaForanea(String tablaForanea) {
        this.tablaForanea = tablaForanea;
    }

    public String getCampoForaneo() {
        return this.campoForaneo;
    }

    public void setCampoForaneo(String campoForaneo) {
        this.campoForaneo = campoForaneo;
    }
}
