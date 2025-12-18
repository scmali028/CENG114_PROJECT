/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import AdminProcess.AdminSystem;
import GUI.MainMenuFrame;
import Game.Admin;
import Game.NormalPlayer;
import LengthOfWords.*;
import LengthOfWords.FourLettersWords;
import LengthOfWords.FiveLettersWords;

import Game.Player;
import PlayerInformation.AddQuestionFromUser;
import PlayerInformation.ReaderAndWriterFileProcess;
import PlayerInformation.RegisterAndSignIn;
import PlayerInformation.Submit;
import java.awt.Choice;
import java.io.IOException;
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
    private static ArrayList<AllWords> LengthOfWords = new ArrayList<>();// main menüde direk yükleyelim aradan çıksın 
    private static Player normalPlayer;//cardPanelin registerında görevli olcak
    private static Player adminPlayer;//  buda aynı şekil yuakrdakiyle
    private static RegisterAndSignIn registerAndSignIn;// bunu yazdım zaten 

    public static void main(String[] args) throws IOException {
     MainMenuFrame frame =   new MainMenuFrame();
     frame.setVisible(true);
     // mainMenu();

    }

    public static void mainMenu() throws IOException {
        loadCategories();
      //  RegisterAndLoginMenu();

        createPlayer();

        boolean exit = false;

        for (int questionIndex = 0; questionIndex <= 6 && !exit; questionIndex++) {

            String randomWord = LengthOfWords.get(questionIndex).getRandomWord().toLowerCase();

            startNewQuestion(randomWord, questionIndex);

            exit = runQuestionLoop(questionIndex);

        }
        Submit sb = new Submit(normalPlayer);

        sb.writeOnScoreboard();

        System.out.println("do you wanna burda ana menü butonu olcak ");
        mainMenu();

    }

    /*public static void RegisterAndLoginMenu() throws IOException {

        registerAndSignIn = new RegisterAndSignIn(input);
        boolean check = true;
        while (check) {
            System.out.println("""
                0. Exit
                1. Register
                2. Sign In
                """);

            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.exit(0);
                    break;

                case 1: {
                    if (registerAndSignIn.register()) {
                        System.out.println("Register successful. Please sign in.");
                    } else {
                        System.out.println("Register failed.");
                    }
                    break;
                }

                case 2: {
                    int result = registerAndSignIn.signIn();

                    if (result == 1) {
                        System.out.println("Giriş başarılı.");
                        check = false;
                        return;
                    } else if (result == 0) {
                        System.out.println("Yönetici modu.");
                        adminPlayer = new Admin(registerAndSignIn.getUserName(), -1);
                        check = false;
                        return;
                    } else {
                        System.out.println("Giriş başarısız.");
                    }
                    break;
                }

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }*/

    public static void loadCategories() {
        LengthOfWords.add(new FourLettersWords());
        LengthOfWords.add(new FiveLettersWords());
        LengthOfWords.add(new SixLettersWords());
        LengthOfWords.add(new SevenLettersWords());
        LengthOfWords.add(new EightLettersWords());
        LengthOfWords.add(new NineLettersWords());
        LengthOfWords.add(new TenLettersWords());
    }

    public static void createPlayer() throws IOException {
        //System.out.println("enter name");
       // input.nextLine();
        String name = registerAndSignIn.getUserName();

        normalPlayer = new NormalPlayer(
                name,
                // oyuncu adı
                
                ReaderAndWriterFileProcess.getterLastIdFromFile(name),
                new Taking(), // harf alma stratejisi
                new Estimating()// kelime tahmin stratejisi
        );
        normalPlayer.getEngine().getPrintNoVisibleState();

        normalPlayer.displayName();

    }

    public static void startNewQuestion(String word, int questionOrd) {
        normalPlayer.getEngine().setNewWord(word);

        System.out.println();
        System.out.println(questionOrd + 1 + ". Question");
    }

    
    
    
        // bura önemli baya 
    public static boolean runQuestionLoop(int lengthOfWordsIndex) {

        int howManyGotLetter = 0;
        //bura süre olucak 
        while (normalPlayer.getEngine().getLife() > 0) {

            showQuestionInfo(lengthOfWordsIndex, howManyGotLetter);
            normalPlayer.getEngine().getPrintVisibleState();
            //printCurrentArr(normalPlayer.getEngine().getCurrent());// burdan current arr fonksiyonu yaz 

            if (normalPlayer.getEngine().isCompleted()) {
                System.out.println("Correct! Next Question.");
                return false;
            }

            int choice = askChoice();
            if (choice == 0) {
                return true; // exit
            }
            switch (choice) {

                case 1:
                    normalPlayer.getEngine().performTakingLetter();
                    howManyGotLetter++;
                    break;

                case 2:
                    System.out.println("Please enter your guess: ");
                    String guess = input.nextLine();

                    if (normalPlayer.getEngine().performEstimate(guess)) {

                        normalPlayer.getEngine().addScore(howManyGotLetter);
                        System.out.println("correct");
                        return false;
                    } else {
                        System.out.println("Wrong answer! Try again.");
                        normalPlayer.getEngine().loseLife();
                    }
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
            }
        }

        return false;
    }
    
    
    // burda labellar kullancaz int döndürürler +"" ile bağlarsın     
    public static void showQuestionInfo(int categoryIndex, int howManyGotLetter) {
        System.out.print(LengthOfWords.get(categoryIndex).getQuestion());
        System.out.println("   Life(bu spnra süre olcak): " + normalPlayer.getEngine().getLife());
        System.out.println("                    alınabilcek score " + normalPlayer.getEngine().getReachableScore(howManyGotLetter));
        System.out.printf("                     Score: %.2f\n", normalPlayer.getEngine().getScore());
    }
    
    
    
        // direk iptal bunu text fiedlarla faln yapcaz butonalrla faln
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
