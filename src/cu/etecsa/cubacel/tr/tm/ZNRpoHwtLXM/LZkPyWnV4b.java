package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVWriter;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.b9Y4DfRgnv;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LZkPyWnV4b extends AsyncTask<String, Boolean, Boolean> {
    public Context context;
    private final ProgressDialog dialog;
    public b9Y4DfRgnv entidad;
    public File exportDir;
    public String nombreFichero;

    public LZkPyWnV4b(Context context, b9Y4DfRgnv entidad, File exportDir) {
        this.context = context;
        this.entidad = entidad;
        this.exportDir = exportDir;
        this.dialog = new ProgressDialog(context);
    }

    public LZkPyWnV4b(Context context, b9Y4DfRgnv entidad, File exportDir, String nombreFich) {
        String name = nombreFich;
        this.context = context;
        this.entidad = entidad;
        this.exportDir = exportDir;
        if (nombreFich.equals(BuildConfig.FLAVOR)) {
            if (entidad == b9Y4DfRgnv.Pines) {
                name = "exportPin";
            } else if (entidad == b9Y4DfRgnv.Clientes) {
                name = "exportClientes";
            } else if (entidad == b9Y4DfRgnv.Fijos) {
                name = "exportTelefonosFijos";
            } else if (entidad == b9Y4DfRgnv.Moviles) {
                name = "exportTelefonosMoviles";
            } else if (entidad == b9Y4DfRgnv.Nautas) {
                name = "exportCuentasNautas";
            } else if (entidad == b9Y4DfRgnv.Facturas) {
                name = "exportFacturas";
            }
        }
        this.nombreFichero = name.trim() + ".csv";
        this.dialog = new ProgressDialog(context);
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(String... params) {
        if (!this.exportDir.exists()) {
            this.exportDir.mkdirs();
        }
        b9Y4DfRgnv b9y4dfrgnv = this.entidad;
        if (b9y4dfrgnv == b9Y4DfRgnv.Clientes) {
            return Boolean.valueOf(ExportClientes());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Pines) {
            return Boolean.valueOf(ExportPines());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Fijos) {
            return Boolean.valueOf(ExportFijos());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Moviles) {
            return Boolean.valueOf(ExportMoviles());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Nautas) {
            return Boolean.valueOf(ExportNautas());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Todos) {
            return Boolean.valueOf(ExportAll());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.RecordSMS) {
            return Boolean.valueOf(ExportRecordSMS());
        }
        if (b9y4dfrgnv == b9Y4DfRgnv.Facturas) {
            return Boolean.valueOf(ExportFacturas());
        }
        return false;
    }

    private boolean ExportAll() throws SQLException {
        List<TelfFijo> listFijos;
        File fileCliente = new File(this.exportDir, this.nombreFichero);
        try {
            fileCliente.createNewFile();
            CSVWriter csvWriteAll = new CSVWriter(new FileWriter(fileCliente));
            try {
                try {
                    List<TelfFijo> listFijos2 = unYp8VQThY.getInstance().getHelper().getFijosListDao().queryForAll();
                    try {
                        for (TelfFijo fijo : listFijos2) {
                            try {
                                try {
                                    if (fijo.getId_client() == 0) {
                                        String[] arrStr = {"TF", fijo.getNumber().toString()};
                                        csvWriteAll.writeNext(arrStr);
                                    }
                                } catch (SQLException e) {
                                    e = e;
                                    e.printStackTrace();
                                    return false;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                Log.e("IHVTCBmiLV", e.getMessage(), e);
                                return false;
                            }
                        }
                        try {
                            List<TeflMovil> listMoviles = unYp8VQThY.getInstance().getHelper().getMovilesListDao().queryForAll();
                            for (TeflMovil movil : listMoviles) {
                                try {
                                    if (movil.getId_client() == 0) {
                                        String[] arrStr2 = {"TM", movil.getNumber().toString()};
                                        csvWriteAll.writeNext(arrStr2);
                                    }
                                } catch (SQLException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    return false;
                                }
                            }
                            try {
                                List<Nauta> listNauta = unYp8VQThY.getInstance().getHelper().getNautasListDao().queryForAll();
                                for (Nauta nauta : listNauta) {
                                    try {
                                        if (nauta.getId_client() == 0) {
                                            String[] arrStr3 = {"NA", nauta.getCuenta(), String.valueOf(nauta.getTipo_cuenta())};
                                            csvWriteAll.writeNext(arrStr3);
                                        }
                                    } catch (SQLException e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        return false;
                                    }
                                }
                                try {
                                    List<Factura> listfactura = unYp8VQThY.getInstance().getHelper().getFacturasListDao().queryForAll();
                                    for (Factura factura : listfactura) {
                                        try {
                                            if (factura.getId_client() == 0) {
                                                String[] arrStr4 = {"FA", String.valueOf(factura.getTipo_Factura()), factura.getFactura(), factura.getCodFactura(), String.valueOf(factura.getId_client())};
                                                csvWriteAll.writeNext(arrStr4);
                                            }
                                        } catch (SQLException e5) {
                                            e = e5;
                                            e.printStackTrace();
                                            return false;
                                        }
                                    }
                                    try {
                                        List<Pin> listpines = unYp8VQThY.getInstance().getHelper().getPinListDao().queryForAll();
                                        for (Pin pin : listpines) {
                                            try {
                                                String[] arrStr5 = {"PI", pin.getPin(), pin.getDescripcion()};
                                                csvWriteAll.writeNext(arrStr5);
                                            } catch (SQLException e6) {
                                                e = e6;
                                                e.printStackTrace();
                                                return false;
                                            }
                                        }
                                        try {
                                            List<Client> listcliente = unYp8VQThY.getInstance().getHelper().getClientListDao().queryForAll();
                                            Iterator<Client> it = listcliente.iterator();
                                            while (it.hasNext()) {
                                                Client client = it.next();
                                                String[] arr1 = {"CL", client.getName(), client.getCi(), client.getAddress()};
                                                csvWriteAll.writeNext(arr1);
                                                List<TelfFijo> listFijosCliente = unYp8VQThY.getInstance().getFijosListsWithClient(client);
                                                Iterator<Client> it2 = it;
                                                List<TeflMovil> listMovilesCliente = unYp8VQThY.getInstance().getMovilListsWithClient(client);
                                                List<Nauta> listNautaCliente = unYp8VQThY.getInstance().getNautasListsWithClient(client);
                                                File fileCliente2 = fileCliente;
                                                try {
                                                    List<Factura> listFacturaCliente = unYp8VQThY.getInstance().getFacturasListsWithClient(client);
                                                    if (listFijosCliente.isEmpty()) {
                                                        listFijos = listFijos2;
                                                    } else {
                                                        Iterator<TelfFijo> it3 = listFijosCliente.iterator();
                                                        while (it3.hasNext()) {
                                                            String[] arrStr6 = arr1;
                                                            List<TelfFijo> listFijos3 = listFijos2;
                                                            try {
                                                                csvWriteAll.writeNext(new String[]{"TF", it3.next().getNumber().toString()});
                                                                arr1 = arrStr6;
                                                                listFijos2 = listFijos3;
                                                            } catch (SQLException e7) {
                                                                e = e7;
                                                                e.printStackTrace();
                                                                return false;
                                                            }
                                                        }
                                                        listFijos = listFijos2;
                                                    }
                                                    if (!listMovilesCliente.isEmpty()) {
                                                        for (Iterator<TeflMovil> it4 = listMovilesCliente.iterator(); it4.hasNext(); it4 = it4) {
                                                            csvWriteAll.writeNext(new String[]{"TM", it4.next().getNumber().toString()});
                                                            listMovilesCliente = listMovilesCliente;
                                                        }
                                                    }
                                                    if (!listNautaCliente.isEmpty()) {
                                                        for (Iterator<Nauta> it5 = listNautaCliente.iterator(); it5.hasNext(); it5 = it5) {
                                                            Nauta nauta2 = it5.next();
                                                            csvWriteAll.writeNext(new String[]{"NA", nauta2.getCuenta().toString(), String.valueOf(nauta2.getTipo_cuenta())});
                                                        }
                                                    }
                                                    if (!listFacturaCliente.isEmpty()) {
                                                        for (Iterator<Factura> it6 = listFacturaCliente.iterator(); it6.hasNext(); it6 = it6) {
                                                            Factura factura2 = it6.next();
                                                            csvWriteAll.writeNext(new String[]{"FA", String.valueOf(factura2.getTipo_Factura()), factura2.getFactura(), factura2.getCodFactura(), String.valueOf(factura2.getId_client())});
                                                        }
                                                    }
                                                    it = it2;
                                                    fileCliente = fileCliente2;
                                                    listFijos2 = listFijos;
                                                } catch (SQLException e8) {
                                                    e = e8;
                                                    e.printStackTrace();
                                                    return false;
                                                }
                                            }
                                            csvWriteAll.close();
                                            return true;
                                        } catch (SQLException e9) {
                                            e = e9;
                                        }
                                    } catch (SQLException e10) {
                                        e = e10;
                                    }
                                } catch (SQLException e11) {
                                    e = e11;
                                }
                            } catch (SQLException e12) {
                                e = e12;
                            }
                        } catch (SQLException e13) {
                            e = e13;
                        }
                    } catch (SQLException e14) {
                        e = e14;
                    }
                } catch (SQLException e15) {
                    e = e15;
                }
            } catch (IOException e16) {
                e = e16;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    private boolean ExportClientes() {
        File fileCliente = new File(this.exportDir, this.nombreFichero);
        try {
            fileCliente.createNewFile();
            CSVWriter csvWriteCliente = new CSVWriter(new FileWriter(fileCliente));
            try {
                List<Client> listcliente = unYp8VQThY.getInstance().getHelper().getClientListDao().queryForAll();
                for (Client client : listcliente) {
                    String[] arrStr = {"CL", client.getName(), client.getCi(), client.getAddress()};
                    csvWriteCliente.writeNext(arrStr);
                    List<TelfFijo> listFijosCliente = unYp8VQThY.getInstance().getFijosListsWithClient(client);
                    List<TeflMovil> listMovilesCliente = unYp8VQThY.getInstance().getMovilListsWithClient(client);
                    List<Nauta> listNautaCliente = unYp8VQThY.getInstance().getNautasListsWithClient(client);
                    if (!listFijosCliente.isEmpty()) {
                        for (TelfFijo fijo : listFijosCliente) {
                            String[] arr1 = {"TF", fijo.getNumber().toString()};
                            csvWriteCliente.writeNext(arr1);
                        }
                    }
                    if (!listMovilesCliente.isEmpty()) {
                        for (TeflMovil movil : listMovilesCliente) {
                            String[] arr2 = {"TM", movil.getNumber().toString()};
                            csvWriteCliente.writeNext(arr2);
                        }
                    }
                    if (!listNautaCliente.isEmpty()) {
                        for (Nauta nauta : listNautaCliente) {
                            String[] arr3 = {"NA", nauta.getCuenta(), String.valueOf(nauta.getTipo_cuenta())};
                            csvWriteCliente.writeNext(arr3);
                        }
                    }
                }
                csvWriteCliente.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportPines() {
        File filePin = new File(this.exportDir, this.nombreFichero);
        try {
            filePin.createNewFile();
            CSVWriter csvWritePin = new CSVWriter(new FileWriter(filePin));
            try {
                List<Pin> listpines = unYp8VQThY.getInstance().getHelper().getPinListDao().queryForAll();
                for (Pin pin : listpines) {
                    String[] arrStr = {pin.getPin(), pin.getDescripcion()};
                    csvWritePin.writeNext(arrStr);
                }
                csvWritePin.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportRecordSMS() {
        File filePin = new File(this.exportDir, this.nombreFichero);
        try {
            filePin.createNewFile();
            CSVWriter csvWritePin = new CSVWriter(new FileWriter(filePin));
            try {
                List<RecordSMS> listrecord = unYp8VQThY.getInstance().getHelper().getRecordSMSListDao().queryForAll();
                for (RecordSMS record : listrecord) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \nhh:mm:ss");
                    String date = dateFormat.format(record.getFecha());
                    String[] arrStr = {"RS", record.getIdTransaccion(), date, record.getCuenta(), record.getMonto(), record.getMoneda(), record.getServicio(), record.getTipo_servicio().name()};
                    csvWritePin.writeNext(arrStr);
                }
                csvWritePin.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportFijos() {
        char c;
        File fileFijos = new File(this.exportDir, this.nombreFichero);
        try {
            fileFijos.createNewFile();
            CSVWriter csvWriteFijo = new CSVWriter(new FileWriter(fileFijos));
            try {
                unYp8VQThY.getInstance().getHelper().getClientListDao().queryForAll();
                List<TelfFijo> listfijo = unYp8VQThY.getInstance().getHelper().getFijosListDao().queryForAll();
                List<Integer> idListClient = new ArrayList<>();
                Iterator<TelfFijo> it = listfijo.iterator();
                while (true) {
                    c = 1;
                    if (!it.hasNext()) {
                        break;
                    }
                    TelfFijo fijo = it.next();
                    if (fijo.getId_client() > 0) {
                        if (!idListClient.contains(Integer.valueOf(fijo.getId_client()))) {
                            idListClient.add(Integer.valueOf(fijo.getId_client()));
                        }
                    } else {
                        csvWriteFijo.writeNext(new String[]{"TF", fijo.getNumber()});
                    }
                }
                for (Integer id : idListClient) {
                    Client cl = unYp8VQThY.getInstance().getClientListWithId(id.intValue());
                    String[] arrStr = new String[4];
                    arrStr[0] = "CL";
                    arrStr[c] = cl.getName();
                    arrStr[2] = cl.getCi();
                    arrStr[3] = cl.getAddress();
                    csvWriteFijo.writeNext(arrStr);
                    List<TelfFijo> listFijosCliente = unYp8VQThY.getInstance().getFijosListsWithClient(cl);
                    if (!listFijosCliente.isEmpty()) {
                        Iterator<TelfFijo> it2 = listFijosCliente.iterator();
                        while (it2.hasNext()) {
                            String[] arr1 = {"TF", it2.next().getNumber().toString()};
                            csvWriteFijo.writeNext(arr1);
                        }
                    }
                    c = 1;
                }
                csvWriteFijo.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportMoviles() {
        File fileMovil = new File(this.exportDir, this.nombreFichero);
        try {
            fileMovil.createNewFile();
            CSVWriter csvWriteMovil = new CSVWriter(new FileWriter(fileMovil));
            try {
                List<TeflMovil> listmovil = unYp8VQThY.getInstance().getHelper().getMovilesListDao().queryForAll();
                for (TeflMovil movil : listmovil) {
                    String[] arrStr = {"TM", movil.getNumber()};
                    csvWriteMovil.writeNext(arrStr);
                    if (movil.getId_client() > 0) {
                        Client cliente = unYp8VQThY.getInstance().getClientListWithId(movil.getId_client());
                        String[] arr1 = {"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()};
                        csvWriteMovil.writeNext(arr1);
                    }
                }
                csvWriteMovil.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportNautas() {
        File fileNauta = new File(this.exportDir, this.nombreFichero);
        try {
            fileNauta.createNewFile();
            CSVWriter csvWriteMovil = new CSVWriter(new FileWriter(fileNauta));
            try {
                List<Nauta> listnauta = unYp8VQThY.getInstance().getHelper().getNautasListDao().queryForAll();
                for (Nauta nauta : listnauta) {
                    String[] arrStr = {"NA", nauta.getCuenta(), String.valueOf(nauta.getTipo_cuenta())};
                    csvWriteMovil.writeNext(arrStr);
                    if (nauta.getId_client() > 0) {
                        Client cliente = unYp8VQThY.getInstance().getClientListWithId(nauta.getId_client());
                        String[] arr1 = {"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()};
                        csvWriteMovil.writeNext(arr1);
                    }
                }
                csvWriteMovil.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    private boolean ExportFacturas() {
        File fileNauta = new File(this.exportDir, this.nombreFichero);
        try {
            fileNauta.createNewFile();
            CSVWriter csvWriteMovil = new CSVWriter(new FileWriter(fileNauta));
            try {
                List<Factura> listafactura = unYp8VQThY.getInstance().getHelper().getFacturasListDao().queryForAll();
                for (Factura factura : listafactura) {
                    String[] arrStr = {"FA", String.valueOf(factura.getTipo_Factura()), factura.getFactura(), factura.getCodFactura(), String.valueOf(factura.getId_client())};
                    csvWriteMovil.writeNext(arrStr);
                    if (factura.getId_client() > 0) {
                        Client cliente = unYp8VQThY.getInstance().getClientListWithId(factura.getId_client());
                        String[] arr1 = {"CL", cliente.getName(), cliente.getCi(), cliente.getAddress()};
                        csvWriteMovil.writeNext(arr1);
                    }
                }
                csvWriteMovil.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            Log.e("IHVTCBmiLV", e2.getMessage(), e2);
            return false;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.dialog.setMessage("Exportando datos...");
        this.dialog.show();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean success) {
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (success.booleanValue()) {
            Toast.makeText(this.context, R.string.toad_exportacion_realizada, 0).show();
        } else {
            Toast.makeText(this.context, R.string.toad_fallo_operacion, 0).show();
        }
    }
}
