package com.example.spacexpastlaunches.commons.ioc.modules;

import com.example.spacexpastlaunches.data.remote.beans.Launch;
import com.example.spacexpastlaunches.commons.ioc.scopes.ApplicationScope;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by milospesic on 10/05/19.
 */
@Module
public class RetrofitRestApiModule {

    @Provides
    @ApplicationScope
    public LaunchesService providesLaunchesService(Retrofit retrofit) {
        return retrofit.create(LaunchesService.class);
    }

    public interface LaunchesService {

        @GET("/v3/launches/past")
        Observable<List<Launch>> getPastLaunches(@Query("order") String order, @Query("limit") Integer limit);
    }
}
