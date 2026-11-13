"""Compare migrated child-user form payloads and result effects with source on JVM.

Android views, presenter dispatch and Toast are recorded by small fixtures; no
network request, device rendering or photo decoding is exercised.
"""
import os
import shutil
import subprocess
import tempfile
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
CLEAN = ROOT / 'app/src/main/java'
RAW = ROOT / 'src'


def extract_method(source, signature):
    start = source.index(signature)
    opening = source.index('{', start)
    depth = 1
    end = opening + 1
    while depth:
        depth += (source[end] == '{') - (source[end] == '}')
        end += 1
    return source[start:end]


@unittest.skipUnless(shutil.which('javac') and shutil.which('java'), 'JDK required')
class ChildUserUiTest(unittest.TestCase):
    def test_form_payloads_and_mutation_callbacks_match_source(self):
        jar = Path(os.environ.get('TRANSFERMOVIL_GSON_JAR', str(
            Path.home() / '.m2/repository/com/google/code/gson/gson/2.9.1/gson-2.9.1.jar')))
        if not jar.is_file():
            self.skipTest('Set TRANSFERMOVIL_GSON_JAR to compare JSON payloads')
        clean = CLEAN / 'cu/etecsa/transfermovil/ecommerce'
        raw = RAW / 'cu/etecsa/tm/ecommerce/LaIvmOMkyve/isyTi1whjIo'
        original_editor = (raw / 'ibvd0DUkXb.java').read_text()
        migrated_editor = (clean / 'ChildUserEditorDialog.java').read_text()
        original_detail = (raw / 'xoBMVddCFw.java').read_text()
        migrated_detail = (clean / 'ChildUserDetailFragment.java').read_text()
        methods = {
            'ORIGINAL_SUBMIT': extract_method(original_editor, 'public void onClick(View v)'),
            'CLEAN_SUBMIT': extract_method(migrated_editor, 'public void onClick(View v)'),
            'ORIGINAL_EDITOR': extract_method(original_editor, 'public void onResultCRUD('),
            'CLEAN_EDITOR': extract_method(migrated_editor, 'public void onMutationResult('),
            'ORIGINAL_DETAIL': extract_method(original_detail, 'public void onResultCRUD('),
            'CLEAN_DETAIL': extract_method(migrated_detail, 'public void onMutationResult('),
            'ORIGINAL_PERMISSIONS': extract_method((RAW / 'cu/etecsa/tm/ecommerce/LaIvmOMkyve/QKj1EC9b3YL/GB0CGE0H88.java').read_text(), 'public void onResult(Boolean result, OkZVobY9IO.OperTypePermisos'),
            'CLEAN_PERMISSIONS': extract_method((clean / 'ChildUserPermissionsDialog.java').read_text(), 'public void onMutationResult('),
            'STATUS_REQUEST': extract_method((clean / 'ChildUserPresenter.java').read_text(), 'public void setStatus('),
        }
        sources = [
            clean / 'model/BaseRequest.java', clean / 'model/BaseApiResult.java',
            clean / 'model/dto/UserProfile.java', clean / 'model/request/ChildUserCreateRequest.java',
            clean / 'model/response/UserWithRolesResponse.java', clean / 'ApiResponse.java',
            clean / 'data/geo/Province.java', clean / 'data/geo/Municipality.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/AfjNivq1ga0/qwlqFYH8aO.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/TzJ2tcDcUWM/YjMcWATWMD.java',
            RAW / 'cu/etecsa/tm/ecommerce/Dyporpu9vbM/tQvDIr4mUHh/XpLbwNXtZPa/fGYt3sYXbt.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/kf1rAJ1MG4.java',
            RAW / 'cu/etecsa/tm/ecommerce/UE0rwmdgIVT/AfjNivq1ga0/u5mpEjsROy.java',
            RAW / 'cu/etecsa/tm/ecommerce/I3ki0FxWzgdY/IEapoTwbnMK/cyVKjSmMxV.java',
            clean / 'model/request/BanUserRequest.java',
        ]
        harness = '''
import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.u5mpEjsROy;
import cu.etecsa.tm.ecommerce.I3ki0FxWzgdY.IEapoTwbnMK.cyVKjSmMxV;
import cu.etecsa.transfermovil.ecommerce.model.request.BanUserRequest;
import cu.etecsa.transfermovil.ecommerce.ApiResponse;
import cu.etecsa.transfermovil.ecommerce.model.dto.UserProfile;
import cu.etecsa.transfermovil.ecommerce.model.request.ChildUserCreateRequest;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.TzJ2tcDcUWM.YjMcWATWMD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
public class ChildUiCheck {
    static class R { static class string { static int head_notificacion=1; } }
    static class OkZVobY9IO { enum OperTypePermisos { STATUS_CHILD, UPDATE_PERMISOS } }
    static class PermissionData { int idUsuario=73; }
    static class View { void setVisibility(int visibility){} }
    static class Text { String value=" value "; String getText(){return value;} }
    static class BuildConfig { static String FLAVOR=""; }
    enum OperTypeChildUserCRUD { CREATE, UPDATE, DELETE }
    static class MNdSLKzqqG {
        enum OperTypeUserList { CREATE_CHILD, UPDATE_CHILD, DELETE_CHILD }
    }
    static class ChildUserPresenter {
        enum Operation { CREATE, UPDATE, DELETE, STATUS }
    }
    static class Dispatch {
        Object request; String route;
        void permisoChildUpdate(Object value){request=value;route="GRANTS";}
        void create(Object value){request=value;route="CREATE_CHILD";}
        void update(Object value){request=value;route="UPDATE_CHILD";}
        void userCRUD(MNdSLKzqqG.OperTypeUserList operation,Object value){request=value;route=operation.name();}
    }
    static class Refresh { int count; void refreshData(){count++;} }
    static class Activity { int backs; void onBackPressed(){backs++;} }
    static class Toast {
        static String message; static Toast makeText(Object context,String value,int duration){message=value;return new Toast();}
        void show(){}
    }
    static class Form {
        List<cyVKjSmMxV> listPermisos=new ArrayList<>();
        PermissionData datos=new PermissionData(); Dispatch permisosPresenter=new Dispatch();
        String getString(int id){return "Notificación";} void goToParentForDev(){}
        View rootView=new View(),mProgressView=new View(); Object context=new Object();
        Text txDireccion=new Text(),txCarnet=new Text(),txMovil=new Text(),txNombre=new Text(),txCorreo=new Text();
        String codigoProvincia="11",codigoMuncipio="1102",imagePath="/selected/photo.png";
        boolean hasNewPhoto; UserWithRolesResponse.User datosUsuario=new UserWithRolesResponse.User();
        OperTypeChildUserCRUD operTypeChildUserCRUD=OperTypeChildUserCRUD.CREATE;
        Dispatch userPresenter=new Dispatch(); Refresh refreshListener=new Refresh();
        String message; boolean dismissed; Activity activity=new Activity();
        void ShowMessageADialog(String title,String text){message=title+":"+text;}
        void dismiss(){dismissed=true;} Activity getActivity(){return activity;}
    }
    static class ibvd0DUkXb extends Form {
        class Click { ORIGINAL_SUBMIT }
        ORIGINAL_EDITOR
    }
    static class ChildUserEditorDialog extends Form {
        class Click { CLEAN_SUBMIT }
        CLEAN_EDITOR
    }
    static class OriginalPermissions extends Form { ORIGINAL_PERMISSIONS }
    static class CleanPermissions extends Form { CLEAN_PERMISSIONS }
    static class StatusRequests {
        enum Operation { STATUS }
        Operation operation; BanUserRequest request;
        void execute(Operation op,Object value){operation=op;request=(BanUserRequest)value;}
        STATUS_REQUEST
    }
    static class OriginalDetail extends Form { ORIGINAL_DETAIL }
    static class CleanDetail extends Form { CLEAN_DETAIL }
    static void check(boolean value,String label){if(!value)throw new AssertionError(label);}
    static void equal(Object a,Object b,String label){check(java.util.Objects.equals(a,b),label+" "+a+" != "+b);}
    public static void main(String[] args) {
        Gson gson=new Gson();
        for(OperTypeChildUserCRUD operation:new OperTypeChildUserCRUD[]{OperTypeChildUserCRUD.CREATE,OperTypeChildUserCRUD.UPDATE}) {
            for(boolean photo:new boolean[]{false,true}) {
                ibvd0DUkXb raw=new ibvd0DUkXb(); ChildUserEditorDialog clean=new ChildUserEditorDialog();
                raw.operTypeChildUserCRUD=clean.operTypeChildUserCRUD=operation;
                raw.hasNewPhoto=clean.hasNewPhoto=photo;
                raw.datosUsuario.setId(73);clean.datosUsuario.setId(73);
                raw.new Click().onClick(new View());clean.new Click().onClick(new View());
                equal(gson.toJsonTree(raw.userPresenter.request),gson.toJsonTree(clean.userPresenter.request),"wire payload");
                equal(raw.userPresenter.route,clean.userPresenter.route,"dispatch route");
                ChildUserCreateRequest request=(ChildUserCreateRequest)clean.userPresenter.request;
                check(java.util.Arrays.equals(request.getRoles(),new int[]{100,101,102,103,200,201}),"default roles");
                if(operation==OperTypeChildUserCRUD.UPDATE) equal("",request.getUser().getPhoto(),"source clears update photo");
                for(boolean success:new boolean[]{false,true}) {
                    kf1rAJ1MG4 oldResult=new kf1rAJ1MG4();oldResult.setOK(success);
                    ApiResponse result=new ApiResponse();result.setError(!success);result.setMenssaje("server failure");
                    raw.onResultCRUD(success,MNdSLKzqqG.OperTypeUserList.CREATE_CHILD,"server failure",oldResult);
                    clean.onMutationResult(ChildUserPresenter.Operation.CREATE,result);
                    equal(raw.message,clean.message,"editor message");
                    equal(raw.dismissed,clean.dismissed,"dismiss");
                    equal(raw.refreshListener.count,clean.refreshListener.count,"refresh");
                }
            }
        }
        for(ChildUserPresenter.Operation operation:new ChildUserPresenter.Operation[]{ChildUserPresenter.Operation.UPDATE,ChildUserPresenter.Operation.DELETE}) {
            for(boolean success:new boolean[]{false,true}) {
                OriginalDetail raw=new OriginalDetail();CleanDetail clean=new CleanDetail();
                kf1rAJ1MG4 oldResult=new kf1rAJ1MG4();oldResult.setOK(success);
                ApiResponse result=new ApiResponse();result.setError(!success);result.setMenssaje("failure");
                raw.onResultCRUD(success,operation==ChildUserPresenter.Operation.UPDATE?MNdSLKzqqG.OperTypeUserList.UPDATE_CHILD:MNdSLKzqqG.OperTypeUserList.DELETE_CHILD,"failure",oldResult);
                String rawToast=Toast.message;Toast.message=null;
                clean.onMutationResult(operation,result);
                equal(raw.message,clean.message,"detail message");
                equal(raw.activity.backs,clean.activity.backs,"detail back navigation");
                if(success&&operation==ChildUserPresenter.Operation.DELETE) equal(rawToast,Toast.message,"delete toast");
            }
        }
        for(int size:new int[]{0,1,4}) for(boolean success:new boolean[]{false,true}) {
            OriginalPermissions raw=new OriginalPermissions();CleanPermissions clean=new CleanPermissions();
            for(int i=0;i<size;i++) {
                cyVKjSmMxV permission=new cyVKjSmMxV();permission.setCodigo(100+i);permission.setEstado(i%2==0);
                raw.listPermisos.add(permission);clean.listPermisos.add(permission);
            }
            kf1rAJ1MG4 oldResult=new kf1rAJ1MG4();oldResult.setOK(success);
            ApiResponse result=new ApiResponse();result.setError(!success);result.setMenssaje("status failure");
            raw.onResult(success,OkZVobY9IO.OperTypePermisos.STATUS_CHILD,"status failure",oldResult);
            clean.onMutationResult(ChildUserPresenter.Operation.STATUS,result);
            equal(raw.message,clean.message,"status error");
            equal(gson.toJsonTree(raw.permisosPresenter.request),gson.toJsonTree(clean.permisosPresenter.request),"enabled grants payload");
            if(!success)check(clean.permisosPresenter.request==null,"failed status must not save grants");
        }
        for(boolean banned:new boolean[]{false,true}) {
            StatusRequests status=new StatusRequests();status.setStatus(73,banned);
            equal(73,status.request.getId(),"status identity");
            equal(banned?"1":"0",status.request.getBanned(),"status string");
        }
        ChildUserEditorDialog detached=new ChildUserEditorDialog();detached.rootView=null;
        detached.onMutationResult(ChildUserPresenter.Operation.CREATE,new ApiResponse());
        check(!detached.dismissed&&detached.refreshListener.count==0,"detached view callback");
    }
}
'''
        for key, value in methods.items():
            harness = harness.replace(key, value)
        with tempfile.TemporaryDirectory() as directory:
            temp = Path(directory)
            stub = temp / 'org/json/JSONObject.java'
            stub.parent.mkdir(parents=True)
            stub.write_text('package org.json; public class JSONObject {}')
            main = temp / 'ChildUiCheck.java'
            main.write_text(harness)
            compile_result = subprocess.run(['javac', '-cp', str(jar), '-d', directory,
                                            str(stub), str(main), *map(str, sources)],
                                           capture_output=True, text=True)
            self.assertEqual(0, compile_result.returncode, compile_result.stderr)
            run = subprocess.run(['java', '-cp', directory + os.pathsep + str(jar), 'ChildUiCheck'],
                                 capture_output=True, text=True)
            self.assertEqual(0, run.returncode, run.stderr)
