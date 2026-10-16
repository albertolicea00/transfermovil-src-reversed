package cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.style.Circle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.ZsIJgHaaO9;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.HD5RIUn7tB;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.v7emp5gRyD;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.X7hwy8FHbt;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.Y8m8V0frIX;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.jTnoQAoHrX;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.o8aJAm1V8Pa;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.ZxjGjcZ9UR;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.hJ45hA3s7Q;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.xc7SYjTCzp;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.WpYPbPBxxh;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.PgpBvfqqU4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.rw0GJVadKk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RjBvMOuknd extends Fragment implements ZsIJgHaaO9, KFxuVD3dg2 {
    public Activity activity;
    public FloatingActionButton btAddNegocio;
    public Context context;
    public rw0GJVadKk cuentasPresenter;
    public List<v7emp5gRyD> list;
    public jTnoQAoHrX listNegocioAdapter;
    public boolean lockUpdate;
    private ProgressBar mProgressView;
    public PgpBvfqqU4 negociosPresenter;
    private ProgressBar pBarLoad;
    public View rootView;
    public RecyclerView rvList;
    public NestedScrollView scrollView;
    public TextView txFiltrado;
    public TextView txTotal;
    public String HEAD_LOG = "RjBvMOuknd";
    public jTnoQAoHrX.OnItemClickListener onItemClickListener = new jTnoQAoHrX.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.2
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.jTnoQAoHrX.OnItemClickListener
        public void onGetItemClick(View view, int position, int id, String descripcionNegocio) {
            U1zgY8gPcNl parameters = new U1zgY8gPcNl();
            parameters.setIdNegocio(String.valueOf(id));
            parameters.setDescripcionNegocio(descripcionNegocio);
            parameters.setOperTypeCuentasCRUD(bDqhGetEjA.OperTypeCuentasCRUD.CREATE);
            RjBvMOuknd.this.mostrarCuenta(parameters);
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.jTnoQAoHrX.OnItemClickListener
        public void onGetLongItemClick(View view, int position, int id) {
            i6zxINJYbmQ request = new i6zxINJYbmQ();
            request.setDescripcion(RjBvMOuknd.this.list.get(position).getTitulo());
            request.setId(id);
            request.setOperTypeNegocioCRUD(nCeySAq4vz.OperTypeNegocioCRUD.UPDATE);
            RjBvMOuknd.this.mostrarNegocio(request);
        }
    };
    public o8aJAm1V8Pa.OnItemClickListener onItemCuentasClickListener = new o8aJAm1V8Pa.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.3
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.o8aJAm1V8Pa.OnItemClickListener
        public void onGetItemClick(View view, int position, int id) {
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.o8aJAm1V8Pa.OnItemClickListener
        public void onGetItemClick(View view, int position, HD5RIUn7tB cuentaNegocio) {
            U1zgY8gPcNl parameters = new U1zgY8gPcNl();
            parameters.setIdNegocio(String.valueOf(cuentaNegocio.getIdNegocio()));
            parameters.setSource(cuentaNegocio.getSource());
            parameters.setDescripcionCuenta(cuentaNegocio.getDescripcion());
            parameters.setIdCuenta(String.valueOf(cuentaNegocio.getId()));
            parameters.setEstado(cuentaNegocio.isActivo());
            RjBvMOuknd.this.mostrarEstadoCuenta(parameters);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:14:0x0053  */
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.o8aJAm1V8Pa.OnItemClickListener
        public void onGetItemCuentaClick(View view, int position, HD5RIUn7tB cuentaNegocio) {
            U1zgY8gPcNl parameters = new U1zgY8gPcNl();
            parameters.setIdNegocio(String.valueOf(cuentaNegocio.getIdNegocio()));
            parameters.setSource(cuentaNegocio.getSource());
            parameters.setDescripcionCuenta(cuentaNegocio.getDescripcion());
            parameters.setIdCuenta(String.valueOf(cuentaNegocio.getId()));
            switch (cuentaNegocio.getMoneda()) {
                case "CUP":
                    parameters.setMoneda(X7hwy8FHbt.CUP);
                    break;
                case "CUC":
                    parameters.setMoneda(X7hwy8FHbt.CUC);
                    break;
                case "USD":
                    parameters.setMoneda(X7hwy8FHbt.USD);
                    break;
            }
            parameters.setOperTypeCuentasCRUD(bDqhGetEjA.OperTypeCuentasCRUD.UPDATE);
            parameters.setDescripcionNegocio(cuentaNegocio.getTituloNegocio());
            RjBvMOuknd.this.mostrarCuenta(parameters);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.idlipgbkshsmx, container, false);
        Context context = container.getContext();
        this.context = context;
        this.negociosPresenter = new WpYPbPBxxh(this, context);
        this.cuentasPresenter = new HLAV6HkYgi(this, this.context);
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.pBarLoad);
        this.pBarLoad = progressBar;
        progressBar.setVisibility(8);
        this.list = new ArrayList();
        this.lockUpdate = false;
        this.txTotal = (TextView) this.rootView.findViewById(R.id.txTotal);
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.rootView.findViewById(R.id.btAddNegocio);
        this.btAddNegocio = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                i6zxINJYbmQ request = new i6zxINJYbmQ();
                request.setOperTypeNegocioCRUD(nCeySAq4vz.OperTypeNegocioCRUD.CREATE);
                RjBvMOuknd.this.mostrarNegocio(request);
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
        initData(container);
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_NEGOCIO)) {
            this.btAddNegocio.hide();
        }
        return this.rootView;
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

    private void initData(View v) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        Circle doubleBounce = new Circle();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        fillAdapter();
    }

    public void fillAdapter() {
        this.lockUpdate = true;
        if (isOnline()) {
            this.negociosPresenter.getNegocios();
            return;
        }
        this.lockUpdate = false;
        this.mProgressView.setVisibility(4);
        ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.ZsIJgHaaO9
    public void onNegociosResult(Boolean result, int code, String mensaje, xc7SYjTCzp response) {
        this.pBarLoad.setVisibility(4);
        this.mProgressView.setVisibility(4);
        this.lockUpdate = false;
        if (result.booleanValue()) {
            List<v7emp5gRyD> itemsList = response.getItemsList();
            this.list = itemsList;
            this.txTotal.setText(String.valueOf(itemsList.size()));
            List<v7emp5gRyD> list = this.list;
            if (list != null && list.size() > 0) {
                jTnoQAoHrX jtnoqaohrx = new jTnoQAoHrX(this.context, this.list, this.onItemCuentasClickListener);
                this.listNegocioAdapter = jtnoqaohrx;
                this.rvList.setAdapter(jtnoqaohrx);
                this.listNegocioAdapter.setOnItemClickListener(this.onItemClickListener);
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
        if (requestCode == 1 && resultCode == 1) {
            i6zxINJYbmQ parameters = (i6zxINJYbmQ) data.getSerializableExtra("PARAMETERS");
            hJ45hA3s7Q request = new hJ45hA3s7Q();
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$nCeySAq4vz$OperTypeNegocioCRUD[parameters.operTypeNegocioCRUD.ordinal()]) {
                case 1:
                    request.setDescriptionBusiness(parameters.getDescripcion());
                    this.negociosPresenter.negocioCRUD(Y8m8V0frIX.CREATE, request);
                    break;
                case 2:
                    request.setDescriptionBusiness(parameters.getDescripcion());
                    this.negociosPresenter.negocioCRUD(Y8m8V0frIX.UPDATE, request);
                    break;
                case 3:
                    request.setId(String.valueOf(parameters.getId()));
                    this.negociosPresenter.negocioCRUD(Y8m8V0frIX.DELETE, request);
                    break;
            }
        }
        if (requestCode == 2 && resultCode == 1) {
            U1zgY8gPcNl parameters2 = (U1zgY8gPcNl) data.getSerializableExtra("PARAMETERS");
            ZxjGjcZ9UR request2 = new ZxjGjcZ9UR();
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$bDqhGetEjA$OperTypeCuentasCRUD[parameters2.operTypeCuentasCRUD.ordinal()]) {
                case 1:
                    request2.setBusiness_id(parameters2.getIdNegocio());
                    request2.setCurrency(parameters2.getMoneda().name());
                    request2.setDescriptionSource(parameters2.getDescripcionCuenta());
                    request2.setSource(parameters2.getSource());
                    this.cuentasPresenter.cuentaCRUD(Y8m8V0frIX.CREATE, request2);
                    break;
                case 2:
                    request2.setBusiness_id(parameters2.getIdNegocio());
                    request2.setCurrency(parameters2.getMoneda().name());
                    request2.setDescriptionSource(parameters2.getDescripcionCuenta());
                    request2.setSource_id(parameters2.getIdCuenta());
                    this.cuentasPresenter.cuentaCRUD(Y8m8V0frIX.UPDATE, request2);
                    break;
                case 3:
                    request2.setId(parameters2.getIdCuenta());
                    this.cuentasPresenter.cuentaCRUD(Y8m8V0frIX.UPDATE, request2);
                    break;
            }
        }
        if (requestCode == 3 && resultCode == 1) {
            U1zgY8gPcNl parameters3 = (U1zgY8gPcNl) data.getSerializableExtra("PARAMETERS");
            this.cuentasPresenter.estadoCuenta(parameters3.isEstado(), parameters3.getSource());
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.ZsIJgHaaO9
    public void onResult(Boolean result, WpYPbPBxxh.OperTypeNegocio operTypeNegocio, String mensaje, kf1rAJ1MG4 response) {
        if (result.booleanValue()) {
            fillAdapter();
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[operTypeNegocio.ordinal()]) {
                case 1:
                    ShowMessageADialog("Notificación", "Negocio creado");
                    break;
                case 2:
                    ShowMessageADialog("Notificación", "Negocio actualizado");
                    break;
                case 3:
                    ShowMessageADialog("Notificación", "Negocio eliminado");
                    break;
            }
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            ShowMessageADialog("Error", mensaje);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarNegocio(i6zxINJYbmQ request) {
        nCeySAq4vz dialogFrag = nCeySAq4vz.newInstance(request);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_negocio_crud");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarCuenta(U1zgY8gPcNl request) {
        bDqhGetEjA dialogFrag = bDqhGetEjA.newInstance(request);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 2);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_negocio_crud");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarEstadoCuenta(U1zgY8gPcNl request) {
        p0cxg0PRR2 dialogFrag = p0cxg0PRR2.newInstance(request);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 3);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_estado_cuenta_crud");
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, int code, String mensaje, sR8QMZUZBy response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, HLAV6HkYgi.OperTypeCuentas operTypeCuentas, String mensaje, kf1rAJ1MG4 response) {
        if (result.booleanValue()) {
            fillAdapter();
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[operTypeCuentas.ordinal()]) {
                case 1:
                    ShowMessageADialog("Notificación", "Cuenta creada");
                    break;
                case 2:
                    ShowMessageADialog("Notificación", "Cuenta actualizada");
                    break;
                case 3:
                    ShowMessageADialog("Notificación", "Cuenta eliminada");
                    break;
                case 4:
                    ShowMessageADialog("Notificación", "Cuenta actualizada");
                    break;
            }
        }
        ShowMessageADialog("Error", mensaje);
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$bDqhGetEjA$OperTypeCuentasCRUD;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$nCeySAq4vz$OperTypeNegocioCRUD;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio;

        static {
            int[] iArr = new int[HLAV6HkYgi.OperTypeCuentas.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas = iArr;
            try {
                iArr[HLAV6HkYgi.OperTypeCuentas.CREAR_CUENTA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[HLAV6HkYgi.OperTypeCuentas.UPDATE_CUENTA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[HLAV6HkYgi.OperTypeCuentas.DELETE_CUENTA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$HLAV6HkYgi$OperTypeCuentas[HLAV6HkYgi.OperTypeCuentas.ESTADO_CUENTA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[WpYPbPBxxh.OperTypeNegocio.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio = iArr2;
            try {
                iArr2[WpYPbPBxxh.OperTypeNegocio.CREAR_NEGOCIO.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[WpYPbPBxxh.OperTypeNegocio.UPDATE_NEGOCIO.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$WpYPbPBxxh$OperTypeNegocio[WpYPbPBxxh.OperTypeNegocio.DELETE_NEGOCIO.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            int[] iArr3 = new int[bDqhGetEjA.OperTypeCuentasCRUD.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$bDqhGetEjA$OperTypeCuentasCRUD = iArr3;
            try {
                iArr3[bDqhGetEjA.OperTypeCuentasCRUD.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$bDqhGetEjA$OperTypeCuentasCRUD[bDqhGetEjA.OperTypeCuentasCRUD.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$bDqhGetEjA$OperTypeCuentasCRUD[bDqhGetEjA.OperTypeCuentasCRUD.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            int[] iArr4 = new int[nCeySAq4vz.OperTypeNegocioCRUD.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$nCeySAq4vz$OperTypeNegocioCRUD = iArr4;
            try {
                iArr4[nCeySAq4vz.OperTypeNegocioCRUD.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$nCeySAq4vz$OperTypeNegocioCRUD[nCeySAq4vz.OperTypeNegocioCRUD.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$LaIvmOMkyve$buhgLM4UPhf$nCeySAq4vz$OperTypeNegocioCRUD[nCeySAq4vz.OperTypeNegocioCRUD.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.ZsIJgHaaO9, cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.4
            @Override // java.lang.Runnable
            public void run() {
                RjBvMOuknd.this.mProgressView.setVisibility(visibility);
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
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.5
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(RjBvMOuknd.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }
}
