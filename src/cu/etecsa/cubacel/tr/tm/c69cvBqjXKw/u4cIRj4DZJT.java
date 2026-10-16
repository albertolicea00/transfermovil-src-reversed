package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u4cIRj4DZJT extends Fragment implements XvulaG5FAh.ViewHolder.ClickListener {
    public List<Factura> FacturaLists;
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomHelp;
    public FloatingActionButton actionButtomImport;
    public FloatingActionButton actionButtonNuevo;
    private ActionMode actionMode;
    public XvulaG5FAh adapterFactura;
    public Context context;
    public RecyclerView rvFactura;
    public String id_cliente = "-1";
    public rDEl7rW1aN bs = new rDEl7rW1aN();
    private ActionModeCallback actionModeCallback = new ActionModeCallback();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerView getRvFactura() {
        return this.rvFactura;
    }

    public void setRvFactura(RecyclerView rvFactura) {
        this.rvFactura = rvFactura;
    }

    public XvulaG5FAh getAdapterFactura() {
        return this.adapterFactura;
    }

    public void setAdapterFactura(XvulaG5FAh adapterFactura) {
        this.adapterFactura = adapterFactura;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.uubfnggjxzz7q, container, false);
        this.context = container.getContext();
        if (getArguments() != null) {
            this.id_cliente = getArguments().get("IdCliente").toString();
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.u4cIRj4DZJT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentManager mFragmentManager = u4cIRj4DZJT.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                bJaiFoVYfK editFactura = new bJaiFoVYfK();
                mFragmentTransaction.replace(R.id.containerView, editFactura).addToBackStack(null).commit();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.u4cIRj4DZJT.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.u4cIRj4DZJT.2.1
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
        fillAdapter();
        return rootView;
    }

    public void fillAdapter() {
        yHdVJARBHM yhdvjarbhm;
        unYp8VQThY.init(this.context);
        if (!this.id_cliente.contains("-1")) {
            this.FacturaLists = unYp8VQThY.getInstance().getFacturasListsWithCliente(Integer.parseInt(this.id_cliente));
        } else {
            this.FacturaLists = unYp8VQThY.getInstance().getAllFacurasLists();
        }
        List<yHdVJARBHM> items = new ArrayList<>();
        for (Factura c : this.FacturaLists) {
            Client cl = unYp8VQThY.getInstance().getClientListWithId(c.getId_client());
            String nom_client = BuildConfig.FLAVOR;
            if (cl != null) {
                nom_client = cl.getName().trim();
            }
            String[] mTiposFacturas = getResources().getStringArray(R.array.array_servicios);
            String nom_cuenta = c.getFactura();
            if (cl != null) {
                yhdvjarbhm = new yHdVJARBHM(c.getId(), nom_cuenta, mTiposFacturas[c.getTipo_Factura()] + " - PROPIETARIO: " + nom_client, false);
            } else {
                yhdvjarbhm = new yHdVJARBHM(c.getId(), nom_cuenta, mTiposFacturas[c.getTipo_Factura()], false);
            }
            yHdVJARBHM uyh0pxs9m37in = yhdvjarbhm;
            items.add(uyh0pxs9m37in);
        }
        XvulaG5FAh xvulaG5FAh = new XvulaG5FAh(this, items, getActivity(), 5, this.context);
        this.adapterFactura = xvulaG5FAh;
        this.rvFactura.setAdapter(xvulaG5FAh);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        Factura Factura = this.FacturaLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        bJaiFoVYfK editFijo = new bJaiFoVYfK();
        Bundle b = new Bundle();
        b.putString("Id", String.valueOf(Factura.getId()));
        editFijo.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, editFijo).addToBackStack(null).commit();
    }

    private void toggleSelection(int position) {
        this.adapterFactura.toggleSelection(position);
        int count = this.adapterFactura.getSelectedItemCount();
        if (count == 0) {
            this.actionMode.finish();
        } else {
            this.actionMode.setTitle(String.valueOf(count));
            this.actionMode.invalidate();
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(u4cIRj4DZJT.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.u4cIRj4DZJT.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = u4cIRj4DZJT.this.adapterFactura.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(u4cIRj4DZJT.this.context);
                                Factura FacturaRemove = u4cIRj4DZJT.this.FacturaLists.get(pos);
                                unYp8VQThY.getInstance().deleteFactura(FacturaRemove);
                            }
                            XvulaG5FAh xvulaG5FAh = u4cIRj4DZJT.this.adapterFactura;
                            xvulaG5FAh.removeItems(xvulaG5FAh.getSelectedItems());
                            if (u4cIRj4DZJT.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) u4cIRj4DZJT.this.getActivity()).UpdateMenu();
                            } else if (u4cIRj4DZJT.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) u4cIRj4DZJT.this.getActivity()).UpdateMenu();
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
            u4cIRj4DZJT.this.adapterFactura.clearSelection();
            u4cIRj4DZJT.this.actionMode = null;
        }
    }
}
