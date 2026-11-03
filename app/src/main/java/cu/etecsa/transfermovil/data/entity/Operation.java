package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.core.enums.BankType;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "Operacion")
public class Operation {

    @DatabaseField
    private boolean activo;

    @DatabaseField
    private String fragment_name;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int imagen;

    @DatabaseField
    private BankOperationCode operacion;

    @DatabaseField
    private int order;

    @DatabaseField
    private String subtitulo;

    @DatabaseField
    private BankType tipo_servicio;

    @DatabaseField
    private String titulo;

    public BankOperationCode getOperacion() {
        return this.operacion;
    }

    public void setOperacion(BankOperationCode operacion) {
        this.operacion = operacion;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public int getImagen() {
        return this.imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getFragment_name() {
        return this.fragment_name;
    }

    public void setFragment_name(String fragment_name) {
        this.fragment_name = fragment_name;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public BankType getTipo_serivicio() {
        return this.tipo_servicio;
    }

    public void setTipo_serivicio(BankType tipo_serivicio) {
        this.tipo_servicio = tipo_serivicio;
    }
}
