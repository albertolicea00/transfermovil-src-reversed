package cu.etecsa.transfermovil.data;

import android.content.Context;
import android.util.Log;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.core.enums.AgentSource;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.core.enums.Currency;
import cu.etecsa.transfermovil.core.enums.OperationType;
import cu.etecsa.transfermovil.data.entity.*;
import cu.etecsa.transfermovil.stats.TransactionStatsModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY
 * @fingerprint Singleton DAO facade wrapping TransferMobilDatabaseOpenHelper.
 *              Provides CRUD + query methods for all 26 entity types.
 *              Lazy-initialized via init(Context), accessed via getInstance().
 */
public class DatabaseHelper {

    private static DatabaseHelper instance;
    private TransferMobilDatabaseOpenHelper helper;

    public static void init(Context ctx) {
        if (instance == null) {
            instance = new DatabaseHelper(ctx);
        }
    }

    public static DatabaseHelper getInstance() {
        return instance;
    }

    private DatabaseHelper(Context ctx) {
        this.helper = new TransferMobilDatabaseOpenHelper(ctx);
    }

    public TransferMobilDatabaseOpenHelper getHelper() {
        return this.helper;
    }

    // ========== SmsRecord queries ==========

    public List<SmsRecord> getAllRecordListsFilter(String moneda, String servicio) {
        QueryBuilder<SmsRecord, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = queryBuilder.where();
            where.eq("moneda", moneda);
            where.and();
            where.eq("servicio", servicio);
            PreparedQuery<SmsRecord> preparedQuery = queryBuilder.orderBy("fecha", true).prepare();
            return getHelper().getRecordSMSListDao().query(preparedQuery);
        } catch (Exception e) {
            return null;
        }
    }

    public List<SmsRecord> getAllRecordLists() {
        try {
            return getHelper().getRecordSMSListDao().queryBuilder().orderBy("fecha", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SmsRecord> getAllRecordListsFilter(String moneda, String servicio, AgentSource tipo_servicio) {
        QueryBuilder<SmsRecord, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = queryBuilder.where();
            where.eq("moneda", moneda);
            where.and();
            where.eq("servicio", servicio);
            where.and();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            PreparedQuery<SmsRecord> preparedQuery = queryBuilder.orderBy("fecha", true).prepare();
            return getHelper().getRecordSMSListDao().query(preparedQuery);
        } catch (Exception e) {
            return null;
        }
    }

    public List<SmsRecord> getAllRecordLists(AgentSource tipo_servicio) {
        List<SmsRecord> aList = null;
        QueryBuilder<SmsRecord, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            PreparedQuery<SmsRecord> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
            aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            if (aList.size() == 0) {
                where.eq("tipo_servicio", null);
                where.and();
                where.eq("mostrar", true);
                queryBuilder.orderBy("fecha", false).prepare();
                return getHelper().getRecordSMSListDao().query(preparedQuery);
            }
            return aList;
        } catch (Exception e) {
            Log.i("a", e.getMessage());
            return aList;
        }
    }

    public Date getMaxDateRecordLists(AgentSource tipo_servicio) throws ParseException {
        Date ultima_fecha = null;
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw(
                    "select max(fecha) from recordsms where tipo_servicio = '" + tipo_servicio.name() + "'  and mostrar = 1", new String[0]);
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String[] a = rawResults.getFirstResult();
                ultima_fecha = formatter.parse(a[0].substring(0, 10));
            } catch (Exception ex) {
                Log.i("a", ex.getMessage());
            }
            rawResults.close();
        } catch (SQLException e) {
            Log.i("error", e.getMessage());
        }
        return ultima_fecha;
    }

    public List<SmsRecord> getRecordSMSBetweenDates(AgentSource tipo_servicio, int mes, int anno) {
        List<SmsRecord> aList = null;
        QueryBuilder<SmsRecord, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicioString = anno + "-" + mes + "-01";
            Date fechainicio = formatter.parse(fechaInicioString);
            Calendar c = Calendar.getInstance();
            c.setTime(fechainicio);
            int diaFindeMes = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            String fechaFinString = anno + "-" + mes + "-" + diaFindeMes;
            Date fechafin = formatter.parse(fechaFinString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechafin);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date fechafin2 = cal.getTime();
            where.and();
            where.and(where.ge("fecha", fechainicio), where.le("fecha", fechafin2));
            PreparedQuery<SmsRecord> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
            aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            if (aList.size() == 0) {
                where.and();
                where.isNull("tipo_servicio");
                where.and();
                where.eq("mostrar", true);
                queryBuilder.orderBy("fecha", false).prepare();
                aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            }
            return aList;
        } catch (Exception e) {
            Log.i("a", e.getMessage());
            return aList;
        }
    }

    public List<SmsRecord> getRecordSMSBetweenDates(AgentSource tipo_servicio, String servicio, String moneda, int mes, int anno) {
        List<SmsRecord> aList = null;
        QueryBuilder<SmsRecord, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            where.and();
            where.eq("servicio", servicio);
            where.and();
            where.eq("moneda", moneda);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicioString = anno + "-" + mes + "-01";
            Date fechainicio = formatter.parse(fechaInicioString);
            Calendar c = Calendar.getInstance();
            c.setTime(fechainicio);
            int diaFindeMes = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            String fechaFinString = anno + "-" + mes + "-" + diaFindeMes;
            Date fechafin = formatter.parse(fechaFinString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechafin);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date fechafin2 = cal.getTime();
            where.and();
            where.between("fecha", fechainicio, fechafin2);
            PreparedQuery<SmsRecord> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
            aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            if (aList.size() == 0) {
                where.and();
                where.isNull("tipo_servicio");
                where.and();
                where.eq("mostrar", true);
                queryBuilder.orderBy("fecha", false).prepare();
                aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            }
            return aList;
        } catch (Exception e) {
            Log.i("a", e.getMessage());
            return aList;
        }
    }

    public List<TransactionStatsModel> getResumenRecordLists() {
        List<TransactionStatsModel> resumen = new ArrayList<>();
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw(
                    "select servicio, moneda,sum(monto), count(id) from recordsms group by servicio, moneda order by servicio, moneda", new String[0]);
            for (String[] resultArray : rawResults) {
                TransactionStatsModel item = new TransactionStatsModel();
                item.setServicio(resultArray[0]);
                item.setMoneda(resultArray[1]);
                item.setMonto(resultArray[2]);
                item.setCantidad(resultArray[3]);
                resumen.add(item);
            }
            rawResults.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumen;
    }

    // ========== Get-all lists ==========

    public List<AgentService> getAllAgentServiceLists() {
        try { return getHelper().getAgentServiceListDao().queryForAll(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<MiBoletoService> getAllMiBoletoServiceLists() {
        try { return getHelper().getMiBoletoServiceListDao().queryForAll(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<AppConfig> getAllAppConfigLists() {
        try { return getHelper().getAppConfigListDao().queryForAll(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<BankService> getAllBancoServiceLists() {
        try { return getHelper().getBancoServiceListDao().queryForAll(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<AppConfig> getAppConfigLists() {
        try { return getHelper().getAppConfigListDao().queryForAll(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<Client> getAllClientLists() {
        try { return getHelper().getClientListDao().queryBuilder().orderBy("name", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<PinEntry> getAllPinLists() {
        try { return getHelper().getPinListDao().queryBuilder().orderBy("pin", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<MobilePhone> getAllMovilLists() {
        try { return getHelper().getMovilesListDao().queryBuilder().orderBy("number", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<LandlinePhone> getAllFijoLists() {
        try { return getHelper().getFijosListDao().queryBuilder().orderBy("number", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<NautaAccount> getAllNautaLists() {
        try { return getHelper().getNautasListDao().queryBuilder().orderBy("cuenta", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<Invoice> getAllFacurasLists() {
        try { return getHelper().getFacturasListDao().queryBuilder().orderBy("tipo_factura", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<BankAccountCard> getCuentasLists() {
        try { return getHelper().getcuentasBancoListDao().queryBuilder().orderBy("descripcion", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<PublicService> getAllServicioPublicoLists() {
        try { return getHelper().getServiciosPublicosListDao().queryBuilder().orderBy("valor", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<MobileCardBank> getAllMCBankLists() {
        try { return getHelper().getMCBankListDao().queryBuilder().orderBy("agencia", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TicketServiceAccount> getAllPropiaLists() {
        try { return getHelper().getPropiaListDao().queryBuilder().orderBy("serie", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<SmsPromotion> getAllPromoSMSLists() {
        try {
            QueryBuilder<SmsPromotion, Integer> queryBuilder = getHelper().getPromosSMSListDao().queryBuilder();
            queryBuilder.where().eq("habilitado", true);
            PreparedQuery<SmsPromotion> preparedQuery = queryBuilder.orderBy("fecha_inicio", true).prepare();
            return getHelper().getPromosSMSListDao().query(preparedQuery);
        } catch (Exception e) { e.printStackTrace(); return null; }
    }

    public List<Province> getAllProvinciasLists() {
        try { return getHelper().getProvinciasListDao().queryBuilder().orderBy("cod_provincia", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<Municipality> getAllMunipiosLists(String cod_provincia) {
        QueryBuilder<Municipality, Integer> queryBuilder = getHelper().getMunicipiosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cod_provincia", cod_provincia);
            PreparedQuery<Municipality> preparedQuery = queryBuilder.orderBy("cod_municipio", true).prepare();
            return getHelper().getMunicipiosListDao().query(preparedQuery);
        } catch (Exception e) { Log.e("error", e.getMessage()); return null; }
    }

    public List<Municipality> getAllMunicipiosLists() {
        try { return getHelper().getMunicipiosListDao().queryBuilder().orderBy("cod_municipio", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TaxRecord> getAllTributosLists() {
        try { return getHelper().getTributosListDao().queryBuilder().orderBy("cod_tributo", true).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TransportTicket> getAllTicketLists() {
        try {
            return getHelper().getTcTicketsListDao().queryBuilder()
                    .orderBy("fecha", false).where().eq("deleted", false).query();
        } catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TicketPurchase> getAllMiBoletoCompraLists() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date fechaActualSinHora = calendar.getTime();
            return getHelper().getCompraBoletoListDao().queryBuilder()
                    .orderBy("fecha_compra", false).where()
                    .eq("consumido", false).and().ge("fecha_vencimiento", fechaActualSinHora).query();
        } catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<AuthSession> getAllOperKeysLists() {
        try { return getHelper().getAOperKeyListDao().queryBuilder().query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TicketOffer> getAllOfertasmiBoleto() {
        try { return getHelper().getOfertasBoletoListDao().queryBuilder().query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<TicketOffer> getAllOfertasmiBoletoOrderBy() {
        try { return getHelper().getOfertasBoletoListDao().queryBuilder().orderBy("id_control", false).query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<CubacelPlan> getAllPaquetesLists() {
        try { return getHelper().getCompraPaquetesListDao().queryBuilder().query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    // ========== Get by ID ==========

    public AppConfig getAppConfigListWithId(int id) {
        try { return getHelper().getAppConfigListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public Client getClientListWithId(int id) {
        try { return getHelper().getClientListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public PinEntry getPinListWithId(int id) {
        try { return getHelper().getPinListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public MobilePhone getMovilListWithId(int id) {
        try { return getHelper().getMovilesListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public LandlinePhone getFijoListWithId(int id) {
        try { return getHelper().getFijosListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public NautaAccount getNautaListWithId(int id) {
        try { return getHelper().getNautasListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public Invoice getFacturaListWithId(int id) {
        try { return getHelper().getFacturasListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public PublicService getServicioListWithId(int id) {
        try { return getHelper().getServiciosPublicosListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public BankAccountCard getCuentaListWithId(int id) {
        try { return getHelper().getcuentasBancoListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public MobileCardBank getMCBank(int id) {
        try { return getHelper().getMCBankListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public TicketServiceAccount getPropiaListWithID(int id) {
        try { return getHelper().getPropiaListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public TransportTicket getTCTicketListWithID(int id) {
        try { return getHelper().getTcTicketsListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public TicketPurchase getBoletoListWithID(int id) {
        try { return getHelper().getCompraBoletoListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public AuthSession getAOperKey(OperationType oper) {
        QueryBuilder<AuthSession, Integer> queryBuilder = getHelper().getAOperKeyListDao().queryBuilder();
        try {
            queryBuilder.where().eq("operacion", oper);
            PreparedQuery<AuthSession> preparedQuery = queryBuilder.orderBy("id", true).prepare();
            List<AuthSession> aList = getHelper().getAOperKeyListDao().query(preparedQuery);
            if (aList == null || aList.size() <= 0) return null;
            return aList.get(0);
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    // ========== Delete single ==========

    public boolean deleteRecordSMSService(SmsRecord rsms) {
        try { getHelper().getRecordSMSListDao().delete(rsms); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAppConfig(AppConfig appConfig) {
        try { getHelper().getAppConfigListDao().delete(appConfig); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAgentService(AgentService agents) {
        try { getHelper().getAgentServiceListDao().delete(agents); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteBancoService(BankService agents) {
        try { getHelper().getBancoServiceListDao().delete(agents); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllAgentService() {
        try { getHelper().getAgentServiceListDao().delete(getAllAgentServiceLists()); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllCuentasBanco() {
        try { getHelper().getcuentasBancoListDao().delete(getCuentasLists()); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllBancoService() {
        try { getHelper().getBancoServiceListDao().delete(getAllBancoServiceLists()); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllServicioPublicoService() {
        try { getHelper().getServiciosPublicosListDao().delete(getAllServicioPublicoLists()); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllTCTTicket() {
        try { getHelper().getTcTicketsListDao().delete(getAllTicketLists()); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteClient(Client client) {
        try { getHelper().getClientListDao().delete(client); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deletePin(PinEntry pin) {
        try { getHelper().getPinListDao().delete(pin); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteFijo(LandlinePhone fijo) {
        try { getHelper().getFijosListDao().delete(fijo); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteMovil(MobilePhone movil) {
        try { getHelper().getMovilesListDao().delete(movil); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteNauta(NautaAccount nauta) {
        try { getHelper().getNautasListDao().delete(nauta); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteFactura(Invoice factura) {
        try { getHelper().getFacturasListDao().delete(factura); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteServicio(PublicService servicioPublico) {
        try { getHelper().getServiciosPublicosListDao().delete(servicioPublico); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deletePromoSMS(SmsPromotion promoSMS) {
        try { getHelper().getPromosSMSListDao().delete(promoSMS); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteCuentaBanco(BankAccountCard cuenta) {
        try { getHelper().getcuentasBancoListDao().delete(cuenta); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteMCBank(MobileCardBank cuenta) {
        try { getHelper().getMCBankListDao().delete(cuenta); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deletePropia(TicketServiceAccount cuenta) {
        try { getHelper().getPropiaListDao().delete(cuenta); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteTCTicket(TransportTicket ticket) {
        try { getHelper().getTcTicketsListDao().delete(ticket); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAOperKey(AuthSession key) {
        try { getHelper().getAOperKeyListDao().delete(key); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteOfertasWithIdTmLess(long id_tm) {
        try {
            List<TicketOffer> todasLasOfertas = getHelper().getOfertasBoletoListDao().queryForAll();
            List<TicketOffer> ofertasAEliminar = new ArrayList<>();
            for (TicketOffer oferta : todasLasOfertas) {
                if (oferta.getId_control() < id_tm) {
                    ofertasAEliminar.add(oferta);
                }
            }
            for (TicketOffer oferta : ofertasAEliminar) {
                getHelper().getOfertasBoletoListDao().delete(oferta);
            }
            Log.i("Database", "Borradas " + ofertasAEliminar.size() + " ofertas con ID_TM menor a " + id_tm);
            return true;
        } catch (SQLException e) {
            Log.e("Database", "Error borrando ofertas: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllOfertasMiBoleto() {
        try { getHelper().getOfertasBoletoListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteAllPaquetes() {
        try { getHelper().getCompraPaquetesListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // ========== Add (create) ==========

    public void addRecordSMS(SmsRecord v) {
        try { getHelper().getRecordSMSListDao().create(v); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addAppConfig(AppConfig app) {
        try { getHelper().getAppConfigListDao().create(app); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addAgentService(AgentService a) {
        try { getHelper().getAgentServiceListDao().create(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addMiBoletoService(MiBoletoService a) {
        try { getHelper().getMiBoletoServiceListDao().create(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addBancoService(BankService a) {
        try { getHelper().getBancoServiceListDao().create(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addClient(Client c) {
        try { getHelper().getClientListDao().create(c); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public int addClientID(Client c) {
        try { return getHelper().getClientListDao().create(c); }
        catch (SQLException e) { return 0; }
    }

    public int addClientGetID(Client c) {
        try {
            Client cl = getHelper().getClientListDao().createIfNotExists(c);
            return cl.getId();
        } catch (SQLException e) { e.printStackTrace(); return -1; }
    }

    public void addPin(PinEntry p) {
        try { getHelper().getPinListDao().create(p); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addTelfMovil(MobilePhone m) {
        try { getHelper().getMovilesListDao().create(m); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addTelfFijo(LandlinePhone f) {
        try { getHelper().getFijosListDao().create(f); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addNauta(NautaAccount n) {
        try { getHelper().getNautasListDao().create(n); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addFactura(Invoice f) {
        try { getHelper().getFacturasListDao().create(f); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addServicioPublico(PublicService s) {
        try { getHelper().getServiciosPublicosListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addPromoSMS(SmsPromotion s) {
        try { getHelper().getPromosSMSListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addCuentaBanco(BankAccountCard s) {
        try { getHelper().getcuentasBancoListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addMCBank(MobileCardBank s) {
        try { getHelper().getMCBankListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addPropia(TicketServiceAccount s) {
        try { getHelper().getPropiaListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addProvincia(Province s) {
        try { getHelper().getProvinciasListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addMunicipio(Municipality s) {
        try { getHelper().getMunicipiosListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addTributo(TaxRecord s) {
        try { getHelper().getTributosListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addTCTicket(TransportTicket s) {
        try { getHelper().getTcTicketsListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addAOperKey(AuthSession s) {
        try { getHelper().getAOperKeyListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addOfertasMiBoleto(TicketOffer s) {
        try { getHelper().getOfertasBoletoListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addCompraMiBoleto(TicketPurchase s) {
        try { getHelper().getCompraBoletoListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addMonedasWallet(WalletCurrency s) {
        try { getHelper().getMonedasWalletListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void addPaquetes(CubacelPlan s) {
        try { getHelper().getCompraPaquetesListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    // ========== Update ==========

    public int updateRecordSMS(SmsRecord v) {
        try {
            UpdateBuilder<SmsRecord, Integer> updateBuilder = getHelper().getRecordSMSListDao().updateBuilder();
            updateBuilder.where().eq("id", v.getId());
            updateBuilder.updateColumnValue("mostrar", false);
            return updateBuilder.update();
        } catch (SQLException e) { e.printStackTrace(); return 0; }
    }

    public void updateAppConfig(AppConfig app) {
        try { getHelper().getAppConfigListDao().update(app); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateAgentService(AgentService a) {
        try { getHelper().getAgentServiceListDao().update(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateMiBoletoService(MiBoletoService a) {
        try { getHelper().getMiBoletoServiceListDao().update(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateBancoService(BankService a) {
        try { getHelper().getBancoServiceListDao().update(a); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateClient(Client c) {
        try { getHelper().getClientListDao().update(c); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updatePin(PinEntry p) {
        try { getHelper().getPinListDao().update(p); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateMovil(MobilePhone p) {
        try { getHelper().getMovilesListDao().update(p); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateFijo(LandlinePhone p) {
        try { getHelper().getFijosListDao().update(p); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateNauta(NautaAccount p) {
        try { getHelper().getNautasListDao().update(p); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateFactura(Invoice f) {
        try { getHelper().getFacturasListDao().update(f); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateServicioPublico(PublicService s) {
        try { getHelper().getServiciosPublicosListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updatePromoSMS(SmsPromotion s) {
        try { getHelper().getPromosSMSListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateCuentaBanco(BankAccountCard s) {
        try { getHelper().getcuentasBancoListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateMCBank(MobileCardBank s) {
        try { getHelper().getMCBankListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updatePropia(TicketServiceAccount s) {
        try { getHelper().getPropiaListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateProvincia(Province s) {
        try { getHelper().getProvinciasListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateMunicipio(Municipality s) {
        try { getHelper().getMunicipiosListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateTributo(TaxRecord s) {
        try { getHelper().getTributosListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateTCTicket(TransportTicket s) {
        try { getHelper().getTcTicketsListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateCompraMiboleto(TicketPurchase s) {
        try { getHelper().getCompraBoletoListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateOfertasBoleto(TicketOffer s) {
        try { getHelper().getOfertasBoletoListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateAOperKey(AuthSession s) {
        try { getHelper().getAOperKeyListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    // ========== Lookup queries ==========

    public List<AgentService> getAgentServiceWithCode(String code) {
        QueryBuilder<AgentService, Integer> qb = getHelper().getAgentServiceListDao().queryBuilder();
        try {
            qb.where().eq("code", code);
            return getHelper().getAgentServiceListDao().query(qb.prepare());
        } catch (Exception e) { return null; }
    }

    public List<BankService> getBancoServiceWithCode(String code) {
        QueryBuilder<BankService, Integer> qb = getHelper().getBancoServiceListDao().queryBuilder();
        try {
            qb.where().eq("code", code);
            return getHelper().getBancoServiceListDao().query(qb.prepare());
        } catch (Exception e) { return null; }
    }

    public List<SmsRecord> getRecordSMSwithCuenta(String cuenta) {
        QueryBuilder<SmsRecord, Integer> qb = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            qb.where().eq("cuenta", cuenta);
            return getHelper().getRecordSMSListDao().query(qb.prepare());
        } catch (Exception e) { return null; }
    }

    public SmsPromotion getPromoSMS(String mensaje) {
        SmsPromotion sms = null;
        QueryBuilder<SmsPromotion, Integer> qb = getHelper().getPromosSMSListDao().queryBuilder();
        try {
            qb.where().like("mensaje", "%" + mensaje + "%");
            List<SmsPromotion> aList = getHelper().getPromosSMSListDao().query(qb.prepare());
            if (aList.size() > 0) {
                Date today = new Date();
                for (SmsPromotion promoSMS : aList) {
                    if (promoSMS.getFecha_fin().after(today)) {
                        sms = promoSMS;
                    }
                }
            }
            return sms;
        } catch (Exception e) { return sms; }
    }

    public List<SmsRecord> getRecordSMSwithIDTransaction(String id) {
        QueryBuilder<SmsRecord, Integer> qb = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            qb.where().eq("idTransaccion", id);
            return getHelper().getRecordSMSListDao().query(qb.prepare());
        } catch (Exception e) { return null; }
    }

    public List<SmsRecord> getRecordSMSwithIDTransactionByType(String id, AgentSource modulosEstadisticosEntity) {
        QueryBuilder<SmsRecord, Integer> qb = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<SmsRecord, Integer> where = qb.where();
            where.eq("idTransaccion", id);
            where.and();
            where.eq("tipo_servicio", modulosEstadisticosEntity);
            PreparedQuery<SmsRecord> preparedQuery = qb.orderBy("fecha", true).prepare();
            return getHelper().getRecordSMSListDao().query(preparedQuery);
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    public List<Client> getClientListsWithPhoneNumber(String telef) {
        QueryBuilder<Client, Integer> qb = getHelper().getClientListDao().queryBuilder();
        try { qb.where().eq("phone", telef); return getHelper().getClientListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Client> getClientListsWithName(String name) {
        QueryBuilder<Client, Integer> qb = getHelper().getClientListDao().queryBuilder();
        try { qb.where().eq("name", name); return getHelper().getClientListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PinEntry> getPinListsWithNumPin(String pin) {
        QueryBuilder<PinEntry, Integer> qb = getHelper().getPinListDao().queryBuilder();
        try { qb.where().eq("pin", pin); return getHelper().getPinListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<LandlinePhone> getFijoListsWithPhoneNumber(String telef) {
        QueryBuilder<LandlinePhone, Integer> qb = getHelper().getFijosListDao().queryBuilder();
        try { qb.where().eq("number", telef); return getHelper().getFijosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<LandlinePhone> getFijoListsWithCliente(int id_cliente) {
        QueryBuilder<LandlinePhone, Integer> qb = getHelper().getFijosListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getFijosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobilePhone> getMovilListsWithPhoneNumber(String telef) {
        QueryBuilder<MobilePhone, Integer> qb = getHelper().getMovilesListDao().queryBuilder();
        try { qb.where().eq("number", telef); return getHelper().getMovilesListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobilePhone> getMovilListsWithCliente(int id_cliente) {
        QueryBuilder<MobilePhone, Integer> qb = getHelper().getMovilesListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getMovilesListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<NautaAccount> getNautaListsWithAccount(String cuenta, int tipo) {
        QueryBuilder<NautaAccount, Integer> qb = getHelper().getNautasListDao().queryBuilder();
        try { qb.where().eq("cuenta", cuenta).and().eq("tipo_cuenta", tipo); return getHelper().getNautasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Invoice> getFacturasListsWithCliente(int id_cliente) {
        QueryBuilder<Invoice, Integer> qb = getHelper().getFacturasListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getFacturasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<BankAccountCard> getCuentasListsWithCliente(int id_cliente) {
        QueryBuilder<BankAccountCard, Integer> qb = getHelper().getcuentasBancoListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getcuentasBancoListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PublicService> getServiciosPublicosListsWithCliente(int id_cliente) {
        QueryBuilder<PublicService, Integer> qb = getHelper().getServiciosPublicosListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getServiciosPublicosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Invoice> getFacturasListsTipoCuenta(int tipo_factura) {
        QueryBuilder<Invoice, Integer> qb = getHelper().getFacturasListDao().queryBuilder();
        try { qb.where().eq("tipo_factura", tipo_factura); return getHelper().getFacturasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PublicService> getFacturasListsTipoServicio(int tipo_servicio) {
        QueryBuilder<PublicService, Integer> qb = getHelper().getServiciosPublicosListDao().queryBuilder();
        try { qb.where().eq("tipo_servicio", tipo_servicio); return getHelper().getServiciosPublicosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<NautaAccount> getNautaListsWithAccount(String cuenta) {
        QueryBuilder<NautaAccount, Integer> qb = getHelper().getNautasListDao().queryBuilder();
        try { qb.where().eq("cuenta", cuenta); return getHelper().getNautasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Invoice> getFacturaListsWithFactura(String factura) {
        QueryBuilder<Invoice, Integer> qb = getHelper().getFacturasListDao().queryBuilder();
        try { qb.where().eq("factura", factura); return getHelper().getFacturasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PublicService> getServicioPublicoListsWithValor(String servicio) {
        QueryBuilder<PublicService, Integer> qb = getHelper().getServiciosPublicosListDao().queryBuilder();
        try { qb.where().eq("valor", servicio); return getHelper().getServiciosPublicosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<NautaAccount> getNautaListsWithClient(int id_cliente) {
        QueryBuilder<NautaAccount, Integer> qb = getHelper().getNautasListDao().queryBuilder();
        try { qb.where().eq("id_client", id_cliente); return getHelper().getNautasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TransportTicket> getTCTicketWithSerie(String serie) {
        QueryBuilder<TransportTicket, Integer> qb = getHelper().getTcTicketsListDao().queryBuilder();
        try { qb.where().eq("serie", serie); return getHelper().getTcTicketsListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobilePhone> getMovilListsWithClient(Client cliente) {
        QueryBuilder<MobilePhone, Integer> qb = getHelper().getMovilesListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getMovilesListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<LandlinePhone> getFijosListsWithClient(Client cliente) {
        QueryBuilder<LandlinePhone, Integer> qb = getHelper().getFijosListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getFijosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<NautaAccount> getNautasListsWithClient(Client cliente) {
        QueryBuilder<NautaAccount, Integer> qb = getHelper().getNautasListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getNautasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Invoice> getFacturasListsWithClient(Client cliente) {
        QueryBuilder<Invoice, Integer> qb = getHelper().getFacturasListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getFacturasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PublicService> getServicioListsWithClient(Client cliente) {
        QueryBuilder<PublicService, Integer> qb = getHelper().getServiciosPublicosListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getServiciosPublicosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TicketServiceAccount> getPropiasListsWithClient(Client cliente) {
        QueryBuilder<TicketServiceAccount, Integer> qb = getHelper().getPropiaListDao().queryBuilder();
        try { qb.where().eq("id_client", cliente.getId()); return getHelper().getPropiaListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobileCardBank> getMisCuentasAlias(String alias) {
        QueryBuilder<MobileCardBank, Integer> qb = getHelper().getMCBankListDao().queryBuilder();
        try { qb.where().eq("alias", alias); return getHelper().getMCBankListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobileCardBank> getMiCuenta(String cuenta) {
        QueryBuilder<MobileCardBank, Integer> qb = getHelper().getMCBankListDao().queryBuilder();
        try { qb.where().eq("cuenta", cuenta); return getHelper().getMCBankListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PinEntry> getPinListsWithoutDesc() {
        QueryBuilder<PinEntry, Integer> qb = getHelper().getPinListDao().queryBuilder();
        try { qb.where().eq("descripcion", ""); return getHelper().getPinListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Client> getClientListsWithoutName() {
        QueryBuilder<Client, Integer> qb = getHelper().getClientListDao().queryBuilder();
        try { qb.where().eq("name", ""); return getHelper().getClientListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<LandlinePhone> getFijosListsWithoutName() {
        QueryBuilder<LandlinePhone, Integer> qb = getHelper().getFijosListDao().queryBuilder();
        try { qb.where().eq("id_client", "0"); return getHelper().getFijosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobilePhone> getMovilListsWithoutName() {
        QueryBuilder<MobilePhone, Integer> qb = getHelper().getMovilesListDao().queryBuilder();
        try { qb.where().eq("id_client", "0"); return getHelper().getMovilesListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<NautaAccount> getNautaListsWithoutName() {
        QueryBuilder<NautaAccount, Integer> qb = getHelper().getNautasListDao().queryBuilder();
        try { qb.where().eq("id_client", "0"); return getHelper().getNautasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<Invoice> getFacturasListsWithoutName() {
        QueryBuilder<Invoice, Integer> qb = getHelper().getFacturasListDao().queryBuilder();
        try { qb.where().eq("id_client", "0"); return getHelper().getFacturasListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<PublicService> getServiciosPublicosListsWithoutName() {
        QueryBuilder<PublicService, Integer> qb = getHelper().getServiciosPublicosListDao().queryBuilder();
        try { qb.where().eq("id_client", "0"); return getHelper().getServiciosPublicosListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<BankAccountCard> getCuentaListsWithAccount(String cuenta) {
        QueryBuilder<BankAccountCard, Integer> qb = getHelper().getcuentasBancoListDao().queryBuilder();
        try { qb.where().eq("cuenta", cuenta); return getHelper().getcuentasBancoListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TicketServiceAccount> getTarjetaPropiaWithSerie(String serie) {
        QueryBuilder<TicketServiceAccount, Integer> qb = getHelper().getPropiaListDao().queryBuilder();
        try { qb.where().eq("serie", serie); return getHelper().getPropiaListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TransportTicket> getTCombustible(String serie) {
        QueryBuilder<TransportTicket, Integer> qb = getHelper().getTcTicketsListDao().queryBuilder();
        try { qb.where().eq("serie", serie); return getHelper().getTcTicketsListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TicketPurchase> getCompraBoleto(String idoferta) {
        QueryBuilder<TicketPurchase, Integer> qb = getHelper().getCompraBoletoListDao().queryBuilder();
        try { qb.where().eq("id_oferta", idoferta); return getHelper().getCompraBoletoListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<TicketOffer> getOfertasBoleto(String serie) {
        QueryBuilder<TicketOffer, Integer> qb = getHelper().getOfertasBoletoListDao().queryBuilder();
        try { qb.where().eq("serie", serie); return getHelper().getOfertasBoletoListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    // ========== Operation queries ==========

    public List<Operation> getOperacionesByType(AgentSource modulosEstadisticosEntity) {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operation, Integer> where = qb.where();
            where.eq("tipo_servicio", modulosEstadisticosEntity);
            where.and();
            where.ge("order", 0);
            return getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    public List<Operation> getOperacionesList() {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operation, Integer> where = qb.where();
            where.ge("order", 0);
            where.and();
            where.eq("activo", true);
            return getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    public List<Operation> getOperacionesListTipo(BankType tipo) {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            qb.where().eq("tipo_servicio", tipo);
            return getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    public List<Operation> getOperacionesNoActivasList() {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operation, Integer> where = qb.where();
            where.eq("order", -1);
            where.and();
            where.eq("activo", true);
            return getHelper().getoperacionesListDao().query(qb.orderBy("tipo_servicio", true).prepare());
        } catch (Exception e) { Log.i("Error", e.getMessage()); return null; }
    }

    public Operation getOperacion(BankOperationCode operacioneEnum) {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            qb.where().eq("operacion", operacioneEnum);
            List<Operation> aList = getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
            if (aList == null || aList.size() == 0) return null;
            return aList.get(0);
        } catch (Exception e) { Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage()); return null; }
    }

    public int getCountOperacion(BankOperationCode operacioneEnum) {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            qb.where().eq("operacion", operacioneEnum);
            List<Operation> aList = getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
            if (aList == null || aList.size() == 0) return 0;
            return aList.size();
        } catch (Exception e) { Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage()); return 0; }
    }

    public List<Operation> getListOperacion(BankOperationCode operacioneEnum) {
        QueryBuilder<Operation, Integer> qb = getHelper().getoperacionesListDao().queryBuilder();
        try {
            qb.where().eq("operacion", operacioneEnum);
            List<Operation> aList = getHelper().getoperacionesListDao().query(qb.orderBy("order", true).prepare());
            if (aList == null || aList.size() == 0) return null;
            return aList;
        } catch (Exception e) { Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage()); return null; }
    }

    // ========== MCBank by agency ==========

    public List<MobileCardBank> getMCBankByAgency(BankType agencyEntity) {
        QueryBuilder<MobileCardBank, Integer> qb = getHelper().getMCBankListDao().queryBuilder();
        try { qb.where().eq("agencia", agencyEntity); return getHelper().getMCBankListDao().query(qb.prepare()); }
        catch (Exception e) { return null; }
    }

    public List<MobileCardBank> getMCBankByAgencyNoMLC(BankType agencyEntity) {
        QueryBuilder<MobileCardBank, Integer> qb = getHelper().getMCBankListDao().queryBuilder();
        try {
            Where<MobileCardBank, Integer> where = qb.where();
            where.eq("agencia", agencyEntity);
            where.and();
            where.not().eq("tipo_moneda", Currency.USD);
            return getHelper().getMCBankListDao().query(qb.prepare());
        } catch (Exception e) { Log.e("ERROR", e.getMessage()); return null; }
    }

    public List<MobileCardBank> getMCBankByAgencyMLC(BankType agencyEntity) {
        QueryBuilder<MobileCardBank, Integer> qb = getHelper().getMCBankListDao().queryBuilder();
        try {
            Where<MobileCardBank, Integer> where = qb.where();
            where.eq("agencia", agencyEntity);
            where.and();
            where.eq("tipo_moneda", Currency.USD);
            return getHelper().getMCBankListDao().query(qb.prepare());
        } catch (Exception e) { Log.e("ERROR", e.getMessage()); return null; }
    }

    // ========== Operation CRUD ==========

    public void addOperacion(Operation s) {
        try { getHelper().getoperacionesListDao().create(s); }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateOperacion(Operation s) {
        try { getHelper().getoperacionesListDao().update(s); }
        catch (SQLException e) { e.printStackTrace(); Log.i("ERRORBD", e.getMessage()); }
    }

    public Operation getOperacionWithId(int id) {
        try { return getHelper().getoperacionesListDao().queryForId(id); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    // ========== WalletCurrency ==========

    public List<WalletCurrency> getMonedasWallet() {
        try { return getHelper().getMonedasWalletListDao().queryBuilder().query(); }
        catch (SQLException e) { e.printStackTrace(); return null; }
    }

    public List<WalletCurrency> getMonedasWalletSinMisCuentas() {
        QueryBuilder<WalletCurrency, Integer> qb = getHelper().getMonedasWalletListDao().queryBuilder();
        try {
            qb.where().not().eq("descripcion", "-MIS CUENTAS-");
            qb.where().eq("allowTransfer", 1);
            return getHelper().getMonedasWalletListDao().query(qb.prepare());
        } catch (Exception e) { return null; }
    }

    // ========== Bulk deletes ==========

    public boolean deleteOperacion(Operation operacion) {
        try { getHelper().getoperacionesListDao().delete(operacion); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteOperacionesAll() {
        try { getHelper().getoperacionesListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteTributosAll() {
        try { getHelper().getTributosListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteProvinciaAll() {
        try { getHelper().getProvinciasListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteMunicipiosAll() {
        try { getHelper().getMunicipiosListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean deleteMonedasWallet() {
        try { getHelper().getMonedasWalletListDao().deleteBuilder().delete(); return true; }
        catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // ========== Maintenance ==========

    public int MaxIdRecordSms() {
        int max = 0;
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw(
                    "select max(id) from recordsms", new String[0]);
            if (rawResults != null) {
                for (String[] resultArray : rawResults) {
                    String maximo = resultArray[0] != null ? resultArray[0] : "0";
                    max = Integer.parseInt(maximo);
                }
            }
            rawResults.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    public boolean MaintenanceRecordsSms() {
        int max = MaxIdRecordSms();
        if (max <= 10000) return false;
        int min = max - 10000;
        try {
            DeleteBuilder<SmsRecord, Integer> deleteBuilder = getHelper().getRecordSMSListDao().deleteBuilder();
            deleteBuilder.where().le("id", min);
            getHelper().getRecordSMSListDao().delete(deleteBuilder.prepare());
            return true;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // ========== Raw table helpers ==========

    public boolean checkIfTableExists(String tableName) {
        return getHelper().tableExists(tableName);
    }

    public boolean insertData(String t, String c, String v) {
        return getHelper().insertData(t, c, v);
    }

    public boolean checkIdentityData(String t, String c, String v) {
        return getHelper().checkIfExistDataIdentity(t, c, v);
    }
}
