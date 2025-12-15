package Hangman;

import PlayerInformation.ReaderAndWriterFileProcess;
import java.io.BufferedReader;
import java.io.FileReader;
import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;

abstract public class Player {

    private String name;
    private int Id;
    private static int lastusedID=loadLastId();

    private HangmanEngine engine;
    private ReaderAndWriterFileProcess readerAndWriterFileProcess;

    public Player(String name,int Id,
            HangmanEngine engine) {

        this.name = name;
        
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
    
     public static int loadLastId() {
        int lastId = 100;
        try (BufferedReader br = new BufferedReader(new FileReader("Submit.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                lastId = Integer.parseInt(parts[0]);
            }
        } catch (Exception e) {
            
        }
        return lastId;
    }

    public void displayName() {
        System.out.println("Welcome to our game " + name);
    }

}
