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
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletLatestOperationsFragment;
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
import cu.etecsa.transfermovil.ui.fragment.BalanceQueryFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V
 *
 * General queries tab — "Consultas". 7 menu items for wallet query operations.
 *
 * Menu items:
 *   BOLSAConsultarSaldo → dialog: wallet balance / classic balance (USSD 46)
 *   BOLSAUltimasOperaciones → QM5YzxsQFRH.dI2tctjNbR (agent operation fragment)
 *   BOLSAConsultaServicio → agent check: phone bill fragment or dialog
 *   BOLSAEstadoCuenta → agent wallet recharge fragment (qAMfdm9Kls)
 *   BOLSAConsultaReservaOFA → dialog: OFA reservation query type
 *   BOLSAConsultaTicket → dialog: ticket query (USSD 103) or per-ticket lookup
 *   BOLSAConsultaMiBoleto → dialog: 5 MiBoleto sub-options
 *   BOLSAConsultaSindicato → navigate to sindicato payment query
 *
 * Dialogs:
 *   showDialogConsultaSaldo() — wallet vs classic account (array_bolsa_consulta_saldo)
 *   showDialogConsultaTicket() — USSD 103 vs per-ticket (array_bolsa_consulta_ticket)
 *   showDialogReservaOFA() — OFA visit/tour type (array_consulta_reserva_ofa)
 *   showAGConsulta() — agent query: phone bill vs general bill
 *   showConsultaMiBoleto() — 5 options: offers/last ops/tickets/status/update key
 *   goToConsultaSindicato() — navigates with BankType.MiTransfer + OperationType.ConsultarPagosSindicato
 */
public class GeneralBankingTabFragment extends Fragment {

    public Context context;
    public View rootView;
    public RecyclerView recyclerView;

    public OperationListAdapter.OnItemClickListener onItemClickListener = new OperationListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onGetItemClick(View view, BankOperationCode operacion) {
            FragmentManager fm = GeneralBankingTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (operacion != null) {
                switch (operacion) {
                    case BOLSAConsultarSaldo:
                        GeneralBankingTabFragment.this.showDialogConsultaSaldo();
                        break;
                    case BOLSAUltimasOperaciones:
                        ft.replace(R.id.containerView, new WalletLatestOperationsFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAConsultaServicio:
                        if (cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ.isAGTelecom(this.context)) {
                            GeneralBankingTabFragment.this.showAGConsulta();
                        } else {
                            ft.replace(R.id.containerView,
                                    new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb())
                                    .addToBackStack(null).commit();
                        }
                        break;
                    case BOLSAEstadoCuenta:
                        ft.replace(R.id.containerView,
                                new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAConsultaReservaOFA:
                        GeneralBankingTabFragment.this.showDialogReservaOFA();
                        break;
                    case BOLSAConsultaTicket:
                        GeneralBankingTabFragment.this.showDialogConsultaTicket();
                        break;
                    case BOLSAConsultaMiBoleto:
                        GeneralBankingTabFragment.this.showConsultaMiBoleto();
                        break;
                    case BOLSAConsultaSindicato:
                        GeneralBankingTabFragment.this.goToConsultaSindicato();
                        break;
                    default:
                        Toast.makeText(GeneralBankingTabFragment.this.context, operacion.toString(), Toast.LENGTH_LONG).show();
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

        OperationItem consultaSaldo = new OperationItem();
        consultaSaldo.setTitulo(getString(R.string.tx_consultar_saldo));
        consultaSaldo.setSubtitulo(getString(R.string.tx_consultar_saldo_actual));
        consultaSaldo.setIcono(R.drawable.ic_consulta_saldo_bolsa);
        consultaSaldo.setType(type);
        consultaSaldo.setOperacion(BankOperationCode.BOLSAConsultarSaldo);
        items.add(consultaSaldo);

        OperationItem ultOperaciones = new OperationItem();
        ultOperaciones.setTitulo(getString(R.string.tx_ultimas_operaciones));
        ultOperaciones.setSubtitulo(getString(R.string.tx_sub_ultimas_operaciones_bolsa));
        ultOperaciones.setIcono(R.drawable.ic_consulta_utlimas_oper_bolsa);
        ultOperaciones.setType(type);
        ultOperaciones.setOperacion(BankOperationCode.BOLSAUltimasOperaciones);
        items.add(ultOperaciones);

        OperationItem consultaServicios = new OperationItem();
        consultaServicios.setTitulo(getString(R.string.tx_consultar_servicio_bolsa));
        consultaServicios.setSubtitulo(getString(R.string.tx_sub_consultar_servicio_bolsa));
        consultaServicios.setIcono(R.drawable.ic_consultar_servicio_bolsa);
        consultaServicios.setType(type);
        consultaServicios.setOperacion(BankOperationCode.BOLSAConsultaServicio);
        items.add(consultaServicios);

        OperationItem estadoCuenta = new OperationItem();
        estadoCuenta.setTitulo("Estado Cuentas");
        estadoCuenta.setSubtitulo("Solicitar estado de una cuenta");
        estadoCuenta.setIcono(R.drawable.ic_consulta_estado_cuenta_bolsa);
        estadoCuenta.setType(type);
        estadoCuenta.setOperacion(BankOperationCode.BOLSAEstadoCuenta);
        items.add(estadoCuenta);

        OperationItem consultaOFA = new OperationItem();
        consultaOFA.setTitulo(getString(R.string.title_consulta_reservas_ofa));
        consultaOFA.setSubtitulo(getString(R.string.subtitle_consulta_reservas_ofa));
        consultaOFA.setIcono(R.drawable.ic_consulta_ofa_bolsa_nuevo);
        consultaOFA.setType(type);
        consultaOFA.setOperacion(BankOperationCode.BOLSAConsultaReservaOFA);
        items.add(consultaOFA);

        OperationItem consultaTicket = new OperationItem();
        consultaTicket.setTitulo(getString(R.string.title_reserva_ticket_consulta));
        consultaTicket.setSubtitulo(getString(R.string.title_reserva_ticket_consulta));
        consultaTicket.setIcono(R.drawable.ic_consulta_miturno_bolsa);
        consultaTicket.setType(type);
        consultaTicket.setOperacion(BankOperationCode.BOLSAConsultaTicket);
        items.add(consultaTicket);

        OperationItem consultaMiBoleto = new OperationItem();
        consultaMiBoleto.setTitulo(getString(R.string.title_consulta_miboleto));
        consultaMiBoleto.setSubtitulo(getString(R.string.subtitle_consulta_miboleto));
        consultaMiBoleto.setIcono(R.drawable.ic_consulta_miboleto_bolsa);
        consultaMiBoleto.setType(type);
        consultaMiBoleto.setOperacion(BankOperationCode.BOLSAConsultaMiBoleto);
        items.add(consultaMiBoleto);

        OperationListAdapter adapter = new OperationListAdapter(this.context, items);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    void showDialogConsultaSaldo() {
        CharSequence[] items = getResources().getStringArray(R.array.array_bolsa_consulta_saldo);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de cuenta: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 1) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.containerView, new BalanceQueryFragment())
                            .addToBackStack(null).commit();
                } else {
                    ((BaseMainActivity) getActivity()).actionCallUSSD("46");
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showDialogConsultaTicket() {
        CharSequence[] items = getResources().getStringArray(R.array.array_bolsa_consulta_ticket);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de consulta: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ((BaseMainActivity) getActivity()).actionCallUSSD("103");
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerView,
                                    new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.x12rSjPY6pZ())
                            .addToBackStack(null).commit();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showDialogReservaOFA() {
        CharSequence[] items = getResources().getStringArray(R.array.array_consulta_reserva_ofa);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de consulta de Visita/Recorrido: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle args = new Bundle();
                args.putSerializable("R1sDOSqZ2z", cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z.MiTransfer);
                args.putSerializable("Opcion", Integer.valueOf(i + 1));
                cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dYBdUyjb1D fragment =
                        new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dYBdUyjb1D();
                fragment.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, fragment).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    void showConsultaMiBoleto() {
        CharSequence[] items = {"Consulta de Ofertas", "Últimas operaciones realizadas",
                "Consulta de boletos", "Consulta estado de boleto", "Actualizar clave de boleto"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.alert_msg_consulta_combustible));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0: // USSD 117: query offers
                        ((BaseMainActivity) getActivity()).actionCallUSSD("117");
                        break;
                    case 1: // → i9I9XZGnR3 (MiBoleto last ops)
                        navigateToMiBoletoFragment(
                                new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.i9I9XZGnR3());
                        break;
                    case 2: // → OXpoe3K2m1 (ticket query)
                        navigateToMiBoletoFragment(
                                new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.OXpoe3K2m1());
                        break;
                    case 3: // → w7mHpmOa4EP (ticket status)
                        navigateToMiBoletoFragment(
                                new cu.etecsa.transfermovil.ui.fragment.TicketStatusFragment());
                        break;
                    case 4: // → hjX8MS8xO9 (update ticket key)
                        navigateToMiBoletoFragment(
                                new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.rq5HBT3ZZCR.hjX8MS8xO9());
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

    void goToConsultaSindicato() {
        Bundle args = new Bundle();
        args.putSerializable("R1sDOSqZ2z", cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z.MiTransfer);
        args.putSerializable("Nl0yptXmjQ", cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ.ConsultarPagosSindicato);
        cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i fragment =
                new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i();
        fragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, fragment).addToBackStack(null).commit();
    }

    private void showAGConsulta() {
        CharSequence[] items = {
                this.context.getString(R.string.tx_modal_head_consulat_ag_op1),
                this.context.getString(R.string.tx_modal_head_consulat_ag_op2)
        };
        new AlertDialog.Builder(this.context)
                .setTitle(R.string.tx_modal_head_consulat_ag)
                .setSingleChoiceItems(items, -1, (dialog, index) -> {
                    Fragment destination = index == 0
                            ? new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.HFzgpLELho()
                            : new cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb();
                    Bundle args = new Bundle();
                    args.putSerializable("R1sDOSqZ2z",
                            cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z.MiTransfer);
                    destination.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerView, destination).addToBackStack(null).commit();
                    dialog.dismiss();
                })
                .setNegativeButton("Salir", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void navigateToMiBoletoFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, fragment).addToBackStack(null).commit();
    }
}
