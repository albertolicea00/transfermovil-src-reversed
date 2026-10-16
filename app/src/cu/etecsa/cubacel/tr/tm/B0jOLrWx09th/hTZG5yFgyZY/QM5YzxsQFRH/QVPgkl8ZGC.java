package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class QVPgkl8ZGC extends Fragment {
    public Activity activity;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    public Context context;
    private TextInputLayout lyCI;
    private TextInputLayout lyEntidad;
    private TextInputLayout lyServicioBanco;
    public View rootView;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spServicioBanco;
    private TextView toolbar_title;
    private AutoCompleteTextView txCI;
    private String agencyId = "4";
    private String qrdata = BuildConfig.FLAVOR;
    public int tipoServicio = 0;
    public jN13TOyLMX.OnItemClickListener spClickEntidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            QVPgkl8ZGC qVPgkl8ZGC = QVPgkl8ZGC.this;
            int i = position + 1;
            qVPgkl8ZGC.tipoServicio = i;
            if (i == 4) {
                qVPgkl8ZGC.lyServicioBanco.setVisibility(0);
                QVPgkl8ZGC.this.spServicioBanco.setText(BuildConfig.FLAVOR);
            } else {
                qVPgkl8ZGC.lyServicioBanco.setVisibility(8);
                QVPgkl8ZGC.this.tipoServicio = position + 1;
            }
            if (position > 0) {
                QVPgkl8ZGC.this.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                QVPgkl8ZGC.this.txCI.setHint(R.string.hint_ci_pasaporte);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            QVPgkl8ZGC qVPgkl8ZGC = QVPgkl8ZGC.this;
            qVPgkl8ZGC.tipoServicio = position + 4;
            if (position > 0) {
                qVPgkl8ZGC.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                qVPgkl8ZGC.txCI.setHint(R.string.hint_ci_pasaporte);
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.yojcvvgzrfmzf, container, false);
        this.context = container.getContext();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.txCI = autoCompleteTextView;
        autoCompleteTextView.setHint(R.string.hint_ci_pasaporte);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.opcion_eliminar_reserva_ticket);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btnAceptar);
        ArrayAdapter<CharSequence> adapterEntidad = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket_metro, android.R.layout.simple_list_item_1);
        adapterEntidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
        this.spEntidad = jn13toylmx;
        jn13toylmx.setAdapter(adapterEntidad);
        this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        this.lyServicioBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyServicioBanco);
        this.spServicioBanco = (jN13TOyLMX) this.rootView.findViewById(R.id.spServicioBanco);
        this.lyServicioBanco.setVisibility(8);
        ArrayAdapter<CharSequence> adapterServicios = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_bancarios_miturno, android.R.layout.simple_list_item_1);
        adapterServicios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spServicioBanco.setAdapter(adapterServicios);
        this.spServicioBanco.setOnItemClickListener(this.spClickServicio);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QVPgkl8ZGC.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QVPgkl8ZGC.this.mensajeAyuda("Ayuda", "La opción Eliminar MiTurno permite cancelar la reserva para el servicio seleccionado. Puede utilizar el lector de QR para escanear su carnet de identidad");
            }
        });
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("QRData")) {
            String string = arg.getString("QRData");
            this.qrdata = string;
            try {
                String ci = string.split("CI:")[1].split("FV")[0].trim();
                this.txCI.setText(ci);
            } catch (Exception e) {
                this.txCI.setText(BuildConfig.FLAVOR);
            }
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateSpEntidad()) {
            return;
        }
        if ((this.lyServicioBanco.getVisibility() == 0 && !validateSpServicioBanco()) || !validateCI()) {
            return;
        }
        String cadena = this.agencyId + "*" + this.tipoServicio + "*" + this.txCI.getText().toString();
        String msg = "Desea eliminar la reserva al beneficiario con CI: " + this.txCI.getText().toString() + "?";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTicket);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "106", cadena, msg, group, getFragmentManager());
    }

    public boolean validateCI() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpServicioBanco() {
        if (this.spServicioBanco.getText().toString().trim().isEmpty()) {
            this.lyServicioBanco.setError(getString(R.string.hint_campo_vacio));
            requestFocus(this.spServicioBanco);
            return false;
        }
        this.lyServicioBanco.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_qr, menu);
        MenuItem uyh0pxs9m37in = menu.findItem(R.id.qrsgen);
        uyh0pxs9m37in.setVisible(false);
        MenuItem itemCargarLink = menu.findItem(R.id.itemCargarLink);
        itemCargarLink.setVisible(false);
        MenuItem itemShare = menu.findItem(R.id.qrshare);
        itemShare.setVisible(false);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        FragmentActivity activity = getActivity();
        uyh0pxs9m37in.toString();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.EliminarReservasTicket);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
        switch (uyh0pxs9m37in.getItemId()) {
            case R.id.qrscan /* 2131297279 */:
                if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
                    return true;
                }
                OJ3XxacXOT qr = new OJ3XxacXOT();
                qr.setArguments(arg);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(uyh0pxs9m37in);
        }
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.3
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(QVPgkl8ZGC.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
                alertDialog.show();
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                if (textView != null) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
        });
    }

    public boolean validateSpEntidad() {
        if (this.spEntidad.getText().toString().trim().isEmpty()) {
            this.lyEntidad.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spEntidad);
            return false;
        }
        this.lyEntidad.setErrorEnabled(false);
        return true;
    }
}
