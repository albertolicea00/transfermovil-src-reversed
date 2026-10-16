package cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8;

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
import com.github.paolorotolo.appintro.BuildConfig;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.K1a8LCEmAD;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.OUl0pYQl8g;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.PWf5TMuFy2;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;

/* JADX INFO: loaded from: classes.dex */
public class tUBlYBpX0J extends Fragment implements uBTvQUHyua, p5UHWIhp4aH {
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int PERMISSION_CODE = 1000;
    public String HEAD_LOG = "tUBlYBpX0J";
    public Activity activity;
    public ImageView btEdit;
    public ImageView btFoto;
    public ImageView btPass;
    public Context context;
    public boolean hasNewPhoto;
    public int idUser;
    public ImageView imAvatar;
    public String imagePath;
    public Uri image_uri;
    private LinearLayout pBar;
    public N9BWYA3EvW profilePresenter;
    public OUl0pYQl8g profileResponse;
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
    public ME8KWex9OS.YjMcWATWMD user;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.zfmalw76qvuwb, container, false);
        this.context = container.getContext();
        this.pBar = (LinearLayout) this.rootView.findViewById(R.id.llProgressBar);
        this.profilePresenter = new PWf5TMuFy2(this, this.context);
        this.txRol = (TextView) this.rootView.findViewById(R.id.txRol);
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
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btPass);
        this.btPass = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tUBlYBpX0J.this.mostrarCambioPass();
            }
        });
        this.btFoto.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                tUBlYBpX0J.this.showManipulateFoto();
            }
        });
        this.profilePresenter.getProfile();
        try {
            String rol = UhA7J2923N.getInstance().getUserRol();
            if (rol == null || rol.length() <= 0) {
                this.txRol.setText("Usuario");
            } else {
                this.txRol.setText(rol.toLowerCase());
            }
        } catch (Exception e) {
            this.txRol.setText("Usuario");
        }
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarCambioPass() {
        aJPnChUFfp dialogFrag = new aJPnChUFfp();
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1987);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_cambio_pass");
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.3
            @Override // java.lang.Runnable
            public void run() {
                tUBlYBpX0J.this.pBar.setVisibility(visibility);
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua
    public void onResult(Boolean result, N9BWYA3EvW.OperTypeProfilePresenter operTypeProfilePresenter, String mensaje, kf1rAJ1MG4 response) {
        if (result.booleanValue()) {
            if (operTypeProfilePresenter == N9BWYA3EvW.OperTypeProfilePresenter.GET_PROFILE) {
                if (response instanceof OUl0pYQl8g) {
                    OUl0pYQl8g oUl0pYQl8g = (OUl0pYQl8g) response;
                    this.profileResponse = oUl0pYQl8g;
                    loadDataProfileUI(oUl0pYQl8g);
                    this.btEdit.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            ME8KWex9OS.YjMcWATWMD user = new ME8KWex9OS.YjMcWATWMD();
                            user.setId(tUBlYBpX0J.this.profileResponse.getId());
                            user.setUpdateAt(tUBlYBpX0J.this.profileResponse.getUpdateAt());
                            user.setPhoto(tUBlYBpX0J.this.profileResponse.getPhoto());
                            user.setProvince(tUBlYBpX0J.this.profileResponse.getProvince());
                            user.setMunicipality(tUBlYBpX0J.this.profileResponse.getMunicipality());
                            user.setAddress(tUBlYBpX0J.this.profileResponse.getAddress());
                            user.setPhone(tUBlYBpX0J.this.profileResponse.getPhone());
                            user.setDni(tUBlYBpX0J.this.profileResponse.getDni());
                            user.setEmail(tUBlYBpX0J.this.profileResponse.getEmail());
                            user.setUsername(tUBlYBpX0J.this.profileResponse.getUsername());
                            tUBlYBpX0J.this.mostrarUpdateUser(user);
                        }
                    });
                    return;
                }
                if (response.getHttpCode() == 401) {
                    UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
                    return;
                } else {
                    Toast.makeText(this.context, "Error cargando datos", 1).show();
                    return;
                }
            }
            if (operTypeProfilePresenter == N9BWYA3EvW.OperTypeProfilePresenter.CHANGE_Password) {
                Toast.makeText(this.context, "Su contraseña ha sido cambiada", 1).show();
                return;
            }
            return;
        }
        if (response.getHttpCode() == 401) {
            UhA7J2923N.getInstance().finilizarNoAutenticado(getActivity());
        } else {
            Toast.makeText(this.context, mensaje, 1).show();
        }
    }

    public void loadDataProfileUI(OUl0pYQl8g response) {
        this.txCarnet.setText(response.getDni());
        this.txCorreo.setText(response.getEmail());
        this.txDireccion.setText(response.getAddress());
        this.txMovil.setText(response.getPhone());
        if (response.getMunicipality() != null) {
            this.txMuncipio.setText(response.getMunicipality().getNombre());
        }
        if (response.getProvince() != null) {
            this.txProvincia.setText(response.getProvince().getNombre());
        }
        this.txNombre.setText(response.getUsername());
        String urlImage = UhA7J2923N.getInstance().getApiURL() + "/user/photo/" + UhA7J2923N.getInstance().getUserid();
        Glide.with(this.context).load(urlImage).signature(new ObjectKey(response.getUpdateAt())).centerCrop().placeholder(R.drawable.ic_avatar).into(this.imAvatar);
        UhA7J2923N.getInstance().setChangePhotoHome("change");
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.5
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(tUBlYBpX0J.this.getContext()).setTitle(title).setMessage(mensaje).setPositiveButton("OK", null).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mostrarUpdateUser(ME8KWex9OS.YjMcWATWMD user) {
        yWnmbo01GY dialogFrag = yWnmbo01GY.newInstance(user);
        dialogFrag.setListener(this);
        if (dialogFrag.getDialog() != null) {
            dialogFrag.getDialog().setCanceledOnTouchOutside(true);
        }
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.setCancelable(false);
        dialogFrag.show(getFragmentManager(), "fragment_crear_user");
    }

    private void actualizarFoto() {
        w4DRczPYeb request = new w4DRczPYeb();
        request.setAddress(this.txDireccion.getText().toString().trim());
        request.setDni(this.txCarnet.getText().toString().trim());
        request.setPhone(this.txMovil.getText().toString().trim());
        request.setUsername(this.txNombre.getText().toString().trim());
        if (this.profileResponse.getProvince() != null) {
            request.setProvince(this.profileResponse.getProvince().getCod_provincia());
        }
        if (this.profileResponse.getProvince() != null && this.profileResponse.getMunicipality() != null) {
            request.setMunicipality(this.profileResponse.getProvince().getCod_provincia() + this.profileResponse.getMunicipality().getCod_municipio());
        }
        request.setEmail(this.txCorreo.getText().toString().trim());
        request.setId(String.valueOf(this.profileResponse.getId()));
        if (this.hasNewPhoto) {
            request.setPhoto(this.imagePath);
        } else {
            request.setPhoto(BuildConfig.FLAVOR);
        }
        this.profilePresenter.updateProfile(request);
    }

    @Override // cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH
    public void refreshData() {
        this.pBar.setVisibility(0);
        this.profilePresenter.getProfile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showManipulateFoto() {
        CharSequence[] items = {"Seleccionar en Galeria", "Tomar Foto"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la opción deseada");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        tUBlYBpX0J tublybpx0j = tUBlYBpX0J.this;
                        tublybpx0j.takePhoto = false;
                        tublybpx0j.takeGallery();
                        break;
                    case 1:
                        tUBlYBpX0J tublybpx0j2 = tUBlYBpX0J.this;
                        tublybpx0j2.takePhoto = true;
                        tublybpx0j2.takePhoto();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.tUBlYBpX0J.7
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
        if (requestCode == 1987) {
            if (resultCode == 1) {
                NnwdA7ink5 parameters = (NnwdA7ink5) data.getSerializableExtra("PARAMETERS");
                K1a8LCEmAD passwordRequest = new K1a8LCEmAD();
                passwordRequest.setOldpassword(parameters.getOld());
                passwordRequest.setNewpassword(parameters.getNuevo());
                passwordRequest.setRenewpassword(parameters.getRepeat_nuevo());
                this.profilePresenter.changePassword(passwordRequest);
                return;
            }
            return;
        }
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
