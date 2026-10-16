package cu.etecsa.cubacel.tr.tm.B21UyndcVvF;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.RecordSMS;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.KYTjPlWScT;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.BXJNp1qv2n;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.FlNVShJWtm;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.o3etZ8qrxr;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.oy860zvrlY;
import cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl.tGolNOl3DN;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import lecho.lib.hellocharts.formatter.PieChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimplePieChartValueFormatter;
import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

/* JADX INFO: loaded from: classes.dex */
public class ByJot7nE5d extends RecyclerView.Adapter<a2dVPTG0kZc> {
    public FragmentActivity activity;
    public int anno;
    private Context context;
    private List<Y9aAL2BCAI> itemList;
    public OnItemClickListener mItemClickListener;
    public int mes;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public ByJot7nE5d(Context contexts, List<Y9aAL2BCAI> itemList, FragmentActivity fragmentManager, int mesData, int annoData) {
        this.context = contexts;
        this.itemList = itemList;
        this.activity = fragmentManager;
        this.mes = mesData;
        this.anno = annoData;
    }

    public ByJot7nE5d(Context contexts, FragmentActivity fragmentManager, int mesData, int annoData) {
        try {
            this.context = contexts;
            this.activity = fragmentManager;
            this.mes = mesData;
            this.anno = annoData;
            cargarDatos();
        } catch (Exception ex) {
            Log.i("EXCEPTION PAYADAPTER", ex.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e6  */
    private void cargarDatos() {
        BXJNp1qv2n moneda;
        List<Y9aAL2BCAI> list = U6ucOCBccJ.itemsOperacionList;
        if (list == null) {
            List<Y9aAL2BCAI> itemsOperacionList = new ArrayList<>();
            for (KYTjPlWScT moduloEstaditico : KYTjPlWScT.values()) {
                int yearLast = this.anno;
                int monthLast = this.mes;
                List<RecordSMS> recordSMS = null;
                try {
                    Date ultima = unYp8VQThY.getInstance().getMaxDateRecordLists(moduloEstaditico);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(ultima);
                    yearLast = cal.get(1);
                    monthLast = cal.get(2) + 1;
                    recordSMS = unYp8VQThY.getInstance().getRecordSMSBetweenDates(moduloEstaditico, monthLast, yearLast);
                } catch (Exception ex) {
                    Log.d("Error", ex.toString());
                }
                if (recordSMS != null && recordSMS.size() > 0) {
                    List<FlNVShJWtm> operacionPojoList = new ArrayList<>();
                    Iterator<RecordSMS> it = recordSMS.iterator();
                    boolean isOkOpertionForEntity = true;
                    while (isOkOpertionForEntity) {
                        RecordSMS sms = it.next();
                        try {
                            FlNVShJWtm operacion = new FlNVShJWtm();
                            switch (sms.getMoneda()) {
                                case "CUC":
                                    moneda = BXJNp1qv2n.CUC;
                                    break;
                                case "CUP":
                                    moneda = BXJNp1qv2n.CUP;
                                    break;
                                case "USD":
                                    moneda = BXJNp1qv2n.USD;
                                    break;
                                case "MLC":
                                    moneda = BXJNp1qv2n.MLC;
                                    break;
                                default:
                                    moneda = null;
                                    break;
                            }
                            operacion.setImporte(Float.parseFloat(sms.getMonto()));
                            operacion.setTipoMoneda(moneda);
                            operacion.setDiaOperacion(sms.getFecha());
                            switch (sms.getServicio()) {
                                case "Recarga Móvil":
                                case "Recarga Movil":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Movil);
                                    operacion.setColor(Color.parseColor("#AA66CC"));
                                    break;
                                case "Pago Factura":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_Factura_Telefonica);
                                    operacion.setColor(Color.parseColor("#33B5E5"));
                                    break;
                                case "Recarga Nauta":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta);
                                    operacion.setColor(Color.parseColor("#99CC00"));
                                    break;
                                case "Pago Electricidad":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_Electricidad);
                                    operacion.setColor(Color.parseColor("#FF4444"));
                                    break;
                                case "Pago Teléfono(P)":
                                case "Pago Teléfono(T)":
                                case "Pago Telefono":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_Telefono);
                                    operacion.setColor(Color.parseColor("#FFBB33"));
                                    break;
                                case "Pago Agua":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_Agua);
                                    operacion.setColor(Color.parseColor("#00796B"));
                                    break;
                                case "Pago ONAT":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_ONAT);
                                    operacion.setColor(Color.parseColor("#FFEB3B"));
                                    break;
                                case "Transferencia":
                                    operacion.setOperacion(Nl0yptXmjQ.Transferencia);
                                    operacion.setColor(Color.parseColor("#536DFE"));
                                    break;
                                case "Recarga de Saldo Móvil":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Movil_Banco);
                                    operacion.setColor(Color.parseColor("#AA66CC"));
                                    break;
                                case "Amortizacion":
                                    operacion.setOperacion(Nl0yptXmjQ.Amortizacion);
                                    operacion.setColor(Color.parseColor("#E91E63"));
                                    break;
                                case "Pago Gas":
                                    operacion.setOperacion(Nl0yptXmjQ.Pago_Gas);
                                    operacion.setColor(Color.parseColor("#CC8B66"));
                                    break;
                                case "Giro postal":
                                    operacion.setOperacion(Nl0yptXmjQ.Giro);
                                    operacion.setColor(Color.parseColor("#CD5C5C"));
                                    break;
                                case "Compra en linea":
                                    operacion.setOperacion(Nl0yptXmjQ.xf94v3SFEM);
                                    operacion.setColor(Color.parseColor("#8FD500"));
                                    break;
                                case "Recarga nauta banco":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta_Banco);
                                    operacion.setColor(Color.parseColor("#001489"));
                                    break;
                                case "Recarga Propia":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Propia);
                                    operacion.setColor(Color.parseColor("#33B5E5"));
                                    break;
                                case "Nauta Hogar":
                                    operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta_Hogar_Banco);
                                    operacion.setColor(Color.parseColor("#1D3557"));
                                    break;
                                case "Joven Club":
                                    operacion.setOperacion(Nl0yptXmjQ.JClub);
                                    operacion.setColor(Color.parseColor("#A8DADC"));
                                    break;
                                case "Aporte Patrimonio":
                                    operacion.setOperacion(Nl0yptXmjQ.Aporte_Patrimonio);
                                    operacion.setColor(Color.parseColor("#4D727C"));
                                    break;
                                case "Combustible":
                                    operacion.setOperacion(Nl0yptXmjQ.Ticket_Combustible_Gestion);
                                    operacion.setColor(Color.parseColor("#c78b00"));
                                    break;
                                case "MiBoleto":
                                    operacion.setOperacion(Nl0yptXmjQ.Ticket_MiBoleto_Gestion);
                                    operacion.setColor(Color.parseColor("#c78b00"));
                                    break;
                                case "Caja Extra":
                                    operacion.setOperacion(Nl0yptXmjQ.CajaExtra);
                                    operacion.setColor(Color.parseColor("#00c73c"));
                                    break;
                                case "Sello de Timbre":
                                    operacion.setOperacion(Nl0yptXmjQ.SelloTimbre);
                                    operacion.setColor(Color.parseColor("#d17c0a"));
                                    break;
                                case "Recarga CUP Bolsa":
                                case "Recarga CUP Monedero":
                                    operacion.setOperacion(Nl0yptXmjQ.RecargaCUPBolsa);
                                    operacion.setColor(Color.parseColor("#d23918"));
                                    break;
                                case "Paquete MLC":
                                    operacion.setOperacion(Nl0yptXmjQ.PaqueteMLC);
                                    operacion.setColor(Color.parseColor("#d0dd2a"));
                                    break;
                                case "Recarga Nauta MLC":
                                    operacion.setOperacion(Nl0yptXmjQ.RecargaNautaMLC);
                                    operacion.setColor(Color.parseColor("#1ad910"));
                                    break;
                                case "Recarga Nauta Hogar 4G":
                                    operacion.setOperacion(Nl0yptXmjQ.RecargaNautaHogar4G);
                                    operacion.setColor(Color.parseColor("#3B4BE8"));
                                    break;
                                case "Gigas Nauta Hogar 4G":
                                    operacion.setOperacion(Nl0yptXmjQ.GigasNautaHogare4G);
                                    operacion.setColor(Color.parseColor("#1F1368"));
                                    break;
                                case "Visitas-Recorridos":
                                    operacion.setOperacion(Nl0yptXmjQ.VisitaRecorridos);
                                    operacion.setColor(Color.parseColor("#eab676"));
                                    break;
                                case "Mi Turno":
                                    operacion.setOperacion(Nl0yptXmjQ.ReservasTicket);
                                    operacion.setColor(Color.parseColor("#591ed9"));
                                    break;
                            }
                            if (operacion.getOperacion() != null) {
                                operacion.setTipo_operacion_string(sms.getServicio());
                                operacionPojoList.add(operacion);
                                isOkOpertionForEntity = true;
                            }
                        } catch (Exception ex2) {
                            Log.d("Error", ex2.toString());
                            isOkOpertionForEntity = false;
                        }
                    }
                    if (isOkOpertionForEntity) {
                        Y9aAL2BCAI operacionItem = new Y9aAL2BCAI();
                        operacionItem.setAgencia(moduloEstaditico);
                        operacionItem.setOperacionesEstaditicas(operacionPojoList);
                        operacionItem.setMes(monthLast);
                        operacionItem.setAnno(yearLast);
                        itemsOperacionList.add(operacionItem);
                    }
                }
            }
            U6ucOCBccJ.itemsOperacionList = itemsOperacionList;
            this.itemList = itemsOperacionList;
            return;
        }
        this.itemList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:134:0x0221  */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    public boolean cargarDatos(KYTjPlWScT moduloEstaditico, int mes, int anno) {
        new ArrayList();
        try {
            List<RecordSMS> recordSMS = unYp8VQThY.getInstance().getRecordSMSBetweenDates(moduloEstaditico, mes, anno);
            if (recordSMS == null || recordSMS.size() <= 0) {
                return false;
            }
            List<FlNVShJWtm> operacionPojoList = new ArrayList<>();
            Iterator<RecordSMS> it = recordSMS.iterator();
            while (true) {
                if (it.hasNext()) {
                    RecordSMS sms = it.next();
                    FlNVShJWtm operacion = new FlNVShJWtm();
                    BXJNp1qv2n moneda = null;
                    switch (sms.getMoneda()) {
                        case "CUC":
                            moneda = BXJNp1qv2n.CUC;
                            break;
                        case "CUP":
                            moneda = BXJNp1qv2n.CUP;
                            break;
                        case "USD":
                            moneda = BXJNp1qv2n.USD;
                            break;
                        case "MLC":
                            moneda = BXJNp1qv2n.MLC;
                            break;
                    }
                    operacion.setImporte(Float.parseFloat(sms.getMonto()));
                    operacion.setTipoMoneda(moneda);
                    operacion.setDiaOperacion(sms.getFecha());
                    switch (sms.getServicio()) {
                        case "Recarga Móvil":
                        case "Recarga Movil":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Movil);
                            operacion.setColor(Color.parseColor("#AA66CC"));
                            break;
                        case "Pago Factura":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_Factura_Telefonica);
                            operacion.setColor(Color.parseColor("#33B5E5"));
                            break;
                        case "Recarga Nauta":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta);
                            operacion.setColor(Color.parseColor("#99CC00"));
                            break;
                        case "Pago Electricidad":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_Electricidad);
                            operacion.setColor(Color.parseColor("#FF4444"));
                            break;
                        case "Pago Teléfono(P)":
                        case "Pago Teléfono(T)":
                        case "Pago Telefono":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_Telefono);
                            operacion.setColor(Color.parseColor("#FFBB33"));
                            break;
                        case "Pago Agua":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_Agua);
                            operacion.setColor(Color.parseColor("#00796B"));
                            break;
                        case "Pago ONAT":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_ONAT);
                            operacion.setColor(Color.parseColor("#FFEB3B"));
                            break;
                        case "Transferencia":
                            operacion.setOperacion(Nl0yptXmjQ.Transferencia);
                            operacion.setColor(Color.parseColor("#536DFE"));
                            break;
                        case "Recarga de Saldo Móvil":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Movil_Banco);
                            operacion.setColor(Color.parseColor("#AA66CC"));
                            break;
                        case "Amortizacion":
                            operacion.setOperacion(Nl0yptXmjQ.Amortizacion);
                            operacion.setColor(Color.parseColor("#E91E63"));
                            break;
                        case "Pago Gas":
                            operacion.setOperacion(Nl0yptXmjQ.Pago_Gas);
                            operacion.setColor(Color.parseColor("#CC8B66"));
                            break;
                        case "Giro postal":
                            operacion.setOperacion(Nl0yptXmjQ.Giro);
                            operacion.setColor(Color.parseColor("#CD5C5C"));
                            break;
                        case "Compra en linea":
                            operacion.setOperacion(Nl0yptXmjQ.xf94v3SFEM);
                            operacion.setColor(Color.parseColor("#8FD500"));
                            break;
                        case "Recarga nauta banco":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta_Banco);
                            operacion.setColor(Color.parseColor("#001489"));
                            break;
                        case "Recarga Propia":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Propia);
                            operacion.setColor(Color.parseColor("#33B5E5"));
                            break;
                        case "Nauta Hogar":
                            operacion.setOperacion(Nl0yptXmjQ.Recarga_Nauta_Hogar_Banco);
                            operacion.setColor(Color.parseColor("#1D3557"));
                            break;
                        case "Joven Club":
                            operacion.setOperacion(Nl0yptXmjQ.JClub);
                            operacion.setColor(Color.parseColor("#A8DADC"));
                            break;
                        case "Aporte Patrimonio":
                            operacion.setOperacion(Nl0yptXmjQ.Aporte_Patrimonio);
                            operacion.setColor(Color.parseColor("#4D727C"));
                            break;
                        case "Combustible":
                            operacion.setOperacion(Nl0yptXmjQ.Ticket_Combustible_Gestion);
                            operacion.setColor(Color.parseColor("#c78b00"));
                            break;
                        case "MiBoleto":
                            operacion.setOperacion(Nl0yptXmjQ.Ticket_MiBoleto_Gestion);
                            operacion.setColor(Color.parseColor("#c78b00"));
                            break;
                        case "Caja Extra":
                            operacion.setOperacion(Nl0yptXmjQ.CajaExtra);
                            operacion.setColor(Color.parseColor("#00c73c"));
                            break;
                        case "Sello de Timbre":
                            operacion.setOperacion(Nl0yptXmjQ.SelloTimbre);
                            operacion.setColor(Color.parseColor("#d17c0a"));
                            break;
                        case "Recarga CUP Bolsa":
                        case "Recarga CUP Monedero":
                            operacion.setOperacion(Nl0yptXmjQ.RecargaCUPBolsa);
                            operacion.setColor(Color.parseColor("#d23918"));
                            break;
                        case "Paquete MLC":
                            operacion.setOperacion(Nl0yptXmjQ.PaqueteMLC);
                            operacion.setColor(Color.parseColor("#d0dd2a"));
                            break;
                        case "Recarga Nauta MLC":
                            operacion.setOperacion(Nl0yptXmjQ.RecargaNautaMLC);
                            operacion.setColor(Color.parseColor("#1ad910"));
                            break;
                        case "Recarga Nauta Hogar 4G":
                            operacion.setOperacion(Nl0yptXmjQ.RecargaNautaHogar4G);
                            operacion.setColor(Color.parseColor("#3B4BE8"));
                            break;
                        case "Gigas Nauta Hogar 4G":
                            operacion.setOperacion(Nl0yptXmjQ.GigasNautaHogare4G);
                            operacion.setColor(Color.parseColor("#1F1368"));
                            break;
                        case "Visitas-Recorridos":
                            operacion.setOperacion(Nl0yptXmjQ.VisitaRecorridos);
                            operacion.setColor(Color.parseColor("#eab676"));
                            break;
                        case "Mi Turno":
                            operacion.setOperacion(Nl0yptXmjQ.ReservasTicket);
                            operacion.setColor(Color.parseColor("#591ed9"));
                            break;
                    }
                    if (operacion.getOperacion() != null) {
                        operacion.setTipo_operacion_string(sms.getServicio());
                        operacionPojoList.add(operacion);
                    }
                } else {
                    Y9aAL2BCAI operacionItem = new Y9aAL2BCAI();
                    List<Y9aAL2BCAI> itemsOperacionList = this.itemList;
                    operacionItem.setAgencia(moduloEstaditico);
                    operacionItem.setOperacionesEstaditicas(operacionPojoList);
                    operacionItem.setMes(mes);
                    operacionItem.setAnno(anno);
                    for (int i = 0; i < itemsOperacionList.size(); i++) {
                        if (itemsOperacionList.get(i).getAgencia() == moduloEstaditico) {
                            itemsOperacionList.remove(i);
                            itemsOperacionList.add(i, operacionItem);
                        }
                    }
                    U6ucOCBccJ.itemsOperacionList = itemsOperacionList;
                    this.itemList = itemsOperacionList;
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a2dVPTG0kZc onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.su61iils2kwd4, viewGroup, false);
        a2dVPTG0kZc viewHolder = new a2dVPTG0kZc(view);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a2dVPTG0kZc customViewHolder, int i) {
        customViewHolder.operacionesEstaditicas = this.itemList.get(i).getOperacionesEstaditicas();
        customViewHolder.agencia = this.itemList.get(i).getAgencia();
        customViewHolder.generateDataCharts(this.itemList.get(i), this.itemList.get(i).getAgencia());
        customViewHolder.eventosOnClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Y9aAL2BCAI> list = this.itemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class a2dVPTG0kZc extends RecyclerView.ViewHolder implements View.OnClickListener {
        public oy860zvrlY adapterLeyenda;
        public oy860zvrlY adapterLeyenda2;
        public oy860zvrlY adapterLeyenda3;
        public KYTjPlWScT agencia;
        public KYTjPlWScT agenciaSeleccionada;
        private ImageButton agencyImage;
        public int annoItem;
        private PieChartView chart1;
        private PieChartView chart2;
        public CardView cv;
        private PieChartData data1;
        private PieChartData data2;
        public o3etZ8qrxr estadisticasListItemsSinMoneda;
        private boolean hasCenterCircle;
        private boolean hasCenterText1;
        private boolean hasCenterText2;
        private boolean hasLabelForSelected;
        private boolean hasLabels;
        private boolean hasLabelsOutside;
        private boolean isExploded;
        private List<tGolNOl3DN> itemsLeyendaCantidades;
        private List<tGolNOl3DN> itemsLeyendaImportes;
        public ListView listVLeyenda2;
        public ListView listVLeyenda3;
        public int mesItem;
        private TextView monedaCUC;
        private TextView monedaCUP;
        public String monedaSeleccionada;
        public List<FlNVShJWtm> operacionesEstaditicas;
        public RelativeLayout placeHolder;
        private TextView textAnno;
        private TextView textMes;

        public a2dVPTG0kZc(View view) {
            super(view);
            this.hasLabels = false;
            this.hasLabelsOutside = false;
            this.hasCenterCircle = true;
            this.hasCenterText1 = true;
            this.hasCenterText2 = false;
            this.isExploded = false;
            this.hasLabelForSelected = false;
            this.monedaSeleccionada = "CUP";
            this.agenciaSeleccionada = null;
            this.mesItem = 0;
            this.annoItem = 0;
            this.cv = (CardView) view.findViewById(R.id.cv);
            PieChartView pieChartView = (PieChartView) view.findViewById(R.id.chartPie);
            this.chart1 = pieChartView;
            pieChartView.setOnValueTouchListener(new ValueTouchListener());
            PieChartView pieChartView2 = (PieChartView) view.findViewById(R.id.chartPie2);
            this.chart2 = pieChartView2;
            pieChartView2.setOnValueTouchListener(new ValueTouchListener());
            this.listVLeyenda2 = (ListView) view.findViewById(R.id.leyenda_list2);
            this.listVLeyenda3 = (ListView) view.findViewById(R.id.leyenda_list3);
            this.agencyImage = (ImageButton) view.findViewById(R.id.agenciaBtn);
            this.monedaCUP = (TextView) view.findViewById(R.id.txtmonedaCUP);
            this.monedaCUC = (TextView) view.findViewById(R.id.txtmonedaCUC);
            this.placeHolder = (RelativeLayout) view.findViewById(R.id.mainHolder);
            this.textAnno = (TextView) view.findViewById(R.id.textAnno);
            this.textMes = (TextView) view.findViewById(R.id.textMes);
        }

        private List<tGolNOl3DN> clonarListaLeyenda(List<tGolNOl3DN> original) {
            List<tGolNOl3DN> copia = new ArrayList<>();
            for (tGolNOl3DN uyh0pxs9m37in : original) {
                tGolNOl3DN nuevoItem = new tGolNOl3DN();
                nuevoItem.setColor(uyh0pxs9m37in.getColor());
                nuevoItem.setLeyenda(uyh0pxs9m37in.getLeyenda());
                nuevoItem.setOperacion(uyh0pxs9m37in.getOperacion());
                nuevoItem.setMoneda(uyh0pxs9m37in.getMoneda());
                nuevoItem.setOperacion_literal(uyh0pxs9m37in.getOperacion_literal());
                nuevoItem.setValor(uyh0pxs9m37in.getValor());
                copia.add(nuevoItem);
            }
            return copia;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void actualizarValoresLeyendaConDatos(List<SliceValue> valores, oy860zvrlY adapter, ListView listView, List<tGolNOl3DN> itemsList, boolean esImporte) {
            if (adapter != null && itemsList != null) {
                for (int i = 0; i < itemsList.size() && i < valores.size(); i++) {
                    tGolNOl3DN uyh0pxs9m37in = itemsList.get(i);
                    float valor = valores.get(i).getValue();
                    uyh0pxs9m37in.setValor(valor);
                }
                BXJNp1qv2n monedaEntity = this.monedaSeleccionada.equals("CUP") ? BXJNp1qv2n.CUP : BXJNp1qv2n.USD;
                adapter.setMonedaActual(monedaEntity);
                adapter.setEsFormatoImporte(esImporte);
                adapter.notifyDataSetChanged();
                listLeyendaAlturaDinamica(listView, adapter, itemsList);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:31:0x01c2  */
        public void generateDataCharts(Y9aAL2BCAI itemPay, KYTjPlWScT agencyEntity) {
            List<SliceValue> values;
            List<SliceValue> values2;
            this.annoItem = itemPay.getAnno();
            this.mesItem = itemPay.getMes();
            List<FlNVShJWtm> operacionPojoList = itemPay.getOperacionesEstaditicas();
            this.agenciaSeleccionada = agencyEntity;
            byte b = 0;
            o3etZ8qrxr o3etz8qrxr = new o3etZ8qrxr(operacionPojoList, false);
            this.estadisticasListItemsSinMoneda = o3etz8qrxr;
            List<tGolNOl3DN> leyendaOriginal = o3etz8qrxr.getLeyenda();
            this.itemsLeyendaCantidades = clonarListaLeyenda(leyendaOriginal);
            this.itemsLeyendaImportes = clonarListaLeyenda(leyendaOriginal);
            o3etZ8qrxr o3etz8qrxr2 = this.estadisticasListItemsSinMoneda;
            BXJNp1qv2n bXJNp1qv2n = BXJNp1qv2n.CUP;
            List<SliceValue> values3 = o3etz8qrxr2.getCantidadOperacionesPayMoneda(bXJNp1qv2n);
            if (values3 != null) {
                values = values3;
            } else {
                values = this.estadisticasListItemsSinMoneda.getCantidadOperacionesPayMoneda(BXJNp1qv2n.USD);
            }
            PieChartData pieChartData = new PieChartData(values);
            this.data1 = pieChartData;
            pieChartData.setHasLabels(this.hasLabels);
            this.data1.setHasLabelsOnlyForSelected(this.hasLabelForSelected);
            this.data1.setHasLabelsOutside(this.hasLabelsOutside);
            this.data1.setHasCenterCircle(this.hasCenterCircle);
            this.data1.setCenterText1("Cantidad");
            List<SliceValue> values4 = this.estadisticasListItemsSinMoneda.getImporteOperacionesPayMoneda(bXJNp1qv2n);
            if (values4 != null) {
                values2 = values4;
            } else {
                List<SliceValue> values5 = this.estadisticasListItemsSinMoneda.getImporteOperacionesPayMoneda(BXJNp1qv2n.USD);
                this.monedaCUP.setBackgroundResource(R.drawable.circular_textview3out);
                this.monedaCUC.setBackgroundResource(R.drawable.circular_textview);
                this.monedaSeleccionada = "USD";
                values2 = values5;
            }
            PieChartData pieChartData2 = new PieChartData(values2);
            this.data2 = pieChartData2;
            pieChartData2.setHasLabels(this.hasLabels);
            this.data2.setHasLabelsOnlyForSelected(this.hasLabelForSelected);
            this.data2.setHasLabelsOutside(this.hasLabelsOutside);
            this.data2.setHasCenterCircle(this.hasCenterCircle);
            PieChartValueFormatter p = new SimplePieChartValueFormatter(1);
            this.data2.setFormatter(p);
            this.data2.setCenterText1("Importe");
            this.data1.setCenterText1FontSize(ChartUtils.px2sp(ByJot7nE5d.this.context.getResources().getDisplayMetrics().scaledDensity, (int) ByJot7nE5d.this.context.getResources().getDimension(R.dimen.pie_chart_text1_size)));
            this.data2.setCenterText1FontSize(ChartUtils.px2sp(ByJot7nE5d.this.context.getResources().getDisplayMetrics().scaledDensity, (int) ByJot7nE5d.this.context.getResources().getDimension(R.dimen.pie_chart_text1_size)));
            if (this.isExploded) {
                this.data1.setSlicesSpacing(24);
                this.data2.setSlicesSpacing(24);
            }
            this.chart1.setPieChartData(this.data1);
            this.chart2.setPieChartData(this.data2);
            this.adapterLeyenda2 = new oy860zvrlY(ByJot7nE5d.this.context, this.itemsLeyendaCantidades);
            this.adapterLeyenda3 = new oy860zvrlY(ByJot7nE5d.this.context, this.itemsLeyendaImportes);
            this.listVLeyenda2.setAdapter((ListAdapter) this.adapterLeyenda2);
            this.listVLeyenda3.setAdapter((ListAdapter) this.adapterLeyenda3);
            actualizarValoresLeyendaConDatos(this.data1.getValues(), this.adapterLeyenda2, this.listVLeyenda2, this.itemsLeyendaCantidades, false);
            actualizarValoresLeyendaConDatos(this.data2.getValues(), this.adapterLeyenda3, this.listVLeyenda3, this.itemsLeyendaImportes, true);
            String strName = agencyEntity.name();
            switch (strName.hashCode()) {
                case -1801083080:
                    if (!strName.equals("BancoBPA")) {
                        b = -1;
                    }
                    break;
                case 41817406:
                    if (!strName.equals("BancoMetro")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 224462632:
                    if (!strName.equals("BolsaEtecsa")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 603667027:
                    if (!strName.equals("Agentes")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 946994670:
                    if (!strName.equals("BancoBANDEC")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    this.agencyImage.setBackgroundResource(R.drawable.banco_bpa_ico);
                    break;
                case 1:
                    this.agencyImage.setBackgroundResource(R.drawable.logo_bandec_color);
                    break;
                case 2:
                    this.agencyImage.setBackgroundResource(R.drawable.banco_metro_ico_gris);
                    break;
                case 3:
                    this.agencyImage.setBackgroundResource(R.drawable.etecsa_logo);
                    break;
                case 4:
                    this.agencyImage.setBackgroundResource(R.drawable.mitransfer_head_1);
                    break;
            }
            this.textAnno.setText(String.valueOf(itemPay.getAnno()));
            String mesText = BuildConfig.FLAVOR;
            switch (itemPay.getMes()) {
                case 1:
                    mesText = "Enero";
                    break;
                case 2:
                    mesText = "Febrero";
                    break;
                case 3:
                    mesText = "Marzo";
                    break;
                case 4:
                    mesText = "Abril";
                    break;
                case 5:
                    mesText = "Mayo";
                    break;
                case 6:
                    mesText = "Junio";
                    break;
                case 7:
                    mesText = "Julio";
                    break;
                case 8:
                    mesText = "Agosto";
                    break;
                case 9:
                    mesText = "Septiembre";
                    break;
                case 10:
                    mesText = "Octubre";
                    break;
                case 11:
                    mesText = "Noviembre";
                    break;
                case 12:
                    mesText = "Diciembre";
                    break;
            }
            this.textMes.setText(mesText);
        }

        public void eventosOnClick() {
            this.textAnno.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a2dVPTG0kZc.this.mostrarCalendario();
                    } catch (Exception e) {
                        Log.i("Calendario", e.getMessage());
                    }
                }
            });
            this.textMes.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a2dVPTG0kZc.this.mostrarCalendario();
                    } catch (Exception e) {
                        Log.i("Calendario", e.getMessage());
                    }
                }
            });
            this.monedaCUP.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    List<SliceValue> valuesCUC = a2dVPTG0kZc.this.estadisticasListItemsSinMoneda.getCantidadOperacionesPayMoneda(BXJNp1qv2n.CUP);
                    if (valuesCUC == null) {
                        Toast.makeText(ByJot7nE5d.this.context, R.string.err_msg_no_oper_by_moneda, 1).show();
                        return;
                    }
                    int contador1 = 0;
                    for (SliceValue value : a2dVPTG0kZc.this.data1.getValues()) {
                        value.setTarget(valuesCUC.get(contador1).getValue());
                        contador1++;
                    }
                    int contador2 = 0;
                    List<SliceValue> values = a2dVPTG0kZc.this.estadisticasListItemsSinMoneda.getImporteOperacionesPayMoneda(BXJNp1qv2n.CUP);
                    for (SliceValue value2 : a2dVPTG0kZc.this.data2.getValues()) {
                        value2.setTarget(values.get(contador2).getValue());
                        contador2++;
                    }
                    a2dVPTG0kZc.this.monedaCUP.setBackgroundResource(R.drawable.circular_textview);
                    a2dVPTG0kZc.this.monedaCUC.setBackgroundResource(R.drawable.circular_textview3out);
                    Animation a = AnimationUtils.loadAnimation(ByJot7nE5d.this.context, R.anim.size_big);
                    a.reset();
                    a2dVPTG0kZc.this.monedaCUP.clearAnimation();
                    a2dVPTG0kZc.this.monedaCUP.startAnimation(a);
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    a2dvptg0kzc.monedaSeleccionada = "CUP";
                    a2dvptg0kzc.chart1.startDataAnimation();
                    a2dVPTG0kZc.this.chart2.startDataAnimation();
                    a2dVPTG0kZc.this.chart1.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a2dVPTG0kZc a2dvptg0kzc2 = a2dVPTG0kZc.this;
                            List<SliceValue> values2 = a2dvptg0kzc2.data1.getValues();
                            a2dVPTG0kZc a2dvptg0kzc3 = a2dVPTG0kZc.this;
                            a2dvptg0kzc2.actualizarValoresLeyendaConDatos(values2, a2dvptg0kzc3.adapterLeyenda2, a2dvptg0kzc3.listVLeyenda2, a2dvptg0kzc3.itemsLeyendaCantidades, false);
                            a2dVPTG0kZc a2dvptg0kzc4 = a2dVPTG0kZc.this;
                            List<SliceValue> values3 = a2dvptg0kzc4.data2.getValues();
                            a2dVPTG0kZc a2dvptg0kzc5 = a2dVPTG0kZc.this;
                            a2dvptg0kzc4.actualizarValoresLeyendaConDatos(values3, a2dvptg0kzc5.adapterLeyenda3, a2dvptg0kzc5.listVLeyenda3, a2dvptg0kzc5.itemsLeyendaImportes, true);
                        }
                    }, 500L);
                }
            });
            this.monedaCUC.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    List<SliceValue> valuesCUC = a2dVPTG0kZc.this.estadisticasListItemsSinMoneda.getCantidadOperacionesPayMoneda(BXJNp1qv2n.USD);
                    if (valuesCUC == null) {
                        Toast.makeText(ByJot7nE5d.this.context, R.string.err_msg_no_oper_by_moneda, 1).show();
                        return;
                    }
                    int contador1 = 0;
                    for (SliceValue value : a2dVPTG0kZc.this.data1.getValues()) {
                        value.setTarget(valuesCUC.get(contador1).getValue());
                        contador1++;
                    }
                    a2dVPTG0kZc.this.chart1.startDataAnimation();
                    int contador2 = 0;
                    try {
                        List<SliceValue> values = a2dVPTG0kZc.this.estadisticasListItemsSinMoneda.getImporteOperacionesPayMoneda(BXJNp1qv2n.USD);
                        for (SliceValue value2 : a2dVPTG0kZc.this.data2.getValues()) {
                            value2.setTarget(values.get(contador2).getValue());
                            contador2++;
                        }
                    } catch (Exception e) {
                    }
                    a2dVPTG0kZc.this.chart2.startDataAnimation();
                    a2dVPTG0kZc.this.monedaCUP.setBackgroundResource(R.drawable.circular_textview3out);
                    a2dVPTG0kZc.this.monedaCUC.setBackgroundResource(R.drawable.circular_textview);
                    Animation a = AnimationUtils.loadAnimation(ByJot7nE5d.this.context, R.anim.size_big);
                    a.reset();
                    a2dVPTG0kZc.this.monedaCUC.clearAnimation();
                    a2dVPTG0kZc.this.monedaCUC.startAnimation(a);
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    a2dvptg0kzc.monedaSeleccionada = "USD";
                    a2dvptg0kzc.chart1.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a2dVPTG0kZc a2dvptg0kzc2 = a2dVPTG0kZc.this;
                            List<SliceValue> values2 = a2dvptg0kzc2.data1.getValues();
                            a2dVPTG0kZc a2dvptg0kzc3 = a2dVPTG0kZc.this;
                            a2dvptg0kzc2.actualizarValoresLeyendaConDatos(values2, a2dvptg0kzc3.adapterLeyenda2, a2dvptg0kzc3.listVLeyenda2, a2dvptg0kzc3.itemsLeyendaCantidades, false);
                            a2dVPTG0kZc a2dvptg0kzc4 = a2dVPTG0kZc.this;
                            List<SliceValue> values3 = a2dvptg0kzc4.data2.getValues();
                            a2dVPTG0kZc a2dvptg0kzc5 = a2dVPTG0kZc.this;
                            a2dvptg0kzc4.actualizarValoresLeyendaConDatos(values3, a2dvptg0kzc5.adapterLeyenda3, a2dvptg0kzc5.listVLeyenda3, a2dvptg0kzc5.itemsLeyendaImportes, true);
                        }
                    }, 500L);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mostrarCalendario() {
            Calendar calendarCurrent = Calendar.getInstance();
            calendarCurrent.set(1, this.annoItem);
            calendarCurrent.set(2, this.mesItem - 1);
            rRvXcuGxBE yearMonthPickerDialog = new rRvXcuGxBE(ByJot7nE5d.this.activity, calendarCurrent, new rRvXcuGxBE.OnDateSetListener() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.5
                @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.z9AyDhvWhoQ.iUhUEXEdlxs.K5TDZs6r2lUJ.rRvXcuGxBE.OnDateSetListener
                public void onYearMonthSet(int year, int month) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, year);
                    calendar.set(2, month);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
                    a2dVPTG0kZc a2dvptg0kzc = a2dVPTG0kZc.this;
                    if (!ByJot7nE5d.this.cargarDatos(a2dvptg0kzc.agencia, month + 1, year)) {
                        Toast.makeText(ByJot7nE5d.this.context, "No existen registros la fecha seleccionada", 1).show();
                        return;
                    }
                    ByJot7nE5d byJot7nE5d = ByJot7nE5d.this;
                    byJot7nE5d.anno = year;
                    byJot7nE5d.mes = month + 1;
                    byJot7nE5d.notifyDataSetChanged();
                    a2dVPTG0kZc.this.chart1.startDataAnimation();
                    a2dVPTG0kZc.this.chart2.startDataAnimation();
                    a2dVPTG0kZc.this.textMes.setText(dateFormat.format(calendar.getTime()));
                    a2dVPTG0kZc.this.monedaCUP.setBackgroundResource(R.drawable.circular_textview);
                    a2dVPTG0kZc.this.monedaCUC.setBackgroundResource(R.drawable.circular_textview3out);
                    Animation a = AnimationUtils.loadAnimation(ByJot7nE5d.this.context, R.anim.size_big);
                    a.reset();
                    a2dVPTG0kZc.this.monedaCUP.clearAnimation();
                    a2dVPTG0kZc.this.monedaCUP.startAnimation(a);
                    a2dVPTG0kZc a2dvptg0kzc2 = a2dVPTG0kZc.this;
                    a2dvptg0kzc2.monedaSeleccionada = "CUP";
                    a2dvptg0kzc2.chart1.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B21UyndcVvF.ByJot7nE5d.a2dVPTG0kZc.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a2dVPTG0kZc a2dvptg0kzc3 = a2dVPTG0kZc.this;
                            List<SliceValue> values = a2dvptg0kzc3.data1.getValues();
                            a2dVPTG0kZc a2dvptg0kzc4 = a2dVPTG0kZc.this;
                            a2dvptg0kzc3.actualizarValoresLeyendaConDatos(values, a2dvptg0kzc4.adapterLeyenda2, a2dvptg0kzc4.listVLeyenda2, a2dvptg0kzc4.itemsLeyendaCantidades, false);
                            a2dVPTG0kZc a2dvptg0kzc5 = a2dVPTG0kZc.this;
                            List<SliceValue> values2 = a2dvptg0kzc5.data2.getValues();
                            a2dVPTG0kZc a2dvptg0kzc6 = a2dVPTG0kZc.this;
                            a2dvptg0kzc5.actualizarValoresLeyendaConDatos(values2, a2dvptg0kzc6.adapterLeyenda3, a2dvptg0kzc6.listVLeyenda3, a2dvptg0kzc6.itemsLeyendaImportes, true);
                        }
                    }, 500L);
                }
            });
            yearMonthPickerDialog.show();
        }

        private void listLeyendaAlturaDinamica(ListView listView, oy860zvrlY adapter, List<tGolNOl3DN> items) {
            if (listView == null || adapter == null) {
                return;
            }
            int totalHeight = 0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View listItem = adapter.getView(i, null, listView);
                listItem.measure(View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                totalHeight += listItem.getMeasuredHeight();
            }
            int i2 = listView.getDividerHeight();
            int dividerHeight = i2 * (adapter.getCount() - 1);
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + dividerHeight + listView.getPaddingTop() + listView.getPaddingBottom();
            listView.setLayoutParams(params);
            listView.requestLayout();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == this.monedaCUP.getId()) {
                List<SliceValue> values = this.estadisticasListItemsSinMoneda.getCantidadOperacionesPayMoneda(BXJNp1qv2n.CUP);
                int contador1 = 0;
                for (SliceValue value : this.data1.getValues()) {
                    value.setTarget(values.get(contador1).getValue());
                    contador1++;
                }
                this.chart1.startDataAnimation();
            }
            if (view.getId() == this.monedaCUC.getId()) {
                int contador2 = 0;
                List<SliceValue> values2 = this.estadisticasListItemsSinMoneda.getImporteOperacionesPayMoneda(BXJNp1qv2n.USD);
                for (SliceValue value2 : this.data2.getValues()) {
                    value2.setTarget(values2.get(contador2).getValue());
                    contador2++;
                }
            }
            OnItemClickListener onItemClickListener = ByJot7nE5d.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }

        public void btn_pagar_On_Click(View view) {
            OnItemClickListener onItemClickListener = ByJot7nE5d.this.mItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.itemView, getPosition());
            }
        }

        public class ValueTouchListener implements PieChartOnValueSelectListener {
            public ValueTouchListener() {
            }

            @Override // lecho.lib.hellocharts.listener.PieChartOnValueSelectListener
            public void onValueSelected(int arcIndex, SliceValue value) {
                oy860zvrlY oy860zvrly = a2dVPTG0kZc.this.adapterLeyenda2;
                if (oy860zvrly != null) {
                    oy860zvrly.getCount();
                }
                oy860zvrlY oy860zvrly2 = a2dVPTG0kZc.this.adapterLeyenda3;
                if (oy860zvrly2 != null) {
                    oy860zvrly2.getCount();
                }
            }

            @Override // lecho.lib.hellocharts.listener.OnValueDeselectListener
            public void onValueDeselected() {
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
