package cu.etecsa.transfermovil.ui.home;

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

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.cYyrKJVQ6G
 * @fingerprint Home screen operations grid. Creates a RecyclerView with GridLayoutManager,
 *              attaches OperationsGridAdapter + ItemTouchHelper for drag-reorder.
 *              Implements DragStartListener to programmatically initiate drags.
 */
public class OperationsGridFragment extends Fragment implements DragStartListener {
    private ItemTouchHelper itemTouchHelper;

    public OperationsGridAdapter.OnItemClickListener onItemClickListener =
        new OperationsGridAdapter.OnItemClickListener() {
            public Bundle b = new Bundle();

            @Override
            public void onItemClick(View view, int position) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction();
                Toast.makeText(getActivity(), "Position " + position, Toast.LENGTH_SHORT).show();
            }
        };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OperationsGridAdapter adapter = new OperationsGridAdapter(getActivity(), this);
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        // int spanCount = getResources().getInteger(R.integer.gallery_columns);
        int spanCount = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), spanCount);
        recyclerView.setLayoutManager(layoutManager);
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(adapter);
        this.itemTouchHelper = new ItemTouchHelper(callback);
        this.itemTouchHelper.attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        this.itemTouchHelper.startDrag(viewHolder);
    }
}
