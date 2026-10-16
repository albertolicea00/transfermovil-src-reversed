package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.jceCwl8l2R;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class SUXnX1ucFU extends Fragment {
    public ArrayAdapter<CharSequence> adapterTipoMoneda;
    public ArrayAdapter<CharSequence> adapterTipoMonedaImporte;
    public Context context;
    public TextInputLayout inputLayoutTipoMoneda;
    public TextInputLayout inputLayoutTipoMonedaImporte;
    public View rootView;
    public jceCwl8l2R seleccionTransferencia;
    private jN13TOyLMX.OnItemClickListener spClickMonedaImporte = new jN13TOyLMX.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SUXnX1ucFU.1
        @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.jN13TOyLMX.OnItemClickListener
        public void onItemClick(View view, int position) {
        }
    };
    public jN13TOyLMX spinnerTipoMoneda;
    public jN13TOyLMX spinnerTipoMonedaTarjeta;
    public String[] tipomoneda;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.rootView;
    }

    public String getSQLStatementInsert(String table, String columns, String values) {
        try {
            return String.format("Insert into %s (%s) values (%s)", table, columns, values);
        } catch (Exception e) {
            return null;
        }
    }

    private String enc(String data) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest(data.getBytes());
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + RecyclerView.ViewHolder.FLAG_TMP_DETACHED, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String cadena = sb.toString();
        return cadena;
    }

    public String getRandomString() {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(20);
        for (int i = 0; i < 20; i++) {
            int randomLimitedInt = ((int) (random.nextFloat() * ((122 - 97) + 1))) + 97;
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public void encTest() {
        V5FFEZ0Qrr0.cH(" 11II3FqMi3ch2FAflI/I6lzFAcn82OeZoHD698WsA2c=", "MM1234", "10011553");
    }
}
