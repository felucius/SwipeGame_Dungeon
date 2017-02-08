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
    private AnimationDrawable axethrower = null;
    private AnimationDrawable necromancer = null;
    private Context context = null;
    private PlayerController playerController = null;

    // Constructor
    public CharacterAnimationController(Context context){
        this.context = context;
    }

    // Methods
    // Archer
    public AnimationDrawable getArcherLeft(){
        archer = new AnimationDrawable();
        switch(playerController.getAmountOfHealthUpgrades()){
            case 0:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l7), 150);
                break;
            case 1:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left7), 150);
                break;
            default:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2left7), 150);
                break;
        }

        return archer;
    }

    public AnimationDrawable getArcherRight(){
        archer = new AnimationDrawable();
        switch(playerController.getAmountOfHealthUpgrades()){
            case 0:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r7), 150);
                break;
            case 1:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right7), 150);
                break;
            default:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2right7), 150);
                break;
        }

        return archer;
    }

    public AnimationDrawable getArcherDown(){
        archer = new AnimationDrawable();
        switch(playerController.getAmountOfHealthUpgrades()){
            case 0:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down7), 150);
                break;
            case 1:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down7), 150);
                break;
            default:
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down1), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down2), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down3), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down4), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down5), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down6), 150);
                archer.addFrame(context.getResources().getDrawable(R.drawable.characterarcherlvl2down7), 150);
                break;
        }

        return archer;
    }

    // Wizard
    public AnimationDrawable getWizardLeft(){
        wizard = new AnimationDrawable();
        switch(playerController.getAmountOfHealthUpgrades()){
            case 0:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down1left), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down2left), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down3left), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down4left), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down5left), 150);
                break;
            case 1:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2left1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2left2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2left3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2left4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2left5), 150);
                break;
            case 2:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3left1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3left2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3left3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3left4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3left5), 150);
                break;
            case 3:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left5), 150);
                break;
            default:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4left5), 150);
                break;
        }

        return wizard;
    }

    public AnimationDrawable getWizardRight(){
        wizard = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1right5), 150);
                break;
            case 1:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2right1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2right2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2right3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2right4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2right5), 150);
                break;
            case 2:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3right1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3right2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3right3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3right4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3right5), 150);
                break;
            case 3:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right5), 150);
                break;
            default:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right2), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right3), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right4), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4right5), 150);
                break;
        }

        return wizard;
    }

    public AnimationDrawable getWizardDown(){
        wizard = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard1down2), 150);
                break;
            case 1:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2down1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard2down2), 150);
                break;
            case 2:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3down1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard3down2), 150);
                break;
            case 3:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4down1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4down2), 150);
                break;
            default:
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4down1), 150);
                wizard.addFrame(context.getResources().getDrawable(R.drawable.characterwizard4down2), 150);
                break;
        }

        return wizard;
    }

    public AnimationDrawable getAxeThrowerLeft(){
        axethrower = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left2), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left3), 150);
                break;
            default:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left2), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1left3), 150);
                break;
        }

        return axethrower;
    }

    public AnimationDrawable getAxeThrowerRight(){
        axethrower = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right2), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right3), 150);
                break;
            default:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right2), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1right3), 150);
                break;
        }

        return axethrower;
    }

    public AnimationDrawable getAxeThrowerDown(){
        axethrower = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1down1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1down2), 150);
                break;
            default:
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1down1), 150);
                axethrower.addFrame(context.getResources().getDrawable(R.drawable.characteraxethrowerlvl1down2), 150);
                break;
        }

        return axethrower;
    }

    public AnimationDrawable getNecromancerLeft(){
        necromancer = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left2), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left3), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left4), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left5), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left6), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left7), 150);
                break;
            default:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left2), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left3), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left4), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left5), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left6), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1left7), 150);
                break;
        }

        return necromancer;
    }

    public AnimationDrawable getNecromancerRight(){
        necromancer = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright2), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright3), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright4), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright5), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright6), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright7), 150);
                break;
            default:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright2), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright3), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright4), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright5), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright6), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1lright7), 150);
                break;
        }

        return necromancer;
    }

    public AnimationDrawable getNecromancerDown(){
        necromancer = new AnimationDrawable();
        switch (playerController.getAmountOfHealthUpgrades()){
            case 0:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1down1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1down2), 150);
                break;
            default:
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1down1), 150);
                necromancer.addFrame(context.getResources().getDrawable(R.drawable.characternecromancerlvl1down2), 150);
                break;
        }

        return necromancer;
    }
}
