package cu.etecsa.cubacel.tr.tm.us8tbD58ow4;

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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;

/* JADX INFO: loaded from: classes.dex */
public class LxRjrwTADB extends Fragment {
    public static int int_items;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public D1rOcltDGsD estadisticaDetalleFragmentAGENTES = new D1rOcltDGsD();
    public D1rOcltDGsD estadisticaDetalleFragmentBPA = new D1rOcltDGsD();
    public D1rOcltDGsD estadisticaDetalleFragmentBANDEC = new D1rOcltDGsD();
    public D1rOcltDGsD estadisticaDetalleFragmentMETRO = new D1rOcltDGsD();
    public D1rOcltDGsD estadisticaDetalleFragmentWallet = new D1rOcltDGsD();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int_items = 4;
        View x = inflater.inflate(R.layout.xfa8cmbe43dms, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.us8tbD58ow4.LxRjrwTADB.1
            @Override // java.lang.Runnable
            public void run() {
                LxRjrwTADB.tabLayout.setupWithViewPager(LxRjrwTADB.viewPager);
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
            Bundle b = new Bundle();
            switch (position) {
                case 0:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoBPA);
                    LxRjrwTADB.this.estadisticaDetalleFragmentBPA.setArguments(b);
                    return LxRjrwTADB.this.estadisticaDetalleFragmentBPA;
                case 1:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoBANDEC);
                    LxRjrwTADB.this.estadisticaDetalleFragmentBANDEC.setArguments(b);
                    return LxRjrwTADB.this.estadisticaDetalleFragmentBANDEC;
                case 2:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoMetro);
                    LxRjrwTADB.this.estadisticaDetalleFragmentMETRO.setArguments(b);
                    return LxRjrwTADB.this.estadisticaDetalleFragmentMETRO;
                case 3:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BolsaEtecsa);
                    LxRjrwTADB.this.estadisticaDetalleFragmentWallet.setArguments(b);
                    return LxRjrwTADB.this.estadisticaDetalleFragmentWallet;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LxRjrwTADB.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BPA";
                case 1:
                    return "BANDEC";
                case 2:
                    return "Metropolitano";
                case 3:
                    return "Monedero MiTransfer";
                default:
                    return null;
            }
        }
    }
}
