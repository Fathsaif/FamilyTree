package com.saif.familytree.core;

import android.app.Activity;
import android.content.Intent;

import com.saif.familytree.features.main_members.screens.MainMembersActivity;


/**
 * Created by ganna on 12/9/16.
 */

public class NavigationManager {

    public static void startMainMembersScreen(Activity activity) {
        Intent intent = new Intent(activity, MainMembersActivity.class);
        activity.startActivity(intent);
    }

}
