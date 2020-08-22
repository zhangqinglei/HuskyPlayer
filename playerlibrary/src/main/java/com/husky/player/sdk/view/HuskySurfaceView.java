package com.husky.player.sdk.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class HuskySurfaceView extends SurfaceView {

    // x as width, y as height
    protected Point mVideoSize;
    protected boolean hasUpdated;

    public HuskySurfaceView(Context context) {
        this(context, null);
    }

    public HuskySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mVideoSize = new Point(0, 0);
    }

    @Override
    public void setRotation(float rotation) {
        if (rotation != getRotation()) {
            super.setRotation(rotation);
            requestLayout();
        }
    }


    public void setVideoSize(Point videoSize) {
        if (videoSize != null && !mVideoSize.equals(videoSize)) {
            this.mVideoSize = videoSize;
            requestLayout();
        }
    }

    /*
     *根据视频的宽和高视频调整
     */
    /*
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mVideoSize == null) {
            return;
        }
        int viewRotation = (int) getRotation();
        // 如果判断成立，则说明显示的TextureView和本身的位置是有90度的旋转的，所以需要交换宽高参数。
        if (viewRotation == 90 || viewRotation == 270) {
            int tempMeasureSpec = widthMeasureSpec;
            widthMeasureSpec = heightMeasureSpec;
            heightMeasureSpec = tempMeasureSpec;
        }

        int videoWidth = mVideoSize.x;
        int videoHeight = mVideoSize.y;

        int width = getDefaultSize(videoWidth, widthMeasureSpec);
        int height = getDefaultSize(videoHeight, heightMeasureSpec);


        if (videoWidth > 0 && videoHeight > 0) {

            int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
            int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
            int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);


            if (widthSpecMode == MeasureSpec.EXACTLY && heightSpecMode == MeasureSpec.EXACTLY) {
               //根据视频的尺寸比例调整View的尺寸比例
                // the size is fixed
                width = widthSpecSize;
                height = heightSpecSize;

                if (videoWidth * height < width * videoHeight) {
                    width = height * videoWidth / videoHeight;
                } else if (videoWidth * height > width * videoHeight) {
                    height = width * videoHeight / videoWidth;
                }
            } else if (widthSpecMode == MeasureSpec.EXACTLY) {
                // only the width is fixed, adjust the height to match aspect ratio if possible
                width = widthSpecSize;
                height = width * videoHeight / videoWidth;
                if (heightSpecMode == MeasureSpec.AT_MOST && height > heightSpecSize) {
                    //AT_MOST 高度不能超出heightSpecSize限制， 重新调整宽和高
                    height = heightSpecSize;
                    width = height * videoWidth / videoHeight;
                }
            } else if (heightSpecMode == MeasureSpec.EXACTLY) {
                // only the height is fixed, adjust the width to match aspect ratio if possible
                height = heightSpecSize;
                width = height * videoWidth / videoHeight;
                if (widthSpecMode == MeasureSpec.AT_MOST && width > widthSpecSize) {
                    //宽度不能超出widthSpecSize限制，重新调整宽和高
                    width = widthSpecSize;
                    height = width * videoHeight / videoWidth;
                }
            } else {
                // neither the width nor the height are fixed, try to use actual video size
                width = videoWidth;
                height = videoHeight;
                if (heightSpecMode == MeasureSpec.AT_MOST && height > heightSpecSize) {
                    // too tall, decrease both width and height
                    height = heightSpecSize;
                    width = height * videoWidth / videoHeight;
                }
                if (widthSpecMode == MeasureSpec.AT_MOST && width > widthSpecSize) {
                    // too wide, decrease both width and height
                    width = widthSpecSize;
                    height = width * videoHeight / videoWidth;
                }
            }
        }
    }

     */

}
