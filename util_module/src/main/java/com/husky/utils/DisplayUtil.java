package com.husky.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DisplayUtil {

    public static int dpToPx(Context context, float dip) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, metrics);
    }

    public static int spToPx(Context context, float sp) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, metrics);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }


    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
