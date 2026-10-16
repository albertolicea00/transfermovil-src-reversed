package cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO;

import android.content.Context;
import android.util.Log;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Canal;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CiudadesPatrimoniales;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.DenominacionSello;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Empresa;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.EntidadEfectivo;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MultasTransito;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Municipio;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ObligacionesOFA;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ReservasOFA;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ServicioSucursal;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalBancaria;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TipoPrelacion;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class V9s8rJIDplX {
    public static List<SucursalBancaria> sucursalesList = new ArrayList();
    public static List<SucursalCadeca> sucursalesCadecaList = new ArrayList();
    public static List<ReservasOFA> reservasOFAList = new ArrayList();
    public static List<Provincia> provMiTurnoList = new ArrayList();
    public static List<ServicioSucursal> serviciosMiTurnoList = new ArrayList();

    public List<SucursalBancaria> getSucursalxDPA(String codDpa, Context context) {
        List<SucursalBancaria> list = new ArrayList<>();
        for (SucursalBancaria m : sucursalesList) {
            if (m.getDpa().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<SucursalCadeca> getSucursalxCadecaDPA(String codDpa, Context context) {
        List<SucursalCadeca> list = new ArrayList<>();
        for (SucursalCadeca m : sucursalesCadecaList) {
            if (m.getCodigoPovincia().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<SucursalCadeca> getSucursalGasDPA(String codDpa, Context context) {
        List<SucursalCadeca> list = new ArrayList<>();
        for (SucursalCadeca m : sucursalesCadecaList) {
            if (m.getCodigoPovincia().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<SucursalCadeca> getSucursalBancosDPA(String codDpa, Context context) {
        List<SucursalCadeca> list = new ArrayList<>();
        for (SucursalCadeca m : sucursalesCadecaList) {
            if (m.getCodigoPovincia().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<SucursalCadeca> getSucursalGasBalitaDPA(String codDpa, Context context) {
        List<SucursalCadeca> list = new ArrayList<>();
        for (SucursalCadeca m : sucursalesCadecaList) {
            if (m.getCodigoPovincia().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<SucursalCadeca> getSucursalGasBalitaDPAHab(String codDpa, String codMun, Context context) {
        List<SucursalCadeca> list = new ArrayList<>();
        for (SucursalCadeca m : sucursalesCadecaList) {
            if (m.getCodigoPovincia().contains(codDpa) && m.getCod_mun().contains(codMun)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<ServicioSucursal> getServiciosBancosDPA(String codDpa, Context context) {
        List<ServicioSucursal> list = new ArrayList<>();
        for (ServicioSucursal m : serviciosMiTurnoList) {
            if (m.getCodDpa().contains(codDpa)) {
                list.add(m);
            }
        }
        return list;
    }

    public void loadData(Context context, R1sDOSqZ2z agencyEntity) {
        String jsonLocation;
        String jsonLocation2;
        try {
            sucursalesList.clear();
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[agencyEntity.ordinal()]) {
                case 1:
                    JSONObject jsonobject = new JSONObject(loadJSONFromAsset("sucursalesBanco.json", context));
                    JSONArray jarray = jsonobject.getJSONArray("sucursales");
                    for (int i = 0; i < jarray.length(); i++) {
                        try {
                            JSONObject jb = (JSONObject) jarray.get(i);
                            String cod_dpa = jb.getString("cod_dpa");
                            jb.getString("nom_munic");
                            String cod_ccosto = jb.getString("cod_ccosto");
                            String nom_ccosto = jb.getString("nom_ccosto");
                            SucursalBancaria p = new SucursalBancaria();
                            p.setCodigoSucursal(cod_ccosto);
                            p.setDpa(cod_dpa);
                            p.setTitulo(nom_ccosto);
                            sucursalesList.add(p);
                        } catch (Exception e) {
                        }
                    }
                    break;
                case 2:
                    String jsonLocation3 = loadJSONFromAsset("sucursalesBancoBPA.json", context);
                    JSONObject jsonobject2 = new JSONObject(jsonLocation3);
                    JSONArray jarray2 = jsonobject2.getJSONArray("sucursales");
                    int i2 = 0;
                    while (i2 < jarray2.length()) {
                        try {
                            JSONObject jb2 = (JSONObject) jarray2.get(i2);
                            String dpa = jb2.getString("cod_provincia") + jb2.getString("cod_municipio");
                            String cod_ccosto2 = jb2.getString("cod_ccosto");
                            String nom_ccosto2 = jb2.getString("nom_ccosto");
                            SucursalBancaria p2 = new SucursalBancaria();
                            p2.setCodigoSucursal(cod_ccosto2);
                            p2.setDpa(dpa);
                            p2.setTitulo(nom_ccosto2);
                            jsonLocation = jsonLocation3;
                            try {
                                sucursalesList.add(p2);
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            jsonLocation = jsonLocation3;
                        }
                        i2++;
                        jsonLocation3 = jsonLocation;
                    }
                    break;
                case 3:
                    String jsonLocation4 = loadJSONFromAsset("sucursalesBancoBANDEC.json", context);
                    JSONObject jsonobject3 = new JSONObject(jsonLocation4);
                    JSONArray jarray3 = jsonobject3.getJSONArray("sucursales");
                    int i3 = 0;
                    while (i3 < jarray3.length()) {
                        try {
                            JSONObject jb3 = (JSONObject) jarray3.get(i3);
                            String dpa2 = jb3.getString("cod_provincia") + jb3.getString("cod_municipio");
                            String cod_ccosto3 = jb3.getString("cod_ccosto");
                            String nom_ccosto3 = jb3.getString("nom_ccosto");
                            SucursalBancaria p3 = new SucursalBancaria();
                            p3.setCodigoSucursal(cod_ccosto3);
                            p3.setDpa(dpa2);
                            p3.setTitulo(nom_ccosto3);
                            jsonLocation2 = jsonLocation4;
                            try {
                                sucursalesList.add(p3);
                            } catch (Exception e4) {
                            }
                        } catch (Exception e5) {
                            jsonLocation2 = jsonLocation4;
                        }
                        i3++;
                        jsonLocation4 = jsonLocation2;
                    }
                    break;
                default:
                    return;
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.tDZO41TAmLO.V9s8rJIDplX$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.Metropolitano.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void loadSucursalCadeca(Context context) {
        try {
            sucursalesCadecaList.clear();
            String jsonLocation = loadJSONFromAsset("sucursalesCadeca.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("sucursales");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_provincia = jb.getString("cod_provincia");
                    String nom_suc = jb.getString("nom_suc");
                    SucursalCadeca p = new SucursalCadeca();
                    p.setCodigoPovincia(cod_provincia);
                    p.setDpa(cod_dpa);
                    p.setTitulo(nom_suc);
                    sucursalesCadecaList.add(p);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadSucursalGas(Context context) {
        try {
            sucursalesCadecaList.clear();
            String jsonLocation = loadJSONFromAsset("sucursalesGas.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("sucursales");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_provincia = jb.getString("cod_provincia");
                    String nom_suc = jb.getString("nom_suc");
                    SucursalCadeca p = new SucursalCadeca();
                    p.setCodigoPovincia(cod_provincia);
                    p.setDpa(cod_dpa);
                    p.setTitulo(nom_suc);
                    sucursalesCadecaList.add(p);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadSucursalGasBalita(Context context) {
        try {
            sucursalesCadecaList.clear();
            String jsonLocation = loadJSONFromAsset("sucursalesGasBalita.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("sucursales");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_provincia = jb.getString("cod_provincia");
                    String nom_suc = jb.getString("nom_suc");
                    SucursalCadeca p = new SucursalCadeca();
                    p.setCodigoPovincia(cod_provincia);
                    p.setDpa(cod_dpa);
                    p.setTitulo(nom_suc);
                    sucursalesCadecaList.add(p);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadSucursalGasBalitaHab(Context context) {
        try {
            sucursalesCadecaList.clear();
            String jsonLocation = loadJSONFromAsset("scursalesGasBalitaHabana.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("sucursales");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_provincia = jb.getString("cod_provincia");
                    String nom_suc = jb.getString("nom_suc");
                    String cod_mun = jb.getString("cod_mun");
                    SucursalCadeca p = new SucursalCadeca();
                    p.setCodigoPovincia(cod_provincia);
                    p.setDpa(cod_dpa);
                    p.setTitulo(nom_suc);
                    p.setCod_mun(cod_mun);
                    sucursalesCadecaList.add(p);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadSucursalServiciosbancos(Context context) {
        try {
            sucursalesCadecaList.clear();
            String jsonLocation = loadJSONFromAsset("sucursales_miturno_servicios.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("sucursales");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_provincia = jb.getString("cod_provincia");
                    String nom_suc = jb.getString("nom_suc");
                    SucursalCadeca p = new SucursalCadeca();
                    p.setCodigoPovincia(cod_provincia);
                    p.setDpa(cod_dpa);
                    p.setTitulo(nom_suc);
                    sucursalesCadecaList.add(p);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadAllServiciosSucursal(Context context) {
        try {
            serviciosMiTurnoList.clear();
            String jsonLocation = loadJSONFromAsset("servicios_sucursal.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("servicios_sucursal");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = jarray.getJSONObject(i);
                    String cod_dpa = jb.getString("cod_dpa");
                    String cod_servicio = jb.getString("cod_servicio");
                    String nom_servicio = jb.getString("nom_servicio");
                    ServicioSucursal servicio = new ServicioSucursal();
                    servicio.setCodDpa(cod_dpa);
                    servicio.setCodServicio(cod_servicio);
                    servicio.setNomServicio(nom_servicio);
                    serviciosMiTurnoList.add(servicio);
                } catch (Exception e) {
                }
            }
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public List<MultasTransito> loadDataTransitoIncisos(Context context, int articulo) {
        String str;
        String str2 = "articulo";
        List<MultasTransito> multasTransitos = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("art_inc_transito.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("Articulos");
            List<MultasTransito> multasTransitos2 = multasTransitos;
            int i = 0;
            while (i < jarray.length()) {
                try {
                    try {
                        JSONObject jb = (JSONObject) jarray.get(i);
                        int cod_articulo = jb.getInt(str2);
                        if (cod_articulo != articulo) {
                            str = str2;
                            i++;
                            str2 = str;
                        } else {
                            try {
                                JSONArray incisosArray = jb.getJSONArray("datos");
                                int j = 0;
                                while (j < incisosArray.length()) {
                                    try {
                                        JSONObject incisoJB = (JSONObject) incisosArray.get(j);
                                        int articuloData = incisoJB.getInt(str2);
                                        String descripcionData = incisoJB.getString("descripcion");
                                        str = str2;
                                        try {
                                            int incisoData = incisoJB.getInt("inciso");
                                            int peligrosidadData = incisoJB.getInt("peligrosidad");
                                            MultasTransito p = new MultasTransito();
                                            p.setArticulo(articuloData);
                                            p.setDescripcion(descripcionData);
                                            p.setInciso(incisoData);
                                            p.setPeligrosidad(peligrosidadData);
                                            multasTransitos2.add(p);
                                        } catch (Exception e) {
                                            ex = e;
                                            try {
                                                Log.e("LOG_ERR", ex.getMessage());
                                            } catch (Exception e2) {
                                                multasTransitos2 = null;
                                                i++;
                                                str2 = str;
                                            }
                                        }
                                    } catch (Exception e3) {
                                        ex = e3;
                                        str = str2;
                                    }
                                    j++;
                                    str2 = str;
                                }
                                return multasTransitos2;
                            } catch (Exception e4) {
                                str = str2;
                                multasTransitos2 = null;
                                i++;
                                str2 = str;
                            }
                        }
                    } catch (Exception e5) {
                    }
                } catch (JSONException e6) {
                    e = e6;
                    e.printStackTrace();
                    return null;
                }
            }
            return multasTransitos2;
        } catch (JSONException e7) {
            e = e7;
        }
    }

    public List<Empresa> loadDataEmpresas(Context context) {
        List<Empresa> empresaList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("entidades.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("EntEmp");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String ministerio = jb.getString("Ministerio");
                    Empresa empresa = new Empresa();
                    empresa.setCode(code);
                    empresa.setEmpresa(nombre);
                    empresa.setMinisterio(ministerio);
                    empresaList.add(empresa);
                } catch (Exception e) {
                    empresaList = null;
                }
            }
            return empresaList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Empresa> loadDataAgencias(Context context) {
        List<Empresa> empresaList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("agenciasBancarias.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("Agencias");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String ministerio = jb.getString("Abreviatura");
                    Empresa empresa = new Empresa();
                    empresa.setCode(code);
                    empresa.setEmpresa(nombre);
                    empresa.setMinisterio(ministerio);
                    empresaList.add(empresa);
                } catch (Exception e) {
                    empresaList = null;
                }
            }
            return empresaList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<ObligacionesOFA> loadDataObligaciones(Context context) {
        List<ObligacionesOFA> obligacionesOFASList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("obligacionesOFA.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ObligacionesOFA");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    ObligacionesOFA obligacionesOFA = new ObligacionesOFA();
                    obligacionesOFA.setCode(code);
                    obligacionesOFA.setDescripcion(nombre);
                    obligacionesOFA.setAbreviatura(abreviatura);
                    obligacionesOFASList.add(obligacionesOFA);
                } catch (Exception e) {
                    obligacionesOFASList = null;
                }
            }
            return obligacionesOFASList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<ObligacionesOFA> loadDataZPC(Context context) {
        List<ObligacionesOFA> zpcSList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("zpcOFA.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("zpcOFA");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    ObligacionesOFA obligacionesOFA = new ObligacionesOFA();
                    obligacionesOFA.setCode(code);
                    obligacionesOFA.setDescripcion(nombre);
                    obligacionesOFA.setAbreviatura(abreviatura);
                    zpcSList.add(obligacionesOFA);
                } catch (Exception e) {
                    zpcSList = null;
                }
            }
            return zpcSList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<TipoPrelacion> loadDataPrelacion(Context context) {
        List<TipoPrelacion> prelacionList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("tipoPrelacion.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("Prelacion");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    TipoPrelacion tipoPrelacion = new TipoPrelacion();
                    tipoPrelacion.setCode(code);
                    tipoPrelacion.setDescripcion(nombre);
                    prelacionList.add(tipoPrelacion);
                } catch (Exception e) {
                    prelacionList = null;
                }
            }
            return prelacionList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<DenominacionSello> loadDataDenominacionSello(Context context) {
        List<DenominacionSello> dList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("denominacionesSellos.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("DenominacionesSellos");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String importe = jb.getString("Importe");
                    String nombre = jb.getString("Nombre");
                    String moneda = jb.getString("Moneda");
                    DenominacionSello denominacion = new DenominacionSello();
                    denominacion.setImporte(importe);
                    denominacion.setNombre(nombre);
                    denominacion.setMoneda(moneda);
                    dList.add(denominacion);
                } catch (Exception e) {
                    dList = null;
                }
            }
            return dList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<EntidadEfectivo> loadDataEntidadEfectivo(Context context) {
        List<EntidadEfectivo> dList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("entidadesEfectivo.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("EntEmp");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String moneda = jb.getString("Moneda");
                    EntidadEfectivo uyh0pxs9m37in = new EntidadEfectivo();
                    uyh0pxs9m37in.setCode(code);
                    uyh0pxs9m37in.setNombre(nombre);
                    uyh0pxs9m37in.setMoneda(moneda);
                    dList.add(uyh0pxs9m37in);
                } catch (Exception e) {
                    dList = null;
                }
            }
            return dList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Provincia> loadProvinciasMiTurno(Context context) {
        provMiTurnoList.clear();
        List<Provincia> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("provinciasMiTurno.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ProvinciasMiTurno");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    Provincia prov = new Provincia();
                    prov.setCod_provincia(code);
                    prov.setNombre(nombre);
                    prov.setAbreviatura(abreviatura);
                    cList.add(prov);
                } catch (Exception e) {
                    cList = null;
                }
            }
            return cList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Provincia> loadProvinciasMiTurnoGas(Context context) {
        provMiTurnoList.clear();
        List<Provincia> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("provinciasMiTurnoGas.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ProvinciasMiTurnoGas");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    Provincia prov = new Provincia();
                    prov.setCod_provincia(code);
                    prov.setNombre(nombre);
                    prov.setAbreviatura(abreviatura);
                    cList.add(prov);
                } catch (Exception e) {
                    cList = null;
                }
            }
            return cList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Provincia> loadProvinciasMiTurnoGasBalita(Context context) {
        provMiTurnoList.clear();
        List<Provincia> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("provinciasMiTurnoGasBalita.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ProvinciasMiTurnoGas");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    Provincia prov = new Provincia();
                    prov.setCod_provincia(code);
                    prov.setNombre(nombre);
                    prov.setAbreviatura(abreviatura);
                    cList.add(prov);
                } catch (Exception e) {
                    cList = null;
                }
            }
            return cList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Provincia> loadProvinciasMiTurnoServiciosBanco(Context context) {
        provMiTurnoList.clear();
        List<Provincia> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("provincias_servicios_bancos_miturno.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ProvinciasMiTurnoServiciosBancos");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    Provincia prov = new Provincia();
                    prov.setCod_provincia(code);
                    prov.setNombre(nombre);
                    prov.setAbreviatura(abreviatura);
                    cList.add(prov);
                } catch (Exception e) {
                    cList = null;
                }
            }
            return cList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<CompraPlanesCubacel> loadCompraPlanesCubacel(Context context) {
        List<CompraPlanesCubacel> ofertasList = new ArrayList<>();
        Date fechaActual = new Date();
        try {
            String jsonData = loadJSONFromAsset("compraplanescubacel.json", context);
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("Ofertas");
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonOferta = jsonArray.getJSONObject(i);
                    CompraPlanesCubacel planes = new CompraPlanesCubacel();
                    planes.setNombre(jsonOferta.getString("nombre"));
                    planes.setId(Integer.parseInt(jsonOferta.getString("id")));
                    planes.setVersion_ussd(Integer.parseInt(jsonOferta.getString("version")));
                    planes.setFechaAct(fechaActual);
                    ofertasList.add(planes);
                } catch (JSONException e) {
                    Log.e("OfertasFragment", "Error al parsear oferta: " + e.getMessage());
                }
            }
            return ofertasList;
        } catch (JSONException e2) {
            Log.e("OfertasFragment", "Error al parsear JSON principal", e2);
            return new ArrayList();
        }
    }

    public List<Municipio> loadMunicipiosLaHabana(Context context, String codProvincia) {
        List<Municipio> municipios = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("municipios_la_habana.json", context);
            JSONObject jsonObject = new JSONObject(jsonLocation);
            JSONArray jsonArray = jsonObject.getJSONArray("MunicipiosLaHabana");
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonMunicipio = jsonArray.getJSONObject(i);
                    if (jsonMunicipio.getString("cod_provincia").equals(codProvincia)) {
                        String cod_dpa = jsonMunicipio.getString("cod_dpa");
                        String abreviatura = jsonMunicipio.getString("abreviatura");
                        String nombre = jsonMunicipio.getString("nombre");
                        String cod_provincia = jsonMunicipio.getString("cod_provincia");
                        Municipio municipio = new Municipio();
                        municipio.setCod_municipio(cod_dpa);
                        municipio.setAbreviatura(abreviatura);
                        municipio.setNombre(nombre);
                        municipio.setCod_provincia(cod_provincia);
                        municipios.add(municipio);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return municipios;
    }

    public List<CiudadesPatrimoniales> loadCiudadPatrimonial(Context context) {
        reservasOFAList.clear();
        List<CiudadesPatrimoniales> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("ciudadPatrimonial.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("CiudadPatrimonialOFA");
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    JSONObject jb = (JSONObject) jarray.get(i);
                    String code = jb.getString("Code");
                    String nombre = jb.getString("Nombre");
                    String abreviatura = jb.getString("Abreviatura");
                    CiudadesPatrimoniales ofa = new CiudadesPatrimoniales();
                    ofa.setCode(code);
                    ofa.setNombre(nombre);
                    ofa.setAbreviatura(abreviatura);
                    cList.add(ofa);
                } catch (Exception e) {
                    cList = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            cList = null;
        }
        reservasOFAList = loadReservasOFA(context);
        return cList;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public List<ReservasOFA> loadReservasOFA(Context context) {
        List<ReservasOFA> cList = new ArrayList<>();
        try {
            String jsonLocation = loadJSONFromAsset("reservasOFA.json", context);
            JSONObject jsonobject = new JSONObject(jsonLocation);
            JSONArray jarray = jsonobject.getJSONArray("ReservasOFA");
            List<ReservasOFA> cList2 = cList;
            for (int i = 0; i < jarray.length(); i++) {
                try {
                    try {
                        JSONObject jb = (JSONObject) jarray.get(i);
                        String code = jb.getString("Code");
                        String nombre = jb.getString("Nombre");
                        String abreviatura = jb.getString("Abreviatura");
                        String ciudad = jb.getString("Ciudad");
                        String precioNac = jb.getString("PrecioNac");
                        String precioExt = jb.getString("PrecioExt");
                        String monedaNac = jb.getString("MonedaNac");
                        String monedaExt = jb.getString("MonedaExt");
                        ReservasOFA ofa = new ReservasOFA();
                        ofa.setCode(code);
                        ofa.setNombre(nombre);
                        ofa.setAbreviatura(abreviatura);
                        ofa.setCiudad(ciudad);
                        ofa.setPrecioNac(precioNac);
                        ofa.setPrecioExt(precioExt);
                        ofa.setMonedaNac(monedaNac);
                        ofa.setMonedaExt(monedaExt);
                        cList2.add(ofa);
                    } catch (Exception e) {
                        cList2 = null;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return null;
                }
            }
            return cList2;
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public List<ReservasOFA> getReservasOFA(String codCiudad, Context context) {
        List<ReservasOFA> list = new ArrayList<>();
        for (ReservasOFA m : reservasOFAList) {
            if (m.getCiudad().contains(codCiudad)) {
                list.add(m);
            }
        }
        return list;
    }

    public List<ReservasOFA> getSucursalCadeca(String codCiudad, Context context) {
        List<ReservasOFA> list = new ArrayList<>();
        for (ReservasOFA m : reservasOFAList) {
            if (m.getCiudad().contains(codCiudad)) {
                list.add(m);
            }
        }
        return list;
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

    public List<Canal> loadCanalesFromJSON(Context context) {
        List<Canal> canalesList = new ArrayList<>();
        try {
            try {
                String jsonLocation = loadJSONFromAsset("canales_votomovil.json", context);
                if (jsonLocation == null) {
                    Log.e("JsonHelper", "No se pudo cargar el archivo JSON");
                    return canalesList;
                }
                JSONObject jsonobject = new JSONObject(jsonLocation);
                JSONArray jarray = jsonobject.getJSONArray("canales");
                for (int i = 0; i < jarray.length(); i++) {
                    try {
                        JSONObject jb = jarray.getJSONObject(i);
                        String id = jb.getString("id");
                        String nombre = jb.getString("nombre");
                        int esDePago = jb.getInt("esDePago");
                        Canal canal = new Canal();
                        canal.setId(id);
                        canal.setNombre(nombre);
                        canal.setEsDePago(esDePago);
                        canalesList.add(canal);
                    } catch (JSONException ex) {
                        Log.e("JsonHelper", "Error al parsear canal en posición " + i + ": " + ex.getMessage());
                    }
                }
                return canalesList;
            } catch (JSONException e) {
                Log.e("JsonHelper", "Error JSON: " + e.getMessage());
                canalesList.clear();
            }
        } catch (Exception e2) {
            Log.e("JsonHelper", "Error general: " + e2.getMessage());
            canalesList.clear();
        }
    }

    private Date parsearFecha(String fechaStr) {
        Date date = null;
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null;
        }
        SimpleDateFormat[] formatos = {new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()), new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()), new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())};
        for (SimpleDateFormat sdf : formatos) {
            try {
                sdf.setLenient(false);
                return sdf.parse(fechaStr);
            } catch (ParseException e) {
            }
        }
        return date;
    }
}
