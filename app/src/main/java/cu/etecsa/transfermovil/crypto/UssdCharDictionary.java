package cu.etecsa.transfermovil.crypto;

import java.util.HashMap;
import java.util.Map;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.EKB7Plln4L
 * @fingerprint Character-to-2-digit-code dictionary for USSD parameter encoding.
 *              Maps 73 characters (a-z, A-Z, 0-9, accented Spanish chars, punctuation, space)
 *              to unique 2-digit numeric codes. Used by UssdMessageEncoder.
 */
public class UssdCharDictionary {

    public Map<String, String> dictionaryCode;

    public UssdCharDictionary() {
        HashMap<String, String> map = new HashMap<>();
        this.dictionaryCode = map;
        map.put(".", "15");
        map.put("-", "85");
        map.put("_", "58");
        map.put("0", "37");
        map.put("/", "11");
        map.put(",", "29");
        map.put("%", "67");
        map.put("&", "20");
        map.put("a", "59");
        map.put("b", "00");
        map.put("c", "82");
        map.put("1", "89");
        map.put("A", "05");
        map.put("B", "54");
        map.put("C", "60");
        map.put("á", "88");
        map.put("@", "64");
        map.put("d", "51");
        map.put("e", "93");
        map.put("h", "50");
        map.put("2", "41");
        map.put("D", "57");
        map.put("E", "65");
        map.put("F", "61");
        map.put("é", "91");
        map.put("#", "08");
        map.put("g", "30");
        map.put("f", "46");
        map.put("i", "97");
        map.put("3", "80");
        map.put("G", "83");
        map.put("H", "13");
        map.put("I", "55");
        map.put("í", "53");
        map.put(";", "56");
        map.put("j", "76");
        map.put("k", "25");
        map.put("l", "42");
        map.put("4", "66");
        map.put("J", "73");
        map.put("K", "17");
        map.put("L", "38");
        map.put("ó", "32");
        map.put("m", "27");
        map.put("n", "92");
        map.put("o", "12");
        map.put("ñ", "03");
        map.put("5", "01");
        map.put("M", "06");
        map.put("N", "49");
        map.put("O", "18");
        map.put("Ñ", "33");
        map.put("p", "98");
        map.put("q", "23");
        map.put("r", "31");
        map.put("6", "94");
        map.put("P", "44");
        map.put("Q", "35");
        map.put("R", "34");
        map.put("ú", "87");
        map.put("s", "19");
        map.put("t", "45");
        map.put("u", "81");
        map.put("7", "62");
        map.put("S", "22");
        map.put("T", "40");
        map.put("U", "10");
        map.put("v", "96");
        map.put("w", "69");
        map.put("x", "75");
        map.put("8", "24");
        map.put("V", "14");
        map.put("W", "70");
        map.put("X", "74");
        map.put("y", "09");
        map.put("z", "90");
        map.put(" ", "78");
        map.put("9", "72");
        map.put("Y", "71");
        map.put("Z", "07");
        map.put("Á", "99");
        map.put("É", "86");
        map.put("Í", "47");
        map.put("Ó", "36");
        map.put("Ú", "39");
        map.put("ü", "77");
        map.put("Ü", "95");
    }

    public String getCode(String value) {
        return this.dictionaryCode.get(value);
    }
}
