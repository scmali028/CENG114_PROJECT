/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userBehaviors;

/**
 *
 * @author aliemre
 */
public class Estimating implements EstimateQuestionBehaviors {

    public boolean estimate(String answer, String estimate, char[] current) {

        if (answer.equalsIgnoreCase(estimate)) {
            for (int i = 0; i < current.length; i++) {
                current[i] = answer.charAt(i);

            }

        }

        return answer.equalsIgnoreCase(estimate);

    }
}
