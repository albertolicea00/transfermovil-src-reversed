package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.ZJDahAOo71x;

/* JADX INFO: loaded from: classes.dex */
public class Ax4arraYwv {
    private static Ax4arraYwv instance;
    private TVYvUziTDv callback;

    private Ax4arraYwv() {
    }

    public static synchronized Ax4arraYwv getInstance() {
        if (instance == null) {
            instance = new Ax4arraYwv();
        }
        return instance;
    }

    public void setCallback(TVYvUziTDv callback) {
        this.callback = callback;
    }

    public TVYvUziTDv getCallback() {
        return this.callback;
    }
}
