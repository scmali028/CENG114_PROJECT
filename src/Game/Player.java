package Game;

import PlayerInformation.ReaderAndWriterFileProcess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;

abstract public class Player {

    private String name;
    private int Id;
   

    private HangmanEngine engine;
   

    public Player(String name,int Id,
            HangmanEngine engine)  {

        this.name = name;
        
        this.Id=Id;
        this.engine = engine;
    }
    
    abstract public void displayWhichPlayer();

    public HangmanEngine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }
    public int getId(){
    
    return Id;
    }
    
     

    public void displayName() {
        System.out.println("Welcome to our game " + name);
    }

     @Override
    public String toString() {
        return "Name "+getName()+" Your score "+ getEngine().getScore();
        
    }
}
