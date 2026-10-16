package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.H0kVHR7zuu;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.N9YZcaVn8GC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.hOQ4ESKEhm;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.rR6oImkdEU;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class gCD4Z8F6ml extends Fragment {
    public static int int_items = 5;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.kfu18xntaf1jz, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.gCD4Z8F6ml.1
            @Override // java.lang.Runnable
            public void run() {
                gCD4Z8F6ml.tabLayout.setupWithViewPager(gCD4Z8F6ml.viewPager);
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
                    return new H0kVHR7zuu();
                case 1:
                    return new UMVR3qrc3V();
                case 2:
                    return new rR6oImkdEU();
                case 3:
                    return new hOQ4ESKEhm();
                case 4:
                    return new N9YZcaVn8GC();
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return gCD4Z8F6ml.int_items;
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
                    return "Agente";
                default:
                    return null;
            }
        }
    }
}
