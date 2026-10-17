package cu.etecsa.transfermovil.banking.ui.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.transfermovil.R;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.s684VE6Dm0
 * 5-tab pager for BANDEC: Sesión, Consultas, Operaciones, Servicios contratados, Configuración.
 * Child fragments from OfZgAbz2cY8.TJzyszIDKqc subpackage + Kgii4NH4Ce.
 */
public class BandecOperationTabsFragment extends Fragment {

    public static int int_items = 5;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.g4ybhpqvlytaoa, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(() -> tabLayout.setupWithViewPager(viewPager));
        return x;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) { super(fm); }

        @Override
        public Fragment getItem(int position) {
            // OfZgAbz2cY8 subpackage fragments:
            // 0: rvxiiV3tYu (Sesión), 1: R7PmVxXLJZC (Consultas),
            // 2: bLlRBTTLue (Operaciones), 3: Kgii4NH4Ce (Servicios contratados),
            // 4: X7obECfkKf (Configuración)
            return null; // stub
        }

        @Override
        public int getCount() { return int_items; }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Sesión";
                case 1: return "Consultas";
                case 2: return "Operaciones";
                case 3: return "Servicios contratados";
                case 4: return "Configuración";
                default: return null;
            }
        }
    }
}
