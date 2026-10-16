package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.bIqwjujBCy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.cT6z0jcLEG;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OSQajAAbpl;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.luC26d6Wdp;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.yl2MWOolvQ;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class j2tvTITC0Z implements Y5RKazbgNj {
    public int code;
    public Context context;
    public boolean isSuccess;
    public String mensaje;
    public OperTypeEstadisticas operTypeEstadisticas;
    public cT6z0jcLEG request;
    public tVwkzUCBeV requestCuadre;
    public OSQajAAbpl response;
    public luC26d6Wdp responseCuadre;
    public bIqwjujBCy resultCuadreView;
    public Df8kK2jSQl resultView;
    public String HEAD_LOG = "j2tvTITC0Z";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypeEstadisticas {
        GET_SIMPLE,
        GET_TOTAL,
        GET_CUADRE
    }

    public j2tvTITC0Z(Df8kK2jSQl resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    public j2tvTITC0Z(bIqwjujBCy resultView, Context context) {
        this.resultCuadreView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj
    public void getEstadisticaSimple(cT6z0jcLEG request) {
        this.request = request;
        this.operTypeEstadisticas = OperTypeEstadisticas.GET_SIMPLE;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj
    public void getEstadisticassTotal(cT6z0jcLEG request) {
        this.request = request;
        this.operTypeEstadisticas = OperTypeEstadisticas.GET_TOTAL;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj
    public void getEstadisticasCuadre(tVwkzUCBeV request) {
        this.requestCuadre = request;
        this.operTypeEstadisticas = OperTypeEstadisticas.GET_CUADRE;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj
    public void setProgressBarVisiblity(int visiblity) {
        Df8kK2jSQl df8kK2jSQl = this.resultView;
        if (df8kK2jSQl != null) {
            df8kK2jSQl.onSetProgressLoadVisibility(visiblity);
        }
    }

    public class ExcTask extends AsyncTask<String, Integer, Boolean> {
        public ExcTask() {
        }

        public /* synthetic */ ExcTask(j2tvTITC0Z x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            j2tvTITC0Z.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                yl2MWOolvQ estadisticasCU = new yl2MWOolvQ(j2tvTITC0Z.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j2tvTITC0Z$OperTypeEstadisticas[j2tvTITC0Z.this.operTypeEstadisticas.ordinal()]) {
                    case 1:
                        j2tvTITC0Z.this.response = new OSQajAAbpl();
                        j2tvTITC0Z j2tvtitc0z = j2tvTITC0Z.this;
                        j2tvtitc0z.response = estadisticasCU.getPagos(j2tvtitc0z.token, j2tvtitc0z.request);
                        j2tvTITC0Z j2tvtitc0z2 = j2tvTITC0Z.this;
                        j2tvtitc0z2.isSuccess = j2tvtitc0z2.response.isOK();
                        j2tvTITC0Z j2tvtitc0z3 = j2tvTITC0Z.this;
                        j2tvtitc0z3.mensaje = j2tvtitc0z3.response.getMenssage();
                        j2tvTITC0Z j2tvtitc0z4 = j2tvTITC0Z.this;
                        j2tvtitc0z4.code = j2tvtitc0z4.response.getHttpCode();
                        break;
                    case 2:
                        new OSQajAAbpl();
                        j2tvTITC0Z j2tvtitc0z5 = j2tvTITC0Z.this;
                        OSQajAAbpl responsePagos = estadisticasCU.getPagos(j2tvtitc0z5.token, j2tvtitc0z5.request);
                        new OSQajAAbpl();
                        j2tvTITC0Z j2tvtitc0z6 = j2tvTITC0Z.this;
                        OSQajAAbpl responseCantPagos = estadisticasCU.getCantidadPagos(j2tvtitc0z6.token, j2tvtitc0z6.request);
                        new OSQajAAbpl();
                        j2tvTITC0Z j2tvtitc0z7 = j2tvTITC0Z.this;
                        OSQajAAbpl responseDevPagos = estadisticasCU.getCantidadDevoluciones(j2tvtitc0z7.token, j2tvtitc0z7.request);
                        j2tvTITC0Z.this.response = new OSQajAAbpl();
                        j2tvTITC0Z.this.response.setStatsDay(responsePagos.getStatsDay());
                        j2tvTITC0Z.this.response.setStatsWeek(responsePagos.getStatsWeek());
                        j2tvTITC0Z.this.response.setStatsMonth(responsePagos.getStatsMonth());
                        j2tvTITC0Z.this.response.setStatsYear(responsePagos.getStatsYear());
                        j2tvTITC0Z.this.response.setDayConfirm(responseCantPagos.getDayConfirm());
                        j2tvTITC0Z.this.response.setDayPend(responseCantPagos.getDayPend());
                        j2tvTITC0Z.this.response.setDayAbort(responseCantPagos.getDayAbort());
                        j2tvTITC0Z.this.response.setMesConfirm(responseCantPagos.getMesConfirm());
                        j2tvTITC0Z.this.response.setMesPend(responseCantPagos.getMesPend());
                        j2tvTITC0Z.this.response.setMesAbort(responseCantPagos.getMesAbort());
                        j2tvTITC0Z.this.response.setYearConfirm(responseCantPagos.getYearConfirm());
                        j2tvTITC0Z.this.response.setYearPend(responseCantPagos.getYearPend());
                        j2tvTITC0Z.this.response.setYearAbort(responseCantPagos.getYearAbort());
                        j2tvTITC0Z.this.response.setDevDayConfim(responseDevPagos.getDevDayConfim());
                        j2tvTITC0Z.this.response.setDevDayPend(responseDevPagos.getDevDayPend());
                        j2tvTITC0Z.this.response.setDevDayAbort(responseDevPagos.getDevDayAbort());
                        j2tvTITC0Z.this.response.setDevMesConfirm(responseDevPagos.getDevMesConfirm());
                        j2tvTITC0Z.this.response.setDevDayPend(responseDevPagos.getDevDayPend());
                        j2tvTITC0Z.this.response.setDevDayAbort(responseDevPagos.getDevDayAbort());
                        j2tvTITC0Z.this.response.setDevYearConfirm(responseDevPagos.getDevYearConfirm());
                        j2tvTITC0Z.this.response.setDevYearPend(responseDevPagos.getDevYearPend());
                        j2tvTITC0Z.this.response.setDevYearAbort(responseDevPagos.getDevYearAbort());
                        if (responsePagos.isOK() && responseCantPagos.isOK() && responseDevPagos.isOK()) {
                            j2tvTITC0Z j2tvtitc0z8 = j2tvTITC0Z.this;
                            j2tvtitc0z8.isSuccess = true;
                            j2tvtitc0z8.response.setOK(true);
                            j2tvTITC0Z.this.mensaje = "OK";
                        } else {
                            j2tvTITC0Z j2tvtitc0z9 = j2tvTITC0Z.this;
                            j2tvtitc0z9.isSuccess = false;
                            j2tvtitc0z9.response.setOK(false);
                            j2tvTITC0Z.this.code = responseCantPagos.getHttpCode();
                            j2tvTITC0Z.this.mensaje = responsePagos.getMenssage();
                        }
                        j2tvTITC0Z j2tvtitc0z10 = j2tvTITC0Z.this;
                        j2tvtitc0z10.mensaje = j2tvtitc0z10.response.getMenssage();
                        break;
                    case 3:
                        j2tvTITC0Z.this.responseCuadre = new luC26d6Wdp();
                        j2tvTITC0Z j2tvtitc0z11 = j2tvTITC0Z.this;
                        j2tvtitc0z11.responseCuadre = estadisticasCU.getCuadre(j2tvtitc0z11.token, j2tvtitc0z11.requestCuadre);
                        j2tvTITC0Z j2tvtitc0z12 = j2tvTITC0Z.this;
                        j2tvtitc0z12.isSuccess = j2tvtitc0z12.responseCuadre.isOK();
                        j2tvTITC0Z j2tvtitc0z13 = j2tvTITC0Z.this;
                        j2tvtitc0z13.mensaje = j2tvtitc0z13.responseCuadre.getMenssage();
                        j2tvTITC0Z j2tvtitc0z14 = j2tvTITC0Z.this;
                        j2tvtitc0z14.code = j2tvtitc0z14.responseCuadre.getHttpCode();
                        break;
                }
                return true;
            } catch (Exception ex) {
                j2tvTITC0Z j2tvtitc0z15 = j2tvTITC0Z.this;
                j2tvtitc0z15.isSuccess = false;
                j2tvtitc0z15.code = -1;
                j2tvtitc0z15.mensaje = UhA7J2923N.getInstance().getMessage(500, j2tvTITC0Z.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            j2tvTITC0Z.this.setProgressBarVisiblity(4);
            j2tvTITC0Z j2tvtitc0z = j2tvTITC0Z.this;
            Df8kK2jSQl df8kK2jSQl = j2tvtitc0z.resultView;
            if (df8kK2jSQl != null || j2tvtitc0z.resultCuadreView != null) {
                if (j2tvtitc0z.operTypeEstadisticas != OperTypeEstadisticas.GET_CUADRE) {
                    Boolean boolValueOf = Boolean.valueOf(j2tvtitc0z.isSuccess);
                    j2tvTITC0Z j2tvtitc0z2 = j2tvTITC0Z.this;
                    df8kK2jSQl.onResultEstadisticas(boolValueOf, j2tvtitc0z2.code, j2tvtitc0z2.mensaje, j2tvtitc0z2.response);
                } else {
                    bIqwjujBCy biqwjujbcy = j2tvtitc0z.resultCuadreView;
                    Boolean boolValueOf2 = Boolean.valueOf(j2tvtitc0z.isSuccess);
                    j2tvTITC0Z j2tvtitc0z3 = j2tvTITC0Z.this;
                    biqwjujbcy.onResultEstadisticas(boolValueOf2, j2tvtitc0z3.code, j2tvtitc0z3.mensaje, j2tvtitc0z3.responseCuadre);
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j2tvTITC0Z$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j2tvTITC0Z$OperTypeEstadisticas;

        static {
            int[] iArr = new int[OperTypeEstadisticas.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j2tvTITC0Z$OperTypeEstadisticas = iArr;
            try {
                iArr[OperTypeEstadisticas.GET_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j2tvTITC0Z$OperTypeEstadisticas[OperTypeEstadisticas.GET_TOTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$j2tvTITC0Z$OperTypeEstadisticas[OperTypeEstadisticas.GET_CUADRE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
