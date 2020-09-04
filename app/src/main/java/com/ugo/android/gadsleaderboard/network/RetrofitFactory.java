package com.ugo.android.gadsleaderboard.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
   // static SportsNews news = new SportsNews();
    private static final String APP_BASE_URL = " https://gadsapi.herokuapp.com";

    //  private static final String IMAGE_URL_BASE_PATH = news.getUrlToImage();
    //private static final String API_KEY = "9f37150adacb4632843bf3af3378c539";

    public RetrofitFactory(){}
    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getAppBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        Retrofit retrofit = builder.build();

        return retrofit;
    }


    /*public static String getApiKey(){
        return API_KEY;
    }*/

    public static String getAppBaseUrl(){
        return APP_BASE_URL;
    }


}
