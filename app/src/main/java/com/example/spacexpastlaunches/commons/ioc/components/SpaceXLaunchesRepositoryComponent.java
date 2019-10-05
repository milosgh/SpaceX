package com.example.spacexpastlaunches.commons.ioc.components;

import com.example.spacexpastlaunches.data.SpaceXLaunchesRepository;
import com.example.spacexpastlaunches.commons.ioc.modules.RetrofitRestApiModule;
import com.example.spacexpastlaunches.commons.ioc.modules.SpaceXLaunchesRepositoryModule;
import com.example.spacexpastlaunches.commons.ioc.scopes.ApplicationScope;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by milospesic on 10/05/19.
 */
@ApplicationScope
@Component(dependencies = {BaseComponent.class}, modules = {SpaceXLaunchesRepositoryModule.class, RetrofitRestApiModule.class})
public interface SpaceXLaunchesRepositoryComponent {

    Retrofit getRetrofitApi();

    SpaceXLaunchesRepository getIncodeRepository();
}
