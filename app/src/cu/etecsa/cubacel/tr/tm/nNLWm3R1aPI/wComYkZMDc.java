package cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.github.paolorotolo.appintro.AppIntro;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class wComYkZMDc extends AppIntro {
    public List<Integer> colorList = new ArrayList();

    @Override // com.github.paolorotolo.appintro.AppIntro
    public void init(Bundle savedInstanceState) {
        try {
            this.colorList.add(Integer.valueOf(Color.parseColor("#3A8BBB")));
            this.colorList.add(Integer.valueOf(Color.parseColor("#50EB8F")));
            this.colorList.add(Integer.valueOf(Color.parseColor("#FF566A")));
            this.colorList.add(-16711681);
            this.colorList.add(-16776961);
            this.colorList.add(-16711936);
            this.colorList.add(-256);
            this.colorList.add(-65281);
            BOf8kgNm7V promoManagement = new BOf8kgNm7V();
            List<PromoSMS> promoSMSList = promoManagement.getPromosDia();
            if (promoSMSList != null && promoSMSList.size() > 0) {
                for (PromoSMS sms : promoSMSList) {
                    addSlide(GNMxOsPuzb.newInstance(R.layout.d4kj1v3wlyi173, sms.getTipo_promo().name(), sms.getMensaje(), this.colorList.get(0).intValue()));
                }
            }
        } catch (Exception ex) {
            Log.e("TM_DEFAULINTRO", "Exception" + ex.getMessage());
        }
    }

    private void loadMainActivity() {
        onBackPressed();
    }

    @Override // com.github.paolorotolo.appintro.AppIntro
    public void onNextPressed() {
    }

    @Override // com.github.paolorotolo.appintro.AppIntro
    public void onSkipPressed() {
        loadMainActivity();
    }

    @Override // com.github.paolorotolo.appintro.AppIntro
    public void onDonePressed() {
        loadMainActivity();
    }

    @Override // com.github.paolorotolo.appintro.AppIntro
    public void onSlideChanged() {
    }

    public void getStarted(View v) {
        loadMainActivity();
    }
}
