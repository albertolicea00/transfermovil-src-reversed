package cu.etecsa.transfermovil.banking.ui.bpa;

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

import java.util.ArrayList;
import java.util.List;

/**
 * BPA account management sub-menu fragment.
 *
 * <p>Presents a RecyclerView list of account-related operations for the BPA bank:
 * registration, change PIN, delete registration, change limits, associate accounts,
 * digital PIN generation, card reprint, lost PIN recovery, fiscal account opening,
 * and MLC (USD-backed) account opening.</p>
 *
 * <p>Each menu item routes to the corresponding operation fragment or shows a
 * confirmation dialog that dispatches a USSD code.</p>
 *
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx
 * @original_apk_version 1.260416
 */
public class BpaAccountMenuFragment extends Fragment {

    private Context context;
    private View rootView;
    private RecyclerView recyclerView;

    /**
     * Click listener that routes each BankOperationCode to the appropriate
     * fragment or confirmation dialog.
     *
     * Switch mapping (from AnonymousClass18 initializer):
     * <pre>
     *   1 → BPARegistrarse      → IixhA1yamp (BpaRegistrationFragment)
     *   2 → BPACambiarclave      → PQmKwgxZd1 (BpaChangePinFragment)
     *   3 → BPAEliminarRegistro  → showDialogEliminarRegistro() → USSD "68*01"
     *   4 → BPACambioLimite      → qmcwKV1fzU (r1lhlGiU6g65 subpackage)
     *   5 → BPAAsociarCuenta     → Ittht2aX4N (BpaAssociateAccountFragment)
     *   6 → BPAPinDigital        → uLySWsCVTv (r1lhlGiU6g65 subpackage)
     *   7 → BPARenovarTarj       → kWnV7nzNWl (r1lhlGiU6g65 subpackage)
     *   8 → BPARecuperarTarj     → Yhi9DhKkMz (r1lhlGiU6g65 subpackage)
     *   9 → BPAConvertirCuenta   → ZZ6L6QderZ (r1lhlGiU6g65 subpackage)
     *  10 → BPAImprimirMLC       → T7bvG7kpeae (r1lhlGiU6g65 subpackage)
     *  11 → BPACuentaFiscal      → EyKrF4UJ9B (FiscalAccountFragment, with BankType.BPA arg)
     * </pre>
     */
    private final OperationMenuAdapter.OnItemClickListener onItemClickListener =
            new OperationMenuAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    // Not used; routing is by operation code
                }

                @Override
                public void onGetItemClick(View view, BankOperationCode operacion) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    switch (operacion) {
                        case BPARegistrarse:
                            ft.replace(R.id.containerView, new BpaRegistrationFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPACambiarclave:
                            ft.replace(R.id.containerView, new BpaChangePinFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPAEliminarRegistro:
                            showDialogEliminarRegistro();
                            break;
                        case BPACambioLimite:
                            ft.replace(R.id.containerView, new BpaChangeLimitFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPAAsociarCuenta:
                            ft.replace(R.id.containerView, new BpaAssociateAccountFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPAPinDigital:
                            ft.replace(R.id.containerView, new BpaDigitalPinFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPARenovarTarj:
                            ft.replace(R.id.containerView, new BpaReprintCardFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPARecuperarTarj:
                            ft.replace(R.id.containerView, new BpaLostPinFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPAConvertirCuenta:
                            ft.replace(R.id.containerView, new BpaConvertAccountFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPAImprimirMLC:
                            ft.replace(R.id.containerView, new BpaOpenMlcAccountFragment())
                                    .addToBackStack(null).commit();
                            break;
                        case BPACuentaFiscal:
                            Bundle arg = new Bundle();
                            arg.putSerializable("R1sDOSqZ2z", BankType.BPA);
                            FiscalAccountFragment fiscalFragment = new FiscalAccountFragment();
                            fiscalFragment.setArguments(arg);
                            ft.replace(R.id.containerView, fiscalFragment)
                                    .addToBackStack(null).commit();
                            break;
                        default:
                            Toast.makeText(context, "Error! " + operacion, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_operations_list, container, false);
        context = container.getContext();
        recyclerView = rootView.findViewById(R.id.drawerList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        initData();
        return rootView;
    }

    /**
     * Populates the menu with 10 account management operations.
     *
     * <p>All items use {@code rBXnNc0Kx4.Post} as their type (POST request type).</p>
     */
    private void initData() {
        List<OperationMenuItem> items = new ArrayList<>();

        OperationMenuItem registro = new OperationMenuItem();
        registro.setTitle("Registrarse");
        registro.setSubtitle("Registrarse en el sistema");
        registro.setIcon(R.drawable.ic_registrarse_bpa);
        registro.setType(OperationMenuItem.TYPE_POST);
        registro.setOperationCode(BankOperationCode.BPARegistrarse);
        items.add(registro);

        OperationMenuItem changePass = new OperationMenuItem();
        changePass.setTitle("Cambiar Clave");
        changePass.setSubtitle("Cambiar la clave de acceso");
        changePass.setIcon(R.drawable.ic_cambio_pin_bpa);
        changePass.setType(OperationMenuItem.TYPE_POST);
        changePass.setOperationCode(BankOperationCode.BPACambiarclave);
        items.add(changePass);

        OperationMenuItem delRegistro = new OperationMenuItem();
        delRegistro.setTitle("Eliminar Registro");
        delRegistro.setSubtitle("Eliminar registro asociado a su cuenta");
        delRegistro.setIcon(R.drawable.ic_eliminar_registro_bpa);
        delRegistro.setType(OperationMenuItem.TYPE_POST);
        delRegistro.setOperationCode(BankOperationCode.BPAEliminarRegistro);
        items.add(delRegistro);

        OperationMenuItem cambioLimite = new OperationMenuItem();
        cambioLimite.setTitle("Cambio de Limite");
        cambioLimite.setSubtitle("Cambio de limites de las cuentas bancarias");
        cambioLimite.setIcon(R.drawable.ic_cambio_limites_bpa);
        cambioLimite.setType(OperationMenuItem.TYPE_POST);
        cambioLimite.setOperationCode(BankOperationCode.BPACambioLimite);
        items.add(cambioLimite);

        OperationMenuItem asociarCuenta = new OperationMenuItem();
        asociarCuenta.setTitle("Asociar Cuentas");
        asociarCuenta.setSubtitle("Vincular otra cuenta bancaria");
        asociarCuenta.setIcon(R.drawable.ic_asociar_cuenta_bpa);
        asociarCuenta.setType(OperationMenuItem.TYPE_POST);
        asociarCuenta.setOperationCode(BankOperationCode.BPAAsociarCuenta);
        items.add(asociarCuenta);

        OperationMenuItem pinDigital = new OperationMenuItem();
        pinDigital.setTitle("PIN no Impreso");
        pinDigital.setSubtitle("Generar Codigo PIN");
        pinDigital.setIcon(R.drawable.ic_generar_pin_bpa);
        pinDigital.setType(OperationMenuItem.TYPE_POST);
        pinDigital.setOperationCode(BankOperationCode.BPAPinDigital);
        items.add(pinDigital);

        OperationMenuItem reimprimir = new OperationMenuItem();
        reimprimir.setTitle("Reimprimir Tarjeta");
        reimprimir.setSubtitle("Renovar tarjeta");
        reimprimir.setIcon(R.drawable.ic_reimprimir_tarjeta_bpa);
        reimprimir.setType(OperationMenuItem.TYPE_POST);
        reimprimir.setOperationCode(BankOperationCode.BPARenovarTarj);
        items.add(reimprimir);

        OperationMenuItem recuperar = new OperationMenuItem();
        recuperar.setTitle("Perdida de PIN");
        recuperar.setSubtitle("Perdida PIN de tarjeta magnetica");
        recuperar.setIcon(R.drawable.ic_perdida_pin_bpa);
        recuperar.setType(OperationMenuItem.TYPE_POST);
        recuperar.setOperationCode(BankOperationCode.BPARecuperarTarj);
        items.add(recuperar);

        OperationMenuItem cuentaFiscal = new OperationMenuItem();
        cuentaFiscal.setTitle(getString(R.string.head_cuenta_fiscal));
        cuentaFiscal.setSubtitle(getString(R.string.subtitle_cuenta_fiscal));
        cuentaFiscal.setIcon(R.drawable.ic_apertura_cuenta_fiscal_bpa);
        cuentaFiscal.setType(OperationMenuItem.TYPE_POST);
        cuentaFiscal.setOperationCode(BankOperationCode.BPACuentaFiscal);
        items.add(cuentaFiscal);

        OperationMenuItem mlc = new OperationMenuItem();
        mlc.setTitle("Apertura de Cuenta");
        mlc.setSubtitle("Apertura de Cuenta en USD con respaldo en MLC");
        mlc.setIcon(R.drawable.ic_apertura_cuenta_bpa);
        mlc.setType(OperationMenuItem.TYPE_POST);
        mlc.setOperationCode(BankOperationCode.BPAImprimirMLC);
        items.add(mlc);

        OperationMenuAdapter adapter = new OperationMenuAdapter(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
    }

    /**
     * Shows confirmation dialog for closing the bank session.
     * Sends USSD code "70" to disconnect.
     * Also calls {@code UssdDispatcher.closeSessionBank()} before showing dialog.
     */
    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage(context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("70");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        UssdDispatcher.closeSessionBank(getActivity());
        builder.create().show();
    }

    /**
     * Shows confirmation dialog for balance query.
     * Sends USSD code "46" to query card balance.
     */
    private void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("Desea consultar el saldo de su tarjeta? ");
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("46");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows confirmation dialog for pending credits query.
     * Sends USSD code "72" to check pending credits.
     */
    private void showDialogConsultaCredito() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("Desea ver los creditos pendientes? ");
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("72");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows confirmation dialog for deleting the user's bank registration.
     * Sends USSD code "68*01" to remove registration associated with the account
     * and phone number.
     */
    private void showDialogEliminarRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("Desea eliminar registro asociado a su cuenta y numero telefonico?.  ");
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("68*01");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows a currency selection dialog (CUP/CUC) for querying account limits.
     * Sends USSD code "62" with currency parameter "1" (CUP) or "2" (CUC).
     */
    private void showDialogConsultarLimites() {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Para consultar los limites de sus cuentas bancarias debe seleccionar el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, (dialogInterface, i) -> {
            if (i == 0) {
                dispatchUssd("62", "1");
            } else {
                dispatchUssd("62", "2");
            }
        });
        builder.setNegativeButton("Cerrar", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows a currency selection dialog (CUP/CUC) for a given USSD operation code.
     * Appends currency parameter "1" or "2" to the operation code.
     *
     * @param operationCode the USSD operation code to dispatch
     */
    private void showDialogTipoMoneda(final String operationCode) {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, (dialogInterface, i) -> {
            if (i == 0) {
                dispatchUssd(operationCode, "1");
            } else {
                dispatchUssd(operationCode, "2");
            }
        });
        builder.setNegativeButton("Salir", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows a currency selection dialog for "last operations" queries.
     * Prepends "00*" to the currency parameter before dispatching.
     *
     * @param operationCode the base USSD operation code
     */
    private void showDialogUltimosTipoMoneda(final String operationCode) {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, (dialogInterface, i) -> {
            if (i == 0) {
                dispatchUssd(operationCode, "00*1");
            } else {
                dispatchUssd(operationCode, "00*2");
            }
        });
        builder.setNegativeButton("Salir", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Shows confirmation dialog for querying all account balances.
     * Sends USSD code "58".
     */
    private void showDialogTodasCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("Desea consultar el importe de todas sus cuentas? ");
        builder.setPositiveButton("Si", (dialog, id) -> {
            dispatchUssd("58");
        });
        builder.setNegativeButton("No", (dialog, id) -> { /* dismissed */ });
        builder.create().show();
    }

    /**
     * Dispatches a USSD code through the appropriate activity interface.
     * Checks whether the current agent code contains "-1" to decide
     * between legacy (S9ycHcoxAzy) and new (IHVTCBmiLV) activity cast.
     *
     * @param code the USSD operation code
     */
    private void dispatchUssd(String code) {
        BaseMainActivity bs = new BaseMainActivity();
        if (bs.getCodeAgent() != null && !bs.getCodeAgent().getCode().contains("-1")) {
            ((BankingActivity) getActivity()).actionCallUSSD(code);
        } else {
            ((MainBankingActivity) getActivity()).actionCallUSSD(code);
        }
    }

    /**
     * Dispatches a USSD code with an additional parameter.
     *
     * @param code  the USSD operation code
     * @param param additional parameter (e.g., currency selection)
     */
    private void dispatchUssd(String code, String param) {
        BaseMainActivity bs = new BaseMainActivity();
        if (bs.getCodeAgent() != null && !bs.getCodeAgent().getCode().contains("-1")) {
            ((BankingActivity) getActivity()).actionCallUSSD(code, param);
        } else {
            ((MainBankingActivity) getActivity()).actionCallUSSD(code, param);
        }
    }
}
