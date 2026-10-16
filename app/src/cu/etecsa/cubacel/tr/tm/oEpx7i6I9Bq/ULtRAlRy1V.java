package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.FqBpCTmUog;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.Tm6hIpKM2l;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.i2s4qBIJCN;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ULtRAlRy1V extends Fragment implements i2s4qBIJCN {
    public Activity activity;
    public Button btBackup;
    public Button btRestaura;
    public Context context;
    private ActivityResultLauncher<Intent> createFileLauncher;
    public Tm6hIpKM2l dataPresenter;
    private ExportTask exportTask;
    private ImportTask importTask;
    private ActivityResultLauncher<Intent> openFileLauncher;
    private LinearLayout pBar;
    private TextView pbText;
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = getContext();
        this.rootView = inflater.inflate(R.layout.jz079sb3g5sau, container, false);
        initializeLaunchers();
        this.btBackup = (Button) this.rootView.findViewById(R.id.btBackup);
        this.btRestaura = (Button) this.rootView.findViewById(R.id.btRestaura);
        this.btBackup.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("ULtRAlRy1V", "Backup button clicked");
                ULtRAlRy1V.this.showBackupOptions();
            }
        });
        this.btRestaura.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("ULtRAlRy1V", "Restore button clicked");
                ULtRAlRy1V.this.openFileForRestore();
            }
        });
        this.pBar = (LinearLayout) this.rootView.findViewById(R.id.llProgressBar);
        this.pbText = (TextView) this.rootView.findViewById(R.id.pbText);
        this.dataPresenter = new Tm6hIpKM2l(this, this.context);
        return this.rootView;
    }

    private void initializeLaunchers() {
        this.createFileLauncher = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V.3
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult result) {
                Log.d("ULtRAlRy1V", "Create file result - Code: " + result.getResultCode() + ", Data: " + result.getData());
                if (result.getResultCode() == -1 || (result.getData() != null && result.getData().getData() != null)) {
                    Intent data = result.getData();
                    if (data != null && data.getData() != null) {
                        Log.d("ULtRAlRy1V", "File created successfully: " + data.getData());
                        ULtRAlRy1V.this.startExportInBackground(data);
                        return;
                    }
                    Log.e("ULtRAlRy1V", "File data is null but result is OK");
                    Toast.makeText(ULtRAlRy1V.this.context, "Error: No se pudo crear el archivo", 0).show();
                    return;
                }
                Log.d("ULtRAlRy1V", "File creation cancelled or failed");
            }
        });
        this.openFileLauncher = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V.4
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult result) {
                Log.d("ULtRAlRy1V", "Open file result - Code: " + result.getResultCode() + ", Data: " + result.getData());
                if (result.getResultCode() == -1 || (result.getData() != null && result.getData().getData() != null)) {
                    Intent data = result.getData();
                    if (data != null && data.getData() != null) {
                        Log.d("ULtRAlRy1V", "File selected for restore: " + data.getData());
                        try {
                            ULtRAlRy1V.this.context.getContentResolver().takePersistableUriPermission(data.getData(), 3);
                            ULtRAlRy1V.this.startImportInBackground(data);
                            return;
                        } catch (Exception e) {
                            Log.e("ULtRAlRy1V", "Error taking permissions: " + e.getMessage());
                            ULtRAlRy1V.this.startImportInBackground(data);
                            return;
                        }
                    }
                    Log.e("ULtRAlRy1V", "Restore file data is null");
                    Toast.makeText(ULtRAlRy1V.this.context, "Error al seleccionar el archivo", 0).show();
                    return;
                }
                Log.d("ULtRAlRy1V", "File selection cancelled");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBackupOptions() {
        try {
            Log.d("ULtRAlRy1V", "Showing backup options");
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/octet-stream");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String date = formatter.format(new Date());
            String fileName = "Transfermovil-" + date + ".trm";
            intent.putExtra("android.intent.extra.TITLE", fileName);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    intent.putExtra("android.provider.extra.INITIAL_URI", DocumentsContract.buildDocumentUri("com.android.externalstorage.documents", "primary:Documents"));
                } catch (Exception e) {
                    Log.w("ULtRAlRy1V", "Could not set initial URI: " + e.getMessage());
                }
            }
            Log.d("ULtRAlRy1V", "Launching file creator with file: " + fileName);
            this.createFileLauncher.launch(intent);
        } catch (Exception e2) {
            Log.e("ULtRAlRy1V", "Error in showBackupOptions: " + e2.getMessage(), e2);
            Toast.makeText(this.context, "Error: " + e2.getMessage(), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFileForRestore() {
        try {
            Log.d("ULtRAlRy1V", "Opening file for restore");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/trm", "text/plain", "application/json"});
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    intent.putExtra("android.provider.extra.INITIAL_URI", DocumentsContract.buildRootUri("com.android.externalstorage.documents", "primary:Documents"));
                } catch (Exception e) {
                    Log.w("ULtRAlRy1V", "Could not set initial URI for restore: " + e.getMessage());
                }
            }
            Log.d("ULtRAlRy1V", "Launching file picker");
            this.openFileLauncher.launch(intent);
        } catch (Exception e2) {
            Log.e("ULtRAlRy1V", "Error in openFileForRestore: " + e2.getMessage(), e2);
            Toast.makeText(this.context, "Error: " + e2.getMessage(), 1).show();
        }
    }

    private void openFileForRestoreAlternative() {
        try {
            Log.d("ULtRAlRy1V", "Using alternative file picker");
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            Intent chooser = Intent.createChooser(intent, "Seleccionar archivo de respaldo");
            this.openFileLauncher.launch(chooser);
        } catch (Exception e) {
            Log.e("ULtRAlRy1V", "Error in alternative file picker: " + e.getMessage(), e);
            Toast.makeText(this.context, "Error al abrir selector de archivos", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExportInBackground(Intent data) {
        onSetProgressBarVisibility(0, "Exportando datos...");
        ExportTask exportTask = new ExportTask(data);
        this.exportTask = exportTask;
        exportTask.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImportInBackground(Intent data) {
        onSetProgressBarVisibility(0, "Importando datos...");
        ImportTask importTask = new ImportTask(data);
        this.importTask = importTask;
        importTask.execute(new Void[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ExportTask exportTask = this.exportTask;
        if (exportTask != null && exportTask.getStatus() != AsyncTask.Status.FINISHED) {
            this.exportTask.cancel(true);
        }
        ImportTask importTask = this.importTask;
        if (importTask != null && importTask.getStatus() != AsyncTask.Status.FINISHED) {
            this.importTask.cancel(true);
        }
    }

    public class ExportTask extends AsyncTask<Void, Void, Boolean> {
        public Intent data;
        public String errorMessage;

        public ExportTask(Intent data) {
            this.data = data;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voids) {
            try {
                ULtRAlRy1V.this.dataPresenter.exportData(this.data);
                return true;
            } catch (Exception e) {
                this.errorMessage = e.getMessage();
                Log.e("ULtRAlRy1V", "Export error in background: " + this.errorMessage, e);
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            ULtRAlRy1V.this.onSetProgressBarVisibility(8, BuildConfig.FLAVOR);
            if (success.booleanValue()) {
                Toast.makeText(ULtRAlRy1V.this.context, "Datos exportados correctamente", 1).show();
                return;
            }
            Toast.makeText(ULtRAlRy1V.this.context, "Error al exportar: " + this.errorMessage, 1).show();
        }
    }

    public class ImportTask extends AsyncTask<Void, Void, Boolean> {
        public Intent data;
        public String errorMessage;

        public ImportTask(Intent data) {
            this.data = data;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voids) {
            try {
                ULtRAlRy1V.this.dataPresenter.importData(this.data);
                return true;
            } catch (Exception e) {
                this.errorMessage = e.getMessage();
                Log.e("ULtRAlRy1V", "Import error in background: " + this.errorMessage, e);
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            ULtRAlRy1V.this.onSetProgressBarVisibility(8, BuildConfig.FLAVOR);
            if (success.booleanValue()) {
                Toast.makeText(ULtRAlRy1V.this.context, "Datos importados correctamente", 1).show();
                return;
            }
            Toast.makeText(ULtRAlRy1V.this.context, "Error al importar: " + this.errorMessage, 1).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.i2s4qBIJCN
    public void onResultExport(FqBpCTmUog response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.i2s4qBIJCN
    public void onResultImport(FqBpCTmUog response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.i2s4qBIJCN
    public void onSetProgressBarVisibility(final int visibility, final String msg) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.ULtRAlRy1V.5
            @Override // java.lang.Runnable
            public void run() {
                ULtRAlRy1V.this.pBar.setVisibility(visibility);
                ULtRAlRy1V.this.pbText.setText(msg);
            }
        });
    }
}
