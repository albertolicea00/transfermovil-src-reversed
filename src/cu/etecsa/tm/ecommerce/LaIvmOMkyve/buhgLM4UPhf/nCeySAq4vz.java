package cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class nCeySAq4vz extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public Button btActualizar;
    public ImageView btClose;
    public Button btEliminar;
    public Button btOk;
    public CardView cdUpdate;
    public Context context;
    public i6zxINJYbmQ datos;
    public TextInputLayout lyDescripcion;
    public OperTypeNegocioCRUD operTypeNegocioCRUD;
    public View rootView;
    public TextInputEditText txDescripcion;
    public View.OnClickListener btClickActualizar = new AnonymousClass2();
    public View.OnClickListener btClicEliminar = new AnonymousClass3();
    public View.OnClickListener btClickCrear = new AnonymousClass4();

    public enum OperTypeNegocioCRUD {
        UPDATE,
        DELETE,
        CREATE
    }

    public static nCeySAq4vz newInstance(i6zxINJYbmQ request) {
        nCeySAq4vz frag = new nCeySAq4vz();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", request);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.n7wvcjkmwiegf, container, false);
        Bundle arg = getArguments();
        this.datos = (i6zxINJYbmQ) arg.getSerializable("PAGO");
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatDescription() {
        if (this.txDescripcion.getText().toString().trim().isEmpty()) {
            this.lyDescripcion.setError("Este campo no puede ser vacío");
            requestFocus(this.txDescripcion);
            return false;
        }
        this.lyDescripcion.setErrorEnabled(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.operTypeNegocioCRUD = this.datos.operTypeNegocioCRUD;
        this.lyDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.lyDescripcion);
        this.txDescripcion = (TextInputEditText) this.rootView.findViewById(R.id.txDescripcion);
        this.cdUpdate = (CardView) this.rootView.findViewById(R.id.cdUpdate);
        Button button = (Button) this.rootView.findViewById(R.id.btOk);
        this.btOk = button;
        button.setOnClickListener(this.btClickCrear);
        Button button2 = (Button) this.rootView.findViewById(R.id.btActualizar);
        this.btActualizar = button2;
        button2.setOnClickListener(this.btClickActualizar);
        Button button3 = (Button) this.rootView.findViewById(R.id.btEliminar);
        this.btEliminar = button3;
        button3.setOnClickListener(this.btClicEliminar);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                nCeySAq4vz.this.dismiss();
            }
        });
        if (this.operTypeNegocioCRUD != OperTypeNegocioCRUD.CREATE) {
            this.txDescripcion.setText(this.datos.getDescripcion());
            this.cdUpdate.setVisibility(0);
            this.btOk.setVisibility(8);
        } else {
            this.btOk.setVisibility(0);
            this.cdUpdate.setVisibility(8);
        }
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_NEGOCIO)) {
            this.btOk.setVisibility(8);
            this.cdUpdate.setVisibility(8);
        }
    }

    public static nCeySAq4vz newInstance(String id) {
        nCeySAq4vz frag = new nCeySAq4vz();
        Bundle args = new Bundle();
        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz$2, reason: invalid class name */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!nCeySAq4vz.this.validatDescription()) {
                return;
            }
            nCeySAq4vz.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.2.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(nCeySAq4vz.this.context).setTitle("Confirmar").setMessage("Confirme que desea actualizar el negocio").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.2.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            nCeySAq4vz.this.actualizar();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void actualizar() {
        Intent returnIntent = new Intent();
        this.datos.descripcion = this.txDescripcion.getText().toString().trim();
        returnIntent.putExtra("PARAMETERS", this.datos);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz$3, reason: invalid class name */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            nCeySAq4vz.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.3.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(nCeySAq4vz.this.context).setTitle("Confirmar").setMessage("Confirme que desea eliminar el negocio").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.3.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            nCeySAq4vz.this.eliminar();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void eliminar() {
        Intent returnIntent = new Intent();
        i6zxINJYbmQ datosEliminar = new i6zxINJYbmQ();
        datosEliminar.setOperTypeNegocioCRUD(OperTypeNegocioCRUD.DELETE);
        datosEliminar.setId(this.datos.getId());
        returnIntent.putExtra("PARAMETERS", datosEliminar);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!nCeySAq4vz.this.validatDescription()) {
                return;
            }
            nCeySAq4vz.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.4.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(nCeySAq4vz.this.context).setTitle("Confirmar").setMessage("Confirme que desea crear el negocio").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.nCeySAq4vz.4.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            nCeySAq4vz.this.crear();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void crear() {
        Intent returnIntent = new Intent();
        i6zxINJYbmQ datosCrear = new i6zxINJYbmQ();
        datosCrear.setOperTypeNegocioCRUD(OperTypeNegocioCRUD.CREATE);
        datosCrear.setDescripcion(this.txDescripcion.getText().toString().trim());
        returnIntent.putExtra("PARAMETERS", datosCrear);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
