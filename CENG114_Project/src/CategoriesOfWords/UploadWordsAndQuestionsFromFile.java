/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alise
 */
public class UploadWordsAndQuestionsFromFile {
    //burada dosyadan arrayleri tek tek doludrma clasıı 
    //nasıl çağrıldıpını falan  four lettersda anlattım oraya da bir bak 

    private String file = "WordsAndQuestions.txt";
    private int len;

    public UploadWordsAndQuestionsFromFile(int len) {
        this.len = len;
    }

    // burası gelen len kadar kaç tane kelime var onu döndürüyor
    public int howManyWordsSpecificLetters() {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] PartOfLine = line.split("###");
                if (PartOfLine[0].length() == len) {
                    count++;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    //burada şey var artık 
    public void getFillInWordsAndQuestions(String words[], String questions[]) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] PartOfLine = line.split("###");
                if (PartOfLine[0].length() == len) {
                    words[index] = PartOfLine[0];//System.out.println(PartOfLine[0]+ "*****************veee"+PartOfLine[1]);
                    questions[index++] = PartOfLine[1];

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
