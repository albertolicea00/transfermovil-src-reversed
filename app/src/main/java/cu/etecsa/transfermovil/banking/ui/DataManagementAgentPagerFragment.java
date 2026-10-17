package cu.etecsa.transfermovil.banking.ui;

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
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ
 * @fingerprint Agent-mode data management pager with 11 tabs: Clientes, Fijos, Moviles,
 *              Nauta, Facturas, Cuentas, Propia, ServiciosPublicos, NautaBanco, Tickets, MiBoleto.
 *              Used for agent/business accounts with extended management capabilities.
 */
public class DataManagementAgentPagerFragment extends Fragment {

    public static int int_items;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public ClientListFragment clientesFragment = new ClientListFragment();
    public PinListFragment tarjetasFragment = new PinListFragment();
    public MobileListFragment movilesFragment = new MobileListFragment();
    public LandlineListFragment fijosFragment = new LandlineListFragment();
    public NautaListFragment nautasFragment = new NautaListFragment();
    public InvoiceListFragment facturasFragments = new InvoiceListFragment();
    public PublicServiceListFragment serviciosPublicosFragments = new PublicServiceListFragment();
    public BankAccountListFragment cuentasFragment = new BankAccountListFragment();
    public OwnCardListFragment propiasFragment = new OwnCardListFragment();
    public NautaBankListFragment nautasBancoFragments = new NautaBankListFragment();
    public TicketListFragment ticketsFragment = new TicketListFragment();
    public MiBoletoListFragment miBoletoFragments = new MiBoletoListFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int_items = 11;
        View x = inflater.inflate(R.layout.uwsf4ji3yumwn, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager vp = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = vp;
        vp.setAdapter(new MyAdapter(getChildFragmentManager()));
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
                case 1: return fijosFragment;
                case 2: return movilesFragment;
                case 3: return nautasFragment;
                case 4: return facturasFragments;
                case 5: return cuentasFragment;
                case 6: return propiasFragment;
                case 7: return serviciosPublicosFragments;
                case 8: return nautasBancoFragments;
                case 9: return ticketsFragment;
                case 10: return miBoletoFragments;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            try {
                switch (position) {
                    case 0: return getActivity().getString(R.string.title_gestion_cliente);
                    case 1: return getActivity().getString(R.string.title_gestion_fijo);
                    case 2: return getActivity().getString(R.string.title_gestion_moviles);
                    case 3: return getActivity().getString(R.string.title_gestion_nauta);
                    case 4: return getActivity().getString(R.string.title_gestion_facturas);
                    case 5: return getActivity().getString(R.string.title_servicios_cuenta);
                    case 6: return "Propia";
                    case 7: return getActivity().getString(R.string.title_servicios_publicos);
                    case 8: return getActivity().getString(R.string.title_nauta_banco_extendido);
                    case 9: return getActivity().getString(R.string.title_combustible);
                    case 10: return getActivity().getString(R.string.title_miBoleto);
                    default: return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
    }
}
