package com.husky.player.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.husky.player.sdk.player.HuskyPlayer;

public class BaseFloatingView extends RelativeLayout {

    private HuskyPlayer mHuskyPlayer;

    public BaseFloatingView(Context context) {
        this(context, null);
    }

    public BaseFloatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mHuskyPlayer = new HuskyPlayer(getContext());
        //设置播放器视频容器
        mHuskyPlayer.setParentAnchor(this);
    }

}
