package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM;

import android.content.Context;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AgentService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.BancoService;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MiBoletoService;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Fr52O1uSYF extends rDEl7rW1aN {
    public String getPhone() {
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AppConfig app = appConfigList.get(0);
        String phone = app.getPhone();
        return phone;
    }

    public String getPhone(Context ct) {
        unYp8VQThY.init(ct);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AppConfig app = appConfigList.get(0);
        String phone = app.getPhone();
        return phone;
    }

    public void setPhone(String phone) {
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() > 0) {
            AppConfig app = appConfigList.get(0);
            app.setPhone(phone);
            unYp8VQThY.getInstance().updateAppConfig(app);
        }
    }

    public void setPhone(String phone, Context ct) {
        unYp8VQThY.init(ct);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() > 0) {
            AppConfig app = appConfigList.get(0);
            app.setPhone(phone);
            unYp8VQThY.getInstance().updateAppConfig(app);
        }
    }

    public String getVersion() {
        unYp8VQThY.init(getBaseContext());
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AppConfig app = appConfigList.get(0);
        String version = app.getNumber();
        return version;
    }

    public String getVersion(Context ct) {
        unYp8VQThY.init(ct);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AppConfig app = appConfigList.get(0);
        String version = app.getNumber();
        return version;
    }

    public String getCodigoAgente() {
        unYp8VQThY.init(getBaseContext());
        List<AgentService> agentConfigList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AgentService app = agentConfigList.get(0);
        String code = app.getCode();
        return code;
    }

    public String getCodigoMiBoleto() {
        unYp8VQThY.init(getBaseContext());
        List<MiBoletoService> agentConfigList = unYp8VQThY.getInstance().getAllMiBoletoServiceLists();
        if (agentConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        MiBoletoService app = agentConfigList.get(0);
        String code = app.getCode();
        return code;
    }

    public String getCodigoAgente(Context ct) {
        unYp8VQThY.init(ct);
        List<AgentService> agentConfigList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        if (agentConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        AgentService app = agentConfigList.get(0);
        String code = app.getCode();
        return code;
    }

    public void setCodigoAgente(String code) {
        unYp8VQThY.init(getBaseContext());
        List<AgentService> agentList = unYp8VQThY.getInstance().getAllAgentServiceLists();
        if (agentList.size() > 0) {
            AgentService app = agentList.get(0);
            app.setCode(code);
            unYp8VQThY.getInstance().updateAgentService(app);
        } else {
            AgentService app2 = new AgentService();
            app2.setCode(code);
            unYp8VQThY.getInstance().addAgentService(app2);
        }
    }

    public void setCodigoMiBoleto(String code) {
        unYp8VQThY.init(getBaseContext());
        List<MiBoletoService> agentList = unYp8VQThY.getInstance().getAllMiBoletoServiceLists();
        if (agentList.size() > 0) {
            MiBoletoService app = agentList.get(0);
            app.setCode(code);
            unYp8VQThY.getInstance().updateMiBoletoService(app);
        } else {
            MiBoletoService app2 = new MiBoletoService();
            app2.setCode(code);
            unYp8VQThY.getInstance().addMiBoletoService(app2);
        }
    }

    public String getCodigoBanco() {
        unYp8VQThY.init(getBaseContext());
        List<BancoService> bankConfigList = unYp8VQThY.getInstance().getAllBancoServiceLists();
        if (bankConfigList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        BancoService bank = bankConfigList.get(0);
        String code = bank.getCode();
        return code;
    }

    public void setCodigoBanco(String code) {
        unYp8VQThY.init(getBaseContext());
        List<BancoService> bList = unYp8VQThY.getInstance().getAllBancoServiceLists();
        if (bList.size() > 0) {
            BancoService app = bList.get(0);
            app.setCode(code);
            unYp8VQThY.getInstance().updateBancoService(app);
        } else {
            BancoService bank = new BancoService();
            bank.setCode(code);
            unYp8VQThY.getInstance().addBancoService(bank);
        }
    }
}
