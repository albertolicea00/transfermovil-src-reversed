package cu.etecsa.transfermovil.data;

import android.content.Context;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.data.entity.AppConfig;
import cu.etecsa.transfermovil.data.entity.AgentAccount;
import cu.etecsa.transfermovil.data.entity.BankAccount;
import cu.etecsa.transfermovil.data.entity.TicketServiceAccount;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF
 * @fingerprint Extends BaseMainActivity. Accessor for phone, version, agent/bank/boleto codes
 *              stored in AppConfig/AgentAccount/BancoService/TicketServiceAccount tables.
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
        List<AgentAccount> agentConfigList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return "";
        }
        return agentConfigList.get(0).getCode();
    }

    public String getCodigoAgente(Context ct) {
        DatabaseHelper.init(ct);
        List<AgentAccount> agentConfigList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return "";
        }
        return agentConfigList.get(0).getCode();
    }

    public void setCodigoAgente(String code) {
        DatabaseHelper.init(getBaseContext());
        List<AgentAccount> agentList = DatabaseHelper.getInstance().getAllAgentServiceLists();
        if (agentList.size() > 0) {
            AgentAccount app = agentList.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateAgentService(app);
        } else {
            AgentAccount app = new AgentAccount();
            app.setCode(code);
            DatabaseHelper.getInstance().addAgentService(app);
        }
    }

    public String getCodigoMiBoleto() {
        DatabaseHelper.init(getBaseContext());
        List<TicketServiceAccount> list = DatabaseHelper.getInstance().getAllMiBoletoServiceLists();
        if (list.size() <= 0) {
            return "";
        }
        return list.get(0).getCode();
    }

    public void setCodigoMiBoleto(String code) {
        DatabaseHelper.init(getBaseContext());
        List<TicketServiceAccount> list = DatabaseHelper.getInstance().getAllMiBoletoServiceLists();
        if (list.size() > 0) {
            TicketServiceAccount app = list.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateMiBoletoService(app);
        } else {
            TicketServiceAccount app = new TicketServiceAccount();
            app.setCode(code);
            DatabaseHelper.getInstance().addMiBoletoService(app);
        }
    }

    public String getCodigoBanco() {
        DatabaseHelper.init(getBaseContext());
        List<BankAccount> bankConfigList = DatabaseHelper.getInstance().getAllBancoServiceLists();
        if (bankConfigList.size() <= 0) {
            return "";
        }
        return bankConfigList.get(0).getCode();
    }

    public void setCodigoBanco(String code) {
        DatabaseHelper.init(getBaseContext());
        List<BankAccount> bList = DatabaseHelper.getInstance().getAllBancoServiceLists();
        if (bList.size() > 0) {
            BankAccount app = bList.get(0);
            app.setCode(code);
            DatabaseHelper.getInstance().updateBancoService(app);
        } else {
            BankAccount bank = new BankAccount();
            bank.setCode(code);
            DatabaseHelper.getInstance().addBancoService(bank);
        }
    }
}
