package cu.etecsa.tm.ecommerce.Dyporpu9vbM;

import cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil.ldmbl4HatR;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.e26lZ6zHsTP;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.g7q75bsZ7U4;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.mxDKBoiAGg;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.sAzoBGHkpK;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.tgXzViKJOK;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.yKRmUtDUiP;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.JAl9AlHrnbt.z5jDbHBKvX;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.Pb8vvZarL8;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.YRajWCKfyB;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.iXb3TXled5;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.ii95c4ZHJp;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.qL2BfhKUbD;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.slJjVOMGPF;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.u4TIG1AFbY;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8.M0cQEZKnN5;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8.aG1rpdTw1Q;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8.m1OGkT0zRws;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8.pOtLARIMDg;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.eZwoIrgtCv8.zArtkHOFhM;

/* JADX INFO: loaded from: classes.dex */
public class KQ1TrOYV2S {
    private static qL2BfhKUbD cuentasRepo;
    private static ii95c4ZHJp devRepo;
    private static Pb8vvZarL8 estadisticaRepo;
    private static YRajWCKfyB negociosRepo;
    private static iXb3TXled5 pagosRepo;
    private static slJjVOMGPF profileRepo;
    private static GdIcoRIaia regionRepo;
    private static u4TIG1AFbY usersRepo;
    private static boolean isDebug = false;
    private static final KQ1TrOYV2S ourInstance = new KQ1TrOYV2S();

    public static KQ1TrOYV2S getInstance() {
        init();
        return ourInstance;
    }

    public static void init() {
        if (isDebug) {
            usersRepo = new M0cQEZKnN5();
            pagosRepo = new m1OGkT0zRws();
            devRepo = new aG1rpdTw1Q();
            cuentasRepo = new zArtkHOFhM();
            profileRepo = new pOtLARIMDg();
            return;
        }
        usersRepo = new e26lZ6zHsTP();
        pagosRepo = new g7q75bsZ7U4();
        devRepo = new z5jDbHBKvX();
        cuentasRepo = new yKRmUtDUiP();
        profileRepo = new sAzoBGHkpK();
        negociosRepo = new tgXzViKJOK();
        regionRepo = new ldmbl4HatR();
        estadisticaRepo = new mxDKBoiAGg();
    }

    public ii95c4ZHJp getDevRepo() {
        return devRepo;
    }

    public static void setDevRepo(ii95c4ZHJp devRepo2) {
        devRepo = devRepo2;
    }

    public u4TIG1AFbY getUsersRepoAPI() {
        return usersRepo;
    }

    public iXb3TXled5 getPagosRepo() {
        return pagosRepo;
    }

    public qL2BfhKUbD getCuentasRepo() {
        return cuentasRepo;
    }

    public slJjVOMGPF getProfileRepo() {
        return profileRepo;
    }

    public u4TIG1AFbY getUsersRepo() {
        return usersRepo;
    }

    public GdIcoRIaia getRegionRepo() {
        return regionRepo;
    }

    public YRajWCKfyB getNegociosRepo() {
        return negociosRepo;
    }

    public Pb8vvZarL8 getEstadisticaRepo() {
        return estadisticaRepo;
    }
}
