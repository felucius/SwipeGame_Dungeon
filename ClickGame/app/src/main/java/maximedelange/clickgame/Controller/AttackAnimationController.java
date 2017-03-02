package maximedelange.clickgame.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class AttackAnimationController {

    // Fields
    private AnimationDrawable attack = null;
    private Context context = null;
    private PlayerController playerController = null;

    // Constructor
    public AttackAnimationController(Context context){
        this.context = context;
    }

    // Methods
    public AnimationDrawable getArrowLeft(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl1al), 150);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl2left1), 150);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3left1), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3left1), 150);
                break;
        }

        return attack;
    }

    // Methods
    public AnimationDrawable getArrowRight(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl1ar), 150);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl2right1), 150);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3right1), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3right1), 150);
                break;
        }

        return attack;
    }

    public AnimationDrawable getArrowDown(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl1ad1), 150);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl2down1), 150);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3down1), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arrowlvl3down1), 150);
                break;
        }

        return attack;
    }

    public AnimationDrawable getSpellLeft(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1l4), 3000);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2left1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2left2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2left3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2left4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2left5), 3000);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3left1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3left2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3left3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3left4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3left5), 3000);
                break;
            case 3:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left6), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4left6), 150);
                break;
        }

        return attack;
    }

    public AnimationDrawable getSpellRight(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1r4), 3000);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2right1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2right2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2right3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2right4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2right5), 3000);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3right1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3right2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3right3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3right4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3right5), 3000);
                break;
            case 3:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right6), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4right6), 150);
                break;
        }

        return attack;
    }

    public AnimationDrawable getSpellDown(){
        attack = new AnimationDrawable();
        switch(playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d2), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d3), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.fireballlvl1d4), 3000);
                break;
            case 1:
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2down1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2down2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2down3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2down4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.frostboltlvl2down5), 3000);
                break;
            case 2:
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3down1), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3down2), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3down3), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3down4), 80);
                attack.addFrame(context.getResources().getDrawable(R.drawable.sparklvl3down5), 3000);
                break;
            case 3:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down6), 150);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down1), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down4), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down5), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down6), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down8), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down7), 150);
                attack.addFrame(context.getResources().getDrawable(R.drawable.arcaneboltlvl4down6), 150);
                break;
        }

        return attack;
    }

    public AnimationDrawable getAxeLeft(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left8), 70);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1left8), 70);
                break;
        }

        return attack;
    }

    public AnimationDrawable getAxeRight(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right8), 70);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1right8), 70);
                break;
        }

        return attack;
    }

    public AnimationDrawable getAxeDown(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down8), 70);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down7), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.axelvl1down8), 70);
                break;
        }

        return attack;
    }

    public AnimationDrawable getNecroSpellLeft(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left7), 3000);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1left7), 3000);
                break;
        }

        return attack;
    }

    public AnimationDrawable getNecroSpellRight(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right7), 3000);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1right7), 3000);
                break;
        }

        return attack;
    }

    public AnimationDrawable getNecroSpellDown(){
        attack = new AnimationDrawable();
        switch (playerController.getAmountOfDamageUpgrades()){
            case 0:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down7), 3000);
                break;
            default:
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down1), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down2), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down3), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down4), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down5), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down6), 70);
                attack.addFrame(context.getResources().getDrawable(R.drawable.floatingeyelvl1down7), 3000);
                break;
        }

        return attack;
    }

    /*
Animation of the character damage to a certain position
*/
    public AnimationDrawable damageAnimation(int enemyDirection, Activity getActivity){
        AnimationDrawable characterDamageAnimation = null;

        Intent intent = getActivity.getIntent();
        switch(enemyDirection){
            case 0:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = getArrowLeft();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = getSpellLeft();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = getAxeLeft();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = getNecroSpellLeft();
                }
                break;
            case 1:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = getArrowRight();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = getSpellRight();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = getAxeRight();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = getNecroSpellRight();
                }
                break;
            case 2:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = getArrowDown();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = getSpellDown();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = getAxeDown();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = getNecroSpellDown();
                }
                break;
        }

        return characterDamageAnimation;
    }
}
