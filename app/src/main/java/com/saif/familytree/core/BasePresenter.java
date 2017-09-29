package com.saif.familytree.core;

import android.app.Activity;
import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.saif.familytree.R;
import com.saif.familytree.core.constants.ErrorCodes;
import com.saif.familytree.utils.LoggerUtil;
import com.saif.familytree.utils.NullObjectHelper;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import io.appflate.droidmvp.DroidMVPPresenter;
import rx.Subscriber;


/**
 * Created by ganna on 8/26/16.
 */
public abstract class BasePresenter<V extends BaseView, M> implements DroidMVPPresenter<V, M> {
    private M presentationModel;
    private V mvpView;
    protected Activity activityContext;

    public BasePresenter() {
    }

    public void attachView(V mvpView, M presentationModel) {
        this.mvpView = mvpView;
        this.presentationModel = presentationModel;
        activityContext = mvpView.getActivityContext();
    }

    public void detachView() {
        this.mvpView = null;
    }

    public void onDestroy() {
    }

    public M getPresentationModel() {
        return this.presentationModel;
    }

    protected V getMvpView() {
        return (this.mvpView != null) ? this.mvpView : getNullView();
    }

    private V getNullView() {
        Class viewClass = null;
        Class<?> currentClass = getClass();

        while (viewClass == null) {

            Type genericSuperType = currentClass.getGenericSuperclass();

            while (!(genericSuperType instanceof ParameterizedType)) {
                currentClass = currentClass.getSuperclass();
                genericSuperType = currentClass.getGenericSuperclass();
            }

            Type[] types = ((ParameterizedType) genericSuperType).getActualTypeArguments();

            for (int i = 0; i < types.length; i++) {
                Class<?> genericType = (Class<?>) types[i];
                if (genericType.isInterface() && isSubViewOfBaseView(genericType)) {
                    viewClass = (Class) genericType;
                    break;
                }
            }

            currentClass = currentClass.getSuperclass();
        }

        return (V) Proxy.newProxyInstance(viewClass.getClassLoader(), new Class[]{viewClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // The default value implementation here is not very necessary because views
                        // public APIs are mostly setters or mutators, but this is just in case
                        return NullObjectHelper.DefaultValues.defaultValueFor(method.getReturnType());
                    }
                });
    }

    private boolean isSubViewOfBaseView(Class<?> genericType) {
        if (BaseView.class.equals(genericType))
            return true;

        Class[] superInterfaces = genericType.getInterfaces();
        for (int i = 0; i < superInterfaces.length; i++) {
            if (isSubViewOfBaseView(superInterfaces[0])) {
                return true;
            }
        }

        return false;
    }

    public abstract class BaseSubscriber<T> extends Subscriber<T> {

        public abstract void onRequestSuccess(T value);

        public abstract void onErrorHandle(int errorCodeException);

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable error) {
            onErrorOccurred(error, this);
        }

        @Override
        public void onNext(T value) {
            onRequestSuccess(value);
        }
    }


    public abstract class BaseSubscriberWithRetry<T> extends BaseSubscriber<T> {
        public abstract void onRetryClicked(int errorCodeException);

        @Override
        public void onError(Throwable error) {
            onErrorOccurred(error, this);
        }

    }

    private void onErrorOccurred(Throwable error, BaseSubscriber baseSubscriber) {
        LoggerUtil.e(error.getLocalizedMessage() + " "+error
                .getLocalizedMessage() );
        if (error instanceof FamilyTreeException) {
            handleGeneralHiCoachErrors(baseSubscriber, ((FamilyTreeException) error));
        } else {
            if (error instanceof VolleyError) {
                VolleyError volleyError = (VolleyError) error;
                if (!TextUtils.isEmpty(volleyError.getMessage())) {
                    if (volleyError.getMessage().equals(String.valueOf(ErrorCodes.API_KEY_NOT_VALID))) {
                        forceLogout();
                    } else {
                        baseSubscriber.onErrorHandle(ErrorCodes.UNKNOWN_ERROR);
                    }
                }else {
                    baseSubscriber.onErrorHandle(ErrorCodes.UNKNOWN_ERROR);
                }
            } else {
                baseSubscriber.onErrorHandle(ErrorCodes.UNKNOWN_ERROR);
            }
        }

    }

    private void handleGeneralHiCoachErrors(final BaseSubscriber baseSubscriber, final FamilyTreeException citipalException) {
        switch (citipalException.getErrorCode()) {
            case ErrorCodes.NO_INTERNET_CONNECTION:
                if (baseSubscriber instanceof BaseSubscriberWithRetry) {
                    getMvpView().showErrorMessageWithRetry(R.drawable.empty_no_network,
                            R.string.check_internet_connection_title, new Runnable() {
                                @Override
                                public void run() {
                                    ((BaseSubscriberWithRetry) baseSubscriber).
                                            onRetryClicked(citipalException.getErrorCode());
                                }
                            });
                } else {
                    getMvpView().showErrorMessage(R.drawable.empty_no_network,
                            R.string.check_internet_connection_title);
                }
                break;
            default:
                //is a private exception.
                baseSubscriber.onErrorHandle(citipalException.getErrorCode());
        }
    }

    /**
     * API Key not valid anymore so will force user to logout.
     */
    private void forceLogout() {
        //SessionManager.clearCurrentSession(activityContext);
    }
}
