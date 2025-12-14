/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

/**
 *
 * @author alise
 */
public class TenLetterCategory implements Categories{
 
    private String[] TenLetterWordsArray;
    private String[] TenLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile tenWords;

    public TenLetterCategory() {
        tenWords = new UploadWordsAndQuestionsFromFile(10);
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