package cu.etecsa.transfermovil.crypto.ussd;

import java.util.ArrayList;
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class AFm1GraXBXUkpF1hmOdV.YzK9tTZsYVnC5kFxSie
 * @fingerprint constructor(String, String), parses binary string into int list
 *
 * Parses the 1024-char binary lookup table (crude_code) using code_version
 * digits as shift offsets. Produces a substitution list where each entry
 * is an 8-bit integer derived from the binary string.
 */
public class SubstitutionTableBuilder {

    private final List<Integer> substitutionList = new ArrayList<>();
    private final int[][] matrix = new int[10][10];
    private String binaryTable;

    /**
     * @param binaryTable  crude_code — 1024-char binary string ("0"/"1")
     * @param codeVersion  code_version — digit string controlling shift offsets
     */
    public SubstitutionTableBuilder(String binaryTable, String codeVersion) {
        this.binaryTable = binaryTable;
        buildSubstitutionList(codeVersion);
    }

    public List<Integer> getSubstitutionList() {
        return this.substitutionList;
    }

    /**
     * For each digit in codeVersion, shifts binaryTable left by that digit's
     * numeric value, extracts first 8 bits as an integer, then advances past
     * those 8 bits. Repeats cycling through codeVersion digits until the
     * binary string is exhausted.
     */
    private void buildSubstitutionList(String codeVersion) {
        String remaining = this.binaryTable;
        int length = remaining.length();
        while (true) {
            int versionIndex = 0;
            while (length > 0) {
                int shift = Character.getNumericValue(codeVersion.charAt(versionIndex));
                String shifted = remaining.substring(shift, remaining.length());
                String eightBits = shifted.substring(0, 8);
                remaining = shifted.substring(8, shifted.length());
                length = remaining.length();
                this.substitutionList.add(Integer.valueOf(Integer.parseInt(eightBits, 2)));
                if (versionIndex != codeVersion.length() - 1) {
                    versionIndex++;
                }
            }
            return;
        }
    }
}
