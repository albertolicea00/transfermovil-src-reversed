package cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class cYyrKJVQ6G extends Fragment implements CdmbKxDIrW {
    private ItemTouchHelper mItemTouchHelper;
    public h6V5083iulG.OnItemClickListener onItemClickListener = new h6V5083iulG.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.cYyrKJVQ6G.1
        public Bundle b = new Bundle();

        @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.h6V5083iulG.OnItemClickListener
        public void onItemClick(View view, int position) {
            FragmentManager mFragmentManager = cYyrKJVQ6G.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            Toast.makeText(cYyrKJVQ6G.this.getActivity(), "Position " + position, 0).show();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        h6V5083iulG adapter = new h6V5083iulG(getActivity(), this);
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        int spanCount = getResources().getInteger(R.integer.gallery_columns);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), spanCount);
        recyclerView.setLayoutManager(layoutManager);
        ItemTouchHelper.Callback callback = new GlX2jG27mG(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        this.mItemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    @Override // cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.CdmbKxDIrW
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        this.mItemTouchHelper.startDrag(viewHolder);
    }
}
