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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.myPAy8444WF.ULFE6hmQU6;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.MIya98FZRz;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.e7QqJJqvaOU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.QGOIyTuo2a;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Mg7YIILN4B;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.Np5pMRuX6q;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.leZyk029xo;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.iKwHmDs0tyq.stRd4NiI1J;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.m0lk5Y7wy1E;
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
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ME2IdEhApc extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = ME2IdEhApc.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass18.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new Mg7YIILN4B()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new m0lk5Y7wy1E()).addToBackStack(null).commit();
                        break;
                    case 3:
                        mFragmentTransaction.replace(R.id.containerView, new Np5pMRuX6q()).addToBackStack(null).commit();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new leZyk029xo()).addToBackStack(null).commit();
                        break;
                    case 5:
                        ME2IdEhApc.this.showDialogTodasCuentas();
                        break;
                    case 6:
                        mFragmentTransaction.replace(R.id.containerView, new QGOIyTuo2a()).addToBackStack(null).commit();
                        break;
                    case 7:
                        ME2IdEhApc.this.showDialogLocalizaTransferencias();
                        break;
                    case 8:
                        ME2IdEhApc.this.showDialogTipoCambio();
                        break;
                    case 9:
                        ME2IdEhApc.this.showConsultaMulta();
                        break;
                    case 10:
                        ME2IdEhApc.this.showDialogInformacionTarjetaRed();
                        break;
                    case 11:
                        ME2IdEhApc.this.showConsultaCombustible();
                        break;
                    case 12:
                        ME2IdEhApc.this.showDialogConsultaCredito();
                        break;
                    case 13:
                        mFragmentTransaction.replace(R.id.containerView, new MIya98FZRz()).addToBackStack(null).commit();
                        break;
                    case 14:
                        mFragmentTransaction.replace(R.id.containerView, new stRd4NiI1J()).addToBackStack(null).commit();
                        break;
                    case 15:
                        mFragmentTransaction.replace(R.id.containerView, new e7QqJJqvaOU()).addToBackStack(null).commit();
                        break;
                    case 16:
                        ME2IdEhApc.this.showDialogConsultaTicket();
                        break;
                    default:
                        Toast.makeText(ME2IdEhApc.this.context, operacion.toString(), 1).show();
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
        consulta_saldo.setSubtitulo(getString(R.string.banco_sub_saldo));
        consulta_saldo.setIcono(R.drawable.ic_consulta_saldo_bfi);
        Integer num = rBXnNc0Kx4.Post;
        consulta_saldo.setType(num);
        consulta_saldo.setOperacion(FdonIAFI9w.BFIConsultarSaldo);
        itemsOperaciones.add(consulta_saldo);
        WUULVgZq02 ult_operaciones = new WUULVgZq02();
        ult_operaciones.setTitulo(getString(R.string.tx_ultimas_operaciones));
        ult_operaciones.setSubtitulo(getString(R.string.tx_sub_ultimas_operaciones_bolsa));
        ult_operaciones.setIcono(R.drawable.ic_consulta_ultimas_oper_bfi);
        ult_operaciones.setType(num);
        ult_operaciones.setOperacion(FdonIAFI9w.BFIUltimasoperaciones);
        itemsOperaciones.add(ult_operaciones);
        WUULVgZq02 consultaLimite = new WUULVgZq02();
        consultaLimite.setTitulo(getString(R.string.title_tx_consulta_limite));
        consultaLimite.setSubtitulo(getString(R.string.banco_sub_consulta_limites));
        consultaLimite.setIcono(R.drawable.ic_consulta_limites_bfi);
        consultaLimite.setType(num);
        consultaLimite.setOperacion(FdonIAFI9w.BFIConsultaLimite);
        itemsOperaciones.add(consultaLimite);
        WUULVgZq02 estadoCuenta = new WUULVgZq02();
        estadoCuenta.setTitulo(getString(R.string.banco_tx_estado_cuentas));
        estadoCuenta.setSubtitulo(getString(R.string.banco_sub_estado_cuentas));
        estadoCuenta.setIcono(R.drawable.ic_estado_cuentas_bfi);
        estadoCuenta.setType(num);
        estadoCuenta.setOperacion(FdonIAFI9w.BFIEstadoCuentas);
        itemsOperaciones.add(estadoCuenta);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc$18, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass18 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BFIConsultarSaldo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultarServicio.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIUltimasoperaciones.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaLimite.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaTodasCuentas.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultarGiroPostal.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFILocalizarTransferencia.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFITipoCambio.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaMulta.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIInformacionTarjeta.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFICombustibleConsultas.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaCredito.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIEstadoCuentas.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaPrelacion.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIObtenerCuentaEstandar.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIConsultaTicket.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTodasCuentas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el importe de todas sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("58");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("58");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogInformacionTarjetaRed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el estado de su tarjeta red? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("78");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("78");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("78");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.5
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("85");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("85");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("85");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogLocalizaTransferencias() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea localizar las transferencias pendientes de sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("73");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("73");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("73");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.9
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = ME2IdEhApc.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Bundle arg = new Bundle();
                if (i == 0) {
                    arg.putSerializable("TipoMultaEntity", ULFE6hmQU6.TipoMulta.Contravension);
                } else {
                    arg.putSerializable("TipoMultaEntity", ULFE6hmQU6.TipoMulta.Transito);
                }
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                ULFE6hmQU6 consultaMultas = new ULFE6hmQU6();
                consultaMultas.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, consultaMultas).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.11
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
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = ME2IdEhApc.this.getActivity().getSupportFragmentManager();
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
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.13
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
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("72");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("72");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("72");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogConsultaTicket() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea ver los créditos pendientes? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                rDEl7rW1aN bs = new rDEl7rW1aN();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("103");
                        return;
                    } else {
                        ((IHVTCBmiLV) ME2IdEhApc.this.getActivity()).actionCallUSSD("103");
                        return;
                    }
                }
                ((S9ycHcoxAzy) ME2IdEhApc.this.getActivity()).actionCallUSSD("103");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.ME2IdEhApc.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
