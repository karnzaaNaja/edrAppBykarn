package com.example.msi_gl62.edr.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.adpter.AdapterListViewCustomer;
import com.example.msi_gl62.edr.model.ModelCustomer;
import com.example.msi_gl62.edr.service.UrlService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCustomerActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<ModelCustomer> item;
    private static AdapterListViewCustomer adapterListViewCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customer);
        listView=(ListView)findViewById(R.id.listViewCustomer);
        getApiCustomer();
    }

    private void getApiCustomer(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlService.BASE_URL_CUSTOMER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlService api = retrofit.create(UrlService.class);
        Call<List<ModelCustomer>> call = api.getCutomer();
        call.enqueue(new Callback<List<ModelCustomer>>() {
            @Override
            public void onResponse(Call<List<ModelCustomer>> call, Response<List<ModelCustomer>> response) {
                final ArrayList<ModelCustomer> universityList = (ArrayList<ModelCustomer>) response.body();
                adapterListViewCustomer= new AdapterListViewCustomer(universityList,getApplicationContext());
                listView.setAdapter(adapterListViewCustomer);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ModelCustomer m=universityList.get(position);
                        Intent intent = new Intent(ListCustomerActivity.this, LoginActivity.class);
                        startActivity(intent);
                        SharedPreferences sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("School_name",m.getSchool_name_thai());
                        editor.putString("app_edr_ipaddress",m.get_app_edr_ipaddress());
                        editor.putString("app_edr_android_port",m.getApp_edr_android_port());
                        editor.putString("grandats_staff_contact_phone",m.getGrandats_staff_contact_phone());
                        editor.apply();
                    }
                });
            }
            @Override
            public void onFailure(Call<List<ModelCustomer>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
