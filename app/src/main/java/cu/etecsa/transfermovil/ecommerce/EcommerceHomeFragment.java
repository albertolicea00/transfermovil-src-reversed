package cu.etecsa.transfermovil.ecommerce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/** Inherits the source home behavior and routes its users card to the clean list. */
public class EcommerceHomeFragment extends PVrNBPiBYx {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View view = super.onCreateView(inflater, container, state);
        cdUsers.setOnClickListener(clicked -> {
            UhA7J2923N session = UhA7J2923N.getInstance();
            if (session.checkUserPermission(ThptISKBHA.VER_USUARIOS)
                    || session.checkUserPermission(ThptISKBHA.VER_USERS_HIJOS)) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new ChildUserListFragment())
                        .addToBackStack(null).commit();
            } else {
                Toast.makeText(context, context.getString(R.string.txt_msg_no_permiso), 1).show();
            }
        });
        return view;
    }
}
