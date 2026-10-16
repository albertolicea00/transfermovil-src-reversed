package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mznuZkZXP3 extends Fragment {
    public ArrayAdapter<CharSequence> adapter;
    public Button btnAceptar;
    public List<Client> clientsList;
    public Context context;
    public int id_cliente_select;
    private TextInputLayout input__layout_cliente;
    private TextInputLayout lySerie;
    private TextInputLayout lydescripcion;
    private TextInputLayout lymoneda;
    public View rootView;
    public boolean serieCorrecto;
    private jN13TOyLMX spinnerCliente;
    public TarjetaPropia tarjetaPropia;
    public TextView toolbar_title;
    private AutoCompleteTextView txSerie;
    private AutoCompleteTextView txdescripcion;
    private AutoCompleteTextView txmoneda;
    public boolean editMode = false;
    public boolean lista_vacia = false;
    private jN13TOyLMX.OnItemClickListener spCliente = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.6
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            mznuZkZXP3 mznuzkzxp3 = mznuZkZXP3.this;
            mznuzkzxp3.id_cliente_select = mznuzkzxp3.clientsList.get(mznuzkzxp3.spinnerCliente.getPosition_select()).getId();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.gs5r679uvgevs, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) this.rootView.findViewById(R.id.toolbar_title);
        this.lySerie = (TextInputLayout) this.rootView.findViewById(R.id.lySerie);
        this.txSerie = (AutoCompleteTextView) this.rootView.findViewById(R.id.txSerie);
        this.lydescripcion = (TextInputLayout) this.rootView.findViewById(R.id.lydescripcion);
        this.txdescripcion = (AutoCompleteTextView) this.rootView.findViewById(R.id.txdescripcion);
        this.lymoneda = (TextInputLayout) this.rootView.findViewById(R.id.lymoneda);
        this.txmoneda = (AutoCompleteTextView) this.rootView.findViewById(R.id.txmoneda);
        this.input__layout_cliente = (TextInputLayout) this.rootView.findViewById(R.id.input__layout_cliente);
        this.spinnerCliente = (jN13TOyLMX) this.rootView.findViewById(R.id.spinnerCliente);
        this.clientsList = unYp8VQThY.getInstance().getAllClientLists();
        List<String> titles = new ArrayList<>();
        for (Client c : this.clientsList) {
            try {
                if (c.getName().length() != 0) {
                    titles.add(c.getName());
                }
            } catch (Exception e) {
            }
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, titles);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerCliente.setAdapter(adapter1);
        if (getArguments() != null) {
            this.toolbar_title.setText("Editar Tarjeta Propia");
            int id = Integer.parseInt(getArguments().get("cuenta_id").toString());
            unYp8VQThY.init(this.context);
            TarjetaPropia propiaListWithID = unYp8VQThY.getInstance().getPropiaListWithID(id);
            this.tarjetaPropia = propiaListWithID;
            this.txSerie.setText(propiaListWithID.getSerie());
            this.txdescripcion.setText(this.tarjetaPropia.getDescripcion());
            this.serieCorrecto = true;
            switch (AnonymousClass7.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[this.tarjetaPropia.getTipo_moneda().ordinal()]) {
                case 1:
                    this.txmoneda.setText("CUP");
                case 2:
                    this.txmoneda.setText("CUC");
                    break;
            }
            if (this.tarjetaPropia.getId_client() > 0) {
                Client cl = unYp8VQThY.getInstance().getClientListWithId(this.tarjetaPropia.getId_client());
                this.spinnerCliente.setText(cl.getName());
                this.id_cliente_select = cl.getId();
            }
            this.editMode = true;
        } else {
            this.toolbar_title.setText("Nueva Tarjeta Propia");
            this.tarjetaPropia = new TarjetaPropia();
        }
        onSerieText();
        this.spinnerCliente.setOnItemClickListener(this.spCliente);
        Button button = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mznuZkZXP3.this.submitForm();
            }
        });
        return this.rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE;

        static {
            int[] iArr = new int[qTDVwLFEjE.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE = iArr;
            try {
                iArr[qTDVwLFEjE.CUP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$qTDVwLFEjE[qTDVwLFEjE.CUC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public void submitForm() {
        if (!validateDescripcion() || !validateSerie()) {
            return;
        }
        if (!validateSpinnerCliente()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getString(R.string.msd_title_spinner_client_sin_asign));
            builder.setMessage(this.context.getString(R.string.msg_alert_spinner_cliente_sin_asignar));
            builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    mznuZkZXP3 mznuzkzxp3 = mznuZkZXP3.this;
                    mznuzkzxp3.lista_vacia = true;
                    mznuzkzxp3.execute_commit();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    mznuZkZXP3.this.lista_vacia = false;
                }
            });
            builder.show();
            return;
        }
        execute_commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute_commit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(R.string.confirm);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.4
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:11:0x0058  */
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                unYp8VQThY.init(mznuZkZXP3.this.context);
                mznuZkZXP3 mznuzkzxp3 = mznuZkZXP3.this;
                mznuzkzxp3.tarjetaPropia.setSerie(mznuzkzxp3.txSerie.getText().toString());
                mznuZkZXP3 mznuzkzxp4 = mznuZkZXP3.this;
                mznuzkzxp4.tarjetaPropia.setDescripcion(mznuzkzxp4.txdescripcion.getText().toString());
                switch (mznuZkZXP3.this.txmoneda.getText().toString()) {
                    case "CUP":
                        mznuZkZXP3.this.tarjetaPropia.setTipo_moneda(qTDVwLFEjE.CUP);
                        break;
                    case "CUC":
                        mznuZkZXP3.this.tarjetaPropia.setTipo_moneda(qTDVwLFEjE.CUC);
                        break;
                }
                mznuZkZXP3 mznuzkzxp5 = mznuZkZXP3.this;
                int i = mznuzkzxp5.id_cliente_select;
                if (i != 0 && i != -1) {
                    mznuzkzxp5.tarjetaPropia.setId_client(i);
                }
                if (mznuZkZXP3.this.editMode) {
                    unYp8VQThY.getInstance().updatePropia(mznuZkZXP3.this.tarjetaPropia);
                } else {
                    unYp8VQThY.getInstance().addPropia(mznuZkZXP3.this.tarjetaPropia);
                }
                if (mznuZkZXP3.this.getActivity() instanceof IHVTCBmiLV) {
                    ((IHVTCBmiLV) mznuZkZXP3.this.getActivity()).UpdateMenu();
                } else if (mznuZkZXP3.this.getActivity() instanceof S9ycHcoxAzy) {
                    ((S9ycHcoxAzy) mznuZkZXP3.this.getActivity()).UpdateMenu();
                }
                mznuZkZXP3.this.getFragmentManager().popBackStack();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.show();
    }

    private boolean validateSerie() {
        if (this.txSerie.getText().toString().trim().isEmpty()) {
            this.lySerie.setError("El campo no puede estar vacio");
            requestFocus(this.txSerie);
            return false;
        }
        if (this.txSerie.getText().toString().trim().length() != 12) {
            this.lySerie.setError(getString(R.string.err_msg_len_serie_12_propia));
            requestFocus(this.txSerie);
            return false;
        }
        if (!this.serieCorrecto) {
            this.lySerie.setError("Número de serie incorrecto");
            requestFocus(this.txSerie);
            return false;
        }
        boolean z = this.editMode;
        if (!z || (z && !this.txSerie.getText().toString().contains(this.tarjetaPropia.getSerie()))) {
            if (unYp8VQThY.getInstance().getTarjetaPropiaWithSerie(this.txSerie.getText().toString().trim()).size() != 0) {
                this.lySerie.setError("La serie ya existe");
                requestFocus(this.txSerie);
                return false;
            }
            return true;
        }
        this.lySerie.setErrorEnabled(false);
        return true;
    }

    private boolean validateDescripcion() {
        if (this.txdescripcion.getText().toString().trim().isEmpty()) {
            this.lydescripcion.setError("El campo no puede estar vacio");
            requestFocus(this.txdescripcion);
            return false;
        }
        this.lydescripcion.setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateSerieIncorrecto() {
        this.lySerie.setError("Número de serie incorrecto");
        requestFocus(this.txSerie);
    }

    public void onSerieText() {
        this.txSerie.addTextChangedListener(new TextWatcher() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.mznuZkZXP3.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mznuZkZXP3.this.txmoneda.setText(BuildConfig.FLAVOR);
                mznuZkZXP3.this.lySerie.setErrorEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String serie = mznuZkZXP3.this.txSerie.getText().toString().trim();
                if (serie.length() >= 3) {
                    char caracter = serie.charAt(2);
                    switch (caracter) {
                        case '5':
                            mznuZkZXP3 mznuzkzxp3 = mznuZkZXP3.this;
                            mznuzkzxp3.serieCorrecto = true;
                            mznuzkzxp3.txmoneda.setText("CUP");
                            break;
                        case '6':
                            mznuZkZXP3 mznuzkzxp4 = mznuZkZXP3.this;
                            mznuzkzxp4.serieCorrecto = true;
                            mznuzkzxp4.txmoneda.setText("CUC");
                            break;
                        default:
                            mznuZkZXP3 mznuzkzxp5 = mznuZkZXP3.this;
                            mznuzkzxp5.serieCorrecto = false;
                            mznuzkzxp5.txmoneda.setText(BuildConfig.FLAVOR);
                            mznuZkZXP3.this.validateSerieIncorrecto();
                            break;
                    }
                }
            }
        });
    }

    private boolean validateSpinnerCliente() {
        if (this.spinnerCliente.getText().toString().trim().isEmpty()) {
            return false;
        }
        this.lista_vacia = true;
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
