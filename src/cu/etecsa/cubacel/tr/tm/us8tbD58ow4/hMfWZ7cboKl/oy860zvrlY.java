package cu.etecsa.cubacel.tr.tm.us8tbD58ow4.hMfWZ7cboKl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cu.etecsa.cubacel.tr.tm.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class oy860zvrlY extends ArrayAdapter<tGolNOl3DN> {
    private boolean esFormatoImporte;
    private BXJNp1qv2n monedaActual;

    public oy860zvrlY(Context context, List<tGolNOl3DN> objects) {
        super(context, 0, objects);
        this.monedaActual = BXJNp1qv2n.CUP;
        this.esFormatoImporte = false;
    }

    public void setMonedaActual(BXJNp1qv2n moneda) {
        this.monedaActual = moneda;
        notifyDataSetChanged();
    }

    public void setEsFormatoImporte(boolean esImporte) {
        this.esFormatoImporte = esImporte;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        String valorFormateado;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.m2tzzitxiucdl9, parent, false);
        }
        View fondo = convertView.findViewById(R.id.colorLeyenda);
        TextView title = (TextView) convertView.findViewById(R.id.textLeyenda);
        TextView valor = (TextView) convertView.findViewById(R.id.textValor);
        tGolNOl3DN uyh0pxs9m37in = (tGolNOl3DN) getItem(position);
        fondo.setBackgroundColor(uyh0pxs9m37in.getColor());
        title.setText(uyh0pxs9m37in.getLeyenda());
        if (uyh0pxs9m37in.getValor() > 0.0f) {
            if (this.esFormatoImporte) {
                valorFormateado = String.format("%.2f", Float.valueOf(uyh0pxs9m37in.getValor()));
            } else {
                valorFormateado = String.format("%.0f", Float.valueOf(uyh0pxs9m37in.getValor()));
            }
            valor.setText(valorFormateado);
            valor.setVisibility(0);
        } else {
            valor.setVisibility(8);
        }
        return convertView;
    }
}
