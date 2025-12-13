package Game;

import UserBehaviors.TakeLetterBehavior;
import UserBehaviors.EstimateBehavior;

public class WordEngine {

    private WordState wordState;
    private ScoreManager scoreManager;

    private TakeLetterBehavior takeLetterBehavior;
    private EstimateBehavior estimateBehavior;

    private int takenLetterCount;

    public WordEngine(WordState wordState,
            ScoreManager scoreManager,
            TakeLetterBehavior takeLetterBehavior,
            EstimateBehavior estimateBehavior) {

        this.wordState = wordState;
        this.scoreManager = scoreManager;
        this.takeLetterBehavior = takeLetterBehavior;
        this.estimateBehavior = estimateBehavior;
        this.takenLetterCount = 0;
    }

    public void setNewWord(String newAnswer) {
        wordState.setNewAnswer(newAnswer);
        takenLetterCount = 0;
    }

    public void takeLetter() {
        takeLetterBehavior.takeLetter(
                wordState.getCurrent(),
                wordState.getAnswer()
        );
        takenLetterCount++;
    }


    public boolean performEstimate(String guess) {
        return estimateBehavior.estimate(
                wordState.getAnswer(),
                guess,
                wordState.getCurrent()
        );
    }

    public boolean isCompleted() {
        return wordState.isCompleted();
    }

    public double calculateFinalScore() {
        return scoreManager.addScore(
                wordState.getAnswer().length(),
                takenLetterCount
        );
    }

    public int getTakenLetterCount() {
        return wordState.getTakenLetterCount();
    }

    public char[] getCurrent() {
        return wordState.getCurrent();
    }

    public String getAnswer() {
        return wordState.getAnswer();
    }
}
