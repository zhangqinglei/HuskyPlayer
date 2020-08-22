package com.husky.player.view.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.husky.player.view.base.BaseFloatingView;
import com.yxl.medialibrary.R;

public class PortraitBottomController extends BaseFloatingView {


    public PortraitBottomController(Context context) {
        this(context, null);
    }

    public PortraitBottomController(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.portrait_bottom_controller, this);

    }
}
