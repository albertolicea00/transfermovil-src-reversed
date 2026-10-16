package cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.cyVKjSmMxV;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.bk1v6NAFu8;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.TzJ2tcDcUWM.YjMcWATWMD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.OkZVobY9IO;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.uenFaEQ06N;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GB0CGE0H88 extends DialogFragment implements Xz5tY9X1IR {
    public static final String DATOS_RESPONSE = "PAGO";
    public Activity activity;
    public ImageView btClose;
    public Button btOk;
    public Context context;
    public PermisosDialogRequest datos;
    public List<cyVKjSmMxV> listPermisos;
    public bk1v6NAFu8 listPermisosAdapter;
    private ProgressBar mProgressView;
    public bk1v6NAFu8.OnItemCheckListener onItemCheckListener = new bk1v6NAFu8.OnItemCheckListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.4
        @Override // cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.bk1v6NAFu8.OnItemCheckListener
        public void onGetItemCheck(View view, int position, int id, boolean status) {
            if (GB0CGE0H88.this.listPermisos.size() > 0) {
                GB0CGE0H88.this.listPermisos.get(position).setEstado(status);
            }
        }
    };
    public x4umm6Wzsp8 permisosPresenter;
    public View rootView;
    public RecyclerView rvPermisos;
    public Switch swEstado;
    public TextView txPermisosText;
    public uenFaEQ06N usersListPresenter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.omvbo7v0gigd7, container, false);
        Bundle arg = getArguments();
        this.datos = (PermisosDialogRequest) arg.getSerializable("PAGO");
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        this.txPermisosText = (TextView) this.rootView.findViewById(R.id.txPermisosText);
        this.swEstado = (Switch) this.rootView.findViewById(R.id.swEstado);
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-1);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        this.mProgressView.setVisibility(0);
        this.swEstado.setChecked(this.datos.estado);
        qwlqFYH8aO request = new qwlqFYH8aO();
        YjMcWATWMD userChild = new YjMcWATWMD();
        userChild.setId(String.valueOf(this.datos.getIdUsuario()));
        request.setUser(userChild);
        OkZVobY9IO okZVobY9IO = new OkZVobY9IO(this, this.context);
        this.permisosPresenter = okZVobY9IO;
        okZVobY9IO.permisoChildCRUD(OkZVobY9IO.OperTypePermisos.GET_PERMISOS, request);
        return this.rootView;
    }

    public static GB0CGE0H88 newInstance(PermisosDialogRequest datos) {
        GB0CGE0H88 frag = new GB0CGE0H88();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", datos);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.listPermisos = new ArrayList();
        this.rvPermisos = (RecyclerView) this.rootView.findViewById(R.id.rvPermisos);
        this.swEstado = (Switch) this.rootView.findViewById(R.id.swEstado);
        this.rvPermisos.setItemAnimator(new DefaultItemAnimator());
        this.rvPermisos.setHasFixedSize(true);
        LinearLayoutManager lLyManager = new LinearLayoutManager(this.context);
        this.rvPermisos.setLayoutManager(lLyManager);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GB0CGE0H88.this.dismiss();
            }
        });
        Button button = (Button) this.rootView.findViewById(R.id.btOk);
        this.btOk = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GB0CGE0H88 gb0cge0h88 = GB0CGE0H88.this;
                gb0cge0h88.permisosPresenter.userStatus(gb0cge0h88.datos.getIdUsuario(), GB0CGE0H88.this.datos.estado);
            }
        });
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS) && !UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS_HIJOS)) {
            this.btOk.setVisibility(8);
        }
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.3
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(GB0CGE0H88.this.context).setTitle(title).setMessage(mensaje).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR
    public void onResultPermisos(Boolean result, int code, String mensaje, ToUwD5xX9T permisosResponse) {
        if (result.booleanValue()) {
            this.listPermisos = permisosResponse.getListPermisos();
            this.txPermisosText.setText("PERMISOS");
            List<cyVKjSmMxV> list = this.listPermisos;
            if (list != null && list.size() > 0) {
                bk1v6NAFu8 bk1v6nafu8 = new bk1v6NAFu8(this.context, this.listPermisos);
                this.listPermisosAdapter = bk1v6nafu8;
                this.rvPermisos.setAdapter(bk1v6nafu8);
                this.listPermisosAdapter.setOnItemClickListener(this.onItemCheckListener);
                return;
            }
            Context context = this.context;
            Toast.makeText(context, context.getResources().getString(R.string.tx_no_item_mostrar), 1).show();
            return;
        }
        this.txPermisosText.setText("Listado no disponible");
        Toast.makeText(this.context, mensaje, 1).show();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.GB0CGE0H88.5
            @Override // java.lang.Runnable
            public void run() {
                GB0CGE0H88.this.mProgressView.setVisibility(visibility);
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR
    public void onResult(Boolean result, OkZVobY9IO.OperTypePermisos operTypePermisos, String mensaje, kf1rAJ1MG4 response) {
        if (operTypePermisos == OkZVobY9IO.OperTypePermisos.STATUS_CHILD) {
            if (result.booleanValue()) {
                if (response.isOK()) {
                    u5mpEjsROy permisosRequest = new u5mpEjsROy();
                    List<Integer> permisos = new ArrayList<>();
                    for (cyVKjSmMxV item : this.listPermisos) {
                        if (item.isEstado()) {
                            permisos.add(Integer.valueOf(item.getCodigo()));
                        }
                    }
                    int[] grants = new int[permisos.size()];
                    if (permisos.size() > 0) {
                        for (int i = 0; i < permisos.size(); i++) {
                            grants[i] = permisos.get(i).intValue();
                        }
                    }
                    permisosRequest.setGrants(grants);
                    permisosRequest.setUser_id(this.datos.idUsuario);
                    this.permisosPresenter.permisoChildUpdate(permisosRequest);
                    return;
                }
                ShowMessageADialog(getString(R.string.head_notificacion), "El usuario no ha sido activado: " + mensaje);
                return;
            }
            ShowMessageADialog(getString(R.string.head_notificacion), mensaje);
            return;
        }
        if (operTypePermisos == OkZVobY9IO.OperTypePermisos.UPDATE_PERMISOS) {
            if (result.booleanValue()) {
                if (response.isOK()) {
                    ShowMessageADialog(getString(R.string.head_notificacion), "Permisos actualizados");
                    goToParentForDev();
                    return;
                }
                ShowMessageADialog(getString(R.string.head_notificacion), "El usuario no ha sido activado: " + mensaje);
                return;
            }
            ShowMessageADialog(getString(R.string.head_notificacion), mensaje);
        }
    }

    private void goToParentForDev() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("PAGO", BuildConfig.FLAVOR);
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, returnIntent);
        dismiss();
    }

    public static class PermisosDialogRequest implements Serializable {
        public boolean estado;
        public int idUsuario;
        public List<cyVKjSmMxV> permisoList;

        public int getIdUsuario() {
            return this.idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public boolean isEstado() {
            return this.estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }

        public List<cyVKjSmMxV> getPermisoList() {
            return this.permisoList;
        }

        public void setPermisoList(List<cyVKjSmMxV> permisoList) {
            this.permisoList = permisoList;
        }
    }
}
