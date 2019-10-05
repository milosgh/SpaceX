package com.example.spacexpastlaunches.data.remote;

import com.example.spacexpastlaunches.data.remote.beans.Launch;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by milospesic on 10/05/19.
 */
public interface RemoteDataSource {

    Observable<List<Launch>> getPastLaunches(String order, Integer limit);
}
