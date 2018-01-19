package com.zgodnji.fifastattracker;

public class UserStat {

    private String userId;
    private double winPercentage;
    private int allGamesPlayed;
    private int won;
    private int lost;

    public UserStat(String userId, double winPercentage, int allGamesPlayed, int won, int lost) {
        this.userId = userId;
        this.winPercentage = winPercentage;
        this.allGamesPlayed = allGamesPlayed;
        this.won = won;
        this.lost = lost;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public int getAllGamesPlayed() {
        return allGamesPlayed;
    }

    public int getLost() {
        return lost;
    }

    public int getWon() {
        return won;
    }

    public void setAllGamesPlayed(int allGamesPlayed) {
        this.allGamesPlayed = allGamesPlayed;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }

    public void setWon(int won) {
        this.won = won;
    }
}
