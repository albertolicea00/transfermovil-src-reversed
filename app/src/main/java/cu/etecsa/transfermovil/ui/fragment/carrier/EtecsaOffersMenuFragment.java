package cu.etecsa.transfermovil.ui.fragment.carrier;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HzjedYqYeh;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ
 * @original_apk_version 1.260416
 */
public class EtecsaOffersMenuFragment extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = EtecsaOffersMenuFragment.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    EtecsaOffersMenuFragment.this.showSendSMS("2266", "OFERTA", EtecsaOffersMenuFragment.this.context.getString(R.string.msg_confirm_send_sms_ofertas));
                    break;
                case 1:
                    EtecsaOffersMenuFragment.this.showSendSMS("2266", "TARIFA", EtecsaOffersMenuFragment.this.context.getString(R.string.msg_confirm_send_sms_tarifas));
                    break;
                case 2:
                    EtecsaOffersMenuFragment.this.showSendSMS("2266", "PLANES", "Desea enviar un SMS gratis para conocer ofertas de planes (Bolsa nauta, SMS y Voz) actuales");
                    break;
                case 3:
                    EtecsaOffersMenuFragment.this.showSendSMS("2266", "AMIGOS", "Desea enviar un SMS gratis para conocer ofertas del Plan Amigos");
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
        WUULVgZq02 ofertas = new WUULVgZq02();
        ofertas.setTitulo(this.context.getString(R.string.msg_ofertas_etecsa));
        ofertas.setSubtitulo(this.context.getString(R.string.msg_generales_ofertas_etecsa));
        ofertas.setIcono(R.drawable.ic_ofertas_etecsa);
        itemsSeguridad.add(ofertas);
        WUULVgZq02 tarifa = new WUULVgZq02();
        tarifa.setTitulo(this.context.getString(R.string.msg_tarifas_etecsa));
        tarifa.setSubtitulo(this.context.getString(R.string.msg_tarifas_etecsa_detail));
        tarifa.setIcono(R.drawable.ic_tarifas_vigentes);
        itemsSeguridad.add(tarifa);
        WUULVgZq02 planes = new WUULVgZq02();
        planes.setTitulo("Oferta Planes");
        planes.setSubtitulo("Ofertas planes Bolsa Nauta, SMS y Voz");
        planes.setIcono(R.drawable.ic_consultar_oferta_planes);
        itemsSeguridad.add(planes);
        WUULVgZq02 amigos = new WUULVgZq02();
        amigos.setTitulo("Ofertas Amigos");
        amigos.setSubtitulo("Ofertas del Plan Amigos");
        amigos.setIcono(R.drawable.ic_plan_amigos);
        itemsSeguridad.add(amigos);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsSeguridad);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    private void showSendSMS(final String origen, final String messageSms, String messageUser) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(messageUser);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                HzjedYqYeh.send_sms(origen, messageSms, EtecsaOffersMenuFragment.this.getContext());
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
