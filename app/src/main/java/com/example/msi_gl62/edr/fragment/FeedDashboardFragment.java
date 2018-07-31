package com.example.msi_gl62.edr.fragment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.adpter.AdapterListViewGroup;
import com.example.msi_gl62.edr.adpter.AdapterTableDashboard;
import com.example.msi_gl62.edr.model.ModelAdviserGroupList;
import com.example.msi_gl62.edr.model.ModelTimeTableDashboard;
import com.example.msi_gl62.edr.service.UrlService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedDashboardFragment extends Fragment {
    private static AdapterListViewGroup adapterListViewGroup;
    private static AdapterTableDashboard adapterTableDashboard;
    ListView listview, listenable;
    private TextView txt_name;

    public static FeedDashboardFragment newInstance(String param1, String param2) {
        FeedDashboardFragment fragment = new FeedDashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_dashboard, container, false);
        setById(view);
        getShare();
        return view;
    }

    private void setById(View view){
        txt_name=(TextView)view.findViewById(R.id.txt_name_tac);
        listview = (ListView) view.findViewById(R.id.list);
        listenable =(ListView) view.findViewById(R.id.listTimeTableDashboard);
    }

    @SuppressLint("SetTextI18n")
    private void getShare(){
        SharedPreferences sp = this.getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        String surname = sp.getString("surname", "");
        String teacher_id=sp.getString("teacher_id","");
        String term_id=sp.getString("term_id","");
        txt_name.setText(name+" "+surname);
        SharedPreferences customer = this.getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String  app_edr_android_port= customer.getString("app_edr_android_port", "");
        SharedPreferences url = this.getActivity().getSharedPreferences("BASEURL", Context.MODE_PRIVATE);
        String get_url= url.getString("url", "");
        getApiAdviserGroupList(teacher_id,app_edr_android_port);
        getApiTimeTableDashboardByDay(teacher_id, app_edr_android_port,term_id,get_url);
    }

    private void getApiAdviserGroupList(String teacher_id, String app_edr_android_port) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlService api = retrofit.create(UrlService.class);
        Call<List<ModelAdviserGroupList>> call3 = api.getAdviserGroupList(teacher_id,app_edr_android_port);
        call3.enqueue(new Callback<List<ModelAdviserGroupList>>() {
            @Override
            public void onResponse(Call<List<ModelAdviserGroupList>> call, Response<List<ModelAdviserGroupList>> response) {
                ArrayList<ModelAdviserGroupList> universityList = (ArrayList<ModelAdviserGroupList>) response.body();
                adapterListViewGroup = new AdapterListViewGroup(universityList, getActivity().getApplicationContext());
                listview.setAdapter(adapterListViewGroup);
            }
            @Override
            public void onFailure(Call<List<ModelAdviserGroupList>> call, Throwable t) {
                call.cancel();
            }
        });
    }

    private void getApiTimeTableDashboardByDay(String teacher_id, String app_edr_android_port,String term_id,String get_url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(get_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlService api = retrofit.create(UrlService.class);
        Call<List<ModelTimeTableDashboard>> call3 = api.getTimeTableDashboard(teacher_id,app_edr_android_port,"TUE",term_id);
        call3.enqueue(new Callback<List<ModelTimeTableDashboard>>() {
            @Override
            public void onResponse(Call<List<ModelTimeTableDashboard>> call, Response<List<ModelTimeTableDashboard>> response) {
                ArrayList<ModelTimeTableDashboard> group = (ArrayList<ModelTimeTableDashboard>) response.body();
                adapterTableDashboard = new AdapterTableDashboard(group, getActivity().getApplicationContext());
                listenable.setAdapter(adapterTableDashboard);
            }
            @Override
            public void onFailure(Call<List<ModelTimeTableDashboard>> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
