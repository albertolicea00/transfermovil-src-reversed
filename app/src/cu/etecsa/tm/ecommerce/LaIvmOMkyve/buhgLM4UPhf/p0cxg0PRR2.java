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
import android.widget.Switch;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import cu.etecsa.tm.ecommerce.R;

/* JADX INFO: loaded from: classes.dex */
public class p0cxg0PRR2 extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public View.OnClickListener btClickCrear = new AnonymousClass2();
    public ImageView btClose;
    public Button btOk;
    public CardView cdUpdate;
    public Context context;
    public U1zgY8gPcNl datos;
    public boolean estado;
    public int id;
    public View rootView;
    public Switch swEstado;

    public static p0cxg0PRR2 newInstance(U1zgY8gPcNl request) {
        p0cxg0PRR2 frag = new p0cxg0PRR2();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", request);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fxicsjth7pqq0, container, false);
        Bundle arg = getArguments();
        this.datos = (U1zgY8gPcNl) arg.getSerializable("PAGO");
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.swEstado = (Switch) this.rootView.findViewById(R.id.swEstado);
        this.cdUpdate = (CardView) this.rootView.findViewById(R.id.cdUpdate);
        Button button = (Button) this.rootView.findViewById(R.id.btOk);
        this.btOk = button;
        button.setOnClickListener(this.btClickCrear);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.p0cxg0PRR2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                p0cxg0PRR2.this.dismiss();
            }
        });
        this.swEstado.setChecked(this.datos.isEstado());
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.p0cxg0PRR2$2, reason: invalid class name */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            p0cxg0PRR2.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.p0cxg0PRR2.2.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(p0cxg0PRR2.this.context).setTitle("Confirmar").setMessage("Confirme que desea actualizar el estado de la cuenta").setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.p0cxg0PRR2.2.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.p0cxg0PRR2.2.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            p0cxg0PRR2.this.crear();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void crear() {
        Intent returnIntent = new Intent();
        this.datos.setEstado(this.swEstado.isChecked());
        returnIntent.putExtra("PARAMETERS", this.datos);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
