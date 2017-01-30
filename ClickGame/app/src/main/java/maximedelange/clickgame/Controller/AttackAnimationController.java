package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

/**
 * Created by M on 1/30/2017.
 */

public class AttackAnimationController {

    // Fields
    private AnimationDrawable attack = null;
    private Context context = null;

    // Constructor
    public AttackAnimationController(Context context){
        this.context = context;
    }

    // Methods
    public AnimationDrawable getAttackLeft(){

        return attack;
    }

    public AnimationDrawable getAttackRight(){

        return attack;
    }

    public AnimationDrawable getAttackDown(){

        return attack;
    }
}
