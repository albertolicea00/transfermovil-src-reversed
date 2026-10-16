package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g1bQ0lLj6na extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = g1bQ0lLj6na.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    mFragmentTransaction.replace(R.id.containerView, new cwVwMsOO60()).addToBackStack(null).commit();
                    break;
                case 1:
                    g1bQ0lLj6na.this.showDialogConsultaSaldo();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new A9IFPpW4HW()).addToBackStack(null).commit();
                    break;
                case 3:
                    g1bQ0lLj6na.this.showDialogUltimasRecargas();
                    break;
                case 4:
                    mFragmentTransaction.replace(R.id.containerView, new VqNI4JnvJD()).addToBackStack(null).commit();
                    break;
                case 5:
                    g1bQ0lLj6na.this.showDialogCerrarSession();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.context);
        rv.setLayoutManager(llm);
        List<WUULVgZq02> items = new ArrayList<>();
        WUULVgZq02 autenticar = new WUULVgZq02();
        autenticar.setTitulo(this.context.getString(R.string.title_autenticar_recarga_movil));
        autenticar.setSubtitulo(this.context.getString(R.string.title_autenticar_detaik));
        autenticar.setIcono(R.drawable.ic_autenticacion_agente);
        items.add(autenticar);
        WUULVgZq02 consulta = new WUULVgZq02();
        consulta.setTitulo(this.context.getString(R.string.title_consultar_saldo_agente));
        consulta.setSubtitulo(this.context.getString(R.string.title_detail_consultar_saldo));
        consulta.setIcono(R.drawable.ic_consultar_saldo_agente);
        items.add(consulta);
        WUULVgZq02 recargar = new WUULVgZq02();
        recargar.setTitulo(this.context.getString(R.string.title_recargar_movil_agente));
        recargar.setSubtitulo(this.context.getString(R.string.OP_Recg_movil));
        recargar.setIcono(R.drawable.ic_recarga_movil_agente);
        items.add(recargar);
        WUULVgZq02 ultimos = new WUULVgZq02();
        ultimos.setTitulo(this.context.getString(R.string.OP_Ult_Recargas));
        ultimos.setSubtitulo(this.context.getString(R.string.OP_Ult_Recagargas_Option));
        ultimos.setIcono(R.drawable.ic_ultimas_recargas_agente);
        items.add(ultimos);
        WUULVgZq02 cambiapass = new WUULVgZq02();
        cambiapass.setTitulo(this.context.getString(R.string.title_cambiar_clave));
        cambiapass.setSubtitulo(this.context.getString(R.string.title_detail_cambio_clave_agente));
        cambiapass.setIcono(R.drawable.ic_cambio_pin_agente);
        items.add(cambiapass);
        WUULVgZq02 desconectar = new WUULVgZq02();
        desconectar.setTitulo(this.context.getString(R.string.title_desconectar));
        desconectar.setSubtitulo(this.context.getString(R.string.OP_Close_Session));
        desconectar.setIcono(R.drawable.ic_desconcetarse_agente);
        items.add(desconectar);
        lkLP9buUCl adapter = new lkLP9buUCl(this.context, items);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_consultar_saldo_stock));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ((IHVTCBmiLV) g1bQ0lLj6na.this.getActivity()).actionCallUSSD("11*2");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.3
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                ((IHVTCBmiLV) g1bQ0lLj6na.this.getActivity()).actionCallUSSD("11*6");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.5
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
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.Tpv6wiFh8L6.g1bQ0lLj6na.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ((IHVTCBmiLV) g1bQ0lLj6na.this.getActivity()).actionCallUSSD("11*4");
                    return;
                }
                FragmentManager mFragmentManager = g1bQ0lLj6na.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new yzFfgPWLpL()).addToBackStack(null).commit();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
