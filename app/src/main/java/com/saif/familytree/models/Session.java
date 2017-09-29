package com.saif.familytree.models;

import java.io.Serializable;

/**
 * Created by ahmed on 23/06/17.
 */

public class Session implements Serializable {

    private String apiKey,userId,userType;


    public Session(String apiKey, String userId, String userType) {
        this.apiKey = apiKey;
        this.userId = userId;
        this.userType = userType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
