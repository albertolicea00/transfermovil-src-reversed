package cu.etecsa.transfermovil.banking.ui.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cu.etecsa.transfermovil.banking.ui.tabs.BfiConsultationsMenuFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.BfiOperationsMenuFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.BfiSessionMenuFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.BfiSecurityMenuFragment;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.RTIOw2NwU7 */
public class BfiOperationTabsFragment extends Fragment {
    public static int int_items = 4;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.g4ybhpqvlytaoa, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.RTIOw2NwU7.1
            @Override // java.lang.Runnable
            public void run() {
                BfiOperationTabsFragment.tabLayout.setupWithViewPager(BfiOperationTabsFragment.viewPager);
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
                    return new BfiSessionMenuFragment();
                case 1:
                    return new BfiConsultationsMenuFragment();
                case 2:
                    return new BfiOperationsMenuFragment();
                case 3:
                    return new BfiSecurityMenuFragment();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return BfiOperationTabsFragment.int_items;
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
                    return "Configuración";
                case 4:
                    return "Empresa";
                default:
                    return null;
            }
        }
    }
}
