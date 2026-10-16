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
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.aKh5ZFPmqR;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.qcI22KekhL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HPuMiTypoW;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class B2duAUYNOU extends Fragment {
    public aKh5ZFPmqR adapterDetalle;
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
        new ArrayList();
        unYp8VQThY.init(this.context);
        try {
            new rDEl7rW1aN();
            new HPuMiTypoW(getContext().getContentResolver()).execute(new Void[0]);
        } catch (Exception e) {
        }
        List<qcI22KekhL> itemsOperacion = unYp8VQThY.getInstance().getResumenRecordLists();
        aKh5ZFPmqR akh5zfpmqr = new aKh5ZFPmqR(this.context, itemsOperacion, getActivity());
        this.adapterDetalle = akh5zfpmqr;
        this.rvdetalle.setAdapter(akh5zfpmqr);
        return rootView;
    }
}
