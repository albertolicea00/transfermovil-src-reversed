package cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.V9CpxZJfIeK;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;

/* JADX INFO: loaded from: classes.dex */
public class isiTmFZ2lx extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public ImageView btClose;
    public Button btOk;
    public String codPago;
    public V9CpxZJfIeK communicator;
    public Context context;
    public RKxbomWW57 datos;
    public EditText edImporte;
    public String externalCode;
    public float importe;
    public TextInputLayout lyDescripcion;
    public FhtwnBtOAx result;
    public View rootView;
    public String source;
    public TextView txCodPago;
    public TextInputEditText txDescripcion;
    public TextView txDetalles;
    public TextView txImporte;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.zqtt86pxrqsdj, container, false);
        this.result = new FhtwnBtOAx();
        Bundle arg = getArguments();
        this.datos = (RKxbomWW57) arg.getSerializable("PAGO");
        return this.rootView;
    }

    public static isiTmFZ2lx newInstance(RKxbomWW57 datos) {
        isiTmFZ2lx frag = new isiTmFZ2lx();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", datos);
        frag.setArguments(args);
        return frag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof V9CpxZJfIeK) {
            this.communicator = (V9CpxZJfIeK) context;
        } else {
            this.communicator = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.txCodPago = (TextView) this.rootView.findViewById(R.id.txCodPago);
        this.txImporte = (TextView) this.rootView.findViewById(R.id.txImporte);
        this.txDetalles = (TextView) this.rootView.findViewById(R.id.txDetalles);
        this.txDescripcion = (TextInputEditText) this.rootView.findViewById(R.id.txDescripcion);
        this.btOk = (Button) this.rootView.findViewById(R.id.btOk);
        this.lyDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.lyDescripcion);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                isiTmFZ2lx.this.dismiss();
            }
        });
        EditText editText = (EditText) this.rootView.findViewById(R.id.edImporte);
        this.edImporte = editText;
        editText.requestFocus();
        this.btOk.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (isiTmFZ2lx.this.validateImporte() && isiTmFZ2lx.this.validateDetalles()) {
                    isiTmFZ2lx.this.goToParentForDev();
                }
            }
        });
        RKxbomWW57 rKxbomWW57 = this.datos;
        if (rKxbomWW57 != null) {
            this.txCodPago.setText(rKxbomWW57.getIdTercero());
            this.txImporte.setText(this.datos.getImoprte());
            this.txDetalles.setText(this.datos.getDetalles());
            this.importe = this.datos.getImporte();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToParentForDev() {
        FhtwnBtOAx.Pago pago = new FhtwnBtOAx.Pago();
        pago.setPayment_code(this.datos.idTercero);
        pago.setExternal_code(this.datos.externalCode);
        pago.setSource(Integer.valueOf(this.datos.source).intValue());
        this.result.setPago(pago);
        this.result.setDescription(this.txDescripcion.getText().toString().trim());
        this.result.setAmont(Float.valueOf(this.edImporte.getText().toString().trim()).floatValue());
        V9CpxZJfIeK v9CpxZJfIeK = this.communicator;
        if (v9CpxZJfIeK != null) {
            v9CpxZJfIeK.ejecutarDevolucion(this.result);
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("PAGO", this.result);
            getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        }
        dismiss();
    }

    public boolean validateImporte() {
        try {
            if (this.edImporte.getText().toString().length() == 0) {
                ShowMessageADialog("Importe", "El importe no puede ser vacío.");
                return false;
            }
            if (Float.valueOf(this.edImporte.getText().toString()).floatValue() > this.importe) {
                ShowMessageADialog("Importe", "El importe no puede ser mayor que el generado por la compra.");
                return false;
            }
            return true;
        } catch (Exception e) {
            ShowMessageADialog("Importe", "Error importe incorrecto.");
            return false;
        }
    }

    public boolean validateDetalles() {
        if (this.txDescripcion.getText().toString().length() == 0) {
            ShowMessageADialog("Detalles", "Inserte detalles de la devolución.");
            return false;
        }
        return true;
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx.3
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(isiTmFZ2lx.this.context).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }
}
