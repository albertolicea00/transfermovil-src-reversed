package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.FtAKxvNjrD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.RRLfqlrfwP;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.RYCvQK4nkF;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.KsDQL9cTTl;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.Xh70Rdjfpc;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.nNSC8tRyptP.uWkWt7AEZ5;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.vVF87n7MnK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.wLHKkaC4Ha;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class X7obECfkKf extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = X7obECfkKf.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new wLHKkaC4Ha()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new FtAKxvNjrD()).addToBackStack(null).commit();
                    break;
                case 3:
                    X7obECfkKf.this.showDialogEliminarRegistro();
                    break;
                case 4:
                    mFragmentTransaction.replace(R.id.containerView, new uWkWt7AEZ5()).addToBackStack(null).commit();
                    break;
                case 5:
                    mFragmentTransaction.replace(R.id.containerView, new RRLfqlrfwP()).addToBackStack(null).commit();
                    break;
                case 6:
                    mFragmentTransaction.replace(R.id.containerView, new KsDQL9cTTl()).addToBackStack(null).commit();
                    break;
                case 7:
                    mFragmentTransaction.replace(R.id.containerView, new vVF87n7MnK()).addToBackStack(null).commit();
                    break;
                case 8:
                    mFragmentTransaction.replace(R.id.containerView, new RYCvQK4nkF()).addToBackStack(null).commit();
                    break;
                case 9:
                    mFragmentTransaction.replace(R.id.containerView, new Xh70Rdjfpc()).addToBackStack(null).commit();
                    break;
                case 10:
                    Bundle arg = new Bundle();
                    arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                    EyKrF4UJ9B cuentaFiscal = new EyKrF4UJ9B();
                    cuentaFiscal.setArguments(arg);
                    mFragmentTransaction.replace(R.id.containerView, cuentaFiscal).addToBackStack(null).commit();
                    break;
            }
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
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Registrarse");
        registro.setSubtitulo("Registrarse en el sistema");
        registro.setIcono(R.drawable.ic_registrarse_bandec);
        Integer num = rBXnNc0Kx4.Post;
        registro.setType(num);
        registro.setOperacion(FdonIAFI9w.BANRegistrarse);
        itemsOperaciones.add(registro);
        WUULVgZq02 delRegister = new WUULVgZq02();
        delRegister.setTitulo("Eliminar Registro");
        delRegister.setSubtitulo("Eliminar registro asociado a su cuenta");
        delRegister.setIcono(R.drawable.ic_eliminar_registro_bandec);
        delRegister.setType(num);
        delRegister.setOperacion(FdonIAFI9w.BANEliminarRegistro);
        itemsOperaciones.add(delRegister);
        WUULVgZq02 cambiopin = new WUULVgZq02();
        cambiopin.setTitulo("Cambio de Clave");
        cambiopin.setSubtitulo("Cambio de clave de acceso");
        cambiopin.setIcono(R.drawable.ic_cambio_pin_bandec);
        cambiopin.setType(num);
        cambiopin.setOperacion(FdonIAFI9w.BANCambiarclave);
        itemsOperaciones.add(cambiopin);
        WUULVgZq02 cambiopinmultibanca = new WUULVgZq02();
        cambiopinmultibanca.setTitulo("Cambio PIN Multibanca");
        cambiopinmultibanca.setSubtitulo("Cambio del pin de la tarjeta multibanca");
        cambiopinmultibanca.setIcono(R.drawable.ic_actualizar_cuenta_bandec);
        cambiopinmultibanca.setType(num);
        cambiopinmultibanca.setOperacion(FdonIAFI9w.BANCambioPinMultibanca);
        itemsOperaciones.add(cambiopinmultibanca);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de Límites");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.ic_cambio_limites_bandec);
        cambioLimite.setType(num);
        cambioLimite.setOperacion(FdonIAFI9w.BANCambioLimite);
        itemsOperaciones.add(cambioLimite);
        WUULVgZq02 imprimirMLC = new WUULVgZq02();
        imprimirMLC.setTitulo("Imprimir Tarjeta USD");
        imprimirMLC.setSubtitulo("Apertura de cuenta en USD con respaldo en MLC");
        imprimirMLC.setIcono(R.drawable.ic_apertura_cuenta_bandec);
        imprimirMLC.setType(num);
        imprimirMLC.setOperacion(FdonIAFI9w.BANImprimirMLC);
        itemsOperaciones.add(imprimirMLC);
        WUULVgZq02 reimprimir = new WUULVgZq02();
        reimprimir.setTitulo("Reimpresión Tarjeta Red");
        reimprimir.setSubtitulo("Reimprimir tarjeta red");
        reimprimir.setIcono(R.drawable.ic_reimprimir_tarjeta_bandec);
        reimprimir.setType(num);
        reimprimir.setOperacion(FdonIAFI9w.BANReimpresion);
        itemsOperaciones.add(reimprimir);
        WUULVgZq02 pinDigital = new WUULVgZq02();
        pinDigital.setTitulo("Generar Código PIN");
        pinDigital.setSubtitulo("PIN no impreso");
        pinDigital.setIcono(R.drawable.ic_generar_pin_bandec);
        pinDigital.setType(num);
        pinDigital.setOperacion(FdonIAFI9w.BANPinDigital);
        itemsOperaciones.add(pinDigital);
        WUULVgZq02 cuentaFiscal = new WUULVgZq02();
        cuentaFiscal.setTitulo(getString(R.string.head_cuenta_fiscal));
        cuentaFiscal.setSubtitulo(getString(R.string.subtitle_cuenta_fiscal));
        cuentaFiscal.setIcono(R.drawable.ic_apertura_cuenta_fiscal_bandec);
        cuentaFiscal.setType(num);
        cuentaFiscal.setOperacion(FdonIAFI9w.BANCuentaFiscal);
        itemsOperaciones.add(cuentaFiscal);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BANRegistrarse.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANCambiarclave.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANEliminarRegistro.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANCambioLimite.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANCambioPinMultibanca.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANImprimirMLC.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANReimpresion.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANPinDigital.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANConvertirCuenta.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BANCuentaFiscal.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogEliminarRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea eliminar registro asociado a su cuenta y número telefónico?.  ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) X7obECfkKf.this.getActivity()).actionCallUSSD("68*02");
                        return;
                    } else {
                        ((IHVTCBmiLV) X7obECfkKf.this.getActivity()).actionCallUSSD("68*02");
                        return;
                    }
                }
                ((S9ycHcoxAzy) X7obECfkKf.this.getActivity()).actionCallUSSD("68*02");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogImprimirUSD() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea realizar la apertura de cuenta en USD con respaldo en MLC? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) X7obECfkKf.this.getActivity()).actionCallUSSD("76", "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) X7obECfkKf.this.getActivity()).actionCallUSSD("76", "1");
                        return;
                    }
                }
                ((S9ycHcoxAzy) X7obECfkKf.this.getActivity()).actionCallUSSD("76", "1");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.TJzyszIDKqc.X7obECfkKf.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
