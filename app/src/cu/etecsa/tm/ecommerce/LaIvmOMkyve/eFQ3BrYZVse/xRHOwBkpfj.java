package cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.LWt69JQUoH;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.p0XuqX2hWag;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.sR8QMZUZBy;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.HLAV6HkYgi;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.Y4BGwPjdRJT;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xRHOwBkpfj extends Fragment implements KFxuVD3dg2, m7xsfApYLch {
    public String HEAD_LOG = "xRHOwBkpfj";
    public Activity activity;
    public CardView cdMonedaDefecto;
    public Context context;
    public String[] cuentas;
    public HLAV6HkYgi cuentasPresenter;
    public Y4BGwPjdRJT hashtagPresenter;
    public String[] hashtags;
    public List<LWt69JQUoH> listCuentas;
    public String[] monedas;
    public View rootView;
    public Switch swHahstag;
    public Switch swModoCompacto;
    public Switch swModoNotificacion;
    public Switch swPredeterminar;
    public TextView txCuentaDefecto;
    public TextView txEstadoModoCompacto;
    public TextView txHashtag;
    public TextView txMonedaDefecto;
    public TextView txmodoNotifacion;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.rootView = inflater.inflate(R.layout.cqudrcbw7xmti, container, false);
        this.context = container.getContext();
        Switch r0 = (Switch) this.rootView.findViewById(R.id.swPredeterminar);
        this.swPredeterminar = r0;
        r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    xRHOwBkpfj xrhowbkpfj = xRHOwBkpfj.this;
                    String[] strArr = xrhowbkpfj.cuentas;
                    if (strArr != null && strArr.length > 0) {
                        xrhowbkpfj.mostrarCuentasSeleccionDialog(strArr);
                        return;
                    }
                    return;
                }
                UhA7J2923N.getInstance().setPrefAccount(BuildConfig.FLAVOR);
                xRHOwBkpfj xrhowbkpfj2 = xRHOwBkpfj.this;
                xrhowbkpfj2.txCuentaDefecto.setText(xrhowbkpfj2.context.getText(R.string.tx_no_definida));
            }
        });
        this.txCuentaDefecto = (TextView) this.rootView.findViewById(R.id.txCuentaDefecto);
        this.txMonedaDefecto = (TextView) this.rootView.findViewById(R.id.txMonedaDefecto);
        this.cdMonedaDefecto = (CardView) this.rootView.findViewById(R.id.cdMonedaDefecto);
        this.monedas = getResources().getStringArray(R.array.currency_no_cuc);
        this.cdMonedaDefecto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String monedaPredeterminada = UhA7J2923N.getInstance().getPrefCurrency();
                int posicionPredeterminada = 0;
                if (monedaPredeterminada != null && monedaPredeterminada.length() > 0) {
                    int i = 0;
                    while (true) {
                        String[] strArr = xRHOwBkpfj.this.monedas;
                        if (i >= strArr.length) {
                            break;
                        }
                        if (!strArr[i].contains(monedaPredeterminada)) {
                            i++;
                        } else {
                            posicionPredeterminada = i;
                            break;
                        }
                    }
                }
                xRHOwBkpfj xrhowbkpfj = xRHOwBkpfj.this;
                xrhowbkpfj.mostrarMonedaSeleccionDialog(xrhowbkpfj.monedas, posicionPredeterminada);
            }
        });
        HLAV6HkYgi hLAV6HkYgi = new HLAV6HkYgi(this, this.context);
        this.cuentasPresenter = hLAV6HkYgi;
        hLAV6HkYgi.getCuentas();
        Y4BGwPjdRJT y4BGwPjdRJT = new Y4BGwPjdRJT(this, this.context);
        this.hashtagPresenter = y4BGwPjdRJT;
        y4BGwPjdRJT.getHashtag();
        this.swModoCompacto = (Switch) this.rootView.findViewById(R.id.swPredeterminarModoCompacto);
        this.txEstadoModoCompacto = (TextView) this.rootView.findViewById(R.id.txmodoCompacto);
        this.swModoCompacto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UhA7J2923N.getInstance().setCompactMode("ON");
                    xRHOwBkpfj.this.txEstadoModoCompacto.setText("ACTIVO");
                } else {
                    UhA7J2923N.getInstance().setCompactMode(BuildConfig.FLAVOR);
                    xRHOwBkpfj xrhowbkpfj = xRHOwBkpfj.this;
                    xrhowbkpfj.txEstadoModoCompacto.setText(xrhowbkpfj.context.getText(R.string.tx_no_definida));
                }
            }
        });
        this.swModoNotificacion = (Switch) this.rootView.findViewById(R.id.swModoNotificacion);
        this.txmodoNotifacion = (TextView) this.rootView.findViewById(R.id.txmodoNotifacion);
        this.swModoNotificacion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UhA7J2923N.getInstance().setComunicationMode("ON");
                    xRHOwBkpfj xrhowbkpfj = xRHOwBkpfj.this;
                    xrhowbkpfj.txmodoNotifacion.setText(xrhowbkpfj.context.getText(R.string.tx_estado_beta));
                } else {
                    UhA7J2923N.getInstance().setComunicationMode(BuildConfig.FLAVOR);
                    xRHOwBkpfj xrhowbkpfj2 = xRHOwBkpfj.this;
                    xrhowbkpfj2.txmodoNotifacion.setText(xrhowbkpfj2.context.getText(R.string.tx_por_defecto));
                }
            }
        });
        this.txHashtag = (TextView) this.rootView.findViewById(R.id.txHashtag);
        this.swHahstag = (Switch) this.rootView.findViewById(R.id.swHahstag);
        initData();
        return this.rootView;
    }

    public void initData() {
        String cuentaPref = UhA7J2923N.getInstance().getPrefAccount();
        if (cuentaPref != null && cuentaPref.length() > 0) {
            this.txCuentaDefecto.setText(cuentaPref);
            this.swPredeterminar.setChecked(true);
        }
        String moneda = UhA7J2923N.getInstance().getPrefCurrency();
        if (moneda != null && moneda.length() > 0) {
            this.txMonedaDefecto.setText(moneda);
        }
        String compactoState = UhA7J2923N.getInstance().getCompactMode();
        if (compactoState != null && compactoState.length() > 0 && compactoState.contains("ON")) {
            this.txEstadoModoCompacto.setText("ACTIVO");
            this.swModoCompacto.setChecked(true);
        } else {
            this.txEstadoModoCompacto.setText(this.context.getText(R.string.tx_no_definida));
            this.swModoCompacto.setChecked(false);
        }
        String comunicationState = UhA7J2923N.getInstance().getComunicationMode();
        if (comunicationState != null && comunicationState.length() > 0 && comunicationState.contains("ON")) {
            this.txmodoNotifacion.setText(this.context.getString(R.string.tx_estado_beta));
            this.swModoNotificacion.setChecked(true);
        } else {
            this.txmodoNotifacion.setText(this.context.getString(R.string.tx_por_defecto));
            this.swModoNotificacion.setChecked(false);
        }
        UhA7J2923N.getInstance();
        String hastTagPref = UhA7J2923N.getHashtagDefault();
        if (hastTagPref != null && hastTagPref.length() > 0) {
            this.txHashtag.setText(hastTagPref);
            this.swHahstag.setChecked(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_empy, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, int code, String mensaje, sR8QMZUZBy response) {
        if (result.booleanValue()) {
            if (!fillCuentas(response.getItemsList())) {
                Toast.makeText(this.context, "Error cargando las cuentas", 1).show();
            }
        } else if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(this.activity);
        } else {
            Toast.makeText(this.context, mensaje, 1).show();
        }
    }

    private boolean fillCuentas(List<LWt69JQUoH> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.listCuentas = list;
                    this.cuentas = new String[list.size()];
                    int i = 0;
                    for (LWt69JQUoH item : list) {
                        this.cuentas[i] = item.getSource() + " - " + item.getName();
                        i++;
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2
    public void onCuentasResult(Boolean result, HLAV6HkYgi.OperTypeCuentas operTypeCuentas, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onResultTags(Boolean result, int code, String mensaje, p0XuqX2hWag response) {
        if (result.booleanValue() && response.getHashtag().length > 0) {
            this.hashtags = response.getHashtag();
            this.swHahstag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        xRHOwBkpfj xrhowbkpfj = xRHOwBkpfj.this;
                        String[] strArr = xrhowbkpfj.hashtags;
                        if (strArr != null && strArr.length > 0) {
                            xrhowbkpfj.mostrarHashTagsDialog(strArr);
                            return;
                        } else {
                            Toast.makeText(xrhowbkpfj.context, "No hay comentarios cargados", 1).show();
                            xRHOwBkpfj.this.swHahstag.setChecked(false);
                            return;
                        }
                    }
                    UhA7J2923N.getInstance().setPrefAccount(BuildConfig.FLAVOR);
                    xRHOwBkpfj xrhowbkpfj2 = xRHOwBkpfj.this;
                    xrhowbkpfj2.txHashtag.setText(xrhowbkpfj2.context.getText(R.string.tx_no_definida));
                }
            });
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.KFxuVD3dg2, cu.etecsa.tm.ecommerce.HOOahyDFMGH.SRIeLPPchM, cu.etecsa.tm.ecommerce.HOOahyDFMGH.m7xsfApYLch
    public void onSetProgressBarVisibility(int visibility) {
    }

    public void mostrarCuentasSeleccionDialog(final String[] cuentas) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.6
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(xRHOwBkpfj.this.getContext());
                builder.setTitle("Seleccione la cuenta");
                final int[] seleccion = {0};
                builder.setSingleChoiceItems(cuentas, 0, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        seleccion[0] = which;
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.6.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (!xRHOwBkpfj.this.setAccount(seleccion[0])) {
                            Toast.makeText(xRHOwBkpfj.this.getContext(), "Error estableciendo la cuenta.", 1).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.6.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        xRHOwBkpfj.this.swPredeterminar.setChecked(false);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void mostrarHashTagsDialog(final String[] hashtags) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.7
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(xRHOwBkpfj.this.getContext());
                builder.setTitle("Seleccione el Hashtag a predeterminar");
                final int[] seleccion = {0};
                builder.setSingleChoiceItems(hashtags, 0, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        seleccion[0] = which;
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.7.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (!xRHOwBkpfj.this.setHashtag(seleccion[0])) {
                            Toast.makeText(xRHOwBkpfj.this.getContext(), "Error estableciendo la cuenta.", 1).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.7.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        xRHOwBkpfj.this.swHahstag.setChecked(false);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public boolean setAccount(int pos) {
        try {
            LWt69JQUoH item = this.listCuentas.get(pos);
            UhA7J2923N.getInstance().setPrefAccount(item.getSource());
            this.txCuentaDefecto.setText(item.getSource() + " - " + item.getName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setHashtag(int pos) {
        try {
            UhA7J2923N.getInstance().setHashtagDefault(this.hashtags[pos]);
            this.txHashtag.setText(this.hashtags[pos]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void mostrarMonedaSeleccionDialog(final String[] monedas, final int checkedItem) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.8
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(xRHOwBkpfj.this.getContext());
                builder.setTitle("Seleccione la moneda por defecto");
                final int[] seleccion = {0};
                builder.setSingleChoiceItems(monedas, checkedItem, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.8.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        seleccion[0] = which;
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.8.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        UhA7J2923N.getInstance().setPrefCurrency(monedas[seleccion[0]]);
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        xRHOwBkpfj.this.txMonedaDefecto.setText(monedas[seleccion[0]]);
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.eFQ3BrYZVse.xRHOwBkpfj.8.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
