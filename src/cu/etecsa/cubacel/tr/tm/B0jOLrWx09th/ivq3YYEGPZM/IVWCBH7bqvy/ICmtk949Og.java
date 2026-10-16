package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.IVWCBH7bqvy;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ICmtk949Og extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.IVWCBH7bqvy.ICmtk949Og.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = ICmtk949Og.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    mFragmentTransaction.replace(R.id.containerView, new b0kkzvOCEu()).addToBackStack(null).commit();
                    break;
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new C8l2t8799rL()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new E1lhoLKryWP()).addToBackStack(null).commit();
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
        registro.setTitulo("Recarga TU Movil con Bono");
        registro.setSubtitulo("Recagar movil con bono");
        registro.setIcono(R.drawable.ico_gestion_recarga_color);
        itemsSeguridad.add(registro);
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo("Transferir TU Saldo");
        autenticarse.setSubtitulo("Transferencia de saldo");
        autenticarse.setIcono(R.drawable.ico_gestion_tranferir_color);
        itemsSeguridad.add(autenticarse);
        WUULVgZq02 transferir = new WUULVgZq02();
        transferir.setTitulo("Cambiar tu clave de recarga");
        transferir.setSubtitulo("Cambie su clave de recarga por defecto 1234");
        transferir.setIcono(R.drawable.ico_gestion_tranferir_color);
        itemsSeguridad.add(transferir);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsSeguridad);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }
}
