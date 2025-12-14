/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriesOfWords;

/**
 *
 * @author alise
 */
public class EightLetterCategory implements Categories{
  private String[] EightLetterWordsArray;
    private String[] EightLetterQuestionArray;
    private int lengthOfArrays;
    private int random;

    protected UploadWordsAndQuestionsFromFile eightWords;

    public EightLetterCategory() {
        eightWords = new UploadWordsAndQuestionsFromFile(8);
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