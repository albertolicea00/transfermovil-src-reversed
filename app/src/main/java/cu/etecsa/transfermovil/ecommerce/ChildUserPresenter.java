package cu.etecsa.transfermovil.ecommerce;

import android.content.Context;
import android.os.AsyncTask;
import cu.etecsa.transfermovil.data.DatabaseHelper;
import cu.etecsa.transfermovil.data.entity.Municipality;
import cu.etecsa.transfermovil.data.entity.Province;
import cu.etecsa.transfermovil.ecommerce.domain.entity.ChildUser;
import cu.etecsa.transfermovil.ecommerce.model.request.BanUserRequest;
import cu.etecsa.transfermovil.ecommerce.model.request.ChildUserCreateRequest;
import cu.etecsa.transfermovil.ecommerce.model.request.IdRequest;
import cu.etecsa.transfermovil.ecommerce.model.response.ChildUserListResponse;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/** Source-backed child-user request adapter for MNdSLKzqqG. */
public final class ChildUserPresenter {
    public enum Operation { LIST, DETAIL, CREATE, UPDATE, DELETE, STATUS }
    public interface Callback {
        void onProgressVisibility(int visibility);
        void onListResult(ChildUserListResponse response);
        void onDetailResult(UserWithRolesResponse response);
        void onMutationResult(Operation operation, ApiResponse response);
    }

    private final Context context;
    private final String token;
    private final String apiUrl;
    private final Callback callback;

    public ChildUserPresenter(Context context, String token, Callback callback) {
        this.context = context.getApplicationContext();
        android.content.SharedPreferences session = this.context.getSharedPreferences("SESSION_SHARE_DATA", 0);
        String storedToken = session.getString("ACCESS_TOKEN", null);
        String sessionToken = storedToken == null || storedToken.contains("Bearer")
                ? storedToken : "Bearer " + storedToken;
        this.token = token == null ? sessionToken : token;
        this.apiUrl = session.getString("API_URL", null);
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
            @Override protected void onPreExecute() {
                if (callback != null) callback.onProgressVisibility(0);
            }
            @Override protected ApiResponse doInBackground(Void... ignored) {
                try {
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
                } catch (Exception error) {
                    ApiResponse failure = new ApiResponse();
                    failure.setError(true);
                    failure.setCodigoHTTP(500);
                    failure.setMenssaje(error.getMessage() == null ? "Request failed" : error.getMessage());
                    return failure;
                }
            }
            @Override protected void onPostExecute(ApiResponse response) {
                if (callback == null) return;
                callback.onProgressVisibility(4);
                if (operation == Operation.LIST) callback.onListResult(mapList(response));
                else if (operation == Operation.DETAIL) {
                    UserWithRolesResponse detail;
                    try {
                        detail = mapDetail(response);
                    } catch (Exception error) {
                        detail = new UserWithRolesResponse();
                        detail.setOK(false);
                        detail.setHttpCode(500);
                        detail.setMenssage(error.getMessage() == null ? "Request failed" : error.getMessage());
                    }
                    callback.onDetailResult(detail);
                }
                else callback.onMutationResult(operation, mapMutation(response));
            }
        }.execute();
    }

    private ChildUserListResponse mapList(ApiResponse raw) {
        ChildUserListResponse result = new ChildUserListResponse();
        if (raw == null) { result.setOK(false); result.setHttpCode(500); return result; }
        result.setHttpCode(raw.getCodigoHTTP());
        result.setJsonObject(raw.getJsonObject());
        JSONObject body = raw.getJsonObject();
        if (raw.isError() || raw.getCodigoHTTP() != 200 || body == null
                || !body.optString("code").contains("Ok")) {
            result.setOK(false);
            result.setMenssage(raw.getMenssaje());
            return result;
        }
        ArrayList<ChildUser> users = new ArrayList<>();
        JSONObject data = body.optJSONObject("dt");
        JSONArray rows = data == null ? null : data.optJSONArray("rows");
        if (rows != null) for (int i = 0; i < rows.length(); i++) {
            JSONObject row = rows.optJSONObject(i);
            if (row == null) continue;
            ChildUser user = new ChildUser();
            user.setIdUser(row.optInt("id"));
            user.setNombre(row.optString("username", null));
            user.setCorreo(row.optString("email", null));
            user.setCreado(row.optString("created_at", null));
            user.setUpdateAt(row.optString("updated_at", null));
            if (!row.isNull("banned")) user.setActivo(row.optInt("banned") == 0);
            user.setAvatar(apiUrl + "/user/photo/" + row.optString("id"));
            users.add(user);
        }
        result.setItemsList(users);
        result.setOK(true);
        return result;
    }

    private UserWithRolesResponse mapDetail(ApiResponse raw) {
        UserWithRolesResponse result = new UserWithRolesResponse();
        if (raw == null) { result.setOK(false); result.setHttpCode(500); return result; }
        result.setHttpCode(raw.getCodigoHTTP());
        result.setJsonObject(raw.getJsonObject());
        JSONObject body = raw.getJsonObject();
        JSONObject user = body == null ? null : body.optJSONObject("user");
        if (raw.isError() || raw.getCodigoHTTP() != 200 || body == null
                || !body.optString("code").contains("Ok") || user == null) {
            result.setOK(false);
            result.setMenssage(raw.getMenssaje());
            return result;
        }
        UserWithRolesResponse.User detail = new UserWithRolesResponse.User();
        detail.setId(user.optInt("id"));
        detail.setUsername(user.optString("username", null));
        detail.setEmail(user.optString("email", null));
        detail.setDni(user.optString("dni", null));
        detail.setPhone(user.optString("phone", null));
        detail.setAddress(user.optString("address", null));
        detail.setUpdateAt(user.optString("updated_at", null));
        String provinceCode = user.optString("province", null);
        String municipalityCode = user.optString("municipality", null);
        DatabaseHelper database = DatabaseHelper.getInstance();
        if (database != null && provinceCode != null) {
            java.util.List<Province> provinces = database.getAllProvinciasLists();
            if (provinces != null) for (Province province : provinces) {
                if (provinceCode.equals(province.getCod_provincia())) {
                    cu.etecsa.transfermovil.ecommerce.data.geo.Province mapped =
                            new cu.etecsa.transfermovil.ecommerce.data.geo.Province();
                    mapped.setCod_provincia(province.getCod_provincia());
                    mapped.setAbreviatura(province.getAbreviatura());
                    mapped.setNombre(province.getNombre());
                    detail.setProvince(mapped);
                    break;
                }
            }
            java.util.List<Municipality> municipalities = database.getAllMunipiosLists(provinceCode);
            if (municipalities != null && municipalityCode != null) for (Municipality municipality : municipalities) {
                String shortCode = municipalityCode.length() == 4
                        ? municipalityCode.substring(2, 4) : municipalityCode;
                if (shortCode.equals(municipality.getCod_municipio())
                        || municipalityCode.equals(municipality.getId())) {
                    cu.etecsa.transfermovil.ecommerce.data.geo.Municipality mapped =
                            new cu.etecsa.transfermovil.ecommerce.data.geo.Municipality();
                    mapped.setId(municipality.getId());
                    mapped.setCod_provincia(municipality.getCod_provincia());
                    mapped.setCod_municipio(municipality.getCod_municipio());
                    mapped.setAbreviatura(municipality.getAbreviatura());
                    mapped.setNombre(municipality.getNombre());
                    detail.setMunicipality(mapped);
                    break;
                }
            }
        }
        if (database == null) {
            // The running source Application has its own initialized region
            // repository. Reuse it while clean database bootstrap is pending.
            cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil.ldmbl4HatR regions =
                    new cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil.ldmbl4HatR();
            if (cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil.ldmbl4HatR.provinciaList.isEmpty()
                    || cu.etecsa.tm.ecommerce.Dyporpu9vbM.FstCIiz1Qil.ldmbl4HatR.municipiosList.isEmpty()) {
                regions.loadData(context);
            }
            if (provinceCode != null) {
                cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ province =
                        regions.getProvincia(provinceCode, context);
                if (province != null) {
                    cu.etecsa.transfermovil.ecommerce.data.geo.Province mapped =
                            new cu.etecsa.transfermovil.ecommerce.data.geo.Province();
                    mapped.setCod_provincia(province.getCod_provincia());
                    mapped.setAbreviatura(province.getAbreviatura());
                    mapped.setNombre(province.getNombre());
                    detail.setProvince(mapped);
                }
            }
            if (municipalityCode != null && municipalityCode.length() == 4) {
                cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM municipality =
                        regions.getMunicipio(municipalityCode, context);
                if (municipality != null) {
                    cu.etecsa.transfermovil.ecommerce.data.geo.Municipality mapped =
                            new cu.etecsa.transfermovil.ecommerce.data.geo.Municipality();
                    mapped.setId(municipality.getId());
                    mapped.setCod_provincia(municipality.getCod_provincia());
                    mapped.setCod_municipio(municipality.getCod_municipio());
                    mapped.setAbreviatura(municipality.getAbreviatura());
                    mapped.setNombre(municipality.getNombre());
                    detail.setMunicipality(mapped);
                }
            }
        }
        if (provinceCode != null && !provinceCode.isEmpty() && detail.getProvince() == null)
            throw new IllegalStateException("Unable to resolve child-user province");
        if (municipalityCode != null && !municipalityCode.isEmpty() && detail.getMunicipality() == null)
            throw new IllegalStateException("Unable to resolve child-user municipality");
        if (!user.isNull("photo")) detail.setPhoto(apiUrl
                + "/user/photo/" + user.optString("id"));
        result.setUser(detail);
        result.setOK(true);
        return result;
    }

    private static ApiResponse mapMutation(ApiResponse raw) {
        if (raw == null) {
            ApiResponse failure = new ApiResponse();
            failure.setError(true);
            failure.setCodigoHTTP(500);
            failure.setMenssaje("Request failed");
            return failure;
        }
        boolean success = !raw.isError() && raw.getCodigoHTTP() == 200
                && raw.getJsonObject() != null
                && raw.getJsonObject().optString("code").contains("Ok");
        raw.setError(!success);
        if (!success && (raw.getMenssaje() == null || raw.getMenssaje().isEmpty()))
            raw.setMenssaje("Unable to complete child-user operation");
        return raw;
    }
}
