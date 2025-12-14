/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userBehaviors;

/**
 *
 * @author aliemre
 */
public class Taking implements TakeLetter {
    //buraya array gelemsi lazım
    private int count=0;
    public void guessLetter(char[] currentArr, String answer) {
       
        while (true) {
            int random = (int) (Math.random() * currentArr.length);
            if (currentArr[random] == '-') {
                currentArr[random] = answer.charAt(random);
                count++;
                System.out.println(count);
                break;
            }
        }
        
    }
    
   
    
    
}
