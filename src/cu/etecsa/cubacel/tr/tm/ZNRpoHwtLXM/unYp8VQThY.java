package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.qcI22KekhL;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AgentService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.BancoService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MiBoletoService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.OfertasBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Tributo;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class unYp8VQThY {
    private static unYp8VQThY instance;
    private ZqXxImD3Ix helper;

    public static void init(Context ctx) {
        if (instance == null) {
            instance = new unYp8VQThY(ctx);
        }
    }

    public static unYp8VQThY getInstance() {
        return instance;
    }

    private unYp8VQThY(Context ctx) {
        this.helper = new ZqXxImD3Ix(ctx);
    }

    public ZqXxImD3Ix getHelper() {
        return this.helper;
    }

    public List<RecordSMS> getAllRecordListsFilter(String moneda, String servicio) {
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            where.eq("moneda", moneda);
            where.and();
            where.eq("servicio", servicio);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", true).prepare();
            List<RecordSMS> aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<RecordSMS> getAllRecordLists() {
        try {
            List<RecordSMS> agLists = getHelper().getRecordSMSListDao().queryBuilder().orderBy("fecha", false).query();
            return agLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RecordSMS> getAllRecordListsFilter(String moneda, String servicio, KYTjPlWScT tipo_servicio) {
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            where.eq("moneda", moneda);
            where.and();
            where.eq("servicio", servicio);
            where.and();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", true).prepare();
            List<RecordSMS> aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<RecordSMS> getAllRecordLists(KYTjPlWScT tipo_servicio) {
        List<RecordSMS> aList = null;
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
            aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            if (aList.size() == 0) {
                where.eq("tipo_servicio", null);
                where.and();
                where.eq("mostrar", true);
                queryBuilder.orderBy("fecha", false).prepare();
                List<RecordSMS> aList2 = getHelper().getRecordSMSListDao().query(preparedQuery);
                return aList2;
            }
            return aList;
        } catch (Exception e) {
            Log.i("a", e.getMessage());
            return aList;
        }
    }

    public Date getMaxDateRecordLists(KYTjPlWScT tipo_servicio) throws ParseException {
        Date ultima_fecha = null;
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw("select max(fecha) from recordsms where tipo_servicio = '" + tipo_servicio.name() + "'  and mostrar = 1", new String[0]);
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String[] a = rawResults.getFirstResult();
                ultima_fecha = formatter.parse(a[0].substring(0, 10));
            } catch (Exception ex) {
                Log.i("a", ex.getMessage().toString());
            }
            rawResults.close();
        } catch (SQLException e) {
            Log.i("error", e.getMessage().toString());
        }
        return ultima_fecha;
    }

    public List<RecordSMS> getRecordSMSBetweenDates(KYTjPlWScT tipo_servicio, int mes, int anno) {
        List<RecordSMS> aList = null;
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            try {
                where.eq("tipo_servicio", tipo_servicio);
                where.and();
                where.eq("mostrar", true);
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String fechaInicioString = String.valueOf(anno) + "-" + String.valueOf(mes) + "-01";
                try {
                    Date fechainicio = formatter.parse(fechaInicioString);
                    Calendar c = Calendar.getInstance();
                    c.setTime(fechainicio);
                    int diaFindeMes = c.getActualMaximum(5);
                    String fechaFinString = String.valueOf(anno) + "-" + String.valueOf(mes) + "-" + diaFindeMes;
                    try {
                        Date fechafin = formatter.parse(fechaFinString);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(fechafin);
                        try {
                            cal.add(5, 1);
                            Date fechafin2 = cal.getTime();
                            where.and();
                            where.and(where.ge("fecha", fechainicio), where.le("fecha", fechafin2), new Where[0]);
                            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
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
                            fechaErr = e;
                            throw new Exception(fechaErr.getMessage());
                        }
                    } catch (Exception e2) {
                        fechaErr = e2;
                    }
                } catch (Exception fechaErr) {
                    throw new Exception(fechaErr.getMessage());
                }
            } catch (Exception e3) {
                fechaErr = e3;
                Log.i("a", fechaErr.getMessage());
            }
        } catch (Exception e4) {
            fechaErr = e4;
        }
    }

    /* JADX WARN: Not initialized variable reg: 19, insn: 0x012d: MOVE (r4 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY] A[D('aList' java.util.List<cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS>)]), block:B:38:0x012d */
    public List<RecordSMS> getRecordSMSBetweenDates(KYTjPlWScT tipo_servicio, String servicio, String moneda, int mes, int anno) {
        List<RecordSMS> aList;
        List<RecordSMS> aList2 = null;
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", tipo_servicio);
            where.and();
            where.eq("mostrar", true);
            where.and();
            try {
                where.eq("servicio", servicio);
                where.and();
                try {
                    where.eq("moneda", moneda);
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaInicioString = String.valueOf(anno) + "-" + String.valueOf(mes) + "-01";
                    try {
                        try {
                            Date fechainicio = formatter.parse(fechaInicioString);
                            Calendar c = Calendar.getInstance();
                            c.setTime(fechainicio);
                            int diaFindeMes = c.getActualMaximum(5);
                            String fechaFinString = String.valueOf(anno) + "-" + String.valueOf(mes) + "-" + diaFindeMes;
                            try {
                                Date fechafin = formatter.parse(fechaFinString);
                                Calendar cal = Calendar.getInstance();
                                try {
                                    cal.setTime(fechafin);
                                    try {
                                        cal.add(5, 1);
                                        Date fechafin2 = cal.getTime();
                                        where.and();
                                        where.between("fecha", fechainicio, fechafin2);
                                        PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", false).prepare();
                                        List<RecordSMS> aList3 = getHelper().getRecordSMSListDao().query(preparedQuery);
                                        try {
                                            if (aList3.size() == 0) {
                                                where.and();
                                                where.isNull("tipo_servicio");
                                                where.and();
                                                where.eq("mostrar", true);
                                                queryBuilder.orderBy("fecha", false).prepare();
                                                List<RecordSMS> aList4 = getHelper().getRecordSMSListDao().query(preparedQuery);
                                                return aList4;
                                            }
                                            return aList3;
                                        } catch (Exception e) {
                                            e = e;
                                            aList2 = aList3;
                                            Log.i("a", e.getMessage());
                                            return aList2;
                                        }
                                    } catch (Exception e2) {
                                        fechaErr = e2;
                                        throw new Exception(fechaErr.getMessage());
                                    }
                                } catch (Exception e3) {
                                    fechaErr = e3;
                                }
                            } catch (Exception e4) {
                                fechaErr = e4;
                            }
                        } catch (Exception fechaErr) {
                            throw new Exception(fechaErr.getMessage());
                        }
                    } catch (Exception e5) {
                        e = e5;
                        aList2 = aList;
                    }
                } catch (Exception e6) {
                    e = e6;
                    Log.i("a", e.getMessage());
                    return aList2;
                }
            } catch (Exception e7) {
                e = e7;
                Log.i("a", e.getMessage());
                return aList2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    public List<qcI22KekhL> getResumenRecordLists() {
        List<qcI22KekhL> resumen = new ArrayList<>();
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw("select servicio, moneda,sum(monto), count(id) from recordsms group by servicio, moneda order by servicio, moneda", new String[0]);
            for (String[] resultArray : rawResults) {
                qcI22KekhL uyh0pxs9m37in = new qcI22KekhL();
                uyh0pxs9m37in.setServicio(resultArray[0]);
                uyh0pxs9m37in.setMoneda(resultArray[1]);
                uyh0pxs9m37in.setMonto(resultArray[2]);
                uyh0pxs9m37in.setCantidad(resultArray[3]);
                resumen.add(uyh0pxs9m37in);
            }
            rawResults.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumen;
    }

    public List<AgentService> getAllAgentServiceLists() {
        try {
            List<AgentService> agLists = getHelper().getAgentServiceListDao().queryForAll();
            return agLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MiBoletoService> getAllMiBoletoServiceLists() {
        try {
            List<MiBoletoService> agLists = getHelper().getMiBoletoServiceListDao().queryForAll();
            return agLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AppConfig> getAllAppConfigLists() {
        try {
            List<AppConfig> appLists = getHelper().getAppConfigListDao().queryForAll();
            return appLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BancoService> getAllBancoServiceLists() {
        try {
            List<BancoService> agLists = getHelper().getBancoServiceListDao().queryForAll();
            return agLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AppConfig> getAppConfigLists() {
        try {
            List<AppConfig> appConfigLists = getHelper().getAppConfigListDao().queryForAll();
            return appConfigLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Client> getAllClientLists() {
        try {
            List<Client> clientLists = getHelper().getClientListDao().queryBuilder().orderBy("name", true).query();
            return clientLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pin> getAllPinLists() {
        try {
            List<Pin> pinLists = getHelper().getPinListDao().queryBuilder().orderBy("pin", true).query();
            return pinLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TeflMovil> getAllMovilLists() {
        try {
            List<TeflMovil> movilLists = getHelper().getMovilesListDao().queryBuilder().orderBy("number", true).query();
            return movilLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TelfFijo> getAllFijoLists() {
        try {
            List<TelfFijo> fijosLists = getHelper().getFijosListDao().queryBuilder().orderBy("number", true).query();
            return fijosLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Nauta> getAllNautaLists() {
        try {
            List<Nauta> nautasLists = getHelper().getNautasListDao().queryBuilder().orderBy("cuenta", true).query();
            return nautasLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Factura> getAllFacurasLists() {
        try {
            List<Factura> facturaLists = getHelper().getFacturasListDao().queryBuilder().orderBy("tipo_factura", true).query();
            return facturaLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CuentaBanco> getCuentasLists() {
        try {
            List<CuentaBanco> cLists = getHelper().getcuentasBancoListDao().queryBuilder().orderBy("descripcion", true).query();
            return cLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ServicioPublico> getAllServicioPublicoLists() {
        try {
            List<ServicioPublico> servicioPublicoListLists = getHelper().getServiciosPublicosListDao().queryBuilder().orderBy("valor", true).query();
            return servicioPublicoListLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MCBank> getAllMCBankLists() {
        try {
            List<MCBank> mcBanksListLists = getHelper().getMCBankListDao().queryBuilder().orderBy("agencia", true).query();
            return mcBanksListLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TarjetaPropia> getAllPropiaLists() {
        try {
            List<TarjetaPropia> iLists = getHelper().getPropiaListDao().queryBuilder().orderBy("serie", true).query();
            return iLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PromoSMS> getAllPromoSMSLists() {
        try {
            QueryBuilder<PromoSMS, Integer> queryBuilder = getHelper().getPromosSMSListDao().queryBuilder();
            queryBuilder.where().eq("habilitado", true);
            PreparedQuery<PromoSMS> preparedQuery = queryBuilder.orderBy("fecha_inicio", true).prepare();
            List<PromoSMS> servicioPublicoListLists = getHelper().getPromosSMSListDao().query(preparedQuery);
            return servicioPublicoListLists;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Provincia> getAllProvinciasLists() {
        try {
            List<Provincia> fijosLists = getHelper().getProvinciasListDao().queryBuilder().orderBy("cod_provincia", true).query();
            return fijosLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Municipio> getAllMunipiosLists(String cod_provincia) {
        QueryBuilder<Municipio, Integer> queryBuilder = getHelper().getMunicipiosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cod_provincia", cod_provincia);
            PreparedQuery<Municipio> preparedQuery = queryBuilder.orderBy("cod_municipio", true).prepare();
            List<Municipio> aList = getHelper().getMunicipiosListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.e("error", e.getMessage());
            return null;
        }
    }

    public List<Municipio> getAllMunicipiosLists() {
        try {
            List<Municipio> fijosLists = getHelper().getMunicipiosListDao().queryBuilder().orderBy("cod_municipio", true).query();
            return fijosLists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Tributo> getAllTributosLists() {
        try {
            List<Tributo> alist = getHelper().getTributosListDao().queryBuilder().orderBy("cod_tributo", true).query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TCTicket> getAllTicketLists() {
        try {
            List<TCTicket> alist = getHelper().getTcTicketsListDao().queryBuilder().orderBy("fecha", false).where().eq("deleted", false).query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CompraBoleto> getAllMiBoletoCompraLists() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            Date fechaActualSinHora = calendar.getTime();
            List<CompraBoleto> alist = getHelper().getCompraBoletoListDao().queryBuilder().orderBy("fecha_compra", false).where().eq("consumido", false).and().ge("fecha_vencimiento", fechaActualSinHora).query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AOperKey> getAllOperKeysLists() {
        try {
            List<AOperKey> alist = getHelper().getAOperKeyListDao().queryBuilder().query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OfertasBoleto> getAllOfertasmiBoleto() {
        try {
            List<OfertasBoleto> alist = getHelper().getOfertasBoletoListDao().queryBuilder().query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OfertasBoleto> getAllOfertasmiBoletoOrderBy() {
        try {
            List<OfertasBoleto> alist = getHelper().getOfertasBoletoListDao().queryBuilder().orderBy("id_control", false).query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CompraPlanesCubacel> getAllPaquetesLists() {
        try {
            List<CompraPlanesCubacel> alist = getHelper().getCompraPaquetesListDao().queryBuilder().query();
            return alist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AppConfig getAppConfigListWithId(int appConfigListId) {
        try {
            AppConfig appConfigList = getHelper().getAppConfigListDao().queryForId(Integer.valueOf(appConfigListId));
            return appConfigList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Client getClientListWithId(int clientListId) {
        try {
            Client clientList = getHelper().getClientListDao().queryForId(Integer.valueOf(clientListId));
            return clientList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pin getPinListWithId(int pintListId) {
        try {
            Pin pinList = getHelper().getPinListDao().queryForId(Integer.valueOf(pintListId));
            return pinList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TeflMovil getMovilListWithId(int movilListId) {
        try {
            TeflMovil movilList = getHelper().getMovilesListDao().queryForId(Integer.valueOf(movilListId));
            return movilList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TelfFijo getFijoListWithId(int fijoListId) {
        try {
            TelfFijo fijoList = getHelper().getFijosListDao().queryForId(Integer.valueOf(fijoListId));
            return fijoList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Nauta getNautaListWithId(int nautaListId) {
        try {
            Nauta nautaList = getHelper().getNautasListDao().queryForId(Integer.valueOf(nautaListId));
            return nautaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Factura getFacturaListWithId(int facturaListId) {
        try {
            Factura facturaList = getHelper().getFacturasListDao().queryForId(Integer.valueOf(facturaListId));
            return facturaList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ServicioPublico getServicioListWithId(int servicioListId) {
        try {
            ServicioPublico servicioPublicoList = getHelper().getServiciosPublicosListDao().queryForId(Integer.valueOf(servicioListId));
            return servicioPublicoList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CuentaBanco getCuentaListWithId(int cuentaListId) {
        try {
            CuentaBanco cList = getHelper().getcuentasBancoListDao().queryForId(Integer.valueOf(cuentaListId));
            return cList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MCBank getMCBank(int cuentaListId) {
        try {
            MCBank cList = getHelper().getMCBankListDao().queryForId(Integer.valueOf(cuentaListId));
            return cList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TarjetaPropia getPropiaListWithID(int propiaListID) {
        try {
            TarjetaPropia cList = getHelper().getPropiaListDao().queryForId(Integer.valueOf(propiaListID));
            return cList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public TCTicket getTCTicketListWithID(int id) {
        try {
            TCTicket cList = getHelper().getTcTicketsListDao().queryForId(Integer.valueOf(id));
            return cList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CompraBoleto getBoletoListWithID(int id) {
        try {
            CompraBoleto cList = getHelper().getCompraBoletoListDao().queryForId(Integer.valueOf(id));
            return cList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AOperKey getAOperKey(Nl0yptXmjQ oper) {
        QueryBuilder<AOperKey, Integer> queryBuilder = getHelper().getAOperKeyListDao().queryBuilder();
        try {
            queryBuilder.where().eq("operacion", oper);
            PreparedQuery<AOperKey> preparedQuery = queryBuilder.orderBy("id", true).prepare();
            List<AOperKey> aList = getHelper().getAOperKeyListDao().query(preparedQuery);
            if (aList == null || aList.size() <= 0) {
                return null;
            }
            AOperKey operKey = aList.get(0);
            return operKey;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public boolean deleteRecordSMSService(RecordSMS rsms) {
        try {
            getHelper().getRecordSMSListDao().delete(rsms);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAppConfig(AppConfig appConfig) {
        try {
            getHelper().getAppConfigListDao().delete(appConfig);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAgentService(AgentService agents) {
        try {
            getHelper().getAgentServiceListDao().delete(agents);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBancoService(BancoService agents) {
        try {
            getHelper().getBancoServiceListDao().delete(agents);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllAgentService() {
        try {
            getHelper().getAgentServiceListDao().delete(getAllAgentServiceLists());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllCuentasBanco() {
        try {
            getHelper().getcuentasBancoListDao().delete(getCuentasLists());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllBancoService() {
        try {
            getHelper().getBancoServiceListDao().delete(getAllBancoServiceLists());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllServicioPublicoService() {
        try {
            getHelper().getServiciosPublicosListDao().delete(getAllServicioPublicoLists());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllTCTTicket() {
        try {
            getHelper().getTcTicketsListDao().delete(getAllTicketLists());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteClient(Client client) {
        try {
            getHelper().getClientListDao().delete(client);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePin(Pin pin) {
        try {
            getHelper().getPinListDao().delete(pin);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFijo(TelfFijo fijo) {
        try {
            getHelper().getFijosListDao().delete(fijo);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMovil(TeflMovil movil) {
        try {
            getHelper().getMovilesListDao().delete(movil);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNauta(Nauta nauta) {
        try {
            getHelper().getNautasListDao().delete(nauta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFactura(Factura factura) {
        try {
            getHelper().getFacturasListDao().delete(factura);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteServicio(ServicioPublico servicioPublico) {
        try {
            getHelper().getServiciosPublicosListDao().delete(servicioPublico);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePromoSMS(PromoSMS promoSMS) {
        try {
            getHelper().getPromosSMSListDao().delete(promoSMS);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCuentaBanco(CuentaBanco cuenta) {
        try {
            getHelper().getcuentasBancoListDao().delete(cuenta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMCBank(MCBank cuenta) {
        try {
            getHelper().getMCBankListDao().delete(cuenta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePropia(TarjetaPropia cuenta) {
        try {
            getHelper().getPropiaListDao().delete(cuenta);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTCTicket(TCTicket ticket) {
        try {
            getHelper().getTcTicketsListDao().delete(ticket);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAOperKey(AOperKey key) {
        try {
            getHelper().getAOperKeyListDao().delete(key);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOfertasWithIdTmLess(long id_tm) {
        try {
            List<OfertasBoleto> todasLasOfertas = getHelper().getOfertasBoletoListDao().queryForAll();
            List<OfertasBoleto> ofertasAEliminar = new ArrayList<>();
            for (OfertasBoleto oferta : todasLasOfertas) {
                if (oferta.getId_control() < id_tm) {
                    ofertasAEliminar.add(oferta);
                }
            }
            Iterator<OfertasBoleto> it = ofertasAEliminar.iterator();
            while (it.hasNext()) {
                getHelper().getOfertasBoletoListDao().delete(it.next());
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
        try {
            getHelper().getOfertasBoletoListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllPaquetes() {
        try {
            getHelper().getCompraPaquetesListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addRecordSMS(RecordSMS v) {
        try {
            int valor = getHelper().getRecordSMSListDao().create(v);
            Log.i("valor", String.valueOf(valor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAppConfig(AppConfig app) {
        try {
            getHelper().getAppConfigListDao().create(app);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAgentService(AgentService a) {
        try {
            getHelper().getAgentServiceListDao().create(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMiBoletoService(MiBoletoService a) {
        try {
            getHelper().getMiBoletoServiceListDao().create(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBancoService(BancoService a) {
        try {
            getHelper().getBancoServiceListDao().create(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client c) {
        try {
            getHelper().getClientListDao().create(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addClientID(Client c) {
        try {
            return getHelper().getClientListDao().create(c);
        } catch (SQLException e) {
            return 0;
        }
    }

    public int addClientGetID(Client c) {
        try {
            Client cl = getHelper().getClientListDao().createIfNotExists(c);
            int id = cl.getId();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void addPin(Pin p) {
        try {
            getHelper().getPinListDao().create(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTelfMovil(TeflMovil m) {
        try {
            getHelper().getMovilesListDao().create(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTelfFijo(TelfFijo f) {
        try {
            getHelper().getFijosListDao().create(f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNauta(Nauta n) {
        try {
            getHelper().getNautasListDao().create(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFactura(Factura f) {
        try {
            getHelper().getFacturasListDao().create(f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addServicioPublico(ServicioPublico s) {
        try {
            getHelper().getServiciosPublicosListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPromoSMS(PromoSMS s) {
        try {
            getHelper().getPromosSMSListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCuentaBanco(CuentaBanco s) {
        try {
            getHelper().getcuentasBancoListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMCBank(MCBank s) {
        try {
            getHelper().getMCBankListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPropia(TarjetaPropia s) {
        try {
            getHelper().getPropiaListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProvincia(Provincia s) {
        try {
            getHelper().getProvinciasListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMunicipio(Municipio s) {
        try {
            getHelper().getMunicipiosListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTributo(Tributo s) {
        try {
            getHelper().getTributosListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTCTicket(TCTicket s) {
        try {
            getHelper().getTcTicketsListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAOperKey(AOperKey s) {
        try {
            getHelper().getAOperKeyListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOfertasMiBoleto(OfertasBoleto s) {
        try {
            getHelper().getOfertasBoletoListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCompraMiBoleto(CompraBoleto s) {
        try {
            getHelper().getCompraBoletoListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMonedasWallet(TMonedasWallet s) {
        try {
            getHelper().getMonedasWalletListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPaquetes(CompraPlanesCubacel s) {
        try {
            getHelper().getCompraPaquetesListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int updateRecordSMS(RecordSMS v) {
        try {
            UpdateBuilder<RecordSMS, Integer> updateBuilder = getHelper().getRecordSMSListDao().updateBuilder();
            updateBuilder.where().eq("id", Integer.valueOf(v.getId()));
            updateBuilder.updateColumnValue("mostrar", false);
            int valor = updateBuilder.update();
            return valor;
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("E", e.getMessage());
            return 0;
        }
    }

    public void updateAppConfig(AppConfig app) {
        try {
            getHelper().getAppConfigListDao().update(app);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAgentService(AgentService a) {
        try {
            getHelper().getAgentServiceListDao().update(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMiBoletoService(MiBoletoService a) {
        try {
            getHelper().getMiBoletoServiceListDao().update(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBancoService(BancoService a) {
        try {
            getHelper().getBancoServiceListDao().update(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client c) {
        try {
            getHelper().getClientListDao().update(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePin(Pin p) {
        try {
            getHelper().getPinListDao().update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMovil(TeflMovil p) {
        try {
            getHelper().getMovilesListDao().update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFijo(TelfFijo p) {
        try {
            getHelper().getFijosListDao().update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNauta(Nauta p) {
        try {
            getHelper().getNautasListDao().update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFactura(Factura f) {
        try {
            getHelper().getFacturasListDao().update(f);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateServicioPublico(ServicioPublico s) {
        try {
            getHelper().getServiciosPublicosListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePromoSMS(PromoSMS s) {
        try {
            getHelper().getPromosSMSListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCuentaBanco(CuentaBanco s) {
        try {
            getHelper().getcuentasBancoListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMCBank(MCBank s) {
        try {
            getHelper().getMCBankListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePropia(TarjetaPropia s) {
        try {
            getHelper().getPropiaListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProvincia(Provincia s) {
        try {
            getHelper().getProvinciasListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMunicipio(Municipio s) {
        try {
            getHelper().getMunicipiosListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTributo(Tributo s) {
        try {
            getHelper().getTributosListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTCTicket(TCTicket s) {
        try {
            getHelper().getTcTicketsListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCompraMiboleto(CompraBoleto s) {
        try {
            getHelper().getCompraBoletoListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOfertasBoleto(OfertasBoleto s) {
        try {
            getHelper().getOfertasBoletoListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAOperKey(AOperKey s) {
        try {
            getHelper().getAOperKeyListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AgentService> getAgentServiceWithCode(String code) {
        QueryBuilder<AgentService, Integer> queryBuilder = getHelper().getAgentServiceListDao().queryBuilder();
        try {
            queryBuilder.where().eq("code", code);
            PreparedQuery<AgentService> preparedQuery = queryBuilder.prepare();
            List<AgentService> aList = getHelper().getAgentServiceListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<BancoService> getBancoServiceWithCode(String code) {
        QueryBuilder<BancoService, Integer> queryBuilder = getHelper().getBancoServiceListDao().queryBuilder();
        try {
            queryBuilder.where().eq("code", code);
            PreparedQuery<BancoService> preparedQuery = queryBuilder.prepare();
            List<BancoService> aList = getHelper().getBancoServiceListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<RecordSMS> getRecordSMSwithCuenta(String cuenta) {
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cuenta", cuenta);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.prepare();
            List<RecordSMS> aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public PromoSMS getPromoSMS(String mensaje) {
        PromoSMS sms = null;
        QueryBuilder<PromoSMS, Integer> queryBuilder = getHelper().getPromosSMSListDao().queryBuilder();
        try {
            queryBuilder.where().like("mensaje", "%" + mensaje + "%");
            PreparedQuery<PromoSMS> preparedQuery = queryBuilder.prepare();
            List<PromoSMS> aList = getHelper().getPromosSMSListDao().query(preparedQuery);
            if (aList.size() > 0) {
                Date today = new Date();
                for (PromoSMS promoSMS : aList) {
                    if (promoSMS.getFecha_fin().after(today)) {
                        sms = promoSMS;
                    }
                }
            }
            return sms;
        } catch (Exception e) {
            return sms;
        }
    }

    public List<RecordSMS> getRecordSMSwithIDTransaction(String id) {
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            queryBuilder.where().eq("idTransaccion", id);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.prepare();
            List<RecordSMS> aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<RecordSMS> getRecordSMSwithIDTransactionByType(String id, KYTjPlWScT modulosEstadisticosEntity) {
        QueryBuilder<RecordSMS, Integer> queryBuilder = getHelper().getRecordSMSListDao().queryBuilder();
        try {
            Where<RecordSMS, Integer> where = queryBuilder.where();
            where.eq("idTransaccion", id);
            where.and();
            where.eq("tipo_servicio", modulosEstadisticosEntity);
            PreparedQuery<RecordSMS> preparedQuery = queryBuilder.orderBy("fecha", true).prepare();
            List<RecordSMS> aList = getHelper().getRecordSMSListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public List<Client> getClientListsWithPhoneNumber(String telef) {
        QueryBuilder<Client, Integer> queryBuilder = getHelper().getClientListDao().queryBuilder();
        try {
            queryBuilder.where().eq("phone", telef);
            PreparedQuery<Client> preparedQuery = queryBuilder.prepare();
            List<Client> clientList = getHelper().getClientListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Client> getClientListsWithName(String name) {
        QueryBuilder<Client, Integer> queryBuilder = getHelper().getClientListDao().queryBuilder();
        try {
            queryBuilder.where().eq("name", name);
            PreparedQuery<Client> preparedQuery = queryBuilder.prepare();
            List<Client> clientList = getHelper().getClientListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Pin> getPinListsWithNumPin(String pin) {
        QueryBuilder<Pin, Integer> queryBuilder = getHelper().getPinListDao().queryBuilder();
        try {
            queryBuilder.where().eq("pin", pin);
            PreparedQuery<Pin> preparedQuery = queryBuilder.prepare();
            List<Pin> pinList = getHelper().getPinListDao().query(preparedQuery);
            return pinList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TelfFijo> getFijoListsWithPhoneNumber(String telef) {
        QueryBuilder<TelfFijo, Integer> queryBuilder = getHelper().getFijosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("number", telef);
            PreparedQuery<TelfFijo> preparedQuery = queryBuilder.prepare();
            List<TelfFijo> fijosList = getHelper().getFijosListDao().query(preparedQuery);
            return fijosList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TelfFijo> getFijoListsWithCliente(int id_cliente) {
        QueryBuilder<TelfFijo, Integer> queryBuilder = getHelper().getFijosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<TelfFijo> preparedQuery = queryBuilder.prepare();
            List<TelfFijo> fijosList = getHelper().getFijosListDao().query(preparedQuery);
            return fijosList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TeflMovil> getMovilListsWithPhoneNumber(String telef) {
        QueryBuilder<TeflMovil, Integer> queryBuilder = getHelper().getMovilesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("number", telef);
            PreparedQuery<TeflMovil> preparedQuery = queryBuilder.prepare();
            List<TeflMovil> movilList = getHelper().getMovilesListDao().query(preparedQuery);
            return movilList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TeflMovil> getMovilListsWithCliente(int id_cliente) {
        QueryBuilder<TeflMovil, Integer> queryBuilder = getHelper().getMovilesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<TeflMovil> preparedQuery = queryBuilder.prepare();
            List<TeflMovil> movilList = getHelper().getMovilesListDao().query(preparedQuery);
            return movilList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nauta> getNautaListsWithAccount(String cuenta, int tipo) {
        QueryBuilder<Nauta, Integer> queryBuilder = getHelper().getNautasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cuenta", cuenta).and().eq("tipo_cuenta", Integer.valueOf(tipo));
            PreparedQuery<Nauta> preparedQuery = queryBuilder.prepare();
            List<Nauta> nautaList = getHelper().getNautasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Factura> getFacturasListsWithCliente(int id_cliente) {
        QueryBuilder<Factura, Integer> queryBuilder = getHelper().getFacturasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<Factura> preparedQuery = queryBuilder.prepare();
            List<Factura> facturasList = getHelper().getFacturasListDao().query(preparedQuery);
            return facturasList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CuentaBanco> getCuentasListsWithCliente(int id_cliente) {
        QueryBuilder<CuentaBanco, Integer> queryBuilder = getHelper().getcuentasBancoListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<CuentaBanco> preparedQuery = queryBuilder.prepare();
            List<CuentaBanco> facturasList = getHelper().getcuentasBancoListDao().query(preparedQuery);
            return facturasList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ServicioPublico> getServiciosPublicosListsWithCliente(int id_cliente) {
        QueryBuilder<ServicioPublico, Integer> queryBuilder = getHelper().getServiciosPublicosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<ServicioPublico> preparedQuery = queryBuilder.prepare();
            List<ServicioPublico> servicioPublicoListList = getHelper().getServiciosPublicosListDao().query(preparedQuery);
            return servicioPublicoListList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Factura> getFacturasListsTipoCuenta(int tipo_factura) {
        QueryBuilder<Factura, Integer> queryBuilder = getHelper().getFacturasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("tipo_factura", Integer.valueOf(tipo_factura));
            PreparedQuery<Factura> preparedQuery = queryBuilder.prepare();
            List<Factura> facturasList = getHelper().getFacturasListDao().query(preparedQuery);
            return facturasList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ServicioPublico> getFacturasListsTipoServicio(int tipo_servicio) {
        QueryBuilder<ServicioPublico, Integer> queryBuilder = getHelper().getServiciosPublicosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("tipo_servicio", Integer.valueOf(tipo_servicio));
            PreparedQuery<ServicioPublico> preparedQuery = queryBuilder.prepare();
            List<ServicioPublico> servicioPublicoListList = getHelper().getServiciosPublicosListDao().query(preparedQuery);
            return servicioPublicoListList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nauta> getNautaListsWithAccount(String cuenta) {
        QueryBuilder<Nauta, Integer> queryBuilder = getHelper().getNautasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cuenta", cuenta);
            PreparedQuery<Nauta> preparedQuery = queryBuilder.prepare();
            List<Nauta> nautaList = getHelper().getNautasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Factura> getFacturaListsWithFactura(String factura) {
        QueryBuilder<Factura, Integer> queryBuilder = getHelper().getFacturasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("factura", factura);
            PreparedQuery<Factura> preparedQuery = queryBuilder.prepare();
            List<Factura> nautaList = getHelper().getFacturasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ServicioPublico> getServicioPublicoListsWithValor(String servicio) {
        QueryBuilder<ServicioPublico, Integer> queryBuilder = getHelper().getServiciosPublicosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("valor", servicio);
            PreparedQuery<ServicioPublico> preparedQuery = queryBuilder.prepare();
            List<ServicioPublico> sList = getHelper().getServiciosPublicosListDao().query(preparedQuery);
            return sList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nauta> getNautaListsWithClient(int id_cliente) {
        QueryBuilder<Nauta, Integer> queryBuilder = getHelper().getNautasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(id_cliente));
            PreparedQuery<Nauta> preparedQuery = queryBuilder.prepare();
            List<Nauta> nautaList = getHelper().getNautasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TCTicket> getTCTicketWithSerie(String serie) {
        QueryBuilder<TCTicket, Integer> queryBuilder = getHelper().getTcTicketsListDao().queryBuilder();
        try {
            queryBuilder.where().eq("serie", serie);
            PreparedQuery<TCTicket> preparedQuery = queryBuilder.prepare();
            List<TCTicket> aList = getHelper().getTcTicketsListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TeflMovil> getMovilListsWithClient(Client cliente) {
        QueryBuilder<TeflMovil, Integer> queryBuilder = getHelper().getMovilesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<TeflMovil> preparedQuery = queryBuilder.prepare();
            List<TeflMovil> movilList = getHelper().getMovilesListDao().query(preparedQuery);
            return movilList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TelfFijo> getFijosListsWithClient(Client cliente) {
        QueryBuilder<TelfFijo, Integer> queryBuilder = getHelper().getFijosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<TelfFijo> preparedQuery = queryBuilder.prepare();
            List<TelfFijo> fijosList = getHelper().getFijosListDao().query(preparedQuery);
            return fijosList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nauta> getNautasListsWithClient(Client cliente) {
        QueryBuilder<Nauta, Integer> queryBuilder = getHelper().getNautasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<Nauta> preparedQuery = queryBuilder.prepare();
            List<Nauta> nautaList = getHelper().getNautasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Factura> getFacturasListsWithClient(Client cliente) {
        QueryBuilder<Factura, Integer> queryBuilder = getHelper().getFacturasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<Factura> preparedQuery = queryBuilder.prepare();
            List<Factura> facturasList = getHelper().getFacturasListDao().query(preparedQuery);
            return facturasList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ServicioPublico> getServicioListsWithClient(Client cliente) {
        QueryBuilder<ServicioPublico, Integer> queryBuilder = getHelper().getServiciosPublicosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<ServicioPublico> preparedQuery = queryBuilder.prepare();
            List<ServicioPublico> servicioPublicoListList = getHelper().getServiciosPublicosListDao().query(preparedQuery);
            return servicioPublicoListList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TarjetaPropia> getPropiasListsWithClient(Client cliente) {
        QueryBuilder<TarjetaPropia, Integer> queryBuilder = getHelper().getPropiaListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", Integer.valueOf(cliente.getId()));
            PreparedQuery<TarjetaPropia> preparedQuery = queryBuilder.prepare();
            List<TarjetaPropia> servicioPublicoListList = getHelper().getPropiaListDao().query(preparedQuery);
            return servicioPublicoListList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<MCBank> getMisCuentasAlias(String alias) {
        QueryBuilder<MCBank, Integer> queryBuilder = getHelper().getMCBankListDao().queryBuilder();
        try {
            queryBuilder.where().eq("alias", alias);
            PreparedQuery<MCBank> preparedQuery = queryBuilder.prepare();
            List<MCBank> mcBanks = getHelper().getMCBankListDao().query(preparedQuery);
            return mcBanks;
        } catch (Exception e) {
            return null;
        }
    }

    public List<MCBank> getMiCuenta(String cuenta) {
        QueryBuilder<MCBank, Integer> queryBuilder = getHelper().getMCBankListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cuenta", cuenta);
            PreparedQuery<MCBank> preparedQuery = queryBuilder.prepare();
            List<MCBank> mcBanks = getHelper().getMCBankListDao().query(preparedQuery);
            return mcBanks;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Pin> getPinListsWithoutDesc() {
        QueryBuilder<Pin, Integer> queryBuilder = getHelper().getPinListDao().queryBuilder();
        try {
            queryBuilder.where().eq("descripcion", BuildConfig.FLAVOR);
            PreparedQuery<Pin> preparedQuery = queryBuilder.prepare();
            List<Pin> pinList = getHelper().getPinListDao().query(preparedQuery);
            return pinList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Client> getClientListsWithoutName() {
        QueryBuilder<Client, Integer> queryBuilder = getHelper().getClientListDao().queryBuilder();
        try {
            queryBuilder.where().eq("name", BuildConfig.FLAVOR);
            PreparedQuery<Client> preparedQuery = queryBuilder.prepare();
            List<Client> clientList = getHelper().getClientListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TelfFijo> getFijosListsWithoutName() {
        QueryBuilder<TelfFijo, Integer> queryBuilder = getHelper().getFijosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", "0");
            PreparedQuery<TelfFijo> preparedQuery = queryBuilder.prepare();
            List<TelfFijo> clientList = getHelper().getFijosListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TeflMovil> getMovilListsWithoutName() {
        QueryBuilder<TeflMovil, Integer> queryBuilder = getHelper().getMovilesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", "0");
            PreparedQuery<TeflMovil> preparedQuery = queryBuilder.prepare();
            List<TeflMovil> movilList = getHelper().getMovilesListDao().query(preparedQuery);
            return movilList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nauta> getNautaListsWithoutName() {
        QueryBuilder<Nauta, Integer> queryBuilder = getHelper().getNautasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", "0");
            PreparedQuery<Nauta> preparedQuery = queryBuilder.prepare();
            List<Nauta> nautaList = getHelper().getNautasListDao().query(preparedQuery);
            return nautaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Factura> getFacturasListsWithoutName() {
        QueryBuilder<Factura, Integer> queryBuilder = getHelper().getFacturasListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", "0");
            PreparedQuery<Factura> preparedQuery = queryBuilder.prepare();
            List<Factura> facturasList = getHelper().getFacturasListDao().query(preparedQuery);
            return facturasList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ServicioPublico> getServiciosPublicosListsWithoutName() {
        QueryBuilder<ServicioPublico, Integer> queryBuilder = getHelper().getServiciosPublicosListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_client", "0");
            PreparedQuery<ServicioPublico> preparedQuery = queryBuilder.prepare();
            List<ServicioPublico> servicioPublicoList = getHelper().getServiciosPublicosListDao().query(preparedQuery);
            return servicioPublicoList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CuentaBanco> getCuentaListsWithAccount(String cuenta) {
        QueryBuilder<CuentaBanco, Integer> queryBuilder = getHelper().getcuentasBancoListDao().queryBuilder();
        try {
            queryBuilder.where().eq("cuenta", cuenta);
            PreparedQuery<CuentaBanco> preparedQuery = queryBuilder.prepare();
            List<CuentaBanco> cuentaList = getHelper().getcuentasBancoListDao().query(preparedQuery);
            return cuentaList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TarjetaPropia> getTarjetaPropiaWithSerie(String serie) {
        QueryBuilder<TarjetaPropia, Integer> queryBuilder = getHelper().getPropiaListDao().queryBuilder();
        try {
            queryBuilder.where().eq("serie", serie);
            PreparedQuery<TarjetaPropia> preparedQuery = queryBuilder.prepare();
            List<TarjetaPropia> oList = getHelper().getPropiaListDao().query(preparedQuery);
            return oList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<TCTicket> getTCombustible(String serie) {
        QueryBuilder<TCTicket, Integer> queryBuilder = getHelper().getTcTicketsListDao().queryBuilder();
        try {
            queryBuilder.where().eq("serie", serie);
            PreparedQuery<TCTicket> preparedQuery = queryBuilder.prepare();
            List<TCTicket> oList = getHelper().getTcTicketsListDao().query(preparedQuery);
            return oList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CompraBoleto> getCompraBoleto(String idoferta) {
        QueryBuilder<CompraBoleto, Integer> queryBuilder = getHelper().getCompraBoletoListDao().queryBuilder();
        try {
            queryBuilder.where().eq("id_oferta", idoferta);
            PreparedQuery<CompraBoleto> preparedQuery = queryBuilder.prepare();
            List<CompraBoleto> oList = getHelper().getCompraBoletoListDao().query(preparedQuery);
            return oList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<OfertasBoleto> getOfertasBoleto(String serie) {
        QueryBuilder<OfertasBoleto, Integer> queryBuilder = getHelper().getOfertasBoletoListDao().queryBuilder();
        try {
            queryBuilder.where().eq("serie", serie);
            PreparedQuery<OfertasBoleto> preparedQuery = queryBuilder.prepare();
            List<OfertasBoleto> oList = getHelper().getOfertasBoletoListDao().query(preparedQuery);
            return oList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Operacion> getOperacionesByType(KYTjPlWScT modulosEstadisticosEntity) {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operacion, Integer> where = queryBuilder.where();
            where.eq("tipo_servicio", modulosEstadisticosEntity);
            where.and();
            where.ge("order", 0);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public List<Operacion> getOperacionesList() {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operacion, Integer> where = queryBuilder.where();
            where.ge("order", 0);
            where.and();
            where.eq("activo", true);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public List<Operacion> getOperacionesListTipo(R1sDOSqZ2z tipo) {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("tipo_servicio", tipo);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public List<Operacion> getOperacionesNoActivasList() {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            Where<Operacion, Integer> where = queryBuilder.where();
            where.eq("order", -1);
            where.and();
            where.eq("activo", true);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("tipo_servicio", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            return aList;
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            return null;
        }
    }

    public Operacion getOperacion(FdonIAFI9w operacioneEnum) {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("operacion", operacioneEnum);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            if (aList == null || aList.size() == 0) {
                return null;
            }
            return aList.get(0);
        } catch (Exception e) {
            Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage());
            return null;
        }
    }

    public int getCountOperacion(FdonIAFI9w operacioneEnum) {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("operacion", operacioneEnum);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            if (aList == null || aList.size() == 0) {
                return 0;
            }
            return aList.size();
        } catch (Exception e) {
            Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage());
            return 0;
        }
    }

    public List<Operacion> getListOperacion(FdonIAFI9w operacioneEnum) {
        QueryBuilder<Operacion, Integer> queryBuilder = getHelper().getoperacionesListDao().queryBuilder();
        try {
            queryBuilder.where().eq("operacion", operacioneEnum);
            PreparedQuery<Operacion> preparedQuery = queryBuilder.orderBy("order", true).prepare();
            List<Operacion> aList = getHelper().getoperacionesListDao().query(preparedQuery);
            if (aList == null || aList.size() == 0) {
                return null;
            }
            return aList;
        } catch (Exception e) {
            Log.i("TM_ERROR", "ERROR_GET_OPER" + e.getMessage());
            return null;
        }
    }

    public List<MCBank> getMCBankByAgency(R1sDOSqZ2z agencyEntity) {
        QueryBuilder<MCBank, Integer> queryBuilder = getHelper().getMCBankListDao().queryBuilder();
        try {
            queryBuilder.where().eq("agencia", agencyEntity);
            PreparedQuery<MCBank> preparedQuery = queryBuilder.prepare();
            List<MCBank> clientList = getHelper().getMCBankListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<MCBank> getMCBankByAgencyNoMLC(R1sDOSqZ2z agencyEntity) {
        QueryBuilder<MCBank, Integer> queryBuilder = getHelper().getMCBankListDao().queryBuilder();
        try {
            Where<MCBank, Integer> where = queryBuilder.where();
            where.eq("agencia", agencyEntity);
            where.and();
            where.not().eq("tipo_moneda", qTDVwLFEjE.USD);
            PreparedQuery<MCBank> preparedQuery = queryBuilder.prepare();
            List<MCBank> clientList = getHelper().getMCBankListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
            return null;
        }
    }

    public List<MCBank> getMCBankByAgencyMLC(R1sDOSqZ2z agencyEntity) {
        QueryBuilder<MCBank, Integer> queryBuilder = getHelper().getMCBankListDao().queryBuilder();
        try {
            Where<MCBank, Integer> where = queryBuilder.where();
            where.eq("agencia", agencyEntity);
            where.and();
            where.eq("tipo_moneda", qTDVwLFEjE.USD);
            PreparedQuery<MCBank> preparedQuery = queryBuilder.prepare();
            List<MCBank> clientList = getHelper().getMCBankListDao().query(preparedQuery);
            return clientList;
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
            return null;
        }
    }

    public void addOperacion(Operacion s) {
        try {
            getHelper().getoperacionesListDao().create(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOperacion(Operacion s) {
        try {
            getHelper().getoperacionesListDao().update(s);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.i("ERRORBD", e.getMessage());
        }
    }

    public Operacion getOperacionWithId(int id) {
        try {
            Operacion operacion = getHelper().getoperacionesListDao().queryForId(Integer.valueOf(id));
            return operacion;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TMonedasWallet> getMonedasWallet() {
        try {
            List<TMonedasWallet> monesdasList = getHelper().getMonedasWalletListDao().queryBuilder().query();
            return monesdasList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TMonedasWallet> getMonedasWalletSinMisCuentas() {
        QueryBuilder<TMonedasWallet, Integer> queryBuilder = getHelper().getMonedasWalletListDao().queryBuilder();
        try {
            queryBuilder.where().not().eq("descripcion", "-MIS CUENTAS-");
            queryBuilder.where().eq("allowTransfer", 1);
            PreparedQuery<TMonedasWallet> preparedQuery = queryBuilder.prepare();
            List<TMonedasWallet> monesdasList = getHelper().getMonedasWalletListDao().query(preparedQuery);
            return monesdasList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteOperacion(Operacion operacion) {
        try {
            getHelper().getoperacionesListDao().delete(operacion);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOperacionesAll() {
        try {
            getHelper().getoperacionesListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTributosAll() {
        try {
            getHelper().getTributosListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProvinciaAll() {
        try {
            getHelper().getProvinciasListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMunicipiosAll() {
        try {
            getHelper().getMunicipiosListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMonedasWallet() {
        try {
            getHelper().getMonedasWalletListDao().deleteBuilder().delete();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int MaxIdRecordSms() {
        int max = 0;
        new ArrayList();
        try {
            GenericRawResults<String[]> rawResults = getHelper().getRecordSMSListDao().queryRaw("select max(id) from recordsms", new String[0]);
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
        if (max <= 10000) {
            return false;
        }
        int min = max - 10000;
        try {
            DeleteBuilder<RecordSMS, Integer> deleteBuilder = getHelper().getRecordSMSListDao().deleteBuilder();
            deleteBuilder.where().le("id", Integer.valueOf(min));
            getHelper().getRecordSMSListDao().delete(deleteBuilder.prepare());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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
