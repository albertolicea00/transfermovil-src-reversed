package cu.etecsa.transfermovil.banking.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import cu.etecsa.transfermovil.core.enums.AuthAction;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.G4wGs16qPA
 * @fingerprint Access code entry fragment. Receives AuthAction + Operation enums via arguments.
 *              Shows auth dialog (AuthDialogFragment) on button click.
 *              Checks parent fragment type (DataManagementGeneralPagerFragment) on activity result.
 */
public class AccessCodeFragment extends Fragment {

    public AuthAction actionEntity;
    public Button btAcceder;
    public Context context;
    // public Operation operationEntity; // Nl0yptXmjQ
    public View rootView;
    public String titulo;
    public TextView txTextoAcceso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.o263eoyep9cask, container, false);
        this.context = container.getContext();
        if (getArguments() != null
                && getArguments().containsKey("HrLy23Pb9b")
                && getArguments().containsKey("Nl0yptXmjQ")) {
            this.actionEntity = (AuthAction) getArguments().getSerializable("HrLy23Pb9b");
            this.titulo = getArguments().getString("Titulo");
        }
        this.txTextoAcceso = (TextView) this.rootView.findViewById(R.id.txTextoAcceso);
        Button button = (Button) this.rootView.findViewById(R.id.btAcceder);
        this.btAcceder = button;
        button.setOnClickListener(v -> {});
        return this.rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getActivity().getSupportFragmentManager().beginTransaction();
        if (requestCode == 1 && resultCode == 2) {
            Fragment parentFragment = getParentFragment();
            boolean isGeneralPager = parentFragment instanceof DataManagementGeneralPagerFragment;
        }
    }

    private void showDialog() {
        try {
            AuthDialogFragment dialogFrag = AuthDialogFragment.newInstance(
                    /* operationEntity, actionEntity, titulo */);
            if (dialogFrag.getDialog() != null) {
                dialogFrag.getDialog().setCanceledOnTouchOutside(true);
            }
            dialogFrag.setTargetFragment(this, 1);
            dialogFrag.setCancelable(false);
            dialogFrag.show(getFragmentManager(), "fragment_PAGO");
        } catch (Exception e) {
        }
    }
}
