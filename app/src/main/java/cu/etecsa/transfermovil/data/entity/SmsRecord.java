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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS
 * @fingerprint @DatabaseTable, ITMDataDatabase, idTransaccion, cuenta, monto validation, defaultValue="Agentes"
 *
 * ORMLite entity for SMS transaction records. Similar validation pattern
 * to OfferRecord: non-empty checks throw NullPointerException, currency
 * validated against CUP|CUC|USD|MLC, monto validated as numeric non-zero.
 *
 * NOTE: The original decompiled setters use a redundant try/catch pattern
 * that catches NullPointerException only to re-throw it.
 */
@DatabaseTable(tableName = "RecordSMS")
public class SmsRecord implements ITMDataDatabase {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String idTransaccion;

    @DatabaseField
    private String cuenta;

    @DatabaseField
    private String monto;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private String servicio;

    @DatabaseField
    private Date fecha;

    @DatabaseField
    private Boolean mostrar;

    /** obfuscated: KYTjPlWScT */
    @DatabaseField(canBeNull = true, defaultValue = "Agentes")
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
        } else {
            throw new NullPointerException();
        }
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        if (!isNullOrEmpty(cuenta) && cuenta.length() > 0) {
            this.cuenta = cuenta;
        } else {
            throw new NullPointerException();
        }
    }

    public String getMonto() {
        return this.monto;
    }

    /**
     * Validates monto is a parseable float and not "0".
     * Original decompiled code uses redundant try/catch re-throw pattern.
     */
    public void setMonto(String monto) throws Exception {
        try {
            Float.parseFloat(monto);
            if (monto.equals("0")) {
                throw new NullPointerException();
            } else {
                this.monto = monto;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String getMoneda() {
        return this.moneda;
    }

    /**
     * Validates currency against CUP, CUC, USD, MLC using contains().
     * Throws NullPointerException (not IllegalArgumentException) on invalid input.
     */
    public void setMoneda(String moneda) {
        if (moneda.contains("CUP") || moneda.contains("CUC")
                || moneda.contains("USD") || moneda.contains("MLC")) {
            this.moneda = moneda;
        } else {
            throw new NullPointerException();
        }
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public TableMetadata getMetadata() {
        TableMetadata metadata = new TableMetadata();
        metadata.setTabla_name("RecordSMS");

        List<FieldSchema> camposList = new ArrayList<>();

        FieldSchema id = new FieldSchema();
        id.setNombre("id");
        id.setTipo(FieldType.PK);
        camposList.add(id);

        FieldSchema idTransaccion = new FieldSchema();
        idTransaccion.setNombre("idTransaccion");
        idTransaccion.setTipo(FieldType.IDENTITY);
        camposList.add(idTransaccion);

        FieldSchema cuenta = new FieldSchema();
        cuenta.setNombre("cuenta");
        cuenta.setTipo(FieldType.DATA);
        camposList.add(cuenta);

        FieldSchema monto = new FieldSchema();
        monto.setNombre("monto");
        monto.setTipo(FieldType.DATA);
        camposList.add(monto);

        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(FieldType.DATA);
        camposList.add(moneda);

        FieldSchema servicio = new FieldSchema();
        servicio.setNombre("servicio");
        servicio.setTipo(FieldType.DATA);
        camposList.add(servicio);

        FieldSchema fecha = new FieldSchema();
        fecha.setNombre("fecha");
        fecha.setTipo(FieldType.DATA);
        camposList.add(fecha);

        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
