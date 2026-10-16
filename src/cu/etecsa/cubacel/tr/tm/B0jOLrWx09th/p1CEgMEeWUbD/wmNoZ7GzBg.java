package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.bnsLemXoui;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.vhcWzIxxMH;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class wmNoZ7GzBg extends Fragment {
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
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.wmNoZ7GzBg.1
            @Override // java.lang.Runnable
            public void run() {
                wmNoZ7GzBg.tabLayout.setupWithViewPager(wmNoZ7GzBg.viewPager);
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
                    return new vhcWzIxxMH();
                case 1:
                    return new ME2IdEhApc();
                case 2:
                    return new dLMLrixv4f();
                case 3:
                    return new bnsLemXoui();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return wmNoZ7GzBg.int_items;
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
                default:
                    return null;
            }
        }
    }
}
