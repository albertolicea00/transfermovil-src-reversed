package cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.X7hwy8FHbt;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class bDqhGetEjA extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public Button btActualizar;
    public ImageView btClose;
    public Button btEliminar;
    public Button btOk;
    public CardView cdUpdate;
    public Context context;
    public U1zgY8gPcNl datos;
    public TextInputLayout lyDescripcion;
    public TextInputLayout lyMoneda;
    public TextInputLayout lyNegocio;
    public TextInputLayout lySource;
    public X7hwy8FHbt monedaSeleccion;
    public OperTypeCuentasCRUD operTypeCuentasCRUD;
    public View rootView;
    public Hrke6IBHBA spMoneda;
    public TextInputEditText txDescripcion;
    public TextInputEditText txNegocio;
    public TextInputEditText txSource;
    public View.OnClickListener btClickActualizar = new AnonymousClass2();
    public View.OnClickListener btClicEliminar = new AnonymousClass3();
    public View.OnClickListener btClickCrear = new AnonymousClass4();
    public Hrke6IBHBA.OnItemClickListener spClickMoneda = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:14:0x0034  */
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            switch (bDqhGetEjA.this.adapterTipoMoneda.getItem(position).toString()) {
                case "CUP":
                    bDqhGetEjA.this.monedaSeleccion = X7hwy8FHbt.CUP;
                    break;
                case "CUC":
                    bDqhGetEjA.this.monedaSeleccion = X7hwy8FHbt.CUC;
                    break;
                case "USD":
                    bDqhGetEjA.this.monedaSeleccion = X7hwy8FHbt.USD;
                    break;
            }
        }
    };

    public enum OperTypeCuentasCRUD {
        UPDATE,
        DELETE,
        CREATE
    }

    public static bDqhGetEjA newInstance(U1zgY8gPcNl request) {
        bDqhGetEjA frag = new bDqhGetEjA();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", request);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ryef8kkvsz5wc, container, false);
        Bundle arg = getArguments();
        this.datos = (U1zgY8gPcNl) arg.getSerializable("PAGO");
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.operTypeCuentasCRUD = this.datos.operTypeCuentasCRUD;
        this.lyNegocio = (TextInputLayout) this.rootView.findViewById(R.id.lyNegocio);
        this.txNegocio = (TextInputEditText) this.rootView.findViewById(R.id.txNegocio);
        this.lyDescripcion = (TextInputLayout) this.rootView.findViewById(R.id.lyDescripcion);
        this.txDescripcion = (TextInputEditText) this.rootView.findViewById(R.id.txDescripcion);
        this.lySource = (TextInputLayout) this.rootView.findViewById(R.id.lySource);
        this.txSource = (TextInputEditText) this.rootView.findViewById(R.id.txSource);
        this.lyMoneda = (TextInputLayout) this.rootView.findViewById(R.id.lyMoneda);
        this.spMoneda = (Hrke6IBHBA) this.rootView.findViewById(R.id.spMoneda);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.context, R.array.currency, android.R.layout.simple_list_item_1);
        this.adapterTipoMoneda = arrayAdapterCreateFromResource;
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMoneda.setAdapter(this.adapterTipoMoneda);
        this.spMoneda.setOnItemClickListener(this.spClickMoneda);
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                bDqhGetEjA.this.dismiss();
            }
        });
        this.txNegocio.setText(this.datos.getDescripcionNegocio());
        if (this.operTypeCuentasCRUD != OperTypeCuentasCRUD.CREATE) {
            this.txDescripcion.setText(this.datos.getDescripcionCuenta());
            this.txSource.setText(this.datos.getSource());
            this.txSource.setEnabled(false);
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$X7hwy8FHbt[this.datos.getMoneda().ordinal()]) {
                case 1:
                    this.monedaSeleccion = X7hwy8FHbt.CUP;
                    this.spMoneda.setText("CUP");
                    break;
                case 2:
                    this.monedaSeleccion = X7hwy8FHbt.CUC;
                    this.spMoneda.setText("CUC");
                    break;
                case 3:
                    this.monedaSeleccion = X7hwy8FHbt.USD;
                    this.spMoneda.setText("USD");
                    break;
            }
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

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$X7hwy8FHbt;

        static {
            int[] iArr = new int[X7hwy8FHbt.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$X7hwy8FHbt = iArr;
            try {
                iArr[X7hwy8FHbt.CUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$X7hwy8FHbt[X7hwy8FHbt.CUC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$X7hwy8FHbt[X7hwy8FHbt.USD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static bDqhGetEjA newInstance(String id) {
        bDqhGetEjA frag = new bDqhGetEjA();
        Bundle args = new Bundle();
        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA$2, reason: invalid class name */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!bDqhGetEjA.this.validateTipoMoneda() || !bDqhGetEjA.this.validatDescription()) {
                return;
            }
            bDqhGetEjA.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.2.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(bDqhGetEjA.this.context).setTitle("Confirmar").setMessage("Confirme que desea actualizar la cuenta").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.2.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            bDqhGetEjA.this.actualizar();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void actualizar() {
        Intent returnIntent = new Intent();
        this.datos.setDescripcionCuenta(this.txDescripcion.getText().toString().trim());
        U1zgY8gPcNl u1zgY8gPcNl = this.datos;
        u1zgY8gPcNl.setIdNegocio(u1zgY8gPcNl.getIdNegocio());
        U1zgY8gPcNl u1zgY8gPcNl2 = this.datos;
        u1zgY8gPcNl2.setIdCuenta(u1zgY8gPcNl2.getIdCuenta());
        this.datos.setSource(this.txSource.getText().toString());
        this.datos.setMoneda(this.monedaSeleccion);
        returnIntent.putExtra("PARAMETERS", this.datos);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA$3, reason: invalid class name */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            bDqhGetEjA.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.3.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(bDqhGetEjA.this.context).setTitle("Confirmar").setMessage("Confirme que desea eliminar la cuenta").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.3.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            bDqhGetEjA.this.eliminar();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void eliminar() {
        Intent returnIntent = new Intent();
        U1zgY8gPcNl datosEliminar = new U1zgY8gPcNl();
        datosEliminar.setOperTypeCuentasCRUD(OperTypeCuentasCRUD.DELETE);
        datosEliminar.setIdCuenta(this.datos.getIdCuenta());
        returnIntent.putExtra("PARAMETERS", datosEliminar);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!bDqhGetEjA.this.validatSource() || !bDqhGetEjA.this.validateTipoMoneda() || !bDqhGetEjA.this.validatDescription()) {
                return;
            }
            bDqhGetEjA.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.4.1
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(bDqhGetEjA.this.context).setTitle("Confirmar").setMessage("Confirme que desea crear la cuenta").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.bDqhGetEjA.4.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            bDqhGetEjA.this.crear();
                            dialog.cancel();
                        }
                    }).show();
                }
            });
        }
    }

    public void crear() {
        Intent returnIntent = new Intent();
        U1zgY8gPcNl datosCrear = new U1zgY8gPcNl();
        datosCrear.setOperTypeCuentasCRUD(OperTypeCuentasCRUD.CREATE);
        datosCrear.setIdNegocio(this.datos.getIdNegocio());
        datosCrear.setMoneda(this.monedaSeleccion);
        datosCrear.setSource(this.txSource.getText().toString());
        datosCrear.setDescripcionCuenta(this.txDescripcion.getText().toString().trim());
        returnIntent.putExtra("PARAMETERS", datosCrear);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validatSource() {
        if (this.txSource.getText().toString().trim().isEmpty()) {
            this.lySource.setError("Este campo no puede ser vacío");
            requestFocus(this.txSource);
            return false;
        }
        this.lySource.setErrorEnabled(false);
        return true;
    }

    public boolean validateTipoMoneda() {
        if (this.spMoneda.getText().toString().trim().isEmpty()) {
            this.lyMoneda.setError("Seleccione la moneda");
            requestFocus(this.spMoneda);
            return false;
        }
        this.lyMoneda.setErrorEnabled(false);
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
