package cu.etecsa.transfermovil.ecommerce;

import cu.etecsa.transfermovil.ecommerce.model.response.ChildUserListResponse;
import cu.etecsa.transfermovil.ecommerce.model.response.UserWithRolesResponse;
import cu.etecsa.transfermovil.ecommerce.model.request.ChildUserCreateRequest;
import cu.etecsa.transfermovil.ecommerce.model.dto.UserProfile;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.qwlqFYH8aO;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.TzJ2tcDcUWM.YjMcWATWMD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ToUwD5xX9T;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.OkZVobY9IO;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.x4umm6Wzsp8;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.ThptISKBHA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/**
 * @obfuscated_class cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.xoBMVddCFw
 * @original_apk_version 1.260416
 */
public class ChildUserDetailFragment extends Fragment implements ChildUserPresenter.Callback, ChildUserRefreshCallback, Xz5tY9X1IR {
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int PERMISSION_CODE = 1000;
    public String HEAD_LOG = "ChildUserDetailFragment";
    public Activity activity;
    public ImageView btEdit;
    public ImageView btFoto;
    public Context context;
    public boolean hasNewPhoto;
    public int idUser;
    public ImageView imAvatar;
    public String imagePath;
    public Uri image_uri;
    private LinearLayout pBar;
    public x4umm6Wzsp8 permisosPresenter;
    public View rootView;
    public boolean takePhoto;
    public TextView txCarnet;
    public TextView txCorreo;
    public TextView txDireccion;
    public TextView txMovil;
    public TextView txMuncipio;
    public TextView txNombre;
    public TextView txProvincia;
    public TextView txRol;
    public UserWithRolesResponse.User userChild;
    public ChildUserPresenter userPresenter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.u6a4uqpcfppv3k, container, false);
        this.context = container.getContext();
        this.pBar = (LinearLayout) this.rootView.findViewById(R.id.llProgressBar);
        this.userPresenter = new ChildUserPresenter(this.context, null, this);
        this.permisosPresenter = new OkZVobY9IO(this, this.context);
        this.txRol = (TextView) this.rootView.findViewById(R.id.txRol);
        String rol = UhA7J2923N.getInstance().getUserRol();
        this.txRol.setText(rol);
        this.txNombre = (TextView) this.rootView.findViewById(R.id.txNombre);
        this.txDireccion = (TextView) this.rootView.findViewById(R.id.txDireccion);
        this.txCorreo = (TextView) this.rootView.findViewById(R.id.txCorreo);
        this.txMovil = (TextView) this.rootView.findViewById(R.id.txMovil);
        this.txCarnet = (TextView) this.rootView.findViewById(R.id.txCarnet);
        this.txProvincia = (TextView) this.rootView.findViewById(R.id.txProvincia);
        this.txMuncipio = (TextView) this.rootView.findViewById(R.id.txMuncipio);
        this.imAvatar = (ImageView) this.rootView.findViewById(R.id.imAvatar);
        this.btEdit = (ImageView) this.rootView.findViewById(R.id.btEdit);
        this.btFoto = (ImageView) this.rootView.findViewById(R.id.btFoto);
        this.btEdit.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChildUserDetailFragment.this.mostrarUpdateUser();
            }
        });
        if (!UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS) && !UhA7J2923N.getInstance().checkUserPermission(ThptISKBHA.GESTIONAR_USUARIOS_HIJOS)) {
            this.btEdit.setVisibility(4);
            this.btFoto.setVisibility(4);
        }
        Bundle arg = getArguments();
        if (arg.containsKey("ID")) {
            this.pBar.setVisibility(0);
            int i = arg.getInt("ID");
            this.idUser = i;
            this.userPresenter.detail(i);
            qwlqFYH8aO request = new qwlqFYH8aO();
            YjMcWATWMD user = new YjMcWATWMD();
            user.setId(String.valueOf(this.idUser));
            request.setUser(user);
            this.permisosPresenter.permisoChildCRUD(OkZVobY9IO.OperTypePermisos.GET_PERMISOS, request);
        }
        this.btFoto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChildUserDetailFragment.this.showManipulateFoto();
            }
        });
        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_delete, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        if (i == R.id.delete) {
            showMessagaDeleteUserDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override
    public void onDetailResult(UserWithRolesResponse response) {
        if (rootView == null) return;
        pBar.setVisibility(4);
        if (response.isOK() && response.getUser() != null) {
            userChild = response.getUser();
            txCarnet.setText(userChild.getDni());
            txCorreo.setText(userChild.getEmail());
            txDireccion.setText(userChild.getAddress());
            txMovil.setText(userChild.getPhone());
            if (userChild.getMunicipality() != null) txMuncipio.setText(userChild.getMunicipality().getNombre());
            if (userChild.getProvince() != null) txProvincia.setText(userChild.getProvince().getNombre());
            txNombre.setText(userChild.getUsername());
            Glide.with(context).load(userChild.getPhoto()).signature(new ObjectKey(userChild.getUpdateAt()))
                    .centerCrop().placeholder(R.drawable.ic_avatar).into(imAvatar);
        } else if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(context, response.getMenssage(), 1).show();
        }
    }

    @Override
    public void onMutationResult(ChildUserPresenter.Operation operation, ApiResponse response) {
        if (rootView == null) return;
        if (operation == ChildUserPresenter.Operation.UPDATE) {
            ShowMessageADialog("Notificación", response.isError() ? response.getMenssaje() : "Perfil actualizado");
        } else if (operation == ChildUserPresenter.Operation.DELETE) {
            if (!response.isError()) {
                Toast.makeText(context, "Usuario eliminado", 1).show();
                getActivity().onBackPressed();
            } else ShowMessageADialog("Notificación", response.getMenssaje());
        }
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR
    public void onResultPermisos(Boolean result, int code, String mensaje, ToUwD5xX9T permisosResponse) {
        Toast.makeText(this.context, mensaje, 1);
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.Xz5tY9X1IR
    public void onResult(Boolean result, OkZVobY9IO.OperTypePermisos operTypePermisos, String mensaje, kf1rAJ1MG4 response) {
    }

    @Override public void onListResult(ChildUserListResponse response) {}

    @Override
    public void onProgressVisibility(final int visibility) {
        activity.runOnUiThread(() -> { if (rootView != null) pBar.setVisibility(visibility); });
    }

    @Override
    public void onSetProgressBarVisibility(final int visibility) {
        onProgressVisibility(visibility);
    }

    @Override
    public void onDestroyView() {
        rootView = null;
        super.onDestroyView();
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.4
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(ChildUserDetailFragment.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    public void showMessagaDeleteUserDialog() {
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.5
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(ChildUserDetailFragment.this.context).setTitle("Eliminar usuario").setMessage("Confirme que desea eliminar el usuario seleccionado").setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.5.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        ChildUserDetailFragment.this.userPresenter.delete(idUser);
                    }
                }).setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarUpdateUser() {
        ChildUserEditorDialog dialogFrag = ChildUserEditorDialog.newInstance(this.userChild);
        dialogFrag.setListener(this);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_crear_user");
    }

    private void actualizarFoto() {
        ChildUserCreateRequest request = new ChildUserCreateRequest();
        UserProfile user = new UserProfile();
        user.setAddress(this.userChild.getAddress());
        user.setDni(this.userChild.getDni());
        user.setPhone(this.userChild.getPhone());
        user.setUsername(this.userChild.getUsername());
        if (this.userChild.getProvince() != null) {
            user.setProvince(this.userChild.getProvince().getCod_provincia());
        }
        if (this.userChild.getProvince() != null && this.userChild.getMunicipality() != null) {
            user.setMunicipality(this.userChild.getProvince().getCod_provincia() + this.userChild.getMunicipality().getCod_municipio());
        }
        user.setEmail(this.userChild.getEmail());
        user.setId(String.valueOf(this.userChild.getId()));
        if (this.hasNewPhoto) {
            user.setPhoto(this.imagePath);
        }
        request.setUser(user);
        this.pBar.setVisibility(0);
        this.userPresenter.update(request);
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH
    public void refreshData() {
        this.pBar.setVisibility(0);
        this.userPresenter.detail(this.idUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showManipulateFoto() {
        CharSequence[] items = {"Seleccionar en Galeria", "Tomar Foto"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la opción deseada");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        ChildUserDetailFragment xobmvddcfw = ChildUserDetailFragment.this;
                        xobmvddcfw.takePhoto = false;
                        xobmvddcfw.takeGallery();
                        break;
                    case 1:
                        ChildUserDetailFragment xobmvddcfw2 = ChildUserDetailFragment.this;
                        xobmvddcfw2.takePhoto = true;
                        xobmvddcfw2.takePhoto();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.ChildUserDetailFragment.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takeGallery() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (i >= 23 && this.context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == -1) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                return;
            } else {
                Intent i2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i2, 1);
                return;
            }
        }
        Intent i3 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i3, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.context.checkSelfPermission("android.permission.CAMERA") == -1 || this.context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                String[] permission = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
                requestPermissions(permission, 1000);
                return;
            } else {
                openCamera();
                return;
            }
        }
        openCamera();
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put("title", "New Pic");
        values.put("description", "From camera");
        this.image_uri = this.context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        cameraIntent.putExtra("output", this.image_uri);
        startActivityForResult(cameraIntent, 1001);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UhA7J2923N global = UhA7J2923N.getInstance();
        String str = global.getToken_type() + " " + global.getAccess_token();
        this.hasNewPhoto = true;
        if (this.takePhoto) {
            if (requestCode == 1001) {
                Glide.with(this.activity).load(this.image_uri).centerCrop().placeholder(R.drawable.ic__users).into(this.imAvatar);
                String[] filePathColumn = {"_data"};
                Cursor cursor = this.context.getContentResolver().query(this.image_uri, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                this.imagePath = cursor.getString(columnIndex);
                cursor.close();
                actualizarFoto();
                return;
            }
            return;
        }
        if (requestCode == 1 && resultCode == -1 && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn2 = {"_data"};
            Cursor cursor2 = this.context.getContentResolver().query(selectedImage, filePathColumn2, null, null, null);
            cursor2.moveToFirst();
            int columnIndex2 = cursor2.getColumnIndex(filePathColumn2[0]);
            this.imagePath = cursor2.getString(columnIndex2);
            cursor2.close();
            Glide.with(this.activity).load(this.imagePath).centerCrop().placeholder(R.drawable.ic_avatar).into(this.imAvatar);
            actualizarFoto();
        }
    }
}
