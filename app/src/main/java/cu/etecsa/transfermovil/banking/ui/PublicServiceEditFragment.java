package cu.etecsa.transfermovil.banking.ui;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.R2dyFo85vQ4
 * @fingerprint Public service add/edit form. Fields: service type spinner, service number,
 *              client spinner.
 */
public class PublicServiceEditFragment extends Fragment {
    private Button btnAceptar;
    private EditText inputCFactura;
    // public ServicioPublico servicioPublico;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public int tipo_cuenta = -1;
    public int edit_tipo_cuenta = -1;
}
