package maximedelange.clickgame.Controller;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import maximedelange.clickgame.Database.Database;
import maximedelange.clickgame.R;
import maximedelange.clickgame.Screens.PlayScreen;

/**
 * Created by M on 3/2/2017.
 */

public class PlayerStatisticsController {
    // Fields

    public PlayerStatisticsController() {

    }

    public Dialog statusScreen(Activity screen, PlayerController playerController, Database database) {
        final Dialog statusScreenDialog = new Dialog(screen);
        statusScreenDialog.setCanceledOnTouchOutside(false);
        statusScreenDialog.setCancelable(false);
        statusScreenDialog.setContentView(R.layout.status_screen);

        // Create textviews
        TextView statusHealth = (TextView) statusScreenDialog.findViewById(R.id.playerStatusHealthTxt);
        TextView statusTapDamage = (TextView) statusScreenDialog.findViewById(R.id.playerStatusTapDamageTxt);
        TextView statusHighScore = (TextView) statusScreenDialog.findViewById(R.id.playerStatusHighScoreTxt);
        TextView statusCurrentScore = (TextView) statusScreenDialog.findViewById(R.id.playerStatusCurrentScoreTxt);
        TextView statusGold = (TextView) statusScreenDialog.findViewById(R.id.playerStatusGoldTxt);
        TextView statusHealthUpgrades = (TextView) statusScreenDialog.findViewById(R.id.playerStatusAmountOfHealthUpgradesTxt);
        TextView statusDamageUpgrades = (TextView) statusScreenDialog.findViewById(R.id.playerStatusAmountOfDamageUpgradesTxt);
        TextView statusAttackspeedUpgrades = (TextView) statusScreenDialog.findViewById(R.id.playerStatusAmountOfAttackspeedTxt);

        // Displaying the character information
        statusHealth.setText("HEALTH: " + playerController.getHealth());
        statusTapDamage.setText("DAMAGE: " + playerController.getDamage());
        statusHighScore.setText("HIGH SCORE: " + database.getHighscore());
        statusCurrentScore.setText("SCORE: " + playerController.getScore());
        statusGold.setText("GOLD: " + playerController.getGold());
        statusHealthUpgrades.setText("TOTAL HEALTH UPGRADES: " + playerController.getAmountOfHealthUpgrades());
        statusDamageUpgrades.setText("TOTAL DAMAGE UPGRADES: " + playerController.getAmountOfDamageUpgrades());
        statusAttackspeedUpgrades.setText("TOTAL ATTACK SPEED UPGRADES: " + playerController.getAmountOfAttackspeedUpgrades());

        return statusScreenDialog;
    }

    public Dialog upgradeScreen(Activity screen, PlayerController playerController, int upgradecostHealth, int upgradecostDamage, int upgradecostAttackspeed) {
        final Dialog upgradeDialog = new Dialog(screen);
        upgradeDialog.setCanceledOnTouchOutside(false);
        upgradeDialog.setCancelable(false);
        upgradeDialog.setContentView(R.layout.upgrade_screen);

        // Creating views
        final TextView upgradeHealth = (TextView) upgradeDialog.findViewById(R.id.upgradeHealthTxt);
        final TextView upgradeHealthCost = (TextView) upgradeDialog.findViewById(R.id.upgradeHealthCostTxt);
        final TextView upgradeDamage = (TextView) upgradeDialog.findViewById(R.id.upgradeDamageTxt);
        final TextView upgradeDamageCost = (TextView) upgradeDialog.findViewById(R.id.upgradeDamageCostTxt);
        final TextView upgradeAttackspeed = (TextView) upgradeDialog.findViewById(R.id.upgradeAttackspeedTxt);
        final TextView upgradeAttackspeedCost = (TextView) upgradeDialog.findViewById(R.id.upgradeAttackspeedCostTxt);
        final Button btnUpgradeHealth = (Button) upgradeDialog.findViewById(R.id.btnUpgradeHealth);
        final Button btnUpgradeDamage = (Button) upgradeDialog.findViewById(R.id.btnUpgradeDamage);
        final Button btnUpgradeAttackspeed = (Button) upgradeDialog.findViewById(R.id.btnUpgradeAttackspeed);

        // Setting content to the views
        upgradeHealth.setText(String.valueOf(playerController.getHealth()));
        upgradeDamage.setText(String.valueOf(playerController.getDamage()));
        upgradeAttackspeed.setText(String.valueOf(playerController.getAttackspeed()));
        upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
        upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));
        upgradeAttackspeedCost.setText(String.valueOf("G " + upgradecostAttackspeed));

        btnUpgradeHealth.setText("upgrade"); // Health
        btnUpgradeDamage.setText("upgrade"); // Damage
        btnUpgradeAttackspeed.setText("upgrade"); // Attack speed

        return upgradeDialog;
    }
}
