package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;
    private final String[] SCORE_DESCRIPTIONS = new String[] {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = scoreOfDeuce();

        score = scoreOfNotEqual(score);

        score = scoreOfAdvantage(score);

        return scoreForWin(score);
    }

    private String scoreForWin(String score) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String scoreOfAdvantage(String score) {
        if (P1point > P2point && P2point >= 3) {
            return "Advantage " + player1Name;
        }

        if (P2point > P1point && P1point >= 3) {
            return "Advantage " + player2Name;
        }
        return score;
    }

    private String scoreOfNotEqual(String score) {
        if (P1point < 4 && P2point < 4 && P1point != P2point) {
            return SCORE_DESCRIPTIONS[P1point] + "-" + SCORE_DESCRIPTIONS[P2point];
        }
        return score;
    }

    private String scoreOfDeuce() {
        if (P1point == P2point) {
            if (P1point < 3)
                return SCORE_DESCRIPTIONS[P1point] + "-All";
            return "Deuce";
        }
        return "";
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player))
            P1Score();
        else
            P2Score();
    }
}
