package com.ugo.android.gadsleaderboard.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static final String APP_BASE_URL = " https://gadsapi.herokuapp.com";

    public RetrofitFactory(){}
    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getAppBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client);
        Retrofit retrofit = builder.build();

        return retrofit;
    }

    public static String getAppBaseUrl(){
        return APP_BASE_URL;
    }


}
