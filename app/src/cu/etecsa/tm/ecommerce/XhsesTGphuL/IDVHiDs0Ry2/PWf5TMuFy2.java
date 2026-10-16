package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.K1a8LCEmAD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.ImIDy2TQHP;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class PWf5TMuFy2 implements N9BWYA3EvW {
    public int code;
    public Context context;
    public boolean isSuccess;
    public String mensaje;
    public N9BWYA3EvW.OperTypeProfilePresenter operTypeProfilePresenter;
    public K1a8LCEmAD passwordRequest;
    public w4DRczPYeb profileCRUDRequest;
    public kf1rAJ1MG4 responseBase;
    public uBTvQUHyua resultView;
    public String HEAD_LOG = "PWf5TMuFy2";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public PWf5TMuFy2(uBTvQUHyua resultView, Context context) {
        this.context = context;
        this.resultView = resultView;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW
    public void setProgressBarVisiblity(int visiblity) {
        uBTvQUHyua ubtvquhyua = this.resultView;
        if (ubtvquhyua != null) {
            ubtvquhyua.onSetProgressBarVisibility(visiblity);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW
    public void getProfile() {
        this.operTypeProfilePresenter = N9BWYA3EvW.OperTypeProfilePresenter.GET_PROFILE;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW
    public void updateProfile(w4DRczPYeb request) {
        this.operTypeProfilePresenter = N9BWYA3EvW.OperTypeProfilePresenter.UPDATE;
        this.profileCRUDRequest = request;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW
    public void changePassword(K1a8LCEmAD passwordRequest) {
        this.operTypeProfilePresenter = N9BWYA3EvW.OperTypeProfilePresenter.CHANGE_Password;
        this.passwordRequest = passwordRequest;
        ExcTask task = new ExcTask(this, null);
        task.execute(new String[0]);
    }

    public class ExcTask extends AsyncTask<String, Integer, Boolean> {
        public ExcTask() {
        }

        public /* synthetic */ ExcTask(PWf5TMuFy2 x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            PWf5TMuFy2.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                ImIDy2TQHP perfilCU = new ImIDy2TQHP(PWf5TMuFy2.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$N9BWYA3EvW$OperTypeProfilePresenter[PWf5TMuFy2.this.operTypeProfilePresenter.ordinal()]) {
                    case 1:
                        PWf5TMuFy2.this.responseBase = new kf1rAJ1MG4();
                        PWf5TMuFy2 pWf5TMuFy2 = PWf5TMuFy2.this;
                        pWf5TMuFy2.responseBase = perfilCU.getProfile(pWf5TMuFy2.token);
                        PWf5TMuFy2 pWf5TMuFy3 = PWf5TMuFy2.this;
                        pWf5TMuFy3.isSuccess = pWf5TMuFy3.responseBase.isOK();
                        PWf5TMuFy2 pWf5TMuFy4 = PWf5TMuFy2.this;
                        pWf5TMuFy4.mensaje = pWf5TMuFy4.responseBase.getMenssage();
                        break;
                    case 2:
                        PWf5TMuFy2.this.responseBase = new kf1rAJ1MG4();
                        if (PWf5TMuFy2.this.profileCRUDRequest.getPhoto() != null && PWf5TMuFy2.this.profileCRUDRequest.getPhoto().length() > 0) {
                            PWf5TMuFy2 pWf5TMuFy5 = PWf5TMuFy2.this;
                            pWf5TMuFy5.profileCRUDRequest.setPhoto(y6NQQxH0NI.getInstance(pWf5TMuFy5.context).convertImageToSend(PWf5TMuFy2.this.profileCRUDRequest.getPhoto()));
                        }
                        PWf5TMuFy2 pWf5TMuFy6 = PWf5TMuFy2.this;
                        pWf5TMuFy6.responseBase = perfilCU.updateProfile(pWf5TMuFy6.profileCRUDRequest, pWf5TMuFy6.token);
                        PWf5TMuFy2 pWf5TMuFy7 = PWf5TMuFy2.this;
                        pWf5TMuFy7.isSuccess = pWf5TMuFy7.responseBase.isOK();
                        PWf5TMuFy2 pWf5TMuFy8 = PWf5TMuFy2.this;
                        pWf5TMuFy8.mensaje = pWf5TMuFy8.responseBase.getMenssage();
                        break;
                    case 3:
                        PWf5TMuFy2.this.responseBase = new kf1rAJ1MG4();
                        PWf5TMuFy2 pWf5TMuFy9 = PWf5TMuFy2.this;
                        pWf5TMuFy9.responseBase = perfilCU.changePassword(pWf5TMuFy9.passwordRequest, pWf5TMuFy9.token);
                        PWf5TMuFy2 pWf5TMuFy10 = PWf5TMuFy2.this;
                        pWf5TMuFy10.isSuccess = pWf5TMuFy10.responseBase.isOK();
                        PWf5TMuFy2 pWf5TMuFy11 = PWf5TMuFy2.this;
                        pWf5TMuFy11.mensaje = pWf5TMuFy11.responseBase.getMenssage();
                        break;
                }
                return true;
            } catch (Exception ex) {
                PWf5TMuFy2 pWf5TMuFy12 = PWf5TMuFy2.this;
                pWf5TMuFy12.isSuccess = false;
                pWf5TMuFy12.code = -1;
                pWf5TMuFy12.mensaje = UhA7J2923N.getInstance().getMessage(500, PWf5TMuFy2.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            PWf5TMuFy2.this.setProgressBarVisiblity(4);
            PWf5TMuFy2 pWf5TMuFy2 = PWf5TMuFy2.this;
            uBTvQUHyua ubtvquhyua = pWf5TMuFy2.resultView;
            if (ubtvquhyua != null) {
                Boolean boolValueOf = Boolean.valueOf(pWf5TMuFy2.isSuccess);
                PWf5TMuFy2 pWf5TMuFy3 = PWf5TMuFy2.this;
                ubtvquhyua.onResult(boolValueOf, pWf5TMuFy3.operTypeProfilePresenter, pWf5TMuFy3.mensaje, pWf5TMuFy3.responseBase);
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.PWf5TMuFy2$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$N9BWYA3EvW$OperTypeProfilePresenter;

        static {
            int[] iArr = new int[N9BWYA3EvW.OperTypeProfilePresenter.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$N9BWYA3EvW$OperTypeProfilePresenter = iArr;
            try {
                iArr[N9BWYA3EvW.OperTypeProfilePresenter.GET_PROFILE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$N9BWYA3EvW$OperTypeProfilePresenter[N9BWYA3EvW.OperTypeProfilePresenter.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$N9BWYA3EvW$OperTypeProfilePresenter[N9BWYA3EvW.OperTypeProfilePresenter.CHANGE_Password.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
