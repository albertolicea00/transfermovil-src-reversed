package cu.etecsa.cubacel.tr.tm.us8tbD58ow4;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.JPTJLdwS9n;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.M7OG7jG8CS;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.QV8ylwbhfB;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class D1rOcltDGsD extends Fragment {
    public FloatingActionButton actionButtomExport;
    public FloatingActionButton actionButtomImport;
    public Context context;
    public SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() { // from class: cu.etecsa.cubacel.tr.tm.us8tbD58ow4.D1rOcltDGsD.1
        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String query) {
            String query2 = query.toLowerCase();
            unYp8VQThY.init(D1rOcltDGsD.this.context);
            List<RecordSMS> filteredList = new ArrayList<>();
            for (RecordSMS uyh0pxs9m37in : D1rOcltDGsD.this.recordsLists) {
                if (uyh0pxs9m37in.getServicio().toLowerCase().contains(query2) || uyh0pxs9m37in.getCuenta().toLowerCase().contains(query2) || uyh0pxs9m37in.getMoneda().toLowerCase().contains(query2) || uyh0pxs9m37in.getIdTransaccion().toLowerCase().contains(query2)) {
                    filteredList.add(uyh0pxs9m37in);
                }
            }
            List<M7OG7jG8CS> itemsOperacion = new ArrayList<>();
            for (RecordSMS record : filteredList) {
                M7OG7jG8CS uyh0pxs9m37in2 = new M7OG7jG8CS();
                uyh0pxs9m37in2.setCuenta(record.getCuenta());
                uyh0pxs9m37in2.setFecha(record.getFecha());
                uyh0pxs9m37in2.setIdTransaccion(record.getIdTransaccion());
                uyh0pxs9m37in2.setMonto(record.getMonto());
                uyh0pxs9m37in2.setServicio(record.getServicio());
                uyh0pxs9m37in2.setMoneda(record.getMoneda());
                itemsOperacion.add(uyh0pxs9m37in2);
            }
            D1rOcltDGsD d1rOcltDGsD = D1rOcltDGsD.this;
            d1rOcltDGsD.mRecyclerView.setLayoutManager(d1rOcltDGsD.llDetalle);
            D1rOcltDGsD d1rOcltDGsD2 = D1rOcltDGsD.this;
            d1rOcltDGsD2.mAdapter = new QV8ylwbhfB(d1rOcltDGsD2.context, itemsOperacion);
            D1rOcltDGsD d1rOcltDGsD3 = D1rOcltDGsD.this;
            d1rOcltDGsD3.mRecyclerView.setAdapter(d1rOcltDGsD3.mAdapter);
            D1rOcltDGsD.this.mAdapter.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    };
    public LinearLayoutManager llDetalle;
    public QV8ylwbhfB mAdapter;
    public ItemTouchHelperExtension.Callback mCallback;
    public ItemTouchHelperExtension mItemTouchHelper;
    public RecyclerView mRecyclerView;
    public List<RecordSMS> recordsLists;
    public SearchView search;
    public KYTjPlWScT tipo_estadistica;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.y99qc0voicwyog, container, false);
        this.context = container.getContext();
        SearchView searchView = (SearchView) rootView.findViewById(R.id.searchView);
        this.search = searchView;
        searchView.setOnQueryTextListener(this.listener);
        int i = -1;
        if (Build.VERSION.SDK_INT >= 23 && getContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        }
        this.mRecyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        this.llDetalle = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.setHasFixedSize(true);
        List<M7OG7jG8CS> itemsOperacion = new ArrayList<>();
        unYp8VQThY.init(this.context);
        if (getArguments() == null) {
            this.recordsLists = unYp8VQThY.getInstance().getAllRecordLists();
        } else {
            KYTjPlWScT tipo_servicio = KYTjPlWScT.Agentes;
            if (getArguments().containsKey("TipoEstadistica")) {
                tipo_servicio = (KYTjPlWScT) getArguments().getSerializable("TipoEstadistica");
            }
            if (!getArguments().containsKey("anno") || !getArguments().containsKey("mes")) {
                this.recordsLists = unYp8VQThY.getInstance().getAllRecordLists(tipo_servicio);
            } else {
                int anno = Integer.parseInt(getArguments().get("anno").toString());
                int mes = Integer.parseInt(getArguments().get("mes").toString());
                if (!getArguments().containsKey("moneda") || !getArguments().containsKey("servicio")) {
                    this.recordsLists = unYp8VQThY.getInstance().getRecordSMSBetweenDates(tipo_servicio, mes, anno);
                } else {
                    String moneda = getArguments().get("moneda").toString();
                    String servicio = getArguments().get("servicio").toString();
                    this.recordsLists = unYp8VQThY.getInstance().getRecordSMSBetweenDates(tipo_servicio, servicio, moneda, mes, anno);
                }
            }
        }
        List<RecordSMS> list = this.recordsLists;
        if (list != null) {
            for (RecordSMS record : list) {
                M7OG7jG8CS uyh0pxs9m37in = new M7OG7jG8CS();
                try {
                    if (record.getServicio().contains("Transferencia")) {
                        if (record.getCuenta().indexOf("X") == i) {
                            String cuenta = record.getCuenta().substring(0, 6) + "XXXXXX" + record.getCuenta().substring(12, 16);
                            String cuenta2 = cuenta.substring(0, 4) + "-" + cuenta.substring(4, 8) + "-" + cuenta.substring(8, 12) + "-" + cuenta.substring(12, 16);
                            uyh0pxs9m37in.setCuenta(cuenta2);
                            RecordSMS sms = unYp8VQThY.getInstance().getRecordSMSwithIDTransaction(record.getIdTransaccion()).get(0);
                            sms.setCuenta(cuenta2);
                            unYp8VQThY.getInstance().updateRecordSMS(sms);
                        } else {
                            uyh0pxs9m37in.setCuenta(record.getCuenta());
                        }
                    } else {
                        uyh0pxs9m37in.setCuenta(record.getCuenta());
                    }
                } catch (Exception e) {
                    uyh0pxs9m37in.setCuenta(record.getCuenta());
                }
                uyh0pxs9m37in.setFecha(record.getFecha());
                uyh0pxs9m37in.setIdTransaccion(record.getIdTransaccion());
                uyh0pxs9m37in.setMonto(record.getMonto());
                uyh0pxs9m37in.setServicio(record.getServicio());
                uyh0pxs9m37in.setMoneda(record.getMoneda());
                itemsOperacion.add(uyh0pxs9m37in);
                i = -1;
            }
            QV8ylwbhfB qV8ylwbhfB = new QV8ylwbhfB(this.context, itemsOperacion, KYTjPlWScT.Agentes);
            this.mAdapter = qV8ylwbhfB;
            this.mRecyclerView.setAdapter(qV8ylwbhfB);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.mRecyclerView.getContext(), 1);
            this.mRecyclerView.addItemDecoration(dividerItemDecoration);
            JPTJLdwS9n jPTJLdwS9n = new JPTJLdwS9n();
            this.mCallback = jPTJLdwS9n;
            ItemTouchHelperExtension itemTouchHelperExtension = new ItemTouchHelperExtension(jPTJLdwS9n);
            this.mItemTouchHelper = itemTouchHelperExtension;
            itemTouchHelperExtension.closeOpened();
            this.mItemTouchHelper.attachToRecyclerView(this.mRecyclerView);
        }
        return rootView;
    }
}
