package Game;

import UserBehaviors.*;

public class WordEngine {

    private WordState wordState;
    private ScoreManager scoreManager;
    private LifeManager lifeManager;

    private TakeLetterBehavior takingLetterBehavior;
    private EstimateBehavior estimateBehavior;

    public WordEngine(String answer,
            TakeLetterBehavior takeLetterBehavior,
            EstimateBehavior estimateBehavior) {

        this.wordState = new WordState(answer);
        this.lifeManager = new LifeManager(3);
        this.scoreManager = new ScoreManager();

this.takingLetterBehavior= takeLetterBehavior;
this.estimateBehavior = estimateBehavior;
    }

    public void setNewWord(String newAnswer) {
        wordState.setNewAnswer(newAnswer);
        lifeManager = new LifeManager(3);

    }

    public void performTakingLetter() {
        takingLetterBehavior.takeLetter(wordState.getCurrent(), wordState.getAnswer());
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

    public char[] getCurrent() {
        return wordState.getCurrent();
    }

    public String getAnswer() {
        return wordState.getAnswer();
    }

    public void getPrintNoVisibleState() {

        wordState.fillingArrayAsANotVisible(getCurrent());
    }

    public void getPrintVisibleState() {

        wordState.printCurrentArr(getCurrent());

    }

    public double getScore() {
        return scoreManager.getScore();
    }

    public double addScore(int howManyGotLetter) {
        return scoreManager.addScore(wordState.getAnswer(), howManyGotLetter);
    }

    public double getReachableScore(int howManyGotLetter) {

        return scoreManager.canTakeScore(getAnswer(), howManyGotLetter);
    }

    public int getLife() {
        return lifeManager.getLife();
    }

    public void loseLife() {
        lifeManager.loseLife();
    }
}
