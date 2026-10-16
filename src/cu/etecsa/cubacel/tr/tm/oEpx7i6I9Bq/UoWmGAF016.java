package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UoWmGAF016 extends Fragment {
    public Context context;
    public Fr52O1uSYF msap;
    public boolean agente_activo = false;
    public boolean miboleto_activo = false;
    public boolean banco_activo = true;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UoWmGAF016.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = UoWmGAF016.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new WBJpHonI92()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new W2FmEAMdovs()).addToBackStack(null).commit();
                        break;
                    case 3:
                        mFragmentTransaction.replace(R.id.containerView, new b3vEPrhNHF()).addToBackStack(null).commit();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new KeTIEVSfVo()).addToBackStack(null).commit();
                        break;
                    case 5:
                        mFragmentTransaction.replace(R.id.containerView, new xtUiphIcBa()).addToBackStack(null).commit();
                        break;
                    case 6:
                        mFragmentTransaction.replace(R.id.containerView, new ULtRAlRy1V()).addToBackStack(null).commit();
                        break;
                    case 7:
                        mFragmentTransaction.replace(R.id.containerView, new UUlOTi00Yp()).addToBackStack(null).commit();
                        break;
                    case 8:
                        if (UoWmGAF016.this.msap.getCodigoAgente().contains("-1") || UoWmGAF016.this.msap.getCodigoAgente().isEmpty()) {
                            ((S9ycHcoxAzy) UoWmGAF016.this.getActivity()).actionCallUSSD("116");
                        } else {
                            ((IHVTCBmiLV) UoWmGAF016.this.getActivity()).actionCallUSSD("116");
                        }
                        break;
                }
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.msap = new Fr52O1uSYF();
        View rootView = inflater.inflate(R.layout.ykcdtlfvf8q3d, container, false);
        this.context = container.getContext();
        RecyclerView rvfactura = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvfactura.setItemAnimator(new DefaultItemAnimator());
        rvfactura.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        rvfactura.setLayoutManager(llmFactura);
        List<WUULVgZq02> itemsConfiguracion = new ArrayList<>();
        if (this.msap.getCodigoAgente().contains("-1") || this.msap.getCodigoAgente().isEmpty()) {
            WUULVgZq02 habilitarAgente = new WUULVgZq02();
            habilitarAgente.setTitulo(this.context.getString(R.string.txt_config_habilitar_version_agente_menu));
            habilitarAgente.setSubtitulo(this.context.getString(R.string.txt_config_hab_descrip_version_agent));
            habilitarAgente.setIcono(R.drawable.ic_habilitar_version_agente);
            habilitarAgente.setOperacion(FdonIAFI9w.ConfAgente);
            itemsConfiguracion.add(habilitarAgente);
        } else {
            this.agente_activo = true;
        }
        if (this.msap.getCodigoMiBoleto().contains("-1") || this.msap.getCodigoMiBoleto().isEmpty()) {
            WUULVgZq02 habilitarMiBoleto = new WUULVgZq02();
            habilitarMiBoleto.setTitulo(this.context.getString(R.string.txt_config_habilitar_version_miboleto_menu));
            habilitarMiBoleto.setSubtitulo(this.context.getString(R.string.txt_config_hab_descrip_version_miboleto));
            habilitarMiBoleto.setIcono(R.drawable.ic_modulo_vendedor_miboleto);
            habilitarMiBoleto.setOperacion(FdonIAFI9w.ConfMiBoleto);
            itemsConfiguracion.add(habilitarMiBoleto);
        } else {
            this.miboleto_activo = true;
        }
        WUULVgZq02 actualizar = new WUULVgZq02();
        actualizar.setTitulo("Actualizar");
        actualizar.setSubtitulo("Actualizar aplicación libre de costo");
        actualizar.setIcono(R.drawable.ic_update_apk);
        actualizar.setOperacion(FdonIAFI9w.ConfActualizar);
        itemsConfiguracion.add(actualizar);
        WUULVgZq02 salva = new WUULVgZq02();
        salva.setTitulo("Respaldo y Restauras");
        salva.setSubtitulo("Respaldo y Restauras de los datos");
        salva.setIcono(R.drawable.ic_salva_restauras);
        salva.setOperacion(FdonIAFI9w.ConfSalvas);
        itemsConfiguracion.add(salva);
        this.msap.getCodigoBanco();
        if ((!this.msap.getCodigoBanco().contains("-1") || this.msap.getCodigoBanco().isEmpty()) && this.msap.getCodigoBanco().length() < 3) {
            WUULVgZq02 bulevar = new WUULVgZq02();
            bulevar.setTitulo("Bulevar de Transfermóvil");
            bulevar.setSubtitulo("Habilitar bulevar de Transfermóvil");
            bulevar.setIcono(R.drawable.ic_activar_bulevar);
            bulevar.setOperacion(FdonIAFI9w.Bulevar);
            itemsConfiguracion.add(bulevar);
        } else {
            this.agente_activo = true;
        }
        WUULVgZq02 otros = new WUULVgZq02();
        otros.setTitulo("Otras configuraciones");
        otros.setSubtitulo("Ajustes avanzados");
        otros.setIcono(R.drawable.ic_ajustes_avanzados);
        otros.setOperacion(FdonIAFI9w.ConfAvanzadas);
        itemsConfiguracion.add(otros);
        vD9rc3MbTL adapterFactura = new vD9rc3MbTL(this.context, itemsConfiguracion);
        rvfactura.setAdapter(adapterFactura);
        adapterFactura.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UoWmGAF016$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.ConfActualizar.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.ConfAgente.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.ConfMiBoleto.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.ConfCuentas.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.Bulevar.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.ConfSalvas.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.ConfAvanzadas.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.UpdateWallet.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }
}
