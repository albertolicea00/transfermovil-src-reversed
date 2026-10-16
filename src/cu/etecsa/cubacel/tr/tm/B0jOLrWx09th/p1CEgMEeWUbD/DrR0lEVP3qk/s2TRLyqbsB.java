package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk;

import android.content.Context;
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
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s2TRLyqbsB extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.s2TRLyqbsB.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = s2TRLyqbsB.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    mFragmentTransaction.replace(R.id.containerView, new IixhA1yamp()).addToBackStack(null).commit();
                    break;
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new lzGEfceoJu()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new PQmKwgxZd1()).addToBackStack(null).commit();
                    break;
                default:
                    Toast.makeText(s2TRLyqbsB.this.context, "Seguridad " + position, 0).show();
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rvseguridad = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvseguridad.setItemAnimator(new DefaultItemAnimator());
        rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        rvseguridad.setLayoutManager(llmSegidad);
        List<WUULVgZq02> itemsSeguridad = new ArrayList<>();
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Registrarse");
        registro.setSubtitulo("Registrarse en el sistema");
        registro.setIcono(R.drawable.ico_agent_predet_pin);
        itemsSeguridad.add(registro);
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo("Autenticarse");
        autenticarse.setSubtitulo("Autenticarse en el sistema");
        autenticarse.setIcono(R.drawable.ico_agent_consultar_factura);
        itemsSeguridad.add(autenticarse);
        WUULVgZq02 changepass = new WUULVgZq02();
        changepass.setTitulo("Cambiar clave");
        changepass.setSubtitulo("Cambiar la clave de acceso");
        changepass.setIcono(R.drawable.ico_agent_pagar_fact);
        itemsSeguridad.add(changepass);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsSeguridad);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }
}
