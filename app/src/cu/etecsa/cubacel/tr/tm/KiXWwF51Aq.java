package cu.etecsa.cubacel.tr.tm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.D1rOcltDGsD;

/* JADX INFO: loaded from: classes.dex */
public class KiXWwF51Aq extends Fragment {
    public Context context;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ku004pfrbslmu, container, false);
        this.context = container.getContext();
        Button btnGestion = (Button) rootView.findViewById(R.id.btn_gestion);
        btnGestion.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.KiXWwF51Aq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FragmentManager mFragmentManager = KiXWwF51Aq.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new OQcONjDATJ()).addToBackStack(null).commit();
            }
        });
        Button btnEstadisticas = (Button) rootView.findViewById(R.id.btn_estadisticas);
        btnEstadisticas.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.KiXWwF51Aq.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FragmentManager mFragmentManager = KiXWwF51Aq.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new D1rOcltDGsD()).addToBackStack(null).commit();
            }
        });
        return rootView;
    }
}
