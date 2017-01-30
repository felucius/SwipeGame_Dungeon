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
}
