/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

/**
 *
 * @author alise
 */
public class NineLetterCategory implements Categories{
      private String[] NineLetterWordsArray;
    private String[] NineLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile nineWords;

    public NineLetterCategory() {
        nineWords = new UploadWordsAndQuestionsFromFile(9);
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