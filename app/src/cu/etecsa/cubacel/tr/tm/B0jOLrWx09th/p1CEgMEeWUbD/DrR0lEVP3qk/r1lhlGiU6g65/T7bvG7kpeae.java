package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65;

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
public class T7bvG7kpeae extends Fragment {
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
    public jN13TOyLMX.OnItemClickListener spClickProvincias = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            T7bvG7kpeae t7bvG7kpeae = T7bvG7kpeae.this;
            t7bvG7kpeae.provincia = t7bvG7kpeae.provinciasArrayAdapter.getItem(position);
            T7bvG7kpeae t7bvG7kpeae2 = T7bvG7kpeae.this;
            t7bvG7kpeae2.municipio = null;
            t7bvG7kpeae2.spMunicipio.setText(BuildConfig.FLAVOR);
            T7bvG7kpeae t7bvG7kpeae3 = T7bvG7kpeae.this;
            t7bvG7kpeae3.sucursal = null;
            t7bvG7kpeae3.spSucursal.setText(BuildConfig.FLAVOR);
            T7bvG7kpeae t7bvG7kpeae4 = T7bvG7kpeae.this;
            t7bvG7kpeae4.loadMunicipio(t7bvG7kpeae4.provincia.getCod_provincia());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            T7bvG7kpeae t7bvG7kpeae = T7bvG7kpeae.this;
            t7bvG7kpeae.municipio = t7bvG7kpeae.municipioArrayAdapter.getItem(position);
            T7bvG7kpeae t7bvG7kpeae2 = T7bvG7kpeae.this;
            t7bvG7kpeae2.sucursal = null;
            t7bvG7kpeae2.spSucursal.setText(BuildConfig.FLAVOR);
            if (!T7bvG7kpeae.this.loadSucursales(T7bvG7kpeae.this.municipio.getCod_provincia() + T7bvG7kpeae.this.municipio.getCod_municipio())) {
                Toast.makeText(T7bvG7kpeae.this.context, "No hay sucursales en el municipio seleccionado", 1).show();
                T7bvG7kpeae.this.sucursalArrayAdapter = new ArrayAdapter<>(T7bvG7kpeae.this.context, R.layout.simple_dropdown_item_1line);
                T7bvG7kpeae.this.sucursalArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                T7bvG7kpeae.this.spSucursal.setAdapter(T7bvG7kpeae.this.sucursalArrayAdapter);
                T7bvG7kpeae.this.spSucursal.setOnItemClickListener(T7bvG7kpeae.this.spSucursal);
                T7bvG7kpeae.this.sucursalArrayAdapter.notifyDataSetChanged();
            }
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            T7bvG7kpeae t7bvG7kpeae = T7bvG7kpeae.this;
            t7bvG7kpeae.sucursal = t7bvG7kpeae.sucursalArrayAdapter.getItem(position);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(cu.etecsa.cubacel.tr.tm.R.layout.qjaqwnuvvtujy, container, false);
        this.context = container.getContext();
        V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
        this.jsonFilesManager = v9s8rJIDplX;
        v9s8rJIDplX.loadData(this.context, R1sDOSqZ2z.BPA);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyProvincia);
        this.spProvincia = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.spSucursal);
        loadProvincias();
        Button button = (Button) this.rootView.findViewById(cu.etecsa.cubacel.tr.tm.R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                T7bvG7kpeae.this.submitForm();
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
