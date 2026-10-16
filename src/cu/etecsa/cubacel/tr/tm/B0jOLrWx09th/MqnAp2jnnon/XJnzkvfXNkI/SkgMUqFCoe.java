package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI;

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
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkgMUqFCoe extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.SkgMUqFCoe.3
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = SkgMUqFCoe.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    mFragmentTransaction.replace(R.id.containerView, new Mu8P2X7JEu()).addToBackStack(null).commit();
                    break;
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new vnC9BffKAI()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new R0CqDlLUE6()).addToBackStack(null).commit();
                    break;
                case 3:
                    SkgMUqFCoe.this.showDialogUltimosPagos();
                    break;
                case 4:
                    mFragmentTransaction.replace(R.id.containerView, new JM38ENT2L0()).addToBackStack(null).commit();
                    break;
                default:
                    Toast.makeText(SkgMUqFCoe.this.context, "Factura " + position, 0).show();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rvfactura = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvfactura.setItemAnimator(new DefaultItemAnimator());
        rvfactura.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        rvfactura.setLayoutManager(llmFactura);
        List<WUULVgZq02> itemsFactura = new ArrayList<>();
        WUULVgZq02 prePin = new WUULVgZq02();
        prePin.setTitulo(this.context.getString(R.string.title_pred_tarjeta));
        prePin.setSubtitulo(this.context.getString(R.string.title_establecer_tarjeta));
        prePin.setIcono(R.drawable.ico_agent_predet_pin_color);
        itemsFactura.add(prePin);
        WUULVgZq02 consulta = new WUULVgZq02();
        consulta.setTitulo(this.context.getString(R.string.title_consultar_factura_fija));
        consulta.setSubtitulo(this.context.getString(R.string.OP_Deuda_Telefono));
        consulta.setIcono(R.drawable.ico_agent_consultar_factura_color);
        itemsFactura.add(consulta);
        WUULVgZq02 pagar = new WUULVgZq02();
        pagar.setTitulo(this.context.getString(R.string.pagar_factura));
        pagar.setSubtitulo(this.context.getString(R.string.OP_Consulat_Deuda));
        pagar.setIcono(R.drawable.ico_agent_pagar_fact_color);
        itemsFactura.add(pagar);
        WUULVgZq02 ultimos = new WUULVgZq02();
        ultimos.setTitulo(this.context.getString(R.string.OP_ultimos_pagos));
        ultimos.setSubtitulo(this.context.getString(R.string.OP_Ult_pgos));
        ultimos.setIcono(R.drawable.ico_agente_ultimas_color);
        itemsFactura.add(ultimos);
        WUULVgZq02 repago = new WUULVgZq02();
        repago.setTitulo(this.context.getString(R.string.title_rectificar_pago));
        repago.setSubtitulo(this.context.getString(R.string.title_detail_rectificar));
        repago.setIcono(R.drawable.ico_agent_rect_fact_color);
        itemsFactura.add(repago);
        lkLP9buUCl adapterFactura = new lkLP9buUCl(this.context, itemsFactura);
        rvfactura.setAdapter(adapterFactura);
        adapterFactura.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUltimosPagos() {
        CharSequence[] items = {getString(R.string.opcion_ult_pagos_generales), getString(R.string.opcion_ult_pagos_numero)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.SkgMUqFCoe.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ((IHVTCBmiLV) SkgMUqFCoe.this.getActivity()).actionCallUSSD("3");
                    return;
                }
                FragmentManager mFragmentManager = SkgMUqFCoe.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new JUhL44kV5Z()).addToBackStack(null).commit();
            }
        });
        builder.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.XJnzkvfXNkI.SkgMUqFCoe.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
