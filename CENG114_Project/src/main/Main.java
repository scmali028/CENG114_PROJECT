package main;

import java.util.Scanner;

import CategoriesOfWords.Categories;
import CategoriesOfWords.FourLetterCategory;
import CategoriesOfWords.FiveLetterCategory;

import Game.WordEngine;
import Game.WordState;
import Game.ScoreManager;

import UserBehaviors.TakeLetter;
import UserBehaviors.Estimate;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WORD GAME ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Behaviors
        TakeLetter takeLetter = new TakeLetter();
        Estimate estimate = new Estimate();

        // Core game objects
        WordState wordState = new WordState();
        ScoreManager scoreManager = new ScoreManager();
        WordEngine engine = new WordEngine(
                wordState,
                scoreManager,
                takeLetter,
                estimate
        );

        System.out.println("\nWelcome " + name + "!\n");

        // Sadece 4 ve 5 harfli kategoriler
        Categories[] categories = {
            new FourLetterCategory(),
            new FiveLetterCategory()
        };

        for (Categories category : categories) {

            System.out.println("----------------------------------");
            System.out.println("Question (" + category.getWordLength() + " letters)");
            System.out.println("Points: " + category.getWordLength() * 10);
            System.out.println("Hint: " + category.getQuestion());

            engine.setNewWord(category.getAnswer());

            boolean finished = false;

            while (!finished) {

                System.out.println("\nCurrent: " + String.valueOf(engine.getCurrent()));
                System.out.println("1 - Take Letter");
                System.out.println("2 - Estimate Word");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        engine.takeLetter();
                        break;

                    case 2:
                        System.out.print("Your guess: ");
                        String guess = scanner.nextLine();

                        if (engine.performEstimate(guess)) {
                            System.out.println("Correct!");
                            engine.calculateFinalScore();
                            finished = true;
                        } else {
                            System.out.println("Wrong guess.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

                if (engine.isCompleted()) {
                    finished = true;
                }
            }
        }

        System.out.println("\nGame Finished!");
        System.out.println("Final Score: " + scoreManager.getScore());
    }
}
