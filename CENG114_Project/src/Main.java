
import CategoriesOfWords.*;
import Game.Player;
import PlayerInformation.*;
import UserBehaviors.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Categories> LengthOfWords = new ArrayList<>();
    private static Player player;
    private static UserManager userManager ;
    private static User currentUser;

    public static void main(String[] args) throws FileNotFoundException {
        userManager = new UserManager();

        loadCategories();

        createPlayer();

        boolean exit = false;

        for (int questionIndex = 0; questionIndex <= 6 && !exit; questionIndex++) {

            String randomWord = LengthOfWords.get(questionIndex).getRandomWord().toLowerCase();

            startNewQuestion(randomWord, questionIndex);

            exit = runQuestionLoop(questionIndex);

        }
        currentUser.setScore((int) player.getEngine().getScore());
        userManager.saveToFile();

        System.out.println("Score saved. Goodbye!");

    }

    public static void loadCategories() {
        LengthOfWords.add(new FourLetterCategory());
        LengthOfWords.add(new FiveLetterCategory());
        LengthOfWords.add(new SixLetterCategory());
        LengthOfWords.add(new SevenLetterCategory());
        LengthOfWords.add(new EightLetterCategory());
        LengthOfWords.add(new NineLetterCategory());
        LengthOfWords.add(new TenLetterCategory());
    }
public static void createPlayer() {

    while (true) {

        System.out.println("1 - Register");
        System.out.println("2 - Login");
        int choice = input.nextInt();
        input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (choice == 1) {

            currentUser = userManager.register(username, password);

            if (currentUser != null) {
                break; // başarılı register
            }

            System.out.println("Username already exists. Try again.\n");

        } else if (choice == 2) {

            currentUser = userManager.login(username, password);

            if (currentUser != null) {
                break; // başarılı login
            }

            System.out.println("Wrong username or password. Try again.\n");

        } else {
            System.out.println("Invalid choice.\n");
        }
    }

    player = new Player(
            currentUser.getUsername(),
            "",
            new TakeLetter(),
            new Estimate()
    );

    player.displayName();
}

    public static void startNewQuestion(String word, int questionOrd) {
        player.getEngine().setNewWord(word);

        System.out.println();
        System.out.println(questionOrd + 1 + ". Question");
    }

    public static boolean runQuestionLoop(int lengthOfWordsIndex) {

        int howManyGotLetter = 0;
        //bura süre olucak 
        while (player.getEngine().getLife() > 0) {

            showQuestionInfo(lengthOfWordsIndex, howManyGotLetter);
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

    public static void showQuestionInfo(int categoryIndex, int howManyGotLetter) {
        System.out.print(LengthOfWords.get(categoryIndex).getQuestion());
        System.out.println("   Life(bu spnra süre olcak): " + player.getEngine().getLife());
        System.out.println("                    alınabilcek score " + player.getEngine().getReachableScore(howManyGotLetter));
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
