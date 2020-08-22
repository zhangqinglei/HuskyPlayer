package com.husky.player.view.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.husky.player.view.base.BaseFloatingView;
import com.yxl.medialibrary.R;

public class LandscapeTopController extends BaseFloatingView {

    public LandscapeTopController(Context context) {
        this(context, null);
    }

    public LandscapeTopController(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.landscape_top_controller, this);

    }
}
