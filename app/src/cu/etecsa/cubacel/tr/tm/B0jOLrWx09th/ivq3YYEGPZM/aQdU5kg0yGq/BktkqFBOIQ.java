package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq;

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

/* JADX INFO: loaded from: classes.dex */
public class BktkqFBOIQ extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = BktkqFBOIQ.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    BktkqFBOIQ bktkqFBOIQ = BktkqFBOIQ.this;
                    bktkqFBOIQ.showSendSMS("2266", "OFERTA", bktkqFBOIQ.context.getString(R.string.msg_confirm_send_sms_ofertas));
                    break;
                case 1:
                    BktkqFBOIQ bktkqFBOIQ2 = BktkqFBOIQ.this;
                    bktkqFBOIQ2.showSendSMS("2266", "TARIFA", bktkqFBOIQ2.context.getString(R.string.msg_confirm_send_sms_tarifas));
                    break;
                case 2:
                    BktkqFBOIQ.this.showSendSMS("2266", "PLANES", "Desea enviar un SMS gratis para conocer ofertas de planes (Bolsa nauta, SMS y Voz) actuales");
                    break;
                case 3:
                    BktkqFBOIQ.this.showSendSMS("2266", "AMIGOS", "Desea enviar un SMS gratis para conocer ofertas del Plan Amigos");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showSendSMS(final String Origen, final String Message_SMS, String Message_User) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(Message_User);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                HzjedYqYeh.send_sms(Origen, Message_SMS, BktkqFBOIQ.this.getContext());
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
