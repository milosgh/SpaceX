package com.example.spacexpastlaunches.ui.home;

import com.example.spacexpastlaunches.data.SpaceXLaunchesRepository;


import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by milospesic on 10/05/19.
 */
public class HomePresenter implements HomeContract.Presenter {

    public static final String DEFAULT_ORDER = "desc";
    public static final int LIMIT = 20;

    private final HomeContract.View homeView;
    private final SpaceXLaunchesRepository launchesRepository;

    private CompositeDisposable compositeDisposable;

    @Inject
    public HomePresenter(SpaceXLaunchesRepository launchesRepository, HomeContract.View homeView) {
        this.homeView = homeView;
        this.launchesRepository = launchesRepository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onCreate() {
        compositeDisposable.add(launchesRepository.getPastLaunches(DEFAULT_ORDER, LIMIT)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(homeView::showLaunches, error -> {
            Timber.e(error, "Couldn't fetch launches");
            homeView.onError(error);
        }));
    }
}
