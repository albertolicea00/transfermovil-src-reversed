package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.gNS2UxRuVW;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.ouX1muv8Hd;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SqtuHONWS9 extends Fragment {
    private ouX1muv8Hd HeaderItemDecoration;
    private gNS2UxRuVW adapter;
    public Context context;
    private LinearLayoutManager layoutManager;
    public gNS2UxRuVW.OnItemClickListener onItemClickListenerStick = new gNS2UxRuVW.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.gNS2UxRuVW.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = SqtuHONWS9.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            if (operacion != null) {
                int i = AnonymousClass14.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()];
                Toast.makeText(SqtuHONWS9.this.context, operacion.toString(), 1).show();
            }
        }
    };
    private RecyclerView recyclerView;
    public View rootView;

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9$14, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass14 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = new int[FdonIAFI9w.values().length];
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.uuxgaxmj7ykyg, container, false);
        this.context = container.getContext();
        initAdapter();
        initData();
        return this.rootView;
    }

    private void initAdapter() {
        this.adapter = new gNS2UxRuVW();
        this.layoutManager = new LinearLayoutManager(this.context);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.drawerList);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(this.layoutManager);
        this.HeaderItemDecoration = new ouX1muv8Hd(this.adapter);
        this.recyclerView.setAdapter(this.adapter);
    }

    private void initData() {
        ArrayList arrayList = new ArrayList();
        WUULVgZq02 head1 = new WUULVgZq02();
        head1.setTitulo("Sesión");
        Integer num = rBXnNc0Kx4.Header;
        head1.setType(num);
        arrayList.add(head1);
        WUULVgZq02 autenticarse = new WUULVgZq02();
        autenticarse.setTitulo("Autenticarse");
        autenticarse.setSubtitulo("Acceder al sistema");
        autenticarse.setIcono(R.drawable.banco_metro_autenticar);
        Integer num2 = rBXnNc0Kx4.Post;
        autenticarse.setType(num2);
        autenticarse.setOperacion(FdonIAFI9w.METROAutenticarse);
        arrayList.add(autenticarse);
        WUULVgZq02 close = new WUULVgZq02();
        close.setTitulo(this.context.getString(R.string.banco_desconectar));
        close.setSubtitulo(this.context.getString(R.string.banco_sub_desconectar));
        close.setIcono(R.drawable.banco_metro_cerrar);
        close.setType(num2);
        close.setOperacion(FdonIAFI9w.METRODesconectar);
        arrayList.add(close);
        WUULVgZq02 head2 = new WUULVgZq02();
        head2.setTitulo("Consultas");
        head2.setType(num);
        arrayList.add(head2);
        WUULVgZq02 consulta_saldo = new WUULVgZq02();
        consulta_saldo.setTitulo("Consultar Saldo");
        consulta_saldo.setSubtitulo("Consultar saldo actual de la cuenta");
        consulta_saldo.setIcono(R.drawable.banco_metro_consultar);
        consulta_saldo.setType(num2);
        consulta_saldo.setOperacion(FdonIAFI9w.METROConsultarSaldo);
        arrayList.add(consulta_saldo);
        WUULVgZq02 consulta_servicio = new WUULVgZq02();
        consulta_servicio.setTitulo("Consultar Servicio");
        consulta_servicio.setSubtitulo("Consultar factura del servicio");
        consulta_servicio.setIcono(R.drawable.banco_metro_telebanca);
        consulta_servicio.setType(num2);
        consulta_servicio.setOperacion(FdonIAFI9w.METROConsultarServicio);
        arrayList.add(consulta_servicio);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo("Últimas operaciones");
        ult_operaciones.setSubtitulo("Últimas 10 operaciones de la cuenta");
        ult_operaciones.setIcono(R.drawable.banco_metro_uoperaciones);
        ult_operaciones.setType(num2);
        ult_operaciones.setOperacion(FdonIAFI9w.METROUltimasoperaciones);
        arrayList.add(ult_operaciones);
        WUULVgZq02 consultaLimite = new WUULVgZq02();
        consultaLimite.setTitulo("Consulta de límites");
        consultaLimite.setSubtitulo("Consulta de límites de las cuentas bancarias");
        consultaLimite.setIcono(R.drawable.banco_metro_consulta_limite);
        consultaLimite.setType(num2);
        consultaLimite.setOperacion(FdonIAFI9w.METROConsultaLimite);
        arrayList.add(consultaLimite);
        WUULVgZq02 consultaAllCuenta = new WUULVgZq02();
        consultaAllCuenta.setTitulo("Consultar Todas las Cuentas");
        consultaAllCuenta.setSubtitulo("Consultar Todas las Cuentas Bancarias");
        consultaAllCuenta.setIcono(R.drawable.banco_metro_consultar_todas_cuentas);
        consultaAllCuenta.setType(num2);
        consultaAllCuenta.setOperacion(FdonIAFI9w.METROConsultaTodasCuentas);
        arrayList.add(consultaAllCuenta);
        WUULVgZq02 consGiro = new WUULVgZq02();
        consGiro.setTitulo("Consulta Giros");
        consGiro.setSubtitulo("Giros pendientes");
        consGiro.setIcono(R.drawable.ico_agent_consultar_factura);
        consGiro.setType(num2);
        consGiro.setOperacion(FdonIAFI9w.METROConsultarGiroPostal);
        arrayList.add(consGiro);
        WUULVgZq02 ltransfer = new WUULVgZq02();
        ltransfer.setTitulo("Localizar transferencias");
        ltransfer.setSubtitulo("Localización de transferencias del exterior");
        ltransfer.setIcono(R.drawable.ico_agent_consultar_factura);
        ltransfer.setType(num2);
        ltransfer.setOperacion(FdonIAFI9w.METROLocalizarTransferencia);
        arrayList.add(ltransfer);
        WUULVgZq02 head3 = new WUULVgZq02();
        head3.setTitulo("Operaciones");
        head3.setType(num);
        arrayList.add(head3);
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo("Transferir Efectivo");
        transferencia.setSubtitulo(getString(R.string.banco_sub_transferencia));
        transferencia.setIcono(R.drawable.banco_metro_transferir);
        transferencia.setType(num2);
        transferencia.setOperacion(FdonIAFI9w.METROTransferirEfectivo);
        arrayList.add(transferencia);
        WUULVgZq02 telefono = new WUULVgZq02();
        telefono.setTitulo(getString(R.string.banco_telefono));
        telefono.setSubtitulo(getString(R.string.banco_sub_telefono));
        telefono.setIcono(R.drawable.banco_metro_telefono);
        telefono.setType(num2);
        telefono.setOperacion(FdonIAFI9w.METROTelefono);
        arrayList.add(telefono);
        WUULVgZq02 electricidad = new WUULVgZq02();
        electricidad.setTitulo(getString(R.string.banco_electricidad));
        electricidad.setSubtitulo(getString(R.string.banco_sub_electricidad));
        electricidad.setIcono(R.drawable.banco_metro_pelectrica);
        electricidad.setType(num2);
        electricidad.setOperacion(FdonIAFI9w.METROElectricidad);
        arrayList.add(electricidad);
        WUULVgZq02 agua = new WUULVgZq02();
        agua.setTitulo("Agua");
        agua.setSubtitulo("Pagar factura Aguas de la Habana");
        agua.setIcono(R.drawable.banco_metro_pagua);
        agua.setType(num2);
        agua.setOperacion(FdonIAFI9w.METROAgua);
        arrayList.add(agua);
        WUULVgZq02 gas = new WUULVgZq02();
        gas.setTitulo("Gas");
        gas.setSubtitulo("Pagar factura de gas en la Habana");
        gas.setIcono(R.drawable.banco_metro_pagua);
        gas.setType(num2);
        gas.setOperacion(FdonIAFI9w.METROGas);
        arrayList.add(gas);
        WUULVgZq02 onat = new WUULVgZq02();
        onat.setTitulo("Impuestos");
        onat.setSubtitulo("Pagar Impuestos");
        onat.setIcono(R.drawable.banco_metro_onat);
        onat.setType(num2);
        onat.setOperacion(FdonIAFI9w.METROImpuestos);
        arrayList.add(onat);
        WUULVgZq02 recargarMovil = new WUULVgZq02();
        recargarMovil.setTitulo("Recarga Saldo Móvil");
        recargarMovil.setSubtitulo("Recargar saldo del móvil con cuenta bancaria");
        recargarMovil.setIcono(R.drawable.banco_metro_recarga);
        recargarMovil.setType(num2);
        recargarMovil.setOperacion(FdonIAFI9w.METRORecargaMovil);
        arrayList.add(recargarMovil);
        WUULVgZq02 giroPostal = new WUULVgZq02();
        giroPostal.setTitulo("Realizar Giro Postal");
        giroPostal.setSubtitulo("Realizar Giro cuentaCaracteres traves de Correo de Cuba");
        giroPostal.setIcono(R.drawable.ico_agent_consultar_factura);
        giroPostal.setType(num2);
        giroPostal.setOperacion(FdonIAFI9w.METROGiroPostal);
        arrayList.add(giroPostal);
        WUULVgZq02 pagoExternoUCI = new WUULVgZq02();
        pagoExternoUCI.setTitulo("Pago Externo");
        pagoExternoUCI.setSubtitulo("Comercio Electronico");
        pagoExternoUCI.setIcono(R.drawable.ico_agent_consultar_factura);
        pagoExternoUCI.setType(num2);
        pagoExternoUCI.setOperacion(FdonIAFI9w.METROPagoExterno);
        arrayList.add(pagoExternoUCI);
        WUULVgZq02 recargaNauta = new WUULVgZq02();
        recargaNauta.setTitulo("Recarga Nauta");
        recargaNauta.setSubtitulo("Recargar cuenta permanente nauta");
        recargaNauta.setIcono(R.drawable.ico_agent_consultar_factura);
        recargaNauta.setType(num2);
        recargaNauta.setOperacion(FdonIAFI9w.METRORecargaNauta);
        arrayList.add(recargaNauta);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de límites");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.banco_metro_cambio_limite);
        cambioLimite.setType(num2);
        cambioLimite.setOperacion(FdonIAFI9w.METROCambioLimite);
        arrayList.add(cambioLimite);
        WUULVgZq02 head4 = new WUULVgZq02();
        head4.setTitulo("Configuración");
        head4.setType(num);
        arrayList.add(head4);
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Registrarse");
        registro.setSubtitulo("Registrarse en el sistema");
        registro.setIcono(R.drawable.banco_metro_registro);
        registro.setType(num2);
        registro.setOperacion(FdonIAFI9w.METRORegistrarse);
        arrayList.add(registro);
        WUULVgZq02 eliminarreg = new WUULVgZq02();
        eliminarreg.setTitulo("Eliminar registro");
        eliminarreg.setSubtitulo("Eliminar registro asociado cuentaCaracteres su tarjeta");
        eliminarreg.setIcono(R.drawable.banco_metro_eliminar);
        eliminarreg.setType(num2);
        eliminarreg.setOperacion(FdonIAFI9w.METROEliminarregistro);
        arrayList.add(eliminarreg);
        WUULVgZq02 cambioclave = new WUULVgZq02();
        cambioclave.setTitulo("Cambio de clave");
        cambioclave.setSubtitulo("Cambiar la clave de acceso");
        cambioclave.setIcono(R.drawable.banco_metro_clave);
        cambioclave.setType(num2);
        cambioclave.setOperacion(FdonIAFI9w.METROCambioPin);
        arrayList.add(cambioclave);
        WUULVgZq02 asociar = new WUULVgZq02();
        asociar.setTitulo("Asociar cuenta");
        asociar.setSubtitulo("Asociar cuenta cuentaCaracteres tarjeta telebanca");
        asociar.setIcono(R.drawable.banco_metro_telebanca_vincular);
        asociar.setType(num2);
        asociar.setOperacion(FdonIAFI9w.METROAsociarCuenta);
        arrayList.add(asociar);
        WUULVgZq02 actualizar = new WUULVgZq02();
        actualizar.setTitulo("Actualizar cuenta");
        actualizar.setSubtitulo("Actualizar cuentas asociadas cuentaCaracteres su tarjeta telebanca");
        actualizar.setIcono(R.drawable.banco_metro_actualizar);
        actualizar.setType(num2);
        actualizar.setOperacion(FdonIAFI9w.METROActualizarcuenta);
        arrayList.add(actualizar);
        WUULVgZq02 reimprimir = new WUULVgZq02();
        reimprimir.setTitulo("Reimprimir nueva tarjeta");
        reimprimir.setSubtitulo("Reimprimir nueva");
        reimprimir.setIcono(R.drawable.banco_metro_actualizar);
        reimprimir.setType(num2);
        reimprimir.setOperacion(FdonIAFI9w.METROReimprimirTarjeta);
        arrayList.add(reimprimir);
        this.adapter.submitList(arrayList);
        this.adapter.setOnItemClickListener(this.onItemClickListenerStick);
    }

    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("70");
                        return;
                    } else {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("70");
                        return;
                    }
                }
                ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("70");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        FBsQzP3Zfj.closeSessionBank(getActivity());
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTipoMOnedaConsultaSaldo() {
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "1");
                } else {
                    ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("46", "2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.5
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
        builder.setTitle("Seleccionar el tipo de moneda de su tarjeta cuentaCaracteres consultar:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "1");
                } else {
                    ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("62", "2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.7
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.9
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
        builder.setTitle("Seleccione segun la moneda la tarjeta cuentaCaracteres reimprimir:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.10
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
                Uri number = Uri.parse(cadena2);
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    SqtuHONWS9.this.context.startActivity(dial);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogLocalizaTransferencias() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea localizar las transferencias pendientes de sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("73");
                        return;
                    } else {
                        ((IHVTCBmiLV) SqtuHONWS9.this.getActivity()).actionCallUSSD("73");
                        return;
                    }
                }
                ((S9ycHcoxAzy) SqtuHONWS9.this.getActivity()).actionCallUSSD("73");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SqtuHONWS9.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
