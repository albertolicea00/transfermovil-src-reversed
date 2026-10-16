package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.L6l0bKlV5aq;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.ImIDy2TQHP;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.gC3MfWqxUy;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class c1TYoqkyyPA implements mAtrYjNld7 {
    public String HEAD_LOG = "c1TYoqkyyPA";
    public int code;
    public Context context;
    public boolean isSuccess;
    public boolean isViewFactor;
    public String mensaje;
    public gC3MfWqxUy response;
    public L6l0bKlV5aq resultView;

    public c1TYoqkyyPA(L6l0bKlV5aq loginView, Context context) {
        this.context = context;
        this.resultView = loginView;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7
    public void login(String username, String password) {
        LoginTask task = new LoginTask();
        this.isViewFactor = false;
        task.execute(username, password, BuildConfig.FLAVOR);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7
    public void loginFactor(String username, String password, String factor) {
        LoginTask task = new LoginTask();
        this.isViewFactor = true;
        task.execute(username, password, factor);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.mAtrYjNld7
    public void setProgressBarVisiblity(int visiblity) {
        L6l0bKlV5aq l6l0bKlV5aq = this.resultView;
        if (l6l0bKlV5aq != null) {
            l6l0bKlV5aq.onSetProgressBarVisibility(visiblity);
        }
    }

    public class LoginTask extends AsyncTask<String, Integer, Boolean> {
        public LoginTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            c1TYoqkyyPA.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                c1TYoqkyyPA.this.response = new gC3MfWqxUy();
                ImIDy2TQHP perfilCU = new ImIDy2TQHP(c1TYoqkyyPA.this.context);
                c1TYoqkyyPA.this.response = perfilCU.login(strings[0], strings[1], strings[2]);
                c1TYoqkyyPA c1tyoqkyypa = c1TYoqkyyPA.this;
                c1tyoqkyypa.isSuccess = c1tyoqkyypa.response.isOK();
                c1TYoqkyyPA c1tyoqkyypa2 = c1TYoqkyyPA.this;
                c1tyoqkyypa2.mensaje = c1tyoqkyypa2.response.getMenssage();
                return true;
            } catch (Exception ex) {
                c1TYoqkyyPA c1tyoqkyypa3 = c1TYoqkyyPA.this;
                c1tyoqkyypa3.isSuccess = false;
                c1tyoqkyypa3.code = -1;
                c1tyoqkyypa3.mensaje = UhA7J2923N.getInstance().getMessage(500, c1TYoqkyyPA.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            c1TYoqkyyPA.this.setProgressBarVisiblity(4);
            c1TYoqkyyPA c1tyoqkyypa = c1TYoqkyyPA.this;
            L6l0bKlV5aq l6l0bKlV5aq = c1tyoqkyypa.resultView;
            if (l6l0bKlV5aq != null) {
                if (c1tyoqkyypa.isViewFactor) {
                    Boolean boolValueOf = Boolean.valueOf(c1tyoqkyypa.isSuccess);
                    c1TYoqkyyPA c1tyoqkyypa2 = c1TYoqkyyPA.this;
                    l6l0bKlV5aq.onResultFactor(boolValueOf, c1tyoqkyypa2.code, c1tyoqkyypa2.mensaje);
                } else {
                    Boolean boolValueOf2 = Boolean.valueOf(c1tyoqkyypa.isSuccess);
                    c1TYoqkyyPA c1tyoqkyypa3 = c1TYoqkyyPA.this;
                    l6l0bKlV5aq.onResult(boolValueOf2, c1tyoqkyypa3.code, c1tyoqkyypa3.mensaje);
                }
            }
        }
    }
}
