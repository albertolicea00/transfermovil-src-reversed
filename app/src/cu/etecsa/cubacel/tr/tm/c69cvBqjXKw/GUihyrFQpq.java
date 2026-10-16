package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRCombustible;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.XYfkGsUkKH;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public class GUihyrFQpq extends Fragment implements Ti8eM28U2E {
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
    public TCTicket ticket;
    public TextView toolbar_title;
    public TextView txIDBTM;
    public TextView txIDBancoshow;
    public TextView txImporteCombustible;
    public TextView txPin;
    public TextView txSerieTarjeta;
    public TextView txToken;
    public TextView txfecha;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ekytfremjzee8, container, false);
        this.isUpdated = false;
        setHasOptionsMenu(true);
        this.context = container.getContext();
        this.toolbar_title = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.txfecha = (TextView) this.rootView.findViewById(R.id.txfecha);
        this.txSerieTarjeta = (TextView) this.rootView.findViewById(R.id.txSerieTarjeta);
        this.txIDBancoshow = (TextView) this.rootView.findViewById(R.id.txIDBancoshow);
        this.txIDBTM = (TextView) this.rootView.findViewById(R.id.txIDBTM);
        this.txImporteCombustible = (TextView) this.rootView.findViewById(R.id.txImporteCombustible);
        this.edAlias = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_descripcion);
        this.lyAlias = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_descripcion);
        this.txPin = (TextView) this.rootView.findViewById(R.id.txPin);
        this.txToken = (TextView) this.rootView.findViewById(R.id.txToken);
        this.ivQR = (ImageView) this.rootView.findViewById(R.id.ivQR);
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.progressBarUpdate);
        this.progressBarUpdate = progressBar;
        progressBar.setVisibility(8);
        this.btnActualizarCupon = (CardView) this.rootView.findViewById(R.id.btnActualizarCupon);
        this.btnEstadoCupon = (CardView) this.rootView.findViewById(R.id.btnEstadoCupon);
        this.btnActualizarCupon.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.showActualizarTarjeta();
            }
        });
        this.btnEstadoCupon.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.showEstadoTarjeta();
            }
        });
        if (getArguments() != null) {
            this.id = Integer.parseInt(getArguments().get("ticket_id").toString());
            loadDataTicket();
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.submitForm();
            }
        });
        this.ivQR.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq gUihyrFQpq = GUihyrFQpq.this;
                gUihyrFQpq.showDialogQR(gUihyrFQpq.createBitmapQR());
            }
        });
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btHelpEstado);
        this.btHelpEstado = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.mensajeAyuda("Ayuda", "Obtiene la información del cupón.");
            }
        });
        ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.btnHelpActualizar);
        this.btnHelpActualizar = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.mensajeAyuda("Ayuda", "Permite cambiar la clave del cupón.");
            }
        });
        ImageView imageView3 = (ImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GUihyrFQpq.this.mensajeAyuda("Ayuda", "Puede ver y gestionar los datos del cupón de combustible.");
            }
        });
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    private void loadDataTicket() {
        try {
            unYp8VQThY.init(this.context);
            this.ticket = unYp8VQThY.getInstance().getTCTicketListWithID(this.id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            String date = dateFormat.format(this.ticket.getFecha());
            this.txfecha.setText(date);
            this.txSerieTarjeta.setText(this.ticket.getSerie());
            this.txIDBancoshow.setText(this.ticket.getIdBank());
            this.txIDBTM.setText(this.ticket.getIdTM());
            this.txImporteCombustible.setText(String.valueOf(this.ticket.getImporte()) + " " + this.ticket.getMoneda());
            if (this.ticket.getAlias() != null && this.ticket.getAlias().length() > 0) {
                this.edAlias.setText(this.ticket.getAlias());
            }
            Bitmap btIM = createBitmapQR();
            this.ivQR.setImageBitmap(btIM);
        } catch (Exception ex) {
            Log.e("EXCEPTION", ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createBitmapQR() throws WriterException {
        String cadena = "ERROR";
        try {
            String[] data = this.ticket.getData().split("\\|");
            String d1 = data[0];
            String d2 = data[1];
            String vSer = V5FFEZ0Qrr0.cH(d1, this.ticket.getIdBank(), this.ticket.getIdTM());
            String vTok = V5FFEZ0Qrr0.cH(d2, this.ticket.getIdBank(), this.ticket.getIdTM());
            this.txPin.setText(vSer);
            this.txToken.setText(vTok);
            QRCombustible qr = new QRCombustible();
            qr.setToken(vTok);
            qr.setPin(vSer);
            Gson gson = new Gson();
            cadena = gson.toJson(qr);
        } catch (Exception ex) {
            Log.e("AESERROR", ex.getMessage());
        }
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.logo_transfermovil_sm);
        Bitmap bm = ZUoEY89WdA.ProductLogo(icon, cadena, false, R.color.primaryDarkColor);
        return bm;
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
                new XYfkGsUkKH(getContext().getContentResolver(), this).execute(new Void[0]);
            } else {
                Toast.makeText(this.context, "Comprobando", 0).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(uyh0pxs9m37in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogQR(Bitmap bm) {
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
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(GUihyrFQpq.this.context);
                String alias = GUihyrFQpq.this.edAlias.getText().toString();
                GUihyrFQpq.this.ticket.setAlias(alias);
                unYp8VQThY.getInstance().updateTCTicket(GUihyrFQpq.this.ticket);
                GUihyrFQpq.this.getFragmentManager().popBackStack();
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
        String cadena = this.ticket.getSerie();
        String msg = "¿Desea consultar el estado de la serie de combustible siguiente " + cadena + " ?";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDNoBackSimple(this.context, "38", cadena, msg, group, getFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActualizarTarjeta() {
        String cadena = this.ticket.getSerie();
        String msg = "¿Desea actualizar el cupón de la serie de combustible siguiente " + cadena + " ? ";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDNoBackSimple(this.context, "39", cadena, msg, group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E
    public void onCuentasResult(Boolean result, int code, String mensaje) {
        this.isUpdated = false;
        loadDataTicket();
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.9
            @Override // java.lang.Runnable
            public void run() {
                GUihyrFQpq.this.progressBarUpdate.setVisibility(visibility);
            }
        });
    }

    public void mensajeAyuda(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.10
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(GUihyrFQpq.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GUihyrFQpq.10.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }
}
