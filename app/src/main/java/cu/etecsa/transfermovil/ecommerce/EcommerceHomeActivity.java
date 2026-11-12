package cu.etecsa.transfermovil.ecommerce;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import cu.etecsa.tm.ecommerce.R;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.hd5jZHAGaN
 * @original_apk_version 1.260416
 */
public class EcommerceHomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iyost7rs4atmc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new EcommerceHomeFragment()).commit();
    }
}
