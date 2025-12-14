/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import LengthOfWords.*;
import LengthOfWords.FourLettersWords;
import LengthOfWords.FiveLettersWords;

import Hangman.Player;
import java.util.ArrayList;
import java.util.Scanner;
import userBehaviors.Estimating;
import userBehaviors.Taking;

/**
 *
 * @author aliemre
 */
public class Presantation1Console {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<AllWords> LengthOfWords = new ArrayList<>();
    private static Player player;

    public static void main(String[] args) {

        loadCategories();
        
        
        createPlayer();

        boolean exit = false;

        for (int questionIndex = 0; questionIndex <= 6 && !exit; questionIndex++) {

            String randomWord = LengthOfWords.get(questionIndex).getRandomWord().toLowerCase();

            startNewQuestion(randomWord, questionIndex);

            exit = runQuestionLoop(questionIndex);
            
        }
    }

    
    public static void loadCategories() {
        LengthOfWords.add(new FourLettersWords());
        LengthOfWords.add(new FiveLettersWords());
        LengthOfWords.add(new SixLettersWords());
        LengthOfWords.add(new SevenLettersWords());
        LengthOfWords.add(new EightLettersWords());
        LengthOfWords.add(new NineLettersWords());
        LengthOfWords.add(new TenLettersWords());
    }

    public static void createPlayer() {
        System.out.println("enter name");
        String name = input.nextLine();

        player = new Player(
                name, // oyuncu adı
                "", // ilk answer boş olacak
                new Taking(), // harf alma stratejisi
                new Estimating() // kelime tahmin stratejisi
        );
        player.getEngine().getPrintNoVisibleState();
        
        
        player.displayName();

    }

    public static void startNewQuestion(String word, int questionOrd) {
        player.getEngine().setNewWord(word);
        
        System.out.println();
        System.out.println(questionOrd+1 + ". Question");
    }

    public static boolean runQuestionLoop(int lengthOfWordsIndex) {

        int howManyGotLetter = 0;
                    //bura süre olucak 
        while (player.getEngine().getLife() > 0) {

            showQuestionInfo(lengthOfWordsIndex,howManyGotLetter);
            player.getEngine().getPrintVisibleState();
            //printCurrentArr(player.getEngine().getCurrent());// burdan current arr fonksiyonu yaz 

            if (player.getEngine().isCompleted()) {
                System.out.println("Correct! Next Question.");
                return false;  
            }

            int choice = askChoice();
            if (choice == 0) {
                return true; // exit
            }
            switch (choice) {

                case 1:
                    player.getEngine().performTakingLetter();
                    howManyGotLetter++;
                    break;

                case 2:
                    System.out.println("Please enter your guess: ");
                    String guess = input.nextLine();

                    if (player.getEngine().performEstimate(guess)) {

                        player.getEngine().addScore(howManyGotLetter);
                        System.out.println("correct");
                        return false;
                    } else {
                        System.out.println("Wrong answer! Try again.");
                        player.getEngine().loseLife();
                    }
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
            }
        }

        return false;
    }

    public static void showQuestionInfo(int categoryIndex,int howManyGotLetter) {
        System.out.print(LengthOfWords.get(categoryIndex).getQuestion());
        System.out.println("   Life(bu spnra süre olcak): " + player.getEngine().getLife());
        System.out.println("                    alınabilcek score "+player.getEngine().getReachableScore(howManyGotLetter));
        System.out.printf("                     Score: %.2f\n", player.getEngine().getScore());
    }

    public static int askChoice() {
        try {
            System.out.println("\nChoose one: "
                    + "\n0. Exit"
                    + "\n1. Take letter"
                    + "\n2. Estimate word");
            System.out.print("Choice: ");

            int c = input.nextInt();
            input.nextLine();
            return c;
        } catch (Exception e) {
            input.nextLine();
            return -1;
        }
    }

}
