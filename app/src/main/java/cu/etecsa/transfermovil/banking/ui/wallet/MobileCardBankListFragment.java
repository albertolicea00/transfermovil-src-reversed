package cu.etecsa.transfermovil.banking.ui.wallet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.WriterException;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.x6Wob3Sa98U;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.banking.ui.bfi.BfiEnterpriseTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.banking.bandec.payment.BandecTransferFragment;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.MobileCardBank;
import cu.etecsa.transfermovil.ui.fragment.BfiTransferFragment;
import cu.etecsa.transfermovil.ui.qr.QrCodeGenerator;
import java.util.ArrayList;
import java.util.List;

/** Clean MiTransfer saved-account list migrated from KeTIEVSfVo. */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo */
public class MobileCardBankListFragment extends Fragment implements MobileCardBankAdapter.Listener {
    private static final String QR_TRANSFER_HEADER = "TRANSFERMOVIL_ETECSA,TRANSFERENCIA";
    private Context context;
    private ImageView cardsEmpty;
    private RecyclerView recyclerView;
    private MobileCardBankAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        View root = inflater.inflate(R.layout.x7hqio7zhb0epj, container, false);
        context = container.getContext();
        DatabaseHelper.init(context);
        cardsEmpty = root.findViewById(R.id.imCards);
        recyclerView = root.findViewById(R.id.drawerList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new MobileCardBankAdapter(context);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton add = root.findViewById(R.id.btActionAccount);
        add.setOnClickListener(v -> openEditor(null));
        cardsEmpty.setOnClickListener(v -> openEditor(null));
        add.setOnLongClickListener(v -> {
            v.setOnTouchListener(new View.OnTouchListener() {
                @Override public boolean onTouch(View view, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                        view.setOnTouchListener(null);
                    } else if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
                        view.setX(event.getRawX() - 120.0f);
                        view.setY(event.getRawY() - 425.0f);
                    }
                    return true;
                }
            });
            return true;
        });
        refreshAccounts();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) refreshAccounts();
    }

    private void refreshAccounts() {
        DatabaseHelper.init(context);
        List<MobileCardBank> accounts = DatabaseHelper.getInstance().getAllMCBankLists();
        if (accounts == null) accounts = new ArrayList<>();
        cardsEmpty.setVisibility(accounts.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setItems(accounts);
    }

    private void openEditor(Integer accountId) {
        List<MobileCardBank> accounts = DatabaseHelper.getInstance().getAllMCBankLists();
        if (accountId == null && (accounts == null || accounts.size() >= 20)) {
            new AlertDialog.Builder(context).setTitle("Aviso")
                    .setMessage("Ha superado la cantidad de cuentas a insertar en la aplicación.")
                    .setPositiveButton("Si", null).show();
            return;
        }
        MobileCardBankEditFragment editor = new MobileCardBankEditFragment();
        if (accountId != null) {
            Bundle args = new Bundle();
            args.putInt("cuenta_id", accountId);
            editor.setArguments(args);
        }
        navigate(editor, null);
    }

    private void navigate(Fragment fragment, Bundle args) {
        if (args != null) fragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onEdit(MobileCardBank account) {
        openEditor(account.getId());
    }

    @Override
    public void onDelete(MobileCardBank account) {
        DatabaseHelper.getInstance().deleteMCBank(account);
        refreshAccounts();
    }

    @Override
    public void onShare(MobileCardBank account) {
        Intent send = new Intent(Intent.ACTION_SEND);
        send.putExtra(Intent.EXTRA_TEXT, "He compartido con usted desde Transfermóvil mi número de cuenta bancaria: "
                + account.getCuenta() + " . Antes de utilizar la cuenta rectifique el número compartido.");
        send.setType("text/plain");
        startActivity(Intent.createChooser(send, null));
    }

    @Override
    public void onQr(MobileCardBank account) {
        try {
            String payload = QR_TRANSFER_HEADER + "," + account.getCuenta() + ","
                    + account.getMovil_notificar() + ",";
            Bitmap logo = BitmapFactory.decodeResource(context.getResources(), R.drawable.etecsa);
            Bitmap qr = QrCodeGenerator.ProductLogo(logo, payload, false, R.color.primaryDarkColor);
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            View content = LayoutInflater.from(context).inflate(R.layout.qtpdr8ekovu2m, null);
            ((ImageView) content.findViewById(R.id.profile_img_popup)).setImageBitmap(qr);
            dialog.setContentView(content);
            dialog.show();
        } catch (WriterException e) {
            android.util.Log.e("MobileCardBankList", "QR generation failed", e);
        }
    }

    @Override
    public void onTransfer(MobileCardBank account) {
        Bundle args = new Bundle();
        args.putInt("cuenta_origen_id", account.getId());
        BankType bank = account.getAgencia();
        if (bank == BankType.Metropolitano) {
            navigate(new x6Wob3Sa98U(), args);
        } else if (bank == BankType.BANDEC) {
            navigate(new BandecTransferFragment(), args);
        } else if (bank == BankType.BPA) {
            navigate(new iN1lHDKE5h(), args);
        } else if (bank == BankType.BFI) {
            showBfiTransferChoices();
        } else if (bank == BankType.MiTransfer) {
            navigate(new WalletClassicTransferFragment(), args);
        } else if (bank == BankType.CLASICAEMP) {
            showEnterpriseTransferChoices(args);
        } else {
            new AlertDialog.Builder(context).setTitle("Notificación")
                    .setMessage("El banco especificado no tiene habilitada esta opción.")
                    .setPositiveButton("OK", null).show();
        }
    }

    private void showBfiTransferChoices() {
        CharSequence[] choices = {
                context.getString(R.string.tx_bfi_transferencia_con_solic),
                context.getString(R.string.tx_bfi_transferencia_con_confirm),
                context.getString(R.string.tx_bfi_transferencia_indistinta)
        };
        new AlertDialog.Builder(context).setTitle("Seleccione opción")
                .setSingleChoiceItems(choices, -1, (dialog, index) -> {
                    Bundle args = new Bundle();
                    args.putSerializable("TransferType", Integer.valueOf(index));
                    navigate(new BfiEnterpriseTransferFragment(), args);
                    dialog.dismiss();
                }).setNegativeButton("Salir", (dialog, which) -> dialog.dismiss()).show();
    }

    private void showEnterpriseTransferChoices(Bundle args) {
        CharSequence[] choices = {
                context.getString(R.string.tx_bfi_transferencia_con_solic),
                context.getString(R.string.tx_bfi_transferencia_con_confirm)
        };
        new AlertDialog.Builder(context).setTitle("Seleccione opción")
                .setSingleChoiceItems(choices, -1, (dialog, index) -> {
                    args.putSerializable("TransferType", Integer.valueOf(index));
                    navigate(new BfiTransferFragment(), args);
                    dialog.dismiss();
                }).setNegativeButton("Salir", (dialog, which) -> dialog.dismiss()).show();
    }
}
