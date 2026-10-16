package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.Kw29o4NNrz;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.MqnAp2jnnon.I1YePWjLywK9.NdeFyyhxF1;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KyQXczCdrr extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.KyQXczCdrr.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = KyQXczCdrr.this.getActivity().getSupportFragmentManager();
            Toast.makeText(KyQXczCdrr.this.getContext(), "Recarga " + position, 0);
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    NdeFyyhxF1 rnauta = new NdeFyyhxF1();
                    Bundle args = new Bundle();
                    args.putInt("modulo", 1);
                    rnauta.setArguments(args);
                    mFragmentTransaction.replace(R.id.containerView, rnauta).addToBackStack(null).commit();
                    break;
                case 1:
                    KyQXczCdrr.this.showDialogUltimosPagos();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ris7iu9rethyp, container, false);
        this.context = container.getContext();
        RecyclerView rvnauta = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvnauta.setHasFixedSize(true);
        LinearLayoutManager llmNauta = new LinearLayoutManager(this.context);
        rvnauta.setLayoutManager(llmNauta);
        List<WUULVgZq02> itemsNauta = new ArrayList<>();
        WUULVgZq02 recargar = new WUULVgZq02();
        recargar.setTitulo("Recargar");
        recargar.setSubtitulo("Recargar cuenta nauta");
        recargar.setIcono(R.drawable.ico_agente_nauta_color);
        itemsNauta.add(recargar);
        WUULVgZq02 consultar = new WUULVgZq02();
        consultar.setTitulo("Consultar");
        consultar.setSubtitulo(this.context.getString(R.string.OP_ultimas_nauta));
        consultar.setIcono(R.drawable.ico_agente_ultimas_color);
        itemsNauta.add(consultar);
        lkLP9buUCl adapterNauta = new lkLP9buUCl(this.context, itemsNauta);
        rvnauta.setAdapter(adapterNauta);
        adapterNauta.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUltimosPagos() {
        CharSequence[] items = {this.context.getString(R.string.msg_nauta_consulta_option_one), "Ultimas recargas de una cuenta"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.KyQXczCdrr.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ((S9ycHcoxAzy) KyQXczCdrr.this.getActivity()).actionCallUSSD("91");
                    return;
                }
                FragmentManager mFragmentManager = KyQXczCdrr.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new Kw29o4NNrz()).addToBackStack(null).commit();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
