package LengthOfWords;

public class TenLettersWords implements AllWords {

    private String[] TenLetterWordsArray;
    private String[] TenLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile tenWords;

    public TenLettersWords() {
        tenWords = new UploadWordsAndQuestionFromFile(10);
        lengthOfArrays = tenWords.howManyWordsSpecificLetters();

        TenLetterWordsArray = new String[lengthOfArrays];
        TenLetterQuestionArray = new String[lengthOfArrays];

        tenWords.getFillInWordsAndQuestions(
                TenLetterWordsArray,
                TenLetterQuestionArray
                
        );
    }

    public String getQuestion() {
        return TenLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * TenLetterWordsArray.length);
        return TenLetterWordsArray[random];
    }
}
