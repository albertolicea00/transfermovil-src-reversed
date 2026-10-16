package cu.etecsa.transfermovil.ecommerce;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N
 * @fingerprint Application subclass, SESSION_SHARE_DATA SharedPrefs, 15 string keys
 *
 * E-commerce module Application class and session manager. Singleton that
 * manages authentication state, API configuration, and user preferences
 * via SharedPreferences.
 *
 * SECURITY: All session data (Bearer token, CSRF token, user role, grants)
 * stored in plaintext SharedPreferences. MODE_PRIVATE provides app isolation
 * but allowBackup=true makes everything extractable via adb backup.
 */
public class SessionManager extends Application {

    private static final String PREFS_NAME = "SESSION_SHARE_DATA";

    // Auth tokens
    private static final String KEY_ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String KEY_TOKEN_TYPE = "TOKEN_TYPE";
    private static final String KEY_CSRF_TOKEN = "CSRF_TOKEN";

    // API config
    private static final String KEY_API_URL = "API_URL";

    // User identity
    private static final String KEY_USER_NAME = "USER_NAME";
    private static final String KEY_USER_ID = "USER_ID";
    private static final String KEY_USER_ROL = "USER_ROL";
    private static final String KEY_GRANTS = "GRANTS";

    // Preferences
    private static final String KEY_PREF_ACCOUNT = "PREF_ACCOUNT";
    private static final String KEY_PREF_CURRENCY = "PREF_CURRENCY";
    private static final String KEY_COMPACT_MODE = "COMPACT_MODE";
    private static final String KEY_COMMUNICATION_MODE = "COMUNICATION_MODE";
    private static final String KEY_HASHTAG_DEFAULT = "HASHTAG_DEFAULT";
    private static final String KEY_CHANGE_PHOTO_HOME = "CHANGE_PHOTO_HOME";

    private static SessionManager instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static SessionManager getInstance() {
        return instance;
    }

    // --- Auth tokens ---

    /**
     * Returns Bearer token with "Bearer " prefix.
     * Adds prefix if not already present in stored value.
     */
    public String getAccessToken() {
        String token = getPreference(KEY_ACCESS_TOKEN);
        if (token == null) return null;
        return token.contains("Bearer") ? token : "Bearer " + token;
    }

    public void setAccessToken(String token) {
        setPreference(KEY_ACCESS_TOKEN, token);
    }

    public String getTokenType() {
        return getPreference(KEY_TOKEN_TYPE);
    }

    public void setTokenType(String type) {
        setPreference(KEY_TOKEN_TYPE, type);
    }

    public String getCsrfToken() {
        return getPreference(KEY_CSRF_TOKEN);
    }

    public void setCsrfToken(String token) {
        setPreference(KEY_CSRF_TOKEN, token);
    }

    // --- API config ---

    /** Dynamic base URL — not hardcoded, retrieved from server at login. */
    public String getApiUrl() {
        return getPreference(KEY_API_URL);
    }

    public void setApiUrl(String url) {
        setPreference(KEY_API_URL, url);
    }

    // --- User identity ---

    public String getUsername() {
        return getPreference(KEY_USER_NAME);
    }

    public void setUsername(String username) {
        setPreference(KEY_USER_NAME, username);
    }

    public String getUserId() {
        return getPreference(KEY_USER_ID);
    }

    public void setUserId(String id) {
        setPreference(KEY_USER_ID, id);
    }

    /** User role string — if tampered, could enable privilege escalation. */
    public String getUserRole() {
        return getPreference(KEY_USER_ROL);
    }

    public void setUserRole(String role) {
        setPreference(KEY_USER_ROL, role);
    }

    /** Pipe-delimited permission grant IDs (e.g., "1|2|5|12"). */
    public String getGrants() {
        return getPreference(KEY_GRANTS);
    }

    public void setGrants(String grants) {
        setPreference(KEY_GRANTS, grants);
    }

    // --- Preferences ---

    public String getPreferredAccount() {
        return getPreference(KEY_PREF_ACCOUNT);
    }

    public void setPreferredAccount(String account) {
        setPreference(KEY_PREF_ACCOUNT, account);
    }

    public String getPreferredCurrency() {
        return getPreference(KEY_PREF_CURRENCY);
    }

    public void setPreferredCurrency(String currency) {
        setPreference(KEY_PREF_CURRENCY, currency);
    }

    public String getCompactMode() {
        return getPreference(KEY_COMPACT_MODE);
    }

    public void setCompactMode(String mode) {
        setPreference(KEY_COMPACT_MODE, mode);
    }

    public String getCommunicationMode() {
        return getPreference(KEY_COMMUNICATION_MODE);
    }

    public void setCommunicationMode(String mode) {
        setPreference(KEY_COMMUNICATION_MODE, mode);
    }

    public String getDefaultHashtag() {
        return getPreference(KEY_HASHTAG_DEFAULT);
    }

    public void setDefaultHashtag(String hashtag) {
        setPreference(KEY_HASHTAG_DEFAULT, hashtag);
    }

    public String getChangePhotoHome() {
        return getPreference(KEY_CHANGE_PHOTO_HOME);
    }

    public void setChangePhotoHome(String value) {
        setPreference(KEY_CHANGE_PHOTO_HOME, value);
    }

    // --- Permission check ---

    /**
     * Checks if user has a specific grant by comparing numeric IDs.
     * Grants stored as pipe-delimited string (e.g., "1|2|5|12").
     */
    public boolean hasPermission(int grantId) {
        String grants = getGrants();
        if (grants == null) return false;
        for (String item : grants.split(Pattern.quote("|"))) {
            try {
                if (Integer.parseInt(item) == grantId) return true;
            } catch (NumberFormatException ignored) {}
        }
        return false;
    }

    // --- Utility ---

    public String loadJsonAsset(String filename) {
        try {
            InputStream is = getAssets().open(filename);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Shows session-expired dialog forcing re-authentication or close.
     * Clears access token on re-auth, redirects to login activity.
     */
    public void showSessionExpiredDialog(Activity activity) {
        AlertDialog dialog = new AlertDialog.Builder(activity).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setTitle("No autenticado");
        dialog.setMessage("Su sesión ha expirado. Debe autenticarse para continuar el uso del Bulevar.");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Autenticar", (d, w) -> {
            setAccessToken(null);
            // Redirects to login activity (a7Y4bbw8Os in obfuscated source)
            activity.finish();
        });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cerrar", (d, w) -> activity.finish());
        dialog.show();
    }

    // --- SharedPreferences helpers ---

    private String getPreference(String key) {
        return getSharedPreferences(PREFS_NAME, MODE_PRIVATE).getString(key, null);
    }

    private void setPreference(String key, String value) {
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit().putString(key, value).apply();
    }
}
