package CategoriesOfWords;


public class FiveLetterCategory implements Categories {

    private String[] FiveLetterWordsArray;
    private String[] FiveLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile fiveWords;

    public FiveLetterCategory() {
        fiveWords = new UploadWordsAndQuestionsFromFile(5);
        lengthOfArrays = fiveWords.howManyWordsSpecificLetters();

        FiveLetterWordsArray = new String[lengthOfArrays];
        FiveLetterQuestionArray = new String[lengthOfArrays];

        fiveWords.getFillInWordsAndQuestions(
                FiveLetterWordsArray,
                FiveLetterQuestionArray
        );
    }

    public String getQuestion() {
        return FiveLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * FiveLetterWordsArray.length);
        return FiveLetterWordsArray[random];
    }
}
