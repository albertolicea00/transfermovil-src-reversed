package cu.etecsa.transfermovil.banking.ui.metro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;

/**
 * Fragment for reprinting a Metropolitano/BFI bank card.
 * Extends YWo20QOWZz (base fragment with account + commission account selectors).
 * User selects municipio and sucursal (branch), plus source and commission accounts.
 * Sends USSD code "74" with payload "{moneda}*{cuentaOrigen}*{cuentaComision}*{municipio}*{sucursal}".
 * Loads municipio list for province code "23" (Havana) and BFI branch data.
 *
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.hqlegRdVXsu.WoIpvvMtRp
 * @fingerprint Metro/BFI card reprint fragment with municipio/sucursal selection (USSD 74)
 */
public class MetroReimprimirTarjetaFragment /* extends YWo20QOWZz */ {

    private Button btnAceptar;
    // public V9s8rJIDplX jsonFilesManager;  // JsonFilesManager — loads BFI branch data
    private TextInputLayout lyMunicipio;
    private TextInputLayout lySucursal;
    // public Municipio municipio;
    // public ArrayAdapter<Municipio> municipioArrayAdapter;
    // public List<Municipio> municipiosList;
    // private jN13TOyLMX spMunicipio;  // CustomAutoCompleteTextView
    // private jN13TOyLMX spSucursal;
    // public SucursalBancaria sucursal;
    // public ArrayAdapter<SucursalBancaria> sucursalArrayAdapter;
    // public List<SucursalBancaria> sucursalList;
    public TextView toolbar_title;
    public String tipoServicio = "0";

    // Inherited from YWo20QOWZz / QGQCqILT4b:
    // public View rootView;
    // public Context context;
    // public String monedaTarjeta, cuentaOrigen, cuentaOrigenComision;

    /* --- Municipio item click listener --- */
    // Sets selected municipio, clears sucursal, reloads sucursales
    // by cod_provincia + cod_municipio

    /* --- Sucursal item click listener --- */
    // Sets selected sucursal

    // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflates layout: R.layout.a5rb5s9yq70fr
        // rootView = inflater.inflate(R.layout.a5rb5s9yq70fr, container, false);
        // context = container.getContext();
        // unYp8VQThY.init(context);  // DatabaseHelper init

        // jsonFilesManager = new V9s8rJIDplX();
        // jsonFilesManager.loadData(context, R1sDOSqZ2z.BFI);  // BankType.BFI

        // lyMunicipio = rootView.findViewById(R.id.lyMunicipio);
        // spMunicipio = rootView.findViewById(R.id.spMunicipio);
        // lySucursal = rootView.findViewById(R.id.lySucursal);
        // spSucursal = rootView.findViewById(R.id.spSucursal);

        // toolbar_title = rootView.findViewById(R.id.toolbar_title);
        // toolbar_title.setText("Reimprimir Tarjeta");

        // initComponentesCuentas(rootView, BankType.BFI);
        // initComponentesCuentasComision(rootView, BankType.BFI);
        // loadMunicipio("23");  // Province code 23 = Havana

        // btnAceptar = rootView.findViewById(R.id.btn_aceptar);
        // btnAceptar.setOnClickListener(view -> submitForm());

        return null; // stub
    }

    /**
     * Validates accounts, commission account, municipio, and sucursal selections.
     * Builds USSD payload: "{monedaTarjeta}*{cuentaOrigen}*{cuentaOrigenComision}*{codMunicipio}*{codigoSucursal}"
     * Sends USSD code "74" with confirmation "¿Desea reimprimir su tarjeta?"
     */
    // @Override
    public void submitForm() {
        // super.submitForm();
        // if (!validateSelectionAccounts() || !validateSelectionAccountsComision()
        //         || !validateMunicipio() || !validateSucursal()) return;

        // String municipioCode = municipio.getCod_municipio();
        // String sucursalCode = sucursal.getCodigoSucursal();
        // nuevoDatos();

        // String cadena = monedaTarjeta + "*" + cuentaOrigen + "*" + cuentaOrigenComision
        //         + "*" + municipioCode + "*" + sucursalCode;
        // ViewGroup group = (ViewGroup) rootView.findViewById(R.id.frmView);
        // FBsQzP3Zfj.actionCallUSSDBack(context, "74", cadena,
        //         "¿Desea reimprimir su tarjeta?", group, getFragmentManager());
    }

    // @Override
    public void nuevoDatos() { /* no-op override */ }

    // @Override
    public void nuevoDatosComision() { /* no-op override */ }

    /**
     * Loads municipio list for the given province code from DatabaseHelper.
     * Populates spMunicipio adapter.
     */
    private boolean loadMunicipio(String codigoProvincia) {
        // List<Municipio> list = DatabaseHelper.getInstance().getAllMunipiosLists(codigoProvincia);
        // if (list == null || list.isEmpty()) return false;
        // municipiosList = list;
        // municipioArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
        // for (Municipio m : list) municipioArrayAdapter.add(m);
        // spMunicipio.setAdapter(municipioArrayAdapter);
        // spMunicipio.setOnItemClickListener(spClickMunicipio);
        return false; // stub
    }

    /**
     * Loads branch (sucursal) list for the given DPA code from JsonFilesManager.
     * Populates spSucursal adapter.
     */
    private boolean loadSucursales(String codigoDPA) {
        // List<SucursalBancaria> list = jsonFilesManager.getSucursalxDPA(codigoDPA, context);
        // if (list == null || list.isEmpty()) return false;
        // sucursalList = list;
        // sucursalArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line);
        // for (SucursalBancaria s : list) sucursalArrayAdapter.add(s);
        // spSucursal.setAdapter(sucursalArrayAdapter);
        // spSucursal.setOnItemClickListener(spClickSucursal);
        return false; // stub
    }

    /** Validates municipio selection. Error: "Seleccione el municipio" */
    private boolean validateMunicipio() {
        // if (spMunicipio.getText().toString().trim().isEmpty()) {
        //     lyMunicipio.setError("Seleccione el municipio");
        //     return false;
        // }
        return true; // stub
    }

    /** Validates sucursal selection. Error: "Seleccione la sucursal" */
    private boolean validateSucursal() {
        // if (spSucursal.getText().toString().trim().isEmpty()) {
        //     lySucursal.setError("Seleccione la sucursal");
        //     return false;
        // }
        return true; // stub
    }
}
