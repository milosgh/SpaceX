package com.example.spacexpastlaunches.data.remote;

import com.example.spacexpastlaunches.data.remote.beans.Launch;
import com.example.spacexpastlaunches.commons.ioc.modules.RetrofitRestApiModule;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by milospesic on 10/05/19.
 */
public class RetrofitRemoteDataSource implements RemoteDataSource {

    private final RetrofitRestApiModule.LaunchesService launchesService;

    public RetrofitRemoteDataSource(RetrofitRestApiModule.LaunchesService launchesService) {
        this.launchesService = launchesService;
    }


    @Override
    public Observable<List<Launch>> getPastLaunches(String order, Integer limit) {
            return launchesService.getPastLaunches(order, limit);
    }

}
