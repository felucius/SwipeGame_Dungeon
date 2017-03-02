package maximedelange.clickgame.Controller;

import android.graphics.Rect;
import android.widget.ImageView;

/**
 * Created by M on 2/26/2017.
 */

public class CollisionController {
    // Fields

    public CollisionController(){

    }

    public void collisionDetection(ImageView damage, ImageView enemy){
        Rect playerCollision = new Rect();
        Rect enemyCollision = new Rect();

        damage.getHitRect(playerCollision);
        enemy.getHitRect(enemyCollision);

        if(Rect.intersects(playerCollision, enemyCollision)) {

        }
    }
}
