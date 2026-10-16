package cu.etecsa.tm.ecommerce.Dyporpu9vbM.tQvDIr4mUHh;

import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class OL5DKyRBcd implements CookieJar {
    private List<Cookie> cookies;

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        this.cookies = cookies;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> list = this.cookies;
        if (list != null) {
            return list;
        }
        return new ArrayList();
    }
}
