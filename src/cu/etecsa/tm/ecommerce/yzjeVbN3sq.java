package cu.etecsa.tm.ecommerce;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class yzjeVbN3sq extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 0;
    private static final int TYPING_TIMER_LENGTH = 600;
    public Activity activity;
    private Socket mSocket;
    private String mUsername;
    private boolean mTyping = false;
    private Handler mTypingHandler = new Handler();
    private Boolean isConnected = false;
    private Emitter.Listener onConnect = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.1
        @Override // io.socket.emitter.Emitter.Listener
        public void call(Object... args) {
            yzjeVbN3sq.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!yzjeVbN3sq.this.isConnected.booleanValue()) {
                        if (yzjeVbN3sq.this.mUsername != null) {
                            yzjeVbN3sq.this.mSocket.emit("add user", yzjeVbN3sq.this.mUsername);
                        }
                        Toast.makeText(yzjeVbN3sq.this.activity.getApplicationContext(), "Conectado", 1).show();
                        yzjeVbN3sq.this.isConnected = true;
                    }
                }
            });
        }
    };
    private Emitter.Listener onDisconnect = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.2
        @Override // io.socket.emitter.Emitter.Listener
        public void call(Object... args) {
            yzjeVbN3sq.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.2.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("CHAT", "diconnected");
                    yzjeVbN3sq.this.isConnected = false;
                    Toast.makeText(yzjeVbN3sq.this.activity.getApplicationContext(), "DESCONECTADO", 1).show();
                }
            });
        }
    };
    private Emitter.Listener onConnectError = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.3
        @Override // io.socket.emitter.Emitter.Listener
        public void call(final Object... args) {
            yzjeVbN3sq.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.3.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("CHAT", "Error connecting");
                    Log.e("CHAT", args[0].toString());
                    Toast.makeText(yzjeVbN3sq.this.activity.getApplicationContext(), "CONNECT ERROR", 1).show();
                }
            });
        }
    };
    private Emitter.Listener onNewMessage = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.4
        @Override // io.socket.emitter.Emitter.Listener
        public void call(final Object... args) {
            yzjeVbN3sq.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.4.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("CHAT", args[0].toString());
                    try {
                    } catch (Exception e) {
                    }
                }
            });
        }
    };
    private Emitter.Listener onNewMessageChat = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.5
        @Override // io.socket.emitter.Emitter.Listener
        public void call(final Object... args) {
            yzjeVbN3sq.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.yzjeVbN3sq.5.1
                @Override // java.lang.Runnable
                public void run() {
                    String informacion = args[0].toString();
                    Log.i("CHAT", informacion);
                    try {
                        JSONObject data = (JSONObject) args[0];
                        try {
                            data.getString("username");
                            data.getString("message");
                        } catch (JSONException e) {
                        }
                    } catch (Exception e2) {
                    }
                }
            });
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veblxjkv51ke6);
        mB0ZJmAKFb wsBulevar = new mB0ZJmAKFb(getApplicationContext(), this);
        this.activity = this;
        Socket socket = wsBulevar.getSocket();
        this.mSocket = socket;
        socket.on("connect", this.onConnect);
        this.mSocket.on("disconnect", this.onDisconnect);
        this.mSocket.on("connect_error", this.onConnectError);
        this.mSocket.connect();
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
}
