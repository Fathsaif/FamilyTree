
package com.saif.familytree.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDto extends BaseDto implements Serializable {

    @SerializedName("about")
    private String mAbout;
    @SerializedName("active")
    private String mActive;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("admin")
    private String mAdmin;
    @SerializedName("avatar")
    private String mAvatar;
    @SerializedName("balance")
    private String mBalance;
    @SerializedName("bio")
    private String mBio;
    @SerializedName("birth_privacy")
    private String mBirthPrivacy;
    @SerializedName("birthday")
    private String mBirthday;
    @SerializedName("confirm_followers")
    private String mConfirmFollowers;
    @SerializedName("cover")
    private String mCover;
    @SerializedName("device_id")
    private String mDeviceId;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("facebook")
    private String mFacebook;
    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("follow_privacy")
    private String mFollowPrivacy;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("google")
    private String mGoogle;
    @SerializedName("instagram")
    private String mInstagram;
    @SerializedName("ip_address")
    private String mIpAddress;
    @SerializedName("is_pro")
    private String mIsPro;
    @SerializedName("joined")
    private String mJoined;
    @SerializedName("language")
    private String mLanguage;
    @SerializedName("last_name")
    private String mLastName;
    @SerializedName("lastseen")
    private String mLastseen;
    @SerializedName("linkedin")
    private String mLinkedin;
    @SerializedName("message_privacy")
    private String mMessagePrivacy;
    @SerializedName("name")
    private String mName;
    @SerializedName("notifications_sound")
    private String mNotificationsSound;
    @SerializedName("order_posts_by")
    private String mOrderPostsBy;
    @SerializedName("paypal_email")
    private String mPaypalEmail;
    @SerializedName("phone_number")
    private String mPhoneNumber;
    @SerializedName("post_privacy")
    private String mPostPrivacy;
    @SerializedName("pro_type")
    private String mProType;
    @SerializedName("referrer")
    private String mReferrer;
    @SerializedName("registered")
    private String mRegistered;
    @SerializedName("relationship_id")
    private String mRelationshipId;
    @SerializedName("school")
    private String mSchool;
    @SerializedName("show_activities_privacy")
    private String mShowActivitiesPrivacy;
    @SerializedName("showlastseen")
    private String mShowlastseen;
    @SerializedName("social_login")
    private String mSocialLogin;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("timezone")
    private String mTimezone;
    @SerializedName("trainee")
    private String mTrainee;
    @SerializedName("trainer")
    private String mTrainer;
    @SerializedName("twitter")
    private String mTwitter;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user_id")
    private String mUserId;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("verified")
    private String mVerified;
    @SerializedName("visit_privacy")
    private String mVisitPrivacy;
    @SerializedName("vk")
    private String mVk;
    @SerializedName("website")
    private String mWebsite;
    @SerializedName("working")
    private String mWorking;
    @SerializedName("working_link")
    private String mWorkingLink;
    @SerializedName("youtube")
    private String mYoutube;
    @SerializedName("followers_count")
    private String mFollowersCount;
    @SerializedName("following_count")
    private String mFollowingCount;
    @SerializedName("post_count")
    private String mPostsCount;
    @SerializedName("premium")
    private boolean mPremium;
    @SerializedName("is_following")
    private int mIsFollowing;
    @SerializedName("profile_picture")
    private String mProfilePicture;


    public UserDto(String mEmail, String mSocialLogin, String mUserId, String mUsername) {
        this.mEmail = mEmail;
        this.mSocialLogin = mSocialLogin;
        this.mUserId = mUserId;
        this.mUsername = mUsername;
    }

    public String getmProfilePicture() {
        return mProfilePicture;
    }

    public void setmProfilePicture(String mProfilePicture) {
        this.mProfilePicture = mProfilePicture;
    }

    public boolean isFollowingPremium() {
        return mPremium;
    }


    public void setmPremium(boolean mPremium) {
        this.mPremium = mPremium;
    }

    public boolean isFollowing() {
        return mIsFollowing!=0;
    }

    public void setIsFollowing(int mIsFollowing) {
        this.mIsFollowing = mIsFollowing;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getAdmin() {
        return mAdmin;
    }

    public void setAdmin(String admin) {
        mAdmin = admin;
    }

    public String getAvatar() {
        return mAvatar!=null?mAvatar:mProfilePicture;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getBalance() {
        return mBalance;
    }

    public void setBalance(String balance) {
        mBalance = balance;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public String getBirthPrivacy() {
        return mBirthPrivacy;
    }

    public void setBirthPrivacy(String birthPrivacy) {
        mBirthPrivacy = birthPrivacy;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public String getConfirmFollowers() {
        return mConfirmFollowers;
    }

    public void setConfirmFollowers(String confirmFollowers) {
        mConfirmFollowers = confirmFollowers;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }

    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String deviceId) {
        mDeviceId = deviceId;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFacebook() {
        return mFacebook;
    }

    public void setFacebook(String facebook) {
        mFacebook = facebook;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFollowPrivacy() {
        return mFollowPrivacy;
    }

    public void setFollowPrivacy(String followPrivacy) {
        mFollowPrivacy = followPrivacy;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getGoogle() {
        return mGoogle;
    }

    public void setGoogle(String google) {
        mGoogle = google;
    }

    public String getInstagram() {
        return mInstagram;
    }

    public void setInstagram(String instagram) {
        mInstagram = instagram;
    }

    public String getIpAddress() {
        return mIpAddress;
    }

    public void setIpAddress(String ipAddress) {
        mIpAddress = ipAddress;
    }

    public String getIsPro() {
        return mIsPro;
    }

    public void setIsPro(String isPro) {
        mIsPro = isPro;
    }

    public String getJoined() {
        return mJoined;
    }

    public void setJoined(String joined) {
        mJoined = joined;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getLastseen() {
        return mLastseen;
    }

    public void setLastseen(String lastseen) {
        mLastseen = lastseen;
    }

    public String getLinkedin() {
        return mLinkedin;
    }

    public void setLinkedin(String linkedin) {
        mLinkedin = linkedin;
    }

    public String getMessagePrivacy() {
        return mMessagePrivacy;
    }

    public void setMessagePrivacy(String messagePrivacy) {
        mMessagePrivacy = messagePrivacy;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getNotificationsSound() {
        return mNotificationsSound;
    }

    public void setNotificationsSound(String notificationsSound) {
        mNotificationsSound = notificationsSound;
    }

    public String getOrderPostsBy() {
        return mOrderPostsBy;
    }

    public void setOrderPostsBy(String orderPostsBy) {
        mOrderPostsBy = orderPostsBy;
    }

    public String getPaypalEmail() {
        return mPaypalEmail;
    }

    public void setPaypalEmail(String paypalEmail) {
        mPaypalEmail = paypalEmail;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getPostPrivacy() {
        return mPostPrivacy;
    }

    public void setPostPrivacy(String postPrivacy) {
        mPostPrivacy = postPrivacy;
    }

    public String getProType() {
        return mProType;
    }

    public void setProType(String proType) {
        mProType = proType;
    }

    public String getReferrer() {
        return mReferrer;
    }

    public void setReferrer(String referrer) {
        mReferrer = referrer;
    }

    public String getRegistered() {
        return mRegistered;
    }

    public void setRegistered(String registered) {
        mRegistered = registered;
    }

    public String getRelationshipId() {
        return mRelationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        mRelationshipId = relationshipId;
    }

    public String getSchool() {
        return mSchool;
    }

    public void setSchool(String school) {
        mSchool = school;
    }

    public String getShowActivitiesPrivacy() {
        return mShowActivitiesPrivacy;
    }

    public void setShowActivitiesPrivacy(String showActivitiesPrivacy) {
        mShowActivitiesPrivacy = showActivitiesPrivacy;
    }

    public String getShowlastseen() {
        return mShowlastseen;
    }

    public void setShowlastseen(String showlastseen) {
        mShowlastseen = showlastseen;
    }

    public String getSocialLogin() {
        return mSocialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        mSocialLogin = socialLogin;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getTrainee() {
        return mTrainee;
    }

    public void setTrainee(String trainee) {
        mTrainee = trainee;
    }

    public String getTrainer() {
        return mTrainer;
    }

    public void setTrainer(String trainer) {
        mTrainer = trainer;
    }

    public String getTwitter() {
        return mTwitter;
    }

    public void setTwitter(String twitter) {
        mTwitter = twitter;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getVerified() {
        return mVerified;
    }

    public void setVerified(String verified) {
        mVerified = verified;
    }

    public String getVisitPrivacy() {
        return mVisitPrivacy;
    }

    public void setVisitPrivacy(String visitPrivacy) {
        mVisitPrivacy = visitPrivacy;
    }

    public String getVk() {
        return mVk;
    }

    public void setVk(String vk) {
        mVk = vk;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

    public String getWorking() {
        return mWorking;
    }

    public void setWorking(String working) {
        mWorking = working;
    }

    public String getWorkingLink() {
        return mWorkingLink;
    }

    public void setWorkingLink(String workingLink) {
        mWorkingLink = workingLink;
    }

    public String getYoutube() {
        return mYoutube;
    }

    public void setYoutube(String youtube) {
        mYoutube = youtube;
    }

    public String getmFollowersCount() {
        return mFollowersCount;
    }

    public void setmFollowersCount(String mFollowersCount) {
        this.mFollowersCount = mFollowersCount;
    }

    public String getmFollowingCount() {
        return mFollowingCount;
    }

    public void setmFollowingCount(String mFollowingCount) {
        this.mFollowingCount = mFollowingCount;
    }


    public String getmPostsCount() {
        return mPostsCount;
    }

    public void setmPostsCount(String mPostsCount) {
        this.mPostsCount = mPostsCount;
    }
    public static UserDto fromJson(String json) {
        return new Gson().fromJson(json,UserDto.class);
    }

    public String getType() {
        return null;
    }
}
