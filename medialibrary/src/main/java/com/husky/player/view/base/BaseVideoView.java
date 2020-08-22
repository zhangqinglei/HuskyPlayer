package com.husky.player.view.base;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;

import com.husky.player.model.IVideoImpl;
import com.husky.player.sdk.model.PlayData;
import com.husky.player.sdk.player.HuskyPlayer;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

public class BaseVideoView extends RelativeLayout implements IVideoImpl {

    private HuskyPlayer mHuskPlayer;

    public BaseVideoView(Context context) {
        this(context, null);
    }

    public BaseVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mHuskPlayer = new HuskyPlayer(getContext());
        mHuskPlayer.setParentAnchor(this);
    }

    public void doPlay(PlayData playData) {
        if (mHuskPlayer != null) {
            mHuskPlayer.doPlay(playData);
        }
    }


    @Override
    public void setDisplay(SurfaceHolder sh) {
        
    }

    @Override
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {

    }

    @Override
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {

    }

    @Override
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {

    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {

    }

    @Override
    public String getDataSource() {
        return null;
    }

    @Override
    public void prepareAsync() throws IllegalStateException {

    }

    @Override
    public void prepare() {

    }

    @Override
    public void start() throws IllegalStateException {

    }

    @Override
    public void stop() throws IllegalStateException {

    }

    @Override
    public void pause() throws IllegalStateException {

    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {

    }

    @Override
    public int getVideoWidth() {
        return 0;
    }

    @Override
    public int getVideoHeight() {
        return 0;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {

    }

    @Override
    public long getCurrentPosition() {
        return 0;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public void release() {

    }

    @Override
    public void reset() {

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

    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {

    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {

    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {

    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {

    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {

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

    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setSurface(Surface surface) {

    }
}
