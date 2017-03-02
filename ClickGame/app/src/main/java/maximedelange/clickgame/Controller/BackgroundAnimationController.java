package maximedelange.clickgame.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.widget.RelativeLayout;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class BackgroundAnimationController {

    // Fields
    private AnimationDrawable background = null;
    private Context context = null;

    // Constructor
    public BackgroundAnimationController(Context context){
        this.context = context;
    }

    // Methods
    public AnimationDrawable getBackground(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl1), 450);

        return background;
    }

    public AnimationDrawable getPlayscreenBackground(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundplayscreen1), 70);
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundplayscreen2), 70);
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundplayscreen3), 70);

        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel2(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl21), 70);
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl22), 70);
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl23), 70);

        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel3(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl3v2), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel4(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl4), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel5(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl5), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel6(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl6), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel7(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl7), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel8(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl8), 70);
        return background;
    }

    public AnimationDrawable getPlayscreenBackgroundlevel9(){
        background = new AnimationDrawable();
        background.addFrame(context.getResources().getDrawable(R.drawable.backgroundlvl9), 70);
        return background;
    }

    public void getPlayscreenLevel(int level, RelativeLayout linearLayout, AnimationDrawable backgroundAnimation){
        //Intent intent = get.getIntent();
        //level = intent.getIntExtra("level", 0);

        switch(level){
            case 1:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl1);
                //checkLevelRequirement();
                break;
            case 2:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl2);
                backgroundAnimation = getPlayscreenBackgroundlevel2();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 3:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl3v2);
                backgroundAnimation = getPlayscreenBackgroundlevel3();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 4:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl4);
                backgroundAnimation = getPlayscreenBackgroundlevel4();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 5:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl5);
                backgroundAnimation = getPlayscreenBackgroundlevel5();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 6:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl6);
                backgroundAnimation = getPlayscreenBackgroundlevel6();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 7:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl7);
                backgroundAnimation = getPlayscreenBackgroundlevel7();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 8:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl8);
                backgroundAnimation = getPlayscreenBackgroundlevel8();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 9:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl9);
                backgroundAnimation = getPlayscreenBackgroundlevel9();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            default:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl8);
                backgroundAnimation = getPlayscreenBackgroundlevel8();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
        }
    }
}
