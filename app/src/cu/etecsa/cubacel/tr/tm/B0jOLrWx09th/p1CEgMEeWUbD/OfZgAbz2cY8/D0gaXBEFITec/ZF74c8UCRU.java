package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/* JADX INFO: loaded from: classes.dex */
public class ZF74c8UCRU extends Agg55uYctq {
    public ArrayAdapter<CharSequence> adapterTipoServicio;
    private Button btnAceptar;
    public TextInputLayout inputLayoutTipoServicio;
    private jN13TOyLMX.OnItemClickListener spClickTipoServicio = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.ZF74c8UCRU.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ZF74c8UCRU.this.tipoServicio = position + 1;
        }
    };
    public jN13TOyLMX spinnerTipoServicio;
    public int tipoServicio;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.f4fzds2usmi6a, container, false);
        Context context = container.getContext();
        this.context = context;
        this.manager = new pAzq93vIl3(context, this);
        unYp8VQThY.init(this.context);
        this.inputLayoutTipoServicio = (TextInputLayout) this.rootView.findViewById(R.id.inputLayoutTipoServicio);
        this.spinnerTipoServicio = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerTipoServicio);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_ultimos_pagos_bandec, android.R.layout.simple_list_item_1);
        this.adapterTipoServicio = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerTipoServicio.setAdapter(this.adapterTipoServicio);
        this.spinnerTipoServicio.setOnItemClickListener(this.spClickTipoServicio);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BANDEC);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.D0gaXBEFITec.ZF74c8UCRU.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ZF74c8UCRU.this.submitForm();
            }
        });
        return this.rootView;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void submitForm() {
        String cadena;
        super.submitForm();
        if (!validateTipoServicio() || !validateSelectionAccounts()) {
            return;
        }
        nuevoDatos();
        String cadena2 = String.valueOf(this.tipoServicio);
        if (!this.swCuentasBanco.isChecked()) {
            cadena = cadena2;
        } else {
            String cadena3 = String.valueOf(this.tipoServicio) + "*" + this.cuentaOrigen;
            cadena = cadena3;
        }
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmView);
        if (!this.isPartialUSSD) {
            FBsQzP3Zfj.actionCallUSSDBack(this.context, "63", cadena, "Confirme que desea realizar la consulta de últimos pagos", group, getFragmentManager());
        } else {
            this.manager.principalEnviarUSSD(this.context, "110", "63", "02", this.MAX_PARAMETERS_PQUETE, cadena, "Confirme que desea realizar la consulta de últimos pagos", group, getFragmentManager());
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.Agg55uYctq
    public void nuevoDatos() {
    }

    private boolean validateTipoServicio() {
        if (this.spinnerTipoServicio.getText().toString().trim().isEmpty()) {
            this.inputLayoutTipoServicio.setError("Seleccione el tipo de servicio");
            requestFocus(this.spinnerTipoServicio);
            return false;
        }
        this.inputLayoutTipoServicio.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
