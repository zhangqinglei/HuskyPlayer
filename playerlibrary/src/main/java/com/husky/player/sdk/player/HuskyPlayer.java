package com.husky.player.sdk.player;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

import com.husky.player.sdk.config.PlayerType;
import com.husky.player.sdk.factory.HuskyPlayerFactory;
import com.husky.player.sdk.model.PlayData;
import com.husky.player.sdk.view.HuskySurfaceView;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public class HuskyPlayer implements IMediaPlayer {

    // all possible internal states
    private static final int STATE_ERROR              = -1;

    private static final int STATE_IDLE               = 0;

    private static final int STATE_PREPARING          = 1;

    private static final int STATE_PREPARED           = 2;

    private static final int STATE_PLAYING            = 3;

    private static final int STATE_PAUSED             = 4;

    private static final int STATE_PLAYBACK_COMPLETED = 5;

    private static final int STATE_SUSPEND            = 6;

    private static final int STATE_RESUME             = 7;

    private static final int STATE_SUSPEND_UNSUPPORTED = 8;

    private int mCurrentState = STATE_IDLE;

    private int mTargetState  = STATE_IDLE;

    private HuskyPlayerFactory mPlayerFactory;

    private IMediaPlayer mMediPlayer;

    private PlayData mPlayData;

    private HuskySurfaceView mSufaceView;

    private Context mContext;

    private ViewGroup mParentView;

    public HuskyPlayer(Context context) {
        mPlayerFactory = new HuskyPlayerFactory();
        this.mContext = context;
    }

    public void setParentAnchor(ViewGroup parentView) {
        if (parentView == null) {
            return;
        }
        Context context = parentView.getContext();
        mSufaceView = new HuskySurfaceView(context);
        mSufaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        parentView.addView(mSufaceView);
        this.mParentView = parentView;
    }


    public void doPlay(final PlayData playData) {

        if (playData == null || playData.getPlayerType() == null) {
            return;
        }

        mPlayData = playData;

        //分发播放器,调用播放
        PlayerType playerType = playData.getPlayerType();
        IMediaPlayer mediaPlayer = mPlayerFactory.geMediaPlayer(playerType);
        mMediPlayer = mediaPlayer;


        if (mediaPlayer != null) {
            if (mSufaceView.getHolder().isCreating()) {
                mSufaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                    @Override
                    public void surfaceCreated(SurfaceHolder surfaceHolder) {
                        doPlay(playData);
                    }

                    @Override
                    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                    }

                    @Override
                    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

                    }
                });
            } else {
                mMediPlayer.setDisplay(mSufaceView.getHolder());
            }
        }

        try {

            final String url = playData.getPlayUrl();
            if (mCurrentState == STATE_PLAYING || mMediPlayer.isPlaying()) {
                //如果处于播放中，停止播放
                mMediPlayer.stop();
            }

            try {
                setDataSource(url);
            } catch (Exception e) {

            }
            setAudioStreamType(AudioManager.STREAM_MUSIC);
            prepareAsync();

            setOnPreparedListener(new OnPreparedListener() {
                @Override
                public void onPrepared(IMediaPlayer mp) {
                    start();
                }
            });
        } catch (Exception e) {

        }

        setOnVideoSizeChangedListener(mVideoSizeChangedListener);
    }


    @Override
    public void setDisplay(SurfaceHolder sh) {
        if (mMediPlayer != null) {
            mMediPlayer.setDisplay(sh);
        }
    }

    @Override
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediPlayer != null) {
            mMediPlayer.setDataSource(context, uri);
        }
    }

    @Override
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediPlayer != null) {
            mMediPlayer.setDataSource(context, uri, headers);
        }
    }

    @Override
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        if (mMediPlayer != null) {
            mMediPlayer.setDataSource(fd);
        }
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediPlayer != null) {
            mMediPlayer.setDataSource(path);
        }
    }

    @Override
    public String getDataSource() {
        return null;
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        if (mMediPlayer == null) {
            throw  new IllegalStateException("");
        }

        try {
            mMediPlayer.prepareAsync();
            //状态机调整为STATE_PREPARING
            updateState(STATE_PREPARING);
        } catch (Exception e) {
        }
    }

    @Override
    public void prepare() {
        if (mMediPlayer != null) {
            mMediPlayer.prepare();
        }
    }

    @Override
    public void start() throws IllegalStateException {
        if (mMediPlayer == null) {
            throw  new IllegalStateException("");
        }

        try {
            mMediPlayer.start();
            //状态机调整为STATE_PLAYING
            updateState(STATE_PLAYING);
        } catch (Exception e) {
        }
    }

    @Override
    public void stop() throws IllegalStateException {
        if (mMediPlayer == null) {
            throw  new IllegalStateException("");
        }

        try {
            mMediPlayer.stop();
            //stop之后状态进入IDLE
            updateState(STATE_IDLE);
        } catch (Exception e) {
        }
    }

    @Override
    public void pause() throws IllegalStateException {
        if (mMediPlayer == null) {
            throw  new IllegalStateException("");
        }

        try {
            mMediPlayer.pause();
            //状态机调整为STATE_PAUSED
            updateState(STATE_PAUSED);
        } catch (Exception e) {
        }
    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {
        if (mMediPlayer == null) {
            throw  new IllegalStateException("");
        }

        try {
            mMediPlayer.setScreenOnWhilePlaying(screenOn);
        } catch (Exception e) {
        }
    }

    @Override
    public int getVideoWidth() {
        if (mMediPlayer != null) {
            return mMediPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override
    public int getVideoHeight() {
        if (mMediPlayer != null) {
            return mMediPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override
    public boolean isPlaying() {
        if (mMediPlayer != null) {
            mMediPlayer.isPlaying();
        }
        return false;
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {
        if (mMediPlayer == null) {
            throw new IllegalStateException("");
        }

        mMediPlayer.seekTo(msec);
    }

    @Override
    public long getCurrentPosition() {
        if (mMediPlayer != null) {
            return mMediPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override
    public long getDuration() {
        if (mMediPlayer != null) {
            mMediPlayer.getDuration();
        }
        return 0;
    }

    @Override
    public void release() {
        if (mMediPlayer != null) {
            mMediPlayer.release();
        }
    }

    @Override
    public void reset() {
        if (mMediPlayer != null) {
            mMediPlayer.reset();
        }
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {

    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public void setLogEnabled(boolean enable) {

    }

    @Override
    public boolean isPlayable() {
        return false;
    }

    @Override
    public void setOnPreparedListener(OnPreparedListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnPreparedListener(listener);
        }
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnCompletionListener(listener);
        }
    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnBufferingUpdateListener(listener);
        }
    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnSeekCompleteListener(listener);
        }
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnVideoSizeChangedListener(listener);
        }
    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {
        if (mMediPlayer != null) {
            mMediPlayer.setOnErrorListener(listener);
        }
    }

    @Override
    public void setOnInfoListener(OnInfoListener listener) {

    }

    @Override
    public void setAudioStreamType(int streamtype) {

    }

    @Override
    public void setKeepInBackground(boolean keepInBackground) {

    }

    @Override
    public int getVideoSarNum() {
        return 0;
    }

    @Override
    public int getVideoSarDen() {
        return 0;
    }

    @Override
    public void setWakeMode(Context context, int mode) {

    }

    @Override
    public void setLooping(boolean looping) {
        if (mMediPlayer != null) {
            mMediPlayer.setLooping(looping);
        }
    }

    @Override
    public boolean isLooping() {
        if (mMediPlayer != null) {
            mMediPlayer.isLooping();
        }
        return false;
    }

    @Override
    public void setSurface(Surface surface) {
        if (mMediPlayer != null) {
            mMediPlayer.setSurface(surface);
        }
    }

    private void updateState(int state) {
        mCurrentState = state;
    }

    private IMediaPlayer.OnVideoSizeChangedListener mVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener () {
        @Override
        public void onVideoSizeChanged(IMediaPlayer mp, int width, int height) {
            Point point = new Point(width, height);
            if (mSufaceView != null) {
                mSufaceView.setVideoSize(point);
            }
        }
    };
}
