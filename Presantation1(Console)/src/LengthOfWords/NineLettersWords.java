package LengthOfWords;

public class NineLettersWords implements AllWords {

    private String[] NineLetterWordsArray;
    private String[] NineLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile nineWords;

    public NineLettersWords() {
        nineWords = new UploadWordsAndQuestionFromFile(9);
        lengthOfArrays = nineWords.howManyWordsSpecificLetters();

        NineLetterWordsArray = new String[lengthOfArrays];
        NineLetterQuestionArray = new String[lengthOfArrays];

        nineWords.getFillInWordsAndQuestions(
                NineLetterWordsArray,
                NineLetterQuestionArray
                
        );
    }

    public String getQuestion() {
        return NineLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * NineLetterWordsArray.length);
        return NineLetterWordsArray[random];
    }
}
