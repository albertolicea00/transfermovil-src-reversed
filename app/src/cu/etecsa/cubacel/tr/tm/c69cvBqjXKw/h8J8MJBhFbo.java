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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Pin;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h8J8MJBhFbo extends Fragment implements XvulaG5FAh.ViewHolder.ClickListener {
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomHelp;
    public FloatingActionButton actionButtomImport;
    public FloatingActionButton actionButtonNuevo;
    private ActionMode actionMode;
    public XvulaG5FAh adapterTarjetas;
    public Context context;
    public RecyclerView rvtarjetas;
    public List<Pin> tarjetasLists;
    private ActionModeCallback actionModeCallback = new ActionModeCallback();
    public rDEl7rW1aN bs = new rDEl7rW1aN();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerView getRvtarjetas() {
        return this.rvtarjetas;
    }

    public void setRvtarjetas(RecyclerView rvtarjetas) {
        this.rvtarjetas = rvtarjetas;
    }

    public XvulaG5FAh getAdapterTarjetas() {
        return this.adapterTarjetas;
    }

    public void setAdapterClientes(XvulaG5FAh adapterTarjetas) {
        this.adapterTarjetas = adapterTarjetas;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.jeznqh20psbmw, container, false);
        this.context = container.getContext();
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.h8J8MJBhFbo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentManager mFragmentManager = h8J8MJBhFbo.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                yn4mwNjGz0 editTarjeta = new yn4mwNjGz0();
                mFragmentTransaction.replace(R.id.containerView, editTarjeta).addToBackStack(null).commit();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.h8J8MJBhFbo.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.h8J8MJBhFbo.2.1
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
        this.rvtarjetas = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvtarjetas.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        this.rvtarjetas.setLayoutManager(llmFactura);
        fillAdapter();
        return rootView;
    }

    public void fillAdapter() {
        unYp8VQThY.init(this.context);
        this.tarjetasLists = unYp8VQThY.getInstance().getAllPinLists();
        List<yHdVJARBHM> itemsTarjeta = new ArrayList<>();
        for (Pin c : this.tarjetasLists) {
            yHdVJARBHM uyh0pxs9m37in = new yHdVJARBHM(c.getId(), c.getPin(), c.getDescripcion(), false);
            itemsTarjeta.add(uyh0pxs9m37in);
        }
        XvulaG5FAh xvulaG5FAh = new XvulaG5FAh(this, itemsTarjeta, getActivity(), 4);
        this.adapterTarjetas = xvulaG5FAh;
        this.rvtarjetas.setAdapter(xvulaG5FAh);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        Pin pin = this.tarjetasLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        yn4mwNjGz0 editTarjeta = new yn4mwNjGz0();
        Bundle b = new Bundle();
        b.putString("Id", String.valueOf(pin.getId()));
        editTarjeta.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, editTarjeta).addToBackStack(null).commit();
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
    public boolean onItemLongClicked(int position) {
        if (this.actionMode == null) {
            this.actionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(this.actionModeCallback);
        }
        toggleSelection(position);
        return true;
    }

    private void toggleSelection(int position) {
        this.adapterTarjetas.toggleSelection(position);
        int count = this.adapterTarjetas.getSelectedItemCount();
        if (count == 0) {
            this.actionMode.finish();
        } else {
            this.actionMode.setTitle(String.valueOf(count));
            this.actionMode.invalidate();
        }
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(h8J8MJBhFbo.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.h8J8MJBhFbo.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = h8J8MJBhFbo.this.adapterTarjetas.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(h8J8MJBhFbo.this.context);
                                Pin tarjetaRemove = h8J8MJBhFbo.this.tarjetasLists.get(pos);
                                unYp8VQThY.getInstance().deletePin(tarjetaRemove);
                            }
                            XvulaG5FAh xvulaG5FAh = h8J8MJBhFbo.this.adapterTarjetas;
                            xvulaG5FAh.removeItems(xvulaG5FAh.getSelectedItems());
                            ((IHVTCBmiLV) h8J8MJBhFbo.this.getActivity()).UpdateMenu();
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
            h8J8MJBhFbo.this.adapterTarjetas.clearSelection();
            h8J8MJBhFbo.this.actionMode = null;
        }
    }
}
