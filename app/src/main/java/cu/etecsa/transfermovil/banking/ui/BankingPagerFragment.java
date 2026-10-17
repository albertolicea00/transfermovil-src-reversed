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
import cu.etecsa.transfermovil.banking.ui.tabs.WalletOperationsTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.AgentOperationsTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.GeneralBankingTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.WalletBoletoTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.MainBankingTabFragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.gCD4Z8F6ml
 *
 * 5-tab ViewPager for full banking operations.
 * Tabs: Sesión (wallet auth), Consultas (queries), Operaciones (operations),
 *       Configuración (wallet/boleto config), Agente (agent ops).
 */
public class BankingPagerFragment extends Fragment {

    public static int int_items = 5;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.kfu18xntaf1jz, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        ViewPager viewPager2 = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager = viewPager2;
        viewPager2.setAdapter(new BankingPagerAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                BankingPagerFragment.tabLayout.setupWithViewPager(BankingPagerFragment.viewPager);
            }
        });
        return x;
    }

    public class BankingPagerAdapter extends FragmentPagerAdapter {

        public BankingPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new WalletOperationsTabFragment();
                case 1:
                    return new GeneralBankingTabFragment();
                case 2:
                    return new MainBankingTabFragment();
                case 3:
                    return new WalletBoletoTabFragment();
                case 4:
                    return new AgentOperationsTabFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return BankingPagerFragment.int_items;
        }

        @Override
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
