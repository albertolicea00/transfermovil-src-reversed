package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf;

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

/* JADX INFO: loaded from: classes.dex */
public class s9lZwtvq9Dl extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = s9lZwtvq9Dl.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    Intent ambulanciaIntent = new Intent("android.intent.action.CALL");
                    ambulanciaIntent.setData(Uri.parse("tel:104"));
                    s9lZwtvq9Dl.this.startActivity(ambulanciaIntent);
                    break;
                case 1:
                    Intent bomberos = new Intent("android.intent.action.CALL");
                    bomberos.setData(Uri.parse("tel:105"));
                    s9lZwtvq9Dl.this.startActivity(bomberos);
                    break;
                case 2:
                    Intent pnr = new Intent("android.intent.action.CALL");
                    pnr.setData(Uri.parse("tel:106"));
                    s9lZwtvq9Dl.this.startActivity(pnr);
                    break;
                case 3:
                    Intent salv = new Intent("android.intent.action.CALL");
                    salv.setData(Uri.parse("tel:107"));
                    s9lZwtvq9Dl.this.startActivity(salv);
                    break;
                case 4:
                    Intent drugs = new Intent("android.intent.action.CALL");
                    drugs.setData(Uri.parse("tel:103"));
                    s9lZwtvq9Dl.this.startActivity(drugs);
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

    private void showSendSMS(final String Origen, final String Message_SMS, String Message_User) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(Message_User);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                HzjedYqYeh.send_sms(Origen, Message_SMS, s9lZwtvq9Dl.this.getContext());
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
