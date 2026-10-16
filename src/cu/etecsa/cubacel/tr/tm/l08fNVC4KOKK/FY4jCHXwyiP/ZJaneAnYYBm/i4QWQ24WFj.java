package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i4QWQ24WFj extends DialogFragment {
    public static final String DATOS_RESPONSE = "USSDPartial";
    public static CommunicadorDialogListener communicator;
    public LXkgnXgQxU adapter;
    public Button btnAceptar;
    public Context context;
    public ObjRequest datos;
    private ImageView imgArrow;
    public View rootView;
    public RecyclerView rvList;
    public Switch swhabilitar;
    public String HEAD_LOG = "i4QWQ24WFj ";
    private boolean isRecyclerViewVisible = true;
    public LXkgnXgQxU.OnItemClickListener onItemClickListener = new LXkgnXgQxU.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.i4QWQ24WFj.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.LXkgnXgQxU.OnItemClickListener
        public void onGetItemClick(View view, jraNhpzll4 uyh0pxs9m37in) {
            ObjResponse response = i4QWQ24WFj.this.new ObjResponse();
            response.send = true;
            response.data = uyh0pxs9m37in;
            i4QWQ24WFj.communicator.onSendUSSD(response);
        }
    };

    public interface CommunicadorDialogListener {
        void initUSSDAutomatic();

        void onSendUSSD(ObjResponse objResponse);
    }

    public static class ObjRequest implements Serializable {
        public List<jraNhpzll4> data;
    }

    public static i4QWQ24WFj newInstance(ObjRequest datosRequest, CommunicadorDialogListener communicadorAlertaListener) {
        i4QWQ24WFj frag = new i4QWQ24WFj();
        communicator = communicadorAlertaListener;
        try {
            Bundle args = new Bundle();
            args.putSerializable("USSDPartial", datosRequest);
            frag.setArguments(args);
        } catch (Exception e) {
        }
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.ordetoconfszf, container, false);
        this.rootView = viewInflate;
        this.rvList = (RecyclerView) viewInflate.findViewById(R.id.rvList);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.swhabilitar = (Switch) this.rootView.findViewById(R.id.swhabilitar);
        this.imgArrow = (ImageView) this.rootView.findViewById(R.id.img_arrow);
        this.rvList.setVisibility(8);
        this.isRecyclerViewVisible = false;
        Bundle arg = getArguments();
        if (arg.containsKey("USSDPartial")) {
            try {
                this.datos = (ObjRequest) arg.getSerializable("USSDPartial");
            } catch (Exception e) {
            }
        }
        initData();
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.i4QWQ24WFj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                i4QWQ24WFj.communicator.initUSSDAutomatic();
            }
        });
        this.swhabilitar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.i4QWQ24WFj.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    i4QWQ24WFj.this.adapter.enableSwitches();
                } else {
                    i4QWQ24WFj.this.adapter.disableSwitches();
                }
                i4QWQ24WFj.this.toggleRecyclerViewVisibility();
            }
        });
        this.imgArrow.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.i4QWQ24WFj.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                i4QWQ24WFj.this.toggleRecyclerViewVisibility();
            }
        });
        return this.rootView;
    }

    private void initData() {
        this.rvList.setLayoutManager(new LinearLayoutManager(this.context));
        LXkgnXgQxU lXkgnXgQxU = new LXkgnXgQxU(this.context, this.datos.data);
        this.adapter = lXkgnXgQxU;
        lXkgnXgQxU.setOnItemClickListener(this.onItemClickListener);
        this.rvList.setAdapter(this.adapter);
    }

    public void cambiarEstadoSwitch(int pos, boolean status) {
        this.adapter.cambiarEstadoSwitch(pos, status);
    }

    public void updateItemData(jraNhpzll4 uyh0pxs9m37in) {
        int pos = this.adapter.encontrarPosicionPorId(uyh0pxs9m37in.getNoPaquete());
        if (pos >= 0) {
            this.adapter.modificarItem(pos, uyh0pxs9m37in);
        }
    }

    public void enviarItemData(jraNhpzll4 uyh0pxs9m37in) {
        int pos = this.adapter.encontrarPosicionPorId(uyh0pxs9m37in.getNoPaquete());
        if (pos >= 0) {
            this.adapter.modificarItem(pos, uyh0pxs9m37in);
        }
        ObjResponse response = new ObjResponse();
        response.send = true;
        response.data = uyh0pxs9m37in;
        communicator.onSendUSSD(response);
    }

    public class ObjResponse implements Serializable {
        public jraNhpzll4 data;
        public boolean send;

        public ObjResponse() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleRecyclerViewVisibility() {
        if (this.isRecyclerViewVisible) {
            this.rvList.setVisibility(8);
            this.imgArrow.setImageResource(R.drawable.ic_arrow_down);
        } else {
            this.rvList.setVisibility(0);
            this.imgArrow.setImageResource(R.drawable.ic_arrow_up);
        }
        this.isRecyclerViewVisible = !this.isRecyclerViewVisible;
    }
}
