package maximedelange.clickgame.Controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

import maximedelange.clickgame.Domain.Player;
import maximedelange.clickgame.R;

import static maximedelange.clickgame.Domain.Player.getStaticAmountOfAttackspeedUpgrades;
import static maximedelange.clickgame.Domain.Player.getStaticAmountOfHealthUpgrades;
import static maximedelange.clickgame.Domain.Player.getStaticAmountOfDamageUpgrades;

/**
 * Created by M on 1/10/2017.
 */

public class PlayerController {

    // Fields
    private Player player = null;
    public int damageMovement1, damageMovement2, damageMovement3 = 0;
    private int direction;
    private ImageView damage = null;
    private AnimationDrawable characterDamageAnimation = null;

    // Constructor
    public PlayerController(){

    }

    // Methods
    public void createPlayer(String name, ImageView sprite, Activity get){
        Intent intent = get.getIntent();
        damageMovement1 = 465;
        damageMovement2 = 495;
        damageMovement3 = 900;

        player = new Player(name, 3, R.mipmap.ic_launcher);
        sprite.setY(80);

        if(intent.getIntExtra("archer", 0) == 1){
            sprite.setImageResource(R.drawable.characterarcher1l1);
        }
        else if(intent.getIntExtra("wizard", 0) == 2){
            sprite.setImageResource(R.drawable.characterwizard1down1left);
        }
        else if(intent.getIntExtra("axethrower", 0) == 3){
            sprite.setImageResource(R.drawable.characteraxethrowerlvl1left1);
        }
        else if(intent.getIntExtra("necromancer", 0) == 4){
            sprite.setImageResource(R.drawable.characternecromancerlvl1left1);
        }

    }

    public int getHealth(){
        return player.getHealth();
    }

    public int getStartHealth(){
        return player.getStartHealth();
    }

    public void setHealth(int health){
        this.player.setHealth(health);
    }

    public void setUpgradeHealth(int health){
        this.player.setUpgradeHealth(health);
    }

    public void setUpgradeDamage(int health){
        this.player.setUpgradeDamage(health);
    }

    public void setUpgradeAttackspeed(int attackspeed){
        this.player.setUpgradeAttackspeed(attackspeed);
    }

    public String getName(){
        return player.getName();
    }

    public void setDamage(int damage){
        this.player.setDamage(damage);
    }

    public int getDamage(){
        return player.getDamage();
    }

    public void setAttackspeed(int attackspeed){
        this.player.setAttackspeed(attackspeed);
    }

    public int getAttackspeed(){
        return this.player.getAttackspeed();
    }

    public void setGold(int gold){
        this.player.setGold(gold);
    }

    public int getGold(){
        return this.player.getGold();
    }

    public void setBuyUpgrade(int upgradeCost){
        this.player.setBuyUpgrade(upgradeCost);
    }

    public int getScore(){
        return this.player.getScore();
    }

    public void setScore(int score){
        this.player.setScore(score);
    }

    public int getHighScore(){
        return player.getHighScore();
    }

    public void setHighScore(int score){
        this.player.setHighScore(score);
    }

    public void setAmountOfDamageUpgrades(int amountOfDamageUpgrades){
        this.player.setAmountOfDamageUpgrades(amountOfDamageUpgrades);
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getAmountOfDamageUpgrades(){
        return getStaticAmountOfDamageUpgrades();
    }

    public void setAmountOfHealthUpgrades(int amountOfHealthUpgrades){
        this.player.setAmountOfHealthUpgrades(amountOfHealthUpgrades);
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getAmountOfHealthUpgrades(){
        return getStaticAmountOfHealthUpgrades();
    }

    public void setAmountOfAttackspeedUpgrades(int amountOfAttackspeedUpgrades){
        this.player.setAmountOfAttackspeedUpgrades(amountOfAttackspeedUpgrades);
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getAmountOfAttackspeedUpgrades(){
        return getStaticAmountOfAttackspeedUpgrades();
    }

    public int enemyDoDamage(int damage){
        int playerHealth = player.getHealth();
        playerHealth -= damage;
        player.setHealth(playerHealth);
        return playerHealth;
    }

    public void getDamageDirectionLogic(int direction, ImageView damage, AnimationDrawable characterDamageAnimation){
        switch(direction){
            case 0:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement1 -= getAttackspeed();
                damage.setX(damageMovement1);
                break;
            case 1:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement2 += getAttackspeed();
                damage.setX(damageMovement2);
                break;
            case 2:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement3 += getAttackspeed();
                damage.setY(damageMovement3);
                break;
        }

        this.damage = damage;
        this.direction = direction;
        this.characterDamageAnimation = characterDamageAnimation;
    }

    public void getDamageDirection(int direction, Activity get){
        Intent intent = get.getIntent();
        switch(direction){
            case 0:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }

                break;
            case 1:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                break;
            case 2:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic(direction, damage, characterDamageAnimation);
                }
                break;
        }
    }

    public int healthUpgradeLogic(int upgradecostHealth){
        setBuyUpgrade(upgradecostHealth);
        // Adding 1 to the amount of upgrades.
        setAmountOfHealthUpgrades(1);

        // Checking for the amount of upgrades. For each upgrade the price
        // is getting up by percentage
        for (int i = 0; i < getAmountOfHealthUpgrades(); i++) {
            upgradecostHealth *= 1.5;
        }

        setUpgradeHealth(3); // Adding the new information.
        //int playerHealthBegin = getHealth();

        return upgradecostHealth;
    }

    public int damageUpgradeLogic(int upgradecostDamage){
        setBuyUpgrade(upgradecostDamage);
        // Adding 1 to the amount of upgrades
        setAmountOfDamageUpgrades(1);

        // Checking for the amount of upgrades. For each upgrade the price
        // is getting up by a percentage.

        for (int i = 0; i < getAmountOfDamageUpgrades(); i++) {
            upgradecostDamage *= 1.5;
        }

        setUpgradeDamage(1); // Adding the new information

        return upgradecostDamage;
    }

    public int attackspeedUpgradeLogic(int upgradecostAttackspeed){
        setBuyUpgrade(upgradecostAttackspeed);
        setAmountOfAttackspeedUpgrades(1); // Adding 1 to the amount of upgrades

        // Checking for the amount of upgrades. For each upgrade the price
        // is getting up by a percentage.
        for (int i = 0; i < getAmountOfAttackspeedUpgrades(); i++) {
            upgradecostAttackspeed *= 1.5;
        }

        // Adding the new information
        setUpgradeAttackspeed(5);

        return upgradecostAttackspeed;
    }
}
