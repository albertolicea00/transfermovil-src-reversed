package cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.R7PmVxXLJZC;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecPaymentStatusFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecCardInfoQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecInvoiceQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecPostalOrderQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecLatestOperationsFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecAccountLimitQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecRecentPaymentsFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecAccountStatementFragment;

/**
 * BANDEC Consultas menu with clean routes for source-backed query forms.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.R7PmVxXLJZC
 * @fingerprint Preserves fourteen visible consultation rows and source destinations.
 */
public class BandecQueriesMenuFragment extends R7PmVxXLJZC {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final vD9rc3MbTL.OnItemClickListener sourceListener = super.onItemClickListener;
        super.onItemClickListener = new vD9rc3MbTL.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                sourceListener.onItemClick(view, position);
            }

            @Override
            public void onGetItemClick(View view, FdonIAFI9w operation) {
                if (operation == FdonIAFI9w.BANEstadoCuentas) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecAccountStatementFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANConsultarTodasCuentas) {
                    showAllAccountsConfirmation();
                } else if (operation == FdonIAFI9w.BANConsultaMulta) {
                    showFineQueryTypeDialog();
                } else if (operation == FdonIAFI9w.BANUltimasoperaciones) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecLatestOperationsFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANConsultaLimite) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecAccountLimitQueryFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANUltimosPagos) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecRecentPaymentsFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANConsultarGiroPostal) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecPostalOrderQueryFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANConsultarServicio) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecInvoiceQueryFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANInfoTarjeta) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecCardInfoQueryFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANEstadoPagoExterno) {
                    FragmentManager manager = BandecQueriesMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new BandecPaymentStatusFragment()).addToBackStack(null).commit();
                } else {
                    sourceListener.onGetItemClick(view, operation);
                }
            }
        };
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void showAllAccountsConfirmation() {
        new AlertDialog.Builder(getContext())
                .setTitle("Seleccione")
                .setMessage("¿Desea consultar el importe de todas sus cuentas? ")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rDEl7rW1aN bankingSession = new rDEl7rW1aN();
                        if (bankingSession.getCodeAgent() != null
                                && !bankingSession.getCodeAgent().getCode().contains("-1")) {
                            ((IHVTCBmiLV) getActivity()).actionCallUSSD("58");
                        } else {
                            ((S9ycHcoxAzy) getActivity()).actionCallUSSD("58");
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void showFineQueryTypeDialog() {
        final String[] fineTypes = {"Multa de contravención", "Multa de tránsito"};
        new AlertDialog.Builder(getContext())
                .setTitle(getString(R.string.alert_msg_conulta_tipo))
                .setSingleChoiceItems(fineTypes, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BandecFineQueryFragment.TipoMulta fineType = which == 0
                                ? BandecFineQueryFragment.TipoMulta.Contravension
                                : BandecFineQueryFragment.TipoMulta.Transito;
                        FragmentManager manager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.containerView, BandecFineQueryFragment.newInstance(fineType))
                                .addToBackStack(null).commit();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
