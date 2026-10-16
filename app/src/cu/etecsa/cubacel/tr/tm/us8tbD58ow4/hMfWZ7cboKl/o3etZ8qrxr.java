package cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl;

import android.graphics.Color;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lecho.lib.hellocharts.model.SliceValue;

/* JADX INFO: loaded from: classes.dex */
public class o3etZ8qrxr {
    public List<tGolNOl3DN> leyenda;
    public List<FlNVShJWtm> operacionesPojos;
    public List<Integer> listColor = new ArrayList();
    private List<Nl0yptXmjQ> ordenOperaciones = new ArrayList();

    public String getStringOperacionByEnum(Nl0yptXmjQ operationEntity) {
        Map<String, String> map = new HashMap<>();
        map.put(Nl0yptXmjQ.Pago_Electricidad.name(), "Pago Electricidad");
        map.put(Nl0yptXmjQ.Pago_Telefono.name(), "Pago Teléfono");
        map.put(Nl0yptXmjQ.Pago_Agua.name(), "Pago Agua");
        map.put(Nl0yptXmjQ.Transferencia.name(), "Transferencia");
        map.put(Nl0yptXmjQ.Pago_Factura_Telefonica.name(), "Factura Telefónica");
        map.put(Nl0yptXmjQ.Recarga_Movil.name(), "Recarga Móvil");
        map.put(Nl0yptXmjQ.Recarga_Nauta.name(), "Recarga Nauta");
        map.put(Nl0yptXmjQ.Recarga_Movil_Banco.name(), "Recarga Móvil");
        map.put(Nl0yptXmjQ.Amortizacion.name(), "Amortización");
        map.put(Nl0yptXmjQ.Pago_ONAT.name(), "Pago ONAT");
        map.put(Nl0yptXmjQ.Pago_Gas.name(), "Pago Gas");
        map.put(Nl0yptXmjQ.Recarga_Nauta_Banco.name(), "Recarga Nauta");
        map.put(Nl0yptXmjQ.Giro.name(), "Giro Postal");
        map.put(Nl0yptXmjQ.xf94v3SFEM.name(), "Compra en linea");
        map.put(Nl0yptXmjQ.Recarga_Propia.name(), "Recarga Propia");
        map.put(Nl0yptXmjQ.Recarga_Nauta_Hogar_Banco.name(), "Nauta Hogar");
        map.put(Nl0yptXmjQ.JClub.name(), "Joven Club");
        map.put(Nl0yptXmjQ.Aporte_Patrimonio.name(), "Aporte Patrimonio");
        map.put(Nl0yptXmjQ.Ticket_Combustible_Gestion.name(), "Combustible");
        map.put(Nl0yptXmjQ.Ticket_MiBoleto_Gestion.name(), "MiBoleto");
        map.put(Nl0yptXmjQ.CajaExtra.name(), "Caja Extra");
        map.put(Nl0yptXmjQ.SelloTimbre.name(), "Sello de Timbre");
        map.put(Nl0yptXmjQ.RecargaCUPBolsa.name(), "Recarga CUP Bolsa");
        map.put(Nl0yptXmjQ.PaqueteMLC.name(), "Paquete MLC");
        map.put(Nl0yptXmjQ.RecargaNautaMLC.name(), "Recarga Nauta MLC");
        map.put(Nl0yptXmjQ.RecargaNautaHogar4G.name(), "Recarga Nauta Hogar 4G");
        map.put(Nl0yptXmjQ.GigasNautaHogare4G.name(), "Gigas Nauta Hogar 4G");
        map.put(Nl0yptXmjQ.VisitaRecorridos.name(), "Visitas-Recorridos");
        map.put(Nl0yptXmjQ.ReservasTicket.name(), "Mi Turno");
        try {
            return map.get(operationEntity.name());
        } catch (Exception e) {
            return "error";
        }
    }

    public o3etZ8qrxr(List<FlNVShJWtm> operaciones) {
        generarLeyenda(operaciones, true);
    }

    public o3etZ8qrxr(List<FlNVShJWtm> operaciones, boolean desgloceMoneda) {
        generarLeyenda(operaciones, desgloceMoneda);
    }

    private void generarLeyenda(List<FlNVShJWtm> operaciones, boolean conMoneda) {
        this.operacionesPojos = operaciones;
        this.leyenda = new ArrayList();
        this.ordenOperaciones.clear();
        Map<Nl0yptXmjQ, List<FlNVShJWtm>> operacionesPorTipo = new HashMap<>();
        for (FlNVShJWtm operacion : this.operacionesPojos) {
            Nl0yptXmjQ key = operacion.getOperacion();
            if (!operacionesPorTipo.containsKey(key)) {
                operacionesPorTipo.put(key, new ArrayList<>());
            }
            operacionesPorTipo.get(key).add(operacion);
        }
        for (FlNVShJWtm operacion2 : this.operacionesPojos) {
            operacion2.getOperacion();
            if (!operationExistInLeyenda(operacion2, conMoneda)) {
                tGolNOl3DN itemLeyenda = new tGolNOl3DN();
                itemLeyenda.setColor(getColor(operacion2.getOperacion()));
                if (conMoneda) {
                    itemLeyenda.setLeyenda(getStringOperacionByEnum(operacion2.getOperacion()) + " " + operacion2.getTipoMoneda());
                } else {
                    itemLeyenda.setLeyenda(getStringOperacionByEnum(operacion2.getOperacion()));
                }
                itemLeyenda.setOperacion_literal(operacion2.getTipo_operacion_string());
                itemLeyenda.setOperacion(operacion2.getOperacion());
                itemLeyenda.setMoneda(operacion2.getTipoMoneda());
                this.leyenda.add(itemLeyenda);
                if (!this.ordenOperaciones.contains(operacion2.getOperacion())) {
                    this.ordenOperaciones.add(operacion2.getOperacion());
                }
            }
        }
    }

    public boolean operationExistInLeyenda(FlNVShJWtm operacion, boolean conMoneda) {
        if (this.leyenda.isEmpty()) {
            return false;
        }
        for (tGolNOl3DN uyh0pxs9m37in : this.leyenda) {
            if (conMoneda) {
                if (uyh0pxs9m37in.getOperacion() == operacion.getOperacion() && uyh0pxs9m37in.getMoneda() == operacion.getTipoMoneda()) {
                    return true;
                }
            } else if (uyh0pxs9m37in.getOperacion() == operacion.getOperacion()) {
                return true;
            }
        }
        return false;
    }

    public List<FlNVShJWtm> getOperacionesPojos() {
        return this.operacionesPojos;
    }

    public List<tGolNOl3DN> getLeyenda() {
        return this.leyenda;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:89:0x014c  */
    public int getColor(Nl0yptXmjQ operationEntity) {
        switch (operationEntity.name()) {
            case "Pago_Factura_Telefonica":
                return Color.parseColor("#33B5E5");
            case "Recarga_Movil":
                return Color.parseColor("#AA66CC");
            case "Recarga_Nauta":
                return Color.parseColor("#99CC00");
            case "Pago_Telefono":
                return Color.parseColor("#FFBB33");
            case "Pago_Electricidad":
                return Color.parseColor("#FF4444");
            case "Pago_Agua":
                return Color.parseColor("#00796B");
            case "Transferencia":
                return Color.parseColor("#536DFE");
            case "Pago_ONAT":
                return Color.parseColor("#FFEB3B");
            case "Amortizacion":
                return Color.parseColor("#E91E63");
            case "Recarga_Movil_Banco":
                return Color.parseColor("#AA66CC");
            case "Pago_Gas":
                return Color.parseColor("#CC8B66");
            case "Recarga_Nauta_Banco":
                return Color.parseColor("#001489");
            case "Giro":
                return Color.parseColor("#CD5C5C");
            case "xf94v3SFEM":
                return Color.parseColor("#8FD500");
            case "Recarga_Propia":
                return Color.parseColor("#33B5E5");
            case "Recarga_Nauta_Hogar_Banco":
                return Color.parseColor("#1D3557");
            case "JClub":
                return Color.parseColor("#A8DADC");
            case "Aporte_Patrimonio":
                return Color.parseColor("#4D727C");
            case "Ticket_Combustible_Gestion":
                return Color.parseColor("#c78b00");
            case "CajaExtra":
                return Color.parseColor("#00c73c");
            case "SelloTimbre":
                return Color.parseColor("#d17c0a");
            case "RecargaCUPBolsa":
                return Color.parseColor("#d23918");
            case "PaqueteMLC":
                return Color.parseColor("#d0dd2a");
            case "RecargaNautaMLC":
                return Color.parseColor("#1ad910");
            case "RecargaNautaHogar4G":
                return Color.parseColor("#3B4BE8");
            case "GigasNautaHogare4G":
                return Color.parseColor("#1F1368");
            case "VisitaRecorridos":
                return Color.parseColor("#eab676");
            case "ReservasTicket":
                return Color.parseColor("#591ed9");
            default:
                return Color.parseColor("#FFFFFF");
        }
    }

    public List<SliceValue> getCantidadOperacionesPayMoneda(BXJNp1qv2n monedaEntity) {
        List<SliceValue> list = new ArrayList<>();
        for (tGolNOl3DN uyh0pxs9m37in : this.leyenda) {
            Nl0yptXmjQ e = uyh0pxs9m37in.getOperacion();
            float contador = 0.0f;
            for (FlNVShJWtm operacion : this.operacionesPojos) {
                if (operacion.getOperacion() == e && operacion.getTipoMoneda() == monedaEntity) {
                    contador += 1.0f;
                }
            }
            int color = getColor(e);
            if (contador > 0.0f) {
                SliceValue sl = new SliceValue(contador, color);
                list.add(sl);
            }
        }
        float valor = 0.0f;
        for (SliceValue l : list) {
            valor += l.getValue();
        }
        if (valor == 0.0f) {
            return null;
        }
        return list;
    }

    public List<SliceValue> getImporteOperacionesPayMoneda(BXJNp1qv2n monedaEntity) {
        List<SliceValue> list = new ArrayList<>();
        for (tGolNOl3DN uyh0pxs9m37in : this.leyenda) {
            Nl0yptXmjQ e = uyh0pxs9m37in.getOperacion();
            float importe = 0.0f;
            for (FlNVShJWtm operacion : this.operacionesPojos) {
                if (operacion.getOperacion() == e && operacion.getTipoMoneda() == monedaEntity) {
                    importe += operacion.getImporte();
                }
            }
            int color = getColor(e);
            if (importe > 0.0f) {
                SliceValue sl = new SliceValue(importe, color);
                list.add(sl);
            }
        }
        float valor = 0.0f;
        for (SliceValue l : list) {
            valor += l.getValue();
        }
        if (valor == 0.0f) {
            return null;
        }
        return list;
    }
}
