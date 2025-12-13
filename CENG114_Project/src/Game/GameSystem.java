
package Game;

import java.util.ArrayList;

public class GameSystem {

    private ArrayList<WordSession> sessions = new ArrayList<>();

    public void addSession(WordSession s) {
        sessions.add(s);
    }

    public void displayRecursive(int index) {
        if (index == sessions.size()) return;
        System.out.println(sessions.get(index));
        displayRecursive(index + 1);
    }

    public WordSession searchRecursive(String word, int index) {
        if (index == sessions.size()) return null;
        if (sessions.get(index).getWord().equalsIgnoreCase(word))
            return sessions.get(index);
        return searchRecursive(word, index + 1);
    }

    public void deleteSession(String word) {
        sessions.removeIf(s -> s.getWord().equalsIgnoreCase(word));
    }
}
