package com.saif.familytree.core;


import android.support.multidex.MultiDexApplication;

/**
 * Created by ganna on 7/17/16.
 */
public class FamilyTreeApplication extends MultiDexApplication{

    private static final int DB_VERSION = 2;
    private static FamilyTreeApplication instance;

    public static FamilyTreeApplication get() {
        if (instance == null)
            // This should never happen, but just in case
            throw new IllegalStateException("Application instance has not been initialized!");
        return instance;
    }



    private void initializeFaceboolSdk(){

    }

    private void prepareAA() {

    }

}
