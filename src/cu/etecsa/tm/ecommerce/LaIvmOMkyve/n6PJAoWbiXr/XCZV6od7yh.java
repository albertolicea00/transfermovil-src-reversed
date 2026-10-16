package cu.etecsa.tm.ecommerce.LaIvmOMkyve.n6PJAoWbiXr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.cT6z0jcLEG;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OSQajAAbpl;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.j2tvTITC0Z;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Y5RKazbgNj;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class XCZV6od7yh extends Fragment implements Df8kK2jSQl {
    public Context context;
    public Y5RKazbgNj estadisticasPresenter;
    public boolean lockUpdate;
    public ProgressBar pLoadAnual;
    public ProgressBar pLoadDiario;
    public ProgressBar pLoadMensual;
    public ProgressBar pLoadSemanal;
    public ProgressBar ptxAnualFallido;
    public ProgressBar ptxAnualPago;
    public ProgressBar ptxAnualPend;
    public ProgressBar ptxDevAnualFallido;
    public ProgressBar ptxDevAnualOk;
    public ProgressBar ptxDevAnualPend;
    public ProgressBar ptxDevDayFallido;
    public ProgressBar ptxDevDayOk;
    public ProgressBar ptxDevDayPendiente;
    public ProgressBar ptxDevMesFallido;
    public ProgressBar ptxDevMesOk;
    public ProgressBar ptxDevMesPend;
    public ProgressBar ptxDiaFallos;
    public ProgressBar ptxDiaPagos;
    public ProgressBar ptxMesFallido;
    public ProgressBar ptxMesPago;
    public ProgressBar ptxMesPendiente;
    public ProgressBar pxDiaPend;
    public View rootView;
    public TextView txAnual;
    public TextView txAnualFallido;
    public TextView txAnualPago;
    public TextView txAnualPend;
    public TextView txDevAnualFallido;
    public TextView txDevAnualOk;
    public TextView txDevAnualPend;
    public TextView txDevDayFallido;
    public TextView txDevDayOk;
    public TextView txDevDayPendiente;
    public TextView txDevMesFallido;
    public TextView txDevMesOk;
    public TextView txDevMesPend;
    public TextView txDiaFallos;
    public TextView txDiaPagos;
    public TextView txDiaPend;
    public TextView txDiario;
    public TextView txMensual;
    public TextView txMesFallido;
    public TextView txMesPago;
    public TextView txMesPendiente;
    public TextView txMonedaDev;
    public TextView txMonedaImporte;
    public TextView txMonedaPago;
    public TextView txNombre;
    public TextView txSemanal;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (UhA7J2923N.getInstance().getCompactMode() != null && UhA7J2923N.getInstance().getCompactMode().contains("ON")) {
            this.rootView = inflater.inflate(R.layout.wi0schyo8tfor, container, false);
        } else {
            this.rootView = inflater.inflate(R.layout.ijnd7q943vpf4, container, false);
        }
        this.lockUpdate = false;
        this.context = container.getContext();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        this.txNombre = (TextView) this.rootView.findViewById(R.id.txNombre);
        this.txDiario = (TextView) this.rootView.findViewById(R.id.txDiario);
        this.txSemanal = (TextView) this.rootView.findViewById(R.id.txSemanal);
        this.txMensual = (TextView) this.rootView.findViewById(R.id.txMensual);
        this.txAnual = (TextView) this.rootView.findViewById(R.id.txAnual);
        this.txDiaPagos = (TextView) this.rootView.findViewById(R.id.txDiaPagos);
        this.txDiaPend = (TextView) this.rootView.findViewById(R.id.txDiaPend);
        this.txDiaFallos = (TextView) this.rootView.findViewById(R.id.txDiaFallos);
        this.txMesPago = (TextView) this.rootView.findViewById(R.id.txMesPago);
        this.txMesPendiente = (TextView) this.rootView.findViewById(R.id.txMesPendiente);
        this.txMesFallido = (TextView) this.rootView.findViewById(R.id.txMesFallido);
        this.txAnualPago = (TextView) this.rootView.findViewById(R.id.txAnualPago);
        this.txAnualPend = (TextView) this.rootView.findViewById(R.id.txAnualPend);
        this.txAnualFallido = (TextView) this.rootView.findViewById(R.id.txAnualFallido);
        this.txDevDayOk = (TextView) this.rootView.findViewById(R.id.txDevDayOk);
        this.txDevDayPendiente = (TextView) this.rootView.findViewById(R.id.txDevDayPendiente);
        this.txDevDayFallido = (TextView) this.rootView.findViewById(R.id.txDevDayFallido);
        this.txDevMesOk = (TextView) this.rootView.findViewById(R.id.txDevMesOk);
        this.txDevMesPend = (TextView) this.rootView.findViewById(R.id.txDevMesPend);
        this.txDevMesFallido = (TextView) this.rootView.findViewById(R.id.txDevMesFallido);
        this.txDevAnualOk = (TextView) this.rootView.findViewById(R.id.txDevAnualOk);
        this.txDevAnualPend = (TextView) this.rootView.findViewById(R.id.txDevAnualPend);
        this.txDevAnualFallido = (TextView) this.rootView.findViewById(R.id.txDevAnualFallido);
        this.txMonedaImporte = (TextView) this.rootView.findViewById(R.id.txMonedaImporte);
        this.txMonedaPago = (TextView) this.rootView.findViewById(R.id.txMonedaPago);
        this.txMonedaDev = (TextView) this.rootView.findViewById(R.id.txMonedaDev);
        this.pLoadDiario = (ProgressBar) this.rootView.findViewById(R.id.pLoadDiario);
        this.pLoadSemanal = (ProgressBar) this.rootView.findViewById(R.id.pLoadSemanal);
        this.pLoadMensual = (ProgressBar) this.rootView.findViewById(R.id.pLoadMensual);
        this.pLoadAnual = (ProgressBar) this.rootView.findViewById(R.id.pLoadAnual);
        this.ptxDiaPagos = (ProgressBar) this.rootView.findViewById(R.id.ptxDiaPagos);
        this.pxDiaPend = (ProgressBar) this.rootView.findViewById(R.id.pxDiaPend);
        this.ptxDiaFallos = (ProgressBar) this.rootView.findViewById(R.id.ptxDiaFallos);
        this.ptxMesPago = (ProgressBar) this.rootView.findViewById(R.id.ptxMesPago);
        this.ptxMesPendiente = (ProgressBar) this.rootView.findViewById(R.id.ptxMesPendiente);
        this.ptxMesFallido = (ProgressBar) this.rootView.findViewById(R.id.ptxMesFallido);
        this.ptxAnualPago = (ProgressBar) this.rootView.findViewById(R.id.ptxAnualPago);
        this.ptxAnualPend = (ProgressBar) this.rootView.findViewById(R.id.ptxAnualPend);
        this.ptxAnualFallido = (ProgressBar) this.rootView.findViewById(R.id.ptxAnualFallido);
        this.ptxDevDayOk = (ProgressBar) this.rootView.findViewById(R.id.ptxDevDayOk);
        this.ptxDevDayPendiente = (ProgressBar) this.rootView.findViewById(R.id.ptxDevDayPendiente);
        this.ptxDevDayFallido = (ProgressBar) this.rootView.findViewById(R.id.ptxDevDayFallido);
        this.ptxDevMesOk = (ProgressBar) this.rootView.findViewById(R.id.ptxDevMesOk);
        this.ptxDevMesPend = (ProgressBar) this.rootView.findViewById(R.id.ptxDevMesPend);
        this.ptxDevMesFallido = (ProgressBar) this.rootView.findViewById(R.id.ptxDevMesFallido);
        this.ptxDevAnualOk = (ProgressBar) this.rootView.findViewById(R.id.ptxDevAnualOk);
        this.ptxDevAnualPend = (ProgressBar) this.rootView.findViewById(R.id.ptxDevAnualPend);
        this.ptxDevAnualFallido = (ProgressBar) this.rootView.findViewById(R.id.ptxDevAnualFallido);
        this.estadisticasPresenter = new j2tvTITC0Z(this, this.context);
        fillAdapter();
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_estadistica, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        if (i == R.id.menu_estadistica_resumen) {
            return true;
        }
        if (i == R.id.menu_estadistica_cierre) {
            if (UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.VER_CONCILIACION)) {
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new RM9QrdJZuK()).addToBackStack(null).commit();
            } else {
                Context context = this.context;
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
            return true;
        }
        if (i == R.id.action_update) {
            if (!this.lockUpdate) {
                this.lockUpdate = true;
                fillAdapter();
            } else {
                Context context2 = this.context;
                Toast.makeText(context2, context2.getString(R.string.tx_carga_datos), 0).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void fillAdapter() {
        this.lockUpdate = true;
        cargarEstadisticas();
    }

    public void cargarEstadisticas() {
        this.txDiario.setText("0");
        this.txSemanal.setText("0");
        this.txMensual.setText("0");
        this.txAnual.setText("0");
        this.txDiaPagos.setText("0.0");
        this.txDiaPend.setText("0.0");
        this.txDiaFallos.setText("0.0");
        this.txMesPago.setText("0.0");
        this.txMesPendiente.setText("0.0");
        this.txMesFallido.setText("0.0");
        this.txAnualPago.setText("0.0");
        this.txAnualPend.setText("0.0");
        this.txAnualFallido.setText("0.0");
        this.txDevDayOk.setText("0.0");
        this.txDevDayPendiente.setText("0.0");
        this.txDevDayFallido.setText("0.0");
        this.txDevMesOk.setText("0.0");
        this.txDevMesPend.setText("0.0");
        this.txDevMesFallido.setText("0.0");
        this.txDevAnualOk.setText("0.0");
        this.txDevAnualPend.setText("0.0");
        this.txDevAnualFallido.setText("0.0");
        cT6z0jcLEG request = new cT6z0jcLEG();
        String moneda = "CUP";
        try {
            String aux = UhA7J2923N.getInstance().getPrefCurrency();
            if (aux != null && aux.length() > 0) {
                moneda = aux;
            }
        } catch (Exception e) {
        }
        request.setMoneda(moneda);
        this.txMonedaDev.setText(moneda);
        this.txMonedaImporte.setText(moneda);
        this.txMonedaPago.setText(moneda);
        this.estadisticasPresenter.getEstadisticassTotal(request);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl
    public void onResultEstadisticas(Boolean result, int code, String mensaje, OSQajAAbpl response) {
        this.lockUpdate = false;
        if (result.booleanValue()) {
            this.txDiario.setText(String.valueOf(response.getStatsDay()));
            this.txSemanal.setText(String.valueOf(response.getStatsWeek()));
            this.txMensual.setText(String.valueOf(response.getStatsMonth()));
            this.txAnual.setText(String.valueOf(response.getStatsYear()));
            this.txDiaPagos.setText(String.valueOf(response.getDayConfirm()));
            this.txDiaPend.setText(String.valueOf(response.getDayPend()));
            this.txDiaFallos.setText(String.valueOf(response.getDayAbort()));
            this.txMesPago.setText(String.valueOf(response.getMesConfirm()));
            this.txMesPendiente.setText(String.valueOf(response.getMesPend()));
            this.txMesFallido.setText(String.valueOf(response.getMesAbort()));
            this.txAnualPago.setText(String.valueOf(response.getYearConfirm()));
            this.txAnualPend.setText(String.valueOf(response.getYearPend()));
            this.txAnualFallido.setText(String.valueOf(response.getYearAbort()));
            this.txDevDayOk.setText(String.valueOf(response.getDevDayConfim()));
            this.txDevDayPendiente.setText(String.valueOf(response.getDevDayPend()));
            this.txDevDayFallido.setText(String.valueOf(response.getDevDayAbort()));
            this.txDevMesOk.setText(String.valueOf(response.getDevMesConfirm()));
            this.txDevMesPend.setText(String.valueOf(response.getDevMesPend()));
            this.txDevMesFallido.setText(String.valueOf(response.getDevMesAbort()));
            this.txDevAnualOk.setText(String.valueOf(response.getDevYearConfirm()));
            this.txDevAnualPend.setText(String.valueOf(response.getDevYearPend()));
            this.txDevAnualFallido.setText(String.valueOf(response.getDevYearAbort()));
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(this.context, mensaje, 1).show();
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Df8kK2jSQl
    public void onSetProgressLoadVisibility(int visibility) {
        if (visibility != 0) {
            this.txDiario.setVisibility(0);
            this.txSemanal.setVisibility(0);
            this.txMensual.setVisibility(0);
            this.txAnual.setVisibility(0);
            this.txDiaPagos.setVisibility(0);
            this.txDiaPend.setVisibility(0);
            this.txDiaFallos.setVisibility(0);
            this.txMesPago.setVisibility(0);
            this.txMesPendiente.setVisibility(0);
            this.txMesFallido.setVisibility(0);
            this.txAnualPago.setVisibility(0);
            this.txAnualPend.setVisibility(0);
            this.txAnualFallido.setVisibility(0);
            this.txDevDayOk.setVisibility(0);
            this.txDevDayPendiente.setVisibility(0);
            this.txDevDayFallido.setVisibility(0);
            this.txDevMesOk.setVisibility(0);
            this.txDevMesPend.setVisibility(0);
            this.txDevMesFallido.setVisibility(0);
            this.txDevAnualOk.setVisibility(0);
            this.txDevAnualPend.setVisibility(0);
            this.txDevAnualFallido.setVisibility(0);
            this.pLoadDiario.setVisibility(8);
            this.pLoadMensual.setVisibility(8);
            this.pLoadSemanal.setVisibility(8);
            this.pLoadAnual.setVisibility(8);
            this.pLoadDiario.setVisibility(8);
            this.pLoadMensual.setVisibility(8);
            this.pLoadSemanal.setVisibility(8);
            this.ptxDiaPagos.setVisibility(8);
            this.pxDiaPend.setVisibility(8);
            this.ptxDiaFallos.setVisibility(8);
            this.ptxMesPago.setVisibility(8);
            this.ptxMesPendiente.setVisibility(8);
            this.ptxMesFallido.setVisibility(8);
            this.ptxAnualPago.setVisibility(8);
            this.ptxAnualPend.setVisibility(8);
            this.ptxAnualFallido.setVisibility(8);
            this.ptxDevDayOk.setVisibility(8);
            this.ptxDevDayPendiente.setVisibility(8);
            this.ptxDevDayFallido.setVisibility(8);
            this.ptxDevMesOk.setVisibility(8);
            this.ptxDevMesPend.setVisibility(8);
            this.ptxDevMesFallido.setVisibility(8);
            this.ptxDevAnualOk.setVisibility(8);
            this.ptxDevAnualPend.setVisibility(8);
            this.ptxDevAnualFallido.setVisibility(8);
            return;
        }
        this.txDiario.setVisibility(4);
        this.txSemanal.setVisibility(4);
        this.txMensual.setVisibility(4);
        this.txAnual.setVisibility(4);
        this.txDiaPagos.setVisibility(4);
        this.txDiaPend.setVisibility(4);
        this.txDiaFallos.setVisibility(4);
        this.txMesPago.setVisibility(4);
        this.txMesPendiente.setVisibility(4);
        this.txMesFallido.setVisibility(4);
        this.txAnualPago.setVisibility(4);
        this.txAnualPend.setVisibility(4);
        this.txAnualFallido.setVisibility(4);
        this.txDevDayOk.setVisibility(4);
        this.txDevDayPendiente.setVisibility(4);
        this.txDevDayFallido.setVisibility(4);
        this.txDevMesOk.setVisibility(4);
        this.txDevMesPend.setVisibility(4);
        this.txDevMesFallido.setVisibility(4);
        this.txDevAnualOk.setVisibility(4);
        this.txDevAnualPend.setVisibility(4);
        this.txDevAnualFallido.setVisibility(4);
        this.pLoadDiario.setVisibility(0);
        this.pLoadMensual.setVisibility(0);
        this.pLoadSemanal.setVisibility(0);
        this.pLoadAnual.setVisibility(0);
        this.ptxDiaPagos.setVisibility(0);
        this.pxDiaPend.setVisibility(0);
        this.ptxDiaFallos.setVisibility(0);
        this.ptxMesPago.setVisibility(0);
        this.ptxMesPendiente.setVisibility(0);
        this.ptxMesFallido.setVisibility(0);
        this.ptxAnualPago.setVisibility(0);
        this.ptxAnualPend.setVisibility(0);
        this.ptxAnualFallido.setVisibility(0);
        this.ptxDevDayOk.setVisibility(0);
        this.ptxDevDayPendiente.setVisibility(0);
        this.ptxDevDayFallido.setVisibility(0);
        this.ptxDevMesOk.setVisibility(0);
        this.ptxDevMesPend.setVisibility(0);
        this.ptxDevMesFallido.setVisibility(0);
        this.ptxDevAnualOk.setVisibility(0);
        this.ptxDevAnualPend.setVisibility(0);
        this.ptxDevAnualFallido.setVisibility(0);
    }
}
