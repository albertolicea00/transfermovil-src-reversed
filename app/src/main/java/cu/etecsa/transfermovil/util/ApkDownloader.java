package cu.etecsa.transfermovil.util;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import cu.etecsa.cubacel.tr.tm.BuildConfig;
import java.io.File;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UrwqJEz77K
 * @fingerprint Downloads APK via DownloadManager, then triggers install via FileProvider (API 24+)
 *              or direct URI (older). BroadcastReceiver listens for DOWNLOAD_COMPLETE.
 *
 * @security Uses FileProvider with ".provider" authority suffix for APK installs.
 *           Registers dynamic BroadcastReceiver (not exported).
 */
public class ApkDownloader {
    public Context context;
    public String url;
    public String FILE_NAME = "transfermovil_0.apk";
    public String FILE_BASE_PATH = "file://";
    public String MIME_TYPE = "application/vnd.android.package-archive";
    public String PROVIDER_PATH = ".provider";
    public String APP_INSTALL_PATH = "\"application/vnd.android.package-archive\"";

    public ApkDownloader(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    public void enqueueDownload() {
        String destination = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()
                + "/" + FILE_NAME;
        Uri uri = Uri.parse(FILE_BASE_PATH + destination);
        File file = new File(destination);
        if (file.exists()) {
            file.delete();
        }
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        Uri downloadUri = Uri.parse(this.url);
        DownloadManager.Request request = new DownloadManager.Request(downloadUri);
        request.setMimeType(MIME_TYPE);
        request.setTitle("Descarga de Transfermóvil");
        request.setDescription("Descargar aplicación Transfermóvil");
        request.setDestinationUri(uri);
        showInstallOption(destination, uri);
        downloadManager.enqueue(request);
    }

    private void showInstallOption(final String destination, final Uri uri) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (Build.VERSION.SDK_INT >= 24) {
                    Uri contentUri = FileProvider.getUriForFile(
                            context,
                            BuildConfig.APPLICATION_ID + PROVIDER_PATH,
                            new File(destination));
                    Intent install = new Intent("android.intent.action.VIEW");
                    install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    install.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    install.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    install.setData(contentUri);
                    context.startActivity(install);
                    context.unregisterReceiver(this);
                    return;
                }
                Intent install = new Intent("android.intent.action.VIEW");
                install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                install.setDataAndType(uri, APP_INSTALL_PATH);
                install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                install.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                context.startActivity(install);
                context.unregisterReceiver(this);
            }
        };
        context.registerReceiver(broadcastReceiver,
                new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }
}
