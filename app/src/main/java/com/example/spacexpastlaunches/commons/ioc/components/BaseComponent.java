package com.example.spacexpastlaunches.commons.ioc.components;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.spacexpastlaunches.commons.ioc.modules.ApplicationModule;
import com.example.spacexpastlaunches.commons.ioc.modules.LocalModule;
import com.example.spacexpastlaunches.commons.ioc.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by milospesic on 10/05/19.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LocalModule.class, NetworkModule.class})
public interface BaseComponent {

    Application getApplication();

    SharedPreferences getSharedPreferences();

    Retrofit getRetrofit();
}
