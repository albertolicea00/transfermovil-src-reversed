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
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletChangePinFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletEmailRegistrationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletQrPaymentFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletRegistrationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletAccountSelectorFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletTransferFragment;
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.hOQ4ESKEhm
 *
 * Wallet configuration tab — "Configuración". Shows wallet management operations:
 * register, change PIN, delete registration, associate classic account.
 *
 * Routes:
 *   BOLSARegistrarse → WalletEmailRegistrationFragment
 *   BOLSACambioPin → WalletChangePinFragment
 *   BOLSAEliminarRegistro → dialog: wallet delete / classic delete
 *   BOLSAAsociarCuenta → dialog: classic / enterprise classic
 */
public class WalletBoletoTabFragment extends Fragment {

    public Context context;
    public boolean isMiBoletoActive = false;
    public View rootView;
    public RecyclerView recyclerView;

    public OperationListAdapter.OnItemClickListener onItemClickListener = new OperationListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onGetItemClick(View view, BankOperationCode operacion) {
            FragmentManager fm = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (operacion != null) {
                switch (operacion) {
                    case BOLSARegistrarse:
                        ft.replace(R.id.containerView, new WalletEmailRegistrationFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSACambioPin:
                        ft.replace(R.id.containerView, new WalletChangePinFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAEliminarRegistro:
                        WalletBoletoTabFragment.this.showDialogEliminarRegistro();
                        break;
                    case BOLSAAsociarCuenta:
                        WalletBoletoTabFragment.this.showDialogAsocClasica();
                        break;
                    default:
                        Toast.makeText(WalletBoletoTabFragment.this.context, operacion.toString(), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView rv = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.recyclerView = rv;
        rv.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        initData();
        return this.rootView;
    }

    private void initData() {
        List<OperationItem> items = new ArrayList<>();

        OperationItem registro = new OperationItem();
        registro.setTitulo(getString(R.string.tx_registrarse));
        registro.setSubtitulo(getString(R.string.tx_sub_registro_bolsa));
        registro.setIcono(R.drawable.ic_registrarse_bolsa);
        registro.setType(OperationItem.TYPE_POST);
        registro.setOperacion(BankOperationCode.BOLSARegistrarse);
        items.add(registro);

        OperationItem cambioclave = new OperationItem();
        cambioclave.setTitulo(getString(R.string.tx_cambio_pin_bolsa));
        cambioclave.setSubtitulo(getString(R.string.tx_sub_cambio_pin_bolsa));
        cambioclave.setIcono(R.drawable.ic_cambio_pin_bolsa);
        cambioclave.setType(OperationItem.TYPE_POST);
        cambioclave.setOperacion(BankOperationCode.BOLSACambioPin);
        items.add(cambioclave);

        OperationItem eliminarreg = new OperationItem();
        eliminarreg.setTitulo(getString(R.string.tx_eliminar_registro));
        eliminarreg.setSubtitulo(getString(R.string.tx_sub_eliminar_registro));
        eliminarreg.setIcono(R.drawable.ic_eliminar_registro_bolsa);
        eliminarreg.setType(OperationItem.TYPE_POST);
        eliminarreg.setOperacion(BankOperationCode.BOLSAEliminarRegistro);
        items.add(eliminarreg);

        OperationItem asociarClasica = new OperationItem();
        asociarClasica.setTitulo(getString(R.string.tx_title_clasica));
        asociarClasica.setSubtitulo(getString(R.string.tx_subtitle_clasica));
        asociarClasica.setIcono(R.drawable.ic_asociar_cuenta_bolsa);
        asociarClasica.setType(OperationItem.TYPE_POST);
        asociarClasica.setOperacion(BankOperationCode.BOLSAAsociarCuenta);
        items.add(asociarClasica);

        OperationListAdapter adapter = new OperationListAdapter(this.context, items);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    void showDialogEliminarRegistro() {
        CharSequence[] items = {this.context.getString(R.string.eliminar_registro_wallet), this.context.getString(R.string.title_eliminar_registro_clasica)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el Registro a Eliminar");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager fm = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (i) {
                    case 0:
                        ft.replace(R.id.containerView, new WalletRegistrationFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        ft.replace(R.id.containerView, new WalletAccountSelectorFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showDialogAsocClasica() {
        CharSequence[] items = {this.context.getString(R.string.tx_title_clasica), this.context.getString(R.string.tx_title_clasica_empresarial)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.hint_seleccione_tipo_cuenta_movil));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager fm = WalletBoletoTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (i) {
                    case 0:
                        ft.replace(R.id.containerView, new WalletQrPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        ft.replace(R.id.containerView, new WalletTransferFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }
}
