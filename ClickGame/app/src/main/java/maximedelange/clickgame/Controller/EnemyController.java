package maximedelange.clickgame.Controller;

import java.util.Random;

import maximedelange.clickgame.Domain.EnemyCoordinates;
import maximedelange.clickgame.Domain.Enemy;

/**
 * Created by M on 1/10/2017.
 */

public class EnemyController {

    // Fields
    private Enemy enemy = null;
    private Random amountOfGold = null;
    private Random amountOfDamage = null;
    private EnemyCoordinates coordinates = null;

    // Constructor
    public EnemyController(){
        coordinates = new EnemyCoordinates();
        enemy = new Enemy(0, 0, randomEnemyGold(), randomEnemyGold());
    }

    // Methods
    public int randomEnemyGold(){
        amountOfGold = new Random();
        return amountOfGold.nextInt(100);
    }

    public void setGold(int gold){
        this.enemy.setGold(gold);
    }

    public int getGold(){
        return this.enemy.getGold();
    }

    public int randomEnemyDamage(){
        amountOfDamage = new Random();
        return amountOfDamage.nextInt(1);
    }

    public void setDamage(){
        this.enemy.setDamage(randomEnemyDamage());
    }

    public int getDamage(){
        return this.enemy.getDamage();
    }

    public void setHealth(int health){
        this.enemy.setHealth(health);
    }

    public int getHealth(){
        return this.enemy.getHealth();
    }
}
