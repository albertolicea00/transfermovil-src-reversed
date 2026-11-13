package cu.etecsa.transfermovil.banking.ui.tabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletChangePinFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletClassicAccountAssociationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletRegistrationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletEnrollmentFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletQrPaymentFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletAccountSelectorFragment;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.hOQ4ESKEhm
 * @original_apk_version 1.260416
 */
public class WalletBoletoTabFragment extends Fragment {
    public Context context;
    public boolean isMiBoletoActive = false;
    public BoletoManagementAdapter.OnItemClickListener onItemClickListener =
            new BoletoManagementAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, BoletoManagementAdapter.Action action) {
            FragmentManager mFragmentManager = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (action != null) {
                switch (action) {
                    case REGISTER:
                        mFragmentTransaction.replace(R.id.containerView, new WalletEnrollmentFragment()).addToBackStack(null).commit();
                        return;
                    case CHANGE_PIN:
                        mFragmentTransaction.replace(R.id.containerView, new WalletChangePinFragment()).addToBackStack(null).commit();
                        return;
                    case DELETE_REGISTRATION:
                        WalletBoletoTabFragment.this.showDialogEliminarRegistro();
                        return;
                    case ASSOCIATE_CLASSIC_ACCOUNT:
                        WalletBoletoTabFragment.this.showDialogAsocClasica();
                        return;
                    default:
                        Toast.makeText(WalletBoletoTabFragment.this.context, action.name(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
    public View rootView;
    public RecyclerView rvseguridad;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.rvseguridad = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        this.rvseguridad.setLayoutManager(llmSegidad);
        initData();
        return this.rootView;
    }

    private void initData() {
        List<BoletoManagementAdapter.MenuItem> itemsOperaciones = new ArrayList<>();
        itemsOperaciones.add(new BoletoManagementAdapter.MenuItem(
                getString(R.string.tx_registrarse), getString(R.string.tx_sub_registro_bolsa),
                R.drawable.ic_registrarse_bolsa, BoletoManagementAdapter.Action.REGISTER));
        itemsOperaciones.add(new BoletoManagementAdapter.MenuItem(
                getString(R.string.tx_cambio_pin_bolsa), getString(R.string.tx_sub_cambio_pin_bolsa),
                R.drawable.ic_cambio_pin_bolsa, BoletoManagementAdapter.Action.CHANGE_PIN));
        itemsOperaciones.add(new BoletoManagementAdapter.MenuItem(
                getString(R.string.tx_eliminar_registro), getString(R.string.tx_sub_eliminar_registro),
                R.drawable.ic_eliminar_registro_bolsa, BoletoManagementAdapter.Action.DELETE_REGISTRATION));
        itemsOperaciones.add(new BoletoManagementAdapter.MenuItem(
                getString(R.string.tx_title_clasica), getString(R.string.tx_subtitle_clasica),
                R.drawable.ic_asociar_cuenta_bolsa, BoletoManagementAdapter.Action.ASSOCIATE_CLASSIC_ACCOUNT));
        BoletoManagementAdapter adapterSeguridad = new BoletoManagementAdapter(itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogEliminarRegistro() {
        CharSequence[] items = {this.context.getString(R.string.eliminar_registro_wallet), this.context.getString(R.string.title_eliminar_registro_clasica)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el Registro a Eliminar");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletBoletoTabFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new WalletRegistrationFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new WalletAccountSelectorFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletBoletoTabFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogAsocClasica() {
        CharSequence[] items = {this.context.getString(R.string.tx_title_clasica), this.context.getString(R.string.tx_title_clasica_empresarial)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.hint_seleccione_tipo_cuenta_movil));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletBoletoTabFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new WalletClassicAccountAssociationFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new WalletQrPaymentFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.WalletBoletoTabFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
