package com.example.jobprofile;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrifitClient {
    private static final String BASE_URL = "https://afternoon-shore-36490.herokuapp.com/";
    //192.168.150.1
    private static RetrifitClient minstance;
    private Retrofit retrofit;

    private RetrifitClient() {

        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrifitClient getInstance() {
        if (minstance == null) {
            minstance = new RetrifitClient();
        }
        return minstance;
    }

    public ApiInterface getApiInterface() {
        return retrofit.create(ApiInterface.class);
    }
}


