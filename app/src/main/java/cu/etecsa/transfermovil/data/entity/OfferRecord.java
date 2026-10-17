package cu.etecsa.transfermovil.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.core.enums.AgentSource;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.ITMDataDatabase;
import cu.etecsa.transfermovil.data.TableMetadata;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordOferta
 * @fingerprint @DatabaseTable, ITMDataDatabase, idTransaccion, idOferta, token, monto validation, moneda CUP|CUC|USD|MLC
 *
 * ORMLite entity for offer/deal transaction records. Includes input
 * validation in setters: non-empty checks throw NullPointerException,
 * moneda validates against CUP|CUC|USD|MLC, tipoOferta validates against
 * COMPRA|ACTUALIZACION|CONSULTA, monto validates numeric non-zero.
 */
@DatabaseTable(tableName = "RecordOferta")
public class OfferRecord implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String idTransaccion;

    @DatabaseField
    private String idOferta;

    @DatabaseField
    private String idTransferencia;

    @DatabaseField
    private String token;

    @DatabaseField
    private String monto;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private String tipoOferta;

    @DatabaseField
    private Date fecha;

    @DatabaseField
    private String fechaVencimiento;

    @DatabaseField
    private Boolean mostrar;

    /** obfuscated: KYTjPlWScT */
    @DatabaseField(canBeNull = true, defaultValue = "Ofertas")
    private AgentSource tipo_servicio;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        if (!isNullOrEmpty(idTransaccion) && idTransaccion.length() > 0) {
            this.idTransaccion = idTransaccion;
            return;
        }
        throw new NullPointerException("idTransaccion no puede ser nulo o vacio");
    }

    public String getIdOferta() {
        return this.idOferta;
    }

    public void setIdOferta(String idOferta) {
        if (!isNullOrEmpty(idOferta) && idOferta.length() > 0) {
            this.idOferta = idOferta;
            return;
        }
        throw new NullPointerException("idOferta no puede ser nulo o vacio");
    }

    public String getIdTransferencia() {
        return this.idTransferencia;
    }

    /**
     * NOTE: Original error message says "idTransaccion" even though this
     * validates idTransferencia. Bug preserved from decompiled source.
     */
    public void setIdTransferencia(String idTransferencia) {
        if (!isNullOrEmpty(idTransferencia) && idTransferencia.length() > 0) {
            this.idTransferencia = idTransferencia;
            return;
        }
        throw new NullPointerException("idTransaccion no puede ser nulo o vacio");
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        if (!isNullOrEmpty(token) && token.length() > 0) {
            this.token = token;
            return;
        }
        throw new NullPointerException("token no puede ser nulo o vacio");
    }

    public String getMonto() {
        return this.monto;
    }

    /**
     * Validates that monto is a parseable float and not "0".
     * Throws NumberFormatException on parse failure, NullPointerException if zero.
     */
    public void setMonto(String monto) {
        try {
            Float.parseFloat(monto);
            if (monto.equals("0")) {
                throw new NullPointerException("El monto no puede ser cero");
            }
            this.monto = monto;
        } catch (Exception e) {
            throw new NumberFormatException("Formato de monto invalido");
        }
    }

    public String getMoneda() {
        return this.moneda;
    }

    /**
     * Validates currency against CUP, CUC, USD, MLC using contains().
     */
    public void setMoneda(String moneda) {
        if (moneda.contains("CUP") || moneda.contains("CUC")
                || moneda.contains("USD") || moneda.contains("MLC")) {
            this.moneda = moneda;
            return;
        }
        throw new IllegalArgumentException("Moneda no valida");
    }

    public String getTipoOferta() {
        return this.tipoOferta;
    }

    /**
     * Validates offer type against COMPRA, ACTUALIZACION, CONSULTA.
     */
    public void setTipoOferta(String tipoOferta) {
        if (!isNullOrEmpty(tipoOferta)
                && (tipoOferta.equals("COMPRA")
                    || tipoOferta.equals("ACTUALIZACION")
                    || tipoOferta.equals("CONSULTA"))) {
            this.tipoOferta = tipoOferta;
            return;
        }
        throw new IllegalArgumentException("Tipo de oferta no valido");
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        if (fecha != null) {
            this.fecha = fecha;
            return;
        }
        throw new NullPointerException("Fecha no puede ser nula");
    }

    public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        if (!isNullOrEmpty(fechaVencimiento)) {
            this.fechaVencimiento = fechaVencimiento;
            return;
        }
        throw new NullPointerException("Fecha de vencimiento no puede ser nula");
    }

    public Boolean getMostrar() {
        return this.mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public AgentSource getTipo_servicio() {
        return this.tipo_servicio;
    }

    public void setTipo_servicio(AgentSource tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    /** Extracts month (0-based) from fecha via Calendar.MONTH. */
    public int getMes() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        return cal.get(Calendar.MONTH);
    }

    /** Extracts year from fecha via Calendar.YEAR. */
    public int getAnno() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        return cal.get(Calendar.YEAR);
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("RecordOferta");

        List<FieldSchema> camposList = new ArrayList<>();

        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);

        FieldSchema idTransaccion = new FieldSchema();
        idTransaccion.setNombre("idTransaccion");
        idTransaccion.setTipo(FieldType.IDENTITY);
        camposList.add(idTransaccion);

        FieldSchema idOferta = new FieldSchema();
        idOferta.setNombre("idOferta");
        idOferta.setTipo(FieldType.DATA);
        camposList.add(idOferta);

        FieldSchema token = new FieldSchema();
        token.setNombre("token");
        token.setTipo(FieldType.DATA);
        camposList.add(token);

        FieldSchema monto = new FieldSchema();
        monto.setNombre("monto");
        monto.setTipo(FieldType.DATA);
        camposList.add(monto);

        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(FieldType.DATA);
        camposList.add(moneda);

        FieldSchema tipoOferta = new FieldSchema();
        tipoOferta.setNombre("tipoOferta");
        tipoOferta.setTipo(FieldType.DATA);
        camposList.add(tipoOferta);

        FieldSchema fecha = new FieldSchema();
        fecha.setNombre("fecha");
        fecha.setTipo(FieldType.DATA);
        camposList.add(fecha);

        FieldSchema fechaVenc = new FieldSchema();
        fechaVenc.setNombre("fechaVencimiento");
        fechaVenc.setTipo(FieldType.DATA);
        camposList.add(fechaVenc);

        FieldSchema tipoServicio = new FieldSchema();
        tipoServicio.setNombre("tipo_servicio");
        tipoServicio.setTipo(FieldType.DATA);
        camposList.add(tipoServicio);

        FieldSchema mostrar = new FieldSchema();
        mostrar.setNombre("mostrar");
        mostrar.setTipo(FieldType.DATA);
        camposList.add(mostrar);

        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
