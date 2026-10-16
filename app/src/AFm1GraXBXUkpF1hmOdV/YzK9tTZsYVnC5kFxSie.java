package AFm1GraXBXUkpF1hmOdV;

import com.github.paolorotolo.appintro.BuildConfig;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class YzK9tTZsYVnC5kFxSie {
    public List aSHV52SplNh3HfZBSmJe = new ArrayList();

    /* JADX INFO: renamed from: aSHV52SplNh3HfZBSmJe, reason: collision with other field name */
    public int[][] f1aSHV52SplNh3HfZBSmJe = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 10, 10);
    public String is0RT67JHPWDGKDrDOPd;

    public YzK9tTZsYVnC5kFxSie(String str, String str2) {
        this.is0RT67JHPWDGKDrDOPd = BuildConfig.FLAVOR;
        this.is0RT67JHPWDGKDrDOPd = str;
        aSHV52SplNh3HfZBSmJe(str2);
    }

    public List aSHV52SplNh3HfZBSmJe() {
        return this.aSHV52SplNh3HfZBSmJe;
    }

    public void aSHV52SplNh3HfZBSmJe(String str) {
        String strSubstring = this.is0RT67JHPWDGKDrDOPd;
        int length = strSubstring.length();
        while (true) {
            int i = 0;
            while (length > 0) {
                String strSubstring2 = strSubstring.substring(Character.getNumericValue(str.charAt(i)), strSubstring.length());
                String strSubstring3 = strSubstring2.substring(0, 8);
                strSubstring = strSubstring2.substring(8, strSubstring2.length());
                length = strSubstring.length();
                this.aSHV52SplNh3HfZBSmJe.add(Integer.valueOf(Integer.parseInt(strSubstring3, 2)));
                if (i != str.length() - 1) {
                    i++;
                }
            }
            return;
        }
    }
}
