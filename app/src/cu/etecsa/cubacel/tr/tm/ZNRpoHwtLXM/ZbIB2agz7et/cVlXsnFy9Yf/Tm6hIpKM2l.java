package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class Tm6hIpKM2l implements HEi1mzxf5v.ExportProgressListener {
    public String HEAD_LOG = "LoginPresenter";
    public int code;
    public Context context;
    public HEi1mzxf5v export;
    public boolean isSuccess;
    public String mensaje;
    public FqBpCTmUog response;
    public Intent resultData;
    public i2s4qBIJCN resultView;
    public TipoOperationDataEnum tipo;

    public enum TipoOperationDataEnum {
        EXPORT,
        IMPORT
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.HEi1mzxf5v.ExportProgressListener
    public void onProgressUpdate(int progress, String mensaje) {
        Log.i("TM_LOGS", "Progreso: " + progress + "% - " + mensaje);
        setProgressBarVisiblity(3, "Progreso: " + progress + "% - " + mensaje);
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.HEi1mzxf5v.ExportProgressListener
    public void onExportComplete(boolean success, String message) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.ZbIB2agz7et.cVlXsnFy9Yf.HEi1mzxf5v.ExportProgressListener
    public void onErrorOccurred(String errorMessage, int errorCode) {
    }

    public Tm6hIpKM2l(i2s4qBIJCN resultView, Context context) {
        this.context = context;
        this.resultView = resultView;
        HEi1mzxf5v hEi1mzxf5v = new HEi1mzxf5v();
        this.export = hEi1mzxf5v;
        hEi1mzxf5v.setProgressListener(this);
    }

    public void setProgressBarVisiblity(int visiblity, String msg) {
        i2s4qBIJCN i2s4qbijcn = this.resultView;
        if (i2s4qbijcn != null) {
            i2s4qbijcn.onSetProgressBarVisibility(visiblity, msg);
        }
    }

    public void exportData(Intent resultData) {
        this.tipo = TipoOperationDataEnum.EXPORT;
        this.resultData = resultData;
        ExportImportTask task = new ExportImportTask();
        task.execute(new String[0]);
    }

    public void importData(Intent resultData) {
        this.tipo = TipoOperationDataEnum.IMPORT;
        this.resultData = resultData;
        ExportImportTask task = new ExportImportTask();
        task.execute(new String[0]);
    }

    public class ExportImportTask extends AsyncTask<String, Integer, Boolean> {
        public ExportImportTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            Tm6hIpKM2l.this.setProgressBarVisiblity(0, BuildConfig.FLAVOR);
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                Tm6hIpKM2l tm6hIpKM2l = Tm6hIpKM2l.this;
                TipoOperationDataEnum tipoOperationDataEnum = tm6hIpKM2l.tipo;
                if (tipoOperationDataEnum == TipoOperationDataEnum.EXPORT) {
                    tm6hIpKM2l.response = tm6hIpKM2l.export.exportData(tm6hIpKM2l.context, tm6hIpKM2l.resultData);
                } else if (tipoOperationDataEnum == TipoOperationDataEnum.IMPORT) {
                    Q94Igo6JT0 importCU = new Q94Igo6JT0();
                    Tm6hIpKM2l tm6hIpKM2l2 = Tm6hIpKM2l.this;
                    tm6hIpKM2l2.response = importCU.importData(tm6hIpKM2l2.context, tm6hIpKM2l2.resultData);
                }
                return true;
            } catch (Exception e) {
                Tm6hIpKM2l.this.response.setCode(-1);
                Tm6hIpKM2l.this.response.setSuccess(false);
                Tm6hIpKM2l.this.response.setMensaje("Error: Ha ocurrido un error inesperado.");
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            Tm6hIpKM2l.this.setProgressBarVisiblity(4, BuildConfig.FLAVOR);
            Tm6hIpKM2l tm6hIpKM2l = Tm6hIpKM2l.this;
            i2s4qBIJCN i2s4qbijcn = tm6hIpKM2l.resultView;
            if (i2s4qbijcn != null) {
                TipoOperationDataEnum tipoOperationDataEnum = tm6hIpKM2l.tipo;
                if (tipoOperationDataEnum == TipoOperationDataEnum.EXPORT) {
                    i2s4qbijcn.onResultExport(tm6hIpKM2l.response);
                } else if (tipoOperationDataEnum == TipoOperationDataEnum.IMPORT) {
                    i2s4qbijcn.onResultImport(tm6hIpKM2l.response);
                }
            }
        }
    }
}
