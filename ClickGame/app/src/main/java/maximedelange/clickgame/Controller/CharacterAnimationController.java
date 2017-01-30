package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class CharacterAnimationController {

    // Fields
    private AnimationDrawable archer = null;
    private AnimationDrawable wizard = null;
    private Context context = null;

    // Constructor
    public CharacterAnimationController(Context context){
        this.context = context;
    }

    // Methods
    // Archer
    public AnimationDrawable getArcherLeft(){
        archer = new AnimationDrawable();
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l1), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l2), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l3), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l4), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l5), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l6), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l7), 150);

        return archer;
    }

    public AnimationDrawable getArcherRight(){
        archer = new AnimationDrawable();
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r1), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r2), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r3), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r4), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r5), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r6), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r7), 150);

        return archer;
    }

    public AnimationDrawable getArcherDown(){
        archer = new AnimationDrawable();
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down1), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down2), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down3), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down4), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down5), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down6), 150);
        archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down7), 150);

        return archer;
    }

    // Wizard
    public AnimationDrawable getWizardLeft(){
        wizard = new AnimationDrawable();
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down1left), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down2left), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down3left), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down4left), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down5left), 150);

        return wizard;
    }

    public AnimationDrawable getWizardRight(){
        wizard = new AnimationDrawable();
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right1), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right2), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right3), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right4), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right5), 150);

        return wizard;
    }

    public AnimationDrawable getWizardDown(){
        wizard = new AnimationDrawable();
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down1), 150);
        wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down2), 150);

        return wizard;
    }
}
