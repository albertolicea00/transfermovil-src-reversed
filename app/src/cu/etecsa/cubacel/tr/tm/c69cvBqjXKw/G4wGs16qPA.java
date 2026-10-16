package cu.etecsa.cubacel.tr.tm.c69cvBqjXKw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.HrLy23Pb9b;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;

/* JADX INFO: loaded from: classes.dex */
public class G4wGs16qPA extends Fragment {
    public HrLy23Pb9b actionEntity;
    public Button btAcceder;
    public Context context;
    public Nl0yptXmjQ operationEntity;
    public View rootView;
    public String titulo;
    public TextView txTextoAcceso;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.o263eoyep9cask, container, false);
        this.context = container.getContext();
        if (getArguments() != null && getArguments().containsKey("HrLy23Pb9b") && getArguments().containsKey("Nl0yptXmjQ")) {
            this.actionEntity = (HrLy23Pb9b) getArguments().getSerializable("HrLy23Pb9b");
            this.operationEntity = (Nl0yptXmjQ) getArguments().getSerializable("Nl0yptXmjQ");
            this.titulo = getArguments().getString("Titulo");
        }
        this.txTextoAcceso = (TextView) this.rootView.findViewById(R.id.txTextoAcceso);
        Button button = (Button) this.rootView.findViewById(R.id.btAcceder);
        this.btAcceder = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.G4wGs16qPA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction();
        if (requestCode == 1 && resultCode == 2) {
            Fragment parentFragment = getParentFragment();
            boolean z = parentFragment instanceof wTZi6Zeikv;
        }
    }

    private void showDialog() {
        try {
            GRGvmCZD7R dialogFrag = GRGvmCZD7R.newInstance(this.operationEntity, this.actionEntity, this.titulo);
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
