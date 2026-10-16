package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

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
public class GPsckxvkPu extends Fragment {
    public Activity activity;
    public R1sDOSqZ2z agencia;
    public int banco;
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
    public int tipoServicio = 0;
    private String qrdata = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickEntidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            GPsckxvkPu gPsckxvkPu = GPsckxvkPu.this;
            int i = position + 1;
            gPsckxvkPu.tipoServicio = i;
            if (i == 4) {
                gPsckxvkPu.lyServicioBanco.setVisibility(0);
                GPsckxvkPu.this.spServicioBanco.setText(BuildConfig.FLAVOR);
            } else {
                gPsckxvkPu.lyServicioBanco.setVisibility(8);
                GPsckxvkPu.this.tipoServicio = position + 1;
            }
            if (position > 0) {
                GPsckxvkPu.this.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                GPsckxvkPu.this.txCI.setHint(R.string.hint_ci_pasaporte);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            GPsckxvkPu gPsckxvkPu = GPsckxvkPu.this;
            gPsckxvkPu.tipoServicio = position + 4;
            if (position > 0) {
                gPsckxvkPu.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                gPsckxvkPu.txCI.setHint(R.string.hint_ci_pasaporte);
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
        this.lyServicioBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyServicioBanco);
        this.spServicioBanco = (jN13TOyLMX) this.rootView.findViewById(R.id.spServicioBanco);
        this.lyServicioBanco.setVisibility(8);
        ArrayAdapter<CharSequence> adapterServicios = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_bancarios_miturno, android.R.layout.simple_list_item_1);
        adapterServicios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spServicioBanco.setAdapter(adapterServicios);
        this.spServicioBanco.setOnItemClickListener(this.spClickServicio);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText(R.string.opcion_eliminar_reserva_ticket);
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GPsckxvkPu.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GPsckxvkPu.this.mensajeAyuda("Ayuda", "La opción Eliminar MiTurno permite cancelar la reserva para el servicio seleccionado. Puede utilizar el lector de QR para escanear su carnet de identidad");
            }
        });
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
                case 1:
                    this.banco = 1;
                    break;
                case 2:
                    this.banco = 2;
                    break;
                case 3:
                    this.banco = 3;
                    break;
            }
        }
        if (this.banco == 3) {
            ArrayAdapter<CharSequence> adapterEntidad = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket_metro, android.R.layout.simple_list_item_1);
            adapterEntidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jN13TOyLMX jn13toylmx = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
            this.spEntidad = jn13toylmx;
            jn13toylmx.setAdapter(adapterEntidad);
            this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        } else {
            ArrayAdapter<CharSequence> adapterEntidad2 = ArrayAdapter.createFromResource(this.context, R.array.array_entidad_ticket, android.R.layout.simple_list_item_1);
            adapterEntidad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jN13TOyLMX jn13toylmx2 = (jN13TOyLMX) this.rootView.findViewById(R.id.spEntidad);
            this.spEntidad = jn13toylmx2;
            jn13toylmx2.setAdapter(adapterEntidad2);
            this.spEntidad.setOnItemClickListener(this.spClickEntidad);
        }
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.Metropolitano.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateSpEntidad()) {
            return;
        }
        if ((this.lyServicioBanco.getVisibility() == 0 && !validateSpServicioBanco()) || !validateCI()) {
            return;
        }
        String cadena = String.valueOf(this.banco) + "*" + this.tipoServicio + "*" + this.txCI.getText().toString();
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

    public boolean validateSpEntidad() {
        if (this.spEntidad.getText().toString().trim().isEmpty()) {
            this.lyEntidad.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spEntidad);
            return false;
        }
        this.lyEntidad.setErrorEnabled(false);
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
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.EliminarReservasTicket);
        arg.putSerializable("R1sDOSqZ2z", this.agencia);
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
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.3
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(GPsckxvkPu.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu.3.1
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
}
