package cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.wnGiwuD0kT;
import cu.etecsa.tm.ecommerce.R;

/* JADX INFO: loaded from: classes.dex */
public class vIGfHVEwb7 extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public String HEAD_LOG = "vIGfHVEwb7";
    public CardView btDevolver;
    public Button btOk;
    public CardView cdDetalles;
    public CardView cdEstado;
    public CardView cdPagoConfirmado;
    public Context context;
    public hLxHp3lKE9 datos;
    public ImageView imStatus;
    public float importe;
    public ImageView ivBanco;
    public ImageView ivIconoTM;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public TextView titleDetallesPendiente;
    public TextView txBanco;
    public TextView txCodDevolucion;
    public TextView txCodPago;
    public TextView txDescripcionPendiente;
    public TextView txDevBank;
    public TextView txDevTM;
    public TextView txEstado;
    public TextView txFecha;
    public TextView txImporte;
    public TextView txTitleDevBank;
    public TextView txTitleDevTM;
    public TextView txTitleUser;
    public TextView txUsuario;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.bzqutvw3lwozj, container, false);
        loadDrawables();
        Bundle arg = getArguments();
        this.datos = (hLxHp3lKE9) arg.getSerializable("PAGO");
        return this.rootView;
    }

    public static vIGfHVEwb7 newInstance(hLxHp3lKE9 datos) {
        vIGfHVEwb7 frag = new vIGfHVEwb7();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", datos);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = view.getContext();
        this.ivBanco = (ImageView) this.rootView.findViewById(R.id.ivBanco);
        this.cdEstado = (CardView) this.rootView.findViewById(R.id.cdEstado);
        this.txEstado = (TextView) this.rootView.findViewById(R.id.txOperacion);
        this.txCodPago = (TextView) this.rootView.findViewById(R.id.txCodPago);
        this.txImporte = (TextView) this.rootView.findViewById(R.id.txImporte);
        this.txBanco = (TextView) this.rootView.findViewById(R.id.txBanco);
        this.ivIconoTM = (ImageView) this.rootView.findViewById(R.id.ivIconoTM);
        this.txFecha = (TextView) this.rootView.findViewById(R.id.txFecha);
        this.imStatus = (ImageView) this.rootView.findViewById(R.id.imStatus);
        this.txUsuario = (TextView) this.rootView.findViewById(R.id.txUsuario);
        this.txTitleUser = (TextView) this.rootView.findViewById(R.id.txTitleUser);
        this.txTitleDevBank = (TextView) this.rootView.findViewById(R.id.txTitleDevBank);
        this.txDevBank = (TextView) this.rootView.findViewById(R.id.txDevBank);
        this.txTitleDevTM = (TextView) this.rootView.findViewById(R.id.txTitleDevTM);
        this.txDevTM = (TextView) this.rootView.findViewById(R.id.txDevTM);
        this.txCodDevolucion = (TextView) this.rootView.findViewById(R.id.txCodDevolucion);
        this.txTitleDevBank.setVisibility(8);
        this.txDevBank.setVisibility(8);
        this.txTitleDevTM.setVisibility(8);
        this.txDevTM.setVisibility(8);
        this.titleDetallesPendiente = (TextView) this.rootView.findViewById(R.id.titleDetallesPendiente);
        this.txDescripcionPendiente = (TextView) this.rootView.findViewById(R.id.txDescripcionPendiente);
        this.titleDetallesPendiente.setVisibility(8);
        this.txDescripcionPendiente.setVisibility(8);
        this.btOk = (Button) this.rootView.findViewById(R.id.btOk);
        this.cdDetalles = (CardView) this.rootView.findViewById(R.id.cdDetalles);
        CardView cardView = (CardView) this.rootView.findViewById(R.id.cdPagoConfirmado);
        this.cdPagoConfirmado = cardView;
        cardView.setVisibility(8);
        this.btOk.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.vIGfHVEwb7.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                vIGfHVEwb7.this.dismiss();
            }
        });
        try {
            hLxHp3lKE9 hlxhp3lke9 = this.datos;
            if (hlxhp3lke9 != null) {
                if (hlxhp3lke9.getUsuario() != null && this.datos.getUsuario().length() > 0) {
                    this.txUsuario.setText(this.datos.getUsuario());
                } else {
                    this.txUsuario.setVisibility(8);
                    this.txTitleUser.setVisibility(8);
                }
                this.txEstado.setText(this.datos.getEstado().name());
                if (this.datos.getBanco() != null) {
                    switch (AnonymousClass2.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[this.datos.getBanco().ordinal()]) {
                        case 1:
                            this.txBanco.setText("Banco Popular de Ahorro");
                            this.ivBanco.setImageDrawable(this.tarjeta_bpa);
                            break;
                        case 2:
                            this.txBanco.setText("BANDEC");
                            this.ivBanco.setImageDrawable(this.tarjeta_bandec);
                            break;
                        case 3:
                            this.txBanco.setText("Metropolitano");
                            this.ivBanco.setImageDrawable(this.tarjeta_metro);
                            break;
                    }
                }
                switch (AnonymousClass2.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[this.datos.getEstado().ordinal()]) {
                    case 1:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.verde_oscuro2));
                        this.cdPagoConfirmado.setVisibility(0);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_devolucion));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.verde_oscuro3));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.verde_oscuro4));
                        this.txTitleDevBank.setVisibility(0);
                        this.txDevBank.setVisibility(0);
                        this.txTitleDevTM.setVisibility(0);
                        this.txDevTM.setVisibility(0);
                        this.txDevTM.setText(this.datos.getIdDevTM());
                        this.txDevBank.setText(this.datos.getIdDevBanco());
                        break;
                    case 2:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo));
                        this.ivIconoTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_abort));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.rojo3));
                        break;
                    case 3:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo));
                        this.ivIconoTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.rojo3));
                        break;
                    case 4:
                        this.ivIconoTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_pause));
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja));
                        this.cdPagoConfirmado.setVisibility(8);
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.naranja3));
                    case 5:
                        this.txEstado.setText("PENDIENTE");
                        this.ivIconoTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_pause));
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja));
                        this.cdPagoConfirmado.setVisibility(8);
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.naranja3));
                        break;
                }
                this.txImporte.setText(this.datos.getImoprte());
                this.txFecha.setText(this.datos.getFecha());
                this.txCodPago.setText(this.datos.getIdTercero());
                this.txCodDevolucion.setText(this.datos.getIdDevTercero());
                this.importe = this.datos.getImporte();
                if (this.datos.getDescripcion() != null && this.datos.getDescripcion().length() > 0) {
                    this.txDescripcionPendiente.setVisibility(0);
                    this.titleDetallesPendiente.setVisibility(0);
                    this.txDescripcionPendiente.setText(this.datos.getDescripcion());
                }
            }
        } catch (Exception ex) {
            Log.e(this.HEAD_LOG, ex.getMessage());
            dismiss();
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.vIGfHVEwb7$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT;

        static {
            int[] iArr = new int[SHYgXB9Dco.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco = iArr;
            try {
                iArr[SHYgXB9Dco.DEVUELTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.FALLIDO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.CANCELADO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.PENDIENTE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[SHYgXB9Dco.DEVUELTO_PENDIENTE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[wnGiwuD0kT.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT = iArr2;
            try {
                iArr2[wnGiwuD0kT.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[wnGiwuD0kT.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[wnGiwuD0kT.METRO.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public void loadDrawables() {
        Drawable drBPA = getResources().getDrawable(R.drawable.tarjeta_bpa);
        Bitmap bitmapBPA = ((BitmapDrawable) drBPA).getBitmap();
        this.tarjeta_bpa = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBPA, 80, 60, true));
        Drawable drBANDEC = getResources().getDrawable(R.drawable.tarjeta_bandec);
        Bitmap bitmapBANDEC = ((BitmapDrawable) drBANDEC).getBitmap();
        this.tarjeta_bandec = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapBANDEC, 80, 60, true));
        Drawable drMETRO = getResources().getDrawable(R.drawable.tarjeta_metro);
        Bitmap bitmapMetro = ((BitmapDrawable) drMETRO).getBitmap();
        this.tarjeta_metro = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapMetro, 80, 60, true));
    }
}
