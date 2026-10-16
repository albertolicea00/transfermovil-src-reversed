package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
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
public class sHCJZGMjak extends Fragment {
    private Button btnAceptar;
    public Context context;
    public V9s8rJIDplX jsonFilesManager;
    private TextInputLayout lyMunicipio;
    private TextInputLayout lySucursal;
    public Municipio municipio;
    public ArrayAdapter<Municipio> municipioArrayAdapter;
    public List<Municipio> municipiosList;
    public View rootView;
    public jN13TOyLMX.OnItemClickListener spClickMunicipio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.sHCJZGMjak.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            sHCJZGMjak shcjzgmjak = sHCJZGMjak.this;
            shcjzgmjak.municipio = shcjzgmjak.municipioArrayAdapter.getItem(position);
            sHCJZGMjak shcjzgmjak2 = sHCJZGMjak.this;
            shcjzgmjak2.sucursal = null;
            shcjzgmjak2.spSucursal.setText(BuildConfig.FLAVOR);
            sHCJZGMjak.this.loadSucursales(sHCJZGMjak.this.municipio.getCod_provincia() + sHCJZGMjak.this.municipio.getCod_municipio());
        }
    };
    public jN13TOyLMX.OnItemClickListener spClickSucursal = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.sHCJZGMjak.3
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            sHCJZGMjak shcjzgmjak = sHCJZGMjak.this;
            shcjzgmjak.sucursal = shcjzgmjak.sucursalArrayAdapter.getItem(position);
        }
    };
    private jN13TOyLMX spMunicipio;
    private jN13TOyLMX spSucursal;
    public SucursalBancaria sucursal;
    public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    public List<SucursalBancaria> sucursalList;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.h1rxcsbgovtfh, container, false);
        this.context = container.getContext();
        V9s8rJIDplX v9s8rJIDplX = new V9s8rJIDplX();
        this.jsonFilesManager = v9s8rJIDplX;
        v9s8rJIDplX.loadData(this.context, R1sDOSqZ2z.BFI);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.spMunicipio = (jN13TOyLMX) this.rootView.findViewById(R.id.spMunicipio);
        this.lySucursal = (TextInputLayout) this.rootView.findViewById(R.id.lySucursal);
        this.spSucursal = (jN13TOyLMX) this.rootView.findViewById(R.id.spSucursal);
        loadMunicipio("23");
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.sHCJZGMjak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sHCJZGMjak.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        if (!validateMunicipio() || !validateSucursal()) {
            return;
        }
        String municipioSeleccionado = this.municipio.getCod_municipio();
        String surcursalSeleccionado = this.sucursal.getCodigoSucursal();
        String cadena = municipioSeleccionado + "*" + surcursalSeleccionado;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmRegistroBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "76", cadena, "¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?", group, getFragmentManager());
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

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
