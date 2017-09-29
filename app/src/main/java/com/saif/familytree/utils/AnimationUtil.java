package com.saif.familytree.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Ahmed on 1/25/2017.
 */

/**
 * Little helper class for animating content, error and loading view
 */
public class AnimationUtil {

    public static final long INPUT_LAYOUT_DURATION = 700;
    public static final long NORMAL_FLASH_DURATION = 1000;
    public static final long DEFAULT_DELAY = 500;

    public static void animateWithYoYo(Techniques animation, long duration, View target,long delay){
        YoYo.with(animation)
                .duration(duration)
                .delay(delay)
                .playOn(target);
    }

    /**
     * Show the loading view. No animations, because sometimes loading things is pretty fast (i.e.
     * retrieve data from memory cache).
     */
    public static void showLoading(View loadingView, View contentView) {

        contentView.setVisibility(View.GONE);

        loadingView.setVisibility(View.VISIBLE);
    }

    /**
     * Shows the error view instead of the loading view
     */
    public static void showErrorView(final View loadingView, final View contentView) {

        if (Build.VERSION.SDK_INT < 11) {
            // Before honeycomb
            contentView.setVisibility(View.GONE);
            loadingView.setVisibility(View.GONE);

        } else {

            contentView.setVisibility(View.GONE);

            // Not visible yet, so animate the view in
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator loadingOut = ObjectAnimator.ofFloat(loadingView, "alpha", 0f);

            set.play(loadingOut);
            set.setDuration(200);

            set.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }

                @TargetApi(Build.VERSION_CODES.HONEYCOMB)
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    loadingView.setVisibility(View.GONE);
                    loadingView.setAlpha(1f); // For future showLoading calls
                }
            });

            set.start();
        }
    }

    /**
     * Display the content instead of the loadingView
     */
    @TargetApi(11)
    public static void showContent(final View loadingView, final View contentView) {

        if (contentView.getVisibility() == View.VISIBLE) {
            // No Changing needed, because contentView is already visible
            loadingView.setVisibility(View.GONE);
        } else {

            if (Build.VERSION.SDK_INT < 14) {
                // Before honeycomb

                loadingView.setVisibility(View.GONE);
                contentView.setVisibility(View.VISIBLE);
            } else {

                // ICS and above

                int translateDp = 40;
                // Not visible yet, so animate the view in
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator contentFadeIn = ObjectAnimator.ofFloat(contentView, "alpha", 0f, 1f);
                ObjectAnimator contentTranslateIn = ObjectAnimator.ofFloat(contentView, "translationY",
                        dpToPx(loadingView.getContext(), translateDp), 0);

                ObjectAnimator loadingFadeOut = ObjectAnimator.ofFloat(loadingView, "alpha", 1f, 0f);
                ObjectAnimator loadingTranslateOut = ObjectAnimator.ofFloat(loadingView, "translationY", 0,
                        -dpToPx(loadingView.getContext(), translateDp));

                set.playTogether(contentFadeIn, contentTranslateIn, loadingFadeOut, loadingTranslateOut);
                set.setDuration(600);

                set.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                        contentView.setTranslationY(0);
                        loadingView.setTranslationY(0);
                        contentView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        loadingView.setVisibility(View.GONE);
                        loadingView.setAlpha(1f); // For future showLoading calls
                        contentView.setTranslationY(0);
                        loadingView.setTranslationY(0);
                    }
                });

                set.start();
            }
        }
    }

    /**
     * Converts a dp value to a px value
     *
     * @param dp the dp value
     */
    public static int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

    public static void expand(final View v, final int targtetHeight, int duration) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targtetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(duration);
        v.startAnimation(a);
    }

    public static void collapse(final View v, int duration) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(duration);
        v.startAnimation(a);
    }

    public static void crossfade(final View mLoadingView, View mContentView) {
        long mShortAnimationDuration = 500;

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }
}
