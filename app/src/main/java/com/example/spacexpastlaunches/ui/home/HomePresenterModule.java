package com.example.spacexpastlaunches.ui.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by milospesic on 10/05/19.
 */
@Module
public class HomePresenterModule {

    private final HomeContract.View mView;

    public HomePresenterModule(HomeContract.View view) {
        mView = view;
    }

    @Provides
    HomeContract.View provideHomeView() {
        return mView;
    }

}
