package maximedelange.clickgame.Controller;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/30/2017.
 */

public class CharacterAnimationController {

    // Fields
    private AnimationDrawable character = null;
    private Context context = null;

    // Constructor
    public CharacterAnimationController(Context context){
        this.context = context;
    }

    // Methods
    public AnimationDrawable getCharacterLeft(){
        character = new AnimationDrawable();
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l1), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l2), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l3), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l4), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l5), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l6), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1l7), 150);

        return character;
    }

    public AnimationDrawable getCharacterRight(){
        character = new AnimationDrawable();
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r1), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r2), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r3), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r4), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r5), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r6), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1r7), 150);

        return character;
    }

    public AnimationDrawable getCharacterDown(){
        character = new AnimationDrawable();
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down1), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down2), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down3), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down4), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down5), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down6), 150);
        character.addFrame(context.getResources().getDrawable(R.drawable.characterarcher1down7), 150);

        return character;
    }
}
