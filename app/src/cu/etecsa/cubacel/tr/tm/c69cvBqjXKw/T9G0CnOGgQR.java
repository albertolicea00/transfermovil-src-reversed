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
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CuentaBanco;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Factura;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Nauta;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioPublico;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TeflMovil;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TelfFijo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class T9G0CnOGgQR extends Fragment implements XvulaG5FAh.ViewHolder.ClickListener {
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomHelp;
    public FloatingActionButton actionButtomImport;
    public FloatingActionButton actionButtonNuevo;
    private ActionMode actionMode;
    public XvulaG5FAh adapterClientes;
    public List<Client> clienteLists;
    public Context context;
    public RecyclerView rvclientes;
    private ActionModeCallback actionModeCallback = new ActionModeCallback();
    public rDEl7rW1aN bs = new rDEl7rW1aN();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerView getRvclientes() {
        return this.rvclientes;
    }

    public void setRvclientes(RecyclerView rvclientes) {
        this.rvclientes = rvclientes;
    }

    public XvulaG5FAh getAdapterClientes() {
        return this.adapterClientes;
    }

    public void setAdapterClientes(XvulaG5FAh adapterClientes) {
        this.adapterClientes = adapterClientes;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rrws8ohvuef8c, container, false);
        this.context = container.getContext();
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.T9G0CnOGgQR.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FragmentManager mFragmentManager = T9G0CnOGgQR.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                cAnuWG2fly editCliente = new cAnuWG2fly();
                mFragmentTransaction.replace(R.id.containerView, editCliente).addToBackStack(null).commit();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.T9G0CnOGgQR.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.T9G0CnOGgQR.2.1
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
        this.rvclientes = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvclientes.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        this.rvclientes.setLayoutManager(llmFactura);
        fillAdapter();
        return rootView;
    }

    public void fillAdapter() {
        unYp8VQThY.init(this.context);
        this.clienteLists = unYp8VQThY.getInstance().getAllClientLists();
        String clientProper = BuildConfig.FLAVOR;
        if (getActivity() instanceof IHVTCBmiLV) {
            clientProper = "Cliente #";
        } else if (getActivity() instanceof S9ycHcoxAzy) {
            clientProper = "Propietario #";
        }
        List<yHdVJARBHM> itemsClientes = new ArrayList<>();
        int Contador = 1;
        for (Client c : this.clienteLists) {
            yHdVJARBHM uyh0pxs9m37in = new yHdVJARBHM(c.getId(), c.getName(), clientProper + String.valueOf(Contador), false);
            itemsClientes.add(uyh0pxs9m37in);
            Contador++;
        }
        XvulaG5FAh xvulaG5FAh = new XvulaG5FAh(this, itemsClientes, getActivity(), 0);
        this.adapterClientes = xvulaG5FAh;
        this.rvclientes.setAdapter(xvulaG5FAh);
    }

    @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XvulaG5FAh.ViewHolder.ClickListener
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        Client cliente = this.clienteLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        cAnuWG2fly editCliente = new cAnuWG2fly();
        Bundle b = new Bundle();
        b.putString("Id", String.valueOf(cliente.getId()));
        editCliente.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, editCliente).addToBackStack(null).commit();
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
        this.adapterClientes.toggleSelection(position);
        int count = this.adapterClientes.getSelectedItemCount();
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
                case R.id.btn_pagar /* 2131296456 */:
                    Log.d("Entro", "Aqui");
                    return false;
                case R.id.menu_remove /* 2131297160 */:
                    AlertDialog.Builder builder = new AlertDialog.Builder(T9G0CnOGgQR.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.T9G0CnOGgQR.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = T9G0CnOGgQR.this.adapterClientes.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(T9G0CnOGgQR.this.context);
                                Client clienteRemove = T9G0CnOGgQR.this.clienteLists.get(pos);
                                List<Factura> facturaList = unYp8VQThY.getInstance().getFacturasListsWithCliente(clienteRemove.getId());
                                List<CuentaBanco> cuentasList = unYp8VQThY.getInstance().getCuentasListsWithCliente(clienteRemove.getId());
                                List<ServicioPublico> servicioPublicoList = unYp8VQThY.getInstance().getServiciosPublicosListsWithCliente(clienteRemove.getId());
                                List<TeflMovil> movilList = unYp8VQThY.getInstance().getMovilListsWithCliente(clienteRemove.getId());
                                List<TelfFijo> fijoList = unYp8VQThY.getInstance().getFijoListsWithCliente(clienteRemove.getId());
                                List<Nauta> nautaList = unYp8VQThY.getInstance().getNautasListsWithClient(clienteRemove);
                                for (Factura i : facturaList) {
                                    if (i.getId_client() == clienteRemove.getId()) {
                                        i.setId_client(0);
                                        unYp8VQThY.getInstance().updateFactura(i);
                                    }
                                }
                                for (CuentaBanco i2 : cuentasList) {
                                    if (i2.getId_client() == clienteRemove.getId()) {
                                        i2.setId_client(0);
                                        unYp8VQThY.getInstance().updateCuentaBanco(i2);
                                    }
                                }
                                for (ServicioPublico i3 : servicioPublicoList) {
                                    if (i3.getId_client() == clienteRemove.getId()) {
                                        i3.setId_client(0);
                                        unYp8VQThY.getInstance().updateServicioPublico(i3);
                                    }
                                }
                                for (TeflMovil i4 : movilList) {
                                    if (i4.getId_client() == clienteRemove.getId()) {
                                        i4.setId_client(0);
                                        unYp8VQThY.getInstance().updateMovil(i4);
                                    }
                                }
                                for (TelfFijo i5 : fijoList) {
                                    if (i5.getId_client() == clienteRemove.getId()) {
                                        i5.setId_client(0);
                                        unYp8VQThY.getInstance().updateFijo(i5);
                                    }
                                }
                                for (Nauta i6 : nautaList) {
                                    if (i6.getId_client() == clienteRemove.getId()) {
                                        i6.setId_client(0);
                                        unYp8VQThY.getInstance().updateNauta(i6);
                                    }
                                }
                                unYp8VQThY.getInstance().deleteClient(clienteRemove);
                            }
                            XvulaG5FAh xvulaG5FAh = T9G0CnOGgQR.this.adapterClientes;
                            xvulaG5FAh.removeItems(xvulaG5FAh.getSelectedItems());
                            if (T9G0CnOGgQR.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) T9G0CnOGgQR.this.getActivity()).UpdateMenu();
                            } else if (T9G0CnOGgQR.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) T9G0CnOGgQR.this.getActivity()).UpdateMenu();
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
            T9G0CnOGgQR.this.adapterClientes.clearSelection();
            T9G0CnOGgQR.this.actionMode = null;
        }
    }
}
