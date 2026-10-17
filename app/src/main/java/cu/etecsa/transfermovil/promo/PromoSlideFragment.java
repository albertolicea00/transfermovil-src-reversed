package cu.etecsa.transfermovil.promo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import cu.etecsa.transfermovil.R;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI.GNMxOsPuzb
 * @fingerprint AppIntro slide fragment displaying one promo. Sets background color,
 *              adjusts text to black for cyan/yellow/black backgrounds.
 */
public class PromoSlideFragment extends Fragment {

    private static final String ARG_LAYOUT_COLOR = "layoutResColor";
    private static final String ARG_LAYOUT_MENSAJE = "layoutResMensaje";
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    private static final String ARG_LAYOUT_TITULO = "layoutRestTitulo";
    public int aColor;
    public LinearLayout aLayout;
    private int layoutResId;
    private String mensaje;
    public View rootView;
    public TextView textMessage;
    public TextView textTitle;
    private String titulo;

    public static PromoSlideFragment newInstance(int layoutResId) {
        PromoSlideFragment slide = new PromoSlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        slide.setArguments(args);
        return slide;
    }

    public static PromoSlideFragment newInstance(int layoutResId, String title, String message, int backgroundColor) {
        PromoSlideFragment slide = new PromoSlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        args.putString(ARG_LAYOUT_TITULO, title);
        args.putString(ARG_LAYOUT_MENSAJE, message);
        args.putInt(ARG_LAYOUT_COLOR, backgroundColor);
        slide.setArguments(args);
        return slide;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            this.layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
        this.titulo = getArguments().getString(ARG_LAYOUT_TITULO);
        this.mensaje = getArguments().getString(ARG_LAYOUT_MENSAJE);
        this.aColor = getArguments().getInt(ARG_LAYOUT_COLOR);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(this.layoutResId, container, false);
        this.rootView = view;
        this.textTitle = (TextView) view.findViewById(R.id.textTitle);
        this.textMessage = (TextView) this.rootView.findViewById(R.id.textMessage);
        int color = this.aColor;
        // cyan=-16711681, yellow=-256, black=-16777216
        if (-16711681 == color || -256 == color || -16777216 == color) {
            this.textTitle.setTextColor(-16777216);
            this.textMessage.setTextColor(-16777216);
        }
        LinearLayout layout = (LinearLayout) this.rootView.findViewById(R.id.main);
        this.aLayout = layout;
        layout.setBackgroundColor(this.aColor);
        this.textTitle.setText(this.titulo);
        this.textMessage.setText(this.mensaje);
        return this.rootView;
    }
}
