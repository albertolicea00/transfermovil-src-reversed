package cu.etecsa.transfermovil.ecommerce;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI
 * @fingerprint Singleton, getUnsafeOkHttpClient(), CountDownLatch sync, trustEveryone()
 *
 * E-commerce REST API client. Singleton that wraps OkHttp for all Bulevar
 * marketplace requests. Supports POST (JSON + multipart image), PUT, GET.
 *
 * SECURITY CRITICAL: Uses getUnsafeOkHttpClient() which:
 *   - Trusts ALL certificates (empty X509TrustManager)
 *   - Disables hostname verification (returns true for all)
 *   - Uses SSLContext("SSL") instead of "TLS"
 *   This makes the entire e-commerce module vulnerable to MITM attacks.
 *   Also has trustEveryone() that sets the GLOBAL default HostnameVerifier
 *   and SSLSocketFactory to trust-all, affecting the entire JVM.
 *
 * Request flow:
 *   1. Base URL from SessionManager.getApiUrl() (dynamic, set at login)
 *   2. Serialize request body via Gson
 *   3. Enqueue async OkHttp call
 *   4. Block calling thread with CountDownLatch.await() (async→sync bridge)
 *   5. Parse JSON response into ApiResponse wrapper
 *
 * Auth headers:
 *   - "Authorization": Bearer token for authenticated requests
 *   - "X-XSRF-TOKEN": CSRF token extracted from Set-Cookie response header
 *
 * Cookie/CSRF flow: getApiResponseWithCookie() extracts XSRF-TOKEN from
 * Set-Cookie header, strips URL encoding ("%3D" → ""), and saves to SessionManager.
 */
public class ApiClient {

    private static final String LOG_TAG = "APIManagement";
    private static final ApiClient INSTANCE = new ApiClient();
    private static Context context;

    private final OkHttpClient client;
    private final MediaType jsonMediaType;
    private String baseUrl;

    private ApiClient() {
        this.client = createUnsafeOkHttpClient();
        this.jsonMediaType = MediaType.parse("application/json; charset=utf-8");
        this.baseUrl = SessionManager.getInstance() != null
                ? SessionManager.getInstance().getApiUrl() : "";
    }

    public static ApiClient getInstance() {
        return INSTANCE;
    }

    public static ApiClient getInstance(Context ctx) {
        context = ctx;
        return INSTANCE;
    }

    // --- HTTP methods ---

    /** POST with JSON body, no auth. Used for login. */
    public ApiResponse post(String endpoint, Object requestParams) {
        try {
            String json = new Gson().toJson(requestParams);
            RequestBody body = RequestBody.create(jsonMediaType, json);
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .post(body)
                    .addHeader("Accept-Charset", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build();
            return executeSync(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    /** POST with CSRF token. Extracts XSRF-TOKEN from Set-Cookie in response. */
    public ApiResponse postWithCsrf(String endpoint, Object requestParams) {
        try {
            String json = new Gson().toJson(requestParams);
            RequestBody body = RequestBody.create(jsonMediaType, json);
            String csrf = SessionManager.getInstance().getCsrfToken();
            if (csrf == null || csrf.isEmpty()) csrf = "xxx";
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-XSRF-TOKEN", csrf)
                    .build();
            return executeSyncWithCookie(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    /** POST with Bearer auth token. */
    public ApiResponse postAuthenticated(String endpoint, Object requestParams, String bearerToken) {
        try {
            String json = new Gson().toJson(requestParams);
            RequestBody body = RequestBody.create(jsonMediaType, json);
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", bearerToken)
                    .build();
            return executeSync(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    /** POST empty body with Bearer auth. */
    public ApiResponse postEmpty(String endpoint, String bearerToken) {
        try {
            RequestBody body = RequestBody.create(null, new byte[0]);
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", bearerToken)
                    .build();
            return executeSync(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    /** PUT with JSON body and Bearer auth. */
    public ApiResponse put(String endpoint, Object requestParams, String bearerToken) {
        try {
            String json = new Gson().toJson(requestParams);
            RequestBody body = RequestBody.create(jsonMediaType, json);
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .put(body)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("Authorization", bearerToken)
                    .build();
            return executeSync(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    /** GET with Bearer auth. */
    public ApiResponse get(String endpoint, String bearerToken) {
        try {
            Request request = new Request.Builder()
                    .url(baseUrl + endpoint)
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("Authorization", bearerToken)
                    .build();
            return executeSync(request);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    // --- Sync execution (async→sync bridge via CountDownLatch) ---

    private ApiResponse executeSync(Request request) {
        ApiResponse response = new ApiResponse();
        CountDownLatch latch = new CountDownLatch(1);
        client.newCall(request).enqueue(new ResponseCallback(response, latch, false));
        try { latch.await(); } catch (InterruptedException e) { Log.e(LOG_TAG, e.getMessage()); }
        return response;
    }

    private ApiResponse executeSyncWithCookie(Request request) {
        ApiResponse response = new ApiResponse();
        CountDownLatch latch = new CountDownLatch(1);
        client.newCall(request).enqueue(new ResponseCallback(response, latch, true));
        try { latch.await(); } catch (InterruptedException e) { Log.e(LOG_TAG, e.getMessage()); }
        return response;
    }

    // --- TLS bypass (CRITICAL VULNERABILITY) ---

    /**
     * Creates OkHttpClient that trusts ALL certificates and all hostnames.
     * Completely disables TLS verification — vulnerable to any MITM attack.
     */
    private static OkHttpClient createUnsafeOkHttpClient() {
        try {
            X509TrustManager trustAll = new X509TrustManager() {
                @Override public void checkClientTrusted(X509Certificate[] c, String a) {}
                @Override public void checkServerTrusted(X509Certificate[] c, String a) {}
                @Override public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            };

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{trustAll}, new SecureRandom());
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            return new OkHttpClient.Builder()
                    .sslSocketFactory(socketFactory, trustAll)
                    .hostnameVerifier((hostname, session) -> true)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets JVM-wide default HTTPS to trust all certs and hostnames.
     * Even worse than getUnsafeOkHttpClient — affects ALL HttpsURLConnection.
     */
    public static void trustEveryone() {
        try {
            X509TrustManager trustAll = new X509TrustManager() {
                @Override public void checkClientTrusted(X509Certificate[] c, String a) {}
                @Override public void checkServerTrusted(X509Certificate[] c, String a) {}
                @Override public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
            };
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, new TrustManager[]{trustAll}, new SecureRandom());
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((h, s) -> true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- Inner classes ---

    /** Minimal API response wrapper. */
    public static class ApiResponse {
        private boolean error;
        private int httpCode;
        private String message;
        private JSONObject jsonObject;

        public boolean isError() { return error; }
        public void setError(boolean error) { this.error = error; }
        public int getHttpCode() { return httpCode; }
        public void setHttpCode(int code) { this.httpCode = code; }
        public String getMessage() { return message; }
        public void setMessage(String msg) { this.message = msg; }
        public JSONObject getJsonObject() { return jsonObject; }
        public void setJsonObject(JSONObject obj) { this.jsonObject = obj; }
    }

    /** OkHttp async callback that fills ApiResponse and counts down latch. */
    private static class ResponseCallback implements Callback {
        private final ApiResponse response;
        private final CountDownLatch latch;
        private final boolean extractCookie;

        ResponseCallback(ApiResponse response, CountDownLatch latch, boolean extractCookie) {
            this.response = response;
            this.latch = latch;
            this.extractCookie = extractCookie;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            response.setError(true);
            response.setMessage(e.getMessage());
            latch.countDown();
        }

        @Override
        public void onResponse(Call call, Response resp) throws IOException {
            try {
                int code = resp.networkResponse().code();
                String message = resp.networkResponse().message();
                response.setHttpCode(code);
                response.setMessage(message != null ? message : "error");

                try {
                    response.setJsonObject(new JSONObject(resp.body().string()));
                } catch (Exception e) {
                    response.setJsonObject(null);
                }

                response.setError(!resp.isSuccessful());

                if (extractCookie && resp.isSuccessful()) {
                    List<String> cookies = resp.headers().values("Set-Cookie");
                    if (!cookies.isEmpty()) {
                        String cookie = cookies.get(0).split(";")[0];
                        if (cookie.contains("XSRF-TOKEN")) {
                            String token = cookie.replace("%3D", "");
                            SessionManager.getInstance().setCsrfToken(token);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
