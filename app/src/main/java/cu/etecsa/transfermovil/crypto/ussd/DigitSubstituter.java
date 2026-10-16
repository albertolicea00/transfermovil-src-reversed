package cu.etecsa.transfermovil.crypto.ussd;

import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class AFm1GraXBXUkpF1hmOdV.hKRRh7lnIpNaVleqsuo
 * @fingerprint constructor(int, YzK9tTZsYVnC5kFxSie), digit-pair lookup
 *
 * Stage 1 of USSD parameter encoding. Takes a numeric string, splits it
 * into digit pairs, and substitutes each pair using the substitution list.
 * Odd-length strings get the last digit substituted via single-digit map.
 */
public class DigitSubstituter {

    private int seed;
    private final List<Integer> substitutionList;
    private final int[] singleDigitMap = new int[10];
    private String result = "";

    /**
     * @param seed             random seed 0-99 from orchestrator
     * @param tableBuilder     provides the substitution list
     */
    public DigitSubstituter(int seed, SubstitutionTableBuilder tableBuilder) {
        this.substitutionList = new ArrayList<>();
        this.seed = 0;
        this.seed = seed;
        this.substitutionList.addAll(tableBuilder.getSubstitutionList());
    }

    /**
     * Substitutes a numeric string by processing digit pairs.
     * Even-length: each pair "AB" → substitutionList[AB] → zero-padded 2-digit result.
     * Odd-length: last digit looked up via singleDigitMap, rest processed as pairs.
     */
    public String substitute(String numericInput) {
        this.result = "";
        int i = 0;
        if (numericInput.length() % 2 == 0) {
            while (i < numericInput.length()) {
                String pair = String.valueOf(numericInput.charAt(i)) + String.valueOf(numericInput.charAt(i + 1));
                this.result = this.result + lookupPair(pair);
                i += 2;
            }
        } else {
            buildSingleDigitMap();
            String lastDigitSubstituted = lookupSingleDigit(
                    String.valueOf(numericInput.charAt(numericInput.length() - 1)));
            String withoutLast = numericInput.substring(0, numericInput.length() - 1);
            while (i < withoutLast.length()) {
                String pair = String.valueOf(withoutLast.charAt(i)) + String.valueOf(withoutLast.charAt(i + 1));
                this.result = this.result + lookupPair(pair);
                i += 2;
            }
            this.result = this.result + lastDigitSubstituted;
        }
        return this.result;
    }

    /**
     * Looks up a two-digit string "AB" in the substitution list at index AB.
     * Returns zero-padded 2-digit string (e.g., 5 → "05", 0 → "00").
     */
    private String lookupPair(String twoDigits) {
        int index = Integer.parseInt(twoDigits.substring(0, 1) + twoDigits.substring(1));
        int value = this.substitutionList.get(index).intValue();
        if (String.valueOf(value).length() != 1) {
            return String.valueOf(value);
        }
        if (value == 0) {
            return "00";
        }
        return "0" + String.valueOf(value);
    }

    /**
     * Single-digit lookup for odd-length input's last character.
     */
    private String lookupSingleDigit(String digit) {
        return String.valueOf(this.singleDigitMap[Integer.parseInt(digit)]);
    }

    /**
     * Builds single-digit map from the first 10 entries in substitutionList
     * that have value < 10.
     */
    private void buildSingleDigitMap() {
        int mapIndex = 0;
        for (Integer entry : this.substitutionList) {
            if (entry.intValue() < 10) {
                this.singleDigitMap[mapIndex] = entry.intValue();
                mapIndex++;
            }
        }
    }
}
