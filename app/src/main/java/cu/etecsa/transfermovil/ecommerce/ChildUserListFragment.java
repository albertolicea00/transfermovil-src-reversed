package cu.etecsa.transfermovil.ecommerce;

import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ibvd0DUkXb;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.xoBMVddCFw;
import cu.etecsa.transfermovil.ecommerce.model.response.ChildUserListResponse;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import cu.etecsa.transfermovil.ecommerce.domain.entity.ChildUser;
import java.util.ArrayList;

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
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.JpFlOZXEDx;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX
 * @original_apk_version 1.260416
 * List UI migrated to typed results; detail/editor/grants remain legacy screens.
 */
public class ChildUserListFragment extends Fragment implements ChildUserPresenter.Callback, p5UHWIhp4aH {
    public Activity activity;
    public FloatingActionButton btAdd;
    public Context context;
    public s7v6K7WoKk7 listUserAdapter;
    private ProgressBar mProgressView;
    public s7v6K7WoKk7.OnItemClickListener onItemClickListener = new s7v6K7WoKk7.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserListFragment.3
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
        public void onGetItemClick(View view, int position, int id) {
            FragmentManager mFragmentManager = ChildUserListFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            xoBMVddCFw child = new xoBMVddCFw();
            Bundle arg = new Bundle();
            arg.putInt("ID", id);
            child.setArguments(arg);
            mFragmentTransaction.replace(R.id.containerView, child).addToBackStack(null).commit();
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
        public void onGetLongItemClick(View view, int position, int id) {
            ChildUserListFragment.this.usersListPresenter.detail(id);
        }

        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.s7v6K7WoKk7.OnItemClickListener
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
                ArrayList<JpFlOZXEDx> rows = new ArrayList<>();
                for (ChildUser user : users) {
                    JpFlOZXEDx row = new JpFlOZXEDx();
                    row.setIdUser(user.getIdUser());
                    row.setNombre(user.getNombre());
                    row.setCorreo(user.getCorreo());
                    row.setAvatar(user.getAvatar());
                    row.setCreado(user.getCreado());
                    row.setUpdateAt(user.getUpdateAt());
                    row.setActivo(user.isActivo());
                    rows.add(row);
                }
                txTotal.setText(String.valueOf(rows.size()));
                listUserAdapter = new s7v6K7WoKk7(context, rows);
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
            mostrarUpdateUser(toLegacyUser(response.getUser()));
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

    /** Explicit boundary while the source-backed editor still takes raw models. */
    private static ME8KWex9OS.YjMcWATWMD toLegacyUser(UserWithRolesResponse.User user) {
        ME8KWex9OS.YjMcWATWMD result = new ME8KWex9OS.YjMcWATWMD();
        result.setId(user.getId());
        result.setUsername(user.getUsername());
        result.setEmail(user.getEmail());
        result.setDni(user.getDni());
        result.setPhone(user.getPhone());
        result.setAddress(user.getAddress());
        result.setPhoto(user.getPhoto());
        result.setUpdateAt(user.getUpdateAt());
        if (user.getProvince() != null) {
            cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ province =
                    new cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ();
            province.setCod_provincia(user.getProvince().getCod_provincia());
            province.setAbreviatura(user.getProvince().getAbreviatura());
            province.setNombre(user.getProvince().getNombre());
            result.setProvince(province);
        }
        if (user.getMunicipality() != null) {
            cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM municipality =
                    new cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM();
            municipality.setId(user.getMunicipality().getId());
            municipality.setCod_provincia(user.getMunicipality().getCod_provincia());
            municipality.setCod_municipio(user.getMunicipality().getCod_municipio());
            municipality.setAbreviatura(user.getMunicipality().getAbreviatura());
            municipality.setNombre(user.getMunicipality().getNombre());
            result.setMunicipality(municipality);
        }
        return result;
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

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH
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
        GB0CGE0H88.PermisosDialogRequest request = new GB0CGE0H88.PermisosDialogRequest();
        request.setEstado(activo);
        request.setIdUsuario(id);
        GB0CGE0H88 dialogFrag = GB0CGE0H88.newInstance(request);
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager(), "fragment_alert");
    }
}
