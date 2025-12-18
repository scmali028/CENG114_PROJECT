package Game;

public class LifeManager {
    private int life;

    public LifeManager(int startingLife) {
        this.life = startingLife;
    }

    public int getLife() {
        return life;
    }

    public void loseLife() {
        life--;
    }
}
