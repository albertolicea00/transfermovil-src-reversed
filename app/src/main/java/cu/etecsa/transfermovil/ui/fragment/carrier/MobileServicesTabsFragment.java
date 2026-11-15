package cu.etecsa.transfermovil.ui.fragment.carrier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.R;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.s88cBrrDEaR
 * @original_apk_version 1.260416
 */
public class MobileServicesTabsFragment extends Fragment {
    public static int int_items = 4;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.yeu5v990cnus1, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                MobileServicesTabsFragment.tabLayout.setupWithViewPager(MobileServicesTabsFragment.viewPager);
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
                    return new MobileServicesMenuFragment();
                case 1:
                    return new MobileOperationsMenuFragment();
                case 2:
                    return new EtecsaOffersMenuFragment();
                case 3:
                    return new EmergencyServicesFragment();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MobileServicesTabsFragment.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "LLamadas";
                case 1:
                    return "Operaciones";
                case 2:
                    return "Servicios";
                case 3:
                    return "Útiles";
                default:
                    return null;
            }
        }
    }
}
