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
        setContentView(cu.etecsa.cubacel.tr.tm.R.layout.shnhr8qmyvcga);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(cu.etecsa.cubacel.tr.tm.R.id.containerView, new EcommerceMenuFragment()).commit();
        Toolbar toolbar = (Toolbar) findViewById(cu.etecsa.cubacel.tr.tm.R.id.toolbar);
        this.toolbar = toolbar;
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(cu.etecsa.cubacel.tr.tm.R.menu.menu_splash, menu);
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
        builder.setTitle(getString(cu.etecsa.cubacel.tr.tm.R.string.confirm));
        builder.setMessage(getString(cu.etecsa.cubacel.tr.tm.R.string.confirm_close));
        builder.setPositiveButton("Cerrar", (dialog, id) -> finish());
        builder.setNegativeButton("No", null);
        builder.create().show();
    }
}
