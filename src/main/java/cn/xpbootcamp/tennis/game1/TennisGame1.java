package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;
    private final String[] SCORE_DESCRIPTIONS = new String[] {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            mScore1 += 1;
        } else if (player2Name.equals(playerName)) {
            mScore2 += 1;
        }
    }

    public String getScore() {
        if (isDeuce(mScore1, mScore2)) {
            return scoreOfDeuce();
        }
        if (isAdvantage()) {
            return scoreOfAdvantage();
        }

        return SCORE_DESCRIPTIONS[mScore1] + '-' + SCORE_DESCRIPTIONS[mScore2];
    }

    private String scoreOfAdvantage() {
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) {
            return "Advantage " + player1Name;
        }
        if (minusResult == -1) {
            return "Advantage " + player2Name;
        }
        if (minusResult >= 2) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
    }

    private String scoreOfDeuce() {
        if (mScore1 < 3) {
            return SCORE_DESCRIPTIONS[mScore1] + "-All";
        }
        return "Deuce";
    }

    private boolean isAdvantage() {
        return mScore1 >= 4 || mScore2 >= 4;
    }

    private boolean isDeuce(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }
}