package cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil;

import android.content.Context;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ldmbl4HatR implements GdIcoRIaia {
    public static List<I7Szcu2IgpM> municipiosList = new ArrayList();
    public static List<njwILmSkGJ> provinciaList = new ArrayList();

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia
    public void loadData(Context context) {
        String str;
        String str2 = "Mun";
        try {
            String jsonLocation = loadJSONFromAsset("dpabulevar.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("Mun");
            int i = 0;
            while (i < jarray.length()) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_municipio = jb.getString(str2);
                    String cod_provincia = jb.getString("Prov");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    I7Szcu2IgpM p = new I7Szcu2IgpM();
                    p.setCod_municipio(cod_municipio);
                    p.setCod_provincia(cod_provincia);
                    p.setNombre(nombre);
                    p.setAbreviatura(abreviatura);
                    str = str2;
                    try {
                        municipiosList.add(p);
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    str = str2;
                }
                i++;
                str2 = str;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            String jsonLocation2 = loadJSONFromAsset("dpabulevar.json", context);
            JSONObject jsonobject2 = new JSONObject(jsonLocation2);
            JSONArray jarray2 = jsonobject2.getJSONArray("Prov");
            for (int i2 = 0; i2 < jarray2.length(); i2++) {
                try {
                    JSONObject jb2 = (JSONObject) jarray2.get(i2);
                    String cod = jb2.getString("Prov");
                    String nombre2 = jb2.getString("Nombre");
                    String abreviatura2 = jb2.getString("Abreviatura");
                    njwILmSkGJ p2 = new njwILmSkGJ();
                    p2.setCod_provincia(cod);
                    p2.setNombre(nombre2);
                    p2.setAbreviatura(abreviatura2);
                    provinciaList.add(p2);
                } catch (Exception e4) {
                }
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia
    public List<njwILmSkGJ> getProvinciasList(Context context) {
        return provinciaList;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia
    public njwILmSkGJ getProvincia(String codProvincia, Context context) {
        for (njwILmSkGJ p : provinciaList) {
            if (p.getCod_provincia().contains(codProvincia)) {
                return p;
            }
        }
        return null;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia
    public List<I7Szcu2IgpM> getMuncipioXProvinciaList(String codProvincia, Context context) {
        List<I7Szcu2IgpM> list = new ArrayList<>();
        for (I7Szcu2IgpM m : municipiosList) {
            if (m.getCod_provincia().contains(codProvincia)) {
                list.add(m);
            }
        }
        return list;
    }

    @Override // cu.etecsa.tm.ecommerce.Dyporpu9vbM.QaHUruvdVUN.GdIcoRIaia
    public I7Szcu2IgpM getMunicipio(String codMunicipio, Context context) {
        String codM = codMunicipio.substring(2, 4);
        String codP = codMunicipio.substring(0, 2);
        for (I7Szcu2IgpM m : municipiosList) {
            if (m.getCod_provincia().contains(codP) && m.getCod_municipio().contains(codM)) {
                return m;
            }
        }
        return null;
    }

    public String loadJSONFromAsset(String nameJson, Context context) {
        try {
            InputStream is = context.getAssets().open(nameJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            return json;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
