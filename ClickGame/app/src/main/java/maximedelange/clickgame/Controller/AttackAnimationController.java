package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import maximedelange.clickgame.R;

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
    public AnimationDrawable getFireBallLevel1Left(){
        attack = new AnimationDrawable();
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l1), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l2), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l3), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l4), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l5), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l6), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l7), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l8), 150);

        return attack;
    }

    public AnimationDrawable getFireBallLevel1Right(){
        attack = new AnimationDrawable();
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r1), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r2), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r3), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r4), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r5), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r6), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r7), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r8), 150);

        return attack;
    }

    public AnimationDrawable getFireBallLevel1Down(){
        attack = new AnimationDrawable();
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d1), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d2), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d3), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d4), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d5), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d6), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d7), 150);
        attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d8), 150);

        return attack;
    }
}
