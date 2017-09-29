package com.saif.familytree.core.customuicomonents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.saif.familytree.utils.Fonts;


public class CustomButtonView extends android.support.v7.widget.AppCompatButton {

//    public CustomButtonView(Context activityContext) {
//        super(activityContext);
//    }
//
//    public CustomButtonView(Context activityContext, AttributeSet attrs) {
//        super(activityContext, attrs);
//        CustomFontHelper.setCustomFont(this, activityContext, attrs);
//    }
//
//    public CustomButtonView(Context activityContext, AttributeSet attrs, int defStyle) {
//        super(activityContext, attrs, defStyle);
//        CustomFontHelper.setCustomFont(this, activityContext, attrs);
//    }

    public CustomButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButtonView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                Fonts.NEWS_SAN);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(tf);
        }
    }
}