package Hangman;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aliemre
 */
import java.io.IOException;
import userBehaviors.*;
public class NormalPlayer extends Player{

     public NormalPlayer(String name,
                        String firstAnswer,
                        int Id,
                        TakeLetter guessBehavior,
                        EstimateQuestionBehaviors estimateBehavior) throws IOException {

        super(name, Id,new HangmanEngine(firstAnswer, guessBehavior, estimateBehavior));
    }
    
     @Override
     public void displayWhichPlayer(){
     
         System.out.println("you are a Normal Player");
     }
     

    @Override
    public String toString() {
        return super.toString();
                
    }
    
     
   
    
}
