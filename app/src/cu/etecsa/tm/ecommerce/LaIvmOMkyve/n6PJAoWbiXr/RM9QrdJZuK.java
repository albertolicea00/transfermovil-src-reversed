package cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.ybq.android.spinkit.style.Circle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.bIqwjujBCy;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.q5eErW0HcCa;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.muSU2TIZ8I;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.tVwkzUCBeV;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.luC26d6Wdp;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j2tvTITC0Z;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk;
import cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RM9QrdJZuK extends Fragment implements bIqwjujBCy, KFxuVD3dg2 {
    public Activity activity;
    public Button btFiltrar;
    public Context context;
    public ArrayAdapter<LWt69JQUoH> cuentasArrayAdapter;
    public rw0GJVadKk cuentasPresenter;
    public Y5RKazbgNj estadisticasPresenter;
    public DatePickerDialog fFindatePicker;
    public DatePickerDialog fIniciodatePicker;
    public String fechaFin;
    public String fechaInicio;
    public List<q5eErW0HcCa> list;
    public muSU2TIZ8I listEstadisticaParentAdapter;
    public boolean lockUpdate;
    public TextInputLayout lyCuentas;
    public TextInputLayout lyFechaFin;
    public TextInputLayout lyFechaInicio;
    public TextInputLayout lyUser;
    private ProgressBar mProgressView;
    public String numeroCuenta;
    private ProgressBar pBarLoad;
    public View rootView;
    public RecyclerView rvList;
    public Hrke6IBHBA spCuentas;
    public Switch swEstado;
    public TextInputEditText txFechaFin;
    public TextInputEditText txFechaInicio;
    public TextInputEditText txUser;
    public String HEAD_LOG = "RM9QrdJZuK";
    private Hrke6IBHBA.OnItemClickListener spClickMisCuentas = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.3
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            LWt69JQUoH item = RM9QrdJZuK.this.cuentasArrayAdapter.getItem(position);
            RM9QrdJZuK.this.numeroCuenta = item.getSource();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.zxje01kphtzre, container, false);
        this.context = container.getContext();
        initData(container);
        HLAV6HkYgi hLAV6HkYgi = new HLAV6HkYgi(this, this.context);
        this.cuentasPresenter = hLAV6HkYgi;
        hLAV6HkYgi.getCuentas();
        this.estadisticasPresenter = new j2tvTITC0Z(this, this.context);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rvList);
        this.rvList = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvList.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        this.rvList.setLayoutManager(lLyManager);
        this.rvList.setNestedScrollingEnabled(false);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.lyCuentas = (TextInputLayout) this.rootView.findViewById(R.id.lyCuentas);
        this.lyFechaInicio = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaInicio);
        this.lyFechaFin = (TextInputLayout) this.rootView.findViewById(R.id.lyFechaFin);
        this.lyUser = (TextInputLayout) this.rootView.findViewById(R.id.lyUser);
        Switch r1 = (Switch) this.rootView.findViewById(R.id.swEstado);
        this.swEstado = r1;
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                RM9QrdJZuK.this.visibleCard(b);
            }
        });
        this.txFechaInicio = (TextInputEditText) this.rootView.findViewById(R.id.txFechaInicio);
        fechaInicioConfig();
        this.txFechaFin = (TextInputEditText) this.rootView.findViewById(R.id.txFechaFin);
        fechaFinConfig();
        this.txUser = (TextInputEditText) this.rootView.findViewById(R.id.txUser);
        this.spCuentas = (Hrke6IBHBA) this.rootView.findViewById(R.id.spCuentas);
        Button button = (Button) this.rootView.findViewById(R.id.btFiltrar);
        this.btFiltrar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RM9QrdJZuK.this.sendData();
            }
        });
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.pBarLoad);
        this.pBarLoad = progressBar;
        progressBar.setVisibility(8);
        return this.rootView;
    }

    private void initData(View v) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        Circle doubleBounce = new Circle();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
    }

    public void visibleCard(boolean b) {
        if (b) {
            this.swEstado.setText("Mostrar Filtro");
            this.lyCuentas.setVisibility(8);
            this.lyFechaInicio.setVisibility(8);
            this.lyFechaFin.setVisibility(8);
            this.lyUser.setVisibility(8);
            this.btFiltrar.setVisibility(8);
            return;
        }
        this.swEstado.setText("Ocultar Filtro");
        this.btFiltrar.setVisibility(0);
        this.lyUser.setVisibility(0);
        this.lyFechaFin.setVisibility(0);
        this.lyFechaInicio.setVisibility(0);
        this.lyCuentas.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData() {
        try {
            if (!validateCuenta() || !validateFechaInicio() || !validateFechaFin()) {
                return;
            }
            tVwkzUCBeV request = new tVwkzUCBeV();
            tVwkzUCBeV.FiltersCuadre filtro = new tVwkzUCBeV.FiltersCuadre();
            String[] sources = {this.numeroCuenta};
            filtro.setSource(sources);
            String str = this.fechaInicio;
            if (str != null && str.length() > 0) {
                filtro.setStartdate(this.fechaInicio);
            }
            String str2 = this.fechaFin;
            if (str2 != null && str2.length() > 0) {
                filtro.setEnddate(this.fechaFin);
            }
            if (!this.txUser.getText().toString().isEmpty() && this.txUser.getText().length() > 0) {
                filtro.setCreate_user(this.txUser.getText().toString());
            } else {
                filtro.setCreate_user(BuildConfig.FLAVOR);
            }
            request.setFilters(filtro);
            fillAdapter(request);
        } catch (Exception e) {
        }
    }

    public boolean validateCuenta() {
        if (this.numeroCuenta == null) {
            this.lyCuentas.setError("Selecione una cuenta");
            requestFocus(this.spCuentas);
            return false;
        }
        if (this.spCuentas.getText().toString().trim().isEmpty()) {
            this.lyCuentas.setError("Selecione una cuenta");
            requestFocus(this.spCuentas);
            return false;
        }
        this.lyCuentas.setErrorEnabled(false);
        return true;
    }

    private boolean validateFechaFin() {
        if (this.txFechaFin.getText().toString().trim().isEmpty()) {
            this.lyFechaFin.setError("Este campo no puede ser vacío");
            requestFocus(this.txFechaFin);
            return false;
        }
        this.lyFechaFin.setErrorEnabled(false);
        return true;
    }

    private boolean validateFechaInicio() {
        if (this.txFechaInicio.getText().toString().trim().isEmpty()) {
            this.lyFechaInicio.setError("Este campo no puede ser vacío");
            requestFocus(this.txFechaInicio);
            return false;
        }
        this.lyFechaInicio.setErrorEnabled(false);
        return true;
    }

    public void fillAdapter(tVwkzUCBeV request) {
        this.lockUpdate = true;
        if (isOnline()) {
            this.estadisticasPresenter.getEstadisticasCuadre(request);
            return;
        }
        this.lockUpdate = false;
        this.mProgressView.setVisibility(4);
        ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, int code, String mensaje, sR8QMZUZBy response) {
        if (result.booleanValue()) {
            if (!fillCuentas(response.getItemsList())) {
                Toast.makeText(this.context, "Error cargando las cuentas", 1).show();
            }
        } else if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(this.context, mensaje, 1).show();
        }
    }

    private boolean fillCuentas(List<LWt69JQUoH> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    boolean hasAccountPref = false;
                    String account = BuildConfig.FLAVOR;
                    if (UhA7J2923N.getInstance().getPrefAccount() != null && UhA7J2923N.getInstance().getPrefAccount().length() > 0) {
                        hasAccountPref = true;
                        account = UhA7J2923N.getInstance().getPrefAccount();
                    }
                    this.cuentasArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
                    for (LWt69JQUoH item : list) {
                        if (hasAccountPref) {
                            try {
                                if (item.getSource().contains(account)) {
                                    this.spCuentas.setText(item.getSource() + " - " + item.getName());
                                    this.numeroCuenta = item.getSource();
                                }
                            } catch (Exception e) {
                            }
                        }
                        this.cuentasArrayAdapter.add(item);
                    }
                    this.cuentasArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    this.spCuentas.setAdapter(this.cuentasArrayAdapter);
                    this.spCuentas.setOnItemClickListener(this.spClickMisCuentas);
                    return true;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, HLAV6HkYgi.OperTypeCuentas operTypeCuentas, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.4
            @Override // java.lang.Runnable
            public void run() {
                RM9QrdJZuK.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.bIqwjujBCy
    public void onResultEstadisticas(Boolean result, int code, String mensaje, luC26d6Wdp response) {
        this.pBarLoad.setVisibility(4);
        this.mProgressView.setVisibility(4);
        this.lockUpdate = false;
        if (result.booleanValue()) {
            List<q5eErW0HcCa> listNegocios = response.getListNegocios();
            this.list = listNegocios;
            if (listNegocios != null && listNegocios.size() > 0) {
                muSU2TIZ8I musu2tiz8i = new muSU2TIZ8I(this.context, this.list);
                this.listEstadisticaParentAdapter = musu2tiz8i;
                this.rvList.setAdapter(musu2tiz8i);
                this.swEstado.setChecked(true);
                visibleCard(true);
                return;
            }
            this.rvList.setAdapter(null);
            Context context = this.context;
            Toast.makeText(context, context.getResources().getString(R.string.tx_no_item_mostrar), 1).show();
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(this.context, mensaje, 1).show();
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.bIqwjujBCy
    public void onSetProgressLoadVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.5
            @Override // java.lang.Runnable
            public void run() {
                RM9QrdJZuK.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.6
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(RM9QrdJZuK.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void fechaInicioConfig() {
        this.txFechaInicio.setInputType(0);
        this.txFechaInicio.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                RM9QrdJZuK.this.fIniciodatePicker = new DatePickerDialog(RM9QrdJZuK.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.7.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        RM9QrdJZuK.this.txFechaInicio.setText(year2 + "/" + mes + "/" + dia);
                        RM9QrdJZuK.this.fechaInicio = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                RM9QrdJZuK.this.fIniciodatePicker.show();
            }
        });
    }

    private void fechaFinConfig() {
        this.txFechaFin.setInputType(0);
        this.txFechaFin.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Calendar cldr = Calendar.getInstance();
                int day = cldr.get(5);
                int month = cldr.get(2);
                int year = cldr.get(1);
                RM9QrdJZuK.this.fFindatePicker = new DatePickerDialog(RM9QrdJZuK.this.context, new DatePickerDialog.OnDateSetListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.RM9QrdJZuK.8.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int year2, int monthOfYear, int dayOfMonth) {
                        String mes;
                        String dia;
                        if (String.valueOf(monthOfYear + 1).length() > 1) {
                            mes = String.valueOf(monthOfYear + 1);
                        } else {
                            mes = "0" + String.valueOf(monthOfYear + 1);
                        }
                        if (String.valueOf(dayOfMonth).length() > 1) {
                            dia = String.valueOf(dayOfMonth);
                        } else {
                            dia = "0" + String.valueOf(dayOfMonth);
                        }
                        RM9QrdJZuK.this.txFechaFin.setText(year2 + "/" + mes + "/" + dia);
                        RM9QrdJZuK.this.fechaFin = year2 + "-" + mes + "-" + dia;
                    }
                }, year, month, day);
                RM9QrdJZuK.this.fFindatePicker.show();
            }
        });
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
