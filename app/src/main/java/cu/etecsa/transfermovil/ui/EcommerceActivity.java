package cu.etecsa.transfermovil.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.QqWqw83vJf
 * @fingerprint E-commerce host activity. Loads EcommerceMenuFragment (KiXWwF51Aq)
 *              as initial fragment. Toolbar with splash menu. Back press: pop stack or confirm quit.
 */
public class EcommerceActivity extends AppCompatActivity {
    public Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.shnhr8qmyvcga);
        // FragmentManager fm = getSupportFragmentManager();
        // fm.beginTransaction()
        //   .replace(R.id.containerView, new EcommerceMenuFragment())
        //   .commit();
        // toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            openQuitDialog();
        }
    }

    private void openQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setTitle(getString(R.string.confirm));
        // builder.setMessage(getString(R.string.confirm_close));
        builder.setPositiveButton("Cerrar", (dialog, id) -> finish());
        builder.setNegativeButton("No", null);
        builder.create().show();
    }
}
