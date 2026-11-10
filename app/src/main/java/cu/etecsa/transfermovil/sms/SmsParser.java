package cu.etecsa.transfermovil.sms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.paolorotolo.appintro.BuildConfig;

import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.SmsRecord;
import cu.etecsa.transfermovil.data.entity.TransportTicket;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.g0xM9kQCsqu
 * @fingerprint 1830-line SMS response parser. Parses PAGOxMOVIL gateway responses
 *              into structured database records.
 *
 * Handles 32+ service types by parsing SMS body text for known patterns:
 *   - Banking transactions (transfers, payments, balance queries)
 *   - Cubacel top-ups and plan purchases
 *   - Nauta internet payments
 *   - Utility bill payments (electric, water, gas, phone)
 *   - ONAT tax payments
 *   - Fuel/combustible purchases
 *   - MiBoleto ticket offers and purchases
 *   - Agent/telecom wallet operations
 *   - Promotional SMS processing
 *
 * Key parsing patterns:
 *   - "INFORMACION:" prefix → promo/info SMS (date-filtered to today)
 *   - "Id. Transaccion:" → transaction record with bank routing
 *   - "Datos App:" → app configuration data (phone, version, agent code)
 *   - "Wallet:" → wallet currency management
 *   - "Oferta:" → ticket offer processing
 *   - "Combustible:" → fuel purchase records
 *
 * Dependencies (obfuscated → clean):
 *   - RecordSMS → SmsRecord entity (main output type)
 *   - CompraBoleto → TicketPurchase entity
 *   - CompraPlanesCubacel → CubacelPlan entity
 *   - OfertasBoleto → TicketOffer entity
 *   - PromoSMS → SmsPromotion entity
 *   - TCTicket → TransportTicket entity
 *   - TMonedasWallet → WalletCurrency entity
 *   - unYp8VQThY → DatabaseHelper
 *   - KYTjPlWScT → AgentSource enum
 *   - R1sDOSqZ2z → BankType enum
 */
public class SmsParser {

    public String numero_telefonico = "";
    public String version = "";
    public String code_agent = "";
    public String code_bank = "";
    public String code_bulevar = "";
    public String code_boleto = "";

    // --- Getters ---

    public String getCode_bulevar() { return code_bulevar; }
    public String getCode_boleto() { return code_boleto; }
    public String getCode_agent() { return code_agent; }
    public String getCode_bank() { return code_bank; }
    public String getVersion() { return version; }
    public String getNumero_telefonico() { return numero_telefonico; }

    // --- Main parse method (lines 62–752) ---

    /**
     * Parses a PAGOxMOVIL SMS into a RecordSMS entity.
     * Routes based on SMS body content:
     *   - "INFORMACION:" → promotional (stored as SmsPromotion if today's date)
     *   - Contains "Id. Transaccion:" → transaction record
     *   - Extracts: idTransaccion, cuenta, monto, moneda, servicio
     *   - Determines AgentSource from context (BancoMetro, BPA, BANDEC, Agentes)
     *
     * @param sms_properties SMS with body, date, address
     * @return RecordSMS entity ready for DB insertion, or null if unparseable
     */
    // public RecordSMS parse(SmsMessage sms_properties) { ... }

    // --- Wallet parsing (lines 753–815) ---

    /**
     * Parses "Wallet:" SMS responses to update TMonedasWallet table.
     * Extracts currency list and allowTransfer flags.
     */
    // public void parseMonedasWallet(String sms) { ... }

    // --- Agent/Telecom wallet (lines 816–882) ---

    /**
     * Parses agent telecom wallet operation responses.
     * @return RecordSMS for the wallet transaction
     */
    // public RecordSMS parseAgentesTelecomWallet(String sms) { ... }

    // --- Fuel/Combustible (source lines 883–1090) ---

    /**
     * Parses fuel purchase confirmation SMS.
     * Extracts: station, fuel type, liters, amount, ticket number.
     * Creates TCTicket entity for fuel transactions.
     *
     * @return RecordSMS for fuel purchase, or null
     */

    // --- Ticket offers (lines 1091–1535) ---

    /**
     * Parses MiBoleto ticket offer and purchase confirmations.
     * Handles: offer listings, purchase confirmations, ticket validations.
     * Creates/updates OfertasBoleto and CompraBoleto entities.
     *
     * @return RecordSMS for ticket operation, or null
     */
    // public RecordSMS parseOfertasBoleto(SmsMessage sms_properties) { ... }

    // --- Purchase confirmation (lines 1536–1624) ---

    /**
     * Processes purchase confirmation SMS (Cubacel plans, etc).
     * Updates CompraPlanesCubacel records with confirmation status.
     */
    // public void procesarConfirmacionCompra(String sms, Date fechaSms) { ... }

    // --- App data extraction (lines 1625–1676) ---

    /**
     * Parses "Datos App:" SMS to extract configuration:
     *   - Phone number → numero_telefonico
     *   - App version → version
     *   - Agent code → code_agent
     *   - Bank code → code_bank
     *   - Boulevard code → code_bulevar
     *   - Ticket code → code_boleto
     *
     * @return true if any data was extracted
     */
    // public boolean parse_fill_sms_data(String sms) { ... }

    /** Parses fuel coupon confirmations, status updates, and coupon listings. */
    public SmsRecord parseCombustible(SmsMessage sms_properties) {
        Date dateAux;
        SmsRecord record = new SmsRecord();
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
                            DatabaseHelper.getInstance().addRecordSMS(record);
                            if (DatabaseHelper.getInstance().getTCTicketWithSerie(idSerie).size() == 0) {
                                TransportTicket ticket = new TransportTicket();
                                ticket.setIdTM(transaccionTM);
                                ticket.setIdBank(transaccionBanco);
                                ticket.setSerie(idSerie);
                                ticket.setImporte(Float.parseFloat(importe));
                                ticket.setMoneda(moneda);
                                ticket.setConsumido(false);
                                ticket.setData(data);
                                ticket.setFecha(sms_properties.getDate());
                                DatabaseHelper.getInstance().addTCTicket(ticket);
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
                        List<TransportTicket> ticketList = DatabaseHelper.getInstance().getTCTicketWithSerie(idSerie2);
                        if (ticketList.size() > 0) {
                            TransportTicket ticket2 = ticketList.get(0);
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
                                DatabaseHelper.getInstance().updateTCTicket(ticket2);
                            }
                        } else {
                            TransportTicket ticketNuevo = new TransportTicket();
                            ticketNuevo.setIdTM(transaccionTM2);
                            ticketNuevo.setIdBank(transaccionBanco2);
                            ticketNuevo.setSerie(idSerie2);
                            ticketNuevo.setImporte(Float.parseFloat(importe2));
                            ticketNuevo.setMoneda(moneda2);
                            ticketNuevo.setConsumido(false);
                            ticketNuevo.setData(data2);
                            ticketNuevo.setFecha(sms_properties.getDate());
                            DatabaseHelper.getInstance().addTCTicket(ticketNuevo);
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
                            List<TransportTicket> ticketList2 = DatabaseHelper.getInstance().getTCTicketWithSerie(idSerie3);
                            if (ticketList2.size() > 0) {
                                TransportTicket ticket3 = ticketList2.get(0);
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
                                    DatabaseHelper.getInstance().updateTCTicket(ticket3);
                                }
                            } else {
                                TransportTicket ticketNuevo2 = new TransportTicket();
                                ticketNuevo2.setIdTM(transaccionTM3);
                                ticketNuevo2.setIdBank(transaccionBanco3);
                                ticketNuevo2.setSerie(idSerie3);
                                ticketNuevo2.setImporte(Float.parseFloat(importe3));
                                ticketNuevo2.setMoneda(moneda3);
                                ticketNuevo2.setConsumido(false);
                                ticketNuevo2.setData(data3);
                                ticketNuevo2.setFecha(sms_properties.getDate());
                                DatabaseHelper.getInstance().addTCTicket(ticketNuevo2);
                            }
                        } else if (sms.contains("ha realizado una devolucion al cupon de combustible con")) {
                            String transaccionTM4 = getElement(", ID TM:", sms).replace(".", BuildConfig.FLAVOR);
                            String transaccionBanco4 = getElement("No. Transaccion: ", sms).replace(".", BuildConfig.FLAVOR);
                            String idSerie4 = getElement("No. Serie:", sms).replace(".", BuildConfig.FLAVOR);
                            String importe4 = getElement("Importe acreditado:", sms);
                            String valor4 = "Importe acreditado: " + importe4;
                            String moneda4 = getElement(valor4, sms).substring(0, 3);
                            String data4 = getElement("Datos del cupon:", sms);
                            List<TransportTicket> ticketList3 = DatabaseHelper.getInstance().getTCTicketWithSerie(idSerie4);
                            if (ticketList3.size() > 0) {
                                TransportTicket ticket4 = ticketList3.get(0);
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
                                    DatabaseHelper.getInstance().updateTCTicket(ticket4);
                                }
                            } else {
                                TransportTicket ticketNuevo3 = new TransportTicket();
                                ticketNuevo3.setIdTM(transaccionTM4);
                                ticketNuevo3.setIdBank(transaccionBanco4);
                                ticketNuevo3.setSerie(idSerie4);
                                ticketNuevo3.setImporte(Float.parseFloat(importe4));
                                ticketNuevo3.setMoneda(moneda4);
                                ticketNuevo3.setConsumido(false);
                                ticketNuevo3.setData(data4);
                                ticketNuevo3.setFecha(sms_properties.getDate());
                                DatabaseHelper.getInstance().addTCTicket(ticketNuevo3);
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
        return null;
    }

    private void combustibleProcess(String idSerie, Date date, String importe, String transaccionBanco, String transaccionTM, String moneda, String data) {
        try {
            List<TransportTicket> ticketList = DatabaseHelper.getInstance().getTCTicketWithSerie(idSerie);
            if (ticketList.size() > 0) {
                TransportTicket ticket = ticketList.get(0);
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
                    DatabaseHelper.getInstance().updateTCTicket(ticket);
                }
                return;
            }
            TransportTicket ticketNuevo = new TransportTicket();
            ticketNuevo.setIdTM(transaccionTM);
            ticketNuevo.setIdBank(transaccionBanco);
            ticketNuevo.setSerie(idSerie);
            ticketNuevo.setImporte(Float.parseFloat(importe));
            try {
                ticketNuevo.setMoneda(moneda);
                ticketNuevo.setConsumido(false);
                ticketNuevo.setData(data);
                ticketNuevo.setFecha(date);
                DatabaseHelper.getInstance().addTCTicket(ticketNuevo);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    // --- Utility methods ---

    /**
     * Extracts first match of regex pattern from string.
     */
    public static String getElement(String patron, String cadena) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    /**
     * Extracts match across line boundaries.
     */
    public static String getElementLine(String patron, String cadena) {
        Pattern pattern = Pattern.compile(patron, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(cadena);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    /**
     * Parses date string in multiple formats (dd/MM/yyyy HH:mm:ss, etc).
     */
    private Date parseFecha(String fechaStr) {
        String[] formats = {"dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss"};
        for (String fmt : formats) {
            try {
                return new SimpleDateFormat(fmt).parse(fechaStr);
            } catch (Exception e) {
                // try next format
            }
        }
        return null;
    }
}
