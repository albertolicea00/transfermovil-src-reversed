package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.doK2nmcsGSe;

/* JADX INFO: loaded from: classes.dex */
public class jUkmOGHTpN {
    private static jUkmOGHTpN instance;
    private naLGp4k3kz callback;

    private jUkmOGHTpN() {
    }

    public static synchronized jUkmOGHTpN getInstance() {
        if (instance == null) {
            instance = new jUkmOGHTpN();
        }
        return instance;
    }

    public void setCallback(naLGp4k3kz callback) {
        this.callback = callback;
    }

    public naLGp4k3kz getCallback() {
        return this.callback;
    }
}
