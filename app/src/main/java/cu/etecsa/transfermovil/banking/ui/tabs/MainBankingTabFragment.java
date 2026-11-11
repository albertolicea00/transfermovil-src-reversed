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
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.transfermovil.banking.BankOperationCode;
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
import cu.etecsa.transfermovil.ui.fragment.WalletRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletTopupFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletWithdrawFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletClassicTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.NautaUserFragment;
import cu.etecsa.transfermovil.ui.fragment.NautaPlusRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.OwnCardPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletExtraPackageFragment;
import cu.etecsa.transfermovil.ui.fragment.FwaBalanceRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.FwaDataPackagePurchaseFragment;
import cu.etecsa.transfermovil.ui.fragment.CubacelPackagePurchaseFragment;
import cu.etecsa.transfermovil.ui.fragment.TfaRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.CreditPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.OfaReservationFragment;
import cu.etecsa.transfermovil.ui.fragment.OfaContributionFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationCreateFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationDateChangeFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationCancelFragment;
import cu.etecsa.transfermovil.ui.fragment.FixedPhoneBillPaymentFragment;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.As6QBoLoQJ;
import cu.etecsa.transfermovil.ui.fragment.QrDynamicPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.MiBoletoPurchaseFragment;
import cu.etecsa.transfermovil.ui.fragment.MobileVotingFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiEnterpriseTransferFragment;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiExternalPaymentFragment;
import cu.etecsa.transfermovil.core.enums.AccountType;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletBankTransferFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletElectricityPaymentFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletWaterPaymentFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletGasPaymentFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.rR6oImkdEU
 *
 * Main operations tab — "Operaciones". 23 menu items covering all wallet payment/service ops.
 * Largest tab fragment (731 lines). Executes ticket offer check on create.
 *
 * 26 operation codes handled:
 *   BOLSATransferencia → dialog: MiTransfer vs Clásica
 *   BOLSATelefono → p5B8KozjvpQ (phone bill payment)
 *   BOLSARecargaMovil → WalletTopupFragment with CUP currency
 *   BOLSARecargaNauta → NautaUserFragment (nauta recharge)
 *   BOLSARecargaPropia → JrjJL8mtlI (own card recharge)
 *   BOLSAPagoLinea → s9CT6pjRyD with OperationType.xf94v3SFEM
 *   BOLSACompraPaqueteMLC → f3Ttlx30sMT (MLC package purchase)
 *   BOLSARecargaNautaMLC → dialog: nauta plus sin/con cuenta
 *   BOLSARecargaFWA → dialog: 4G FWA recharge vs query
 *   BOLSACompraPaqueteFWA → q55ExEc6x2l (FWA package purchase)
 *   BOLSARecargaCUPWalletTicket → WalletRechargeFragment (CUP wallet ticket recharge)
 *   BOLSAExtraccionWalletTicket → f9Reflqt3EZ (cash extraction from ticket)
 *   BOLSATransferirBancos → WalletBankTransferFragment (transfer to bank accounts)
 *   BOLSAElectricidad → dwdZ5sHcFR (electricity payment)
 *   BOLSAAgua → WalletWaterPaymentFragment
 *   BOLSAgas → XCDkgbw8oZ (gas payment)
 *   BOLSAPaquetesCubacel → WyYHxgzYyW (Cubacel packages)
 *   BOLSAPCC → xb7DiohJuX (political org payment)
 *   BOLSAReservasOFA → dWLcK5oQoS (OFA reservations)
 *   BOLSAAporteOFA → C6ZYln3x19W (OFA contributions)
 *   BOLSAReservasTicket → dialog: reserve/delete/change date
 *   BOLSARecargaTFA → b7zSZMAX7cN (TFA recharge)
 *   BOLSATransferenciaClasicaEmpresarial → dialog: solicitud/confirmación
 *   BOLSAPagoExternoClasicaEmpresarial → dialog: solicitud/confirmación
 *   BOLSACompraMiBoleto → TBaFnBLjEA (MiBoleto purchase)
 *   BOLSAVotoMovil → cdINOtQ3iN (mobile voting)
 *
 * Dialogs:
 *   showDialogTransferencia() — MiTransfer vs Clásica → WalletTransferFragment / WalletClassicTransferFragment
 *   showDialogNautaPlus() — sin/con cuenta → HZgbT8IXPf with AccountType
 *   showDialog4G() — FWA recharge vs query → wbFn8tBw8W / q55ExEc6x2l
 *   showDialogReservasTicket() — reserve/delete/change → XnVSHGPTkK/QVPgkl8ZGC/Wwc5crW71D
 *   showDialogTransferenciaEmpresarial() — solicitud/confirmación → Z3kYdPwq6K2
 *   showDialogPagoExternoEmpresarial() — solicitud/confirmación → Eqj43O0pUx with CLASICAEMP
 *   showDialogRecargaMovil() — CUP/USD → zzyNbaqs1U with Currency
 */
public class MainBankingTabFragment extends Fragment {

    public Context context;
    public View rootView;
    public RecyclerView recyclerView;

    public OperationListAdapter.OnItemClickListener onItemClickListener = new OperationListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
        }

        @Override
        public void onGetItemClick(View view, BankOperationCode operacion) {
            FragmentManager fm = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (operacion != null) {
                switch (operacion) {
                    case BOLSATransferencia:
                        MainBankingTabFragment.this.showDialogTransferencia();
                        break;
                    case BOLSATelefono:
                        ft.replace(R.id.containerView, new FixedPhoneBillPaymentFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSARecargaMovil:
                        Bundle walletTopupArgs = new Bundle();
                        walletTopupArgs.putSerializable("TipoBolsa", qTDVwLFEjE.CUP);
                        walletTopupArgs.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        WalletTopupFragment walletTopup = new WalletTopupFragment();
                        walletTopup.setArguments(walletTopupArgs);
                        ft.replace(R.id.containerView, walletTopup).addToBackStack(null).commit();
                        break;
                    case BOLSARecargaNauta:
                        ft.replace(R.id.containerView, new NautaUserFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSARecargaPropia:
                        ft.replace(R.id.containerView, new OwnCardPaymentFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAPagoLinea:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pdata = "";
                        Bundle onlinePaymentArgs = new Bundle();
                        onlinePaymentArgs.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        onlinePaymentArgs.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        QrDynamicPaymentFragment onlinePayment = new QrDynamicPaymentFragment();
                        onlinePayment.setArguments(onlinePaymentArgs);
                        ft.replace(R.id.containerView, onlinePayment).addToBackStack(null).commit();
                        break;
                    case BOLSACompraPaqueteMLC:
                        ft.replace(R.id.containerView, new WalletExtraPackageFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSARecargaNautaMLC:
                        MainBankingTabFragment.this.showDialogNautaPlus();
                        break;
                    case BOLSARecargaFWA:
                        MainBankingTabFragment.this.showDialog4G();
                        break;
                    case BOLSACompraPaqueteFWA:
                        ft.replace(R.id.containerView, new FwaDataPackagePurchaseFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSARecargaCUPWalletTicket:
                        ft.replace(R.id.containerView, new WalletRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAExtraccionWalletTicket:
                        ft.replace(R.id.containerView, new WalletWithdrawFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSATransferirBancos:
                        ft.replace(R.id.containerView, new WalletBankTransferFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAElectricidad:
                        ft.replace(R.id.containerView, new WalletElectricityPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAAgua:
                        ft.replace(R.id.containerView, new WalletWaterPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAgas:
                        ft.replace(R.id.containerView, new WalletGasPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case BOLSAPaquetesCubacel:
                        ft.replace(R.id.containerView, new CubacelPackagePurchaseFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAPCC:
                        ft.replace(R.id.containerView, new CreditPaymentFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAReservasOFA:
                        ft.replace(R.id.containerView, new OfaReservationFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAAporteOFA:
                        ft.replace(R.id.containerView, new OfaContributionFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAReservasTicket:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pEntidad = "";
                        U6ucOCBccJ.pProvincia = new Provincia();
                        U6ucOCBccJ.pSucursal = "";
                        U6ucOCBccJ.pSucursalCadeca = new SucursalCadeca();
                        U6ucOCBccJ.ptipoServicio = 0;
                        U6ucOCBccJ.pdata = "";
                        U6ucOCBccJ.pIsEnviar = false;
                        U6ucOCBccJ.pTextoSpMisCuentas = "";
                        U6ucOCBccJ.pcuenta = "";
                        MainBankingTabFragment.this.showDialogReservasTicket();
                        break;
                    case BOLSARecargaTFA:
                        ft.replace(R.id.containerView, new TfaRechargeFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSATransferenciaClasicaEmpresarial:
                        MainBankingTabFragment.this.showDialogTransferenciaEmpresarial();
                        break;
                    case BOLSAPagoExternoClasicaEmpresarial:
                        MainBankingTabFragment.this.showDialogPagoExternoEmpresarial();
                        break;
                    case BOLSACompraMiBoleto:
                        As6QBoLoQJ.ci = "";
                        As6QBoLoQJ.fecha = "";
                        As6QBoLoQJ.fechaInicio = "";
                        As6QBoLoQJ.cantidad = "";
                        As6QBoLoQJ.monto = "";
                        As6QBoLoQJ.phone = "";
                        As6QBoLoQJ.moneda = "";
                        ft.replace(R.id.containerView, new MiBoletoPurchaseFragment())
                                .addToBackStack(null).commit();
                        break;
                    case BOLSAVotoMovil:
                        ft.replace(R.id.containerView, new MobileVotingFragment())
                                .addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(MainBankingTabFragment.this.context, operacion.toString(), Toast.LENGTH_LONG).show();
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
        // Execute ticket offer check task on create
        return this.rootView;
    }

    private void initData() {
        List<OperationItem> items = new ArrayList<>();
        Integer type = OperationItem.TYPE_POST;

        addItem(items, R.string.menu_title_transferencia_bolsa, R.string.menu_sub_transferencia_bolsa, R.drawable.ic_transferencia_bolsa, type, BankOperationCode.BOLSATransferencia);
        addItem(items, R.string.banco_telefono, R.string.banco_sub_telefono, R.drawable.ic_pago_factura_telefono_fijo_bolsa, type, BankOperationCode.BOLSATelefono);
        addItem(items, R.string.menu_title_recarga_movil_bolsa, R.string.menu_sub_recarga_movil_bolsa, R.drawable.ic_recarga_saldo_movil_bolsa, type, BankOperationCode.BOLSARecargaMovil);
        addItem(items, R.string.title_recarga_nauta, R.string.sub_recarga_nauta, R.drawable.ic_pago_nauta_hogar_bolsa, type, BankOperationCode.BOLSARecargaNauta);
        addItem(items, R.string.hint_recarga_propia, R.string.hint_subtitle_recarga_propia, R.drawable.ic_recarga_tarjeta_propia_bolsa, type, BankOperationCode.BOLSARecargaPropia);
        addItem(items, R.string.title_pago_externo, R.string.sub_pago_externo, R.drawable.ic_pago_linea_bolsa, type, BankOperationCode.BOLSAPagoLinea);
        addItem(items, R.string.menu_title_compra_paquete_mlc_bolsa, R.string.menu_sub_compra_paquete_mlc_bolsa, R.drawable.ic_paquetes_combinados_bolsa, type, BankOperationCode.BOLSACompraPaqueteMLC);
        addItem(items, R.string.menu_title_compra_nauta_plus_bolsa, R.string.menu_sub_compra_nauta_plus_bolsa, R.drawable.ic_pago_nauta_plus_bolsa, type, BankOperationCode.BOLSARecargaNautaMLC);
        addItem(items, R.string.menu_tite_recarga_cup_ticket, R.string.menu_sub_recarga_cup_ticket, R.drawable.ic_recargar_monedero_cup_bolsa, type, BankOperationCode.BOLSARecargaCUPWalletTicket);
        addItem(items, R.string.menu_tite_extraccion_efectivo_ticket, R.string.menu_sub_extraccion_efectivo_ticket, R.drawable.ic_extraer_efectivo_bolsa, type, BankOperationCode.BOLSAExtraccionWalletTicket);
        addItem(items, R.string.menu_tite_transferir_bolsa_bancos, R.string.menu_sub_transferir_bolsa_bancos, R.drawable.ic_transferir_cuentas_banco_bolsa, type, BankOperationCode.BOLSATransferirBancos);
        addItem(items, R.string.banco_electricidad, R.string.banco_sub_electricidad, R.drawable.ic_pago_factura_electricidad_bolsa, type, BankOperationCode.BOLSAElectricidad);
        addItem(items, R.string.title_pago_agua_hab, R.string.sub_service_bpa_agua, R.drawable.ic_pago_factura_agua_bolsa, type, BankOperationCode.BOLSAAgua);
        addItem(items, R.string.title_service_metro_gas, R.string.sub_service_metro_gas, R.drawable.ic_pago_factura_gas_bolsa, type, BankOperationCode.BOLSAgas);
        addItem(items, R.string.head_paquetes_cubacel, R.string.sub_compra_paquetes, R.drawable.ic_compra_paquetes_bolsa, type, BankOperationCode.BOLSAPaquetesCubacel);
        addItem(items, R.string.title_organizacion_politica, R.string.subtitle_pcc, R.drawable.ic_pago_organizaciones_masa_bolsa, type, BankOperationCode.BOLSAPCC);
        addItem(items, R.string.title_reservas_ofa, R.string.tx_sub_patrimonio_bolsa, R.drawable.ic_reserva_ofa_bolsa, type, BankOperationCode.BOLSAReservasOFA);
        addItem(items, R.string.title_compra_miboleto, R.string.subtitle_compra_miboleto, R.drawable.ic_miboleto_pago_bolsa, type, BankOperationCode.BOLSACompraMiBoleto);
        addItem(items, R.string.title_reserva_ticket, R.string.subtitle_reserva_ticket, R.drawable.ic_pago_miturno_bolsa, type, BankOperationCode.BOLSAReservasTicket);
        addItem(items, R.string.title_recarga_tfa, R.string.subtitle_recarga_tfa, R.drawable.ic_tfa_bolsa, type, BankOperationCode.BOLSARecargaTFA);
        addItem(items, R.string.tx_head_patrimonio2, R.string.tx_sub_patrimonio, R.drawable.ic_ofa_bolsa, type, BankOperationCode.BOLSAAporteOFA);
        addItem(items, R.string.msg_votomovil_etecsa, R.string.msg_votomovil_descrip_etecsa, R.drawable.ic_voto_movil, type, BankOperationCode.BOLSAVotoMovil);
        addItem(items, R.string.tx_transferencia_clasica_empresa, R.string.ly_title_transferencia_a_clasica_empresa, R.drawable.ico_transfer_clasica, type, BankOperationCode.BOLSATransferenciaClasicaEmpresarial);
        addItem(items, R.string.title_pago_externo_empresarial, R.string.sub_pago_externo_empresarial, R.drawable.ic_pago_linea_empresarial, type, BankOperationCode.BOLSAPagoExternoClasicaEmpresarial);

        OperationListAdapter adapter = new OperationListAdapter(this.context, items);
        this.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this.onItemClickListener);
    }

    private void addItem(List<OperationItem> items, int titleRes, int subtitleRes, int iconRes, Integer type, BankOperationCode op) {
        OperationItem item = new OperationItem();
        item.setTitulo(getString(titleRes));
        item.setSubtitulo(getString(subtitleRes));
        item.setIcono(iconRes);
        item.setType(type);
        item.setOperacion(op);
        items.add(item);
    }

    void showDialogTransferencia() {
        CharSequence[] items = {this.context.getString(R.string.menu_title_transferencia_mi_transfer), this.context.getString(R.string.tx_transferencia_clasica)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.hint_seleccione_cuenta));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 0 → MiTransfer, 1 → Clásica
                FragmentManager fragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                Fragment fragment = i == 0 ? new WalletTransferFragment() : new WalletClassicTransferFragment();
                fragmentManager.beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }

    void showDialogNautaPlus() {
        CharSequence[] items = {this.context.getString(R.string.tx_wallet_nauta_plus_sin_cuenta), this.context.getString(R.string.tx_wallet_nauta_plus_con_cuenta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_modal_head_nauta_plus_bolsa));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                NautaPlusRechargeFragment fragment = new NautaPlusRechargeFragment();
                Bundle args = new Bundle();
                args.putSerializable("OpcionNautaPlus",
                        i == 0 ? AccountType.SIN_CUENTA : AccountType.CON_CUENTA);
                fragment.setArguments(args);
                MainBankingTabFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }

    void showDialog4G() {
        CharSequence[] items = {this.context.getString(R.string.tx_opcion_fwa_recarga), this.context.getString(R.string.tx_opcion_fwa_consulta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Fragment fragment = i == 0
                        ? new FwaBalanceRechargeFragment()
                        : new FwaDataPackagePurchaseFragment();
                MainBankingTabFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }

    void showDialogReservasTicket() {
        CharSequence[] items = {this.context.getString(R.string.opcion_reserva_ticket), this.context.getString(R.string.opcion_eliminar_reserva_ticket), this.context.getString(R.string.opcion_cambiar_fecha_ticket)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Fragment fragment;
                if (i == 0) {
                    fragment = new TicketReservationCreateFragment();
                } else if (i == 1) {
                    fragment = new TicketReservationCancelFragment();
                } else {
                    fragment = new TicketReservationDateChangeFragment();
                }
                MainBankingTabFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }

    void showDialogTransferenciaEmpresarial() {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = "";
                Bundle args = new Bundle();
                args.putSerializable("TransferType", Integer.valueOf(i));
                cu.etecsa.transfermovil.ui.fragment.BfiTransferFragment fragment =
                        new cu.etecsa.transfermovil.ui.fragment.BfiTransferFragment();
                fragment.setArguments(args);
                MainBankingTabFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }

    void showDialogPagoExternoEmpresarial() {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = "";
                Bundle args = new Bundle();
                args.putSerializable("PayType", Integer.valueOf(i));
                args.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICAEMP);
                BfiExternalPaymentFragment fragment = new BfiExternalPaymentFragment();
                fragment.setArguments(args);
                MainBankingTabFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.containerView, fragment)
                        .addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }
}
