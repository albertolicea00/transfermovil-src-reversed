package cu.etecsa.tm.ecommerce;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.PVrNBPiBYx;

/* JADX INFO: loaded from: classes.dex */
public class hd5jZHAGaN extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iyost7rs4atmc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        FragmentTransaction xfragmentTransaction = getSupportFragmentManager().beginTransaction();
        xfragmentTransaction.replace(R.id.containerView, new PVrNBPiBYx()).commit();
    }
}
