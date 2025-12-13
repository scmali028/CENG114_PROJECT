package Game;

public class Player {

    private String name;

    private static final int MIN_WORD_LENGTH = 4;
    private static final int MAX_WORD_LENGTH = 10;

    private int currentWordLength = MIN_WORD_LENGTH;

    private WordEngine wordEngine;

    public Player(String name, WordEngine wordEngine) {
        this.name = name;
        this.wordEngine = wordEngine;
    }

    public String getName() {
        return name;
    }

    public WordEngine getEngine() {
        return wordEngine;
    }

    public int getCurrentWordLength() {
        return currentWordLength;
    }

    public boolean hasNextQuestion() {
        return currentWordLength <= MAX_WORD_LENGTH;
    }

    public void moveToNextQuestion() {
        if (currentWordLength < MAX_WORD_LENGTH) {
            currentWordLength++;
        }
    }
}
