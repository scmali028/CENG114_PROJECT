/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LengthOfWords;

/**
 *
 * @author aliemre
 */
// 4harfli için
public class FourLettersWords implements AllWords {

    private String[] FourLetterWordsArray ;
    private String[] FourLetterQuestionArray;
    private int lengthOfArrays;
    private int random;
    
    
    protected UploadWordsAndQuestionFromFile fourWords;

    public FourLettersWords() {
        //System.out.println("girdi");
        this.fourWords = new UploadWordsAndQuestionFromFile(4); //bu construct dizinin laç leni olduğunu göstermek içiçn 
        lengthOfArrays = fourWords.howManyWordsSpecificLetters();//kaç tane 4 harfli kelime var onu döndğrdü
        FourLetterWordsArray = new String[lengthOfArrays];//arrayi bulunan kadar açtık
        FourLetterQuestionArray = new String[lengthOfArrays];

        fourWords.getFillInWordsAndQuestions(FourLetterWordsArray, FourLetterQuestionArray);//burdada artık dosyadan 4 harfli 
                                                                                                //kelimeve sorualrı yukardaki
                                                                                                //arraye atıcak.

    }

    public String getQuestion() {

        return FourLetterQuestionArray[random];

    }

    public String getRandomWord() {
        random = (int) (Math.random() * FourLetterWordsArray.length);

        return FourLetterWordsArray[random];
    }

}
