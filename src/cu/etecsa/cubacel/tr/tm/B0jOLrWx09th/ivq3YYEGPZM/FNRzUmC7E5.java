package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.AjGJz9tVLXv.GMFMyKMnO2;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FNRzUmC7E5 extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = FNRzUmC7E5.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    FNRzUmC7E5.this.showDialogConsultaSaldoPrepago();
                    break;
                case 1:
                    FNRzUmC7E5.this.showDialogConsultaSaldoPostpago();
                    break;
                case 2:
                    GMFMyKMnO2 myCall = new GMFMyKMnO2();
                    Bundle args = new Bundle();
                    args.putInt("operacion", 1);
                    myCall.setArguments(args);
                    mFragmentTransaction.replace(R.id.containerView, myCall).addToBackStack(null).commit();
                    break;
                case 3:
                    GMFMyKMnO2 myCall_Nine = new GMFMyKMnO2();
                    Bundle args1 = new Bundle();
                    args1.putInt("operacion", 2);
                    myCall_Nine.setArguments(args1);
                    mFragmentTransaction.replace(R.id.containerView, myCall_Nine).addToBackStack(null).commit();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.iytq0yq4jywkc, container, false);
        this.context = container.getContext();
        RecyclerView rvseguridad = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvseguridad.setItemAnimator(new DefaultItemAnimator());
        rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        rvseguridad.setLayoutManager(llmSegidad);
        List<WUULVgZq02> itemsSeguridad = new ArrayList<>();
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Consulta tu Saldo Prepago");
        registro.setSubtitulo("Consultar Saldo marcando *222#");
        registro.setIcono(R.drawable.ic_consultar_saldo_222);
        itemsSeguridad.add(registro);
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo("Consulta tu Saldo Pospago");
        autenticarse.setSubtitulo("Consultar Saldo marcando *111#");
        autenticarse.setIcono(R.drawable.ic_consultar_saldo_111);
        itemsSeguridad.add(autenticarse);
        WUULVgZq02 call = new WUULVgZq02();
        call.setTitulo("Realizar LLamada");
        call.setSubtitulo("Llamada");
        call.setIcono(R.drawable.ic_llamar);
        itemsSeguridad.add(call);
        WUULVgZq02 call_nine = new WUULVgZq02();
        call_nine.setTitulo("Llamar con *99");
        call_nine.setSubtitulo("El destinatario paga");
        call_nine.setIcono(R.drawable.ic_llamar_con_99);
        itemsSeguridad.add(call_nine);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsSeguridad);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    private void tipo_operacion() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaSaldoPrepago() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_consultar_saldo_stock));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Uri number = Uri.parse(Uri.parse("tel:*222") + Uri.encode("#"));
                Intent dial = new Intent("android.intent.action.CALL", number);
                FNRzUmC7E5.this.startActivity(dial);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaSaldoPostpago() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_consultar_saldo_stock));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Uri number = Uri.parse(Uri.parse("tel:*111") + Uri.encode("#"));
                Intent dial = new Intent("android.intent.action.CALL", number);
                FNRzUmC7E5.this.startActivity(dial);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.FNRzUmC7E5.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
