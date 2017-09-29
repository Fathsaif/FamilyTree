
package com.saif.familytree.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.io.Serializable;

@Table(name = "Users")
public class UserDbModel extends Model implements Serializable {

    @Column(name = "user_id", unique = true,onUniqueConflict = Column.ConflictAction.REPLACE)
    public String mId;
    @Column(name = "email")
    public String mEmail;
    @Column(name = "profile_image")
    public String mProfileImage;
    @Column(name = "phone")
    public String mPhone;
    @Column(name = "user_type")
    public String mType;
    @Column(name = "name")
    public String mName;

    public UserDbModel(String mId, String mEmail, String mProfileImage, String mPhone, String mType, String mName) {
        this.mId = mId;
        this.mEmail = mEmail;
        this.mProfileImage = mProfileImage;
        this.mPhone = mPhone;
        this.mType = mType;
        this.mName = mName;
    }

    public UserDbModel() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmProfileImage() {
        return mProfileImage;
    }

    public void setmProfileImage(String mProfileImage) {
        this.mProfileImage = mProfileImage;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public static void removeUser(){
        new Delete().from(UserDbModel.class)
                .execute();

    }

    public static UserDbModel getUser() {
       return new Select()
                .from(UserDbModel.class)
                .executeSingle();
    }

    public static boolean isUserExist() {
        return new Select().from(UserDbModel.class)
                .executeSingle()!=null;
    }

    public static void saveNewUser(UserDto user) {
        removeUser();
        new UserDbModel(user.getUserId(),user.getEmail(),user.getAvatar(),user.getPhoneNumber(),
                user.getType(),user.getName()).save();
    }
}
