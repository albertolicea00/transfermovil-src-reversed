package cu.etecsa.tm.ecommerce.cclrmrQMCrJ;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.lang.reflect.Array;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class cLjDBJlvRe {
    private static final int BLACK = -16777216;
    private static final float FULL_LOGO_QR = 507.1f;
    private static final float LOGO_BACKGROUND = 140.7f;
    private static final float LOGO_SIZE = 126.7f;
    private static final int MAX_INPUT_GIF_SIZE = 480;
    private static final int MAX_LOGO_SIZE = 1080;
    private static final int SCALE_NORMAL_QR = 10;
    private static final String TAG = "cLjDBJlvRe";
    private static final int WHITE = -1;
    private static int[] patternCenters;
    private static int scaleQR;

    public static Bitmap Product(String txt, Bitmap input, boolean colorful, int color) throws WriterException {
        int i;
        Bitmap resizedImage;
        int imageSize;
        int inputSize;
        Log.d(TAG, "Product start input input.getWidth(): " + input.getWidth() + " input.getHeight(): " + input.getHeight());
        Bitmap QRImage = null;
        try {
            QRImage = encodeAsBitmap(txt);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
        }
        if (colorful && color != BLACK) {
            QRImage = replaceColor(QRImage, color);
        }
        int inputSize2 = Math.max(input.getWidth(), input.getHeight());
        int scale = (int) Math.ceil((((double) inputSize2) * 1.0d) / ((double) QRImage.getWidth()));
        if (scale % 3 != 0) {
            scale += 3 - (scale % 3);
        }
        scaleQR = scale;
        Bitmap scaledQRImage = Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * scale, QRImage.getHeight() * scale, false);
        if (input.getWidth() < input.getHeight()) {
            resizedImage = Bitmap.createScaledBitmap(input, scaledQRImage.getWidth() - ((scale * 4) * 2), (int) (((double) (scaledQRImage.getHeight() - ((scale * 4) * 2))) * ((((double) input.getHeight()) * 1.0d) / ((double) input.getWidth()))), false);
            imageSize = resizedImage.getWidth();
            i = 2;
        } else {
            i = 2;
            resizedImage = Bitmap.createScaledBitmap(input, (int) (((double) (scaledQRImage.getWidth() - ((scale * 4) * 2))) * ((((double) input.getWidth()) * 1.0d) / ((double) input.getHeight()))), scaledQRImage.getHeight() - ((scale * 4) * 2), false);
            imageSize = resizedImage.getHeight();
        }
        int imageSize2 = scaledQRImage.getWidth();
        int[] iArr = new int[i];
        int i2 = 1;
        iArr[1] = scaledQRImage.getWidth() - ((scale * 4) * 2);
        iArr[0] = imageSize2 - ((scale * 4) * 2);
        int[][] pattern = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr);
        int i3 = 0;
        while (i3 < patternCenters.length) {
            int j = 0;
            while (true) {
                int[] iArr2 = patternCenters;
                if (j < iArr2.length) {
                    int i4 = iArr2[i3];
                    if (i4 == 6) {
                        inputSize = inputSize2;
                        if (iArr2[j] != iArr2[iArr2.length - i2]) {
                        }
                        j++;
                        inputSize2 = inputSize;
                        i2 = 1;
                    } else {
                        inputSize = inputSize2;
                    }
                    int inputSize3 = iArr2[j];
                    if ((inputSize3 != 6 || i4 != iArr2[iArr2.length - i2]) && (i4 != 6 || inputSize3 != 6)) {
                        int initx = (i4 - 2) * scale;
                        int inity = (inputSize3 - 2) * scale;
                        for (int x = initx; x < (scale * 5) + initx; x++) {
                            for (int y = inity; y < inity + (scale * 5); y++) {
                                pattern[x][y] = 1;
                            }
                        }
                    }
                    j++;
                    inputSize2 = inputSize;
                    i2 = 1;
                }
            }
            i3++;
            i2 = 1;
        }
        Bitmap blackWhite = resizedImage;
        if (!colorful) {
            blackWhite = convertBlackWhiteFull(blackWhite);
        }
        for (int i5 = 0; i5 < imageSize; i5++) {
            for (int j2 = 0; j2 < imageSize; j2++) {
                if ((((i5 * 3) / scale) % 3 != 1 || ((j2 * 3) / scale) % 3 != 1) && ((i5 >= scale * 4 * 2 || (j2 >= scale * 4 * 2 && j2 <= imageSize - (((scale * 4) * 2) + 1))) && ((i5 <= imageSize - (((scale * 4) * 2) + 1) || j2 >= scale * 4 * 2) && pattern[i5][j2] != 1))) {
                    scaledQRImage.setPixel((scale * 4) + i5, (scale * 4) + j2, blackWhite.getPixel(i5, j2));
                }
            }
        }
        Log.d(TAG, "Product end input scaledQRImage.getWidth(): " + scaledQRImage.getWidth() + " scaledQRImage.getHeight(): " + scaledQRImage.getHeight());
        return scaledQRImage;
    }

    public static Bitmap convertBlackWhiteFull(Bitmap blackWhite) {
        return convertGreyImgByFloyd2(ConvertToBlackAndWhite(createContrast(blackWhite, 50.0d, 30)));
    }

    public static Bitmap ProductEmbed(String txt, Bitmap input, boolean colorful, int color, int x, int y, Bitmap originBitmap) throws WriterException {
        int originalSize = input.getWidth();
        Bitmap qrBitmap = Product(txt, input, colorful, color);
        double newScale = ((((double) originalSize) * 1.0d) * ((double) scaleQR)) / ((double) (qrBitmap.getWidth() - (scaleQR * 8)));
        int targetSize = (qrBitmap.getWidth() * originalSize) / (qrBitmap.getWidth() - (scaleQR * 8));
        Bitmap qrBitmap2 = Bitmap.createScaledBitmap(resizeQuiteZone(qrBitmap, newScale), targetSize, targetSize, false);
        Bitmap originBitmap2 = originBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(originBitmap2);
        canvas.drawBitmap(qrBitmap2, x - ((int) (newScale * 4.0d)), y - ((int) (4.0d * newScale)), (Paint) null);
        return originBitmap2;
    }

    private static Bitmap resizeQuiteZone(Bitmap qrBitmap, double scale) {
        int size = qrBitmap.getWidth();
        int boundary = (int) (3.5d * scale);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < boundary || i > size - (boundary + 1) || j < boundary || j > size - (boundary + 1)) {
                    qrBitmap.setPixel(i, j, 0);
                }
            }
        }
        return qrBitmap;
    }

    public static Bitmap ProductNormal(String txt, boolean colorful, int color) throws WriterException {
        try {
            Bitmap QRImage = encodeAsBitmap(txt);
            if (colorful && color != BLACK) {
                QRImage = replaceColor(QRImage, color);
            }
            return Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * 10, QRImage.getHeight() * 10, false);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
            return null;
        }
    }

    public static Bitmap ProductForResult(String txt) {
        try {
            Bitmap QRImage = encodeAsBitmap(txt, ErrorCorrectionLevel.L);
            return Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * 10, QRImage.getHeight() * 10, false);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
            return null;
        }
    }

    public static Bitmap ProductLogo(Bitmap logo, String txt, boolean colorful, int color) throws WriterException {
        Bitmap qrImage = ProductNormal(txt, colorful, color);
        int fullSize = qrImage.getWidth() - 80;
        int finalSize = Math.min((int) ((logo.getWidth() * FULL_LOGO_QR) / LOGO_SIZE), MAX_LOGO_SIZE);
        int scale = 10;
        if (finalSize > fullSize) {
            scale = (finalSize * 10) / fullSize;
            qrImage = Bitmap.createScaledBitmap(qrImage, (qrImage.getWidth() * finalSize) / fullSize, (qrImage.getHeight() * finalSize) / fullSize, false);
            fullSize = finalSize;
        }
        int background = (int) ((fullSize * LOGO_BACKGROUND) / FULL_LOGO_QR);
        int logoSize = (int) ((fullSize * LOGO_SIZE) / FULL_LOGO_QR);
        Bitmap white = Bitmap.createBitmap(background, background, Bitmap.Config.ARGB_8888);
        int boundary = (background - logoSize) / 2;
        Canvas canvas = new Canvas(white);
        canvas.drawColor(-1);
        Bitmap scaleLogo = Bitmap.createScaledBitmap(logo, logoSize, logoSize, false);
        canvas.drawBitmap(fillBoundary(scaleLogo, boundary, -1), boundary, boundary, (Paint) null);
        canvas.save();
        Bitmap white2 = fillBoundary(white, boundary, 0);
        Canvas canvasQR = new Canvas(qrImage);
        canvasQR.drawBitmap(white2, (scale * 4) + ((fullSize - background) / 2), (scale * 4) + ((fullSize - background) / 2), (Paint) null);
        return qrImage;
    }

    private static Bitmap fillBoundary(Bitmap white, int boundary, int color) {
        int size = white.getWidth();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= boundary || j >= boundary) {
                    if (i >= boundary || j <= size - (boundary + 1)) {
                        if (i <= size - (boundary + 1) || j >= boundary) {
                            if (i > size - (boundary + 1) && j > size - (boundary + 1) && Math.pow((size - (boundary + 1)) - i, 2.0d) + Math.pow((size - (boundary + 1)) - j, 2.0d) > Math.pow(boundary, 2.0d)) {
                                white.setPixel(i, j, color);
                            }
                        } else if (Math.pow((size - (boundary + 1)) - i, 2.0d) + Math.pow(boundary - j, 2.0d) > Math.pow(boundary, 2.0d)) {
                            white.setPixel(i, j, color);
                        }
                    } else if (Math.pow(boundary - i, 2.0d) + Math.pow((size - (boundary + 1)) - j, 2.0d) > Math.pow(boundary, 2.0d)) {
                        white.setPixel(i, j, color);
                    }
                } else if (Math.pow(boundary - i, 2.0d) + Math.pow(boundary - j, 2.0d) > Math.pow(boundary, 2.0d)) {
                    white.setPixel(i, j, color);
                }
            }
        }
        return white;
    }

    public static Bitmap[] ProductGIF(String txt, Bitmap[] input, boolean colorful, int color) {
        Log.d(TAG, "ProductGIF start");
        int size = input[0].getWidth();
        int i = 0;
        Bitmap[] output = new Bitmap[input.length];
        for (Bitmap inputBitmap : input) {
            if (size > MAX_INPUT_GIF_SIZE) {
                inputBitmap = Bitmap.createScaledBitmap(inputBitmap, MAX_INPUT_GIF_SIZE, MAX_INPUT_GIF_SIZE, false);
            }
            output[i] = Product(txt, inputBitmap, colorful, color);
            i++;
        }
        return output;
    }

    public static Bitmap replaceColor(Bitmap qrBitmap, int color) {
        int[] allpixels = new int[qrBitmap.getHeight() * qrBitmap.getWidth()];
        qrBitmap.getPixels(allpixels, 0, qrBitmap.getWidth(), 0, 0, qrBitmap.getWidth(), qrBitmap.getHeight());
        for (int i = 0; i < allpixels.length; i++) {
            if (allpixels[i] == BLACK) {
                allpixels[i] = color;
            }
        }
        qrBitmap.setPixels(allpixels, 0, qrBitmap.getWidth(), 0, 0, qrBitmap.getWidth(), qrBitmap.getHeight());
        return qrBitmap;
    }

    public static Bitmap replaceQR(Bitmap qrBitmap, Bitmap image) {
        int width = qrBitmap.getWidth();
        int height = qrBitmap.getHeight();
        int[] pixels = new int[width * height];
        qrBitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] iArr = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pixels[(width * i) + j] != -1) {
                    image.setPixel(i, j, pixels[(width * i) + j]);
                }
            }
        }
        return image;
    }

    public static Bitmap encodeAsBitmap(String txt) throws WriterException {
        return encodeAsBitmap(txt, ErrorCorrectionLevel.H);
    }

    public static Bitmap encodeAsBitmap(String txt, ErrorCorrectionLevel level) throws WriterException {
        Map<EncodeHintType, Object> hints;
        if (txt == null) {
            return null;
        }
        Object encoding = guessAppropriateEncoding(txt);
        if (encoding == null) {
            hints = null;
        } else {
            Map<EncodeHintType, Object> hints2 = new EnumMap<>(EncodeHintType.class);
            hints2.put(EncodeHintType.CHARACTER_SET, encoding);
            hints = hints2;
        }
        try {
            QRCode qrCode = Encoder.encode(txt, level, hints);
            patternCenters = qrCode.getVersion().getAlignmentPatternCenters();
            BitMatrix result = renderResult(qrCode, 4);
            int width = result.getWidth();
            int height = result.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    pixels[offset + x] = result.get(x, y) ? BLACK : -1;
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    private static BitMatrix renderResult(QRCode code, int quietZone) {
        ByteMatrix input = code.getMatrix();
        if (input == null) {
            throw new IllegalStateException();
        }
        int inputWidth = input.getWidth();
        int inputHeight = input.getHeight();
        int qrWidth = (quietZone * 2) + inputWidth;
        int qrHeight = (quietZone * 2) + inputHeight;
        int outputWidth = Math.max(0, qrWidth);
        int outputHeight = Math.max(0, qrHeight);
        int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
        int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
        int topPadding = (outputHeight - (inputHeight * multiple)) / 2;
        BitMatrix output = new BitMatrix(outputWidth, outputHeight);
        int inputY = 0;
        int outputY = topPadding;
        while (inputY < inputHeight) {
            int inputX = 0;
            int outputX = leftPadding;
            while (inputX < inputWidth) {
                ByteMatrix input2 = input;
                if (input.get(inputX, inputY) == 1) {
                    output.setRegion(outputX, outputY, multiple, multiple);
                }
                inputX++;
                outputX += multiple;
                input = input2;
            }
            inputY++;
            outputY += multiple;
        }
        return output;
    }

    public static Bitmap ConvertToBlackAndWhite(Bitmap sampleBitmap) {
        ColorMatrix bwMatrix = new ColorMatrix();
        bwMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(bwMatrix);
        Bitmap rBitmap = sampleBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);
        Canvas myCanvas = new Canvas(rBitmap);
        myCanvas.drawBitmap(rBitmap, 0.0f, 0.0f, paint);
        return rBitmap;
    }

    public static Bitmap addQRQuietZone(Bitmap qrBitmap) {
        int size = Math.min(qrBitmap.getWidth(), qrBitmap.getHeight());
        int boundary = size / 5;
        Bitmap white = Bitmap.createBitmap(qrBitmap.getWidth() + (boundary * 2), qrBitmap.getWidth() + (boundary * 2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(white);
        canvas.drawColor(-1);
        canvas.drawBitmap(qrBitmap, boundary, boundary, (Paint) null);
        return white;
    }

    public static Bitmap createContrast(Bitmap src, double value, int brightness) {
        int B = src.getWidth();
        int height = src.getHeight();
        Bitmap bmOut = Bitmap.createBitmap(B, height, src.getConfig());
        double contrast = Math.pow((value + 100.0d) / 100.0d, 2.0d);
        for (int x = 0; x < B; x++) {
            int y = 0;
            while (y < height) {
                int pixel = src.getPixel(x, y);
                int A = Color.alpha(pixel);
                int R = ((int) (((((((double) Color.red(pixel)) / 255.0d) - 0.5d) * contrast) + 0.5d) * 255.0d)) + brightness;
                if (R < 0) {
                    R = 0;
                } else if (R > 255) {
                    R = 255;
                }
                int R2 = R;
                int G = ((int) (((((((double) Color.green(pixel)) / 255.0d) - 0.5d) * contrast) + 0.5d) * 255.0d)) + brightness;
                if (G < 0) {
                    G = 0;
                } else if (G > 255) {
                    G = 255;
                }
                int width = B;
                int height2 = height;
                int B2 = ((int) (((((((double) Color.blue(pixel)) / 255.0d) - 0.5d) * contrast) + 0.5d) * 255.0d)) + brightness;
                if (B2 < 0) {
                    B2 = 0;
                } else if (B2 > 255) {
                    B2 = 255;
                }
                bmOut.setPixel(x, y, Color.argb(A, R2, G, B2));
                y++;
                B = width;
                height = height2;
            }
        }
        return bmOut;
    }

    public static Bitmap convertGreyImgByFloyd(Bitmap img) {
        int e;
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        img.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] gray = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[(width * i) + j];
                int red = (16711680 & grey) >> 16;
                gray[(width * i) + j] = red;
            }
        }
        for (int i2 = 0; i2 < height; i2++) {
            for (int j2 = 0; j2 < width; j2++) {
                int g = gray[(width * i2) + j2];
                if (g >= 128) {
                    pixels[(width * i2) + j2] = -1;
                    e = g - 255;
                } else {
                    int e2 = width * i2;
                    pixels[e2 + j2] = BLACK;
                    e = g + 0;
                }
                if (j2 < width - 1 && i2 < height - 1) {
                    int i3 = (width * i2) + j2 + 1;
                    gray[i3] = gray[i3] + ((e * 3) / 8);
                    int i4 = ((i2 + 1) * width) + j2;
                    gray[i4] = gray[i4] + ((e * 3) / 8);
                    int i5 = ((i2 + 1) * width) + j2 + 1;
                    gray[i5] = gray[i5] + (e / 4);
                } else if (j2 == width - 1 && i2 < height - 1) {
                    int i6 = ((i2 + 1) * width) + j2;
                    gray[i6] = gray[i6] + ((e * 3) / 8);
                } else if (j2 < width - 1 && i2 == height - 1) {
                    int i7 = (width * i2) + j2 + 1;
                    gray[i7] = gray[i7] + (e / 4);
                }
            }
        }
        Bitmap mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        mBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return mBitmap;
    }

    public static Bitmap convertGreyImgByFloyd2(Bitmap img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        img.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] gray = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[(width * i) + j];
                gray[(width * i) + j] = grey & 255;
            }
        }
        for (int i2 = 0; i2 < height; i2++) {
            for (int j2 = 0; j2 < width; j2++) {
                int g = gray[(width * i2) + j2];
                int newPixel = (g >> 7) * 255;
                int e = g - newPixel;
                pixels[(width * i2) + j2] = newPixel > 0 ? -1 : BLACK;
                if (j2 + 1 < width) {
                    int i3 = (width * i2) + j2 + 1;
                    gray[i3] = gray[i3] + ((e * 7) / 16);
                }
                if (j2 - 1 >= 0 && i2 + 1 < height) {
                    int i4 = (((i2 + 1) * width) + j2) - 1;
                    gray[i4] = gray[i4] + ((e * 3) / 16);
                }
                if (i2 + 1 < height) {
                    int i5 = ((i2 + 1) * width) + j2;
                    gray[i5] = gray[i5] + ((e * 5) / 16);
                }
                if (j2 + 1 < width && i2 + 1 < height) {
                    int i6 = ((i2 + 1) * width) + j2 + 1;
                    gray[i6] = gray[i6] + ((e * 1) / 16);
                }
            }
        }
        Bitmap mBitmap = Bitmap.createBitmap(width, height, img.getConfig());
        mBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return mBitmap;
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public static Bitmap getResizedBitmap(Bitmap source, float scaleX, float scaleY) {
        if (source == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(scaleX, scaleY);
        Bitmap bitmap = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        return bitmap;
    }

    public static Result decodeQRImage(Bitmap bitmap) {
        Bitmap blackWhite = ConvertToBlackAndWhite(bitmap);
        int width = blackWhite.getWidth();
        int height = blackWhite.getHeight();
        int[] pixels = new int[width * height];
        blackWhite.getPixels(pixels, 0, width, 0, 0, width, height);
        RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);
        BinaryBitmap bBitmap = new BinaryBitmap(new HybridBinarizer(source));
        MultiFormatReader reader = new MultiFormatReader();
        try {
            Result result = reader.decode(bBitmap);
            return result;
        } catch (NotFoundException e) {
            Log.e(TAG, "direct decode exception", e);
            HashMap<DecodeHintType, Object> map = new HashMap<>();
            map.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            try {
                Result result2 = reader.decode(bBitmap, map);
                return result2;
            } catch (NotFoundException ex) {
                Log.e(TAG, "DecodeHintType.PURE_BARCODE exception", ex);
                return null;
            }
        }
    }
}
