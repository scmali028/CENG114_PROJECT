package UserBehaviors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TakeLetter implements TakeLetterBehavior {

    private Random random = new Random();

    @Override
    public void takeLetter(char[] current, String answer) {

        List<Integer> hiddenIndexes = new ArrayList<>();

        for (int i = 0; i < current.length; i++) {
            if (current[i] == '-') {
                hiddenIndexes.add(i);
            }
        }

        if (hiddenIndexes.isEmpty()) return;

        int randomIndex = hiddenIndexes.get(
                random.nextInt(hiddenIndexes.size())
        );

        char letter = answer.charAt(randomIndex);

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                current[i] = letter;
            }
        }
    }
}
