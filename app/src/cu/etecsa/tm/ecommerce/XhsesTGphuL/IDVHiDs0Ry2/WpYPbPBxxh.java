package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.ZsIJgHaaO9;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.Y8m8V0frIX;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.hJ45hA3s7Q;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XhtLGYy0Bo;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.xc7SYjTCzp;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class WpYPbPBxxh implements PgpBvfqqU4 {
    public int code;
    public Context context;
    public boolean isSuccess;
    public String mensaje;
    public hJ45hA3s7Q negocioCRUDRequest;
    public OperTypeNegocio operTypeNegocio;
    public xc7SYjTCzp response;
    public kf1rAJ1MG4 responseBase;
    public ZsIJgHaaO9 resultView;
    public String HEAD_LOG = "WpYPbPBxxh";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypeNegocio {
        GET_LISTA_NEGOCIO,
        CREAR_NEGOCIO,
        UPDATE_NEGOCIO,
        DELETE_NEGOCIO
    }

    public WpYPbPBxxh(ZsIJgHaaO9 resultView, Context context) {
        this.context = context;
        this.resultView = resultView;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void getNegocios() {
        this.operTypeNegocio = OperTypeNegocio.GET_LISTA_NEGOCIO;
        NegociosListTask task = new NegociosListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void negocioCRUD(Y8m8V0frIX crudEnum, hJ45hA3s7Q request) {
        this.negocioCRUDRequest = request;
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[crudEnum.ordinal()]) {
            case 1:
                this.operTypeNegocio = OperTypeNegocio.CREAR_NEGOCIO;
                break;
            case 2:
                this.operTypeNegocio = OperTypeNegocio.UPDATE_NEGOCIO;
                break;
            case 3:
                this.operTypeNegocio = OperTypeNegocio.DELETE_NEGOCIO;
                break;
        }
        NegociosListTask task = new NegociosListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void getCuentasNegocios() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void getCuentasNegocio(int idNegocio) {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4
    public void setProgressBarVisiblity(int visiblity) {
        ZsIJgHaaO9 zsIJgHaaO9 = this.resultView;
        if (zsIJgHaaO9 != null) {
            zsIJgHaaO9.onSetProgressBarVisibility(visiblity);
        }
    }

    public class NegociosListTask extends AsyncTask<String, Integer, Boolean> {
        public NegociosListTask() {
        }

        public /* synthetic */ NegociosListTask(WpYPbPBxxh x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            WpYPbPBxxh.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                XhtLGYy0Bo negociosCU = new XhtLGYy0Bo(WpYPbPBxxh.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[WpYPbPBxxh.this.operTypeNegocio.ordinal()]) {
                    case 1:
                        WpYPbPBxxh.this.response = new xc7SYjTCzp();
                        WpYPbPBxxh wpYPbPBxxh = WpYPbPBxxh.this;
                        wpYPbPBxxh.response = negociosCU.getNegociosCuentas(wpYPbPBxxh.token);
                        WpYPbPBxxh wpYPbPBxxh2 = WpYPbPBxxh.this;
                        wpYPbPBxxh2.isSuccess = wpYPbPBxxh2.response.isOK();
                        WpYPbPBxxh wpYPbPBxxh3 = WpYPbPBxxh.this;
                        wpYPbPBxxh3.mensaje = wpYPbPBxxh3.response.getMenssage();
                        break;
                    case 2:
                        WpYPbPBxxh.this.responseBase = new kf1rAJ1MG4();
                        WpYPbPBxxh wpYPbPBxxh4 = WpYPbPBxxh.this;
                        wpYPbPBxxh4.responseBase = negociosCU.createNegocio(wpYPbPBxxh4.negocioCRUDRequest, wpYPbPBxxh4.token);
                        WpYPbPBxxh wpYPbPBxxh5 = WpYPbPBxxh.this;
                        wpYPbPBxxh5.isSuccess = wpYPbPBxxh5.responseBase.isOK();
                        WpYPbPBxxh wpYPbPBxxh6 = WpYPbPBxxh.this;
                        wpYPbPBxxh6.mensaje = wpYPbPBxxh6.responseBase.getMenssage();
                        break;
                    case 3:
                        WpYPbPBxxh.this.responseBase = new kf1rAJ1MG4();
                        WpYPbPBxxh wpYPbPBxxh7 = WpYPbPBxxh.this;
                        wpYPbPBxxh7.responseBase = negociosCU.updateNegocio(wpYPbPBxxh7.negocioCRUDRequest, wpYPbPBxxh7.token);
                        WpYPbPBxxh wpYPbPBxxh8 = WpYPbPBxxh.this;
                        wpYPbPBxxh8.isSuccess = wpYPbPBxxh8.responseBase.isOK();
                        WpYPbPBxxh wpYPbPBxxh9 = WpYPbPBxxh.this;
                        wpYPbPBxxh9.mensaje = wpYPbPBxxh9.responseBase.getMenssage();
                        break;
                    case 4:
                        WpYPbPBxxh.this.responseBase = new kf1rAJ1MG4();
                        WpYPbPBxxh wpYPbPBxxh10 = WpYPbPBxxh.this;
                        wpYPbPBxxh10.responseBase = negociosCU.deleteNegocio(wpYPbPBxxh10.negocioCRUDRequest, wpYPbPBxxh10.token);
                        WpYPbPBxxh wpYPbPBxxh11 = WpYPbPBxxh.this;
                        wpYPbPBxxh11.isSuccess = wpYPbPBxxh11.responseBase.isOK();
                        WpYPbPBxxh wpYPbPBxxh12 = WpYPbPBxxh.this;
                        wpYPbPBxxh12.mensaje = wpYPbPBxxh12.responseBase.getMenssage();
                        break;
                }
                return true;
            } catch (Exception ex) {
                WpYPbPBxxh wpYPbPBxxh13 = WpYPbPBxxh.this;
                wpYPbPBxxh13.isSuccess = false;
                wpYPbPBxxh13.code = -1;
                wpYPbPBxxh13.mensaje = UhA7J2923N.getInstance().getMessage(500, WpYPbPBxxh.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            WpYPbPBxxh.this.setProgressBarVisiblity(4);
            WpYPbPBxxh wpYPbPBxxh = WpYPbPBxxh.this;
            if (wpYPbPBxxh.resultView != null) {
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[wpYPbPBxxh.operTypeNegocio.ordinal()]) {
                    case 1:
                        WpYPbPBxxh wpYPbPBxxh2 = WpYPbPBxxh.this;
                        ZsIJgHaaO9 zsIJgHaaO9 = wpYPbPBxxh2.resultView;
                        Boolean boolValueOf = Boolean.valueOf(wpYPbPBxxh2.isSuccess);
                        WpYPbPBxxh wpYPbPBxxh3 = WpYPbPBxxh.this;
                        zsIJgHaaO9.onNegociosResult(boolValueOf, wpYPbPBxxh3.code, wpYPbPBxxh3.mensaje, wpYPbPBxxh3.response);
                        break;
                    case 2:
                        WpYPbPBxxh wpYPbPBxxh4 = WpYPbPBxxh.this;
                        ZsIJgHaaO9 zsIJgHaaO10 = wpYPbPBxxh4.resultView;
                        Boolean boolValueOf2 = Boolean.valueOf(wpYPbPBxxh4.isSuccess);
                        WpYPbPBxxh wpYPbPBxxh5 = WpYPbPBxxh.this;
                        zsIJgHaaO10.onResult(boolValueOf2, wpYPbPBxxh5.operTypeNegocio, wpYPbPBxxh5.mensaje, wpYPbPBxxh5.responseBase);
                        break;
                    case 3:
                        WpYPbPBxxh wpYPbPBxxh6 = WpYPbPBxxh.this;
                        ZsIJgHaaO9 zsIJgHaaO11 = wpYPbPBxxh6.resultView;
                        Boolean boolValueOf3 = Boolean.valueOf(wpYPbPBxxh6.isSuccess);
                        WpYPbPBxxh wpYPbPBxxh7 = WpYPbPBxxh.this;
                        zsIJgHaaO11.onResult(boolValueOf3, wpYPbPBxxh7.operTypeNegocio, wpYPbPBxxh7.mensaje, wpYPbPBxxh7.responseBase);
                        break;
                    case 4:
                        WpYPbPBxxh wpYPbPBxxh8 = WpYPbPBxxh.this;
                        ZsIJgHaaO9 zsIJgHaaO12 = wpYPbPBxxh8.resultView;
                        Boolean boolValueOf4 = Boolean.valueOf(wpYPbPBxxh8.isSuccess);
                        WpYPbPBxxh wpYPbPBxxh9 = WpYPbPBxxh.this;
                        zsIJgHaaO12.onResult(boolValueOf4, wpYPbPBxxh9.operTypeNegocio, wpYPbPBxxh9.mensaje, wpYPbPBxxh9.responseBase);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.WpYPbPBxxh$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio;

        static {
            int[] iArr = new int[OperTypeNegocio.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio = iArr;
            try {
                iArr[OperTypeNegocio.GET_LISTA_NEGOCIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[OperTypeNegocio.CREAR_NEGOCIO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[OperTypeNegocio.UPDATE_NEGOCIO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[OperTypeNegocio.DELETE_NEGOCIO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[Y8m8V0frIX.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX = iArr2;
            try {
                iArr2[Y8m8V0frIX.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[Y8m8V0frIX.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[Y8m8V0frIX.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
