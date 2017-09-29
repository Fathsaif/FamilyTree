package com.saif.familytree.core;

import android.app.Activity;

import io.appflate.droidmvp.DroidMVPView;

/**
 * Created by ganna on 8/21/16.
 */
public interface BaseView extends DroidMVPView {
    void showLoading();
    void showLoadingWithCustomStyle(int loadingViewBackgroundRes, int loadingIndicatorColor,
                                    int loadingTextColor);
    void showContent();
    void showNoConnection();
    void showErrorMessage(int errorImg, int errorTitle);
    void showErrorMessageWithRetry(int errorImg, int errorTitle, Runnable action);
    void showErrorMessageWithRetry(int errorImg, int errorTitle, Runnable action, int actionTitle);
    Activity getActivityContext();


    void showLoadingWithCustomText(int textRes);

}
