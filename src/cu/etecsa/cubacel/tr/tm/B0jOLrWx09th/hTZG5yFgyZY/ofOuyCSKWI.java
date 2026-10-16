package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY;

import android.content.ContentResolver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.H0kVHR7zuu;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.hOQ4ESKEhm;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.rR6oImkdEU;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.HzjedYqYeh;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.g0xM9kQCsqu;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rIgmgP6JXL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ofOuyCSKWI extends Fragment {
    public static int int_items = 4;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.kfu18xntaf1jz, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        try {
            ContentResolver cs = container.getContext().getContentResolver();
            HzjedYqYeh sms_center = new HzjedYqYeh();
            ArrayList<rIgmgP6JXL> sms = sms_center.readSmsInbox(cs);
            List<TMonedasWallet> lisMonedas = unYp8VQThY.getInstance().getMonedasWallet();
            if (lisMonedas != null && lisMonedas.size() > 0 && sms != null) {
                g0xM9kQCsqu parseSMS = new g0xM9kQCsqu();
                for (int i = 0; i < sms.size(); i++) {
                    if (sms.get(i).getBody().contains("La actualizacion de las cuentas virtuales fue completada.") && sms.get(i).getDate().after(lisMonedas.get(0).getFecha())) {
                        parseSMS.parseMonedasWallet(sms.get(i).getBody());
                    }
                }
            }
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
        }
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.ofOuyCSKWI.1
            @Override // java.lang.Runnable
            public void run() {
                ofOuyCSKWI.tabLayout.setupWithViewPager(ofOuyCSKWI.viewPager);
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
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ofOuyCSKWI.int_items;
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
