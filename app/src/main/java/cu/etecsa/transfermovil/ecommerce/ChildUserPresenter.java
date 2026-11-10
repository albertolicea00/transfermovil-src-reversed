package cu.etecsa.transfermovil.ecommerce;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.transfermovil.ecommerce.model.request.BanUserRequest;
import cu.etecsa.transfermovil.ecommerce.model.request.ChildUserCreateRequest;
import cu.etecsa.transfermovil.ecommerce.model.request.IdRequest;

/** Source-backed child-user request adapter for MNdSLKzqqG. */
public final class ChildUserPresenter {
    public enum Operation { LIST, DETAIL, CREATE, UPDATE, DELETE, STATUS }
    public interface Callback {
        void onProgressVisibility(int visibility);
        void onResult(Operation operation, ApiResponse response);
    }

    private final Context context;
    private final String token;
    private final Callback callback;

    public ChildUserPresenter(Context context, String token, Callback callback) {
        this.context = context.getApplicationContext();
        String sessionToken = SessionManager.getInstance().getAccessToken();
        this.token = token == null ? sessionToken : token;
        this.callback = callback;
    }

    public void list() { execute(Operation.LIST, null); }
    public void detail(int id) { IdRequest request = new IdRequest(); request.setId(id); execute(Operation.DETAIL, request); }
    public void create(ChildUserCreateRequest request) { execute(Operation.CREATE, request); }
    public void update(ChildUserCreateRequest request) { execute(Operation.UPDATE, request); }
    public void delete(int id) { IdRequest request = new IdRequest(); request.setId(id); execute(Operation.DELETE, request); }
    public void setStatus(int id, boolean banned) {
        BanUserRequest request = new BanUserRequest(); request.setId(id); request.setBanned(banned ? "1" : "0");
        execute(Operation.STATUS, request);
    }

    private void execute(Operation operation, Object request) {
        new AsyncTask<Void, Void, ApiResponse>() {
            @Override protected void onPreExecute() { callback.onProgressVisibility(0); }
            @Override protected ApiResponse doInBackground(Void... ignored) {
                ApiClient api = ApiClient.getInstance(context);
                if ((operation == Operation.CREATE || operation == Operation.UPDATE)
                        && request instanceof ChildUserCreateRequest)
                    api.prepareChildUserPhoto((ChildUserCreateRequest) request);
                switch (operation) {
                    case LIST: return api.listChildUsers(token);
                    case DETAIL: return api.getChildUser(request, token);
                    case CREATE: return api.createChildUser(request, token);
                    case UPDATE: return api.updateChildUser(request, token);
                    case DELETE: return api.deleteChildUser(request, token);
                    case STATUS: return api.setChildUserStatus(request, token);
                    default: throw new IllegalStateException(operation.name());
                }
            }
            @Override protected void onPostExecute(ApiResponse response) {
                callback.onProgressVisibility(4);
                callback.onResult(operation, response);
            }
        }.execute();
    }
}
