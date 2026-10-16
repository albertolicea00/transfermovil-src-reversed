package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.aQdU5kg0yGq.BktkqFBOIQ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.xLm6Wjf6gEf.s9lZwtvq9Dl;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class s88cBrrDEaR extends Fragment {
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
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.s88cBrrDEaR.1
            @Override // java.lang.Runnable
            public void run() {
                s88cBrrDEaR.tabLayout.setupWithViewPager(s88cBrrDEaR.viewPager);
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
                    return new FNRzUmC7E5();
                case 1:
                    return new LALCrDPvhM();
                case 2:
                    return new BktkqFBOIQ();
                case 3:
                    return new s9lZwtvq9Dl();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return s88cBrrDEaR.int_items;
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
