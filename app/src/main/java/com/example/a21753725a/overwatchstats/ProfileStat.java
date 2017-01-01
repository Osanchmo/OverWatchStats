package com.example.a21753725a.overwatchstats;

public class ProfileStat {
    String username;
    String level;
    String rank;

    String quickGameWins;
    String competitiveRank;
    // competitive wins - lost - played
    String[] competitive = new String[3];
    //quickgame - competitive
    String[] playTime = new String[2];

    //images
    String levelFrame;
    String avatar;
    String star;
    String rankImg;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankImg() {
        return rankImg;
    }

    public void setRankImg(String rankImg) {
        this.rankImg = rankImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getQuickGameWins() {
        return quickGameWins;
    }

    public void setQuickGameWins(String quickGameWins) {
        this.quickGameWins = quickGameWins;
    }

    public String getCompetitiveRank() {
        return competitiveRank;
    }

    public void setCompetitiveRank(String competitiveRank) {
        this.competitiveRank = competitiveRank;
    }

    public String[] getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String[] playTime) {
        this.playTime = playTime;
    }

    public String[] getCompetitive() {
        return competitive;
    }

    public void setCompetitive(String[] competitive) {
        this.competitive = competitive;
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
