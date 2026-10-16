package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.A9IFPpW4HW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.VqNI4JnvJD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.cwVwMsOO60;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.yzFfgPWLpL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.BpgQdOQz0p;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.CepWe39cnz;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.H4bU7yMkJJK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.ee4tsHNQiS;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.f03gMUuBeK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.tKjjxHr2PT;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.yww1pS0VKU;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class N9YZcaVn8GC extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = N9YZcaVn8GC.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass11.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new ee4tsHNQiS()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new f03gMUuBeK()).addToBackStack(null).commit();
                        break;
                    case 3:
                        N9YZcaVn8GC.this.showDialogAgenteOperTelefono();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new yww1pS0VKU()).addToBackStack(null).commit();
                        break;
                    case 5:
                        mFragmentTransaction.replace(R.id.containerView, new CepWe39cnz()).addToBackStack(null).commit();
                        break;
                    case 6:
                        mFragmentTransaction.replace(R.id.containerView, new BpgQdOQz0p()).addToBackStack(null).commit();
                        break;
                    case 7:
                        mFragmentTransaction.replace(R.id.containerView, new tKjjxHr2PT()).addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(N9YZcaVn8GC.this.context, operacion.toString(), 1).show();
                        break;
                }
            }
        }
    };
    public View rootView;
    public RecyclerView rvseguridad;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.rvseguridad = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        this.rvseguridad.setLayoutManager(llmSegidad);
        initData();
        return this.rootView;
    }

    private void initData() {
        List<WUULVgZq02> itemsOperaciones = new ArrayList<>();
        WUULVgZq02 ag1 = new WUULVgZq02();
        ag1.setTitulo(getString(R.string.banco_telefono));
        ag1.setSubtitulo(getString(R.string.banco_sub_telefono));
        ag1.setIcono(R.drawable.ic_pagar_factura_telf_agente);
        Integer num = rBXnNc0Kx4.Post;
        ag1.setType(num);
        ag1.setOperacion(FdonIAFI9w.BOLSAAGFacturaTelefonica);
        itemsOperaciones.add(ag1);
        WUULVgZq02 ag2 = new WUULVgZq02();
        ag2.setTitulo(getString(R.string.menu_title_recarga_movil_bolsa));
        ag2.setSubtitulo(getString(R.string.menu_sub_recarga_movil_bolsa));
        ag2.setIcono(R.drawable.ic_recarga_movil_agente);
        ag2.setType(num);
        ag2.setOperacion(FdonIAFI9w.BOLSAAGRecargaMovil);
        itemsOperaciones.add(ag2);
        WUULVgZq02 ag3 = new WUULVgZq02();
        ag3.setTitulo(getString(R.string.title_recargar_nauta_bolsa));
        ag3.setSubtitulo(getString(R.string.title_detail_recargar_nauta));
        ag3.setIcono(R.drawable.ic_recargar_naura_cupon_agente);
        ag3.setType(num);
        ag3.setOperacion(FdonIAFI9w.BOLSAAGCuponNauta);
        itemsOperaciones.add(ag3);
        WUULVgZq02 ag4 = new WUULVgZq02();
        ag4.setTitulo(getString(R.string.title_recarga_nauta));
        ag4.setSubtitulo(getString(R.string.sub_recarga_nauta));
        ag4.setIcono(R.drawable.ic_recarga_nauta_agente);
        ag4.setType(num);
        ag4.setOperacion(FdonIAFI9w.BOLSAAGRecargaNauta);
        itemsOperaciones.add(ag4);
        WUULVgZq02 ag5 = new WUULVgZq02();
        ag5.setTitulo(getString(R.string.hint_recarga_propia));
        ag5.setSubtitulo(getString(R.string.hint_subtitle_recarga_propia));
        ag5.setIcono(R.drawable.ic_recarga_propia_agente);
        ag5.setType(num);
        ag5.setOperacion(FdonIAFI9w.BOLSAAGRecargaPropia);
        itemsOperaciones.add(ag5);
        WUULVgZq02 ag6 = new WUULVgZq02();
        ag6.setTitulo(getString(R.string.head_paquetes_cubacel));
        ag6.setSubtitulo(getString(R.string.sub_compra_paquetes));
        ag6.setIcono(R.drawable.ic_compra_planes_agente);
        ag6.setType(num);
        ag6.setOperacion(FdonIAFI9w.BOLSAAGPaquetesCubacel);
        itemsOperaciones.add(ag6);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC$11, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BOLSAAGFacturaTelefonica.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGRecargaMovil.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGCuponNauta.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGRecargaNauta.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGConsultaCuponNauta.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGRecargaPropia.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAGPaquetesCubacel.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogAgenteOperTelefono() {
        CharSequence[] items = {this.context.getString(R.string.tx_opcion_ag_telefono_recarga), this.context.getString(R.string.tx_opcion_ag_telefono_consulta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = N9YZcaVn8GC.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new H4bU7yMkJJK()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new CepWe39cnz()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogRecargaAgenteConAgenciaenK() {
        CharSequence[] items = getResources().getStringArray(R.array.array_ag_recarga_movil_agencia);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = N9YZcaVn8GC.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new cwVwMsOO60()).addToBackStack(null).commit();
                        break;
                    case 1:
                        N9YZcaVn8GC.this.showDialogConsultaSaldo();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new A9IFPpW4HW()).addToBackStack(null).commit();
                        break;
                    case 3:
                        N9YZcaVn8GC.this.showDialogUltimasRecargas();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new VqNI4JnvJD()).addToBackStack(null).commit();
                        break;
                    case 5:
                        N9YZcaVn8GC.this.showDialogCerrarSession();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_consultar_saldo_stock));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ((IHVTCBmiLV) N9YZcaVn8GC.this.getActivity()).actionCallUSSD("11*2");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ((IHVTCBmiLV) N9YZcaVn8GC.this.getActivity()).actionCallUSSD("11*6");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUltimasRecargas() {
        CharSequence[] items = {this.context.getString(R.string.msg_ilt_recharge_all), this.context.getString(R.string.msg_ult_recharge_cell)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ((IHVTCBmiLV) N9YZcaVn8GC.this.getActivity()).actionCallUSSD("11*4");
                    return;
                }
                FragmentManager mFragmentManager = N9YZcaVn8GC.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new yzFfgPWLpL()).addToBackStack(null).commit();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
