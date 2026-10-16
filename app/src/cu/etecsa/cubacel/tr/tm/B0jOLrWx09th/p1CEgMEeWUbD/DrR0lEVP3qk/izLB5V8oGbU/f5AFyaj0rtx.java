package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.IixhA1yamp;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.Ittht2aX4N;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.PQmKwgxZd1;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.T7bvG7kpeae;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.Yhi9DhKkMz;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.ZZ6L6QderZ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.kWnV7nzNWl;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.qmcwKV1fzU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.r1lhlGiU6g65.uLySWsCVTv;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f5AFyaj0rtx extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = f5AFyaj0rtx.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (AnonymousClass18.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new IixhA1yamp()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new PQmKwgxZd1()).addToBackStack(null).commit();
                    break;
                case 3:
                    f5AFyaj0rtx.this.showDialogEliminarRegistro();
                    break;
                case 4:
                    mFragmentTransaction.replace(R.id.containerView, new qmcwKV1fzU()).addToBackStack(null).commit();
                    break;
                case 5:
                    mFragmentTransaction.replace(R.id.containerView, new Ittht2aX4N()).addToBackStack(null).commit();
                    break;
                case 6:
                    mFragmentTransaction.replace(R.id.containerView, new uLySWsCVTv()).addToBackStack(null).commit();
                    break;
                case 7:
                    mFragmentTransaction.replace(R.id.containerView, new kWnV7nzNWl()).addToBackStack(null).commit();
                    break;
                case 8:
                    mFragmentTransaction.replace(R.id.containerView, new Yhi9DhKkMz()).addToBackStack(null).commit();
                    break;
                case 9:
                    mFragmentTransaction.replace(R.id.containerView, new ZZ6L6QderZ()).addToBackStack(null).commit();
                    break;
                case 10:
                    mFragmentTransaction.replace(R.id.containerView, new T7bvG7kpeae()).addToBackStack(null).commit();
                    break;
                case 11:
                    Bundle arg = new Bundle();
                    arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                    EyKrF4UJ9B cuentaFiscal = new EyKrF4UJ9B();
                    cuentaFiscal.setArguments(arg);
                    mFragmentTransaction.replace(R.id.containerView, cuentaFiscal).addToBackStack(null).commit();
                    break;
                default:
                    Toast.makeText(f5AFyaj0rtx.this.context, "Error! " + operacion, 0).show();
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
        registro.setIcono(R.drawable.ic_registrarse_bpa);
        Integer num = rBXnNc0Kx4.Post;
        registro.setType(num);
        registro.setOperacion(FdonIAFI9w.BPARegistrarse);
        itemsOperaciones.add(registro);
        WUULVgZq02 changepass = new WUULVgZq02();
        changepass.setTitulo("Cambiar Clave");
        changepass.setSubtitulo("Cambiar la clave de acceso");
        changepass.setIcono(R.drawable.ic_cambio_pin_bpa);
        changepass.setType(num);
        changepass.setOperacion(FdonIAFI9w.BPACambiarclave);
        itemsOperaciones.add(changepass);
        WUULVgZq02 delRegister = new WUULVgZq02();
        delRegister.setTitulo("Eliminar Registro");
        delRegister.setSubtitulo("Eliminar registro asociado a su cuenta");
        delRegister.setIcono(R.drawable.ic_eliminar_registro_bpa);
        delRegister.setType(num);
        delRegister.setOperacion(FdonIAFI9w.BPAEliminarRegistro);
        itemsOperaciones.add(delRegister);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de Límite");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.ic_cambio_limites_bpa);
        cambioLimite.setType(num);
        cambioLimite.setOperacion(FdonIAFI9w.BPACambioLimite);
        itemsOperaciones.add(cambioLimite);
        WUULVgZq02 cambioTarjeta = new WUULVgZq02();
        cambioTarjeta.setTitulo("Asociar Cuentas");
        cambioTarjeta.setSubtitulo("Vincular otra cuenta bancaria");
        cambioTarjeta.setIcono(R.drawable.ic_asociar_cuenta_bpa);
        cambioTarjeta.setType(num);
        cambioTarjeta.setOperacion(FdonIAFI9w.BPAAsociarCuenta);
        itemsOperaciones.add(cambioTarjeta);
        WUULVgZq02 pinDigital = new WUULVgZq02();
        pinDigital.setTitulo("PIN no Impreso");
        pinDigital.setSubtitulo("Generar Código PIN");
        pinDigital.setIcono(R.drawable.ic_generar_pin_bpa);
        pinDigital.setType(num);
        pinDigital.setOperacion(FdonIAFI9w.BPAPinDigital);
        itemsOperaciones.add(pinDigital);
        WUULVgZq02 reimprimir = new WUULVgZq02();
        reimprimir.setTitulo("Reimprimir Tarjeta");
        reimprimir.setSubtitulo("Renovar tarjeta");
        reimprimir.setIcono(R.drawable.ic_reimprimir_tarjeta_bpa);
        reimprimir.setType(num);
        reimprimir.setOperacion(FdonIAFI9w.BPARenovarTarj);
        itemsOperaciones.add(reimprimir);
        WUULVgZq02 recuperar = new WUULVgZq02();
        recuperar.setTitulo("Pérdida de PIN");
        recuperar.setSubtitulo("Pérdida PIN de tarjeta magnética");
        recuperar.setIcono(R.drawable.ic_perdida_pin_bpa);
        recuperar.setType(num);
        recuperar.setOperacion(FdonIAFI9w.BPARecuperarTarj);
        itemsOperaciones.add(recuperar);
        WUULVgZq02 cuentaFiscal = new WUULVgZq02();
        cuentaFiscal.setTitulo(getString(R.string.head_cuenta_fiscal));
        cuentaFiscal.setSubtitulo(getString(R.string.subtitle_cuenta_fiscal));
        cuentaFiscal.setIcono(R.drawable.ic_apertura_cuenta_fiscal_bpa);
        cuentaFiscal.setType(num);
        cuentaFiscal.setOperacion(FdonIAFI9w.BPACuentaFiscal);
        itemsOperaciones.add(cuentaFiscal);
        WUULVgZq02 mlc = new WUULVgZq02();
        mlc.setTitulo("Apertura de Cuenta");
        mlc.setSubtitulo("Apertura de Cuenta en USD con respaldo en MLC");
        mlc.setIcono(R.drawable.ic_apertura_cuenta_bpa);
        mlc.setType(num);
        mlc.setOperacion(FdonIAFI9w.BPAImprimirMLC);
        itemsOperaciones.add(mlc);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx$18, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass18 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BPARegistrarse.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPACambiarclave.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAEliminarRegistro.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPACambioLimite.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAAsociarCuenta.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAPinDigital.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPARenovarTarj.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPARecuperarTarj.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConvertirCuenta.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAImprimirMLC.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPACuentaFiscal.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("70");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("70");
                        return;
                    }
                }
                ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("70");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        FBsQzP3Zfj.closeSessionBank(getActivity());
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el saldo de su tarjeta? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("46");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("46");
                        return;
                    }
                }
                ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("46");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultaCredito() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea ver los créditos pendientes? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("72");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("72");
                        return;
                    }
                }
                ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("72");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogEliminarRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea eliminar registro asociado a su cuenta y número telefónico?.  ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("68*01");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("68*01");
                        return;
                    }
                }
                ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("68*01");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultarLimites() {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Para consultar los límites de sus cuentas bancarias debe seleccionar el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "1");
                } else {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("62", "2");
                }
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTipoMOneda(final String operacion) {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "1");
                } else {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogUltimosTipoMOneda(final String operacion) {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*1");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*1");
                } else {
                    ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD(operacion, "00*2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTodasCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el importe de todas sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) f5AFyaj0rtx.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.f5AFyaj0rtx.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
