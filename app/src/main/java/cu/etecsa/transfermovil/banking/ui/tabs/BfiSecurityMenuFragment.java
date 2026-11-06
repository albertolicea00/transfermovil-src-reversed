package cu.etecsa.transfermovil.banking.ui.tabs;

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
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiChangePinFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiRegistrationFragment;
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.bnsLemXoui */
public class BfiSecurityMenuFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    private final vD9rc3MbTL.OnItemClickListener listener = new vD9rc3MbTL.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) { }
        @Override public void onGetItemClick(View view, FdonIAFI9w operation) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            if (operation == FdonIAFI9w.BFIRegistrarse) {
                transaction.replace(R.id.containerView, new BfiRegistrationFragment()).addToBackStack(null).commit();
            } else if (operation == FdonIAFI9w.BFICambioPin) {
                transaction.replace(R.id.containerView, new BfiChangePinFragment()).addToBackStack(null).commit();
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
        WUULVgZq02 registration = new WUULVgZq02();
        registration.setTitulo(getString(R.string.tx_registrarse));
        registration.setSubtitulo(getString(R.string.tx_sub_registro_bolsa));
        registration.setIcono(R.drawable.ic_registrarse_bfi);
        registration.setType(rBXnNc0Kx4.Post);
        registration.setOperacion(FdonIAFI9w.BFIRegistrarse);
        items.add(registration);

        WUULVgZq02 changePin = new WUULVgZq02();
        changePin.setTitulo(getString(R.string.tx_cambio_pin_bolsa));
        changePin.setSubtitulo(getString(R.string.tx_sub_cambio_pin_bolsa));
        changePin.setIcono(R.drawable.ic_cambio_pin_bfi);
        changePin.setType(rBXnNc0Kx4.Post);
        changePin.setOperacion(FdonIAFI9w.BFICambioPin);
        items.add(changePin);

        vD9rc3MbTL adapter = new vD9rc3MbTL(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(listener);
    }
}
