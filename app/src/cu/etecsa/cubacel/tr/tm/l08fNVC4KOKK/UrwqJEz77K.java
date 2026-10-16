package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.BuildConfig;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class UrwqJEz77K {
    public Context context;
    public String url;
    public String FILE_NAME = "transfermovil_0.apk";
    public String FILE_BASE_PATH = "file://";
    public String MIME_TYPE = "application/vnd.android.package-archive";
    public String PROVIDER_PATH = ".provider";
    public String APP_INSTALL_PATH = "\"application/vnd.android.package-archive\"";

    public UrwqJEz77K(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    public void enquequeDowload() {
        String destinantion = (this.context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/") + this.FILE_NAME;
        Uri uri = Uri.parse(this.FILE_BASE_PATH + destinantion);
        File file = new File(destinantion);
        if (file.exists()) {
            file.delete();
        }
        DownloadManager downloadManager = (DownloadManager) this.context.getSystemService("download");
        Uri dowloadUri = Uri.parse(this.url);
        DownloadManager.Request request = new DownloadManager.Request(dowloadUri);
        request.setMimeType(this.MIME_TYPE);
        request.setTitle("Descarga de Transfermóvil");
        request.setDescription("Descargar aplicación Transfermóvil");
        request.setDestinationUri(uri);
        showInstallOption(destinantion, uri);
        downloadManager.enqueue(request);
    }

    private void showInstallOption(final String destinantion, final Uri uri) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UrwqJEz77K.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) throws XmlPullParserException, IOException {
                if (Build.VERSION.SDK_INT >= 24) {
                    Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + UrwqJEz77K.this.PROVIDER_PATH, new File(destinantion));
                    Intent install = new Intent("android.intent.action.VIEW");
                    install.addFlags(RecyclerView.ViewHolder.FLAG_IGNORE);
                    install.addFlags(67108864);
                    install.addFlags(1);
                    install.addFlags(2);
                    install.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    install.setData(contentUri);
                    context.startActivity(install);
                    context.unregisterReceiver(this);
                    return;
                }
                Intent install2 = new Intent("android.intent.action.VIEW");
                install2.addFlags(67108864);
                install2.setDataAndType(uri, UrwqJEz77K.this.APP_INSTALL_PATH);
                install2.addFlags(1);
                install2.addFlags(2);
                context.startActivity(install2);
                context.unregisterReceiver(this);
            }
        };
        this.context.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }
}
