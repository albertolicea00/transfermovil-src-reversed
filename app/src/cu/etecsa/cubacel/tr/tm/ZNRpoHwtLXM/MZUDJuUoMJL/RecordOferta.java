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
public class RecordOferta implements ITMDataDatabase {

    @DatabaseField
    private Date fecha;

    @DatabaseField
    private String fechaVencimiento;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String idOferta;

    @DatabaseField
    private String idTransaccion;

    @DatabaseField
    private String idTransferencia;

    @DatabaseField
    private String moneda;

    @DatabaseField
    private String monto;

    @DatabaseField
    private Boolean mostrar;

    @DatabaseField
    private String tipoOferta;

    @DatabaseField(canBeNull = true, defaultValue = "Ofertas")
    private KYTjPlWScT tipo_servicio;

    @DatabaseField
    private String token;

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
            return;
        }
        throw new NullPointerException("idTransaccion no puede ser nulo o vacío");
    }

    public String getIdTransferencia() {
        return this.idTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        if (!isNullOrEmpty(idTransferencia) && idTransferencia.length() > 0) {
            this.idTransferencia = idTransferencia;
            return;
        }
        throw new NullPointerException("idTransaccion no puede ser nulo o vacío");
    }

    public String getIdOferta() {
        return this.idOferta;
    }

    public void setIdOferta(String idOferta) {
        if (!isNullOrEmpty(idOferta) && idOferta.length() > 0) {
            this.idOferta = idOferta;
            return;
        }
        throw new NullPointerException("idOferta no puede ser nulo o vacío");
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        if (!isNullOrEmpty(token) && token.length() > 0) {
            this.token = token;
            return;
        }
        throw new NullPointerException("token no puede ser nulo o vacío");
    }

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) {
        try {
            Float.parseFloat(monto);
            if (monto.equals("0")) {
                throw new NullPointerException("El monto no puede ser cero");
            }
            this.monto = monto;
        } catch (Exception e) {
            throw new NumberFormatException("Formato de monto inválido");
        }
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda) {
        if (moneda.contains("CUP") || moneda.contains("CUC") || moneda.contains("USD") || moneda.contains("MLC")) {
            this.moneda = moneda;
            return;
        }
        throw new IllegalArgumentException("Moneda no válida");
    }

    public String getTipoOferta() {
        return this.tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        if (!isNullOrEmpty(tipoOferta) && (tipoOferta.equals("COMPRA") || tipoOferta.equals("ACTUALIZACION") || tipoOferta.equals("CONSULTA"))) {
            this.tipoOferta = tipoOferta;
            return;
        }
        throw new IllegalArgumentException("Tipo de oferta no válido");
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

    public int getMes() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        return cal.get(2);
    }

    public int getAnno() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fecha);
        return cal.get(1);
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("RecordOferta");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 idTransaccion = new z9CJ2fIAs7();
        idTransaccion.setNombre("idTransaccion");
        idTransaccion.setTipo(cQi3wj0jBL.IDENTITY);
        camposList.add(idTransaccion);
        z9CJ2fIAs7 idOferta = new z9CJ2fIAs7();
        idOferta.setNombre("idOferta");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        idOferta.setTipo(cqi3wj0jbl);
        camposList.add(idOferta);
        z9CJ2fIAs7 token = new z9CJ2fIAs7();
        token.setNombre("token");
        token.setTipo(cqi3wj0jbl);
        camposList.add(token);
        z9CJ2fIAs7 monto = new z9CJ2fIAs7();
        monto.setNombre("monto");
        monto.setTipo(cqi3wj0jbl);
        camposList.add(monto);
        z9CJ2fIAs7 moneda = new z9CJ2fIAs7();
        moneda.setNombre("moneda");
        moneda.setTipo(cqi3wj0jbl);
        camposList.add(moneda);
        z9CJ2fIAs7 tipoOferta = new z9CJ2fIAs7();
        tipoOferta.setNombre("tipoOferta");
        tipoOferta.setTipo(cqi3wj0jbl);
        camposList.add(tipoOferta);
        z9CJ2fIAs7 fecha = new z9CJ2fIAs7();
        fecha.setNombre("fecha");
        fecha.setTipo(cqi3wj0jbl);
        camposList.add(fecha);
        z9CJ2fIAs7 fechaVenc = new z9CJ2fIAs7();
        fechaVenc.setNombre("fechaVencimiento");
        fechaVenc.setTipo(cqi3wj0jbl);
        camposList.add(fechaVenc);
        z9CJ2fIAs7 tipoServicio = new z9CJ2fIAs7();
        tipoServicio.setNombre("tipo_servicio");
        tipoServicio.setTipo(cqi3wj0jbl);
        camposList.add(tipoServicio);
        z9CJ2fIAs7 mostrar = new z9CJ2fIAs7();
        mostrar.setNombre("mostrar");
        mostrar.setTipo(cqi3wj0jbl);
        camposList.add(mostrar);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
