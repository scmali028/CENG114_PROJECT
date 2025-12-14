package Hangman;

import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;



public class Player {

    private String name;
    private int questionLength = 4;

    private HangmanEngine engine;

    public Player(String name,
                  String firstAnswer,
                  TakeLetter guessBehavior,
                  EstimateQuestionBehaviors estimateBehavior) {

        this.name = name;
        this.engine = new HangmanEngine(firstAnswer, guessBehavior, estimateBehavior);
    }

    public HangmanEngine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }

    public void displayName() {
        System.out.println("Welcome to our game " + name);
    }

   

    
   
}
