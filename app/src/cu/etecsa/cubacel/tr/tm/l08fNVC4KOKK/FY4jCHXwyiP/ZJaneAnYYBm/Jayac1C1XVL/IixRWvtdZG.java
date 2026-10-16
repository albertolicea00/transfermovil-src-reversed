package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL;

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
public class IixRWvtdZG extends DialogFragment {
    public static final String DATOS_RESPONSE = "USSDPartial";
    public static CommunicadorDialogListener communicator;
    public iNEsCMH3jK adapter;
    public Button btnAceptar;
    public Context context;
    public ObjRequest datos;
    private ImageView imgArrow;
    public View rootView;
    public RecyclerView rvList;
    public Switch swhabilitar;
    public String HEAD_LOG = "i4QWQ24WFj ";
    private boolean isRecyclerViewVisible = true;
    public iNEsCMH3jK.OnItemClickListener onItemClickListener = new iNEsCMH3jK.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.4
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.iNEsCMH3jK.OnItemClickListener
        public void onGetItemClick(View view, QfruhfaN5Z uyh0pxs9m37in) {
            ObjResponse response = IixRWvtdZG.this.new ObjResponse();
            response.send = true;
            response.data = uyh0pxs9m37in;
            IixRWvtdZG.communicator.onSendUSSD(response);
        }
    };

    public interface CommunicadorDialogListener {
        void initUSSDAutomatic();

        void onSendUSSD(ObjResponse objResponse);
    }

    public static class ObjRequest implements Serializable {
        public List<QfruhfaN5Z> data;
    }

    public static IixRWvtdZG newInstance(ObjRequest datosRequest, CommunicadorDialogListener communicadorAlertaListener) {
        IixRWvtdZG frag = new IixRWvtdZG();
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
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IixRWvtdZG.communicator.initUSSDAutomatic();
            }
        });
        this.swhabilitar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    IixRWvtdZG.this.adapter.enableSwitches();
                } else {
                    IixRWvtdZG.this.adapter.disableSwitches();
                }
                IixRWvtdZG.this.toggleRecyclerViewVisibility();
            }
        });
        this.imgArrow.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.Jayac1C1XVL.IixRWvtdZG.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IixRWvtdZG.this.toggleRecyclerViewVisibility();
            }
        });
        return this.rootView;
    }

    private void initData() {
        this.rvList.setLayoutManager(new LinearLayoutManager(this.context));
        iNEsCMH3jK inescmh3jk = new iNEsCMH3jK(this.context, this.datos.data);
        this.adapter = inescmh3jk;
        inescmh3jk.setOnItemClickListener(this.onItemClickListener);
        this.rvList.setAdapter(this.adapter);
    }

    public void cambiarEstadoSwitch(int pos, boolean status) {
        this.adapter.cambiarEstadoSwitch(pos, status);
    }

    public void updateItemData(QfruhfaN5Z uyh0pxs9m37in) {
        int pos = this.adapter.encontrarPosicionPorId(uyh0pxs9m37in.getNoPaquete());
        if (pos >= 0) {
            this.adapter.modificarItem(pos, uyh0pxs9m37in);
        }
    }

    public void enviarItemData(QfruhfaN5Z uyh0pxs9m37in) {
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
        public QfruhfaN5Z data;
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
