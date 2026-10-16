package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.BpB71R2rG8;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class OkZVobY9IO implements x4umm6Wzsp8 {
    public kf1rAJ1MG4 baseResponse;
    public int code;
    public Context context;
    public int idUser;
    public boolean isSuccess;
    public String mensaje;
    public OperTypePermisos operTypePermisos;
    public ToUwD5xX9T permisosResponse;
    public Xz5tY9X1IR resultView;
    public PxQtH5HO6p userChildGetRequest;
    public u5mpEjsROy userPermisosRequest;
    public String HEAD_LOG = "OkZVobY9IO";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypePermisos {
        GET_PERMISOS,
        UPDATE_PERMISOS,
        STATUS_CHILD
    }

    public OkZVobY9IO(Xz5tY9X1IR resultView, Context context) {
        this.context = context;
        this.resultView = resultView;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8
    public void setProgressBarVisiblity(int visiblity) {
        Xz5tY9X1IR xz5tY9X1IR = this.resultView;
        if (xz5tY9X1IR != null) {
            xz5tY9X1IR.onSetProgressBarVisibility(visiblity);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8
    public void permisoChildCRUD(OperTypePermisos operTypePermisos, qwlqFYH8aO request) {
        this.operTypePermisos = operTypePermisos;
        this.idUser = Integer.valueOf(request.getUser().getId()).intValue();
        PermisosTask permisosTask = new PermisosTask(this, null);
        permisosTask.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8
    public void permisoChildUpdate(u5mpEjsROy request) {
        this.operTypePermisos = OperTypePermisos.UPDATE_PERMISOS;
        this.userPermisosRequest = request;
        PermisosTask permisosTask = new PermisosTask(this, null);
        permisosTask.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8
    public void userStatus(int id, boolean status) {
        this.operTypePermisos = OperTypePermisos.STATUS_CHILD;
        PermisosTask task = new PermisosTask(this, null);
        PxQtH5HO6p pxQtH5HO6p = new PxQtH5HO6p();
        this.userChildGetRequest = pxQtH5HO6p;
        pxQtH5HO6p.setId(id);
        if (status) {
            this.userChildGetRequest.setBanned("1");
        } else {
            this.userChildGetRequest.setBanned("0");
        }
        task.execute(new String[0]);
    }

    public class PermisosTask extends AsyncTask<String, Integer, Boolean> {
        public PermisosTask() {
        }

        public /* synthetic */ PermisosTask(OkZVobY9IO x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            OkZVobY9IO.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                BpB71R2rG8 usersCU = new BpB71R2rG8(OkZVobY9IO.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$OkZVobY9IO$OperTypePermisos[OkZVobY9IO.this.operTypePermisos.ordinal()]) {
                    case 1:
                        OkZVobY9IO.this.permisosResponse = new ToUwD5xX9T();
                        OkZVobY9IO okZVobY9IO = OkZVobY9IO.this;
                        okZVobY9IO.permisosResponse = usersCU.getPermisoChildTodos(okZVobY9IO.idUser, okZVobY9IO.token);
                        OkZVobY9IO okZVobY9IO2 = OkZVobY9IO.this;
                        okZVobY9IO2.isSuccess = okZVobY9IO2.permisosResponse.isOK();
                        OkZVobY9IO okZVobY9IO3 = OkZVobY9IO.this;
                        okZVobY9IO3.mensaje = okZVobY9IO3.permisosResponse.getMenssage();
                        break;
                    case 2:
                        OkZVobY9IO.this.baseResponse = new kf1rAJ1MG4();
                        OkZVobY9IO okZVobY9IO4 = OkZVobY9IO.this;
                        okZVobY9IO4.baseResponse = usersCU.userChildEstado(okZVobY9IO4.userChildGetRequest, okZVobY9IO4.token);
                        OkZVobY9IO okZVobY9IO5 = OkZVobY9IO.this;
                        okZVobY9IO5.isSuccess = okZVobY9IO5.baseResponse.isOK();
                        OkZVobY9IO okZVobY9IO6 = OkZVobY9IO.this;
                        okZVobY9IO6.mensaje = okZVobY9IO6.baseResponse.getMenssage();
                        break;
                    case 3:
                        OkZVobY9IO.this.baseResponse = new kf1rAJ1MG4();
                        OkZVobY9IO okZVobY9IO7 = OkZVobY9IO.this;
                        okZVobY9IO7.baseResponse = usersCU.permisosUpdate(okZVobY9IO7.userPermisosRequest, okZVobY9IO7.token);
                        OkZVobY9IO okZVobY9IO8 = OkZVobY9IO.this;
                        okZVobY9IO8.isSuccess = okZVobY9IO8.baseResponse.isOK();
                        OkZVobY9IO okZVobY9IO9 = OkZVobY9IO.this;
                        okZVobY9IO9.mensaje = okZVobY9IO9.baseResponse.getMenssage();
                        break;
                }
                return true;
            } catch (Exception ex) {
                OkZVobY9IO okZVobY9IO10 = OkZVobY9IO.this;
                okZVobY9IO10.isSuccess = false;
                okZVobY9IO10.code = -1;
                okZVobY9IO10.mensaje = UhA7J2923N.getInstance().getMessage(500, OkZVobY9IO.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            OkZVobY9IO.this.setProgressBarVisiblity(4);
            OkZVobY9IO okZVobY9IO = OkZVobY9IO.this;
            Xz5tY9X1IR xz5tY9X1IR = okZVobY9IO.resultView;
            if (xz5tY9X1IR != null) {
                if (okZVobY9IO.operTypePermisos == OperTypePermisos.GET_PERMISOS) {
                    Boolean boolValueOf = Boolean.valueOf(okZVobY9IO.isSuccess);
                    OkZVobY9IO okZVobY9IO2 = OkZVobY9IO.this;
                    xz5tY9X1IR.onResultPermisos(boolValueOf, okZVobY9IO2.code, okZVobY9IO2.mensaje, okZVobY9IO2.permisosResponse);
                } else {
                    Boolean boolValueOf2 = Boolean.valueOf(okZVobY9IO.isSuccess);
                    OkZVobY9IO okZVobY9IO3 = OkZVobY9IO.this;
                    xz5tY9X1IR.onResult(boolValueOf2, okZVobY9IO3.operTypePermisos, okZVobY9IO3.mensaje, okZVobY9IO3.baseResponse);
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.OkZVobY9IO$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$OkZVobY9IO$OperTypePermisos;

        static {
            int[] iArr = new int[OperTypePermisos.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$OkZVobY9IO$OperTypePermisos = iArr;
            try {
                iArr[OperTypePermisos.GET_PERMISOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$OkZVobY9IO$OperTypePermisos[OperTypePermisos.STATUS_CHILD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$OkZVobY9IO$OperTypePermisos[OperTypePermisos.UPDATE_PERMISOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
