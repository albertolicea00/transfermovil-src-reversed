package cu.etecsa.transfermovil.banking.ui.tabs;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiPinAuthFragment;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.vhcWzIxxMH */
public class BfiSessionMenuFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    private final vD9rc3MbTL.OnItemClickListener listener = new vD9rc3MbTL.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) { }
        @Override public void onGetItemClick(View view, FdonIAFI9w operation) {
            if (operation == FdonIAFI9w.BFIAutenticarse) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerView, new BfiPinAuthFragment()).addToBackStack(null).commit();
            } else if (operation == FdonIAFI9w.BFIDesconectar) {
                showCloseSessionDialog();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = container.getContext();
        View root = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        recyclerView = root.findViewById(R.id.drawerList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        populate();
        return root;
    }

    private void populate() {
        List<WUULVgZq02> items = new ArrayList<>();
        WUULVgZq02 authenticate = new WUULVgZq02();
        authenticate.setTitulo("Autenticarse");
        authenticate.setSubtitulo("Acceder al sistema");
        authenticate.setIcono(R.drawable.ic_autenticarse_bfi);
        authenticate.setType(rBXnNc0Kx4.Post);
        authenticate.setOperacion(FdonIAFI9w.BFIAutenticarse);
        items.add(authenticate);

        WUULVgZq02 disconnect = new WUULVgZq02();
        disconnect.setTitulo(getString(R.string.banco_desconectar));
        disconnect.setSubtitulo(getString(R.string.banco_sub_desconectar));
        disconnect.setIcono(R.drawable.ic_desconectarse_bfi);
        disconnect.setType(rBXnNc0Kx4.Post);
        disconnect.setOperacion(FdonIAFI9w.BFIDesconectar);
        items.add(disconnect);

        vD9rc3MbTL adapter = new vD9rc3MbTL(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(listener);
    }

    private void showCloseSessionDialog() {
        FBsQzP3Zfj.closeSessionBank(getActivity());
        new AlertDialog.Builder(context)
                .setTitle("Seleccione")
                .setMessage(getString(R.string.msg_confirm_close_session))
                .setPositiveButton("Si", (dialog, id) -> ((BaseMainActivity) getActivity()).actionCallUSSD("70"))
                .setNegativeButton("No", (dialog, id) -> { })
                .show();
    }
}
