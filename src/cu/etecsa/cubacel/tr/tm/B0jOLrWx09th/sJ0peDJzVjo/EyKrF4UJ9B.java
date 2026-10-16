package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalBancaria;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EyKrF4UJ9B extends Fragment {
    public R1sDOSqZ2z agencia;
    public Button btnAceptar;
    public Context context;
    public TextInputLayout input__layout_ci;
    public AutoCompleteTextView input_ci;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lyProvincia;
    private TextInputLayout lySucursal;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public Provincia provincia;
    public List<Provincia> provinciaList;
    public ArrayAdapter<Provincia> provinciasArrayAdapter;
    public View rootView;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spProvincia;
    private jN13TOyLMX spSucursal;
    public SucursalBancaria sucursal;
    public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    public List<SucursalBancaria> sucursalList;
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            EyKrF4UJ9B eyKrF4UJ9B = EyKrF4UJ9B.this;
            eyKrF4UJ9B.provincia = eyKrF4UJ9B.provinciasArrayAdapter.getItem(position);
            EyKrF4UJ9B eyKrF4UJ9B2 = EyKrF4UJ9B.this;
            eyKrF4UJ9B2.municipio = null;
            eyKrF4UJ9B2.spMunicipio.setText(BuildConfig.FLAVOR);
            EyKrF4UJ9B eyKrF4UJ9B3 = EyKrF4UJ9B.this;
            eyKrF4UJ9B3.sucursal = null;
            eyKrF4UJ9B3.spSucursal.setText(BuildConfig.FLAVOR);
            EyKrF4UJ9B eyKrF4UJ9B4 = EyKrF4UJ9B.this;
            eyKrF4UJ9B4.loadMunicipio(eyKrF4UJ9B4.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            EyKrF4UJ9B eyKrF4UJ9B = EyKrF4UJ9B.this;
            eyKrF4UJ9B.municipio = eyKrF4UJ9B.municipioArrayAdapter.getItem(position);
            EyKrF4UJ9B eyKrF4UJ9B2 = EyKrF4UJ9B.this;
            eyKrF4UJ9B2.sucursal = null;
            eyKrF4UJ9B2.spSucursal.setText(BuildConfig.FLAVOR);
            if (!EyKrF4UJ9B.this.loadSucursales(EyKrF4UJ9B.this.municipio.getCod_provincia() + EyKrF4UJ9B.this.municipio.getCod_municipio())) {
                Toast.makeText(EyKrF4UJ9B.this.context, "No hay sucursales en el municipio seleccionado", 1).show();
                EyKrF4UJ9B.this.sucursalArrayAdapter = new ArrayAdapter<>(EyKrF4UJ9B.this.context, R.layout.simple_dropdown_item_1line);
                EyKrF4UJ9B.this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                EyKrF4UJ9B.this.spSucursal.setAdapter(EyKrF4UJ9B.this.sucursalArrayAdapter);
                EyKrF4UJ9B.this.spSucursal.setOnItemClickListener(EyKrF4UJ9B.this.spSucursal);
                EyKrF4UJ9B.this.sucursalArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            EyKrF4UJ9B eyKrF4UJ9B = EyKrF4UJ9B.this;
            eyKrF4UJ9B.sucursal = eyKrF4UJ9B.sucursalArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.o5fihbhozibrl, container, false);
        this.context = getContext();
        this.input__layout_ci = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.input__layout_ci);
        this.input_ci = (AutoCompleteTextView) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.input_ci);
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EyKrF4UJ9B.this.submitForm();
            }
        });
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spSucursal);
        if (getArguments() != null && getArguments().containsKey("R1sDOSqZ2z")) {
            this.agencia = (R1sDOSqZ2z) getArguments().getSerializable("R1sDOSqZ2z");
            V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
            this.jsonFilesManager = v9s8rJIDplX;
            v9s8rJIDplX.loadData(this.context, this.agencia);
            switch (AnonymousClass5.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                    loadProvincias();
                    break;
                case 3:
                    loadMunicipio("23");
                    this.lyProvincia.setVisibility(8);
                    break;
            }
        }
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
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
        String ci = this.input_ci.getText().toString().trim();
        if (!validateMunicipio() || !validateSucursal()) {
            return;
        }
        String surcursalSeleccionado = this.sucursal.getCodigoSucursal();
        String dpa = this.sucursal.getDpa();
        if (!validateCi(ci)) {
            return;
        }
        String msg = "Desea solicitar una apertura de cuenta fiscal para el CI: " + ci;
        String cadena = ci + "*" + dpa + "*" + surcursalSeleccionado;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.frmCuentaFiscal);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "5", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCi(String ci) {
        if (ci.isEmpty()) {
            this.input__layout_ci.setError(getString(cu.etecsa.cubacel.tr.tm.R.string.err_msg_empty_cuenta));
            requestFocus(this.input_ci);
            return false;
        }
        if (ci.length() != 11) {
            this.input__layout_ci.setError(getString(cu.etecsa.cubacel.tr.tm.R.string.err_msg_len_ci));
            requestFocus(this.input_ci);
            return false;
        }
        this.input__layout_ci.setErrorEnabled(false);
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private boolean loadProvincias() {
        try {
            List<Provincia> list = unYp8VQThY.getInstance().getAllProvinciasLists();
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.provinciaList = list;
            this.provinciasArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
            for (Provincia uyh0pxs9m37in : list) {
                this.provinciasArrayAdapter.add(uyh0pxs9m37in);
            }
            this.provinciasArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.spProvincia.setAdapter(this.provinciasArrayAdapter);
            this.spProvincia.setOnItemClickListener(this.spClickProvincias);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadMunicipio(String codigo) {
        try {
            List<Municipio> list = unYp8VQThY.getInstance().getAllMunipiosLists(codigo);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.municipiosList = list;
            this.municipioArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipioArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipioArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.spMunicipio.setAdapter(this.municipioArrayAdapter);
            this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
            this.municipioArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadSucursales(String codigo) {
        try {
            List<SucursalBancaria> list = this.jsonFilesManager.getSucursalxDPA(codigo, this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.sucursalList = list;
            this.sucursalArrayAdapter = new ArrayAdapter<>(this.context, R.layout.simple_dropdown_item_1line);
            for (SucursalBancaria uyh0pxs9m37in : list) {
                this.sucursalArrayAdapter.add(uyh0pxs9m37in);
            }
            this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.spSucursal.setAdapter(this.sucursalArrayAdapter);
            this.spSucursal.setOnItemClickListener(this.spClickSucursal);
            this.sucursalArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateMunicipio() {
        this.lyMunicipio.setErrorEnabled(false);
        if (this.spMunicipio.getText().toString().trim().isEmpty()) {
            this.lyMunicipio.setError("Seleccione el municipio");
            requestFocus(this.spMunicipio);
            return false;
        }
        this.lyMunicipio.setErrorEnabled(false);
        return true;
    }

    private boolean validateSucursal() {
        this.lySucursal.setErrorEnabled(false);
        if (this.spSucursal.getText().toString().trim().isEmpty()) {
            this.lySucursal.setError("Seleccione la sucursal");
            requestFocus(this.spSucursal);
            return false;
        }
        this.lySucursal.setErrorEnabled(false);
        return true;
    }
}
