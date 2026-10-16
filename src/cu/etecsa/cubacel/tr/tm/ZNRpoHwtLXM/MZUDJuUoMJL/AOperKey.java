package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.cQi3wj0jBL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.z9CJ2fIAs7;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DatabaseTable
public class AOperKey implements ITMDataDatabase {

    @DatabaseField
    public Date authDate;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    public boolean isAuth;

    @DatabaseField
    public Nl0yptXmjQ operacion;

    @DatabaseField
    public String pin;

    public Nl0yptXmjQ getOperacion() {
        return this.operacion;
    }

    public void setOperacion(Nl0yptXmjQ operacion) {
        this.operacion = operacion;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isAuth() {
        return this.isAuth;
    }

    public void setAuth(boolean auth) {
        this.isAuth = auth;
    }

    public Date getAuthDate() {
        return this.authDate;
    }

    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
    public gwHFUMMDRu getMetadata() {
        gwHFUMMDRu metadata = new gwHFUMMDRu();
        metadata.setTabla_name("AOperKey");
        List<z9CJ2fIAs7> camposList = new ArrayList<>();
        z9CJ2fIAs7 id = new z9CJ2fIAs7();
        id.setNombre("id");
        id.setTipo(cQi3wj0jBL.PK);
        camposList.add(id);
        z9CJ2fIAs7 data = new z9CJ2fIAs7();
        data.setNombre("operacion");
        cQi3wj0jBL cqi3wj0jbl = cQi3wj0jBL.DATA;
        data.setTipo(cqi3wj0jbl);
        camposList.add(data);
        z9CJ2fIAs7 pin = new z9CJ2fIAs7();
        pin.setNombre("pin");
        pin.setTipo(cqi3wj0jbl);
        camposList.add(pin);
        metadata.setCamposSquemas(camposList);
        return metadata;
    }
}
