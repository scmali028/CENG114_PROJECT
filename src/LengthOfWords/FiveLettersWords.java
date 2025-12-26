package LengthOfWords;

public class FiveLettersWords implements AllWords {

    private String[] FiveLetterWordsArray;
    private String[] FiveLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile fiveWords;

    public FiveLettersWords() {
        fiveWords = new UploadWordsAndQuestionFromFile(5);
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
