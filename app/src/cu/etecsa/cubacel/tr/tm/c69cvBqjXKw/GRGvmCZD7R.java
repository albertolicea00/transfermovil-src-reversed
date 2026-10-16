package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.HrLy23Pb9b;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class GRGvmCZD7R extends DialogFragment {
    public HrLy23Pb9b actionEntity;
    public Button btnAceptarCodigo;
    private View.OnClickListener btnAutenticarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (GRGvmCZD7R.this.isFieldsAuthOK()) {
                try {
                    GRGvmCZD7R gRGvmCZD7R = GRGvmCZD7R.this;
                    if (!gRGvmCZD7R.checkAuth(gRGvmCZD7R.operationEntity, gRGvmCZD7R.txCodAcceso.getText().toString().trim())) {
                        Toast.makeText(GRGvmCZD7R.this.context, "Contraseña inválida", 1).show();
                    } else {
                        AOperKey key = unYp8VQThY.getInstance().getAOperKey(GRGvmCZD7R.this.operationEntity);
                        key.setAuth(true);
                        key.setAuthDate(new Date());
                        unYp8VQThY.getInstance().updateAOperKey(key);
                        Intent returnIntent = new Intent();
                        GRGvmCZD7R.this.getTargetFragment().onActivityResult(GRGvmCZD7R.this.getTargetRequestCode(), 2, returnIntent);
                        GRGvmCZD7R.this.dismiss();
                    }
                } catch (Exception e) {
                    Toast.makeText(GRGvmCZD7R.this.context, "Ha ocurrido un error inesperado, vuelva intentarlo", 1).show();
                }
            }
        }
    };
    private View.OnClickListener btnRegistarOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (GRGvmCZD7R.this.isFieldsRegisterOK()) {
                try {
                    AOperKey checkOper = unYp8VQThY.getInstance().getAOperKey(GRGvmCZD7R.this.operationEntity);
                    if (checkOper != null) {
                        unYp8VQThY.getInstance().deleteAOperKey(checkOper);
                    }
                    AOperKey operKey = new AOperKey();
                    operKey.setAuth(true);
                    operKey.setAuthDate(new Date());
                    operKey.setOperacion(GRGvmCZD7R.this.operationEntity);
                    operKey.setPin(V5FFEZ0Qrr0.getSha256(GRGvmCZD7R.this.txCodAcceso.getText().toString().trim()));
                    unYp8VQThY.getInstance().addAOperKey(operKey);
                    Intent returnIntent = new Intent();
                    GRGvmCZD7R.this.getTargetFragment().onActivityResult(GRGvmCZD7R.this.getTargetRequestCode(), 1, returnIntent);
                    GRGvmCZD7R.this.dismiss();
                } catch (Exception ex) {
                    Log.e("ERROR", ex.getMessage());
                }
            }
        }
    };
    private View.OnClickListener btnResetOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                GRGvmCZD7R.this.eliminarDatosSesion();
            } catch (Exception e) {
            }
        }
    };
    public TextView btnRestCodigo;
    public Context context;
    public TextInputLayout lyCodAcceso;
    public TextInputLayout lyConfirmPassword;
    public Nl0yptXmjQ operationEntity;
    public View rootView;
    public String titulo;
    public TextView toolbar_title;
    public TextInputEditText txCodAcceso;
    public TextInputEditText txConfirmCodAcceso;
    public TextView txHeadAcceso;
    public TextView txInsertCodAccesoHead;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.qxpdpo6c5xfhj, container, false);
        this.rootView = viewInflate;
        this.toolbar_title = (TextView) viewInflate.findViewById(R.id.toolbar_title);
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        loadViewUI(this.rootView);
        if (getArguments() != null && getArguments().containsKey("HrLy23Pb9b") && getArguments().containsKey("Nl0yptXmjQ")) {
            this.actionEntity = (HrLy23Pb9b) getArguments().getSerializable("HrLy23Pb9b");
            this.operationEntity = (Nl0yptXmjQ) getArguments().getSerializable("Nl0yptXmjQ");
            this.titulo = getArguments().getString("Titulo");
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$HrLy23Pb9b[this.actionEntity.ordinal()]) {
                case 1:
                    loadDataAuth();
                    break;
                case 2:
                    loadDataRegister();
                    break;
            }
        }
        Toast.makeText(this.context, "Ha ocurrido un error", 0).show();
    }

    public static GRGvmCZD7R newInstance(Nl0yptXmjQ operationEntity, HrLy23Pb9b authActionEntity, String title) {
        GRGvmCZD7R frag = new GRGvmCZD7R();
        Bundle args = new Bundle();
        args.putSerializable("HrLy23Pb9b", authActionEntity);
        args.putSerializable("Nl0yptXmjQ", operationEntity);
        args.putString("Titulo", title);
        frag.setArguments(args);
        return frag;
    }

    public void loadViewUI(View v) {
        this.txHeadAcceso = (TextView) v.findViewById(R.id.txHeadAcceso);
        this.txInsertCodAccesoHead = (TextView) v.findViewById(R.id.txInsertCodAccesoHead);
        this.lyCodAcceso = (TextInputLayout) v.findViewById(R.id.lyCodAcceso);
        this.lyConfirmPassword = (TextInputLayout) v.findViewById(R.id.lyConfirmPassword);
        this.txCodAcceso = (TextInputEditText) v.findViewById(R.id.txCodAcceso);
        this.txConfirmCodAcceso = (TextInputEditText) v.findViewById(R.id.txConfirmCodAcceso);
        this.btnAceptarCodigo = (Button) v.findViewById(R.id.btnAceptarCodigo);
        TextView textView = (TextView) v.findViewById(R.id.btnRestCodigo);
        this.btnRestCodigo = textView;
        textView.setOnClickListener(this.btnResetOnClick);
    }

    private void loadDataAuth() {
        this.lyConfirmPassword.setVisibility(8);
        this.txInsertCodAccesoHead.setText("Inserte su código para acceder a: " + this.titulo);
        this.btnAceptarCodigo.setOnClickListener(this.btnAutenticarOnClick);
    }

    private void loadDataRegister() {
        this.txInsertCodAccesoHead.setText("Crear código de acceso a:" + this.titulo);
        this.btnAceptarCodigo.setOnClickListener(this.btnRegistarOnClick);
        this.btnRestCodigo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eliminarDatosSesion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Confime");
        builder.setMessage("¿Desea eliminar todos los datos relacionados para su autenticación? Todos los datos del servicio adquirido serán borrados.");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                AOperKey operKey = unYp8VQThY.getInstance().getAOperKey(GRGvmCZD7R.this.operationEntity);
                unYp8VQThY.getInstance().deleteAOperKey(operKey);
                unYp8VQThY.getInstance().deleteAllTCTTicket();
                Intent returnIntent = new Intent();
                GRGvmCZD7R.this.getTargetFragment().onActivityResult(GRGvmCZD7R.this.getTargetRequestCode(), 3, returnIntent);
                GRGvmCZD7R.this.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsAuthOK() {
        if (!validatPass()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFieldsRegisterOK() {
        return validatPass() && validateRepNewPass();
    }

    private boolean validatPass() {
        if (this.txCodAcceso.getText().toString().trim().isEmpty()) {
            this.lyCodAcceso.setError("Este campo no puede ser vacío");
            requestFocus(this.txCodAcceso);
            return false;
        }
        this.lyCodAcceso.setErrorEnabled(false);
        return true;
    }

    private boolean validateRepNewPass() {
        if (this.txConfirmCodAcceso.getText().toString().trim().isEmpty()) {
            this.lyConfirmPassword.setError("Este campo no puede ser vacío");
            requestFocus(this.txConfirmCodAcceso);
            return false;
        }
        if (!this.txConfirmCodAcceso.getText().toString().contains(this.txCodAcceso.getText().toString().trim())) {
            this.lyConfirmPassword.setError("Campos no coinciden");
            requestFocus(this.txConfirmCodAcceso);
            return false;
        }
        this.lyConfirmPassword.setErrorEnabled(false);
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    public boolean checkAuth(Nl0yptXmjQ oper, String code) {
        AOperKey aOperKey;
        try {
            String key = V5FFEZ0Qrr0.getSha256(code);
            if (key == null || key.length() <= 0 || (aOperKey = unYp8VQThY.getInstance().getAOperKey(oper)) == null || aOperKey.getOperacion() != oper || !aOperKey.getPin().contains(key)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void goTo(Nl0yptXmjQ operationEntity) {
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction();
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ[operationEntity.ordinal()]) {
            case 1:
                new GUihyrFQpq();
                break;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.GRGvmCZD7R$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$HrLy23Pb9b;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ;

        static {
            int[] iArr = new int[Nl0yptXmjQ.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ = iArr;
            try {
                iArr[Nl0yptXmjQ.Ticket_Combustible_Gestion.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            int[] iArr2 = new int[HrLy23Pb9b.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$HrLy23Pb9b = iArr2;
            try {
                iArr2[HrLy23Pb9b.AUTENTICAR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$HrLy23Pb9b[HrLy23Pb9b.REGISTRO.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
