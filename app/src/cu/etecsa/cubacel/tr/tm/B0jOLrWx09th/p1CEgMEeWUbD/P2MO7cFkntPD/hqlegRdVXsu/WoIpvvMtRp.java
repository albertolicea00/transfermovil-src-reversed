package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.YWo20QOWZz;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalBancaria;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WoIpvvMtRp extends YWo20QOWZz {
    private Button btnAceptar;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lySucursal;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spSucursal;
    public SucursalBancaria sucursal;
    public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    public List<SucursalBancaria> sucursalList;
    public TextView toolbar_title;
    public String tipoServicio = "0";
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.WoIpvvMtRp.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WoIpvvMtRp woIpvvMtRp = WoIpvvMtRp.this;
            woIpvvMtRp.municipio = woIpvvMtRp.municipioArrayAdapter.getItem(position);
            WoIpvvMtRp woIpvvMtRp2 = WoIpvvMtRp.this;
            woIpvvMtRp2.sucursal = null;
            woIpvvMtRp2.spSucursal.setText(BuildConfig.FLAVOR);
            WoIpvvMtRp.this.loadSucursales(WoIpvvMtRp.this.municipio.getCod_provincia() + WoIpvvMtRp.this.municipio.getCod_municipio());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.WoIpvvMtRp.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            WoIpvvMtRp woIpvvMtRp = WoIpvvMtRp.this;
            woIpvvMtRp.sucursal = woIpvvMtRp.sucursalArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.a5rb5s9yq70fr, container, false);
        Context context = container.getContext();
        this.context = context;
        unYp8VQThY.init(context);
        V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
        this.jsonFilesManager = v9s8rJIDplX;
        Context context2 = this.context;
        R1sDOSqZ2z r1sDOSqZ2z = R1sDOSqZ2z.BFI;
        v9s8rJIDplX.loadData(context2, r1sDOSqZ2z);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(R.id.spSucursal);
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbar_title = textView;
        textView.setText("Reimprimir Tarjeta");
        initComponentesCuentas(this.rootView, r1sDOSqZ2z);
        initComponentesCuentasComision(this.rootView, r1sDOSqZ2z);
        loadMunicipio("23");
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.WoIpvvMtRp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WoIpvvMtRp.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (!validateSelectionAccounts() || !validateSelectionAccountsComision() || !validateMunicipio() || !validateSucursal()) {
            return;
        }
        String municipioSeleccionado = this.municipio.getCod_municipio();
        String surcursalSeleccionado = this.sucursal.getCodigoSucursal();
        nuevoDatos();
        String cadena = this.monedaTarjeta + "*" + this.cuentaOrigen + "*" + this.cuentaOrigenComision + "*" + municipioSeleccionado + "*" + surcursalSeleccionado;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "74", cadena, "¿Desea reimprimir su tarjeta?", group, getFragmentManager());
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.YWo20QOWZz
    public void nuevoDatosComision() {
    }

    private boolean loadMunicipio(String codigo) {
        try {
            List<Municipio> list = unYp8VQThY.getInstance().getAllMunipiosLists(codigo);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.municipiosList = list;
            this.municipioArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (Municipio uyh0pxs9m37in : list) {
                this.municipioArrayAdapter.add(uyh0pxs9m37in);
            }
            this.municipioArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
            this.sucursalArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (SucursalBancaria uyh0pxs9m37in : list) {
                this.sucursalArrayAdapter.add(uyh0pxs9m37in);
            }
            this.sucursalArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
