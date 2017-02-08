package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

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
}
