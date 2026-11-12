package cu.etecsa.transfermovil.banking.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.DmvQBLZLbV;
import cu.etecsa.cubacel.tr.tm.B21UyndcVvF.yHdVJARBHM;
import cu.etecsa.cubacel.tr.tm.IHVTCBmiLV;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.banking.AuthValidator;
import cu.etecsa.transfermovil.core.enums.OperationType;
import cu.etecsa.transfermovil.banking.ui.OffersResultCallback;
import cu.etecsa.transfermovil.sms.OffersSmsTask;
import cu.etecsa.cubacel.tr.tm.S9ycHcoxAzy;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AOperKey;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.CompraBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRMiBoleto;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.V5FFEZ0Qrr0;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.HrLy23Pb9b;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.rDEl7rW1aN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
/** @obfuscated_class cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.x5ijzOU4VE */
public class MiBoletoListFragment extends AuthValidator implements DmvQBLZLbV.ViewHolder.ClickListener, OffersResultCallback {
    public FloatingActionButton actionButtonNuevo;
    public HrLy23Pb9b actionEntity;
    private ActionMode actionMode;
    public DmvQBLZLbV adapterCuentas;
    public Button btAcceder;
    public FloatingActionButton btnRefresh;
    public List<CompraBoleto> cLists;
    public Context context;
    public ConstraintLayout noAuthFragment;
    public Nl0yptXmjQ operationEntity;
    public RecyclerView rvFactura;
    public String titulo;
    public TextView txTextoAcceso;
    public rDEl7rW1aN bs = new rDEl7rW1aN();
    private ActionModeCallback actionModeCallback = new ActionModeCallback();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.or10ioszrj3es, container, false);
        this.context = container.getContext();
        FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.iButtonNuevo);
        this.actionButtonNuevo = floatingActionButton;
        floatingActionButton.setVisibility(8);
        this.actionButtonNuevo.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MiBoletoListFragment.this.cerrarSesion();
            }
        });
        this.actionButtonNuevo.setOnLongClickListener(new View.OnLongClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                v.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent event) {
                        switch (event.getActionMasked()) {
                            case 1:
                                view.setOnTouchListener(null);
                                break;
                            case 2:
                                view.setX(event.getRawX() - 120.0f);
                                view.setY(event.getRawY() - 425.0f);
                                break;
                        }
                        return true;
                    }
                });
                return true;
            }
        });
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.drawerList);
        this.rvFactura = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.rvFactura.setHasFixedSize(true);
        LinearLayoutManager llmFactura = new LinearLayoutManager(this.context);
        this.rvFactura.setLayoutManager(llmFactura);
        this.noAuthFragment = (ConstraintLayout) rootView.findViewById(R.id.noAuthFragment);
        this.txTextoAcceso = (TextView) rootView.findViewById(R.id.txTextoAcceso);
        Button button = (Button) rootView.findViewById(R.id.btAcceder);
        this.btAcceder = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiBoletoListFragment.this.showDialog();
            }
        });
        FloatingActionButton floatingActionButton2 = (FloatingActionButton) rootView.findViewById(R.id.btnRefresh);
        this.btnRefresh = floatingActionButton2;
        floatingActionButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MiBoletoListFragment.this.refreshData();
            }
        });
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        validate();
        new OffersSmsTask(getContext().getContentResolver(), this).execute(new Void[0]);
    }

    private void loadData(boolean isAutenticated) {
        if (isAutenticated) {
            this.noAuthFragment.setVisibility(8);
            this.rvFactura.setVisibility(0);
            this.actionButtonNuevo.setVisibility(0);
            this.btnRefresh.setVisibility(0);
            try {
                fillAdapter();
                return;
            } catch (Exception ex) {
                Log.e("TM_LOG", ex.getMessage());
                return;
            }
        }
        this.noAuthFragment.setVisibility(0);
        this.rvFactura.setVisibility(4);
        this.actionButtonNuevo.setVisibility(4);
        this.btnRefresh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        getActivity().getWindow().setFlags(16, 16);
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Actualizando boletos...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        new OffersSmsTask(getActivity().getContentResolver(), new OffersResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.5
            @Override
            public void onSetProgressBarVisibility(int visibility) {
            }

            @Override
            public void onOfertasResult(final boolean success, int count, String message) {
                new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProgressDialog progressDialog2 = progressDialog;
                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                            progressDialog.dismiss();
                        }
                        MiBoletoListFragment.this.getActivity().getWindow().clearFlags(16);
                        MiBoletoListFragment.this.fillAdapter();
                        if (success) {
                            MiBoletoListFragment.this.showMessage("Datos actualizados correctamente.");
                        } else {
                            MiBoletoListFragment.this.showMessage("Datos actualizados");
                        }
                    }
                }, 3000L);
            }
        }).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessage(String message) {
        new AlertDialog.Builder(this.context).setMessage(message).setPositiveButton("Aceptar", null).setCancelable(false).show();
    }

    public void fillAdapter() {
        unYp8VQThY.init(this.context);
        List<yHdVJARBHM> itemsList = new ArrayList<>();
        List<CompraBoleto> allMiBoletoCompraLists = unYp8VQThY.getInstance().getAllMiBoletoCompraLists();
        this.cLists = allMiBoletoCompraLists;
        for (CompraBoleto uyh0pxs9m37in : allMiBoletoCompraLists) {
            yHdVJARBHM iDB = new yHdVJARBHM(uyh0pxs9m37in.getId(), uyh0pxs9m37in.getIdOferta(), uyh0pxs9m37in.getEstado(), uyh0pxs9m37in.isConsumido());
            itemsList.add(iDB);
        }
        DmvQBLZLbV dmvQBLZLbV = new DmvQBLZLbV(this, itemsList, getActivity(), this.context);
        this.adapterCuentas = dmvQBLZLbV;
        this.rvFactura.setAdapter(dmvQBLZLbV);
    }

    @Override
    public void onItemClicked(int position) {
        if (this.actionMode != null) {
            toggleSelection(position);
            return;
        }
        CompraBoleto ticket = this.cLists.get(position);
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        MiBoletoEditFragment tcTicketFragment = new MiBoletoEditFragment();
        Bundle b = new Bundle();
        b.putString("id", String.valueOf(ticket.getId()));
        tcTicketFragment.setArguments(b);
        mFragmentTransaction.replace(R.id.containerView, tcTicketFragment).addToBackStack(null).commit();
    }

    private void toggleSelection(int position) {
        this.adapterCuentas.toggleSelection(position);
        int count = this.adapterCuentas.getSelectedItemCount();
        if (count == 0) {
            this.actionMode.finish();
        } else {
            this.actionMode.setTitle(String.valueOf(count));
            this.actionMode.invalidate();
        }
    }

    @Override
    public boolean onItemLongClicked(int position) {
        if (this.actionMode == null) {
            this.actionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(this.actionModeCallback);
        }
        toggleSelection(position);
        return true;
    }

    @Override
    public boolean showQR(int position) {
        CompraBoleto miCuenta = unYp8VQThY.getInstance().getBoletoListWithID(this.cLists.get(position).getId());
        List<QRMiBoleto.DetalleAdicional> detallesList = parseDetallesFromTicket(miCuenta.getDatos());
        showQRDetailsDialog(miCuenta, detallesList);
        return true;
    }

    private void showQRDetailsDialog(final CompraBoleto ticket, final List<QRMiBoleto.DetalleAdicional> detallesList) {
        try {
            if (detallesList.isEmpty()) {
                Toast.makeText(this.context, "No hay atracciones disponibles", 0).show();
                Bitmap qrBitmap = createCustomQR(ticket, null);
                showDialogQR(qrBitmap);
                return;
            }
            String[] descripciones = new String[detallesList.size()];
            for (int i = 0; i < detallesList.size(); i++) {
                descripciones[i] = detallesList.get(i).getDescripcion();
            }
            final int[] seleccion = {-1};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("Seleccione el detalle para el QR");
            builder.setCancelable(false);
            builder.setSingleChoiceItems(descripciones, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    MiBoletoListFragment.lambda$showQRDetailsDialog$0(seleccion, dialogInterface, i2);
                }
            });
            builder.setPositiveButton("Generar QR", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    MiBoletoListFragment.this.lambda$showQRDetailsDialog$1(seleccion, detallesList, ticket, dialogInterface, i2);
                }
            });
            builder.setNegativeButton("Cancelar", null);
            builder.show();
        } catch (Exception e) {
            Toast.makeText(this.context, "Error al procesar detalles", 0).show();
            Log.e("QR_SELECTION", "Error en showQRDetailsDialog", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showQRDetailsDialog$0(int[] seleccion, DialogInterface dialog, int which) {
        seleccion[0] = which;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showQRDetailsDialog$1(int[] seleccion, List detallesList, CompraBoleto ticket, DialogInterface dialog, int which) {
        if (seleccion[0] == -1) {
            Toast.makeText(this.context, "Debe seleccionar un detalle", 0).show();
            return;
        }
        List<QRMiBoleto.DetalleAdicional> seleccionadosList = new ArrayList<>();
        seleccionadosList.add((QRMiBoleto.DetalleAdicional) detallesList.get(seleccion[0]));
        Bitmap qrBitmap = createCustomQR(ticket, seleccionadosList);
        showDialogQR(qrBitmap);
    }

    private Bitmap createCustomQR(CompraBoleto ticket, List<QRMiBoleto.DetalleAdicional> detallesSeleccionados) {
        try {
            String data = ticket.getToken();
            String transaccionTM = ticket.getIdTransaccion();
            byte[] salt = ticket.getIdTransferencia().getBytes("UTF-8");
            String vSer = V5FFEZ0Qrr0.decryptMonedasWallet(data, transaccionTM, salt, 2);
            String[] list = vSer.split("\\|");
            QRMiBoleto qrData = new QRMiBoleto();
            qrData.setPin(list[1]);
            qrData.setToken(list[0]);
            qrData.setCi(ticket.getCi());
            if (detallesSeleccionados != null && !detallesSeleccionados.isEmpty()) {
                qrData.setDetallesAdicionales(detallesSeleccionados);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonQR = gson.toJson(qrData);
            Log.d("QR_JSON", jsonQR);
            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_etecsa_rectangle);
            Bitmap qr = ZUoEY89WdA.ProductLogo(icon, jsonQR, false, R.color.primaryDarkColor);
            return Bitmap.createScaledBitmap(qr, 700, 700, false);
        } catch (Exception e) {
            Log.e("QR_ERROR", "Error al generar QR", e);
            return null;
        }
    }

    private List<QRMiBoleto.DetalleAdicional> parseDetallesFromTicket(String datosTicket) {
        List<QRMiBoleto.DetalleAdicional> detalles = new ArrayList<>();
        if (datosTicket == null || datosTicket.isEmpty()) {
            return detalles;
        }
        try {
            String[] elementos = datosTicket.split("\\|");
            for (String elemento : elementos) {
                String[] partes = elemento.trim().split(";");
                if (partes.length >= 4) {
                    String valor = partes[2].trim();
                    if (!valor.equals("0")) {
                        QRMiBoleto.DetalleAdicional detalle = new QRMiBoleto.DetalleAdicional();
                        detalle.setId(partes[0].trim());
                        detalle.setDescripcion(partes[1].trim());
                        detalle.setValor(valor);
                        detalle.setMoneda(partes[3].trim());
                        detalles.add(detalle);
                    }
                }
            }
        } catch (Exception e) {
            Log.e("PARSE_ERROR", "Error al parsear detalles", e);
        }
        return detalles;
    }

    private void showDialogQR(Bitmap bm) {
        try {
            Dialog settingsDialog = new Dialog(this.context);
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            View v = inflater.inflate(R.layout.qtpdr8ekovu2m, (ViewGroup) null);
            ImageView iv = (ImageView) v.findViewById(R.id.profile_img_popup);
            iv.setImageBitmap(bm);
            settingsDialog.getWindow().requestFeature(1);
            settingsDialog.setContentView(v);
            settingsDialog.show();
        } catch (Exception e) {
            Toast.makeText(this.context, "Error, vuelva a intentarlo", 0).show();
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment$8, reason: invalid class name */
    /* JADX INFO: Access modifiers changed from: private */
    public void validate() {
        Nl0yptXmjQ nl0yptXmjQ = Nl0yptXmjQ.Ticket_MiBoleto_Gestion;
        switch (validateAuth(OperationType.Ticket_MiBoleto_Gestion)) {
            case NO_AUTH:
                this.actionEntity = HrLy23Pb9b.AUTENTICAR;
                this.operationEntity = nl0yptXmjQ;
                this.titulo = "MiBoleto";
                loadData(false);
                break;
            case NO_REGISTRADO:
                this.actionEntity = HrLy23Pb9b.REGISTRO;
                this.operationEntity = nl0yptXmjQ;
                this.titulo = "MiBoleto";
                loadData(false);
                break;
            case AUTH_OK:
                loadData(true);
                break;
            case ERRO_AUTH:
                loadData(false);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == 1) {
                loadData(true);
            }
            if (resultCode == 2) {
                loadData(true);
            }
            if (resultCode == 3) {
                this.actionEntity = HrLy23Pb9b.REGISTRO;
                loadData(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            GRGvmCZD7R dialogFrag = GRGvmCZD7R.newInstance(this.operationEntity, this.actionEntity, this.titulo);
            dialogFrag.setTargetFragment(this, 1);
            dialogFrag.setCancelable(false);
            dialogFrag.show(getFragmentManager(), "fragment_PAGO");
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cerrarSesion() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.context);
        builder.setTitle("Confirme");
        builder.setMessage("¿Desea cerrar la sección? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                AOperKey key = unYp8VQThY.getInstance().getAOperKey(Nl0yptXmjQ.Ticket_MiBoleto_Gestion);
                key.setAuth(false);
                unYp8VQThY.getInstance().updateAOperKey(key);
                MiBoletoListFragment.this.validate();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
    }

    @Override
    public void onOfertasResult(boolean success, int count, String message) {
    }

    public class ActionModeCallback implements ActionMode.Callback {
        public ActionModeCallback() {
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(final ActionMode mode, MenuItem uyh0pxs9m37in) {
            switch (uyh0pxs9m37in.getItemId()) {
                case R.id.menu_remove /* 2131297160 */:
                    AlertDialog.Builder builder = new AlertDialog.Builder(MiBoletoListFragment.this.context);
                    builder.setTitle(R.string.confirm);
                    builder.setMessage(R.string.confirm_delete);
                    builder.setPositiveButton("SI", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.c69cvBqjXKw.MiBoletoListFragment.ActionModeCallback.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Iterator<Integer> it = MiBoletoListFragment.this.adapterCuentas.getSelectedItems().iterator();
                            while (it.hasNext()) {
                                int pos = it.next().intValue();
                                unYp8VQThY.init(MiBoletoListFragment.this.context);
                                CompraBoleto cRemove = MiBoletoListFragment.this.cLists.get(pos);
                                cRemove.setConsumido(true);
                                unYp8VQThY.getInstance().updateCompraMiboleto(cRemove);
                            }
                            DmvQBLZLbV dmvQBLZLbV = MiBoletoListFragment.this.adapterCuentas;
                            dmvQBLZLbV.removeItems(dmvQBLZLbV.getSelectedItems());
                            if (MiBoletoListFragment.this.getActivity() instanceof IHVTCBmiLV) {
                                ((IHVTCBmiLV) MiBoletoListFragment.this.getActivity()).UpdateMenu();
                            } else if (MiBoletoListFragment.this.getActivity() instanceof S9ycHcoxAzy) {
                                ((S9ycHcoxAzy) MiBoletoListFragment.this.getActivity()).UpdateMenu();
                            }
                            mode.finish();
                        }
                    });
                    builder.setNegativeButton("NO", null);
                    builder.show();
                    return true;
                default:
                    return false;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            MiBoletoListFragment.this.adapterCuentas.clearSelection();
            MiBoletoListFragment.this.actionMode = null;
        }
    }
}
