package cu.etecsa.transfermovil.banking.ui;

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

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.wTZi6Zeikv
 * @fingerprint General-mode data management pager with 8 tabs: Propietario, Facturas,
 *              Cuentas, Propia, ServiciosPublicos, NautaBanco, Tickets, MiBoleto.
 *              Fewer tabs than agent mode (no Fijos/Moviles/Nauta separate management).
 *              Requests READ_CONTACTS permission on API 23+.
 */
public class DataManagementGeneralPagerFragment extends Fragment {

    public static int int_items;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public ClientListFragment clientesFragment = new ClientListFragment();
    public PinListFragment tarjetasFragment = new PinListFragment();
    public MobileListFragment movilesFragment = new MobileListFragment();
    public LandlineListFragment fijosFragment = new LandlineListFragment();
    public NautaListFragment nautasFragment = new NautaListFragment();
    public InvoiceListFragment facturasFragments = new InvoiceListFragment();
    public BankAccountListFragment cuentasFragment = new BankAccountListFragment();
    public PublicServiceListFragment serviciosPublicosFragments = new PublicServiceListFragment();
    public OwnCardListFragment propiasFragment = new OwnCardListFragment();
    public NautaBankListFragment nautaBancoFragment = new NautaBankListFragment();
    public TicketListFragment ticketsFragment = new TicketListFragment();
    public MiBoletoListFragment miBoletoFragments = new MiBoletoListFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 23
                && getContext().checkSelfPermission("android.permission.READ_CONTACTS") == -1) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
        }
        int_items = 8;
        View x = inflater.inflate(R.layout.uwsf4ji3yumwn, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(() -> tabLayout.setupWithViewPager(viewPager));
        return x;
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return clientesFragment;
                case 1: return facturasFragments;
                case 2: return cuentasFragment;
                case 3: return propiasFragment;
                case 4: return serviciosPublicosFragments;
                case 5: return nautaBancoFragment;
                case 6: return ticketsFragment;
                case 7: return miBoletoFragments;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Propietario";
                case 1: return "Facturas";
                case 2: return getActivity().getString(R.string.title_servicios_cuenta);
                case 3: return "PROPIA";
                case 4: return getActivity().getString(R.string.title_servicios_publicos);
                case 5: return getActivity().getString(R.string.title_nauta_banco);
                case 6: return getActivity().getString(R.string.title_combustible);
                case 7: return getActivity().getString(R.string.title_miBoleto);
                default: return null;
            }
        }
    }
}
