package cu.etecsa.tm.ecommerce.LaIvmOMkyve;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.tm.ecommerce.H9l22AIYKkA;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.S8XNGD9qdg78.m8VcbqsQfBi;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.buhgLM4UPhf.RjBvMOuknd;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.hktnNTZUSX;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr.XCZV6od7yh;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.sAtc0TWVQkk.nz5e9USlvI;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.cT6z0jcLEG;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OSQajAAbpl;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j2tvTITC0Z;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj;
import cu.etecsa.tm.ecommerce.a7Y4bbw8Os;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.Date;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class PVrNBPiBYx extends Fragment implements Df8kK2jSQl {
    public FloatingActionButton btGoTPos;
    public ImageView btMenuUser;
    public CardView cdConfiguracion;
    public CardView cdDevolucion;
    public CardView cdEstadisticas;
    public CardView cdNegocio;
    public CardView cdPagos;
    public CardView cdUsers;
    public Context context;
    public Y5RKazbgNj estadisticasPresenter;
    public ImageView imAvatar;
    public ProgressBar pLoadDiario;
    public ProgressBar pLoadMensual;
    public ProgressBar pLoadSemanal;
    public View rootView;
    public TextView txDiario;
    public TextView txMensual;
    public TextView txNombre;
    public TextView txSemanal;
    public View.OnClickListener onUsers = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_USUARIOS) || PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_USERS_HIJOS)) {
                FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new hktnNTZUSX()).addToBackStack(null).commit();
            } else {
                Context context = PVrNBPiBYx.this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        }
    };
    public View.OnClickListener onPagos = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_PAGOS) || PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.GESTIONAR_PAGOS)) {
                FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new nz5e9USlvI()).addToBackStack(null).commit();
            } else {
                Context context = PVrNBPiBYx.this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        }
    };
    public View.OnClickListener onDevolucion = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_DEVOLUCION) || PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.GESTIONAR_DEVOLUCION)) {
                FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new m8VcbqsQfBi()).addToBackStack(null).commit();
            } else {
                Context context = PVrNBPiBYx.this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        }
    };
    public View.OnClickListener onNegocios = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_DEVOLUCION) || PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.GESTIONAR_DEVOLUCION)) {
                FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new RjBvMOuknd()).addToBackStack(null).commit();
            } else {
                Context context = PVrNBPiBYx.this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        }
    };
    public View.OnClickListener onConfiguracion = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.containerView, new xRHOwBkpfj()).addToBackStack(null).commit();
        }
    };
    public View.OnClickListener onGoTPOS = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.7
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intent intent = new Intent(PVrNBPiBYx.this.getActivity(), (Class<?>) H9l22AIYKkA.class);
            View androidRobotView = PVrNBPiBYx.this.rootView.findViewById(R.id.homeContraint);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PVrNBPiBYx.this.getActivity(), androidRobotView, "robot");
            PVrNBPiBYx.this.startActivity(intent, options.toBundle());
        }
    };
    public View.OnClickListener onEstadisticas = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PVrNBPiBYx.this.checkUserPermission(ThptISKBHA.VER_ESTADISTICA)) {
                FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new XCZV6od7yh()).addToBackStack(null).commit();
            } else {
                Context context = PVrNBPiBYx.this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.itb2itx9so9yq, container, false);
        this.context = container.getContext();
        this.cdUsers = (CardView) this.rootView.findViewById(R.id.cdUsers);
        this.cdNegocio = (CardView) this.rootView.findViewById(R.id.cdNegocio);
        this.cdPagos = (CardView) this.rootView.findViewById(R.id.cdPagos);
        this.cdDevolucion = (CardView) this.rootView.findViewById(R.id.cdDevolucion);
        this.cdConfiguracion = (CardView) this.rootView.findViewById(R.id.cdConfiguracion);
        this.cdEstadisticas = (CardView) this.rootView.findViewById(R.id.cdEstadisticas);
        this.btGoTPos = (FloatingActionButton) this.rootView.findViewById(R.id.btGoTPos);
        this.cdUsers.setOnClickListener(this.onUsers);
        this.cdPagos.setOnClickListener(this.onPagos);
        this.cdDevolucion.setOnClickListener(this.onDevolucion);
        this.cdEstadisticas.setOnClickListener(this.onEstadisticas);
        this.cdNegocio.setOnClickListener(this.onNegocios);
        this.btGoTPos.setOnClickListener(this.onGoTPOS);
        this.cdConfiguracion.setOnClickListener(this.onConfiguracion);
        this.txNombre = (TextView) this.rootView.findViewById(R.id.txNombre);
        this.imAvatar = (ImageView) this.rootView.findViewById(R.id.imAvatar);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btMenuUser);
        this.btMenuUser = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(PVrNBPiBYx.this.getActivity(), PVrNBPiBYx.this.btMenuUser);
                popup.getMenuInflater().inflate(R.menu.menu_user, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx.1.1
                    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem item) {
                        int i = item.getItemId();
                        if (i == R.id.action_edit) {
                            FragmentManager mFragmentManager = PVrNBPiBYx.this.getActivity().getSupportFragmentManager();
                            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.replace(R.id.containerView, new tUBlYBpX0J()).addToBackStack(null).commit();
                            return true;
                        }
                        if (i != R.id.action_close) {
                            return true;
                        }
                        UhA7J2923N.getInstance().setAccess_token(null);
                        Intent intent = new Intent(PVrNBPiBYx.this.getActivity(), (Class<?>) a7Y4bbw8Os.class);
                        intent.setFlags(335577088);
                        PVrNBPiBYx.this.startActivity(intent);
                        return true;
                    }
                });
                popup.show();
            }
        });
        this.txDiario = (TextView) this.rootView.findViewById(R.id.txDiario);
        this.txSemanal = (TextView) this.rootView.findViewById(R.id.txSemanal);
        this.txMensual = (TextView) this.rootView.findViewById(R.id.txMensual);
        this.pLoadDiario = (ProgressBar) this.rootView.findViewById(R.id.pLoadDiario);
        this.pLoadSemanal = (ProgressBar) this.rootView.findViewById(R.id.pLoadSemanal);
        this.pLoadMensual = (ProgressBar) this.rootView.findViewById(R.id.pLoadMensual);
        this.estadisticasPresenter = new j2tvTITC0Z(this, this.context);
        cargarEstadisticasSimple();
        loadDataProfile();
        setHasOptionsMenu(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return this.rootView;
    }

    public void cargarEstadisticasSimple() {
        this.txDiario.setVisibility(4);
        this.txSemanal.setVisibility(4);
        this.txMensual.setVisibility(4);
        this.pLoadDiario.setVisibility(0);
        this.pLoadMensual.setVisibility(0);
        this.pLoadSemanal.setVisibility(0);
        cT6z0jcLEG request = new cT6z0jcLEG();
        request.setMoneda(UhA7J2923N.getInstance().getPrefCurrency());
        this.estadisticasPresenter.getEstadisticaSimple(request);
    }

    private void loadDataProfile() {
        String username = BuildConfig.FLAVOR;
        if (UhA7J2923N.getInstance().getUsername() != null && UhA7J2923N.getInstance().getUsername().length() > 0) {
            username = UhA7J2923N.getInstance().getUsername().split(" ")[0];
        }
        this.txNombre.setText(username);
        String value = "none";
        if (UhA7J2923N.getInstance().getChangePhotoHome() != null && UhA7J2923N.getInstance().getChangePhotoHome().length() > 0) {
            value = UhA7J2923N.getInstance().getChangePhotoHome();
        }
        if (value.contains("change")) {
            Glide.with(this.context).load(UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + UhA7J2923N.getInstance().getUserid()).centerCrop().signature(new ObjectKey(new Date())).placeholder(R.drawable.ic_avatar).into(this.imAvatar);
            UhA7J2923N.getInstance().setChangePhotoHome("none");
            return;
        }
        Glide.with(this.context).load(UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + UhA7J2923N.getInstance().getUserid()).centerCrop().placeholder(R.drawable.ic_avatar).into(this.imAvatar);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl
    public void onResultEstadisticas(Boolean result, int code, String mensaje, OSQajAAbpl response) {
        if (result.booleanValue()) {
            if (response != null && response.isOK()) {
                try {
                    this.txDiario.setText(String.valueOf(response.getStatsDay()));
                    this.txMensual.setText(String.valueOf(response.getStatsMonth()));
                    this.txSemanal.setText(String.valueOf(response.getStatsWeek()));
                    return;
                } catch (Exception e) {
                    this.txDiario.setText("0");
                    this.txMensual.setText("0");
                    this.txSemanal.setText("0");
                    return;
                }
            }
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl
    public void onSetProgressLoadVisibility(int visibility) {
        if (visibility != 0) {
            this.txDiario.setVisibility(0);
            this.txSemanal.setVisibility(0);
            this.txMensual.setVisibility(0);
            this.pLoadDiario.setVisibility(8);
            this.pLoadMensual.setVisibility(8);
            this.pLoadSemanal.setVisibility(8);
            return;
        }
        this.txDiario.setVisibility(4);
        this.txSemanal.setVisibility(4);
        this.txMensual.setVisibility(4);
        this.pLoadDiario.setVisibility(0);
        this.pLoadMensual.setVisibility(0);
        this.pLoadSemanal.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserPermission(ThptISKBHA grantEnum) {
        String grant = UhA7J2923N.getInstance().getGrants();
        String[] grantList = grant.split(Pattern.quote("|"));
        for (String item : grantList) {
            try {
                int numberGrant = Integer.valueOf(item).intValue();
                if (numberGrant == grantEnum.getNumVal()) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
