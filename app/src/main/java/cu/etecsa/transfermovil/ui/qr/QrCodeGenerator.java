package cu.etecsa.transfermovil.ui.qr;

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

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.h4VIMAs7y2v.ZUoEY89WdA
 * @fingerprint Static QR code generation and image processing utility.
 *              Methods: Product (image-embedded QR), ProductEmbed (overlay on origin bitmap),
 *              ProductNormal (plain scaled QR), ProductForResult (low ECC for dense data),
 *              ProductLogo (QR with centered logo), ProductGIF (animated QR frames).
 *              Image processing: Floyd-Steinberg dithering (two variants), contrast adjustment,
 *              B&W conversion, rotation, scaling, QR decoding from bitmap.
 */
public class QrCodeGenerator {

    private static final int BLACK = -16777216;
    private static final float FULL_LOGO_QR = 507.1f;
    private static final float LOGO_BACKGROUND = 140.7f;
    private static final float LOGO_SIZE = 126.7f;
    private static final int MAX_INPUT_GIF_SIZE = 480;
    private static final int MAX_LOGO_SIZE = 1080;
    private static final int SCALE_NORMAL_QR = 10;
    private static final String TAG = "QrCodeGenerator";
    private static final int WHITE = -1;
    private static int[] patternCenters;
    private static int scaleQR;

    public static Bitmap Product(String txt, Bitmap input, boolean colorful, int color) throws WriterException {
        Bitmap QRImage = null;
        try {
            QRImage = encodeAsBitmap(txt);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
        }
        if (colorful && color != BLACK) {
            QRImage = replaceColor(QRImage, color);
        }
        int inputSize = Math.max(input.getWidth(), input.getHeight());
        int scale = (int) Math.ceil(((double) inputSize) / ((double) QRImage.getWidth()));
        if (scale % 3 != 0) {
            scale += 3 - (scale % 3);
        }
        scaleQR = scale;
        Bitmap scaledQRImage = Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * scale, QRImage.getHeight() * scale, false);
        Bitmap resizedImage;
        int imageSize;
        if (input.getWidth() < input.getHeight()) {
            resizedImage = Bitmap.createScaledBitmap(input,
                    scaledQRImage.getWidth() - ((scale * 4) * 2),
                    (int) (((double) (scaledQRImage.getHeight() - ((scale * 4) * 2))) * (((double) input.getHeight()) / ((double) input.getWidth()))),
                    false);
            imageSize = resizedImage.getWidth();
        } else {
            resizedImage = Bitmap.createScaledBitmap(input,
                    (int) (((double) (scaledQRImage.getWidth() - ((scale * 4) * 2))) * (((double) input.getWidth()) / ((double) input.getHeight()))),
                    scaledQRImage.getHeight() - ((scale * 4) * 2),
                    false);
            imageSize = resizedImage.getHeight();
        }
        int fullWidth = scaledQRImage.getWidth();
        int[][] pattern = (int[][]) Array.newInstance(Integer.TYPE, fullWidth - ((scale * 4) * 2), fullWidth - ((scale * 4) * 2));
        for (int i = 0; i < patternCenters.length; i++) {
            for (int j = 0; j < patternCenters.length; j++) {
                int pi = patternCenters[i];
                int pj = patternCenters[j];
                if (pi == 6 && pj == patternCenters[patternCenters.length - 1]) continue;
                if (pj == 6 && pi == patternCenters[patternCenters.length - 1]) continue;
                if (pi == 6 && pj == 6) continue;
                int initx = (pi - 2) * scale;
                int inity = (pj - 2) * scale;
                for (int x = initx; x < (scale * 5) + initx; x++) {
                    for (int y = inity; y < inity + (scale * 5); y++) {
                        pattern[x][y] = 1;
                    }
                }
            }
        }
        Bitmap blackWhite = colorful ? resizedImage : convertBlackWhiteFull(resizedImage);
        for (int i = 0; i < imageSize; i++) {
            for (int j = 0; j < imageSize; j++) {
                if ((((i * 3) / scale) % 3 != 1 || ((j * 3) / scale) % 3 != 1)
                        && ((i >= scale * 4 * 2 || (j >= scale * 4 * 2 && j <= imageSize - (((scale * 4) * 2) + 1)))
                        && ((i <= imageSize - (((scale * 4) * 2) + 1) || j >= scale * 4 * 2)
                        && pattern[i][j] != 1))) {
                    scaledQRImage.setPixel((scale * 4) + i, (scale * 4) + j, blackWhite.getPixel(i, j));
                }
            }
        }
        return scaledQRImage;
    }

    public static Bitmap convertBlackWhiteFull(Bitmap blackWhite) {
        return convertGreyImgByFloyd2(ConvertToBlackAndWhite(createContrast(blackWhite, 50.0d, 30)));
    }

    public static Bitmap ProductEmbed(String txt, Bitmap input, boolean colorful, int color, int x, int y, Bitmap originBitmap) throws WriterException {
        int originalSize = input.getWidth();
        Bitmap qrBitmap = Product(txt, input, colorful, color);
        double newScale = (((double) originalSize) * ((double) scaleQR)) / ((double) (qrBitmap.getWidth() - (scaleQR * 8)));
        int targetSize = (qrBitmap.getWidth() * originalSize) / (qrBitmap.getWidth() - (scaleQR * 8));
        Bitmap qrBitmap2 = Bitmap.createScaledBitmap(resizeQuietZone(qrBitmap, newScale), targetSize, targetSize, false);
        Bitmap result = originBitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(qrBitmap2, x - ((int) (newScale * 4.0d)), y - ((int) (4.0d * newScale)), null);
        return result;
    }

    private static Bitmap resizeQuietZone(Bitmap qrBitmap, double scale) {
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
            return Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * SCALE_NORMAL_QR, QRImage.getHeight() * SCALE_NORMAL_QR, false);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
            return null;
        }
    }

    public static Bitmap ProductForResult(String txt) {
        try {
            Bitmap QRImage = encodeAsBitmap(txt, ErrorCorrectionLevel.L);
            return Bitmap.createScaledBitmap(QRImage, QRImage.getWidth() * SCALE_NORMAL_QR, QRImage.getHeight() * SCALE_NORMAL_QR, false);
        } catch (WriterException e) {
            Log.e(TAG, "encodeAsBitmap: " + e);
            return null;
        }
    }

    public static Bitmap ProductLogo(Bitmap logo, String txt, boolean colorful, int color) {
        try {
            Bitmap qrImage = ProductNormal(txt, colorful, color);
            int fullSize = qrImage.getWidth() - 80;
            int finalSize = Math.min((int) ((logo.getWidth() * FULL_LOGO_QR) / LOGO_SIZE), MAX_LOGO_SIZE);
            int scale = SCALE_NORMAL_QR;
            if (finalSize > fullSize) {
                scale = (finalSize * SCALE_NORMAL_QR) / fullSize;
                qrImage = Bitmap.createScaledBitmap(qrImage,
                        (qrImage.getWidth() * finalSize) / fullSize,
                        (qrImage.getHeight() * finalSize) / fullSize, false);
                fullSize = finalSize;
            }
            int background = (int) ((fullSize * LOGO_BACKGROUND) / FULL_LOGO_QR);
            int logoSize = (int) ((fullSize * LOGO_SIZE) / FULL_LOGO_QR);
            Bitmap white = Bitmap.createBitmap(background, background, Bitmap.Config.ARGB_8888);
            int boundary = (background - logoSize) / 2;
            Canvas canvas = new Canvas(white);
            canvas.drawColor(WHITE);
            Bitmap scaleLogo = Bitmap.createScaledBitmap(logo, logoSize, logoSize, false);
            canvas.drawBitmap(fillBoundary(scaleLogo, boundary, WHITE), boundary, boundary, null);
            canvas.save();
            Bitmap white2 = fillBoundary(white, boundary, 0);
            Canvas canvasQR = new Canvas(qrImage);
            canvasQR.drawBitmap(white2,
                    (scale * 4) + ((fullSize - background) / 2),
                    (scale * 4) + ((fullSize - background) / 2), null);
            return qrImage;
        } catch (WriterException e) {
            Log.e(TAG, "ProductLogo: " + e);
            return null;
        }
    }

    private static Bitmap fillBoundary(Bitmap bitmap, int boundary, int color) {
        int size = bitmap.getWidth();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double dist;
                if (i < boundary && j < boundary) {
                    dist = Math.pow(boundary - i, 2.0d) + Math.pow(boundary - j, 2.0d);
                } else if (i < boundary && j > size - (boundary + 1)) {
                    dist = Math.pow(boundary - i, 2.0d) + Math.pow((size - (boundary + 1)) - j, 2.0d);
                } else if (i > size - (boundary + 1) && j < boundary) {
                    dist = Math.pow((size - (boundary + 1)) - i, 2.0d) + Math.pow(boundary - j, 2.0d);
                } else if (i > size - (boundary + 1) && j > size - (boundary + 1)) {
                    dist = Math.pow((size - (boundary + 1)) - i, 2.0d) + Math.pow((size - (boundary + 1)) - j, 2.0d);
                } else {
                    continue;
                }
                if (dist > Math.pow(boundary, 2.0d)) {
                    bitmap.setPixel(i, j, color);
                }
            }
        }
        return bitmap;
    }

    public static Bitmap[] ProductGIF(String txt, Bitmap[] input, boolean colorful, int color) {
        int size = input[0].getWidth();
        Bitmap[] output = new Bitmap[input.length];
        for (int i = 0; i < input.length; i++) {
            Bitmap frame = input[i];
            if (size > MAX_INPUT_GIF_SIZE) {
                frame = Bitmap.createScaledBitmap(frame, MAX_INPUT_GIF_SIZE, MAX_INPUT_GIF_SIZE, false);
            }
            output[i] = Product(txt, frame, colorful, color);
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

    public static Bitmap encodeAsBitmap(String txt) throws WriterException {
        return encodeAsBitmap(txt, ErrorCorrectionLevel.H);
    }

    public static Bitmap encodeAsBitmap(String txt, ErrorCorrectionLevel level) throws WriterException {
        if (txt == null) return null;
        Object encoding = guessAppropriateEncoding(txt);
        Map<EncodeHintType, Object> hints = null;
        if (encoding != null) {
            hints = new EnumMap<>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
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
                    pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
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
        if (input == null) throw new IllegalStateException();
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
                if (input.get(inputX, inputY) == 1) {
                    output.setRegion(outputX, outputY, multiple, multiple);
                }
                inputX++;
                outputX += multiple;
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

    public static Bitmap createContrast(Bitmap src, double value, int brightness) {
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        double contrast = Math.pow((value + 100.0d) / 100.0d, 2.0d);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = src.getPixel(x, y);
                int A = Color.alpha(pixel);
                int R = ((int) (((((double) Color.red(pixel)) / 255.0d - 0.5d) * contrast + 0.5d) * 255.0d)) + brightness;
                R = Math.max(0, Math.min(255, R));
                int G = ((int) (((((double) Color.green(pixel)) / 255.0d - 0.5d) * contrast + 0.5d) * 255.0d)) + brightness;
                G = Math.max(0, Math.min(255, G));
                int B = ((int) (((((double) Color.blue(pixel)) / 255.0d - 0.5d) * contrast + 0.5d) * 255.0d)) + brightness;
                B = Math.max(0, Math.min(255, B));
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        return bmOut;
    }

    /**
     * Floyd-Steinberg dithering variant 1: simplified 3/8, 3/8, 1/4 error distribution.
     */
    public static Bitmap convertGreyImgByFloyd(Bitmap img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        img.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] gray = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gray[(width * i) + j] = (pixels[(width * i) + j] & 0x00FF0000) >> 16;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int g = gray[(width * i) + j];
                int e;
                if (g >= 128) {
                    pixels[(width * i) + j] = WHITE;
                    e = g - 255;
                } else {
                    pixels[(width * i) + j] = BLACK;
                    e = g;
                }
                if (j < width - 1 && i < height - 1) {
                    gray[(width * i) + j + 1] += (e * 3) / 8;
                    gray[((i + 1) * width) + j] += (e * 3) / 8;
                    gray[((i + 1) * width) + j + 1] += e / 4;
                } else if (j == width - 1 && i < height - 1) {
                    gray[((i + 1) * width) + j] += (e * 3) / 8;
                } else if (j < width - 1 && i == height - 1) {
                    gray[(width * i) + j + 1] += e / 4;
                }
            }
        }
        Bitmap mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        mBitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return mBitmap;
    }

    /**
     * Floyd-Steinberg dithering variant 2: standard 7/16, 3/16, 5/16, 1/16 weights.
     */
    public static Bitmap convertGreyImgByFloyd2(Bitmap img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        img.getPixels(pixels, 0, width, 0, 0, width, height);
        int[] gray = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gray[(width * i) + j] = pixels[(width * i) + j] & 0xFF;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int g = gray[(width * i) + j];
                int newPixel = (g >> 7) * 255;
                int e = g - newPixel;
                pixels[(width * i) + j] = newPixel > 0 ? WHITE : BLACK;
                if (j + 1 < width)
                    gray[(width * i) + j + 1] += (e * 7) / 16;
                if (j - 1 >= 0 && i + 1 < height)
                    gray[(((i + 1) * width) + j) - 1] += (e * 3) / 16;
                if (i + 1 < height)
                    gray[((i + 1) * width) + j] += (e * 5) / 16;
                if (j + 1 < width && i + 1 < height)
                    gray[((i + 1) * width) + j + 1] += e / 16;
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
        if (source == null) return null;
        Matrix matrix = new Matrix();
        matrix.setScale(scaleX, scaleY);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
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
            return reader.decode(bBitmap);
        } catch (NotFoundException e) {
            Log.e(TAG, "direct decode exception", e);
            HashMap<DecodeHintType, Object> map = new HashMap<>();
            map.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            try {
                return reader.decode(bBitmap, map);
            } catch (NotFoundException ex) {
                Log.e(TAG, "PURE_BARCODE decode exception", ex);
                return null;
            }
        }
    }

    public static Bitmap addQRQuietZone(Bitmap qrBitmap) {
        int size = Math.min(qrBitmap.getWidth(), qrBitmap.getHeight());
        int boundary = size / 5;
        Bitmap white = Bitmap.createBitmap(qrBitmap.getWidth() + (boundary * 2), qrBitmap.getWidth() + (boundary * 2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(white);
        canvas.drawColor(WHITE);
        canvas.drawBitmap(qrBitmap, boundary, boundary, null);
        return white;
    }

    public static Bitmap replaceQR(Bitmap qrBitmap, Bitmap image) {
        int width = qrBitmap.getWidth();
        int height = qrBitmap.getHeight();
        int[] pixels = new int[width * height];
        qrBitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pixels[(width * i) + j] != WHITE) {
                    image.setPixel(i, j, pixels[(width * i) + j]);
                }
            }
        }
        return image;
    }
}
