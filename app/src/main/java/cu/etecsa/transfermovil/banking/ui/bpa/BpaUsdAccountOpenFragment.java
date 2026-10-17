package cu.etecsa.transfermovil.banking.ui.bpa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.Municipio;
import cu.etecsa.transfermovil.data.entity.Provincia;
import cu.etecsa.transfermovil.data.entity.SucursalBancaria;
import cu.etecsa.transfermovil.data.json.JsonFilesManager;
import cu.etecsa.transfermovil.ui.widget.MaterialSpinner;
import cu.etecsa.transfermovil.ussd.UssdDispatcher;
import cu.etecsa.transfermovil.banking.BankType;

/**
 * BPA fragment for opening a USD account backed by MLC at a selected bank branch.
 * <p>
 * Presents cascading province → municipality → branch selectors, then sends
 * USSD code "76" with the selected branch code.
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae
 * @original_apk_version 1.260416
 */
public class BpaUsdAccountOpenFragment extends Fragment {

    private Button btnAceptar;
    public Context context;
    public JsonFilesManager jsonFilesManager;

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

    private MaterialSpinner spMunicipio;
    private MaterialSpinner spProvincia;
    private MaterialSpinner spSucursal;

    public SucursalBancaria sucursal;
    public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    public List<SucursalBancaria> sucursalList;

    /** Province selection listener — loads municipalities for the selected province. */
    public MaterialSpinner.OnItemClickListener spClickProvincias = new MaterialSpinner.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            provincia = provinciasArrayAdapter.getItem(position);
            municipio = null;
            spMunicipio.setText("");
            sucursal = null;
            spSucursal.setText("");
            loadMunicipio(provincia.getCod_provincia());
        }
    };

    /** Municipality selection listener — loads bank branches for the selected municipality. */
    public MaterialSpinner.OnItemClickListener spClickMunicipio = new MaterialSpinner.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            municipio = municipioArrayAdapter.getItem(position);
            sucursal = null;
            spSucursal.setText("");
            if (!loadSucursales(municipio.getCod_provincia() + municipio.getCod_municipio())) {
                Toast.makeText(context, "No hay sucursales en el municipio seleccionado", Toast.LENGTH_LONG).show();
                sucursalArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
                sucursalArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSucursal.setAdapter(sucursalArrayAdapter);
                spSucursal.setOnItemClickListener(spSucursal);
                sucursalArrayAdapter.notifyDataSetChanged();
            }
        }
    };

    /** Branch selection listener — stores the selected branch. */
    public MaterialSpinner.OnItemClickListener spClickSucursal = new MaterialSpinner.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            sucursal = sucursalArrayAdapter.getItem(position);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.qjaqwnuvvtujy, container, false);
        context = container.getContext();

        JsonFilesManager manager = new JsonFilesManager();
        jsonFilesManager = manager;
        manager.loadData(context, BankType.BPA);

        lyProvincia = (TextInputLayout) rootView.findViewById(R.id.lyProvincia);
        spProvincia = (MaterialSpinner) rootView.findViewById(R.id.spProvincia);
        lyMunicipio = (TextInputLayout) rootView.findViewById(R.id.lyMunicipio);
        spMunicipio = (MaterialSpinner) rootView.findViewById(R.id.spMunicipio);
        lySucursal = (TextInputLayout) rootView.findViewById(R.id.lySucursal);
        spSucursal = (MaterialSpinner) rootView.findViewById(R.id.spSucursal);

        loadProvincias();

        Button button = (Button) rootView.findViewById(R.id.btn_aceptar);
        btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        return rootView;
    }

    private void submitForm() {
        if (!validateMunicipio() || !validateSucursal()) {
            return;
        }
        String codigoMunicipio = provincia.getCod_provincia() + municipio.getCod_municipio();
        String sucursalSeleccionada = sucursal.getCodigoSucursal();
        ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmRegistroBanco);
        UssdDispatcher.actionCallUSSDBack(context, "76", sucursalSeleccionada,
                "¿Desea realizar la apertura de cuenta en USD con respaldo en MLC?",
                group, getFragmentManager());
    }

    private boolean loadProvincias() {
        try {
            List<Provincia> list = DatabaseHelper.getInstance().getAllProvinciasLists();
            if (list == null || list.size() <= 0) {
                return false;
            }
            provinciaList = list;
            provinciasArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
            for (Provincia p : list) {
                provinciasArrayAdapter.add(p);
            }
            provinciasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spProvincia.setAdapter(provinciasArrayAdapter);
            spProvincia.setOnItemClickListener(spClickProvincias);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loadMunicipio(String codigo) {
        try {
            List<Municipio> list = DatabaseHelper.getInstance().getAllMunipiosLists(codigo);
            if (list == null || list.size() <= 0) {
                return false;
            }
            municipiosList = list;
            municipioArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
            for (Municipio m : list) {
                municipioArrayAdapter.add(m);
            }
            municipioArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spMunicipio.setAdapter(municipioArrayAdapter);
            spMunicipio.setOnItemClickListener(spClickMunicipio);
            municipioArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loadSucursales(String codigo) {
        try {
            List<SucursalBancaria> list = jsonFilesManager.getSucursalxDPA(codigo, context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            sucursalList = list;
            sucursalArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
            for (SucursalBancaria s : list) {
                sucursalArrayAdapter.add(s);
            }
            sucursalArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spSucursal.setAdapter(sucursalArrayAdapter);
            spSucursal.setOnItemClickListener(spClickSucursal);
            sucursalArrayAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateMunicipio() {
        lyMunicipio.setErrorEnabled(false);
        if (spMunicipio.getText().toString().trim().isEmpty()) {
            lyMunicipio.setError("Seleccione el municipio");
            requestFocus(spMunicipio);
            return false;
        }
        lyMunicipio.setErrorEnabled(false);
        return true;
    }

    private boolean validateSucursal() {
        lySucursal.setErrorEnabled(false);
        if (spSucursal.getText().toString().trim().isEmpty()) {
            lySucursal.setError("Seleccione la sucursal");
            requestFocus(spSucursal);
            return false;
        }
        lySucursal.setErrorEnabled(false);
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
