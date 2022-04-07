package com.barhop.datingapp;

public class eloSystem {

    public static float winProbability(int myElo, int otherElo) {
        return 1.0f * 1.0f / (1 + 1.0f *
                (float)(Math.pow(10, 1.0f *
                        (otherElo - myElo) / 400)));
    }

    public static int updateRating(int currentElo, int otherElo, int right) {
        return (int)(currentElo + 30*(right - winProbability(currentElo, otherElo)));
    }

}
