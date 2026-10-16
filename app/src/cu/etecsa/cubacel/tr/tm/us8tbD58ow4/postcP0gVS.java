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
public class postcP0gVS extends Fragment {
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
        int_items = 5;
        View x = inflater.inflate(R.layout.xfa8cmbe43dms, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.us8tbD58ow4.postcP0gVS.1
            @Override // java.lang.Runnable
            public void run() {
                postcP0gVS.tabLayout.setupWithViewPager(postcP0gVS.viewPager);
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
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.Agentes);
                    postcP0gVS.this.estadisticaDetalleFragmentAGENTES.setArguments(b);
                    return postcP0gVS.this.estadisticaDetalleFragmentAGENTES;
                case 1:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoBPA);
                    postcP0gVS.this.estadisticaDetalleFragmentBPA.setArguments(b);
                    return postcP0gVS.this.estadisticaDetalleFragmentBPA;
                case 2:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoBANDEC);
                    postcP0gVS.this.estadisticaDetalleFragmentBANDEC.setArguments(b);
                    return postcP0gVS.this.estadisticaDetalleFragmentBANDEC;
                case 3:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BancoMetro);
                    postcP0gVS.this.estadisticaDetalleFragmentMETRO.setArguments(b);
                    return postcP0gVS.this.estadisticaDetalleFragmentMETRO;
                case 4:
                    b.putSerializable("TipoEstadistica", KYTjPlWScT.BolsaEtecsa);
                    postcP0gVS.this.estadisticaDetalleFragmentWallet.setArguments(b);
                    return postcP0gVS.this.estadisticaDetalleFragmentWallet;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return postcP0gVS.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Agentes";
                case 1:
                    return "BPA";
                case 2:
                    return "BANDEC";
                case 3:
                    return "Metropolitano";
                case 4:
                    return "Monedero MiTransfer";
                default:
                    return null;
            }
        }
    }
}
