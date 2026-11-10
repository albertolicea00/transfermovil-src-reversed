package cu.etecsa.transfermovil.ui.fragment.banking.bandec.operations;

import android.os.Bundle;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;

/**
 * BANDEC fine query form for traffic and contravention fines.
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6
 */
public class BandecFineQueryFragment extends ULFE6hmQU6 {
    public static BandecFineQueryFragment newInstance(ULFE6hmQU6.TipoMulta fineType) {
        BandecFineQueryFragment fragment = new BandecFineQueryFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("TipoMultaEntity", fineType);
        arguments.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
        fragment.setArguments(arguments);
        return fragment;
    }
}
