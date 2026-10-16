package cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.gson.Gson;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.XpLbwNXtZPa.fGYt3sYXbt;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y6NQQxH0NI {
    public static Context context;
    private static final y6NQQxH0NI ourInstance = new y6NQQxH0NI();
    public String apiBase;
    public String MESSAGE_LOG = "APIManagement";
    public final OkHttpClient client = getUnsafeOkHttpClient();
    public MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    public static y6NQQxH0NI getInstance() {
        return ourInstance;
    }

    public static y6NQQxH0NI getInstance(Context pContext) {
        context = pContext;
        return ourInstance;
    }

    private y6NQQxH0NI() {
        this.apiBase = BuildConfig.FLAVOR;
        this.apiBase = UhA7J2923N.getInstance().getApiURL();
    }

    public zDPt4FP8OC processPOST(String operacionAPI, fGYt3sYXbt requestParams) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            Gson gson = new Gson();
            String dataJSON = gson.toJson(requestParams);
            RequestBody body = RequestBody.create(this.mediaType, dataJSON);
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("Accept-Charset", "application/json").addHeader("Content-Type", "application/json").build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPOST(String operacionAPI, String tokenCSRF, fGYt3sYXbt requestParams) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            Gson gson = new Gson();
            String dataJSON = gson.toJson(requestParams);
            RequestBody body = RequestBody.create(this.mediaType, dataJSON);
            String csrf = "xxx";
            if (UhA7J2923N.getInstance().getCsrf_token() != null && UhA7J2923N.getInstance().getCsrf_token().length() > 0) {
                csrf = UhA7J2923N.getInstance().getCsrf_token();
            }
            Log.i("y6NQQxH0NI-CSRF", csrf);
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("Content-Type", "application/json").addHeader("X-XSRF-TOKEN", csrf).build();
            return getApiResponseCokkieBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPOST(String operacionAPI, fGYt3sYXbt requestParams, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            Gson gson = new Gson();
            String dataJSON = gson.toJson(requestParams);
            RequestBody body = RequestBody.create(this.mediaType, dataJSON);
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("Content-Type", "application/json").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPOST(String operacionAPI, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            new Gson();
            RequestBody body = RequestBody.create((MediaType) null, new byte[0]);
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("Content-Type", "application/json").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPUT(String operacionAPI, fGYt3sYXbt requestParams, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            Gson gson = new Gson();
            String dataJSON = gson.toJson(requestParams);
            RequestBody body = RequestBody.create(this.mediaType, dataJSON);
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).put(body).addHeader("Content-Type", ",ultipart").addHeader("cache-control", "no-cache").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPUTImage(String operacionAPI, String sourceImageFile, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            File sourceFileOriginal = new File(sourceImageFile);
            File sourceFile = reduceFileImage(sourceFileOriginal);
            MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
            String filename = sourceImageFile.substring(sourceImageFile.lastIndexOf("/") + 1);
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("image", filename, RequestBody.create(MEDIA_TYPE_PNG, sourceFile)).addFormDataPart("_method", "PUT").build();
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPUTImage(String operacionAPI, String columnNameImage, String sourceImageFile, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            File sourceFileOriginal = new File(sourceImageFile);
            File sourceFile = reduceFileImage(sourceFileOriginal);
            MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
            String filename = sourceImageFile.substring(sourceImageFile.lastIndexOf("/") + 1);
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(columnNameImage, filename, RequestBody.create(MEDIA_TYPE_PNG, sourceFile)).addFormDataPart("_method", "PUT").build();
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processPOSTImage(String operacionAPI, String sourceImageFile, String from, String to, String message, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            File sourceFileOriginal = new File(sourceImageFile);
            File sourceFile = reduceFileImage(sourceFileOriginal);
            MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
            String filename = sourceImageFile.substring(sourceImageFile.lastIndexOf("/") + 1);
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("image", filename, RequestBody.create(MEDIA_TYPE_PNG, sourceFile)).addFormDataPart("_method", "POST").addFormDataPart("from", from).addFormDataPart("to", to).addFormDataPart("message", message).build();
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).post(body).addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    public zDPt4FP8OC processGET(String operacionAPI, String key) {
        try {
            zDPt4FP8OC apiResponseBase = new zDPt4FP8OC();
            Request request = new Request.Builder().url(this.apiBase + operacionAPI).addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW").addHeader("Accept", "application/json").addHeader("Content-Type", "application/json").addHeader("cache-control", "no-cache").addHeader("Authorization", key).build();
            return getApiResponseBase(apiResponseBase, request);
        } catch (Exception ex) {
            Log.e(this.MESSAGE_LOG, ex.getMessage());
            return null;
        }
    }

    private zDPt4FP8OC getApiResponseBase(final zDPt4FP8OC apiResponseBase, Request request) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.client.newCall(request).enqueue(new Callback() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Log.e(y6NQQxH0NI.this.MESSAGE_LOG, e.getMessage());
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
                    Log.i("ApiManager", String.valueOf(code));
                    String message = response.networkResponse().message() != null ? response.networkResponse().message() : "error";
                    apiResponseBase.setCodigoHTTP(code);
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        Log.i("ApiManager", jsonObject.toString());
                    } catch (JSONException e) {
                        Log.i("ApiManager", e.getMessage());
                        jsonObject = null;
                    } catch (Exception ex) {
                        Log.i("ApiManager", ex.getMessage());
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
                        Log.i("y6NQQxH0NI", response.body().toString());
                    } catch (Exception e2) {
                        apiResponseBase.setJsonObject(null);
                    }
                    apiResponseBase.setCodigoHTTP(code2);
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
            Log.e(this.MESSAGE_LOG, e.getMessage());
        }
        return apiResponseBase;
    }

    private zDPt4FP8OC getApiResponseCokkieBase(final zDPt4FP8OC apiResponseBase, Request request) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.client.newCall(request).enqueue(new Callback() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Log.e(y6NQQxH0NI.this.MESSAGE_LOG, e.getMessage());
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
                    Log.i("ApiManager", String.valueOf(code));
                    String message = response.networkResponse().message() != null ? response.networkResponse().message() : "error";
                    apiResponseBase.setCodigoHTTP(code);
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        Log.i("ApiManager", jsonObject.toString());
                    } catch (JSONException e) {
                        Log.i("ApiManager", e.getMessage());
                        jsonObject = null;
                    } catch (Exception ex) {
                        Log.i("ApiManager", ex.getMessage());
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
                    List<String> Cookielist = response.headers().values("Set-Cookie");
                    String jsessionid = Cookielist.get(0).split(";")[0];
                    if (jsessionid.contains("XSRF-TOKEN")) {
                        String cadena = jsessionid.replace("%3D", BuildConfig.FLAVOR);
                        Log.i("CSRF cadena", cadena);
                        UhA7J2923N.getInstance().setCsrf_token(cadena);
                    }
                    apiResponseBase.setCodigoHTTP(code2);
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
            Log.e(this.MESSAGE_LOG, e.getMessage());
        }
        return apiResponseBase;
    }

    public File reduceFileImage(File mFile) {
        String filePath = mFile.getPath();
        mFile.getPath().replace(mFile.getName(), BuildConfig.FLAVOR);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        int imHeight = options.outHeight;
        int imWith = options.outWidth;
        String str = options.outMimeType;
        Bitmap reduceBitmap = correcionCOnGlinde(Uri.fromFile(new File(filePath)), imWith / 2, imHeight / 2);
        File fileNew = new File(context.getFilesDir().getAbsolutePath(), "newthub.jpg");
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(fileNew));
            reduceBitmap.compress(Bitmap.CompressFormat.JPEG, 50, os);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileNew;
    }

    public String convertImageToSend(String sourceImageFile) {
        File sourceFileOriginal = new File(sourceImageFile);
        String dataFoto = reduceBase64ImageBitmap(sourceFileOriginal);
        return dataFoto;
    }

    public String reduceBase64ImageBitmap(File mFile) {
        String filePath = mFile.getPath();
        mFile.getPath().replace(mFile.getName(), BuildConfig.FLAVOR);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        int imHeight = options.outHeight;
        int imWith = options.outWidth;
        String str = options.outMimeType;
        Bitmap reduceBitmap = correcionCOnGlinde(Uri.fromFile(new File(filePath)), imWith / 2, imHeight / 2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        reduceBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String encoded = "data:image/png;base64," + Base64.encodeToString(byteArray, 2);
        return encoded;
    }

    public Bitmap normalizeImageForUri(Context context2, Uri uri) {
        try {
            ExifInterface exif = new ExifInterface(uri.getPath());
            int orientation = exif.getAttributeInt("Orientation", 0);
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context2.getContentResolver(), uri);
            Bitmap rotatedBitmap = rotateBitmap(bitmap, orientation);
            return rotatedBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bitmap rotateBitmap(Bitmap bitmap, int orientation) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case 1:
                return bitmap;
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveBitmapToFile(Context context2, Bitmap croppedImage, Uri saveUri) {
        if (saveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = context2.getContentResolver().openOutputStream(saveUri);
                if (outputStream != null) {
                    croppedImage.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException e) {
            } finally {
                closeSilently(outputStream);
                croppedImage.recycle();
            }
        }
    }

    private static void closeSilently(Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bitmap correcionCOnGlinde(Uri uri, int with, int heigh) {
        try {
            Bitmap bitmap = (Bitmap) Glide.with(context).asBitmap().load(uri).override(with, heigh).submit().get();
            return bitmap;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.3
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context2 = SSLContext.getInstance("TLS");
            context2.init(null, new X509TrustManager[]{new X509TrustManager() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.4
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
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context2.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.5
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
            builder.hostnameVerifier(new HostnameVerifier() { // from class: cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh.y6NQQxH0NI.6
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
