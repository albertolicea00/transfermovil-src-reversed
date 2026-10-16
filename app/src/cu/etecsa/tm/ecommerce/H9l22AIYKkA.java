package cu.etecsa.tm.ecommerce;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.WriterException;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.qQsnaKw3VY;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.wnGiwuD0kT;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.RKxbomWW57;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.Z5fUajldziN;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.V9CpxZJfIeK;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.p0XuqX2hWag;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.qztlzqkyWH;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.Y4BGwPjdRJT;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.iHni1rlkwr;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j8e1KQ8gfS;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.u1cC1eLpoh3;
import cu.etecsa.tm.ecommerce.cclrmrQMCrJ.cLjDBJlvRe;
import cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA;
import cu.etecsa.tm.ecommerce.l1i6XXWOfGBF.zMnpbxBIN5;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class H9l22AIYKkA extends AppCompatActivity implements qQsnaKw3VY, KFxuVD3dg2, V9CpxZJfIeK, SRIeLPPchM, m7xsfApYLch {
    public static int MAX_CONTADOR = QV8ylwbhfB.ITEM_TYPE_RECYCLER_WIDTH;
    private static final int REQUEST_LOGIN = 0;
    private static final int TYPING_TIMER_LENGTH = 600;
    public Activity activity;
    private View background;
    public Button bt_1;
    public Button bt_2;
    public Button bt_3;
    public Button bt_4;
    public Button bt_5;
    public Button bt_6;
    public Button bt_7;
    public Button bt_8;
    public Button bt_9;
    public ImageButton bt_borrar;
    public Button bt_cero;
    public ImageButton bt_clear;
    public Button bt_doblecero;
    public ImageButton bt_done;
    public Button bt_suma;
    public boolean chequear;
    public int contador;
    public ArrayAdapter<LWt69JQUoH> cuentasArrayAdapter;
    public HLAV6HkYgi cuentasPresenter;
    public RXqUCo8r9g devPresenter;
    public MaterialAutoCompleteTextView edDescripcion;
    public boolean hasHashtags;
    public u1cC1eLpoh3 hashtagPresenter;
    public String idPago;
    public boolean isConfiguracionWSActiva;
    public Boolean isShareQR;
    public TextInputLayout lyCuentas;
    private ProgressBar mProgressView;
    private Socket mSocket;
    public String numeroCuenta;
    private LinearLayout pBar;
    public Q3QlsyUy019 pagoPresenter;
    public Dialog settingsDialog;
    public String source;
    public Hrke6IBHBA spCuentas;
    public SpinnerDialog spinnerDialog;
    public Timer timer;
    public TextView txMoneda;
    public TextView txTotalResult;
    public mB0ZJmAKFb wsBulevar;
    public String HEAD_LOG = "H9l22AIYKkA";
    public String result = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
    public ArrayList<String> items = new ArrayList<>();
    public String DEEP_LINK_URL = "https://transfermovil.app/action?";
    public String dataSendQR = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
    private boolean mTyping = false;
    private Handler mTypingHandler = new Handler();
    private Boolean isConnected = false;
    private Hrke6IBHBA.OnItemClickListener spClickMisCuentas = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.7
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            LWt69JQUoH item = H9l22AIYKkA.this.cuentasArrayAdapter.getItem(position);
            H9l22AIYKkA.this.numeroCuenta = item.getSource();
        }
    };
    public View.OnClickListener onClickShare = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            H9l22AIYKkA.this.share();
        }
    };
    public View.OnClickListener onClickUpdate = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (H9l22AIYKkA.this.isOnline()) {
                H9l22AIYKkA h9l22AIYKkA = H9l22AIYKkA.this;
                h9l22AIYKkA.pagoPresenter.checkPago(h9l22AIYKkA.idPago);
            }
        }
    };
    private Emitter.Listener onConnect = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.11
        @Override // io.socket.emitter.Emitter.Listener
        public void call(Object... args) {
            H9l22AIYKkA.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.11.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("CHAT", "conected");
                    H9l22AIYKkA.this.isConnected = true;
                }
            });
        }
    };
    private Emitter.Listener onDisconnect = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.12
        @Override // io.socket.emitter.Emitter.Listener
        public void call(Object... args) {
            H9l22AIYKkA.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.12.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("CHAT", "diconnected");
                    H9l22AIYKkA.this.isConnected = false;
                    H9l22AIYKkA.this.mSocket.connect();
                }
            });
        }
    };
    private Emitter.Listener onConnectError = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.13
        @Override // io.socket.emitter.Emitter.Listener
        public void call(final Object... args) {
            H9l22AIYKkA.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.13.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("CHAT", "Error connecting");
                    Log.e("CHAT", args[0].toString());
                    H9l22AIYKkA.this.isConnected = false;
                    H9l22AIYKkA.this.mSocket.connect();
                }
            });
        }
    };
    private Emitter.Listener onNewMessage = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.14
        @Override // io.socket.emitter.Emitter.Listener
        public void call(final Object... args) {
            H9l22AIYKkA.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.14.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("CHAT", args[0].toString());
                    try {
                        JSONObject data = (JSONObject) args[0];
                        H9l22AIYKkA.this.leerMensaje(data);
                    } catch (Exception ex) {
                        Log.e("CHAT", "Error en lectura de mensaje: " + ex.getMessage());
                    }
                }
            });
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ibbq3zwlazpsa);
        this.idPago = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
        this.lyCuentas = (TextInputLayout) findViewById(R.id.lyCuentas);
        this.spCuentas = (Hrke6IBHBA) findViewById(R.id.spCuentas);
        this.chequear = false;
        this.hasHashtags = false;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) findViewById(R.id.edDescripcion);
        this.edDescripcion = materialAutoCompleteTextView;
        materialAutoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1 && event.getRawX() >= H9l22AIYKkA.this.edDescripcion.getRight() - H9l22AIYKkA.this.edDescripcion.getCompoundDrawables()[2].getBounds().width()) {
                    H9l22AIYKkA.this.edDescripcion.setText(com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
                    return true;
                }
                return false;
            }
        });
        this.txTotalResult = (TextView) findViewById(R.id.txTotalResult);
        this.txMoneda = (TextView) findViewById(R.id.txMoneda);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.pBar = (LinearLayout) findViewById(R.id.llProgressBar);
        this.bt_1 = (Button) findViewById(R.id.bt_1);
        this.bt_2 = (Button) findViewById(R.id.bt_2);
        this.bt_3 = (Button) findViewById(R.id.bt_3);
        this.bt_4 = (Button) findViewById(R.id.bt_4);
        this.bt_5 = (Button) findViewById(R.id.bt_5);
        this.bt_6 = (Button) findViewById(R.id.bt_6);
        this.bt_7 = (Button) findViewById(R.id.bt_7);
        this.bt_8 = (Button) findViewById(R.id.bt_8);
        this.bt_9 = (Button) findViewById(R.id.bt_9);
        this.bt_cero = (Button) findViewById(R.id.bt_cero);
        this.bt_doblecero = (Button) findViewById(R.id.bt_doblecero);
        this.bt_borrar = (ImageButton) findViewById(R.id.bt_borrar);
        this.bt_clear = (ImageButton) findViewById(R.id.bt_clear);
        this.bt_done = (ImageButton) findViewById(R.id.bt_done);
        this.pagoPresenter = new iHni1rlkwr(this, getApplicationContext());
        this.bt_done.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                H9l22AIYKkA.this.vender();
            }
        });
        HLAV6HkYgi hLAV6HkYgi = new HLAV6HkYgi(this, this);
        this.cuentasPresenter = hLAV6HkYgi;
        hLAV6HkYgi.getCuentas();
        Y4BGwPjdRJT y4BGwPjdRJT = new Y4BGwPjdRJT(this, this);
        this.hashtagPresenter = y4BGwPjdRJT;
        y4BGwPjdRJT.getHashtag();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.timer = new Timer();
        this.contador = 0;
        this.devPresenter = new j8e1KQ8gfS(this, this);
        this.wsBulevar = new mB0ZJmAKFb(getApplicationContext(), this);
        this.activity = this;
        cargaConfiguracion();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        cargaConfiguracion();
        if (this.isConfiguracionWSActiva) {
            Socket socket = this.wsBulevar.getSocket();
            this.mSocket = socket;
            socket.on("connect", this.onConnect);
            this.mSocket.on("disconnect", this.onDisconnect);
            this.mSocket.on("connect_error", this.onConnectError);
            if (!this.isConnected.booleanValue()) {
                this.mSocket.connect();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isConfiguracionWSActiva && !this.isConnected.booleanValue()) {
            this.mSocket.connect();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void cargaConfiguracion() {
        String comunicationState = UhA7J2923N.getInstance().getComunicationMode();
        if (comunicationState != null && comunicationState.length() > 0 && comunicationState.contains("ON")) {
            this.isConfiguracionWSActiva = true;
        } else {
            this.isConfiguracionWSActiva = false;
        }
    }

    public void onClickOperations(View v) {
        String valor = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
        int i = v.getId();
        if (i == R.id.bt_1) {
            valor = "1";
        } else if (i == R.id.bt_2) {
            valor = "2";
        } else if (i == R.id.bt_3) {
            valor = "3";
        } else if (i == R.id.bt_4) {
            valor = "4";
        } else if (i == R.id.bt_5) {
            valor = "5";
        } else if (i == R.id.bt_6) {
            valor = "6";
        } else if (i == R.id.bt_7) {
            valor = "7";
        } else if (i == R.id.bt_8) {
            valor = "8";
        } else if (i == R.id.bt_9) {
            valor = "9";
        } else if (i == R.id.bt_cero) {
            valor = "0";
        } else if (i == R.id.bt_doblecero) {
            valor = "00";
        } else if (i != R.id.bt_sum) {
            if (i == R.id.bt_borrar) {
                if (this.result.length() > 0) {
                    String str = this.result;
                    String strSubstring = str.substring(0, str.length() - 1);
                    this.result = strSubstring;
                    String resultado = formatoResultado(strSubstring);
                    this.txTotalResult.setText(resultado);
                    return;
                }
            } else if (i == R.id.bt_clear && this.result.length() > 0) {
                this.result = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
                String resultado2 = formatoResultado(com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
                this.txTotalResult.setText(resultado2);
                return;
            }
        }
        String str2 = this.result + valor;
        this.result = str2;
        String resultado3 = formatoResultado(str2);
        this.txTotalResult.setText(resultado3);
    }

    private String formatoResultado(String digits) {
        if (digits.length() > 2) {
            String pound = digits.substring(0, digits.length() - 2);
            String pence = digits.substring(digits.length() - 2);
            String string = "$" + pound + "." + pence;
            return string;
        }
        if (digits.length() == 1) {
            String string2 = "$0.0" + digits;
            return string2;
        }
        if (digits.length() != 2) {
            return "$";
        }
        String string3 = "$0." + digits;
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vender() {
        this.idPago = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
        if (isOnline()) {
            if (validateCuenta() && validateImporte()) {
                String importe = this.txTotalResult.getText().toString().replace("$", com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
                float mount = Float.parseFloat(importe);
                Log.i("SQOxNLWPOW", String.valueOf(importe));
                String descripcion = this.edDescripcion.getText().toString();
                this.pagoPresenter.setProgressBarVisiblity(0);
                this.pagoPresenter.enviarPago(Integer.valueOf(this.numeroCuenta).intValue(), descripcion, mount);
                return;
            }
            return;
        }
        this.pagoPresenter.setProgressBarVisiblity(4);
    }

    public boolean validateCuenta() {
        if (this.numeroCuenta == null) {
            this.lyCuentas.setError("Selecione una cuenta");
            requestFocus(this.spCuentas);
            return false;
        }
        if (this.spCuentas.getText().toString().trim().isEmpty()) {
            this.lyCuentas.setError("Selecione una cuenta");
            requestFocus(this.spCuentas);
            return false;
        }
        this.lyCuentas.setErrorEnabled(false);
        return true;
    }

    public boolean validateImporte() {
        String str = this.result;
        if (str == null || str == com.github.paolorotolo.appintro.BuildConfig.FLAVOR || str.length() == 0) {
            ShowMessageADialog("Importe", "El importe no puede ser vacío");
            return false;
        }
        return true;
    }

    private void qrGenerator(String cadena) throws WriterException {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.logo_transfermovil_sm);
        Bitmap bm = cLjDBJlvRe.ProductLogo(icon, cadena, false, R.color.colorPrimary);
        this.settingsDialog = new Dialog(this);
        View v = getLayoutInflater().inflate(R.layout.nnerqkmonjy9o, (ViewGroup) null);
        ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
        Button btClose = (Button) v.findViewById(R.id.btClose);
        ImageView btShare = (ImageView) v.findViewById(R.id.btShare);
        btShare.setOnClickListener(this.onClickShare);
        ImageView btUpdate = (ImageView) v.findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(this.onClickUpdate);
        iv.setImageBitmap(bm);
        this.settingsDialog.getWindow().requestFeature(1);
        this.settingsDialog.setContentView(v);
        this.settingsDialog.setCanceledOnTouchOutside(false);
        this.settingsDialog.setCancelable(false);
        this.settingsDialog.show();
        btClose.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                H9l22AIYKkA.this.settingsDialog.dismiss();
            }
        });
    }

    private boolean fillCuentas(List<LWt69JQUoH> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    boolean hasAccountPref = false;
                    String account = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
                    if (UhA7J2923N.getInstance().getPrefAccount() != null && UhA7J2923N.getInstance().getPrefAccount().length() > 0) {
                        hasAccountPref = true;
                        account = UhA7J2923N.getInstance().getPrefAccount();
                    }
                    this.cuentasArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
                    for (LWt69JQUoH item : list) {
                        if (hasAccountPref) {
                            try {
                                if (item.getSource().contains(account)) {
                                    this.spCuentas.setText(item.getSource() + " - " + item.getName());
                                    this.numeroCuenta = item.getSource();
                                }
                            } catch (Exception e) {
                            }
                        }
                        this.cuentasArrayAdapter.add(item);
                    }
                    this.cuentasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spCuentas.setAdapter(this.cuentasArrayAdapter);
                    this.spCuentas.setOnItemClickListener(this.spClickMisCuentas);
                    return true;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.qQsnaKw3VY
    public void onPagoResult(Boolean result, int code, String mensaje, IIvRN9WfE5 response) throws WriterException {
        this.pagoPresenter.setProgressBarVisiblity(4);
        if (result.booleanValue()) {
            this.txTotalResult.setText("00.00");
            this.edDescripcion.setText(com.github.paolorotolo.appintro.BuildConfig.FLAVOR);
            this.result = com.github.paolorotolo.appintro.BuildConfig.FLAVOR;
            Gson gson = new Gson();
            Log.i("PAGOQR", gson.toJson(response.getQrResponse()));
            if (response.getQrResponse() != null) {
                this.dataSendQR = this.DEEP_LINK_URL + String.format("id_transaccion=%s&importe=%s&moneda=%s&numero_proveedor=%s", response.getQrResponse().getId_transaccion(), String.valueOf(response.getQrResponse().getImporte()), response.getQrResponse().getMoneda(), response.getQrResponse().getNumero_proveedor());
                this.isShareQR = true;
                String data = gson.toJson(response.getQrResponse());
                qrGenerator(data);
                this.idPago = response.getQrResponse().getId_transaccion();
                if (this.isConfiguracionWSActiva) {
                    crearEscucha(response.getQrResponse().getNumero_proveedor());
                    return;
                } else {
                    ChequeoPagoTimer();
                    this.chequear = true;
                    return;
                }
            }
            ShowMessageADialog("Error", "Ha ocurrido un error, intentelo nuevamente.");
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(this);
        } else {
            ShowMessageADialog("Error", mensaje);
        }
    }

    public void share() {
        if (this.isShareQR.booleanValue()) {
            Intent sendIntent = new Intent();
            sendIntent.setAction("android.intent.action.SEND");
            sendIntent.putExtra("android.intent.extra.TEXT", "He compartido con usted desde Transfermóvil un link para la compra en línea: " + this.dataSendQR + " ");
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
            return;
        }
        Toast.makeText(this, "QR vacio o incompleto.", 1).show();
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, int code, String mensaje, sR8QMZUZBy response) {
        if (result.booleanValue()) {
            if (!fillCuentas(response.getItemsList())) {
                Toast.makeText(this, "Error cargando las cuentas", 1).show();
            }
        } else if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(this);
        } else {
            Toast.makeText(this, mensaje, 1).show();
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, HLAV6HkYgi.OperTypeCuentas operTypeCuentas, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.qQsnaKw3VY
    public void onChequeoPagoResult(Boolean result, int code, String mensaje, RKxbomWW57 response) {
        try {
            Log.i(this.HEAD_LOG, "onChequeoPagoResult:RESULT:" + result + "CODE: " + code + "MENSAJE:" + mensaje + " ISOK: " + response.isOk() + "DETALLE: " + response.getDetalles() + " ESTADO:" + response.getEstado().name());
        } catch (Exception e) {
            Log.i(this.HEAD_LOG, "onChequeoPagoResult:");
        }
        if (result.booleanValue()) {
            if (response.getEstado() == SHYgXB9Dco.PAGADO || response.getEstado() == SHYgXB9Dco.CANCELADO) {
                try {
                    Dialog dialog = this.settingsDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                } catch (Exception e2) {
                }
                this.chequear = false;
                this.contador = 0;
                mostrarPago(response);
                return;
            }
            if (!this.isConfiguracionWSActiva) {
                if (this.contador == MAX_CONTADOR) {
                    this.chequear = false;
                    Log.i(this.HEAD_LOG, "onChequeoPagoResult: Contador detenido");
                    return;
                }
                return;
            }
            Toast.makeText(getApplicationContext(), "PENDIENTE", 1).show();
            return;
        }
        this.chequear = false;
        Log.i(this.HEAD_LOG, "onChequeoPagoResult: Contador detenido con result false");
    }

    private void mostrarPago(RKxbomWW57 datos) {
        try {
            Z5fUajldziN dialogFrag = Z5fUajldziN.newInstance(datos);
            if (dialogFrag.getDialog() != null) {
                dialogFrag.getDialog().setCanceledOnTouchOutside(true);
            }
            dialogFrag.setCancelable(false);
            dialogFrag.show(getSupportFragmentManager(), "fragment_PAGO");
        } catch (Exception e) {
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResult(Boolean result, int code, String mensaje, PYjuxvJ5mg response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResultDevolucion(Boolean result, int code, String mensaje, qztlzqkyWH response) {
        if (result.booleanValue()) {
            if (response.isOK()) {
                String mdev = getString(R.string.msg_dev_procesada) + response.getRefund();
                ShowMessageADialog(getString(R.string.head_notificacion), mdev);
                return;
            }
            ShowMessageADialog(getString(R.string.head_notificacion), response.getMenssage());
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(this);
        }
        ShowMessageADialog(getString(R.string.head_notificacion), response.getMenssage());
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onResultTags(Boolean result, int code, String mensaje, p0XuqX2hWag response) {
        if (result.booleanValue()) {
            if (response.isOK()) {
                if (response.getHashtag().length > 0) {
                    this.hasHashtags = true;
                    List<String> list = new ArrayList<>();
                    list.addAll(Arrays.asList(response.getHashtag()));
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list);
                    this.edDescripcion.setAdapter(adapter);
                    this.edDescripcion.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.4
                        @Override // android.view.View.OnFocusChangeListener
                        public void onFocusChange(View view, boolean hasFocus) {
                            if (hasFocus) {
                                H9l22AIYKkA.this.edDescripcion.showDropDown();
                            }
                        }
                    });
                    UhA7J2923N.getInstance();
                    if (UhA7J2923N.getHashtagDefault() != null) {
                        UhA7J2923N.getInstance();
                        if (UhA7J2923N.getHashtagDefault().length() > 0) {
                            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.edDescripcion;
                            UhA7J2923N.getInstance();
                            materialAutoCompleteTextView.setText(UhA7J2923N.getHashtagDefault());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.hasHashtags = false;
                return;
            }
            this.hasHashtags = false;
            ShowMessageADialog(getString(R.string.head_notificacion), response.getMenssage());
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(this);
        }
        ShowMessageADialog(getString(R.string.head_notificacion), response.getMenssage());
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.qQsnaKw3VY, cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(final int visibility) {
        runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.5
            @Override // java.lang.Runnable
            public void run() {
                H9l22AIYKkA.this.pBar.setVisibility(visibility);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(5);
        }
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.6
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(H9l22AIYKkA.this).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    public void ChequeoPagoTimer() {
        final Handler handler = new Handler();
        TimerTask timertask = new TimerTask() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                handler.post(new Runnable() { // from class: cu.etecsa.tm.ecommerce.H9l22AIYKkA.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            H9l22AIYKkA.this.checkEstado();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(timertask, 0L, 10000L);
    }

    public void checkEstado() {
        try {
            if (this.chequear) {
                if (isOnline()) {
                    this.contador++;
                    this.pagoPresenter.checkPago(this.idPago);
                } else {
                    this.timer.cancel();
                    this.timer.purge();
                    this.timer = null;
                }
            }
        } catch (Exception e) {
            this.timer.cancel();
            this.timer.purge();
            this.timer = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.V9CpxZJfIeK
    public void mostrarDevolucion(RKxbomWW57 data) {
        isiTmFZ2lx dialogFrag = isiTmFZ2lx.newInstance(data);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setCancelable(false);
        dialogFrag.show(getSupportFragmentManager(), "fragment_devolver_PAGO");
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.V9CpxZJfIeK
    public void ejecutarDevolucion(FhtwnBtOAx data) {
        this.devPresenter.devolverPago(data);
    }

    public void crearEscucha(String source) {
        emitSend("joinRoom", source);
        listenEmit("msgFromServer");
    }

    public void emitSend(String command, String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        this.mSocket.emit(command, message);
    }

    public void listenEmit(String CommmandEvent) {
        this.mSocket.on(CommmandEvent, this.onNewMessage);
        this.mSocket.connect();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x00ac  */
    public void leerMensaje(JSONObject msg) {
        RKxbomWW57 pago;
        new Gson();
        try {
            zMnpbxBIN5 traza = (zMnpbxBIN5) new GsonBuilder().setPrettyPrinting().create().fromJson(msg.toString(), zMnpbxBIN5.class);
            pago = new RKxbomWW57();
            if (this.idPago.contains(traza.getPayment_code())) {
                pago.setDescripcion(traza.getDescription());
                pago.setDetalles(traza.getResult_msg());
                pago.setExternalCode(traza.getPayment_code());
                pago.setFecha(traza.getCreated_at());
                pago.setIdBanco(traza.getBanck_code());
                pago.setIdTercero(traza.getPayment_code());
                pago.setIdTM(traza.getTm_code());
                pago.setImoprte(String.valueOf(traza.getAmount()));
                pago.setImporte(traza.getAmount());
                byte b = 1;
                pago.setOk(true);
                pago.setSource(traza.getSource());
                pago.setUsuario(traza.getCreate_user());
                switch (traza.getBanck()) {
                    case 1:
                        pago.setBanco(wnGiwuD0kT.BPA);
                        break;
                    case 2:
                        pago.setBanco(wnGiwuD0kT.BANDEC);
                        break;
                    case 3:
                        pago.setBanco(wnGiwuD0kT.METRO);
                        break;
                }
                String status = traza.getStatus();
                switch (status.hashCode()) {
                    case -1194777649:
                        b = !status.equals("aborted") ? (byte) -1 : (byte) 2;
                        break;
                    case -804109473:
                        if (!status.equals("confirmed")) {
                        }
                        break;
                    case -682587753:
                        if (status.equals("pending")) {
                            b = 0;
                        }
                        break;
                    default:
                        break;
                }
                switch (b) {
                    case 0:
                        pago.setEstado(SHYgXB9Dco.PENDIENTE);
                        break;
                    case 1:
                        pago.setEstado(SHYgXB9Dco.PAGADO);
                        break;
                    case 2:
                        pago.setEstado(SHYgXB9Dco.CANCELADO);
                        break;
                    default:
                        pago.setEstado(SHYgXB9Dco.NO_DEFINIDO);
                        break;
                }
            } else {
                pago = null;
            }
        } catch (Exception ex) {
            Log.e("CHAT", "Error desearizando" + ex.getMessage());
            pago = null;
        }
        if (pago == null) {
            Log.e("CHAT", "Error obteniendo el pago");
            return;
        }
        if (pago.getEstado() == SHYgXB9Dco.PAGADO || pago.getEstado() == SHYgXB9Dco.CANCELADO) {
            try {
                Dialog dialog = this.settingsDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
            }
            mostrarPago(pago);
        }
    }
}
