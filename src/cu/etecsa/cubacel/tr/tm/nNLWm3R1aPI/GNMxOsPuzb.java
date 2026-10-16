package cu.etecsa.cubacel.tr.tm.nNLWm3R1aPI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import cu.etecsa.cubacel.tr.tm.R;

/* JADX INFO: loaded from: classes.dex */
public class GNMxOsPuzb extends Fragment {
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

    public static GNMxOsPuzb newInstance(int layoutResId) {
        GNMxOsPuzb simpleSlide = new GNMxOsPuzb();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        simpleSlide.setArguments(args);
        return simpleSlide;
    }

    public static GNMxOsPuzb newInstance(int layoutResId, String title, String message, int acolor_backgroud) {
        GNMxOsPuzb simpleSlide = new GNMxOsPuzb();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        args.putString(ARG_LAYOUT_TITULO, title);
        args.putString(ARG_LAYOUT_MENSAJE, message);
        args.putInt(ARG_LAYOUT_COLOR, acolor_backgroud);
        simpleSlide.setArguments(args);
        return simpleSlide;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            this.layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
        this.titulo = getArguments().getString(ARG_LAYOUT_TITULO);
        this.mensaje = getArguments().getString(ARG_LAYOUT_MENSAJE);
        this.aColor = getArguments().getInt(ARG_LAYOUT_COLOR);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(this.layoutResId, container, false);
        this.rootView = viewInflate;
        this.textTitle = (TextView) viewInflate.findViewById(R.id.textTitle);
        this.textMessage = (TextView) this.rootView.findViewById(R.id.textMessage);
        int i = this.aColor;
        if (-16711681 == i || -256 == i || -16777216 == i) {
            this.textTitle.setTextColor(-16777216);
            this.textMessage.setTextColor(-16777216);
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.main);
        this.aLayout = linearLayout;
        linearLayout.setBackgroundColor(this.aColor);
        this.textTitle.setText(this.titulo);
        this.textMessage.setText(this.mensaje);
        return this.rootView;
    }
}
