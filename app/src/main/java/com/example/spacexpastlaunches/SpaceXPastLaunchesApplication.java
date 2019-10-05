package com.example.spacexpastlaunches;

import android.app.Application;

import com.example.spacexpastlaunches.commons.ioc.components.BaseComponent;
import com.example.spacexpastlaunches.commons.ioc.components.DaggerBaseComponent;
import com.example.spacexpastlaunches.commons.ioc.components.DaggerSpaceXLaunchesRepositoryComponent;
import com.example.spacexpastlaunches.commons.ioc.components.SpaceXLaunchesRepositoryComponent;
import com.example.spacexpastlaunches.commons.ioc.modules.ApplicationModule;
import com.example.spacexpastlaunches.commons.ioc.modules.NetworkModule;

import timber.log.Timber;

/**
 * Created by milospesic on 10/05/19.
 */
public class SpaceXPastLaunchesApplication extends Application {

    private SpaceXLaunchesRepositoryComponent spaceXLaunchesRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        BaseComponent baseComponent = DaggerBaseComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule()).build();

        spaceXLaunchesRepositoryComponent = DaggerSpaceXLaunchesRepositoryComponent.builder()
                .baseComponent(baseComponent)
                .build();

    }

    public SpaceXLaunchesRepositoryComponent getSpaceXLaunchesRepositoryComponent() {
        return spaceXLaunchesRepositoryComponent;
    }
}
