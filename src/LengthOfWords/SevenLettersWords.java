package LengthOfWords;

public class SevenLettersWords implements AllWords {

    private String[] SevenLetterWordsArray;
    private String[] SevenLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile sevenWords;

    public SevenLettersWords() {
        sevenWords = new UploadWordsAndQuestionFromFile(7);
        lengthOfArrays = sevenWords.howManyWordsSpecificLetters();

        SevenLetterWordsArray = new String[lengthOfArrays];
        SevenLetterQuestionArray = new String[lengthOfArrays];

        sevenWords.getFillInWordsAndQuestions(
                SevenLetterWordsArray,
                SevenLetterQuestionArray
                
        );
    }

    public String getQuestion() {
        return SevenLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * SevenLetterWordsArray.length);
        return SevenLetterWordsArray[random];
    }
}
