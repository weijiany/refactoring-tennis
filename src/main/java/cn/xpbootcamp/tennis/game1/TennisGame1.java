package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            m_score1 += 1;
        else if (player2Name.equals(playerName))
            m_score2 += 1;
    }

    public String getScore() {
        if (isDeuce(m_score1, m_score2))
            return scoreOfDeuce();
        if (isAdvantage())
            return scoreOfAdvantage();

        return scoreOfDescription(m_score1) + '-' + scoreOfDescription(m_score2);
    }

    private String scoreOfDescription(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new RuntimeException();
        }
    }

    private String scoreOfAdvantage() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private boolean isAdvantage() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String scoreOfDeuce() {
        switch (m_score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";

        }
    }

    private boolean isDeuce(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }
}