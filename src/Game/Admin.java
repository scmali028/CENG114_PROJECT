package Game;

import java.io.IOException;
import userBehaviors.EstimateQuestionBehaviors;
import userBehaviors.TakeLetter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aliemre
 */
public class Admin extends Player{
    
    
    
    
        /*
         public Admin(String name,
                        String firstAnswer,
                        TakeLetter guessBehavior,
                        EstimateQuestionBehaviors estimateBehavior) {

        super(name, new HangmanEngine(firstAnswer, guessBehavior, estimateBehavior));
    }*/
    
     
    // delete işlemleri flan bağlıcaz sana 
    public Admin()   {
        super(null, 0,null);
        
    }
         
    
     @Override
     public void displayWhichPlayer(){
     
         System.out.println("Welcome Our  a little Admin");
     }
}
