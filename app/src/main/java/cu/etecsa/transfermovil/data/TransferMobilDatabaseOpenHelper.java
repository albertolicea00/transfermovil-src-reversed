package cu.etecsa.transfermovil.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import cu.etecsa.transfermovil.core.GlobalState;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.crypto.UssdCipher;
import cu.etecsa.transfermovil.data.entity.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZqXxImD3Ix
 * @fingerprint OrmLiteSqliteOpenHelper. DATABASE_NAME="TransferMDB.sqlite", DATABASE_VERSION=162.
 *              Creates/upgrades 26 tables. Migration logic adds columns for USSD parcial,
 *              QR improvements, MiBoleto, and plan purchases across versions.
 *              Backup/restore via file channel copy. Agent code re-encryption on version upgrade.
 */
public class TransferMobilDatabaseOpenHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASELOG = "DATABASELOG";
    private static final String DATABASE_NAME = "TransferMDB.sqlite";
    private static final int DATABASE_VERSION = 162;

    private Dao<AgentService, Integer> agentServiceListDao;
    private Dao<AuthSession, Integer> aoperkeyListDao;
    private Dao<AppConfig, Integer> appConfigListDao;
    private Dao<BankService, Integer> bancoServiceListDao;
    private Dao<Client, Integer> clientListDao;
    private Dao<TicketPurchase, Integer> compraBoletoListDao;
    private Dao<CubacelPlan, Integer> compraPaquetesDao;
    private Dao<BankAccountCard, Integer> cuentasListDao;
    private Dao<Invoice, Integer> facturasListDao;
    private Dao<MobileCardBank, Integer> mcBanksListDao;
    private Dao<MiBoletoService, Integer> miboletoServiceListDao;
    private Dao<WalletCurrency, Integer> monedasWalletsListDao;
    private Dao<Municipality, Integer> municipiosListDao;
    public Context mycontex;
    private Dao<NautaAccount, Integer> nautaListDao;
    private Dao<TicketOffer, Integer> ofertasBoletoListDao;
    private Dao<Operation, Integer> operacionesListDao;
    private Dao<PinEntry, Integer> pinListDao;
    private Dao<SmsPromotion, Integer> promosSMSListDao;
    private Dao<TicketServiceAccount, Integer> propiaListDao;
    private Dao<Province, Integer> provinciasListDao;
    private Dao<SmsRecord, Integer> recordSMSListDao;
    private Dao<PublicService, Integer> servicioPublicosListDao;
    private Dao<TransportTicket, Integer> tcTicketsListDao;
    private Dao<LandlinePhone, Integer> telfijoListDao;
    private Dao<MobilePhone, Integer> telfmovilListDao;
    private Dao<TaxRecord, Integer> tributosListDao;

    public TransferMobilDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mycontex = context;
    }

    public long SizeDB() {
        return this.mycontex.getDatabasePath(DATABASE_NAME).length();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Client.class);
            TableUtils.createTable(connectionSource, PinEntry.class);
            TableUtils.createTable(connectionSource, MobilePhone.class);
            TableUtils.createTable(connectionSource, LandlinePhone.class);
            TableUtils.createTable(connectionSource, NautaAccount.class);
            TableUtils.createTable(connectionSource, AgentService.class);
            TableUtils.createTable(connectionSource, SmsRecord.class);
            TableUtils.createTable(connectionSource, AppConfig.class);
            TableUtils.createTable(connectionSource, BankService.class);
            TableUtils.createTable(connectionSource, Invoice.class);
            TableUtils.createTable(connectionSource, PublicService.class);
            TableUtils.createTable(connectionSource, SmsPromotion.class);
            TableUtils.createTable(connectionSource, Operation.class);
            TableUtils.createTable(connectionSource, BankAccountCard.class);
            TableUtils.createTable(connectionSource, MobileCardBank.class);
            TableUtils.createTable(connectionSource, TicketServiceAccount.class);
            TableUtils.createTable(connectionSource, Province.class);
            TableUtils.createTable(connectionSource, Municipality.class);
            TableUtils.createTable(connectionSource, TaxRecord.class);
            TableUtils.createTable(connectionSource, TransportTicket.class);
            TableUtils.createTable(connectionSource, AuthSession.class);
            TableUtils.createTable(connectionSource, TicketOffer.class);
            TableUtils.createTable(connectionSource, TicketPurchase.class);
            TableUtils.createTable(connectionSource, MiBoletoService.class);
            TableUtils.createTable(connectionSource, WalletCurrency.class);
            TableUtils.createTable(connectionSource, CubacelPlan.class);
            OperationMenuBuilder fillDB = new OperationMenuBuilder();
            fillDB.fill_all(this.mycontex);
        } catch (SQLException e) {
            Log.e(TransferMobilDatabaseOpenHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            Log.i(DATABASELOG, "Version Old " + oldVersion + " Version nueva: " + newVersion);
            TableUtils.createTableIfNotExists(connectionSource, Invoice.class);
            TableUtils.createTableIfNotExists(connectionSource, PublicService.class);
            TableUtils.createTableIfNotExists(connectionSource, SmsPromotion.class);
            TableUtils.createTableIfNotExists(connectionSource, Operation.class);
            TableUtils.createTableIfNotExists(connectionSource, BankAccountCard.class);
            TableUtils.createTableIfNotExists(connectionSource, MobileCardBank.class);
            TableUtils.createTableIfNotExists(connectionSource, TicketServiceAccount.class);
            TableUtils.createTableIfNotExists(connectionSource, Province.class);
            TableUtils.createTableIfNotExists(connectionSource, Municipality.class);
            TableUtils.createTableIfNotExists(connectionSource, TaxRecord.class);
            TableUtils.createTableIfNotExists(connectionSource, TransportTicket.class);
            TableUtils.createTableIfNotExists(connectionSource, AuthSession.class);
            TableUtils.createTableIfNotExists(connectionSource, TicketOffer.class);
            TableUtils.createTableIfNotExists(connectionSource, TicketPurchase.class);
            TableUtils.createTableIfNotExists(connectionSource, MiBoletoService.class);
            TableUtils.createTableIfNotExists(connectionSource, WalletCurrency.class);
            TableUtils.createTableIfNotExists(connectionSource, CubacelPlan.class);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Version");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CodigoAcceso");
            addUssdPartialColumn(sqLiteDatabase, oldVersion);
            addMiBoletoColumn(sqLiteDatabase, oldVersion);
            addPlanPurchaseColumn(sqLiteDatabase, oldVersion);
            addQrImprovementColumn(sqLiteDatabase, oldVersion);

            OperationMenuBuilder fillDB = new OperationMenuBuilder();
            try {
                fillDB.fillList(this.mycontex);
                DatabaseHelper.getInstance().deleteProvinciaAll();
                DatabaseHelper.getInstance().deleteMunicipiosAll();
                DatabaseHelper.getInstance().deleteTributosAll();
                fillDB.fill_provincias(this.mycontex);
                fillDB.fill_municipios(this.mycontex);
                fillDB.fill_tributos(this.mycontex);
            } catch (Exception ex) {
                try {
                    if (DatabaseHelper.getInstance().deleteOperacionesAll()) {
                        fillDB.fill_all(this.mycontex);
                    }
                } catch (Exception e) {
                }
                Log.e(DATABASELOG, "onUpgrade exception OperationMenuBuilder : " + ex.getMessage());
            }
            try {
                updateConfigs();
            } catch (Exception ex2) {
                Log.i(DATABASELOG, "onUpgrade2 UpgradeCodeVersion3: " + ex2.getMessage());
            }
        } catch (SQLException e2) {
            Log.i(DATABASELOG, "onUpgrade2: " + e2.getMessage());
            GlobalState.writeLog("SQLException:" + e2.getMessage());
        } catch (java.sql.SQLException e3) {
            Log.i(DATABASELOG, "onUpgrade3: " + e3.getMessage());
            GlobalState.writeLog("SQLException:" + e3.getMessage());
        } catch (Exception e4) {
            Log.i(DATABASELOG, "onUpgrade4: " + e4.getMessage());
            GlobalState.writeLog("Exception:" + e4.getMessage());
        }
    }

    // v106: add activarussdparcial column
    public void addUssdPartialColumn(SQLiteDatabase database, int version) {
        if (106 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN activarussdparcial BOOLEAN DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // v131: add activarMejoraQR column
    public void addQrImprovementColumn(SQLiteDatabase database, int version) {
        if (131 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN activarMejoraQR BOOLEAN DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // v130: add comprapaquetes column
    public void addPlanPurchaseColumn(SQLiteDatabase database, int version) {
        if (130 >= version) {
            try {
                database.execSQL("ALTER TABLE `appconfig` ADD COLUMN comprapaquetes INT DEFAULT 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // v135: add activarmodulomiboleto column
    public void addMiBoletoColumn(SQLiteDatabase database, int version) {
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
            List<BankAccountCard> cuentaBancos = DatabaseHelper.getInstance().getCuentasLists();
            if (cuentaBancos != null && cuentaBancos.size() > 0) {
                List<BankAccountCard> cuentasNuevas = new ArrayList<>();
                for (BankAccountCard c : cuentaBancos) {
                    BankAccountCard index = new BankAccountCard();
                    index.setCuenta(c.getCuentaOld());
                    index.setDescripcion(c.getDescripcion());
                    index.setId_client(c.getId_client());
                    cuentasNuevas.add(index);
                }
                DatabaseHelper.getInstance().deleteAllCuentasBanco();
                for (BankAccountCard cuentaBanco : cuentasNuevas) {
                    DatabaseHelper.getInstance().addCuentaBanco(cuentaBanco);
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
        FileChannel fromChannel = null;
        FileChannel toChannel = null;
        try {
            fromChannel = fromFile.getChannel();
            toChannel = toFile.getChannel();
            fromChannel.transferTo(0L, fromChannel.size(), toChannel);
        } finally {
            if (fromChannel != null) fromChannel.close();
            if (toChannel != null) toChannel.close();
        }
    }

    public void backupDatabase() throws IOException {
        if (!isSDCardWriteable()) return;
        String inFileName = this.mycontex.getDatabasePath(DATABASE_NAME).getPath();
        FileInputStream fis = new FileInputStream(new File(inFileName));
        String outFileName = Environment.getExternalStorageDirectory() + "/transfermovil/" + DATABASE_NAME;
        File backupFile = new File(outFileName);
        if (backupFile.exists()) {
            backupFile.delete();
        }
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        fis.close();
    }

    private boolean isSDCardWriteable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private void updateConfigs() {
        String version = this.mycontex.getString(R.string.version_transfermovil);
        String telefono = "0";
        List<AppConfig> appConfigs = DatabaseHelper.getInstance().getAllAppConfigLists();
        List<AgentService> agentServiceList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        try {
            telefono = appConfigs.get(0).getPhone();
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
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try {
            if (agentServiceList != null) {
                if (agentServiceList.get(0).getCode().contains("-1")
                        || agentServiceList.get(0).getCode().isEmpty()) {
                    try {
                        DatabaseHelper.getInstance().deleteAgentService(agentServiceList.get(0));
                    } catch (Exception e2) {
                    }
                    return;
                }
                UpdateBuilder<AgentService, Integer> updateBuilderAgente = this.agentServiceListDao.updateBuilder();
                try {
                    UssdCipher ac = new UssdCipher();
                    String code = ac.en_version(1, version, telefono);
                    updateBuilderAgente.updateColumnValue("code", code);
                    updateBuilderAgente.update();
                    try {
                        List<Operation> operacionesAgente =
                                DatabaseHelper.getInstance().getOperacionesListTipo(BankType.ETECSA);
                        for (Operation op : operacionesAgente) {
                            op.setActivo(true);
                            DatabaseHelper.getInstance().updateOperacion(op);
                        }
                    } catch (Exception ex) {
                        throw new Exception(ex.getMessage());
                    }
                } catch (java.sql.SQLException e3) {
                    try {
                        DatabaseHelper.getInstance().deleteAgentService(agentServiceList.get(0));
                    } catch (Exception e4) {
                    }
                    throw new Exception(e3.getMessage());
                }
            }
        } catch (Exception ex2) {
            try {
                AgentService app = DatabaseHelper.getInstance().getAllAgentServiceLists().get(0);
                app.setCode("");
                DatabaseHelper.getInstance().updateAgentService(app);
            } catch (Exception exe) {
                Log.e(DATABASELOG, "updateConfigs Agent set default value Exception: " + exe.getMessage());
            }
        }
    }

    public boolean tableExists(String tableName) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(
                this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 1);
        if (tableName == null || db == null || !db.isOpen()) {
            return false;
        }
        Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?",
                new String[]{"table", tableName});
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
        SQLiteDatabase db = SQLiteDatabase.openDatabase(
                this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 0);
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
        SQLiteDatabase db = SQLiteDatabase.openDatabase(
                this.mycontex.getDatabasePath(DATABASE_NAME).getPath(), null, 1);
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

    // --- DAO accessors (lazy-initialized) ---

    public Dao<SmsRecord, Integer> getRecordSMSListDao() {
        if (this.recordSMSListDao == null) {
            try { this.recordSMSListDao = getDao(SmsRecord.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.recordSMSListDao;
    }

    public Dao<AppConfig, Integer> getAppConfigListDao() {
        if (this.appConfigListDao == null) {
            try { this.appConfigListDao = getDao(AppConfig.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.appConfigListDao;
    }

    public Dao<AgentService, Integer> getAgentServiceListDao() {
        if (this.agentServiceListDao == null) {
            try { this.agentServiceListDao = getDao(AgentService.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.agentServiceListDao;
    }

    public Dao<MiBoletoService, Integer> getMiBoletoServiceListDao() {
        if (this.miboletoServiceListDao == null) {
            try { this.miboletoServiceListDao = getDao(MiBoletoService.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.miboletoServiceListDao;
    }

    public Dao<BankService, Integer> getBancoServiceListDao() {
        if (this.bancoServiceListDao == null) {
            try { this.bancoServiceListDao = getDao(BankService.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.bancoServiceListDao;
    }

    public Dao<Client, Integer> getClientListDao() {
        if (this.clientListDao == null) {
            try { this.clientListDao = getDao(Client.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.clientListDao;
    }

    public Dao<PinEntry, Integer> getPinListDao() {
        if (this.pinListDao == null) {
            try { this.pinListDao = getDao(PinEntry.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.pinListDao;
    }

    public Dao<MobilePhone, Integer> getMovilesListDao() {
        if (this.telfmovilListDao == null) {
            try { this.telfmovilListDao = getDao(MobilePhone.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.telfmovilListDao;
    }

    public Dao<LandlinePhone, Integer> getFijosListDao() {
        if (this.telfijoListDao == null) {
            try { this.telfijoListDao = getDao(LandlinePhone.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.telfijoListDao;
    }

    public Dao<NautaAccount, Integer> getNautasListDao() {
        if (this.nautaListDao == null) {
            try { this.nautaListDao = getDao(NautaAccount.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.nautaListDao;
    }

    public Dao<Invoice, Integer> getFacturasListDao() {
        if (this.facturasListDao == null) {
            try { this.facturasListDao = getDao(Invoice.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.facturasListDao;
    }

    public Dao<PublicService, Integer> getServiciosPublicosListDao() {
        if (this.servicioPublicosListDao == null) {
            try { this.servicioPublicosListDao = getDao(PublicService.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.servicioPublicosListDao;
    }

    public Dao<SmsPromotion, Integer> getPromosSMSListDao() {
        if (this.promosSMSListDao == null) {
            try { this.promosSMSListDao = getDao(SmsPromotion.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.promosSMSListDao;
    }

    public Dao<Operation, Integer> getoperacionesListDao() {
        if (this.operacionesListDao == null) {
            try { this.operacionesListDao = getDao(Operation.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.operacionesListDao;
    }

    public Dao<BankAccountCard, Integer> getcuentasBancoListDao() {
        if (this.cuentasListDao == null) {
            try { this.cuentasListDao = getDao(BankAccountCard.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.cuentasListDao;
    }

    public Dao<MobileCardBank, Integer> getMCBankListDao() {
        if (this.mcBanksListDao == null) {
            try { this.mcBanksListDao = getDao(MobileCardBank.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.mcBanksListDao;
    }

    public Dao<TicketServiceAccount, Integer> getPropiaListDao() {
        if (this.propiaListDao == null) {
            try { this.propiaListDao = getDao(TicketServiceAccount.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.propiaListDao;
    }

    public Dao<Province, Integer> getProvinciasListDao() {
        if (this.provinciasListDao == null) {
            try { this.provinciasListDao = getDao(Province.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.provinciasListDao;
    }

    public Dao<Municipality, Integer> getMunicipiosListDao() {
        if (this.municipiosListDao == null) {
            try { this.municipiosListDao = getDao(Municipality.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.municipiosListDao;
    }

    public Dao<TaxRecord, Integer> getTributosListDao() {
        if (this.tributosListDao == null) {
            try { this.tributosListDao = getDao(TaxRecord.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.tributosListDao;
    }

    public Dao<TransportTicket, Integer> getTcTicketsListDao() {
        if (this.tcTicketsListDao == null) {
            try { this.tcTicketsListDao = getDao(TransportTicket.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.tcTicketsListDao;
    }

    public Dao<AuthSession, Integer> getAOperKeyListDao() {
        if (this.aoperkeyListDao == null) {
            try { this.aoperkeyListDao = getDao(AuthSession.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.aoperkeyListDao;
    }

    public Dao<TicketOffer, Integer> getOfertasBoletoListDao() {
        if (this.ofertasBoletoListDao == null) {
            try { this.ofertasBoletoListDao = getDao(TicketOffer.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.ofertasBoletoListDao;
    }

    public Dao<TicketPurchase, Integer> getCompraBoletoListDao() {
        if (this.compraBoletoListDao == null) {
            try { this.compraBoletoListDao = getDao(TicketPurchase.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.compraBoletoListDao;
    }

    public Dao<WalletCurrency, Integer> getMonedasWalletListDao() {
        if (this.monedasWalletsListDao == null) {
            try { this.monedasWalletsListDao = getDao(WalletCurrency.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.monedasWalletsListDao;
    }

    public Dao<CubacelPlan, Integer> getCompraPaquetesListDao() {
        if (this.compraPaquetesDao == null) {
            try { this.compraPaquetesDao = getDao(CubacelPlan.class); } catch (java.sql.SQLException e) { e.printStackTrace(); }
        }
        return this.compraPaquetesDao;
    }
}
