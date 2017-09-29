/*
 * Copyright (C) 2016 Appflate.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.saif.familytree.core;

import io.appflate.droidmvp.DroidMVPActivity;
import io.appflate.droidmvp.DroidMVPPresenter;
import io.appflate.droidmvp.DroidMVPView;

/**
 * Created by ganna on 22/06/16.
 */
public abstract class BaseActivity<M, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
        extends DroidMVPActivity<M, V, P> implements BaseView {

    @Override
    protected void performFieldInjection() {
        //since we don't use any dependency injection framework here, lets make this method no-op.
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadingWithCustomStyle(int loadingViewBackgroundRes, int loadingIndicatorColor, int loadingTextColor) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showNoConnection() {

    }

    @Override
    public void showErrorMessage(int errorImg, int errorTitle) {

    }

    @Override
    public void showErrorMessageWithRetry(int errorImg, int errorTitle, Runnable action) {

    }

    @Override
    public void showErrorMessageWithRetry(int errorImg, int errorTitle, Runnable action, int actionTitle) {

    }


}
