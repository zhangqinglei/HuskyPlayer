package com.husky.player.sdk.model;

import com.husky.player.sdk.config.PlayerType;

public class PlayData {

    private PlayerType playerType;

    private String playUrl;


    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public static class Builder {



    }
}
