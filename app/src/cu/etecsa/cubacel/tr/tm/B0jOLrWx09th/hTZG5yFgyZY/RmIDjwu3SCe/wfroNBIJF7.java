package cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.QRData;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class wfroNBIJF7 extends Fragment implements pAzq93vIl3.UssdResponseObserver {
    private static final int CAMERA_PERMISSION_REQUEST = 101;
    private static final String TAG = "QRScanner";
    private BarcodeScanner barcodeScanner;
    private Button btnAceptar;
    private ExecutorService cameraExecutor;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    public Context context;
    private EditText etMonto;
    private FloatingActionButton fabLeerQR;
    private RelativeLayout mainContainer;
    public pAzq93vIl3 manager;
    private LinearLayout montoContainer;
    private PreviewView previewView;
    private ImageAnalysis.Analyzer qrAnalyzer;
    private QRData qrData;
    private List<QRData.DetalleAdicional> qrDetalles;
    private ImageView qrFrame;
    private View resultsCard;
    public View rootView;
    private TextView tvDetalles;
    private TextView tvMoneda;
    public int MAX_PARAMETERS_PQUETE = 4;
    private String currentMoneda = null;
    private boolean isScanning = false;
    public boolean isPartialUSSD = false;
    public boolean isDirectScan = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.vige6640tcqli, container, false);
        this.context = container.getContext();
        this.previewView = (PreviewView) this.rootView.findViewById(R.id.preview_view);
        this.tvDetalles = (TextView) this.rootView.findViewById(R.id.tv_detalles);
        this.etMonto = (EditText) this.rootView.findViewById(R.id.et_monto);
        this.tvMoneda = (TextView) this.rootView.findViewById(R.id.tv_moneda);
        this.btnAceptar = (Button) this.rootView.findViewById(R.id.btn_aceptar);
        this.montoContainer = (LinearLayout) this.rootView.findViewById(R.id.monto_container);
        this.resultsCard = this.rootView.findViewById(R.id.results_card);
        this.fabLeerQR = (FloatingActionButton) this.rootView.findViewById(R.id.fab_leer_qr);
        this.mainContainer = (RelativeLayout) this.rootView.findViewById(R.id.main_container);
        this.qrFrame = (ImageView) this.rootView.findViewById(R.id.qr_frame);
        this.tvDetalles.setText("Detalles: No escaneados");
        this.montoContainer.setVisibility(8);
        this.btnAceptar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.fabLeerQR.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        BarcodeScannerOptions options = new BarcodeScannerOptions.Builder().setBarcodeFormats(RecyclerView.ViewHolder.FLAG_TMP_DETACHED, new int[0]).build();
        this.barcodeScanner = BarcodeScanning.getClient(options);
        this.cameraExecutor = Executors.newSingleThreadExecutor();
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View v) {
        if (this.currentMoneda != null) {
            String monto = this.etMonto.getText().toString();
            if (monto.isEmpty()) {
                this.etMonto.setError(this.context.getString(R.string.hint_campo_vacio));
                requestFocus(this.etMonto);
                return;
            } else {
                SubmitForm(monto);
                return;
            }
        }
        SubmitForm(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View v) {
        reiniciarEscaneo();
    }

    private void reiniciarEscaneo() {
        this.tvDetalles.setText("Detalles: No escaneados");
        this.etMonto.setText(BuildConfig.FLAVOR);
        this.montoContainer.setVisibility(8);
        this.currentMoneda = null;
        stopScanner();
        showScanner();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkCameraPermission();
    }

    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
            navigateBack();
        } else {
            startScanner();
        }
    }

    private void SubmitForm(String monto) {
        String str = this.currentMoneda;
        if (str != null && !"-".equals(str)) {
            try {
                double montoValue = Double.parseDouble(monto);
                if (montoValue > 0.0d && !String.format(Locale.US, "%.3f", Double.valueOf(montoValue)).matches("0+[.,]?0*")) {
                    double maxPermitido = obtenerMaximoPermitido(this.currentMoneda);
                    if (maxPermitido > 0.0d && montoValue > maxPermitido) {
                        this.etMonto.setError(this.context.getString(R.string.hint_max_permitido) + " " + maxPermitido + " " + this.currentMoneda);
                        requestFocus(this.etMonto);
                        return;
                    }
                }
                this.etMonto.setError(this.context.getString(R.string.hint_monto_cero));
                requestFocus(this.etMonto);
                return;
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Monto no válido", 0).show();
                return;
            }
        }
        String str2 = this.currentMoneda;
        if (str2 != null && "-".equals(str2)) {
            try {
                int cantidad = Integer.parseInt(monto);
                if (cantidad <= 0) {
                    this.etMonto.setError(this.context.getString(R.string.hint_monto_cero));
                    requestFocus(this.etMonto);
                    return;
                }
                int maxPermitido2 = obtenerCantidadMaximaPermitida();
                if (maxPermitido2 > 0 && cantidad > maxPermitido2) {
                    this.etMonto.setError(this.context.getString(R.string.hint_max_permitido) + " " + maxPermitido2);
                    requestFocus(this.etMonto);
                    return;
                }
            } catch (NumberFormatException e2) {
                Toast.makeText(getContext(), "Cantidad no válida", 0).show();
                return;
            }
        }
        String cadena = this.qrData.getCi() + "*" + this.qrData.getPin() + "*" + this.qrData.getToken() + "*" + this.qrDetalles.get(0).getId() + "*" + this.etMonto.getText().toString();
        ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.results_card);
        FBsQzP3Zfj.actionCallUSSDBack(this.context, "119", cadena, "¿Desea validar el boleto?", group, getFragmentManager());
    }

    private double obtenerMaximoPermitido(String moneda) {
        QRData qRData = this.qrData;
        if (qRData == null || qRData.getDetallesAdicionales() == null) {
            return 0.0d;
        }
        Iterator<QRData.DetalleAdicional> it = this.qrData.getDetallesAdicionales().iterator();
        while (it.hasNext()) {
            QRData.DetalleAdicional detalle = it.next();
            if (moneda.equals(detalle.getMoneda()) && detalle.getValor() != null) {
                try {
                    return Double.parseDouble(detalle.getValor());
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Error al parsear valor: " + detalle.getValor());
                }
            }
        }
        return 0.0d;
    }

    private int obtenerCantidadMaximaPermitida() {
        QRData qRData = this.qrData;
        if (qRData == null || qRData.getDetallesAdicionales() == null) {
            return 0;
        }
        Iterator<QRData.DetalleAdicional> it = this.qrData.getDetallesAdicionales().iterator();
        while (it.hasNext()) {
            QRData.DetalleAdicional detalle = it.next();
            if ("-".equals(detalle.getMoneda()) && detalle.getValor() != null) {
                try {
                    return Integer.parseInt(detalle.getValor());
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Error al parsear cantidad: " + detalle.getValor());
                }
            }
        }
        return 0;
    }

    private void startScanner() {
        if (this.isScanning) {
            return;
        }
        this.isScanning = true;
        ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(requireContext());
        this.cameraProviderFuture = processCameraProvider;
        processCameraProvider.addListener(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startScanner$2();
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScanner$2() {
        try {
            ProcessCameraProvider cameraProvider = this.cameraProviderFuture.get();
            Preview preview = new Preview.Builder().build();
            preview.setSurfaceProvider(this.previewView.getSurfaceProvider());
            ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().setTargetResolution(new Size(1280, 720)).setBackpressureStrategy(0).build();
            float scanAreaLeft = (1.0f - 0.8f) / 2.0f;
            float scanAreaTop = (1.0f - 0.5f) / 2.0f;
            RectF scanArea = new RectF(scanAreaLeft, scanAreaTop, scanAreaLeft + 0.8f, scanAreaTop + 0.5f);
            if (this.qrAnalyzer == null) {
                this.qrAnalyzer = new AnonymousClass1(scanArea);
            }
            imageAnalysis.setAnalyzer(this.cameraExecutor, this.qrAnalyzer);
            CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(1).build();
            cameraProvider.unbindAll();
            cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis);
        } catch (Exception e) {
            Log.e(TAG, "Error al inicializar la cámara", e);
            this.isScanning = false;
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageAnalysis.Analyzer {
        public final /* synthetic */ RectF val$scanArea;

        @Override // androidx.camera.core.ImageAnalysis.Analyzer
        public /* synthetic */ Size getDefaultTargetResolution() {
            return ImageAnalysis.Analyzer.CC.$default$getDefaultTargetResolution(this);
        }

        public AnonymousClass1(RectF rectF) {
            this.val$scanArea = rectF;
        }

        @Override // androidx.camera.core.ImageAnalysis.Analyzer
        public void analyze(final ImageProxy imageProxy) {
            if (!wfroNBIJF7.this.isScanning) {
                imageProxy.close();
                return;
            }
            InputImage image = InputImage.fromMediaImage(imageProxy.getImage(), imageProxy.getImageInfo().getRotationDegrees());
            Task<List<Barcode>> taskProcess = wfroNBIJF7.this.barcodeScanner.process(image);
            final RectF rectF = this.val$scanArea;
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$1$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$analyze$1(rectF, imageProxy, (List) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$1$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    wfroNBIJF7.AnonymousClass1.lambda$analyze$2(imageProxy, exc);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$analyze$1(RectF scanArea, ImageProxy imageProxy, List barcodes) {
            Point[] corners;
            Iterator it = barcodes.iterator();
            while (it.hasNext()) {
                Barcode barcode = (Barcode) it.next();
                final String rawValue = barcode.getRawValue();
                if (rawValue != null && (corners = barcode.getCornerPoints()) != null && isInsideScanArea(corners, scanArea, imageProxy)) {
                    wfroNBIJF7.this.isScanning = false;
                    wfroNBIJF7.this.getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$analyze$0(rawValue);
                        }
                    });
                    break;
                }
            }
            imageProxy.close();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$analyze$0(String rawValue) {
            wfroNBIJF7.this.processScannedQR(rawValue);
        }

        public static /* synthetic */ void lambda$analyze$2(ImageProxy imageProxy, Exception e) {
            Log.e(wfroNBIJF7.TAG, "Error al escanear código QR", e);
            imageProxy.close();
        }

        public final boolean isInsideScanArea(Point[] corners, RectF relativeScanArea, ImageProxy imageProxy) {
            int imageWidth = imageProxy.getWidth();
            int imageHeight = imageProxy.getHeight();
            Rect imageScanArea = new Rect((int) (relativeScanArea.left * imageWidth), (int) (relativeScanArea.top * imageHeight), (int) (relativeScanArea.right * imageWidth), (int) (relativeScanArea.bottom * imageHeight));
            for (Point corner : corners) {
                if (corner != null && !imageScanArea.contains(corner.x, corner.y)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processScannedQR(String jsonString) {
        try {
            Log.d(TAG, "QR escaneado: " + jsonString);
            if (jsonString != null && !jsonString.trim().isEmpty()) {
                if (!isValidJson(jsonString)) {
                    showErrorMessage("Formato de QR no reconocido", false);
                    return;
                }
                QRData qRData = (QRData) new Gson().fromJson(jsonString, QRData.class);
                this.qrData = qRData;
                this.qrDetalles = qRData.getDetallesAdicionales();
                if (this.qrData.getPin() != null && this.qrData.getToken() != null && this.qrData.getCi() != null) {
                    List<QRData.DetalleAdicional> list = this.qrDetalles;
                    if (list != null && list.size() > 1) {
                        showErrorMessage("Este QR contiene múltiples atracciones. Por favor seleccione una específica.", true);
                        return;
                    } else if (this.qrDetalles == null) {
                        showErrorMessage("Este QR no contiene atracciones. Por favor muestre un QR válido.", true);
                        return;
                    } else {
                        requireActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$processScannedQR$3();
                            }
                        });
                        return;
                    }
                }
                showErrorMessage("QR no contiene datos válidos (falta PIN o Token).", false);
                return;
            }
            showErrorMessage("QR vacío o no válido", false);
        } catch (Exception e) {
            Log.e(TAG, "Error al procesar QR: " + e.getMessage());
            showErrorMessage("Error al procesar QR", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processScannedQR$3() {
        showValidQRResults(this.qrData);
    }

    private boolean isValidJson(String json) {
        try {
            new Gson().fromJson(json, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    private void navigateBack() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$navigateBack$4();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$navigateBack$4() {
        if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            getActivity().onBackPressed();
        }
    }

    private void showErrorMessage(final String message, final boolean restartScan) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        final ViewGroup group = (ViewGroup) this.rootView.findViewById(R.id.results_card);
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showErrorMessage$6(group, message, restartScan);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorMessage$6(ViewGroup group, final String message, final boolean restartScan) {
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle("Atención");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showErrorMessage$5(message, restartScan, dialogInterface, i);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        Button positiveButton = dialog.getButton(-1);
        if (positiveButton != null) {
            positiveButton.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorMessage$5(String message, boolean restartScan, DialogInterface dialog, int which) {
        dialog.dismiss();
        handleErrorActions(message, restartScan);
    }

    private void handleErrorActions(final String message, final boolean restartScan) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleErrorActions$7(message, restartScan);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleErrorActions$7(String message, boolean restartScan) {
        if (message.contains("Formato de QR no reconocido") || message.contains("QR no contiene datos válidos")) {
            navigateBack();
        } else if (restartScan) {
            reiniciarEscaneo();
        }
    }

    private void showValidQRResults(final QRData qrData) {
        if (getActivity() == null || getActivity().isFinishing()) {
            Log.w(TAG, "Activity no disponible, no se pueden mostrar resultados");
        } else {
            getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.RmIDjwu3SCe.wfroNBIJF7$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showValidQRResults$8(qrData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showValidQRResults$8(QRData qrData) {
        try {
            if (qrData == null) {
                showErrorMessage("Datos QR inválidos", true);
                return;
            }
            StringBuilder detalles = new StringBuilder();
            this.currentMoneda = null;
            if (qrData.getDetallesAdicionales() != null && !qrData.getDetallesAdicionales().isEmpty()) {
                for (QRData.DetalleAdicional detalle : qrData.getDetallesAdicionales()) {
                    try {
                        detalles.append("• ");
                        String descripcion = detalle.getDescripcion();
                        String valor = BuildConfig.FLAVOR;
                        detalles.append(descripcion != null ? detalle.getDescripcion() : BuildConfig.FLAVOR);
                        detalles.append(": ");
                        if (detalle.getValor() != null) {
                            valor = detalle.getValor();
                        }
                        detalles.append(valor);
                        if (detalle.getMoneda() != null && !"-".equals(detalle.getMoneda())) {
                            detalles.append(" ");
                            detalles.append(detalle.getMoneda());
                        }
                        detalles.append("\n");
                        if (detalle.getMoneda() != null && !detalle.getMoneda().isEmpty()) {
                            this.currentMoneda = detalle.getMoneda();
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Error formateando detalle: " + e.getMessage());
                        detalles.append("• [Error mostrando este detalle]\n");
                    }
                }
            } else {
                detalles.append("No hay detalles adicionales");
            }
            this.tvDetalles.setText(detalles.toString());
            String str = this.currentMoneda;
            if (str != null) {
                if ("-".equals(str)) {
                    this.etMonto.setHint("Cantidad");
                    this.etMonto.setInputType(2);
                    this.tvMoneda.setVisibility(8);
                } else {
                    this.etMonto.setHint("Monto");
                    this.etMonto.setInputType(8194);
                    this.tvMoneda.setText(this.currentMoneda);
                    this.tvMoneda.setVisibility(0);
                }
                this.montoContainer.setVisibility(0);
            } else {
                this.montoContainer.setVisibility(8);
            }
            showResults();
        } catch (Exception e2) {
            Log.e(TAG, "Error inesperado en showValidQRResults: " + e2.getMessage());
            showErrorMessage("Error mostrando resultados", true);
        }
    }

    private void stopScanner() {
        this.isScanning = false;
        try {
            ListenableFuture<ProcessCameraProvider> listenableFuture = this.cameraProviderFuture;
            if (listenableFuture != null) {
                ProcessCameraProvider cameraProvider = listenableFuture.get();
                cameraProvider.unbindAll();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error al detener la cámara", e);
        }
    }

    private void showScanner() {
        this.mainContainer.setBackgroundColor(ContextCompat.getColor(this.context, android.R.color.black));
        this.previewView.setVisibility(0);
        this.qrFrame.setVisibility(0);
        this.resultsCard.setVisibility(8);
        this.fabLeerQR.setVisibility(8);
        startScanner();
    }

    private void showResults() {
        this.mainContainer.setBackgroundColor(ContextCompat.getColor(this.context, android.R.color.white));
        this.previewView.setVisibility(8);
        this.qrFrame.setVisibility(8);
        this.resultsCard.setVisibility(0);
        this.fabLeerQR.setVisibility(0);
        stopScanner();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PreviewView previewView = this.previewView;
        if (previewView != null && previewView.getVisibility() == 0) {
            startScanner();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BarcodeScanner barcodeScanner = this.barcodeScanner;
        if (barcodeScanner != null) {
            barcodeScanner.close();
        }
        ExecutorService executorService = this.cameraExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(5);
        }
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onUssdResponseReceived(String response) {
    }

    @Override // cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FY4jCHXwyiP.ZJaneAnYYBm.pAzq93vIl3.UssdResponseObserver
    public void onCloseAndBack() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
            if (this.isPartialUSSD && this.isDirectScan) {
                fragmentManager.popBackStack();
            }
        } catch (Exception e) {
            try {
                getActivity().onBackPressed();
            } catch (Exception e2) {
            }
        }
    }
}
