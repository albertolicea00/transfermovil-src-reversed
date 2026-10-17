package cu.etecsa.transfermovil.ui.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.wTZi6Zeikv
 * @fingerprint Simpler ViewPager variant with 10 tabs (no Tickets/MiBoleto).
 *              Extends SharedPreferencesAccessor (Fr52O1uSYF) for phone access.
 */
public class ContactManagerSimplePagerFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    public ClientListFragment clientesFragment = new ClientListFragment();
    public PinListFragment tarjetasFragment = new PinListFragment();
    public MobilePhoneListFragment movilesFragment = new MobilePhoneListFragment();
    public LandlinePhoneListFragment fijosFragment = new LandlinePhoneListFragment();
    public NautaAccountListFragment nautasFragment = new NautaAccountListFragment();
    public InvoiceListFragment facturasFragments = new InvoiceListFragment();
    public BankAccountListFragment cuentasFragment = new BankAccountListFragment();
    public PublicServiceListFragment serviciosPublicosFragments = new PublicServiceListFragment();
    public TicketAccountListFragment propiasFragment = new TicketAccountListFragment();
    public NautaBankListFragment nautaBancoFragment = new NautaBankListFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null; // stub
    }
}
