package cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.rvxiiV3tYu;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.transfermovil.ui.fragment.banking.common.AccountSwitchFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.common.AuthenticateFragment;

/**
 * BANDEC session menu with a clean route for active-account switching.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.rvxiiV3tYu
 * @fingerprint Preserves authenticate/disconnect and routes BANAutenticar and BANCambioCuenta to clean source-backed forms.
 */
public class BandecSessionMenuFragment extends rvxiiV3tYu {
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
                if (operation == FdonIAFI9w.BANAutenticar) {
                    FragmentManager manager = BandecSessionMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new AuthenticateFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANCambioCuenta) {
                    FragmentManager manager = BandecSessionMenuFragment.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.containerView, new AccountSwitchFragment()).addToBackStack(null).commit();
                } else {
                    sourceListener.onGetItemClick(view, operation);
                }
            }
        };
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
