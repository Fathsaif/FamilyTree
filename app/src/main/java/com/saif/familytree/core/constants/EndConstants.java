package com.saif.familytree.core.constants;

/**
 * Created by ganna on 12/17/2016.
 */

public class EndConstants {

    public static final String PRODUCTION_DOMAIN = "http://dinenn.com/hicoach/app_api.php";
    public static final String TESTING_DOMAIN = "";

    /**
     * Apis
     */
    public static final String API_BASE_URL = PRODUCTION_DOMAIN + "?"+"application=phone&type=";

    public static final String LOGIN_URL = API_BASE_URL+"user_login";

    public static final String SIGN_UP_URL = API_BASE_URL+"user_registration";

    public static final String UPDATE_PROFILE_IMAGE_URL = API_BASE_URL+"set_profile_picture";

    public static final String UPDATE_USER_DATA_URL = API_BASE_URL + "update_user_data";
    public static final String TRAINERS_LIST_URL = API_BASE_URL + "get_suggestions";


    public static final String NEW_POST_URL = API_BASE_URL+"new_post";

    public static final String FOLLOW_TRAINER_URL = API_BASE_URL+"follow_user";


    public static final String ALL_FEED_URL =API_BASE_URL+ "get_user_all_posts";

    public static final String SPECIFIC_FEED_URL = API_BASE_URL + "get_user_posts";
    public static final String LIKE_POST_URL = API_BASE_URL + "like_post";

    public static final String POST_DETAILS_URL = API_BASE_URL + "get_post_data";
    public static final String COMMENT_POST_URL = API_BASE_URL + "new_comment";
    public static final String DELETE_POST_URL = API_BASE_URL + "post_manager";
    public static final String USER_PROFILE_URL = API_BASE_URL + "get_user_data";
    public static final String FOLLOWED_TRAINERS_URL  =API_BASE_URL+ "get_users_friends";

    public static final String SOCIAL_LOGIN_URL = API_BASE_URL + "user_social_login";
    public static final String SOCIAL_SIGN_UP_URL = API_BASE_URL + "social_registration";
    public static final String SEARCH_URL = API_BASE_URL + "search_public_users";
    public static final String COMMENT_REPLIES_URL = API_BASE_URL +"get_comment_replies";
    public static final String LIKE_COMMENT_URL = API_BASE_URL + "like_comment";
    public static final String NEW_REPLY_URL = API_BASE_URL + "new_comment_reply";
}


