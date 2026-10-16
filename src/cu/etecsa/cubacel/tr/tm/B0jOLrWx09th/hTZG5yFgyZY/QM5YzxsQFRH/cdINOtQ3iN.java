package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Canal;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class cdINOtQ3iN extends Fragment {
    private static final int CAMERA_PERMISSION_REQUEST = 100;
    private static final Pattern PATRON_TEXTO_VALIDO = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final String TAG = "cdINOtQ3iN";
    private ArrayAdapter<Canal> adapterCanales;
    private ArrayAdapter<CharSequence> adapterTipoBolsa;
    private Button btnAceptar;
    private ImageButton btnQR;
    private Context context;
    private TextInputLayout inputLayoutTipoSource;
    private V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyBolsas;
    private View rootView;
    private jN13TOyLMX spBolsas;
    private jN13TOyLMX spinnerTipoSource;
    private TextInputLayout textInputLayoutBody;
    private EditText txBody;
    private List<Canal> listaCanales = new ArrayList();
    private int tipoBolsa = 0;
    private Canal canalSeleccionado = null;
    private final jN13TOyLMX.OnItemClickListener spClickCanal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            if (position >= 0 && position < cdINOtQ3iN.this.listaCanales.size()) {
                cdINOtQ3iN cdinotq3in = cdINOtQ3iN.this;
                cdinotq3in.canalSeleccionado = (Canal) cdinotq3in.listaCanales.get(position);
                if (cdINOtQ3iN.this.lyBolsas != null) {
                    cdINOtQ3iN.this.lyBolsas.setVisibility(cdINOtQ3iN.this.canalSeleccionado.getEsDePago() == 1 ? 0 : 8);
                    if (cdINOtQ3iN.this.canalSeleccionado.getEsDePago() == 0) {
                        cdINOtQ3iN.this.tipoBolsa = 0;
                    }
                }
                Log.i(cdINOtQ3iN.TAG, "Canal seleccionado: " + cdINOtQ3iN.this.canalSeleccionado.getNombre());
            }
        }
    };
    private final jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            cdINOtQ3iN.this.tipoBolsa = position + 1;
            Log.i(cdINOtQ3iN.TAG, "Bolsa seleccionada: " + cdINOtQ3iN.this.tipoBolsa);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.h1vzvglny8jc5, container, false);
        this.context = container.getContext();
        this.jsonFilesManager = new V9s8rJIDplX();
        initViews();
        setupSpinners();
        setupListeners();
        setupTextValidation();
        cargarCanales();
        completarQR();
        return this.rootView;
    }

    private void initViews() {
        try {
            this.textInputLayoutBody = (TextInputLayout) this.rootView.findViewById(R.id.textInputLayoutBody);
            this.txBody = (EditText) this.rootView.findViewById(R.id.txBody);
            this.inputLayoutTipoSource = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_tipo_source);
            this.spinnerTipoSource = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoSource);
            this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
            this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
            this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
            this.btnQR = (ImageButton) this.rootView.findViewById(R.id.btnQRScan);
        } catch (Exception e) {
            Log.e(TAG, "Error initViews: " + e.getMessage());
        }
    }

    private void setupSpinners() {
        try {
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo, android.R.layout.simple_list_item_1);
            this.adapterTipoBolsa = arrayAdapterCreateFromResource;
            arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jN13TOyLMX jn13toylmx = this.spBolsas;
            if (jn13toylmx != null) {
                jn13toylmx.setAdapter(this.adapterTipoBolsa);
                this.spBolsas.setOnItemClickListener(this.spClickBolsa);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error setupSpinners: " + e.getMessage());
        }
    }

    private void setupListeners() {
        ImageButton imageButton = this.btnQR;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cdINOtQ3iN.this.checkCameraPermissionAndScan();
                }
            });
        }
        Button button = this.btnAceptar;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    cdINOtQ3iN.this.submitForm();
                }
            });
        }
    }

    private void setupTextValidation() {
        EditText editText = this.txBody;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.3
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    cdINOtQ3iN.this.validarTextoEnTiempoReal(s.toString());
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validarTextoEnTiempoReal(String texto) {
        if (texto.isEmpty()) {
            this.txBody.setError(null);
            return;
        }
        if (texto.contains(" ")) {
            this.txBody.setError("El texto no puede contener espacios");
        } else if (!PATRON_TEXTO_VALIDO.matcher(texto).matches()) {
            this.txBody.setError("Solo se permiten letras y números (sin espacios ni caracteres especiales)");
        } else {
            this.txBody.setError(null);
        }
    }

    private boolean validarTexto(String texto) {
        if (texto.isEmpty()) {
            this.txBody.setError("Este campo es requerido");
            return false;
        }
        if (texto.contains(" ")) {
            this.txBody.setError("El texto no puede contener espacios");
            return false;
        }
        if (!PATRON_TEXTO_VALIDO.matcher(texto).matches()) {
            this.txBody.setError("Solo se permiten letras y números (sin caracteres especiales)");
            return false;
        }
        if (texto.length() > 12) {
            this.txBody.setError("Máximo 12 caracteres");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCameraPermissionAndScan() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") == 0) {
                iniciarEscaneoQR();
                return;
            } else {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
                return;
            }
        }
        iniciarEscaneoQR();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                iniciarEscaneoQR();
            } else {
                Toast.makeText(this.context, "Se necesita permiso de cámara para escanear QR", 1).show();
            }
        }
    }

    private void cargarCanales() {
        try {
            List<Canal> listLoadCanalesFromJSON = this.jsonFilesManager.loadCanalesFromJSON(this.context);
            this.listaCanales = listLoadCanalesFromJSON;
            if (listLoadCanalesFromJSON == null || listLoadCanalesFromJSON.isEmpty()) {
                Log.e(TAG, "No se encontraron canales");
                this.listaCanales = new ArrayList();
                Toast.makeText(this.context, "No hay canales disponibles", 0).show();
            } else {
                Collections.sort(this.listaCanales, new Comparator<Canal>() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.4
                    @Override // java.util.Comparator
                    public int compare(Canal c1, Canal c2) {
                        return Integer.compare(c1.getEsDePago(), c2.getEsDePago());
                    }
                });
            }
            configurarSpinnerCanales();
        } catch (Exception e) {
            Log.e(TAG, "Error cargando canales: " + e.getMessage());
            Toast.makeText(this.context, "Error al cargar canales", 0).show();
        }
    }

    private void configurarSpinnerCanales() {
        if (this.spinnerTipoSource == null) {
            return;
        }
        ArrayAdapter<Canal> arrayAdapter = new ArrayAdapter<Canal>(this.context, android.R.layout.simple_list_item_1, this.listaCanales) { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN.5
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Canal canal = (Canal) getItem(position);
                if (canal != null) {
                    view.setText(canal.getNombre());
                    view.setTextColor(canal.getEsDePago() == 1 ? ContextCompat.getColor(cdINOtQ3iN.this.context, R.color.rojo) : ContextCompat.getColor(cdINOtQ3iN.this.context, android.R.color.holo_blue_dark));
                }
                return view;
            }

            @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                Canal canal = (Canal) getItem(position);
                if (canal != null) {
                    view.setText(canal.getNombre() + " (ID: " + canal.getId() + ")");
                }
                return view;
            }
        };
        this.adapterCanales = arrayAdapter;
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoSource.setAdapter(this.adapterCanales);
        this.spinnerTipoSource.setOnItemClickListener(this.spClickCanal);
    }

    public void completarQR() {
        String qrdata;
        try {
            if (getArguments() != null && getArguments().containsKey("QRData") && (qrdata = getArguments().getString("QRData")) != null && qrdata.contains("VOTOMOVIL")) {
                procesarDatosQR(qrdata);
            }
        } catch (Exception ex) {
            Log.e(TAG, "Error en completarQR: " + ex.getMessage());
        }
    }

    private void procesarDatosQR(String qrDataString) {
        try {
            JSONObject qrJson = new JSONObject(qrDataString);
            String type = qrJson.optString("type", BuildConfig.FLAVOR);
            if (!"VOTOMOVIL".equals(type)) {
                Toast.makeText(this.context, "QR no válido para Voto Móvil", 0).show();
                return;
            }
            JSONObject data = qrJson.optJSONObject("data");
            if (data != null) {
                String nombreCanal = data.optString("canalId", BuildConfig.FLAVOR);
                String texto = data.optString("texto", BuildConfig.FLAVOR);
                if (nombreCanal.isEmpty()) {
                    Toast.makeText(this.context, "QR no contiene nombre de canal", 0).show();
                    return;
                }
                if (texto.isEmpty()) {
                    Toast.makeText(this.context, "QR no contiene texto a enviar", 0).show();
                    return;
                }
                boolean canalEncontrado = false;
                for (Canal canal : this.listaCanales) {
                    Log.d(TAG, "Comparando: QR nombre='" + nombreCanal + "' con Canal Nombre='" + canal.getNombre() + "'");
                    if (canal.getNombre().equalsIgnoreCase(nombreCanal)) {
                        seleccionarCanal(canal);
                        canalEncontrado = true;
                        Log.i(TAG, "Canal encontrado por nombre: " + canal.getNombre() + " (ID: " + canal.getId() + ")");
                        break;
                    }
                }
                if (!canalEncontrado) {
                    Log.e(TAG, "Canal no encontrado para nombre: " + nombreCanal);
                    for (Canal canal2 : this.listaCanales) {
                        if (canal2.getNombre().equalsIgnoreCase(nombreCanal)) {
                            seleccionarCanal(canal2);
                            canalEncontrado = true;
                            Log.i(TAG, "Canal encontrado por coincidencia parcial: " + canal2.getNombre());
                            break;
                        }
                    }
                    if (!canalEncontrado) {
                        Toast.makeText(this.context, "Canal '" + nombreCanal + "' no encontrado en la lista", 1).show();
                        StringBuilder nombresDisponibles = new StringBuilder("Canales disponibles: ");
                        Iterator<Canal> it = this.listaCanales.iterator();
                        while (it.hasNext()) {
                            nombresDisponibles.append(it.next().getNombre());
                            nombresDisponibles.append(", ");
                        }
                        Log.d(TAG, nombresDisponibles.toString());
                    }
                }
                EditText editText = this.txBody;
                if (editText != null) {
                    editText.setText(texto);
                }
                Log.i(TAG, "QR procesado correctamente: Canal Nombre='" + nombreCanal + "', Texto='" + texto + "'");
                return;
            }
            Toast.makeText(this.context, "QR no contiene datos válidos", 0).show();
        } catch (JSONException e) {
            Log.e(TAG, "Error parseando JSON del QR: " + e.getMessage());
            Toast.makeText(this.context, "Error: Formato JSON inválido", 0).show();
        } catch (Exception e2) {
            Log.e(TAG, "Error procesando QR: " + e2.getMessage());
            Toast.makeText(this.context, "Error procesando QR", 0).show();
        }
    }

    private void seleccionarCanal(Canal canal) {
        jN13TOyLMX jn13toylmx;
        int posicion = this.listaCanales.indexOf(canal);
        if (posicion >= 0 && (jn13toylmx = this.spinnerTipoSource) != null) {
            jn13toylmx.setText((CharSequence) canal.getNombre(), false);
            this.canalSeleccionado = canal;
            TextInputLayout textInputLayout = this.lyBolsas;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(canal.getEsDePago() == 1 ? 0 : 8);
                if (canal.getEsDePago() == 0) {
                    this.tipoBolsa = 0;
                }
            }
            Toast.makeText(this.context, "Canal seleccionado: " + canal.getNombre(), 0).show();
            Log.i(TAG, "Canal seleccionado en spinner: " + canal.getNombre() + " en posición: " + posicion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String msg;
        if (validarFormulario()) {
            String textoInput = this.txBody.getText().toString().trim();
            Canal canal = this.canalSeleccionado;
            String nombre = BuildConfig.FLAVOR;
            String idCanal = canal != null ? canal.getId() : BuildConfig.FLAVOR;
            String cadena = idCanal + "*" + textoInput + "*" + this.tipoBolsa;
            if (this.canalSeleccionado.getEsDePago() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("¿Desea realizar la operación en el canal: ");
                Canal canal2 = this.canalSeleccionado;
                if (canal2 != null) {
                    nombre = canal2.getNombre();
                }
                sb.append(nombre);
                sb.append(" con el texto: ");
                sb.append(textoInput);
                sb.append("? Este canal es de pago y genera un costo adicional.");
                msg = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("¿Desea realizar la operación en el canal: ");
                Canal canal3 = this.canalSeleccionado;
                if (canal3 != null) {
                    nombre = canal3.getNombre();
                }
                sb2.append(nombre);
                sb2.append(" con el texto: ");
                sb2.append(textoInput);
                sb2.append("?");
                msg = sb2.toString();
            }
            ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmNautaBanco);
            if (group != null) {
                FBsQzP3Zfj.actionCallUSSDBack454(this.context, "215", cadena, msg, group, getFragmentManager());
            }
        }
    }

    private boolean validarFormulario() {
        if (this.canalSeleccionado == null) {
            Toast.makeText(this.context, "Debe seleccionar un canal", 0).show();
            return false;
        }
        String texto = this.txBody.getText().toString().trim();
        if (!validarTexto(texto)) {
            return false;
        }
        if (this.canalSeleccionado.getEsDePago() != 1 || this.tipoBolsa != 0) {
            return true;
        }
        Toast.makeText(this.context, "Debe seleccionar una cuenta para el pago", 0).show();
        return false;
    }

    private void iniciarEscaneoQR() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Bundle args = new Bundle();
        args.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.VotoMovil);
        args.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
        OJ3XxacXOT qr = new OJ3XxacXOT();
        qr.setArguments(args);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerView, qr).addToBackStack(null).commit();
    }
}
