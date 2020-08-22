package com.husky.player.sdk.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;

import com.husky.utils.LogUtil;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public class MediaPlayerImpl implements IMediaPlayer {

    private static final String TAG = "MediaPlayerImpl";

    private MediaPlayer mMediaPlayer = null;

    private OnPreparedListener mPreparedListener;

    private OnBufferingUpdateListener mBufferingUpdateListener;

    private OnCompletionListener mCompletionListener;

    private OnSeekCompleteListener mSeekCompleteListener;

    private OnVideoSizeChangedListener mVideoSizeChangedListener;

    private OnErrorListener mErrorListener;

    public MediaPlayerImpl() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnPreparedListener(mOnPreparedListener);
        mMediaPlayer.setOnBufferingUpdateListener(mOnBufferingUpdateListener);
        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
        mMediaPlayer.setOnErrorListener(mOnErrorListener);
    }

    @Override
    public void setDisplay(SurfaceHolder sh) {
        if (mMediaPlayer != null) {
            LogUtil.i(TAG + " setDisplay()");
            mMediaPlayer.setDisplay(sh);
        }
    }

    @Override
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediaPlayer != null) {
            LogUtil.i(TAG + " setDisplay()");
            mMediaPlayer.setDataSource(context, uri);
        }
    }

    @Override
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.setDataSource(context, uri, headers);
        }
    }

    @Override
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.setDataSource(fd);
        }
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (mMediaPlayer != null) {
            Log.e("Test", "url -------------->" + path);
            mMediaPlayer.setDataSource(path);
        }
    }

    @Override
    public String getDataSource() {
        return null;
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        if (mMediaPlayer != null) {
            Log.e("Test", "prepareAsync()--------------->");
            mMediaPlayer.prepareAsync();
        }
    }

    @Override
    public void prepare() {
        try {
            if (mMediaPlayer != null) {
                Log.e("Test", "prepare()--------------->");
                mMediaPlayer.prepare();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void start() throws IllegalStateException {
        if (mMediaPlayer != null) {
            Log.e("Test", "start()--------------->");
            mMediaPlayer.start();
        }
    }

    @Override
    public void stop() throws IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
        }
    }

    @Override
    public void pause() throws IllegalStateException {
        if (mMediaPlayer != null) {
            mMediaPlayer.pause();
        }
    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setScreenOnWhilePlaying(screenOn);
        }
    }

    @Override
    public int getVideoWidth() {
        if (mMediaPlayer != null) {
            mMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override
    public int getVideoHeight() {
        if (mMediaPlayer != null) {
            mMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override
    public boolean isPlaying() {
        if (mMediaPlayer != null) {
            mMediaPlayer.isPlaying();
        }
        return false;
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {
        if (mMediaPlayer != null) {
            int pos = (int)(msec / 1000);
            mMediaPlayer.seekTo(pos);
        }
    }

    @Override
    public long getCurrentPosition() {
        if (mMediaPlayer != null) {
            mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override
    public long getDuration() {
        if (mMediaPlayer != null) {
            mMediaPlayer.getDuration();
        }
        return 0;
    }

    @Override
    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }
    }

    @Override
    public void reset() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
        }
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setVolume(leftVolume, rightVolume);
        }
    }

    @Override
    public int getAudioSessionId() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getAudioSessionId();
        }
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
        Log.e("Test", TAG + " setOnPreparedListener()");
        this.mPreparedListener = listener;
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        Log.e("Test", TAG + " setOnCompletionListener()");
        this.mCompletionListener = listener;
    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        Log.e("Test", TAG + " setOnCompletionListener()");

        this.mBufferingUpdateListener = listener;
    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        Log.e("Test", TAG + " setOnSeekCompleteListener()");
        this.mSeekCompleteListener = listener;
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        Log.e("Test", TAG + " setOnVideoSizeChangedListener()");
        this.mVideoSizeChangedListener = listener;
    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {
        Log.e("Test", TAG + " setOnErrorListener()");
        this.mErrorListener = listener;
    }

    @Override
    public void setOnInfoListener(OnInfoListener listener) {

    }

    @Override
    public void setAudioStreamType(int streamtype) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setAudioStreamType(streamtype);
        }
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
        if (mMediaPlayer != null) {
            mMediaPlayer.setLooping(looping);
        }
    }

    @Override
    public boolean isLooping() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.isLooping();
        }
        return false;
    }

    @Override
    public void setSurface(Surface surface) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setSurface(surface);
        }
    }

    private MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            Log.e("Test", "onPrepared()------------------>");
            if (mPreparedListener != null) {
                mPreparedListener.onPrepared(MediaPlayerImpl.this);
            }
        }
    };

    private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (mBufferingUpdateListener != null) {
                mBufferingUpdateListener.onBufferingUpdate(MediaPlayerImpl.this, i);
            }
        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mCompletionListener != null) {
                mCompletionListener.onCompletion(MediaPlayerImpl.this);
            }
        }
    };

    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (mSeekCompleteListener != null) {
                mSeekCompleteListener.onSeekComplete(MediaPlayerImpl.this);
            }
        }
    };

    private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
        @Override
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
            if (mVideoSizeChangedListener != null) {
                mVideoSizeChangedListener.onVideoSizeChanged(MediaPlayerImpl.this, i, i1);
            }
        }
    };


    private MediaPlayer.OnErrorListener mOnErrorListener = new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            if (mErrorListener != null) {
                mErrorListener.onError(MediaPlayerImpl.this, i, i1);
            }
            return false;
        }
    };
}

