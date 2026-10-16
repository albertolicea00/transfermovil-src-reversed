package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq;

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

/* JADX INFO: loaded from: classes.dex */
public class XRa1KuZNBW extends Fragment {
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
    private jN13TOyLMX.OnItemClickListener spClickTipo = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW.5
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    XRa1KuZNBW.this.sender = "2899";
                    break;
                case 1:
                    XRa1KuZNBW.this.sender = "3099";
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
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                XRa1KuZNBW.this.getQR();
            }
        });
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                XRa1KuZNBW.this.submitForm();
            }
        });
        completarQR();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
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

    private void showSendSMS(final String Origen, final String Message_SMS, String Message_User) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(Message_User);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                HzjedYqYeh.send_sms(Origen, Message_SMS, XRa1KuZNBW.this.getContext());
                XRa1KuZNBW.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.XRa1KuZNBW.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQR() {
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
