package cu.etecsa.transfermovil.banking.ui.host;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.transfermovil.R;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.Pg7MuGKEAe
 * Single-tab host showing BPA bank logo. Inner content: BpaOperationTabsFragment.
 */
public class BpaTabHostFragment extends Fragment {

    public static int int_items = 1;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.ngtrfxybeehkb, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(() -> {
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setBackgroundColor(getResources().getColor(R.color.bancoBPA));
            try {
                Context ct = getContext();
                TextView tabOne = (TextView) LayoutInflater.from(ct).inflate(R.layout.qk38evge3cdbu, (ViewGroup) null);
                tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_banco_bpa, 0, 0);
                tabLayout.getTabAt(0).setCustomView(tabOne);
            } catch (Exception e) {
            }
        });
        return x;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) { super(fm); }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new BpaOperationTabsFragment();
            return null;
        }

        @Override
        public int getCount() { return int_items; }

        @Override
        public CharSequence getPageTitle(int position) { return null; }
    }
}
