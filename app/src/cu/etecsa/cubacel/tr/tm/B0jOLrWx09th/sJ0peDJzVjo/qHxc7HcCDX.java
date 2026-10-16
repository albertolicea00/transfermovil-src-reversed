package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.QGQCqILT4b;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ObligacionesOFA;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class qHxc7HcCDX extends QGQCqILT4b {
    public ImageButton btSearchZPC;
    public SpinnerDialog spinnerDialog;
    public AutoCompleteTextView txCodigo;
    public ArrayAdapter<ObligacionesOFA> zpcArrayAdapter;
    public ObligacionesOFA zpcData;
    public List<ObligacionesOFA> zpcList;
    public ArrayList<String> items = new ArrayList<>();
    public jN13TOyLMX.OnItemClickListener spZPCOnClickListener = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.qHxc7HcCDX.2
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
            qHxc7HcCDX qhxc7hccdx = qHxc7HcCDX.this;
            qhxc7hccdx.zpcData = qhxc7hccdx.zpcArrayAdapter.getItem(position);
        }
    };
    private View.OnClickListener btnZPCOnClick = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.qHxc7HcCDX.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            qHxc7HcCDX.this.spinnerDialog.showSpinerDialog();
        }
    };

    public void initParent() {
        this.txCodigo = (AutoCompleteTextView) this.rootView.findViewById(R.id.txCodigo);
        ImageButton imageButton = (ImageButton) this.rootView.findViewById(R.id.btSearchZPC);
        this.btSearchZPC = imageButton;
        imageButton.setOnClickListener(this.btnZPCOnClick);
        loadZPC();
    }

    public boolean loadZPC() {
        try {
            this.zpcList = new ArrayList();
            V9s8rJIDplX jsonFilesManager = new V9s8rJIDplX();
            List<ObligacionesOFA> list = jsonFilesManager.loadDataZPC(this.context);
            if (list == null || list.size() <= 0) {
                return false;
            }
            this.zpcArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
            for (ObligacionesOFA uyh0pxs9m37in : list) {
                this.zpcArrayAdapter.add(uyh0pxs9m37in);
                this.zpcList.add(uyh0pxs9m37in);
                this.items.add(uyh0pxs9m37in.getCode() + " - " + uyh0pxs9m37in.getDescripcion());
            }
            this.zpcArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), this.items, "Seleccione el ZPC", 2131820786, "Cerrar");
            this.spinnerDialog = spinnerDialog;
            spinnerDialog.setCancellable(true);
            this.spinnerDialog.setShowKeyboard(false);
            this.spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.qHxc7HcCDX.1
                @Override // in.galaxyofandroid.spinerdialog.OnSpinerItemClick
                public void onClick(String uyh0pxs9m37in2, int position) {
                    qHxc7HcCDX qhxc7hccdx = qHxc7HcCDX.this;
                    qhxc7hccdx.txCodigo.setText(qhxc7hccdx.zpcList.get(position).getCode());
                    qHxc7HcCDX qhxc7hccdx2 = qHxc7HcCDX.this;
                    qhxc7hccdx2.zpcData = qhxc7hccdx2.zpcList.get(position);
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
