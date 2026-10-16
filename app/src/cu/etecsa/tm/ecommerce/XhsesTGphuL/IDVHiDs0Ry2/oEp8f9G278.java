package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.zWwX278fcd;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.q0H70da5TFZ;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.V8vPhoI56gL;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class oEp8f9G278 implements V8vPhoI56gL {
    public Context context;
    public zWwX278fcd iAppInitView;
    public String HEAD_LOG = "oEp8f9G278";
    public String mensaje = " ";
    public q0H70da5TFZ stateAPP = q0H70da5TFZ.LOGIN_SIN_TOKEN;

    public oEp8f9G278(zWwX278fcd iAppInitView, Context context) {
        this.context = context;
        this.iAppInitView = iAppInitView;
    }

    public void execInitApp() {
        if (UhA7J2923N.getInstance().getApiURL() == null || UhA7J2923N.getInstance().getApiURL().length() <= 0) {
            UhA7J2923N.getInstance().setApiURL(this.context.getString(R.string.url_bulevar));
            UhA7J2923N.getInstance().setPrefCurrency("CUP");
        }
        if (UhA7J2923N.getInstance().getAccess_token() == null || UhA7J2923N.getInstance().getAccess_token().length() <= 0) {
            this.stateAPP = q0H70da5TFZ.LOGIN_SIN_TOKEN;
            this.mensaje = "No token";
        } else {
            this.stateAPP = q0H70da5TFZ.LOGINOK;
        }
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.V8vPhoI56gL
    public void iniApp() {
        InitProcessAPPTask initProcessAPPTask = new InitProcessAPPTask();
        initProcessAPPTask.execute(new Void[0]);
    }

    public class InitProcessAPPTask extends AsyncTask<Void, Void, Boolean> {
        public InitProcessAPPTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voids) {
            try {
                oEp8f9G278.this.execInitApp();
                return true;
            } catch (Exception ex) {
                Log.e(oEp8f9G278.this.HEAD_LOG, "doInBackground-Exception" + ex.getMessage());
                oEp8f9G278.this.mensaje = UhA7J2923N.getInstance().getMessage(500, oEp8f9G278.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            if (oEp8f9G278.this.iAppInitView != null) {
                if (result.booleanValue()) {
                    zWwX278fcd zwwx278fcd = oEp8f9G278.this.iAppInitView;
                    boolean zBooleanValue = result.booleanValue();
                    oEp8f9G278 oep8f9g278 = oEp8f9G278.this;
                    zwwx278fcd.initResult(zBooleanValue, oep8f9g278.stateAPP, oep8f9g278.mensaje);
                    return;
                }
                oEp8f9G278.this.iAppInitView.initResult(result.booleanValue(), q0H70da5TFZ.ERROR, oEp8f9G278.this.mensaje);
            }
        }
    }
}
