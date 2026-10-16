package cu.etecsa.transfermovil.crypto.ussd;

import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class AFm1GraXBXUkpF1hmOdV.ytpPfHi93O3gQEyZrT9r
 * @fingerprint constructor(int, YzK9tTZsYVnC5kFxSie), XOR long values
 *
 * Stage 2 of USSD parameter encoding. Takes the substituted numeric string
 * from DigitSubstituter, builds a cyclic key stream from the substitution
 * list, and XORs the two as longs.
 */
public class XorCipherStep {

    private final DigitSubstituter substituter;
    private int seed;
    private int[] cyclicKey;

    /**
     * @param seed          random seed 0-99 from orchestrator
     * @param tableBuilder  provides substitution list for both stages
     */
    public XorCipherStep(int seed, SubstitutionTableBuilder tableBuilder) {
        this.seed = 0;
        this.seed = seed;
        this.substituter = new DigitSubstituter(seed, tableBuilder);
    }

    /** Returns the random seed (prepended to encoded output as first element). */
    public int getSeed() {
        return this.seed;
    }

    /**
     * Full encode pipeline for one parameter:
     * 1. Build cyclic key of same length as input
     * 2. Substitute digits via DigitSubstituter
     * 3. XOR substituted value with cyclic key (as longs)
     */
    public String encode(String numericInput) {
        buildCyclicKey(numericInput.length());
        String substituted = this.substituter.substitute(numericInput);
        return xorWithKey(substituted);
    }

    /**
     * Builds cyclic key array of given length by cycling through the
     * substitution list starting at position = seed.
     */
    private void buildCyclicKey(int length) {
        List<Integer> list = this.substituter.substitutionList;
        int listIndex = this.substituter.seed;
        this.cyclicKey = new int[length];
        for (int i = 0; i < length; i++) {
            if (listIndex == list.size() - 1) {
                this.cyclicKey[i] = list.get(0).intValue();
                listIndex = 1;
            } else if (listIndex >= 0 || listIndex < list.size()) {
                this.cyclicKey[i] = list.get(listIndex).intValue();
                listIndex++;
            }
        }
    }

    /**
     * Concatenates cyclic key digits into a numeric string, truncates to
     * match input length, then XORs both as long values.
     */
    private String xorWithKey(String substituted) {
        StringBuilder keyStr = new StringBuilder();
        for (int digit : this.cyclicKey) {
            keyStr.append(String.valueOf(digit));
        }
        String key = keyStr.toString();
        if (key.length() > substituted.length()) {
            key = key.substring(0, substituted.length());
        }
        long xorResult = Long.parseLong(key) ^ Long.parseLong(substituted);
        return String.valueOf(xorResult);
    }
}
