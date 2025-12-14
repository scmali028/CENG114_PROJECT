/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

/**
 *
 * @author alise
 */
public class SixLetterCategory implements Categories{
 
    private String[] SixLetterWordsArray;
    private String[] SixLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile sixWords;

    public SixLetterCategory() {
        sixWords = new UploadWordsAndQuestionsFromFile(6);
        lengthOfArrays = sixWords.howManyWordsSpecificLetters();

        SixLetterWordsArray = new String[lengthOfArrays];
        SixLetterQuestionArray = new String[lengthOfArrays];

        sixWords.getFillInWordsAndQuestions(
                SixLetterWordsArray,
                SixLetterQuestionArray
                
        );
    }

    @Override
    public String getQuestion() {
        return SixLetterQuestionArray[random];
    }

    @Override
    public String getRandomWord() {
        random = (int) (Math.random() * SixLetterWordsArray.length);
        return SixLetterWordsArray[random];
    }
}