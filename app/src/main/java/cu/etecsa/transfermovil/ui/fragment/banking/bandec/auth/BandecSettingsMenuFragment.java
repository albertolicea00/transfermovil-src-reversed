package cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecChangeLimitFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecPinDigitalFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations.BandecCardReprintFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.common.ChangePinFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.common.MultibancaPinChangeFragment;

/**
 * BANDEC Configuración menu with clean routes for reconstructed operations.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf
 * @fingerprint Preserves the nine source menu entries; clean routes cover access-key change, Multibanca PIN, limits, digital PIN, and card reprint.
 */
public class BandecSettingsMenuFragment extends X7obECfkKf {
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
                FragmentManager manager = BandecSettingsMenuFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if (operation == FdonIAFI9w.BANCambiarclave) {
                    transaction.replace(R.id.containerView, new ChangePinFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANCambioPinMultibanca) {
                    transaction.replace(R.id.containerView, new MultibancaPinChangeFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANCambioLimite) {
                    transaction.replace(R.id.containerView, new BandecChangeLimitFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANPinDigital) {
                    transaction.replace(R.id.containerView, new BandecPinDigitalFragment()).addToBackStack(null).commit();
                } else if (operation == FdonIAFI9w.BANReimpresion) {
                    transaction.replace(R.id.containerView, new BandecCardReprintFragment()).addToBackStack(null).commit();
                } else {
                    sourceListener.onGetItemClick(view, operation);
                }
            }
        };
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
