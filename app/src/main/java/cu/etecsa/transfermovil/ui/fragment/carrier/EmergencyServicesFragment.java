package cu.etecsa.transfermovil.ui.fragment.carrier;

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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl
 * @original_apk_version 1.260416
 */
public class EmergencyServicesFragment extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = EmergencyServicesFragment.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    Intent ambulanciaIntent = new Intent("android.intent.action.CALL");
                    ambulanciaIntent.setData(Uri.parse("tel:104"));
                    EmergencyServicesFragment.this.startActivity(ambulanciaIntent);
                    break;
                case 1:
                    Intent bomberos = new Intent("android.intent.action.CALL");
                    bomberos.setData(Uri.parse("tel:105"));
                    EmergencyServicesFragment.this.startActivity(bomberos);
                    break;
                case 2:
                    Intent pnr = new Intent("android.intent.action.CALL");
                    pnr.setData(Uri.parse("tel:106"));
                    EmergencyServicesFragment.this.startActivity(pnr);
                    break;
                case 3:
                    Intent salv = new Intent("android.intent.action.CALL");
                    salv.setData(Uri.parse("tel:107"));
                    EmergencyServicesFragment.this.startActivity(salv);
                    break;
                case 4:
                    Intent drugs = new Intent("android.intent.action.CALL");
                    drugs.setData(Uri.parse("tel:103"));
                    EmergencyServicesFragment.this.startActivity(drugs);
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
        WUULVgZq02 a = new WUULVgZq02();
        a.setTitulo(this.context.getString(R.string.title_util_ambulancia));
        a.setSubtitulo(this.context.getString(R.string.msg_util_ambulancia_detail));
        a.setIcono(R.drawable.ic_ambulancia);
        itemsSeguridad.add(a);
        WUULVgZq02 b = new WUULVgZq02();
        b.setTitulo(this.context.getString(R.string.title_util_bombero));
        b.setSubtitulo(this.context.getString(R.string.msg_util_bombero_detail));
        b.setIcono(R.drawable.ic_bomberos);
        itemsSeguridad.add(b);
        WUULVgZq02 p = new WUULVgZq02();
        p.setTitulo(this.context.getString(R.string.title_util_pnr));
        p.setSubtitulo(this.context.getString(R.string.msg_util_policia_detail));
        p.setIcono(R.drawable.ic_policia_pnr);
        itemsSeguridad.add(p);
        WUULVgZq02 bs = new WUULVgZq02();
        bs.setTitulo(this.context.getString(R.string.title_util_marino));
        bs.setSubtitulo(this.context.getString(R.string.msg_util_marino_detail));
        bs.setIcono(R.drawable.ic_salvamento_maritimo);
        itemsSeguridad.add(bs);
        WUULVgZq02 adrugs = new WUULVgZq02();
        adrugs.setTitulo(this.context.getString(R.string.title_util_antidrodas));
        adrugs.setSubtitulo(this.context.getString(R.string.msg_util_antidroga_detail));
        adrugs.setIcono(R.drawable.ic_servicio_antidrogas);
        itemsSeguridad.add(adrugs);
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
                HzjedYqYeh.send_sms(origen, messageSms, EmergencyServicesFragment.this.getContext());
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
