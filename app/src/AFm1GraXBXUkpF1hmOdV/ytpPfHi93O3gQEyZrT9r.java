package AFm1GraXBXUkpF1hmOdV;

import com.github.paolorotolo.appintro.BuildConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ytpPfHi93O3gQEyZrT9r {
    public hKRRh7lnIpNaVleqsuo aSHV52SplNh3HfZBSmJe;
    public int is0RT67JHPWDGKDrDOPd;

    /* JADX INFO: renamed from: is0RT67JHPWDGKDrDOPd, reason: collision with other field name */
    public int[] f5is0RT67JHPWDGKDrDOPd;

    public ytpPfHi93O3gQEyZrT9r(int i, YzK9tTZsYVnC5kFxSie yzK9tTZsYVnC5kFxSie) {
        this.is0RT67JHPWDGKDrDOPd = 0;
        this.is0RT67JHPWDGKDrDOPd = i;
        this.aSHV52SplNh3HfZBSmJe = new hKRRh7lnIpNaVleqsuo(i, yzK9tTZsYVnC5kFxSie);
    }

    public int aSHV52SplNh3HfZBSmJe() {
        return this.is0RT67JHPWDGKDrDOPd;
    }

    public final void aSHV52SplNh3HfZBSmJe(int i) {
        hKRRh7lnIpNaVleqsuo hkrrh7lnipnavleqsuo = this.aSHV52SplNh3HfZBSmJe;
        int i2 = hkrrh7lnipnavleqsuo.aSHV52SplNh3HfZBSmJe;
        List list = hkrrh7lnipnavleqsuo.f3aSHV52SplNh3HfZBSmJe;
        this.f5is0RT67JHPWDGKDrDOPd = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (i2 == list.size() - 1) {
                this.f5is0RT67JHPWDGKDrDOPd[i3] = ((Integer) list.get(0)).intValue();
                i2 = 1;
            } else if (i2 >= 0 || i2 < list.size()) {
                this.f5is0RT67JHPWDGKDrDOPd[i3] = ((Integer) list.get(i2)).intValue();
                i2++;
            }
        }
    }

    public final String elm3KXVuolZT3pf9Zdhx(String str) {
        int[] iArr = this.f5is0RT67JHPWDGKDrDOPd;
        String strSubstring = BuildConfig.FLAVOR;
        for (int i : iArr) {
            strSubstring = strSubstring + String.valueOf(i);
        }
        if (strSubstring.length() > str.length()) {
            strSubstring = strSubstring.substring(0, str.length());
        }
        return String.valueOf(Long.valueOf(Long.valueOf(Long.parseLong(strSubstring)).longValue() ^ Long.valueOf(Long.parseLong(str)).longValue()));
    }

    public String u7e3g2r1vaMGiuBXZCf(String str) {
        aSHV52SplNh3HfZBSmJe(str.length());
        return elm3KXVuolZT3pf9Zdhx(this.aSHV52SplNh3HfZBSmJe.aSHV52SplNh3HfZBSmJe(str));
    }
}
