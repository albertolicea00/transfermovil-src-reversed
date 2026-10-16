package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class opFvbCxlRn extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = opFvbCxlRn.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass2.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        showDialogTransferencia();
                        break;
                    case 2:
                        showDialogPagoExterno();
                        break;
                    default:
                        Toast.makeText(opFvbCxlRn.this.context, operacion.toString(), 1).show();
                        break;
                }
            }
        }

        public final void showDialogTransferencia() {
            CharSequence[] items = {opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_con_solic), opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_con_confirm), opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_indistinta)};
            AlertDialog.Builder builder = new AlertDialog.Builder(opFvbCxlRn.this.context);
            builder.setTitle("Seleccione opción");
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Bundle arg = new Bundle();
                    FragmentManager mFragmentManager = opFvbCxlRn.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    f1IveoSASW transferenciaCuentasBFI = new f1IveoSASW();
                    arg.putSerializable("TransferType", Integer.valueOf(i));
                    transferenciaCuentasBFI.setArguments(arg);
                    mFragmentTransaction.replace(R.id.containerView, transferenciaCuentasBFI).addToBackStack(null).commit();
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn.1.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        public final void showDialogPagoExterno() {
            CharSequence[] items = {opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_con_solic), opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_con_confirm), opFvbCxlRn.this.context.getString(R.string.tx_bfi_transferencia_indistinta)};
            AlertDialog.Builder builder = new AlertDialog.Builder(opFvbCxlRn.this.context);
            builder.setTitle("Seleccione opción");
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn.1.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Bundle arg = new Bundle();
                    FragmentManager mFragmentManager = opFvbCxlRn.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    Eqj43O0pUx pagoExternoEmpresa = new Eqj43O0pUx();
                    arg.putSerializable("PayType", Integer.valueOf(i));
                    pagoExternoEmpresa.setArguments(arg);
                    mFragmentTransaction.replace(R.id.containerView, pagoExternoEmpresa).addToBackStack(null).commit();
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn.1.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    };
    public View rootView;
    public RecyclerView rvseguridad;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.p1r9hi3qhdlpun, container, false);
        this.context = container.getContext();
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.rvseguridad = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvseguridad.setHasFixedSize(true);
        LinearLayoutManager llmSegidad = new LinearLayoutManager(this.context);
        this.rvseguridad.setLayoutManager(llmSegidad);
        initData();
        return this.rootView;
    }

    private void initData() {
        List<WUULVgZq02> itemsOperaciones = new ArrayList<>();
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo(getString(R.string.traspaso_fondos));
        transferencia.setSubtitulo(getString(R.string.banco_sub_transferencia_cuenta));
        transferencia.setIcono(R.drawable.ic_transferencia_bfi);
        Integer num = rBXnNc0Kx4.Post;
        transferencia.setType(num);
        transferencia.setOperacion(FdonIAFI9w.BFITransferirEmpresa);
        itemsOperaciones.add(transferencia);
        WUULVgZq02 pagoExternoEmpresa = new WUULVgZq02();
        pagoExternoEmpresa.setTitulo(getString(R.string.title_pago_externo));
        pagoExternoEmpresa.setSubtitulo(getString(R.string.sub_pago_externo));
        pagoExternoEmpresa.setIcono(R.drawable.ic_pago_linea_bfi);
        pagoExternoEmpresa.setType(num);
        pagoExternoEmpresa.setOperacion(FdonIAFI9w.BFIPagoExternoEmpresa);
        itemsOperaciones.add(pagoExternoEmpresa);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.opFvbCxlRn$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BFITransferirEmpresa.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPagoExternoEmpresa.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
