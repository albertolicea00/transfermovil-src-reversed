package cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK;

import android.util.Log;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraPlanesCubacel;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.OfertasBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.PromoSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TCTicket;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.TMonedasWallet;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class g0xM9kQCsqu {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) g0xM9kQCsqu.class);
    public String numero_telefonico = BuildConfig.FLAVOR;
    public String version = BuildConfig.FLAVOR;
    public String code_agent = BuildConfig.FLAVOR;
    public String code_bank = BuildConfig.FLAVOR;
    public String code_bulevar = BuildConfig.FLAVOR;
    public String code_boleto = BuildConfig.FLAVOR;

    public String getCode_bulevar() {
        return this.code_bulevar;
    }

    public String getCode_boleto() {
        return this.code_boleto;
    }

    public String getCode_agent() {
        return this.code_agent;
    }

    public String getCode_bank() {
        return this.code_bank;
    }

    public String getVersion() {
        return this.version;
    }

    public String getNumero_telefonico() {
        return this.numero_telefonico;
    }

    public RecordSMS parse(rIgmgP6JXL sms_properties) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        String CONS_DATOS;
        String cadena;
        RecordSMS record = new RecordSMS();
        try {
            String sms = sms_properties.getBody();
            if (sms.contains("INFORMACION:")) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date today = new Date();
                Date diaPromo = new Date();
                try {
                    today = formatter.parse(formatter.format(today));
                    diaPromo = formatter.parse(formatter.format(sms_properties.getDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (today.equals(diaPromo)) {
                    String[] smsPromo = sms.split("INFORMACION:");
                    String sms2 = smsPromo[0];
                    String promo = smsPromo[1].trim();
                    PromoSMS smsSearch = unYp8VQThY.getInstance().getPromoSMS(promo);
                    if (smsSearch == null) {
                        PromoSMS promoSMS = new PromoSMS();
                        promoSMS.setMensaje(promo);
                        promoSMS.setHabilitado(true);
                        Date dayNow = new Date();
                        Calendar c = Calendar.getInstance();
                        c.setTime(dayNow);
                        c.add(5, 1);
                        Date datePlusNow = c.getTime();
                        promoSMS.setFecha_inicio(dayNow);
                        promoSMS.setFecha_fin(datePlusNow);
                        if (!promo.contains("Banco")) {
                            promoSMS.setTipo_promo(R1sDOSqZ2z.ETECSA);
                            promoSMS.setIcono_asociado(R.drawable.etecsa_logo);
                        } else if (promo.contains("Popular de Ahorros") || promo.contains("Popular de Ahorro")) {
                            promoSMS.setTipo_promo(R1sDOSqZ2z.BPA);
                            promoSMS.setIcono_asociado(R.drawable.banco_bpa_ico);
                        } else if (promo.contains("Bandec")) {
                            promoSMS.setTipo_promo(R1sDOSqZ2z.BANDEC);
                            promoSMS.setIcono_asociado(R.drawable.banco_bandec_ico);
                        } else if (promo.contains("Metropolitano")) {
                            promoSMS.setTipo_promo(R1sDOSqZ2z.Metropolitano);
                            promoSMS.setIcono_asociado(R.drawable.banco_metro_ico);
                        }
                        unYp8VQThY.getInstance().addPromoSMS(promoSMS);
                    }
                    sms = sms2;
                }
            }
            if (!sms.contains("Bolsa") && !sms.contains("Monedero") && (!sms.contains("Banco") || (!sms.contains("El pago") && !sms.contains("La Transferencia") && !sms.contains("La recarga se") && !sms.contains("La amortizacion de credito") && !sms.contains("Id Transaccion:") && !sms.contains("Giro Postal") && !sms.contains("Id Compra:") && !sms.contains("PIN de combustible") && !sms.contains("caja extra") && !sms.contains("turno")))) {
                if (sms.contains("ETECSA")) {
                    return parseAgentesTelecomWallet(sms);
                }
                if (sms.contains("La recarga se realizo con exito.")) {
                    String[] msg_separate = sms.split(" ");
                    record.setMonto(msg_separate[9]);
                    record.setMoneda(msg_separate[10].substring(0, 3));
                    record.setCuenta(msg_separate[16].substring(0, msg_separate[16].length() - 1));
                    record.setIdTransaccion(msg_separate[19].substring(0, msg_separate[19].length() - 1));
                    record.setServicio("Recarga Móvil");
                    record.setTipo_servicio(KYTjPlWScT.Agentes);
                    record.setMostrar(true);
                    return record;
                }
                if (sms.contains("La recarga se realizo con exito,") && sms.contains("con bono adicional")) {
                    String[] msg_separate2 = sms.split(" ");
                    record.setMonto(msg_separate2[12]);
                    record.setMoneda(msg_separate2[13].substring(0, 3));
                    record.setCuenta(msg_separate2[19].substring(0, msg_separate2[19].length() - 1));
                    record.setIdTransaccion(msg_separate2[22].substring(0, msg_separate2[22].length() - 1));
                    record.setServicio("Recarga Móvil");
                    record.setTipo_servicio(KYTjPlWScT.Agentes);
                    record.setMostrar(true);
                    return record;
                }
                if (sms.contains("El pago de la factura del telefono") && sms.contains("esta siendo procesado")) {
                    String[] msg_separate3 = sms.split(" ");
                    record.setMonto(msg_separate3[12]);
                    msg_separate3[13].split(".");
                    record.setMoneda(msg_separate3[13].substring(0, 3));
                    record.setCuenta(msg_separate3[7]);
                    record.setIdTransaccion(msg_separate3[20].substring(0, msg_separate3[20].length() - 1));
                    record.setServicio("Pago Factura");
                    record.setTipo_servicio(KYTjPlWScT.Agentes);
                    record.setMostrar(true);
                    return record;
                }
                if (sms.contains("El pago de la factura del telefono") && sms.contains("fue exitoso")) {
                    String[] msg_separate4 = sms.split(" ");
                    record.setMonto(msg_separate4[11]);
                    record.setMoneda(msg_separate4[12].substring(0, 3));
                    record.setCuenta(msg_separate4[7]);
                    record.setIdTransaccion(msg_separate4[19].substring(0, msg_separate4[19].length() - 1));
                    record.setServicio("Pago Factura");
                    record.setTipo_servicio(KYTjPlWScT.Agentes);
                    record.setMostrar(true);
                    return record;
                }
                if (sms.contains("La cuenta") && sms.contains("ha sido recargada")) {
                    String[] msg_separate5 = sms.split(" ");
                    record.setIdTransaccion(msg_separate5[12]);
                    record.setCuenta(msg_separate5[3]);
                    record.setMonto(msg_separate5[8]);
                    record.setMoneda(msg_separate5[9].substring(0, 3));
                    record.setServicio("Recarga Nauta");
                    record.setTipo_servicio(KYTjPlWScT.Agentes);
                    record.setMostrar(true);
                    return record;
                }
                if (sms.contains("Actualizacion de los planes.")) {
                    try {
                        String CONS_DATOS2 = "Codigo;Descripcion;version";
                        String cadena2 = sms;
                        int intIndex = cadena2.indexOf("Codigo;Descripcion;version");
                        int proximoElemento = "Codigo;Descripcion;version".length() + intIndex;
                        String cadenaRestante = cadena2.substring(proximoElemento).replace("\n", BuildConfig.FLAVOR).trim();
                        String[] elementos = cadenaRestante.split("\\|");
                        CompraPlanesCubacel listActual = unYp8VQThY.getInstance().getAllPaquetesLists().get(0);
                        if (sms_properties.getDate().after(listActual.getFecha())) {
                            boolean borrar = unYp8VQThY.getInstance().deleteAllPaquetes();
                            if (borrar) {
                                int length = elementos.length;
                                int i = 0;
                                while (i < length) {
                                    String uyh0pxs9m37in = elementos[i];
                                    if (uyh0pxs9m37in == null || uyh0pxs9m37in.trim().length() <= 0) {
                                        CONS_DATOS = CONS_DATOS2;
                                        cadena = cadena2;
                                    } else {
                                        CONS_DATOS = CONS_DATOS2;
                                        String[] itemList = uyh0pxs9m37in.trim().split(";");
                                        if (itemList != null) {
                                            cadena = cadena2;
                                            if (itemList.length == 3) {
                                                String codigo = itemList[0].trim();
                                                String descripcion = itemList[1].trim();
                                                String version = itemList[2].trim();
                                                procesarPlan(codigo, descripcion, version, sms_properties.getDate());
                                            }
                                        } else {
                                            cadena = cadena2;
                                        }
                                    }
                                    i++;
                                    CONS_DATOS2 = CONS_DATOS;
                                    cadena2 = cadena;
                                    intIndex = intIndex;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return record;
                }
                return null;
                return null;
            }
            if (!sms.contains("Id Compra:")) {
                if (sms.contains("Popular de Ahorros")) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                    sms = sms.substring("Banco Popular de Ahorros:  ".length());
                } else if (sms.contains("Popular de Ahorro")) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                    sms = sms.substring("Banco Popular de Ahorro:  ".length());
                } else if (sms.contains("Bandec")) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBANDEC);
                    sms = sms.substring("Banco Bandec:  ".length());
                } else if (sms.contains("Metropolitano")) {
                    record.setTipo_servicio(KYTjPlWScT.BancoMetro);
                    sms = sms.substring("Banco Metropolitano:  ".length());
                } else if (sms.contains("Bolsa Mi Transfer")) {
                    record.setTipo_servicio(KYTjPlWScT.BolsaEtecsa);
                    sms = sms.substring("Bolsa Mi Transfer:  ".length());
                } else if (sms.contains("Monedero Mi Transfer")) {
                    record.setTipo_servicio(KYTjPlWScT.BolsaEtecsa);
                    sms = sms.substring("Monedero Mi Transfer:  ".length());
                }
            }
            String[] msg_separate6 = sms.split(" ");
            if (sms.contains("El pago parcial de la factura telefonica fue completado")) {
                try {
                    record.setCuenta(msg_separate6[13]);
                    record.setMonto(msg_separate6[17]);
                    record.setMoneda(msg_separate6[18].substring(0, 3));
                    record.setIdTransaccion(msg_separate6[22]);
                    record.setServicio("Pago Teléfono(P)");
                    record.setMostrar(true);
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (sms.contains("El pago de la factura del agua fue completado.")) {
                record.setCuenta(msg_separate6[13]);
                record.setMonto(msg_separate6[17]);
                record.setMoneda(msg_separate6[18].substring(0, 3));
                record.setIdTransaccion(msg_separate6[22]);
                record.setServicio("Pago Agua");
                record.setMostrar(true);
            }
            if (sms.contains("La Transferencia fue completada.") && record.getTipo_servicio() != KYTjPlWScT.BolsaEtecsa) {
                String transaccionBanco = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String CONS_NO_TRANSACCION_BANCO = getElement("Beneficiario:", sms);
                String idSerie = CONS_NO_TRANSACCION_BANCO.replace(".", BuildConfig.FLAVOR);
                String importe = getElement("Monto:", sms);
                String valor = "Monto: " + importe;
                String moneda = getElement(valor, sms).substring(0, 3);
                record.setCuenta(idSerie.substring(0, 6) + "XXXXXX" + idSerie.substring(12, 16));
                record.setMonto(importe);
                record.setMoneda(moneda);
                record.setIdTransaccion(transaccionBanco);
                record.setServicio("Transferencia");
                record.setMostrar(true);
            }
            if (sms.contains("La Transferencia fue completada.") && record.getTipo_servicio() == KYTjPlWScT.BolsaEtecsa) {
                String transaccionBanco2 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie2 = getElement("Beneficiario:", sms).replace(".", BuildConfig.FLAVOR);
                String importe2 = getElement("Monto:", sms);
                String valor2 = "Monto: " + importe2;
                String moneda2 = getElement(valor2, sms).substring(0, 3);
                record.setCuenta(idSerie2);
                record.setMonto(importe2);
                record.setMoneda(moneda2);
                record.setIdTransaccion(transaccionBanco2);
                record.setServicio("Transferencia");
                record.setMostrar(true);
            }
            if (sms.contains("La recarga se realizo con exito.")) {
                String transaccionBanco3 = getElement("Id transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie3 = getElement("Telefono:", sms).replace(".", BuildConfig.FLAVOR);
                String importe3 = getElement("Saldo acreditado:", sms);
                String valor3 = "Saldo acreditado: " + importe3;
                String moneda3 = getElement(valor3, sms).substring(0, 3);
                record.setCuenta(idSerie3);
                record.setMonto(importe3);
                record.setMoneda(moneda3);
                record.setIdTransaccion(transaccionBanco3);
                record.setServicio("Recarga de Saldo Móvil");
                record.setMostrar(true);
            } else if (sms.contains("La recarga se realizo con exito,") && sms.contains("con bono adicional")) {
                String transaccionBanco4 = getElement("Id transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie4 = getElement("Telefono:", sms).replace(".", BuildConfig.FLAVOR);
                String importe4 = getElement("Saldo acreditado:", sms);
                String valor4 = "Saldo acreditado: " + importe4;
                String moneda4 = getElement(valor4, sms).substring(0, 3);
                record.setCuenta(idSerie4);
                record.setMonto(importe4);
                record.setMoneda(moneda4);
                record.setIdTransaccion(transaccionBanco4);
                record.setServicio("Recarga de Saldo Móvil");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura del Gas fue completado.")) {
                String transaccionBanco5 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie5 = getElement("Nro. Factura Pagada:", sms).replace(".", BuildConfig.FLAVOR);
                String importe5 = getElement("Importe Pagado:", sms);
                String valor5 = "Importe Pagado: " + importe5;
                String CONS_IMPORTE = getElement(valor5, sms);
                String moneda5 = CONS_IMPORTE.substring(0, 3);
                record.setCuenta(idSerie5);
                record.setMonto(importe5);
                record.setMoneda(moneda5);
                record.setIdTransaccion(transaccionBanco5);
                record.setServicio("Pago Gas");
                record.setMostrar(true);
            }
            if (!sms.contains("Pago completado.") || !sms.contains("Id Compra:")) {
                charSequence = r10;
                charSequence2 = r5;
                charSequence3 = r6;
                charSequence4 = r8;
                charSequence5 = r7;
            } else {
                charSequence5 = "Popular de Ahorro";
                if (sms.contains(charSequence5)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                    charSequence = "Monedero Mi Transfer";
                    charSequence2 = "Metropolitano";
                    charSequence3 = "Bandec";
                    charSequence4 = "Popular de Ahorros";
                } else {
                    charSequence4 = r8;
                    if (sms.contains(charSequence4)) {
                        record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                        charSequence = r10;
                        charSequence2 = r5;
                        charSequence3 = r6;
                    } else {
                        charSequence3 = r6;
                        if (sms.contains(charSequence3)) {
                            record.setTipo_servicio(KYTjPlWScT.BancoBANDEC);
                            charSequence = r10;
                            charSequence2 = r5;
                        } else {
                            charSequence2 = r5;
                            if (sms.contains(charSequence2)) {
                                record.setTipo_servicio(KYTjPlWScT.BancoMetro);
                                charSequence = r10;
                            } else if (sms.contains(charSequence)) {
                                charSequence = r10;
                                record.setTipo_servicio(KYTjPlWScT.BolsaEtecsa);
                            }
                        }
                    }
                }
                charSequence = r10;
                String transaccion = getElement("No. Transaccion:", sms);
                String idcompra = getElement("Id Compra:", sms);
                String importe6 = getElement("Importe: ", sms);
                String valor6 = "Importe: " + importe6;
                String moneda6 = getElement(valor6, sms);
                record.setCuenta(idcompra);
                record.setMonto(importe6);
                record.setMoneda(moneda6);
                record.setIdTransaccion(transaccion);
                record.setServicio("Compra en linea");
                record.setMostrar(true);
            }
            if (sms.contains("se realizo con exito.") && sms.contains("recarga de la tarjeta propia")) {
                if (sms.contains(charSequence5) || sms.contains(charSequence4)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                } else if (sms.contains(charSequence3)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBANDEC);
                } else if (sms.contains(charSequence2)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoMetro);
                } else if (sms.contains(charSequence)) {
                    record.setTipo_servicio(KYTjPlWScT.BolsaEtecsa);
                }
                String transaccion2 = getElement("Id Transaccion:", sms);
                String idcompra2 = getElement("Nro. Serie Tarjeta :", sms);
                String importe7 = getElement("Importe Recargado :", sms);
                String valor7 = "Importe Recargado :" + importe7;
                String moneda7 = getElement(valor7, sms).substring(0, 3);
                record.setCuenta(idcompra2);
                record.setMonto(importe7);
                record.setMoneda(moneda7);
                record.setIdTransaccion(transaccion2);
                record.setServicio("Recarga Propia");
                record.setMostrar(true);
            }
            if (sms.contains("caja extra") && sms.contains("Pago completado: ")) {
                if (sms.contains(charSequence5) || sms.contains(charSequence4)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBPA);
                } else if (sms.contains(charSequence3)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoBANDEC);
                } else if (sms.contains(charSequence2)) {
                    record.setTipo_servicio(KYTjPlWScT.BancoMetro);
                } else if (sms.contains("Bolsa Mi Transfer") || sms.contains(charSequence)) {
                    record.setTipo_servicio(KYTjPlWScT.BolsaEtecsa);
                }
                String transaccion3 = getElement("No. Transaccion:", sms);
                String idcompra3 = getElement("Id Negocio:", sms);
                String importe8 = getElement("Importe pagado: ", sms);
                String valor8 = "Importe pagado: " + importe8;
                String moneda8 = getElement(valor8, sms);
                record.setCuenta(idcompra3);
                record.setMonto(importe8);
                record.setMoneda(moneda8);
                record.setIdTransaccion(transaccion3);
                record.setServicio("Caja Extra");
                record.setMostrar(true);
            }
            if (sms.contains("Giro Postal fue completado.")) {
                record.setCuenta(msg_separate6[34]);
                record.setMonto(msg_separate6[50]);
                record.setMoneda(msg_separate6[51].substring(0, 3));
                record.setIdTransaccion(msg_separate6[56]);
                record.setServicio("Giro postal");
                record.setMostrar(true);
            }
            if (sms.contains("La cuenta Nauta Hogar:") && sms.contains("ha sido pagada con")) {
                String transaccion4 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra4 = getElement("Nauta Hogar:", sms);
                String importe9 = getElement("pagada con", sms);
                String valor9 = "pagada con " + importe9;
                String moneda9 = getElement(valor9, sms).substring(0, 3);
                record.setCuenta(idcompra4);
                record.setMonto(importe9);
                record.setMoneda(moneda9);
                record.setIdTransaccion(transaccion4);
                record.setServicio("Nauta Hogar");
                record.setMostrar(true);
            }
            if (sms.contains("La cuenta :") && sms.contains("ha sido recargada con")) {
                String transaccionBanco6 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie6 = getElement("La cuenta :", sms).replace(".", BuildConfig.FLAVOR);
                String importe10 = getElement("ha sido recargada con", sms);
                String valor10 = "ha sido recargada con " + importe10;
                String moneda10 = getElement(valor10, sms).substring(0, 3);
                record.setCuenta(idSerie6);
                record.setMonto(importe10);
                record.setMoneda(moneda10);
                record.setIdTransaccion(transaccionBanco6);
                record.setServicio("Recarga nauta banco");
                record.setMostrar(true);
            }
            if (sms.contains("La cuenta de Joven Club del usuario:") && sms.contains("ha sido recargada")) {
                String transaccion5 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra5 = getElement("Joven Club del usuario:", sms);
                String importe11 = getElement("ha sido recargada con", sms);
                String valor11 = "ha sido recargada con " + importe11;
                String moneda11 = getElement(valor11, sms).substring(0, 3);
                record.setCuenta(idcompra5);
                record.setMonto(importe11);
                record.setMoneda(moneda11);
                record.setIdTransaccion(transaccion5);
                record.setServicio("Joven Club");
                record.setMostrar(true);
            }
            if (sms.contains("La amortizacion") && sms.contains("fue completada")) {
                String transaccion6 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra6 = "No. " + transaccion6;
                String importe12 = getElement("Monto Pagado:", sms);
                String valor12 = "Monto Pagado: " + importe12;
                String moneda12 = getElement(valor12, sms).substring(0, 3);
                record.setCuenta(idcompra6);
                record.setMonto(importe12);
                record.setMoneda(moneda12);
                record.setIdTransaccion(transaccion6);
                record.setServicio("Amortizar");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la ONAT fue completado") && sms.contains("RC05:")) {
                String transaccion7 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra7 = getElement("RC05:", sms);
                String importe13 = getElement("Monto Pagado:", sms);
                String rc04 = getElement("RC04:", sms);
                String valor13 = "Monto Pagado: " + importe13;
                String CONS_ID_COMPRA = getElement(valor13, sms);
                String moneda13 = CONS_ID_COMPRA.substring(0, 3);
                record.setCuenta("RC05: " + idcompra7);
                record.setMonto(importe13);
                record.setMoneda(moneda13);
                record.setIdTransaccion(transaccion7 + " RC04:" + rc04);
                record.setServicio("Pago ONAT");
                record.setMostrar(true);
            } else if (sms.contains("El pago de la ONAT fue completado") && sms.contains("NIT:")) {
                String transaccion8 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra8 = getElement("NIT:", sms);
                String importe14 = getElement("Monto Pagado:", sms);
                String parrafo = getElement("PARRAFO:", sms);
                String valor14 = "Monto Pagado: " + importe14;
                String CONS_ID_COMPRA2 = getElement(valor14, sms);
                String moneda14 = CONS_ID_COMPRA2.substring(0, 3);
                record.setCuenta("NIT:" + idcompra8);
                record.setMonto(importe14);
                record.setMoneda(moneda14);
                record.setIdTransaccion(transaccion8 + " PR:" + parrafo);
                record.setServicio("Pago ONAT");
                record.setMostrar(true);
            } else if (sms.contains("El pago de la ONAT fue completado")) {
                record.setCuenta(msg_separate6[12]);
                record.setMonto(msg_separate6[16]);
                record.setMoneda(msg_separate6[17].substring(0, 3));
                record.setIdTransaccion(msg_separate6[21]);
                record.setServicio("Pago ONAT");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la multa fue completado.")) {
                String transaccion9 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra9 = getElement("Nro. Multa:", sms);
                String importe15 = getElement("Monto Pagado:", sms);
                String valor15 = "Monto Pagado: " + importe15;
                String moneda15 = getElement(valor15, sms).substring(0, 3);
                record.setCuenta(idcompra9);
                record.setMonto(importe15);
                record.setMoneda(moneda15);
                record.setIdTransaccion(transaccion9);
                record.setServicio("Pago de Multa");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura telefonica fue completado") && sms.contains("Importe Factura:")) {
                String transaccion10 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra10 = getElement("Nro. Factura Pagada:", sms);
                String importe16 = getElement("Monto Pagado:", sms);
                String valor16 = "Monto Pagado: " + importe16;
                String moneda16 = getElement(valor16, sms).substring(0, 3);
                record.setCuenta(idcompra10);
                record.setMonto(importe16);
                record.setMoneda(moneda16);
                record.setIdTransaccion(transaccion10);
                record.setServicio("Pago Teléfono(T)");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura telefonica fue completado") && sms.contains("Importe Factura:")) {
                String transaccion11 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra11 = getElement("Nro. Factura Pagada:", sms);
                String importe17 = getElement("Importe Factura:", sms);
                String valor17 = "Importe Factura: " + importe17;
                String moneda17 = getElement(valor17, sms).substring(0, 3);
                record.setCuenta(idcompra11);
                record.setMonto(importe17);
                record.setMoneda(moneda17);
                record.setIdTransaccion(transaccion11);
                record.setServicio("Pago Teléfono(T)");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura telefonica fue completado") && sms.contains("Monto Pagado:")) {
                String transaccion12 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra12 = getElement("Nro. Factura Pagada:", sms);
                String importe18 = getElement("Monto Pagado:", sms);
                String valor18 = "Monto Pagado: " + importe18;
                String moneda18 = getElement(valor18, sms).substring(0, 3);
                record.setCuenta(idcompra12);
                record.setMonto(importe18);
                record.setMoneda(moneda18);
                record.setIdTransaccion(transaccion12);
                record.setServicio("Pago Teléfono(T)");
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura de electricidad fue completado")) {
                String transaccion13 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra13 = getElement("Nro. Factura Pagada:", sms);
                String importe19 = getElement("Importe Pagado:", sms);
                String valor19 = "Importe Pagado: " + importe19;
                String moneda19 = getElement(valor19, sms).substring(0, 3);
                record.setCuenta(idcompra13);
                record.setMonto(importe19);
                record.setMoneda(moneda19);
                record.setIdTransaccion(transaccion13);
                record.setServicio("Pago Electricidad");
                record.setMostrar(true);
            }
            if (sms.contains("El pago del aporte a patrimonio fue completado.")) {
                String transaccion14 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR).replace(",", BuildConfig.FLAVOR);
                String idcompra14 = getElement("Nro. Contribuyente:", sms).replace(",", BuildConfig.FLAVOR);
                String importe20 = getElement("Monto Pagado:", sms);
                String valor20 = "Monto Pagado: " + importe20;
                String moneda20 = getElement(valor20, sms).substring(0, 3);
                record.setCuenta(idcompra14);
                record.setMonto(importe20);
                record.setMoneda(moneda20);
                record.setIdTransaccion(transaccion14);
                record.setServicio("Aporte Patrimonio");
                record.setMostrar(true);
            }
            if (sms.contains("pago del cupon de combustible fue completado.")) {
                getElement("ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                String transaccionBanco7 = getElement("No. Transaccion :", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie7 = getElement("No. Serie:", sms).replace(".", BuildConfig.FLAVOR);
                String importe21 = getElement("Importe pagado:", sms);
                String valor21 = "Importe pagado: " + importe21;
                String CONS_NO_TRANSACCION_TM = getElement(valor21, sms);
                String moneda21 = CONS_NO_TRANSACCION_TM.substring(0, 3);
                getElement("Datos del cupon:", sms);
                record.setCuenta(idSerie7);
                record.setMonto(importe21);
                record.setMoneda(moneda21);
                record.setIdTransaccion(transaccionBanco7);
                record.setServicio("Combustible");
                record.setMostrar(true);
            }
            if (sms.contains("pago del impuesto sobre el documento (sello del timbre) fue completado.")) {
                String transaccionBanco8 = getElement("Nro. Transaccion Banco:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie8 = getElement(" IdSello:", sms).replace(".", BuildConfig.FLAVOR);
                String importe22 = getElement("Importe Pagado:", sms);
                String valor22 = "Importe Pagado: " + importe22;
                String moneda22 = getElement(valor22, sms).substring(0, 3);
                record.setCuenta(idSerie8);
                record.setMonto(importe22);
                record.setMoneda(moneda22);
                record.setIdTransaccion(transaccionBanco8);
                record.setServicio("Sello de Timbre");
                record.setMostrar(true);
            }
            if (sms.contains("La recarga de la cuenta CUP se realizo con exito")) {
                String transaccionBanco9 = getElement("Id Monedero:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie9 = getElement("cuenta recargada:", sms).replace(".", BuildConfig.FLAVOR);
                String importe23 = getElement("Importe Recargado:", sms);
                String valor23 = "Importe Recargado: " + importe23;
                String moneda23 = getElement(valor23, sms).substring(0, 3);
                record.setCuenta(idSerie9);
                record.setMonto(importe23);
                record.setMoneda(moneda23);
                record.setIdTransaccion(transaccionBanco9);
                record.setServicio("Recarga CUP Monedero");
                record.setMostrar(true);
            }
            if (sms.contains("La recarga de la cuenta CUP se realizo con exito")) {
                String transaccionBanco10 = getElement("Id Monedero:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie10 = getElement("monedero recargada:", sms).replace(".", BuildConfig.FLAVOR);
                String importe24 = getElement("Importe Recargado:", sms);
                String valor24 = "Importe Recargado: " + importe24;
                String moneda24 = getElement(valor24, sms).substring(0, 3);
                record.setCuenta(idSerie10);
                record.setMonto(importe24);
                record.setMoneda(moneda24);
                record.setIdTransaccion(transaccionBanco10);
                record.setServicio("Recarga CUP Monedero");
                record.setMostrar(true);
            }
            if (sms.contains("La compra del Paquete MLC para el numero") && sms.contains("se realizo con exito.")) {
                String transaccionBanco11 = getElement("Id transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie11 = getElement("Paquete comprado:", sms).replace(".", BuildConfig.FLAVOR);
                String importe25 = getElement("Saldo Descontado:", sms);
                String valor25 = "Saldo Descontado: " + importe25;
                String moneda25 = getElement(valor25, sms).substring(0, 3);
                record.setCuenta(idSerie11);
                record.setMonto(importe25);
                record.setMoneda(moneda25);
                record.setIdTransaccion(transaccionBanco11);
                record.setServicio("Paquete MLC");
                record.setMostrar(true);
            }
            if (sms.contains("Ha comprado con") && sms.contains("para su uso la oferta Nauta Plus.")) {
                String transaccionBanco12 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie12 = getElement("el producto", sms).replace(".", BuildConfig.FLAVOR);
                String importe26 = getElement("Ha comprado con", sms);
                String valor26 = "Ha comprado con " + importe26;
                String moneda26 = getElement(valor26, sms).substring(0, 3);
                record.setCuenta("producto " + idSerie12);
                record.setMonto(importe26);
                record.setMoneda(moneda26);
                record.setIdTransaccion(transaccionBanco12);
                record.setServicio("Recarga Nauta MLC");
                record.setMostrar(true);
            }
            if (sms.contains("La recarga del numero de servicio") && sms.contains("se realizo con exito.")) {
                String transaccionBanco13 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie13 = getElement("Nauta Hogar 4G", sms).replace(".", BuildConfig.FLAVOR);
                String importe27 = getElement("Importe Pagado:", sms);
                String valor27 = "Importe Pagado: " + importe27;
                String moneda27 = getElement(valor27, sms).substring(0, 3);
                record.setCuenta(idSerie13);
                record.setMonto(importe27);
                record.setMoneda(moneda27);
                record.setIdTransaccion(transaccionBanco13);
                record.setServicio("Recarga Nauta Hogar 4G");
                record.setMostrar(true);
            }
            if (sms.contains("La compra del Paquete para el numero de servicio Nauta Hogar 4G") && sms.contains("se realizo con exito.")) {
                String transaccionBanco14 = getElement("Id transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie14 = getElement("Nauta Hogar 4G", sms).replace(".", BuildConfig.FLAVOR);
                String importe28 = getElement("Costo del paquete:", sms);
                String valor28 = "Costo del paquete: " + importe28;
                String moneda28 = getElement(valor28, sms).substring(0, 3);
                record.setCuenta(idSerie14);
                record.setMonto(importe28);
                record.setMoneda(moneda28);
                record.setIdTransaccion(transaccionBanco14);
                record.setServicio("Gigas Nauta Hogar 4G");
                record.setMostrar(true);
            }
            try {
                if (sms.contains("Visita:") && sms.contains("La compra fue completada.")) {
                    String transaccionBanco15 = getElement("Transaccion de Banco:", sms).replace(".", BuildConfig.FLAVOR);
                    String idSerie15 = getElement("Nro. de Reserva:", sms).replace(".", BuildConfig.FLAVOR);
                    String importe29 = getElement("Importe Pagado:", sms);
                    String valor29 = "Importe Pagado: " + importe29;
                    String moneda29 = getElement(valor29, sms).substring(0, 3);
                    record.setCuenta(idSerie15);
                    record.setMonto(importe29);
                    record.setMoneda(moneda29);
                    record.setIdTransaccion(transaccionBanco15);
                    record.setServicio("Visitas-Recorridos");
                    record.setMostrar(true);
                }
            } catch (Exception e4) {
            }
            try {
                if (sms.contains("La solicitud de Turno") && sms.contains("fue completada.")) {
                    String transaccionBanco16 = getElement("Nro. Transaccion de Banco:", sms).replace(".", BuildConfig.FLAVOR);
                    String idSerie16 = getElement("Carnet de Identidad:", sms).replace(".", BuildConfig.FLAVOR);
                    String importe30 = getElement("Comision Pagada:", sms);
                    String valor30 = "Comision Pagada: " + importe30;
                    String moneda30 = getElement(valor30, sms).substring(0, 3);
                    record.setCuenta(idSerie16);
                    record.setMonto(importe30);
                    record.setMoneda(moneda30);
                    record.setIdTransaccion(transaccionBanco16);
                    record.setServicio("Mi Turno");
                    record.setMostrar(true);
                }
            } catch (Exception e5) {
            }
            if (sms.contains("La actualizacion de las cuentas virtuales fue completada.")) {
                parseMonedasWallet(sms);
                return record;
            }
            return record;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public void parseMonedasWallet(String sms) {
        String data = getElement("Informacion:", sms);
        String transaccionBanco = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
        String transaccionTM = getElement("ID TM:", sms).replace(".", BuildConfig.FLAVOR);
        byte[] bArr = new byte[0];
        try {
            byte[] salt = transaccionBanco.getBytes("UTF-8");
            try {
                String vSer = V5FFEZ0Qrr0.decryptMonedasWallet(data, transaccionTM, salt, 2);
                if (vSer != null) {
                    try {
                        String[] list = vSer.split("\\|");
                        boolean deleted = unYp8VQThY.getInstance().deleteMonedasWallet();
                        if (deleted) {
                            TMonedasWallet mon = new TMonedasWallet();
                            mon.setId("1");
                            mon.setDescripcion("Cuenta USD");
                            mon.setCurrency("USD");
                            mon.setFecha(new Date());
                            mon.setAllowTransfer(1);
                            unYp8VQThY.getInstance().addMonedasWallet(mon);
                            mon.setId("2");
                            mon.setDescripcion("Cuenta CUP");
                            mon.setCurrency("CUP");
                            mon.setFecha(new Date());
                            mon.setAllowTransfer(1);
                            unYp8VQThY.getInstance().addMonedasWallet(mon);
                            mon.setId("-MIS CUENTAS-");
                            mon.setDescripcion("-MIS CUENTAS-");
                            mon.setCurrency("-MIS CUENTAS-");
                            mon.setFecha(new Date());
                            mon.setAllowTransfer(1);
                            unYp8VQThY.getInstance().addMonedasWallet(mon);
                            int length = list.length;
                            int i = 0;
                            while (i < length) {
                                String moneda = list[i];
                                String[] uyh0pxs9m37in = moneda.split(";");
                                int i2 = length;
                                if (uyh0pxs9m37in.length == 4) {
                                    TMonedasWallet mon2 = new TMonedasWallet();
                                    mon2.setId(uyh0pxs9m37in[0]);
                                    mon2.setDescripcion(uyh0pxs9m37in[1]);
                                    mon2.setCurrency(uyh0pxs9m37in[2]);
                                    mon2.setAllowTransfer(Integer.parseInt(uyh0pxs9m37in[3]));
                                    mon2.setFecha(new Date());
                                    unYp8VQThY.getInstance().addMonedasWallet(mon2);
                                }
                                i++;
                                length = i2;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public RecordSMS parseAgentesTelecomWallet(String sms) {
        RecordSMS record = new RecordSMS();
        try {
            if (sms.contains("La recarga se realizo con exito.")) {
                String transaccionBanco = getElement("Id transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie = getElement("Telefono:", sms).replace(".", BuildConfig.FLAVOR);
                String importe = getElement("Saldo acreditado:", sms);
                String valor = "Saldo acreditado: " + importe;
                String moneda = getElement(valor, sms).substring(0, 3);
                record.setCuenta(idSerie);
                record.setMonto(importe);
                record.setMoneda(moneda);
                record.setIdTransaccion(transaccionBanco);
                record.setServicio("Recarga Móvil");
                record.setTipo_servicio(KYTjPlWScT.Agentes);
                record.setMostrar(true);
            }
            if (sms.contains("La cuenta Nauta Hogar:") && sms.contains("ha sido pagada con")) {
                String transaccion = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra = getElement("Nauta Hogar:", sms);
                String importe2 = getElement("pagada con", sms);
                String valor2 = "pagada con " + importe2;
                String CONS_NO_TRANSACCION = getElement(valor2, sms);
                String moneda2 = CONS_NO_TRANSACCION.substring(0, 3);
                record.setCuenta(idcompra);
                record.setMonto(importe2);
                record.setMoneda(moneda2);
                record.setIdTransaccion(transaccion);
                record.setServicio("Nauta Hogar");
                record.setTipo_servicio(KYTjPlWScT.Agentes);
                record.setMostrar(true);
            }
            if (sms.contains("La cuenta :") && sms.contains("ha sido recargada con")) {
                String transaccionBanco2 = getElement("Id Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idSerie2 = getElement("La cuenta :", sms).replace(".", BuildConfig.FLAVOR);
                String importe3 = getElement("ha sido recargada con", sms);
                String valor3 = "ha sido recargada con " + importe3;
                String moneda3 = getElement(valor3, sms).substring(0, 3);
                record.setCuenta(idSerie2);
                record.setMonto(importe3);
                record.setMoneda(moneda3);
                record.setIdTransaccion(transaccionBanco2);
                record.setServicio("Recarga Nauta");
                record.setTipo_servicio(KYTjPlWScT.Agentes);
                record.setMostrar(true);
            }
            if (sms.contains("El pago de la factura telefonica fue completado") && sms.contains("Monto Pagado:")) {
                String transaccion2 = getElement("Nro. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                String idcompra2 = getElement("Nro. Factura Pagada:", sms);
                String importe4 = getElement("Monto Pagado:", sms);
                String valor4 = "Monto Pagado: " + importe4;
                String moneda4 = getElement(valor4, sms).substring(0, 3);
                record.setCuenta(idcompra2);
                record.setMonto(importe4);
                record.setMoneda(moneda4);
                record.setIdTransaccion(transaccion2);
                record.setServicio("Factura Telefónica");
                record.setTipo_servicio(KYTjPlWScT.Agentes);
                record.setMostrar(true);
                return record;
            }
            return record;
        } catch (Exception e) {
            return null;
        }
    }

    public RecordSMS parseCombustible(rIgmgP6JXL sms_properties) {
        Date dateAux;
        RecordSMS record = new RecordSMS();
        try {
            String sms = sms_properties.getBody();
            char c = 1;
            char c2 = 3;
            try {
                if (sms.contains("cupon de combustible")) {
                    if (sms.contains("pago del cupon de combustible fue completado.")) {
                        try {
                            String transaccionTM = getElement("ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                            String transaccionBanco = getElement("No. Transaccion :", sms).replace(".", BuildConfig.FLAVOR);
                            String idSerie = getElement("No. Serie:", sms).replace(".", BuildConfig.FLAVOR);
                            String importe = getElement("Importe pagado:", sms);
                            String valor = "Importe pagado: " + importe;
                            String moneda = getElement(valor, sms).substring(0, 3);
                            String data = getElement("Datos del cupon:", sms);
                            record.setCuenta(idSerie);
                            record.setMonto(importe);
                            record.setMoneda(moneda);
                            record.setIdTransaccion(transaccionBanco);
                            record.setServicio("Combustible");
                            record.setMostrar(true);
                            unYp8VQThY.getInstance().addRecordSMS(record);
                            if (unYp8VQThY.getInstance().getTCombustible(idSerie).size() == 0) {
                                TCTicket ticket = new TCTicket();
                                ticket.setIdTM(transaccionTM);
                                ticket.setIdBank(transaccionBanco);
                                ticket.setSerie(idSerie);
                                ticket.setImporte(Float.parseFloat(importe));
                                ticket.setMoneda(moneda);
                                ticket.setConsumido(false);
                                ticket.setData(data);
                                ticket.setFecha(sms_properties.getDate());
                                unYp8VQThY.getInstance().addTCTicket(ticket);
                            }
                            record = record;
                        } catch (Exception e) {
                            return null;
                        }
                    } else if (sms.contains("Actualizado el token del cupon de combustible con")) {
                        String transaccionTM2 = getElement("ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                        String transaccionBanco2 = getElement("No. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                        String idSerie2 = getElement("No.Serie:", sms).replace(".", BuildConfig.FLAVOR);
                        String importe2 = getElement("Saldo actual:", sms);
                        String valor2 = "Saldo actual: " + importe2;
                        String moneda2 = getElement(valor2, sms).substring(0, 3);
                        String data2 = getElement("Datos del cupon:", sms);
                        List<TCTicket> ticketList = unYp8VQThY.getInstance().getTCombustible(idSerie2);
                        if (ticketList.size() > 0) {
                            TCTicket ticket2 = ticketList.get(0);
                            Date smsInboxDate = sms_properties.getDate();
                            Date dateCupon = ticket2.getFecha();
                            dateCupon.compareTo(smsInboxDate);
                            Date smsInboxDate2 = ticket2.getFecha();
                            Date dateCupon2 = sms_properties.getDate();
                            if (smsInboxDate2.compareTo(dateCupon2) < 0) {
                                ticket2.setImporte(Float.parseFloat(importe2));
                                ticket2.setData(data2);
                                ticket2.setIdBank(transaccionBanco2);
                                ticket2.setIdTM(transaccionTM2);
                                ticket2.setFecha(sms_properties.getDate());
                                ticket2.setDeleted(false);
                                unYp8VQThY.getInstance().updateTCTicket(ticket2);
                            }
                        } else {
                            TCTicket ticketNuevo = new TCTicket();
                            ticketNuevo.setIdTM(transaccionTM2);
                            ticketNuevo.setIdBank(transaccionBanco2);
                            ticketNuevo.setSerie(idSerie2);
                            ticketNuevo.setImporte(Float.parseFloat(importe2));
                            ticketNuevo.setMoneda(moneda2);
                            ticketNuevo.setConsumido(false);
                            ticketNuevo.setData(data2);
                            ticketNuevo.setFecha(sms_properties.getDate());
                            unYp8VQThY.getInstance().addTCTicket(ticketNuevo);
                        }
                    } else {
                        record = record;
                        if (sms.contains("Estado del cupon de combustible con")) {
                            String transaccionTM3 = getElement("ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                            String transaccionBanco3 = getElement("No. Transaccion:", sms).replace(".", BuildConfig.FLAVOR);
                            String idSerie3 = getElement("No.Serie:", sms).replace(".", BuildConfig.FLAVOR);
                            String importe3 = getElement("Saldo actual:", sms);
                            String valor3 = "Saldo actual: " + importe3;
                            String moneda3 = getElement(valor3, sms).substring(0, 3);
                            String data3 = getElement("Datos del cupon:", sms);
                            List<TCTicket> ticketList2 = unYp8VQThY.getInstance().getTCombustible(idSerie3);
                            if (ticketList2.size() > 0) {
                                TCTicket ticket3 = ticketList2.get(0);
                                new Date();
                                Calendar c3 = Calendar.getInstance();
                                c3.setTime(ticket3.getFecha());
                                Date smsInboxDate3 = sms_properties.getDate();
                                Date dateCupon3 = ticket3.getFecha();
                                dateCupon3.compareTo(smsInboxDate3);
                                Date smsInboxDate4 = ticket3.getFecha();
                                Date dateCupon4 = sms_properties.getDate();
                                if (smsInboxDate4.compareTo(dateCupon4) < 0) {
                                    ticket3.setImporte(Float.parseFloat(importe3));
                                    ticket3.setData(data3);
                                    ticket3.setIdBank(transaccionBanco3);
                                    ticket3.setIdTM(transaccionTM3);
                                    ticket3.setFecha(sms_properties.getDate());
                                    ticket3.setDeleted(false);
                                    unYp8VQThY.getInstance().updateTCTicket(ticket3);
                                }
                            } else {
                                TCTicket ticketNuevo2 = new TCTicket();
                                ticketNuevo2.setIdTM(transaccionTM3);
                                ticketNuevo2.setIdBank(transaccionBanco3);
                                ticketNuevo2.setSerie(idSerie3);
                                ticketNuevo2.setImporte(Float.parseFloat(importe3));
                                ticketNuevo2.setMoneda(moneda3);
                                ticketNuevo2.setConsumido(false);
                                ticketNuevo2.setData(data3);
                                ticketNuevo2.setFecha(sms_properties.getDate());
                                unYp8VQThY.getInstance().addTCTicket(ticketNuevo2);
                            }
                        } else if (sms.contains("ha realizado una devolucion al cupon de combustible con")) {
                            String transaccionTM4 = getElement(", ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                            String transaccionBanco4 = getElement("No. Transaccion: ", sms).replace(".", BuildConfig.FLAVOR);
                            String idSerie4 = getElement("No. Serie:", sms).replace(".", BuildConfig.FLAVOR);
                            String importe4 = getElement("Importe acreditado:", sms);
                            String valor4 = "Importe acreditado: " + importe4;
                            String moneda4 = getElement(valor4, sms).substring(0, 3);
                            String data4 = getElement("Datos del cupon:", sms);
                            List<TCTicket> ticketList3 = unYp8VQThY.getInstance().getTCombustible(idSerie4);
                            if (ticketList3.size() > 0) {
                                TCTicket ticket4 = ticketList3.get(0);
                                new Date();
                                Calendar c4 = Calendar.getInstance();
                                c4.setTime(ticket4.getFecha());
                                Date smsInboxDate5 = sms_properties.getDate();
                                Date dateCupon5 = ticket4.getFecha();
                                dateCupon5.compareTo(smsInboxDate5);
                                Date smsInboxDate6 = ticket4.getFecha();
                                Date dateCupon6 = sms_properties.getDate();
                                if (smsInboxDate6.compareTo(dateCupon6) < 0) {
                                    ticket4.setImporte(Float.parseFloat(importe4));
                                    ticket4.setData(data4);
                                    ticket4.setIdBank(transaccionBanco4);
                                    ticket4.setIdTM(transaccionTM4);
                                    ticket4.setFecha(sms_properties.getDate());
                                    ticket4.setDeleted(false);
                                    unYp8VQThY.getInstance().updateTCTicket(ticket4);
                                }
                            } else {
                                TCTicket ticketNuevo3 = new TCTicket();
                                ticketNuevo3.setIdTM(transaccionTM4);
                                ticketNuevo3.setIdBank(transaccionBanco4);
                                ticketNuevo3.setSerie(idSerie4);
                                ticketNuevo3.setImporte(Float.parseFloat(importe4));
                                ticketNuevo3.setMoneda(moneda4);
                                ticketNuevo3.setConsumido(false);
                                ticketNuevo3.setData(data4);
                                ticketNuevo3.setFecha(sms_properties.getDate());
                                unYp8VQThY.getInstance().addTCTicket(ticketNuevo3);
                            }
                        }
                    }
                } else {
                    record = record;
                    if (sms.contains("Mis cupones de combustible")) {
                        try {
                            int intIndex = sms.indexOf("No.Serie;Saldo actual;Importe pagado;Moneda;ID Banco;ID TM;Fecha;Banco;DatosCupon ");
                            int proximoElemento = intIndex + "No.Serie;Saldo actual;Importe pagado;Moneda;ID Banco;ID TM;Fecha;Banco;DatosCupon ".length();
                            String cadenaRestante = sms.substring(proximoElemento).replace("\n", " ");
                            String[] elementos = cadenaRestante.trim().split(" ");
                            int length = elementos.length;
                            int i = 0;
                            while (i < length) {
                                String uyh0pxs9m37in = elementos[i];
                                if (uyh0pxs9m37in != null && uyh0pxs9m37in.length() > 0) {
                                    String[] itemList = uyh0pxs9m37in.split(";");
                                    if (itemList != null && itemList.length == 9) {
                                        String serie = itemList[0];
                                        String importe5 = itemList[c];
                                        String moneda5 = itemList[c2];
                                        String idBanco = itemList[4];
                                        String idTM = itemList[5];
                                        String data5 = itemList[8];
                                        try {
                                            String fecha = itemList[6];
                                            SimpleDateFormat formatter4 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                            dateAux = formatter4.parse(fecha);
                                        } catch (Exception e2) {
                                            dateAux = new Date();
                                        }
                                        combustibleProcess(serie, dateAux, importe5, idBanco, idTM, moneda5, data5);
                                    }
                                }
                                i++;
                                c = 1;
                                c2 = 3;
                            }
                        } catch (Exception e3) {
                        }
                    }
                }
                return record;
            } catch (Exception e4) {
            }
        } catch (Exception e5) {
        }
    }

    public RecordSMS parseOfertasBoleto(rIgmgP6JXL sms_properties) {
        String str;
        String str2;
        String str3;
        String[] bloques;
        String CONS_ID_OFERTA;
        String CONS_NOMBRE;
        String CONS_NOMBRE2;
        int i;
        String CONS_DATOS;
        String CONS_FECHA_INIC;
        int i2;
        RecordSMS record = new RecordSMS();
        try {
            String datos = sms_properties.getBody();
            if (datos.contains("Consulta de las ofertas disponibles Mi Boleto")) {
                try {
                    procesarListadoOfertas(datos, sms_properties.getDate());
                } catch (Exception e) {
                    ex = e;
                    Log.e("parseOfertasBoleto", "Error: " + ex.getMessage(), ex);
                    return null;
                }
            }
            String transaccion = "Importe pagado:";
            String transferencia = "Id_Banco:";
            String moneda = "Id_tm:";
            String fechaVenc = "Nombre:";
            String nombre = "Atraccion;Nombre;Monto/cantidad;Moneda";
            String ci = "Token:";
            String fechaComp = "IdOferta:";
            if (datos.contains("Mi Boleto: La compra de la oferta se realizo correctamente.")) {
                String idOferta = getElement("IdOferta:", datos);
                String nombre2 = getElementLine("Nombre:", datos);
                String token = getElement("Token:", datos);
                String transaccion2 = getElement("Id_tm:", datos);
                String transferencia2 = getElement("Id_Banco:", datos);
                String precio = getElement("Importe pagado:", datos);
                String moneda2 = getElement("Moneda:", datos);
                String ci2 = getElement("CI Beneficiario:", datos);
                String compra = getElement("Compra:", datos);
                String fechaInic = getElement("Fecha Inicial Oferta:", datos);
                String fechaVenc2 = getElement("Fecha Final Oferta:", datos);
                String datos2 = extractAttractionData(datos, "Atraccion;Nombre;Monto/cantidad;Moneda");
                record.setIdTransaccion(transaccion2);
                record.setMonto(precio);
                str = "Fecha Final Oferta:";
                record.setMoneda(moneda2);
                str2 = "CI Beneficiario:";
                record.setServicio("Compra Mi Boleto");
                str3 = "Moneda:";
                record.setMostrar(true);
                if (unYp8VQThY.getInstance().getCompraBoleto(idOferta).size() == 0) {
                    CompraBoleto nueva = new CompraBoleto();
                    try {
                        nueva.setIdOferta(idOferta);
                        nueva.setAlias(nombre2);
                        nueva.setToken(token);
                        nueva.setIdTransaccion(transaccion2);
                        nueva.setIdTransferencia(transferencia2);
                        nueva.setPrecio(Double.parseDouble(precio));
                        nueva.setMoneda(moneda2);
                        nueva.setCi(ci2);
                        nueva.setTipoCompra(compra);
                        nueva.setFechaCompra(sms_properties.getDate());
                        nueva.setFechaInicial(parseFecha(fechaInic));
                        nueva.setFechaVencimiento(parseFecha(fechaVenc2));
                        nueva.setFechaActualizacion(sms_properties.getDate());
                        nueva.setDatos(datos2);
                        nueva.setConsumido(false);
                        nueva.setEstado("ACTIVA");
                        unYp8VQThY.getInstance().addCompraMiBoleto(nueva);
                    } catch (Exception e2) {
                        ex = e2;
                        Log.e("parseOfertasBoleto", "Error: " + ex.getMessage(), ex);
                        return null;
                    }
                }
            } else {
                str = "Fecha Final Oferta:";
                str2 = "CI Beneficiario:";
                str3 = "Moneda:";
            }
            if (datos.contains("Mi Boleto: Cambio de Pin completado.")) {
                String idOferta2 = getElement("IdOferta:", datos);
                String token2 = getElement("Token:", datos);
                String datos3 = extractAttractionData(datos, "Atraccion;Nombre;Monto/cantidad;Moneda");
                List<CompraBoleto> existentes = unYp8VQThY.getInstance().getCompraBoleto(idOferta2);
                if (existentes.size() != 0) {
                    CompraBoleto existente = existentes.get(0);
                    if (sms_properties.getDate().after(existente.getFechaActualizacion())) {
                        existente.setEstado("ACTIVA");
                        existente.setToken(token2);
                        existente.setDatos(datos3);
                        existente.setConsumido(false);
                        existente.setFechaActualizacion(sms_properties.getDate());
                        unYp8VQThY.getInstance().updateCompraMiboleto(existente);
                    }
                }
            }
            String CONS_DATOS2 = "Personal";
            String token3 = "Fecha Compra:";
            if (!datos.contains("Mi Boleto: La consulta se realizo correctamente")) {
                datos = datos;
                token3 = "Fecha Compra:";
                transaccion = "Importe pagado:";
                transferencia = "Id_Banco:";
                moneda = "Id_tm:";
                fechaVenc = "Nombre:";
                nombre = "Atraccion;Nombre;Monto/cantidad;Moneda";
                ci = "Token:";
                fechaComp = "IdOferta:";
            } else {
                String CONS_MONEDA = str3;
                String CONS_CI_BENEFICIARIO = str2;
                String idOferta3 = getElement("IdOferta:", datos);
                String nombre3 = getElementLine("Nombre:", datos);
                String token4 = getElement("Token:", datos);
                String transaccion3 = getElement("Id_tm:", datos);
                String transferencia3 = getElement("Id_Banco:", datos);
                String precio2 = getElement("Importe pagado:", datos);
                String moneda3 = getElement(CONS_MONEDA, datos);
                String ci3 = getElement(CONS_CI_BENEFICIARIO, datos);
                String fechaVenc3 = getElement("Fecha Oferta:", datos);
                String fechaComp2 = getElement("Fecha Compra:", datos);
                String fechaEnd = getElement("Fecha Final Disfrute:", datos);
                String estado = getElement("Estado:", datos);
                String datos4 = extractAttractionData(datos, "Atraccion;Nombre;Monto/cantidad;Moneda");
                List<CompraBoleto> existentes2 = unYp8VQThY.getInstance().getCompraBoleto(idOferta3);
                if (existentes2.size() != 0) {
                    CompraBoleto existente2 = existentes2.get(0);
                    if (sms_properties.getDate().after(existente2.getFechaActualizacion())) {
                        existente2.setIdOferta(idOferta3);
                        existente2.setAlias(nombre3);
                        existente2.setToken(token4);
                        existente2.setIdTransaccion(transaccion3);
                        existente2.setIdTransferencia(transferencia3);
                        existente2.setPrecio(Double.parseDouble(precio2));
                        existente2.setMoneda(moneda3);
                        existente2.setCi(ci3);
                        existente2.setFechaCompra(parseFecha(fechaComp2));
                        existente2.setFechaInicial(parseFecha(fechaVenc3));
                        existente2.setFechaActualizacion(sms_properties.getDate());
                        existente2.setDatos(datos4);
                        existente2.setConsumido(false);
                        if (!estado.equals("Activo")) {
                            existente2.setConsumido(true);
                        }
                        unYp8VQThY.getInstance().updateCompraMiboleto(existente2);
                    }
                } else {
                    token3 = "Fecha Compra:";
                    nombre = "Atraccion;Nombre;Monto/cantidad;Moneda";
                    transaccion = "Importe pagado:";
                    transferencia = "Id_Banco:";
                    moneda = "Id_tm:";
                    ci = "Token:";
                    fechaVenc = "Nombre:";
                    fechaComp = "IdOferta:";
                    datos = datos;
                    CompraBoleto nueva2 = new CompraBoleto();
                    nueva2.setIdOferta(idOferta3);
                    nueva2.setAlias(nombre3);
                    nueva2.setToken(token4);
                    nueva2.setIdTransaccion(transaccion3);
                    nueva2.setIdTransferencia(transferencia3);
                    nueva2.setPrecio(Double.parseDouble(precio2));
                    nueva2.setMoneda(moneda3);
                    nueva2.setCi(ci3);
                    nueva2.setTipoCompra("Personal");
                    nueva2.setFechaCompra(parseFecha(fechaComp2));
                    nueva2.setFechaInicial(parseFecha(fechaVenc3));
                    nueva2.setFechaVencimiento(parseFecha(fechaEnd));
                    nueva2.setFechaActualizacion(sms_properties.getDate());
                    nueva2.setDatos(datos4);
                    nueva2.setEstado("ACTIVA");
                    nueva2.setConsumido(false);
                    unYp8VQThY.getInstance().addCompraMiBoleto(nueva2);
                }
            }
            String sms = datos;
            if (sms.contains("Mi Boleto: La consulta de las ofertas adquiridas antes de")) {
                List<CompraBoleto> boletos = new ArrayList<>();
                String[] bloques2 = sms.split("\\*{6}");
                String CONS_ID_OFERTA2 = fechaComp;
                String CONS_FECHA_INIC2 = fechaVenc;
                String CONS_TOKEN = ci;
                String CONS_TRANSACCION = moneda;
                String CONS_TRANSFERENCIA = transferencia;
                String CONS_PRECIO = transaccion;
                String CONS_MONEDA2 = str3;
                String CONS_CI_BENEFICIARIO2 = str2;
                String CONS_FECHA_COMPRA = token3;
                String CONS_DATOS3 = "Fecha Inicio Oferta:";
                String CONS_FECHA_ATRACCION = str;
                String CONS_DATOS4 = nombre;
                int i3 = 1;
                while (i3 < bloques2.length) {
                    String bloque = bloques2[i3].trim();
                    if (bloque.isEmpty()) {
                        bloques = bloques2;
                        CONS_ID_OFERTA = CONS_ID_OFERTA2;
                        CONS_NOMBRE = CONS_FECHA_INIC2;
                        CONS_NOMBRE2 = CONS_DATOS3;
                        CONS_FECHA_INIC = CONS_DATOS4;
                        CONS_DATOS2 = CONS_DATOS2;
                        i2 = i3;
                    } else {
                        try {
                            CompraBoleto boleto = new CompraBoleto();
                            bloques = bloques2;
                            i = i3;
                            try {
                                boleto.setIdOferta(getElementLine(CONS_ID_OFERTA2, bloque));
                                boleto.setAlias(getElementLine(CONS_FECHA_INIC2, bloque));
                                boleto.setToken(getElementLine(CONS_TOKEN, bloque));
                                boleto.setIdTransaccion(getElementLine(CONS_TRANSACCION, bloque));
                                boleto.setIdTransferencia(getElementLine(CONS_TRANSFERENCIA, bloque));
                                String precioStr = getElementLine(CONS_PRECIO, bloque);
                                if (precioStr == null) {
                                    CONS_ID_OFERTA = CONS_ID_OFERTA2;
                                    CONS_NOMBRE = CONS_FECHA_INIC2;
                                } else {
                                    CONS_ID_OFERTA = CONS_ID_OFERTA2;
                                    CONS_NOMBRE = CONS_FECHA_INIC2;
                                    try {
                                        boleto.setPrecio(Double.parseDouble(precioStr));
                                    } catch (Exception e3) {
                                        e = e3;
                                        CONS_NOMBRE2 = CONS_DATOS3;
                                        CONS_DATOS = CONS_DATOS4;
                                        CONS_FECHA_INIC = CONS_DATOS;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Error procesando boleto ");
                                        i2 = i;
                                        sb.append(i2);
                                        Log.e("BOLETO_ERROR", sb.toString(), e);
                                        procesarBoletos(boletos);
                                        i3 = i2 + 1;
                                        CONS_DATOS2 = CONS_DATOS2;
                                        bloques2 = bloques;
                                        CONS_ID_OFERTA2 = CONS_ID_OFERTA;
                                        CONS_DATOS4 = CONS_FECHA_INIC;
                                        CONS_DATOS3 = CONS_NOMBRE2;
                                        CONS_FECHA_INIC2 = CONS_NOMBRE;
                                    }
                                }
                                try {
                                    String CONS_ID_OFERTA3 = getElementLine(CONS_MONEDA2, bloque);
                                    boleto.setMoneda(CONS_ID_OFERTA3);
                                    boleto.setCi(getElementLine(CONS_CI_BENEFICIARIO2, bloque));
                                    String fechaCompraStr = getElementLine(CONS_FECHA_COMPRA, bloque);
                                    CONS_NOMBRE2 = CONS_DATOS3;
                                    try {
                                        String fechaInic2 = getElementLine(CONS_NOMBRE2, bloque);
                                        String precioStr2 = CONS_FECHA_ATRACCION;
                                        try {
                                            String fechaAtraccionStr = getElementLine(precioStr2, bloque);
                                            CONS_FECHA_ATRACCION = precioStr2;
                                            boleto.setFechaCompra(parseFecha(fechaCompraStr));
                                            boleto.setFechaInicial(parseFecha(fechaInic2));
                                            boleto.setFechaVencimiento(parseFecha(fechaAtraccionStr));
                                            CONS_DATOS = CONS_DATOS4;
                                            try {
                                                String fechaAtraccionStr2 = extractAttractionData(bloque, CONS_DATOS);
                                                boleto.setDatos(fechaAtraccionStr2);
                                                boleto.setEstado("ACTIVA");
                                                boleto.setTipoCompra(CONS_DATOS2);
                                                boleto.setConsumido(false);
                                                boleto.setFechaActualizacion(sms_properties.getDate());
                                                boletos.add(boleto);
                                                CONS_FECHA_INIC = CONS_DATOS;
                                                i2 = i;
                                            } catch (Exception e4) {
                                                e = e4;
                                                CONS_FECHA_INIC = CONS_DATOS;
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append("Error procesando boleto ");
                                                i2 = i;
                                                sb2.append(i2);
                                                Log.e("BOLETO_ERROR", sb2.toString(), e);
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            CONS_FECHA_ATRACCION = precioStr2;
                                            CONS_DATOS = CONS_DATOS4;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        CONS_DATOS = CONS_DATOS4;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    CONS_NOMBRE2 = CONS_DATOS3;
                                    CONS_DATOS = CONS_DATOS4;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                CONS_ID_OFERTA = CONS_ID_OFERTA2;
                                CONS_NOMBRE = CONS_FECHA_INIC2;
                                CONS_NOMBRE2 = CONS_DATOS3;
                                CONS_DATOS = CONS_DATOS4;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            bloques = bloques2;
                            CONS_ID_OFERTA = CONS_ID_OFERTA2;
                            CONS_NOMBRE = CONS_FECHA_INIC2;
                            CONS_NOMBRE2 = CONS_DATOS3;
                            i = i3;
                            CONS_DATOS = CONS_DATOS4;
                        }
                        procesarBoletos(boletos);
                    }
                    i3 = i2 + 1;
                    CONS_DATOS2 = CONS_DATOS2;
                    bloques2 = bloques;
                    CONS_ID_OFERTA2 = CONS_ID_OFERTA;
                    CONS_DATOS4 = CONS_FECHA_INIC;
                    CONS_DATOS3 = CONS_NOMBRE2;
                    CONS_FECHA_INIC2 = CONS_NOMBRE;
                }
            }
            if (sms.contains("Mi Boleto: La operacion se realizo correctamente")) {
                procesarConfirmacionCompra(sms, sms_properties.getDate());
            }
            if (sms.contains("Mi Boleto: Error en la reserva")) {
                String CONS_ID_OFERTA4 = fechaComp;
                String CONS_TOKEN2 = ci;
                String idOferta4 = getElement(CONS_ID_OFERTA4, sms);
                String token5 = getElement(CONS_TOKEN2, sms);
                List<CompraBoleto> existentes3 = unYp8VQThY.getInstance().getCompraBoleto(idOferta4);
                if (existentes3.size() != 0) {
                    CompraBoleto existente3 = existentes3.get(0);
                    if (sms_properties.getDate().after(existente3.getFechaActualizacion())) {
                        existente3.setToken(token5);
                        existente3.setConsumido(false);
                        existente3.setFechaActualizacion(sms_properties.getDate());
                        unYp8VQThY.getInstance().updateCompraMiboleto(existente3);
                    }
                }
            }
            return record;
        } catch (Exception e10) {
            ex = e10;
        }
    }

    private void procesarListadoOfertas(String sms, Date sms_date) {
        String CONS_TRANSACCION;
        String ic_control;
        String ofertaLimpia;
        String CONS_CABECERA = "Codigo;Nombre;Precio;Moneda;Fecha;Plazo;Cantidad";
        String CONS_TRANSACCION2 = "Id_tm:";
        String ic_control2 = getElement("Id_tm:", sms);
        long id_tm = Long.parseLong(ic_control2);
        if (esIdTmValido(id_tm) && sms.contains("Codigo;Nombre;Precio;Moneda;Fecha;Plazo;Cantidad")) {
            try {
                unYp8VQThY.getInstance().deleteOfertasWithIdTmLess(id_tm);
                int startIndex = "Codigo;Nombre;Precio;Moneda;Fecha;Plazo;Cantidad".length() + sms.indexOf("Codigo;Nombre;Precio;Moneda;Fecha;Plazo;Cantidad");
                String ofertasPart = sms.substring(startIndex).trim();
                String[] ofertas = ofertasPart.split("\\|");
                int length = ofertas.length;
                int i = 0;
                while (i < length) {
                    String oferta = ofertas[i];
                    String ofertaLimpia2 = oferta.trim();
                    if (ofertaLimpia2.isEmpty()) {
                        CONS_TRANSACCION = CONS_TRANSACCION2;
                        ic_control = ic_control2;
                        ofertaLimpia = CONS_CABECERA;
                    } else {
                        String[] campos = ofertaLimpia2.split(";");
                        ofertaLimpia = CONS_CABECERA;
                        if (campos.length >= 7) {
                            try {
                                OfertasBoleto nuevaOferta = new OfertasBoleto();
                                nuevaOferta.setId(campos[0].trim());
                                nuevaOferta.setNombre(campos[1].trim());
                                CONS_TRANSACCION = CONS_TRANSACCION2;
                                try {
                                    nuevaOferta.setFecha(sms_date);
                                    String intervaloFechas = campos[4].trim();
                                    nuevaOferta.setFechaOferta(intervaloFechas);
                                    nuevaOferta.setValidDays(Integer.parseInt(campos[5]));
                                    nuevaOferta.setCantPersona(Integer.parseInt(campos[6]));
                                    nuevaOferta.setId_control(id_tm);
                                    try {
                                        ic_control = ic_control2;
                                        try {
                                            try {
                                                nuevaOferta.setPrecio(Double.parseDouble(campos[2].trim()));
                                                nuevaOferta.setMoneda(campos[3].trim());
                                                unYp8VQThY.getInstance().addOfertasMiBoleto(nuevaOferta);
                                            } catch (NumberFormatException e) {
                                                Log.e("Ofertas", "Formato de precio inválido: " + campos[2]);
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            Log.e("Ofertas", "Error procesando ofertas: " + e.getMessage(), e);
                                            return;
                                        }
                                    } catch (NumberFormatException e3) {
                                        ic_control = ic_control2;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    Log.e("Ofertas", "Error procesando ofertas: " + e.getMessage(), e);
                                    return;
                                }
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } else {
                            CONS_TRANSACCION = CONS_TRANSACCION2;
                            ic_control = ic_control2;
                            Log.e("Ofertas", "Formato incorrecto, campos insuficientes: " + ofertaLimpia2);
                        }
                    }
                    i++;
                    CONS_CABECERA = ofertaLimpia;
                    CONS_TRANSACCION2 = CONS_TRANSACCION;
                    ic_control2 = ic_control;
                }
                Log.i("Ofertas", "Ofertas actualizadas correctamente. ID_TM: " + id_tm);
            } catch (Exception e6) {
                e = e6;
            }
        }
    }

    private boolean esIdTmValido(long id_tm) {
        try {
            List<OfertasBoleto> boletos = unYp8VQThY.getInstance().getAllOfertasmiBoletoOrderBy();
            if (boletos != null && !boletos.isEmpty()) {
                long primerIdControl = boletos.get(0).getId_control();
                return id_tm >= primerIdControl;
            }
            return true;
        } catch (Exception e) {
            Log.e("Ofertas", "Error validando ID_TM: " + e.getMessage(), e);
            return false;
        }
    }

    public void procesarConfirmacionCompra(String sms, Date fechaSms) {
        try {
            String idOferta = getElement("IdOferta:", sms);
            String token = getElement("Token:", sms);
            try {
                String datosAtraccion = extractAttractionData(sms, "Atraccion;Nombre;Monto/cantidad;Moneda");
                if (datosAtraccion != null && !datosAtraccion.isEmpty()) {
                    String[] atracciones = datosAtraccion.split("\\|");
                    for (String atraccion : atracciones) {
                        String[] campos = atraccion.split(";");
                        if (campos.length >= 4) {
                            String idAtraccion = campos[0].trim();
                            String nombreAtraccion = campos[1].trim();
                            String montoAtraccion = campos[2].trim();
                            String monedaAtraccion = campos[3].trim();
                            actualizarAtraccionEnOferta(idOferta, idAtraccion, nombreAtraccion, montoAtraccion, monedaAtraccion, token, fechaSms);
                        }
                    }
                }
            } catch (Exception e) {
                e = e;
                Log.e("ProcesarConfirmacion", "Error al procesar confirmación: " + e.getMessage(), e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void actualizarAtraccionEnOferta(String idOferta, String idAtraccion, String nombre, String monto, String moneda, String token, Date fecha) {
        List<CompraBoleto> ofertas;
        try {
            List<CompraBoleto> ofertas2 = unYp8VQThY.getInstance().getCompraBoleto(idOferta);
            CompraBoleto oferta = ofertas2.get(0);
            if (oferta == null) {
                Log.e("ActualizarAtraccion", "No se encontró la oferta con ID: " + idOferta);
                return;
            }
            if (fecha.after(oferta.getFechaActualizacion())) {
                String datosActuales = oferta.getDatos();
                try {
                    if (datosActuales == null || datosActuales.isEmpty()) {
                        Log.e("ActualizarAtraccion", "La oferta no tiene datos de atracciones");
                        return;
                    }
                    StringBuilder nuevosDatos = new StringBuilder();
                    String[] atracciones = datosActuales.split("\\|");
                    int length = atracciones.length;
                    int i = 0;
                    while (i < length) {
                        String atraccion = atracciones[i].trim();
                        if (atraccion.isEmpty()) {
                            ofertas = ofertas2;
                            datosActuales = datosActuales;
                        } else {
                            String[] campos = atraccion.split(";");
                            ofertas = ofertas2;
                            if (campos.length < 4) {
                                datosActuales = datosActuales;
                            } else {
                                String idActual = campos[0].trim();
                                if (!idActual.equals(idAtraccion)) {
                                    nuevosDatos.append(atraccion);
                                } else if (!monto.equals("0")) {
                                    nuevosDatos.append(String.format(Locale.US, "%s;%s;%s;%s", idAtraccion, nombre, monto, moneda));
                                }
                                if (nuevosDatos.length() > 0 && !nuevosDatos.toString().endsWith(" | ")) {
                                    nuevosDatos.append(" | ");
                                }
                            }
                        }
                        i++;
                        ofertas2 = ofertas;
                        datosActuales = datosActuales;
                    }
                    oferta.setDatos(nuevosDatos.toString());
                    oferta.setToken(token);
                    oferta.setFechaActualizacion(fecha);
                    unYp8VQThY.getInstance().updateCompraMiboleto(oferta);
                    Log.i("ActualizarAtraccion", "Atracción actualizada en oferta: " + idOferta);
                } catch (Exception e) {
                    e = e;
                    Log.e("ActualizarAtraccion", "Error al actualizar atracción: " + e.getMessage(), e);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public boolean parse_fill_sms_data(String sms) {
        if (sms.contains("Bienvenido al sistema TRANSFERMOVIL") && sms.contains("Su número: ")) {
            String[] msg_separate = sms.split(" ");
            this.numero_telefonico = msg_separate[6];
            this.version = msg_separate[10];
            return true;
        }
        if (sms.contains("Bienvenido al sistema TRANSFERMOVIL") && sms.contains("Su numero: ")) {
            String[] msg_separate2 = sms.split(" ");
            this.numero_telefonico = msg_separate2[6];
            this.version = msg_separate2[10];
            return true;
        }
        if (sms.contains("Su número:") && sms.contains("actualice su aplicación.")) {
            String[] msg_separate3 = sms.split(" ");
            this.numero_telefonico = msg_separate3[2];
            this.version = msg_separate3[6];
            return true;
        }
        if (sms.contains("Su numero:") && sms.contains("actualice su aplicacion.")) {
            String[] msg_separate4 = sms.split(" ");
            this.numero_telefonico = msg_separate4[2];
            this.version = msg_separate4[6];
            return true;
        }
        if (sms.contains("El código de activación del número") && sms.contains("Debe insertarlo")) {
            String[] msg_separate5 = sms.split(" ");
            this.numero_telefonico = msg_separate5[6];
            if (sms.contains("para agentes")) {
                this.code_agent = msg_separate5[14];
            } else if (sms.contains("para el Modulo de Banco")) {
                this.code_bank = msg_separate5[17];
            }
            return true;
        }
        if (sms.contains("El codigo de activacion del numero") && sms.contains("Debe insertarlo")) {
            String[] msg_separate6 = sms.split(" ");
            this.numero_telefonico = msg_separate6[6];
            if (sms.contains("para agentes")) {
                this.code_agent = msg_separate6[14];
            } else if (sms.contains("para el Modulo de Banco")) {
                this.code_bank = msg_separate6[17];
            } else if (sms.contains("para el Modulo Bulevar")) {
                this.code_bulevar = msg_separate6[14];
            } else if (sms.contains("para el Modulo Mi Boleto")) {
                this.code_boleto = msg_separate6[13];
            }
            return true;
        }
        return false;
    }

    public static String getElement(String patron, String cadena) {
        try {
            int intIndex = cadena.indexOf(patron);
            int proximoElemento = patron.length() + intIndex;
            String cadenaRestante = cadena.substring(proximoElemento).replace("\n", " ");
            String[] elementos = cadenaRestante.trim().split(" ");
            String valor = elementos[0];
            return valor;
        } catch (Exception ex) {
            Log.e("PARSESMS-EXCEPTION", ex.getMessage());
            return null;
        }
    }

    public static String getElementLine(String patron, String cadena) {
        try {
            int startIndex = cadena.indexOf(patron);
            if (startIndex == -1) {
                return null;
            }
            int valueStart = patron.length() + startIndex;
            int endIndex = cadena.indexOf("\n", valueStart);
            if (endIndex == -1) {
                return cadena.substring(valueStart).trim();
            }
            return cadena.substring(valueStart, endIndex).trim();
        } catch (Exception ex) {
            Log.e("PARSESMS-EXCEPTION", ex.getMessage());
            return null;
        }
    }

    private Date parseFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null;
        }
        try {
            String[] partes = fechaStr.split("/");
            if (partes.length != 3) {
                return null;
            }
            String mes = partes[1];
            String dia = partes[0];
            String fechaInvertida = dia + "-" + mes + "-" + partes[2];
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            return sdf.parse(fechaInvertida);
        } catch (Exception e) {
            Log.e("DATE_ERROR", "Error al parsear fecha", e);
            return null;
        }
    }

    private void combustibleProcess(String idSerie, Date date, String importe, String transaccionBanco, String transaccionTM, String moneda, String data) {
        try {
            List<TCTicket> ticketList = unYp8VQThY.getInstance().getTCombustible(idSerie);
            if (ticketList.size() > 0) {
                TCTicket ticket = ticketList.get(0);
                new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(ticket.getFecha());
                Date dateCupon = ticket.getFecha();
                dateCupon.compareTo(date);
                if (ticket.getFecha().compareTo(date) <= 0) {
                    ticket.setImporte(Float.parseFloat(importe));
                    ticket.setData(data);
                    ticket.setIdBank(transaccionBanco);
                    ticket.setIdTM(transaccionTM);
                    ticket.setFecha(date);
                    ticket.setDeleted(false);
                    unYp8VQThY.getInstance().updateTCTicket(ticket);
                }
                return;
            }
            TCTicket ticketNuevo = new TCTicket();
            ticketNuevo.setIdTM(transaccionTM);
            ticketNuevo.setIdBank(transaccionBanco);
            ticketNuevo.setSerie(idSerie);
            ticketNuevo.setImporte(Float.parseFloat(importe));
            try {
                ticketNuevo.setMoneda(moneda);
                ticketNuevo.setConsumido(false);
                ticketNuevo.setData(data);
                ticketNuevo.setFecha(date);
                unYp8VQThY.getInstance().addTCTicket(ticketNuevo);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    private void procesarPlan(String codigo, String descripcion, String version, Date fecha) {
        int cod = Integer.parseInt(codigo);
        int ver = Integer.parseInt(version);
        try {
            CompraPlanesCubacel nuevoPlan = new CompraPlanesCubacel();
            nuevoPlan.setId(cod);
            nuevoPlan.setNombre(descripcion);
            nuevoPlan.setVersion_ussd(ver);
            nuevoPlan.setFechaAct(fecha);
            unYp8VQThY.getInstance().addPaquetes(nuevoPlan);
        } catch (Exception e) {
        }
    }

    private void procesarBoletos(List<CompraBoleto> boletos) {
        if (boletos == null || boletos.isEmpty()) {
            return;
        }
        try {
            for (CompraBoleto boletoSMS : boletos) {
                List<CompraBoleto> existentes = unYp8VQThY.getInstance().getCompraBoleto(boletoSMS.getIdOferta());
                if (existentes != null && !existentes.isEmpty()) {
                    CompraBoleto existente = existentes.get(0);
                    if (boletoSMS.getFechaActualizacion().after(existente.getFechaActualizacion())) {
                        existente.setToken(boletoSMS.getToken());
                        existente.setIdTransaccion(boletoSMS.getIdTransaccion());
                        existente.setIdTransferencia(boletoSMS.getIdTransferencia());
                        existente.setPrecio(boletoSMS.getPrecio());
                        existente.setMoneda(boletoSMS.getMoneda());
                        existente.setFechaVencimiento(boletoSMS.getFechaVencimiento());
                        existente.setEstado(boletoSMS.getEstado());
                        existente.setDatos(boletoSMS.getDatos());
                        existente.setConsumido(boletoSMS.isConsumido());
                        existente.setFechaActualizacion(new Date());
                        unYp8VQThY.getInstance().updateCompraMiboleto(existente);
                    }
                } else {
                    unYp8VQThY.getInstance().addCompraMiBoleto(boletoSMS);
                }
            }
        } catch (Exception e) {
            Log.e("DB_BOLETOS", "Error guardando boletos", e);
        }
    }

    private String extractAttractionData(String sms, String startLabel) {
        int startIndex = sms.indexOf(startLabel);
        if (startIndex == -1) {
            return BuildConfig.FLAVOR;
        }
        int dataStart = startLabel.length() + startIndex;
        String remainingSMS = sms.substring(dataStart).trim();
        StringBuilder result = new StringBuilder();
        String[] lines = remainingSMS.split("\\r?\\n");
        for (String str : lines) {
            String line = str.trim();
            if (line.matches("^\\d+;.*")) {
                result.append(line);
                result.append("\n");
            }
        }
        return result.toString().trim();
    }
}
