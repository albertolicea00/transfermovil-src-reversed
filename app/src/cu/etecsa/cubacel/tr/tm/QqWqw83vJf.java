package cu.etecsa.cubacel.tr.tm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: loaded from: classes.dex */
public class QqWqw83vJf extends AppCompatActivity {
    public Toolbar toolbar;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shnhr8qmyvcga);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new KiXWwF51Aq()).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        setSupportActionBar(toolbar);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem uyh0pxs9m37in) {
        uyh0pxs9m37in.getItemId();
        return super.onOptionsItemSelected(uyh0pxs9m37in);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int backEntry = fm.getBackStackEntryCount();
        if (backEntry > 0) {
            fm.popBackStack();
        } else {
            openQuitDialog();
        }
    }

    private void openQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.confirm));
        builder.setMessage(getString(R.string.confirm_close));
        builder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.QqWqw83vJf.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                QqWqw83vJf.this.finish();
            }
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
