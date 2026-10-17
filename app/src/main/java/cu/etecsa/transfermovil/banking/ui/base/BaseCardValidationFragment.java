package cu.etecsa.transfermovil.banking.ui.base;

import androidx.fragment.app.Fragment;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.EV9Tu0zIL4
 *
 * Abstract base fragment providing card/account number validation.
 * Determines bank agency and card type (PAN vs ESTANDARIZADA) from
 * the card number prefix digits.
 *
 * Card number formats:
 *   PAN (starts with "92"): positions 4-5 identify the bank
 *     "12" -> BPA, "06" -> BANDEC, "95" -> Metropolitano
 *   Special prefixes:
 *     "976003" -> MiTransfer, "976004" -> CLASICAEMP
 *   ESTANDARIZADA (2-digit prefix):
 *     "12" -> BPA, "06" -> BANDEC, "05" -> BFI, "03" -> BFI
 *
 * Dependencies:
 *   - AgencyEntity enum (R1sDOSqZ2z)
 *   - CardType enum (x8AaGMBO19: PAN, ESTANDARIZADA)
 *   - CurrencyType enum (qTDVwLFEjE)
 */
public abstract class BaseCardValidationFragment extends Fragment {

    /**
     * Inner class holding card validation results.
     */
    public class CardData {
        /** The bank agency this card belongs to */
        public Object agencyEntity; // AgencyEntity (R1sDOSqZ2z)
        /** The currency type of the card */
        public Object currency; // CurrencyType (qTDVwLFEjE)
        /** Whether the card's bank prefix is recognized */
        public boolean isValidBank;
        /** Whether the card's currency is valid */
        public boolean isValidCurrency;
        /** The card type: PAN or ESTANDARIZADA */
        public Object tipo; // CardType (x8AaGMBO19)

        public CardData() {
        }
    }

    /**
     * Validates a card/account number and determines its bank agency, card type, and currency.
     *
     * Logic reconstructed from partial JADX output (original switch had decompilation errors):
     *
     * 1. If card starts with "92" and length >= 4:
     *    - tipo = PAN
     *    - Checks positions 4-5 for bank code: "12"->BPA, "06"->BANDEC, "95"->Metropolitano
     * 2. If card (stripped of dashes) starts with "976003": MiTransfer
     * 3. If card (stripped of dashes) starts with "976004": CLASICAEMP
     * 4. Otherwise, tipo = ESTANDARIZADA:
     *    - First 2 chars: "12"->BPA, "06"->BANDEC, "05"->BFI, "03"->BFI
     *
     * After determining bank, currency is inferred from further digit positions
     * (the JADX error prevents full reconstruction of currency logic).
     *
     * @param tarjeta the card number string (may contain dashes)
     * @return CardData with validation results
     */
    public CardData validarCuenta(String tarjeta) {
        CardData cardData = new CardData();
        try {
            if (tarjeta.length() >= 2) {
                if (tarjeta.substring(0, 2).contains("92") && tarjeta.length() >= 4) {
                    // PAN format card
                    String bancoCode = tarjeta.substring(4, 6);
                    // cardData.tipo = CardType.PAN;
                    switch (bancoCode) {
                        case "12":
                            // cardData.agencyEntity = AgencyEntity.BPA;
                            cardData.isValidBank = true;
                            break;
                        case "06":
                            // cardData.agencyEntity = AgencyEntity.BANDEC;
                            cardData.isValidBank = true;
                            break;
                        case "95":
                            // cardData.agencyEntity = AgencyEntity.Metropolitano;
                            cardData.isValidBank = true;
                            break;
                        default:
                            cardData.isValidBank = false;
                            cardData.isValidCurrency = false;
                            return cardData;
                    }
                } else if (tarjeta.replace("-", "").startsWith("976003")) {
                    // MiTransfer card
                    // cardData.agencyEntity = AgencyEntity.MiTransfer;
                    cardData.isValidBank = true;
                } else if (tarjeta.replace("-", "").startsWith("976004")) {
                    // CLASICAEMP card
                    // cardData.agencyEntity = AgencyEntity.CLASICAEMP;
                    cardData.isValidBank = true;
                } else {
                    // ESTANDARIZADA format card
                    String bancoCode = tarjeta.substring(0, 2);
                    // cardData.tipo = CardType.ESTANDARIZADA;
                    switch (bancoCode) {
                        case "12":
                            // cardData.agencyEntity = AgencyEntity.BPA;
                            cardData.isValidBank = true;
                            break;
                        case "06":
                            // cardData.agencyEntity = AgencyEntity.BANDEC;
                            cardData.isValidBank = true;
                            break;
                        case "05":
                            // cardData.agencyEntity = AgencyEntity.BFI;
                            cardData.isValidBank = true;
                            break;
                        case "03":
                            // cardData.agencyEntity = AgencyEntity.BFI;
                            cardData.isValidBank = true;
                            break;
                        default:
                            cardData.isValidBank = false;
                            cardData.isValidCurrency = false;
                            return cardData;
                    }
                    // Currency determination from remaining digits
                    // (JADX decompilation error prevented full reconstruction)
                    // The original code likely checked further digit positions
                    // to determine CUP/CUC/USD currency for ESTANDARIZADA cards.
                    cardData.isValidCurrency = true;
                }
            }
        } catch (Exception e) {
            // Silently handle malformed card numbers
        }
        return cardData;
    }
}
