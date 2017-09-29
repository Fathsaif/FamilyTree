package com.saif.familytree.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.saif.familytree.R;
import com.saif.familytree.utils.Messenger;
import com.saif.familytree.utils.StringUtil;

import java.io.Serializable;

import butterknife.ButterKnife;
import io.appflate.droidmvp.DroidMVPFragment;
import io.appflate.droidmvp.DroidMVPPresenter;
import io.appflate.droidmvp.DroidMVPView;

/**
 * Created by ganna on 22/06/16.
 */
public abstract class BaseFragment<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
        extends DroidMVPFragment<M, V, P> implements BaseView ,Analyzable {

    private View contentView;
    private ViewStub viewStub;
    protected RelativeLayout loadingLayout;
    protected TextView loadingText;
    private LinearLayout errorLayout;
    private ImageView errorImageView;
    private TextView errorTv;
    private Button errorRetryBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_common_base_layout, container, false);
        viewStub = (ViewStub) baseView.findViewById(R.id.fragment_common_base_content);
        viewStub.setLayoutResource(getContentLayoutResId());

        loadingLayout = (RelativeLayout) baseView.findViewById(R.id.layout_loading);
        loadingText = (TextView) baseView.findViewById(R.id.txt_loading);

        errorLayout = (LinearLayout) baseView.findViewById(R.id.layout_error);
        errorImageView = (ImageView) baseView.findViewById(R.id.error_image_view);
        errorTv = (TextView) baseView.findViewById(R.id.error_message_tv);
        errorRetryBtn = (Button) baseView.findViewById(R.id.error_retry_btn);

        contentView = viewStub.inflate();

        ButterKnife.bind(this, baseView);

        return baseView;
    }

    protected abstract
    @LayoutRes
    int getContentLayoutResId();

    @Override
    public void showContent() {
        viewStub.setVisibility(View.VISIBLE);
        loadingLayout.setVisibility(View.GONE);
        errorLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        viewStub.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.VISIBLE);
        errorLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLoadingWithCustomText(int textRes) {
        viewStub.setVisibility(View.GONE);
        loadingText.setText(StringUtil.getStringRes(textRes));
        loadingLayout.setVisibility(View.VISIBLE);
        errorLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLoadingWithCustomStyle(int loadingViewBackgroundRes, int loadingIndicatorColor,
                                           int loadingTextColor) {
        showLoading();
        setLoadingStyle(loadingViewBackgroundRes, loadingIndicatorColor, loadingTextColor);
    }

    private void setLoadingStyle(int loadingViewBackgroundRes, int loadingIndicatorColor, int loadingTextColor) {
        loadingLayout.setBackgroundResource(loadingViewBackgroundRes);
        loadingText.setTextColor(getResources().getColor(loadingTextColor));
    }

    @Override
    public void showNoConnection() {
        showContent();
        /*Toast.makeText(getActivity(), StringUtil.getStringRes(R.string.check_internet_connection_title),
                Toast.LENGTH_SHORT).show();*/
        Messenger.showNetworkErrorMsg(getActivityContext());
    }

    @Override
    public void showErrorMessage(int errorImg, int errorTitle) {
        viewStub.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.GONE);
        errorLayout.setVisibility(View.VISIBLE);
        errorImageView.setImageResource(errorImg);
        errorTv.setText(StringUtil.getStringRes(errorTitle));
    }

    @Override
    public void showErrorMessageWithRetry(int errorImg, int errorTitle, final Runnable action) {
        showErrorMessage(errorImg, errorTitle);
        errorRetryBtn.setVisibility(View.VISIBLE);
        errorRetryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (action != null)
                    action.run();
            }
        });
    }

    @Override
    public void showErrorMessageWithRetry(int errorImg, int errorTitle, Runnable action, int actionTitle) {
        showErrorMessageWithRetry(errorImg, errorTitle, action);
        errorRetryBtn.setText(actionTitle);
    }

    @Override
    public Activity getActivityContext() {
        return getActivity();
    }

    @Override
    protected void performFieldInjection() {

    }

}