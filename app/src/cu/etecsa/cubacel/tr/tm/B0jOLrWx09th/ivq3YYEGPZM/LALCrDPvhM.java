package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.C8l2t8799rL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.E1lhoLKryWP;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LALCrDPvhM extends Fragment {
    public Context context;
    public lkLP9buUCl.OnItemClickListener onItemClickListener = new lkLP9buUCl.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.LALCrDPvhM.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.lkLP9buUCl.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = LALCrDPvhM.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (position) {
                case 0:
                    mFragmentTransaction.replace(R.id.containerView, new b0kkzvOCEu()).addToBackStack(null).commit();
                    break;
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new C8l2t8799rL()).addToBackStack(null).commit();
                    break;
                case 2:
                    LALCrDPvhM lALCrDPvhM = LALCrDPvhM.this;
                    lALCrDPvhM.showSendUSSD("234", "3", lALCrDPvhM.context.getString(R.string.alert_dialog_msg_adelanta));
                    break;
                case 3:
                    mFragmentTransaction.replace(R.id.containerView, new E1lhoLKryWP()).addToBackStack(null).commit();
                    break;
                case 4:
                    LALCrDPvhM lALCrDPvhM2 = LALCrDPvhM.this;
                    lALCrDPvhM2.showSendUSSD("222", "266", lALCrDPvhM2.context.getString(R.string.alert_dialog_msg_bono_confirm));
                    break;
                case 5:
                    LALCrDPvhM lALCrDPvhM3 = LALCrDPvhM.this;
                    lALCrDPvhM3.showSendUSSD("133", BuildConfig.FLAVOR, lALCrDPvhM3.context.getString(R.string.alert_dialog_msg_gesplanes_confirm));
                    break;
                case 6:
                    LALCrDPvhM lALCrDPvhM4 = LALCrDPvhM.this;
                    lALCrDPvhM4.showSendUSSD("222", "328", lALCrDPvhM4.context.getString(R.string.alert_dialog_msg_consultaplandatos_confirm));
                    break;
                case 7:
                    LALCrDPvhM lALCrDPvhM5 = LALCrDPvhM.this;
                    lALCrDPvhM5.showSendUSSD("222", "869", lALCrDPvhM5.context.getString(R.string.alert_dialog_msg_cconsultaplanvoz_confirm));
                    break;
                case 8:
                    LALCrDPvhM lALCrDPvhM6 = LALCrDPvhM.this;
                    lALCrDPvhM6.showSendUSSD("222", "767", lALCrDPvhM6.context.getString(R.string.alert_dialog_msg_consultaplansms_confirm));
                    break;
                case 9:
                    LALCrDPvhM lALCrDPvhM7 = LALCrDPvhM.this;
                    lALCrDPvhM7.showSendUSSD("222", "264", lALCrDPvhM7.context.getString(R.string.alert_dialog_msg_consiltaplanamigos_confirm));
                    break;
            }
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 23 && getContext().checkSelfPermission("android.permission.READ_CONTACTS") == -1) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
        }
        View rootView = inflater.inflate(R.layout.iytq0yq4jywkc, container, false);
        this.context = container.getContext();
        RecyclerView rvseguridad = (RecyclerView) rootView.findViewById(R.id.drawerList);
        rvseguridad.setItemAnimator(new DefaultItemAnimator());
        rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        rvseguridad.setLayoutManager(llmSegidad);
        List<WUULVgZq02> itemsSeguridad = new ArrayList<>();
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo(this.context.getString(R.string.title_operaciones_recarga));
        registro.setSubtitulo(this.context.getString(R.string.detail_operaciones_recarga));
        registro.setIcono(R.drawable.ic_recargar_saldo_movil);
        itemsSeguridad.add(registro);
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo(this.context.getString(R.string.title_operaciones_transferir));
        autenticarse.setSubtitulo(this.context.getString(R.string.detail_operaciones_transferir));
        autenticarse.setIcono(R.drawable.ic_transferir_saldo);
        itemsSeguridad.add(autenticarse);
        WUULVgZq02 adelantaSaldo = new WUULVgZq02();
        adelantaSaldo.setTitulo(this.context.getString(R.string.title_operaciones_adelanta));
        adelantaSaldo.setSubtitulo(this.context.getString(R.string.detail_operaciones_adelanta));
        adelantaSaldo.setIcono(R.drawable.ic_adelantar_saldo);
        itemsSeguridad.add(adelantaSaldo);
        WUULVgZq02 transferir = new WUULVgZq02();
        transferir.setTitulo(this.context.getString(R.string.title_operaciones_clave));
        transferir.setSubtitulo(this.context.getString(R.string.detail_operaciones_clave));
        transferir.setIcono(R.drawable.ic_cambiar_clave_transferencia);
        itemsSeguridad.add(transferir);
        WUULVgZq02 estadobono = new WUULVgZq02();
        estadobono.setTitulo(this.context.getString(R.string.title_consultar_estado_bono));
        estadobono.setSubtitulo(this.context.getString(R.string.subtitle_consultar_estado_bono));
        estadobono.setIcono(R.drawable.ic_consultar_bono);
        itemsSeguridad.add(estadobono);
        WUULVgZq02 planes = new WUULVgZq02();
        planes.setTitulo(this.context.getString(R.string.title_gestion_planes));
        planes.setSubtitulo(this.context.getString(R.string.subtitle_gestion_planes));
        planes.setIcono(R.drawable.ic_recargar_con_bono);
        itemsSeguridad.add(planes);
        WUULVgZq02 bolsa = new WUULVgZq02();
        bolsa.setTitulo(this.context.getString(R.string.title_consultar_plan_datos));
        bolsa.setSubtitulo(this.context.getString(R.string.subtitle_consultar_plan_datos));
        bolsa.setIcono(R.drawable.ic_consultar_plan_datos);
        itemsSeguridad.add(bolsa);
        WUULVgZq02 voz = new WUULVgZq02();
        voz.setTitulo(this.context.getString(R.string.title_consultar_plan_voz));
        voz.setSubtitulo(this.context.getString(R.string.subtitle_consultar_plan_voz));
        voz.setIcono(R.drawable.ic_consultar_plan_voz);
        itemsSeguridad.add(voz);
        WUULVgZq02 sms = new WUULVgZq02();
        sms.setTitulo(this.context.getString(R.string.consultar_plan_sms));
        sms.setSubtitulo(this.context.getString(R.string.subconsultar_plan_sms));
        sms.setIcono(R.drawable.ic_consultar_plan_sms);
        itemsSeguridad.add(sms);
        WUULVgZq02 amigos = new WUULVgZq02();
        amigos.setTitulo(this.context.getString(R.string.consultar_plan_amigos));
        amigos.setSubtitulo(this.context.getString(R.string.subconsultar_plan_amigos));
        amigos.setIcono(R.drawable.ic_consultar_plan_amigo);
        itemsSeguridad.add(amigos);
        lkLP9buUCl adapterSeguridad = new lkLP9buUCl(this.context, itemsSeguridad);
        rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
        return rootView;
    }

    public void showSendUSSD(final String source, final String operacion, String Message_User) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(Message_User);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.LALCrDPvhM.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                String cadena;
                if (operacion.length() > 0) {
                    cadena = "tel:*" + source + "*" + operacion + Uri.encode("#");
                } else {
                    cadena = "tel:*" + source + Uri.encode("#");
                }
                Uri number = Uri.parse(cadena);
                Intent dial = new Intent("android.intent.action.CALL", number);
                LALCrDPvhM.this.startActivity(dial);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.LALCrDPvhM.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
