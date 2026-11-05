package cu.etecsa.transfermovil.data;

import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import cu.etecsa.transfermovil.core.enums.BankType;

/** Adapter for the APK's encrypted per-bank QR account storage. */
public final class BankCodeAccessor {
    private BankCodeAccessor() { }

    private static R1sDOSqZ2z toSourceBank(BankType bank) {
        return R1sDOSqZ2z.valueOf(bank.name());
    }

    public static String getQrCode(BankType bank) {
        return new rDEl7rW1aN().getqrcodeBk(toSourceBank(bank));
    }

    public static boolean setQrCode(BankType bank, String account) {
        return new rDEl7rW1aN().setqrcodeBk(toSourceBank(bank), account);
    }
}
