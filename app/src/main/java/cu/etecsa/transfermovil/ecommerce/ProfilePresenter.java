package cu.etecsa.transfermovil.ecommerce;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.transfermovil.ecommerce.model.BaseApiResult;
import cu.etecsa.transfermovil.ecommerce.model.request.ChangePasswordRequest;
import cu.etecsa.transfermovil.ecommerce.model.request.UserProfileRequest;
import cu.etecsa.transfermovil.ecommerce.model.response.UserProfileResponse;
import org.json.JSONObject;

/** Source-backed adapter for the profile operations in PWf5TMuFy2. */
public final class ProfilePresenter {
    public enum Operation { GET_PROFILE, UPDATE, CHANGE_PASSWORD }

    public interface Callback {
        void onProgressVisibility(int visibility);
        void onResult(boolean success, Operation operation, String message, BaseApiResult response);
    }

    private final Context context;
    private final Callback callback;
    private final String token;

    public ProfilePresenter(Context context, String token, Callback callback) {
        this.context = context.getApplicationContext();
        String sessionToken = SessionManager.getInstance().getAccessToken();
        this.token = token == null ? sessionToken : token;
        this.callback = callback;
    }

    public ProfilePresenter(Context context, Callback callback) {
        this(context, null, callback);
    }

    public void getProfile() { execute(Operation.GET_PROFILE, null); }
    public void updateProfile(UserProfileRequest request) { execute(Operation.UPDATE, request); }
    public void changePassword(ChangePasswordRequest request) { execute(Operation.CHANGE_PASSWORD, request); }

    private void execute(Operation operation, Object request) {
        new AsyncTask<Void, Void, BaseApiResult>() {
            @Override protected void onPreExecute() { callback.onProgressVisibility(0); }
            @Override protected BaseApiResult doInBackground(Void... ignored) {
                try {
                    ApiClient api = ApiClient.getInstance(context);
                    if (operation == Operation.GET_PROFILE) {
                        ApiResponse raw = api.getCurrentProfile(token);
                        if (raw == null) return failure(500, "Request failed");
                        UserProfileResponse result = new UserProfileResponse();
                        result.setHttpCode(raw.getCodigoHTTP());
                        result.setJsonObject(raw.getJsonObject());
                        result.setMenssage(raw.getMenssaje());
                        JSONObject body = raw.getJsonObject();
                        if (!raw.isError() && raw.getCodigoHTTP() == 200 && body != null
                                && body.optString("code").contains("Ok")) {
                            JSONObject user = body.optJSONObject("user");
                            if (user != null) {
                                result.setId(user.optInt("id"));
                                result.setUsername(user.optString("username", null));
                                result.setEmail(user.optString("email", null));
                                result.setDni(user.optString("dni", null));
                                result.setPhone(user.optString("phone", null));
                                result.setAddress(user.optString("address", null));
                                result.setUpdateAt(user.optString("updated_at", null));
                                if (!user.isNull("photo"))
                                    result.setPhoto(SessionManager.getInstance().getApiUrl()
                                            + "/user/photo/" + user.optString("id"));
                                result.setOK(true);
                                return result;
                            }
                        }
                        result.setOK(false);
                        if (result.getMenssage() == null || result.getMenssage().isEmpty())
                            result.setMenssage("Unable to load profile");
                        return result;
                    }
                    if (operation == Operation.UPDATE) {
                        UserProfileRequest profile = (UserProfileRequest) request;
                        if (profile.getPhoto() != null && !profile.getPhoto().isEmpty())
                            profile.setPhoto(api.convertImageToSend(profile.getPhoto()));
                        return result(api.updateProfile(profile, token));
                    }
                    return result(api.changeProfilePassword(request, token));
                } catch (Exception e) {
                    return failure(500, e.getMessage());
                }
            }
            @Override protected void onPostExecute(BaseApiResult response) {
                callback.onProgressVisibility(4);
                callback.onResult(response.isOK(), operation, response.getMenssage(), response);
            }
        }.execute();
    }

    private static BaseApiResult result(ApiResponse raw) {
        BaseApiResult result = new BaseApiResult();
        if (raw == null) return failure(500, "Request failed");
        result.setHttpCode(raw.getCodigoHTTP());
        result.setJsonObject(raw.getJsonObject());
        JSONObject body = raw.getJsonObject();
        result.setOK(!raw.isError() && raw.getCodigoHTTP() == 200 && body != null
                && body.optString("code").contains("Ok"));
        result.setMenssage(raw.getMenssaje());
        return result;
    }

    private static BaseApiResult failure(int code, String message) {
        BaseApiResult result = new BaseApiResult();
        result.setHttpCode(code);
        result.setOK(false);
        result.setMenssage(message);
        return result;
    }
}
