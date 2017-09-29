
package com.saif.familytree.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseDto implements Serializable {

    @SerializedName("api_status")
    private String mApiStatus;
    @SerializedName("api_text")
    private String mApiText;
    @SerializedName("api_version")
    private String mApiVersion;
    @SerializedName("errors")
    private ResponseError mResponseError;

    public String getApiStatus() {
        return mApiStatus;
    }

    public void setApiStatus(String apiStatus) {
        mApiStatus = apiStatus;
    }

    public String getApiText() {
        return mApiText;
    }

    public void setApiText(String apiText) {
        mApiText = apiText;
    }

    public String getApiVersion() {
        return mApiVersion;
    }

    public void setApiVersion(String apiVersion) {
        mApiVersion = apiVersion;
    }

    public ResponseError getError() {
        return mResponseError;
    }

    public void setErrors(ResponseError responseError) {
        mResponseError = responseError;
    }

    public static BaseDto fromJson(String json) {
        return new Gson().fromJson(json,BaseDto.class);
    }

    public class ResponseError implements Serializable {

        @SerializedName("error_id")
        private String mErrorId;
        @SerializedName("error_text")
        private String mErrorText;

        public String getErrorId() {
            return mErrorId;
        }

        public void setErrorId(String errorId) {
            mErrorId = errorId;
        }

        public String getErrorText() {
            return mErrorText;
        }

        public void setErrorText(String errorText) {
            mErrorText = errorText;
        }


    }
}
