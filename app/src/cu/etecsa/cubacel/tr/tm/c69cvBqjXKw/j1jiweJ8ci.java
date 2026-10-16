package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRMiBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.DHfGEge8yT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j1jiweJ8ci extends Fragment implements SYLBHJttme {
    public Activity activity;
    public ImageView btHelp;
    public ImageView btHelpEstado;
    private Button btnAceptar;
    public CardView btnActualizarCupon;
    public CardView btnEstadoCupon;
    public ImageView btnHelpActualizar;
    public Context context;
    public AutoCompleteTextView edAlias;
    public int id;
    public boolean isUpdated;
    public ImageView ivQR;
    public TextInputLayout lyAlias;
    public ProgressBar progressBarUpdate;
    public View rootView;
    public CompraBoleto ticket;
    public TextView toolbar_title;
    public TextView txDetallesAdicionales;
    public TextView txIDBTM;
    public TextView txIDBancoshow;
    public TextView txImporteCombustible;
    public TextView txPin;
    public TextView txSerieTarjeta;
    public TextView txToken;
    public TextView txfecha;
    public TextView txfechaAtraccion;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.hdnn2ne5ucxel, container, false);
        this.isUpdated = false;
        setHasOptionsMenu(true);
        this.context = container.getContext();
        this.toolbar_title = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.txfecha = (TextView) this.rootView.findViewById(R.id.txfecha);
        this.txfechaAtraccion = (TextView) this.rootView.findViewById(R.id.txfechaCompra);
        this.txSerieTarjeta = (TextView) this.rootView.findViewById(R.id.txSerieTarjeta);
        this.txIDBancoshow = (TextView) this.rootView.findViewById(R.id.txIDBancoshow);
        this.txIDBTM = (TextView) this.rootView.findViewById(R.id.txIDBTM);
        this.txImporteCombustible = (TextView) this.rootView.findViewById(R.id.txImporteCombustible);
        this.edAlias = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_descripcion);
        this.lyAlias = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_descripcion);
        this.txDetallesAdicionales = (TextView) this.rootView.findViewById(R.id.txDetallesAdicionales);
        this.ivQR = (ImageView) this.rootView.findViewById(R.id.ivQR);
        this.btnActualizarCupon = (CardView) this.rootView.findViewById(R.id.btnActualizarCupon);
        this.btnEstadoCupon = (CardView) this.rootView.findViewById(R.id.btnEstadoCupon);
        this.btnActualizarCupon.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.showActualizarTarjeta();
            }
        });
        this.btnEstadoCupon.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.showEstadoTarjeta();
            }
        });
        if (getArguments() != null) {
            this.id = Integer.parseInt(getArguments().get("id").toString());
            loadDataTicket();
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.submitForm();
            }
        });
        this.ivQR.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btHelpEstado);
        this.btHelpEstado = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.mensajeAyuda("Ayuda", "Obtiene la información del boleto.");
            }
        });
        ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.btnHelpActualizar);
        this.btnHelpActualizar = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.mensajeAyuda("Ayuda", "Permite cambiar la clave del boleto.");
            }
        });
        ImageView imageView3 = (ImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j1jiweJ8ci.this.mensajeAyuda("Ayuda", "Puede ver y gestionar los datos del boleto.");
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View v) {
        showQRDetailsDialog();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadDataTicket() {
        try {
            unYp8VQThY.init(this.context);
            CompraBoleto boletoListWithID = unYp8VQThY.getInstance().getBoletoListWithID(this.id);
            this.ticket = boletoListWithID;
            String date = invertirDiaMes(boletoListWithID.getFechaCompra());
            String dateAtraccion = invertirDiaMes(this.ticket.getFechaInicial());
            String dateEnd = invertirDiaMes(this.ticket.getFechaVencimiento());
            this.txfecha.setText(date);
            if (!dateAtraccion.equals(dateEnd)) {
                this.txfechaAtraccion.setText(dateAtraccion + " - " + dateEnd);
            } else {
                this.txfechaAtraccion.setText(dateAtraccion);
            }
            this.txSerieTarjeta.setText(String.valueOf(this.ticket.getIdOferta()));
            this.txIDBancoshow.setText(String.valueOf(this.ticket.getIdTransaccion()));
            this.txIDBTM.setText(String.valueOf(this.ticket.getIdTransferencia()));
            this.txImporteCombustible.setText(String.valueOf(this.ticket.getPrecio()) + " " + this.ticket.getMoneda());
            if (this.ticket.getAlias() != null && this.ticket.getAlias().length() > 0) {
                this.edAlias.setText(this.ticket.getAlias());
            }
            cargarDetallesAdicionales(this.ticket.getDatos());
            List<QRMiBoleto.DetalleAdicional> todosDetalles = parseDetallesFromTicket(this.ticket.getDatos());
            Bitmap qrBitmap = createCustomQR(todosDetalles);
            this.ivQR.setImageBitmap(qrBitmap);
        } catch (Exception ex) {
            Log.e("EXCEPTION", ex.getMessage());
        }
    }

    private Bitmap createCustomQR(List<QRMiBoleto.DetalleAdicional> detallesSeleccionados) {
        try {
            String data = this.ticket.getToken();
            String transaccionTM = this.ticket.getIdTransaccion();
            byte[] salt = this.ticket.getIdTransferencia().getBytes("UTF-8");
            String vSer = V5FFEZ0Qrr0.decryptMonedasWallet(data, transaccionTM, salt, 2);
            String[] list = vSer.split("\\|");
            QRMiBoleto qrData = new QRMiBoleto();
            qrData.setPin(list[1]);
            qrData.setToken(list[0]);
            qrData.setCi(this.ticket.getCi());
            if (detallesSeleccionados != null && !detallesSeleccionados.isEmpty()) {
                qrData.setDetallesAdicionales(detallesSeleccionados);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonQR = gson.toJson(qrData);
            Log.d("QR_JSON", jsonQR);
            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_etecsa_rectangle);
            Bitmap qr = ZUoEY89WdA.ProductLogo(icon, jsonQR, false, R.color.primaryDarkColor);
            return Bitmap.createScaledBitmap(qr, 700, 700, false);
        } catch (Exception e) {
            Log.e("QR_ERROR", "Error al generar QR", e);
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_update, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        int i = uyh0pxs9m37in.getItemId();
        if (i == R.id.action_update) {
            if (!this.isUpdated) {
                this.isUpdated = true;
                getActivity().getWindow().setFlags(16, 16);
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Actualizando boleto...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                new DHfGEge8yT(getActivity().getContentResolver(), new SYLBHJttme() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.7
                    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
                    public void onSetProgressBarVisibility(int visibility) {
                    }

                    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
                    public void onOfertasResult(final boolean success, int count, String message) {
                        new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ProgressDialog progressDialog2 = progressDialog;
                                if (progressDialog2 != null && progressDialog2.isShowing()) {
                                    progressDialog.dismiss();
                                }
                                j1jiweJ8ci.this.getActivity().getWindow().clearFlags(16);
                                j1jiweJ8ci.this.loadDataTicket();
                                if (success) {
                                    j1jiweJ8ci.this.showMessage("Datos actualizados correctamente.");
                                } else {
                                    j1jiweJ8ci.this.showMessage("Datos actualizados");
                                }
                            }
                        }, 3000L);
                    }
                }).execute(new Void[0]);
            } else {
                Toast.makeText(this.context, "Comprobando", 0).show();
                loadDataTicket();
            }
            return true;
        }
        return super.onOptionsItemSelected(uyh0pxs9m37in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessage(String message) {
        new AlertDialog.Builder(this.context).setMessage(message).setPositiveButton("Aceptar", null).setCancelable(false).show();
    }

    private void showDialogQR(Bitmap bm) {
        try {
            Dialog settingsDialog = new Dialog(this.context);
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            View v = inflater.inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
            ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
            iv.setImageBitmap(bm);
            settingsDialog.getWindow().requestFeature(1);
            settingsDialog.setContentView(v);
            settingsDialog.show();
        } catch (Exception e) {
            Toast.makeText(this.context, "Error, vuelva a intentarlo", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateAlias()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(j1jiweJ8ci.this.context);
                String alias = j1jiweJ8ci.this.edAlias.getText().toString();
                j1jiweJ8ci.this.ticket.setAlias(alias);
                unYp8VQThY.getInstance().updateCompraMiboleto(j1jiweJ8ci.this.ticket);
                j1jiweJ8ci.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateAlias() {
        if (this.edAlias.getText().toString().trim().isEmpty()) {
            this.lyAlias.setError(getString(R.string.hint_campo_vacio));
            requestFocus(this.edAlias);
            return false;
        }
        this.lyAlias.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEstadoTarjeta() {
        String cadena = String.valueOf(this.ticket.getIdOferta());
        String msg = "¿Desea consultar el estado del boleto de la serie siguiente " + cadena + " ?";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDNoBackSimple(this.context, "114", cadena, msg, group, getFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActualizarTarjeta() {
        String cadena = String.valueOf(this.ticket.getIdOferta());
        String msg = "¿Desea actualizar el boleto de la serie siguiente " + cadena + " ? ";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDNoBackSimple(this.context, "115", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.9
            @Override // java.lang.Runnable
            public void run() {
                j1jiweJ8ci.this.progressBarUpdate.setVisibility(visibility);
            }
        });
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
    public void onOfertasResult(boolean success, int count, String message) {
    }

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.10
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(j1jiweJ8ci.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci.10.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void cargarDetallesAdicionales(String datos) {
        String lineaCompleta;
        if (datos == null || datos.isEmpty()) {
            this.txDetallesAdicionales.setText("No hay detalles adicionales");
            return;
        }
        try {
            String[] elementos = datos.split("\\|");
            SpannableStringBuilder sb = new SpannableStringBuilder();
            int length = elementos.length;
            char c = 0;
            int i = 0;
            while (i < length) {
                String elemento = elementos[i];
                String[] partes = elemento.trim().split(";");
                if (partes.length >= 4) {
                    String valor = partes[2].trim();
                    if (!valor.equals("0")) {
                        String tipo = partes[c].trim();
                        String descripcion = partes[1].trim();
                        String moneda = partes[3].trim();
                        Object[] objArr = new Object[2];
                        objArr[c] = tipo;
                        objArr[1] = descripcion;
                        String lineaBase = String.format("%s: %s", objArr);
                        if (valor.equals("-")) {
                            lineaCompleta = String.format("%s (cantidad ilimitada)\n", lineaBase);
                        } else if (moneda.equals("CUP")) {
                            lineaCompleta = String.format("%s - %s CUP\n", lineaBase, valor);
                        } else {
                            lineaCompleta = String.format("%s - %s\n", lineaBase, valor);
                        }
                        int start = sb.length();
                        sb.append((CharSequence) lineaCompleta);
                        sb.setSpan(new StyleSpan(1), start, lineaBase.length() + start, 33);
                    }
                }
                i++;
                elementos = elementos;
                c = 0;
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
                this.txDetallesAdicionales.setText(sb);
            } else {
                this.txDetallesAdicionales.setText("No hay detalles adicionales válidos");
            }
        } catch (Exception e) {
            this.txDetallesAdicionales.setText("Error al formatear los detalles");
            e.printStackTrace();
        }
    }

    private List<QRMiBoleto.DetalleAdicional> parseDetallesFromTicket(String datosTicket) {
        List<QRMiBoleto.DetalleAdicional> detalles = new ArrayList<>();
        if (datosTicket == null || datosTicket.isEmpty()) {
            return detalles;
        }
        try {
            String[] elementos = datosTicket.split("\\|");
            for (String elemento : elementos) {
                String[] partes = elemento.trim().split(";");
                if (partes.length >= 4) {
                    String valor = partes[2].trim();
                    if (!valor.equals("0")) {
                        QRMiBoleto.DetalleAdicional detalle = new QRMiBoleto.DetalleAdicional();
                        detalle.setId(partes[0].trim());
                        detalle.setDescripcion(partes[1].trim());
                        detalle.setValor(valor);
                        detalle.setMoneda(partes[3].trim());
                        detalles.add(detalle);
                    }
                }
            }
        } catch (Exception e) {
            Log.e("PARSE_ERROR", "Error al parsear detalles", e);
        }
        return detalles;
    }

    private void showQRDetailsDialog() {
        try {
            final List<QRMiBoleto.DetalleAdicional> detallesList = new ArrayList<>();
            String detallesStr = this.ticket.getDatos();
            if (detallesStr != null && !detallesStr.isEmpty()) {
                String[] elementos = detallesStr.split("\\|");
                for (String elemento : elementos) {
                    String[] partes = elemento.trim().split(";");
                    if (partes.length >= 4) {
                        String valor = partes[2].trim();
                        if (!valor.equals("0")) {
                            QRMiBoleto.DetalleAdicional detalle = new QRMiBoleto.DetalleAdicional();
                            detalle.setId(partes[0].trim());
                            detalle.setDescripcion(partes[1].trim());
                            detalle.setValor(valor);
                            detalle.setMoneda(partes[3].trim());
                            detallesList.add(detalle);
                        }
                    }
                }
            }
            if (detallesList.isEmpty()) {
                Toast.makeText(this.context, "No hay detalles adicionales", 0).show();
                showDialogQR(createCustomQR(null));
                return;
            }
            String[] descripciones = new String[detallesList.size()];
            for (int i = 0; i < detallesList.size(); i++) {
                descripciones[i] = detallesList.get(i).getDescripcion();
            }
            final int[] seleccion = {-1};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Seleccionar un detalle para el QR");
            builder.setSingleChoiceItems(descripciones, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    j1jiweJ8ci.lambda$showQRDetailsDialog$1(seleccion, dialogInterface, i2);
                }
            });
            builder.setPositiveButton("Generar QR", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.j1jiweJ8ci$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$showQRDetailsDialog$2(seleccion, detallesList, dialogInterface, i2);
                }
            });
            builder.setNegativeButton("Cancelar", null);
            builder.show();
        } catch (Exception e) {
            Toast.makeText(this.context, "Error al procesar detalles", 0).show();
            Log.e("QR_SELECTION", "Error en showDetallesSelectionDialog", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showQRDetailsDialog$1(int[] seleccion, DialogInterface dialog, int which) {
        seleccion[0] = which;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showQRDetailsDialog$2(int[] seleccion, List detallesList, DialogInterface dialog, int which) {
        if (seleccion[0] == -1) {
            Toast.makeText(this.context, "Debe seleccionar un detalle", 0).show();
            return;
        }
        List<QRMiBoleto.DetalleAdicional> seleccionadosList = new ArrayList<>();
        seleccionadosList.add((QRMiBoleto.DetalleAdicional) detallesList.get(seleccion[0]));
        Bitmap qrBitmap = createCustomQR(seleccionadosList);
        this.ivQR.setImageBitmap(qrBitmap);
        showDialogQR(qrBitmap);
    }

    private String invertirDiaMes(Date fecha) {
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String fechaStr = originalFormat.format(fecha);
            String[] partes = fechaStr.split("[/ ]");
            String mes = partes[0];
            String dia = partes[1];
            return dia + "/" + mes + "/" + partes[2];
        } catch (Exception e) {
            Log.e("DATE_ERROR", "Error al invertir fecha", e);
            return BuildConfig.FLAVOR;
        }
    }
}
