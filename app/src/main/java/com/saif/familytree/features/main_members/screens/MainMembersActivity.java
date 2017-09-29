package com.saif.familytree.features.main_members.screens;

import com.saif.familytree.core.BaseFragment;
import com.saif.familytree.core.CoreActivity;

/**
 * Created by Saif on 14/09/2017.
 */

public class MainMembersActivity extends CoreActivity {
    @Override
    public BaseFragment getFragment() {
        return new MainMembersFragment();
    }

    @Override
    public int getToolbarTitle() {
        return 0;
    }
}
