package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.os.Build;
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
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.Fr52O1uSYF;

/* JADX INFO: loaded from: classes.dex */
public class wTZi6Zeikv extends Fragment {
    public static int int_items;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public T9G0CnOGgQR clientesFragment = new T9G0CnOGgQR();
    public h8J8MJBhFbo tarjetasFragment = new h8J8MJBhFbo();
    public ENqS9qPLC9 movilesFragment = new ENqS9qPLC9();
    public e0KJzgOJUI fijosFragment = new e0KJzgOJUI();
    public YhCZLEFD5F nautasFragment = new YhCZLEFD5F();
    public u4cIRj4DZJT facturasFragments = new u4cIRj4DZJT();
    public OxDrWxtsSZ cuentasFragment = new OxDrWxtsSZ();
    public oxnWCqh7QM serviciosPublicosFragments = new oxnWCqh7QM();
    public MmUcSVNG36 propiasFragment = new MmUcSVNG36();
    public q91TRW0mM2y nautaBancoFragment = new q91TRW0mM2y();
    public JntDz3d2vV ticketsFragment = new JntDz3d2vV();
    public x5ijzOU4VE miBoletoFragments = new x5ijzOU4VE();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 23 && getContext().checkSelfPermission("android.permission.READ_CONTACTS") == -1) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
        }
        new Fr52O1uSYF();
        int_items = 8;
        View x = inflater.inflate(R.layout.uwsf4ji3yumwn, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        tabLayout.setTabGravity(1);
        tabLayout.setTabMode(0);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.wTZi6Zeikv.1
            @Override // java.lang.Runnable
            public void run() {
                wTZi6Zeikv.tabLayout.setupWithViewPager(wTZi6Zeikv.viewPager);
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
                    return wTZi6Zeikv.this.clientesFragment;
                case 1:
                    return wTZi6Zeikv.this.facturasFragments;
                case 2:
                    return wTZi6Zeikv.this.cuentasFragment;
                case 3:
                    return wTZi6Zeikv.this.propiasFragment;
                case 4:
                    return wTZi6Zeikv.this.serviciosPublicosFragments;
                case 5:
                    return wTZi6Zeikv.this.nautaBancoFragment;
                case 6:
                    return wTZi6Zeikv.this.ticketsFragment;
                case 7:
                    return wTZi6Zeikv.this.miBoletoFragments;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return wTZi6Zeikv.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Propietario";
                case 1:
                    return "Facturas";
                case 2:
                    return wTZi6Zeikv.this.getActivity().getString(R.string.title_servicios_cuenta);
                case 3:
                    return "PROPIA";
                case 4:
                    return wTZi6Zeikv.this.getActivity().getString(R.string.title_servicios_publicos);
                case 5:
                    return wTZi6Zeikv.this.getActivity().getString(R.string.title_nauta_banco);
                case 6:
                    return wTZi6Zeikv.this.getActivity().getString(R.string.title_combustible);
                case 7:
                    return wTZi6Zeikv.this.getActivity().getString(R.string.title_miBoleto);
                default:
                    return null;
            }
        }
    }
}
