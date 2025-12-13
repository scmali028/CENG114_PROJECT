package CategoriesOfWords;

import java.util.Random;

public class FourLetterCategory implements Categories {

    private String[] words = {
        "JAVA",
        "ROME",
        "KEDI",
        "C+++"  
    };

    private String[] questions = {
        "Programming language",
        "Capital of Italy",
        "Evcil hayvan",
        "Another programming language"
    };

    private int index;

    public FourLetterCategory() {
        Random r = new Random();
        index = r.nextInt(words.length);
    }

    @Override
    public int getWordLength() {
        return 4;
    }

    @Override
    public String getQuestion() {
        return questions[index];
    }

    @Override
    public String getAnswer() {
        return words[index];
    }
}
