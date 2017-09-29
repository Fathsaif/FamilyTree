package com.saif.familytree.core.customuicomonents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.saif.familytree.utils.Fonts;


/**
 * Created by Ahmed on 1/26/2017.
 */

public class CustomAutoCompleteView extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    private static Typeface mTypeface;

    public CustomAutoCompleteView(final Context context) {
        this(context, null);
    }

    public CustomAutoCompleteView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomAutoCompleteView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(context.getAssets(), Fonts.CAIRO);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            setTypeface(mTypeface);
        }
    }
}
