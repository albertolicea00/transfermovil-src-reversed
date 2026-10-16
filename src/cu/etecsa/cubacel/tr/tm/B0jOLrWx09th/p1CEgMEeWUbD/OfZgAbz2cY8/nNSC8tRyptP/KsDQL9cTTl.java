package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
public class KsDQL9cTTl extends Fragment {
    private Button btnAceptar;
    public Context context;
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
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            KsDQL9cTTl ksDQL9cTTl = KsDQL9cTTl.this;
            ksDQL9cTTl.provincia = ksDQL9cTTl.provinciasArrayAdapter.getItem(position);
            KsDQL9cTTl ksDQL9cTTl2 = KsDQL9cTTl.this;
            ksDQL9cTTl2.municipio = null;
            ksDQL9cTTl2.spMunicipio.setText(BuildConfig.FLAVOR);
            KsDQL9cTTl ksDQL9cTTl3 = KsDQL9cTTl.this;
            ksDQL9cTTl3.sucursal = null;
            ksDQL9cTTl3.spSucursal.setText(BuildConfig.FLAVOR);
            KsDQL9cTTl ksDQL9cTTl4 = KsDQL9cTTl.this;
            ksDQL9cTTl4.loadMunicipio(ksDQL9cTTl4.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            KsDQL9cTTl ksDQL9cTTl = KsDQL9cTTl.this;
            ksDQL9cTTl.municipio = ksDQL9cTTl.municipioArrayAdapter.getItem(position);
            KsDQL9cTTl ksDQL9cTTl2 = KsDQL9cTTl.this;
            ksDQL9cTTl2.sucursal = null;
            ksDQL9cTTl2.spSucursal.setText(BuildConfig.FLAVOR);
            if (!KsDQL9cTTl.this.loadSucursales(KsDQL9cTTl.this.municipio.getCod_provincia() + KsDQL9cTTl.this.municipio.getCod_municipio())) {
                Toast.makeText(KsDQL9cTTl.this.context, "No hay sucursales en el municipio seleccionado", 1).show();
                KsDQL9cTTl.this.sucursalArrayAdapter = new ArrayAdapter<>(KsDQL9cTTl.this.context, R.layout.simple_dropdown_item_1line);
                KsDQL9cTTl.this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                KsDQL9cTTl.this.spSucursal.setAdapter(KsDQL9cTTl.this.sucursalArrayAdapter);
                KsDQL9cTTl.this.spSucursal.setOnItemClickListener(KsDQL9cTTl.this.spSucursal);
                KsDQL9cTTl.this.sucursalArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            KsDQL9cTTl ksDQL9cTTl = KsDQL9cTTl.this;
            ksDQL9cTTl.sucursal = ksDQL9cTTl.sucursalArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.qjaqwnuvvtujy, container, false);
        this.context = container.getContext();
        V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
        this.jsonFilesManager = v9s8rJIDplX;
        v9s8rJIDplX.loadData(this.context, R1sDOSqZ2z.BANDEC);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spSucursal);
        loadProvincias();
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KsDQL9cTTl.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateMunicipio() || !validateSucursal()) {
            return;
        }
        String str = this.provincia.getCod_provincia() + this.municipio.getCod_municipio();
        String surcursalSeleccionado = this.sucursal.getCodigoSucursal();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "76", surcursalSeleccionado, "¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?", group, getFragmentManager());
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

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
