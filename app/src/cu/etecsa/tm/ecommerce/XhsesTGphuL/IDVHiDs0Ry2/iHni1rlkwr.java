package cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.qQsnaKw3VY;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.s5BkGOZ35ku;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.RKxbomWW57;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.MlJJtXnfZh;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.Ph6mQUZRw4;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ALtYP1fGkI;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.IIvRN9WfE5;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.ruM2FlC2jP;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class iHni1rlkwr implements Q3QlsyUy019 {
    public int code;
    public Context context;
    public String idPago;
    public boolean isSuccess;
    public String mensaje;
    public OperTypePagoDinamico operTypePagoDinamico;
    public Ph6mQUZRw4 request;
    public IIvRN9WfE5 response;
    public RKxbomWW57 responseTicket;
    public qQsnaKw3VY resultView;
    public String HEAD_LOG = "iHni1rlkwr";
    public String token = UhA7J2923N.getInstance().getAccess_token();

    public enum OperTypePagoDinamico {
        ENVIAR_PAGO,
        CHEQUEAR_PAGO
    }

    public iHni1rlkwr(qQsnaKw3VY resultView, Context context) {
        this.resultView = resultView;
        this.context = context;
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019
    public void clear() {
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019
    public void enviarPago(int source, String descripcion, float importe) {
        this.operTypePagoDinamico = OperTypePagoDinamico.ENVIAR_PAGO;
        Ph6mQUZRw4 ph6mQUZRw4 = new Ph6mQUZRw4();
        this.request = ph6mQUZRw4;
        ph6mQUZRw4.setAmount(importe);
        this.request.setDescription(descripcion);
        this.request.setSources(source);
        ExcPagoTask pagoTask = new ExcPagoTask(this, null);
        pagoTask.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019
    public void checkPago(String id) {
        this.operTypePagoDinamico = OperTypePagoDinamico.CHEQUEAR_PAGO;
        this.idPago = id;
        ExcPagoTask pagoTask = new ExcPagoTask(this, null);
        pagoTask.execute(new String[0]);
    }

    @Override // cu.etecsa.tm.ecommerce.XhsesTGphuL.Q3QlsyUy019
    public void setProgressBarVisiblity(int visiblity) {
        qQsnaKw3VY qqsnakw3vy = this.resultView;
        if (qqsnakw3vy != null) {
            qqsnakw3vy.onSetProgressBarVisibility(visiblity);
        }
    }

    public class ExcPagoTask extends AsyncTask<String, Ph6mQUZRw4, Boolean> {
        public ExcPagoTask() {
        }

        public /* synthetic */ ExcPagoTask(iHni1rlkwr x0, AnonymousClass1 x1) {
            this();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            iHni1rlkwr ihni1rlkwr = iHni1rlkwr.this;
            if (ihni1rlkwr.operTypePagoDinamico != OperTypePagoDinamico.CHEQUEAR_PAGO) {
                ihni1rlkwr.setProgressBarVisiblity(0);
            }
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strings) {
            try {
                ruM2FlC2jP pagoCU = new ruM2FlC2jP(iHni1rlkwr.this.context);
                switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$iHni1rlkwr$OperTypePagoDinamico[iHni1rlkwr.this.operTypePagoDinamico.ordinal()]) {
                    case 1:
                        iHni1rlkwr.this.response = new IIvRN9WfE5();
                        iHni1rlkwr ihni1rlkwr = iHni1rlkwr.this;
                        ihni1rlkwr.response = pagoCU.enviarPagoDin(ihni1rlkwr.token, ihni1rlkwr.request);
                        iHni1rlkwr ihni1rlkwr2 = iHni1rlkwr.this;
                        ihni1rlkwr2.isSuccess = ihni1rlkwr2.response.isOK();
                        iHni1rlkwr ihni1rlkwr3 = iHni1rlkwr.this;
                        ihni1rlkwr3.mensaje = ihni1rlkwr3.response.getMenssage();
                        break;
                    case 2:
                        iHni1rlkwr.this.responseTicket = new RKxbomWW57();
                        MlJJtXnfZh trazaPagoRequest = new MlJJtXnfZh();
                        trazaPagoRequest.setPayment_code(iHni1rlkwr.this.idPago);
                        ALtYP1fGkI trazaPagoResponse = pagoCU.getTrazaPgo(iHni1rlkwr.this.token, trazaPagoRequest);
                        iHni1rlkwr.this.isSuccess = trazaPagoResponse.isOK();
                        iHni1rlkwr.this.mensaje = trazaPagoResponse.getMenssage();
                        if (!trazaPagoResponse.isOK()) {
                            iHni1rlkwr.this.responseTicket.setOk(false);
                            iHni1rlkwr.this.responseTicket.setDetalles(trazaPagoResponse.getMenssage());
                        } else if (trazaPagoResponse.getPagoList().size() == 1) {
                            s5BkGOZ35ku pago = trazaPagoResponse.getPagoList().get(0);
                            iHni1rlkwr.this.responseTicket.setBanco(pago.getBBancoEnum());
                            iHni1rlkwr.this.responseTicket.setEstado(pago.getEstadoPago());
                            iHni1rlkwr.this.responseTicket.setIdBanco(pago.getBankCode());
                            iHni1rlkwr.this.responseTicket.setIdTercero(pago.getIdPago());
                            iHni1rlkwr.this.responseTicket.setImoprte(String.valueOf(pago.getImporte()) + " " + pago.getMoneda());
                            iHni1rlkwr.this.responseTicket.setIdTM(pago.getTmCode());
                            iHni1rlkwr.this.responseTicket.setDescripcion(pago.getDescription());
                            iHni1rlkwr.this.responseTicket.setDetalles(pago.getResultMsg());
                            iHni1rlkwr.this.responseTicket.setFecha(pago.getFecha());
                            iHni1rlkwr.this.responseTicket.setImporte(pago.getImporte());
                            iHni1rlkwr.this.responseTicket.setSource(pago.getSource());
                            iHni1rlkwr.this.responseTicket.setExternalCode(pago.getExternalCode());
                            iHni1rlkwr.this.responseTicket.setUsuario(pago.getUser());
                        } else {
                            iHni1rlkwr.this.responseTicket.setOk(false);
                            String msg = UhA7J2923N.getInstance().getErrorMessage(UZsizlaDNk.PAGO_DINAMICO_POST, "500");
                            iHni1rlkwr.this.responseTicket.setDetalles(msg);
                        }
                        break;
                }
                return true;
            } catch (Exception ex) {
                iHni1rlkwr ihni1rlkwr4 = iHni1rlkwr.this;
                ihni1rlkwr4.isSuccess = false;
                ihni1rlkwr4.code = -1;
                ihni1rlkwr4.mensaje = UhA7J2923N.getInstance().getMessage(500, iHni1rlkwr.this.HEAD_LOG, ex.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            iHni1rlkwr.this.setProgressBarVisiblity(4);
            iHni1rlkwr ihni1rlkwr = iHni1rlkwr.this;
            qQsnaKw3VY qqsnakw3vy = ihni1rlkwr.resultView;
            if (qqsnakw3vy != null) {
                if (ihni1rlkwr.operTypePagoDinamico == OperTypePagoDinamico.ENVIAR_PAGO) {
                    Boolean boolValueOf = Boolean.valueOf(ihni1rlkwr.isSuccess);
                    iHni1rlkwr ihni1rlkwr2 = iHni1rlkwr.this;
                    qqsnakw3vy.onPagoResult(boolValueOf, ihni1rlkwr2.code, ihni1rlkwr2.mensaje, ihni1rlkwr2.response);
                } else {
                    Boolean boolValueOf2 = Boolean.valueOf(ihni1rlkwr.isSuccess);
                    iHni1rlkwr ihni1rlkwr3 = iHni1rlkwr.this;
                    qqsnakw3vy.onChequeoPagoResult(boolValueOf2, ihni1rlkwr3.code, ihni1rlkwr3.mensaje, ihni1rlkwr3.responseTicket);
                }
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.iHni1rlkwr$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$iHni1rlkwr$OperTypePagoDinamico;

        static {
            int[] iArr = new int[OperTypePagoDinamico.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$iHni1rlkwr$OperTypePagoDinamico = iArr;
            try {
                iArr[OperTypePagoDinamico.ENVIAR_PAGO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$XhsesTGphuL$IDVHiDs0Ry2$iHni1rlkwr$OperTypePagoDinamico[OperTypePagoDinamico.CHEQUEAR_PAGO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
