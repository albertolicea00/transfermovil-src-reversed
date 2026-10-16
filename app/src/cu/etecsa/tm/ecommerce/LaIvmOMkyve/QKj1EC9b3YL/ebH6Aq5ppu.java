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
public class ebH6Aq5ppu extends DialogFragment implements KFxuVD3dg2 {
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
    public TextInputLayout lyDevBanco;
    public TextInputLayout lyDevExt;
    public TextInputLayout lyDevTM;
    public TextInputLayout lyFechaFin;
    public TextInputLayout lyFechaInicio;
    public TextInputLayout lyMoneda;
    public String moneda;
    public String numeroCuenta;
    public View rootView;
    public Hrke6IBHBA spCuentas;
    public Hrke6IBHBA spMoneda;
    public TextInputEditText txCodBanco;
    public TextInputEditText txCodPago;
    public TextInputEditText txCodTM;
    public TextInputEditText txDevBanco;
    public TextInputEditText txDevExt;
    public TextInputEditText txDevTM;
    public TextInputEditText txFechaFin;
    public TextInputEditText txFechaInicio;
    public View.OnClickListener btFiltroClikc = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intent returnIntent = new Intent();
            FiltroResult filtro = ebH6Aq5ppu.this.new FiltroResult();
            String str = ebH6Aq5ppu.this.moneda;
            if (str != null && str.length() > 0) {
                filtro.setMoneda(ebH6Aq5ppu.this.moneda);
            }
            String str2 = ebH6Aq5ppu.this.numeroCuenta;
            if (str2 != null && str2.length() > 0) {
                filtro.setCuenta(ebH6Aq5ppu.this.numeroCuenta);
            }
            String str3 = ebH6Aq5ppu.this.fechaInicio;
            if (str3 != null && str3.length() > 0) {
                filtro.setFechaInicio(ebH6Aq5ppu.this.fechaInicio);
            }
            String str4 = ebH6Aq5ppu.this.fechaFin;
            if (str4 != null && str4.length() > 0) {
                filtro.setFechaFin(ebH6Aq5ppu.this.fechaFin);
            }
            if (!ebH6Aq5ppu.this.txCodPago.getText().toString().isEmpty() && ebH6Aq5ppu.this.txCodBanco.getText().length() > 0) {
                filtro.setCodigoPago(ebH6Aq5ppu.this.txCodPago.getText().toString());
            }
            if (!ebH6Aq5ppu.this.txCodBanco.getText().toString().isEmpty() && ebH6Aq5ppu.this.txCodBanco.getText().length() > 0) {
                filtro.setCodfigoBanco(ebH6Aq5ppu.this.txCodBanco.getText().toString());
            }
            if (!ebH6Aq5ppu.this.txCodTM.getText().toString().isEmpty() && ebH6Aq5ppu.this.txCodTM.getText().length() > 0) {
                filtro.setCodigoTM(ebH6Aq5ppu.this.txCodTM.getText().toString());
            }
            if (!ebH6Aq5ppu.this.txDevExt.getText().toString().isEmpty() && ebH6Aq5ppu.this.txDevExt.getText().length() > 0) {
                filtro.setDevCodigoPago(ebH6Aq5ppu.this.txDevExt.getText().toString());
            }
            if (!ebH6Aq5ppu.this.txDevBanco.getText().toString().isEmpty() && ebH6Aq5ppu.this.txDevBanco.getText().length() > 0) {
                filtro.setDevCodigoBanco(ebH6Aq5ppu.this.txDevBanco.getText().toString());
            }
            if (!ebH6Aq5ppu.this.txDevTM.getText().toString().isEmpty() && ebH6Aq5ppu.this.txDevTM.getText().length() > 0) {
                filtro.setDevCodigoTM(ebH6Aq5ppu.this.txDevTM.getText().toString());
            }
            if (ebH6Aq5ppu.this.ckPendiente.isChecked() || ebH6Aq5ppu.this.ckConfirmado.isChecked() || ebH6Aq5ppu.this.ckAbortado.isChecked()) {
                List<String> arrlist = new ArrayList<>();
                if (ebH6Aq5ppu.this.ckPendiente.isChecked()) {
                    arrlist.add("refound_pending");
                }
                if (ebH6Aq5ppu.this.ckConfirmado.isChecked()) {
                    arrlist.add("refounded");
                }
                if (ebH6Aq5ppu.this.ckAbortado.isChecked()) {
                    arrlist.add("canceled");
                }
                String[] listEstado = new String[arrlist.size()];
                for (int i = 0; i < arrlist.size(); i++) {
                    listEstado[i] = arrlist.get(i);
                }
                filtro.setEstados(listEstado);
            }
            returnIntent.putExtra("filtro", filtro);
            ebH6Aq5ppu.this.getTargetFragment().onActivityResult(ebH6Aq5ppu.this.getTargetRequestCode(), 1, returnIntent);
            ebH6Aq5ppu.this.dismiss();
        }
    };
    private Hrke6IBHBA.OnItemClickListener spClickMoneda = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.4
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (position) {
                case 0:
                    ebH6Aq5ppu.this.moneda = "CUP";
                    break;
                case 1:
                    ebH6Aq5ppu.this.moneda = "CUC";
                    break;
                case 2:
                    ebH6Aq5ppu.this.moneda = "USD";
                    break;
            }
        }
    };
    private Hrke6IBHBA.OnItemClickListener spClickMisCuentas = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.5
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            LWt69JQUoH item = ebH6Aq5ppu.this.cuentasArrayAdapter.getItem(position);
            ebH6Aq5ppu.this.numeroCuenta = item.getSource();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.btibns0wscekg, container, false);
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
        this.lyDevExt = (TextInputLayout) this.rootView.findViewById(R.id.lyDevExt);
        this.lyDevTM = (TextInputLayout) this.rootView.findViewById(R.id.lyDevTM);
        this.lyDevBanco = (TextInputLayout) this.rootView.findViewById(R.id.lyDevBanco);
        this.txCodPago = (TextInputEditText) this.rootView.findViewById(R.id.txCodPago);
        this.txCodTM = (TextInputEditText) this.rootView.findViewById(R.id.txCodTM);
        this.txCodBanco = (TextInputEditText) this.rootView.findViewById(R.id.txCodBanco);
        this.txDevExt = (TextInputEditText) this.rootView.findViewById(R.id.txDevExt);
        this.txDevTM = (TextInputEditText) this.rootView.findViewById(R.id.txDevTM);
        this.txDevBanco = (TextInputEditText) this.rootView.findViewById(R.id.txDevBanco);
        this.txFechaInicio = (TextInputEditText) this.rootView.findViewById(R.id.txFechaInicio);
        fechaInicioConfig();
        this.txFechaFin = (TextInputEditText) this.rootView.findViewById(R.id.txFechaFin);
        fechaFinConfig();
        this.spCuentas = (Hrke6IBHBA) this.rootView.findViewById(R.id.spCuentas);
        this.spMoneda = (Hrke6IBHBA) this.rootView.findViewById(R.id.spMoneda);
        spMonedaConfig();
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

    public static ebH6Aq5ppu newInstance(String id) {
        ebH6Aq5ppu frag = new ebH6Aq5ppu();
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
        this.txFechaInicio.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                ebH6Aq5ppu.this.fIniciodatePicker = new DatePickerDialog(ebH6Aq5ppu.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.2.1
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
                        ebH6Aq5ppu.this.txFechaInicio.setText(year2 + "/" + mes + "/" + dia);
                        ebH6Aq5ppu.this.fechaInicio = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                ebH6Aq5ppu.this.fIniciodatePicker.show();
            }
        });
    }

    private void fechaFinConfig() {
        this.txFechaFin.setInputType(0);
        this.txFechaFin.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                ebH6Aq5ppu.this.fFindatePicker = new DatePickerDialog(ebH6Aq5ppu.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu.3.1
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
                        ebH6Aq5ppu.this.txFechaFin.setText(year2 + "/" + mes + "/" + dia);
                        ebH6Aq5ppu.this.fechaFin = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                ebH6Aq5ppu.this.fFindatePicker.show();
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
        public String devCodigoBanco;
        public String devCodigoPago;
        public String devCodigoTM;
        public String[] estados;
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

        public String getDevCodigoPago() {
            return this.devCodigoPago;
        }

        public void setDevCodigoPago(String devCodigoPago) {
            this.devCodigoPago = devCodigoPago;
        }

        public String getDevCodigoTM() {
            return this.devCodigoTM;
        }

        public void setDevCodigoTM(String devCodigoTM) {
            this.devCodigoTM = devCodigoTM;
        }

        public String getDevCodigoBanco() {
            return this.devCodigoBanco;
        }

        public void setDevCodigoBanco(String devCodigoBanco) {
            this.devCodigoBanco = devCodigoBanco;
        }
    }
}
