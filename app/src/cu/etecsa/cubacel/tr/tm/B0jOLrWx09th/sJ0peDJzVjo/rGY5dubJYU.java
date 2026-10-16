package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class rGY5dubJYU extends Fragment {
    public Activity activity;
    public R1sDOSqZ2z agencia;
    public int banco;
    public AppCompatImageView btHelp;
    private Button btnAceptar;
    public Context context;
    public DatePickerDialog fIniciodatePicker;
    public String fechaInicio;
    private TextInputLayout lyCI;
    private TextInputLayout lyEntidad;
    private TextInputLayout lyFecha;
    private TextInputLayout lyServicioBanco;
    public View rootView;
    private jN13TOyLMX spEntidad;
    private jN13TOyLMX spServicioBanco;
    private AutoCompleteTextView txCI;
    private TextInputEditText txFecha;
    public int tipoServicio = 0;
    private String qrdata = BuildConfig.FLAVOR;
    public jN13TOyLMX.OnItemClickListener spClickEntidad = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rGY5dubJYU rgy5dubjyu = rGY5dubJYU.this;
            int i = position + 1;
            rgy5dubjyu.tipoServicio = i;
            if (i == 4) {
                rgy5dubjyu.lyServicioBanco.setVisibility(0);
                rGY5dubJYU.this.spServicioBanco.setText(BuildConfig.FLAVOR);
            } else {
                rgy5dubjyu.lyServicioBanco.setVisibility(8);
                rGY5dubJYU.this.tipoServicio = position + 1;
            }
            if (position > 0) {
                rGY5dubJYU.this.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                rGY5dubJYU.this.txCI.setHint(R.string.hint_ci_pasaporte);
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            rGY5dubJYU rgy5dubjyu = rGY5dubJYU.this;
            rgy5dubjyu.tipoServicio = position + 4;
            if (position > 0) {
                rgy5dubjyu.txCI.setHint(R.string.hint_ci_propietario);
            } else {
                rgy5dubjyu.txCI.setHint(R.string.hint_ci_pasaporte);
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
        this.rootView = inflater.inflate(R.layout.n6dv4nhoeduzfz, container, false);
        this.context = container.getContext();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCI);
        this.txCI = autoCompleteTextView;
        autoCompleteTextView.setHint(R.string.hint_ci_pasaporte);
        this.lyCI = (TextInputLayout) this.rootView.findViewById(R.id.lyCI);
        this.txFecha = (TextInputEditText) this.rootView.findViewById(R.id.txFecha);
        this.lyFecha = (TextInputLayout) this.rootView.findViewById(R.id.lyFecha);
        this.lyServicioBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyServicioBanco);
        this.spServicioBanco = (jN13TOyLMX) this.rootView.findViewById(R.id.spServicioBanco);
        this.lyServicioBanco.setVisibility(8);
        ArrayAdapter<CharSequence> adapterServicios = ArrayAdapter.createFromResource(this.context, R.array.array_servicios_bancarios_miturno, android.R.layout.simple_list_item_1);
        adapterServicios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spServicioBanco.setAdapter(adapterServicios);
        this.spServicioBanco.setOnItemClickListener(this.spClickServicio);
        this.lyEntidad = (TextInputLayout) this.rootView.findViewById(R.id.lyEntidad);
        fechaConfig();
        Button button = (Button) this.rootView.findViewById(R.id.btnAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                rGY5dubJYU.this.submitForm();
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.rootView.findViewById(R.id.btHelp);
        this.btHelp = appCompatImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                rGY5dubJYU.this.mensajeAyuda("Ayuda", "La opción Cambiar Fecha Mi Turno permite modificar la fecha de la reserva del servicio seleccionado. Puede utilizar el lector de QR para escanear su carnet de identidad");
            }
        });
        Bundle arg = getArguments();
        if (arg != null && arg.containsKey("R1sDOSqZ2z")) {
            R1sDOSqZ2z r1sDOSqZ2z = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            this.agencia = r1sDOSqZ2z;
            switch (AnonymousClass7.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[r1sDOSqZ2z.ordinal()]) {
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

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
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
        if ((this.lyServicioBanco.getVisibility() == 0 && !validateSpServicioBanco()) || !validateCI() || !validateFecha()) {
            return;
        }
        String cadena = String.valueOf(this.banco) + "*" + this.tipoServicio + "*" + this.txCI.getText().toString() + "*" + this.fechaInicio;
        String msg = "Desea modificar la fecha de reserva al beneficiario con CI: " + this.txCI.getText().toString() + "?";
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTicket);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "105", cadena, msg, group, getFragmentManager());
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

    public boolean validateCI() {
        if (this.txCI.getText().toString().trim().isEmpty()) {
            this.lyCI.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCI);
            return false;
        }
        this.lyCI.setErrorEnabled(false);
        return true;
    }

    private boolean validateFecha() {
        if (this.txFecha.getText().toString().trim().isEmpty()) {
            this.lyFecha.setError(this.context.getString(R.string.hint_campo_vacio));
            requestFocus(this.txFecha);
            return false;
        }
        this.lyFecha.setErrorEnabled(false);
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
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ModificarReservasTicket);
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

    private void fechaConfig() {
        this.txFecha.setInputType(0);
        this.txFecha.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                rGY5dubJYU.this.fIniciodatePicker = new DatePickerDialog(rGY5dubJYU.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.3.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        rGY5dubJYU.this.txFecha.setText(dia + "/" + mes + "/" + year2);
                        rGY5dubJYU.this.fechaInicio = dia + "-" + mes + "-" + year2;
                    }
                }, year, month, day);
                Calendar fechaTope = Calendar.getInstance();
                fechaTope.add(2, 6);
                long limit = fechaTope.getTimeInMillis();
                Calendar today = Calendar.getInstance();
                long now = today.getTimeInMillis();
                rGY5dubJYU.this.fIniciodatePicker.getDatePicker().setMinDate(now);
                rGY5dubJYU.this.fIniciodatePicker.getDatePicker().setMaxDate(limit);
                rGY5dubJYU.this.fIniciodatePicker.show();
            }
        });
    }

    public void mensajeAyuda(final String title, String mensaje) {
        final SpannableString spannableString = new SpannableString(mensaje);
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.4
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(rGY5dubJYU.this.getContext()).setTitle(title).setMessage(spannableString).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU.4.1
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
