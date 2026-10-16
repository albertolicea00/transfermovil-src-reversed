package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.hY5P1xQ5h8;
import cu.etecsa.cubacel.tr.tm.R;
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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ZqXxImD3Ix extends OrmLiteSqliteOpenHelper {
    private static final String DATABASELOG = "DATABASELOG";
    private static final String DATABASE_NAME = "TransferMDB.sqlite";
    private static final int DATABASE_VERSION = 162;
    private Dao<AgentService, Integer> agentServiceListDao;
    private Dao<AOperKey, Integer> aoperkeyListDao;
    private Dao<AppConfig, Integer> appConfigListDao;
    private Dao<BancoService, Integer> bancoServiceListDao;
    private Dao<Client, Integer> clientListDao;
    private Dao<CompraBoleto, Integer> compraBoletoListDao;
    private Dao<CompraPlanesCubacel, Integer> compraPaquetesDao;
    private Dao<CuentaBanco, Integer> cuentasListDao;
    private Dao<Factura, Integer> facturasListDao;
    private Dao<MCBank, Integer> mcBanksListDao;
    private Dao<MiBoletoService, Integer> miboletoServiceListDao;
    private Dao<TMonedasWallet, Integer> monedasWalletsListDao;
    private Dao<Municipio, Integer> municipiosListDao;
    public Context mycontex;
    private Dao<Nauta, Integer> nautaListDao;
    private Dao<OfertasBoleto, Integer> ofertasBoletoListDao;
    private Dao<Operacion, Integer> operacionesListDao;
    private Dao<Pin, Integer> pinListDao;
    private Dao<PromoSMS, Integer> promosSMSListDao;
    private Dao<TarjetaPropia, Integer> propiaListDao;
    private Dao<Provincia, Integer> provinciasListDao;
    private Dao<RecordSMS, Integer> recordSMSListDao;
    private Dao<ServicioPublico, Integer> servicioPublicosListDao;
    private Dao<TCTicket, Integer> tcTicketsListDao;
    private Dao<TelfFijo, Integer> telfijoListDao;
    private Dao<TeflMovil, Integer> telfmovilListDao;
    private Dao<Tributo, Integer> tributosListDao;

    public ZqXxImD3Ix(Context context) {
        super(context, DATABASE_NAME, null, 162);
        this.clientListDao = null;
        this.pinListDao = null;
        this.telfmovilListDao = null;
        this.telfijoListDao = null;
        this.nautaListDao = null;
        this.agentServiceListDao = null;
        this.miboletoServiceListDao = null;
        this.bancoServiceListDao = null;
        this.recordSMSListDao = null;
        this.appConfigListDao = null;
        this.facturasListDao = null;
        this.servicioPublicosListDao = null;
        this.promosSMSListDao = null;
        this.operacionesListDao = null;
        this.cuentasListDao = null;
        this.mcBanksListDao = null;
        this.propiaListDao = null;
        this.provinciasListDao = null;
        this.municipiosListDao = null;
        this.tributosListDao = null;
        this.tcTicketsListDao = null;
        this.aoperkeyListDao = null;
        this.ofertasBoletoListDao = null;
        this.compraBoletoListDao = null;
        this.monedasWalletsListDao = null;
        this.compraPaquetesDao = null;
        this.mycontex = context;
    }

    public long SizeDB() {
        long size = this.mycontex.getDatabasePath(DATABASE_NAME).length();
        return size;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Client.class);
            TableUtils.createTable(connectionSource, Pin.class);
            TableUtils.createTable(connectionSource, TeflMovil.class);
            TableUtils.createTable(connectionSource, TelfFijo.class);
            TableUtils.createTable(connectionSource, Nauta.class);
            TableUtils.createTable(connectionSource, AgentService.class);
            TableUtils.createTable(connectionSource, RecordSMS.class);
            TableUtils.createTable(connectionSource, AppConfig.class);
            TableUtils.createTable(connectionSource, BancoService.class);
            TableUtils.createTable(connectionSource, Factura.class);
            TableUtils.createTable(connectionSource, ServicioPublico.class);
            TableUtils.createTable(connectionSource, PromoSMS.class);
            TableUtils.createTable(connectionSource, Operacion.class);
            TableUtils.createTable(connectionSource, CuentaBanco.class);
            TableUtils.createTable(connectionSource, MCBank.class);
            TableUtils.createTable(connectionSource, TarjetaPropia.class);
            TableUtils.createTable(connectionSource, Provincia.class);
            TableUtils.createTable(connectionSource, Municipio.class);
            TableUtils.createTable(connectionSource, Tributo.class);
            TableUtils.createTable(connectionSource, TCTicket.class);
            TableUtils.createTable(connectionSource, AOperKey.class);
            TableUtils.createTable(connectionSource, OfertasBoleto.class);
            TableUtils.createTable(connectionSource, CompraBoleto.class);
            TableUtils.createTable(connectionSource, MiBoletoService.class);
            TableUtils.createTable(connectionSource, TMonedasWallet.class);
            TableUtils.createTable(connectionSource, CompraPlanesCubacel.class);
            nljtDl5MIf fillDB = new nljtDl5MIf();
            fillDB.fill_all(this.mycontex);
        } catch (SQLException e) {
            Log.e(ZqXxImD3Ix.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DATABASELOG, "Version Old " + oldVersion + " Version nueva: " + newVersion);
            TableUtils.createTableIfNotExists(connectionSource, Factura.class);
            TableUtils.createTableIfNotExists(connectionSource, ServicioPublico.class);
            TableUtils.createTableIfNotExists(connectionSource, PromoSMS.class);
            TableUtils.createTableIfNotExists(connectionSource, Operacion.class);
            TableUtils.createTableIfNotExists(connectionSource, CuentaBanco.class);
            TableUtils.createTableIfNotExists(connectionSource, MCBank.class);
            TableUtils.createTableIfNotExists(connectionSource, TarjetaPropia.class);
            TableUtils.createTableIfNotExists(connectionSource, Provincia.class);
            TableUtils.createTableIfNotExists(connectionSource, Municipio.class);
            TableUtils.createTableIfNotExists(connectionSource, Tributo.class);
            TableUtils.createTableIfNotExists(connectionSource, TCTicket.class);
            TableUtils.createTableIfNotExists(connectionSource, AOperKey.class);
            TableUtils.createTableIfNotExists(connectionSource, OfertasBoleto.class);
            TableUtils.createTableIfNotExists(connectionSource, CompraBoleto.class);
            TableUtils.createTableIfNotExists(connectionSource, MiBoletoService.class);
            TableUtils.createTableIfNotExists(connectionSource, TMonedasWallet.class);
            TableUtils.createTableIfNotExists(connectionSource, CompraPlanesCubacel.class);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Version");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CodigoAcceso");
            agregarAppConfigNewColumms(sqLiteDatabase, oldVersion);
            agregarAppConfigMiboletoNewColumms(sqLiteDatabase, oldVersion);
            agregarAppConfigCompraPaquetes(sqLiteDatabase, oldVersion);
            agregarAppConfigMejoraQR(sqLiteDatabase, oldVersion);
            Log.i(DATABASELOG, "onUpgrade: Tablas creaadas");
            nljtDl5MIf fillDB = new nljtDl5MIf();
            try {
                fillDB.fillList(this.mycontex);
                unYp8VQThY.getInstance().deleteProvinciaAll();
                unYp8VQThY.getInstance().deleteMunicipiosAll();
                unYp8VQThY.getInstance().deleteTributosAll();
                fillDB.fill_provincias(this.mycontex);
                fillDB.fill_municipios(this.mycontex);
                fillDB.fill_tributos(this.mycontex);
            } catch (Exception ex) {
                try {
                    if (unYp8VQThY.getInstance().deleteOperacionesAll()) {
                        fillDB.fill_all(this.mycontex);
                    }
                } catch (Exception e) {
                }
                Log.e(DATABASELOG, "onUpgrade exception nljtDl5MIf : " + ex.getMessage());
            }
            try {
                updateConfigs();
            } catch (Exception ex2) {
                Log.i(DATABASELOG, "onUpgrade2 UpgradeCodeVersion3: " + ex2.getMessage());
            }
        } catch (SQLException e2) {
            Log.i(DATABASELOG, "onUpgrade2: " + e2.getMessage());
            U6ucOCBccJ.writeLog("SQLException:" + e2.getMessage());
        } catch (java.sql.SQLException e3) {
            Log.i(DATABASELOG, "onUpgrade3: " + e3.getMessage());
            U6ucOCBccJ.writeLog("SQLException:" + e3.getMessage());
        } catch (Exception e4) {
            Log.i(DATABASELOG, "onUpgrade4: " + e4.getMessage());
            U6ucOCBccJ.writeLog("Exception:" + e4.getMessage());
        }
    }

    public void agregarAppConfigNewColumms(SQLiteDatabase database, int version) {
        if (106 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN activarussdparcial BOOLEAN DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarAppConfigMejoraQR(SQLiteDatabase database, int version) {
        if (131 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN activarMejoraQR BOOLEAN DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarAppConfigCompraPaquetes(SQLiteDatabase database, int version) {
        if (130 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN comprapaquetes INT DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarAppConfigMiboletoNewColumms(SQLiteDatabase database, int version) {
        if (135 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN activarmodulomiboleto BOOLEAN DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkMyAccount() {
        try {
            List<CuentaBanco> cuentaBancos = unYp8VQThY.getInstance().getCuentasLists();
            if (cuentaBancos != null) {
                Log.i(DATABASELOG, " onUpgrade Loop Lista  cuentasBanco" + cuentaBancos.size());
                if (cuentaBancos.size() > 0) {
                    List<CuentaBanco> cuentasNuevas = new ArrayList<>();
                    for (CuentaBanco c : cuentaBancos) {
                        CuentaBanco index = new CuentaBanco();
                        index.setCuenta(c.getCuentaOld());
                        index.setDescripcion(c.getDescripcion());
                        index.setId_client(c.getId_client());
                        cuentasNuevas.add(index);
                    }
                    unYp8VQThY.getInstance().deleteAllCuentasBanco();
                    for (CuentaBanco cuentaBanco : cuentasNuevas) {
                        unYp8VQThY.getInstance().addCuentaBanco(cuentaBanco);
                    }
                }
            }
        } catch (Exception ex) {
            Log.e(DATABASELOG, " onUpgrade checkMyAccount Exception" + ex.getMessage());
        }
    }

    public boolean importDatabase(String dbPath) throws Throwable {
        close();
        File newDb = new File(dbPath);
        File oldDb = new File(this.mycontex.getDatabasePath(DATABASE_NAME).getPath());
        if (newDb.exists()) {
            copyFile(new FileInputStream(newDb), new FileOutputStream(oldDb));
            getWritableDatabase().close();
            return true;
        }
        return false;
    }

    private void copyFile(FileInputStream fromFile, FileOutputStream toFile) throws Throwable {
        FileChannel fromChannel;
        Throwable th;
        FileChannel toChannel = null;
        try {
            fromChannel = fromFile.getChannel();
            try {
                FileChannel fromChannel2 = toFile.getChannel();
                toChannel = fromChannel2;
                fromChannel.transferTo(0L, fromChannel.size(), toChannel);
                try {
                    fromChannel.close();
                } finally {
                    if (toChannel != null) {
                        toChannel.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fromChannel != null) {
                    try {
                        fromChannel.close();
                    } finally {
                        if (toChannel != null) {
                            toChannel.close();
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fromChannel = null;
            th = th3;
        }
    }

    public void backupDatabase() throws IOException {
        if (isSDCardWriteable()) {
            String inFileName = this.mycontex.getDatabasePath(DATABASE_NAME).getPath();
            File dbFile = new File(inFileName);
            FileInputStream fis = new FileInputStream(dbFile);
            String outFileName = Environment.getExternalStorageDirectory() + "/transfermovil/" + DATABASE_NAME;
            File backupFile = new File(outFileName);
            if (backupFile.exists()) {
                backupFile.delete();
            }
            OutputStream output = new FileOutputStream(outFileName);
            byte[] buffer = new byte[RecyclerView.ViewHolder.FLAG_ADAPTER_FULLUPDATE];
            while (true) {
                int length = fis.read(buffer);
                if (length > 0) {
                    output.write(buffer, 0, length);
                } else {
                    output.flush();
                    output.close();
                    fis.close();
                    return;
                }
            }
        }
    }

    private boolean isSDCardWriteable() {
        String state = Environment.getExternalStorageState();
        if (!"mounted".equals(state)) {
            return false;
        }
        return true;
    }

    private void UpgradeCodeVersionAgente() {
        String version = this.mycontex.getString(R.string.version_transfermovil);
        List<AgentService> agentServiceList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        if (agentServiceList.size() > 0) {
            AgentService agentService = agentServiceList.get(0);
            if (!agentService.getCode().contains("-1") && !agentService.getCode().isEmpty()) {
                hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                String code = ac.en_version(1, version, agentService.getPhone());
                agentService.setCode(code);
                unYp8VQThY.getInstance().updateAgentService(agentService);
                AppConfig ap = new AppConfig();
                ap.setPhone(agentService.getPhone());
                ap.setNumber(version);
                ap.setCodigo(this.mycontex.getString(R.string.codigoAcceso));
                ap.setImei(this.mycontex.getString(R.string.new_version));
                unYp8VQThY.getInstance().addAppConfig(ap);
                return;
            }
            List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigs.size() > 0) {
                AppConfig ap2 = appConfigs.get(0);
                ap2.setNumber(version);
                ap2.setImei(this.mycontex.getString(R.string.new_version));
                unYp8VQThY.getInstance().updateAppConfig(ap2);
            }
            unYp8VQThY.getInstance().deleteAgentService(agentService);
        }
    }

    private void UpgradeCodeVersion3() {
        String version = this.mycontex.getString(R.string.version_transfermovil);
        String telefono = "0";
        List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
        List<AgentService> agentServiceList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        try {
            telefono = appConfigs.get(0).getPhone();
        } catch (Exception exphone) {
            Log.i(DATABASELOG, "onUpgrade UpgradeCodeVersion3: " + exphone.getMessage());
        }
        UpdateBuilder<AppConfig, Integer> updateBuilder = this.appConfigListDao.updateBuilder();
        try {
            updateBuilder.updateColumnValue("number", version);
            updateBuilder.updateColumnValue("codigo", this.mycontex.getString(R.string.codigoAcceso));
            updateBuilder.updateColumnValue("imei", this.mycontex.getString(R.string.new_version));
            updateBuilder.updateColumnValue("noMostrarEncuesta", false);
            updateBuilder.updateColumnValue("fechaUltimasExperiencias", new Date());
            updateBuilder.updateColumnValue("evaluacion", "-1");
            updateBuilder.updateColumnValue("mensajeInicio", true);
            updateBuilder.update();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        if (agentServiceList != null) {
            try {
                if (!agentServiceList.get(0).getCode().contains("-1") && !agentServiceList.get(0).getCode().isEmpty()) {
                    UpdateBuilder<AgentService, Integer> updateBuilderAgente = this.agentServiceListDao.updateBuilder();
                    try {
                        hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                        String code = ac.en_version(1, version, telefono);
                        updateBuilderAgente.updateColumnValue("code", code);
                        updateBuilderAgente.update();
                        try {
                            List<Operacion> operacionesAgente = unYp8VQThY.getInstance().getOperacionesListTipo(R1sDOSqZ2z.ETECSA);
                            for (Operacion op : operacionesAgente) {
                                op.setActivo(true);
                                unYp8VQThY.getInstance().updateOperacion(op);
                            }
                        } catch (Exception e2) {
                        }
                    } catch (java.sql.SQLException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
            }
        }
    }

    private void updateConfigs() {
        String version = this.mycontex.getString(R.string.version_transfermovil);
        String telefono = "0";
        List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
        List<AgentService> agentServiceList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        try {
            telefono = appConfigs.get(0).getPhone();
            Log.i(DATABASELOG, "onUpgrade updateConfigs1: " + telefono);
        } catch (Exception exphone) {
            Log.e(DATABASELOG, "onUpgrade updateConfigs1: " + exphone.getMessage());
        }
        UpdateBuilder<AppConfig, Integer> updateBuilder = this.appConfigListDao.updateBuilder();
        try {
            updateBuilder.updateColumnValue("number", version);
            updateBuilder.updateColumnValue("codigo", this.mycontex.getString(R.string.codigoAcceso));
            updateBuilder.updateColumnValue("imei", this.mycontex.getString(R.string.new_version));
            updateBuilder.updateColumnValue("noMostrarEncuesta", false);
            updateBuilder.updateColumnValue("fechaUltimasExperiencias", new Date());
            updateBuilder.updateColumnValue("evaluacion", "-1");
            updateBuilder.updateColumnValue("mensajeInicio", true);
            updateBuilder.update();
            Log.i(DATABASELOG, "onUpgrade updateConfigs2 OK");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            Log.e(DATABASELOG, "onUpgrade updateConfigs2 Exception:" + e.getSQLState() + " " + e.getMessage());
        }
        try {
            if (agentServiceList != null) {
                Log.i(DATABASELOG, "onUpgrade updateConfigs Agent 1");
                Log.i(DATABASELOG, String.format("Datos APP: id{" + agentServiceList.get(0).getId() + "}, code{" + agentServiceList.get(0).getCode() + "}, phone {" + agentServiceList.get(0).getPhone() + "}  ", new Object[0]));
                if (agentServiceList.get(0).getCode().contains("-1") || agentServiceList.get(0).getCode().isEmpty()) {
                    try {
                        unYp8VQThY.getInstance().deleteAgentService(agentServiceList.get(0));
                    } catch (Exception e2) {
                    }
                    Log.i(DATABASELOG, "onUpgrade updateConfigs Agent No es agente");
                    return;
                }
                Log.i(DATABASELOG, "onUpgrade updateConfigs Agent 2");
                UpdateBuilder<AgentService, Integer> updateBuilderAgente = this.agentServiceListDao.updateBuilder();
                try {
                    Log.i(DATABASELOG, "onUpgrade updateConfigs Agent 3");
                    hY5P1xQ5h8 ac = new hY5P1xQ5h8();
                    String code = ac.en_version(1, version, telefono);
                    updateBuilderAgente.updateColumnValue("code", code);
                    updateBuilderAgente.update();
                    try {
                        Log.i(DATABASELOG, "onUpgrade updateConfigs Agent 4");
                        List<Operacion> operacionesAgente = unYp8VQThY.getInstance().getOperacionesListTipo(R1sDOSqZ2z.ETECSA);
                        for (Operacion op : operacionesAgente) {
                            op.setActivo(true);
                            unYp8VQThY.getInstance().updateOperacion(op);
                        }
                        return;
                    } catch (Exception ex) {
                        Log.e(DATABASELOG, "onUpgrade updateConfigs Agent 4 Exception" + ex.getMessage());
                        throw new Exception(ex.getMessage());
                    }
                } catch (java.sql.SQLException e3) {
                    try {
                        unYp8VQThY.getInstance().deleteAgentService(agentServiceList.get(0));
                    } catch (Exception e4) {
                    }
                    Log.e(DATABASELOG, "onUpgrade updateConfigs Agent 3 Exception" + e3.getMessage());
                    throw new Exception(e3.getMessage());
                }
            }
            Log.i(DATABASELOG, "onUpgrade updateConfigs Agent agentServiceList is null");
        } catch (Exception ex2) {
            try {
                Log.e(DATABASELOG, "onUpgrade updateConfigs Exception Agent set default value ");
                AgentService app = unYp8VQThY.getInstance().getAllAgentServiceLists().get(0);
                app.setCode(BuildConfig.FLAVOR);
                unYp8VQThY.getInstance().updateAgentService(app);
            } catch (Exception exe) {
                Log.e(DATABASELOG, "onUpgrade updateConfigs Agent set default value  Exception: " + exe.getMessage());
            }
            Log.e(DATABASELOG, "onUpgrade updateConfigs Agent  Exception" + ex2.getMessage());
        }
    }

    public boolean tableExists(String tableName) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 1);
        if (tableName == null || db == null || !db.isOpen()) {
            return false;
        }
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", tableName});
        if (!cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        db.close();
        return count > 0;
    }

    public boolean insertData(String table, String columns, String values) {
        String sql = String.format("Insert into %s (%s) values (%s)", table, columns, values);
        SQLiteDatabase db = SQLiteDatabase.openDatabase(this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 0);
        if (db == null || !db.isOpen()) {
            return false;
        }
        Cursor cursor = db.rawQuery(sql, new String[0]);
        if (!cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        db.close();
        return count > 0;
    }

    public boolean checkIfExistDataIdentity(String table, String campo, String valor) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 1);
        if (db == null || !db.isOpen()) {
            return false;
        }
        String sql = String.format("Select count(*) from %s where %s = %s", table, campo, valor);
        Cursor cursor = db.rawQuery(sql, new String[0]);
        if (!cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        db.close();
        return count > 0;
    }

    public Dao<RecordSMS, Integer> getRecordSMSListDao() {
        if (this.recordSMSListDao == null) {
            try {
                this.recordSMSListDao = getDao(RecordSMS.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.recordSMSListDao;
    }

    public Dao<AppConfig, Integer> getAppConfigListDao() {
        if (this.appConfigListDao == null) {
            try {
                this.appConfigListDao = getDao(AppConfig.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.appConfigListDao;
    }

    public Dao<AgentService, Integer> getAgentServiceListDao() {
        if (this.agentServiceListDao == null) {
            try {
                this.agentServiceListDao = getDao(AgentService.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.agentServiceListDao;
    }

    public Dao<MiBoletoService, Integer> getMiBoletoServiceListDao() {
        if (this.miboletoServiceListDao == null) {
            try {
                this.miboletoServiceListDao = getDao(MiBoletoService.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.miboletoServiceListDao;
    }

    public Dao<BancoService, Integer> getBancoServiceListDao() {
        if (this.bancoServiceListDao == null) {
            try {
                this.bancoServiceListDao = getDao(BancoService.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.bancoServiceListDao;
    }

    public Dao<Client, Integer> getClientListDao() {
        if (this.clientListDao == null) {
            try {
                this.clientListDao = getDao(Client.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.clientListDao;
    }

    public Dao<Pin, Integer> getPinListDao() {
        if (this.pinListDao == null) {
            try {
                this.pinListDao = getDao(Pin.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.pinListDao;
    }

    public Dao<TeflMovil, Integer> getMovilesListDao() {
        if (this.telfmovilListDao == null) {
            try {
                this.telfmovilListDao = getDao(TeflMovil.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.telfmovilListDao;
    }

    public Dao<TelfFijo, Integer> getFijosListDao() {
        if (this.telfijoListDao == null) {
            try {
                this.telfijoListDao = getDao(TelfFijo.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.telfijoListDao;
    }

    public Dao<Nauta, Integer> getNautasListDao() {
        if (this.nautaListDao == null) {
            try {
                this.nautaListDao = getDao(Nauta.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.nautaListDao;
    }

    public Dao<Factura, Integer> getFacturasListDao() {
        if (this.facturasListDao == null) {
            try {
                this.facturasListDao = getDao(Factura.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.facturasListDao;
    }

    public Dao<ServicioPublico, Integer> getServiciosPublicosListDao() {
        if (this.servicioPublicosListDao == null) {
            try {
                this.servicioPublicosListDao = getDao(ServicioPublico.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.servicioPublicosListDao;
    }

    public Dao<PromoSMS, Integer> getPromosSMSListDao() {
        if (this.promosSMSListDao == null) {
            try {
                this.promosSMSListDao = getDao(PromoSMS.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.promosSMSListDao;
    }

    public Dao<Operacion, Integer> getoperacionesListDao() {
        if (this.operacionesListDao == null) {
            try {
                this.operacionesListDao = getDao(Operacion.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.operacionesListDao;
    }

    public Dao<CuentaBanco, Integer> getcuentasBancoListDao() {
        if (this.cuentasListDao == null) {
            try {
                this.cuentasListDao = getDao(CuentaBanco.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.cuentasListDao;
    }

    public Dao<MCBank, Integer> getMCBankListDao() {
        if (this.mcBanksListDao == null) {
            try {
                this.mcBanksListDao = getDao(MCBank.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.mcBanksListDao;
    }

    public Dao<TarjetaPropia, Integer> getPropiaListDao() {
        if (this.propiaListDao == null) {
            try {
                this.propiaListDao = getDao(TarjetaPropia.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.propiaListDao;
    }

    public Dao<Provincia, Integer> getProvinciasListDao() {
        if (this.provinciasListDao == null) {
            try {
                this.provinciasListDao = getDao(Provincia.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.provinciasListDao;
    }

    public Dao<Municipio, Integer> getMunicipiosListDao() {
        if (this.municipiosListDao == null) {
            try {
                this.municipiosListDao = getDao(Municipio.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.municipiosListDao;
    }

    public Dao<Tributo, Integer> getTributosListDao() {
        if (this.tributosListDao == null) {
            try {
                this.tributosListDao = getDao(Tributo.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.tributosListDao;
    }

    public Dao<TCTicket, Integer> getTcTicketsListDao() {
        if (this.tcTicketsListDao == null) {
            try {
                this.tcTicketsListDao = getDao(TCTicket.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.tcTicketsListDao;
    }

    public Dao<AOperKey, Integer> getAOperKeyListDao() {
        if (this.aoperkeyListDao == null) {
            try {
                this.aoperkeyListDao = getDao(AOperKey.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.aoperkeyListDao;
    }

    public Dao<OfertasBoleto, Integer> getOfertasBoletoListDao() {
        if (this.ofertasBoletoListDao == null) {
            try {
                this.ofertasBoletoListDao = getDao(OfertasBoleto.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.ofertasBoletoListDao;
    }

    public Dao<CompraBoleto, Integer> getCompraBoletoListDao() {
        if (this.compraBoletoListDao == null) {
            try {
                this.compraBoletoListDao = getDao(CompraBoleto.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.compraBoletoListDao;
    }

    public Dao<TMonedasWallet, Integer> getMonedasWalletListDao() {
        if (this.monedasWalletsListDao == null) {
            try {
                this.monedasWalletsListDao = getDao(TMonedasWallet.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.monedasWalletsListDao;
    }

    public Dao<CompraPlanesCubacel, Integer> getCompraPaquetesListDao() {
        if (this.compraPaquetesDao == null) {
            try {
                this.compraPaquetesDao = getDao(CompraPlanesCubacel.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return this.compraPaquetesDao;
    }
}
