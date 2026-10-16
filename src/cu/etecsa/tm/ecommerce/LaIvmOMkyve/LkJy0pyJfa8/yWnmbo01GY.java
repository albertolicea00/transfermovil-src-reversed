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
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.github.paolorotolo.appintro.BuildConfig;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.I7Szcu2IgpM;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.G6liG5If2lu.njwILmSkGJ;
import cu.etecsa.tm.ecommerce.Dyporpu9vbM.KQ1TrOYV2S;
import cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua;
import cu.etecsa.tm.ecommerce.LaIvmOMkyve.isyTi1whjIo.p5UHWIhp4aH;
import cu.etecsa.tm.ecommerce.R;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.AfjNivq1ga0.w4DRczPYeb;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.XiLHuwQSoCT.ME8KWex9OS;
import cu.etecsa.tm.ecommerce.UE0rwmdgIVT.kf1rAJ1MG4;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.IDVHiDs0Ry2.PWf5TMuFy2;
import cu.etecsa.tm.ecommerce.XhsesTGphuL.N9BWYA3EvW;
import cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA;
import cu.etecsa.tm.ecommerce.qHBfDCWv13G.UhA7J2923N;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yWnmbo01GY extends DialogFragment implements uBTvQUHyua {
    public static final String DATOS_RESPONSE = "PAGO";
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int PERMISSION_CODE = 1000;
    public Activity activity;
    public ImageView btClose;
    public Button btOK;
    public CardView cdDetalles;
    public CardView cdEstado;
    public String codigoMuncipio;
    public String codigoProvincia;
    public Context context;
    public ME8KWex9OS.YjMcWATWMD datosUsuario;
    public boolean hasNewPhoto;
    public ImageView imAvatar;
    public String imagePath;
    public Uri image_uri;
    public TextInputLayout lyCorreo;
    public TextInputLayout lyDireccion;
    public TextInputLayout lyMovil;
    public TextInputLayout lyMunicipio;
    public TextInputLayout lyNombre;
    public TextInputLayout lyProvincia;
    private ProgressBar mProgressView;
    public ArrayAdapter<I7Szcu2IgpM> municipioArrayAdapter;
    public List<I7Szcu2IgpM> municipioList;
    public OperTypeProfileCRUD operTypeProfileCRUD;
    public N9BWYA3EvW profilePresenter;
    public ArrayAdapter<njwILmSkGJ> provinciaArrayAdapter;
    public List<njwILmSkGJ> provinciaList;
    public p5UHWIhp4aH refreshListener;
    public View rootView;
    public Hrke6IBHBA spMunicipio;
    public Hrke6IBHBA spProvincia;
    public boolean takePhoto;
    public TextInputEditText txCarnet;
    public TextInputEditText txCorreo;
    public TextInputEditText txDireccion;
    public TextInputEditText txMovil;
    public TextInputEditText txNombre;
    public TextView txOperacion;
    private Hrke6IBHBA.OnItemClickListener spClickProvincia = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.4
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            yWnmbo01GY ywnmbo01gy = yWnmbo01GY.this;
            ywnmbo01gy.codigoProvincia = ywnmbo01gy.provinciaList.get(position).getCod_provincia();
            yWnmbo01GY ywnmbo01gy2 = yWnmbo01GY.this;
            ywnmbo01gy2.fillMuncipio(ywnmbo01gy2.codigoProvincia);
        }
    };
    private Hrke6IBHBA.OnItemClickListener spClickMunicipio = new Hrke6IBHBA.OnItemClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.5
        @Override // cu.etecsa.tm.ecommerce.d4hGW2d9EW8.Hrke6IBHBA.OnItemClickListener
        public void onItemClick(View view, int position) {
            yWnmbo01GY.this.codigoMuncipio = yWnmbo01GY.this.codigoProvincia + yWnmbo01GY.this.municipioList.get(position).getCod_municipio();
        }
    };
    public View.OnClickListener btClickOK = new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.6
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            w4DRczPYeb request = new w4DRczPYeb();
            request.setAddress(yWnmbo01GY.this.txDireccion.getText().toString().trim());
            request.setDni(yWnmbo01GY.this.txCarnet.getText().toString().trim());
            request.setPhone(yWnmbo01GY.this.txMovil.getText().toString().trim());
            request.setUsername(yWnmbo01GY.this.txNombre.getText().toString().trim());
            request.setProvince(yWnmbo01GY.this.codigoProvincia);
            request.setMunicipality(yWnmbo01GY.this.codigoMuncipio);
            request.setEmail(yWnmbo01GY.this.txCorreo.getText().toString().trim());
            request.setId(String.valueOf(yWnmbo01GY.this.datosUsuario.getId()));
            yWnmbo01GY ywnmbo01gy = yWnmbo01GY.this;
            if (ywnmbo01gy.hasNewPhoto) {
                request.setPhoto(ywnmbo01gy.imagePath);
            } else {
                request.setPhoto(BuildConfig.FLAVOR);
            }
            yWnmbo01GY.this.mProgressView.setVisibility(0);
            yWnmbo01GY.this.profilePresenter.updateProfile(request);
        }
    };

    public enum OperTypeProfileCRUD {
        CREATE,
        UPDATE,
        DELETE
    }

    public void setListener(p5UHWIhp4aH listener) {
        this.refreshListener = listener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.wtpyuz93bhkq5, container, false);
        Bundle arg = getArguments();
        Context context = inflater.getContext();
        this.context = context;
        this.profilePresenter = new PWf5TMuFy2(this, context);
        this.txOperacion = (TextView) this.rootView.findViewById(R.id.txOperacion);
        this.lyCorreo = (TextInputLayout) this.rootView.findViewById(R.id.lyCorreo);
        this.lyNombre = (TextInputLayout) this.rootView.findViewById(R.id.lyNombre);
        this.lyMovil = (TextInputLayout) this.rootView.findViewById(R.id.lyMovil);
        this.lyProvincia = (TextInputLayout) this.rootView.findViewById(R.id.lyProvincia);
        this.lyMunicipio = (TextInputLayout) this.rootView.findViewById(R.id.lyMunicipio);
        this.lyDireccion = (TextInputLayout) this.rootView.findViewById(R.id.lyDireccion);
        this.txCorreo = (TextInputEditText) this.rootView.findViewById(R.id.txCorreo);
        this.txNombre = (TextInputEditText) this.rootView.findViewById(R.id.txNombre);
        TextInputEditText textInputEditText = (TextInputEditText) this.rootView.findViewById(R.id.txMovil);
        this.txMovil = textInputEditText;
        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    yWnmbo01GY.this.txMovil.setText("+535");
                }
            }
        });
        this.txCarnet = (TextInputEditText) this.rootView.findViewById(R.id.txCarnet);
        this.txDireccion = (TextInputEditText) this.rootView.findViewById(R.id.txDireccion);
        this.spProvincia = (Hrke6IBHBA) this.rootView.findViewById(R.id.spProvincia);
        this.spMunicipio = (Hrke6IBHBA) this.rootView.findViewById(R.id.spMunicipio);
        fillProvincias();
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.btClose);
        this.btClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                yWnmbo01GY.this.dismiss();
            }
        });
        this.imAvatar = (ImageView) this.rootView.findViewById(R.id.imAvatar);
        Button button = (Button) this.rootView.findViewById(R.id.btOK);
        this.btOK = button;
        button.setOnClickListener(this.btClickOK);
        this.cdEstado = (CardView) this.rootView.findViewById(R.id.cdEstado);
        this.cdDetalles = (CardView) this.rootView.findViewById(R.id.cdDetalles);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.mProgressView = (ProgressBar) this.rootView.findViewById(R.id.progress);
        ThreeBounce doubleBounce = new ThreeBounce();
        doubleBounce.setColor(-1);
        this.mProgressView.setIndeterminateDrawable(doubleBounce);
        this.mProgressView.setVisibility(4);
        if (arg != null && arg.containsKey("PAGO")) {
            this.datosUsuario = (ME8KWex9OS.YjMcWATWMD) arg.getSerializable("PAGO");
            this.operTypeProfileCRUD = OperTypeProfileCRUD.UPDATE;
            this.txOperacion.setText("ACTUALIZAR");
            this.cdEstado.setCardBackgroundColor(this.context.getResources().getColor(R.color.pcolorAccent));
            this.cdDetalles.setCardBackgroundColor(this.context.getResources().getColor(R.color.colorAccent2));
            this.btOK.setBackgroundColor(this.context.getResources().getColor(R.color.colorAccent3));
            this.btOK.setText("ACTUALIZAR");
            fillData();
        } else {
            this.datosUsuario = null;
            this.operTypeProfileCRUD = OperTypeProfileCRUD.CREATE;
            this.txOperacion.setText("CREAR USUARIO");
        }
        this.imAvatar.setOnClickListener(new View.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                yWnmbo01GY.this.showManipulateFoto();
            }
        });
        return this.rootView;
    }

    public static yWnmbo01GY newInstance(ME8KWex9OS.YjMcWATWMD userChild) {
        yWnmbo01GY frag = new yWnmbo01GY();
        Bundle args = new Bundle();
        args.putSerializable("PAGO", userChild);
        frag.setArguments(args);
        return frag;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    public void fillData() {
        ME8KWex9OS.YjMcWATWMD yjMcWATWMD = this.datosUsuario;
        if (yjMcWATWMD != null) {
            this.txMovil.setText(yjMcWATWMD.getPhone());
            this.txCorreo.setText(this.datosUsuario.getEmail());
            this.txCarnet.setText(this.datosUsuario.getDni());
            this.txDireccion.setText(this.datosUsuario.getAddress());
            this.txNombre.setText(this.datosUsuario.getUsername());
            if (this.datosUsuario.getProvince() != null && this.datosUsuario.getMunicipality() != null) {
                this.codigoProvincia = this.datosUsuario.getProvince().getCod_provincia();
                this.codigoMuncipio = this.datosUsuario.getProvince().getCod_provincia() + this.datosUsuario.getMunicipality().getCod_municipio();
                fillMuncipio(this.codigoProvincia);
                this.spProvincia.setText(this.datosUsuario.getProvince().getNombre());
                this.spMunicipio.setText(this.datosUsuario.getMunicipality().getNombre());
            }
            Glide.with(this.context).load(this.datosUsuario.getPhoto()).signature(new ObjectKey(this.datosUsuario.getUpdateAt())).centerCrop().placeholder(R.drawable.ic_avatar).into(this.imAvatar);
        }
    }

    private void fillProvincias() {
        KQ1TrOYV2S.getInstance().getRegionRepo().loadData(this.context);
        this.provinciaList = KQ1TrOYV2S.getInstance().getRegionRepo().getProvinciasList(this.context);
        this.provinciaArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
        for (njwILmSkGJ item : this.provinciaList) {
            this.provinciaArrayAdapter.add(item);
        }
        this.provinciaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spProvincia.setAdapter(this.provinciaArrayAdapter);
        this.spProvincia.setOnItemClickListener(this.spClickProvincia);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillMuncipio(String codigoProvincia) {
        this.municipioArrayAdapter = new ArrayAdapter<>(this.context, android.R.layout.simple_dropdown_item_1line);
        List<I7Szcu2IgpM> muncipioXProvinciaList = KQ1TrOYV2S.getInstance().getRegionRepo().getMuncipioXProvinciaList(codigoProvincia, this.context);
        this.municipioList = muncipioXProvinciaList;
        for (I7Szcu2IgpM item : muncipioXProvinciaList) {
            this.municipioArrayAdapter.add(item);
        }
        this.municipioArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spMunicipio.setAdapter(this.municipioArrayAdapter);
        this.spMunicipio.setOnItemClickListener(this.spClickMunicipio);
    }

    public void ShowMessageADialog(final String title, final String mensaje) {
        getActivity().runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.7
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(yWnmbo01GY.this.context).setTitle(title).setMessage(mensaje).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua
    public void onSetProgressBarVisibility(final int visibility) {
        this.activity.runOnUiThread(new Runnable() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.8
            @Override // java.lang.Runnable
            public void run() {
                yWnmbo01GY.this.mProgressView.setVisibility(visibility);
                if (visibility == 0) {
                    yWnmbo01GY.this.enabledControls(false);
                } else {
                    yWnmbo01GY.this.enabledControls(true);
                }
            }
        });
    }

    @Override // cu.etecsa.tm.ecommerce.HOOahyDFMGH.uBTvQUHyua
    public void onResult(Boolean result, N9BWYA3EvW.OperTypeProfilePresenter operTypeProfilePresenter, String mensaje, kf1rAJ1MG4 response) {
        if (result.booleanValue()) {
            if (response.isOK()) {
                UhA7J2923N.getInstance().setChangePhotoHome("change");
                this.refreshListener.refreshData();
                dismiss();
                if (operTypeProfilePresenter == N9BWYA3EvW.OperTypeProfilePresenter.UPDATE) {
                    ShowMessageADialog("Notificación", "Usuario actualizado");
                    return;
                }
                return;
            }
            ShowMessageADialog("Notificación", mensaje);
            return;
        }
        ShowMessageADialog("Notificación", mensaje);
    }

    public void enabledControls(boolean enabled) {
        this.txCarnet.setEnabled(enabled);
        this.txCorreo.setEnabled(enabled);
        this.txDireccion.setEnabled(enabled);
        this.txMovil.setEnabled(enabled);
        this.txNombre.setEnabled(enabled);
        this.btClose.setEnabled(enabled);
        this.btOK.setEnabled(enabled);
        this.lyCorreo.setEnabled(enabled);
        this.lyDireccion.setEnabled(enabled);
        this.lyMovil.setEnabled(enabled);
        this.lyMunicipio.setEnabled(enabled);
        this.lyProvincia.setEnabled(enabled);
        this.spMunicipio.setEnabled(enabled);
        this.spProvincia.setEnabled(enabled);
        this.imAvatar.setEnabled(enabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showManipulateFoto() {
        CharSequence[] items = {"Seleccionar en Galeria", "Tomar Foto"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Seleccione la opción deseada");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        yWnmbo01GY ywnmbo01gy = yWnmbo01GY.this;
                        ywnmbo01gy.takePhoto = false;
                        ywnmbo01gy.takeGallery();
                        break;
                    case 1:
                        yWnmbo01GY ywnmbo01gy2 = yWnmbo01GY.this;
                        ywnmbo01gy2.takePhoto = true;
                        ywnmbo01gy2.takePhoto();
                        break;
                }
            }
        });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() { // from class: cu.etecsa.tm.ecommerce.LaIvmOMkyve.LkJy0pyJfa8.yWnmbo01GY.10
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
        }
    }
}
