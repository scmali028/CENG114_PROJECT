/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

/**
 *
 * @author alise
 */
public class PlayerInfo {

    private String playerName;

    private int totalScore;

    private int solvedWordCount;

    public PlayerInfo() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSolvedWordCount() {
        return solvedWordCount;
    }

    public void setSolvedWordCount(int solvedWordCount) {
        this.solvedWordCount = solvedWordCount;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" + "playerName=" + playerName + ", totalScore=" + totalScore + ", solvedWordCount=" + solvedWordCount + '}';
    }
}
