package Game;

public class WordState {
  private String answer;
    private char[] current;

    public WordState(String answer) {
        setNewAnswer(answer);
    }
    
    public  void fillingArrayAsANotVisible(char[] empthyAnswerArray) {
        for (int i = 0; i < empthyAnswerArray.length; i++) {

            empthyAnswerArray[i] = '-';

        }

    }
     public  void printCurrentArr(char []currentArray) {
        for (int i = 0; i < currentArray.length; i++) {
            System.out.printf("%2c", currentArray[i]);
        }
        System.out.println("");

    }

    public void setNewAnswer(String answer) {
        this.answer = answer;
        this.current = new char[answer.length()];

        for (int i = 0; i < current.length; i++) {
            current[i] = '-';
        }
    }

    public boolean isCompleted() {
        for (char c : current) {
            if (c == '-') return false;
        }
        return true;
    }

    public String getAnswer() {
        return answer;
    }

    public char[] getCurrent() {
        return current;
    }
}