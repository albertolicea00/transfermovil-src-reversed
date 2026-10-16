package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB;

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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dYBdUyjb1D;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.hjX8MS8xO9;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.w7mHpmOa4EP;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.x12rSjPY6pZ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.HFzgpLELho;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.k5fNqiPSlwb;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.qcFLXVxM456.qAMfdm9Kls;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UMVR3qrc3V extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass14.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        UMVR3qrc3V.this.showDialogConsultaSaldo();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new dI2tctjNbR()).addToBackStack(null).commit();
                        break;
                    case 3:
                        if (U6ucOCBccJ.isAGTelecom(UMVR3qrc3V.this.context)) {
                            UMVR3qrc3V.this.showAGConsulta();
                        } else {
                            mFragmentTransaction.replace(R.id.containerView, new k5fNqiPSlwb()).addToBackStack(null).commit();
                        }
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new qAMfdm9Kls()).addToBackStack(null).commit();
                        break;
                    case 5:
                        UMVR3qrc3V.this.showDialogReservaOFA();
                        break;
                    case 6:
                        UMVR3qrc3V.this.showDialogConsultaTicket();
                        break;
                    case 7:
                        UMVR3qrc3V.this.showConsultaMiBoleto();
                        break;
                    case 8:
                        UMVR3qrc3V.this.goToConsultaSindicato();
                        break;
                    default:
                        Toast.makeText(UMVR3qrc3V.this.context, operacion.toString(), 1).show();
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
        WUULVgZq02 consulta_saldo = new WUULVgZq02();
        consulta_saldo.setTitulo(getString(R.string.tx_consultar_saldo));
        consulta_saldo.setSubtitulo(getString(R.string.tx_consultar_saldo_actual));
        consulta_saldo.setIcono(R.drawable.ic_consulta_saldo_bolsa);
        Integer num = rBXnNc0Kx4.Post;
        consulta_saldo.setType(num);
        consulta_saldo.setOperacion(FdonIAFI9w.BOLSAConsultarSaldo);
        itemsOperaciones.add(consulta_saldo);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo(getString(R.string.tx_ultimas_operaciones));
        ult_operaciones.setSubtitulo(getString(R.string.tx_sub_ultimas_operaciones_bolsa));
        ult_operaciones.setIcono(R.drawable.ic_consulta_utlimas_oper_bolsa);
        ult_operaciones.setType(num);
        ult_operaciones.setOperacion(FdonIAFI9w.BOLSAUltimasOperaciones);
        itemsOperaciones.add(ult_operaciones);
        WUULVgZq02 consultaServicios = new WUULVgZq02();
        consultaServicios.setTitulo(getString(R.string.tx_consultar_servicio_bolsa));
        consultaServicios.setSubtitulo(getString(R.string.tx_sub_consultar_servicio_bolsa));
        consultaServicios.setIcono(R.drawable.ic_consultar_servicio_bolsa);
        consultaServicios.setType(num);
        consultaServicios.setOperacion(FdonIAFI9w.BOLSAConsultaServicio);
        itemsOperaciones.add(consultaServicios);
        WUULVgZq02 estadoCuenta = new WUULVgZq02();
        estadoCuenta.setTitulo("Estado Cuentas");
        estadoCuenta.setSubtitulo("Solicitar estado de una cuenta");
        estadoCuenta.setIcono(R.drawable.ic_consulta_estado_cuenta_bolsa);
        estadoCuenta.setType(num);
        estadoCuenta.setOperacion(FdonIAFI9w.BOLSAEstadoCuenta);
        itemsOperaciones.add(estadoCuenta);
        WUULVgZq02 consultaOFA = new WUULVgZq02();
        consultaOFA.setTitulo(getString(R.string.title_consulta_reservas_ofa));
        consultaOFA.setSubtitulo(getString(R.string.subtitle_consulta_reservas_ofa));
        consultaOFA.setIcono(R.drawable.ic_consulta_ofa_bolsa_nuevo);
        consultaOFA.setType(num);
        consultaOFA.setOperacion(FdonIAFI9w.BOLSAConsultaReservaOFA);
        itemsOperaciones.add(consultaOFA);
        WUULVgZq02 consulta_ticket = new WUULVgZq02();
        consulta_ticket.setTitulo(getString(R.string.title_reserva_ticket_consulta));
        consulta_ticket.setSubtitulo(getString(R.string.title_reserva_ticket_consulta));
        consulta_ticket.setIcono(R.drawable.ic_consulta_miturno_bolsa);
        consulta_ticket.setType(num);
        consulta_ticket.setOperacion(FdonIAFI9w.BOLSAConsultaTicket);
        itemsOperaciones.add(consulta_ticket);
        WUULVgZq02 consulta_miboleto = new WUULVgZq02();
        consulta_miboleto.setTitulo(getString(R.string.title_consulta_miboleto));
        consulta_miboleto.setSubtitulo(getString(R.string.subtitle_consulta_miboleto));
        consulta_miboleto.setIcono(R.drawable.ic_consulta_miboleto_bolsa);
        consulta_miboleto.setType(num);
        consulta_miboleto.setOperacion(FdonIAFI9w.BOLSAConsultaMiBoleto);
        itemsOperaciones.add(consulta_miboleto);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V$14, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass14 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BOLSAConsultarSaldo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAUltimasOperaciones.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAConsultaServicio.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAEstadoCuenta.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAConsultaReservaOFA.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAConsultaTicket.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAConsultaMiBoleto.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAConsultaSindicato.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaSaldo() {
        CharSequence[] items = getResources().getStringArray(R.array.array_bolsa_consulta_saldo);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de cuenta: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 1) {
                    FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new GvNasrezHU()).addToBackStack(null).commit();
                } else {
                    rDEl7rW1aN bs = new rDEl7rW1aN();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) UMVR3qrc3V.this.getActivity()).actionCallUSSD("46");
                    } else {
                        ((IHVTCBmiLV) UMVR3qrc3V.this.getActivity()).actionCallUSSD("46");
                    }
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.3
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    rDEl7rW1aN bs = new rDEl7rW1aN();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) UMVR3qrc3V.this.getActivity()).actionCallUSSD("103");
                    } else {
                        ((IHVTCBmiLV) UMVR3qrc3V.this.getActivity()).actionCallUSSD("103");
                    }
                } else {
                    FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new x12rSjPY6pZ()).addToBackStack(null).commit();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogUltimasOperaciones() {
        CharSequence[] items = getResources().getStringArray(R.array.array_bolsa_ult_oper);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de cuenta: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 2) {
                    FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new dI2tctjNbR()).addToBackStack(null).commit();
                } else {
                    int position = i + 1;
                    String pos = String.valueOf(position);
                    rDEl7rW1aN bs = new rDEl7rW1aN();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) UMVR3qrc3V.this.getActivity()).actionCallUSSD("48", pos);
                    } else {
                        ((IHVTCBmiLV) UMVR3qrc3V.this.getActivity()).actionCallUSSD("48", pos);
                    }
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogReservaOFA() {
        CharSequence[] items = getResources().getStringArray(R.array.array_consulta_reserva_ofa);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione el tipo de consulta de Visita/Recorrido: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                dYBdUyjb1D consultaReservasOFA = new dYBdUyjb1D();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                arg.putSerializable("Opcion", Integer.valueOf(i + 1));
                consultaReservasOFA.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, consultaReservasOFA).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAGConsulta() {
        CharSequence[] items = {this.context.getString(R.string.tx_modal_head_consulat_ag_op1), this.context.getString(R.string.tx_modal_head_consulat_ag_op2)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_modal_head_consulat_ag));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new HFzgpLELho()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new k5fNqiPSlwb()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConsultaMiBoleto() {
        CharSequence[] items = {"Consulta de Ofertas", "Últimas operaciones realizadas", "Consulta de boletos", "Consulta estado de boleto", "Actualizar clave de boleto"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.alert_msg_consulta_combustible));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = UMVR3qrc3V.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                new Bundle();
                rDEl7rW1aN bs = new rDEl7rW1aN();
                switch (i) {
                    case 0:
                        if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                            ((S9ycHcoxAzy) UMVR3qrc3V.this.getActivity()).actionCallUSSD("117");
                        } else {
                            ((IHVTCBmiLV) UMVR3qrc3V.this.getActivity()).actionCallUSSD("117");
                        }
                        break;
                    case 1:
                        i9I9XZGnR3 miboleto = new i9I9XZGnR3();
                        mFragmentTransaction.replace(R.id.containerView, miboleto).addToBackStack(null).commit();
                        break;
                    case 2:
                        OXpoe3K2m1 miboleto2 = new OXpoe3K2m1();
                        mFragmentTransaction.replace(R.id.containerView, miboleto2).addToBackStack(null).commit();
                        break;
                    case 3:
                        w7mHpmOa4EP miboleto3 = new w7mHpmOa4EP();
                        mFragmentTransaction.replace(R.id.containerView, miboleto3).addToBackStack(null).commit();
                        break;
                    case 4:
                        hjX8MS8xO9 miboleto4 = new hjX8MS8xO9();
                        mFragmentTransaction.replace(R.id.containerView, miboleto4).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.UMVR3qrc3V.13
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
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ConsultarPagosSindicato);
        SlZq2dCM9i ticket = new SlZq2dCM9i();
        ticket.setArguments(arg);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, ticket).addToBackStack(null).commit();
    }
}
