package cu.etecsa.transfermovil.ecommerce;

import cu.etecsa.transfermovil.ecommerce.model.response.ChildUserListResponse;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import cu.etecsa.transfermovil.ecommerce.domain.entity.ChildUser;

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
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX
 * @original_apk_version 1.260416
 * List UI uses typed results and clean detail/editor screens.
 */
public class ChildUserListFragment extends Fragment implements ChildUserPresenter.Callback, ChildUserRefreshCallback {
    public Activity activity;
    public FloatingActionButton btAdd;
    public Context context;
    public ChildUserAdapter listUserAdapter;
    private ProgressBar mProgressView;
    public ChildUserAdapter.OnItemClickListener onItemClickListener = new ChildUserAdapter.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.3
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.ChildUserAdapter.OnItemClickListener
        public void onGetItemClick(View view, int position, int id) {
            FragmentManager mFragmentManager = ChildUserListFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            ChildUserDetailFragment child = new ChildUserDetailFragment();
            Bundle arg = new Bundle();
            arg.putInt("ID", id);
            child.setArguments(arg);
            mFragmentTransaction.replace(R.id.containerView, child).addToBackStack(null).commit();
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.ChildUserAdapter.OnItemClickListener
        public void onGetLongItemClick(View view, int position, int id) {
            ChildUserListFragment.this.usersListPresenter.detail(id);
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.ChildUserAdapter.OnItemClickListener
        public void onPermisosItemClick(View view, int id, boolean activo) {
            ChildUserListFragment.this.mostrarPermisos(id, activo);
        }
    };
    public View rootView;
    public RecyclerView rvList;
    public TextView txTotal;
    public ChildUserPresenter usersListPresenter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.ynalzon5rqnbv, container, false);
        this.context = container.getContext();
        this.rvList = (RecyclerView) this.rootView.findViewById(R.id.rvList);
        this.txTotal = (TextView) this.rootView.findViewById(R.id.txTotal);
        FloatingActionButton floatingActionButton = (FloatingActionButton) this.rootView.findViewById(R.id.btAdd);
        this.btAdd = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChildUserListFragment.this.mostrarCrearUser();
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
        this.usersListPresenter = new ChildUserPresenter(this.context, null, this);
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
            this.usersListPresenter.list();
        } else {
            this.mProgressView.setVisibility(4);
            ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
        }
    }

    @Override
    public void onListResult(ChildUserListResponse response) {
        if (rootView == null) return;
        if (response.isOK()) {
            List<ChildUser> users = response.getItemsList();
            if (users != null && !users.isEmpty()) {
                txTotal.setText(String.valueOf(users.size()));
                listUserAdapter = new ChildUserAdapter(context, users);
                listUserAdapter.setOnItemClickListener(onItemClickListener);
                rvList.setAdapter(listUserAdapter);
            } else {
                Toast.makeText(context, getResources().getString(R.string.tx_no_item_mostrar), 1).show();
            }
        } else {
            Toast.makeText(context, response.getMenssage(), 1).show();
        }
    }

    @Override
    public void onDetailResult(UserWithRolesResponse response) {
        if (rootView == null) return;
        if (response.isOK() && response.getUser() != null) {
            mostrarUpdateUser(response.getUser());
        } else if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(context, response.getMenssage(), 1).show();
        }
    }

    @Override
    public void onMutationResult(ChildUserPresenter.Operation operation, ApiResponse response) {
        // Like the source list, mutations are owned by the editor/detail dialogs.
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 1) {
            refreshData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarCrearUser() {
        ChildUserEditorDialog dialogFrag = new ChildUserEditorDialog();
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
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.2
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(ChildUserListFragment.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    private void mostrarUpdateUser(UserWithRolesResponse.User userChild) {
        ChildUserEditorDialog dialogFrag = ChildUserEditorDialog.newInstance(userChild);
        dialogFrag.setListener(this);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_crear_user");
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.jBESo4pBPY
    public void onProgressVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (rootView != null) mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;
        rvList = null;
        txTotal = null;
        mProgressView = null;
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService("connectivity");
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserRefreshCallback
    public void refreshData() {
        if (isOnline()) {
            this.usersListPresenter.list();
        } else {
            this.mProgressView.setVisibility(4);
            ShowMessageADialog("Error", this.context.getResources().getString(R.string.err_not_connection));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarPermisos(int id, boolean activo) {
        ChildUserPermissionsDialog.PermisosDialogRequest request = new ChildUserPermissionsDialog.PermisosDialogRequest();
        request.setEstado(activo);
        request.setIdUsuario(id);
        ChildUserPermissionsDialog dialogFrag = ChildUserPermissionsDialog.newInstance(request);
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }
}
