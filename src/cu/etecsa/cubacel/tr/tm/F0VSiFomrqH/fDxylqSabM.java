package cu.etecsa.cubacel.tr.tm.F0VSiFomrqH;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Client;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UkO3Y6TcHD;
import cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.U4uiCgRvr6;

/* JADX INFO: loaded from: classes.dex */
public class fDxylqSabM extends Fragment {
    private Button Button0;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button ClearBtn;
    private Button btnAceptar;
    public Client cliente;
    private EditText codeEdit;
    public Context context;
    public TextView toolbar_title;
    public String code1 = BuildConfig.FLAVOR;
    public String code2 = "6613c28d4045f9f7dfbb740c3e54724f220719620502c29b22fe96ef20c9b585";
    public String code3 = "6e092fbf4ba82a31a6041fb765b0b0d672b460eb6222cd0bc2b0999d73a72801";
    public String code4 = "b484767f274dab1fa6bed3fa95f99b044ae174390693b27ed8eeca0d688e7851";
    public String code5 = "a01f929ed340c7f45aacc6c5f4f33180fe0483c47d55f3d46e742f7cc2562df4";
    public String code6 = "a1b40bf56b6cdf465cc1aafb61a12f173ba8f39560f91d6f96efeaa264a01904";
    public String code7 = "1e8ca0e81402900fe142b5355a1723cf7d3fa196a7e239393f2bb61011676763";
    public String universal = "2d8e2633b04cee57eaead8737301330bd40a8482d3b1c4b5862dc6218accc938";
    public String code8 = "f248c07a334ffcbb633895b01722d87613fa31f083d768c644d3829f961541ef";
    public String code9 = "efbfb0e6ec1e7b516e7be93098729b012d0ed73a5e805c2b11a6f68544ac15e9";
    public String code10 = "920ef8938a9afcb782aa970b594156b9cade539c6138858fcacc6dc0ee1aa4ec";
    public String code11 = "92128c7fc22f3f685e9914450a0bd855e258aafff9351663260b080a4a7c5188";
    public String code12 = "f46575a329a230b15f81527dbee5186f23ed7dbd381ad6c00662e5655083cc34";
    public String code13 = "c0ed2d7859d1938feef9fd0c7ab231fb0e3366f4fb75ef82b9c95ccf6160bbd0";
    public String code14 = "b55c5134f66d2f0562339be311e902679dd75ed42f7f215c22583564ffe32dbf";
    public boolean editMode = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.h5kgnjnkxu0hcd, container, false);
        this.context = container.getContext();
        this.toolbar_title = (TextView) rootView.findViewById(R.id.toolbar_title);
        this.codeEdit = (EditText) rootView.findViewById(R.id.editTextCode);
        Button button = (Button) rootView.findViewById(R.id.buttonAceptar);
        this.btnAceptar = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                fdxylqsabm.code1 = UkO3Y6TcHD.generateSHA256(fdxylqsabm.code1);
                fDxylqSabM fdxylqsabm2 = fDxylqSabM.this;
                if (!fdxylqsabm2.code1.equals(fdxylqsabm2.code2)) {
                    fDxylqSabM fdxylqsabm3 = fDxylqSabM.this;
                    if (!fdxylqsabm3.code1.equals(fdxylqsabm3.code3)) {
                        fDxylqSabM fdxylqsabm4 = fDxylqSabM.this;
                        if (!fdxylqsabm4.code1.equals(fdxylqsabm4.code4)) {
                            fDxylqSabM fdxylqsabm5 = fDxylqSabM.this;
                            if (!fdxylqsabm5.code1.equals(fdxylqsabm5.code5)) {
                                fDxylqSabM fdxylqsabm6 = fDxylqSabM.this;
                                if (!fdxylqsabm6.code1.equals(fdxylqsabm6.code6)) {
                                    fDxylqSabM fdxylqsabm7 = fDxylqSabM.this;
                                    if (!fdxylqsabm7.code1.equals(fdxylqsabm7.code7)) {
                                        fDxylqSabM fdxylqsabm8 = fDxylqSabM.this;
                                        if (!fdxylqsabm8.code1.equals(fdxylqsabm8.code8)) {
                                            fDxylqSabM fdxylqsabm9 = fDxylqSabM.this;
                                            if (!fdxylqsabm9.code1.equals(fdxylqsabm9.code9)) {
                                                fDxylqSabM fdxylqsabm10 = fDxylqSabM.this;
                                                if (!fdxylqsabm10.code1.equals(fdxylqsabm10.code10)) {
                                                    fDxylqSabM fdxylqsabm11 = fDxylqSabM.this;
                                                    if (!fdxylqsabm11.code1.equals(fdxylqsabm11.code11)) {
                                                        fDxylqSabM fdxylqsabm12 = fDxylqSabM.this;
                                                        if (!fdxylqsabm12.code1.equals(fdxylqsabm12.code12)) {
                                                            fDxylqSabM fdxylqsabm13 = fDxylqSabM.this;
                                                            if (!fdxylqsabm13.code1.equals(fdxylqsabm13.code13)) {
                                                                fDxylqSabM fdxylqsabm14 = fDxylqSabM.this;
                                                                if (!fdxylqsabm14.code1.equals(fdxylqsabm14.code14)) {
                                                                    fDxylqSabM fdxylqsabm15 = fDxylqSabM.this;
                                                                    if (!fdxylqsabm15.code1.equals(fdxylqsabm15.universal)) {
                                                                        fDxylqSabM fdxylqsabm16 = fDxylqSabM.this;
                                                                        if (!fdxylqsabm16.code1.equals(fdxylqsabm16.code5)) {
                                                                            Toast.makeText(container.getContext(), "Codigo Invalido", 1).show();
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                FragmentManager mFragmentManager = fDxylqSabM.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, new U4uiCgRvr6()).addToBackStack(null).commit();
            }
        });
        Button button2 = (Button) rootView.findViewById(R.id.buttonClear);
        this.ClearBtn = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                fdxylqsabm.code1 = BuildConfig.FLAVOR;
                fdxylqsabm.check();
            }
        });
        Button button3 = (Button) rootView.findViewById(R.id.button0);
        this.Button0 = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("0");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button4 = (Button) rootView.findViewById(R.id.button1);
        this.Button1 = button4;
        button4.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("1");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button5 = (Button) rootView.findViewById(R.id.button2);
        this.Button2 = button5;
        button5.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("2");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button6 = (Button) rootView.findViewById(R.id.button3);
        this.Button3 = button6;
        button6.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("3");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button7 = (Button) rootView.findViewById(R.id.button4);
        this.Button4 = button7;
        button7.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("4");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button8 = (Button) rootView.findViewById(R.id.button5);
        this.Button5 = button8;
        button8.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("5");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button9 = (Button) rootView.findViewById(R.id.button6);
        this.Button6 = button9;
        button9.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("6");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button10 = (Button) rootView.findViewById(R.id.button7);
        this.Button7 = button10;
        button10.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("7");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button11 = (Button) rootView.findViewById(R.id.button8);
        this.Button8 = button11;
        button11.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("8");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        Button button12 = (Button) rootView.findViewById(R.id.button9);
        this.Button9 = button12;
        button12.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.F0VSiFomrqH.fDxylqSabM.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                fDxylqSabM fdxylqsabm = fDxylqSabM.this;
                sb.append(fdxylqsabm.code1);
                sb.append("9");
                fdxylqsabm.code1 = sb.toString();
                fDxylqSabM.this.check();
            }
        });
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void check() {
        this.codeEdit.setText(BuildConfig.FLAVOR);
        this.codeEdit.setText(this.code1);
    }
}
