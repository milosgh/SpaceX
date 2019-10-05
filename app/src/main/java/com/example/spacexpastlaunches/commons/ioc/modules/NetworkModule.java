package com.example.spacexpastlaunches.commons.ioc.modules;

import androidx.annotation.NonNull;

import com.example.spacexpastlaunches.commons.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by milospesic on 10/05/19.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit providesRetrofitApi(OkHttpClient okHttpClient) {
        return createRetrofit(okHttpClient, Constants.BASE_URL);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor providesLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @NonNull
    private Retrofit createRetrofit(OkHttpClient okHttpClient, String apiUrl) {
        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
