package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;

/* JADX INFO: loaded from: classes.dex */
public class UUlOTi00Yp extends Fragment {
    public AppConfig config;
    public Context context;
    public View rootView;
    public Switch swActivarUSSD;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.drorsux95t1pa, container, false);
        this.context = container.getContext();
        Switch swActivarUSSD = (Switch) this.rootView.findViewById(R.id.swActivarUSSD);
        Switch swMejorarQR = (Switch) this.rootView.findViewById(R.id.swMejorarQR);
        AppConfig appConfigListWithId = unYp8VQThY.getInstance().getAppConfigListWithId(1);
        this.config = appConfigListWithId;
        swActivarUSSD.setChecked(appConfigListWithId.isActivarussdparcial());
        swMejorarQR.setChecked(this.config.isActivarMejoraQR());
        swActivarUSSD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UUlOTi00Yp.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    UUlOTi00Yp uUlOTi00Yp = UUlOTi00Yp.this;
                    if (uUlOTi00Yp.config == null) {
                        uUlOTi00Yp.config = unYp8VQThY.getInstance().getAppConfigListWithId(1);
                    }
                    UUlOTi00Yp.this.config.setActivarussdparcial(isChecked);
                    unYp8VQThY.getInstance().updateAppConfig(UUlOTi00Yp.this.config);
                } catch (Exception e) {
                    Toast.makeText(UUlOTi00Yp.this.context, "Ha ocurrido un error", 0).show();
                }
            }
        });
        swMejorarQR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UUlOTi00Yp.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    UUlOTi00Yp uUlOTi00Yp = UUlOTi00Yp.this;
                    if (uUlOTi00Yp.config == null) {
                        uUlOTi00Yp.config = unYp8VQThY.getInstance().getAppConfigListWithId(1);
                    }
                    UUlOTi00Yp.this.config.setActivarMejoraQR(isChecked);
                    unYp8VQThY.getInstance().updateAppConfig(UUlOTi00Yp.this.config);
                } catch (Exception e) {
                    Toast.makeText(UUlOTi00Yp.this.context, "Ha ocurrido un error", 0).show();
                }
            }
        });
        return this.rootView;
    }

    public void showMensajeNoHayVersion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Notificación").setMessage(Html.fromHtml("Su aplicación ya se encuentra actualizada con la ultima versión disponible de Transfermóvil")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UUlOTi00Yp.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.UUlOTi00Yp.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }
}
