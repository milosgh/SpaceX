package com.example.spacexpastlaunches.ui.home;

import com.example.spacexpastlaunches.data.remote.beans.Launch;

import java.util.List;

/**
 * Created by milospesic on 10/05/19.
 */
public class HomeContract {

    public interface View {
        void showLaunches(List<Launch> launches);
        void onError(Throwable error);
    }

    public interface Presenter {
        void onCreate();
    }
}
