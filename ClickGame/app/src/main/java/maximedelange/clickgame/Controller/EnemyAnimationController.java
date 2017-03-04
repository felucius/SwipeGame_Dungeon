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

    public AnimationDrawable getEnemyLevel3Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel3Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel3Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy3swordup7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel4Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel4Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel4Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy4swordup7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel5Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel5Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel5Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy5swordup7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel6Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel6Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel6Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy6swordup7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel7Left(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordleft7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel7Right(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordright7), 150);

        return enemy;
    }

    public AnimationDrawable getEnemyLevel7Up(){
        enemy = new AnimationDrawable();
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup1), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup2), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup3), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup4), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup5), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup6), 150);
        enemy.addFrame(context.getResources().getDrawable(R.drawable.enemy7swordup7), 150);

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

    public AnimationDrawable enemyAnimationLvl3(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel3Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel3Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel3Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable enemyAnimationLvl4(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel4Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel4Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel4Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable enemyAnimationLvl5(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel5Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel5Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel5Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable enemyAnimationLvl6(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel6Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel6Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel6Up();
                break;
        }

        return enemySpriteAnimation;
    }

    public AnimationDrawable enemyAnimationLvl7(int direction){
        AnimationDrawable enemySpriteAnimation = null;

        switch(direction){
            case 0:
                enemySpriteAnimation = getEnemyLevel7Left();
                break;
            case 1:
                enemySpriteAnimation = getEnemyLevel7Right();
                break;
            case 2:
                enemySpriteAnimation = getEnemyLevel7Up();
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
            case 3:
                enemySpriteAnimation = enemyAnimationLvl3(direction);
                break;
            case 4:
                enemySpriteAnimation = enemyAnimationLvl4(direction);
                break;
            case 5:
                enemySpriteAnimation = enemyAnimationLvl5(direction);
                break;
            case 6:
                enemySpriteAnimation = enemyAnimationLvl6(direction);
                break;
            case 7:
                enemySpriteAnimation = enemyAnimationLvl7(direction);
                break;
            default:
                enemySpriteAnimation = enemyAnimationLvl1(direction);
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
            case 3:
                enemyName = String.valueOf(EnemyNames.Dark_Knight);
                break;
            case 4:
                enemyName = String.valueOf(EnemyNames.Steel_Warrior);
                break;
            case 5:
                enemyName = String.valueOf(EnemyNames.Blue_paladin);
                break;
            case 6:
                enemyName = String.valueOf(EnemyNames.Green_Crusader);
                break;
            case 7:
                enemyName = String.valueOf(EnemyNames.Red_Commander);
                break;
            default:
                enemyName = String.valueOf(EnemyNames.Bronze_Warrior);
                break;
        }

        return enemyName;
    }
}
