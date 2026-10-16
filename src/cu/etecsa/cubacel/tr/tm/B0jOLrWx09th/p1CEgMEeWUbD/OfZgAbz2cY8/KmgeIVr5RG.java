package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KmgeIVr5RG extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = KmgeIVr5RG.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            int i = AnonymousClass16.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()];
        }
    };
    public View rootView;
    public RecyclerView rvseguridad;

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG$16, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass16 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = new int[FdonIAFI9w.values().length];
    }

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
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo("Autenticarse");
        autenticarse.setSubtitulo("Acceder al sistema");
        autenticarse.setIcono(R.drawable.banco_bandec_auth_login);
        Integer num = rBXnNc0Kx4.Post;
        autenticarse.setType(num);
        autenticarse.setOperacion(FdonIAFI9w.BANAutenticar);
        itemsOperaciones.add(autenticarse);
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo(getString(R.string.banco_transferencia));
        transferencia.setSubtitulo(getString(R.string.banco_sub_transferencia));
        transferencia.setIcono(R.drawable.banco_bandec_transfer);
        transferencia.setType(num);
        transferencia.setOperacion(FdonIAFI9w.BANTransferencia);
        itemsOperaciones.add(transferencia);
        WUULVgZq02 electricidad = new WUULVgZq02();
        electricidad.setTitulo(getString(R.string.banco_electricidad));
        electricidad.setSubtitulo(getString(R.string.banco_sub_electricidad));
        electricidad.setIcono(R.drawable.banco_bandec_electric);
        electricidad.setType(num);
        electricidad.setOperacion(FdonIAFI9w.BANElectricidad);
        itemsOperaciones.add(electricidad);
        WUULVgZq02 telefono = new WUULVgZq02();
        telefono.setTitulo(getString(R.string.banco_telefono));
        telefono.setSubtitulo(getString(R.string.banco_sub_telefono));
        telefono.setIcono(R.drawable.banco_bandec_telefono);
        telefono.setType(num);
        telefono.setOperacion(FdonIAFI9w.BANTelefono);
        itemsOperaciones.add(telefono);
        WUULVgZq02 onat = new WUULVgZq02();
        onat.setTitulo(getString(R.string.banco_onat));
        onat.setSubtitulo(getString(R.string.banco_sub_onat));
        onat.setIcono(R.drawable.banco_bandec_onat);
        onat.setType(num);
        onat.setOperacion(FdonIAFI9w.BANONAT);
        itemsOperaciones.add(onat);
        WUULVgZq02 consulta_saldo = new WUULVgZq02();
        consulta_saldo.setTitulo("Consultar Saldo");
        consulta_saldo.setSubtitulo("Consultar saldo actual de la tarjeta");
        consulta_saldo.setIcono(R.drawable.banco_bandec_consult_saldo);
        consulta_saldo.setType(num);
        consulta_saldo.setOperacion(FdonIAFI9w.BANConsultarSaldo);
        itemsOperaciones.add(consulta_saldo);
        WUULVgZq02 cons_Serv = new WUULVgZq02();
        cons_Serv.setTitulo("Consultar Servicio");
        cons_Serv.setSubtitulo("Consultar factura del servicio");
        cons_Serv.setIcono(R.drawable.banco_bandec_consult_serv);
        cons_Serv.setType(num);
        cons_Serv.setOperacion(FdonIAFI9w.BANConsultarServicio);
        itemsOperaciones.add(cons_Serv);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo("Últimas operaciones");
        ult_operaciones.setSubtitulo("Últimas 10 operaciones de la tarjeta");
        ult_operaciones.setIcono(R.drawable.banco_bandec_ult_oper);
        ult_operaciones.setType(num);
        ult_operaciones.setOperacion(FdonIAFI9w.BANUltimasoperaciones);
        itemsOperaciones.add(ult_operaciones);
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Registrarse");
        registro.setSubtitulo("Registrarse en el sistema");
        registro.setIcono(R.drawable.banco_bandec_register);
        registro.setType(num);
        registro.setOperacion(FdonIAFI9w.BANRegistrarse);
        itemsOperaciones.add(registro);
        WUULVgZq02 changepass = new WUULVgZq02();
        changepass.setTitulo("Cambiar clave");
        changepass.setSubtitulo("Cambiar la clave de acceso");
        changepass.setIcono(R.drawable.banco_bandec_cambio_clave);
        changepass.setType(num);
        changepass.setOperacion(FdonIAFI9w.BANCambiarclave);
        itemsOperaciones.add(changepass);
        WUULVgZq02 close = new WUULVgZq02();
        close.setTitulo(this.context.getString(R.string.banco_desconectar));
        close.setSubtitulo(this.context.getString(R.string.banco_sub_desconectar));
        close.setIcono(R.drawable.banco_bandec_salir);
        close.setType(num);
        close.setOperacion(FdonIAFI9w.BANDesconectar);
        itemsOperaciones.add(close);
        WUULVgZq02 delRegister = new WUULVgZq02();
        delRegister.setTitulo("Eliminar Registro");
        delRegister.setSubtitulo("Eliminar registro asociado a su cuenta");
        delRegister.setIcono(R.drawable.banco_bandec_eliminar_registro);
        delRegister.setType(num);
        delRegister.setOperacion(FdonIAFI9w.BANEliminarRegistro);
        itemsOperaciones.add(delRegister);
        WUULVgZq02 recargarMovil = new WUULVgZq02();
        recargarMovil.setTitulo("Recarga Saldo Móvil");
        recargarMovil.setSubtitulo("Recargar saldo del móvil con cuenta bancaria");
        recargarMovil.setIcono(R.drawable.banco_bandec_recarga2);
        recargarMovil.setType(num);
        recargarMovil.setOperacion(FdonIAFI9w.BANRecargaMovil);
        itemsOperaciones.add(recargarMovil);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de límites");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.banco_bandec_cambio_limite);
        cambioLimite.setType(num);
        cambioLimite.setOperacion(FdonIAFI9w.BANCambioLimite);
        itemsOperaciones.add(cambioLimite);
        WUULVgZq02 consultaLimite = new WUULVgZq02();
        consultaLimite.setTitulo("Consulta de límites");
        consultaLimite.setSubtitulo("Consulta de límites de las cuentas bancarias");
        consultaLimite.setIcono(R.drawable.banco_bandec_consulta_limite);
        consultaLimite.setType(num);
        consultaLimite.setOperacion(FdonIAFI9w.BANConsultaLimite);
        itemsOperaciones.add(consultaLimite);
        WUULVgZq02 cambioTarjeta = new WUULVgZq02();
        cambioTarjeta.setTitulo("Cambio de tarjeta");
        cambioTarjeta.setSubtitulo("Tarjeta RED a operar");
        cambioTarjeta.setIcono(R.drawable.banco_bandec_cambio_cuenta);
        cambioTarjeta.setType(num);
        cambioTarjeta.setOperacion(FdonIAFI9w.BANCambioCuenta);
        itemsOperaciones.add(cambioTarjeta);
        WUULVgZq02 ultimosPagos = new WUULVgZq02();
        ultimosPagos.setTitulo("Ultimos pagos realizados");
        ultimosPagos.setSubtitulo("Consultar últimos pagos realizados");
        ultimosPagos.setIcono(R.drawable.banco_bandec_ultimos_pagos);
        ultimosPagos.setType(num);
        ultimosPagos.setOperacion(FdonIAFI9w.BANUltimosPagos);
        itemsOperaciones.add(ultimosPagos);
        WUULVgZq02 amortizar = new WUULVgZq02();
        amortizar.setTitulo("Amortizar Crédito");
        amortizar.setSubtitulo("Amortizar Crédito Bancario");
        amortizar.setIcono(R.drawable.banco_bandec_amortizar_credito);
        amortizar.setType(num);
        amortizar.setOperacion(FdonIAFI9w.BANAmortizar);
        itemsOperaciones.add(amortizar);
        WUULVgZq02 consultaAllCuenta = new WUULVgZq02();
        consultaAllCuenta.setTitulo("Consultar Todas las Cuentas");
        consultaAllCuenta.setSubtitulo("Consultar Todas las Cuentas Bancarias");
        consultaAllCuenta.setIcono(R.drawable.banco_bandec_consultar_todas_cuentas);
        consultaAllCuenta.setType(num);
        consultaAllCuenta.setOperacion(FdonIAFI9w.BANConsultarTodasCuentas);
        itemsOperaciones.add(consultaAllCuenta);
        WUULVgZq02 giroPostal = new WUULVgZq02();
        giroPostal.setTitulo("Realizar Giro Postal");
        giroPostal.setSubtitulo("Realizar Giro a traves de Correo de Cuba");
        giroPostal.setIcono(R.drawable.ico_agent_consultar_factura);
        giroPostal.setType(num);
        giroPostal.setOperacion(FdonIAFI9w.BANGiroPostal);
        itemsOperaciones.add(giroPostal);
        WUULVgZq02 consGiro = new WUULVgZq02();
        consGiro.setTitulo("Consulta Giros");
        consGiro.setSubtitulo("Giros pendientes");
        consGiro.setIcono(R.drawable.ico_agent_consultar_factura);
        consGiro.setType(num);
        consGiro.setOperacion(FdonIAFI9w.BANConsultarGiroPostal);
        itemsOperaciones.add(consGiro);
        WUULVgZq02 pagoExterno = new WUULVgZq02();
        pagoExterno.setTitulo("Pago Externo");
        pagoExterno.setSubtitulo("Comercio Electronico");
        pagoExterno.setIcono(R.drawable.ico_agent_consultar_factura);
        pagoExterno.setType(num);
        pagoExterno.setOperacion(FdonIAFI9w.BANPagoExterno);
        itemsOperaciones.add(pagoExterno);
        WUULVgZq02 recargaNauta = new WUULVgZq02();
        recargaNauta.setTitulo("Recarga Nauta");
        recargaNauta.setSubtitulo("Recargar cuenta permanente nauta");
        recargaNauta.setIcono(R.drawable.ico_agent_consultar_factura);
        recargaNauta.setType(num);
        recargaNauta.setOperacion(FdonIAFI9w.BANRecargaNauta);
        itemsOperaciones.add(recargaNauta);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                    ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("70");
                } else {
                    ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("70");
                }
                FBsQzP3Zfj.closeSessionBank(KmgeIVr5RG.this.getActivity());
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultaSaldo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el saldo de su tarjeta? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("46");
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("46");
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("46");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogUltimasOperaciones() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea ver las últimas operaciones realizadas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("48");
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("48");
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("48");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogEliminarRegistro() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea eliminar registro asociado a su cuenta y número telefónico?.  ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("68*02");
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("68*02");
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("68*02");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultarLimites() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar los límites de sus cuentas bancarias? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("62");
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("62");
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("62");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogUltimosPagos() {
        CharSequence[] items = {"Todos", "Teléfono", "Eléctrica", "Transferencias", "Recarga Móvil", "Microrecarga Móvil", "Recarga Nauta"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la opción deseada:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String tipoOperacion = "0";
                switch (i) {
                    case 0:
                        tipoOperacion = "1";
                        break;
                    case 1:
                        tipoOperacion = "2";
                        break;
                    case 2:
                        tipoOperacion = "3";
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        tipoOperacion = "9";
                        break;
                }
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("63", tipoOperacion);
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("63", tipoOperacion);
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("63", tipoOperacion);
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.13
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) KmgeIVr5RG.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) KmgeIVr5RG.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.KmgeIVr5RG.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
