package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD;

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
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class z5XKGtUeX8 extends Fragment {
    public static int int_items = 1;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.ngtrfxybeehkb, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.z5XKGtUeX8.1
            @Override // java.lang.Runnable
            public void run() {
                z5XKGtUeX8.tabLayout.setupWithViewPager(z5XKGtUeX8.viewPager);
                z5XKGtUeX8.tabLayout.setBackgroundColor(z5XKGtUeX8.this.getResources().getColor(R.color.bancoBandec));
                Context ct = z5XKGtUeX8.this.getContext();
                try {
                    TextView tabOne = (TextView) LayoutInflater.from(ct).inflate(R.layout.qk38evge3cdbu, (ViewGroup) null);
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_banco_bandec, 0, 0);
                    z5XKGtUeX8.tabLayout.getTabAt(0).setCustomView(tabOne);
                } catch (Exception e) {
                }
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
                    return new s684VE6Dm0();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return z5XKGtUeX8.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
