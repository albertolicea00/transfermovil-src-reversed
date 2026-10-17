package cu.etecsa.transfermovil.banking.ui;

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
import cu.etecsa.transfermovil.banking.ui.tabs.WalletOperationsTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.GeneralBankingTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.WalletBoletoTabFragment;
import cu.etecsa.transfermovil.banking.ui.tabs.MainBankingTabFragment;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.WalletCurrency;
import cu.etecsa.transfermovil.sms.SmsInboxReader;
import cu.etecsa.transfermovil.sms.SmsMessage;
import cu.etecsa.transfermovil.sms.SmsParser;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.ofOuyCSKWI
 *
 * 4-tab ViewPager for wallet operations (no Agent tab).
 * On create, checks SMS inbox for wallet currency updates newer than
 * last stored date and re-parses them.
 */
public class WalletPagerFragment extends Fragment {

    public static int int_items = 4;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.kfu18xntaf1jz, (ViewGroup) null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        try {
            ContentResolver cs = container.getContext().getContentResolver();
            SmsInboxReader smsCenter = new SmsInboxReader();
            ArrayList<SmsMessage> sms = smsCenter.readSmsInbox(cs);
            List<WalletCurrency> currencies = DatabaseHelper.getInstance().getMonedasWallet();
            if (currencies != null && currencies.size() > 0 && sms != null) {
                SmsParser parser = new SmsParser();
                for (int i = 0; i < sms.size(); i++) {
                    if (sms.get(i).getBody().contains("La actualizacion de las cuentas virtuales fue completada.")
                            && sms.get(i).getDate().after(currencies.get(0).getFecha())) {
                        parser.parseMonedasWallet(sms.get(i).getBody());
                    }
                }
            }
        } catch (Exception ex) {
            Log.d("Ex", ex.getMessage());
        }
        viewPager.setAdapter(new WalletPagerAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                WalletPagerFragment.tabLayout.setupWithViewPager(WalletPagerFragment.viewPager);
            }
        });
        return x;
    }

    public class WalletPagerAdapter extends FragmentPagerAdapter {

        public WalletPagerAdapter(FragmentManager fm) {
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
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return WalletPagerFragment.int_items;
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
                default:
                    return null;
            }
        }
    }
}
