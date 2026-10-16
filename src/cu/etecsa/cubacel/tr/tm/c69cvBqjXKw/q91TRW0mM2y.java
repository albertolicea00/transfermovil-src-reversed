package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.app.Activity;
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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q91TRW0mM2y extends Fragment implements XvulaG5FAh.ViewHolder.ClickListener {
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomHelp;
    public FloatingActionButton actionButtomImport;
    public FloatingActionButton actionButtonNuevo;
    private ActionMode actionMode;
    public Activity activity;
    public XvulaG5FAh adapterNauta;
    public Context context;
    public List<Nauta> nautaLists;
    public RecyclerView rvNauta;
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

    public RecyclerView getRvNauta() {
        return this.rvNauta;
    }

    public void setRvNauta(RecyclerView rvNauta) {
        this.rvNauta = rvNauta;
    }

    public XvulaG5FAh getAdapterNauta() {
        return this.adapterNauta;
    }

    public void setAdapterNauta(XvulaG5FAh adapterNauta) {
        this.adapterNauta = adapterNauta;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.u0dk2ndmiatj0, container, false);
        this.context = container.getContext();
        if (getArguments() != null) {
            this.id_cliente = getArguments().get("IdCliente").toString();
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.q91TRW0mM2y.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentManager mFragmentManager = q91TRW0mM2y.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                bKpfdtiEWm editNauta = new bKpfdtiEWm();
                mFragmentTransaction.replace(R.id.containerView, editNauta).addToBackStack(null).commit();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.q91TRW0mM2y.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.q91TRW0mM2y.2.1
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
        this.rvNauta = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvNauta.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        this.rvNauta.setLayoutManager(llmFactura);
        fillAdapter();
        return rootView;
    }

    public void fillAdapter() {
        unYp8VQThY.init(this.context);
        if (!this.id_cliente.contains("-1")) {
            this.nautaLists = unYp8VQThY.getInstance().getNautaListsWithClient(Integer.parseInt(this.id_cliente));
        } else {
            this.nautaLists = unYp8VQThY.getInstance().getAllNautaLists();
        }
        List<yHdVJARBHM> items = new ArrayList<>();
        for (Nauta c : this.nautaLists) {
            Client cl = unYp8VQThY.getInstance().getClientListWithId(c.getId_client());
            String nom_client = BuildConfig.FLAVOR;
            if (cl != null) {
                nom_client = cl.getName().trim();
            }
            String nom_cuenta = c.getCuenta();
            if (c.getTipo_cuenta() == 1) {
                nom_cuenta = nom_cuenta + "@nauta.com.cu";
            } else if (c.getTipo_cuenta() == 2) {
                nom_cuenta = nom_cuenta + "@nauta.co.cu";
            }
            yHdVJARBHM uyh0pxs9m37in = new yHdVJARBHM(c.getId(), nom_cuenta, nom_client, false);
            items.add(uyh0pxs9m37in);
        }
        XvulaG5FAh xvulaG5FAh = new XvulaG5FAh(this, items, getActivity(), 7, this.context);
        this.adapterNauta = xvulaG5FAh;
        this.rvNauta.setAdapter(xvulaG5FAh);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        Nauta nauta = this.nautaLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        bKpfdtiEWm nautaEdit = new bKpfdtiEWm();
        Bundle b = new Bundle();
        b.putString("Id", String.valueOf(nauta.getId()));
        nautaEdit.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, nautaEdit).addToBackStack(null).commit();
    }

    private void toggleSelection(int position) {
        this.adapterNauta.toggleSelection(position);
        int count = this.adapterNauta.getSelectedItemCount();
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(q91TRW0mM2y.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.q91TRW0mM2y.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = q91TRW0mM2y.this.adapterNauta.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(q91TRW0mM2y.this.context);
                                Nauta nautaRemove = q91TRW0mM2y.this.nautaLists.get(pos);
                                unYp8VQThY.getInstance().deleteNauta(nautaRemove);
                            }
                            XvulaG5FAh xvulaG5FAh = q91TRW0mM2y.this.adapterNauta;
                            xvulaG5FAh.removeItems(xvulaG5FAh.getSelectedItems());
                            if (q91TRW0mM2y.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) q91TRW0mM2y.this.getActivity()).UpdateMenu();
                            } else if (q91TRW0mM2y.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) q91TRW0mM2y.this.getActivity()).UpdateMenu();
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
            q91TRW0mM2y.this.adapterNauta.clearSelection();
            q91TRW0mM2y.this.actionMode = null;
        }
    }
}
