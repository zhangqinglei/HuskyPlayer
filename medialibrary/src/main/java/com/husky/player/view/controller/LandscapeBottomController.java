package com.husky.player.view.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.husky.player.view.base.BaseFloatingView;
import com.yxl.medialibrary.R;

public class LandscapeBottomController extends BaseFloatingView {

    public LandscapeBottomController(Context context) {
        this(context, null);
    }

    public LandscapeBottomController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.landscape_bottom_controller, this);
    }
}
