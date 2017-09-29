package com.saif.familytree.core.customuicomonents;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.saif.familytree.utils.Fonts;


public class ScrollingTextView extends android.support.v7.widget.AppCompatTextView {

    public ScrollingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    public ScrollingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public ScrollingTextView(Context context) {
        super(context);
        setFont();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused)
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean focused) {
        if (focused)
            super.onWindowFocusChanged(focused);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    private void setFont() {
        Typeface font;
        // if (LocaleUtility.getApplicationLocale(activityContext).equals("ar")) {
        // font = Typeface.createFromAsset(getContext().getAssets(),
        // "fonts/AdobeArabic-Regular.otf");
        // } else {
        font = Typeface.createFromAsset(getContext().getAssets(), Fonts.CAIRO);
        // }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(font);
        }
    }

}