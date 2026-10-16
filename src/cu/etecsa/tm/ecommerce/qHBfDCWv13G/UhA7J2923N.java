package cu.etecsa.tm.ecommerce.qHBfDCWv13G;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import cu.etecsa.tm.ecommerce.a7Y4bbw8Os;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class UhA7J2923N extends Application {
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String API_URL = "API_URL";
    private static final String CHANGE_PHOTO_HOME = "CHANGE_PHOTO_HOME";
    private static final String COMPACT_MODE = "COMPACT_MODE";
    private static final String COMUNICATION_MODE = "COMUNICATION_MODE";
    private static final String CSRF_TOKEN = "CSRF_TOKEN";
    private static final String GRANTS = "GRANTS";
    private static final String HASHTAG_DEFAULT = "HASHTAG_DEFAULT";
    private static final String PREF_ACCOUNT = "PREF_ACCOUNT";
    private static final String PREF_CURRENCY = "PREF_CURRENCY";
    private static final String SESSION_SHARE_DATA = "SESSION_SHARE_DATA";
    private static final String TOKEN_TYPE = "TOKEN_TYPE";
    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_ROL = "USER_ROL";
    private static UhA7J2923N context;
    public String ApiURL;
    public String access_token;
    public String csrf_token;
    public IGxV3uh9sw globalMsg;
    public String grants;
    public String token_type;
    public String userid;
    public String username;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public String getMessage(int code) {
        return IGxV3uh9sw.getInstance(context).getMessage(code);
    }

    public String getMessage(int code, String headMessage, String message) {
        return IGxV3uh9sw.getInstance(context).getMessage(code, headMessage, message);
    }

    public void WriteLog(int code, String headMessage, String message) {
        IGxV3uh9sw.getInstance(context).WriteLog(code, headMessage, message);
    }

    public String getErrorMessage(UZsizlaDNk tipo, String code) {
        return IGxV3uh9sw.getInstance(context).getErrorMessage(tipo, code);
    }

    public static UhA7J2923N getInstance() {
        return context;
    }

    public String getAccess_token() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        String token = preferences.getString(ACCESS_TOKEN, null);
        if (token == null) {
            return null;
        }
        if (token.contains("Bearer")) {
            return token;
        }
        return "Bearer " + token;
    }

    public void setAccess_token(String access_token) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(ACCESS_TOKEN, access_token).apply();
    }

    public String getToken_type() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(TOKEN_TYPE, null);
    }

    public void setToken_type(String token_type) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(TOKEN_TYPE, token_type).apply();
    }

    public String getApiURL() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(API_URL, null);
    }

    public void setApiURL(String apiURL) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(API_URL, apiURL).apply();
    }

    public String getCsrf_token() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(CSRF_TOKEN, null);
    }

    public void setCsrf_token(String csrf_token) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(CSRF_TOKEN, csrf_token).apply();
    }

    public String getUsername() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(USER_NAME, null);
    }

    public void setUsername(String username) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(USER_NAME, username).apply();
    }

    public String getUserid() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(USER_ID, null);
    }

    public void setUserid(String userid) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(USER_ID, userid).apply();
    }

    public String getGrants() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(GRANTS, null);
    }

    public void setGrants(String grants) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(GRANTS, grants).apply();
    }

    public String getPrefAccount() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(PREF_ACCOUNT, null);
    }

    public void setPrefAccount(String account) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(PREF_ACCOUNT, account).apply();
    }

    public String getPrefCurrency() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(PREF_CURRENCY, null);
    }

    public void setPrefCurrency(String currency) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(PREF_CURRENCY, currency).apply();
    }

    public String getChangePhotoHome() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(CHANGE_PHOTO_HOME, null);
    }

    public void setChangePhotoHome(String changePhotoHome) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(CHANGE_PHOTO_HOME, changePhotoHome).apply();
    }

    public String getUserRol() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(USER_ROL, null);
    }

    public void setUserRol(String rol) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(USER_ROL, rol).apply();
    }

    public String getCompactMode() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(COMPACT_MODE, null);
    }

    public void setCompactMode(String mode) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(COMPACT_MODE, mode).apply();
    }

    public void setComunicationMode(String comunicationMode) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(COMUNICATION_MODE, comunicationMode).apply();
    }

    public String getComunicationMode() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(COMUNICATION_MODE, null);
    }

    public void setHashtagDefault(String hashtagDefault) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        preferences.edit().putString(HASHTAG_DEFAULT, hashtagDefault).apply();
    }

    public static String getHashtagDefault() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION_SHARE_DATA, 0);
        return preferences.getString(HASHTAG_DEFAULT, null);
    }

    public String loadJSONFromAsset(String nameJson) {
        try {
            InputStream is = context.getAssets().open(nameJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            return json;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void finilizarNoAutenticado(final Activity activity) {
        try {
            activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N.1
                @Override // java.lang.Runnable
                public void run() {
                    AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setCancelable(false);
                    alertDialog.setTitle("No autenticado");
                    alertDialog.setMessage("Su sesión ha expirado. Debe autenticarse para continuar el uso del Bulevar.");
                    alertDialog.setButton(-1, "Autenticar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(activity, (Class<?>) a7Y4bbw8Os.class);
                            UhA7J2923N.getInstance().setAccess_token(null);
                            intent.setFlags(335577088);
                            UhA7J2923N.this.startActivity(intent);
                            activity.finish();
                        }
                    });
                    alertDialog.show();
                    alertDialog.setButton(-2, "Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            activity.finish();
                        }
                    });
                    alertDialog.show();
                }
            });
        } catch (Exception e) {
            AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setCancelable(false);
            alertDialog.setTitle("No autenticado");
            alertDialog.setMessage("Su sesión ha expirado. Debe autenticarse para continuar el uso del Bulevar.");
            alertDialog.setButton(-1, "Autenticar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(activity, (Class<?>) a7Y4bbw8Os.class);
                    UhA7J2923N.getInstance().setAccess_token(null);
                    intent.setFlags(335577088);
                    UhA7J2923N.this.startActivity(intent);
                    activity.finish();
                }
            });
            alertDialog.show();
            alertDialog.setButton(-2, "Cerrar", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                }
            });
            alertDialog.show();
        }
    }

    public boolean checkUserPermission(ThptISKBHA grantEnum) {
        String grant = getGrants();
        String[] grantList = grant.split(Pattern.quote("|"));
        for (String item : grantList) {
            try {
                int numberGrant = Integer.valueOf(item).intValue();
                if (numberGrant == grantEnum.getNumVal()) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
