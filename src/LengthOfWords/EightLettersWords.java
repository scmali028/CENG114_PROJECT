package LengthOfWords;

public class EightLettersWords implements AllWords {

    private String[] EightLetterWordsArray;
    private String[] EightLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionFromFile eightWords;

    public EightLettersWords() {
        eightWords = new UploadWordsAndQuestionFromFile(8);
        lengthOfArrays = eightWords.howManyWordsSpecificLetters();

        EightLetterWordsArray = new String[lengthOfArrays];
        EightLetterQuestionArray = new String[lengthOfArrays];

        eightWords.getFillInWordsAndQuestions(
                EightLetterWordsArray,
                EightLetterQuestionArray
        );
    }

    public String getQuestion() {
        return EightLetterQuestionArray[random];
    }

    public String getRandomWord() {
        random = (int) (Math.random() * EightLetterWordsArray.length);
        return EightLetterWordsArray[random];
    }
}
