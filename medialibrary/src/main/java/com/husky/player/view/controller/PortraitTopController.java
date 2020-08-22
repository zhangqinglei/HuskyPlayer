package com.husky.player.view.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.husky.player.view.base.BaseFloatingView;
import com.husky.player.view.base.BaseVideoView;
import com.yxl.medialibrary.R;

public class PortraitTopController extends BaseFloatingView {

    public PortraitTopController(Context context) {
        super(context);
    }

    public PortraitTopController(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.portrait_top_contorller, this);
    }
}
