package cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.nzfmd7tb20;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.Q4vEnhMS0jA;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.ebH6Aq5ppu;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.hLxHp3lKE9;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.vIGfHVEwb7;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.YbN03uYqWN;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.qztlzqkyWH;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j8e1KQ8gfS;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m8VcbqsQfBi extends Fragment implements SRIeLPPchM {
    public Activity activity;
    public Context context;
    public RXqUCo8r9g devPresenter;
    public YbN03uYqWN filtro;
    public ebH6Aq5ppu.FiltroResult filtroResult;
    public FloatingActionButton floatingActionButton;
    public int incremento;
    public List<nzfmd7tb20> list;
    public Q4vEnhMS0jA listDevAdapter;
    public boolean lockUpdate;
    private ProgressBar mProgressView;
    private ProgressBar pBarLoad;
    public int page;
    public View rootView;
    public RecyclerView rvList;
    public NestedScrollView scrollView;
    public SpinnerDialog spinnerDialog;
    public int totalCompleto;
    public int totalFiltrado;
    public TextView txFiltrado;
    public TextView txTotal;
    public String HEAD_LOG = "m8VcbqsQfBi";
    public ArrayList<String> items = new ArrayList<>();
    public Q4vEnhMS0jA.OnItemClickListener onItemClickListener = new Q4vEnhMS0jA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.9
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.Q4vEnhMS0jA.OnItemClickListener
        public void onGetItemClick(View view, int position, String id) {
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.Q4vEnhMS0jA.OnItemClickListener
        public void onGetItemClick(View view, int position, nzfmd7tb20 item) {
            if (item != null) {
                hLxHp3lKE9 datos = new hLxHp3lKE9();
                datos.setIdTercero(item.getIdPago());
                datos.setFecha(item.getFecha());
                datos.setEstado(item.getEstadoPago());
                datos.setBanco(item.getBBancoEnum());
                datos.setDescripcion(item.getResultMsg());
                datos.setDetalles(item.getResultMsg());
                datos.setImoprte(item.getImporte() + " " + item.getMoneda());
                datos.setSource(item.getSource());
                datos.setExternalCode(item.getExternalCode());
                datos.setImporte(item.getImporte());
                datos.setIdDevBanco(item.getIdBankDevolcuin());
                datos.setIdDevTM(item.getIdTMDevolucion());
                datos.setIdDevTercero(item.getIdDevolucion());
                datos.setUsuario(item.getUser());
                m8VcbqsQfBi.this.mostrarDevolucion(datos);
            }
        }
    };
    public View.OnClickListener onDevolerPagos = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.10
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            m8VcbqsQfBi.this.spinnerDialog.showSpinerDialog();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ceqvpjycutcwq, container, false);
        Context context = container.getContext();
        this.context = context;
        this.devPresenter = new j8e1KQ8gfS(this, context);
        this.lockUpdate = false;
        this.scrollView = (NestedScrollView) this.rootView.findViewById(R.id.scrollView);
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.pBarLoad);
        this.pBarLoad = progressBar;
        progressBar.setVisibility(8);
        this.txTotal = (TextView) this.rootView.findViewById(R.id.txTotal);
        this.page = 0;
        this.incremento = 8;
        this.list = new ArrayList();
        this.filtro = new YbN03uYqWN();
        this.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.1
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    m8VcbqsQfBi.this.pBarLoad.setVisibility(0);
                    m8VcbqsQfBi m8vcbqsqfbi = m8VcbqsQfBi.this;
                    m8vcbqsqfbi.filtro.setStartRow(m8vcbqsqfbi.page);
                    m8VcbqsQfBi.this.fillAdapter();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rvList);
        this.rvList = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvList.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        this.rvList.setLayoutManager(lLyManager);
        this.rvList.setNestedScrollingEnabled(false);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.rootView.findViewById(R.id.floatingActionButton);
        this.floatingActionButton = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        initData(container);
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_DEVOLUCION)) {
            this.floatingActionButton.hide();
        }
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        implementSearch(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        if (i == R.id.filter) {
            showFilter();
            return true;
        }
        if (i == R.id.action_update) {
            this.rvList.setAdapter(null);
            this.list.clear();
            if (!this.lockUpdate) {
                this.lockUpdate = true;
                fillAdapter();
            } else {
                Context context = this.context;
                Toast.makeText(context, context.getString(R.string.tx_carga_datos), 0).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.3
            @Override // java.lang.Runnable
            public void run() {
                m8VcbqsQfBi.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    private void initData(View v) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        fillAdapter();
    }

    public void fillAdapter() {
        this.lockUpdate = true;
        if (isOnline()) {
            this.devPresenter.getDevoluciones(this.filtro);
            return;
        }
        this.lockUpdate = false;
        this.mProgressView.setVisibility(4);
        ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResult(Boolean result, int code, String mensaje, PYjuxvJ5mg response) {
        this.pBarLoad.setVisibility(4);
        this.mProgressView.setVisibility(4);
        this.lockUpdate = false;
        if (result.booleanValue()) {
            this.totalFiltrado = response.getRecordFiltered();
            this.totalCompleto = response.getRecordTotal();
            this.txTotal.setText(String.valueOf(this.totalFiltrado));
            int i = this.page;
            int i2 = this.incremento;
            int i3 = i + i2;
            int i4 = this.totalFiltrado;
            if (i3 <= i4) {
                this.page = i + i2;
            } else {
                int aux = i4 - i;
                this.page = i + aux;
            }
            if (this.list.size() > 0) {
                if (response.getItemsList() != null && response.getItemsList().size() > 0) {
                    for (nzfmd7tb20 item : response.getItemsList()) {
                        this.list.add(item);
                    }
                }
            } else if (response.getItemsList() != null && response.getItemsList().size() > 0) {
                this.list = response.getItemsList();
            }
            List<nzfmd7tb20> list = this.list;
            if (list != null && list.size() > 0) {
                Q4vEnhMS0jA q4vEnhMS0jA = new Q4vEnhMS0jA(this.context, this.list);
                this.listDevAdapter = q4vEnhMS0jA;
                this.rvList.setAdapter(q4vEnhMS0jA);
                this.listDevAdapter.setOnItemClickListener(this.onItemClickListener);
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

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResultDevolucion(Boolean result, int code, String mensaje, qztlzqkyWH response) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 1) {
            this.filtroResult = (ebH6Aq5ppu.FiltroResult) data.getSerializableExtra("filtro");
            YbN03uYqWN pagoFiltro = new YbN03uYqWN();
            YbN03uYqWN.Filters filters = pagoFiltro.getFilters();
            if (this.filtroResult.getCodfigoBanco() != null && !this.filtroResult.getCodfigoBanco().isEmpty()) {
                filters.setBanck_code(this.filtroResult.getCodfigoBanco());
            }
            if (this.filtroResult.getFechaFin() != null && !this.filtroResult.getFechaFin().isEmpty()) {
                filters.setEnddate(this.filtroResult.getFechaFin());
            }
            if (this.filtroResult.getFechaInicio() != null && !this.filtroResult.getFechaInicio().isEmpty()) {
                filters.setStartdate(this.filtroResult.getFechaInicio());
            }
            if (this.filtroResult.getCodigoPago() != null && !this.filtroResult.getCodigoPago().isEmpty()) {
                filters.setPayment_code(this.filtroResult.getCodigoPago());
            }
            if (this.filtroResult.getCodigoTM() != null && !this.filtroResult.getCodigoTM().isEmpty()) {
                filters.setTm_code(this.filtroResult.getCodigoTM());
            }
            if (this.filtroResult.getCuenta() != null && !this.filtroResult.getCuenta().isEmpty()) {
                String[] arr = {this.filtroResult.getCuenta()};
                filters.setSource(arr);
            }
            if (this.filtroResult.getMoneda() != null && !this.filtroResult.getMoneda().isEmpty()) {
                String[] arr2 = {this.filtroResult.getMoneda()};
                filters.setCurrency(arr2);
            }
            if (this.filtroResult.getDevCodigoBanco() != null && !this.filtroResult.getDevCodigoBanco().isEmpty()) {
                filters.setReference_refund(this.filtroResult.getDevCodigoBanco());
            }
            if (this.filtroResult.getDevCodigoPago() != null && !this.filtroResult.getDevCodigoPago().isEmpty()) {
                filters.setRefund_code(this.filtroResult.getDevCodigoPago());
            }
            if (this.filtroResult.getDevCodigoTM() != null && !this.filtroResult.getDevCodigoTM().isEmpty()) {
                filters.setTm_reference_refund(this.filtroResult.getDevCodigoTM());
            }
            if (this.filtroResult.getEstados() != null && this.filtroResult.getEstados().length > 0) {
                filters.setStatus(this.filtroResult.getEstados());
            }
            pagoFiltro.setPage(0);
            this.page = 0;
            this.totalFiltrado = 0;
            this.totalCompleto = 0;
            this.list = new ArrayList();
            this.filtro = pagoFiltro;
            this.devPresenter.getDevoluciones(pagoFiltro);
        }
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.4
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(m8VcbqsQfBi.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarDevolucion(hLxHp3lKE9 datos) {
        vIGfHVEwb7 dialogFrag = vIGfHVEwb7.newInstance(datos);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 2);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_mostrar_DEVOLCUCION");
    }

    private void showFilter() {
        DialogFragment dialogFrag = new ebH6Aq5ppu();
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }

    private void implementSearch(Menu menu) {
        SearchManager searchManager = (SearchManager) this.context.getSystemService("search");
        final MenuItem searchMenuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.activity.getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.5
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                Log.i(m8VcbqsQfBi.this.HEAD_LOG, " QUERY CLOSE searchView");
                searchView.clearFocus();
                searchView.setQuery(BuildConfig.FLAVOR, false);
                searchView.setIconified(true);
                searchMenuItem.collapseActionView();
                searchView.clearFocus();
                return false;
            }
        });
        searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.6
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem item) {
                new Handler().post(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        searchView.requestFocus();
                        InputMethodManager imm = (InputMethodManager) m8VcbqsQfBi.this.context.getSystemService("input_method");
                        if (imm != null) {
                            imm.showSoftInput(searchView.findFocus(), 0);
                        }
                    }
                });
                return true;
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.7
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                Log.i(m8VcbqsQfBi.this.HEAD_LOG, " QUERY SUBMIT:" + query);
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                Log.i(m8VcbqsQfBi.this.HEAD_LOG, " QUERY:" + newText);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi.8
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                Log.i(m8VcbqsQfBi.this.HEAD_LOG, " QUERY CLOSE");
                searchView.clearFocus();
                searchView.setQuery(BuildConfig.FLAVOR, false);
                searchView.setIconified(true);
                searchMenuItem.collapseActionView();
                searchView.clearFocus();
                return false;
            }
        });
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
