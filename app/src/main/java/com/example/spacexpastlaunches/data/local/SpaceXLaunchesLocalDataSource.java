package com.example.spacexpastlaunches.data.local;

import android.app.Application;

/**
 * Created by milospesic on 10/05/19.
 */
public class SpaceXLaunchesLocalDataSource implements LocalDataSource {

    private final Application application;

    public SpaceXLaunchesLocalDataSource(Application application) {
        this.application = application;
    }
}
