package cu.etecsa.transfermovil.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.D1rOcltDGsD;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.KiXWwF51Aq
 * @fingerprint E-commerce menu fragment with two buttons: "Gestión" (management)
 *              and "Estadísticas" (statistics). Navigates to OQcONjDATJ (management fragment)
 *              or D1rOcltDGsD (statistics fragment).
 *
 * Dependencies:
 *   - OQcONjDATJ → EcommerceManagementFragment (c69cvBqjXKw package)
 *   - D1rOcltDGsD → EcommerceStatisticsFragment (us8tbD58ow4 package)
 */
public class EcommerceMenuFragment extends Fragment {
    public Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ku004pfrbslmu, container, false);
        this.context = container.getContext();
        Button btnGestion = (Button) rootView.findViewById(R.id.btn_gestion);
        btnGestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerView, new OQcONjDATJ()).addToBackStack(null).commit();
            }
        });
        Button btnEstadisticas = (Button) rootView.findViewById(R.id.btn_estadisticas);
        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.containerView, new D1rOcltDGsD()).addToBackStack(null).commit();
            }
        });
        return rootView;
    }
}
