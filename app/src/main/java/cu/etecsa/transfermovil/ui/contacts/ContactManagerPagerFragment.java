package cu.etecsa.transfermovil.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.OQcONjDATJ
 * @fingerprint ViewPager with 12 tabs: Clientes, Tarjetas(PINs), Moviles, Fijos,
 *              Nautas, Facturas, ServiciosPublicos, Cuentas, Propias, NautasBanco,
 *              Tickets, MiBoleto. Full contact management tabbed UI.
 */
public class ContactManagerPagerFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public ClientListFragment clientesFragment = new ClientListFragment();
    public PinListFragment tarjetasFragment = new PinListFragment();
    public MobilePhoneListFragment movilesFragment = new MobilePhoneListFragment();
    public LandlinePhoneListFragment fijosFragment = new LandlinePhoneListFragment();
    public NautaAccountListFragment nautasFragment = new NautaAccountListFragment();
    public InvoiceListFragment facturasFragments = new InvoiceListFragment();
    public PublicServiceListFragment serviciosPublicosFragments = new PublicServiceListFragment();
    public BankAccountListFragment cuentasFragment = new BankAccountListFragment();
    public TicketAccountListFragment propiasFragment = new TicketAccountListFragment();
    public NautaBankListFragment nautasBancoFragments = new NautaBankListFragment();
    public TransportTicketListFragment ticketsFragment = new TransportTicketListFragment();
    public MiBoletoListFragment miBoletoFragments = new MiBoletoListFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflates pager layout, sets up TabLayout + ViewPager with FragmentPagerAdapter
        return null; // stub
    }
}
