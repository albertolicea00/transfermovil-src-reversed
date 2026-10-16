package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.whiteelephant.monthpicker.MonthPickerDialog;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.qHxc7HcCDX;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ObligacionesOFA;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ILoKZQnPEb extends qHxc7HcCDX {
    public Button btnAceptar;
    public String fecha;
    public TextInputLayout lyCarnet;
    public TextInputLayout lyCodigo;
    public TextInputLayout lyContribuyente;
    public TextInputLayout lyMonto;
    public TextInputLayout lyObligacion;
    public TextInputLayout lyPeriodo;
    public ObligacionesOFA obligacion;
    public ArrayAdapter<ObligacionesOFA> obligacionesArrayAdapter;
    public List<ObligacionesOFA> obligacionesList;
    private jN13TOyLMX spObligaciones;
    public AutoCompleteTextView txCarnet;
    public AutoCompleteTextView txContribuyente;
    public AutoCompleteTextView txMonto;
    public TextInputEditText txPeriodo;
    public jN13TOyLMX.OnItemClickListener spObligacionesOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ILoKZQnPEb iLoKZQnPEb = ILoKZQnPEb.this;
            iLoKZQnPEb.obligacion = iLoKZQnPEb.obligacionesArrayAdapter.getItem(position);
        }
    };
    private View.OnClickListener btnAceptarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ILoKZQnPEb.this.submitForm();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.xl8jjdom815ro, container, false);
        this.context = container.getContext();
        loadViewUI(this.rootView);
        return this.rootView;
    }

    public void loadViewUI(View v) {
        this.lyObligacion = (TextInputLayout) v.findViewById(R.id.lyObligaciones);
        this.spObligaciones = (jN13TOyLMX) this.rootView.findViewById(R.id.spObligaciones);
        loadObligaciones();
        this.lyCarnet = (TextInputLayout) v.findViewById(R.id.lyCarnet);
        this.txCarnet = (AutoCompleteTextView) v.findViewById(R.id.txCarnet);
        this.lyContribuyente = (TextInputLayout) v.findViewById(R.id.lyContribuyente);
        this.txContribuyente = (AutoCompleteTextView) v.findViewById(R.id.txContribuyente);
        this.lyCodigo = (TextInputLayout) v.findViewById(R.id.lyCodigo);
        this.lyPeriodo = (TextInputLayout) v.findViewById(R.id.lyPeriodo);
        TextInputEditText textInputEditText = (TextInputEditText) v.findViewById(R.id.txPeriodo);
        this.txPeriodo = textInputEditText;
        textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                ILoKZQnPEb.this.initMonthPicker();
            }
        });
        this.lyMonto = (TextInputLayout) v.findViewById(R.id.lyMonto);
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        this.txMonto = (AutoCompleteTextView) v.findViewById(R.id.txMonto);
        Button button = (Button) v.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(this.btnAceptarOnClick);
        initComponentesCuentas(this.rootView, R1sDOSqZ2z.BFI);
        initParent();
    }

    private void enviarUSSD() {
        String carnet = this.txCarnet.getText().toString().trim();
        String contribuyente = this.txContribuyente.getText().toString().trim();
        String codigo = this.txCodigo.getText().toString().trim();
        String importe = this.txMonto.getText().toString().trim();
        String cadena = carnet + "*" + contribuyente + "*" + codigo + "*" + this.fecha + "*" + importe + "*" + this.obligacion.getCode() + "*" + this.monedaTarjeta + "*" + this.cuentaOrigen;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmBanco);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "94", cadena, "¿Desea realizar el pago? ", group, getFragmentManager());
    }

    private boolean loadObligaciones() {
        try {
            this.obligacionesList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<ObligacionesOFA> list = jsonFilesManager.loadDataObligaciones(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.obligacionesArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (ObligacionesOFA uyh0pxs9m37in : list) {
                this.obligacionesArrayAdapter.add(uyh0pxs9m37in);
                this.obligacionesList.add(uyh0pxs9m37in);
            }
            this.obligacionesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spObligaciones.setAdapter(this.obligacionesArrayAdapter);
            this.spObligaciones.setOnItemClickListener(this.spObligacionesOnClickListener);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateObligaciones() {
        this.lyObligacion.setErrorEnabled(false);
        if (this.spObligaciones.getText().toString().trim().isEmpty() || this.obligacion == null) {
            this.lyObligacion.setError("Seleccione la obligación de pago");
            requestFocus(this.spObligaciones);
            return false;
        }
        this.lyObligacion.setErrorEnabled(false);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void submitForm() {
        super.submitForm();
        if (isFieldsOK()) {
            try {
                enviarUSSD();
            } catch (Exception e) {
            }
        }
    }

    private boolean isFieldsOK() {
        return validateObligaciones() && validateCI() && validateCI() && validateContribuyente() && validateCodigo() && validatePeriodo() && validateMonto() && validateSelectionAccounts();
    }

    private boolean validateCI() {
        if (this.txCarnet.getText().toString().trim().isEmpty()) {
            this.lyCarnet.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCarnet);
            return false;
        }
        this.lyCarnet.setErrorEnabled(false);
        return true;
    }

    private boolean validateContribuyente() {
        if (this.txContribuyente.getText().toString().trim().isEmpty()) {
            this.lyContribuyente.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txContribuyente);
            return false;
        }
        this.lyContribuyente.setErrorEnabled(false);
        return true;
    }

    private boolean validateCodigo() {
        if (this.txCodigo.getText().toString().trim().isEmpty()) {
            this.lyCodigo.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.txCodigo);
            return false;
        }
        this.lyCodigo.setErrorEnabled(false);
        return true;
    }

    private boolean validatePeriodo() {
        this.lyPeriodo.setErrorEnabled(false);
        if (this.txPeriodo.getText().toString().trim().isEmpty()) {
            this.lyPeriodo.setError("Seleccione el período");
            requestFocus(this.txPeriodo);
            return false;
        }
        if (this.fecha == null) {
            this.lyPeriodo.setError("Seleccione el período");
            requestFocus(this.txPeriodo);
            return false;
        }
        this.lyPeriodo.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (this.txMonto.getText().toString().trim().isEmpty()) {
            this.lyMonto.setError(getString(R.string.err_msg_empty_monto));
            requestFocus(this.txMonto);
            return false;
        }
        try {
            Float.parseFloat(this.txMonto.getText().toString().trim());
            this.lyMonto.setErrorEnabled(false);
            return true;
        } catch (Exception e) {
            this.lyMonto.setError("Monto incorrecto");
            requestFocus(this.txMonto);
            return false;
        }
    }

    public void initMonthPicker() {
        Calendar today = Calendar.getInstance();
        int annoMenos = today.get(1) - 6;
        int annoMax = today.get(1) + 20;
        MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(this.context, new MonthPickerDialog.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.4
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnDateSetListener
            public void onDateSet(int selectedMonth, int selectedYear) {
                String mes;
                if (String.valueOf(selectedMonth + 1).length() > 1) {
                    mes = String.valueOf(selectedMonth + 1);
                } else {
                    mes = "0" + String.valueOf(selectedMonth + 1);
                }
                ILoKZQnPEb.this.txPeriodo.setText(mes + "/" + selectedYear);
                ILoKZQnPEb.this.fecha = mes + "/" + selectedYear;
            }
        }, today.get(1), today.get(2));
        builder.setActivatedMonth(today.get(2)).setMinYear(annoMenos).setActivatedYear(today.get(1)).setMaxYear(annoMax).setTitle("Seleccione el período").setOnMonthChangedListener(new MonthPickerDialog.OnMonthChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.6
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnMonthChangedListener
            public void onMonthChanged(int selectedMonth) {
            }
        }).setOnYearChangedListener(new MonthPickerDialog.OnYearChangedListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb.5
            @Override // com.whiteelephant.monthpicker.MonthPickerDialog.OnYearChangedListener
            public void onYearChanged(int selectedYear) {
            }
        }).build().show();
    }

    @Override // cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b
    public void nuevoDatos() {
    }
}
