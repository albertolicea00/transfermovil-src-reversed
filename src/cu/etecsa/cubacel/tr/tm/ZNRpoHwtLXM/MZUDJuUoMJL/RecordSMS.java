package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class RecordSMS implements ITMDataDatabase {

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
    private KYTjPlWScT tipo_servicio;

    public Boolean getMostrar() {
        return this.mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public KYTjPlWScT getTipo_servicio() {
        return this.tipo_servicio;
    }

    public void setTipo_servicio(KYTjPlWScT tipo_servicio) {
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
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("RecordSMS");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 idTransaccion = new z9CJ2fIAs7();
        idTransaccion.setNombre("idTransaccion");
        idTransaccion.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(idTransaccion);
        z9CJ2fIAs7 cuenta = new z9CJ2fIAs7();
        cuenta.setNombre("cuenta");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        cuenta.setTipo(cqi3wj0jbl);
        camposList.add(cuenta);
        z9CJ2fIAs7 monto = new z9CJ2fIAs7();
        monto.setNombre("monto");
        monto.setTipo(cqi3wj0jbl);
        camposList.add(monto);
        z9CJ2fIAs7 moneda = new z9CJ2fIAs7();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        z9CJ2fIAs7 servicio = new z9CJ2fIAs7();
        servicio.setNombre("servicio");
        servicio.setTipo(cqi3wj0jbl);
        camposList.add(servicio);
        z9CJ2fIAs7 fecha = new z9CJ2fIAs7();
        fecha.setNombre("fecha");
        fecha.setTipo(cqi3wj0jbl);
        camposList.add(fecha);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
