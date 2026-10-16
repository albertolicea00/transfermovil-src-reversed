package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.g7yG4Frdxy;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Kgii4NH4Ce extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.Kgii4NH4Ce.1
        public Bundle b = new Bundle();

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = Kgii4NH4Ce.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    this.b.putSerializable("p3NpwYhcUs3", p3NpwYhcUs3.Agregar);
                    break;
                case 1:
                    this.b.putSerializable("p3NpwYhcUs3", p3NpwYhcUs3.Consulta);
                    break;
                case 2:
                    this.b.putSerializable("p3NpwYhcUs3", p3NpwYhcUs3.Pago);
                    break;
                case 3:
                    this.b.putSerializable("p3NpwYhcUs3", p3NpwYhcUs3.Eliminar);
                    break;
                default:
                    Toast.makeText(Kgii4NH4Ce.this.context, "Error! " + position, 0).show();
                    break;
            }
            if (position == 2) {
                g7yG4Frdxy accesoRapidoBANDECFragment = new g7yG4Frdxy();
                accesoRapidoBANDECFragment.setArguments(this.b);
                mFragmentTransaction.replace(R.id.containerView, accesoRapidoBANDECFragment).addToBackStack(null).commit();
            } else {
                q9DNC6bnexm accesoRapidoBANDECFragment2 = new q9DNC6bnexm();
                accesoRapidoBANDECFragment2.setArguments(this.b);
                mFragmentTransaction.replace(R.id.containerView, accesoRapidoBANDECFragment2).addToBackStack(null).commit();
            }
        }
    };
    public View rootView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rvseguridad = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        rvseguridad.setItemAnimator(new DefaultItemAnimator());
        rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        rvseguridad.setLayoutManager(llmSegidad);
        List<WUULVgZq02> itemsOperaciones = new ArrayList<>();
        WUULVgZq02 addFactura = new WUULVgZq02();
        addFactura.setTitulo(this.context.getString(R.string.title_bandec_acc_add));
        addFactura.setSubtitulo(this.context.getString(R.string.detail_bandec_acc_add));
        addFactura.setIcono(R.drawable.ic_add_factura);
        itemsOperaciones.add(addFactura);
        WUULVgZq02 consultar = new WUULVgZq02();
        consultar.setTitulo(this.context.getString(R.string.title_bandec_acc_consultar));
        consultar.setSubtitulo(this.context.getString(R.string.detail_bandec_acc_consultar));
        consultar.setIcono(R.drawable.ic_consultar_factura);
        itemsOperaciones.add(consultar);
        WUULVgZq02 pagar = new WUULVgZq02();
        pagar.setTitulo(this.context.getString(R.string.title_bandec_acc_pagar));
        pagar.setSubtitulo(this.context.getString(R.string.detail_bandec_acc_pagar));
        pagar.setIcono(R.drawable.ic_pagar_factura);
        itemsOperaciones.add(pagar);
        WUULVgZq02 eliminar = new WUULVgZq02();
        eliminar.setTitulo(this.context.getString(R.string.title_bandec_acc_delete));
        eliminar.setSubtitulo(this.context.getString(R.string.detail_bandec_acc_delete));
        eliminar.setIcono(R.drawable.ic_eliminar_factura);
        itemsOperaciones.add(eliminar);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsOperaciones);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return this.rootView;
    }
}
