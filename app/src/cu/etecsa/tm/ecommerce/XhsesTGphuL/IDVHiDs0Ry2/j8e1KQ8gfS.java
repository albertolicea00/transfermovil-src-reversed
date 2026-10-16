package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.qztlzqkyWH;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.eLrApWcG9O;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class j8e1KQ8gfS implements RXqUCo8r9g {
    public int code;
    public Context context;
    public FhtwnBtOAx devRequest;
    public YbN03uYqWN filterRequest;
    public boolean isSuccess;
    public String mensaje;
    public OperTypeDevolucion operTypeDevolucion;
    public PYjuxvJ5mg response;
    public qztlzqkyWH responseDev;
    public SRIeLPPchM resultView;
    public String HEAD_LOG = "XLzsiVGnie";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypeDevolucion {
        LISTAR_DEVOLUCION,
        DEVOLVER_PAGO
    }

    public j8e1KQ8gfS(SRIeLPPchM resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void getDevoluciones() {
        DevListTask task = new DevListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void getDevoluciones(YbN03uYqWN filtro) {
        this.operTypeDevolucion = OperTypeDevolucion.LISTAR_DEVOLUCION;
        this.filterRequest = filtro;
        DevListTask task = new DevListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void getDevolucion(int id) {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void setProgressBarVisiblity(int visiblity) {
        SRIeLPPchM sRIeLPPchM = this.resultView;
        if (sRIeLPPchM != null) {
            sRIeLPPchM.onSetProgressBarVisibility(visiblity);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g
    public void devolverPago(FhtwnBtOAx devolverRequest) {
        this.operTypeDevolucion = OperTypeDevolucion.DEVOLVER_PAGO;
        this.devRequest = devolverRequest;
        DevListTask task = new DevListTask(this, null);
        task.execute(new String[0]);
    }

    public class DevListTask extends AsyncTask<String, Integer, Boolean> {
        public DevListTask() {
        }

        public /* synthetic */ DevListTask(j8e1KQ8gfS x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            j8e1KQ8gfS.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                eLrApWcG9O devCU = new eLrApWcG9O(j8e1KQ8gfS.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j8e1KQ8gfS$OperTypeDevolucion[j8e1KQ8gfS.this.operTypeDevolucion.ordinal()]) {
                    case 1:
                        j8e1KQ8gfS.this.response = new PYjuxvJ5mg();
                        j8e1KQ8gfS j8e1kq8gfs = j8e1KQ8gfS.this;
                        j8e1kq8gfs.response = devCU.getDevoluciones(j8e1kq8gfs.token, j8e1kq8gfs.filterRequest);
                        j8e1KQ8gfS j8e1kq8gfs2 = j8e1KQ8gfS.this;
                        j8e1kq8gfs2.isSuccess = j8e1kq8gfs2.response.isOK();
                        j8e1KQ8gfS j8e1kq8gfs3 = j8e1KQ8gfS.this;
                        j8e1kq8gfs3.mensaje = j8e1kq8gfs3.response.getMenssage();
                        break;
                    case 2:
                        j8e1KQ8gfS.this.responseDev = new qztlzqkyWH();
                        j8e1KQ8gfS j8e1kq8gfs4 = j8e1KQ8gfS.this;
                        j8e1kq8gfs4.responseDev = devCU.devolverPago(j8e1kq8gfs4.token, j8e1kq8gfs4.devRequest);
                        j8e1KQ8gfS j8e1kq8gfs5 = j8e1KQ8gfS.this;
                        j8e1kq8gfs5.isSuccess = j8e1kq8gfs5.responseDev.isOK();
                        j8e1KQ8gfS j8e1kq8gfs6 = j8e1KQ8gfS.this;
                        j8e1kq8gfs6.mensaje = j8e1kq8gfs6.responseDev.getMenssage();
                        break;
                }
                return true;
            } catch (Exception ex) {
                j8e1KQ8gfS j8e1kq8gfs7 = j8e1KQ8gfS.this;
                j8e1kq8gfs7.isSuccess = false;
                j8e1kq8gfs7.code = -1;
                j8e1kq8gfs7.mensaje = UhA7J2923N.getInstance().getMessage(500, j8e1KQ8gfS.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            j8e1KQ8gfS.this.setProgressBarVisiblity(4);
            j8e1KQ8gfS j8e1kq8gfs = j8e1KQ8gfS.this;
            if (j8e1kq8gfs.resultView != null) {
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j8e1KQ8gfS$OperTypeDevolucion[j8e1kq8gfs.operTypeDevolucion.ordinal()]) {
                    case 1:
                        j8e1KQ8gfS j8e1kq8gfs2 = j8e1KQ8gfS.this;
                        SRIeLPPchM sRIeLPPchM = j8e1kq8gfs2.resultView;
                        Boolean boolValueOf = Boolean.valueOf(j8e1kq8gfs2.isSuccess);
                        j8e1KQ8gfS j8e1kq8gfs3 = j8e1KQ8gfS.this;
                        sRIeLPPchM.onResult(boolValueOf, j8e1kq8gfs3.code, j8e1kq8gfs3.mensaje, j8e1kq8gfs3.response);
                        break;
                    case 2:
                        j8e1KQ8gfS j8e1kq8gfs4 = j8e1KQ8gfS.this;
                        SRIeLPPchM sRIeLPPchM2 = j8e1kq8gfs4.resultView;
                        Boolean boolValueOf2 = Boolean.valueOf(j8e1kq8gfs4.isSuccess);
                        j8e1KQ8gfS j8e1kq8gfs5 = j8e1KQ8gfS.this;
                        sRIeLPPchM2.onResultDevolucion(boolValueOf2, j8e1kq8gfs5.code, j8e1kq8gfs5.mensaje, j8e1kq8gfs5.responseDev);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j8e1KQ8gfS$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j8e1KQ8gfS$OperTypeDevolucion;

        static {
            int[] iArr = new int[OperTypeDevolucion.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j8e1KQ8gfS$OperTypeDevolucion = iArr;
            try {
                iArr[OperTypeDevolucion.LISTAR_DEVOLUCION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j8e1KQ8gfS$OperTypeDevolucion[OperTypeDevolucion.DEVOLVER_PAGO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
