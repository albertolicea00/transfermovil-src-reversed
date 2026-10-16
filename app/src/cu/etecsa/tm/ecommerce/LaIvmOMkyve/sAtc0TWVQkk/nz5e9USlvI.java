package cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk;

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
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.jfDH3IIARO;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.H3vGbSAwSo3;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.O19Uv2NP7rT;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.RKxbomWW57;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.Z5fUajldziN;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.isiTmFZ2lx;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.FhtwnBtOAx;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.zKgYf9THHQ;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.PYjuxvJ5mg;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.j670rPXODo;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.qztlzqkyWH;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.XLzsiVGnie;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j8e1KQ8gfS;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.JGlv5icCPO;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.RXqUCo8r9g;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class nz5e9USlvI extends Fragment implements jfDH3IIARO, SRIeLPPchM {
    public static final String DATOS_RESPONSE = "PAGO";
    public Activity activity;
    public Context context;
    public RXqUCo8r9g devPresenter;
    public zKgYf9THHQ filtro;
    public O19Uv2NP7rT.FiltroResult filtroResult;
    public FloatingActionButton floatingActionButton;
    public int incremento;
    public List<s5BkGOZ35ku> list;
    public H3vGbSAwSo3 listPagosAdapter;
    public boolean lockUpdate;
    private ProgressBar mProgressView;
    private ProgressBar pBarLoad;
    public int page;
    public JGlv5icCPO pagosPresenter;
    public View rootView;
    public RecyclerView rvList;
    public NestedScrollView scrollView;
    public int totalCompleto;
    public int totalFiltrado;
    public TextView txFiltrado;
    public TextView txTotal;
    public String HEAD_LOG = "nz5e9USlvI";
    public H3vGbSAwSo3.OnItemClickListener onItemClickListener = new H3vGbSAwSo3.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.8
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.H3vGbSAwSo3.OnItemClickListener
        public void onGetItemClick(View view, int position, String id) {
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.H3vGbSAwSo3.OnItemClickListener
        public void onGetItemClick(View view, int position, s5BkGOZ35ku item) {
            if (item != null) {
                RKxbomWW57 datos = new RKxbomWW57();
                datos.setIdTercero(item.getIdPago());
                datos.setFecha(item.getFecha());
                datos.setEstado(item.getEstadoPago());
                datos.setBanco(item.getBBancoEnum());
                datos.setDescripcion(item.getDescription());
                datos.setDetalles(item.getResultMsg());
                datos.setIdBanco(item.getBankCode());
                datos.setIdTM(item.getTmCode());
                datos.setImoprte(item.getImporte() + " " + item.getMoneda());
                datos.setSource(item.getSource());
                datos.setExternalCode(item.getExternalCode());
                datos.setImporte(item.getImporte());
                datos.setUsuario(item.getUser());
                nz5e9USlvI.this.mostrarPago(datos);
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ceqvpjycutcwq, container, false);
        this.context = container.getContext();
        this.rvList = (RecyclerView) this.rootView.findViewById(R.id.rvList);
        this.scrollView = (NestedScrollView) this.rootView.findViewById(R.id.scrollView);
        this.pBarLoad = (ProgressBar) this.rootView.findViewById(R.id.pBarLoad);
        this.floatingActionButton = (FloatingActionButton) this.rootView.findViewById(R.id.floatingActionButton);
        this.pBarLoad.setVisibility(8);
        this.txTotal = (TextView) this.rootView.findViewById(R.id.txTotal);
        this.lockUpdate = false;
        this.page = 0;
        this.incremento = 8;
        this.list = new ArrayList();
        this.filtro = new zKgYf9THHQ();
        this.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.1
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    nz5e9USlvI.this.pBarLoad.setVisibility(0);
                    nz5e9USlvI nz5e9uslvi = nz5e9USlvI.this;
                    nz5e9uslvi.filtro.setStartRow(nz5e9uslvi.page);
                    nz5e9USlvI.this.fillAdapter();
                }
            }
        });
        this.rvList.setItemAnimator(new DefaultItemAnimator());
        this.rvList.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        this.rvList.setLayoutManager(lLyManager);
        this.rvList.setNestedScrollingEnabled(false);
        this.pagosPresenter = new XLzsiVGnie(this, this.context);
        this.devPresenter = new j8e1KQ8gfS(this, this.context);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData(container);
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_PAGOS)) {
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
            if (!this.lockUpdate) {
                this.lockUpdate = true;
                this.list.clear();
                this.rvList.setAdapter(null);
                fillAdapter();
            } else {
                Context context = this.context;
                Toast.makeText(context, context.getString(R.string.tx_carga_datos), 0).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jfDH3IIARO, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.2
            @Override // java.lang.Runnable
            public void run() {
                nz5e9USlvI.this.mProgressView.setVisibility(visibility);
            }
        });
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
            this.pagosPresenter.getPagos(this.filtro);
            return;
        }
        this.lockUpdate = false;
        this.mProgressView.setVisibility(4);
        ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jfDH3IIARO
    public void onResult(Boolean result, int code, String mensaje, j670rPXODo response) {
        this.lockUpdate = false;
        this.pBarLoad.setVisibility(4);
        this.mProgressView.setVisibility(4);
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
                    for (s5BkGOZ35ku item : response.getItemsList()) {
                        this.list.add(item);
                    }
                }
            } else if (response.getItemsList() != null && response.getItemsList().size() > 0) {
                this.list = response.getItemsList();
            }
            List<s5BkGOZ35ku> list = this.list;
            if (list != null && list.size() > 0) {
                H3vGbSAwSo3 h3vGbSAwSo3 = new H3vGbSAwSo3(this.context, this.list);
                this.listPagosAdapter = h3vGbSAwSo3;
                this.rvList.setAdapter(h3vGbSAwSo3);
                this.listPagosAdapter.setOnItemClickListener(this.onItemClickListener);
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                this.filtroResult = (O19Uv2NP7rT.FiltroResult) data.getSerializableExtra("filtro");
                zKgYf9THHQ pagoFiltro = new zKgYf9THHQ();
                zKgYf9THHQ.Filters filters = pagoFiltro.getFilters();
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
                if (this.filtroResult.getEstados() != null && this.filtroResult.getEstados().length > 0) {
                    filters.setStatus(this.filtroResult.getEstados());
                }
                if (this.filtroResult.getUser() != null && !this.filtroResult.getUser().isEmpty()) {
                    filters.setCreate_user(this.filtroResult.getUser());
                }
                pagoFiltro.setPage(0);
                this.page = 0;
                this.totalFiltrado = 0;
                this.totalCompleto = 0;
                this.list = new ArrayList();
                this.filtro = pagoFiltro;
                this.pagosPresenter.getPagos(pagoFiltro);
                return;
            }
            return;
        }
        if (requestCode == 2) {
            RKxbomWW57 datosResult = (RKxbomWW57) data.getSerializableExtra("PAGO");
            mostrarDevolverPago(datosResult);
        } else if (requestCode == 3) {
            FhtwnBtOAx result = (FhtwnBtOAx) data.getSerializableExtra("PAGO");
            this.devPresenter.devolverPago(result);
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResultDevolucion(Boolean result, int code, String mensaje, qztlzqkyWH response) {
        if (result.booleanValue()) {
            if (response.isOK()) {
                String mdev = this.context.getString(R.string.msg_dev_procesada) + response.getRefund();
                ShowMessageADialog(this.context.getString(R.string.head_notificacion), mdev);
                return;
            }
            ShowMessageADialog(this.context.getString(R.string.head_notificacion), response.getMenssage());
            return;
        }
        ShowMessageADialog(this.context.getString(R.string.head_notificacion), response.getMenssage());
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM
    public void onResult(Boolean result, int code, String mensaje, PYjuxvJ5mg response) {
    }

    private void showFilter() {
        DialogFragment dialogFrag = new O19Uv2NP7rT();
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }

    private void implementSearch(Menu menu) {
        SearchManager searchManager = (SearchManager) this.context.getSystemService("search");
        final MenuItem searchMenuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(this.activity.getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.3
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                Log.i(nz5e9USlvI.this.HEAD_LOG, " QUERY CLOSE searchView");
                searchView.clearFocus();
                searchView.setQuery(BuildConfig.FLAVOR, false);
                searchView.setIconified(true);
                searchMenuItem.collapseActionView();
                searchView.clearFocus();
                return false;
            }
        });
        searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.4
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem item) {
                new Handler().post(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        searchView.requestFocus();
                        InputMethodManager imm = (InputMethodManager) nz5e9USlvI.this.context.getSystemService("input_method");
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
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.5
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                Log.i(nz5e9USlvI.this.HEAD_LOG, " QUERY SUBMIT:" + query);
                return false;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                Log.i(nz5e9USlvI.this.HEAD_LOG, " QUERY:" + newText);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.6
            @Override // android.widget.SearchView.OnCloseListener
            public boolean onClose() {
                Log.i(nz5e9USlvI.this.HEAD_LOG, " QUERY CLOSE");
                searchView.clearFocus();
                searchView.setQuery(BuildConfig.FLAVOR, false);
                searchView.setIconified(true);
                searchMenuItem.collapseActionView();
                searchView.clearFocus();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarPago(RKxbomWW57 datos) {
        Z5fUajldziN dialogFrag = Z5fUajldziN.newInstance(datos);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 2);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_mostrar_PAGO");
    }

    private void mostrarDevolverPago(RKxbomWW57 devolverRequest) {
        isiTmFZ2lx dialogFrag = isiTmFZ2lx.newInstance(devolverRequest);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 3);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_devolver_PAGO");
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.7
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(nz5e9USlvI.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
