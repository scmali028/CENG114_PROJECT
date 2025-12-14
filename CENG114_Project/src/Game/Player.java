package Game;
import UserBehaviors.*;
public class Player {

     private String name;
    private int questionLength = 4;

    private WordEngine engine;

    public Player(String name,
                  String firstAnswer,
                  TakeLetterBehavior takeLetterBehavior,
                  EstimateBehavior estimateBehavior) {

        this.name = name;
        this.engine = new WordEngine(firstAnswer, takeLetterBehavior, estimateBehavior);
    }

    public WordEngine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }

    public void displayName() {
        System.out.println("Welcome to our game " + name);
    }

   

    
   
}