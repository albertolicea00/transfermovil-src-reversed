package cu.etecsa.transfermovil.banking.ui.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.transfermovil.base.BaseMainActivity;
import cu.etecsa.transfermovil.core.enums.BankType;
import cu.etecsa.transfermovil.core.enums.Currency;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.MobileCardBank;
import java.util.List;

/** @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.HTmIvOo9nb */
public class WalletClassicAccountAssociationFragment extends Fragment
        implements FBsQzP3Zfj.UssdBaseObserver {
    private Activity activity;
    private Context context;
    private View rootView;
    private AutoCompleteTextView inputCuenta;
    private AutoCompleteTextView inputAutorizo;
    private AutoCompleteTextView inputTerminal;
    private TextInputLayout inputLayoutCuenta;
    private TextInputLayout inputLayoutAutorizo;
    private TextInputLayout inputLayoutTerminal;
    private Drawable tarjetaClasica;
    private String cuenta;
    private String cuentaCaracteres = BuildConfig.FLAVOR;
    private int keyDel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        rootView = inflater.inflate(R.layout.jdxp7ybexy1mx, container, false);
        context = container.getContext();
        DatabaseHelper.init(context);
        inputLayoutCuenta = rootView.findViewById(R.id.inputLayoutCuenta);
        inputLayoutAutorizo = rootView.findViewById(R.id.inputLayoutAutorizo);
        inputLayoutTerminal = rootView.findViewById(R.id.inputLayoutTerminal);
        inputCuenta = rootView.findViewById(R.id.inputCuenta);
        inputAutorizo = rootView.findViewById(R.id.inputAutorizo);
        inputTerminal = rootView.findViewById(R.id.inputTerminal);
        AppCompatImageView help = rootView.findViewById(R.id.btHelp);
        Button accept = rootView.findViewById(R.id.btn_aceptar);
        accept.setOnClickListener(view -> submitForm());
        loadDrawable();
        installAccountFormatting();
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("Cuenta")) {
            String savedAccount = arguments.getString("Cuenta");
            if (savedAccount != null) {
                inputCuenta.setText(formatAccount(savedAccount));
                setCardIcon(true);
            }
        }
        help.setOnClickListener(view -> showHelp());
        return rootView;
    }

    private void submitForm() {
        if (!validateAccount() || !validateAuthorization() || !validateTerminal()) return;
        cuenta = inputCuenta.getText().toString().trim();
        String authorization = inputAutorizo.getText().toString().trim();
        String terminal = inputTerminal.getText().toString().trim();
        String account = cuenta.replace("-", BuildConfig.FLAVOR);
        String payload = "08*" + account + "*" + authorization + "*" + terminal;
        ViewGroup form = rootView.findViewById(R.id.frmAsocClasica);
        FBsQzP3Zfj.actionCallUSSDBackAsocClasica(context, "111", payload,
                "Desea asociar la cuenta: " + account + "?", form, getFragmentManager(), this);
    }

    private boolean validateAccount() {
        String value = inputCuenta.getText().toString().trim();
        if (value.isEmpty()) {
            inputLayoutCuenta.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(inputCuenta);
            return false;
        }
        if (value.replace("-", BuildConfig.FLAVOR).trim().length() != 16) {
            inputLayoutCuenta.setError(getString(R.string.err_msg_len_cuenta_trans));
            requestFocus(inputCuenta);
            return false;
        }
        if (!value.replace("-", BuildConfig.FLAVOR).startsWith("976003")) {
            inputLayoutCuenta.setError(getString(R.string.err_msg_err_tarjeta_clasica));
            requestFocus(inputCuenta);
            return false;
        }
        inputLayoutCuenta.setErrorEnabled(false);
        return true;
    }

    private boolean validateAuthorization() {
        String value = inputAutorizo.getText().toString().trim();
        if (value.isEmpty()) {
            inputLayoutAutorizo.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(inputAutorizo);
            return false;
        }
        if (value.length() != 6) {
            inputLayoutAutorizo.setError(getString(R.string.err_msg_len_autorizo));
            requestFocus(inputAutorizo);
            return false;
        }
        inputLayoutAutorizo.setErrorEnabled(false);
        return true;
    }

    private boolean validateTerminal() {
        String value = inputTerminal.getText().toString().trim();
        if (value.isEmpty()) {
            inputLayoutTerminal.setError(getString(R.string.err_msg_empty_cuenta));
            requestFocus(inputTerminal);
            return false;
        }
        if (value.length() != 8) {
            inputLayoutTerminal.setError(getString(R.string.err_msg_len_terminal));
            requestFocus(inputTerminal);
            return false;
        }
        inputLayoutTerminal.setErrorEnabled(false);
        return true;
    }

    private void installAccountFormatting() {
        inputCuenta.addTextChangedListener(new TextWatcher() {
            private boolean formatting;

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (formatting) return;
                if (count == 16 && s.length() == 16) {
                    formatting = true;
                    inputCuenta.setText(formatAccount(s.toString()));
                    inputCuenta.setSelection(inputCuenta.length());
                    formatting = false;
                    return;
                }
                if (count == 0) keyDel = 1;
                String raw = s.toString();
                for (String block : raw.split("-")) {
                    if (block.length() > 4) {
                        formatting = true;
                        inputCuenta.setText(cuentaCaracteres);
                        inputCuenta.setSelection(inputCuenta.length());
                        formatting = false;
                        return;
                    }
                }
                if (keyDel != 0) {
                    cuentaCaracteres = raw;
                    keyDel = 0;
                    return;
                }
                if ((raw.length() + 1) % 5 == 0 && raw.split("-").length <= 3) {
                    formatting = true;
                    inputCuenta.setText(raw + "-");
                    inputCuenta.setSelection(inputCuenta.length());
                    formatting = false;
                }
                cuentaCaracteres = inputCuenta.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable value) {
                String card = value.toString().replace("-", BuildConfig.FLAVOR).trim();
                if (card.length() >= 6) setCardIcon(card.startsWith("976003"));
            }
        });
    }

    private String formatAccount(String account) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < account.length(); i++) {
            formatted.append(account.charAt(i));
            if ((formatted.length() + 1) % 5 == 0 && formatted.toString().split("-").length <= 3) {
                formatted.append('-');
            }
        }
        return formatted.toString();
    }

    private void loadDrawable() {
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.tarjeta_clasica)).getBitmap();
        tarjetaClasica = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 80, 60, true));
    }

    private void setCardIcon(boolean visible) {
        inputCuenta.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null,
                visible ? tarjetaClasica : null, null);
    }

    private void requestFocus(View view) {
        if (view.requestFocus() && getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    private void showHelp() {
        String message = "Los datos solicitados Autorizo (Aut) y Terminal (TML) se obtienen de un comprobante de compra emitido por un POS.";
        SpannableString styled = new SpannableString(message);
        int aut = message.indexOf("Autorizo (Aut)");
        int tml = message.indexOf("Terminal (TML)");
        styled.setSpan(new StyleSpan(1), aut, aut + "Autorizo (Aut)".length(), 33);
        styled.setSpan(new StyleSpan(1), tml, tml + "Terminal (TML)".length(), 33);
        Activity host = activity;
        if (host == null) return;
        host.runOnUiThread(() -> {
            AlertDialog dialog = new AlertDialog.Builder(getContext()).setTitle("Ayuda")
                    .setMessage(styled).setPositiveButton("OK", (d, which) -> d.cancel()).create();
            dialog.show();
            TextView text = dialog.findViewById(android.R.id.message);
            if (text != null) text.setMovementMethod(LinkMovementMethod.getInstance());
        });
    }

    @Override
    public void onCloseAndBack() {
        FragmentManager fragments = getFragmentManager();
        if (fragments != null) {
            fragments.popBackStack();
            fragments.popBackStack();
        }
    }

    @Override
    public void onClose(boolean result) {
        if (!result) return;
        int profile = getArguments() != null && getArguments().containsKey("PerfilCUenta")
                ? getArguments().getInt("PerfilCUenta") : 0;
        if (profile != 1) {
            String alias = "Clásica-" + cuenta.split("-")[3];
            String plainAccount = cuenta.contains("-")
                    ? cuenta.replace("-", BuildConfig.FLAVOR) : cuenta;
            MobileCardBank card = new MobileCardBank();
            card.setAlias(alias);
            card.setCuenta(plainAccount);
            card.setTipo_moneda(Currency.USD);
            card.setAgencia(BankType.MiTransfer);
            DatabaseHelper.init(context);
            String encrypted = new BaseMainActivity().encryption(plainAccount);
            List<MobileCardBank> byAccount = DatabaseHelper.getInstance().getMiCuenta(encrypted);
            List<MobileCardBank> byAlias = DatabaseHelper.getInstance().getMisCuentasAlias(alias);
            if (byAccount != null && byAccount.isEmpty() && byAlias != null && byAlias.isEmpty()) {
                DatabaseHelper.getInstance().addMCBank(card);
            }
        } else {
            FragmentManager fragments = getFragmentManager();
            if (fragments != null) fragments.popBackStack();
        }
        FragmentManager fragments = getFragmentManager();
        if (fragments != null) fragments.popBackStack();
    }
}
