package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.F5QGj1YaNB;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.FLftkSrl5R;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.HGFRxfLF5W;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.TFU20KJsT9;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.tYCC0hiRcm;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.G8E5Fjf9l7Y1.xR6zA9CmCE;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.RFBEnXW0Xr;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.dYe9oOuW7h;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.kD9wg15jwt;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.uurdBwh7ub;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.yvWHEB2qa4;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.EyKrF4UJ9B;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RC71RyOpsk extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = RC71RyOpsk.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new xR6zA9CmCE()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new RFBEnXW0Xr()).addToBackStack(null).commit();
                        break;
                    case 3:
                        mFragmentTransaction.replace(R.id.containerView, new F5QGj1YaNB()).addToBackStack(null).commit();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new uurdBwh7ub()).addToBackStack(null).commit();
                        break;
                    case 5:
                        mFragmentTransaction.replace(R.id.containerView, new yvWHEB2qa4()).addToBackStack(null).commit();
                        break;
                    case 6:
                        mFragmentTransaction.replace(R.id.containerView, new tYCC0hiRcm()).addToBackStack(null).commit();
                        break;
                    case 7:
                        mFragmentTransaction.replace(R.id.containerView, new FLftkSrl5R()).addToBackStack(null).commit();
                        break;
                    case 8:
                        mFragmentTransaction.replace(R.id.containerView, new dYe9oOuW7h()).addToBackStack(null).commit();
                        break;
                    case 9:
                        mFragmentTransaction.replace(R.id.containerView, new kD9wg15jwt()).addToBackStack(null).commit();
                        break;
                    case 10:
                        mFragmentTransaction.replace(R.id.containerView, new HGFRxfLF5W()).addToBackStack(null).commit();
                        break;
                    case 11:
                        mFragmentTransaction.replace(R.id.containerView, new TFU20KJsT9()).addToBackStack(null).commit();
                        break;
                    case 12:
                        Bundle arg = new Bundle();
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                        EyKrF4UJ9B cuentaFiscal = new EyKrF4UJ9B();
                        cuentaFiscal.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, cuentaFiscal).addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(RC71RyOpsk.this.context, operacion.toString(), 1).show();
                        break;
                }
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
        registro.setIcono(R.drawable.ic_registrarse_metro);
        Integer num = rBXnNc0Kx4.Post;
        registro.setType(num);
        registro.setOperacion(FdonIAFI9w.METRORegistrarse);
        itemsOperaciones.add(registro);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de Límites");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.ic_cambio_limites_metro);
        cambioLimite.setType(num);
        cambioLimite.setOperacion(FdonIAFI9w.METROCambioLimite);
        itemsOperaciones.add(cambioLimite);
        WUULVgZq02 eliminarreg = new WUULVgZq02();
        eliminarreg.setTitulo("Eliminar Registro");
        eliminarreg.setSubtitulo("Eliminar registro asociado a su tarjeta");
        eliminarreg.setIcono(R.drawable.ic_eliminar_registro_metro);
        eliminarreg.setType(num);
        eliminarreg.setOperacion(FdonIAFI9w.METROEliminarregistro);
        itemsOperaciones.add(eliminarreg);
        WUULVgZq02 cambioclave = new WUULVgZq02();
        cambioclave.setTitulo("Cambio de PIN");
        cambioclave.setSubtitulo("Cambio de PIN de la tarjeta de Telebanca");
        cambioclave.setIcono(R.drawable.ic_cambio_pin_metro);
        cambioclave.setType(num);
        cambioclave.setOperacion(FdonIAFI9w.METROCambioPin);
        itemsOperaciones.add(cambioclave);
        WUULVgZq02 asociar = new WUULVgZq02();
        asociar.setTitulo("Asociar Cuenta");
        asociar.setSubtitulo("Asociar cuenta a tarjeta telebanca");
        asociar.setIcono(R.drawable.ic_asociar_cuenta_metro);
        asociar.setType(num);
        asociar.setOperacion(FdonIAFI9w.METROAsociarCuenta);
        itemsOperaciones.add(asociar);
        WUULVgZq02 actualizar = new WUULVgZq02();
        actualizar.setTitulo("Actualizar Cuenta");
        actualizar.setSubtitulo("Actualizar cuentas asociadas a su tarjeta telebanca");
        actualizar.setIcono(R.drawable.ic_actualizar_cuenta_metro);
        actualizar.setType(num);
        actualizar.setOperacion(FdonIAFI9w.METROActualizarcuenta);
        itemsOperaciones.add(actualizar);
        WUULVgZq02 reimprimir = new WUULVgZq02();
        reimprimir.setTitulo(getString(R.string.title_reimprimir_tarjeta));
        reimprimir.setSubtitulo(getString(R.string.sub_reimprimir_tarjeta));
        reimprimir.setIcono(R.drawable.ic_reimprimir_tarjeta_metro);
        reimprimir.setType(num);
        reimprimir.setOperacion(FdonIAFI9w.METROReimprimirTarjeta);
        itemsOperaciones.add(reimprimir);
        WUULVgZq02 pinDigital = new WUULVgZq02();
        pinDigital.setTitulo("Generar Código PIN");
        pinDigital.setSubtitulo("PIN no impreso");
        pinDigital.setIcono(R.drawable.ic_generar_pin_metro);
        pinDigital.setType(num);
        pinDigital.setOperacion(FdonIAFI9w.METROPinDigital);
        itemsOperaciones.add(pinDigital);
        WUULVgZq02 mlc = new WUULVgZq02();
        mlc.setTitulo("Apertura de Cuenta");
        mlc.setSubtitulo("Apertura de Cuenta en USD con respaldo en MLC");
        mlc.setIcono(R.drawable.ic_apertura_cuenta_metro);
        mlc.setType(num);
        mlc.setOperacion(FdonIAFI9w.METROImprimirMLC);
        itemsOperaciones.add(mlc);
        WUULVgZq02 modificarPrelacion = new WUULVgZq02();
        modificarPrelacion.setTitulo("Modificar Prelación");
        modificarPrelacion.setSubtitulo("Modificar Prelación de Crédito");
        modificarPrelacion.setIcono(R.drawable.ic_amortizar_credito_metro);
        modificarPrelacion.setType(num);
        modificarPrelacion.setOperacion(FdonIAFI9w.METROModificarPrelacion);
        itemsOperaciones.add(modificarPrelacion);
        WUULVgZq02 cuentaFiscal = new WUULVgZq02();
        cuentaFiscal.setTitulo(getString(R.string.head_cuenta_fiscal));
        cuentaFiscal.setSubtitulo(getString(R.string.subtitle_cuenta_fiscal));
        cuentaFiscal.setIcono(R.drawable.ic_apertura_cuenta_fiscal_metro);
        cuentaFiscal.setType(num);
        cuentaFiscal.setOperacion(FdonIAFI9w.METROCuentaFiscal);
        itemsOperaciones.add(cuentaFiscal);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.METROCambioLimite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METRORegistrarse.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROEliminarregistro.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROAsociarCuenta.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROActualizarcuenta.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROReimprimirTarjeta.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROCambioPin.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROPinDigital.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROImprimirMLC.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROConvertirCuenta.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROModificarPrelacion.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.METROCuentaFiscal.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogReimprimirTarjetas(final String cadena) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea reimprimir la tarjeta en la moneda soleccionada? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                String str = cadena;
                Uri number = Uri.parse(cadena);
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    RC71RyOpsk.this.context.startActivity(dial);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTipoMonedaReimprimirTarjeta() {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        final String CodigoAcFinal = codeAcceso;
        final String VersionFinal = version;
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione según la moneda la tarjeta a reimprimir:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String cadena;
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (i == 0) {
                    cadena = "1";
                } else {
                    cadena = "2";
                }
                String codeSendTo = bs.code(cadena);
                String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");
                RC71RyOpsk.this.showDialogReimprimirTarjetas(cadena2);
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.PKbdqsi8z03.RC71RyOpsk.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
