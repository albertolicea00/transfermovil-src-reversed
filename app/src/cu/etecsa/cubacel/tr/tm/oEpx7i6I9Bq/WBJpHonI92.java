package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UrwqJEz77K;
import cu.etecsa.cubacel.tr.tm.x6YmtG6fmSa.RoPkqiwcQO;

/* JADX INFO: loaded from: classes.dex */
public class WBJpHonI92 extends Fragment {
    public Activity activity;
    public CardView btnActualizar;
    public CardView btnDescargaAPKLis;
    public CardView btnDescargaEtecsa;
    public Context context;
    public UrwqJEz77K dowloadAppManager;
    public FragmentActivity frs;
    public RoPkqiwcQO managerPresenter;
    public Fr52O1uSYF msap;
    public LinearLayout pBar;
    private TextView pbText;
    private ActivityResultLauncher<String> requestPermissionLauncher;
    public View rootView;
    public String versionAPK;
    public String url = "https://www.etecsa.cu/sites/default/files/aplicaciones/transfermovil_0.apk";
    public int PERMISSION_REQUEST_STORAGE = 0;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.msap = new Fr52O1uSYF();
        this.rootView = inflater.inflate(R.layout.x3ql6b2w72knb, container, false);
        Context context = container.getContext();
        this.context = context;
        this.dowloadAppManager = new UrwqJEz77K(context, this.url);
        TextView textInfo = (TextView) this.rootView.findViewById(R.id.txt_info);
        try {
            String version = this.msap.getVersion();
            this.versionAPK = version;
            if (version.length() > 0) {
                textInfo.setText("Versión actual: Transfermóvil V." + this.versionAPK);
            }
        } catch (Exception e) {
        }
        unYp8VQThY.init(this.context);
        this.btnActualizar = (CardView) this.rootView.findViewById(R.id.btnActualizar);
        this.btnDescargaEtecsa = (CardView) this.rootView.findViewById(R.id.btnDecargaEtecsa);
        this.btnDescargaAPKLis = (CardView) this.rootView.findViewById(R.id.btnDecargaAPKLis);
        this.btnDescargaEtecsa.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WBJpHonI92.this.context);
                builder.setTitle("Confirmar").setMessage(Html.fromHtml("¿Desea entrar al sitio para descargar la aplicación?")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.1.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        WBJpHonI92.this.openWeb("https://www.etecsa.cu/aplicaciones/transfermovil");
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
        this.btnDescargaAPKLis.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WBJpHonI92.this.context);
                builder.setTitle("Confirmar").setMessage(Html.fromHtml("¿Desea entrar al sitio para descargar la aplicación?")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        WBJpHonI92.this.openWeb("https://www.apklis.cu/application/cu.etecsa.cubacel.tr.tm");
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
        this.pBar = (LinearLayout) this.rootView.findViewById(R.id.llProgressBar);
        this.pbText = (TextView) this.rootView.findViewById(R.id.pbText);
        this.requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$onCreateView$0((Boolean) obj);
            }
        });
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.requestPermissionLauncher.launch("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(Boolean isGranted) {
        if (isGranted.booleanValue()) {
            Toast.makeText(this.context, "Concedido", 1).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
        if (context instanceof FragmentActivity) {
            this.frs = (FragmentActivity) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.btnActualizar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WBJpHonI92.this.context);
                builder.setTitle("Confirmar").setMessage(Html.fromHtml("Para descargar la actualización requiere conexión a Internet. ¿Desea continuar con la operación de actualización?")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        WBJpHonI92.this.pbText.setText("Comprobando actualizaciones disponibles. Espere...");
                        WBJpHonI92.this.checkPermisos();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermisos() {
        this.dowloadAppManager.enquequeDowload();
    }

    public void showMensajeDescargarVersion(final String version_nueva) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Confirmar").setMessage(Html.fromHtml("Hay una nueva versión disponible. ¿Desea continuar con la operación de actualización?")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                WBJpHonI92.this.pbText.setText("Descargando actualización. Por favor Espere...");
                WBJpHonI92.this.managerPresenter.setProgressBarVisiblity(0);
                WBJpHonI92.this.managerPresenter.updateApp(version_nueva);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    public void showMensajeNoHayVersion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Notificación").setMessage(Html.fromHtml("Su aplicación ya se encuentra actualizada con la ultima versión disponible de Transfermóvil")).setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.WBJpHonI92.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWeb(String url) {
        try {
            Uri web = Uri.parse(url);
            Intent intent = new Intent("android.intent.action.VIEW", web);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.context, "No existe aplicación para abrir el link. Instale un navegador compatible", 1).show();
        }
    }
}
