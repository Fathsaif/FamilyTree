package com.saif.familytree.core;


import com.maksim88.easylogin.EasyLogin;
import com.maksim88.easylogin.networks.FacebookNetwork;
import com.maksim88.easylogin.networks.GooglePlusNetwork;
import com.maksim88.easylogin.networks.SocialNetwork;
import com.maksim88.easylogin.networks.TwitterNetwork;
import com.saif.familytree.core.constants.PrefsConstants;
import com.saif.familytree.models.Session;
import com.saif.familytree.models.UserDbModel;
import com.saif.familytree.utils.LoggerUtil;
import com.saif.familytree.utils.PrefsUtil;


/**
 * Created by Ahmed on 12/31/2016.
 */

public class SessionManager {
    /**
     * Returns a valid apiKey for session
     */
    public static String getSessionAPiKey(){
        LoggerUtil.d("apiKey", PrefsUtil.getString(PrefsConstants.SESSION_API_KEY));
        return PrefsUtil.getString(PrefsConstants.SESSION_API_KEY);
    }

    private static void setSessionAPiKey(String sessionAPiKey){
        PrefsUtil.saveString(PrefsConstants.SESSION_API_KEY,sessionAPiKey);
    }

    public static String getUserId(){
        LoggerUtil.d("userId",PrefsUtil.getString(PrefsConstants.USER_ID));
        return PrefsUtil.getString(PrefsConstants.USER_ID);
    }

    private static void setUserId(String sessionAPiKey){
        PrefsUtil.saveString(PrefsConstants.USER_ID,sessionAPiKey);
    }

    public static void setFcmToken(String refreshedToken) {
        PrefsUtil.saveString(PrefsConstants.FCM_TOKEN,refreshedToken);
    }

    public static String getFcmToken() {
        return PrefsUtil.getString(PrefsConstants.FCM_TOKEN);
    }

    public static String getUserType(){
        LoggerUtil.d("userType",PrefsUtil.getString(PrefsConstants.USER_TYPE));
        return PrefsUtil.getString(PrefsConstants.USER_TYPE);
    }

    private static void setUserType(String type){
        PrefsUtil.saveString(PrefsConstants.USER_TYPE,type);
    }

    public static boolean isLoggedIn() {
        LoggerUtil.d("loggedInStatus",""+PrefsUtil.getBoolean(PrefsConstants.IS_LOGGED_KEY));
        return PrefsUtil.getBoolean(PrefsConstants.IS_LOGGED_KEY);
    }

    public static void setNewSession(Session session) {
        setSessionAPiKey(session.getApiKey());
        setUserId(session.getUserId());
        setUserType(session.getUserType());
        setLoggedInStatus(true);
        //NavigationManager.startMainScreen();
    }

    public static void setLoggedInStatus(boolean isLoggedIn) {
        PrefsUtil.saveBoolean(PrefsConstants.IS_LOGGED_KEY,isLoggedIn);
    }

    public static void clearCurrentSession() {
        setSessionAPiKey(null);
        setUserId(null);
        setUserType(null);
        setLoggedInStatus(false);
        setFcmToken(null);
        socialLogout();
        //NavigationManager.startWelcomeScreen();
    }

    private static void socialLogout() {
        EasyLogin mEasyLogin = EasyLogin.getInstance();
        if (mEasyLogin==null){
            return;
        }
        FacebookNetwork facebook;
        try {
             facebook = (FacebookNetwork) mEasyLogin.getSocialNetwork(SocialNetwork.Network.FACEBOOK);
             facebook.logout();
        }catch (RuntimeException e){

        }


        TwitterNetwork tw;
        try {
            tw = (TwitterNetwork) mEasyLogin.getSocialNetwork(SocialNetwork.Network.TWITTER);
            tw.logout();
        }catch (RuntimeException e){

        }


        GooglePlusNetwork gPlusNetwork;
        try {
            gPlusNetwork = (GooglePlusNetwork) mEasyLogin.getSocialNetwork(SocialNetwork.Network.GOOGLE_PLUS);
            gPlusNetwork.logout();
        }catch (RuntimeException e){

        }
    }


    public static UserDbModel getUser() {
        return UserDbModel.getUser();
    }


}
