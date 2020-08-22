package com.husky.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.view.View.OnClickListener;

import com.husky.player.sdk.config.PlayerType;
import com.husky.player.sdk.model.PlayData;
import com.husky.utils.DisplayUtil;
import com.husky.utils.LogUtil;
import com.yxl.husky.R;

import com.husky.player.view.HuskyPlayerView;

public class NormalVideoActivity extends AppCompatActivity implements OnClickListener{

    private HuskyPlayerView mPlayerView;

    private FrameLayout mVideoContainer;

    private Button mBtnPlay;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_video);

        init();
    }

    private void init() {
        mVideoContainer = findViewById(R.id.video_container);
        resieVideoContainer(mVideoContainer);
        mPlayerView = new HuskyPlayerView(this);
        mVideoContainer.addView(mPlayerView);
        mBtnPlay = findViewById(R.id.btn_normal_video_play);
        mBtnPlay.setOnClickListener(this);
        /*
        mediaPlayer = new MediaPlayer();
        SurfaceView surfaceView = new SurfaceView(this);

        //mPlayerView.addView(surfaceView);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        mVideoContainer.addView(surfaceView);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                LogUtil.e("onPrepared()-------------------------->");
                mediaPlayer.start();
            }
        });

         */

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal_video_play:
                PlayData playData = new PlayData();
                playData.setPlayerType(PlayerType.MEDIAPLAYE);
                String url = "https://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
                /*
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.prepareAsync();


                } catch (Exception e) {
                    LogUtil.e("e is---------------->" + e.getMessage());
                }

                 */



                playData.setPlayUrl(url);
                if (mPlayerView != null) {
                    mPlayerView.doPlay(playData);
                }


                break;
        }
    }

    private void resieVideoContainer(ViewGroup container) {
        if (container == null) {
            return;
        }

        int width = DisplayUtil.getScreenWidth(this);
        int height = (width * 9) / 16;

        ViewGroup.LayoutParams params = container.getLayoutParams();
        if (params != null) {
            params.width = width;
            params.height = height;
            container.setLayoutParams(params);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}