package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TarjetaPropia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MmUcSVNG36 extends Fragment implements xToaaw6pAW.ViewHolder.ClickListener {
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomHelp;
    public FloatingActionButton actionButtomImport;
    public FloatingActionButton actionButtonNuevo;
    private ActionMode actionMode;
    public xToaaw6pAW adapterCuentas;
    public List<TarjetaPropia> cLists;
    public Context context;
    public RecyclerView rvFactura;
    public String id_cliente = "-1";
    public rDEl7rW1aN bs = new rDEl7rW1aN();
    private ActionModeCallback actionModeCallback = new ActionModeCallback();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.qp03cfhlioyto, container, false);
        this.context = container.getContext();
        if (getArguments() != null) {
            this.id_cliente = getArguments().get("IdCliente").toString();
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MmUcSVNG36.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentManager mFragmentManager = MmUcSVNG36.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mznuZkZXP3 tarjetaFragment = new mznuZkZXP3();
                mFragmentTransaction.replace(R.id.containerView, tarjetaFragment).addToBackStack(null).commit();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MmUcSVNG36.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MmUcSVNG36.2.1
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
        try {
            fillAdapter();
        } catch (Exception ex) {
            Log.e("TM_LOG", ex.getMessage());
        }
        return rootView;
    }

    public void fillAdapter() {
        yHdVJARBHM yhdvjarbhm;
        unYp8VQThY.init(this.context);
        if (!this.id_cliente.contains("-1")) {
            Client client = unYp8VQThY.getInstance().getClientListWithId(Integer.parseInt(this.id_cliente));
            this.cLists = unYp8VQThY.getInstance().getPropiasListsWithClient(client);
        } else {
            this.cLists = unYp8VQThY.getInstance().getAllPropiaLists();
        }
        List<yHdVJARBHM> items = new ArrayList<>();
        List<TarjetaPropia> list = this.cLists;
        if (list != null) {
            for (TarjetaPropia c : list) {
                String nom_client = BuildConfig.FLAVOR;
                Client cl = null;
                try {
                    cl = unYp8VQThY.getInstance().getClientListWithId(c.getId_client());
                    if (cl != null) {
                        nom_client = cl.getName().trim();
                    }
                } catch (Exception e) {
                }
                String nom_cuenta = c.getSerie();
                String desripcion = c.getDescripcion() == null ? BuildConfig.FLAVOR : c.getDescripcion();
                if (cl != null) {
                    yhdvjarbhm = new yHdVJARBHM(c.getId(), nom_cuenta, desripcion + " - " + nom_client, false);
                } else {
                    yhdvjarbhm = new yHdVJARBHM(c.getId(), nom_cuenta, desripcion, false);
                }
                yHdVJARBHM uyh0pxs9m37in = yhdvjarbhm;
                items.add(uyh0pxs9m37in);
            }
            xToaaw6pAW xtoaaw6paw = new xToaaw6pAW(this, items, getActivity(), 5, this.context);
            this.adapterCuentas = xtoaaw6paw;
            this.rvFactura.setAdapter(xtoaaw6paw);
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        TarjetaPropia cuenta = this.cLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mznuZkZXP3 editPropia = new mznuZkZXP3();
        Bundle b = new Bundle();
        b.putString("cuenta_id", String.valueOf(cuenta.getId()));
        editPropia.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, editPropia).addToBackStack(null).commit();
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

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.xToaaw6pAW.ViewHolder.ClickListener
    public boolean onItemLongClicked(int position) {
        if (this.actionMode == null) {
            this.actionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(this.actionModeCallback);
        }
        toggleSelection(position);
        return true;
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(MmUcSVNG36.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MmUcSVNG36.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = MmUcSVNG36.this.adapterCuentas.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(MmUcSVNG36.this.context);
                                TarjetaPropia cRemove = MmUcSVNG36.this.cLists.get(pos);
                                unYp8VQThY.getInstance().deletePropia(cRemove);
                            }
                            xToaaw6pAW xtoaaw6paw = MmUcSVNG36.this.adapterCuentas;
                            xtoaaw6paw.removeItems(xtoaaw6paw.getSelectedItems());
                            if (MmUcSVNG36.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) MmUcSVNG36.this.getActivity()).UpdateMenu();
                            } else if (MmUcSVNG36.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) MmUcSVNG36.this.getActivity()).UpdateMenu();
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
            MmUcSVNG36.this.adapterCuentas.clearSelection();
            MmUcSVNG36.this.actionMode = null;
        }
    }
}
