package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk;

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
public class VYOSpQMJgQ extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = VYOSpQMJgQ.this.getActivity().getSupportFragmentManager();
            mFragmentManager.beginTransaction();
            int i = AnonymousClass18.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()];
            Toast.makeText(VYOSpQMJgQ.this.context, "Error! " + operacion, 0).show();
        }
    };
    public View rootView;
    public RecyclerView rvseguridad;

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ$18, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass18 {
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
        autenticarse.setIcono(R.drawable.banco_bpa_login);
        Integer num = rBXnNc0Kx4.Post;
        autenticarse.setType(num);
        autenticarse.setOperacion(FdonIAFI9w.BPAAutenticarse);
        itemsOperaciones.add(autenticarse);
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo(getString(R.string.banco_transferencia));
        transferencia.setSubtitulo(getString(R.string.banco_sub_transferencia));
        transferencia.setIcono(R.drawable.banco_bpa_transferencia);
        transferencia.setType(num);
        transferencia.setOperacion(FdonIAFI9w.BPATransferencia);
        itemsOperaciones.add(transferencia);
        WUULVgZq02 electricidad = new WUULVgZq02();
        electricidad.setTitulo(getString(R.string.banco_electricidad));
        electricidad.setSubtitulo(getString(R.string.banco_sub_electricidad));
        electricidad.setIcono(R.drawable.banco_bpa_electricidad);
        electricidad.setType(num);
        electricidad.setOperacion(FdonIAFI9w.BPAElectricidad);
        itemsOperaciones.add(electricidad);
        WUULVgZq02 telefono = new WUULVgZq02();
        telefono.setTitulo(getString(R.string.banco_telefono));
        telefono.setSubtitulo(getString(R.string.banco_sub_telefono));
        telefono.setIcono(R.drawable.banco_bpa_telefono);
        telefono.setType(num);
        telefono.setOperacion(FdonIAFI9w.BPATelefono);
        itemsOperaciones.add(telefono);
        WUULVgZq02 onat = new WUULVgZq02();
        onat.setTitulo(getString(R.string.banco_onat));
        onat.setSubtitulo(getString(R.string.banco_sub_onat));
        onat.setIcono(R.drawable.banco_bpa_onat);
        onat.setType(num);
        onat.setOperacion(FdonIAFI9w.BPAONAT);
        itemsOperaciones.add(onat);
        WUULVgZq02 consulta_saldo = new WUULVgZq02();
        consulta_saldo.setTitulo("Consultar Saldo");
        consulta_saldo.setSubtitulo("Consultar saldo actual de la tarjeta");
        consulta_saldo.setIcono(R.drawable.banco_bpa_consultar);
        consulta_saldo.setType(num);
        consulta_saldo.setOperacion(FdonIAFI9w.BPAConsultarSaldo);
        itemsOperaciones.add(consulta_saldo);
        WUULVgZq02 consulta_servicio = new WUULVgZq02();
        consulta_servicio.setTitulo("Consultar Servicio");
        consulta_servicio.setSubtitulo("Consultar factura del servicio");
        consulta_servicio.setIcono(R.drawable.banco_bpa_cons_serv);
        consulta_servicio.setType(num);
        consulta_servicio.setOperacion(FdonIAFI9w.BPAConsultarServicio);
        itemsOperaciones.add(consulta_servicio);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo("Últimas operaciones");
        ult_operaciones.setSubtitulo("Últimas 10 operaciones de la tarjeta");
        ult_operaciones.setIcono(R.drawable.banco_bpa_ultimas);
        ult_operaciones.setType(num);
        ult_operaciones.setOperacion(FdonIAFI9w.BPAUltimasoperaciones);
        itemsOperaciones.add(ult_operaciones);
        WUULVgZq02 registro = new WUULVgZq02();
        registro.setTitulo("Registrarse");
        registro.setSubtitulo("Registrarse en el sistema");
        registro.setIcono(R.drawable.banco_bpa_registro);
        registro.setType(num);
        registro.setOperacion(FdonIAFI9w.BPARegistrarse);
        itemsOperaciones.add(registro);
        WUULVgZq02 changepass = new WUULVgZq02();
        changepass.setTitulo("Cambiar clave");
        changepass.setSubtitulo("Cambiar la clave de acceso");
        changepass.setIcono(R.drawable.banco_bpa_pin);
        changepass.setType(num);
        changepass.setOperacion(FdonIAFI9w.BPACambiarclave);
        itemsOperaciones.add(changepass);
        WUULVgZq02 close = new WUULVgZq02();
        close.setTitulo(this.context.getString(R.string.banco_desconectar));
        close.setSubtitulo(this.context.getString(R.string.banco_sub_desconectar));
        close.setIcono(R.drawable.banco_bpa_salir);
        close.setType(num);
        close.setOperacion(FdonIAFI9w.BPADesconectar);
        itemsOperaciones.add(close);
        WUULVgZq02 delRegister = new WUULVgZq02();
        delRegister.setTitulo("Eliminar Registro");
        delRegister.setSubtitulo("Eliminar registro asociado a su cuenta");
        delRegister.setIcono(R.drawable.eliminar_registro_bpa);
        delRegister.setType(num);
        delRegister.setOperacion(FdonIAFI9w.BPAEliminarRegistro);
        itemsOperaciones.add(delRegister);
        WUULVgZq02 recargarMovil = new WUULVgZq02();
        recargarMovil.setTitulo("Recarga Saldo Móvil");
        recargarMovil.setSubtitulo("Recargar saldo del móvil con cuenta bancaria");
        recargarMovil.setIcono(R.drawable.banco_bpa_recarga);
        recargarMovil.setType(num);
        recargarMovil.setOperacion(FdonIAFI9w.BPARecargaMovil);
        itemsOperaciones.add(recargarMovil);
        WUULVgZq02 cambioLimite = new WUULVgZq02();
        cambioLimite.setTitulo("Cambio de límite");
        cambioLimite.setSubtitulo("Cambio de límites de las cuentas bancarias");
        cambioLimite.setIcono(R.drawable.banco_bpa_cambio_limite);
        cambioLimite.setType(num);
        cambioLimite.setOperacion(FdonIAFI9w.BPACambioLimite);
        itemsOperaciones.add(cambioLimite);
        WUULVgZq02 consultaLimite = new WUULVgZq02();
        consultaLimite.setTitulo("Consulta de límites");
        consultaLimite.setSubtitulo("Consulta de límites de las cuentas bancarias");
        consultaLimite.setIcono(R.drawable.banco_bpa_consulta_limite);
        consultaLimite.setType(num);
        consultaLimite.setOperacion(FdonIAFI9w.BPAConsultaLimite);
        itemsOperaciones.add(consultaLimite);
        WUULVgZq02 cambioTarjeta = new WUULVgZq02();
        cambioTarjeta.setTitulo("Asociar cuentas");
        cambioTarjeta.setSubtitulo("Vincular otra cuenta bancaria");
        cambioTarjeta.setIcono(R.drawable.banco_bpa_actualizar);
        cambioTarjeta.setType(num);
        cambioTarjeta.setOperacion(FdonIAFI9w.BPAAsociarCuenta);
        itemsOperaciones.add(cambioTarjeta);
        WUULVgZq02 giroPostal = new WUULVgZq02();
        giroPostal.setTitulo("Realizar Giro Postal");
        giroPostal.setSubtitulo("Realizar Giro a traves de Correo de Cuba");
        giroPostal.setIcono(R.drawable.ico_agent_consultar_factura);
        giroPostal.setType(num);
        giroPostal.setOperacion(FdonIAFI9w.BPAGiroPostal);
        itemsOperaciones.add(giroPostal);
        WUULVgZq02 consGiro = new WUULVgZq02();
        consGiro.setTitulo("Consulta Giros");
        consGiro.setSubtitulo("Giros pendientes");
        consGiro.setIcono(R.drawable.ico_agent_consultar_factura);
        consGiro.setType(num);
        consGiro.setOperacion(FdonIAFI9w.BPAConsultarGiroPostal);
        itemsOperaciones.add(consGiro);
        WUULVgZq02 pagoExterno = new WUULVgZq02();
        pagoExterno.setTitulo("Pago Externo");
        pagoExterno.setSubtitulo("Comercio Electronico");
        pagoExterno.setIcono(R.drawable.ico_agent_consultar_factura);
        pagoExterno.setType(num);
        pagoExterno.setOperacion(FdonIAFI9w.BPAPagoExterno);
        itemsOperaciones.add(pagoExterno);
        WUULVgZq02 recargaNauta = new WUULVgZq02();
        recargaNauta.setTitulo("Recarga Nauta");
        recargaNauta.setSubtitulo("Recargar cuenta permanente nauta");
        recargaNauta.setIcono(R.drawable.ico_agent_consultar_factura);
        recargaNauta.setType(num);
        recargaNauta.setOperacion(FdonIAFI9w.BPARecargaNauta);
        itemsOperaciones.add(recargaNauta);
        WUULVgZq02 amortizar = new WUULVgZq02();
        amortizar.setTitulo("Amortizar");
        amortizar.setSubtitulo("Amortizar créditos bancarios");
        amortizar.setIcono(R.drawable.ico_agent_consultar_factura);
        amortizar.setType(num);
        amortizar.setOperacion(FdonIAFI9w.BPAAmortizar);
        itemsOperaciones.add(amortizar);
        WUULVgZq02 consula_integrada = new WUULVgZq02();
        consula_integrada.setTitulo("Consulta integrada");
        consula_integrada.setSubtitulo("Consulta de todas sus cuentas");
        consula_integrada.setIcono(R.drawable.banco_bpa_consultar);
        consula_integrada.setType(num);
        consula_integrada.setOperacion(FdonIAFI9w.BPAConsultarTodasCuentas);
        itemsOperaciones.add(consula_integrada);
        WUULVgZq02 consula_creditos = new WUULVgZq02();
        consula_creditos.setTitulo("Consulta créditos");
        consula_creditos.setSubtitulo("Consulta de todos sus créditos");
        consula_creditos.setIcono(R.drawable.banco_bpa_consultar);
        consula_creditos.setType(num);
        consula_creditos.setOperacion(FdonIAFI9w.BPAConsultaCredito);
        itemsOperaciones.add(consula_creditos);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    private void showDialogCerrarSession() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage(this.context.getString(R.string.msg_confirm_close_session));
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("70");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("70");
                        return;
                    }
                }
                ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("70");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.3
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("46");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("46");
                        return;
                    }
                }
                ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("46");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.5
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("72");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("72");
                        return;
                    }
                }
                ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("72");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.7
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("68*01");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("68*01");
                        return;
                    }
                }
                ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("68*01");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.9
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "1");
                } else {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("62", "2");
                }
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.11
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "1");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "1");
                } else {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.13
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        if (i == 0) {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*1");
                            return;
                        } else {
                            ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*2");
                            return;
                        }
                    }
                    if (i == 0) {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*1");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*2");
                        return;
                    }
                }
                if (i == 0) {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*1");
                } else {
                    ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD(operacion, "00*2");
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.15
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) VYOSpQMJgQ.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.VYOSpQMJgQ.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
