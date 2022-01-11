package com.example.jobprofile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

//    @FormUrlEncoded
    @POST("api/v1/user/register")
    @Headers("Content-Type: application/json")
    Call<LoginResponce> create(@Body RegisterInfo registerInfo);

    @FormUrlEncoded
    @POST("api/v1/user/login")
    @Headers("Content-Type: application/json")
    Call<LoginResponce> login(@Field("email") String email,
                              @Field("password") String password);

    @GET("api/v1")
    Call<JobResponses> getpublicjob();

    @GET("/")
//    @Headers("Content-Type: application/json")
//    @Headers("Accept: application/json")
    Call<String> welcome();
}

