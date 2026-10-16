package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

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

/* JADX INFO: loaded from: classes.dex */
public class OQcONjDATJ extends Fragment {
    public static int int_items;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public T9G0CnOGgQR clientesFragment = new T9G0CnOGgQR();
    public h8J8MJBhFbo tarjetasFragment = new h8J8MJBhFbo();
    public ENqS9qPLC9 movilesFragment = new ENqS9qPLC9();
    public e0KJzgOJUI fijosFragment = new e0KJzgOJUI();
    public YhCZLEFD5F nautasFragment = new YhCZLEFD5F();
    public u4cIRj4DZJT facturasFragments = new u4cIRj4DZJT();
    public oxnWCqh7QM serviciosPublicosFragments = new oxnWCqh7QM();
    public OxDrWxtsSZ cuentasFragment = new OxDrWxtsSZ();
    public MmUcSVNG36 propiasFragment = new MmUcSVNG36();
    public q91TRW0mM2y nautasBancoFragments = new q91TRW0mM2y();
    public JntDz3d2vV ticketsFragment = new JntDz3d2vV();
    public x5ijzOU4VE miBoletoFragments = new x5ijzOU4VE();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int_items = 11;
        View x = inflater.inflate(R.layout.uwsf4ji3yumwn, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ.1
            @Override // java.lang.Runnable
            public void run() {
                OQcONjDATJ.tabLayout.setupWithViewPager(OQcONjDATJ.viewPager);
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
                    return OQcONjDATJ.this.clientesFragment;
                case 1:
                    return OQcONjDATJ.this.fijosFragment;
                case 2:
                    return OQcONjDATJ.this.movilesFragment;
                case 3:
                    return OQcONjDATJ.this.nautasFragment;
                case 4:
                    return OQcONjDATJ.this.facturasFragments;
                case 5:
                    return OQcONjDATJ.this.cuentasFragment;
                case 6:
                    return OQcONjDATJ.this.propiasFragment;
                case 7:
                    return OQcONjDATJ.this.serviciosPublicosFragments;
                case 8:
                    return OQcONjDATJ.this.nautasBancoFragments;
                case 9:
                    return OQcONjDATJ.this.ticketsFragment;
                case 10:
                    return OQcONjDATJ.this.miBoletoFragments;
                default:
                    return null;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return OQcONjDATJ.int_items;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            try {
                switch (position) {
                    case 0:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_gestion_cliente);
                    case 1:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_gestion_fijo);
                    case 2:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_gestion_moviles);
                    case 3:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_gestion_nauta);
                    case 4:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_gestion_facturas);
                    case 5:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_servicios_cuenta);
                    case 6:
                        return "Propia";
                    case 7:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_servicios_publicos);
                    case 8:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_nauta_banco_extendido);
                    case 9:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_combustible);
                    case 10:
                        return OQcONjDATJ.this.getActivity().getString(R.string.title_miBoleto);
                    default:
                        return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
    }
}
