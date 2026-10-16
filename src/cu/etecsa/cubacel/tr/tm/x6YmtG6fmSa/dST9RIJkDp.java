package cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa;

import android.content.Context;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class dST9RIJkDp {
    public static Context context;
    private static final dST9RIJkDp ourInstance = new dST9RIJkDp();
    public String urlBase = BuildConfig.FLAVOR;
    public final OkHttpClient client = new OkHttpClient();

    public static dST9RIJkDp getInstance() {
        return ourInstance;
    }

    public static dST9RIJkDp getInstance(Context pContext) {
        context = pContext;
        return ourInstance;
    }

    public Q9fJ7WbVwMB processGET(String urlParam) {
        try {
            Q9fJ7WbVwMB apiResponseBase = new Q9fJ7WbVwMB();
            Request request = new Request.Builder().url(this.urlBase + urlParam).addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").addHeader("cache-control", "no-cache").build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e("NETMANAGER", ex.getMessage());
            return null;
        }
    }

    private Q9fJ7WbVwMB getApiResponseBase(final Q9fJ7WbVwMB apiResponseBase, Request request) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.client.newCall(request).enqueue(new Callback() { // from class: cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.dST9RIJkDp.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                apiResponseBase.setError(true);
                apiResponseBase.setMenssaje(e.getMessage());
                countDownLatch.countDown();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                JSONObject jsonObject;
                if (!response.isSuccessful()) {
                    apiResponseBase.setError(true);
                    int code = response.networkResponse().code();
                    String message = response.networkResponse().message();
                    apiResponseBase.setHttpCode(code);
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        Log.i("e", jsonObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jsonObject = null;
                    }
                    apiResponseBase.setJsonObject(jsonObject);
                    apiResponseBase.setMenssaje(message);
                    countDownLatch.countDown();
                    return;
                }
                try {
                    int code2 = response.networkResponse().code();
                    String message2 = response.networkResponse().message();
                    try {
                        apiResponseBase.setJsonObject(new JSONObject(response.body().string()));
                    } catch (Exception e2) {
                        apiResponseBase.setJsonObject(null);
                    }
                    apiResponseBase.setHttpCode(code2);
                    apiResponseBase.setMenssaje(message2);
                    apiResponseBase.setError(false);
                    countDownLatch.countDown();
                } catch (Exception e3) {
                    e3.printStackTrace();
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
}
