package com.example.spacexpastlaunches.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.spacexpastlaunches.R;
import com.example.spacexpastlaunches.SpaceXPastLaunchesApplication;
import com.example.spacexpastlaunches.data.remote.beans.Launch;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by milospesic on 10/05/19.
 */
public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @BindView(R.id.listLaunches)
    RecyclerView listLaunches;

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        DaggerHomeComponent
                .builder()
                .spaceXLaunchesRepositoryComponent(((SpaceXPastLaunchesApplication) getApplication()).getSpaceXLaunchesRepositoryComponent())
                .homePresenterModule(new HomePresenterModule(this))
                .build()
                .inject(this);

        homePresenter.onCreate();
    }

    @Override
    public void showLaunches(List<Launch> launches) {
        Timber.d("showLaunches called, launches: %s", launches);
        LaunchesAdapter launchesAdapter = new LaunchesAdapter(launches);
        listLaunches.setLayoutManager(new LinearLayoutManager(this));
        listLaunches.setAdapter(launchesAdapter);
    }

    @Override
    public void onError(Throwable error) {
        Timber.e(error,"onError called");
        Toast.makeText(this, R.string.ooopps, Toast.LENGTH_LONG).show();
    }
}
