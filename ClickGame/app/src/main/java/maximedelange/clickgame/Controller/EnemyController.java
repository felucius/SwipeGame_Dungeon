package maximedelange.clickgame.Controller;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    int enemyMovement[], enemyHealthBar[], enemyHealthShow[], enemyNameShow[];
    int enemyHealthCounter = 0;
    private int enemyHealthBegin = 0;

    // Constructor
    public EnemyController(){
        coordinates = new EnemyCoordinates();
        enemyMovement = new int[3];
        enemyHealthBar = new int[3];
        enemyHealthShow = new int[3];
        enemyNameShow = new int[3];

        enemyMovement[0] = 0;
        enemyHealthBar[0] = 0;
        enemyHealthShow[0] = 0;
        enemyNameShow[0] = 0;

        enemyMovement[1] = 855;
        enemyHealthBar[1] = 855;
        enemyHealthShow[1] = 855;
        enemyNameShow[1] = 855;

        enemyMovement[2] = 1340;
        enemyHealthBar[2] = 1590;
        enemyHealthShow[2] = 1610;
        enemyNameShow[2] = 1630;

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

    public void checkEnemyPosition(int direction, ImageView enemy, ProgressBar enemyHealth, TextView enemyHealthTxt, TextView enemyName){
        // When the enemy hit the player the enemy is spawned to it's begin point.
        switch (direction){
            case 0:
                enemyMovement[0] = 0;
                enemyHealthBar[0] = 0;
                enemyHealthShow[0] = 0;
                enemyNameShow[0] = 0;
                enemy.setX(enemyMovement[0]);
                enemyHealth.setX(enemyHealthBar[0]);
                enemyHealthTxt.setX(enemyHealthShow[0]);
                enemyName.setX(enemyNameShow[0] - 20);
                break;
            case 1:
                enemyMovement[1] = 885;
                enemyHealthBar[1] = 885;
                enemyHealthShow[1] = 885;
                enemyNameShow[1] = 885;
                enemy.setX(enemyMovement[1]);
                enemyHealth.setX(enemyHealthBar[1]);
                enemyHealthTxt.setX(enemyHealthShow[1]);
                enemyName.setX(enemyNameShow[1]);
                break;
            case 2:
                enemyMovement[2] = 1340;
                enemyHealthBar[2] = 1590;
                enemyHealthShow[2] = 1610;
                enemyNameShow[2] = 1650;
                enemy.setY(enemyMovement[2]);
                enemyHealth.setY(enemyHealthBar[2]);
                enemyHealthTxt.setY(enemyHealthShow[2]);
                enemyName.setY(enemyNameShow[2]);
                break;
        }
    }

    public int[] createEnemy(int direction){
        int coords[] = new int[3];
        EnemyCoordinates enemyCoordinates = new EnemyCoordinates();

        setGold(randomEnemyGold());
        direction = enemyCoordinates.createCoordinates();
        coords[2] = direction;

        coords[0] = enemyCoordinates.getxPos();
        coords[1] = enemyCoordinates.getyPos();

        // Enemy health.
        enemyHealthBar[0] = 0;
        enemyHealthBar[1] = 855;
        enemyHealthBar[2] = 1685;
        enemyHealthShow[0] = 0;
        enemyHealthShow[1] = 855;
        enemyHealthShow[2] = 1705;
        enemyNameShow[0] = 0;
        enemyNameShow[1] = 855;
        enemyNameShow[2] = 1685;

        return coords;
    }

    public void getEnemyDirection(int direction, ImageView enemy, AnimationDrawable enemySpriteAnimation, ProgressBar enemyHealth, TextView enemyHealthTxt, TextView enemyName){
        switch(direction){
            case 0:
                enemyMovement[0] += 1;
                enemyHealthBar[0] += 1;
                enemyHealthShow[0] += 1;
                enemyNameShow[0] += 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setX(enemyMovement[0]);
                enemyHealth.setX(enemyHealthBar[0]);
                enemyHealthTxt.setX(enemyHealthShow[0]);
                enemyName.setX(enemyNameShow[0]);
                break;
            case 1:
                enemyMovement[1] -= 1;
                enemyHealthBar[1] -= 1;
                enemyHealthShow[1] -= 1;
                enemyNameShow[1] -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setX(enemyMovement[1]);
                enemyHealth.setX(enemyHealthBar[1]);
                enemyHealthTxt.setX(enemyHealthShow[1]);
                enemyName.setX(enemyNameShow[1]);
                break;
            case 2:
                enemyMovement[2] -= 1;
                enemyHealthBar[2] -= 1;
                enemyHealthShow[2] -= 1;
                enemyNameShow[2] -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setY(enemyMovement[2]);
                enemyHealth.setY(enemyHealthBar[2]);
                enemyHealthTxt.setY(enemyHealthShow[2]);
                enemyName.setY(enemyNameShow[2]);

                break;
        }
    }
}
