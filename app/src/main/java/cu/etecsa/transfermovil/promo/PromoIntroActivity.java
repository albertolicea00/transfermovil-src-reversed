package cu.etecsa.transfermovil.promo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.github.paolorotolo.appintro.AppIntro;
import cu.etecsa.transfermovil.R;
import cu.etecsa.transfermovil.data.entity.SmsPromotion;
import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI.wComYkZMDc
 * @fingerprint AppIntro activity showing promo slide carousel. Loads active daily
 *              promos via DailyPromoProvider and adds a PromoSlideFragment for each.
 */
public class PromoIntroActivity extends AppIntro {

    public List<Integer> colorList = new ArrayList<>();

    @Override
    public void init(Bundle savedInstanceState) {
        try {
            this.colorList.add(Color.parseColor("#3A8BBB"));
            this.colorList.add(Color.parseColor("#50EB8F"));
            this.colorList.add(Color.parseColor("#FF566A"));
            this.colorList.add(-16711681); // cyan
            this.colorList.add(-16776961); // blue
            this.colorList.add(-16711936); // green
            this.colorList.add(-256);      // yellow
            this.colorList.add(-65281);    // magenta
            DailyPromoProvider promoProvider = new DailyPromoProvider();
            List<SmsPromotion> promoList = promoProvider.getPromosDia();
            if (promoList != null && promoList.size() > 0) {
                for (SmsPromotion sms : promoList) {
                    addSlide(PromoSlideFragment.newInstance(
                            R.layout.d4kj1v3wlyi173,
                            sms.getTipo_promo().name(),
                            sms.getMensaje(),
                            this.colorList.get(0)));
                }
            }
        } catch (Exception ex) {
            Log.e("TM_DEFAULINTRO", "Exception" + ex.getMessage());
        }
    }

    private void loadMainActivity() {
        onBackPressed();
    }

    @Override
    public void onNextPressed() {}

    @Override
    public void onSkipPressed() {
        loadMainActivity();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    @Override
    public void onSlideChanged() {}

    public void getStarted(View v) {
        loadMainActivity();
    }
}
