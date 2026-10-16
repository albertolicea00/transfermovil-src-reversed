package AFm1GraXBXUkpF1hmOdV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class Tz34gww2TFwrsuT8ukpL {
    public int aSHV52SplNh3HfZBSmJe;

    /* JADX INFO: renamed from: aSHV52SplNh3HfZBSmJe, reason: collision with other field name */
    public YzK9tTZsYVnC5kFxSie f0aSHV52SplNh3HfZBSmJe;

    public Tz34gww2TFwrsuT8ukpL(String str, String str2) {
        this.f0aSHV52SplNh3HfZBSmJe = new YzK9tTZsYVnC5kFxSie(str2, str);
        aSHV52SplNh3HfZBSmJe();
    }

    public List aSHV52SplNh3HfZBSmJe(List list) {
        ArrayList arrayList = new ArrayList();
        ytpPfHi93O3gQEyZrT9r ytppfhi93o3gqeyzrt9r = new ytpPfHi93O3gQEyZrT9r(this.aSHV52SplNh3HfZBSmJe, this.f0aSHV52SplNh3HfZBSmJe);
        arrayList.add(String.valueOf(ytppfhi93o3gqeyzrt9r.aSHV52SplNh3HfZBSmJe()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ytppfhi93o3gqeyzrt9r.u7e3g2r1vaMGiuBXZCf((String) it.next()));
        }
        return arrayList;
    }

    public final void aSHV52SplNh3HfZBSmJe() {
        this.aSHV52SplNh3HfZBSmJe = new Random().nextInt(100);
    }
}
