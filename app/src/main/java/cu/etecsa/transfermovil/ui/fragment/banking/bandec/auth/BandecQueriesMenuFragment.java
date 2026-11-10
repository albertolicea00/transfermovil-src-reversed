package cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.R7PmVxXLJZC;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecPaymentStatusFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecCardInfoQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecInvoiceQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecPostalOrderQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecLatestOperationsFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecAccountLimitQueryFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecRecentPaymentsFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecAccountStatementFragment;

/**
 * BANDEC Consultas menu with a clean route for external-payment status.
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
}
