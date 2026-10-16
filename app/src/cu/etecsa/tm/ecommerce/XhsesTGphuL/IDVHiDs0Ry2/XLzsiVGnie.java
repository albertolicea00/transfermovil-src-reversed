package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.jfDH3IIARO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.j670rPXODo;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.ruM2FlC2jP;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class XLzsiVGnie implements JGlv5icCPO {
    public int code;
    public Context context;
    public zKgYf9THHQ filtroRequest;
    public boolean isSuccess;
    public String mensaje;
    public j670rPXODo response;
    public jfDH3IIARO resultView;
    public String HEAD_LOG = "XLzsiVGnie";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public XLzsiVGnie(jfDH3IIARO resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO
    public void getPagos() {
        PagosListTask task = new PagosListTask();
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO
    public void getPagos(zKgYf9THHQ filtro) {
        PagosListTask task = new PagosListTask();
        this.filtroRequest = filtro;
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO
    public void getPagoDetail(int id) {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO
    public void setProgressBarVisiblity(int visiblity) {
        jfDH3IIARO jfdh3iiaro = this.resultView;
        if (jfdh3iiaro != null) {
            jfdh3iiaro.onSetProgressBarVisibility(visiblity);
        }
    }

    public class PagosListTask extends AsyncTask<String, Integer, Boolean> {
        public PagosListTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            XLzsiVGnie.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                XLzsiVGnie.this.response = new j670rPXODo();
                ruM2FlC2jP pagosCU = new ruM2FlC2jP(XLzsiVGnie.this.context);
                XLzsiVGnie xLzsiVGnie = XLzsiVGnie.this;
                xLzsiVGnie.response = pagosCU.getPagos(xLzsiVGnie.token, xLzsiVGnie.filtroRequest);
                XLzsiVGnie xLzsiVGnie2 = XLzsiVGnie.this;
                xLzsiVGnie2.isSuccess = xLzsiVGnie2.response.isOK();
                XLzsiVGnie xLzsiVGnie3 = XLzsiVGnie.this;
                xLzsiVGnie3.mensaje = xLzsiVGnie3.response.getMenssage();
                return true;
            } catch (Exception ex) {
                XLzsiVGnie xLzsiVGnie4 = XLzsiVGnie.this;
                xLzsiVGnie4.isSuccess = false;
                xLzsiVGnie4.code = -1;
                xLzsiVGnie4.mensaje = UhA7J2923N.getInstance().getMessage(500, XLzsiVGnie.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            XLzsiVGnie.this.setProgressBarVisiblity(4);
            XLzsiVGnie xLzsiVGnie = XLzsiVGnie.this;
            jfDH3IIARO jfdh3iiaro = xLzsiVGnie.resultView;
            if (jfdh3iiaro != null) {
                Boolean boolValueOf = Boolean.valueOf(xLzsiVGnie.isSuccess);
                XLzsiVGnie xLzsiVGnie2 = XLzsiVGnie.this;
                jfdh3iiaro.onResult(boolValueOf, xLzsiVGnie2.code, xLzsiVGnie2.mensaje, xLzsiVGnie2.response);
            }
        }
    }
}
