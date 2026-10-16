package cu.etecsa.cubacel.tr.tm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
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
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.wRqLBJvNq6;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.gCD4Z8F6ml;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.s88cBrrDEaR;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.BIc10fn03P;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.HBFPOv3Hig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.Pg7MuGKEAe;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.z5XKGtUeX8;
import cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM;
import cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.cYyrKJVQ6G;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ;
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
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.mYaQ7jnA3Y;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.postcP0gVS;
import cu.etecsa.cubacel.tr.tm.wdZPlVFi6hH.pNvP5NiOcI;
import cu.etecsa.tm.ecommerce.a7Y4bbw8Os;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IHVTCBmiLV extends rDEl7rW1aN implements ysmUbWW79P {
    public Activity activity;
    public Context context;
    public CheckBox dontShowAgain;
    public FloatingActionButton fabOption1;
    public FloatingActionButton fabOption2;
    public FloatingActionButton fabOption3;
    public FloatingActionButton fabQr;
    public boolean isOpenFab = false;
    public DrawerLayout mDrawerLayout;
    public NavigationView mNavigationView;
    public Fr52O1uSYF msap;
    public Menu nav_Menu;
    public LinearLayout option1Container;
    public LinearLayout option2Container;
    public LinearLayout option3Container;
    public Toolbar toolbar;

    /* JADX WARN: Code duplicated, block: B:40:0x0146 A[Catch: Exception -> 0x0204, TryCatch #3 {Exception -> 0x0204, blocks: (B:12:0x0053, B:14:0x009b, B:17:0x00b2, B:19:0x00be, B:24:0x00e3, B:26:0x0107, B:38:0x013b, B:40:0x0146, B:42:0x014f, B:43:0x0152, B:45:0x0174, B:47:0x017a, B:21:0x00ca, B:23:0x00d7, B:16:0x00ab, B:11:0x004a, B:33:0x011c, B:35:0x0130, B:3:0x001c, B:5:0x002d, B:6:0x0031, B:8:0x0045), top: B:84:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x014f A[Catch: Exception -> 0x0204, TryCatch #3 {Exception -> 0x0204, blocks: (B:12:0x0053, B:14:0x009b, B:17:0x00b2, B:19:0x00be, B:24:0x00e3, B:26:0x0107, B:38:0x013b, B:40:0x0146, B:42:0x014f, B:43:0x0152, B:45:0x0174, B:47:0x017a, B:21:0x00ca, B:23:0x00d7, B:16:0x00ab, B:11:0x004a, B:33:0x011c, B:35:0x0130, B:3:0x001c, B:5:0x002d, B:6:0x0031, B:8:0x0045), top: B:84:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0174 A[Catch: Exception -> 0x0204, TryCatch #3 {Exception -> 0x0204, blocks: (B:12:0x0053, B:14:0x009b, B:17:0x00b2, B:19:0x00be, B:24:0x00e3, B:26:0x0107, B:38:0x013b, B:40:0x0146, B:42:0x014f, B:43:0x0152, B:45:0x0174, B:47:0x017a, B:21:0x00ca, B:23:0x00d7, B:16:0x00ab, B:11:0x004a, B:33:0x011c, B:35:0x0130, B:3:0x001c, B:5:0x002d, B:6:0x0031, B:8:0x0045), top: B:84:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ae A[Catch: ParseException -> 0x01b8, Exception -> 0x0201, TRY_LEAVE, TryCatch #2 {ParseException -> 0x01b8, blocks: (B:53:0x01a3, B:55:0x01ae), top: B:86:0x01a3, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01bc A[DONT_INVERT, PHI: r7 r8
      0x01bc: PHI (r7v11 'today' java.util.Date) = (r7v10 'today' java.util.Date), (r7v12 'today' java.util.Date), (r7v12 'today' java.util.Date) binds: [B:59:0x01b9, B:54:0x01ac, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]
      0x01bc: PHI (r8v2 'fechaUltimaPromo' java.util.Date) = 
      (r8v1 'fechaUltimaPromo' java.util.Date)
      (r8v1 'fechaUltimaPromo' java.util.Date)
      (r8v3 'fechaUltimaPromo' java.util.Date)
     binds: [B:59:0x01b9, B:54:0x01ac, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x01be A[Catch: Exception -> 0x0201, TryCatch #7 {Exception -> 0x0201, blocks: (B:48:0x0181, B:53:0x01a3, B:55:0x01ae, B:61:0x01be, B:63:0x01c4, B:65:0x01cf, B:70:0x01f4, B:59:0x01b9), top: B:95:0x0181, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01c4 A[Catch: Exception -> 0x0201, TryCatch #7 {Exception -> 0x0201, blocks: (B:48:0x0181, B:53:0x01a3, B:55:0x01ae, B:61:0x01be, B:63:0x01c4, B:65:0x01cf, B:70:0x01f4, B:59:0x01b9), top: B:95:0x0181, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01cf A[Catch: Exception -> 0x0201, TRY_LEAVE, TryCatch #7 {Exception -> 0x0201, blocks: (B:48:0x0181, B:53:0x01a3, B:55:0x01ae, B:61:0x01be, B:63:0x01c4, B:65:0x01cf, B:70:0x01f4, B:59:0x01b9), top: B:95:0x0181, inners: #2 }] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws ParseException {
        List<AppConfig> appConfigList;
        DateFormat formatter;
        Date today;
        Date fechaUltimaPromo;
        List<PromoSMS> promoSMSList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v2yycjk1vicuy);
        IntentFilter filter = new IntentFilter(rDEl7rW1aN.ACTION);
        registerReceiver(this.mReceivedSMSReceiver, filter);
        try {
            try {
                unYp8VQThY.init(this);
                List<AppConfig> appConfigList2 = unYp8VQThY.getInstance().getAppConfigLists();
                if (appConfigList2.size() == 0 || unYp8VQThY.getInstance().getAllAppConfigLists().get(0).isMensajeInicio()) {
                    mensajeBienvendida();
                }
            } catch (Exception ex) {
                Log.e("ERROR_TM", ex.getMessage());
            }
            this.msap = new Fr52O1uSYF();
            this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            NavigationView navigationView = (NavigationView) findViewById(R.id.navigationdrawermenu);
            this.mNavigationView = navigationView;
            this.nav_Menu = navigationView.getMenu();
            this.activity = this;
            this.context = getApplicationContext();
            UpdateMenu();
            new HPuMiTypoW(getContentResolver()).execute(new Void[0]);
            if (this.msap.getPhone(getBaseContext()) == null || this.msap.getPhone(getBaseContext()).isEmpty()) {
                sms_actualizar_bd_datos_app(getContentResolver());
            }
            if ((!this.msap.getCodigoBanco().contains("-1") || this.msap.getCodigoBanco().isEmpty()) && this.msap.getCodigoBanco().length() > 3) {
                this.nav_Menu.findItem(R.id.group_comercio).setVisible(true);
            }
            this.nav_Menu.findItem(R.id.group_bancos_menu).setVisible(true);
            this.nav_Menu.findItem(R.id.group_estadisticas).setVisible(true);
            boolean enabled_miboleto = this.msap.getCodigoMiBoleto().contains("-1") || this.msap.getCodigoMiBoleto().isEmpty();
            if (!enabled_miboleto) {
                try {
                    boolean isMiBoletoActive = unYp8VQThY.getInstance().getAppConfigLists().get(0).isActivarmodulomiboleto();
                    if (isMiBoletoActive) {
                        this.nav_Menu.findItem(R.id.vendedor_miboleto).setVisible(true);
                        unYp8VQThY.init(getBaseContext());
                        if (savedInstanceState == null) {
                            LimpiarFragmentManager();
                        }
                        Toolbar version_app = (Toolbar) findViewById(R.id.toolbar);
                        version_app.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.1
                            public long then = 0;

                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view, MotionEvent event) {
                                if (event.getAction() == 0) {
                                    this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                                    return false;
                                }
                                if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                                    FragmentTransaction xfragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                                    xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                                    return true;
                                }
                                return false;
                            }
                        });
                        appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                        if (!appConfigList.get(0).isNoMostrarEncuesta() && FBsQzP3Zfj.validateExperienciaUsuario()) {
                            FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                        }
                        try {
                            formatter = new SimpleDateFormat("dd/MM/yyyy");
                            today = new Date();
                            fechaUltimaPromo = null;
                            try {
                                fechaUltimaPromo = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
                            } catch (Exception e) {
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
                        unYp8VQThY.init(getBaseContext());
                        if (savedInstanceState == null) {
                            LimpiarFragmentManager();
                        }
                        Toolbar version_app2 = (Toolbar) findViewById(R.id.toolbar);
                        version_app2.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.1
                            public long then = 0;

                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view, MotionEvent event) {
                                if (event.getAction() == 0) {
                                    this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                                    return false;
                                }
                                if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                                    FragmentTransaction xfragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                                    xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                                    return true;
                                }
                                return false;
                            }
                        });
                        appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                        if (!appConfigList.get(0).isNoMostrarEncuesta()) {
                            FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                        }
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        today = new Date();
                        fechaUltimaPromo = null;
                        fechaUltimaPromo = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
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
                unYp8VQThY.init(getBaseContext());
                if (savedInstanceState == null) {
                    LimpiarFragmentManager();
                }
                Toolbar version_app3 = (Toolbar) findViewById(R.id.toolbar);
                version_app3.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.1
                    public long then = 0;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent event) {
                        if (event.getAction() == 0) {
                            this.then = Long.valueOf(System.currentTimeMillis()).longValue();
                            return false;
                        }
                        if (event.getAction() == 1 && Long.valueOf(System.currentTimeMillis()).longValue() - this.then > 3000) {
                            FragmentTransaction xfragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                            xfragmentTransaction.replace(R.id.containerView, new fDxylqSabM()).commit();
                            return true;
                        }
                        return false;
                    }
                });
                appConfigList = unYp8VQThY.getInstance().getAppConfigLists();
                if (!appConfigList.get(0).isNoMostrarEncuesta()) {
                    FBsQzP3Zfj.encuestaUsuarios(this.activity, this.context);
                }
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                today = new Date();
                fechaUltimaPromo = null;
                fechaUltimaPromo = unYp8VQThY.getInstance().getAppConfigLists().get(0).getFechaUltimasPromos();
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
            Toast toast = Toast.makeText(getBaseContext(), R.string.err_open_app, 0);
            toast.show();
            System.runFinalization();
        }
        this.mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.2
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            @TargetApi(23)
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                IHVTCBmiLV.this.mDrawerLayout.closeDrawers();
                IHVTCBmiLV iHVTCBmiLV = IHVTCBmiLV.this;
                iHVTCBmiLV.uncheckAllMenuItems(iHVTCBmiLV.mNavigationView);
                IHVTCBmiLV.this.LimpiarFragmentManager();
                if (menuItem.getItemId() == R.id.inicio) {
                    FragmentTransaction xfragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new cYyrKJVQ6G()).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.agentes) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction2 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction2.replace(R.id.containerView, new wRqLBJvNq6()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.generales) {
                    if (Build.VERSION.SDK_INT >= 23 && IHVTCBmiLV.this.getBaseContext().checkSelfPermission("android.permission.READ_CONTACTS") == -1) {
                        IHVTCBmiLV.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                    }
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction3 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction3.replace(R.id.containerView, new s88cBrrDEaR()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.gestion) {
                    if (Build.VERSION.SDK_INT >= 23 && IHVTCBmiLV.this.getBaseContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
                        IHVTCBmiLV.this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                    }
                    menuItem.setChecked(true);
                    FragmentTransaction fragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    OQcONjDATJ gestionFragment = new OQcONjDATJ();
                    fragmentTransaction.replace(R.id.containerView, gestionFragment).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.resumidas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction4 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    Bundle b = new Bundle();
                    b.putString("newEstaditica", "1");
                    mYaQ7jnA3Y pay = new mYaQ7jnA3Y();
                    pay.setArguments(b);
                    xfragmentTransaction4.replace(R.id.containerView, pay).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.detalladas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction5 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction5.replace(R.id.containerView, new postcP0gVS()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.setting) {
                    menuItem.setChecked(true);
                    IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new UoWmGAF016()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.help) {
                    menuItem.setChecked(true);
                    FragmentTransaction fragmentTransaction2 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.setBreadCrumbShortTitle("sss");
                    fragmentTransaction2.replace(R.id.containerView, new pNvP5NiOcI()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bpa) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction6 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction6.replace(R.id.containerView, new Pg7MuGKEAe()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.metro) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction7 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction7.replace(R.id.containerView, new BIc10fn03P()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bandec) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction8 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction8.replace(R.id.containerView, new z5XKGtUeX8()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bfi) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction9 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction9.replace(R.id.containerView, new HBFPOv3Hig()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.cuentas) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction10 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction10.replace(R.id.containerView, new KeTIEVSfVo()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() == R.id.bulevar) {
                    Intent i = new Intent(IHVTCBmiLV.this.context, (Class<?>) a7Y4bbw8Os.class);
                    IHVTCBmiLV.this.startActivity(i);
                    return true;
                }
                if (menuItem.getItemId() == R.id.bolsa_etecsa) {
                    menuItem.setChecked(true);
                    FragmentTransaction xfragmentTransaction11 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                    xfragmentTransaction11.replace(R.id.containerView, new gCD4Z8F6ml()).addToBackStack(null).commit();
                    return true;
                }
                if (menuItem.getItemId() != R.id.vendedor_miboleto) {
                    return true;
                }
                menuItem.setChecked(true);
                FragmentTransaction xfragmentTransaction12 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                xfragmentTransaction12.replace(R.id.containerView, new wfroNBIJF7()).addToBackStack(null).commit();
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
        this.fabQr.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IHVTCBmiLV iHVTCBmiLV = IHVTCBmiLV.this;
                if (!iHVTCBmiLV.isOpenFab) {
                    iHVTCBmiLV.isOpenFab = true;
                    iHVTCBmiLV.showFabMenu(iHVTCBmiLV.option1Container, iHVTCBmiLV.option2Container, iHVTCBmiLV.option3Container);
                } else {
                    iHVTCBmiLV.isOpenFab = false;
                    iHVTCBmiLV.hideFabMenu(iHVTCBmiLV.option1Container, iHVTCBmiLV.option2Container, iHVTCBmiLV.option3Container);
                }
            }
        });
        this.option1Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IHVTCBmiLV.this.scanerQRDirect(Nl0yptXmjQ.CajaExtra);
            }
        });
        this.option2Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IHVTCBmiLV.this.scanerQRDirect(Nl0yptXmjQ.Transferencia);
            }
        });
        this.option3Container.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IHVTCBmiLV.this.scanerQRDirect(Nl0yptXmjQ.xf94v3SFEM);
            }
        });
        try {
            getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV$$ExternalSyntheticLambda0
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public final void onBackStackChanged() {
                    this.f$0.lambda$onCreate$0();
                }
            });
        } catch (Exception e7) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.containerView);
        updateComponentVisibility(currentFragment);
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

    public void UpdateMenu() {
        unYp8VQThY.init(this);
        List<Pin> pinLists = unYp8VQThY.getInstance().getPinListsWithoutDesc();
        List<Client> clienteLists = unYp8VQThY.getInstance().getClientListsWithoutName();
        List<TelfFijo> fijosLists = unYp8VQThY.getInstance().getFijosListsWithoutName();
        List<TeflMovil> movilList = unYp8VQThY.getInstance().getMovilListsWithoutName();
        List<Nauta> nautaList = unYp8VQThY.getInstance().getNautaListsWithoutName();
        List<Factura> facturaList = unYp8VQThY.getInstance().getFacturasListsWithoutName();
        List<ServicioPublico> servicioPublicoList = unYp8VQThY.getInstance().getServiciosPublicosListsWithoutName();
        int fijosCount = fijosLists != null ? fijosLists.size() : 0;
        int clientCount = clienteLists != null ? clienteLists.size() : 0;
        int pinesCount = pinLists != null ? pinLists.size() : 0;
        int movilesCount = movilList != null ? movilList.size() : 0;
        int nautasCount = nautaList != null ? nautaList.size() : 0;
        int facturaCount = facturaList != null ? facturaList.size() : 0;
        int servicioCount = servicioPublicoList != null ? servicioPublicoList.size() : 0;
        int count = clientCount + pinesCount + fijosCount + movilesCount + nautasCount + facturaCount + servicioCount;
        Menu menuNav = this.mNavigationView.getMenu();
        MenuItem element = menuNav.findItem(R.id.gestion);
        if (count <= 0) {
            element.setTitle(getString(R.string.gestion));
        } else {
            String counter = Integer.toString(count);
            String s = getString(R.string.gestion) + "   " + counter + " ";
            SpannableString sColored = new SpannableString(s);
            sColored.setSpan(new BackgroundColorSpan(-65536), s.length() - 3, s.length(), 0);
            sColored.setSpan(new ForegroundColorSpan(-1), s.length() - 3, s.length(), 0);
            element.setTitle(sColored);
        }
        FBsQzP3Zfj.menuControlBanks(this.nav_Menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int backEntry = fm.getBackStackEntryCount();
        if (fm.getFragments().get(0) instanceof cYyrKJVQ6G) {
            Log.d("a", "a");
        }
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                IHVTCBmiLV.this.finish();
            }
        });
        builder.setNegativeButton("NO", (DialogInterface.OnClickListener) null);
        AlertDialog alert = builder.create();
        alert.show();
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
                    String importe4 = importe3.replace(",", ".");
                    JSONObject obj2 = new JSONObject();
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
        CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO", "MITRANSFER", "BFI"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Para ejecutar el pago debe seleccionar el banco:");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = IHVTCBmiLV.this.getSupportFragmentManager();
                mFragmentManager.beginTransaction();
                Bundle arg = new Bundle();
                arg.putString("APK_VALUE", valor_enviar);
                switch (i) {
                    case 0:
                        FragmentTransaction mFragmentTransaction = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                        r7Rinp9ooL pagoFragment = new r7Rinp9ooL();
                        pagoFragment.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        FragmentTransaction mFragmentTransaction2 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                        r7Rinp9ooL pagoFragment2 = new r7Rinp9ooL();
                        pagoFragment2.setArguments(arg);
                        mFragmentTransaction2.replace(R.id.containerView, pagoFragment2).addToBackStack(null).commit();
                        break;
                    case 2:
                        FragmentTransaction mFragmentTransaction3 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                        r7Rinp9ooL pagoFragment3 = new r7Rinp9ooL();
                        pagoFragment3.setArguments(arg);
                        mFragmentTransaction3.replace(R.id.containerView, pagoFragment3).addToBackStack(null).commit();
                        break;
                    case 3:
                        FragmentTransaction mFragmentTransaction4 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        s9CT6pjRyD pagoFragment4 = new s9CT6pjRyD();
                        pagoFragment4.setArguments(arg);
                        mFragmentTransaction4.replace(R.id.containerView, pagoFragment4).addToBackStack(null).commit();
                        break;
                    case 4:
                        FragmentTransaction mFragmentTransaction5 = IHVTCBmiLV.this.getSupportFragmentManager().beginTransaction();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.Transferencia);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        r7Rinp9ooL pagoFragment5 = new r7Rinp9ooL();
                        pagoFragment5.setArguments(arg);
                        mFragmentTransaction5.replace(R.id.containerView, pagoFragment5).addToBackStack(null).commit();
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
            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    IHVTCBmiLV.this.ValidateVersion();
                    if (IHVTCBmiLV.this.dontShowAgain.isChecked()) {
                        AppConfig ap = unYp8VQThY.getInstance().getAllAppConfigLists().get(0);
                        ap.setMensajeInicio(false);
                        unYp8VQThY.getInstance().updateAppConfig(ap);
                    }
                }
            });
            adb.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.10
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    IHVTCBmiLV.this.ValidateVersion();
                }
            });
            adb.show();
        } catch (Exception ex) {
            Log.e("Excetion", ex.getMessage());
        }
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
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV.11
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
        f6Y2Wmtg6jQ qr = new f6Y2Wmtg6jQ(new ysmUbWW79P() { // from class: cu.etecsa.cubacel.tr.tm.IHVTCBmiLV$$ExternalSyntheticLambda1
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
