package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.Nm2a3aUwFB;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.p0XuqX2hWag;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.u1cC1eLpoh3;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class Y4BGwPjdRJT implements u1cC1eLpoh3 {
    public int code;
    public Context context;
    public boolean isSuccess;
    public String mensaje;
    public p0XuqX2hWag response;
    public m7xsfApYLch resultView;
    public String HEAD_LOG = "Y4BGwPjdRJT";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public Y4BGwPjdRJT(m7xsfApYLch resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.u1cC1eLpoh3
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.u1cC1eLpoh3
    public void getHashtag() {
        HashTagListTask task = new HashTagListTask();
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.u1cC1eLpoh3
    public void setProgressBarVisiblity(int visiblity) {
        m7xsfApYLch m7xsfapylch = this.resultView;
        if (m7xsfapylch != null) {
            m7xsfapylch.onSetProgressBarVisibility(visiblity);
        }
    }

    public class HashTagListTask extends AsyncTask<String, Integer, Boolean> {
        public HashTagListTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            Y4BGwPjdRJT.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                Y4BGwPjdRJT.this.response = new p0XuqX2hWag();
                Nm2a3aUwFB hashtagCU = new Nm2a3aUwFB(Y4BGwPjdRJT.this.context);
                Y4BGwPjdRJT y4BGwPjdRJT = Y4BGwPjdRJT.this;
                y4BGwPjdRJT.response = hashtagCU.getHashtags(y4BGwPjdRJT.token);
                Y4BGwPjdRJT y4BGwPjdRJT2 = Y4BGwPjdRJT.this;
                y4BGwPjdRJT2.isSuccess = y4BGwPjdRJT2.response.isOK();
                Y4BGwPjdRJT y4BGwPjdRJT3 = Y4BGwPjdRJT.this;
                y4BGwPjdRJT3.mensaje = y4BGwPjdRJT3.response.getMenssage();
                return true;
            } catch (Exception ex) {
                Y4BGwPjdRJT y4BGwPjdRJT4 = Y4BGwPjdRJT.this;
                y4BGwPjdRJT4.isSuccess = false;
                y4BGwPjdRJT4.code = -1;
                y4BGwPjdRJT4.mensaje = UhA7J2923N.getInstance().getMessage(500, Y4BGwPjdRJT.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            Y4BGwPjdRJT.this.setProgressBarVisiblity(4);
            Y4BGwPjdRJT y4BGwPjdRJT = Y4BGwPjdRJT.this;
            m7xsfApYLch m7xsfapylch = y4BGwPjdRJT.resultView;
            if (m7xsfapylch != null) {
                Boolean boolValueOf = Boolean.valueOf(y4BGwPjdRJT.isSuccess);
                Y4BGwPjdRJT y4BGwPjdRJT2 = Y4BGwPjdRJT.this;
                m7xsfapylch.onResultTags(boolValueOf, y4BGwPjdRJT2.code, y4BGwPjdRJT2.mensaje, y4BGwPjdRJT2.response);
            }
        }
    }
}
