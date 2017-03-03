package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import maximedelange.clickgame.Domain.EnemyNames;
import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class EnemyAnimationController {

    // Fields
    AnimationDrawable enemy= null;
    private Context context = null;
    private int level = 1;


    // Constructor
    public EnemyAnimationController(Context context){
        this.context = context;
    }

    // Methods
    public AnimationDrawable getEnemyLevel1Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1sword7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel1Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordr7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel1Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy1swordup7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel2Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel2Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel2Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy2sworduplvl2up7), 150);

        return enemy;
    }

    public AnimationDrawable enemyAnimationLvl1(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel1Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel1Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel1Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable enemyAnimationLvl2(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel2Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel2Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel2Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable checkLevel(int level, int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(level){
            case 1:
                enemySpriteAnimation = enemyAnimationLvl1(direction);
                break;
            case 2:
                enemySpriteAnimation = enemyAnimationLvl2(direction);
                break;
            default:
                enemySpriteAnimation = enemyAnimationLvl2(direction);
                break;
        }

        return enemySpriteAnimation;
    }

    public String getEnemyName(int level){
        String enemyName = null;
        switch(level){
            case 1:
                enemyName = String.valueOf(EnemyNames.Bronze_Warrior);
                break;
            case 2:
                enemyName = String.valueOf(EnemyNames.Iron_Warrior);
                break;
            default:
                enemyName = String.valueOf(EnemyNames.Iron_Warrior);
                break;
        }

        return enemyName;
    }
}
