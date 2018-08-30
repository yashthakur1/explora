package com.user.test.screens;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.heady.explora.R;
import com.orhanobut.logger.Logger;
import com.user.test.base.BaseActivity;
import com.user.test.base.ExploraApp;
import com.user.test.screens.adapters.UserAdapter;
import com.user.test.screens.userModels.ResponseResult;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomePresenter homePresenter;

    @BindView(R.id.rvExplore)
    RecyclerView rvExplore;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DaggerHomeComponent.builder()
                .netComponent(((ExploraApp) getApplicationContext()).getNetComponent())
                .homeModule(new HomeModule(this))
                .build().inject(this);

        homePresenter.getCatalog();
    }


    @Override
    public void showUsers(ArrayList<ResponseResult> users) {
        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        final UserAdapter exploreAdapter = new UserAdapter(context, users);
        rvExplore.setItemAnimator(new SlideInRightAnimator());
        rvExplore.setLayoutManager(linearLayoutManagerVertical);

        rvExplore.setAdapter(exploreAdapter);
        exploreAdapter.listener = new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                exploreAdapter.removeAt(position);
            }
        };
    }

    @Override
    public void showError(String message) {
        Logger.d("API ERROR" + message);
    }

    @Override
    public void showComplete() {
        Logger.d("API complete");
    }

    @Override
    public void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }
}
