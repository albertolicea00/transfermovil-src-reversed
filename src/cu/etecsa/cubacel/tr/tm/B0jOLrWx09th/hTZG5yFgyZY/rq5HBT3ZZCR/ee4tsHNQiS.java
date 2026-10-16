package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ee4tsHNQiS extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoBolsa;
    public ImageButton btSearchAccount;
    private Button btnAceptar;
    public Context context;
    public List<String> facList;
    public List<Factura> facturasLists;
    private AutoCompleteTextView inputCuenta;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutMonto;
    private EditText inputMonto;
    private TextInputLayout lyBolsas;
    public View rootView;
    public jN13TOyLMX spBolsas;
    public SpinnerDialog spinnerDialog;
    public TextView toolbarTitle;
    public final CharSequence[] itemsOpcion = {"Pago Total", "Pago Parcial"};
    public boolean pagoTotal = false;
    public int tipoBolsa = 0;
    public ArrayList<String> items = new ArrayList<>();
    public jN13TOyLMX.OnItemClickListener spClickBolsa = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.7
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            ee4tsHNQiS.this.tipoBolsa = 2;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.uewjt2hhxiuur, container, false);
        this.context = container.getContext();
        TextView textView = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.toolbarTitle = textView;
        textView.setText(getString(R.string.title_pago_telefono_agente));
        this.inputLayoutMonto = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_monto);
        this.inputMonto = (EditText) this.rootView.findViewById(R.id.input_monto);
        this.inputLayoutMonto.setHint(getString(R.string.monto_moneda_de_factura));
        try {
            unYp8VQThY.init(this.context);
            this.facturasLists = unYp8VQThY.getInstance().getFacturasListsTipoCuenta(0);
            if (!getNumbersFijos().isEmpty()) {
                if (this.facturasLists == null) {
                    this.facturasLists = new ArrayList();
                }
                for (Factura f : getNumbersFijos()) {
                    this.facturasLists.add(f);
                }
            }
            this.facList = new ArrayList();
            for (Factura wl : this.facturasLists) {
                this.facList.add(wl.getFactura());
            }
        } catch (Exception e) {
        }
        this.inputLayoutCuenta = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cuenta);
        this.inputCuenta = (AutoCompleteTextView) this.rootView.findViewById(R.id.input_cuenta);
        this.inputLayoutCuenta.setHint(getString(R.string.hint_numero));
        this.inputCuenta.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ee4tsHNQiS.this.inputCuenta.showDropDown();
            }
        });
        if (getArguments() != null) {
            this.inputCuenta.setText(getArguments().get("factura").toString());
        }
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ee4tsHNQiS.this.submitForm();
            }
        });
        this.lyBolsas = (TextInputLayout) this.rootView.findViewById(R.id.lyBolsas);
        this.spBolsas = (jN13TOyLMX) this.rootView.findViewById(R.id.spBolsas);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.array_bolsa_tipo_solo_cup, android.R.layout.simple_list_item_1);
        this.adapterTipoBolsa = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spBolsas.setAdapter(this.adapterTipoBolsa);
        this.spBolsas.setOnItemClickListener(this.spClickBolsa);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<Factura> list = ee4tsHNQiS.this.facturasLists;
                if (list != null && list.size() > 0) {
                    ee4tsHNQiS.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(ee4tsHNQiS.this.context, "No hay elementos para mostrar", 0).show();
                }
            }
        });
        loadSearchSpinner();
        formVisibility(0);
        return this.rootView;
    }

    private void loadSearchSpinner() {
        String facura;
        try {
            List<Factura> list = this.facturasLists;
            if (list != null && list.size() > 0) {
                for (Factura uyh0pxs9m37in : this.facturasLists) {
                    uyh0pxs9m37in.getFactura();
                    try {
                        if (uyh0pxs9m37in.getId_client() > 0) {
                            Client client = unYp8VQThY.getInstance().getClientListWithId(uyh0pxs9m37in.getId_client());
                            facura = client.getName() + " " + uyh0pxs9m37in.getFactura();
                        } else {
                            facura = uyh0pxs9m37in.getFactura();
                        }
                    } catch (Exception e) {
                        facura = uyh0pxs9m37in.getFactura();
                    }
                    this.items.add(facura);
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.4
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    Factura cuenta = ee4tsHNQiS.this.facturasLists.get(position);
                    ee4tsHNQiS.this.inputCuenta.setText(cuenta.getFactura());
                }
            });
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
    }

    public List<Factura> getNumbersFijos() {
        unYp8VQThY.init(this.context);
        List<Factura> items = new ArrayList<>();
        List<TelfFijo> fijosLists = unYp8VQThY.getInstance().getAllFijoLists();
        for (TelfFijo c : fijosLists) {
            Client cl = unYp8VQThY.getInstance().getClientListWithId(c.getId_client());
            Factura fac = new Factura();
            String factura = c.getNumber();
            if (cl != null) {
                cl.getName();
                fac.setId_client(c.getId_client());
            }
            fac.setFactura(factura);
            fac.setCodFactura(factura);
            fac.setTipo_Factura(1);
            items.add(fac);
        }
        return items;
    }

    private void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setSingleChoiceItems(this.itemsOpcion, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ee4tsHNQiS.this.formVisibility(i);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    ee4tsHNQiS.this.getFragmentManager().popBackStack();
                } catch (Exception e) {
                    try {
                        ee4tsHNQiS.this.getChildFragmentManager().popBackStack();
                    } catch (Exception e2) {
                    }
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(true);
        alert.setCancelable(false);
        alert.show();
    }

    public void formVisibility(int opcion) {
        if (opcion != 0) {
            this.inputLayoutMonto.setEnabled(true);
            this.inputMonto.setEnabled(true);
            this.inputMonto.setVisibility(0);
            this.inputLayoutMonto.setVisibility(0);
            this.pagoTotal = false;
            return;
        }
        this.inputLayoutMonto.setEnabled(false);
        this.inputMonto.setEnabled(false);
        this.inputMonto.setVisibility(8);
        this.inputLayoutMonto.setVisibility(8);
        this.pagoTotal = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitForm() {
        String msg;
        if (!validateCuenta() || !validateMonto() || !validateSpBolsa()) {
            return;
        }
        nuevoDatos();
        String cuenta = this.inputCuenta.getText().toString().trim();
        String monto = "0";
        String msg2 = "¿Desea realizar el pago total de la factura telefónica: " + cuenta + " ?";
        if (this.pagoTotal) {
            msg = msg2;
        } else {
            monto = this.inputMonto.getText().toString().trim();
            String msg3 = "¿ Desea pagar la cuenta: " + cuenta + ", con el monto: " + monto + " CUP ?.";
            msg = msg3;
        }
        String cadena = cuenta + "*" + monto + "*0*" + this.tipoBolsa;
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.frmTelefono);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "3", cadena, msg, group, getFragmentManager());
    }

    private boolean validateCuenta() {
        if (this.inputCuenta.getText().toString().trim().isEmpty()) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.inputCuenta);
            return false;
        }
        if (this.inputCuenta.getText().toString().trim().length() != 8) {
            this.inputLayoutCuenta.setError(getString(R.string.err_msg_len_numero));
            requestFocus(this.inputCuenta);
            return false;
        }
        this.inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    public boolean validateSpBolsa() {
        if (this.spBolsas.getText().toString().trim().isEmpty()) {
            this.lyBolsas.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(this.spBolsas);
            return false;
        }
        this.lyBolsas.setErrorEnabled(false);
        return true;
    }

    private boolean validateMonto() {
        if (!this.pagoTotal) {
            if (this.inputMonto.getText().toString().trim().isEmpty()) {
                this.inputLayoutMonto.setError(getString(R.string.err_msg_empty_monto));
                requestFocus(this.inputMonto);
                return false;
            }
            this.inputLayoutMonto.setErrorEnabled(false);
            return true;
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public void nuevoDatos() {
        String edit_factura = this.inputCuenta.getText().toString();
        List<Factura> c_list = unYp8VQThY.getInstance().getFacturaListsWithFactura(edit_factura);
        if (c_list.size() == 0) {
            Factura c = new Factura();
            c.setFactura(edit_factura);
            c.setTipo_Factura(0);
            unYp8VQThY.getInstance().addFactura(c);
        }
        if (getActivity() instanceof IHVTCBmiLV) {
            ((IHVTCBmiLV) getActivity()).UpdateMenu();
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            ((S9ycHcoxAzy) getActivity()).UpdateMenu();
        }
    }
}
