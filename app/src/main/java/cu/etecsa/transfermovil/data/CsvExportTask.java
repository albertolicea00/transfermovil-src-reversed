package cu.etecsa.transfermovil.data;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVWriter;
import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.core.enums.EntityExportType;
import cu.etecsa.transfermovil.data.entity.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.LZkPyWnV4b
 * @fingerprint AsyncTask exporting entity data to CSV files. Handles: Clientes, Pines,
 *              Fijos, Moviles, Nautas, Facturas, RecordSMS, Todos (all combined).
 *              Uses OpenCSV CSVWriter. Shows ProgressDialog during export.
 *
 * CSV row prefixes: CL=Client, TF=Landline, TM=Mobile, NA=Nauta, FA=Invoice,
 *                   PI=Pin, RS=SmsRecord.
 */
public class CsvExportTask extends AsyncTask<String, Boolean, Boolean> {

    public Context context;
    private final ProgressDialog dialog;
    public EntityExportType entidad;
    public File exportDir;
    public String nombreFichero;

    public CsvExportTask(Context context, EntityExportType entidad, File exportDir) {
        this.context = context;
        this.entidad = entidad;
        this.exportDir = exportDir;
        this.dialog = new ProgressDialog(context);
    }

    public CsvExportTask(Context context, EntityExportType entidad, File exportDir, String nombreFich) {
        String name = nombreFich;
        this.context = context;
        this.entidad = entidad;
        this.exportDir = exportDir;
        if (nombreFich.equals("")) {
            if (entidad == EntityExportType.Pines) {
                name = "exportPin";
            } else if (entidad == EntityExportType.Clientes) {
                name = "exportClientes";
            } else if (entidad == EntityExportType.Fijos) {
                name = "exportTelefonosFijos";
            } else if (entidad == EntityExportType.Moviles) {
                name = "exportTelefonosMoviles";
            } else if (entidad == EntityExportType.Nautas) {
                name = "exportCuentasNautas";
            } else if (entidad == EntityExportType.Facturas) {
                name = "exportFacturas";
            }
        }
        this.nombreFichero = name.trim() + ".csv";
        this.dialog = new ProgressDialog(context);
    }

    @Override
    public Boolean doInBackground(String... params) {
        if (!this.exportDir.exists()) {
            this.exportDir.mkdirs();
        }
        if (entidad == EntityExportType.Clientes) return ExportClientes();
        if (entidad == EntityExportType.Pines) return ExportPines();
        if (entidad == EntityExportType.Fijos) return ExportFijos();
        if (entidad == EntityExportType.Moviles) return ExportMoviles();
        if (entidad == EntityExportType.Nautas) return ExportNautas();
        if (entidad == EntityExportType.Todos) return ExportAll();
        if (entidad == EntityExportType.RecordSMS) return ExportRecordSMS();
        if (entidad == EntityExportType.Facturas) return ExportFacturas();
        return false;
    }

    private boolean ExportAll() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<LandlinePhone> fijos = DatabaseHelper.getInstance().getHelper().getFijosListDao().queryForAll();
                for (LandlinePhone fijo : fijos) {
                    if (fijo.getId_client() == 0) {
                        csv.writeNext(new String[]{"TF", fijo.getNumber()});
                    }
                }
                List<MobilePhone> moviles = DatabaseHelper.getInstance().getHelper().getMovilesListDao().queryForAll();
                for (MobilePhone movil : moviles) {
                    if (movil.getId_client() == 0) {
                        csv.writeNext(new String[]{"TM", movil.getNumber()});
                    }
                }
                List<NautaAccount> nautas = DatabaseHelper.getInstance().getHelper().getNautasListDao().queryForAll();
                for (NautaAccount nauta : nautas) {
                    if (nauta.getId_client() == 0) {
                        csv.writeNext(new String[]{"NA", nauta.getCuenta(), String.valueOf(nauta.getTipo_cuenta())});
                    }
                }
                List<Invoice> facturas = DatabaseHelper.getInstance().getHelper().getFacturasListDao().queryForAll();
                for (Invoice factura : facturas) {
                    if (factura.getId_client() == 0) {
                        csv.writeNext(new String[]{"FA", String.valueOf(factura.getTipo_Factura()),
                                factura.getFactura(), factura.getCodFactura(),
                                String.valueOf(factura.getId_client())});
                    }
                }
                List<PinEntry> pines = DatabaseHelper.getInstance().getHelper().getPinListDao().queryForAll();
                for (PinEntry pin : pines) {
                    csv.writeNext(new String[]{"PI", pin.getPin(), pin.getDescripcion()});
                }
                List<Client> clientes = DatabaseHelper.getInstance().getHelper().getClientListDao().queryForAll();
                for (Client client : clientes) {
                    csv.writeNext(new String[]{"CL", client.getName(), client.getCi(), client.getAddress()});
                    List<LandlinePhone> clientFijos = DatabaseHelper.getInstance().getFijosListsWithClient(client);
                    for (LandlinePhone f : clientFijos) {
                        csv.writeNext(new String[]{"TF", f.getNumber()});
                    }
                    List<MobilePhone> clientMoviles = DatabaseHelper.getInstance().getMovilListsWithClient(client);
                    for (MobilePhone m : clientMoviles) {
                        csv.writeNext(new String[]{"TM", m.getNumber()});
                    }
                    List<NautaAccount> clientNautas = DatabaseHelper.getInstance().getNautasListsWithClient(client);
                    for (NautaAccount n : clientNautas) {
                        csv.writeNext(new String[]{"NA", n.getCuenta(), String.valueOf(n.getTipo_cuenta())});
                    }
                    List<Invoice> clientFacturas = DatabaseHelper.getInstance().getFacturasListsWithClient(client);
                    for (Invoice f : clientFacturas) {
                        csv.writeNext(new String[]{"FA", String.valueOf(f.getTipo_Factura()),
                                f.getFactura(), f.getCodFactura(), String.valueOf(f.getId_client())});
                    }
                }
                csv.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e) {
            Log.e("CsvExportTask", e.getMessage(), e);
            return false;
        }
    }

    private boolean ExportClientes() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<Client> clientes = DatabaseHelper.getInstance().getHelper().getClientListDao().queryForAll();
                for (Client client : clientes) {
                    csv.writeNext(new String[]{"CL", client.getName(), client.getCi(), client.getAddress()});
                    List<LandlinePhone> fijos = DatabaseHelper.getInstance().getFijosListsWithClient(client);
                    for (LandlinePhone f : fijos) csv.writeNext(new String[]{"TF", f.getNumber()});
                    List<MobilePhone> moviles = DatabaseHelper.getInstance().getMovilListsWithClient(client);
                    for (MobilePhone m : moviles) csv.writeNext(new String[]{"TM", m.getNumber()});
                    List<NautaAccount> nautas = DatabaseHelper.getInstance().getNautasListsWithClient(client);
                    for (NautaAccount n : nautas) csv.writeNext(new String[]{"NA", n.getCuenta(), String.valueOf(n.getTipo_cuenta())});
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportPines() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<PinEntry> pines = DatabaseHelper.getInstance().getHelper().getPinListDao().queryForAll();
                for (PinEntry pin : pines) {
                    csv.writeNext(new String[]{pin.getPin(), pin.getDescripcion()});
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportRecordSMS() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<SmsRecord> records = DatabaseHelper.getInstance().getHelper().getRecordSMSListDao().queryForAll();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \nhh:mm:ss");
                for (SmsRecord record : records) {
                    String date = dateFormat.format(record.getFecha());
                    csv.writeNext(new String[]{"RS", record.getIdTransaccion(), date,
                            record.getCuenta(), record.getMonto(), record.getMoneda(),
                            record.getServicio(), record.getTipo_servicio().name()});
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportFijos() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<LandlinePhone> fijos = DatabaseHelper.getInstance().getHelper().getFijosListDao().queryForAll();
                List<Integer> idListClient = new ArrayList<>();
                for (LandlinePhone fijo : fijos) {
                    if (fijo.getId_client() > 0) {
                        if (!idListClient.contains(fijo.getId_client())) {
                            idListClient.add(fijo.getId_client());
                        }
                    } else {
                        csv.writeNext(new String[]{"TF", fijo.getNumber()});
                    }
                }
                for (Integer id : idListClient) {
                    Client cl = DatabaseHelper.getInstance().getClientListWithId(id);
                    csv.writeNext(new String[]{"CL", cl.getName(), cl.getCi(), cl.getAddress()});
                    List<LandlinePhone> clientFijos = DatabaseHelper.getInstance().getFijosListsWithClient(cl);
                    for (LandlinePhone f : clientFijos) {
                        csv.writeNext(new String[]{"TF", f.getNumber()});
                    }
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportMoviles() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<MobilePhone> moviles = DatabaseHelper.getInstance().getHelper().getMovilesListDao().queryForAll();
                for (MobilePhone movil : moviles) {
                    csv.writeNext(new String[]{"TM", movil.getNumber()});
                    if (movil.getId_client() > 0) {
                        Client cliente = DatabaseHelper.getInstance().getClientListWithId(movil.getId_client());
                        csv.writeNext(new String[]{"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()});
                    }
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportNautas() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<NautaAccount> nautas = DatabaseHelper.getInstance().getHelper().getNautasListDao().queryForAll();
                for (NautaAccount nauta : nautas) {
                    csv.writeNext(new String[]{"NA", nauta.getCuenta(), String.valueOf(nauta.getTipo_cuenta())});
                    if (nauta.getId_client() > 0) {
                        Client cliente = DatabaseHelper.getInstance().getClientListWithId(nauta.getId_client());
                        csv.writeNext(new String[]{"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()});
                    }
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    private boolean ExportFacturas() {
        File file = new File(this.exportDir, this.nombreFichero);
        try {
            file.createNewFile();
            CSVWriter csv = new CSVWriter(new FileWriter(file));
            try {
                List<Invoice> facturas = DatabaseHelper.getInstance().getHelper().getFacturasListDao().queryForAll();
                for (Invoice factura : facturas) {
                    csv.writeNext(new String[]{"FA", String.valueOf(factura.getTipo_Factura()),
                            factura.getFactura(), factura.getCodFactura(),
                            String.valueOf(factura.getId_client())});
                    if (factura.getId_client() > 0) {
                        Client cliente = DatabaseHelper.getInstance().getClientListWithId(factura.getId_client());
                        csv.writeNext(new String[]{"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()});
                    }
                }
                csv.close();
                return true;
            } catch (SQLException e) { e.printStackTrace(); return false; }
        } catch (IOException e) { Log.e("CsvExportTask", e.getMessage(), e); return false; }
    }

    @Override
    public void onPreExecute() {
        this.dialog.setMessage("Exportando datos...");
        this.dialog.show();
    }

    @Override
    public void onPostExecute(Boolean success) {
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (success) {
            Toast.makeText(this.context, R.string.toad_exportacion_realizada, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, R.string.toad_fallo_operacion, Toast.LENGTH_SHORT).show();
        }
    }
}
