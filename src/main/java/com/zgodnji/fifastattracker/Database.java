package com.zgodnji.fifastattracker;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<UserStat> userStats = new ArrayList<UserStat>();

    public static List<UserStat> getUserStats() {
        return userStats;
    }

    public static UserStat getUserStat(String userId) {
        for (UserStat stat : userStats) {
            if (stat.getUserId().equals(userId))
                return stat;
        }

        return null;
    }

    public static void addUserStat(UserStat stat) {
        userStats.add(stat);
    }

    public static void deleteUserStat(String userId) {
        for (UserStat stat : userStats) {
            if (stat.getUserId().equals(userId)) {
                userStats.remove(stat);
                break;
            }
        }
    }
}
