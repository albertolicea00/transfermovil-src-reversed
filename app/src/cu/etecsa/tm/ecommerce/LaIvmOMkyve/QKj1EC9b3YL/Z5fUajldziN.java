package cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.SHYgXB9Dco;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.RagGNRA81qG.wnGiwuD0kT;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.V9CpxZJfIeK;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class Z5fUajldziN extends DialogFragment {
    public static final String DATOS_RESPONSE = "PAGO";
    public String HEAD_LOG = "Z5fUajldziN";
    public CardView btDevolver;
    public Button btOk;
    public CardView cdDetalles;
    public CardView cdEstado;
    public CardView cdPagoConfirmado;
    public V9CpxZJfIeK communicator;
    public Context context;
    public RKxbomWW57 datos;
    public ImageView imStatus;
    public float importe;
    public ImageView ivBanco;
    public ImageView ivIconoTM;
    public Fragment parent;
    public View rootView;
    public Drawable tarjeta_bandec;
    public Drawable tarjeta_bpa;
    public Drawable tarjeta_metro;
    public TextView titleDetallesPendiente;
    public TextView tvNoTM;
    public TextView tvNoTransacccion;
    public TextView txBanco;
    public TextView txCodPago;
    public TextView txDescripcion;
    public TextView txDescripcionPendiente;
    public TextView txDetalles;
    public TextView txEstado;
    public TextView txFecha;
    public TextView txIDTM;
    public TextView txIdTransaccion;
    public TextView txImporte;
    public TextView txTitleUser;
    public TextView txUsuario;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.a6xgxsasgdlfkc, container, false);
        loadDrawables();
        Bundle arg = getArguments();
        this.datos = (RKxbomWW57) arg.getSerializable("PAGO");
        return this.rootView;
    }

    public static Z5fUajldziN newInstance(RKxbomWW57 datos) {
        Z5fUajldziN frag = new Z5fUajldziN();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", datos);
        frag.setArguments(args);
        return frag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof V9CpxZJfIeK) {
            this.communicator = (V9CpxZJfIeK) context;
        } else {
            this.communicator = null;
        }
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
        this.tvNoTransacccion = (TextView) this.rootView.findViewById(R.id.tvNoTransacccion);
        this.txIdTransaccion = (TextView) this.rootView.findViewById(R.id.txIdTransaccion);
        this.txDetalles = (TextView) this.rootView.findViewById(R.id.txDetalles);
        this.txDescripcion = (TextView) this.rootView.findViewById(R.id.txDescripcion);
        this.ivIconoTM = (ImageView) this.rootView.findViewById(R.id.ivIconoTM);
        this.txFecha = (TextView) this.rootView.findViewById(R.id.txFecha);
        this.imStatus = (ImageView) this.rootView.findViewById(R.id.imStatus);
        this.tvNoTM = (TextView) this.rootView.findViewById(R.id.tvNoTM);
        this.txIDTM = (TextView) this.rootView.findViewById(R.id.txIDTM);
        this.txUsuario = (TextView) this.rootView.findViewById(R.id.txUsuario);
        this.txTitleUser = (TextView) this.rootView.findViewById(R.id.txTitleUser);
        this.titleDetallesPendiente = (TextView) this.rootView.findViewById(R.id.titleDetallesPendiente);
        this.txDescripcionPendiente = (TextView) this.rootView.findViewById(R.id.txDescripcionPendiente);
        this.titleDetallesPendiente.setVisibility(8);
        this.txDescripcionPendiente.setVisibility(8);
        this.btOk = (Button) this.rootView.findViewById(R.id.btOk);
        this.btDevolver = (CardView) this.rootView.findViewById(R.id.btDevolver);
        UhA7J2923N uhA7J2923N = UhA7J2923N.getInstance();
        ThptISKBHA thptISKBHA = ThptISKBHA.GESTIONAR_DEVOLUCION;
        if (!uhA7J2923N.checkUserPermission(thptISKBHA)) {
            this.btDevolver.setVisibility(4);
        }
        this.cdDetalles = (CardView) this.rootView.findViewById(R.id.cdDetalles);
        this.cdPagoConfirmado = (CardView) this.rootView.findViewById(R.id.cdPagoConfirmado);
        this.btDevolver.setVisibility(8);
        this.btOk.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.Z5fUajldziN.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Z5fUajldziN.this.dismiss();
            }
        });
        try {
            RKxbomWW57 rKxbomWW57 = this.datos;
            if (rKxbomWW57 != null) {
                this.txEstado.setText(rKxbomWW57.getEstado().name());
                if (this.datos.getBanco() != null) {
                    switch (AnonymousClass3.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[this.datos.getBanco().ordinal()]) {
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
                switch (AnonymousClass3.$SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco[this.datos.getEstado().ordinal()]) {
                    case 1:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.verde));
                        this.txIdTransaccion.setText(this.datos.getIdBanco());
                        this.txIDTM.setText(this.datos.getIdTM());
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_done_white));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.verde2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.verde3));
                        this.btDevolver.setVisibility(0);
                        this.btDevolver.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.Z5fUajldziN.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                Intent returnIntent = new Intent();
                                returnIntent.putExtra("PAGO", Z5fUajldziN.this.datos);
                                Z5fUajldziN z5fUajldziN = Z5fUajldziN.this;
                                V9CpxZJfIeK v9CpxZJfIeK = z5fUajldziN.communicator;
                                if (v9CpxZJfIeK != null) {
                                    v9CpxZJfIeK.mostrarDevolucion(z5fUajldziN.datos);
                                } else {
                                    try {
                                        z5fUajldziN.getTargetFragment().onActivityResult(Z5fUajldziN.this.getTargetRequestCode(), 2, returnIntent);
                                    } catch (Exception ex) {
                                        Log.e("TicketConfimacionPago", ex.getMessage());
                                    }
                                }
                                Z5fUajldziN.this.dismiss();
                            }
                        });
                        if (!UhA7J2923N.getInstance().checkUserPermission(thptISKBHA)) {
                            this.btDevolver.setVisibility(4);
                        }
                        break;
                    case 2:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo));
                        this.tvNoTransacccion.setVisibility(8);
                        this.ivIconoTM.setVisibility(8);
                        this.tvNoTM.setVisibility(8);
                        this.txIdTransaccion.setVisibility(8);
                        this.txIDTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_abort));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.rojo3));
                        break;
                    case 3:
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo));
                        this.tvNoTransacccion.setVisibility(8);
                        this.ivIconoTM.setVisibility(8);
                        this.tvNoTM.setVisibility(8);
                        this.txIdTransaccion.setVisibility(8);
                        this.txIDTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_block));
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.rojo2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.rojo3));
                        break;
                    case 4:
                        if (this.datos.getDescripcion() != null && this.datos.getDescripcion().length() > 0) {
                            this.txDescripcionPendiente.setVisibility(0);
                            this.titleDetallesPendiente.setVisibility(0);
                            this.txDescripcionPendiente.setText(this.datos.getDescripcion());
                        }
                        this.tvNoTransacccion.setVisibility(8);
                        this.ivIconoTM.setVisibility(8);
                        this.tvNoTM.setVisibility(8);
                        this.txIdTransaccion.setVisibility(8);
                        this.txIDTM.setVisibility(8);
                        this.imStatus.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_pause));
                        this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja));
                        this.cdPagoConfirmado.setVisibility(8);
                        this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.naranja2));
                        this.btOk.setBackgroundColor(this.context.getResources().getColor(R.color.naranja3));
                        break;
                }
                try {
                    if (this.datos.getUsuario() != null && this.datos.getUsuario().length() > 0) {
                        String[] datoU = this.datos.getUsuario().split("@");
                        this.txUsuario.setText(datoU[0]);
                    } else {
                        this.txUsuario.setVisibility(8);
                        this.txTitleUser.setVisibility(8);
                    }
                } catch (Exception e) {
                }
                this.txImporte.setText(this.datos.getImoprte());
                this.txFecha.setText(this.datos.getFecha());
                this.txCodPago.setText(this.datos.getIdTercero());
                this.txDetalles.setText(this.datos.getDescripcion());
                this.txDescripcion.setText(this.datos.getDetalles());
                this.importe = this.datos.getImporte();
            }
        } catch (Exception ex) {
            Log.e(this.HEAD_LOG, ex.getMessage());
            dismiss();
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.LaIvmOMkyve.QKj1EC9b3YL.Z5fUajldziN$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT;

        static {
            int[] iArr = new int[SHYgXB9Dco.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$SHYgXB9Dco = iArr;
            try {
                iArr[SHYgXB9Dco.PAGADO.ordinal()] = 1;
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
            int[] iArr2 = new int[wnGiwuD0kT.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT = iArr2;
            try {
                iArr2[wnGiwuD0kT.BPA.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[wnGiwuD0kT.BANDEC.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$I3ki0FxWzgdY$RagGNRA81qG$wnGiwuD0kT[wnGiwuD0kT.METRO.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
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
