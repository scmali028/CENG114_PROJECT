package CategoriesOfWords;

import java.util.Random;

public class FiveLetterCategory implements Categories {

    private String[] words = {
        "ANKARA",
        "APPLE",
        "PARIS"
    };

    private String[] questions = {
        "Capital of Turkey",
        "A fruit",
        "Capital of France"
    };

    private int index;

    public FiveLetterCategory() {
        index = new Random().nextInt(words.length);
    }

    public int getWordLength() {
        return 5;
    }

    public String getQuestion() {
        return questions[index];
    }

    public String getAnswer() {
        return words[index];
    }
}
