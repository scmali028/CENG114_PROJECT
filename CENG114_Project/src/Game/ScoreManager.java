package Game;

public class ScoreManager {

    private int score = 0;

    public int addScore(int wordLength, int takenLetterCount) {

        int totalPoint = wordLength * 10;
        int gainedPoint = totalPoint - takenLetterCount * 10;

        score += gainedPoint;
        return score;
    }

    public int getScore() {
        return score;
    }
}
