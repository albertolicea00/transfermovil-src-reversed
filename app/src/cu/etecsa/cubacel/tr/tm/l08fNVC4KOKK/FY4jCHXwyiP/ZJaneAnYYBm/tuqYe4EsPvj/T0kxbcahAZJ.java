package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.tuqYe4EsPvj;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class T0kxbcahAZJ {
    private Button btnAceptar;
    private Dialog dialog;
    private ProgressBar progressBar;
    private TextView tvProgressMessage;

    public T0kxbcahAZJ(Context context) {
        Dialog dialog = new Dialog(context);
        this.dialog = dialog;
        dialog.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.jhnnunc3xzhd5);
        this.dialog.setCancelable(false);
        this.tvProgressMessage = (TextView) this.dialog.findViewById(R.id.tvProgressMessage);
        Button button = (Button) this.dialog.findViewById(R.id.btn_aceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.tuqYe4EsPvj.T0kxbcahAZJ.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                T0kxbcahAZJ.this.dismiss();
            }
        });
        this.progressBar = (ProgressBar) this.dialog.findViewById(R.id.progressBar);
    }

    public void showProgress(int current, int total) {
        Dialog dialog = this.dialog;
        if (dialog != null && !dialog.isShowing()) {
            this.dialog.show();
        }
        this.tvProgressMessage.setText("Enviando USSD " + current + " de " + total + "...");
    }

    public void showCompletedAndClose() {
        if (this.dialog != null) {
            this.progressBar.setVisibility(8);
            this.tvProgressMessage.setText("Completado ✔");
            this.tvProgressMessage.setText(R.string.tx_msg_espere_un_sms);
        }
    }

    public void showErrorAndClose() {
        if (this.dialog != null) {
            this.progressBar.setVisibility(8);
            this.tvProgressMessage.setText(R.string.tx_msg_error_ussd);
        }
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
