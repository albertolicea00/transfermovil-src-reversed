package cu.etecsa.transfermovil.banking.ui;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bKpfdtiEWm
 * @fingerprint Nauta account add/edit form. Fields: account email, account type spinner, client spinner.
 */
public class NautaEditFragment extends Fragment {
    private Button btnAceptar;
    private EditText inputCNauta;
    // public Nauta nauta;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public int tipo_cuenta;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
}
