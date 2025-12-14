/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

/**
 *
 * @author alise
 */
public class SevenLetterCategory implements Categories{
    

    private String[] SevenLetterWordsArray;
    private String[] SevenLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile sevenWords;

    public SevenLetterCategory() {
        sevenWords = new UploadWordsAndQuestionsFromFile(7);
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