package com.husky.player.sdk.factory;

import com.husky.player.sdk.player.IMediaPlayer;
import com.husky.player.sdk.config.PlayerType;
import com.husky.player.sdk.player.MediaPlayerImpl;

import java.util.HashMap;
import java.util.Map;

public class HuskyPlayerFactory {

    private Map<PlayerType, IMediaPlayer> mMediaPlayerMap;

    public HuskyPlayerFactory() {
        mMediaPlayerMap = new HashMap<>();
    }

    public IMediaPlayer geMediaPlayer(PlayerType playerType) {
        //首先从缓存中获取播放器实例
        IMediaPlayer mediaPlayer = mMediaPlayerMap.get(playerType);

        //播放器不存在，创建新的播放器保存在缓存中
        if (mediaPlayer == null) {
            switch (playerType) {
                case MEDIAPLAYE:
                    mediaPlayer = new MediaPlayerImpl();
                    break;
            }
        }

        return mediaPlayer;
    }

}
