package com.saif.familytree.features.main_members.screens;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.saif.familytree.R;
import com.saif.familytree.core.BaseFragment;
import com.saif.familytree.features.main.presenters.MainPresenterModel;
import com.saif.familytree.features.main_members.presenters.MainMembersPresenter;
import com.saif.familytree.features.main_members.view.MainMembersView;

import butterknife.BindView;

/**
 * Created by Saif on 14/09/2017.
 */

public class MainMembersFragment extends BaseFragment<MainPresenterModel,MainMembersView,MainMembersPresenter> implements MainMembersView {

@BindView(R.id.unc_abdallah) ImageView uncAbdallahBtn;
    @BindView(R.id.aunt_bata) ImageView auntBataBtn;
    @BindView(R.id.unc_hamed) ImageView uncHamedBtn;
    @BindView(R.id.dad) ImageView dadBtn;
    @BindView(R.id.unc_musatafa) ImageView uncMustafaBtn;



    @Override
    public String getScreenNameForAnalytics() {
        return null;
    }

    @Override
    public ImageView getUncAbdallah() {
        return uncAbdallahBtn;
    }

    @Override
    public ImageView getAuntBata() {
        return auntBataBtn;
    }

    @Override
    public ImageView getUncHamed() {
        return uncHamedBtn;
    }

    @Override
    public ImageView getDad() {
        return dadBtn;
    }

    @Override
    public ImageView getUncMustafa() {
        return uncMustafaBtn;
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.fragment_main;
    }

    @NonNull
    @Override
    protected MainMembersPresenter createPresenter() {
        return new MainMembersPresenter();
    }

    @NonNull
    @Override
    protected MainPresenterModel createPresentationModel() {
        return new MainPresenterModel();
    }
}
