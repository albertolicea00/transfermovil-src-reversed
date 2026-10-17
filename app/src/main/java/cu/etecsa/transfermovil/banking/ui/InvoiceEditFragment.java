package cu.etecsa.transfermovil.banking.ui;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bJaiFoVYfK
 * @fingerprint Invoice add/edit form. Fields: invoice type spinner, invoice number,
 *              invoice code (cod_factura), client spinner.
 */
public class InvoiceEditFragment extends Fragment {
    private Button btnAceptar;
    private EditText inputCFactura;
    public ArrayAdapter<CharSequence> tcuentaAdapter;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    public int tipo_cuenta = -1;
    public int edit_tipo_cuenta = -1;
}
