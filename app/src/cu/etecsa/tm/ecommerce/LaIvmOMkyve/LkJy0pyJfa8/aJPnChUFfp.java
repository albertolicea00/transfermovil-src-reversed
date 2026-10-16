package cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8;

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

/* JADX INFO: loaded from: classes.dex */
public class aJPnChUFfp extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public View.OnClickListener btClickActualizar = new AnonymousClass2();
    public ImageView btClose;
    public Button btOk;
    public CardView cdUpdate;
    public Context context;
    public NnwdA7ink5 datos;
    public TextInputLayout lyNewPass;
    public TextInputLayout lyOldPass;
    public TextInputLayout lyRepNewPass;
    public View rootView;
    public TextInputEditText txNewPass;
    public TextInputEditText txOldPass;
    public TextInputEditText txRepNewPass;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.nkf2o1hjtyz7c, container, false);
        getArguments();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatOld() {
        if (this.txOldPass.getText().toString().trim().isEmpty()) {
            this.lyOldPass.setError("Este campo no puede ser vacío");
            requestFocus(this.txOldPass);
            return false;
        }
        this.lyOldPass.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatNewPass() {
        if (this.txNewPass.getText().toString().trim().isEmpty()) {
            this.lyNewPass.setError("Este campo no puede ser vacío");
            requestFocus(this.txNewPass);
            return false;
        }
        this.lyNewPass.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateRepNewPass() {
        if (this.txRepNewPass.getText().toString().trim().isEmpty()) {
            this.lyRepNewPass.setError("Este campo no puede ser vacío");
            requestFocus(this.txRepNewPass);
            return false;
        }
        if (!this.txRepNewPass.getText().toString().contains(this.txNewPass.getText().toString().trim())) {
            this.lyRepNewPass.setError("Campos no coinciden");
            requestFocus(this.txRepNewPass);
            return false;
        }
        this.lyRepNewPass.setErrorEnabled(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.lyOldPass = (TextInputLayout) this.rootView.findViewById(R.id.lyOldPass);
        this.txOldPass = (TextInputEditText) this.rootView.findViewById(R.id.txOldPass);
        this.lyNewPass = (TextInputLayout) this.rootView.findViewById(R.id.lyNewPass);
        this.txNewPass = (TextInputEditText) this.rootView.findViewById(R.id.txNewPass);
        this.lyRepNewPass = (TextInputLayout) this.rootView.findViewById(R.id.lyRepNewPass);
        this.txRepNewPass = (TextInputEditText) this.rootView.findViewById(R.id.txRepNewPass);
        this.cdUpdate = (CardView) this.rootView.findViewById(R.id.cdUpdate);
        Button button = (Button) this.rootView.findViewById(R.id.btOk);
        this.btOk = button;
        button.setOnClickListener(this.btClickActualizar);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.aJPnChUFfp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                aJPnChUFfp.this.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.aJPnChUFfp$2, reason: invalid class name */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!aJPnChUFfp.this.validatOld() || !aJPnChUFfp.this.validatNewPass() || !aJPnChUFfp.this.validateRepNewPass()) {
                return;
            }
            aJPnChUFfp.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.aJPnChUFfp.2.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(aJPnChUFfp.this.context).setTitle("Confirmar").setMessage("Confirme que desea actualizar la contraseña").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.aJPnChUFfp.2.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            aJPnChUFfp.this.actualizar();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void actualizar() {
        Intent returnIntent = new Intent();
        NnwdA7ink5 nnwdA7ink5 = new NnwdA7ink5();
        this.datos = nnwdA7ink5;
        nnwdA7ink5.setOld(this.txOldPass.getText().toString().trim());
        this.datos.setNuevo(this.txNewPass.getText().toString().trim());
        this.datos.setRepeat_nuevo(this.txRepNewPass.getText().toString().trim());
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
