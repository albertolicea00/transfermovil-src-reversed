package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class L4aAENEGbqv extends Fragment {
    public ImageButton btSearchAccount;
    public List<String> cList;
    public Context context;
    public ArrayList<String> items = new ArrayList<>();
    public TextInputLayout lySerie;
    public SpinnerDialog spinnerDialog;
    public List<CompraBoleto> ticketsList;
    public AutoCompleteTextView txSerie;

    public void loadComponents(View v) {
        try {
            this.txSerie = (AutoCompleteTextView) v.findViewById(R.id.txSerie);
            this.lySerie = (TextInputLayout) v.findViewById(R.id.lySerie);
            unYp8VQThY.init(this.context);
            this.ticketsList = unYp8VQThY.getInstance().getAllMiBoletoCompraLists();
            this.cList = new ArrayList();
            for (CompraBoleto wl : this.ticketsList) {
                this.cList.add(wl.getIdOferta());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line, this.cList);
            this.txSerie.setAdapter(adapter);
            this.txSerie.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.L4aAENEGbqv.1
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        L4aAENEGbqv.this.txSerie.showDropDown();
                    }
                }
            });
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btSearchAccount);
        this.btSearchAccount = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.L4aAENEGbqv.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<CompraBoleto> list = L4aAENEGbqv.this.ticketsList;
                if (list != null && list.size() > 0) {
                    L4aAENEGbqv.this.spinnerDialog.showSpinerDialog();
                } else {
                    Toast.makeText(L4aAENEGbqv.this.context, "No hay boletos para mostrar", 0).show();
                }
            }
        });
        loadSearchSpinnerSeries();
    }

    private void loadSearchSpinnerSeries() {
        try {
            List<CompraBoleto> list = this.ticketsList;
            if (list != null && list.size() > 0) {
                for (CompraBoleto uyh0pxs9m37in : this.ticketsList) {
                    if (uyh0pxs9m37in.getAlias() != null && uyh0pxs9m37in.getAlias().length() > 0) {
                        this.items.add(uyh0pxs9m37in.getAlias() + " - " + uyh0pxs9m37in.getIdOferta());
                    } else {
                        this.items.add(uyh0pxs9m37in.getIdOferta());
                    }
                }
            }
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione el boleto", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.L4aAENEGbqv.3
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    CompraBoleto cuenta = L4aAENEGbqv.this.ticketsList.get(position);
                    L4aAENEGbqv.this.txSerie.setText(cuenta.getIdOferta());
                }
            });
        } catch (Exception e) {
        }
    }

    public boolean validateSerie() {
        if (this.txSerie.getText().toString().trim().isEmpty()) {
            this.lySerie.setError("El campo no puede estar vacio");
            requestFocus(this.txSerie);
            return false;
        }
        if (this.txSerie.getText().toString().trim().length() != 10) {
            this.lySerie.setError(getString(R.string.err_msg_len_cuenta_10_boleto));
            requestFocus(this.txSerie);
            return false;
        }
        this.lySerie.setErrorEnabled(false);
        return true;
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }
}
