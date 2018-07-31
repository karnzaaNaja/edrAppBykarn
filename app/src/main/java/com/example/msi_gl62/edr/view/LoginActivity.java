package com.example.msi_gl62.edr.view;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.fragment.MainTabActivity;
import com.example.msi_gl62.edr.model.ModelLogin;
import com.example.msi_gl62.edr.service.UrlService;
import com.example.msi_gl62.edr.util.AppUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_username,edt_password;
    private Button btn_login;
    private TextView txt_co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setById();
        setOnClick();
    }

    @Override
    public void onClick(View v) {
       if(v==txt_co){
           Intent intent = new Intent(LoginActivity.this, ListCustomerActivity.class);
           startActivity(intent);
       }else if(v==btn_login){
           chackEditext();
       }else {}
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String School_name = sp.getString("School_name", "");
        if(School_name.equals("")){
            txt_co.setText("แตะเพื่อเลือกมหาวิทยาลัย");
        }else { txt_co.setText(School_name); }
    }

    private void setById() {
        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_password=(EditText)findViewById(R.id.edt_pass);
        btn_login=(Button)findViewById(R.id.btn_login);
        txt_co=(TextView)findViewById(R.id.edt_co);
    }

    private void setOnClick(){
        txt_co.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    private void chackEditext(){
        SharedPreferences sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String app_edr_ipaddress = sp.getString("app_edr_ipaddress", "");
        String app_edr_android_port = sp.getString("app_edr_android_port", "");
        if(AppUtil.isEmpty(app_edr_ipaddress)){
            dialogErrorBox();
        }else {
            if(AppUtil.isEmpty(edt_username.getText().toString()) || AppUtil.isEmpty(edt_password.getText().toString())){
                dialogErrorBox();
            }else{
                String _u=edt_username.getText().toString();
                String _p=edt_password.getText().toString();
                getApiLogin(_u,"81dc9bdb52d04dc20036dbd8313ed055",app_edr_ipaddress,app_edr_android_port);
            } }
    }

    private void getApiLogin(String u, String p,String app_edr_ipaddress,String app_edr_android_port){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+app_edr_ipaddress+":"+app_edr_android_port+"/edr_android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SharedPreferences url = getSharedPreferences("BASEURL", Context.MODE_PRIVATE);
        SharedPreferences.Editor txturl = url.edit();
        txturl.putString("url","http://"+app_edr_ipaddress+":"+app_edr_android_port+"/edr_android/");
        txturl.apply();
        UrlService api = retrofit.create(UrlService.class);
        Call<ModelLogin> call3 = api.getLogin(u, p);
        call3.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(@NonNull Call<ModelLogin> call, @NonNull Response<ModelLogin> response) {
                ModelLogin m=response.body();
                if(m.getTeacher_id()==null){
                    dialogErrorRespon();
                }else {
                    progress(m);
                } }
            @Override
            public void onFailure(@NonNull Call<ModelLogin> call, @NonNull Throwable t) {
                call.cancel();
            }
        });

    }

    private void dialogErrorBox(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_error_login);
        dialog.setCancelable(true);
        dialog.show();
    }
    private void dialogErrorRespon(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_error_respont);
        dialog.setCancelable(true);
        dialog.show();
    }
    private  void progress(ModelLogin m){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .content(R.string.content)
                .progress(true, 0)
                .show();
        Intent intent = new Intent(LoginActivity.this, MainTabActivity.class);
        startActivity(intent);
        SharedPreferences sp = getSharedPreferences("DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",m.getName());
        editor.putString("surname",m.getSurname());
        editor.putString("teacher_id",m.getTeacher_id());
        editor.putString("position_name",m.getPosition_name());
        editor.putString("term_id",m.getTerm_id());
        editor.apply();
    }
}
