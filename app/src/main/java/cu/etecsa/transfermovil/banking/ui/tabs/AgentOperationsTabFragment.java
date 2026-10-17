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
import cu.etecsa.transfermovil.banking.ui.general.NautaRechargeFragment;
import cu.etecsa.transfermovil.banking.ui.general.NautaMobileRechargeFragment;
import cu.etecsa.transfermovil.banking.ui.general.PhoneBillPaymentFragment;
import cu.etecsa.transfermovil.banking.ui.general.MobileRechargeFragment;
import cu.etecsa.transfermovil.banking.ui.general.CardRechargeFragment;
import cu.etecsa.transfermovil.banking.ui.general.CubacelPlanPurchaseFragment;
import cu.etecsa.transfermovil.banking.ui.general.GeneralTransferFragment;
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC
 *
 * Agent operations tab — "Agente". Shows wallet-agent operations:
 * phone bill, mobile recharge, nauta coupon, nauta recharge, own recharge, cubacel packages.
 *
 * Also contains dialogs for:
 *   - Agent phone operation (recharge vs query)
 *   - Agent recharge with agency (6 sub-options)
 *   - Balance query confirmation
 *   - Close session confirmation (USSD 11*6)
 *   - Last recharges (all vs cell)
 */
public class AgentOperationsTabFragment extends Fragment {

    public Context context;
    public View rootView;
    public RecyclerView recyclerView;

    public OperationListAdapter.OnItemClickListener onItemClickListener = new OperationListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onGetItemClick(View view, BankOperationCode operacion) {
            FragmentManager fm = AgentOperationsTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (operacion != null) {
                switch (operacion) {
                    case BOLSAAGFacturaTelefonica:
                        ft.replace(R.id.containerView, new PhoneBillPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAGRecargaMovil:
                        ft.replace(R.id.containerView, new MobileRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAGCuponNauta:
                        AgentOperationsTabFragment.this.showDialogAgenteOperTelefono();
                        break;
                    case BOLSAAGRecargaNauta:
                        ft.replace(R.id.containerView, new GeneralTransferFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAGConsultaCuponNauta:
                        ft.replace(R.id.containerView, new NautaRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAGRecargaPropia:
                        ft.replace(R.id.containerView, new CardRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAGPaquetesCubacel:
                        ft.replace(R.id.containerView, new CubacelPlanPurchaseFragment()).addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(AgentOperationsTabFragment.this.context, operacion.toString(), Toast.LENGTH_LONG).show();
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
        Integer type = OperationItem.TYPE_POST;

        OperationItem ag1 = new OperationItem();
        ag1.setTitulo(getString(R.string.banco_telefono));
        ag1.setSubtitulo(getString(R.string.banco_sub_telefono));
        ag1.setIcono(R.drawable.ic_pagar_factura_telf_agente);
        ag1.setType(type);
        ag1.setOperacion(BankOperationCode.BOLSAAGFacturaTelefonica);
        items.add(ag1);

        OperationItem ag2 = new OperationItem();
        ag2.setTitulo(getString(R.string.menu_title_recarga_movil_bolsa));
        ag2.setSubtitulo(getString(R.string.menu_sub_recarga_movil_bolsa));
        ag2.setIcono(R.drawable.ic_recarga_movil_agente);
        ag2.setType(type);
        ag2.setOperacion(BankOperationCode.BOLSAAGRecargaMovil);
        items.add(ag2);

        OperationItem ag3 = new OperationItem();
        ag3.setTitulo(getString(R.string.title_recargar_nauta_bolsa));
        ag3.setSubtitulo(getString(R.string.title_detail_recargar_nauta));
        ag3.setIcono(R.drawable.ic_recargar_naura_cupon_agente);
        ag3.setType(type);
        ag3.setOperacion(BankOperationCode.BOLSAAGCuponNauta);
        items.add(ag3);

        OperationItem ag4 = new OperationItem();
        ag4.setTitulo(getString(R.string.title_recarga_nauta));
        ag4.setSubtitulo(getString(R.string.sub_recarga_nauta));
        ag4.setIcono(R.drawable.ic_recarga_nauta_agente);
        ag4.setType(type);
        ag4.setOperacion(BankOperationCode.BOLSAAGRecargaNauta);
        items.add(ag4);

        OperationItem ag5 = new OperationItem();
        ag5.setTitulo(getString(R.string.hint_recarga_propia));
        ag5.setSubtitulo(getString(R.string.hint_subtitle_recarga_propia));
        ag5.setIcono(R.drawable.ic_recarga_propia_agente);
        ag5.setType(type);
        ag5.setOperacion(BankOperationCode.BOLSAAGRecargaPropia);
        items.add(ag5);

        OperationItem ag6 = new OperationItem();
        ag6.setTitulo(getString(R.string.head_paquetes_cubacel));
        ag6.setSubtitulo(getString(R.string.sub_compra_paquetes));
        ag6.setIcono(R.drawable.ic_compra_planes_agente);
        ag6.setType(type);
        ag6.setOperacion(BankOperationCode.BOLSAAGPaquetesCubacel);
        items.add(ag6);

        OperationListAdapter adapter = new OperationListAdapter(this.context, items);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    void showDialogAgenteOperTelefono() {
        CharSequence[] items = {this.context.getString(R.string.tx_opcion_ag_telefono_recarga), this.context.getString(R.string.tx_opcion_ag_telefono_consulta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager fm = AgentOperationsTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (i) {
                    case 0:
                        ft.replace(R.id.containerView, new NautaMobileRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        ft.replace(R.id.containerView, new NautaRechargeFragment()).addToBackStack(null).commit();
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

    void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_consultar_saldo_stock));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // USSD 11*2: query agent stock balance
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // USSD 11*6: disconnect agent session
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showDialogUltimasRecargas() {
        CharSequence[] items = {this.context.getString(R.string.msg_ilt_recharge_all), this.context.getString(R.string.msg_ult_recharge_cell)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    // USSD 11*4: all last recharges
                } else {
                    FragmentManager fm = AgentOperationsTabFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    // Navigate to last recharges by cell fragment
                }
            }
        });
        builder.create().show();
    }
}
