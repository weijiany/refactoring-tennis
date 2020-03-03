package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private int p2Score;
    private int p1Score;
    private String p1Name;
    private String p2Name;
    private final String[] SCORE_DESCRIPTIONS = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1Name, String p2Name) {
        this.p1Name = p1Name;
        this.p2Name = p2Name;
    }

    public String getScore() {
        String p1Description;
        if (p1Score < 4 && p2Score < 4 && !(p1Score + p2Score == 6)) {
            p1Description = SCORE_DESCRIPTIONS[p1Score];
            return (p1Score == p2Score) ? p1Description + "-All" : p1Description + "-" + SCORE_DESCRIPTIONS[p2Score];
        } else {
            if (p1Score == p2Score)
                return "Deuce";
            p1Description = p1Score > p2Score ? p1Name : p2Name;
            return ((p1Score - p2Score) * (p1Score - p2Score) == 1) ? "Advantage " + p1Description : "Win for " + p1Description;
        }
    }

    public void wonPoint(String playerName) {
        if (p1Name.equals(playerName))
            this.p1Score += 1;
        else
            this.p2Score += 1;

    }

}