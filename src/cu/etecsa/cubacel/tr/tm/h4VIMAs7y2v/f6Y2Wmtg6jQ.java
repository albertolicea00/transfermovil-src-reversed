package cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$GetContent;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.UTk9UWZYxf;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.xpc0ejPtmZ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.H0oV6Ot0bS;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Wwc5crW71D;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.cdINOtQ3iN;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.x12rSjPY6pZ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.ivq3YYEGPZM.kE6CyiKsVrS.b0kkzvOCEu;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.DrR0lEVP3qk.gCOrME2HrQt.iN1lHDKE5h;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.ZDkigMAIBm;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.h79qmyRfm3;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: loaded from: classes.dex */
public class f6Y2Wmtg6jQ extends Fragment implements ZXingScannerView.ResultHandler {
    private static final String TAG = "f6Y2Wmtg6jQ";
    private FragmentActivity activity;
    private R1sDOSqZ2z agencia;
    private AppConfig appconfig;
    private BarcodeScanner barcodeScanner;
    private Camera camera;
    private ExecutorService cameraExecutor;
    private ysmUbWW79P communicador;
    private String contenidoQR;
    private Context context;
    private h79qmyRfm3 externosEntity;
    private ImageButton flashButton;
    public BarcodeFormat formatoQR;
    private ActivityResultLauncher<String> galleryLauncher;
    private ImageButton importButton;
    private ZXingScannerView mScannerview;
    private Nl0yptXmjQ operacion;
    private ActivityResultLauncher<String[]> permissionLauncher;
    private PreviewView previewView;
    private ImageButton rotateButton;
    private boolean isScanning = false;
    public int payType = 0;
    private boolean isFlashOn = false;
    private int lensFacing = 1;

    public f6Y2Wmtg6jQ(ysmUbWW79P communicador) {
        this.communicador = communicador;
    }

    public f6Y2Wmtg6jQ() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        AppConfig appConfigListWithId = unYp8VQThY.getInstance().getAppConfigListWithId(1);
        this.appconfig = appConfigListWithId;
        if (!appConfigListWithId.isActivarMejoraQR()) {
            view = createViewQRNEW(inflater, container);
        } else {
            view = createViewQROLD();
        }
        initializeLaunchers();
        this.context = getContext();
        Bundle arg = getArguments();
        if (arg != null) {
            if (arg.containsKey("Nl0yptXmjQ")) {
                this.operacion = (Nl0yptXmjQ) arg.getSerializable("Nl0yptXmjQ");
            }
            if (arg.containsKey("R1sDOSqZ2z")) {
                this.agencia = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
            }
            if (arg.containsKey("h79qmyRfm3")) {
                this.externosEntity = (h79qmyRfm3) arg.getSerializable("h79qmyRfm3");
            }
            if (arg.containsKey("PayType")) {
                this.payType = arg.getInt("PayType");
            }
            if (arg.containsKey("TransferType")) {
                this.payType = arg.getInt("TransferType");
            }
        }
        return view;
    }

    private void initializeLaunchers() {
        Log.d(TAG, "initializeLaunchers: Inicializando launchers");
        this.galleryLauncher = registerForActivityResult(new ActivityResultContracts$GetContent(), new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda21
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$initializeLaunchers$0((Uri) obj);
            }
        });
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda22
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$initializeLaunchers$1((Map) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeLaunchers$0(Uri uri) {
        if (uri != null) {
            decodeQRFromGallery(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeLaunchers$1(Map permissions) {
        boolean allGranted = true;
        for (Boolean granted : permissions.values()) {
            if (!granted.booleanValue()) {
                allGranted = false;
                break;
            }
        }
        if (allGranted) {
            this.galleryLauncher.launch("image/*");
        } else {
            Toast.makeText(getContext(), "Permiso necesario para acceder a la galería", 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!this.appconfig.isActivarMejoraQR()) {
            startCamera();
        }
    }

    private View createViewQRNEW(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.d8lidrvknrdj58, container, false);
        this.previewView = (PreviewView) view.findViewById(R.id.preview_view);
        this.flashButton = (ImageButton) view.findViewById(R.id.flash_button);
        this.rotateButton = (ImageButton) view.findViewById(R.id.rotate_button);
        this.importButton = (ImageButton) view.findViewById(R.id.import_button);
        setupButtonListeners();
        this.cameraExecutor = Executors.newSingleThreadExecutor();
        this.activity = getActivity();
        BarcodeScannerOptions options = new BarcodeScannerOptions.Builder().setBarcodeFormats(RecyclerView.ViewHolder.FLAG_TMP_DETACHED, new int[0]).build();
        this.barcodeScanner = BarcodeScanning.getClient(options);
        getParentFragmentManager().setFragmentResultListener("returnToA", this, new FragmentResultListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda3
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                this.f$0.lambda$createViewQRNEW$2(str, bundle);
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createViewQRNEW$2(String requestKey, Bundle result) {
        getParentFragmentManager().popBackStack();
    }

    private void setupButtonListeners() {
        ImageButton imageButton = this.flashButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupButtonListeners$3(view);
                }
            });
        }
        ImageButton imageButton2 = this.rotateButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupButtonListeners$4(view);
                }
            });
        }
        ImageButton imageButton3 = this.importButton;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupButtonListeners$5(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupButtonListeners$3(View v) {
        toggleFlash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupButtonListeners$4(View v) {
        rotateCamera();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupButtonListeners$5(View v) {
        openGallery();
    }

    private void toggleFlash() {
        Camera camera = this.camera;
        if (camera != null) {
            CameraControl cameraControl = camera.getCameraControl();
            if (this.isFlashOn) {
                cameraControl.enableTorch(false);
                this.flashButton.setImageResource(R.drawable.ic_flash_off);
                this.isFlashOn = false;
            } else {
                cameraControl.enableTorch(true);
                this.flashButton.setImageResource(R.drawable.ic_flash_on);
                this.isFlashOn = true;
            }
        }
    }

    private void rotateCamera() {
        int i;
        if (this.lensFacing == 1) {
            i = 0;
        } else {
            i = 1;
        }
        this.lensFacing = i;
        stopCamera();
        startCamera();
        if (this.lensFacing == 0) {
            ImageButton imageButton = this.flashButton;
            if (imageButton != null) {
                imageButton.setEnabled(false);
                this.flashButton.setAlpha(0.5f);
            }
            if (this.isFlashOn) {
                this.isFlashOn = false;
                ImageButton imageButton2 = this.flashButton;
                if (imageButton2 != null) {
                    imageButton2.setImageResource(R.drawable.ic_flash_off);
                    return;
                }
                return;
            }
            return;
        }
        ImageButton imageButton3 = this.flashButton;
        if (imageButton3 != null) {
            imageButton3.setEnabled(true);
            this.flashButton.setAlpha(1.0f);
        }
    }

    private void openGallery() {
        String[] permissions;
        if (getContext() == null) {
            return;
        }
        if (!this.appconfig.isActivarMejoraQR()) {
            stopCamera();
        } else {
            ZXingScannerView zXingScannerView = this.mScannerview;
            if (zXingScannerView != null) {
                zXingScannerView.stopCamera();
            }
        }
        if (Build.VERSION.SDK_INT >= 33) {
            permissions = new String[]{"android.permission.READ_MEDIA_IMAGES"};
        } else {
            permissions = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        }
        boolean hasPermission = true;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(requireContext(), permission) != 0) {
                hasPermission = false;
                break;
            }
        }
        if (hasPermission) {
            this.galleryLauncher.launch("image/*");
        } else {
            this.permissionLauncher.launch(permissions);
        }
    }

    private void decodeQRFromGallery(Uri imageUri) {
        try {
            InputStream imageStream = requireContext().getContentResolver().openInputStream(imageUri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            if (selectedImage == null) {
                Toast.makeText(getContext(), "No se pudo cargar la imagen", 0).show();
                reanudarCamara();
            } else if (!this.appconfig.isActivarMejoraQR() && this.barcodeScanner != null) {
                InputImage image = InputImage.fromBitmap(selectedImage, 0);
                this.barcodeScanner.process(image).addOnSuccessListener(new OnSuccessListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda17
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        this.f$0.lambda$decodeQRFromGallery$6(selectedImage, (List) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda18
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        this.f$0.lambda$decodeQRFromGallery$7(selectedImage, exc);
                    }
                });
            } else {
                decodeQRWithZXing(selectedImage);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error en decodeQRFromGallery: " + e.getMessage());
            Toast.makeText(getContext(), "Error al procesar la imagen", 0).show();
            reanudarCamara();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeQRFromGallery$6(Bitmap selectedImage, List barcodes) {
        String rawValue;
        Iterator it = barcodes.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            if (barcode.getFormat() == 256 && (rawValue = barcode.getRawValue()) != null) {
                this.contenidoQR = rawValue;
                procesarQR();
                return;
            }
        }
        decodeQRWithZXing(selectedImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeQRFromGallery$7(Bitmap selectedImage, Exception e) {
        decodeQRWithZXing(selectedImage);
    }

    private void decodeQRWithZXing(Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 800 || height > 800) {
                float scale = Math.min(800.0f / width, 800.0f / height);
                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                try {
                    width = bitmap2.getWidth();
                    height = bitmap2.getHeight();
                } catch (NotFoundException e) {
                    e = e;
                    Log.e(TAG, "No se encontró QR en la imagen: " + e.getMessage());
                    Toast.makeText(getContext(), "No se encontró ningún código QR válido en la imagen", 1).show();
                    reanudarCamara();
                    return;
                }
            } else {
                bitmap2 = bitmap;
            }
            int[] pixels = new int[width * height];
            bitmap2.getPixels(pixels, 0, width, 0, 0, width, height);
            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
            MultiFormatReader reader = new MultiFormatReader();
            Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.of(BarcodeFormat.QR_CODE));
            reader.setHints(hints);
            Result result = reader.decode(binaryBitmap);
            if (result != null) {
                this.contenidoQR = result.getText();
                Log.d(TAG, "QR decodificado correctamente: " + this.contenidoQR);
                procesarQR();
                return;
            }
            Toast.makeText(getContext(), "No se encontró ningún código QR en la imagen", 0).show();
            reanudarCamara();
        } catch (NotFoundException e2) {
            e = e2;
        }
    }

    private void reanudarCamara() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reanudarCamara$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reanudarCamara$9() {
        try {
            new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reanudarCamara$8();
                }
            }, 1000L);
        } catch (Exception e) {
            Log.e(TAG, "Error en reanudarCamara: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reanudarCamara$8() {
        if (isAdded()) {
            if (!this.appconfig.isActivarMejoraQR()) {
                PreviewView previewView = this.previewView;
                if (previewView != null && previewView.getVisibility() == 0) {
                    startCamera();
                    return;
                }
                return;
            }
            ZXingScannerView zXingScannerView = this.mScannerview;
            if (zXingScannerView != null) {
                try {
                    zXingScannerView.stopCamera();
                    this.mScannerview.setResultHandler(this);
                    this.mScannerview.startCamera();
                    Log.d(TAG, "Cámara ZXing reanudada correctamente");
                } catch (Exception e) {
                    Log.e(TAG, "Error al reanudar cámara ZXing: " + e.getMessage());
                }
            }
        }
    }

    private View createViewQROLD() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        ZXingScannerView zXingScannerView = new ZXingScannerView(getActivity());
        this.mScannerview = zXingScannerView;
        zXingScannerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mScannerview.setAutoFocus(true);
        this.mScannerview.setKeepScreenOn(true);
        frameLayout.addView(this.mScannerview);
        LinearLayout buttonContainer = new LinearLayout(getActivity());
        buttonContainer.setOrientation(0);
        buttonContainer.setGravity(17);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 49;
        params.topMargin = 50;
        buttonContainer.setLayoutParams(params);
        ImageButton imageButton = new ImageButton(getActivity());
        this.flashButton = imageButton;
        imageButton.setImageResource(R.drawable.ic_flash_off);
        this.flashButton.setBackgroundResource(android.R.color.transparent);
        this.flashButton.setColorFilter(-1);
        this.flashButton.setPadding(20, 20, 20, 20);
        ImageButton imageButton2 = new ImageButton(getActivity());
        this.importButton = imageButton2;
        imageButton2.setImageResource(R.drawable.ic_import);
        this.importButton.setBackgroundResource(android.R.color.transparent);
        this.importButton.setColorFilter(-1);
        this.importButton.setPadding(20, 20, 20, 20);
        int buttonSize = (int) (getResources().getDisplayMetrics().density * 44.0f);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(buttonSize, buttonSize);
        buttonParams.setMargins(20, 0, 20, 0);
        this.flashButton.setLayoutParams(buttonParams);
        this.importButton.setLayoutParams(buttonParams);
        buttonContainer.addView(this.flashButton);
        buttonContainer.addView(this.importButton);
        setupZXingListeners();
        frameLayout.addView(buttonContainer);
        return frameLayout;
    }

    private void setupZXingListeners() {
        ImageButton imageButton = this.flashButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupZXingListeners$10(view);
                }
            });
        }
        ImageButton imageButton2 = this.importButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupZXingListeners$11(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZXingListeners$10(View v) {
        ZXingScannerView zXingScannerView = this.mScannerview;
        if (zXingScannerView != null) {
            boolean z = !this.isFlashOn;
            this.isFlashOn = z;
            zXingScannerView.setFlash(z);
            this.flashButton.setImageResource(this.isFlashOn ? R.drawable.ic_flash_on : R.drawable.ic_flash_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZXingListeners$11(View v) {
        openGallery();
    }

    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler
    public void handleResult(Result rawResult) {
        this.contenidoQR = rawResult.getText();
        this.formatoQR = rawResult.getBarcodeFormat();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleResult$12();
            }
        }, 2000L);
        procesarQR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleResult$12() {
        ZXingScannerView zXingScannerView = this.mScannerview;
        if (zXingScannerView != null) {
            zXingScannerView.resumeCameraPreview(this);
        }
    }

    private void reiniciarEscaneo() {
        this.isScanning = false;
        this.contenidoQR = null;
        showScanner();
        if (!this.appconfig.isActivarMejoraQR()) {
            startCamera();
        }
    }

    private void showScanner() {
        PreviewView previewView = this.previewView;
        if (previewView != null) {
            previewView.setVisibility(0);
        }
    }

    private void startCamera() {
        if (this.isScanning) {
            return;
        }
        this.isScanning = true;
        final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());
        cameraProviderFuture.addListener(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startCamera$16(cameraProviderFuture);
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$startCamera$16(ListenableFuture cameraProviderFuture) {
        try {
            ProcessCameraProvider cameraProvider = (ProcessCameraProvider) cameraProviderFuture.get();
            Preview preview = new Preview.Builder().build();
            preview.setSurfaceProvider(this.previewView.getSurfaceProvider());
            ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
            imageAnalysis.setAnalyzer(this.cameraExecutor, new ImageAnalysis.Analyzer() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda20
                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public final void analyze(ImageProxy imageProxy) {
                    this.f$0.lambda$startCamera$15(imageProxy);
                }

                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public /* synthetic */ Size getDefaultTargetResolution() {
                    return ImageAnalysis.Analyzer.CC.$default$getDefaultTargetResolution(this);
                }
            });
            CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(this.lensFacing).build();
            cameraProvider.unbindAll();
            this.camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis);
            setupTapToFocus();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Error al iniciar cámara", 0).show();
            this.isScanning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCamera$15(final ImageProxy imageProxy) {
        if (!this.isScanning) {
            imageProxy.close();
            return;
        }
        try {
            InputImage image = InputImage.fromMediaImage(imageProxy.getImage(), imageProxy.getImageInfo().getRotationDegrees());
            this.barcodeScanner.process(image).addOnSuccessListener(new OnSuccessListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda23
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$startCamera$13((List) obj);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda24
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    imageProxy.close();
                }
            });
        } catch (Exception e) {
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCamera$13(List barcodes) {
        String rawValue;
        Iterator it = barcodes.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            if (barcode.getFormat() == 256 && (rawValue = barcode.getRawValue()) != null) {
                this.isScanning = false;
                handleBarcodeResult(rawValue);
                return;
            }
        }
    }

    private void setupTapToFocus() {
        PreviewView previewView = this.previewView;
        if (previewView != null) {
            previewView.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.lambda$setupTapToFocus$17(view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupTapToFocus$17(View v, MotionEvent event) {
        if (this.camera != null) {
            MeteringPointFactory factory = this.previewView.getMeteringPointFactory();
            MeteringPoint point = factory.createPoint(event.getX(), event.getY());
            FocusMeteringAction action = new FocusMeteringAction.Builder(point).build();
            this.camera.getCameraControl().startFocusAndMetering(action);
            return true;
        }
        return true;
    }

    private void setupAutoFocus(Camera camera) {
        try {
            final CameraControl cameraControl = camera.getCameraControl();
            new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f6Y2Wmtg6jQ.this.isScanning && f6Y2Wmtg6jQ.this.isAdded()) {
                        try {
                            MeteringPointFactory factory = f6Y2Wmtg6jQ.this.previewView.getMeteringPointFactory();
                            MeteringPoint point = factory.createPoint(0.5f, 0.5f);
                            FocusMeteringAction action = new FocusMeteringAction.Builder(point).setAutoCancelDuration(2L, TimeUnit.SECONDS).build();
                            cameraControl.startFocusAndMetering(action);
                        } catch (Exception e) {
                            Log.e("QRScanner", "Error en auto-focus", e);
                        }
                        new Handler().postDelayed(this, 2000L);
                    }
                }
            }, 1000L);
        } catch (Exception e) {
            Log.e("QRScanner", "No se pudo configurar auto-focus", e);
        }
    }

    private boolean isInsideScanArea(Point[] corners, RectF relativeScanArea, ImageProxy imageProxy) {
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

    private void stopCamera() {
        this.isScanning = false;
        try {
            ProcessCameraProvider cameraProvider = ProcessCameraProvider.getInstance(requireContext()).get();
            cameraProvider.unbindAll();
            this.camera = null;
        } catch (Exception e) {
            Log.e(TAG, "Error al detener cámara: " + e.getMessage());
        }
    }

    private void stopScanner() {
        stopCamera();
    }

    private void procesarQR() {
        if (validarOperacion(this.contenidoQR)) {
            if (!this.appconfig.isActivarMejoraQR()) {
                mostrarOpcion();
                return;
            } else {
                mostrarOpcionOld();
                return;
            }
        }
        String mensaje = getString(R.string.qr_no_permitido);
        ysmUbWW79P ysmubww79p = this.communicador;
        if (ysmubww79p != null) {
            ysmubww79p.onCommunicatorQRScannerResponse(true, mensaje);
        }
        getParentFragmentManager().popBackStack();
    }

    private void handleBarcodeResult(String qrContent) {
        this.contenidoQR = qrContent;
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleBarcodeResult$18();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleBarcodeResult$18() {
        if (validarOperacion(this.contenidoQR)) {
            if (!this.appconfig.isActivarMejoraQR()) {
                mostrarOpcion();
                return;
            } else {
                mostrarOpcionOld();
                return;
            }
        }
        String mensaje = getString(R.string.qr_no_permitido);
        ysmUbWW79P ysmubww79p = this.communicador;
        if (ysmubww79p != null) {
            ysmubww79p.onCommunicatorQRScannerResponse(true, mensaje);
        }
        getParentFragmentManager().popBackStack();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (!getUserVisibleHint()) {
            stopCameraIfNeeded();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) {
            if (!this.appconfig.isActivarMejoraQR()) {
                if (this.previewView != null) {
                    startCamera();
                    return;
                }
                return;
            } else {
                ZXingScannerView zXingScannerView = this.mScannerview;
                if (zXingScannerView != null) {
                    zXingScannerView.setResultHandler(this);
                    this.mScannerview.startCamera();
                    return;
                }
                return;
            }
        }
        stopCameraIfNeeded();
    }

    private void stopCameraIfNeeded() {
        if (!this.appconfig.isActivarMejoraQR()) {
            stopCamera();
            BarcodeScanner barcodeScanner = this.barcodeScanner;
            if (barcodeScanner != null) {
                barcodeScanner.close();
                return;
            }
            return;
        }
        ZXingScannerView zXingScannerView = this.mScannerview;
        if (zXingScannerView != null) {
            zXingScannerView.stopCamera();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ExecutorService executorService = this.cameraExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint() && isResumed()) {
            if (!this.appconfig.isActivarMejoraQR()) {
                if (this.previewView != null) {
                    startCamera();
                }
            } else {
                ZXingScannerView zXingScannerView = this.mScannerview;
                if (zXingScannerView != null) {
                    zXingScannerView.setResultHandler(this);
                    this.mScannerview.startCamera();
                }
            }
        }
    }

    public void mostrarOpcion() {
        CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO", "MITRANSFER", "CLÁSICA", "CLÁSICA EMPRESARIAL"};
        if (this.operacion == Nl0yptXmjQ.CajaExtra) {
            items = new CharSequence[]{"BPA", "BANDEC", "METROPOLITANO"};
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Para ejecutar la operación debe seleccionar el banco:");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$mostrarOpcion$19(dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$mostrarOpcion$20(dialogInterface, i);
            }
        });
        AlertDialog alert = builder.create();
        alert.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$mostrarOpcion$21(dialogInterface);
            }
        });
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcion$19(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.agencia = R1sDOSqZ2z.BPA;
                break;
            case 1:
                this.agencia = R1sDOSqZ2z.BANDEC;
                break;
            case 2:
                this.agencia = R1sDOSqZ2z.Metropolitano;
                break;
            case 3:
                this.agencia = R1sDOSqZ2z.MiTransfer;
                break;
            case 4:
                this.agencia = R1sDOSqZ2z.CLASICA;
                break;
            case 5:
                this.agencia = R1sDOSqZ2z.CLASICAEMP;
                break;
            default:
                return;
        }
        enviarDatos();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcion$20(DialogInterface dialog, int id) {
        dialog.dismiss();
        if (!this.appconfig.isActivarMejoraQR()) {
            reiniciarEscaneo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcion$21(DialogInterface dialogInterface) {
        if (!this.appconfig.isActivarMejoraQR()) {
            reiniciarEscaneo();
        }
    }

    public void mostrarOpcionOld() {
        CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO", "MITRANSFER", "CLÁSICA"};
        if (this.operacion == Nl0yptXmjQ.CajaExtra) {
            items = new CharSequence[]{"BPA", "BANDEC", "METROPOLITANO"};
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Para ejecutar la operación debe seleccionar el banco:");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$mostrarOpcionOld$22(dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$mostrarOpcionOld$23(dialogInterface, i);
            }
        });
        AlertDialog alert = builder.create();
        alert.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$mostrarOpcionOld$24(dialogInterface);
            }
        });
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcionOld$22(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.agencia = R1sDOSqZ2z.BPA;
                break;
            case 1:
                this.agencia = R1sDOSqZ2z.BANDEC;
                break;
            case 2:
                this.agencia = R1sDOSqZ2z.Metropolitano;
                break;
            case 3:
                this.agencia = R1sDOSqZ2z.MiTransfer;
                break;
            case 4:
                this.agencia = R1sDOSqZ2z.CLASICA;
                break;
            default:
                return;
        }
        enviarDatos();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcionOld$23(DialogInterface dialog, int id) {
        dialog.dismiss();
        if (!this.appconfig.isActivarMejoraQR()) {
            reiniciarEscaneo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mostrarOpcionOld$24(DialogInterface dialogInterface) {
        if (!this.appconfig.isActivarMejoraQR()) {
            reiniciarEscaneo();
        }
    }

    private void enviarDatos() {
        Bundle args = new Bundle();
        args.putString("QRData", this.contenidoQR);
        args.putBoolean("returning_to_a", true);
        args.putSerializable("R1sDOSqZ2z", this.agencia);
        args.putSerializable("Nl0yptXmjQ", this.operacion);
        FragmentManager fragmentManager = getParentFragmentManager();
        if (this.appconfig.isActivarMejoraQR()) {
            fragmentManager.popBackStack();
        }
        if (this.operacion == Nl0yptXmjQ.Transferencia) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                    x6Wob3Sa98U metro = new x6Wob3Sa98U();
                    metro.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, metro, "x6Wob3Sa98U").addToBackStack(null).commit();
                    break;
                case 2:
                    iN1lHDKE5h bpa = new iN1lHDKE5h();
                    bpa.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bpa, "iN1lHDKE5h").addToBackStack(null).commit();
                    break;
                case 3:
                    ZDkigMAIBm bandec = new ZDkigMAIBm();
                    bandec.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bandec, "ZDkigMAIBm").addToBackStack(null).commit();
                    break;
                case 4:
                    H0oV6Ot0bS b = new H0oV6Ot0bS();
                    b.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, b, "H0oV6Ot0bS").addToBackStack(null).commit();
                    break;
                case 5:
                    l3GXbXAyUW b2 = new l3GXbXAyUW();
                    b2.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, b2, "l3GXbXAyUW").addToBackStack(null).commit();
                    break;
                case 6:
                    showDialogTransferenciaEmpresarial(args);
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.xf94v3SFEM) {
            R1sDOSqZ2z r1sDOSqZ2z = this.agencia;
            if (r1sDOSqZ2z == R1sDOSqZ2z.BPA || r1sDOSqZ2z == R1sDOSqZ2z.BANDEC || r1sDOSqZ2z == R1sDOSqZ2z.Metropolitano) {
                r7Rinp9ooL pagoExterno = new r7Rinp9ooL();
                pagoExterno.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, pagoExterno).addToBackStack(null).commit();
            } else if (r1sDOSqZ2z == R1sDOSqZ2z.CLASICA || r1sDOSqZ2z == R1sDOSqZ2z.MiTransfer) {
                s9CT6pjRyD pagoExterno2 = new s9CT6pjRyD();
                pagoExterno2.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, pagoExterno2).addToBackStack(null).commit();
            } else if (r1sDOSqZ2z == R1sDOSqZ2z.CLASICAEMP) {
                showDialogPagoExternoEmpresarial(args);
            }
        }
        if (this.operacion == Nl0yptXmjQ.Recarga_Cupon) {
            b0kkzvOCEu recarga = new b0kkzvOCEu();
            recarga.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.containerView, recarga).addToBackStack(null).commit();
        }
        if (this.operacion == Nl0yptXmjQ.VotoMovil) {
            cdINOtQ3iN voto = new cdINOtQ3iN();
            voto.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.containerView, voto).addToBackStack(null).commit();
        }
        if (this.operacion == Nl0yptXmjQ.CajaExtra) {
            if (R1sDOSqZ2z.Metropolitano == this.agencia) {
                xpc0ejPtmZ cajaExtraCuentasBanco = new xpc0ejPtmZ();
                cajaExtraCuentasBanco.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, cajaExtraCuentasBanco).addToBackStack(null).commit();
            } else {
                UTk9UWZYxf cajaExtraCuentasBanco2 = new UTk9UWZYxf();
                cajaExtraCuentasBanco2.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, cajaExtraCuentasBanco2).addToBackStack(null).commit();
            }
        }
        if (this.operacion == Nl0yptXmjQ.BOLSATransferirBancos) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 4:
                    H0oV6Ot0bS bolsa = new H0oV6Ot0bS();
                    bolsa.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa).addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ReservasTicket) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa2 = new L0JjVr9EwEF();
                    bolsa2.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa2).addToBackStack(null).commit();
                    break;
                case 4:
                    XnVSHGPTkK bolsa3 = new XnVSHGPTkK();
                    bolsa3.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa3).addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.EliminarReservasTicket) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa4 = new L0JjVr9EwEF();
                    bolsa4.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa4).addToBackStack(null).commit();
                    break;
                case 4:
                    QVPgkl8ZGC bolsa5 = new QVPgkl8ZGC();
                    bolsa5.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa5).addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ConsultarReservasTicket) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa6 = new L0JjVr9EwEF();
                    bolsa6.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa6).addToBackStack(null).commit();
                    break;
                case 4:
                    x12rSjPY6pZ bolsa7 = new x12rSjPY6pZ();
                    bolsa7.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa7).addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ModificarReservasTicket) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa8 = new L0JjVr9EwEF();
                    bolsa8.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa8).addToBackStack(null).commit();
                    break;
                case 4:
                    Wwc5crW71D bolsa9 = new Wwc5crW71D();
                    bolsa9.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa9).addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ConsultarPagosSindicato) {
            switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    SlZq2dCM9i banco = new SlZq2dCM9i();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    banco.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, banco, "ConsultaSindicatoBoncos").addToBackStack(null).commit();
                    break;
                case 4:
                    SlZq2dCM9i bolsa10 = new SlZq2dCM9i();
                    bolsa10.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa10, "ConsultaSindicatoBolsa").addToBackStack(null).commit();
                    break;
            }
        }
    }

    private void showDialogPagoExternoEmpresarial(final Bundle arg) {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                FragmentManager mFragmentManager = f6Y2Wmtg6jQ.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Eqj43O0pUx pagoExternoEmpresa = new Eqj43O0pUx();
                arg.putSerializable("PayType", Integer.valueOf(i));
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICAEMP);
                pagoExternoEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoExternoEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogTransferenciaEmpresarial(final Bundle arg) {
        CharSequence[] items = {this.context.getString(R.string.tx_bfi_transferencia_con_solic), this.context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                FragmentManager mFragmentManager = f6Y2Wmtg6jQ.this.getActivity().getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Z3kYdPwq6K2 transferenciaBolsaClasicaEmpresarialEmpresa = new Z3kYdPwq6K2();
                arg.putSerializable("TransferType", Integer.valueOf(i));
                transferenciaBolsaClasicaEmpresarialEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, transferenciaBolsaClasicaEmpresarialEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.f6Y2Wmtg6jQ$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ;
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[Nl0yptXmjQ.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ = iArr;
            try {
                iArr[Nl0yptXmjQ.xf94v3SFEM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ[Nl0yptXmjQ.Transferencia.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ[Nl0yptXmjQ.CajaExtra.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr2;
            try {
                iArr2[R1sDOSqZ2z.Metropolitano.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICA.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICAEMP.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public boolean validarOperacion(String qrdata) {
        switch (AnonymousClass6.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$Nl0yptXmjQ[this.operacion.ordinal()]) {
            case 1:
                return isValidJsonWithAttributes(qrdata);
            case 2:
                return qrdata.contains("TRANSFERMOVIL_ETECSA,TRANSFERENCIA,");
            case 3:
                return isValidJsonWithAttributes(qrdata);
            default:
                return false;
        }
    }

    private boolean isValidJsonWithAttributes(String jsonString) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            return jsonObject.has("id_transaccion") && jsonObject.has("importe") && jsonObject.has("moneda") && jsonObject.has("numero_proveedor");
        } catch (JsonSyntaxException | IllegalStateException e) {
            return false;
        }
    }
}
