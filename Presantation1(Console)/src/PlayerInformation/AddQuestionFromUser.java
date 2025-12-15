/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author aliemre
 */
public class AddQuestionFromUser {
    final static private String FILE = "WordsAndQuestions.txt";
    
    
    
    public static String addQuestion(int Id,Scanner input){
        System.out.println("please düzgün sorualr yazın");//label olarak koyarız
        
        System.out.println("please enter a question (you can use a-Z and numbers)");
        String question=input.nextLine();
        
        
        System.out.println("please enter  question's answer (you can use a-Z and numbers)");
        String answer=input.nextLine();
        
        try (FileWriter fw=new FileWriter(FILE,true)){
            fw.write(answer+"###"+question+"###"+Id);
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
    
    
    
        
        
    
    return "";
    }
    
    
    
}
