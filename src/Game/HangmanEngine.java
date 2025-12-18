package Game;

import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;

public class HangmanEngine {

    private WordState wordState;
    private LifeManager lifeManager;
    private ScoreManager scoreManager;

    private TakeLetter takingLetterBehavior;
    private EstimateQuestionBehaviors estimateBehavior;

    public HangmanEngine(
                         TakeLetter guessBehavior,
                         EstimateQuestionBehaviors estimateBehavior) {

        this.wordState = null;
        this.lifeManager = new LifeManager(20);
        this.scoreManager = new ScoreManager();

        this.takingLetterBehavior = guessBehavior;
        this.estimateBehavior = estimateBehavior;
    }

    public void setNewWord(String newAnswer) {
        wordState.setNewAnswer(newAnswer);
        lifeManager = new LifeManager(3);
    }

    public void performTakingLetter() {
       takingLetterBehavior.guessLetter(wordState.getCurrent(), wordState.getAnswer());
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
    public void getPrintNoVisibleState(){
    
    wordState.fillingArrayAsANotVisible(getCurrent());
    }
    public void getPrintVisibleState(){
    
    wordState.printCurrentArr(getCurrent());
    
    }

    public int getLife() {
        return lifeManager.getLife();
    }

    public void loseLife() {
        lifeManager.loseLife();
    }

    public double getScore() {
        return scoreManager.getScore();
    }

    public double addScore(int howManyGotLetter) {
        return scoreManager.addScore(wordState.getAnswer(), howManyGotLetter);
    }
    public double getReachableScore(int howManyGotLetter){
    
    
    return scoreManager.canTakeScore(getAnswer(),howManyGotLetter);
            }
}
