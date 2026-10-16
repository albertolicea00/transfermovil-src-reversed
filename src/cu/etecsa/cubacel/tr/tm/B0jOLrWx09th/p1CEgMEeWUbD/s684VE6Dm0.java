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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.Kgii4NH4Ce;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.R7PmVxXLJZC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.bLlRBTTLue;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.rvxiiV3tYu;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class s684VE6Dm0 extends Fragment {
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
                s684VE6Dm0.tabLayout.setupWithViewPager(s684VE6Dm0.viewPager);
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
                    return new rvxiiV3tYu();
                case 1:
                    return new R7PmVxXLJZC();
                case 2:
                    return new bLlRBTTLue();
                case 3:
                    return new Kgii4NH4Ce();
                case 4:
                    return new X7obECfkKf();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return s684VE6Dm0.int_items;
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
