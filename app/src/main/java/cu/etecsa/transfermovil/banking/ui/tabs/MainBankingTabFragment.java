package cu.etecsa.transfermovil.banking.ui.tabs;

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
import cu.etecsa.transfermovil.banking.ui.bfi.BfiExternalPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.OfaContributionFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletBankTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.NautaPlusRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.OwnCardPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.NautaUserFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationCancelFragment;
import cu.etecsa.transfermovil.ui.fragment.MiBoletoPurchaseFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletWaterPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationDateChangeFragment;
import cu.etecsa.transfermovil.ui.fragment.CubacelPackagePurchaseFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletGasPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.TicketReservationCreateFragment;
import cu.etecsa.transfermovil.ui.fragment.BfiTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.TfaRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.MobileVotingFragment;
import cu.etecsa.transfermovil.ui.fragment.OfaReservationFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletElectricityPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletExtraPackageFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletWithdrawFragment;
import cu.etecsa.transfermovil.banking.ui.wallet.WalletClassicTransferFragment;
import cu.etecsa.transfermovil.ui.fragment.FixedPhoneBillPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.FwaDataPackagePurchaseFragment;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD;
import cu.etecsa.transfermovil.ui.fragment.FwaBalanceRechargeFragment;
import cu.etecsa.transfermovil.ui.fragment.CreditPaymentFragment;
import cu.etecsa.transfermovil.ui.fragment.WalletTopupFragment;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.WUULVgZq02;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.XPH60zChinL.rBXnNc0Kx4;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Provincia;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.SucursalCadeca;
import cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.As6QBoLoQJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.DHfGEge8yT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.RiZsr8xXRC;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import java.util.ArrayList;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.rR6oImkdEU
 * @original_apk_version 1.260416
 */
public class MainBankingTabFragment extends Fragment {
    public Context context;
    public vD9rc3MbTL.OnItemClickListener onItemClickListener = new vD9rc3MbTL.OnItemClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.2
        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onItemClick(View view, int position) {
        }

        @Override // cu.etecsa.cubacel.tr.tm.B21UyndcVvF.vD9rc3MbTL.OnItemClickListener
        public void onGetItemClick(View view, FdonIAFI9w operacion) {
            FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            if (operacion != null) {
                switch (AnonymousClass17.$SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[operacion.ordinal()]) {
                    case 1:
                        MainBankingTabFragment.this.showDialogTransferencia();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new FixedPhoneBillPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 3:
                        Bundle arg = new Bundle();
                        arg.putSerializable("TipoBolsa", qTDVwLFEjE.CUP);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        WalletTopupFragment recargaMovilFragment = new WalletTopupFragment();
                        recargaMovilFragment.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, recargaMovilFragment).addToBackStack(null).commit();
                        break;
                    case 4:
                        mFragmentTransaction.replace(R.id.containerView, new NautaUserFragment()).addToBackStack(null).commit();
                        break;
                    case 5:
                        mFragmentTransaction.replace(R.id.containerView, new OwnCardPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 6:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                        Bundle arg2 = new Bundle();
                        arg2.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        arg2.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                        s9CT6pjRyD pagoFragment = new s9CT6pjRyD();
                        pagoFragment.setArguments(arg2);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                        break;
                    case 7:
                        mFragmentTransaction.replace(R.id.containerView, new WalletExtraPackageFragment()).addToBackStack(null).commit();
                        break;
                    case 8:
                        MainBankingTabFragment.this.showDialogNautaPlus();
                        break;
                    case 9:
                        MainBankingTabFragment.this.showDialog4G();
                        break;
                    case 10:
                        mFragmentTransaction.replace(R.id.containerView, new FwaDataPackagePurchaseFragment()).addToBackStack(null).commit();
                        break;
                    case 11:
                        mFragmentTransaction.replace(R.id.containerView, new WalletRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case 12:
                        mFragmentTransaction.replace(R.id.containerView, new WalletWithdrawFragment()).addToBackStack(null).commit();
                        break;
                    case 13:
                        mFragmentTransaction.replace(R.id.containerView, new WalletBankTransferFragment()).addToBackStack(null).commit();
                        break;
                    case 14:
                        mFragmentTransaction.replace(R.id.containerView, new WalletElectricityPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 15:
                        mFragmentTransaction.replace(R.id.containerView, new WalletWaterPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 16:
                        mFragmentTransaction.replace(R.id.containerView, new WalletGasPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 17:
                        mFragmentTransaction.replace(R.id.containerView, new CubacelPackagePurchaseFragment()).addToBackStack(null).commit();
                        break;
                    case 18:
                        mFragmentTransaction.replace(R.id.containerView, new CreditPaymentFragment()).addToBackStack(null).commit();
                        break;
                    case 19:
                        mFragmentTransaction.replace(R.id.containerView, new OfaReservationFragment()).addToBackStack(null).commit();
                        break;
                    case 20:
                        mFragmentTransaction.replace(R.id.containerView, new OfaContributionFragment()).addToBackStack(null).commit();
                        break;
                    case 21:
                        U6ucOCBccJ.pmoneda = 0;
                        U6ucOCBccJ.pEntidad = BuildConfig.FLAVOR;
                        U6ucOCBccJ.pProvincia = new Provincia();
                        U6ucOCBccJ.pSucursal = BuildConfig.FLAVOR;
                        U6ucOCBccJ.pSucursalCadeca = new SucursalCadeca();
                        U6ucOCBccJ.ptipoServicio = 0;
                        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                        U6ucOCBccJ.pIsEnviar = false;
                        U6ucOCBccJ.pTextoSpMisCuentas = BuildConfig.FLAVOR;
                        U6ucOCBccJ.pcuenta = BuildConfig.FLAVOR;
                        MainBankingTabFragment.this.showDialogReservasTicket();
                        break;
                    case 22:
                        mFragmentTransaction.replace(R.id.containerView, new TfaRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case 23:
                        MainBankingTabFragment.this.showDialogTransferenciaEmpresarial();
                        break;
                    case 24:
                        MainBankingTabFragment.this.showDialogPagoExternoEmpresarial();
                        break;
                    case 25:
                        As6QBoLoQJ.ci = BuildConfig.FLAVOR;
                        As6QBoLoQJ.fecha = BuildConfig.FLAVOR;
                        As6QBoLoQJ.fechaInicio = BuildConfig.FLAVOR;
                        As6QBoLoQJ.cantidad = BuildConfig.FLAVOR;
                        As6QBoLoQJ.monto = BuildConfig.FLAVOR;
                        As6QBoLoQJ.phone = BuildConfig.FLAVOR;
                        As6QBoLoQJ.moneda = BuildConfig.FLAVOR;
                        mFragmentTransaction.replace(R.id.containerView, new MiBoletoPurchaseFragment()).addToBackStack(null).commit();
                        break;
                    case 26:
                        mFragmentTransaction.replace(R.id.containerView, new MobileVotingFragment()).addToBackStack(null).commit();
                        break;
                    default:
                        Toast.makeText(MainBankingTabFragment.this.context, operacion.toString(), 1).show();
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
        new DHfGEge8yT(getActivity().getContentResolver(), new SYLBHJttme() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.1
            @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
            public void onSetProgressBarVisibility(int visibility) {
            }

            @Override // cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.SYLBHJttme
            public void onOfertasResult(boolean success, int count, String message) {
            }
        }).execute(new Void[0]);
        return this.rootView;
    }

    private void initData() {
        List<WUULVgZq02> itemsOperaciones = new ArrayList<>();
        WUULVgZq02 transferencia = new WUULVgZq02();
        transferencia.setTitulo(getString(R.string.menu_title_transferencia_bolsa));
        transferencia.setSubtitulo(getString(R.string.menu_sub_transferencia_bolsa));
        transferencia.setIcono(R.drawable.ic_transferencia_bolsa);
        Integer num = rBXnNc0Kx4.Post;
        transferencia.setType(num);
        transferencia.setOperacion(FdonIAFI9w.BOLSATransferencia);
        itemsOperaciones.add(transferencia);
        WUULVgZq02 telefono = new WUULVgZq02();
        telefono.setTitulo(getString(R.string.banco_telefono));
        telefono.setSubtitulo(getString(R.string.banco_sub_telefono));
        telefono.setIcono(R.drawable.ic_pago_factura_telefono_fijo_bolsa);
        telefono.setType(num);
        telefono.setOperacion(FdonIAFI9w.BOLSATelefono);
        itemsOperaciones.add(telefono);
        WUULVgZq02 recargarMovil = new WUULVgZq02();
        recargarMovil.setTitulo(getString(R.string.menu_title_recarga_movil_bolsa));
        recargarMovil.setSubtitulo(getString(R.string.menu_sub_recarga_movil_bolsa));
        recargarMovil.setIcono(R.drawable.ic_recarga_saldo_movil_bolsa);
        recargarMovil.setType(num);
        recargarMovil.setOperacion(FdonIAFI9w.BOLSARecargaMovil);
        itemsOperaciones.add(recargarMovil);
        WUULVgZq02 recargaNauta = new WUULVgZq02();
        recargaNauta.setTitulo(getString(R.string.title_recarga_nauta));
        recargaNauta.setSubtitulo(getString(R.string.sub_recarga_nauta));
        recargaNauta.setIcono(R.drawable.ic_pago_nauta_hogar_bolsa);
        recargaNauta.setType(num);
        recargaNauta.setOperacion(FdonIAFI9w.BOLSARecargaNauta);
        itemsOperaciones.add(recargaNauta);
        WUULVgZq02 recargaPropia = new WUULVgZq02();
        recargaPropia.setTitulo(getString(R.string.hint_recarga_propia));
        recargaPropia.setSubtitulo(getString(R.string.hint_subtitle_recarga_propia));
        recargaPropia.setIcono(R.drawable.ic_recarga_tarjeta_propia_bolsa);
        recargaPropia.setType(num);
        recargaPropia.setOperacion(FdonIAFI9w.BOLSARecargaPropia);
        itemsOperaciones.add(recargaPropia);
        WUULVgZq02 pagoExternoUCI = new WUULVgZq02();
        pagoExternoUCI.setTitulo(getString(R.string.title_pago_externo));
        pagoExternoUCI.setSubtitulo(getString(R.string.sub_pago_externo));
        pagoExternoUCI.setIcono(R.drawable.ic_pago_linea_bolsa);
        pagoExternoUCI.setType(num);
        pagoExternoUCI.setOperacion(FdonIAFI9w.BOLSAPagoLinea);
        itemsOperaciones.add(pagoExternoUCI);
        WUULVgZq02 compraPaquete = new WUULVgZq02();
        compraPaquete.setTitulo(getString(R.string.menu_title_compra_paquete_mlc_bolsa));
        compraPaquete.setSubtitulo(getString(R.string.menu_sub_compra_paquete_mlc_bolsa));
        compraPaquete.setIcono(R.drawable.ic_paquetes_combinados_bolsa);
        compraPaquete.setType(num);
        compraPaquete.setOperacion(FdonIAFI9w.BOLSACompraPaqueteMLC);
        itemsOperaciones.add(compraPaquete);
        WUULVgZq02 nautaPlus = new WUULVgZq02();
        nautaPlus.setTitulo(getString(R.string.menu_title_compra_nauta_plus_bolsa));
        nautaPlus.setSubtitulo(getString(R.string.menu_sub_compra_nauta_plus_bolsa));
        nautaPlus.setIcono(R.drawable.ic_pago_nauta_plus_bolsa);
        nautaPlus.setType(num);
        nautaPlus.setOperacion(FdonIAFI9w.BOLSARecargaNautaMLC);
        itemsOperaciones.add(nautaPlus);
        WUULVgZq02 recargaCUPTicket = new WUULVgZq02();
        recargaCUPTicket.setTitulo(getString(R.string.menu_tite_recarga_cup_ticket));
        recargaCUPTicket.setSubtitulo(getString(R.string.menu_sub_recarga_cup_ticket));
        recargaCUPTicket.setIcono(R.drawable.ic_recargar_monedero_cup_bolsa);
        recargaCUPTicket.setType(num);
        recargaCUPTicket.setOperacion(FdonIAFI9w.BOLSARecargaCUPWalletTicket);
        itemsOperaciones.add(recargaCUPTicket);
        WUULVgZq02 extraccionTicket = new WUULVgZq02();
        extraccionTicket.setTitulo(getString(R.string.menu_tite_extraccion_efectivo_ticket));
        extraccionTicket.setSubtitulo(getString(R.string.menu_sub_extraccion_efectivo_ticket));
        extraccionTicket.setIcono(R.drawable.ic_extraer_efectivo_bolsa);
        extraccionTicket.setType(num);
        extraccionTicket.setOperacion(FdonIAFI9w.BOLSAExtraccionWalletTicket);
        itemsOperaciones.add(extraccionTicket);
        WUULVgZq02 transferirBancos = new WUULVgZq02();
        transferirBancos.setTitulo(getString(R.string.menu_tite_transferir_bolsa_bancos));
        transferirBancos.setSubtitulo(getString(R.string.menu_sub_transferir_bolsa_bancos));
        transferirBancos.setIcono(R.drawable.ic_transferir_cuentas_banco_bolsa);
        transferirBancos.setType(num);
        transferirBancos.setOperacion(FdonIAFI9w.BOLSATransferirBancos);
        itemsOperaciones.add(transferirBancos);
        WUULVgZq02 electricidad = new WUULVgZq02();
        electricidad.setTitulo(getString(R.string.banco_electricidad));
        electricidad.setSubtitulo(getString(R.string.banco_sub_electricidad));
        electricidad.setIcono(R.drawable.ic_pago_factura_electricidad_bolsa);
        electricidad.setType(num);
        electricidad.setOperacion(FdonIAFI9w.BOLSAElectricidad);
        itemsOperaciones.add(electricidad);
        WUULVgZq02 agua = new WUULVgZq02();
        agua.setTitulo(getString(R.string.title_pago_agua_hab));
        agua.setSubtitulo(getString(R.string.sub_service_bpa_agua));
        agua.setIcono(R.drawable.ic_pago_factura_agua_bolsa);
        agua.setType(num);
        agua.setOperacion(FdonIAFI9w.BOLSAAgua);
        itemsOperaciones.add(agua);
        WUULVgZq02 gas = new WUULVgZq02();
        gas.setTitulo(getString(R.string.title_service_metro_gas));
        gas.setSubtitulo(getString(R.string.sub_service_metro_gas));
        gas.setIcono(R.drawable.ic_pago_factura_gas_bolsa);
        gas.setType(num);
        gas.setOperacion(FdonIAFI9w.BOLSAgas);
        itemsOperaciones.add(gas);
        WUULVgZq02 paq_cubacel = new WUULVgZq02();
        paq_cubacel.setTitulo(getString(R.string.head_paquetes_cubacel));
        paq_cubacel.setSubtitulo(getString(R.string.sub_compra_paquetes));
        paq_cubacel.setIcono(R.drawable.ic_compra_paquetes_bolsa);
        paq_cubacel.setType(num);
        paq_cubacel.setOperacion(FdonIAFI9w.BOLSAPaquetesCubacel);
        itemsOperaciones.add(paq_cubacel);
        WUULVgZq02 pcc = new WUULVgZq02();
        pcc.setTitulo(getString(R.string.title_organizacion_politica));
        pcc.setSubtitulo(getString(R.string.subtitle_pcc));
        pcc.setIcono(R.drawable.ic_pago_organizaciones_masa_bolsa);
        pcc.setType(num);
        pcc.setOperacion(FdonIAFI9w.BOLSAPCC);
        itemsOperaciones.add(pcc);
        WUULVgZq02 reservasOfa = new WUULVgZq02();
        reservasOfa.setTitulo(getString(R.string.title_reservas_ofa));
        reservasOfa.setSubtitulo(getString(R.string.tx_sub_patrimonio_bolsa));
        reservasOfa.setIcono(R.drawable.ic_reserva_ofa_bolsa);
        reservasOfa.setType(num);
        reservasOfa.setOperacion(FdonIAFI9w.BOLSAReservasOFA);
        itemsOperaciones.add(reservasOfa);
        WUULVgZq02 compra_miboleto = new WUULVgZq02();
        compra_miboleto.setTitulo(getString(R.string.title_compra_miboleto));
        compra_miboleto.setSubtitulo(getString(R.string.subtitle_compra_miboleto));
        compra_miboleto.setIcono(R.drawable.ic_miboleto_pago_bolsa);
        compra_miboleto.setType(num);
        compra_miboleto.setOperacion(FdonIAFI9w.BOLSACompraMiBoleto);
        itemsOperaciones.add(compra_miboleto);
        WUULVgZq02 ticket = new WUULVgZq02();
        ticket.setTitulo(getString(R.string.title_reserva_ticket));
        ticket.setSubtitulo(getString(R.string.subtitle_reserva_ticket));
        ticket.setIcono(R.drawable.ic_pago_miturno_bolsa);
        ticket.setType(num);
        ticket.setOperacion(FdonIAFI9w.BOLSAReservasTicket);
        itemsOperaciones.add(ticket);
        WUULVgZq02 tfa = new WUULVgZq02();
        tfa.setTitulo(getString(R.string.title_recarga_tfa));
        tfa.setSubtitulo(getString(R.string.subtitle_recarga_tfa));
        tfa.setIcono(R.drawable.ic_tfa_bolsa);
        tfa.setType(num);
        tfa.setOperacion(FdonIAFI9w.BOLSARecargaTFA);
        itemsOperaciones.add(tfa);
        WUULVgZq02 ofa = new WUULVgZq02();
        ofa.setTitulo(getString(R.string.tx_head_patrimonio2));
        ofa.setSubtitulo(getString(R.string.tx_sub_patrimonio));
        ofa.setIcono(R.drawable.ic_ofa_bolsa);
        ofa.setType(num);
        ofa.setOperacion(FdonIAFI9w.BOLSAAporteOFA);
        itemsOperaciones.add(ofa);
        WUULVgZq02 votomovilbolsa = new WUULVgZq02();
        votomovilbolsa.setTitulo(getString(R.string.msg_votomovil_etecsa));
        votomovilbolsa.setSubtitulo(getString(R.string.msg_votomovil_descrip_etecsa));
        votomovilbolsa.setIcono(R.drawable.ic_voto_movil);
        votomovilbolsa.setType(num);
        votomovilbolsa.setOperacion(FdonIAFI9w.BOLSAVotoMovil);
        itemsOperaciones.add(votomovilbolsa);
        WUULVgZq02 transfer_clasica = new WUULVgZq02();
        transfer_clasica.setTitulo(getString(R.string.tx_transferencia_clasica_empresa));
        transfer_clasica.setSubtitulo(getString(R.string.ly_title_transferencia_a_clasica_empresa));
        transfer_clasica.setIcono(R.drawable.ico_transfer_clasica);
        transfer_clasica.setType(num);
        transfer_clasica.setOperacion(FdonIAFI9w.BOLSATransferenciaClasicaEmpresarial);
        itemsOperaciones.add(transfer_clasica);
        WUULVgZq02 pagoExternoEmpresa = new WUULVgZq02();
        pagoExternoEmpresa.setTitulo(getString(R.string.title_pago_externo_empresarial));
        pagoExternoEmpresa.setSubtitulo(getString(R.string.sub_pago_externo_empresarial));
        pagoExternoEmpresa.setIcono(R.drawable.ic_pago_linea_empresarial);
        pagoExternoEmpresa.setType(num);
        pagoExternoEmpresa.setOperacion(FdonIAFI9w.BOLSAPagoExternoClasicaEmpresarial);
        itemsOperaciones.add(pagoExternoEmpresa);
        vD9rc3MbTL adapterSeguridad = new vD9rc3MbTL(this.context, itemsOperaciones);
        this.rvseguridad.setAdapter(adapterSeguridad);
        adapterSeguridad.setOnItemClickListener(this.onItemClickListener);
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment$17, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass17 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w;

        static {
            int[] iArr = new int[FdonIAFI9w.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w = iArr;
            try {
                iArr[FdonIAFI9w.BOLSATransferencia.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSATelefono.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaMovil.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaNauta.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaPropia.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAPagoLinea.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSACompraPaqueteMLC.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaNautaMLC.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaFWA.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSACompraPaqueteFWA.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaCUPWalletTicket.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAExtraccionWalletTicket.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSATransferirBancos.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAElectricidad.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAgua.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAgas.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAPaquetesCubacel.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAPCC.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAReservasOFA.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAAporteOFA.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAReservasTicket.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSARecargaTFA.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSATransferenciaClasicaEmpresarial.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAPagoExternoClasicaEmpresarial.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSACompraMiBoleto.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$ZNRpoHwtLXM$FdonIAFI9w[FdonIAFI9w.BOLSAVotoMovil.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
        }
    }

    private void showDialogRecargaMovil() {
        CharSequence[] items = {this.context.getString(R.string.tx_wallet_recarga_cup), this.context.getString(R.string.tx_wallet_recarga_usd)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                WalletTopupFragment recargaMovilBolsa = new WalletTopupFragment();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        arg.putSerializable("TipoBolsa", qTDVwLFEjE.CUP);
                        break;
                    case 1:
                        arg.putSerializable("TipoBolsa", qTDVwLFEjE.USD);
                        break;
                }
                recargaMovilBolsa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargaMovilBolsa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogReservasTicket() {
        CharSequence[] items = {this.context.getString(R.string.opcion_reserva_ticket), this.context.getString(R.string.opcion_eliminar_reserva_ticket), this.context.getString(R.string.opcion_cambiar_fecha_ticket)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new TicketReservationCreateFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new TicketReservationCancelFragment()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new TicketReservationDateChangeFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog4G() {
        CharSequence[] items = {this.context.getString(R.string.tx_opcion_fwa_recarga), this.context.getString(R.string.tx_opcion_fwa_consulta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new FwaBalanceRechargeFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new FwaDataPackagePurchaseFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNautaPlus() {
        CharSequence[] items = {this.context.getString(R.string.tx_wallet_nauta_plus_sin_cuenta), this.context.getString(R.string.tx_wallet_nauta_plus_con_cuenta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.tx_modal_head_nauta_plus_bolsa));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                NautaPlusRechargeFragment recargaNautaPlusBolsa = new NautaPlusRechargeFragment();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        arg.putSerializable("OpcionNautaPlus", RiZsr8xXRC.SIN_CUENTA);
                        break;
                    case 1:
                        arg.putSerializable("OpcionNautaPlus", RiZsr8xXRC.CON_CUENTA);
                        break;
                }
                recargaNautaPlusBolsa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargaNautaPlusBolsa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTransferencia() {
        CharSequence[] items = {this.context.getString(R.string.menu_title_transferencia_mi_transfer), this.context.getString(R.string.tx_transferencia_clasica)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle(this.context.getString(R.string.hint_seleccione_cuenta));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new WalletTransferFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new WalletClassicTransferFragment()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogPagoExternoEmpresarial() {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                BfiExternalPaymentFragment pagoExternoEmpresa = new BfiExternalPaymentFragment();
                arg.putSerializable("PayType", Integer.valueOf(i));
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICAEMP);
                pagoExternoEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoExternoEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTransferenciaEmpresarial() {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = MainBankingTabFragment.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                BfiTransferFragment transferenciaBolsaClasicaEmpresarialEmpresa = new BfiTransferFragment();
                arg.putSerializable("TransferType", Integer.valueOf(i));
                transferenciaBolsaClasicaEmpresarialEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, transferenciaBolsaClasicaEmpresarialEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.GerFAWQsHQB.MainBankingTabFragment.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
