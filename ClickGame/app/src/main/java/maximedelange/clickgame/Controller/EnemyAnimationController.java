package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class EnemyAnimationController {

    // Fields
    AnimationDrawable enemy= null;
    private Context context = null;


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

    public AnimationDrawable enemyAnimation(int direction){
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
}
