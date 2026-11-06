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
import java.util.ArrayList;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn */
public class BfiOperationsMenuFragment extends Fragment {
    private Context context;
    private final vD9rc3MbTL.OnItemClickListener listener = new vD9rc3MbTL.OnItemClickListener() {
        @Override public void onItemClick(View view, int position) { }
        @Override public void onGetItemClick(View view, FdonIAFI9w operation) {
            if (operation == FdonIAFI9w.BFITransferirEmpresa) showModeDialog(true);
            else if (operation == FdonIAFI9w.BFIPagoExternoEmpresa) showModeDialog(false);
        }
    };

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        context = container.getContext();
        View root = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        RecyclerView list = root.findViewById(R.id.drawerList);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(context));
        List<WUULVgZq02> items = new ArrayList<>();
        add(items, R.string.traspaso_fondos, R.string.banco_sub_transferencia_cuenta, R.drawable.ic_transferencia_bfi, FdonIAFI9w.BFITransferirEmpresa);
        add(items, R.string.title_pago_externo, R.string.sub_pago_externo, R.drawable.ic_pago_linea_bfi, FdonIAFI9w.BFIPagoExternoEmpresa);
        vD9rc3MbTL adapter = new vD9rc3MbTL(context, items);
        list.setAdapter(adapter);
        adapter.setOnItemClickListener(listener);
        return root;
    }

    private void add(List<WUULVgZq02> items, int title, int subtitle, int icon, FdonIAFI9w operation) {
        WUULVgZq02 item = new WUULVgZq02();
        item.setTitulo(getString(title)); item.setSubtitulo(getString(subtitle));
        item.setIcono(icon); item.setType(rBXnNc0Kx4.Post); item.setOperacion(operation);
        items.add(item);
    }

    private void showModeDialog(boolean transfer) {
        CharSequence[] modes = {getString(R.string.tx_bfi_transferencia_con_solic), getString(R.string.tx_bfi_transferencia_con_confirm), getString(R.string.tx_bfi_transferencia_indistinta)};
        new AlertDialog.Builder(context).setTitle("Seleccione opción").setSingleChoiceItems(modes, -1, (dialog, which) -> {
            Fragment destination;
            Bundle args = new Bundle();
            if (transfer) {
                cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW fragment = new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW();
                args.putSerializable("TransferType", Integer.valueOf(which)); destination = fragment;
            } else {
                cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx fragment = new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx();
                args.putSerializable("PayType", Integer.valueOf(which)); destination = fragment;
            }
            destination.setArguments(args);
            FragmentTransaction tx = getActivity().getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.containerView, destination).addToBackStack(null).commit();
            dialog.dismiss();
        }).setNegativeButton("Salir", (dialog, which) -> { }).show();
    }
}
