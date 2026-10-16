package cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.JpFlOZXEDx;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.L8gvrPUGKT;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.MNdSLKzqqG;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class hktnNTZUSX extends Fragment implements jBESo4pBPY, p5UHWIhp4aH {
    public Activity activity;
    public FloatingActionButton btAdd;
    public Context context;
    public s7v6K7WoKk7 listUserAdapter;
    private ProgressBar mProgressView;
    public s7v6K7WoKk7.OnItemClickListener onItemClickListener = new s7v6K7WoKk7.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX.3
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
        public void onGetItemClick(View view, int position, int id) {
            FragmentManager mFragmentManager = hktnNTZUSX.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            xoBMVddCFw child = new xoBMVddCFw();
            Bundle arg = new Bundle();
            arg.putInt("ID", id);
            child.setArguments(arg);
            mFragmentTransaction.replace(R.id.containerView, child).addToBackStack(null).commit();
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
        public void onGetLongItemClick(View view, int position, int id) {
            hktnNTZUSX.this.usersListPresenter.getUserDetail(id);
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
        public void onPermisosItemClick(View view, int id, boolean activo) {
            hktnNTZUSX.this.mostrarPermisos(id, activo);
        }
    };
    public View rootView;
    public RecyclerView rvList;
    public TextView txTotal;
    public uenFaEQ06N usersListPresenter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ynalzon5rqnbv, container, false);
        this.context = container.getContext();
        this.rvList = (RecyclerView) this.rootView.findViewById(R.id.rvList);
        this.txTotal = (TextView) this.rootView.findViewById(R.id.txTotal);
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.rootView.findViewById(R.id.btAdd);
        this.btAdd = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                hktnNTZUSX.this.mostrarCrearUser();
            }
        });
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS) && !UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS_HIJOS)) {
            this.btAdd.hide();
        }
        this.txTotal.setText("0");
        this.rvList.setItemAnimator(new DefaultItemAnimator());
        this.rvList.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        this.rvList.setLayoutManager(lLyManager);
        this.usersListPresenter = new MNdSLKzqqG(this, this.context);
        setHasOptionsMenu(true);
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData(container);
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
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
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-16777216);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        fillAdapter(v);
    }

    public void fillAdapter(View v) {
        if (isOnline()) {
            this.usersListPresenter.getUsers();
        } else {
            this.mProgressView.setVisibility(4);
            ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY
    public void onResult(Boolean result, int code, String mensaje, L8gvrPUGKT usersResponse) {
        if (result.booleanValue()) {
            List<JpFlOZXEDx> list = usersResponse.getItemsList();
            if (list != null && list.size() > 0) {
                this.txTotal.setText(String.valueOf(list.size()));
                s7v6K7WoKk7 s7v6k7wokk7 = new s7v6K7WoKk7(this.context, list);
                this.listUserAdapter = s7v6k7wokk7;
                this.rvList.setAdapter(s7v6k7wokk7);
                this.mProgressView.setVisibility(4);
                this.listUserAdapter.setOnItemClickListener(this.onItemClickListener);
                return;
            }
            Context context = this.context;
            Toast.makeText(context, context.getResources().getString(R.string.tx_no_item_mostrar), 1).show();
            return;
        }
        Toast.makeText(this.context, mensaje, 1).show();
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY
    public void onUserChild(Boolean result, int code, String mensaje, ME8KWex9OS usersResponse) {
        if (result.booleanValue()) {
            if (usersResponse != null && usersResponse.isOK()) {
                mostrarUpdateUser(usersResponse.getUser());
                return;
            } else if (usersResponse.getHttpCode() == 401) {
                UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
                return;
            } else {
                Toast.makeText(this.context, usersResponse.getMenssage(), 1).show();
                return;
            }
        }
        if (usersResponse.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(this.context, usersResponse.getMenssage(), 1).show();
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY
    public void onResultCRUD(Boolean result, MNdSLKzqqG.OperTypeUserList operTypeUserList, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 1) {
            refreshData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarCrearUser() {
        ibvd0DUkXb dialogFrag = new ibvd0DUkXb();
        dialogFrag.setListener(this);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int i = metrics.widthPixels;
        int i2 = metrics.heightPixels;
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_crear_user");
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX.2
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(hktnNTZUSX.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void mostrarUpdateUser(ME8KWex9OS.YjMcWATWMD userChild) {
        ibvd0DUkXb dialogFrag = ibvd0DUkXb.newInstance(userChild);
        dialogFrag.setListener(this);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_crear_user");
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX.4
            @Override // java.lang.Runnable
            public void run() {
                hktnNTZUSX.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH
    public void refreshData() {
        if (isOnline()) {
            this.usersListPresenter.getUsers();
        } else {
            this.mProgressView.setVisibility(4);
            ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarPermisos(int id, boolean activo) {
        GB0CGE0H88.PermisosDialogRequest request = new GB0CGE0H88.PermisosDialogRequest();
        request.setEstado(activo);
        request.setIdUsuario(id);
        GB0CGE0H88 dialogFrag = GB0CGE0H88.newInstance(request);
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }
}
