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
import java.util.List;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.bflirTWE7f
 * @fingerprint Landline phone add/edit form. Fields: phone number, client spinner.
 */
public class LandlineEditFragment extends Fragment {
    private Button btnAceptar;
    private EditText inputTFijo;
    // public TelfFijo tfijo;
    public TextView toolbar_title;
    public int id_cliente_select = -1;
    // public List<Client> clientsList;
    public ArrayAdapter<CharSequence> adapter;
}
