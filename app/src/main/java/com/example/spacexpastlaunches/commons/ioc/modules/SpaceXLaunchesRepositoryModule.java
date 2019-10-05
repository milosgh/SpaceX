package com.example.spacexpastlaunches.commons.ioc.modules;

import android.app.Application;

import com.example.spacexpastlaunches.data.local.LocalDataSource;
import com.example.spacexpastlaunches.data.local.SpaceXLaunchesLocalDataSource;
import com.example.spacexpastlaunches.data.remote.RemoteDataSource;
import com.example.spacexpastlaunches.data.remote.RetrofitRemoteDataSource;
import com.example.spacexpastlaunches.commons.ioc.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by milospesic on 10/05/19.
 */

@Module
public class SpaceXLaunchesRepositoryModule {

    @Provides
    @ApplicationScope
    public RemoteDataSource provideRemoteDataSource(RetrofitRestApiModule.LaunchesService launchesService) {
        return new RetrofitRemoteDataSource(launchesService);
    }

    @Provides
    @ApplicationScope
    public LocalDataSource provideLocalDataSource(Application application) {
        return new SpaceXLaunchesLocalDataSource(application);
    }
}
