package com.example.rahulhariharan.f2.api_client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahulhariharan on 09/04/18.
 */

public class RetrofitClient {

    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {

    }

    public static RetrofitClient getInstance() {
        if(mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Retrofit getApiClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
