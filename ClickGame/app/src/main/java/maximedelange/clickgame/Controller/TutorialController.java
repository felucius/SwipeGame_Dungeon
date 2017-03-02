package maximedelange.clickgame.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import maximedelange.clickgame.Screens.PlayScreen;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

/**
 * Created by M on 1/30/2017.
 */

public class TutorialController {

    // Fields
    private PlayerController playerController = null;
    private Activity activity = null;

    // Constructor
    public TutorialController(Activity activity){
        this.activity = activity;
        playerController = new PlayerController();
    }

    public void showTutorial(String tutorialID, View player, View enemy, View currentScoreTxt, View btnStart, View btnUpgradeScreen, View btnStatusScreen){
        // Sequence
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        config.setContentTextColor(Color.RED);
        config.setDismissTextColor(Color.WHITE);
        config.setMaskColor(Color.DKGRAY);

        final MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(activity);//,tutorialID);

        sequence.setConfig(config);
        sequence.addSequenceItem(player, "This is" + playerController.getName() + " and he lives in a castle", "GOT IT");
        sequence.addSequenceItem(enemy, "Jack needs to defend himself from enemies", "GOT IT");
        sequence.addSequenceItem(currentScoreTxt, "For each kill, gain a new score count", "GOT IT");
        sequence.addSequenceItem(btnStart, "After tutorial, press here to start and pause the game", "GOT IT");
        sequence.addSequenceItem(btnUpgradeScreen, "Here you can purchase upgrades for " + playerController.getName(), "GOT IT");
        sequence.addSequenceItem(btnStatusScreen, "Here you can see the status of " + playerController.getName(), "GOT IT");
        sequence.addSequenceItem(player, "Goodluck to you, Jack!", "FIGHT");


        sequence.start();
    }
}
