package cu.etecsa.transfermovil.banking.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.yn4mwNjGz0
 * @fingerprint PIN add/edit form. Fields: pin number, currency (CUP/CUC spinner).
 *              Toolbar shows "Nuevo Pin" or "Editar Pin" based on editMode.
 */
public class PinEditFragment extends Fragment {
    private Button btnAceptar;
    private EditText inputPin;
    public ArrayAdapter<CharSequence> adapter;
    public TextView toolbar_title;
    public boolean editMode = false;

    // onCreateView → inflate form, bind fields, setup currency spinner
    // If editing: populate from Pin object
    // btnAceptar → validate → addPin or updatePin
}
