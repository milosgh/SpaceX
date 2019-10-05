package com.example.spacexpastlaunches.data;

import com.example.spacexpastlaunches.data.local.LocalDataSource;
import com.example.spacexpastlaunches.data.remote.RemoteDataSource;
import com.example.spacexpastlaunches.data.remote.beans.Launch;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by milospesic on 10/05/19.
 */
public class SpaceXLaunchesRepository implements LocalDataSource, RemoteDataSource {

    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;

    @Inject
    public SpaceXLaunchesRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Observable<List<Launch>> getPastLaunches(String order, Integer limit) {
        return remoteDataSource.getPastLaunches(order, limit);
    }
}
