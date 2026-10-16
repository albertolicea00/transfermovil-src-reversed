package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.Y8m8V0frIX;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.ZxjGjcZ9UR;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.N4F6dxO3TC;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class HLAV6HkYgi implements rw0GJVadKk {
    public int code;
    public Context context;
    public String cuenta;
    public ZxjGjcZ9UR cuentasCRUDRequest;
    public boolean estado;
    public boolean isSuccess;
    public String mensaje;
    public OperTypeCuentas operTypeCuentas;
    public sR8QMZUZBy response;
    public kf1rAJ1MG4 responseBase;
    public KFxuVD3dg2 resultView;
    public String HEAD_LOG = "HLAV6HkYgi";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypeCuentas {
        GET_LISTA_CUENTAS,
        CREAR_CUENTA,
        UPDATE_CUENTA,
        DELETE_CUENTA,
        ESTADO_CUENTA
    }

    public HLAV6HkYgi(KFxuVD3dg2 resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void getCuentas() {
        this.operTypeCuentas = OperTypeCuentas.GET_LISTA_CUENTAS;
        CuentasListTask task = new CuentasListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void estadoCuenta(boolean estado, String cuenta) {
        this.operTypeCuentas = OperTypeCuentas.ESTADO_CUENTA;
        this.estado = estado;
        this.cuenta = cuenta;
        CuentasListTask task = new CuentasListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void getCuentaDetail(int id) {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void cuentaCRUD(Y8m8V0frIX crudEnum, ZxjGjcZ9UR request) {
        this.cuentasCRUDRequest = request;
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[crudEnum.ordinal()]) {
            case 1:
                this.operTypeCuentas = OperTypeCuentas.CREAR_CUENTA;
                break;
            case 2:
                this.operTypeCuentas = OperTypeCuentas.UPDATE_CUENTA;
                break;
            case 3:
                this.operTypeCuentas = OperTypeCuentas.DELETE_CUENTA;
                break;
        }
        CuentasListTask task = new CuentasListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk
    public void setProgressBarVisiblity(int visiblity) {
        KFxuVD3dg2 kFxuVD3dg2 = this.resultView;
        if (kFxuVD3dg2 != null) {
            kFxuVD3dg2.onSetProgressBarVisibility(visiblity);
        }
    }

    public class CuentasListTask extends AsyncTask<String, Integer, Boolean> {
        public CuentasListTask() {
        }

        public /* synthetic */ CuentasListTask(HLAV6HkYgi x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            HLAV6HkYgi.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                N4F6dxO3TC devCU = new N4F6dxO3TC(HLAV6HkYgi.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[HLAV6HkYgi.this.operTypeCuentas.ordinal()]) {
                    case 1:
                        HLAV6HkYgi.this.response = new sR8QMZUZBy();
                        HLAV6HkYgi hLAV6HkYgi = HLAV6HkYgi.this;
                        hLAV6HkYgi.response = devCU.getCuentas(hLAV6HkYgi.token);
                        HLAV6HkYgi hLAV6HkYgi2 = HLAV6HkYgi.this;
                        hLAV6HkYgi2.isSuccess = hLAV6HkYgi2.response.isOK();
                        HLAV6HkYgi hLAV6HkYgi3 = HLAV6HkYgi.this;
                        hLAV6HkYgi3.mensaje = hLAV6HkYgi3.response.getMenssage();
                        HLAV6HkYgi hLAV6HkYgi4 = HLAV6HkYgi.this;
                        hLAV6HkYgi4.code = hLAV6HkYgi4.response.getHttpCode();
                        break;
                    case 2:
                        HLAV6HkYgi.this.responseBase = new kf1rAJ1MG4();
                        HLAV6HkYgi hLAV6HkYgi5 = HLAV6HkYgi.this;
                        hLAV6HkYgi5.responseBase = devCU.createCuenta(hLAV6HkYgi5.cuentasCRUDRequest, hLAV6HkYgi5.token);
                        HLAV6HkYgi hLAV6HkYgi6 = HLAV6HkYgi.this;
                        hLAV6HkYgi6.isSuccess = hLAV6HkYgi6.responseBase.isOK();
                        HLAV6HkYgi hLAV6HkYgi7 = HLAV6HkYgi.this;
                        hLAV6HkYgi7.mensaje = hLAV6HkYgi7.responseBase.getMenssage();
                        HLAV6HkYgi hLAV6HkYgi8 = HLAV6HkYgi.this;
                        hLAV6HkYgi8.code = hLAV6HkYgi8.responseBase.getHttpCode();
                        break;
                    case 3:
                        HLAV6HkYgi.this.responseBase = new kf1rAJ1MG4();
                        HLAV6HkYgi hLAV6HkYgi9 = HLAV6HkYgi.this;
                        hLAV6HkYgi9.responseBase = devCU.updateCuenta(hLAV6HkYgi9.cuentasCRUDRequest, hLAV6HkYgi9.token);
                        HLAV6HkYgi hLAV6HkYgi10 = HLAV6HkYgi.this;
                        hLAV6HkYgi10.isSuccess = hLAV6HkYgi10.responseBase.isOK();
                        HLAV6HkYgi hLAV6HkYgi11 = HLAV6HkYgi.this;
                        hLAV6HkYgi11.mensaje = hLAV6HkYgi11.responseBase.getMenssage();
                        break;
                    case 4:
                        HLAV6HkYgi.this.responseBase = new kf1rAJ1MG4();
                        HLAV6HkYgi hLAV6HkYgi12 = HLAV6HkYgi.this;
                        hLAV6HkYgi12.responseBase = devCU.deleteCuenta(hLAV6HkYgi12.cuentasCRUDRequest, hLAV6HkYgi12.token);
                        HLAV6HkYgi hLAV6HkYgi13 = HLAV6HkYgi.this;
                        hLAV6HkYgi13.isSuccess = hLAV6HkYgi13.responseBase.isOK();
                        HLAV6HkYgi hLAV6HkYgi14 = HLAV6HkYgi.this;
                        hLAV6HkYgi14.mensaje = hLAV6HkYgi14.responseBase.getMenssage();
                        HLAV6HkYgi hLAV6HkYgi15 = HLAV6HkYgi.this;
                        hLAV6HkYgi15.code = hLAV6HkYgi15.responseBase.getHttpCode();
                        break;
                    case 5:
                        HLAV6HkYgi.this.responseBase = new kf1rAJ1MG4();
                        HLAV6HkYgi hLAV6HkYgi16 = HLAV6HkYgi.this;
                        hLAV6HkYgi16.responseBase = devCU.estadoCuenta(hLAV6HkYgi16.estado, hLAV6HkYgi16.cuenta, hLAV6HkYgi16.token);
                        HLAV6HkYgi hLAV6HkYgi17 = HLAV6HkYgi.this;
                        hLAV6HkYgi17.isSuccess = hLAV6HkYgi17.responseBase.isOK();
                        HLAV6HkYgi hLAV6HkYgi18 = HLAV6HkYgi.this;
                        hLAV6HkYgi18.mensaje = hLAV6HkYgi18.responseBase.getMenssage();
                        HLAV6HkYgi hLAV6HkYgi19 = HLAV6HkYgi.this;
                        hLAV6HkYgi19.code = hLAV6HkYgi19.responseBase.getHttpCode();
                        break;
                }
                return true;
            } catch (Exception ex) {
                HLAV6HkYgi hLAV6HkYgi20 = HLAV6HkYgi.this;
                hLAV6HkYgi20.isSuccess = false;
                hLAV6HkYgi20.code = -1;
                hLAV6HkYgi20.mensaje = UhA7J2923N.getInstance().getMessage(500, HLAV6HkYgi.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            HLAV6HkYgi.this.setProgressBarVisiblity(4);
            HLAV6HkYgi hLAV6HkYgi = HLAV6HkYgi.this;
            if (hLAV6HkYgi.resultView != null) {
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[hLAV6HkYgi.operTypeCuentas.ordinal()]) {
                    case 1:
                        HLAV6HkYgi hLAV6HkYgi2 = HLAV6HkYgi.this;
                        KFxuVD3dg2 kFxuVD3dg2 = hLAV6HkYgi2.resultView;
                        Boolean boolValueOf = Boolean.valueOf(hLAV6HkYgi2.isSuccess);
                        HLAV6HkYgi hLAV6HkYgi3 = HLAV6HkYgi.this;
                        kFxuVD3dg2.onCuentasResult(boolValueOf, hLAV6HkYgi3.code, hLAV6HkYgi3.mensaje, hLAV6HkYgi3.response);
                        break;
                    case 2:
                        HLAV6HkYgi hLAV6HkYgi4 = HLAV6HkYgi.this;
                        KFxuVD3dg2 kFxuVD3dg3 = hLAV6HkYgi4.resultView;
                        Boolean boolValueOf2 = Boolean.valueOf(hLAV6HkYgi4.isSuccess);
                        HLAV6HkYgi hLAV6HkYgi5 = HLAV6HkYgi.this;
                        kFxuVD3dg3.onCuentasResult(boolValueOf2, hLAV6HkYgi5.operTypeCuentas, hLAV6HkYgi5.mensaje, hLAV6HkYgi5.responseBase);
                        break;
                    case 3:
                        HLAV6HkYgi hLAV6HkYgi6 = HLAV6HkYgi.this;
                        KFxuVD3dg2 kFxuVD3dg4 = hLAV6HkYgi6.resultView;
                        Boolean boolValueOf3 = Boolean.valueOf(hLAV6HkYgi6.isSuccess);
                        HLAV6HkYgi hLAV6HkYgi7 = HLAV6HkYgi.this;
                        kFxuVD3dg4.onCuentasResult(boolValueOf3, hLAV6HkYgi7.operTypeCuentas, hLAV6HkYgi7.mensaje, hLAV6HkYgi7.responseBase);
                        break;
                    case 4:
                        HLAV6HkYgi hLAV6HkYgi8 = HLAV6HkYgi.this;
                        KFxuVD3dg2 kFxuVD3dg5 = hLAV6HkYgi8.resultView;
                        Boolean boolValueOf4 = Boolean.valueOf(hLAV6HkYgi8.isSuccess);
                        HLAV6HkYgi hLAV6HkYgi9 = HLAV6HkYgi.this;
                        kFxuVD3dg5.onCuentasResult(boolValueOf4, hLAV6HkYgi9.operTypeCuentas, hLAV6HkYgi9.mensaje, hLAV6HkYgi9.responseBase);
                        break;
                    case 5:
                        HLAV6HkYgi hLAV6HkYgi10 = HLAV6HkYgi.this;
                        KFxuVD3dg2 kFxuVD3dg6 = hLAV6HkYgi10.resultView;
                        Boolean boolValueOf5 = Boolean.valueOf(hLAV6HkYgi10.isSuccess);
                        HLAV6HkYgi hLAV6HkYgi11 = HLAV6HkYgi.this;
                        kFxuVD3dg6.onCuentasResult(boolValueOf5, hLAV6HkYgi11.operTypeCuentas, hLAV6HkYgi11.mensaje, hLAV6HkYgi11.responseBase);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas;

        static {
            int[] iArr = new int[OperTypeCuentas.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas = iArr;
            try {
                iArr[OperTypeCuentas.GET_LISTA_CUENTAS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[OperTypeCuentas.CREAR_CUENTA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[OperTypeCuentas.UPDATE_CUENTA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[OperTypeCuentas.DELETE_CUENTA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[OperTypeCuentas.ESTADO_CUENTA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[Y8m8V0frIX.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX = iArr2;
            try {
                iArr2[Y8m8V0frIX.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[Y8m8V0frIX.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$Y8m8V0frIX[Y8m8V0frIX.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
        }
    }
}
