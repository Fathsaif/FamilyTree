package com.saif.familytree.core.constants;

/**
 * Created by ganna on 12/7/16.
 */

public class ErrorCodes {

    public static final int API_KEY_NOT_VALID = -1;

    /**
     * No internet Exception
     */
    public static final int NO_INTERNET_CONNECTION = -3000;

    /**
     * UnKnown Exception
     */
    public static final int UNKNOWN_ERROR = -2500;
    public static final int USER_NAME_EXIST_CODE = -100;
    public static final int EMAIL_EXIST_CODE = -200;
    public static final int EMAIL_NOT_EXIST_CODE = -300;
    public static final int INCORRECT_EMAIL_OR_PASS_CODE = -400;
    public static final int INCORRECT_USER_NAME_CHARS = -500;
    public static final int EMTPTY_FEED = -600;
    public static final int SOCAIL_USER_NOT_FOUND_CODE = -700;
    public static final int FACEBOOK_REQUEST_ERROR = -800;


    public static class ServerCodes{
        public static final String SUCCESS_RESPONSE_CODE = "200";
        public static final String FAILURE_RESPONSE_CODE = "400";
        public static final String SESSION_KEY_NOT_VALID = "6";
        public static final String USER_NAME_EXIST_CODE = "3";
        public static final String EMAIL_EXIST_CODE = "9";
        public static final String EMAIL_NOT_EXIST_CODE = "6";
        public static final String SOCIAL_USER_NOT_EXIST_CODE = "6";
        public static final String INCORRECT_EMAIL_OR_PASS_CODE = "7";
        public static final String INCORRECT_USER_NAME_CHARS = "7";
        public static final String IN_CORRECT_PROVIDER_OR_SOCIAL_ID = "7";
    }
}
