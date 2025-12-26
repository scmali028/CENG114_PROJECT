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
   

    private WordEngine engine;
   

    public Player(String name,int Id,
            WordEngine engine)  {

        this.name = name;
        
        this.Id=Id;
        this.engine = engine;
    }
    
    abstract public void displayWhichPlayer();

    public WordEngine getEngine() {
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
        return "Name "+getName()+"\n Your score "+ getEngine().getScore()+
                "\nYour Time:"+getEngine().getTimeManager().getTotalTime()+"seconds";
        
    }
}
