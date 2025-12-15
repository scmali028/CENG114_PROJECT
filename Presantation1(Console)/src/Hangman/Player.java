package Hangman;

import PlayerInformation.ReaderAndWriterFileProcess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;

abstract public class Player {

    private String name;
    private int Id;
    private  int lastusedID;

    private HangmanEngine engine;
    private ReaderAndWriterFileProcess readerAndWriterFileProcess;

    public Player(String name,int Id,
            HangmanEngine engine) throws IOException {

        this.name = name;
        this.lastusedID=ReaderAndWriterFileProcess.getterLastIdFromFile();
        this.Id=lastusedID++;
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
