package UserBehaviors;

public class Estimate implements EstimateBehavior {

    @Override
    public boolean estimate(String answer, String guess, char[] current) {
        answer = answer.toUpperCase();
        guess = guess.toUpperCase();

        if (!answer.equals(guess)) {
            return false;
        }

        for (int i = 0; i < answer.length(); i++) {
            current[i] = answer.charAt(i);
        }
        return true;
    }

}
