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
import cu.etecsa.transfermovil.stats.OperationItem;
import cu.etecsa.transfermovil.stats.OperationListAdapter;
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
 *   BOLSARecargaMovil → zzyNbaqs1U with CUP currency
 *   BOLSARecargaNauta → KtF0PRB8vS (nauta recharge)
 *   BOLSARecargaPropia → JrjJL8mtlI (own card recharge)
 *   BOLSAPagoLinea → s9CT6pjRyD with OperationType.xf94v3SFEM
 *   BOLSACompraPaqueteMLC → f3Ttlx30sMT (MLC package purchase)
 *   BOLSARecargaNautaMLC → dialog: nauta plus sin/con cuenta
 *   BOLSARecargaFWA → dialog: 4G FWA recharge vs query
 *   BOLSACompraPaqueteFWA → q55ExEc6x2l (FWA package purchase)
 *   BOLSARecargaCUPWalletTicket → P8DtkaSW4dR (CUP wallet ticket recharge)
 *   BOLSAExtraccionWalletTicket → f9Reflqt3EZ (cash extraction from ticket)
 *   BOLSATransferirBancos → H0oV6Ot0bS (transfer to bank accounts)
 *   BOLSAElectricidad → dwdZ5sHcFR (electricity payment)
 *   BOLSAAgua → U1sIOmca96i (water payment)
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
 *   showDialogTransferencia() — MiTransfer vs Clásica → LjOlaYSSMH / l3GXbXAyUW
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
                        // → p5B8KozjvpQ
                        break;
                    case BOLSARecargaMovil:
                        // → zzyNbaqs1U with CUP
                        break;
                    case BOLSARecargaNauta:
                        // → KtF0PRB8vS
                        break;
                    case BOLSARecargaPropia:
                        // → JrjJL8mtlI
                        break;
                    case BOLSAPagoLinea:
                        // → s9CT6pjRyD with xf94v3SFEM
                        break;
                    case BOLSACompraPaqueteMLC:
                        // → f3Ttlx30sMT
                        break;
                    case BOLSARecargaNautaMLC:
                        MainBankingTabFragment.this.showDialogNautaPlus();
                        break;
                    case BOLSARecargaFWA:
                        MainBankingTabFragment.this.showDialog4G();
                        break;
                    case BOLSACompraPaqueteFWA:
                        // → q55ExEc6x2l
                        break;
                    case BOLSARecargaCUPWalletTicket:
                        // → P8DtkaSW4dR
                        break;
                    case BOLSAExtraccionWalletTicket:
                        // → f9Reflqt3EZ
                        break;
                    case BOLSATransferirBancos:
                        // → H0oV6Ot0bS
                        break;
                    case BOLSAElectricidad:
                        // → dwdZ5sHcFR
                        break;
                    case BOLSAAgua:
                        // → U1sIOmca96i
                        break;
                    case BOLSAgas:
                        // → XCDkgbw8oZ
                        break;
                    case BOLSAPaquetesCubacel:
                        // → WyYHxgzYyW
                        break;
                    case BOLSAPCC:
                        // → xb7DiohJuX
                        break;
                    case BOLSAReservasOFA:
                        // → dWLcK5oQoS
                        break;
                    case BOLSAAporteOFA:
                        // → C6ZYln3x19W
                        break;
                    case BOLSAReservasTicket:
                        MainBankingTabFragment.this.showDialogReservasTicket();
                        break;
                    case BOLSARecargaTFA:
                        // → b7zSZMAX7cN
                        break;
                    case BOLSATransferenciaClasicaEmpresarial:
                        MainBankingTabFragment.this.showDialogTransferenciaEmpresarial();
                        break;
                    case BOLSAPagoExternoClasicaEmpresarial:
                        MainBankingTabFragment.this.showDialogPagoExternoEmpresarial();
                        break;
                    case BOLSACompraMiBoleto:
                        // → TBaFnBLjEA with reset state
                        break;
                    case BOLSAVotoMovil:
                        // → cdINOtQ3iN
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
                // 0 → LjOlaYSSMH (MiTransfer), 1 → l3GXbXAyUW (Clásica)
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
                // → HZgbT8IXPf with AccountType SIN_CUENTA/CON_CUENTA
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
                // 0 → wbFn8tBw8W (FWA recharge), 1 → q55ExEc6x2l (FWA query)
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
                // 0 → XnVSHGPTkK, 1 → QVPgkl8ZGC, 2 → Wwc5crW71D
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
                // → Z3kYdPwq6K2 with TransferType i
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
                // → Eqj43O0pUx with PayType i, BankType CLASICAEMP
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", null);
        builder.create().show();
    }
}
