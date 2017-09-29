package com.saif.familytree.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.saif.familytree.R;


/**
 * Created by ganna on 7/15/16.
 */
public abstract class CoreActivity extends AppCompatActivity {

     Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_base_layout);
        bindFragment(getFragment());
        setToolBar(getToolbarTitle());

    }

    private void bindFragment(BaseFragment baseFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_common_base_fragment_container, baseFragment).commit();
    }

    public abstract BaseFragment getFragment();


    /**
     * set toolbar title for the activity ,
     * @return  Either 0 if activity does not have a toolbar
     * or resId for the string for ex. (R.id.some_title)
     */
    public abstract int getToolbarTitle();



    protected void setToolBar(int title) {

        if (title != 0) {
            toolbar = (Toolbar) findViewById(R.id.tool_bar);
            toolbar.setVisibility(View.VISIBLE);
            setSupportActionBar(toolbar);
            ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
//            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back);
//            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setToolbarTitle(String toolbarTitle) {
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(toolbarTitle);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

}
