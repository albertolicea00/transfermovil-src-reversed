package cu.etecsa.transfermovil.data.entity;

import cu.etecsa.transfermovil.data.ITMDataDatabase;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.transfermovil.data.FieldType;
import cu.etecsa.transfermovil.data.TableMetadata;
import cu.etecsa.transfermovil.data.FieldSchema;
import cu.etecsa.transfermovil.core.enums.AgentSource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS
 * @original_apk_version 1.260416
 */
@DatabaseTable(tableName = "RecordSMS")
public class SmsRecord implements ITMDataDatabase {

    @DatabaseField
    private String cuenta;

    @DatabaseField
    private Date fecha;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String idTransaccion;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private String monto;

    @DatabaseField
    private Boolean mostrar;

    @DatabaseField
    private String servicio;

    @DatabaseField(canBeNull = true, defaultValue = "Agentes")
    private AgentSource tipo_servicio;

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
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                throw e;
            }
        }
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        if (!isNullOrEmpty(cuenta) && cuenta.length() > 0) {
            this.cuenta = cuenta;
        } else {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                throw e;
            }
        }
    }

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) throws Exception {
        try {
            Float.parseFloat(monto);
            if (monto.equals("0")) {
                try {
                    throw new NullPointerException();
                } catch (NullPointerException e) {
                    throw e;
                }
            } else {
                this.monto = monto;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        if (moneda.contains("CUP") || moneda.contains("CUC") || moneda.contains("USD") || moneda.contains("MLC")) {
            this.moneda = moneda;
        } else {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                throw e;
            }
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

    public int getMes() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        int month = cal.get(2);
        return month;
    }

    public int getAnno() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        int year = cal.get(1);
        return year;
    }

    public boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
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
        FieldType cqi3wj0jbl = FieldType.DATA;
        cuenta.setTipo(cqi3wj0jbl);
        camposList.add(cuenta);
        FieldSchema monto = new FieldSchema();
        monto.setNombre("monto");
        monto.setTipo(cqi3wj0jbl);
        camposList.add(monto);
        FieldSchema moneda = new FieldSchema();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        FieldSchema servicio = new FieldSchema();
        servicio.setNombre("servicio");
        servicio.setTipo(cqi3wj0jbl);
        camposList.add(servicio);
        FieldSchema fecha = new FieldSchema();
        fecha.setNombre("fecha");
        fecha.setTipo(cqi3wj0jbl);
        camposList.add(fecha);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
