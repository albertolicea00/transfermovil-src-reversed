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
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.CUlS6AdACy;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.FSH5TTPZXI;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.ILoKZQnPEb;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.LHLbFzX21y;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.RGGlSlGwBS;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.Sh9ycEKe3r;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.U3Fs3ZfEsvU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.aagv9XXigK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.o7atwhPiFj;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.oGGmtSBioS;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.zqBrU3RI5y;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.NzOTegfhDk;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SjZHfPJPwX;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.e45kqwgCv4Ah.h97aDnMCap;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rc7O18ZPOU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.w1lXYiCfJyk;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dLMLrixv4f extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f.1
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = dLMLrixv4f.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new FSH5TTPZXI()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new Sh9ycEKe3r()).addToBackStack(null).commit();
                        break;
                    case 3:
                        mFragmentTransaction.replace(R.id.containerView, new CUlS6AdACy()).addToBackStack(null).commit();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new LHLbFzX21y()).addToBackStack(null).commit();
                        break;
                    case 5:
                        dLMLrixv4f.this.showDialogFormadePagoONATRCNIT();
                        break;
                    case 6:
                        Bundle argR = new Bundle();
                        argR.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        SjZHfPJPwX recargaMovilCuentasFragment = new SjZHfPJPwX();
                        recargaMovilCuentasFragment.setArguments(argR);
                        mFragmentTransaction.replace(R.id.containerView, recargaMovilCuentasFragment).addToBackStack(null).commit();
                        break;
                    case 7:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                        Bundle arg = new Bundle();
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        r7Rinp9ooL pagoFragment = new r7Rinp9ooL();
                        pagoFragment.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                        break;
                    case 8:
                        Bundle arg2 = new Bundle();
                        arg2.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        PqTzgaEYF6 recargaNautaBanco = new PqTzgaEYF6();
                        recargaNautaBanco.setArguments(arg2);
                        mFragmentTransaction.replace(R.id.containerView, recargaNautaBanco).addToBackStack(null).commit();
                        break;
                    case 9:
                        mFragmentTransaction.replace(R.id.containerView, new RGGlSlGwBS()).addToBackStack(null).commit();
                        break;
                    case 10:
                        mFragmentTransaction.replace(R.id.containerView, new U3Fs3ZfEsvU()).addToBackStack(null).commit();
                        break;
                    case 11:
                        Bundle arg3 = new Bundle();
                        arg3.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        hqPCcU1E8u recargaPropiaBanco = new hqPCcU1E8u();
                        recargaPropiaBanco.setArguments(arg3);
                        mFragmentTransaction.replace(R.id.containerView, recargaPropiaBanco).addToBackStack(null).commit();
                        break;
                    case 12:
                        Bundle arg4 = new Bundle();
                        arg4.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        w1lXYiCfJyk recargaJovenClubBanco = new w1lXYiCfJyk();
                        recargaJovenClubBanco.setArguments(arg4);
                        mFragmentTransaction.replace(R.id.containerView, recargaJovenClubBanco).addToBackStack(null).commit();
                        break;
                    case 13:
                        mFragmentTransaction.replace(R.id.containerView, new o7atwhPiFj()).addToBackStack(null).commit();
                        break;
                    case 14:
                        mFragmentTransaction.replace(R.id.containerView, new aagv9XXigK()).addToBackStack(null).commit();
                        break;
                    case 15:
                        Bundle arg5 = new Bundle();
                        arg5.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        NzOTegfhDk multa = new NzOTegfhDk();
                        multa.setArguments(arg5);
                        mFragmentTransaction.replace(R.id.containerView, multa).addToBackStack(null).commit();
                        break;
                    case 16:
                        Bundle arg6 = new Bundle();
                        arg6.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        rc7O18ZPOU multa2 = new rc7O18ZPOU();
                        multa2.setArguments(arg6);
                        mFragmentTransaction.replace(R.id.containerView, multa2).addToBackStack(null).commit();
                        break;
                    case 17:
                        Bundle arg7 = new Bundle();
                        arg7.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        h97aDnMCap combustible = new h97aDnMCap();
                        combustible.setArguments(arg7);
                        mFragmentTransaction.replace(R.id.containerView, combustible).addToBackStack(null).commit();
                        break;
                    case 18:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                        Bundle arg8 = new Bundle();
                        arg8.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CajaExtra);
                        arg8.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        xpc0ejPtmZ cajaExtraCuentasBanco = new xpc0ejPtmZ();
                        cajaExtraCuentasBanco.setArguments(arg8);
                        mFragmentTransaction.replace(R.id.containerView, cajaExtraCuentasBanco).addToBackStack(null).commit();
                        break;
                    case 19:
                        mFragmentTransaction.replace(R.id.containerView, new oGGmtSBioS()).addToBackStack(null).commit();
                        break;
                    case 20:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                        Bundle arg9 = new Bundle();
                        arg9.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        uKzekWA2jf recargaWalletCUPFragment = new uKzekWA2jf();
                        recargaWalletCUPFragment.setArguments(arg9);
                        mFragmentTransaction.replace(R.id.containerView, recargaWalletCUPFragment).addToBackStack(null).commit();
                        break;
                    case 21:
                        mFragmentTransaction.replace(R.id.containerView, new ILoKZQnPEb()).addToBackStack(null).commit();
                        break;
                    case 22:
                        mFragmentTransaction.replace(R.id.containerView, new zqBrU3RI5y()).addToBackStack(null).commit();
                        break;
                    case 23:
                        Bundle arg10 = new Bundle();
                        arg10.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.PCC);
                        arg10.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        PTsHXOZ1gC pagoPartidoBanco = new PTsHXOZ1gC();
                        pagoPartidoBanco.setArguments(arg10);
                        mFragmentTransaction.replace(R.id.containerView, pagoPartidoBanco).addToBackStack(null).commit();
                        break;
                    case 24:
                        Bundle arg11 = new Bundle();
                        arg11.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CompraPaquetesCubacel);
                        arg11.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        n6dAtto0KFy paqCubacel = new n6dAtto0KFy();
                        paqCubacel.setArguments(arg11);
                        mFragmentTransaction.replace(R.id.containerView, paqCubacel).addToBackStack(null).commit();
                        break;
                    case 25:
                        Bundle arg12 = new Bundle();
                        arg12.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ReservasTicket);
                        arg12.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                        L0JjVr9EwEF ticket = new L0JjVr9EwEF();
                        ticket.setArguments(arg12);
                        mFragmentTransaction.replace(R.id.containerView, ticket).addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(dLMLrixv4f.this.context, operacion.toString(), 1).show();
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
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo("Transferir Efectivo");
        transferencia.setSubtitulo(getString(R.string.banco_sub_transferencia));
        transferencia.setIcono(R.drawable.banco_bfi_transferir);
        Integer num = rBXnNc0Kx4.Post;
        transferencia.setType(num);
        transferencia.setOperacion(FdonIAFI9w.BFITransferirEfectivo);
        itemsOperaciones.add(transferencia);
        WUULVgZq02 telefono = new WUULVgZq02();
        telefono.setTitulo(getString(R.string.banco_telefono));
        telefono.setSubtitulo(getString(R.string.banco_sub_telefono));
        telefono.setIcono(R.drawable.banco_bfi_telefono);
        telefono.setType(num);
        telefono.setOperacion(FdonIAFI9w.BFITelefono);
        itemsOperaciones.add(telefono);
        WUULVgZq02 electricidad = new WUULVgZq02();
        electricidad.setTitulo(getString(R.string.banco_electricidad));
        electricidad.setSubtitulo(getString(R.string.banco_sub_electricidad));
        electricidad.setIcono(R.drawable.banco_bfi_electricidad);
        electricidad.setType(num);
        electricidad.setOperacion(FdonIAFI9w.BFIElectricidad);
        itemsOperaciones.add(electricidad);
        WUULVgZq02 agua = new WUULVgZq02();
        agua.setTitulo(getString(R.string.title_service_bpa_agua));
        agua.setSubtitulo(getString(R.string.sub_service_bpa_agua));
        agua.setIcono(R.drawable.banco_bfi_agua);
        agua.setType(num);
        agua.setOperacion(FdonIAFI9w.BFIAgua);
        itemsOperaciones.add(agua);
        WUULVgZq02 gas = new WUULVgZq02();
        gas.setTitulo(getString(R.string.title_service_metro_gas));
        gas.setSubtitulo(getString(R.string.sub_service_metro_gas));
        gas.setIcono(R.drawable.banco_bfi_gas);
        gas.setType(num);
        gas.setOperacion(FdonIAFI9w.BFIGas);
        itemsOperaciones.add(gas);
        WUULVgZq02 onat = new WUULVgZq02();
        onat.setTitulo("Impuestos");
        onat.setSubtitulo("Pagar Impuestos");
        onat.setIcono(R.drawable.banco_metro_onat);
        onat.setType(num);
        onat.setOperacion(FdonIAFI9w.BFIImpuestos);
        itemsOperaciones.add(onat);
        WUULVgZq02 recargarMovil = new WUULVgZq02();
        recargarMovil.setTitulo("Recarga Saldo Móvil");
        recargarMovil.setSubtitulo("Recargar saldo del móvil con cuenta bancaria");
        recargarMovil.setIcono(R.drawable.banco_bfi_recarga_saldo_movil);
        recargarMovil.setType(num);
        recargarMovil.setOperacion(FdonIAFI9w.BFIRecargaMovil);
        itemsOperaciones.add(recargarMovil);
        WUULVgZq02 recargaNauta = new WUULVgZq02();
        recargaNauta.setTitulo(getString(R.string.title_recarga_nauta));
        recargaNauta.setSubtitulo(getString(R.string.sub_recarga_nauta));
        recargaNauta.setIcono(R.drawable.banco_metro_nauta);
        recargaNauta.setType(num);
        recargaNauta.setOperacion(FdonIAFI9w.BFIRecargaNauta);
        itemsOperaciones.add(recargaNauta);
        WUULVgZq02 giroPostal = new WUULVgZq02();
        giroPostal.setTitulo(getString(R.string.title_giro_postal));
        giroPostal.setSubtitulo(getString(R.string.sub_giro_postal));
        giroPostal.setIcono(R.drawable.banco_metro_giro);
        giroPostal.setType(num);
        giroPostal.setOperacion(FdonIAFI9w.BFIGiroPostal);
        itemsOperaciones.add(giroPostal);
        WUULVgZq02 pagoExternoUCI = new WUULVgZq02();
        pagoExternoUCI.setTitulo(getString(R.string.title_pago_externo));
        pagoExternoUCI.setSubtitulo(getString(R.string.sub_pago_externo));
        pagoExternoUCI.setIcono(R.drawable.banco_metro_compra);
        pagoExternoUCI.setType(num);
        pagoExternoUCI.setOperacion(FdonIAFI9w.BFIPagoExterno);
        itemsOperaciones.add(pagoExternoUCI);
        WUULVgZq02 recargaPropia = new WUULVgZq02();
        recargaPropia.setTitulo(getString(R.string.hint_recarga_propia));
        recargaPropia.setSubtitulo(getString(R.string.hint_subtitle_recarga_propia));
        recargaPropia.setIcono(R.drawable.banco_bfi_recarga_propia);
        recargaPropia.setType(num);
        recargaPropia.setOperacion(FdonIAFI9w.BFIRecargaPropia);
        itemsOperaciones.add(recargaPropia);
        WUULVgZq02 recargaJClub = new WUULVgZq02();
        recargaJClub.setTitulo(getString(R.string.title_jclub));
        recargaJClub.setSubtitulo(getString(R.string.sub_jclub));
        recargaJClub.setIcono(R.drawable.banco_metro_jclub);
        recargaJClub.setType(num);
        recargaJClub.setOperacion(FdonIAFI9w.BFIJClub);
        itemsOperaciones.add(recargaJClub);
        WUULVgZq02 multaContra = new WUULVgZq02();
        multaContra.setTitulo(getString(R.string.tx_title_contravencion));
        multaContra.setSubtitulo(getString(R.string.tx_subtitle_contravencion));
        multaContra.setIcono(R.drawable.banco_metro_multa_contravencion);
        multaContra.setType(num);
        multaContra.setOperacion(FdonIAFI9w.BFIMultaContravension);
        itemsOperaciones.add(multaContra);
        WUULVgZq02 multaTransito = new WUULVgZq02();
        multaTransito.setTitulo(getString(R.string.tx_title_transito));
        multaTransito.setSubtitulo(getString(R.string.tx_subtitle_transtito));
        multaTransito.setIcono(R.drawable.banco_metro_multa_transito);
        multaTransito.setType(num);
        multaTransito.setOperacion(FdonIAFI9w.BFIMultaTransito);
        itemsOperaciones.add(multaTransito);
        WUULVgZq02 combustible = new WUULVgZq02();
        combustible.setTitulo(getString(R.string.tx_title_compra_cupon_combustible));
        combustible.setSubtitulo(getString(R.string.tx_subtitle_compra_cupon_combustible));
        combustible.setIcono(R.drawable.banco_metro_pago_cupon_combustible);
        combustible.setType(num);
        combustible.setOperacion(FdonIAFI9w.BFICombustibleCompra);
        itemsOperaciones.add(combustible);
        WUULVgZq02 bolsa = new WUULVgZq02();
        bolsa.setTitulo(getString(R.string.title_recarga_bolsa_cup));
        bolsa.setSubtitulo(getString(R.string.subtitle_recarga_bolsa_cup));
        bolsa.setIcono(R.drawable.banco_bfi_recarga_wallet);
        bolsa.setType(num);
        bolsa.setOperacion(FdonIAFI9w.BFIRecargaBolsa);
        itemsOperaciones.add(bolsa);
        WUULVgZq02 ofa = new WUULVgZq02();
        ofa.setTitulo(getString(R.string.tx_head_patrimonio));
        ofa.setSubtitulo(getString(R.string.tx_sub_patrimonio));
        ofa.setIcono(R.drawable.metro_pago_ofa_arr_v5);
        ofa.setType(num);
        ofa.setOperacion(FdonIAFI9w.BFIPatrimoniOfa);
        itemsOperaciones.add(ofa);
        WUULVgZq02 pcc = new WUULVgZq02();
        pcc.setTitulo(getString(R.string.title_organizacion_politica));
        pcc.setSubtitulo(getString(R.string.subtitle_pcc));
        pcc.setIcono(R.drawable.banco_bfi_pcc);
        pcc.setType(num);
        pcc.setOperacion(FdonIAFI9w.BFIPCC);
        itemsOperaciones.add(pcc);
        WUULVgZq02 paqCubacel = new WUULVgZq02();
        paqCubacel.setTitulo(getString(R.string.head_paquetes_cubacel));
        paqCubacel.setSubtitulo(getString(R.string.sub_compra_paquetes));
        paqCubacel.setIcono(R.drawable.banco_bfi_compra_paquetes);
        paqCubacel.setType(num);
        paqCubacel.setOperacion(FdonIAFI9w.BFIPaquetesCubacel);
        itemsOperaciones.add(paqCubacel);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BFITransferirEfectivo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFITelefono.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIElectricidad.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIAgua.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIImpuestos.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIRecargaMovil.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPagoExterno.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIRecargaNauta.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIGiroPostal.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIGas.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIRecargaPropia.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIJClub.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPlazoFijo.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFICierrePlazoFijo.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIMultaContravension.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIMultaTransito.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFICombustibleCompra.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFICajaExtra.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPagoCredito.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIRecargaBolsa.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPatrimoniOfa.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFICambioMensualidad.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPCC.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIPaquetesCubacel.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BFIReservasTicket.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogFormadePagoONATRCNIT() {
        CharSequence[] items = {this.context.getString(R.string.tx_onat_nit_rc04), this.context.getString(R.string.tx_onat_nit_ci), this.context.getString(R.string.tx_sello_timbre)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la forma de pago (solo para personas naturales)");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = dLMLrixv4f.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                ROgpLrCtHa onat = new ROgpLrCtHa();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                switch (i) {
                    case 0:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoRC05);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoNIT);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 2:
                        TGMSi5UDp7 sellosPostalesBanco = new TGMSi5UDp7();
                        sellosPostalesBanco.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, sellosPostalesBanco).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogOFA() {
        CharSequence[] items = {this.context.getString(R.string.tx_ofa_visitas), this.context.getString(R.string.tx_ofa_contribuciones), this.context.getString(R.string.tx_ofa_aportes)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = dLMLrixv4f.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                ROgpLrCtHa onat = new ROgpLrCtHa();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BFI);
                switch (i) {
                    case 0:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoRC05);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoNIT);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 2:
                        TGMSi5UDp7 sellosPostalesBanco = new TGMSi5UDp7();
                        sellosPostalesBanco.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, sellosPostalesBanco).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.SXVyD7BX7KJ.dLMLrixv4f.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
