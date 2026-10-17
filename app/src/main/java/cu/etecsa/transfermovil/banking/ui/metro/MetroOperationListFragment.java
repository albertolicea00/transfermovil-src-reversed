package cu.etecsa.transfermovil.banking.ui.metro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9
 * @fingerprint 496L. Metropolitano bank operation list hub. RecyclerView with sticky headers.
 *              Routes all METRO BankOperationCode values to sub-fragments.
 *              Operations: auth, balance, transfer, phone, electric, water, gas, tax,
 *              recharge, nauta, limit, accounts, pin, giro, external pay, reprint, credit,
 *              locate transfer, associate account, disconnect, delete registration.
 */
public class MetroOperationListFragment extends Fragment {
    public Context context;
    public View rootView;
}
