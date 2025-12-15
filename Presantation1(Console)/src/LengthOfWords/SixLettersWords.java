package LengthOfWords;

public class SixLettersWords implements AllWords {

    private String[] SixLetterWordsArray;
    private String[] SixLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile sixWords;

    public SixLettersWords() {
        sixWords = new UploadWordsAndQuestionFromFile(6);
        lengthOfArrays = sixWords.howManyWordsSpecificLetters();

        SixLetterWordsArray = new String[lengthOfArrays];
        SixLetterQuestionArray = new String[lengthOfArrays];

        sixWords.getFillInWordsAndQuestions(
                SixLetterWordsArray,
                SixLetterQuestionArray
                
        );
    }

    public String getQuestion() {
        return SixLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * SixLetterWordsArray.length);
        return SixLetterWordsArray[random];
    }
}
