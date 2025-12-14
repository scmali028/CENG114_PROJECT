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

   final private String FILE = "UsernameAndPasswords.txt";

     public boolean isUserAvailable(String username) throws IOException {
        File file = new File(this.FILE);
        if (!file.exists()) return true;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("###");
                if (part.length == 2 && part[0].equals(username)) {
                    return false; // kullanıcı VAR
                }
                
                
            }
        }
        return true; // kullanıcı YOK → uygun
    }

    public boolean checkUserInformation(String username, String password) throws IOException {
        File file = new File(this.FILE);
        if (!file.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("###");
                if (part.length == 2 &&
                        part[0].equals(username) &&
                        part[1].equals(password)) {
                     
                        
                    
                    return true;
                }
            }
        }
        
        
        return false;
    }

    public void writeUser(String username, String password) throws IOException {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            
            
            fw.write(username + "###" + password + "\n");
        }
    }
}