package cu.etecsa.transfermovil.update;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.dST9RIJkDp
 * @fingerprint Singleton OkHttp client for APK update check API. Uses CountDownLatch
 *              to bridge async OkHttp callback to synchronous return. Base URL set at runtime.
 */
public class UpdateApiClient {

    public static Context context;
    private static final UpdateApiClient ourInstance = new UpdateApiClient();
    public String urlBase = "";
    public final OkHttpClient client = new OkHttpClient();

    public static UpdateApiClient getInstance() {
        return ourInstance;
    }

    public static UpdateApiClient getInstance(Context pContext) {
        context = pContext;
        return ourInstance;
    }

    public ApiResponse processGET(String urlParam) {
        try {
            ApiResponse apiResponseBase = new ApiResponse();
            Request request = new Request.Builder()
                    .url(this.urlBase + urlParam)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e("NETMANAGER", ex.getMessage());
            return null;
        }
    }

    private ApiResponse getApiResponseBase(final ApiResponse apiResponseBase, Request request) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                apiResponseBase.setError(true);
                apiResponseBase.setMenssaje(e.getMessage());
                countDownLatch.countDown();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    apiResponseBase.setError(true);
                    int code = response.networkResponse().code();
                    String message = response.networkResponse().message();
                    apiResponseBase.setHttpCode(code);
                    JSONObject jsonObject;
                    try {
                        jsonObject = new JSONObject(response.body().string());
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
                    int code = response.networkResponse().code();
                    String message = response.networkResponse().message();
                    try {
                        apiResponseBase.setJsonObject(new JSONObject(response.body().string()));
                    } catch (Exception e) {
                        apiResponseBase.setJsonObject(null);
                    }
                    apiResponseBase.setHttpCode(code);
                    apiResponseBase.setMenssaje(message);
                    apiResponseBase.setError(false);
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
}
