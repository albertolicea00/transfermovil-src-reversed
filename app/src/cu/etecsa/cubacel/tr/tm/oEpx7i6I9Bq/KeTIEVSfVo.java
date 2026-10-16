package cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.WriterException;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ZDkigMAIBm;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.K5ksEKSUSh;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.MCBank;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeTIEVSfVo extends Fragment {
    public List<MCBank> accountLists;
    public Activity activity;
    public J9bkD55BKNh adapterMyAccounts;
    public FloatingActionButton btActionAccount;
    public Context context;
    public ImageView imCards;
    public String movil;
    public RecyclerView rvList;
    public String HEADER_TRANSFER = "TRANSFERMOVIL_ETECSA,TRANSFERENCIA";
    public View.OnClickListener btnNewAccount = new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<MCBank> mcBanksList = unYp8VQThY.getInstance().getAllMCBankLists();
            if (mcBanksList == null || mcBanksList.size() >= 20) {
                KeTIEVSfVo.this.showDialogMaxPermitidop();
                return;
            }
            FragmentManager mFragmentManager = KeTIEVSfVo.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            MEqNzldfDl perfil = new MEqNzldfDl();
            mFragmentTransaction.replace(R.id.containerView, perfil).addToBackStack(null).commit();
        }
    };
    public J9bkD55BKNh.OnItemClickListener onItemClickListener = new J9bkD55BKNh.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.4
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.OnItemClickListener
        public void onEditIten(int id) {
            Bundle arg = new Bundle();
            arg.putInt("cuenta_id", id);
            FragmentManager mFragmentManager = KeTIEVSfVo.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            MEqNzldfDl perfil = new MEqNzldfDl();
            perfil.setArguments(arg);
            mFragmentTransaction.replace(R.id.containerView, perfil).addToBackStack(null).commit();
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.OnItemClickListener
        public void onDelete(int position, int id) {
            try {
                MCBank bank = unYp8VQThY.getInstance().getMCBank(id);
                unYp8VQThY.getInstance().deleteMCBank(bank);
            } catch (Exception e) {
            }
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.OnItemClickListener
        public void onTransfer(int id) {
            MCBank banco = unYp8VQThY.getInstance().getMCBank(id);
            FragmentManager mFragmentManager = KeTIEVSfVo.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            Bundle b = new Bundle();
            b.putInt("cuenta_origen_id", banco.getId());
            switch (AnonymousClass10.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[banco.getAgencia().ordinal()]) {
                case 1:
                    x6Wob3Sa98U tFragment = new x6Wob3Sa98U();
                    tFragment.setArguments(b);
                    mFragmentTransaction.replace(R.id.containerView, tFragment).addToBackStack(null).commit();
                    break;
                case 2:
                    ZDkigMAIBm tFragment2 = new ZDkigMAIBm();
                    tFragment2.setArguments(b);
                    mFragmentTransaction.replace(R.id.containerView, tFragment2).addToBackStack(null).commit();
                    break;
                case 3:
                    iN1lHDKE5h tFragment3 = new iN1lHDKE5h();
                    tFragment3.setArguments(b);
                    mFragmentTransaction.replace(R.id.containerView, tFragment3).addToBackStack(null).commit();
                    break;
                case 4:
                    KeTIEVSfVo.this.showDialogTransferenciaEmpresa(b);
                    break;
                case 5:
                    l3GXbXAyUW tFragment4 = new l3GXbXAyUW();
                    tFragment4.setArguments(b);
                    mFragmentTransaction.replace(R.id.containerView, tFragment4).addToBackStack(null).commit();
                    break;
                case 6:
                    KeTIEVSfVo.this.showDialogTransferenciaEmpresarial(b);
                    break;
                default:
                    KeTIEVSfVo.this.showDialogError();
                    break;
            }
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.OnItemClickListener
        public void onQR(int id) throws WriterException {
            MCBank miCuenta = unYp8VQThY.getInstance().getMCBank(id);
            String cadena = KeTIEVSfVo.this.HEADER_TRANSFER + "," + miCuenta.getCuenta() + "," + miCuenta.getMovil_notificar() + ",";
            Bitmap icon = BitmapFactory.decodeResource(KeTIEVSfVo.this.context.getResources(), R.drawable.etecsa);
            Bitmap bm = ZUoEY89WdA.ProductLogo(icon, cadena, false, R.color.primaryDarkColor);
            Dialog settingsDialog = new Dialog(KeTIEVSfVo.this.context);
            LayoutInflater inflater = (LayoutInflater) KeTIEVSfVo.this.context.getSystemService("layout_inflater");
            View v = inflater.inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
            ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
            iv.setImageBitmap(bm);
            settingsDialog.getWindow().requestFeature(1);
            settingsDialog.setContentView(v);
            settingsDialog.show();
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.J9bkD55BKNh.OnItemClickListener
        public void onShare(String cuenta) {
            Intent sendIntent = new Intent();
            sendIntent.setAction("android.intent.action.SEND");
            sendIntent.putExtra("android.intent.extra.TEXT", "He compartido con usted desde Transfermóvil mi número de cuenta bancaria: " + cuenta + " . Antes de utilizar la cuenta rectifique el número compartido.");
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            KeTIEVSfVo.this.startActivity(shareIntent);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.x7hqio7zhb0epj, container, false);
        this.context = container.getContext();
        this.activity = getActivity();
        this.imCards = (ImageView) rootView.findViewById(R.id.imCards);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        this.rvList = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvList.setHasFixedSize(true);
        LinearLayoutManager ly = new LinearLayoutManager(this.context);
        this.rvList.setLayoutManager(ly);
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.btActionAccount);
        this.btActionAccount = floatingActionButton;
        floatingActionButton.setOnClickListener(this.btnNewAccount);
        this.btActionAccount.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.1.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent event) {
                        switch (event.getActionMasked()) {
                            case 1:
                                view.setOnTouchListener(null);
                                break;
                            case 2:
                                view.setX(event.getRawX() - 120.0f);
                                view.setY(event.getRawY() - 425.0f);
                                break;
                        }
                        return true;
                    }
                });
                return true;
            }
        });
        this.imCards.setOnClickListener(this.btnNewAccount);
        try {
            fillAdapter();
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
        return rootView;
    }

    public void fillAdapter() {
        try {
            unYp8VQThY.init(this.context);
            List<MCBank> allMCBankLists = unYp8VQThY.getInstance().getAllMCBankLists();
            this.accountLists = allMCBankLists;
            if (allMCBankLists != null) {
                List<K5ksEKSUSh> items = new ArrayList<>();
                for (MCBank c : this.accountLists) {
                    int id = c.getId();
                    String alias = c.getAlias();
                    String cuenta = c.getCuenta();
                    String cuenta2 = "XXXX XXXX XXXX " + cuenta.substring(12);
                    String moneda = c.getTipo_moneda().name();
                    R1sDOSqZ2z banco = c.getAgencia();
                    K5ksEKSUSh uyh0pxs9m37in = new K5ksEKSUSh();
                    uyh0pxs9m37in.setId(id);
                    uyh0pxs9m37in.setTitulo(alias);
                    uyh0pxs9m37in.setSubtitulo(cuenta2);
                    uyh0pxs9m37in.setMoneda(moneda);
                    uyh0pxs9m37in.setBanco(banco);
                    uyh0pxs9m37in.setCuenta(c.getCuenta());
                    items.add(uyh0pxs9m37in);
                }
                if (items.size() > 0) {
                    this.imCards.setVisibility(8);
                }
                J9bkD55BKNh j9bkD55BKNh = new J9bkD55BKNh(this.context, getActivity(), items);
                this.adapterMyAccounts = j9bkD55BKNh;
                this.rvList.setAdapter(j9bkD55BKNh);
                this.adapterMyAccounts.setOnItemClickListener(this.onItemClickListener);
            }
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogMaxPermitidop() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Aviso");
        builder.setMessage("Ha superado la cantidad de cuentas a insertar en la aplicación.");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.Metropolitano.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BFI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICAEMP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void showDialogError() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Notificación").setMessage("El banco especificado no tiene habilitada esta opción").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTransferenciaEmpresa(Bundle b) {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm), this.context.getString(R.string.tx_bfi_transferencia_indistinta)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = KeTIEVSfVo.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                f1IveoSASW transferenciaCuentasBFI = new f1IveoSASW();
                arg.putSerializable("TransferType", Integer.valueOf(i));
                transferenciaCuentasBFI.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, transferenciaCuentasBFI).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTransferenciaEmpresarial(final Bundle b) {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = KeTIEVSfVo.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Z3kYdPwq6K2 transferenciaBolsaClasicaEmpresarialEmpresa = new Z3kYdPwq6K2();
                b.putSerializable("TransferType", Integer.valueOf(i));
                transferenciaBolsaClasicaEmpresarialEmpresa.setArguments(b);
                mFragmentTransaction.replace(R.id.containerView, transferenciaBolsaClasicaEmpresarialEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.oEpx7i6I9Bq.KeTIEVSfVo.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }
}
