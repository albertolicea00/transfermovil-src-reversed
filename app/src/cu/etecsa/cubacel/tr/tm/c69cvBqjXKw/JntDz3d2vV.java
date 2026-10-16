package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRCombustible;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.XYfkGsUkKH;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.HrLy23Pb9b;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JntDz3d2vV extends puGDXabehz implements khginYXYg6.ViewHolder.ClickListener, Ti8eM28U2E {
    public FloatingActionButton actionButtonNuevo;
    public HrLy23Pb9b actionEntity;
    private ActionMode actionMode;
    public khginYXYg6 adapterCuentas;
    public Button btAcceder;
    public List<TCTicket> cLists;
    public Context context;
    public ConstraintLayout noAuthFragment;
    public Nl0yptXmjQ operationEntity;
    public RecyclerView rvFactura;
    public String titulo;
    public TextView txTextoAcceso;
    public rDEl7rW1aN bs = new rDEl7rW1aN();
    private ActionModeCallback actionModeCallback = new ActionModeCallback();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.or10ioszrj3es, container, false);
        this.context = container.getContext();
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setVisibility(8);
        this.actionButtonNuevo.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                JntDz3d2vV.this.cerrarSesion();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent event) {
                        switch (event.getActionMasked()) {
                            case 1:
                                view.setOnTouchListener(null);
                                break;
                            case 2:
                                view.setX(event.getRawX() - 120.0f);
                                view.setY(event.getRawY() - 425.0f);
                                break;
                        }
                        return true;
                    }
                });
                return true;
            }
        });
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        this.rvFactura = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvFactura.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        this.rvFactura.setLayoutManager(llmFactura);
        this.noAuthFragment = (ConstraintLayout) rootView.findViewById(R.id.noAuthFragment);
        this.txTextoAcceso = (TextView) rootView.findViewById(R.id.txTextoAcceso);
        Button button = (Button) rootView.findViewById(R.id.btAcceder);
        this.btAcceder = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JntDz3d2vV.this.showDialog();
            }
        });
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        validate();
        new XYfkGsUkKH(getContext().getContentResolver(), this).execute(new Void[0]);
    }

    private void loadData(boolean isAutenticated) {
        if (!isAutenticated) {
            this.noAuthFragment.setVisibility(0);
            this.rvFactura.setVisibility(4);
            this.actionButtonNuevo.setVisibility(4);
            return;
        }
        this.noAuthFragment.setVisibility(8);
        this.rvFactura.setVisibility(0);
        this.actionButtonNuevo.setVisibility(0);
        try {
            fillAdapter();
        } catch (Exception ex) {
            Log.e("TM_LOG", ex.getMessage());
        }
    }

    public void fillAdapter() {
        unYp8VQThY.init(this.context);
        List<yHdVJARBHM> itemsList = new ArrayList<>();
        List<TCTicket> allTicketLists = unYp8VQThY.getInstance().getAllTicketLists();
        this.cLists = allTicketLists;
        for (TCTicket uyh0pxs9m37in : allTicketLists) {
            yHdVJARBHM iDB = new yHdVJARBHM(uyh0pxs9m37in.getId(), uyh0pxs9m37in.getSerie(), uyh0pxs9m37in.getAlias(), uyh0pxs9m37in.isConsumido());
            itemsList.add(iDB);
        }
        khginYXYg6 khginyxyg6 = new khginYXYg6(this, itemsList, getActivity(), this.context);
        this.adapterCuentas = khginyxyg6;
        this.rvFactura.setAdapter(khginyxyg6);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        TCTicket ticket = this.cLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        GUihyrFQpq tcTicketFragment = new GUihyrFQpq();
        Bundle b = new Bundle();
        b.putString("ticket_id", String.valueOf(ticket.getId()));
        tcTicketFragment.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, tcTicketFragment).addToBackStack(null).commit();
    }

    private void toggleSelection(int position) {
        this.adapterCuentas.toggleSelection(position);
        int count = this.adapterCuentas.getSelectedItemCount();
        if (count == 0) {
            this.actionMode.finish();
        } else {
            this.actionMode.setTitle(String.valueOf(count));
            this.actionMode.invalidate();
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
    public boolean onItemLongClicked(int position) {
        if (this.actionMode == null) {
            this.actionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(this.actionModeCallback);
        }
        toggleSelection(position);
        return true;
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.khginYXYg6.ViewHolder.ClickListener
    public boolean showQR(int position) throws WriterException {
        TCTicket miCuenta = unYp8VQThY.getInstance().getTCTicketListWithID(this.cLists.get(position).getId());
        String cadena = "ERROR";
        try {
            String[] data = miCuenta.getData().split("\\|");
            String d1 = data[0];
            String d2 = data[1];
            String vSer = V5FFEZ0Qrr0.cH(d1, miCuenta.getIdBank(), miCuenta.getIdTM());
            String vTok = V5FFEZ0Qrr0.cH(d2, miCuenta.getIdBank(), miCuenta.getIdTM());
            QRCombustible qr = new QRCombustible();
            qr.setToken(vTok);
            qr.setPin(vSer);
            Gson gson = new Gson();
            cadena = gson.toJson(qr);
        } catch (Exception ex) {
            Log.e("AESERROR", ex.getMessage());
        }
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.logo_transfermovil_sm);
        Bitmap bm = ZUoEY89WdA.ProductLogo(icon, cadena, false, R.color.primaryDarkColor);
        Dialog settingsDialog = new Dialog(this.context);
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        View v = inflater.inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
        ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
        iv.setImageBitmap(bm);
        settingsDialog.getWindow().requestFeature(1);
        settingsDialog.setContentView(v);
        settingsDialog.show();
        return false;
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS;

        static {
            int[] iArr = new int[puGDXabehz.AUTH_STATUS.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS = iArr;
            try {
                iArr[puGDXabehz.AUTH_STATUS.NO_AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS[puGDXabehz.AUTH_STATUS.NO_REGISTRADO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS[puGDXabehz.AUTH_STATUS.AUTH_OK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS[puGDXabehz.AUTH_STATUS.ERRO_AUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validate() {
        int[] iArr = AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$c69cvBqjXKw$puGDXabehz$AUTH_STATUS;
        Nl0yptXmjQ nl0yptXmjQ = Nl0yptXmjQ.Ticket_Combustible_Gestion;
        switch (iArr[validateAuth(nl0yptXmjQ).ordinal()]) {
            case 1:
                new Bundle();
                this.actionEntity = HrLy23Pb9b.AUTENTICAR;
                this.operationEntity = nl0yptXmjQ;
                this.titulo = "Combustible";
                loadData(false);
                break;
            case 2:
                this.actionEntity = HrLy23Pb9b.REGISTRO;
                this.operationEntity = nl0yptXmjQ;
                this.titulo = "Combustible";
                loadData(false);
                break;
            case 3:
                loadData(true);
                break;
            case 4:
                loadData(false);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                loadData(true);
            }
            if (resultCode == 2) {
                loadData(true);
            }
            if (resultCode == 3) {
                this.actionEntity = HrLy23Pb9b.REGISTRO;
                loadData(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            GRGvmCZD7R dialogFrag = GRGvmCZD7R.newInstance(this.operationEntity, this.actionEntity, this.titulo);
            dialogFrag.setTargetFragment(this, 1);
            dialogFrag.setCancelable(false);
            dialogFrag.show(getFragmentManager(), "fragment_PAGO");
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cerrarSesion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Confirme");
        builder.setMessage("¿Desea cerrar la sección? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                AOperKey key = unYp8VQThY.getInstance().getAOperKey(Nl0yptXmjQ.Ticket_Combustible_Gestion);
                key.setAuth(false);
                unYp8VQThY.getInstance().updateAOperKey(key);
                JntDz3d2vV.this.validate();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E
    public void onCuentasResult(Boolean result, int code, String mensaje) {
        validate();
    }

    @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.Ti8eM28U2E
    public void onSetProgressBarVisibility(int visibility) {
    }

    public class ActionModeCallback implements ActionMode.Callback {
        public ActionModeCallback() {
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(final ActionMode mode, MenuItem uyh0pxs9m37in) {
            switch (uyh0pxs9m37in.getItemId()) {
                case R.id.menu_remove /* 2131297160 */:
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(JntDz3d2vV.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.JntDz3d2vV.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = JntDz3d2vV.this.adapterCuentas.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(JntDz3d2vV.this.context);
                                TCTicket cRemove = JntDz3d2vV.this.cLists.get(pos);
                                cRemove.setDeleted(true);
                                unYp8VQThY.getInstance().updateTCTicket(cRemove);
                            }
                            khginYXYg6 khginyxyg6 = JntDz3d2vV.this.adapterCuentas;
                            khginyxyg6.removeItems(khginyxyg6.getSelectedItems());
                            if (JntDz3d2vV.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) JntDz3d2vV.this.getActivity()).UpdateMenu();
                            } else if (JntDz3d2vV.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) JntDz3d2vV.this.getActivity()).UpdateMenu();
                            }
                            mode.finish();
                        }
                    });
                    builder.setNegativeButton("NO", null);
                    builder.show();
                    return true;
                default:
                    return false;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            JntDz3d2vV.this.adapterCuentas.clearSelection();
            JntDz3d2vV.this.actionMode = null;
        }
    }
}
