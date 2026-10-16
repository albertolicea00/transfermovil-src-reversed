package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.KA1Vl8CZhLC.gwHFUMMDRu;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xNWgXsOsGx {
    public int cantidadTablasProcesadas = 0;
    public Context context;
    public List<DKCSeesA6l> dataJsonList;
    public V7zVJ66kDf dataScheme;
    public List<gwHFUMMDRu> schemeList;

    public xNWgXsOsGx(Context context) {
        this.context = context;
    }

    public V7zVJ66kDf getDataScheme() {
        this.dataScheme = new V7zVJ66kDf();
        this.schemeList = new ArrayList();
        this.dataJsonList = new ArrayList();
        List<Client> clientList = unYp8VQThY.getInstance().getAllClientLists();
        extractData("Client", clientList);
        List<CuentaBanco> cuentaBancoList = unYp8VQThY.getInstance().getCuentasLists();
        extractData("CuentaBanco", cuentaBancoList);
        List<Factura> facturaList = unYp8VQThY.getInstance().getAllFacurasLists();
        extractData("Factura", facturaList);
        List<MCBank> mcBankList = unYp8VQThY.getInstance().getAllMCBankLists();
        extractData("MCBank", mcBankList);
        List<TarjetaPropia> tarjetaPropiaList = unYp8VQThY.getInstance().getAllPropiaLists();
        extractData("TarjetaPropia", tarjetaPropiaList);
        List<TeflMovil> teflMovilList = unYp8VQThY.getInstance().getAllMovilLists();
        extractData("TeflMovil", teflMovilList);
        List<Nauta> nuataList = unYp8VQThY.getInstance().getAllNautaLists();
        extractData("Nauta", nuataList);
        List<Pin> pinList = unYp8VQThY.getInstance().getAllPinLists();
        extractData("Pin", pinList);
        List<RecordSMS> recordSMSList = unYp8VQThY.getInstance().getAllRecordLists();
        extractData("RecordSMS", recordSMSList);
        List<ServicioPublico> servicioPublicosList = unYp8VQThY.getInstance().getAllServicioPublicoLists();
        extractData("ServicioPublico", servicioPublicosList);
        List<TelfFijo> telfFijoList = unYp8VQThY.getInstance().getAllFijoLists();
        extractData("TelfFijo", telfFijoList);
        List<TCTicket> ticketList = unYp8VQThY.getInstance().getAllTicketLists();
        extractData("TCTicket", ticketList);
        List<AOperKey> operKeyList = unYp8VQThY.getInstance().getAllOperKeysLists();
        extractData("AOperKey", operKeyList);
        this.dataScheme.setVersion_apk(this.context.getString(R.string.version_transfermovil));
        try {
            this.dataScheme.setMovil(unYp8VQThY.getInstance().getAppConfigLists().get(0).getPhone());
        } catch (Exception e) {
            this.dataScheme.setMovil("none");
        }
        this.dataScheme.setCantidad_tablas(this.cantidadTablasProcesadas + 1);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = formatter.format(new Date());
        this.dataScheme.setFecha_exp(date);
        this.dataScheme.setScheme(this.schemeList);
        this.dataScheme.setDatos(this.dataJsonList);
        return this.dataScheme;
    }

    public void extractData(String tableName, List<? extends ITMDataDatabase> list) {
        if (list != null && list.size() > 0) {
            try {
                this.cantidadTablasProcesadas++;
                gwHFUMMDRu scheme = list.get(0).getMetadata();
                DKCSeesA6l dataBDEntity = new DKCSeesA6l();
                dataBDEntity.setTabla(tableName);
                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                String dataJSON = gson.toJson(list);
                dataBDEntity.setDataJSON(dataJSON);
                this.schemeList.add(scheme);
                this.dataJsonList.add(dataBDEntity);
            } catch (Exception e) {
            }
        }
    }
}
