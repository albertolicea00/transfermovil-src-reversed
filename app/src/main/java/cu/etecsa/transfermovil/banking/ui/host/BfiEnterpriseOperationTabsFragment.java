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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.wmNoZ7GzBg
 * 4-tab pager for BFI enterprise: Sesión, Consultas, Operaciones, Configuración.
 * Child fragments from P2MO7cFkntPD.SXVyD7BX7KJ subpackage.
 * Differs from BfiOperationTabsFragment in Operaciones tab (uses dLMLrixv4f instead of opFvbCxlRn).
 */
public class BfiEnterpriseOperationTabsFragment extends Fragment {

    public static int int_items = 4;
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
            // P2MO7cFkntPD.SXVyD7BX7KJ subpackage fragments:
            // 0: vhcWzIxxMH (Sesión), 1: ME2IdEhApc (Consultas),
            // 2: dLMLrixv4f (Operaciones — enterprise variant), 3: bnsLemXoui (Configuración)
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
                case 3: return "Configuración";
                default: return null;
            }
        }
    }
}
