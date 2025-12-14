package CategoriesOfWords;

public class FourLetterCategory implements Categories {

    private String[] FourLetterWordsArray;
    private String[] FourLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile fourWords;

    public FourLetterCategory() {
        //System.out.println("girdi");
        this.fourWords = new UploadWordsAndQuestionsFromFile(4); //bu construct dizinin laç leni olduğunu göstermek içiçn 
        lengthOfArrays = fourWords.howManyWordsSpecificLetters();//kaç tane 4 harfli kelime var onu döndğrdü
        FourLetterWordsArray = new String[lengthOfArrays];//arrayi bulunan kadar açtık
        FourLetterQuestionArray = new String[lengthOfArrays];

        fourWords.getFillInWordsAndQuestions(FourLetterWordsArray, FourLetterQuestionArray);//burdada artık dosyadan 4 harfli 
        //kelimeve sorualrı yukardaki
        //arraye atıcak.

    }

    @Override
    public String getQuestion() {

        return FourLetterQuestionArray[random];

    }

    @Override
    public String getRandomWord() {
        random = (int) (Math.random() * FourLetterWordsArray.length);

        return FourLetterWordsArray[random];
    }

}
