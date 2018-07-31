package com.example.msi_gl62.edr.service;

import com.example.msi_gl62.edr.model.ModelAdviserGroupList;
import com.example.msi_gl62.edr.model.ModelCustomer;
import com.example.msi_gl62.edr.model.ModelLogin;
import com.example.msi_gl62.edr.model.ModelTimeTableDashboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UrlService {

    String BASE_URL = "http://demo.appedr.com:8088/edr_android/";
    String BASE_URL_CUSTOMER = "http://www.grandats.com/app_data/edrbasecenter/files/";

    @FormUrlEncoded
    @POST("jsonGetAdviserGroupList")
    Call<List<ModelAdviserGroupList>> getAdviserGroupList(@Field("teacher_id") String teacher_id, @Field("appLocale") String appLocale);

    @GET("edr_customer.json")
    Call<List<ModelCustomer>> getCutomer();

    @FormUrlEncoded
    @POST("jsonTeacherAuthen")
    Call<ModelLogin> getLogin (@Field("_u") String _u, @Field("_p") String _p);

    @FormUrlEncoded
    @POST("jsonGetTeacherTimeTableDashboardByDay")
    Call<List<ModelTimeTableDashboard>> getTimeTableDashboard (@Field("teacher_id") String teacher_id, @Field("appLocale") String appLocale,
            @Field("today_monogram") String today_monogram ,@Field("term_id") String term_id);

}
