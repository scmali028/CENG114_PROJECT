/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aliemre
 */
public class ReaderAndWriterFileProcess {

   final static private String FILE = "UsernameAndPasswords.txt";
   
   

     public static boolean isUserAvailable(String username) throws IOException {
       

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            
            
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("###");
                if (part.length == 3 && part[1].equals(username)) {
                    return false; // kullanıcı VAR
                }
                
                
            }
        }
        return true; // kullanıcı YOK → uygun
    }

    public static boolean checkUserInformation(String username, String password) throws IOException {
       

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("###");
                if (part.length == 3 &&
                        part[1].equals(username) &&
                        part[2].equals(password)) {
                     
                        
                    
                    return true;
                }
            }
        }
        
        
        return false;
    }
    public static int getterLastIdFromFile() throws FileNotFoundException, IOException{
        int defaultId=100;
         try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split("###");
               // System.out.println(parts.length +" "+parts[0]+" "+parts[1]+" 3.");
                if ( parts !=null  && parts.length == 3 ) {
                     defaultId=Integer.parseInt(parts[0])>defaultId ?  Integer.parseInt(parts[0]): defaultId ;
                       
                    
                    
                 
                }
            }
        }
        
      
        
        
        return defaultId;
    }

    public void writeUser(String username, String password) throws IOException {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            
            
            fw.write((getterLastIdFromFile()+1)+"###"+username + "###" + password + "\n");
        }
    }
}