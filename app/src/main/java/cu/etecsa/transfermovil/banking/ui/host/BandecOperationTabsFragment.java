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
import cu.etecsa.transfermovil.ui.fragment.banking.common.BandecMenuFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth.BandecOperationRouterFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth.BandecQueriesMenuFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth.BandecSettingsMenuFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.auth.BandecSessionMenuFragment;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.s684VE6Dm0 */
public class BandecOperationTabsFragment extends Fragment {
    public static int int_items = 5;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.g4ybhpqvlytaoa, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.s684VE6Dm0.1
            @Override // java.lang.Runnable
            public void run() {
                BandecOperationTabsFragment.tabLayout.setupWithViewPager(BandecOperationTabsFragment.viewPager);
            }
        });
        return x;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new BandecSessionMenuFragment();
                case 1:
                    return new BandecQueriesMenuFragment();
                case 2:
                    return new BandecOperationRouterFragment();
                case 3:
                    return new BandecMenuFragment();
                case 4:
                    return new BandecSettingsMenuFragment();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return BandecOperationTabsFragment.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Sesión";
                case 1:
                    return "Consultas";
                case 2:
                    return "Operaciones";
                case 3:
                    return "Servicios contratados";
                case 4:
                    return "Configuración";
                default:
                    return null;
            }
        }
    }
}
