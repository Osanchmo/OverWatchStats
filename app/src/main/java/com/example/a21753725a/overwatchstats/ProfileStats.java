package com.example.a21753725a.overwatchstats;

public class ProfileStats {
    String username;
    int level;
    int star;
    int quickGameWins;
    int competitiveRank;

    // competitive wins - lost - played
    int[] competitive = new int[3];
    //quickgame - competitive
    int[] playTime = new int[2];

    //images
    String levelFrame;
    String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getQuickGameWins() {
        return quickGameWins;
    }

    public void setQuickGameWins(int quickGameWins) {
        this.quickGameWins = quickGameWins;
    }

    public int getCompetitiveRank() {
        return competitiveRank;
    }

    public void setCompetitiveRank(int competitiveRank) {
        this.competitiveRank = competitiveRank;
    }

    public int[] getCompetitive() {
        return competitive;
    }

    public void setCompetitive(int[] competitive) {
        this.competitive = competitive;
    }

    public int[] getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int[] playTime) {
        this.playTime = playTime;
    }

    public String getLevelFrame() {
        return levelFrame;
    }

    public void setLevelFrame(String levelFrame) {
        this.levelFrame = levelFrame;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
