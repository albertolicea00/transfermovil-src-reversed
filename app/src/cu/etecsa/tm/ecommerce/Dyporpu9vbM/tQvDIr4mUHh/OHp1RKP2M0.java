package cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh;

import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OHp1RKP2M0 {
    public OkHttpClient client;

    public zDPt4FP8OC getCSRFCookie() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieJar() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.OHp1RKP2M0.1
            public final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookieStore.put(url.host(), cookies);
                for (Cookie item : cookies) {
                    Log.i("CSRF NAME", item.name());
                    Log.i("CSRF VALUE", item.value());
                    Log.i("CSRF TOSTRING", item.toString());
                    if (item.name().contains("XSRF-TOKEN")) {
                        String cadena = item.value().replace("%3D", BuildConfig.FLAVOR);
                        Log.i("CSRF cadena", cadena);
                        UhA7J2923N.getInstance().setCsrf_token(cadena);
                    }
                }
            }

            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = this.cookieStore.get(url.host());
                return cookies != null ? cookies : new ArrayList();
            }
        });
        this.client = builder.build();
        zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
        Request request = new Request.Builder().addHeader("Content-Type", "application/json").build();
        zDPt4FP8OC response = getApiResponseBase(apiResponseBase, request);
        return response;
    }

    public zDPt4FP8OC setTokenCSRFaHand() {
        UhA7J2923N.getInstance().setCsrf_token("eyJpdiI6IncxanhUcytEODZDNDhhMmRVbnVJbmc9PSIsInZhbHVlIjoiMlFaSkRXUHRxZ0QzdkM4RkVQaVF6Nk5wWTczUmd4a09ucWNmQmROSSsvTU82Zjc4cTVGQkFLWFhKanBlTFJFRjVGZU9lQ1llSWRGeWVmSXZjbTNTdUxuZTBKVk9Md0ZndHJvR1ZoQitjNUYrQ1hBdUZLWXpmcCszcnBVMWE3SloiLCJtYWMiOiI4YWNjODJmZTIwYjc5OGFkNTNjNGJlMTU4YTM2ZTVmNTU2ZDI4OThlMWIwYjdjOGFkMWM2NDAzYzM0ZjZkNmIxIn0");
        zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
        apiResponseBase.setCodigoHTTP(200);
        apiResponseBase.setMenssaje("a");
        apiResponseBase.setError(false);
        return apiResponseBase;
    }

    private zDPt4FP8OC getApiResponseBase(final zDPt4FP8OC apiResponseBase, Request request) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.client.newCall(request).enqueue(new Callback() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.OHp1RKP2M0.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                apiResponseBase.setError(true);
                apiResponseBase.setMenssaje(e.getMessage());
                countDownLatch.countDown();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    apiResponseBase.setError(true);
                    int code = response.networkResponse().code();
                    String message = response.networkResponse().message();
                    apiResponseBase.setCodigoHTTP(code);
                    apiResponseBase.setMenssaje(message);
                    countDownLatch.countDown();
                    return;
                }
                try {
                    int code2 = response.networkResponse().code();
                    String message2 = response.networkResponse().message();
                    apiResponseBase.setCodigoHTTP(code2);
                    apiResponseBase.setMenssaje(message2);
                    apiResponseBase.setError(false);
                    List<String> Cookielist = response.headers().values("Set-Cookie");
                    String str = Cookielist.get(0).split(";")[0];
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return apiResponseBase;
    }

    private void sendGETSync(Request request) throws IOException {
        Response response = this.client.newCall(request).execute();
        try {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            System.out.println(response.body().string());
            response.close();
        } catch (Throwable th) {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
