package cu.etecsa.cubacel.tr.tm.us8tbD58ow4;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class mYaQ7jnA3Y extends Fragment {
    public ByJot7nE5d adapterPay;
    public Context context;
    public LinearLayoutManager llDetalle;
    public RecyclerView rvdetalle;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ynx03xtkmygd3, container, false);
        this.context = container.getContext();
        if (Build.VERSION.SDK_INT >= 23 && getContext().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        this.rvdetalle = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvdetalle.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        this.llDetalle = linearLayoutManager;
        this.rvdetalle.setLayoutManager(linearLayoutManager);
        Calendar c = Calendar.getInstance();
        if (getArguments().containsKey("newEstaditica")) {
            getArguments().clear();
            U6ucOCBccJ.itemsOperacionList = null;
        }
        ByJot7nE5d byJot7nE5d = new ByJot7nE5d(this.context, getActivity(), c.get(2) + 1, c.get(1));
        this.adapterPay = byJot7nE5d;
        this.rvdetalle.setAdapter(byJot7nE5d);
        return rootView;
    }
}
