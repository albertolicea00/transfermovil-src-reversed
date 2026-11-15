package cu.etecsa.transfermovil.ui.fragment.carrier;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HzjedYqYeh;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW
 * @original_apk_version 1.260416
 */
public class MobileVotingSmsFragment extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipo;
    private Button btnAceptar;
    public ImageButton btnQR;
    public Context context;
    public TextInputLayout inputLayoutTipoMoneda;
    public View rootView;
    public jN13TOyLMX spinnerTipoSource;
    private TextInputLayout textInputLayoutBody;
    public String[] tipo;
    private EditText txBody;
    public String sender = BuildConfig.FLAVOR;
    public String body = BuildConfig.FLAVOR;
    private jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    MobileVotingSmsFragment.this.sender = "2899";
                    break;
                case 1:
                    MobileVotingSmsFragment.this.sender = "3099";
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.gbmbcbd18nuua, container, false);
        this.context = container.getContext();
        this.textInputLayoutBody = (TextInputLayout) this.rootView.findViewById(R.id.textInputLayoutBody);
        this.txBody = (EditText) this.rootView.findViewById(R.id.txBody);
        this.tipo = getResources().getStringArray(R.array.array_voto);
        this.inputLayoutTipoMoneda = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_moneda);
        this.spinnerTipoSource = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoSource);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_voto, android.R.layout.simple_list_item_1);
        this.adapterTipo = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoSource.setAdapter(this.adapterTipo);
        this.spinnerTipoSource.setOnItemClickListener(this.spClickTipo);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btnQRScan);
        this.btnQR = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MobileVotingSmsFragment.this.getQR();
            }
        });
        this.btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobileVotingSmsFragment.this.submitForm();
            }
        });
        completarQR();
        return this.rootView;
    }

    private void submitForm() {
        String strTrim = this.txBody.getText().toString().trim();
        this.body = strTrim;
        showSendSMS(this.sender, strTrim, "¿Desea enviar un SMS con el voto seleccionado?");
    }

    public void completarQR() {
        try {
            if (getArguments() != null) {
                Bundle arg = getArguments();
                if (arg.containsKey("QRData")) {
                    String qrdata = arg.getString("QRData");
                    if (qrdata.contains("VOTOMOVIL")) {
                        String[] parametros = qrdata.substring(10).split(",");
                        if (!parametros[0].contains("2899")) {
                            if (parametros[0].contains("3099")) {
                                this.sender = "3099";
                                this.spinnerTipoSource.setText(this.tipo[1]);
                            }
                        } else {
                            this.sender = "2899";
                            this.spinnerTipoSource.setText(this.tipo[0]);
                        }
                        String strTrim = parametros[1].trim();
                        this.body = strTrim;
                        this.txBody.setText(strTrim);
                    }
                }
            }
        } catch (Exception ex) {
            Log.i("jpo48jtycgtsp", ex.getMessage());
        }
    }

    private void showSendSMS(final String origen, final String messageSms, String messageUser) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(messageUser);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                HzjedYqYeh.send_sms(origen, messageSms, MobileVotingSmsFragment.this.getContext());
                MobileVotingSmsFragment.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void getQR() {
        FragmentActivity activity = getActivity();
        Bundle arg = new Bundle();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.VotoMovil);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.ETECSA);
        if (Build.VERSION.SDK_INT >= 23 && this.context.checkSelfPermission("android.permission.CAMERA") == -1) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 0);
            return;
        }
        OJ3XxacXOT qr = new OJ3XxacXOT();
        qr.setArguments(arg);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
    }
}
