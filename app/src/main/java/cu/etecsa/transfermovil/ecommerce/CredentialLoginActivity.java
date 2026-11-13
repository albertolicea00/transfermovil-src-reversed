package cu.etecsa.transfermovil.ecommerce;

import cu.etecsa.tm.ecommerce.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.C1b1PWKeZSE
 * @original_apk_version 1.260416
 */
public class CredentialLoginActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paiboxo0oxiva);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FragmentTransaction xfragmentTransaction = getSupportFragmentManager().beginTransaction();
        xfragmentTransaction.replace(R.id.containerView, new CredentialLoginFragment()).commit();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
