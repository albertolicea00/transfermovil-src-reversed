package cu.etecsa.transfermovil.data;

import android.content.Context;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.data.entity.AppConfig;
import cu.etecsa.transfermovil.data.entity.AgentService;
import cu.etecsa.transfermovil.data.entity.BankService;
import cu.etecsa.transfermovil.data.entity.MiBoletoService;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF
 * @fingerprint Extends BaseMainActivity. Accessor for phone, version, agent/bank/boleto codes
 *              stored in AppConfig/AgentService/BancoService/MiBoletoService tables.
 */
public class SharedPreferencesAccessor extends BaseMainActivity {

    public String getPhone() {
        DatabaseHelper.init(getBaseContext());
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return "";
        }
        return appConfigList.get(0).getPhone();
    }

    public String getPhone(Context ct) {
        DatabaseHelper.init(ct);
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return "";
        }
        return appConfigList.get(0).getPhone();
    }

    public void setPhone(String phone) {
        DatabaseHelper.init(getBaseContext());
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() > 0) {
            AppConfig app = appConfigList.get(0);
            app.setPhone(phone);
            DatabaseHelper.getInstance().updateAppConfig(app);
        }
    }

    public void setPhone(String phone, Context ct) {
        DatabaseHelper.init(ct);
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() > 0) {
            AppConfig app = appConfigList.get(0);
            app.setPhone(phone);
            DatabaseHelper.getInstance().updateAppConfig(app);
        }
    }

    public String getVersion() {
        DatabaseHelper.init(getBaseContext());
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return "";
        }
        return appConfigList.get(0).getNumber();
    }

    public String getVersion(Context ct) {
        DatabaseHelper.init(ct);
        List<AppConfig> appConfigList = DatabaseHelper.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return "";
        }
        return appConfigList.get(0).getNumber();
    }

    public String getCodigoAgente() {
        DatabaseHelper.init(getBaseContext());
        List<AgentService> agentConfigList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return "";
        }
        return agentConfigList.get(0).getCode();
    }

    public String getCodigoAgente(Context ct) {
        DatabaseHelper.init(ct);
        List<AgentService> agentConfigList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return "";
        }
        return agentConfigList.get(0).getCode();
    }

    public void setCodigoAgente(String code) {
        DatabaseHelper.init(getBaseContext());
        List<AgentService> agentList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentList.size() > 0) {
            AgentService app = agentList.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateAgentService(app);
        } else {
            AgentService app = new AgentService();
            app.setCode(code);
            DatabaseHelper.getInstance().addAgentService(app);
        }
    }

    public String getCodigoMiBoleto() {
        DatabaseHelper.init(getBaseContext());
        List<MiBoletoService> list = DatabaseHelper.getInstance().getAllMiBoletoServiceLists();
        if (list.size() <= 0) {
            return "";
        }
        return list.get(0).getCode();
    }

    public void setCodigoMiBoleto(String code) {
        DatabaseHelper.init(getBaseContext());
        List<MiBoletoService> list = DatabaseHelper.getInstance().getAllMiBoletoServiceLists();
        if (list.size() > 0) {
            MiBoletoService app = list.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateMiBoletoService(app);
        } else {
            MiBoletoService app = new MiBoletoService();
            app.setCode(code);
            DatabaseHelper.getInstance().addMiBoletoService(app);
        }
    }

    public String getCodigoBanco() {
        DatabaseHelper.init(getBaseContext());
        List<BankService> bankConfigList = DatabaseHelper.getInstance().getAllBancoServiceLists();
        if (bankConfigList.size() <= 0) {
            return "";
        }
        return bankConfigList.get(0).getCode();
    }

    public void setCodigoBanco(String code) {
        DatabaseHelper.init(getBaseContext());
        List<BankService> bList = DatabaseHelper.getInstance().getAllBancoServiceLists();
        if (bList.size() > 0) {
            BankService app = bList.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateBancoService(app);
        } else {
            BankService bank = new BankService();
            bank.setCode(code);
            DatabaseHelper.getInstance().addBancoService(bank);
        }
    }
}
