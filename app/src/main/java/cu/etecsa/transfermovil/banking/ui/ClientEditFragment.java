package cu.etecsa.transfermovil.banking.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.cAnuWG2fly
 * @fingerprint Client add/edit form. Fields: name, phone, CI (identity number), address.
 *              Tracks counts of associated records (fijos, moviles, nauta, facturas).
 *              On save: addClientGetID or updateClient via DatabaseHelper.
 */
public class ClientEditFragment extends Fragment {
    // public Client cliente;
    private Button btnAceptar;
    private EditText inputName;
    private EditText inputPhone;
    private EditText inputCi;
    private EditText inputAddress;
    public TextView toolbar_title;
    public int cantidad_fijos = 0;
    public int cantidad_moviles = 0;
    public int cantidad_nauta = 0;
    public int cantidad_facturas = 0;

    // onCreateView → inflate form layout, bind fields
    // If editing: populate fields from Client object
    // btnAceptar → validate → save to DB → navigate back
}
