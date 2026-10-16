package cu.etecsa.cubacel.tr.tm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.ofOuyCSKWI;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.KyQXczCdrr;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.LALCrDPvhM;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.BIc10fn03P;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.HBFPOv3Hig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.Pg7MuGKEAe;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.z5XKGtUeX8;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM;
import cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.cYyrKJVQ6G;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.wTZi6Zeikv;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ysmUbWW79P;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HPuMiTypoW;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI.BOf8kgNm7V;
import cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI.wComYkZMDc;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UoWmGAF016;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.LxRjrwTADB;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.mYaQ7jnA3Y;
import cu.etecsa.tm.ecommerce.a7Y4bbw8Os;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class S9ycHcoxAzy extends rDEl7rW1aN implements ysmUbWW79P {
    private static final int CREATE_FILE = 1;
    public static final int PERMISSIONS_MULTIPLE_REQUEST = 123;
    private static final int PICK_PDF_FILE = 2;
    public Activity activity;
    public Context context;
    public CheckBox dontShowAgain;
    public FloatingActionButton fabOption1;
    public FloatingActionButton fabOption2;
    public FloatingActionButton fabOption3;
    public FloatingActionButton fabQr;
    private LocalBroadcastManager loalLocalBroadcastManager;
    public DrawerLayout mDrawerLayout;
    public NavigationView mNavigationView;
    public Fr52O1uSYF msap;
    public Menu nav_Menu;
    public LinearLayout option1Container;
    public LinearLayout option2Container;
    public LinearLayout option3Container;
    public Toolbar toolbar;
    private X9ZiE8XZNKy br = new X9ZiE8XZNKy();
    public boolean isOpenFab = false;

    /* JADX WARN: Code duplicated, block: B:49:0x016c A[Catch: Exception -> 0x027e, TryCatch #3 {Exception -> 0x027e, blocks: (B:3:0x001b, B:13:0x0055, B:15:0x007e, B:18:0x0095, B:20:0x00c5, B:25:0x00e9, B:27:0x010e, B:32:0x011e, B:34:0x012b, B:47:0x0161, B:49:0x016c, B:51:0x0178, B:52:0x017b, B:54:0x018a, B:56:0x0197, B:58:0x01a3, B:60:0x01b0, B:61:0x01c8, B:63:0x01d4, B:65:0x01da, B:66:0x01e1, B:22:0x00d1, B:24:0x00dd, B:17:0x008e, B:12:0x004c, B:42:0x0142, B:44:0x0156, B:4:0x001e, B:6:0x002f, B:7:0x0033, B:9:0x0047), top: B:112:0x001b, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0178 A[Catch: Exception -> 0x027e, TryCatch #3 {Exception -> 0x027e, blocks: (B:3:0x001b, B:13:0x0055, B:15:0x007e, B:18:0x0095, B:20:0x00c5, B:25:0x00e9, B:27:0x010e, B:32:0x011e, B:34:0x012b, B:47:0x0161, B:49:0x016c, B:51:0x0178, B:52:0x017b, B:54:0x018a, B:56:0x0197, B:58:0x01a3, B:60:0x01b0, B:61:0x01c8, B:63:0x01d4, B:65:0x01da, B:66:0x01e1, B:22:0x00d1, B:24:0x00dd, B:17:0x008e, B:12:0x004c, B:42:0x0142, B:44:0x0156, B:4:0x001e, B:6:0x002f, B:7:0x0033, B:9:0x0047), top: B:112:0x001b, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x018a A[Catch: Exception -> 0x027e, TryCatch #3 {Exception -> 0x027e, blocks: (B:3:0x001b, B:13:0x0055, B:15:0x007e, B:18:0x0095, B:20:0x00c5, B:25:0x00e9, B:27:0x010e, B:32:0x011e, B:34:0x012b, B:47:0x0161, B:49:0x016c, B:51:0x0178, B:52:0x017b, B:54:0x018a, B:56:0x0197, B:58:0x01a3, B:60:0x01b0, B:61:0x01c8, B:63:0x01d4, B:65:0x01da, B:66:0x01e1, B:22:0x00d1, B:24:0x00dd, B:17:0x008e, B:12:0x004c, B:42:0x0142, B:44:0x0156, B:4:0x001e, B:6:0x002f, B:7:0x0033, B:9:0x0047), top: B:112:0x001b, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0197 A[Catch: Exception -> 0x027e, TryCatch #3 {Exception -> 0x027e, blocks: (B:3:0x001b, B:13:0x0055, B:15:0x007e, B:18:0x0095, B:20:0x00c5, B:25:0x00e9, B:27:0x010e, B:32:0x011e, B:34:0x012b, B:47:0x0161, B:49:0x016c, B:51:0x0178, B:52:0x017b, B:54:0x018a, B:56:0x0197, B:58:0x01a3, B:60:0x01b0, B:61:0x01c8, B:63:0x01d4, B:65:0x01da, B:66:0x01e1, B:22:0x00d1, B:24:0x00dd, B:17:0x008e, B:12:0x004c, B:42:0x0142, B:44:0x0156, B:4:0x001e, B:6:0x002f, B:7:0x0033, B:9:0x0047), top: B:112:0x001b, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d4 A[Catch: Exception -> 0x027e, TryCatch #3 {Exception -> 0x027e, blocks: (B:3:0x001b, B:13:0x0055, B:15:0x007e, B:18:0x0095, B:20:0x00c5, B:25:0x00e9, B:27:0x010e, B:32:0x011e, B:34:0x012b, B:47:0x0161, B:49:0x016c, B:51:0x0178, B:52:0x017b, B:54:0x018a, B:56:0x0197, B:58:0x01a3, B:60:0x01b0, B:61:0x01c8, B:63:0x01d4, B:65:0x01da, B:66:0x01e1, B:22:0x00d1, B:24:0x00dd, B:17:0x008e, B:12:0x004c, B:42:0x0142, B:44:0x0156, B:4:0x001e, B:6:0x002f, B:7:0x0033, B:9:0x0047), top: B:112:0x001b, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0225 A[Catch: ParseException -> 0x022f, Exception -> 0x027c, TRY_LEAVE, TryCatch #1 {ParseException -> 0x022f, blocks: (B:73:0x021a, B:75:0x0225), top: B:108:0x021a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0233 A[DONT_INVERT, PHI: r9 r15
      0x0233: PHI (r9v3 'fechaUltimaPromo' java.util.Date) = 
      (r9v2 'fechaUltimaPromo' java.util.Date)
      (r9v2 'fechaUltimaPromo' java.util.Date)
      (r9v4 'fechaUltimaPromo' java.util.Date)
     binds: [B:79:0x0230, B:74:0x0223, B:76:0x022d] A[DONT_GENERATE, DONT_INLINE]
      0x0233: PHI (r15v2 'today' java.util.Date) = (r15v1 'today' java.util.Date), (r15v3 'today' java.util.Date), (r15v3 'today' java.util.Date) binds: [B:79:0x0230, B:74:0x0223, B:76:0x022d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0235 A[Catch: Exception -> 0x027c, TryCatch #4 {Exception -> 0x027c, blocks: (B:67:0x01f0, B:73:0x021a, B:75:0x0225, B:81:0x0235, B:83:0x023b, B:85:0x024a, B:90:0x026f, B:79:0x0230), top: B:114:0x01f0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x023b A[Catch: Exception -> 0x027c, TryCatch #4 {Exception -> 0x027c, blocks: (B:67:0x01f0, B:73:0x021a, B:75:0x0225, B:81:0x0235, B:83:0x023b, B:85:0x024a, B:90:0x026f, B:79:0x0230), top: B:114:0x01f0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x024a A[Catch: Exception -> 0x027c, TRY_LEAVE, TryCatch #4 {Exception -> 0x027c, blocks: (B:67:0x01f0, B:73:0x021a, B:75:0x0225, B:81:0x0235, B:83:0x023b, B:85:0x024a, B:90:0x026f, B:79:0x0230), top: B:114:0x01f0, inners: #1 }] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws ParseException {
        List<AppConfig> appConfigList;
        DateFormat formatter;
        Date today;
        Date fechaUltimaPromo;
        List<PromoSMS> promoSMSList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rhxzopwybsq3u);
        this.activity = this;
        this.context = getApplicationContext();
        try {
            checkAndroidVersion();
            try {
                unYp8VQThY.init(this);
                if (unYp8VQThY.getInstance().getAppConfigLists().size() == 0 || unYp8VQThY.getInstance().getAllAppConfigLists().get(0).isMensajeInicio()) {
                    mensajeBienvendida();
                }
            } catch (Exception ex) {
                Log.e("ERROR_TM", ex.getMessage());
            }
            this.msap = new Fr52O1uSYF();
            this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            this.mNavigationView = (NavigationView) findViewById(R.id.navigationdrawermenu);
            if (this.msap.getPhone(getBaseContext()) == null || this.msap.getPhone(getBaseContext()).isEmpty()) {
                sms_actualizar_bd_datos_app(getContentResolver());
            }
            this.msap.getPhone(getBaseContext());
            Menu menu = this.mNavigationView.getMenu();
            this.nav_Menu = menu;
            FBsQzP3Zfj.menuControlBanks(menu);
            new HPuMiTypoW(getContentResolver()).execute(new Void[0]);
            if ((!this.msap.getCodigoBanco().contains("-1") || this.msap.getCodigoBanco().isEmpty()) && this.msap.getCodigoBanco().length() > 3) {
                this.nav_Menu.findItem(R.id.group_comercio).setVisible(true);
            }
            this.nav_Menu.findItem(R.id.group_bancos_menu).setVisible(true);
            this.nav_Menu.findItem(R.id.group_estadisticas).setVisible(true);
            boolean z = this.msap.getCodigoAgente().contains("-1") || this.msap.getCodigoAgente().isEmpty();
            boolean enabled_miboleto = this.msap.getCodigoMiBoleto().contains("-1") || this.msap.getCodigoMiBoleto().isEmpty();
            if (!enabled_miboleto) {
                try {
                    boolean isMiBoletoActive = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarmodulomiboleto();
                    if (isMiBoletoActive) {
                        this.nav_Menu.findItem(R.id.vendedor_miboleto).setVisible(true);
                        FragmentManager mFragmentManager = getSupportFragmentManager();
                        mFragmentManager.beginTransaction();
                        if (savedInstanceState == null) {
                            LimpiarFragmentManager();
                        }
                        appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                        if (appConfigList.size() != 0) {
                            if (appConfigList.get(0).getEvaluacion() != -1 && (appConfigList.get(0).getEvaluacion() <= 0 || appConfigList.get(0).getEvaluacion() > 5)) {
                                AppConfig app_data = appConfigList.get(0);
                                app_data.setFechaUltimasExperiencias(new Date());
                                app_data.setEvaluacion(-1);
                                unYp8VQThY.getInstance().updateAppConfig(app_data);
                            }
                            if (!appConfigList.get(0).isNoMostrarEncuesta() && FBsQzP3Zfj.validateExperienciaUsuario()) {
                                FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                            }
                        }
                        Toolbar version_app = (Toolbar) findViewById(R.id.toolbar);
                        version_app.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.1
                            public long then = 0;

                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view, MotionEvent event) {
                                if (event.getAction() == 0) {
                                    this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                                    return false;
                                }
                                if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                                    FragmentTransaction xfragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                                    xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                                    return true;
                                }
                                return false;
                            }
                        });
                        try {
                            formatter = new SimpleDateFormat("dd/MM/yyyy");
                            today = new Date();
                            try {
                                Date fechaUltimaPromo2 = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
                                fechaUltimaPromo = fechaUltimaPromo2;
                            } catch (Exception e) {
                                fechaUltimaPromo = null;
                            }
                            try {
                                today = formatter.parse(formatter.format(today));
                                if (fechaUltimaPromo != null) {
                                    fechaUltimaPromo = formatter.parse(formatter.format(fechaUltimaPromo));
                                    if (fechaUltimaPromo != null || fechaUltimaPromo.before(today)) {
                                        BOf8kgNm7V promoManagement = new BOf8kgNm7V();
                                        promoSMSList = promoManagement.getPromosDia();
                                        if (promoSMSList != null && promoSMSList.size() > 0) {
                                            try {
                                                AppConfig appConfig = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                                appConfig.setFechaUltimasPromos(new Date());
                                                unYp8VQThY.getInstance().updateAppConfig(appConfig);
                                            } catch (Exception e2) {
                                            }
                                            Intent intent = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                            startActivity(intent);
                                        }
                                    }
                                } else if (fechaUltimaPromo != null) {
                                    BOf8kgNm7V promoManagement2 = new BOf8kgNm7V();
                                    promoSMSList = promoManagement2.getPromosDia();
                                    if (promoSMSList != null) {
                                        AppConfig appConfig2 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                        appConfig2.setFechaUltimasPromos(new Date());
                                        unYp8VQThY.getInstance().updateAppConfig(appConfig2);
                                        Intent intent2 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                        startActivity(intent2);
                                    }
                                } else {
                                    BOf8kgNm7V promoManagement3 = new BOf8kgNm7V();
                                    promoSMSList = promoManagement3.getPromosDia();
                                    if (promoSMSList != null) {
                                        AppConfig appConfig3 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                        appConfig3.setFechaUltimasPromos(new Date());
                                        unYp8VQThY.getInstance().updateAppConfig(appConfig3);
                                        Intent intent3 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                        startActivity(intent3);
                                    }
                                }
                            } catch (ParseException e3) {
                                e3.printStackTrace();
                            }
                        } catch (Exception e4) {
                        }
                    } else {
                        FragmentManager mFragmentManager2 = getSupportFragmentManager();
                        mFragmentManager2.beginTransaction();
                        if (savedInstanceState == null) {
                            LimpiarFragmentManager();
                        }
                        appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                        if (appConfigList.size() != 0) {
                            if (appConfigList.get(0).getEvaluacion() != -1) {
                                AppConfig app_data2 = appConfigList.get(0);
                                app_data2.setFechaUltimasExperiencias(new Date());
                                app_data2.setEvaluacion(-1);
                                unYp8VQThY.getInstance().updateAppConfig(app_data2);
                            }
                            if (!appConfigList.get(0).isNoMostrarEncuesta()) {
                                FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                            }
                        }
                        Toolbar version_app2 = (Toolbar) findViewById(R.id.toolbar);
                        version_app2.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.1
                            public long then = 0;

                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view, MotionEvent event) {
                                if (event.getAction() == 0) {
                                    this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                                    return false;
                                }
                                if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                                    FragmentTransaction xfragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                                    xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                                    return true;
                                }
                                return false;
                            }
                        });
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        today = new Date();
                        Date fechaUltimaPromo3 = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
                        fechaUltimaPromo = fechaUltimaPromo3;
                        today = formatter.parse(formatter.format(today));
                        if (fechaUltimaPromo != null) {
                            fechaUltimaPromo = formatter.parse(formatter.format(fechaUltimaPromo));
                            if (fechaUltimaPromo != null) {
                                BOf8kgNm7V promoManagement4 = new BOf8kgNm7V();
                                promoSMSList = promoManagement4.getPromosDia();
                                if (promoSMSList != null) {
                                    AppConfig appConfig4 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                    appConfig4.setFechaUltimasPromos(new Date());
                                    unYp8VQThY.getInstance().updateAppConfig(appConfig4);
                                    Intent intent4 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                    startActivity(intent4);
                                }
                            } else {
                                BOf8kgNm7V promoManagement5 = new BOf8kgNm7V();
                                promoSMSList = promoManagement5.getPromosDia();
                                if (promoSMSList != null) {
                                    AppConfig appConfig5 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                    appConfig5.setFechaUltimasPromos(new Date());
                                    unYp8VQThY.getInstance().updateAppConfig(appConfig5);
                                    Intent intent5 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                    startActivity(intent5);
                                }
                            }
                        } else if (fechaUltimaPromo != null) {
                            BOf8kgNm7V promoManagement6 = new BOf8kgNm7V();
                            promoSMSList = promoManagement6.getPromosDia();
                            if (promoSMSList != null) {
                                AppConfig appConfig6 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                appConfig6.setFechaUltimasPromos(new Date());
                                unYp8VQThY.getInstance().updateAppConfig(appConfig6);
                                Intent intent6 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                startActivity(intent6);
                            }
                        } else {
                            BOf8kgNm7V promoManagement7 = new BOf8kgNm7V();
                            promoSMSList = promoManagement7.getPromosDia();
                            if (promoSMSList != null) {
                                AppConfig appConfig7 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                                appConfig7.setFechaUltimasPromos(new Date());
                                unYp8VQThY.getInstance().updateAppConfig(appConfig7);
                                Intent intent7 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                                startActivity(intent7);
                            }
                        }
                    }
                } catch (Exception e5) {
                    this.nav_Menu.findItem(R.id.vendedor_miboleto).setVisible(false);
                }
            } else {
                FragmentManager mFragmentManager3 = getSupportFragmentManager();
                mFragmentManager3.beginTransaction();
                if (savedInstanceState == null) {
                    LimpiarFragmentManager();
                }
                appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                if (appConfigList.size() != 0) {
                    if (appConfigList.get(0).getEvaluacion() != -1) {
                        AppConfig app_data3 = appConfigList.get(0);
                        app_data3.setFechaUltimasExperiencias(new Date());
                        app_data3.setEvaluacion(-1);
                        unYp8VQThY.getInstance().updateAppConfig(app_data3);
                    }
                    if (!appConfigList.get(0).isNoMostrarEncuesta()) {
                        FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                    }
                }
                Toolbar version_app3 = (Toolbar) findViewById(R.id.toolbar);
                version_app3.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.1
                    public long then = 0;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent event) {
                        if (event.getAction() == 0) {
                            this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                            return false;
                        }
                        if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                            FragmentTransaction xfragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                            xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                            return true;
                        }
                        return false;
                    }
                });
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                today = new Date();
                Date fechaUltimaPromo4 = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
                fechaUltimaPromo = fechaUltimaPromo4;
                today = formatter.parse(formatter.format(today));
                if (fechaUltimaPromo != null) {
                    fechaUltimaPromo = formatter.parse(formatter.format(fechaUltimaPromo));
                    if (fechaUltimaPromo != null) {
                        BOf8kgNm7V promoManagement8 = new BOf8kgNm7V();
                        promoSMSList = promoManagement8.getPromosDia();
                        if (promoSMSList != null) {
                            AppConfig appConfig8 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                            appConfig8.setFechaUltimasPromos(new Date());
                            unYp8VQThY.getInstance().updateAppConfig(appConfig8);
                            Intent intent8 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                            startActivity(intent8);
                        }
                    } else {
                        BOf8kgNm7V promoManagement9 = new BOf8kgNm7V();
                        promoSMSList = promoManagement9.getPromosDia();
                        if (promoSMSList != null) {
                            AppConfig appConfig9 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                            appConfig9.setFechaUltimasPromos(new Date());
                            unYp8VQThY.getInstance().updateAppConfig(appConfig9);
                            Intent intent9 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                            startActivity(intent9);
                        }
                    }
                } else if (fechaUltimaPromo != null) {
                    BOf8kgNm7V promoManagement10 = new BOf8kgNm7V();
                    promoSMSList = promoManagement10.getPromosDia();
                    if (promoSMSList != null) {
                        AppConfig appConfig10 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                        appConfig10.setFechaUltimasPromos(new Date());
                        unYp8VQThY.getInstance().updateAppConfig(appConfig10);
                        Intent intent10 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                        startActivity(intent10);
                    }
                } else {
                    BOf8kgNm7V promoManagement11 = new BOf8kgNm7V();
                    promoSMSList = promoManagement11.getPromosDia();
                    if (promoSMSList != null) {
                        AppConfig appConfig11 = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                        appConfig11.setFechaUltimasPromos(new Date());
                        unYp8VQThY.getInstance().updateAppConfig(appConfig11);
                        Intent intent11 = new Intent(this.context, (Class<?>) wComYkZMDc.class);
                        startActivity(intent11);
                    }
                }
            }
        } catch (Exception e6) {
            Log.i("TRANSFEREXP", "S9ycHcoxAzy: " + e6.getMessage());
            Toast toast = Toast.makeText(getBaseContext(), R.string.err_open_app, 0);
            toast.show();
            System.runFinalization();
        }
        this.mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.2
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                S9ycHcoxAzy.this.mDrawerLayout.closeDrawers();
                S9ycHcoxAzy s9ycHcoxAzy = S9ycHcoxAzy.this;
                s9ycHcoxAzy.uncheckAllMenuItems(s9ycHcoxAzy.mNavigationView);
                S9ycHcoxAzy.this.LimpiarFragmentManager();
                if (menuItem.getItemId() == R.id.inicio) {
                    FragmentTransaction xfragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new cYyrKJVQ6G()).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.llamadas) {
                    if (Build.VERSION.SDK_INT >= 23 && S9ycHcoxAzy.this.getBaseContext().checkSelfPermission("android.permission.READ_CONTACTS") == -1) {
                        S9ycHcoxAzy.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                    }
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction2 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction2.replace(R.id.containerView, new FNRzUmC7E5()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.operaciones) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction3 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction3.replace(R.id.containerView, new LALCrDPvhM()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.servicios) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction4 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction4.replace(R.id.containerView, new BktkqFBOIQ()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.resumidas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction5 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    Bundle b = new Bundle();
                    b.putString("newEstaditica", "1");
                    mYaQ7jnA3Y pay = new mYaQ7jnA3Y();
                    pay.setArguments(b);
                    xfragmentTransaction5.replace(R.id.containerView, pay).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.detalladas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction6 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction6.replace(R.id.containerView, new LxRjrwTADB()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.tel_utiles) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction7 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction7.replace(R.id.containerView, new s9lZwtvq9Dl()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.setting) {
                    menuItem.setChecked(true);
                    FragmentTransaction fragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new UoWmGAF016()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.nauta) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction8 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction8.replace(R.id.containerView, new KyQXczCdrr()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bpa) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction9 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction9.replace(R.id.containerView, new Pg7MuGKEAe()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.metro) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction10 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction10.replace(R.id.containerView, new BIc10fn03P()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bandec) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction11 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction11.replace(R.id.containerView, new z5XKGtUeX8()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bfi) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction12 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction12.replace(R.id.containerView, new HBFPOv3Hig()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.gestion) {
                    if (Build.VERSION.SDK_INT >= 23 && S9ycHcoxAzy.this.getBaseContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
                        S9ycHcoxAzy.this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                    }
                    menuItem.setChecked(true);
                    FragmentTransaction fragmentTransaction2 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    wTZi6Zeikv gestionFragment = new wTZi6Zeikv();
                    fragmentTransaction2.replace(R.id.containerView, gestionFragment).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.cuentas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction13 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction13.replace(R.id.containerView, new KeTIEVSfVo()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bulevar) {
                    Intent i = new Intent(S9ycHcoxAzy.this.context, (Class<?>) a7Y4bbw8Os.class);
                    S9ycHcoxAzy.this.startActivity(i);
                    return true;
                }
                if (menuItem.getItemId() == R.id.bolsa_etecsa) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction14 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction14.replace(R.id.containerView, new ofOuyCSKWI()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() != R.id.vendedor_miboleto) {
                    return true;
                }
                menuItem.setChecked(true);
                FragmentTransaction xfragmentTransaction15 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                xfragmentTransaction15.replace(R.id.containerView, new wfroNBIJF7()).addToBackStack(null).commit();
                return true;
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.setTitle(com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
        setSupportActionBar(this.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, this.toolbar, R.string.app_name, R.string.app_name);
        this.mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        checkIntentApp();
        this.fabQr = (FloatingActionButton) findViewById(R.id.fabQr);
        this.option1Container = (LinearLayout) findViewById(R.id.option1_container);
        this.option2Container = (LinearLayout) findViewById(R.id.option2_container);
        this.option3Container = (LinearLayout) findViewById(R.id.option3_container);
        this.fabOption1 = (FloatingActionButton) findViewById(R.id.fab_option1);
        this.fabOption2 = (FloatingActionButton) findViewById(R.id.fab_option2);
        this.fabOption3 = (FloatingActionButton) findViewById(R.id.fab_option3);
        this.fabOption1.setCompatElevation(0.0f);
        this.fabOption2.setCompatElevation(0.0f);
        this.fabOption3.setCompatElevation(0.0f);
        this.fabQr.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                S9ycHcoxAzy s9ycHcoxAzy = S9ycHcoxAzy.this;
                if (!s9ycHcoxAzy.isOpenFab) {
                    s9ycHcoxAzy.isOpenFab = true;
                    s9ycHcoxAzy.showFabMenu(s9ycHcoxAzy.option1Container, s9ycHcoxAzy.option2Container, s9ycHcoxAzy.option3Container);
                } else {
                    s9ycHcoxAzy.isOpenFab = false;
                    s9ycHcoxAzy.hideFabMenu(s9ycHcoxAzy.option1Container, s9ycHcoxAzy.option2Container, s9ycHcoxAzy.option3Container);
                }
            }
        });
        this.option1Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                S9ycHcoxAzy.this.scanerQRDirect(Nl0yptXmjQ.CajaExtra);
            }
        });
        this.option2Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                S9ycHcoxAzy.this.scanerQRDirect(Nl0yptXmjQ.Transferencia);
            }
        });
        this.option3Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                S9ycHcoxAzy.this.scanerQRDirect(Nl0yptXmjQ.xf94v3SFEM);
            }
        });
        try {
            getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy$$ExternalSyntheticLambda1
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public final void onBackStackChanged() {
                    this.f$0.lambda$onCreate$0();
                }
            });
        } catch (Exception e7) {
        }
        if (savedInstanceState != null) {
            if (this.isOpenFab) {
                this.isOpenFab = true;
                showFabMenu(this.option1Container, this.option2Container, this.option3Container);
            } else {
                this.isOpenFab = false;
                hideFabMenu(this.option1Container, this.option2Container, this.option3Container);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.containerView);
        updateComponentVisibility(currentFragment);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.loalLocalBroadcastManager = LocalBroadcastManager.getInstance(this.context);
        IntentFilter filter = new IntentFilter();
        filter.addAction(rDEl7rW1aN.ACTION);
        this.loalLocalBroadcastManager.registerReceiver(this.br, filter);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LimpiarFragmentManager() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
        FragmentTransaction fmx = fm.beginTransaction();
        fmx.replace(R.id.containerView, new cYyrKJVQ6G()).addToBackStack(null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uncheckAllMenuItems(NavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem uyh0pxs9m37in = menu.getItem(i);
            if (uyh0pxs9m37in.hasSubMenu()) {
                SubMenu subMenu = uyh0pxs9m37in.getSubMenu();
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    subMenuItem.setChecked(false);
                }
            } else {
                uyh0pxs9m37in.setChecked(false);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int backEntry = fm.getBackStackEntryCount();
        if (backEntry > 1) {
            fm.popBackStack();
        } else {
            openQuitDialog();
        }
    }

    private void openQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.confirm));
        builder.setMessage(getString(R.string.confirm_close));
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                S9ycHcoxAzy.this.finish();
            }
        });
        builder.setNegativeButton("NO", (DialogInterface.OnClickListener) null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void datos() {
        List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.confirm));
        builder.setMessage("imei: " + appConfigs.get(0).getImei() + " version:" + appConfigs.get(0).getNumber() + " activada: " + appConfigs.get(0).getPhone());
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                S9ycHcoxAzy.this.finish();
            }
        });
        builder.setNegativeButton("NO", (DialogInterface.OnClickListener) null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void UpdateMenu() {
        unYp8VQThY.init(this);
        List<Factura> facturaList = unYp8VQThY.getInstance().getFacturasListsWithoutName();
        List<ServicioPublico> servicioPublicoList = unYp8VQThY.getInstance().getServiciosPublicosListsWithoutName();
        int facturaCount = facturaList != null ? facturaList.size() : 0;
        int servicioCount = servicioPublicoList != null ? servicioPublicoList.size() : 0;
        int count = facturaCount + servicioCount;
        Menu menuNav = this.mNavigationView.getMenu();
        MenuItem element = menuNav.findItem(R.id.gestion);
        if (count > 0) {
            String counter = Integer.toString(count);
            String s = getString(R.string.gestion) + "   " + counter + " ";
            SpannableString sColored = new SpannableString(s);
            sColored.setSpan(new BackgroundColorSpan(-65536), s.length() - 3, s.length(), 0);
            sColored.setSpan(new ForegroundColorSpan(-1), s.length() - 3, s.length(), 0);
            element.setTitle(sColored);
        } else {
            element.setTitle(getString(R.string.gestion));
        }
        FBsQzP3Zfj.menuControlBanks(this.nav_Menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ValidateVersion() {
        unYp8VQThY.init(this);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
        if (appConfigList.size() == 0) {
            AppConfig app = new AppConfig();
            app.setCodigo(getString(R.string.codigoAcceso));
            app.setNumber(getString(R.string.version_transfermovil));
            app.setActivada(false);
            unYp8VQThY.getInstance().addAppConfig(app);
            String cadena = "tel:*" + app.getCodigo() + "*100*" + app.getNumber() + Uri.encode("#");
            Uri number = Uri.parse(cadena);
            try {
                Intent dial = new Intent("android.intent.action.CALL", number);
                startActivity(dial);
                return;
            } catch (Exception e) {
                return;
            }
        }
        if (appConfigList.get(0).getImei() != null && appConfigList.get(0).getImei().contains("new_version")) {
            String cadena2 = "tel:*" + appConfigList.get(0).getCodigo() + "*100*" + appConfigList.get(0).getNumber() + Uri.encode("#");
            Uri number2 = Uri.parse(cadena2);
            AppConfig app_data = appConfigList.get(0);
            app_data.setImei(com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
            unYp8VQThY.getInstance().updateAppConfig(app_data);
            try {
                Intent dial2 = new Intent("android.intent.action.CALL", number2);
                startActivity(dial2);
            } catch (Exception e2) {
            }
        }
    }

    private void checkAndroidVersion() {
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermission();
        }
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE") + ContextCompat.checkSelfPermission(this, "android.permission.READ_SMS") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CALL_PHONE") || ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_SMS")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Por favor conceda los permisos necesarios para el uso de esta aplicación").setCancelable(true).setPositiveButton("Conceder", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.9
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        S9ycHcoxAzy.this.requestPermissions(new String[]{"android.permission.CALL_PHONE", "android.permission.READ_SMS"}, 123);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return;
            }
            requestPermissions(new String[]{"android.permission.CALL_PHONE", "android.permission.READ_SMS"}, 123);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (grantResults.length > 0) {
                    boolean cameraPermission = grantResults[1] == 0;
                    boolean readExternalFile = grantResults[0] == 0;
                    if (!cameraPermission || !readExternalFile) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("Por favor conceda los permisos necesarios para el uso de esta aplicación").setCancelable(true).setPositiveButton("Conceder", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.10
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int id) {
                                S9ycHcoxAzy.this.requestPermissions(new String[]{"android.permission.CALL_PHONE", "android.permission.READ_SMS"}, 123);
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
                break;
        }
    }

    private void checkIntentApp() {
        try {
            Intent intent = getIntent();
            String action = intent.getAction();
            String type = intent.getType();
            if ("android.intent.action.SEND".equals(action) && type != null && "text/plain".equals(type)) {
                String sharedText = intent.getStringExtra("android.intent.extra.TEXT");
                enviarDatos(sharedText);
            }
            if (intent.getData() != null && (intent.getData().getScheme().equals("http") || intent.getData().getScheme().equals("transfermovil"))) {
                Uri data = intent.getData();
                String id_transaccion = data.getQueryParameter("id_transaccion");
                String importe = data.getQueryParameter("importe");
                String moneda = data.getQueryParameter("moneda");
                String numero_proveedor = data.getQueryParameter("numero_proveedor");
                String descripcion = data.getQueryParameter("descripcion");
                JSONObject obj = new JSONObject();
                String importe2 = importe.replace(",", ".");
                try {
                    obj.put("id_transaccion", id_transaccion);
                    obj.put("importe", new Double(importe2));
                    try {
                        obj.put("moneda", moneda);
                        try {
                            obj.put("numero_proveedor", new Integer(numero_proveedor));
                            obj.put("version", com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
                            if (descripcion != null) {
                                try {
                                    if (descripcion.length() > 0) {
                                        obj.put("descripcion", descripcion);
                                    }
                                } catch (JSONException e) {
                                    e = e;
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e2) {
                            e = e2;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                    }
                } catch (JSONException e4) {
                    e = e4;
                }
                enviarDatos(obj.toString());
                return;
            }
            if (intent.getData() != null) {
                if (intent.getData().getScheme().equals("https") || intent.getData().getScheme().equals("transfermovil")) {
                    Uri data2 = intent.getData();
                    String id_transaccion2 = data2.getQueryParameter("id_transaccion");
                    String importe3 = data2.getQueryParameter("importe");
                    String moneda2 = data2.getQueryParameter("moneda");
                    String numero_proveedor2 = data2.getQueryParameter("numero_proveedor");
                    String descripcion2 = data2.getQueryParameter("descripcion");
                    JSONObject obj2 = new JSONObject();
                    String importe4 = importe3.replace(",", ".");
                    try {
                        obj2.put("id_transaccion", id_transaccion2);
                        obj2.put("importe", new Double(importe4));
                        try {
                            obj2.put("moneda", moneda2);
                            try {
                                obj2.put("numero_proveedor", new Integer(numero_proveedor2));
                                obj2.put("version", com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
                                if (descripcion2 != null) {
                                    try {
                                        if (descripcion2.length() > 0) {
                                            obj2.put("descripcion", descripcion2);
                                        }
                                    } catch (JSONException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                    }
                                }
                            } catch (JSONException e6) {
                                e = e6;
                            }
                        } catch (JSONException e7) {
                            e = e7;
                        }
                    } catch (JSONException e8) {
                        e = e8;
                    }
                    enviarDatos(obj2.toString());
                }
            }
        } catch (Exception e9) {
            Toast.makeText(this.context, "Ha ocurrido un error inesperado.", 1).show();
        }
    }

    public void enviarDatos(final String valor_enviar) {
        CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO", "MITRANSFER"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Para ejecutar el pago debe seleccionar el banco:");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = S9ycHcoxAzy.this.getSupportFragmentManager();
                mFragmentManager.beginTransaction();
                Bundle arg = new Bundle();
                arg.putString("APK_VALUE", valor_enviar);
                switch (i) {
                    case 0:
                        FragmentTransaction mFragmentTransaction = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                        r7Rinp9ooL pagoFragment = new r7Rinp9ooL();
                        pagoFragment.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        FragmentTransaction mFragmentTransaction2 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                        r7Rinp9ooL pagoFragment2 = new r7Rinp9ooL();
                        pagoFragment2.setArguments(arg);
                        mFragmentTransaction2.replace(R.id.containerView, pagoFragment2).addToBackStack(null).commit();
                        break;
                    case 2:
                        FragmentTransaction mFragmentTransaction3 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                        r7Rinp9ooL pagoFragment3 = new r7Rinp9ooL();
                        pagoFragment3.setArguments(arg);
                        mFragmentTransaction3.replace(R.id.containerView, pagoFragment3).addToBackStack(null).commit();
                        break;
                    case 3:
                        FragmentTransaction mFragmentTransaction4 = S9ycHcoxAzy.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        s9CT6pjRyD pagoFragment4 = new s9CT6pjRyD();
                        pagoFragment4.setArguments(arg);
                        mFragmentTransaction4.replace(R.id.containerView, pagoFragment4).addToBackStack(null).commit();
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void mensajeBienvendida() {
        try {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            View eulaLayout = LayoutInflater.from(this).inflate(R.layout.ljbvmn8fccxie, (ViewGroup) null);
            this.dontShowAgain = (CheckBox) eulaLayout.findViewById(R.id.skip);
            adb.setView(eulaLayout);
            adb.setTitle(getString(R.string.title_bienvenido_tm));
            adb.setMessage(getString(R.string.sub_bienvenido));
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    S9ycHcoxAzy.this.ValidateVersion();
                    if (S9ycHcoxAzy.this.dontShowAgain.isChecked()) {
                        AppConfig ap = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                        ap.setMensajeInicio(false);
                        unYp8VQThY.getInstance().updateAppConfig(ap);
                    }
                }
            });
            adb.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    S9ycHcoxAzy.this.ValidateVersion();
                }
            });
            adb.show();
        } catch (Exception ex) {
            Log.e("Excetion", ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFabMenu(View... views) {
        for (View view : views) {
            view.setVisibility(0);
            ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", 100.0f, 0.0f);
            ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(translationY, alpha);
            animatorSet.setDuration(150L);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFabMenu(View... views) {
        for (final View view : views) {
            ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 100.0f);
            ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(translationY, alpha);
            animatorSet.setDuration(150L);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy.14
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanerQRDirect(Nl0yptXmjQ operationEntity) {
        if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
            return;
        }
        f6Y2Wmtg6jQ qr = new f6Y2Wmtg6jQ(new ysmUbWW79P() { // from class: cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy$$ExternalSyntheticLambda0
            @Override // cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ysmUbWW79P
            public final void onCommunicatorQRScannerResponse(boolean z, String str) {
                this.f$0.onCommunicatorQRScannerResponse(z, str);
            }
        });
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", operationEntity);
        qr.setArguments(arg);
        FragmentTransaction xfragmentTransaction = getSupportFragmentManager().beginTransaction();
        xfragmentTransaction.replace(R.id.containerView, qr).addToBackStack(null).commit();
    }

    private void updateComponentVisibility(Fragment fragment) {
        if (fragment instanceof cYyrKJVQ6G) {
            this.fabQr.setVisibility(0);
            hideFabMenu(new View[0]);
        } else {
            this.fabQr.setVisibility(8);
        }
        this.isOpenFab = false;
        hideFabMenu(this.option1Container, this.option2Container, this.option3Container);
    }

    @Override // cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ysmUbWW79P
    public void onCommunicatorQRScannerResponse(boolean showMessage, String message) {
        if (showMessage) {
            ShowMessageADialog("Alerta", message);
        }
    }
}
