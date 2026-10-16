package cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi;
import cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class O19Uv2NP7rT extends DialogFragment implements KFxuVD3dg2 {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public Button btFiltrar;
    public CheckBox ckAbortado;
    public CheckBox ckConfirmado;
    public CheckBox ckPendiente;
    public Context context;
    public ArrayAdapter<LWt69JQUoH> cuentasArrayAdapter;
    public HLAV6HkYgi cuentasPresenter;
    public DatePickerDialog fFindatePicker;
    public DatePickerDialog fIniciodatePicker;
    public String fechaFin;
    public String fechaInicio;
    public TextInputLayout lyCodBanco;
    public TextInputLayout lyCodPago;
    public TextInputLayout lyCodTM;
    public TextInputLayout lyCuentas;
    public TextInputLayout lyFechaFin;
    public TextInputLayout lyFechaInicio;
    public TextInputLayout lyMoneda;
    public TextInputLayout lyUser;
    public String moneda;
    public String numeroCuenta;
    public View rootView;
    public Hrke6IBHBA spCuentas;
    public Hrke6IBHBA spMoneda;
    public TextInputEditText txCodBanco;
    public TextInputEditText txCodPago;
    public TextInputEditText txCodTM;
    public TextInputEditText txFechaFin;
    public TextInputEditText txFechaInicio;
    public TextInputEditText txUser;
    public View.OnClickListener btFiltroClikc = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intent returnIntent = new Intent();
            FiltroResult filtro = O19Uv2NP7rT.this.new FiltroResult();
            String str = O19Uv2NP7rT.this.moneda;
            if (str != null && str.length() > 0) {
                filtro.setMoneda(O19Uv2NP7rT.this.moneda);
            }
            String str2 = O19Uv2NP7rT.this.numeroCuenta;
            if (str2 != null && str2.length() > 0) {
                filtro.setCuenta(O19Uv2NP7rT.this.numeroCuenta);
            }
            String str3 = O19Uv2NP7rT.this.fechaInicio;
            if (str3 != null && str3.length() > 0) {
                filtro.setFechaInicio(O19Uv2NP7rT.this.fechaInicio);
            }
            String str4 = O19Uv2NP7rT.this.fechaFin;
            if (str4 != null && str4.length() > 0) {
                filtro.setFechaFin(O19Uv2NP7rT.this.fechaFin);
            }
            if (!O19Uv2NP7rT.this.txCodPago.getText().toString().isEmpty() && O19Uv2NP7rT.this.txCodBanco.getText().length() > 0) {
                filtro.setCodigoPago(O19Uv2NP7rT.this.txCodPago.getText().toString());
            }
            if (!O19Uv2NP7rT.this.txCodBanco.getText().toString().isEmpty() && O19Uv2NP7rT.this.txCodBanco.getText().length() > 0) {
                filtro.setCodfigoBanco(O19Uv2NP7rT.this.txCodBanco.getText().toString());
            }
            if (!O19Uv2NP7rT.this.txCodTM.getText().toString().isEmpty() && O19Uv2NP7rT.this.txCodTM.getText().length() > 0) {
                filtro.setCodigoTM(O19Uv2NP7rT.this.txCodTM.getText().toString());
            }
            if (!O19Uv2NP7rT.this.txUser.getText().toString().isEmpty() && O19Uv2NP7rT.this.txUser.getText().length() > 0) {
                filtro.setUser(O19Uv2NP7rT.this.txUser.getText().toString().trim().toLowerCase());
            }
            if (O19Uv2NP7rT.this.ckPendiente.isChecked() || O19Uv2NP7rT.this.ckConfirmado.isChecked() || O19Uv2NP7rT.this.ckAbortado.isChecked()) {
                List<String> arrlist = new ArrayList<>();
                if (O19Uv2NP7rT.this.ckPendiente.isChecked()) {
                    arrlist.add("pending");
                }
                if (O19Uv2NP7rT.this.ckConfirmado.isChecked()) {
                    arrlist.add("confirmed");
                }
                if (O19Uv2NP7rT.this.ckAbortado.isChecked()) {
                    arrlist.add("aborted");
                }
                String[] listEstado = new String[arrlist.size()];
                for (int i = 0; i < arrlist.size(); i++) {
                    listEstado[i] = arrlist.get(i);
                }
                filtro.setEstados(listEstado);
            }
            returnIntent.putExtra("filtro", filtro);
            O19Uv2NP7rT.this.getTargetFragment().onActivityResult(O19Uv2NP7rT.this.getTargetRequestCode(), 1, returnIntent);
            O19Uv2NP7rT.this.dismiss();
        }
    };
    private Hrke6IBHBA.OnItemClickListener spClickMoneda = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.4
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    O19Uv2NP7rT.this.moneda = "CUP";
                    break;
                case 1:
                    O19Uv2NP7rT.this.moneda = "CUC";
                    break;
                case 2:
                    O19Uv2NP7rT.this.moneda = "USD";
                    break;
            }
        }
    };
    private Hrke6IBHBA.OnItemClickListener spClickMisCuentas = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.5
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            LWt69JQUoH item = O19Uv2NP7rT.this.cuentasArrayAdapter.getItem(position);
            O19Uv2NP7rT.this.numeroCuenta = item.getSource();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.aaswsidwyngwj, container, false);
        this.rootView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.lyCuentas = (TextInputLayout) this.rootView.findViewById(R.id.lyCuentas);
        this.lyCodPago = (TextInputLayout) this.rootView.findViewById(R.id.lyCodPago);
        this.lyCodTM = (TextInputLayout) this.rootView.findViewById(R.id.lyCodTM);
        this.lyCodBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyCodBanco);
        this.lyMoneda = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.lyFechaInicio = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaInicio);
        this.lyFechaFin = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaFin);
        this.lyUser = (TextInputLayout) this.rootView.findViewById(R.id.lyUser);
        this.txCodPago = (TextInputEditText) this.rootView.findViewById(R.id.txCodPago);
        this.txCodTM = (TextInputEditText) this.rootView.findViewById(R.id.txCodTM);
        this.txCodBanco = (TextInputEditText) this.rootView.findViewById(R.id.txCodBanco);
        this.txFechaInicio = (TextInputEditText) this.rootView.findViewById(R.id.txFechaInicio);
        fechaInicioConfig();
        this.txFechaFin = (TextInputEditText) this.rootView.findViewById(R.id.txFechaFin);
        fechaFinConfig();
        this.spCuentas = (Hrke6IBHBA) this.rootView.findViewById(R.id.spCuentas);
        this.spMoneda = (Hrke6IBHBA) this.rootView.findViewById(R.id.spMoneda);
        spMonedaConfig();
        this.txUser = (TextInputEditText) this.rootView.findViewById(R.id.txUser);
        this.ckConfirmado = (CheckBox) this.rootView.findViewById(R.id.ckConfirmado);
        this.ckPendiente = (CheckBox) this.rootView.findViewById(R.id.CkPendiente);
        this.ckAbortado = (CheckBox) this.rootView.findViewById(R.id.ckAbortado);
        HLAV6HkYgi hLAV6HkYgi = new HLAV6HkYgi(this, this.context);
        this.cuentasPresenter = hLAV6HkYgi;
        hLAV6HkYgi.getCuentas();
        Button button = (Button) this.rootView.findViewById(R.id.btFiltrar);
        this.btFiltrar = button;
        button.setOnClickListener(this.btFiltroClikc);
    }

    public static O19Uv2NP7rT newInstance(String id) {
        O19Uv2NP7rT frag = new O19Uv2NP7rT();
        Bundle args = new Bundle();
        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }

    private void spMonedaConfig() {
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMoneda.setAdapter(this.adapterTipoMoneda);
        this.spMoneda.setOnItemClickListener(this.spClickMoneda);
    }

    private void fechaInicioConfig() {
        this.txFechaInicio.setInputType(0);
        this.txFechaInicio.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                O19Uv2NP7rT.this.fIniciodatePicker = new DatePickerDialog(O19Uv2NP7rT.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.2.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        O19Uv2NP7rT.this.txFechaInicio.setText(year2 + "/" + mes + "/" + dia);
                        O19Uv2NP7rT.this.fechaInicio = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                O19Uv2NP7rT.this.fIniciodatePicker.show();
            }
        });
    }

    private void fechaFinConfig() {
        this.txFechaFin.setInputType(0);
        this.txFechaFin.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                O19Uv2NP7rT.this.fFindatePicker = new DatePickerDialog(O19Uv2NP7rT.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT.3.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        O19Uv2NP7rT.this.txFechaFin.setText(year2 + "/" + mes + "/" + dia);
                        O19Uv2NP7rT.this.fechaFin = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                O19Uv2NP7rT.this.fFindatePicker.show();
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, int code, String mensaje, sR8QMZUZBy response) {
        if (result.booleanValue()) {
            if (!fillCuentas(response.getItemsList())) {
                Toast.makeText(this.context, "Error cargando las cuentas", 1).show();
                return;
            }
            return;
        }
        Toast.makeText(this.context, mensaje, 1).show();
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, HLAV6HkYgi.OperTypeCuentas operTypeCuentas, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(int visibility) {
    }

    private boolean fillCuentas(List<LWt69JQUoH> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.cuentasArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
                    for (LWt69JQUoH item : list) {
                        this.cuentasArrayAdapter.add(item);
                    }
                    this.cuentasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spCuentas.setAdapter(this.cuentasArrayAdapter);
                    this.spCuentas.setOnItemClickListener(this.spClickMisCuentas);
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public class FiltroResult implements Serializable {
        public String[] estados;
        public String user;
        public String cuenta = null;
        public String codigoPago = null;
        public String codigoTM = null;
        public String codfigoBanco = null;
        public String moneda = null;
        public String fechaInicio = null;
        public String fechaFin = null;

        public FiltroResult() {
        }

        public String getCuenta() {
            return this.cuenta;
        }

        public String getCodigoPago() {
            return this.codigoPago;
        }

        public String getCodigoTM() {
            return this.codigoTM;
        }

        public String getCodfigoBanco() {
            return this.codfigoBanco;
        }

        public String[] getEstados() {
            return this.estados;
        }

        public String getMoneda() {
            return this.moneda;
        }

        public String getFechaInicio() {
            return this.fechaInicio;
        }

        public String getFechaFin() {
            return this.fechaFin;
        }

        public void setCuenta(String cuenta) {
            this.cuenta = cuenta;
        }

        public void setCodigoPago(String codigoPago) {
            this.codigoPago = codigoPago;
        }

        public void setCodigoTM(String codigoTM) {
            this.codigoTM = codigoTM;
        }

        public void setCodfigoBanco(String codfigoBanco) {
            this.codfigoBanco = codfigoBanco;
        }

        public void setEstados(String[] estados) {
            this.estados = estados;
        }

        public void setMoneda(String moneda) {
            this.moneda = moneda;
        }

        public void setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public void setFechaFin(String fechaFin) {
            this.fechaFin = fechaFin;
        }

        public String getUser() {
            return this.user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}
