package com.example.spacexpastlaunches.ui.home;

import com.example.spacexpastlaunches.commons.ioc.components.SpaceXLaunchesRepositoryComponent;
import com.example.spacexpastlaunches.commons.ioc.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by milospesic on 10/05/19.
 */
@ActivityScope
@Component(dependencies = SpaceXLaunchesRepositoryComponent.class, modules = HomePresenterModule.class)
public interface HomeComponent {

    void inject(HomeActivity activity);

}
