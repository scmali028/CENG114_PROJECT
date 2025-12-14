/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

/**
 *
 * @author alise
 */
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
