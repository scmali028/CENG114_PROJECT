package Game;

public class WordSession {

    private String word;
    private int finalScore;

    public WordSession(String word, int finalScore) {
        this.word = word;
        this.finalScore = finalScore;
    }

    public String getWord() {
        return word;
    }

    public String toString() {
        return word + " - Score: " + finalScore;
    }
}
