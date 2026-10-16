package cu.etecsa.transfermovil.crypto.ussd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class AFm1GraXBXUkpF1hmOdV.Tz34gww2TFwrsuT8ukpL
 * @fingerprint Random().nextInt(100), constructor(String, String)
 *
 * Orchestrates the two-stage USSD parameter encoding:
 *   1. Digit-pair substitution via lookup table (DigitSubstituter)
 *   2. XOR with cyclic key stream (XorCipherStep)
 *
 * Usage: construct with (codeVersion, crudeCode), then call encode(paramList).
 * The random seed (0-99) is regenerated per instance and prepended to output.
 *
 * This is obfuscation, not encryption — fully reversible with the static
 * constants from the APK (code_version and crude_code).
 */
public class UssdCipherOrchestrator {

    private int seed;
    private final SubstitutionTableBuilder tableBuilder;

    /**
     * @param codeVersion  "372653282298718711" — controls binary parsing shifts
     * @param crudeCode    1024-char binary string — the substitution lookup table
     */
    public UssdCipherOrchestrator(String codeVersion, String crudeCode) {
        this.tableBuilder = new SubstitutionTableBuilder(crudeCode, codeVersion);
        generateSeed();
    }

    /**
     * Encodes a list of numeric parameters for USSD transmission.
     *
     * @param params  list of numeric strings (e.g., PIN, amount, account number)
     * @return encoded list: first element is the seed, rest are encoded params
     */
    public List<String> encode(List<String> params) {
        ArrayList<String> encoded = new ArrayList<>();
        XorCipherStep xorStep = new XorCipherStep(this.seed, this.tableBuilder);
        encoded.add(String.valueOf(xorStep.getSeed()));
        for (String param : params) {
            encoded.add(xorStep.encode(param));
        }
        return encoded;
    }

    private void generateSeed() {
        this.seed = new Random().nextInt(100);
    }
}
