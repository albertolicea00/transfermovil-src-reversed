package cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class mB0ZJmAKFb {
    public Activity activity;
    public final OkHttpClient client;
    public Context context;
    private Socket mSocket;
    private Emitter.Listener onNewMessage;

    public mB0ZJmAKFb(Context c, Activity a) {
        OkHttpClient unsafeOkHttpClient = getUnsafeOkHttpClient();
        this.client = unsafeOkHttpClient;
        IO.setDefaultOkHttpWebSocketFactory(unsafeOkHttpClient);
        IO.setDefaultOkHttpCallFactory(unsafeOkHttpClient);
        IO.Options otps = new IO.Options();
        otps.transports = new String[]{"websocket"};
        try {
            this.mSocket = IO.socket("https://mitransfer-notification.tur.cu", otps);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.onNewMessage = new Emitter.Listener() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb.2
            @Override // io.socket.emitter.Emitter.Listener
            public void call(final Object... args) {
                mB0ZJmAKFb.this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String informacion = args[0].toString();
                        Log.i("CHAT", informacion);
                        try {
                            JSONObject data = (JSONObject) args[0];
                            try {
                                data.getString("username");
                                data.getString("message");
                            } catch (JSONException e2) {
                            }
                        } catch (Exception e3) {
                        }
                    }
                });
            }
        };
        this.context = c;
        this.activity = a;
    }

    private static HostnameVerifier getLiverfHostnameVerifier() {
        return new HostnameVerifier() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    public void init() {
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

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb.3
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.q1iolDit9Fi.mB0ZJmAKFb.4
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
