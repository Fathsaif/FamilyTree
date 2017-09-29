package com.saif.familytree.features.main.screens;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.saif.familytree.R;
import com.saif.familytree.core.BaseActivity;
import com.saif.familytree.core.NavigationManager;
import com.saif.familytree.features.main.presenters.MainPresenter;
import com.saif.familytree.features.main.presenters.MainPresenterModel;
import com.saif.familytree.features.main.view.MainView;
import com.saif.familytree.features.main_members.screens.MainMembersFragment;
import com.saif.familytree.utils.StringUtil;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenterModel,MainView,MainPresenter> implements MainView{

    private ProgressDialog pd;
    private Toolbar toolbar;
    private MainMembersFragment membersFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        openMain();
        //NavigationManager.startMainMembersScreen(this);
    }


    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }
    @NonNull
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @NonNull
    @Override
    protected MainPresenterModel createPresentationModel() {
        return new MainPresenterModel();
    }

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public void showLoadingWithCustomText(int textRes) {
        pd = new ProgressDialog(this);
        pd.setMessage(StringUtil.getStringRes(textRes));
        pd.setCancelable(false);
        pd.show();

    }

    @Override
    public void hideLoading() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }
    public void loadFragment(Fragment fragment) {
        //toolbar.setVisibility(View.VISIBLE);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitAllowingStateLoss();
        }

    }

    @Override
    public void openMain() {
        if (membersFragment==null){
            membersFragment = new MainMembersFragment();
        }
        loadFragment(membersFragment);
    }
}
