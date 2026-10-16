package AFm1GraXBXUkpF1hmOdV;

import com.github.paolorotolo.appintro.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class hKRRh7lnIpNaVleqsuo {
    public int aSHV52SplNh3HfZBSmJe;

    /* JADX INFO: renamed from: aSHV52SplNh3HfZBSmJe, reason: collision with other field name */
    public List f3aSHV52SplNh3HfZBSmJe;

    /* JADX INFO: renamed from: aSHV52SplNh3HfZBSmJe, reason: collision with other field name */
    public int[] f4aSHV52SplNh3HfZBSmJe = new int[10];

    /* JADX INFO: renamed from: aSHV52SplNh3HfZBSmJe, reason: collision with other field name */
    public String f2aSHV52SplNh3HfZBSmJe = BuildConfig.FLAVOR;

    public hKRRh7lnIpNaVleqsuo(int i, YzK9tTZsYVnC5kFxSie yzK9tTZsYVnC5kFxSie) {
        this.f3aSHV52SplNh3HfZBSmJe = new ArrayList();
        this.aSHV52SplNh3HfZBSmJe = 0;
        this.aSHV52SplNh3HfZBSmJe = i;
        this.f3aSHV52SplNh3HfZBSmJe = yzK9tTZsYVnC5kFxSie.aSHV52SplNh3HfZBSmJe();
    }

    public final String LPvHf9WSoF2n4fwV7feH(String str) {
        return String.valueOf(this.f4aSHV52SplNh3HfZBSmJe[Integer.parseInt(str)]);
    }

    public String aSHV52SplNh3HfZBSmJe(String str) {
        this.f2aSHV52SplNh3HfZBSmJe = BuildConfig.FLAVOR;
        int i = 0;
        if (str.length() % 2 == 0) {
            while (i < str.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2aSHV52SplNh3HfZBSmJe);
                sb.append(is0RT67JHPWDGKDrDOPd(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i + 1))));
                this.f2aSHV52SplNh3HfZBSmJe = sb.toString();
                i += 2;
            }
        } else {
            is0RT67JHPWDGKDrDOPd();
            str.length();
            String strLPvHf9WSoF2n4fwV7feH = LPvHf9WSoF2n4fwV7feH(String.valueOf(str.charAt(str.length() - 1)));
            String strSubstring = str.substring(0, str.length() - 1);
            while (i < strSubstring.length()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2aSHV52SplNh3HfZBSmJe);
                sb2.append(is0RT67JHPWDGKDrDOPd(String.valueOf(strSubstring.charAt(i)) + String.valueOf(strSubstring.charAt(i + 1))));
                this.f2aSHV52SplNh3HfZBSmJe = sb2.toString();
                i += 2;
            }
            String str2 = this.f2aSHV52SplNh3HfZBSmJe + strLPvHf9WSoF2n4fwV7feH;
            this.f2aSHV52SplNh3HfZBSmJe = str2;
            this.f2aSHV52SplNh3HfZBSmJe = str2;
        }
        return this.f2aSHV52SplNh3HfZBSmJe;
    }

    public final String is0RT67JHPWDGKDrDOPd(String str) {
        int iIntValue = ((Integer) this.f3aSHV52SplNh3HfZBSmJe.get(Integer.parseInt(str.substring(0, 1) + str.substring(1)))).intValue();
        if (String.valueOf(iIntValue).length() != 1) {
            return String.valueOf(iIntValue);
        }
        if (iIntValue == 0) {
            return "00";
        }
        return "0" + String.valueOf(iIntValue);
    }

    public final void is0RT67JHPWDGKDrDOPd() {
        int i = 0;
        for (Integer num : this.f3aSHV52SplNh3HfZBSmJe) {
            if (num.intValue() < 10) {
                this.f4aSHV52SplNh3HfZBSmJe[i] = num.intValue();
                i++;
            }
        }
    }
}
