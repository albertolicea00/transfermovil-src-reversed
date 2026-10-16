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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.e8WK1Uajbq;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.h3sd43nvje;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.GF0vcofd59d.ix4mhKGJty;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.XvOK7VM4qL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.xoZnbyoSLT;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.MAvaCEUqwa;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.V0zQxQBN2i;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.T8uOynS2ba;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.iappKl5Vl3;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.p8fd3aGf9lK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.y4hizMsUIU;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class kmO9Md6JHr extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = kmO9Md6JHr.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (AnonymousClass22.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                case 1:
                    mFragmentTransaction.replace(R.id.containerView, new ix4mhKGJty()).addToBackStack(null).commit();
                    break;
                case 2:
                    mFragmentTransaction.replace(R.id.containerView, new xoZnbyoSLT()).addToBackStack(null).commit();
                    break;
                case 3:
                    mFragmentTransaction.replace(R.id.containerView, new h3sd43nvje()).addToBackStack(null).commit();
                    break;
                case 4:
                    mFragmentTransaction.replace(R.id.containerView, new e8WK1Uajbq()).addToBackStack(null).commit();
                    break;
                case 5:
                    mFragmentTransaction.replace(R.id.containerView, new XvOK7VM4qL()).addToBackStack(null).commit();
                    break;
                case 6:
                    kmO9Md6JHr.this.showDialogTodasCuentas();
                    break;
                case 7:
                    kmO9Md6JHr.this.showDialogConsultaCredito();
                    break;
                case 8:
                    kmO9Md6JHr.this.showDialogTipoCambio();
                    break;
                case 9:
                    kmO9Md6JHr.this.showConsultaMulta();
                    break;
                case 10:
                    kmO9Md6JHr.this.showDialogInformacionTarjetaRed();
                    break;
                case 11:
                    Bundle arg = new Bundle();
                    arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                    MAvaCEUqwa obtenerCuentaEstandarPAN = new MAvaCEUqwa();
                    obtenerCuentaEstandarPAN.setArguments(arg);
                    mFragmentTransaction.replace(R.id.containerView, obtenerCuentaEstandarPAN).addToBackStack(null).commit();
                    break;
                case 12:
                    kmO9Md6JHr.this.showConsultaCombustible();
                    break;
                case 13:
                    kmO9Md6JHr.this.showDialogConsultaTicket();
                    break;
                case 14:
                    kmO9Md6JHr.this.goToConsultaSindicato();
                    break;
                default:
                    Toast.makeText(kmO9Md6JHr.this.context, "Error! " + operacion, 0).show();
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
        WUULVgZq02 consulta_saldo = new WUULVgZq02();
        consulta_saldo.setTitulo("Consultar Saldo");
        consulta_saldo.setSubtitulo("Consultar saldo actual de la tarjeta");
        consulta_saldo.setIcono(R.drawable.ic_consulta_saldo_bpa);
        Integer num = rBXnNc0Kx4.Post;
        consulta_saldo.setType(num);
        consulta_saldo.setOperacion(FdonIAFI9w.BPAConsultarSaldo);
        itemsOperaciones.add(consulta_saldo);
        WUULVgZq02 consula_integrada = new WUULVgZq02();
        consula_integrada.setTitulo(getString(R.string.title_service_bpa_consulta_integrada));
        consula_integrada.setSubtitulo(getString(R.string.sub_service_bpa_consulta_integrada));
        consula_integrada.setIcono(R.drawable.ic_consulta_todas_cuentas_bpa);
        consula_integrada.setType(num);
        consula_integrada.setOperacion(FdonIAFI9w.BPAConsultarTodasCuentas);
        itemsOperaciones.add(consula_integrada);
        WUULVgZq02 consulta_servicio = new WUULVgZq02();
        consulta_servicio.setTitulo("Consultar Servicio");
        consulta_servicio.setSubtitulo("Consultar factura del servicio");
        consulta_servicio.setIcono(R.drawable.ic_consultar_servicio_bpa);
        consulta_servicio.setType(num);
        consulta_servicio.setOperacion(FdonIAFI9w.BPAConsultarServicio);
        itemsOperaciones.add(consulta_servicio);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo("Últimas Operaciones");
        ult_operaciones.setSubtitulo("Últimas 10 operaciones de la tarjeta");
        ult_operaciones.setIcono(R.drawable.ic_consulta_utlimas_oper_bpa);
        ult_operaciones.setType(num);
        ult_operaciones.setOperacion(FdonIAFI9w.BPAUltimasoperaciones);
        itemsOperaciones.add(ult_operaciones);
        WUULVgZq02 consultaLimite = new WUULVgZq02();
        consultaLimite.setTitulo("Consulta de Límites");
        consultaLimite.setSubtitulo("Consulta de límites de las cuentas bancarias");
        consultaLimite.setIcono(R.drawable.ic_consulta_limites_bpa);
        consultaLimite.setType(num);
        consultaLimite.setOperacion(FdonIAFI9w.BPAConsultaLimite);
        itemsOperaciones.add(consultaLimite);
        WUULVgZq02 consGiro = new WUULVgZq02();
        consGiro.setTitulo(getString(R.string.title_consulta_giro));
        consGiro.setSubtitulo(getString(R.string.sub_consulta_giros));
        consGiro.setIcono(R.drawable.ic_consultar_giro_bpa);
        consGiro.setType(num);
        consGiro.setOperacion(FdonIAFI9w.BPAConsultarGiroPostal);
        itemsOperaciones.add(consGiro);
        WUULVgZq02 consula_creditos = new WUULVgZq02();
        consula_creditos.setTitulo(getString(R.string.title_service_bpa_consulta_credito));
        consula_creditos.setSubtitulo(getString(R.string.sub_service_consulta_credito));
        consula_creditos.setIcono(R.drawable.ic_consulta_credito_bpa);
        consula_creditos.setType(num);
        consula_creditos.setOperacion(FdonIAFI9w.BPAConsultaCredito);
        itemsOperaciones.add(consula_creditos);
        WUULVgZq02 tipoCambio = new WUULVgZq02();
        tipoCambio.setTitulo(getString(R.string.title_tipo_cambio));
        tipoCambio.setSubtitulo(getString(R.string.sub_tipo_cambio));
        tipoCambio.setIcono(R.drawable.ic_tipo_cambio_bpa);
        tipoCambio.setType(num);
        tipoCambio.setOperacion(FdonIAFI9w.BPATipoCambio);
        itemsOperaciones.add(tipoCambio);
        WUULVgZq02 multaConsulta = new WUULVgZq02();
        multaConsulta.setTitulo("Consulta de Multa");
        multaConsulta.setSubtitulo("Consulta de Multa");
        multaConsulta.setIcono(R.drawable.ic_consulta_multa_bpa);
        multaConsulta.setType(num);
        multaConsulta.setOperacion(FdonIAFI9w.BPAConsultaMulta);
        itemsOperaciones.add(multaConsulta);
        WUULVgZq02 tarjetaRed = new WUULVgZq02();
        tarjetaRed.setTitulo("Información Tarjeta Red");
        tarjetaRed.setSubtitulo("Estado de Tarjeta Red");
        tarjetaRed.setIcono(R.drawable.ic_info_tarjeta_bpa);
        tarjetaRed.setType(num);
        tarjetaRed.setOperacion(FdonIAFI9w.BPAInformacionTarjeta);
        itemsOperaciones.add(tarjetaRed);
        WUULVgZq02 ccuentaestandar = new WUULVgZq02();
        ccuentaestandar.setTitulo("Obtener Cuenta Estandar");
        ccuentaestandar.setSubtitulo("Obtener cuenta estandar mediante PAN");
        ccuentaestandar.setIcono(R.drawable.ic_info_tarjeta_bpa);
        ccuentaestandar.setType(num);
        ccuentaestandar.setOperacion(FdonIAFI9w.BPAObtenerCuentaEstandar);
        itemsOperaciones.add(ccuentaestandar);
        WUULVgZq02 combustibleConsulta = new WUULVgZq02();
        combustibleConsulta.setTitulo(getString(R.string.title_consulta_cupones));
        combustibleConsulta.setSubtitulo(getString(R.string.subtitle_consulta_combustible));
        combustibleConsulta.setIcono(R.drawable.ic_consulta_cupon_combustible_bpa);
        combustibleConsulta.setType(num);
        combustibleConsulta.setOperacion(FdonIAFI9w.BPACombustibleConsultas);
        itemsOperaciones.add(combustibleConsulta);
        WUULVgZq02 cticket = new WUULVgZq02();
        cticket.setTitulo(getString(R.string.title_reserva_ticket_consulta));
        cticket.setSubtitulo(getString(R.string.title_reserva_ticket_consulta));
        cticket.setIcono(R.drawable.ic_consulta_miturno_bpa);
        cticket.setType(num);
        cticket.setOperacion(FdonIAFI9w.BPAConsultaTicket);
        itemsOperaciones.add(cticket);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr$22, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass22 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BPAConsultarSaldo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultarServicio.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAUltimasoperaciones.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultaLimite.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultarGiroPostal.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultarTodasCuentas.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultaCredito.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPATipoCambio.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultaMulta.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAInformacionTarjeta.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAObtenerCuentaEstandar.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPACombustibleConsultas.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultaTicket.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BPAConsultaSindicato.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogInformacionTarjetaRed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el estado de su tarjeta red? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("78");
                        return;
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("78");
                        return;
                    }
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("78");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaTicket() {
        CharSequence[] items = getResources().getStringArray(R.array.array_bolsa_consulta_ticket);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de consulta: ");
        final Bundle arg = new Bundle();
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    rDEl7rW1aN bs = new rDEl7rW1aN();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("103");
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("103");
                    }
                } else {
                    arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ConsultarReservasTicket);
                    V0zQxQBN2i ticket = new V0zQxQBN2i();
                    ticket.setArguments(arg);
                    FragmentManager mFragmentManager = kmO9Md6JHr.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, ticket).addToBackStack(null).commit();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTipoCambio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el tipo de cambio vigente? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("85");
                        return;
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("85");
                        return;
                    }
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("85");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaCredito() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea ver los créditos pendientes? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("72");
                        return;
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("72");
                        return;
                    }
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("72");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogConsultarLimites() {
        CharSequence[] items = getResources().getStringArray(R.array.currency);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Para consultar los límites de sus cuentas bancarias debe seleccionar el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int position = i + 1;
                String pos = String.valueOf(position);
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() == null) {
                    ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("62", pos);
                } else if (bs.getCodeAgent().getCode().contains("-1")) {
                    ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("62", pos);
                } else {
                    ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("62", pos);
                }
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTipoMOneda(final String operacion) {
        CharSequence[] items = getResources().getStringArray(R.array.currency);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int position = i + 1;
                String pos = String.valueOf(position);
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, pos);
                        return;
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, pos);
                        return;
                    }
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, pos);
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogUltimosTipoMOneda(final String operacion) {
        CharSequence[] items = getResources().getStringArray(R.array.currency);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int position = i + 1;
                String pos = String.valueOf(position);
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, "00*" + pos);
                        return;
                    }
                    ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, "00*" + pos);
                    return;
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD(operacion, "00*" + pos);
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTodasCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el importe de todas sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) kmO9Md6JHr.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) kmO9Md6JHr.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConsultaMulta() {
        CharSequence[] items = {"Multa de contravención", "Multa de tránsito"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.alert_msg_conulta_tipo));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.18
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = kmO9Md6JHr.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Bundle arg = new Bundle();
                if (i == 0) {
                    arg.putSerializable("TipoMultaEntity", ULFE6hmQU6.TipoMulta.Contravension);
                } else {
                    arg.putSerializable("TipoMultaEntity", ULFE6hmQU6.TipoMulta.Transito);
                }
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                ULFE6hmQU6 consultaMultas = new ULFE6hmQU6();
                consultaMultas.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, consultaMultas).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.19
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConsultaCombustible() {
        CharSequence[] items = {"Últimas operaciones realizadas", "Consulta de cupones", "Consulta estado de cupones", "Actualizar clave de cupones"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.alert_msg_consulta_combustible));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = kmO9Md6JHr.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                new Bundle();
                switch (i) {
                    case 0:
                        iappKl5Vl3 combustible = new iappKl5Vl3();
                        mFragmentTransaction.replace(R.id.containerView, combustible).addToBackStack(null).commit();
                        break;
                    case 1:
                        y4hizMsUIU combustible2 = new y4hizMsUIU();
                        mFragmentTransaction.replace(R.id.containerView, combustible2).addToBackStack(null).commit();
                        break;
                    case 2:
                        T8uOynS2ba combustible3 = new T8uOynS2ba();
                        mFragmentTransaction.replace(R.id.containerView, combustible3).addToBackStack(null).commit();
                        break;
                    case 3:
                        p8fd3aGf9lK combustible4 = new p8fd3aGf9lK();
                        mFragmentTransaction.replace(R.id.containerView, combustible4).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.izLB5V8oGbU.kmO9Md6JHr.21
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToConsultaSindicato() {
        Bundle arg = new Bundle();
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ConsultarPagosSindicato);
        SlZq2dCM9i ticket = new SlZq2dCM9i();
        ticket.setArguments(arg);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, ticket).addToBackStack(null).commit();
    }
}
