package cu.etecsa.transfermovil.banking.ui.bfi;

import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.x8AaGMBO19;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4 */
public abstract class BankingAccountValidatorFragment extends Fragment {
    public class DatosTarjeta {
        public R1sDOSqZ2z agencyEntity;
        public qTDVwLFEjE currency;
        public boolean isValidBank;
        public boolean isValidCurrency;
        public x8AaGMBO19 tipo;
    }

    /** Recovered from the v162 smali; malformed or too-short values return null. */
    public DatosTarjeta validarCuenta(String tarjeta) {
        DatosTarjeta datos = new DatosTarjeta();
        try {
            if (tarjeta.length() < 2) {
                datos.tipo = x8AaGMBO19.NONE;
                datos.isValidBank = false;
                datos.isValidCurrency = false;
                return datos;
            }

            if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 4) {
                String bancoCode = tarjeta.substring(4, 6);
                datos.tipo = x8AaGMBO19.PAN;
                if ("12".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.BPA;
                } else if ("06".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.BANDEC;
                } else if ("95".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.Metropolitano;
                } else {
                    datos.isValidBank = false;
                    datos.isValidCurrency = false;
                    return datos;
                }
                datos.isValidBank = true;
            } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
                datos.agencyEntity = R1sDOSqZ2z.MiTransfer;
                datos.isValidBank = true;
            } else if (tarjeta.replace("-", BuildConfig.FLAVOR).startsWith("976004")) {
                datos.agencyEntity = R1sDOSqZ2z.CLASICAEMP;
                datos.isValidBank = true;
            } else {
                String bancoCode = tarjeta.substring(0, 2);
                datos.tipo = x8AaGMBO19.ESTANDARIZADA;
                if ("12".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.BPA;
                } else if ("06".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.BANDEC;
                } else if ("05".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.Metropolitano;
                } else if ("03".equals(bancoCode)) {
                    datos.agencyEntity = R1sDOSqZ2z.BFI;
                } else {
                    datos.isValidBank = false;
                    datos.isValidCurrency = false;
                    return datos;
                }
                datos.isValidBank = true;
            }

            if (datos.tipo == x8AaGMBO19.PAN) {
                String moneda = tarjeta.substring(2, 4);
                datos.isValidCurrency = true;
                if (moneda.contains("25") || moneda.contains("26") || moneda.contains("28")
                        || moneda.contains("29") || moneda.contains("35") || moneda.contains("45")) {
                    datos.currency = qTDVwLFEjE.USD;
                } else {
                    datos.currency = qTDVwLFEjE.OTHER;
                }
            } else if (datos.tipo == x8AaGMBO19.ESTANDARIZADA) {
                char currencyDigit = tarjeta.charAt(14);
                datos.isValidCurrency = true;
                switch (currencyDigit) {
                    case '1': datos.currency = qTDVwLFEjE.CUP; break;
                    case '2': datos.currency = qTDVwLFEjE.CUC; break;
                    case '3': datos.currency = qTDVwLFEjE.USD; break;
                    default:
                        datos.isValidCurrency = false;
                        datos.currency = qTDVwLFEjE.NONE;
                        break;
                }
            }
            return datos;
        } catch (Exception ignored) {
            return null;
        }
    }
}
