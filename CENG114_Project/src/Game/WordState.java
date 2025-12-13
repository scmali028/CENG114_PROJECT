package Game;

public class WordState {

    private String answer;
    private char[] current;
    private int takenLetterCount;
    private int remainingEstimates;

    public WordState() {
    }

    public void setNewAnswer(String answer) {
        this.answer = answer;
        this.current = new char[answer.length()];
        this.takenLetterCount = 0;
        this.remainingEstimates = 3;
        for (int i = 0; i < current.length; i++) {
            current[i] = '-';
        }
    }

    public boolean revealLetter(char letter) {
        boolean found = false;
        letter = Character.toUpperCase(letter);

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter && current[i] == '-') {
                current[i] = letter;
                found = true;
            }
        }
        return found;
    }

    public void loseEstimateRight() {
        remainingEstimates--;
    }

    public int getRemainingEstimates() {
        return remainingEstimates;
    }

    public boolean hasEstimateRight() {
        return remainingEstimates > 0;
    }

    public int getTakenLetterCount() {
        return takenLetterCount;
    }

    public boolean isCompleted() {
        for (char c : current) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    public String getAnswer() {
        return answer;
    }

    public char[] getCurrent() {
        return current;
    }

    public String toString() {
        return new String(current);
    }
}
