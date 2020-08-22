package com.husky.player.model;

/*
 *定义播放器提供的更能接口
 */

import com.husky.player.sdk.model.PlayData;
import com.husky.player.sdk.player.IMediaPlayer;

public interface IVideoImpl extends IMediaPlayer {

    public void doPlay(PlayData playData);
}
