package cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.TBaFnBLjEA;
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
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.P2MO7cFkntPD.EE2asIZ0vyr.f1IveoSASW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.x6Wob3Sa98U;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SlZq2dCM9i;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.V0zQxQBN2i;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
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
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: loaded from: classes.dex */
public class OJ3XxacXOT extends Fragment implements ZXingScannerView.ResultHandler {
    private static final String TAG = "OJ3XxacXOT";
    private FragmentActivity activity;
    public R1sDOSqZ2z agencia;
    private AppConfig appconfig;
    private BarcodeScanner barcodeScanner;
    private Camera camera;
    private ExecutorService cameraExecutor;
    public String contenidoQR;
    private Context context;
    public h79qmyRfm3 externosEntity;
    private ImageButton flashButton;
    public BarcodeFormat formatoQR;
    private ActivityResultLauncher<String> galleryLauncher;
    private ImageButton importButton;
    private ZXingScannerView mScannerview;
    public Nl0yptXmjQ operacion;
    private ActivityResultLauncher<String[]> permissionLauncher;
    private PreviewView previewView;
    private ImageButton rotateButton;
    private boolean isScanning = false;
    public int payType = 0;
    private boolean isFlashOn = false;
    private int lensFacing = 1;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        this.context = getContext();
        AppConfig appConfigListWithId = unYp8VQThY.getInstance().getAppConfigListWithId(1);
        this.appconfig = appConfigListWithId;
        if (!appConfigListWithId.isActivarMejoraQR()) {
            view = createViewQRNEW(inflater, container);
        } else {
            view = createViewQROLD();
        }
        initializeLaunchers();
        Bundle arg = getArguments();
        if (arg != null) {
            this.operacion = (Nl0yptXmjQ) arg.getSerializable("Nl0yptXmjQ");
            this.agencia = (R1sDOSqZ2z) arg.getSerializable("R1sDOSqZ2z");
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
        this.galleryLauncher = registerForActivityResult(new ActivityResultContracts$GetContent(), new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda13
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$initializeLaunchers$0((Uri) obj);
            }
        });
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda14
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
        getParentFragmentManager().setFragmentResultListener("returnToA", this, new FragmentResultListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda17
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
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupButtonListeners$3(view);
                }
            });
        }
        ImageButton imageButton2 = this.rotateButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupButtonListeners$4(view);
                }
            });
        }
        ImageButton imageButton3 = this.importButton;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda5
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
            this.flashButton.setEnabled(false);
            this.flashButton.setAlpha(0.5f);
            if (this.isFlashOn) {
                this.isFlashOn = false;
                this.flashButton.setImageResource(R.drawable.ic_flash_off);
                return;
            }
            return;
        }
        this.flashButton.setEnabled(true);
        this.flashButton.setAlpha(1.0f);
    }

    private void openGallery() {
        String[] permissions;
        if (getContext() == null) {
            return;
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
            } else if (!this.appconfig.isActivarMejoraQR() && this.barcodeScanner != null) {
                InputImage image = InputImage.fromBitmap(selectedImage, 0);
                this.barcodeScanner.process(image).addOnSuccessListener(new OnSuccessListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda18
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        this.f$0.lambda$decodeQRFromGallery$6(selectedImage, (List) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda19
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
                lambda$handleBarcodeResult$19();
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
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Log.d(TAG, "Decodificando imagen: " + width + "x" + height);
            int[] pixels = new int[width * height];
            bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
            MultiFormatReader reader = new MultiFormatReader();
            Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.of(BarcodeFormat.QR_CODE));
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            reader.setHints(hints);
            Result result = reader.decode(binaryBitmap);
            if (result != null) {
                this.contenidoQR = result.getText();
                Log.d(TAG, "QR decodificado exitosamente: " + this.contenidoQR);
                lambda$handleBarcodeResult$19();
            } else {
                Toast.makeText(getContext(), "No se encontró ningún código QR en la imagen", 0).show();
                new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$decodeQRWithZXing$8();
                    }
                }, 500L);
            }
        } catch (NotFoundException e) {
            Log.e(TAG, "No se encontró QR en la imagen: " + e.getMessage());
            Toast.makeText(getContext(), "No se encontró un código QR válido en la imagen", 1).show();
            new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$decodeQRWithZXing$9();
                }
            }, 500L);
        } catch (Exception e2) {
            Log.e(TAG, "Error general al decodificar QR: " + e2.getMessage(), e2);
            Toast.makeText(getContext(), "Error al procesar la imagen: " + e2.getMessage(), 0).show();
            new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$decodeQRWithZXing$10();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeQRWithZXing$8() {
        if (getActivity() != null && isAdded()) {
            getParentFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeQRWithZXing$9() {
        if (getActivity() != null && isAdded()) {
            getParentFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decodeQRWithZXing$10() {
        if (getActivity() != null && isAdded()) {
            getParentFragmentManager().popBackStack();
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
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupZXingListeners$11(view);
                }
            });
        }
        ImageButton imageButton2 = this.importButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupZXingListeners$12(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZXingListeners$11(View v) {
        ZXingScannerView zXingScannerView = this.mScannerview;
        if (zXingScannerView != null) {
            boolean z = !this.isFlashOn;
            this.isFlashOn = z;
            zXingScannerView.setFlash(z);
            this.flashButton.setImageResource(this.isFlashOn ? R.drawable.ic_flash_on : R.drawable.ic_flash_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupZXingListeners$12(View v) {
        openGallery();
    }

    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler
    public void handleResult(Result rawResult) {
        this.contenidoQR = rawResult.getText();
        this.formatoQR = rawResult.getBarcodeFormat();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleResult$13();
            }
        }, 500L);
        lambda$handleBarcodeResult$19();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleResult$13() {
        this.mScannerview.resumeCameraPreview(this);
    }

    private void startCamera() {
        if (this.isScanning) {
            return;
        }
        this.isScanning = true;
        final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());
        cameraProviderFuture.addListener(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startCamera$17(cameraProviderFuture);
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$startCamera$17(ListenableFuture cameraProviderFuture) {
        try {
            ProcessCameraProvider cameraProvider = (ProcessCameraProvider) cameraProviderFuture.get();
            Preview preview = new Preview.Builder().build();
            preview.setSurfaceProvider(this.previewView.getSurfaceProvider());
            ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
            imageAnalysis.setAnalyzer(this.cameraExecutor, new ImageAnalysis.Analyzer() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda16
                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public final void analyze(ImageProxy imageProxy) {
                    this.f$0.lambda$startCamera$16(imageProxy);
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
    public /* synthetic */ void lambda$startCamera$16(final ImageProxy imageProxy) {
        if (!this.isScanning) {
            imageProxy.close();
            return;
        }
        try {
            InputImage image = InputImage.fromMediaImage(imageProxy.getImage(), imageProxy.getImageInfo().getRotationDegrees());
            this.barcodeScanner.process(image).addOnSuccessListener(new OnSuccessListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$startCamera$14((List) obj);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda2
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
    public /* synthetic */ void lambda$startCamera$14(List barcodes) {
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
        this.previewView.setOnTouchListener(new View.OnTouchListener() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setupTapToFocus$18(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setupTapToFocus$18(View v, MotionEvent event) {
        if (this.camera != null) {
            MeteringPointFactory factory = this.previewView.getMeteringPointFactory();
            MeteringPoint point = factory.createPoint(event.getX(), event.getY());
            FocusMeteringAction action = new FocusMeteringAction.Builder(point).build();
            this.camera.getCameraControl().startFocusAndMetering(action);
            return true;
        }
        return true;
    }

    private void handleBarcodeResult(String qrContent) {
        this.contenidoQR = qrContent;
        new Handler().postDelayed(new Runnable() { // from class: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleBarcodeResult$19();
            }
        }, 500L);
    }

    private void stopCamera() {
        this.isScanning = false;
        try {
            ProcessCameraProvider cameraProvider = ProcessCameraProvider.getInstance(requireContext()).get();
            cameraProvider.unbindAll();
            this.camera = null;
        } catch (Exception e) {
        }
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

    /* JADX INFO: renamed from: procesarQR, reason: merged with bridge method [inline-methods] */
    public void lambda$handleBarcodeResult$19() {
        FragmentManager fragmentManager = getParentFragmentManager();
        Bundle args = new Bundle();
        args.putString("QRData", this.contenidoQR);
        fragmentManager.popBackStackImmediate();
        if (this.operacion == Nl0yptXmjQ.Transferencia) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
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
                    l3GXbXAyUW clasica = new l3GXbXAyUW();
                    clasica.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, clasica, "l3GXbXAyUW").addToBackStack(null).commit();
                    break;
                case 5:
                    args.putSerializable("TransferType", Integer.valueOf(this.payType));
                    Z3kYdPwq6K2 transferenciaBolsaClasicaEmpresarialEmpresa = new Z3kYdPwq6K2();
                    transferenciaBolsaClasicaEmpresarialEmpresa.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, transferenciaBolsaClasicaEmpresarialEmpresa, "TransferenciaClasicaEmpresarial").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.TransferenciaEmpresa) {
            args.putSerializable("R1sDOSqZ2z", this.agencia);
            args.putSerializable("TransferType", Integer.valueOf(this.payType));
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 6:
                    f1IveoSASW bfi = new f1IveoSASW();
                    bfi.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bfi, "f1IveoSASW").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.xf94v3SFEM) {
            args.putSerializable("R1sDOSqZ2z", this.agencia);
            R1sDOSqZ2z r1sDOSqZ2z = this.agencia;
            if (r1sDOSqZ2z != R1sDOSqZ2z.MiTransfer) {
                if (r1sDOSqZ2z == R1sDOSqZ2z.CLASICAEMP) {
                    args.putSerializable("PayType", Integer.valueOf(this.payType));
                    Eqj43O0pUx pagoExternoEmpresa = new Eqj43O0pUx();
                    pagoExternoEmpresa.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, pagoExternoEmpresa, "PagoExternoClasicaEmpresarial").addToBackStack(null).commit();
                } else {
                    r7Rinp9ooL pagoExterno = new r7Rinp9ooL();
                    pagoExterno.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, pagoExterno, "r7Rinp9ooL").addToBackStack(null).commit();
                }
            } else {
                s9CT6pjRyD pagoExterno2 = new s9CT6pjRyD();
                pagoExterno2.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, pagoExterno2, "s9CT6pjRyD").addToBackStack(null).commit();
            }
        }
        if (this.operacion == Nl0yptXmjQ.Eqj43O0pUx) {
            args.putSerializable("PayType", Integer.valueOf(this.payType));
            args.putSerializable("R1sDOSqZ2z", this.agencia);
            Eqj43O0pUx pagoExterno3 = new Eqj43O0pUx();
            pagoExterno3.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.containerView, pagoExterno3, "Eqj43O0pUx").addToBackStack(null).commit();
        }
        if (this.operacion == Nl0yptXmjQ.Recarga_Cupon) {
            b0kkzvOCEu recarga = new b0kkzvOCEu();
            recarga.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.containerView, recarga, "b0kkzvOCEu").addToBackStack(null).commit();
        }
        if (this.operacion == Nl0yptXmjQ.VotoMovil) {
            cdINOtQ3iN voto = new cdINOtQ3iN();
            voto.setArguments(args);
            fragmentManager.beginTransaction().replace(R.id.containerView, voto, "XRa1KuZNBW").addToBackStack(null).commit();
        }
        if (this.operacion == Nl0yptXmjQ.CajaExtra) {
            R1sDOSqZ2z r1sDOSqZ2z2 = R1sDOSqZ2z.Metropolitano;
            R1sDOSqZ2z r1sDOSqZ2z3 = this.agencia;
            if (r1sDOSqZ2z2 == r1sDOSqZ2z3) {
                args.putSerializable("R1sDOSqZ2z", r1sDOSqZ2z3);
                xpc0ejPtmZ cajaExtraCuentasBanco = new xpc0ejPtmZ();
                cajaExtraCuentasBanco.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, cajaExtraCuentasBanco, "xpc0ejPtmZ").addToBackStack(null).commit();
            } else {
                args.putSerializable("R1sDOSqZ2z", r1sDOSqZ2z3);
                UTk9UWZYxf cajaExtraCuentasBanco2 = new UTk9UWZYxf();
                cajaExtraCuentasBanco2.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.containerView, cajaExtraCuentasBanco2, "UTk9UWZYxf").addToBackStack(null).commit();
            }
        }
        if (this.operacion == Nl0yptXmjQ.BOLSATransferirBancos) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 7:
                    H0oV6Ot0bS bolsa = new H0oV6Ot0bS();
                    bolsa.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa, "H0oV6Ot0bS").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ReservasTicket) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa2 = new L0JjVr9EwEF();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    bolsa2.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa2, "L0JjVr9EwEF").addToBackStack(null).commit();
                    break;
                case 7:
                    XnVSHGPTkK bolsa3 = new XnVSHGPTkK();
                    bolsa3.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa3, "XnVSHGPTkK").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.TBaFnBLjEA) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    L0JjVr9EwEF bolsa4 = new L0JjVr9EwEF();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    bolsa4.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa4, "L0JjVr9EwEF").addToBackStack(null).commit();
                    break;
                case 7:
                    TBaFnBLjEA bolsa5 = new TBaFnBLjEA();
                    bolsa5.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa5, "TBaFnBLjEA").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.EliminarReservasTicket) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    GPsckxvkPu banco = new GPsckxvkPu();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    banco.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, banco, "GPsckxvkPu").addToBackStack(null).commit();
                    break;
                case 7:
                    QVPgkl8ZGC bolsa6 = new QVPgkl8ZGC();
                    bolsa6.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa6, "QVPgkl8ZGC").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ConsultarReservasTicket) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    V0zQxQBN2i banco2 = new V0zQxQBN2i();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    banco2.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, banco2, "V0zQxQBN2i").addToBackStack(null).commit();
                    break;
                case 7:
                    x12rSjPY6pZ bolsa7 = new x12rSjPY6pZ();
                    bolsa7.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa7, "x12rSjPY6pZ").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ModificarReservasTicket) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    rGY5dubJYU banco3 = new rGY5dubJYU();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    banco3.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, banco3, "rGY5dubJYU").addToBackStack(null).commit();
                    break;
                case 7:
                    Wwc5crW71D bolsa8 = new Wwc5crW71D();
                    bolsa8.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa8, "Wwc5crW71D").addToBackStack(null).commit();
                    break;
            }
        }
        if (this.operacion == Nl0yptXmjQ.ConsultarPagosSindicato) {
            switch (AnonymousClass1.$SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[this.agencia.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    SlZq2dCM9i banco4 = new SlZq2dCM9i();
                    args.putSerializable("R1sDOSqZ2z", this.agencia);
                    banco4.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, banco4, "ConsultaSindicatoBoncos").addToBackStack(null).commit();
                    break;
                case 7:
                    SlZq2dCM9i bolsa9 = new SlZq2dCM9i();
                    bolsa9.setArguments(args);
                    fragmentManager.beginTransaction().replace(R.id.containerView, bolsa9, "ConsultaSindicatoBolsa").addToBackStack(null).commit();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.OJ3XxacXOT$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z;

        static {
            int[] iArr = new int[R1sDOSqZ2z.values().length];
            $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z = iArr;
            try {
                iArr[R1sDOSqZ2z.Metropolitano.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BPA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BANDEC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.CLASICAEMP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.BFI.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$cubacel$tr$tm$l08fNVC4KOKK$piM0KeORWQz$R1sDOSqZ2z[R1sDOSqZ2z.MiTransfer.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
