package cu.etecsa.transfermovil.ussd;

import cu.etecsa.transfermovil.base.BaseMainActivity;

import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.U6ucOCBccJ;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.Eqj43O0pUx;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.VW6IL66KC6M.r7Rinp9ooL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.GvNasrezHU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.HZgbT8IXPf;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.LjOlaYSSMH;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.OXpoe3K2m1;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.QVPgkl8ZGC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Wwc5crW71D;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.XnVSHGPTkK;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.Z3kYdPwq6K2;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.b7zSZMAX7cN;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.dI2tctjNbR;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.hjX8MS8xO9;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.i9I9XZGnR3;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.l3GXbXAyUW;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.q55ExEc6x2l;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.s9CT6pjRyD;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.w7mHpmOa4EP;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.wbFn8tBw8W;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.xb7DiohJuX;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.hTZG5yFgyZY.QM5YzxsQFRH.zzyNbaqs1U;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.OfZgAbz2cY8.uWXPvgMX2Iw.t7in6psmmaQ;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.p1CEgMEeWUbD.zpT98w56Knm.EJvHfXHGTV8.RFGGC2VcTY;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.GPsckxvkPu;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.L0JjVr9EwEF;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PTsHXOZ1gC;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.PqTzgaEYF6;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.ROgpLrCtHa;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.SjZHfPJPwX;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.TGMSi5UDp7;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.hqPCcU1E8u;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.kq0rlPklFL;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.n6dAtto0KFy;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.rGY5dubJYU;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.uKzekWA2jf;
import cu.etecsa.cubacel.tr.tm.B0jOLrWx09th.sJ0peDJzVjo.w1lXYiCfJyk;
import cu.etecsa.transfermovil.ui.AgentMainActivity;
import cu.etecsa.cubacel.tr.tm.R;
import cu.etecsa.transfermovil.ui.GeneralMainActivity;
import cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.O2oXWQuRDi;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.FdonIAFI9w;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.AppConfig;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.Operacion;
import cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.unYp8VQThY;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.Nl0yptXmjQ;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.R1sDOSqZ2z;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.RiZsr8xXRC;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.qTDVwLFEjE;
import cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.piM0KeORWQz.y2Cht3lmjg;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.FBsQzP3Zfj
 * @original_apk_version 1.260416
 * Source-backed confirmation, USSD dispatch, bank-session and operation routing.
 * This utility is not an Android Activity; callers supply their UI context.
 * Raw database/enums/navigation destinations remain explicit compatibility edges.
 */
public class UssdDispatcher {
    public AlertDialog alertDialog;
    public int isAcciones;

    public interface UssdBaseObserver {
        void onClose(boolean z);

        void onCloseAndBack();
    }

    public Uri actionCallUSSDBack(Context context, String codeService, String codeToSend) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Uri number = Uri.parse(cadena);
        return number;
    }

    public static final void actionCallUSSDSimple(Context context, String codeService, String codeToSend) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeToSend + "*" + version + Uri.encode("#");
        Uri number = Uri.parse(cadena);
        Intent dial = new Intent("android.intent.action.CALL", number);
        dial.addFlags(268435456);
        if (ContextCompat.checkSelfPermission(context, "android.permission.CALL_PHONE") != 0) {
            return;
        }
        context.startActivity(dial);
    }

    public void clearForm(ViewGroup group) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).setText(BuildConfig.FLAVOR);
            }
            if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                clearForm((ViewGroup) view);
            }
        }
    }

    public static final void actionCallUSSDBack(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        Log.d("TMDESA", "actionCallUSSDBack CODE SEND[" + codeToSend + "] LENGHT[" + codeToSend.length() + "]");
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBack USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    Bundle result = new Bundle();
                    result.putBoolean("returning", true);
                    fragmentManager.setFragmentResult("returnToA", result);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBack454(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = "454";
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        Log.d("TMDESA", "actionCallUSSDBack CODE SEND[" + codeToSend + "] LENGHT[" + codeToSend.length() + "]");
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBack USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    Bundle result = new Bundle();
                    result.putBoolean("returning", true);
                    fragmentManager.setFragmentResult("returnToA", result);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBackAsocClasica(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, FragmentManager fragmentManager, final UssdBaseObserver obs) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        Log.d("TMDESA", "actionCallUSSDBackAsocClasica CODE SEND[" + codeToSend + "] LENGHT[" + codeToSend.length() + "]");
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBackAsocClasica USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    UssdBaseObserver observer = obs;
                    observer.onClose(true);
                } catch (Exception e) {
                    UssdBaseObserver observer2 = obs;
                    observer2.onClose(false);
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                UssdBaseObserver observer = obs;
                observer.onClose(false);
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBackObserver(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager, final UssdBaseObserver obs) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        Log.d("TMDESA", "actionCallUSSDBack CODE SEND[" + codeToSend + "] LENGHT[" + codeToSend.length() + "]");
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBack USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    Bundle result = new Bundle();
                    result.putBoolean("returning", true);
                    fragmentManager.setFragmentResult("returnToA", result);
                    UssdBaseObserver observer = obs;
                    observer.onCloseAndBack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBackHttp(Context context, String codeService, String codeToSend, SpannableString mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBack USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(mensaje_dialog);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final void actionCallUSSDNoBackSimple(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    dialog.dismiss();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBackWithRetun(Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    dialog.dismiss();
                    Bundle result = new Bundle();
                    result.putBoolean("returning", true);
                    fragmentManager.setFragmentResult("returnToA", result);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDNOBack(final Context context, final Activity activity, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "actionCallUSSDBack USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    UssdDispatcher.showDialogCerrarApp(context, activity);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final int callLenght(Context context, String txt) {
        Log.d("TMDESA", "CALLLENGT TEXT[" + txt + "]");
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(txt);
        String cadena = "tel:*" + codeAcceso + "*" + codeSendTo + "*" + version + Uri.encode("#");
        Log.d("TMDESA", "CALLLENGT USSD[" + cadena + "] LENGHT[" + cadena.length() + "]");
        return cadena.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialogCerrarApp(Context context, final Activity activity) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Aviso");
        builder.setMessage("Solicitud enviada, debe retornar a la aplicación donde realizó la compra");
        builder.setPositiveButton("Retornar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "ok");
                activity.setResult(-1, returnIntent);
                activity.finish();
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(false);
        alert.setCancelable(false);
        alert.show();
    }

    public static final void actionCallUSSDBack(final String banco, Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.18
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
                    if (!appConfigs.isEmpty()) {
                        AppConfig app = appConfigs.get(0);
                        app.setCode_bank(banco);
                        Date fecha = new Date();
                        app.setFechaHoraAuthBank(fecha);
                        unYp8VQThY.getInstance().updateAppConfig(app);
                    }
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.19
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void actionCallUSSDBack(final String banco, Context context, String codeService, String codeToSend, String mensaje_dialog, final ViewGroup group, final FragmentManager fragmentManager, final Activity activity) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        unYp8VQThY.init(context);
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        BaseMainActivity bs = new BaseMainActivity();
        String codeSendTo = bs.code(codeToSend);
        String cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.20
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Activity activity2 = activity;
                    if ((activity2 instanceof AgentMainActivity) || (activity2 instanceof GeneralMainActivity)) {
                        activity2.getClass().getName();
                    }
                    List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
                    if (!appConfigs.isEmpty()) {
                        AppConfig app = appConfigs.get(0);
                        app.setCode_bank(banco);
                        Date fecha = new Date();
                        app.setFechaHoraAuthBank(fecha);
                        unYp8VQThY.getInstance().updateAppConfig(app);
                        Activity activity3 = activity;
                        if (activity3 instanceof AgentMainActivity) {
                            ((AgentMainActivity) activity3).UpdateMenu();
                        } else if (activity3 instanceof GeneralMainActivity) {
                            ((GeneralMainActivity) activity3).UpdateMenu();
                        }
                    }
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.21
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final void createAlertDialog(String mensaje_dialog, final ViewGroup group, final Uri number, final FragmentManager fragmentManager) {
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(R.string.confirm);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.22
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                    fragmentManager.popBackStack();
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.23
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static final String validateAuthBank() {
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() <= 0 || appConfigList.get(0).getCode_bank() == BuildConfig.FLAVOR) {
            return "-1";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(appConfigList.get(0).getFechaHoraAuthBank());
        calendar.add(10, 1);
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(new Date());
        return calendar.after(calendarActual) ? appConfigList.get(0).getCode_bank() : "-1";
    }

    public static final boolean validateExperienciaUsuario() {
        try {
            List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigList.size() <= 0) {
                return false;
            }
            if (appConfigList.get(0).getFechaUltimasExperiencias() != null) {
                Calendar calendarUltimaEncuesta = Calendar.getInstance();
                calendarUltimaEncuesta.setTime(appConfigList.get(0).getFechaUltimasExperiencias());
                calendarUltimaEncuesta.add(2, 1);
                Calendar calendarActual = Calendar.getInstance();
                calendarActual.setTime(new Date());
                return calendarUltimaEncuesta.before(calendarActual);
            }
            appConfigList.get(0).setFechaUltimasExperiencias(new Date());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean mostrarPromocion() {
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() <= 0) {
            return false;
        }
        if (appConfigList.get(0).getFechaUltimasPromos() == null) {
            return true;
        }
        Date fechaUltima = appConfigList.get(0).getFechaUltimasPromos();
        Date fechaActual = new Date();
        return fechaActual.after(fechaUltima);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x001d  */
    public static final void menuControlBanks(Menu nav_Menu) {
        try {
            switch (validateAuthBank()) {
                case "01":
                    clearItemsBankMenu(nav_Menu);
                    MenuItem element = nav_Menu.findItem(R.id.bpa);
                    String s = ((Object) element.getTitle()) + "   actual ";
                    SpannableString sColored = new SpannableString(s);
                    sColored.setSpan(new BackgroundColorSpan(Color.parseColor("#ff9800")), s.length() - 8, s.length(), 0);
                    sColored.setSpan(new ForegroundColorSpan(-1), s.length() - 8, s.length(), 0);
                    element.setTitle(sColored);
                    break;
                case "02":
                    clearItemsBankMenu(nav_Menu);
                    MenuItem element2 = nav_Menu.findItem(R.id.bandec);
                    String s2 = ((Object) element2.getTitle()) + "   actual ";
                    SpannableString sColored2 = new SpannableString(s2);
                    sColored2.setSpan(new BackgroundColorSpan(Color.parseColor("#ff9800")), s2.length() - 8, s2.length(), 0);
                    sColored2.setSpan(new ForegroundColorSpan(-1), s2.length() - 8, s2.length(), 0);
                    element2.setTitle(sColored2);
                    break;
                case "03":
                    clearItemsBankMenu(nav_Menu);
                    MenuItem element3 = nav_Menu.findItem(R.id.metro);
                    String s3 = ((Object) element3.getTitle()) + "   actual ";
                    SpannableString sColored3 = new SpannableString(s3);
                    sColored3.setSpan(new BackgroundColorSpan(Color.parseColor("#ff9800")), s3.length() - 8, s3.length(), 0);
                    sColored3.setSpan(new ForegroundColorSpan(-1), s3.length() - 8, s3.length(), 0);
                    element3.setTitle(sColored3);
                    break;
                case "04":
                    clearItemsBankMenu(nav_Menu);
                    MenuItem element4 = nav_Menu.findItem(R.id.bolsa_etecsa);
                    String s4 = ((Object) element4.getTitle()) + "   actual ";
                    SpannableString sColored4 = new SpannableString(s4);
                    sColored4.setSpan(new BackgroundColorSpan(Color.parseColor("#ff9800")), s4.length() - 8, s4.length(), 0);
                    sColored4.setSpan(new ForegroundColorSpan(-1), s4.length() - 8, s4.length(), 0);
                    element4.setTitle(sColored4);
                    break;
                case "05":
                    clearItemsBankMenu(nav_Menu);
                    MenuItem element5 = nav_Menu.findItem(R.id.bfi);
                    String s5 = ((Object) element5.getTitle()) + "   actual ";
                    SpannableString sColored5 = new SpannableString(s5);
                    sColored5.setSpan(new BackgroundColorSpan(Color.parseColor("#ff9800")), s5.length() - 8, s5.length(), 0);
                    sColored5.setSpan(new ForegroundColorSpan(-1), s5.length() - 8, s5.length(), 0);
                    element5.setTitle(sColored5);
                    break;
                default:
                    clearItemsBankMenu(nav_Menu);
                    break;
            }
        } catch (Exception e) {
            nav_Menu.findItem(R.id.bpa).setEnabled(true);
            nav_Menu.findItem(R.id.bandec).setEnabled(true);
            nav_Menu.findItem(R.id.metro).setEnabled(true);
            nav_Menu.findItem(R.id.bolsa_etecsa).setEnabled(true);
            nav_Menu.findItem(R.id.bfi).setEnabled(true);
        }
    }

    private static void clearItemsBankMenu(Menu nav_Menu) {
        MenuItem element1 = nav_Menu.findItem(R.id.bpa);
        element1.setTitle("BPA");
        MenuItem element2 = nav_Menu.findItem(R.id.bandec);
        element2.setTitle("BANDEC");
        MenuItem element3 = nav_Menu.findItem(R.id.metro);
        element3.setTitle("Metropolitano");
        MenuItem element4 = nav_Menu.findItem(R.id.bolsa_etecsa);
        element4.setTitle("MiTransfer");
        MenuItem element5 = nav_Menu.findItem(R.id.bfi);
        element5.setTitle("BFI");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x0017  */
    public static final void menuControlBanks(Menu nav_Menu, Activity activity) {
        try {
            switch (validateAuthBank()) {
                case "01":
                    nav_Menu.findItem(R.id.bpa).setEnabled(true);
                    nav_Menu.findItem(R.id.bandec).setEnabled(false);
                    nav_Menu.findItem(R.id.metro).setEnabled(false);
                    break;
                case "02":
                    nav_Menu.findItem(R.id.bpa).setEnabled(false);
                    nav_Menu.findItem(R.id.bandec).setEnabled(false);
                    nav_Menu.findItem(R.id.metro).setEnabled(true);
                    break;
                case "03":
                    nav_Menu.findItem(R.id.bpa).setEnabled(false);
                    nav_Menu.findItem(R.id.bandec).setEnabled(false);
                    nav_Menu.findItem(R.id.metro).setEnabled(true);
                    break;
                default:
                    nav_Menu.findItem(R.id.bpa).setEnabled(true);
                    nav_Menu.findItem(R.id.bandec).setEnabled(true);
                    nav_Menu.findItem(R.id.metro).setEnabled(true);
                    break;
            }
        } catch (Exception e) {
            nav_Menu.findItem(R.id.bpa).setEnabled(true);
            nav_Menu.findItem(R.id.bandec).setEnabled(true);
            nav_Menu.findItem(R.id.metro).setEnabled(true);
            ((AgentMainActivity) activity).UpdateMenu();
        }
    }

    public static final boolean closeSessionBank(Activity activity) {
        try {
            List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigs.isEmpty()) {
                return false;
            }
            AppConfig app = appConfigs.get(0);
            app.setCode_bank(BuildConfig.FLAVOR);
            unYp8VQThY.getInstance().updateAppConfig(app);
            if (activity instanceof AgentMainActivity) {
                ((AgentMainActivity) activity).UpdateMenu();
                return true;
            }
            if (activity instanceof GeneralMainActivity) {
                ((GeneralMainActivity) activity).UpdateMenu();
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final android.app.AlertDialog crearEncuestaUsuarios(Activity activity) {
        final Context context = activity.getBaseContext();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.uf3rnyy2muibs, (ViewGroup) null);
        final RatingBar ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        builder.setView(v);
        Button signup = (Button) v.findViewById(R.id.btn_aceptar);
        signup.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                int valor = (int) ratingBar.getRating();
                String cadena = "3*" + String.valueOf(valor);
                UssdDispatcher.actionCallUSSDSimple(context, "80", cadena);
            }
        });
        builder.create();
        return builder.create();
    }

    public static final void encuestaUsuarios(Activity activity, final Context context) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.uf3rnyy2muibs, (ViewGroup) null);
        final RatingBar ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        builder.setView(v);
        final android.app.AlertDialog alertDialog = builder.create();
        Button signup = (Button) v.findViewById(R.id.btn_aceptar);
        signup.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v2) {
                int valor = (int) ratingBar.getRating();
                if (valor > 0) {
                    String cadena = "3*" + String.valueOf(valor);
                    UssdDispatcher.actionCallUSSDSimple(context, "80", cadena);
                }
                List<AppConfig> appConfigs = unYp8VQThY.getInstance().getAllAppConfigLists();
                if (!appConfigs.isEmpty()) {
                    AppConfig app = appConfigs.get(0);
                    app.setFechaUltimasExperiencias(new Date());
                    app.setEvaluacion(valor);
                    unYp8VQThY.getInstance().updateAppConfig(app);
                }
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public static final O2oXWQuRDi goToFragment(FragmentActivity activity, ViewGroup group, Context context, int id_operacion) {
        O2oXWQuRDi accesoDirectoResult = new O2oXWQuRDi();
        try {
            Operacion operacion = unYp8VQThY.getInstance().getOperacionWithId(id_operacion);
            if (!operacion.getFragment_name().isEmpty()) {
                Fragment f = (Fragment) Class.forName(operacion.getFragment_name()).newInstance();
                Bundle bundle = getBundleOperation(operacion.getOperacion());
                if (bundle != null) {
                    f.setArguments(bundle);
                }
                accesoDirectoResult.setFragment(f);
            } else {
                AlertDialog.Builder d = getDialogOperation(operacion.getOperacion(), context, group, activity);
                if (d != null) {
                    accesoDirectoResult.setDialogo(d);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        return accesoDirectoResult;
    }

    private static final Bundle getBundleOperation(FdonIAFI9w operacion) {
        Bundle b = new Bundle();
        switch (operacion) {
            case LLamada:
                b.putInt("operacion", 1);
                return b;
            case Llamar99:
                b.putInt("operacion", 2);
                return b;
            default:
                return null;
        }
    }

    private static final AlertDialog.Builder getDialogOperation(FdonIAFI9w operacion, Context context, ViewGroup group, FragmentActivity activity) {
        switch (operacion) {
            case ConsultaSaldo222:
                String mensaje = context.getString(R.string.msg_consultar_saldo_stock);
                AlertDialog.Builder d = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222", "Seleccione", mensaje, group);
                return d;
            case ConsultaSaldo111:
                String mensaje2 = context.getString(R.string.msg_consultar_saldo_stock);
                AlertDialog.Builder d2 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*111", "Seleccione", mensaje2, group);
                return d2;
            case AGUltimosPago:
                AlertDialog.Builder d3 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*3", "Confirme", "¿Desea realizar la consulta?", group);
                return d3;
            case AGConsultarSaldo:
                String mensaje3 = context.getString(R.string.msg_consultar_saldo_stock);
                AlertDialog.Builder d4 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*13", "Confirme", mensaje3, group);
                return d4;
            case AGUltimasRecargas:
                String mensaje4 = context.getString(R.string.msg_ilt_recharge_all);
                AlertDialog.Builder d5 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*15", "Confirme", mensaje4, group);
                return d5;
            case AGDesconectar:
                String mensaje5 = context.getString(R.string.msg_confirm_close_session);
                AlertDialog.Builder d6 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*16", "Confirme", mensaje5, group);
                return d6;
            case AGConsultarNautaUlt:
                String mensaje6 = context.getString(R.string.msg_nauta_consulta_option_one);
                AlertDialog.Builder d7 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*91", "Confirme", mensaje6, group);
                return d7;
            case BPAConsultarSaldo:
                AlertDialog.Builder d8 = showDialogTipoMOneda(context, group, activity, "46");
                return d8;
            case BPAUltimasoperaciones:
                AlertDialog.Builder d9 = showDialogUltimaTipoMOneda(context, group, activity, "48");
                return d9;
            case BPADesconectar:
                String mensaje7 = context.getString(R.string.msg_confirm_close_session);
                AlertDialog.Builder d10 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*70", "Confirme", mensaje7, group);
                return d10;
            case BANConsultarSaldo:
                AlertDialog.Builder d11 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*46", "Confirme", "¿Desea consultar el saldo de su tarjeta?", group);
                return d11;
            case BANUltimasoperaciones:
                AlertDialog.Builder d12 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*48", "Confirme", "¿Desea ver las últimas operaciones realizadas? ", group);
                return d12;
            case BANDesconectar:
                String mensaje8 = context.getString(R.string.msg_confirm_close_session);
                AlertDialog.Builder d13 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*70", "Confirme", mensaje8, group);
                return d13;
            case BANEliminarRegistro:
                AlertDialog.Builder d14 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*68*02", "Confirme", "¿Desea eliminar registro asociado a su cuenta y número telefónico?.  ", group);
                return d14;
            case METRODesconectar:
                String mensaje9 = context.getString(R.string.msg_confirm_close_session);
                AlertDialog.Builder d15 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*70", "Confirme", mensaje9, group);
                return d15;
            case METROConsultarSaldo:
                AlertDialog.Builder d16 = showDialogTipoMOnedaConsultaSaldo(group);
                return d16;
            case ConsultarEstadoBono:
                String mensaje10 = context.getString(R.string.alert_dialog_msg_bono_confirm);
                AlertDialog.Builder d17 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222*266", "Confirme", mensaje10, group);
                return d17;
            case GestionPlanes:
                String mensaje11 = context.getString(R.string.alert_dialog_msg_gesplanes_confirm);
                AlertDialog.Builder d18 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*133", "Confirme", mensaje11, group);
                return d18;
            case ConsultarPlanDatos:
                String mensaje12 = context.getString(R.string.alert_dialog_msg_consultaplandatos_confirm);
                AlertDialog.Builder d19 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222*328", "Confirme", mensaje12, group);
                return d19;
            case ConsultarPlanVoz:
                String mensaje13 = context.getString(R.string.alert_dialog_msg_cconsultaplanvoz_confirm);
                AlertDialog.Builder d20 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222*869", "Confirme", mensaje13, group);
                return d20;
            case ConsultarPlanSMS:
                String mensaje14 = context.getString(R.string.alert_dialog_msg_consultaplansms_confirm);
                AlertDialog.Builder d21 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222*767", "Confirme", mensaje14, group);
                return d21;
            case ConsultarPlanAmigos:
                String mensaje15 = context.getString(R.string.alert_dialog_msg_consiltaplanamigos_confirm);
                AlertDialog.Builder d22 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*222*264", "Confirme", mensaje15, group);
                return d22;
            case BPAConsultaLimite:
                AlertDialog.Builder d23 = showDialogConsultarLimites(context, group, activity);
                return d23;
            case BANConsultaLimite:
                AlertDialog.Builder d24 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*62", "Confirme", "¿Desea consultar los límites de sus cuentas bancarias?", group);
                return d24;
            case BANUltimosPagos:
                AlertDialog.Builder d25 = showDialogUltimosPagos(context, group, activity);
                return d25;
            case BANConsultarTodasCuentas:
                AlertDialog.Builder d26 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*58", "Confirme", "¿Desea consultar el importe de todas sus cuentas?", group);
                return d26;
            case METROConsultaLimite:
                AlertDialog.Builder d27 = showDialogConsultarLimites(context, group, activity);
                return d27;
            case METROConsultaTodasCuentas:
                AlertDialog.Builder d28 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*58", "Confirme", "¿Desea consultar el importe de todas sus cuentas?", group);
                return d28;
            case AdelantaSaldo:
                String mensaje16 = context.getString(R.string.alert_dialog_msg_adelanta);
                AlertDialog.Builder d29 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*234*3", "Confirme", mensaje16, group);
                return d29;
            case xf94v3SFEM:
                AlertDialog.Builder d30 = showDialogPagoExterno(context, activity);
                return d30;
            case BPAPagoExterno:
                goToPagoExterno(context, activity, 0);
                return null;
            case BANPagoExterno:
                goToPagoExterno(context, activity, 1);
                return null;
            case METROPagoExterno:
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                goToPagoExterno(context, activity, 2);
                return null;
            case BPARecargaNauta:
                goToRecarganauta(context, activity, 0);
                return null;
            case BANRecargaNauta:
                goToRecarganauta(context, activity, 1);
                return null;
            case METRORecargaNauta:
                goToRecarganauta(context, activity, 2);
                return null;
            case METROReimprimirTarjeta:
                AlertDialog.Builder d31 = showDialogTipoMonedaReimprimirTarjeta(context);
                return d31;
            case METROLocalizarTransferencia:
                AlertDialog.Builder d32 = showDialogLocalizaTransferencias(context, activity);
                return d32;
            case BPAConsultarTodasCuentas:
                AlertDialog.Builder d33 = showDialogTodasCuentas(context, activity);
                return d33;
            case BPAConsultaCredito:
                AlertDialog.Builder d34 = showDialogConsultaCreditoBPA(context, activity);
                return d34;
            case BPARecargaPropia:
                goToRecargaPropia(context, activity, 0);
                return null;
            case BANRecargaPropia:
                goToRecargaPropia(context, activity, 1);
                return null;
            case METRORecargaPropia:
                goToRecargaPropia(context, activity, 2);
                return null;
            case BPAONAT:
                AlertDialog.Builder d35 = goToONAT(context, activity, 0);
                return d35;
            case BANONAT:
                AlertDialog.Builder d36 = goToONAT(context, activity, 1);
                return d36;
            case METROImpuestos:
                AlertDialog.Builder d37 = goToONAT(context, activity, 2);
                return d37;
            case BPAJClub:
                goToJClub(context, activity, 0);
                return null;
            case BANJClub:
                goToJClub(context, activity, 1);
                return null;
            case METROJClub:
                goToJClub(context, activity, 2);
                return null;
            case BPARecargaMovil:
                goToRecargaMovil(context, activity, 0);
                return null;
            case BANRecargaMovil:
                goToRecargaMovil(context, activity, 1);
                return null;
            case METRORecargaMovil:
                goToRecargaMovil(context, activity, 2);
                return null;
            case METROTipoCambio:
                AlertDialog.Builder d38 = showDialogTipoCambio(context, activity);
                return d38;
            case BOLSAConsultarSaldo:
                AlertDialog.Builder d39 = showDialogConsultarBolsa(context, activity);
                return d39;
            case BOLSATransferencia:
                AlertDialog.Builder d40 = showDialogTransferencia(context, activity);
                return d40;
            case BOLSAConsultaMiBoleto:
                AlertDialog.Builder d41 = showDialogConsultaMiBoleto(context, activity);
                return d41;
            case BOLSAUltimasOperaciones:
                AlertDialog.Builder d42 = showUltimasOperBolsa(context, activity);
                return d42;
            case BOLSARecargaMovil:
                AlertDialog.Builder d43 = goToRecargaMovilBolsa(context, activity);
                return d43;
            case BOLSAPagoLinea:
                goToPagoExternoBolsa(context, activity);
                return null;
            case BOLSARecargaNautaMLC:
                AlertDialog.Builder d44 = goToNautaPlus(context, activity);
                return d44;
            case BOLSARecargaFWA:
                AlertDialog.Builder d45 = goDialog4G(context, activity);
                return d45;
            case BOLSADesconectar:
                String mensaje17 = context.getString(R.string.msg_confirm_close_session);
                AlertDialog.Builder d46 = getAlertDialogBuilder(context, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "*444*70", "Confirme", mensaje17, group);
                return d46;
            case BPARecargaBolsa:
                goToRecargaWallet(context, activity, 1);
                return null;
            case BANRecargaBolsa:
                goToRecargaWallet(context, activity, 2);
                return null;
            case METRORecargaBolsa:
                goToRecargaWallet(context, activity, 3);
                return null;
            case METROReservasTicket:
                showDialogReservasTicketBanco(context, activity, 3);
                return null;
            case BPAReservasTicket:
                showDialogReservasTicketBanco(context, activity, 1);
                return null;
            case BANReservasTicket:
                showDialogReservasTicketBanco(context, activity, 2);
                return null;
            case BOLSAReservasTicket:
                showDialogReservasTicket(context, activity, 4);
                return null;
            case BPARecargaTFA:
                goToRecargaTFA(context, activity, 1);
                return null;
            case BANRecargaTFA:
                goToRecargaTFA(context, activity, 2);
                return null;
            case METRORecargaTFA:
                goToRecargaTFA(context, activity, 3);
                return null;
            case BOLSARecargaTFA:
                goToRecargaTFA(context, activity, 4);
                return null;
            case BPAPCC:
                goToPCC(context, activity, 1);
                return null;
            case BANPCC:
                goToPCC(context, activity, 2);
                return null;
            case METROPCC:
                goToPCC(context, activity, 3);
                return null;
            case BOLSAPCC:
                goToPCC(context, activity, 4);
                return null;
            case BPAPaquetesCubacel:
                goToPaquetesCubacel(context, activity, 1);
                return null;
            case METROPaquetesCubacel:
                goToPaquetesCubacel(context, activity, 3);
                return null;
            case BANPaquetesCubacel:
                goToPaquetesCubacel(context, activity, 2);
                return null;
            case BOLSATransferenciaClasicaEmpresarial:
                AlertDialog.Builder d47 = showDialogTransferClasicEmpresa(context, activity);
                return d47;
            case BOLSAPagoExternoClasicaEmpresarial:
                AlertDialog.Builder d48 = showDialogPagoExtClasicEmpresa(context, activity);
                return d48;
            default:
                return null;
        }
    }

    private static final AlertDialog.Builder getAlertDialogBuilder(Context context, String codigoAccesoPlataforma, String codeService, String codeToSend, String head_dialog, String mensaje_dialog, final ViewGroup group) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        String cadena = "tel:" + codeToSend + Uri.encode("#");
        unYp8VQThY.init(context);
        if (codigoAccesoPlataforma != BuildConfig.FLAVOR) {
            List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
            if (appConfigList.size() > 0) {
                codeAcceso = appConfigList.get(0).getCodigo();
                version = appConfigList.get(0).getNumber();
            }
            BaseMainActivity bs = new BaseMainActivity();
            String codeSendTo = bs.code(codeToSend);
            cadena = "tel:*" + codeAcceso + "*" + codeService + "*" + codeSendTo + "*" + version + Uri.encode("#");
        }
        final Uri number = Uri.parse(cadena);
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle(head_dialog);
        builder.setMessage(Html.fromHtml(mensaje_dialog));
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.26
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.27
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogTipoMOnedaConsultaSaldo(final ViewGroup group) {
        CharSequence[] items = {"CUP", "CUC", "USD"};
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        final String CodigoAcFinal = codeAcceso;
        final String VersionFinal = version;
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.28
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseMainActivity bs = new BaseMainActivity();
                String cadena = String.valueOf(i + 1);
                String codeSendTo = bs.code(cadena);
                String cadena2 = "tel:*" + CodigoAcFinal + "*46*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");
                Uri number = Uri.parse(cadena2);
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    group.getContext().startActivity(dial);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.29
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogFormadePagoONAT(Context context, ViewGroup group, final FragmentActivity activity) {
        CharSequence[] items = {"Parcial Fijo Mensual", "Parcial Fijo Anual", "Parcial con Importe Declarado"};
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle("Seleccione la forma de Pago Parcial:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.30
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                RFGGC2VcTY onatMETRO = new RFGGC2VcTY();
                switch (i) {
                    case 0:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.ParcialFijoMensual);
                        break;
                    case 1:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.ParcialFijoAnual);
                        break;
                    case 2:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.ParcilFijoImporte);
                        break;
                }
                onatMETRO.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, onatMETRO).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.31
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogUltimosPagos(Context context, ViewGroup group, final FragmentActivity activity) {
        CharSequence[] items = {"Todos", "Teléfono", "Electrica", "Transferencias"};
        AlertDialog.Builder builder = new AlertDialog.Builder(group.getContext());
        builder.setTitle("Seleccione la opción deseada:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.32
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String tipoOperacion = "0";
                switch (i) {
                    case 0:
                        tipoOperacion = "1";
                        break;
                    case 1:
                        tipoOperacion = "2";
                        break;
                    case 2:
                        tipoOperacion = "3";
                        break;
                    case 3:
                        tipoOperacion = "4";
                        break;
                }
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("63", tipoOperacion);
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("63", tipoOperacion);
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD("63", tipoOperacion);
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.33
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogConsultarLimites(Context context, ViewGroup group, final FragmentActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        CharSequence[] items = context.getResources().getStringArray(R.array.currency);
        builder.setTitle("Seleccionar el tipo de moneda de su tarjeta a consultar:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.34
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String pos = String.valueOf(i + 1);
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() == null) {
                    ((GeneralMainActivity) activity).actionCallUSSD("62", pos);
                } else if (bs.getCodeAgent().getCode().contains("-1")) {
                    ((GeneralMainActivity) activity).actionCallUSSD("62", pos);
                } else {
                    ((AgentMainActivity) activity).actionCallUSSD("62", pos);
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.35
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogTipoMOneda(Context context, ViewGroup group, final FragmentActivity activity, final String operacion) {
        CharSequence[] items = context.getResources().getStringArray(R.array.currency);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.36
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String pos = String.valueOf(i + 1);
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD(operacion, pos);
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD(operacion, pos);
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD(operacion, pos);
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogUltimaTipoMOneda(Context context, ViewGroup group, final FragmentActivity activity, final String operacion) {
        CharSequence[] items = context.getResources().getStringArray(R.array.currency);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de moneda de su tarjeta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.37
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String pos = String.valueOf(i + 1);
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD(operacion, "00*" + pos);
                        return;
                    }
                    ((AgentMainActivity) activity).actionCallUSSD(operacion, "00*" + pos);
                    return;
                }
                ((GeneralMainActivity) activity).actionCallUSSD(operacion, "00*" + pos);
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogPagoExterno(Context context, final FragmentActivity activity) {
        CharSequence[] items = {"BPA", "BANDEC", "METROPOLITANO"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Para ejecutar el pago debe seleccionar el banco:");
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.38
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                        r7Rinp9ooL pagoFragment = new r7Rinp9ooL();
                        pagoFragment.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                        r7Rinp9ooL pagoFragment2 = new r7Rinp9ooL();
                        pagoFragment2.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment2).addToBackStack(null).commit();
                        break;
                    case 2:
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                        r7Rinp9ooL pagoFragment3 = new r7Rinp9ooL();
                        pagoFragment3.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, pagoFragment3).addToBackStack(null).commit();
                        break;
                }
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogTipoMonedaReimprimirTarjeta(final Context context) {
        String codeAcceso = BuildConfig.FLAVOR;
        String version = BuildConfig.FLAVOR;
        List<AppConfig> appConfigList = unYp8VQThY.getInstance().getAllAppConfigLists();
        if (appConfigList.size() > 0) {
            codeAcceso = appConfigList.get(0).getCodigo();
            version = appConfigList.get(0).getNumber();
        }
        final String CodigoAcFinal = codeAcceso;
        final String VersionFinal = version;
        CharSequence[] items = {"CUP", "CUC"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione segun la moneda la tarjeta a reimprimir:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.39
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String cadena;
                BaseMainActivity bs = new BaseMainActivity();
                if (i == 0) {
                    cadena = "1";
                } else {
                    cadena = "2";
                }
                String codeSendTo = bs.code(cadena);
                String cadena2 = "tel:*" + CodigoAcFinal + "*74*" + codeSendTo + "*" + VersionFinal + Uri.encode("#");
                Uri number = Uri.parse(cadena2);
                try {
                    Intent dial = new Intent("android.intent.action.CALL", number);
                    context.startActivity(dial);
                } catch (Exception e) {
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.40
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final void goToPagoExterno(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 0:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                r7Rinp9ooL pagoFragment = new r7Rinp9ooL();
                pagoFragment.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
                break;
            case 1:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                r7Rinp9ooL pagoFragment2 = new r7Rinp9ooL();
                pagoFragment2.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoFragment2).addToBackStack(null).commit();
                break;
            case 2:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                r7Rinp9ooL pagoFragment3 = new r7Rinp9ooL();
                pagoFragment3.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoFragment3).addToBackStack(null).commit();
                break;
        }
    }

    private static final void goToRecargaTFA(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                kq0rlPklFL recargatfa = new kq0rlPklFL();
                recargatfa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargatfa).addToBackStack(null).commit();
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                kq0rlPklFL recargatfa2 = new kq0rlPklFL();
                recargatfa2.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargatfa2).addToBackStack(null).commit();
                break;
            case 3:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                kq0rlPklFL recargatfa3 = new kq0rlPklFL();
                recargatfa3.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargatfa3).addToBackStack(null).commit();
                break;
            case 4:
                mFragmentTransaction.replace(R.id.containerView, new b7zSZMAX7cN()).addToBackStack(null).commit();
                break;
        }
    }

    private static final void goToPaquetesCubacel(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 1:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CompraPaquetesCubacel);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                n6dAtto0KFy paqCubacel = new n6dAtto0KFy();
                paqCubacel.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, paqCubacel).addToBackStack(null).commit();
                break;
            case 2:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CompraPaquetesCubacel);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                n6dAtto0KFy paqCubacel2 = new n6dAtto0KFy();
                paqCubacel2.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, paqCubacel2).addToBackStack(null).commit();
                break;
            case 3:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.CompraPaquetesCubacel);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                n6dAtto0KFy paqCubacel3 = new n6dAtto0KFy();
                paqCubacel3.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, paqCubacel3).addToBackStack(null).commit();
                break;
            case 4:
                mFragmentTransaction.replace(R.id.containerView, new b7zSZMAX7cN()).addToBackStack(null).commit();
                break;
        }
    }

    private static final void goToPCC(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 1:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.PCC);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                PTsHXOZ1gC pagoPartidoBanco = new PTsHXOZ1gC();
                pagoPartidoBanco.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoPartidoBanco).addToBackStack(null).commit();
                break;
            case 2:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.PCC);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                PTsHXOZ1gC pagoPartidoBanco2 = new PTsHXOZ1gC();
                pagoPartidoBanco2.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoPartidoBanco2).addToBackStack(null).commit();
                break;
            case 3:
                arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.PCC);
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                PTsHXOZ1gC pagoPartidoBanco3 = new PTsHXOZ1gC();
                pagoPartidoBanco3.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoPartidoBanco3).addToBackStack(null).commit();
                break;
            case 4:
                mFragmentTransaction.replace(R.id.containerView, new xb7DiohJuX()).addToBackStack(null).commit();
                break;
        }
    }

    private static final void goToRecarganauta(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 0:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                break;
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                break;
        }
        PqTzgaEYF6 recargaNautaBanco = new PqTzgaEYF6();
        recargaNautaBanco.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, recargaNautaBanco).addToBackStack(null).commit();
    }

    private static final void goToRecargaPropia(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 0:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                break;
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                break;
        }
        hqPCcU1E8u recarga = new hqPCcU1E8u();
        recarga.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, recarga).addToBackStack(null).commit();
    }

    private static final AlertDialog.Builder showDialogLocalizaTransferencias(Context context, final FragmentActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea localizar las transferencias pendientes de sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.41
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("73");
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("73");
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD("73");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.42
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogFormadePagoONATBandec(Context context, final FragmentActivity activity) {
        CharSequence[] items = {"Pago por RC05", "Pago por NIT"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione la forma de Pago Parcial:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.43
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                t7in6psmmaQ onatBANDEC = new t7in6psmmaQ();
                switch (i) {
                    case 0:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoRC05);
                        break;
                    case 1:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoNIT);
                        break;
                }
                onatBANDEC.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, onatBANDEC).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.44
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogTodasCuentas(Context context, final FragmentActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el importe de todas sus cuentas? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.45
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("58");
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("58");
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD("58");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.46
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogConsultaCreditoBPA(Context context, final FragmentActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea ver los créditos pendientes? ");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.47
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("72");
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("72");
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD("72");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.48
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder goToONAT(Context context, final FragmentActivity activity, final int banco) {
        CharSequence[] items = {context.getString(R.string.tx_onat_nit_rc04), context.getString(R.string.tx_onat_nit_ci), context.getString(R.string.tx_sello_timbre)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione la forma de pago (solo para personas naturales)");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.49
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                ROgpLrCtHa onat = new ROgpLrCtHa();
                switch (banco) {
                    case 0:
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                        break;
                    case 1:
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                        break;
                    case 2:
                        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                        break;
                }
                switch (i) {
                    case 0:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoRC05);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        arg.putSerializable("y2Cht3lmjg", y2Cht3lmjg.PagoNIT);
                        onat.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, onat).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                    case 2:
                        TGMSi5UDp7 sellosPostalesBanco = new TGMSi5UDp7();
                        sellosPostalesBanco.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, sellosPostalesBanco).addToBackStack(null).commit();
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.50
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final void goToJClub(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 0:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                break;
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                break;
        }
        w1lXYiCfJyk recarga = new w1lXYiCfJyk();
        recarga.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, recarga).addToBackStack(null).commit();
    }

    private static final void goToRecargaMovil(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 0:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                break;
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                break;
        }
        SjZHfPJPwX recargaMovilCuentasFragment = new SjZHfPJPwX();
        recargaMovilCuentasFragment.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, recargaMovilCuentasFragment).addToBackStack(null).commit();
    }

    private static final AlertDialog.Builder showDialogTipoCambio(Context context, final FragmentActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione");
        builder.setMessage("¿Desea consultar el tipo de cambio vigente?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.51
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                BaseMainActivity bs = new BaseMainActivity();
                if (bs.getCodeAgent() != null) {
                    if (bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("85");
                        return;
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("85");
                        return;
                    }
                }
                ((GeneralMainActivity) activity).actionCallUSSD("85");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.52
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogTransferencia(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.menu_title_transferencia_mi_transfer), context.getString(R.string.tx_transferencia_clasica)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.hint_seleccione_cuenta));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.53
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new LjOlaYSSMH()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new l3GXbXAyUW()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.54
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showDialogConsultarBolsa(Context context, final FragmentActivity activity) {
        CharSequence[] items = context.getResources().getStringArray(R.array.array_bolsa_consulta_saldo);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de cuenta: ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.55
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 1) {
                    FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new GvNasrezHU()).addToBackStack(null).commit();
                } else {
                    BaseMainActivity bs = new BaseMainActivity();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("46");
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("46");
                    }
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.56
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder showUltimasOperBolsa(Context context, final FragmentActivity activity) {
        CharSequence[] items = context.getResources().getStringArray(R.array.array_bolsa_ult_oper);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de cuenta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.57
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                int position = i + 1;
                String pos = String.valueOf(position);
                if (i == 2) {
                    FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView, new dI2tctjNbR()).addToBackStack(null).commit();
                } else {
                    BaseMainActivity bs = new BaseMainActivity();
                    if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                        ((GeneralMainActivity) activity).actionCallUSSD("48", pos);
                    } else {
                        ((AgentMainActivity) activity).actionCallUSSD("48", pos);
                    }
                }
                dialogInterface.dismiss();
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder goToRecargaMovilBolsa(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.tx_wallet_recarga_cup)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.58
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                zzyNbaqs1U recargaMovilBolsa = new zzyNbaqs1U();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        arg.putSerializable("TipoBolsa", qTDVwLFEjE.CUP);
                        break;
                }
                recargaMovilBolsa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargaMovilBolsa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.59
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final void goToPagoExternoBolsa(Context context, FragmentActivity activity) {
        U6ucOCBccJ.pmoneda = 0;
        U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        s9CT6pjRyD pagoFragment = new s9CT6pjRyD();
        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.xf94v3SFEM);
        arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
        pagoFragment.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, pagoFragment).addToBackStack(null).commit();
    }

    private static final AlertDialog.Builder goToNautaPlus(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.tx_wallet_nauta_plus_sin_cuenta), context.getString(R.string.tx_wallet_nauta_plus_con_cuenta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.tx_modal_head_nauta_plus_bolsa));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.60
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                HZgbT8IXPf recargaNautaPlusBolsa = new HZgbT8IXPf();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        arg.putSerializable("OpcionNautaPlus", RiZsr8xXRC.SIN_CUENTA);
                        break;
                    case 1:
                        arg.putSerializable("OpcionNautaPlus", RiZsr8xXRC.CON_CUENTA);
                        break;
                }
                recargaNautaPlusBolsa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, recargaNautaPlusBolsa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.61
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final AlertDialog.Builder goDialog4G(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.tx_opcion_fwa_recarga), context.getString(R.string.tx_opcion_fwa_consulta)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.tx_opcion_fwa_head));
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.62
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.MiTransfer);
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new wbFn8tBw8W()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new q55ExEc6x2l()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.63
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder;
    }

    private static final void goToRecargaWallet(Context context, FragmentActivity activity, int banco) {
        Bundle arg = new Bundle();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        switch (banco) {
            case 1:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BPA);
                break;
            case 2:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.BANDEC);
                break;
            case 3:
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.Metropolitano);
                break;
        }
        uKzekWA2jf recargaWallet = new uKzekWA2jf();
        recargaWallet.setArguments(arg);
        mFragmentTransaction.replace(R.id.containerView, recargaWallet).addToBackStack(null).commit();
    }

    private static final void showDialogReservasTicket(Context context, final FragmentActivity activity, int banco) {
        CharSequence[] items = {context.getString(R.string.opcion_reserva_ticket), context.getString(R.string.opcion_eliminar_reserva_ticket), context.getString(R.string.opcion_cambiar_fecha_ticket)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.64
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (i) {
                    case 0:
                        mFragmentTransaction.replace(R.id.containerView, new XnVSHGPTkK()).addToBackStack(null).commit();
                        break;
                    case 1:
                        mFragmentTransaction.replace(R.id.containerView, new QVPgkl8ZGC()).addToBackStack(null).commit();
                        break;
                    case 2:
                        mFragmentTransaction.replace(R.id.containerView, new Wwc5crW71D()).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.65
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    private static final void showDialogReservasTicketBanco(Context context, final FragmentActivity activity, final int banco) {
        CharSequence[] items = {context.getString(R.string.opcion_reserva_ticket), context.getString(R.string.opcion_eliminar_reserva_ticket), context.getString(R.string.opcion_cambiar_fecha_ticket)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Seleccione ");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.66
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                R1sDOSqZ2z agency;
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Bundle arg = new Bundle();
                switch (banco) {
                    case 1:
                        agency = R1sDOSqZ2z.BPA;
                        break;
                    case 2:
                        agency = R1sDOSqZ2z.BANDEC;
                        break;
                    case 3:
                        agency = R1sDOSqZ2z.Metropolitano;
                        break;
                    default:
                        agency = R1sDOSqZ2z.General;
                        break;
                }
                arg.putSerializable("R1sDOSqZ2z", agency);
                switch (i) {
                    case 0:
                        L0JjVr9EwEF ticket = new L0JjVr9EwEF();
                        ticket.setArguments(arg);
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ReservasTicket);
                        mFragmentTransaction.replace(R.id.containerView, ticket).addToBackStack(null).commit();
                        break;
                    case 1:
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.EliminarReservasTicket);
                        GPsckxvkPu ticket2 = new GPsckxvkPu();
                        ticket2.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, ticket2).addToBackStack(null).commit();
                        break;
                    case 2:
                        arg.putSerializable("Nl0yptXmjQ", Nl0yptXmjQ.ModificarReservasTicket);
                        rGY5dubJYU ticket3 = new rGY5dubJYU();
                        ticket3.setArguments(arg);
                        mFragmentTransaction.replace(R.id.containerView, ticket3).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.67
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    private static final AlertDialog.Builder showDialogConsultaMiBoleto(Context context, final FragmentActivity activity) {
        CharSequence[] items = {"Consulta de Ofertas", "Últimas operaciones realizadas", "Consulta de boletos", "Consulta estado de boleto", "Actualizar clave de boleto"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Seleccione el tipo de consulta:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.68
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                new Bundle();
                BaseMainActivity bs = new BaseMainActivity();
                switch (i) {
                    case 0:
                        if (bs.getCodeAgent() == null || bs.getCodeAgent().getCode().contains("-1")) {
                            ((GeneralMainActivity) activity).actionCallUSSD("117");
                        } else {
                            ((AgentMainActivity) activity).actionCallUSSD("117");
                        }
                        break;
                    case 1:
                        i9I9XZGnR3 miboleto = new i9I9XZGnR3();
                        mFragmentTransaction.replace(R.id.containerView, miboleto).addToBackStack(null).commit();
                        break;
                    case 2:
                        OXpoe3K2m1 miboleto2 = new OXpoe3K2m1();
                        mFragmentTransaction.replace(R.id.containerView, miboleto2).addToBackStack(null).commit();
                        break;
                    case 3:
                        w7mHpmOa4EP miboleto3 = new w7mHpmOa4EP();
                        mFragmentTransaction.replace(R.id.containerView, miboleto3).addToBackStack(null).commit();
                        break;
                    case 4:
                        hjX8MS8xO9 miboleto4 = new hjX8MS8xO9();
                        mFragmentTransaction.replace(R.id.containerView, miboleto4).addToBackStack(null).commit();
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.69
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
        return null;
    }

    private static final AlertDialog.Builder showDialogTransferClasicEmpresa(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.tx_bfi_transferencia_con_solic), context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.70
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Z3kYdPwq6K2 transferenciaBolsaClasicaEmpresarialEmpresa = new Z3kYdPwq6K2();
                arg.putSerializable("TransferType", Integer.valueOf(i));
                transferenciaBolsaClasicaEmpresarialEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, transferenciaBolsaClasicaEmpresarialEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.71
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
        return null;
    }

    private static final AlertDialog.Builder showDialogPagoExtClasicEmpresa(Context context, final FragmentActivity activity) {
        CharSequence[] items = {context.getString(R.string.tx_bfi_transferencia_con_solic), context.getString(R.string.tx_bfi_transferencia_con_confirm)};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle("Seleccione opción");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.72
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                U6ucOCBccJ.pmoneda = 0;
                U6ucOCBccJ.pdata = BuildConfig.FLAVOR;
                Bundle arg = new Bundle();
                FragmentManager mFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                Eqj43O0pUx pagoExternoEmpresa = new Eqj43O0pUx();
                arg.putSerializable("PayType", Integer.valueOf(i));
                arg.putSerializable("R1sDOSqZ2z", R1sDOSqZ2z.CLASICAEMP);
                pagoExternoEmpresa.setArguments(arg);
                mFragmentTransaction.replace(R.id.containerView, pagoExternoEmpresa).addToBackStack(null).commit();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.cubacel.tr.tm.l08fNVC4KOKK.UssdDispatcher.73
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        android.app.AlertDialog alert = builder.create();
        alert.show();
        return null;
    }
}
