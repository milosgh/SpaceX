package com.example.spacexpastlaunches.commons.ioc.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by milospesic on 10/05/19.
 */
@Module
public class LocalModule {

    public static String preferenceFileName = "com.example.spacexpastlaunches.PREFERENCE_FILE";

    @Singleton
    @Provides
    SharedPreferences providesUserSharedPreferences(Application application) {
        return application.getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE);
    }
}
