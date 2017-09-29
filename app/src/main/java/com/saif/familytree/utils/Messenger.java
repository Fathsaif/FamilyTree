package com.saif.familytree.utils;

import android.app.Activity;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.saif.familytree.R;

import static com.github.johnpersano.supertoasts.library.SuperActivityToast.create;


/**
 * Created by Ahmed on 12/4/2016.
 */

public class Messenger {

    public static void showSuccessMsg(String txt, Activity activity){
        create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(txt)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_BLUE))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }

    public static void showSuccessMsg(int txtRes, Activity activity){
        create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(StringUtil.getStringRes(txtRes))
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_BLUE))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }

    public static void showErrorMsg(String msg,Activity activity){
        create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(msg)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(activity.getResources().getColor(R.color.colorAccent))//PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_RED)
                .setAnimations(Style.ANIMATIONS_POP).show();
    }

    public static void showNetworkErrorMsg(Activity activity){
        showErrorMsg(StringUtil.getStringRes(R.string.check_internet_connection_title),activity);
    }



    public static void showLongInfoMessage(Activity activity, String title, String buttonTxt,
                                           SuperActivityToast.OnButtonClickListener clickListener) {
        SuperActivityToast toast =  create(activity, new Style(),buttonTxt==null?Style.TYPE_STANDARD :Style.TYPE_BUTTON );
        if (buttonTxt!=null){
            toast.setButtonText(buttonTxt);
            toast.setOnButtonClickListener(title, null, clickListener);
        }
        toast.setText(title);
        toast.setDuration(10000);
        toast.setFrame(Style.FRAME_LOLLIPOP);
        toast.setColor(activity.getResources().getColor(R.color.colorPrimary));
        toast.setAnimations(Style.ANIMATIONS_POP).show();
    }

}
