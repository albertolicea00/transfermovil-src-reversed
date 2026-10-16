package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.PxQtH5HO6p;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.BpB71R2rG8;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.L8gvrPUGKT;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class MNdSLKzqqG implements uenFaEQ06N {
    public kf1rAJ1MG4 baseResponse;
    public int code;
    public Context context;
    public int idUser;
    public boolean isSuccess;
    public String mensaje;
    public OperTypeUserList operTypeUserList;
    public jBESo4pBPY resultView;
    public qwlqFYH8aO userChildCrudRequest;
    public PxQtH5HO6p userChildGetRequest;
    public ME8KWex9OS userChildResponse;
    public L8gvrPUGKT usersResponse;
    public String HEAD_LOG = "MNdSLKzqqG";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypeUserList {
        LISTAR_CHILDS,
        GET_CHILD,
        CREATE_CHILD,
        UPDATE_CHILD,
        DELETE_CHILD,
        IMAGE,
        STATUS_CHILD
    }

    public MNdSLKzqqG(jBESo4pBPY resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void getUsers() {
        this.operTypeUserList = OperTypeUserList.LISTAR_CHILDS;
        UsersListTask task = new UsersListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void getUserDetail(int id) {
        this.idUser = id;
        this.operTypeUserList = OperTypeUserList.GET_CHILD;
        UsersListTask task = new UsersListTask(this, null);
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void setProgressBarVisiblity(int visiblity) {
        jBESo4pBPY jbeso4pbpy = this.resultView;
        if (jbeso4pbpy != null) {
            jbeso4pbpy.onSetProgressBarVisibility(visiblity);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void userCRUD(OperTypeUserList operTypeUserList, qwlqFYH8aO request) {
        this.operTypeUserList = operTypeUserList;
        UsersListTask task = new UsersListTask(this, null);
        this.userChildCrudRequest = request;
        task.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N
    public void userStatus(int id, boolean status) {
        this.operTypeUserList = OperTypeUserList.STATUS_CHILD;
        UsersListTask task = new UsersListTask(this, null);
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

    public class UsersListTask extends AsyncTask<String, Integer, Boolean> {
        public UsersListTask() {
        }

        public /* synthetic */ UsersListTask(MNdSLKzqqG x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            MNdSLKzqqG.this.setProgressBarVisiblity(0);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                BpB71R2rG8 usersCU = new BpB71R2rG8(MNdSLKzqqG.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[MNdSLKzqqG.this.operTypeUserList.ordinal()]) {
                    case 1:
                        MNdSLKzqqG.this.usersResponse = new L8gvrPUGKT();
                        MNdSLKzqqG mNdSLKzqqG = MNdSLKzqqG.this;
                        mNdSLKzqqG.usersResponse = usersCU.getUsers(mNdSLKzqqG.token);
                        MNdSLKzqqG mNdSLKzqqG2 = MNdSLKzqqG.this;
                        mNdSLKzqqG2.isSuccess = mNdSLKzqqG2.usersResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG3 = MNdSLKzqqG.this;
                        mNdSLKzqqG3.mensaje = mNdSLKzqqG3.usersResponse.getMenssage();
                        break;
                    case 2:
                        MNdSLKzqqG.this.userChildResponse = new ME8KWex9OS();
                        MNdSLKzqqG mNdSLKzqqG4 = MNdSLKzqqG.this;
                        mNdSLKzqqG4.userChildResponse = usersCU.getUserChild(mNdSLKzqqG4.idUser, mNdSLKzqqG4.token);
                        MNdSLKzqqG mNdSLKzqqG5 = MNdSLKzqqG.this;
                        mNdSLKzqqG5.isSuccess = mNdSLKzqqG5.userChildResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG6 = MNdSLKzqqG.this;
                        mNdSLKzqqG6.mensaje = mNdSLKzqqG6.userChildResponse.getMenssage();
                        break;
                    case 3:
                        MNdSLKzqqG.this.baseResponse = new kf1rAJ1MG4();
                        if (MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto() != null && MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto().length() > 0) {
                            MNdSLKzqqG.this.userChildCrudRequest.getUser().setPhoto(y6NQQxH0NI.getInstance(MNdSLKzqqG.this.context).convertImageToSend(MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto()));
                        }
                        MNdSLKzqqG mNdSLKzqqG7 = MNdSLKzqqG.this;
                        mNdSLKzqqG7.baseResponse = usersCU.userChildCREATE(mNdSLKzqqG7.userChildCrudRequest, mNdSLKzqqG7.token);
                        MNdSLKzqqG mNdSLKzqqG8 = MNdSLKzqqG.this;
                        mNdSLKzqqG8.isSuccess = mNdSLKzqqG8.baseResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG9 = MNdSLKzqqG.this;
                        mNdSLKzqqG9.mensaje = mNdSLKzqqG9.baseResponse.getMenssage();
                        break;
                    case 4:
                        MNdSLKzqqG.this.baseResponse = new kf1rAJ1MG4();
                        MNdSLKzqqG mNdSLKzqqG10 = MNdSLKzqqG.this;
                        mNdSLKzqqG10.baseResponse = usersCU.userChildDELETE(Integer.valueOf(mNdSLKzqqG10.userChildCrudRequest.getUser().getId()).intValue(), MNdSLKzqqG.this.token);
                        MNdSLKzqqG mNdSLKzqqG11 = MNdSLKzqqG.this;
                        mNdSLKzqqG11.isSuccess = mNdSLKzqqG11.baseResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG12 = MNdSLKzqqG.this;
                        mNdSLKzqqG12.mensaje = mNdSLKzqqG12.baseResponse.getMenssage();
                        break;
                    case 5:
                        MNdSLKzqqG.this.baseResponse = new kf1rAJ1MG4();
                        if (MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto() != null && MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto().length() > 0) {
                            MNdSLKzqqG.this.userChildCrudRequest.getUser().setPhoto(y6NQQxH0NI.getInstance(MNdSLKzqqG.this.context).convertImageToSend(MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto()));
                        }
                        MNdSLKzqqG mNdSLKzqqG13 = MNdSLKzqqG.this;
                        mNdSLKzqqG13.baseResponse = usersCU.userChildUPDATE(mNdSLKzqqG13.userChildCrudRequest, mNdSLKzqqG13.token);
                        MNdSLKzqqG mNdSLKzqqG14 = MNdSLKzqqG.this;
                        mNdSLKzqqG14.isSuccess = mNdSLKzqqG14.baseResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG15 = MNdSLKzqqG.this;
                        mNdSLKzqqG15.mensaje = mNdSLKzqqG15.baseResponse.getMenssage();
                        break;
                    case 6:
                        MNdSLKzqqG.this.baseResponse = new kf1rAJ1MG4();
                        y6NQQxH0NI.getInstance(MNdSLKzqqG.this.context).convertImageToSend(MNdSLKzqqG.this.userChildCrudRequest.getUser().getPhoto());
                        MNdSLKzqqG mNdSLKzqqG16 = MNdSLKzqqG.this;
                        mNdSLKzqqG16.isSuccess = mNdSLKzqqG16.baseResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG17 = MNdSLKzqqG.this;
                        mNdSLKzqqG17.mensaje = mNdSLKzqqG17.baseResponse.getMenssage();
                        break;
                    case 7:
                        MNdSLKzqqG.this.baseResponse = new kf1rAJ1MG4();
                        MNdSLKzqqG mNdSLKzqqG18 = MNdSLKzqqG.this;
                        mNdSLKzqqG18.baseResponse = usersCU.userChildEstado(mNdSLKzqqG18.userChildGetRequest, mNdSLKzqqG18.token);
                        MNdSLKzqqG mNdSLKzqqG19 = MNdSLKzqqG.this;
                        mNdSLKzqqG19.isSuccess = mNdSLKzqqG19.baseResponse.isOK();
                        MNdSLKzqqG mNdSLKzqqG20 = MNdSLKzqqG.this;
                        mNdSLKzqqG20.mensaje = mNdSLKzqqG20.baseResponse.getMenssage();
                        break;
                }
                return true;
            } catch (Exception ex) {
                MNdSLKzqqG mNdSLKzqqG21 = MNdSLKzqqG.this;
                mNdSLKzqqG21.isSuccess = false;
                mNdSLKzqqG21.code = -1;
                mNdSLKzqqG21.mensaje = UhA7J2923N.getInstance().getMessage(500, MNdSLKzqqG.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            MNdSLKzqqG.this.setProgressBarVisiblity(4);
            MNdSLKzqqG mNdSLKzqqG = MNdSLKzqqG.this;
            jBESo4pBPY jbeso4pbpy = mNdSLKzqqG.resultView;
            if (jbeso4pbpy != null) {
                OperTypeUserList operTypeUserList = mNdSLKzqqG.operTypeUserList;
                if (operTypeUserList == OperTypeUserList.LISTAR_CHILDS) {
                    Boolean boolValueOf = Boolean.valueOf(mNdSLKzqqG.isSuccess);
                    MNdSLKzqqG mNdSLKzqqG2 = MNdSLKzqqG.this;
                    jbeso4pbpy.onResult(boolValueOf, mNdSLKzqqG2.code, mNdSLKzqqG2.mensaje, mNdSLKzqqG2.usersResponse);
                } else if (operTypeUserList == OperTypeUserList.GET_CHILD) {
                    Boolean boolValueOf2 = Boolean.valueOf(mNdSLKzqqG.isSuccess);
                    MNdSLKzqqG mNdSLKzqqG3 = MNdSLKzqqG.this;
                    jbeso4pbpy.onUserChild(boolValueOf2, mNdSLKzqqG3.code, mNdSLKzqqG3.mensaje, mNdSLKzqqG3.userChildResponse);
                } else {
                    Boolean boolValueOf3 = Boolean.valueOf(mNdSLKzqqG.isSuccess);
                    MNdSLKzqqG mNdSLKzqqG4 = MNdSLKzqqG.this;
                    jbeso4pbpy.onResultCRUD(boolValueOf3, mNdSLKzqqG4.operTypeUserList, mNdSLKzqqG4.mensaje, mNdSLKzqqG4.baseResponse);
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.MNdSLKzqqG$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList;

        static {
            int[] iArr = new int[OperTypeUserList.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList = iArr;
            try {
                iArr[OperTypeUserList.LISTAR_CHILDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.GET_CHILD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.CREATE_CHILD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.DELETE_CHILD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.UPDATE_CHILD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.IMAGE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$MNdSLKzqqG$OperTypeUserList[OperTypeUserList.STATUS_CHILD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
