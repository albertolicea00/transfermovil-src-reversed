package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.V7zVJ66kDf;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.ho8G382dwNt.fHZ2PXN4o9;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.xNWgXsOsGx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class HEi1mzxf5v {
    private static final int CHUNK_SIZE = 8192;
    private static final int REQUEST_CODE_STORAGE_PERMISSION = 1021;
    private static final String TAG = "HEi1mzxf5v";
    private final AtomicBoolean isExporting = new AtomicBoolean(false);
    private ExportProgressListener progressListener;

    public interface ExportProgressListener {
        void onErrorOccurred(String str, int i);

        void onExportComplete(boolean z, String str);

        void onProgressUpdate(int i, String str);
    }

    public void setProgressListener(ExportProgressListener listener) {
        this.progressListener = listener;
    }

    public FqBpCTmUog exportData(Context context, Intent resultData) {
        if (this.isExporting.get()) {
            return createErrorResponse("Ya hay una exportación en progreso", -2);
        }
        this.isExporting.set(true);
        FqBpCTmUog response = new FqBpCTmUog();
        try {
            if (resultData != null) {
                try {
                    if (resultData.getData() != null) {
                        Uri uri = resultData.getData();
                        notifyProgress(5, "Preparando exportación");
                        verifyWritePermissions(context, uri);
                        notifyProgress(10, "Verificando permisos");
                        xNWgXsOsGx saveData = new xNWgXsOsGx(context);
                        V7zVJ66kDf data = saveData.getDataScheme();
                        notifyProgress(20, "Obteniendo datos");
                        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                        String dataJSON = gson.toJson(data);
                        notifyProgress(30, "Formateando datos");
                        String dataJSON2 = cleanJsonString(dataJSON);
                        notifyProgress(35, "Optimizando datos");
                        fHZ2PXN4o9 enjoyData = new fHZ2PXN4o9();
                        String dataJSON3 = enjoyData.convertData(dataJSON2);
                        notifyProgress(40, "Encriptando datos");
                        writeModernVersion(context, uri, dataJSON3);
                        notifyProgress(100, "Exportación completada");
                        response.setSuccess(true);
                        response.setCode(0);
                        response.setMensaje("Exportación completada con éxito");
                        notifyCompletion(true, "Exportación exitosa");
                        this.isExporting.set(false);
                        return response;
                    }
                } catch (Exception e) {
                    response = handleExportError(e);
                }
            }
            throw new IllegalArgumentException("Datos vacíos");
        } catch (Throwable th) {
            this.isExporting.set(false);
            throw th;
        }
    }

    private void writeModernVersion(Context context, Uri uri, String dataJSON) throws IOException {
        Uri tempUri = null;
        if (Build.VERSION.SDK_INT >= 29) {
            tempUri = createTempFile(context);
            writeToUri(context, tempUri, dataJSON, 45, 70);
            notifyProgress(75, "Creando copia temporal");
        }
        writeToUri(context, uri, dataJSON, 75, 95);
        notifyProgress(95, "Guardando archivo final");
        syncDocumentModern(context, uri);
        if (tempUri != null) {
            deleteTempFile(context, tempUri);
        }
    }

    private Uri createTempFile(Context context) throws IOException {
        ContentResolver resolver = context.getContentResolver();
        ContentValues values = new ContentValues();
        String fileName = "temp_export_" + System.currentTimeMillis() + ".tmp";
        values.put("_display_name", fileName);
        values.put("mime_type", "application/octet-stream");
        values.put("relative_path", Environment.DIRECTORY_DOWNLOADS + "/Temp");
        Uri tempUri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values);
        if (tempUri == null) {
            throw new IOException("No se pudo crear archivo temporal");
        }
        return tempUri;
    }

    private void writeToUri(Context context, Uri uri, String data, int startProgress, int endProgress) throws IOException {
        OutputStream os = context.getContentResolver().openOutputStream(uri);
        try {
            if (os == null) {
                throw new IOException("No se pudo abrir el archivo");
            }
            writeInChunks(os, data.getBytes(StandardCharsets.UTF_8), startProgress, endProgress);
            os.close();
        } catch (Throwable th) {
            if (os != null) {
                try {
                    os.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void syncDocumentModern(Context context, Uri uri) {
        try {
            ContentResolver resolver = context.getContentResolver();
            if (DocumentsContract.isDocumentUri(context, uri)) {
                ContentValues values = new ContentValues();
                values.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
                resolver.update(uri, values, null, null);
            }
            OutputStream os = resolver.openOutputStream(uri, "rwt");
            if (os != null) {
                try {
                    os.flush();
                } catch (Throwable th) {
                    try {
                        os.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (os != null) {
                os.close();
            }
        } catch (Exception e) {
            Log.w(TAG, "Sincronización fallida: " + e.getMessage());
        }
    }

    private void writeLegacyVersion(Context context, Uri uri, String dataJSON) throws IOException {
        String filePath = getPathFromUriLegacy(context, uri);
        if (filePath == null) {
            throw new FileNotFoundException("No se pudo obtener ruta del archivo");
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        try {
            writeInChunks(fos, dataJSON.getBytes("UTF-8"), 45, 95);
            syncDocumentLegacy(fos);
            notifyProgress(95, "Guardando archivo final");
            fos.close();
        } catch (Throwable th) {
            try {
                fos.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private String getPathFromUriLegacy(Context context, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        String[] projection = {"_data"};
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int column_index = cursor.getColumnIndexOrThrow("_data");
                    return cursor.getString(column_index);
                }
                return null;
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    private void syncDocumentLegacy(FileOutputStream fos) {
        try {
            fos.getFD().sync();
        } catch (IOException e) {
            Log.w(TAG, "No se pudo sincronizar archivo: " + e.getMessage());
        }
    }

    private void verifyWritePermissions(Context context, Uri uri) throws IOException, SecurityException {
        OutputStream testStream = context.getContentResolver().openOutputStream(uri);
        try {
            if (testStream == null) {
                throw new SecurityException("No se tienen permisos para escribir");
            }
            testStream.write(0);
            testStream.close();
        } catch (Throwable th) {
            if (testStream != null) {
                try {
                    testStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void writeInChunks(OutputStream os, byte[] data, int startProgress, int endProgress) throws IOException {
        int totalChunks = (int) Math.ceil(((double) data.length) / 8192.0d);
        for (int i = 0; i < totalChunks; i++) {
            int start = i * 8192;
            int end = Math.min(start + 8192, data.length);
            os.write(data, start, end - start);
            int progress = (((endProgress - startProgress) * i) / totalChunks) + startProgress;
            notifyProgress(progress, "Escribiendo datos... " + (i + 1) + "/" + totalChunks);
        }
        os.flush();
    }

    private void deleteTempFile(Context context, Uri tempUri) {
        if (tempUri != null) {
            try {
                context.getContentResolver().delete(tempUri, null, null);
            } catch (Exception e) {
                Log.w(TAG, "No se pudo eliminar archivo temporal: " + e.getMessage());
            }
        }
    }

    private String cleanJsonString(String json) {
        return json.replace("\\\"", "\"").replace("\"[", "[").replace("]\"", "]");
    }

    private FqBpCTmUog handleExportError(Exception e) {
        Log.e(TAG, "Error en exportación", e);
        int errorCode = -1;
        String errorMsg = "Error: " + e.getMessage();
        if (e instanceof FileNotFoundException) {
            errorCode = -3;
            errorMsg = "Error: Archivo no encontrado o sin permisos";
        } else if (e instanceof IOException) {
            errorCode = -4;
            errorMsg = "Error de E/S al escribir el archivo";
        } else if (e instanceof SecurityException) {
            errorCode = -5;
            errorMsg = "Error de permisos: " + e.getMessage();
        } else if (e instanceof IllegalArgumentException) {
            errorCode = -6;
        }
        notifyError(errorMsg, errorCode);
        notifyCompletion(false, errorMsg);
        return createErrorResponse(errorMsg, errorCode);
    }

    private FqBpCTmUog createErrorResponse(String message, int code) {
        FqBpCTmUog response = new FqBpCTmUog();
        response.setSuccess(false);
        response.setCode(code);
        response.setMensaje(message);
        return response;
    }

    private void notifyProgress(int progress, String message) {
        ExportProgressListener exportProgressListener = this.progressListener;
        if (exportProgressListener != null) {
            exportProgressListener.onProgressUpdate(progress, message);
            Log.d(TAG, "Progreso: " + progress + "% - " + message);
        }
    }

    private void notifyError(String message, int errorCode) {
        ExportProgressListener exportProgressListener = this.progressListener;
        if (exportProgressListener != null) {
            exportProgressListener.onErrorOccurred(message, errorCode);
        }
    }

    private void notifyCompletion(boolean success, String message) {
        ExportProgressListener exportProgressListener = this.progressListener;
        if (exportProgressListener != null) {
            exportProgressListener.onExportComplete(success, message);
        }
    }

    public static Intent createExportFileIntent(String fileName) {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/json");
        intent.putExtra("android.intent.extra.TITLE", fileName);
        return intent;
    }

    public static boolean hasStoragePermissions(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return Environment.isExternalStorageManager();
        }
        return i < 23 || context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static void requestStoragePermission(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            Intent intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
            activity.startActivity(intent);
        } else if (i >= 23) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, REQUEST_CODE_STORAGE_PERMISSION);
        }
    }
}
