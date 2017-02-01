package maximedelange.clickgame.Domain;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/10/2017.
 */

public class Player {

    // Fields
    private int score;
    private int highScore;
    private String name;
    private int health;
    private int image;
    private int experience;
    private int damage;
    private int gold;
    private int attackspeed;

    // This field is static, so it can be called from the CharacterAnimationController
    private static int amountOfDamageUpgrades;
    // This field is static, so it can be called from the CharacterAnimationController
    private static int amountOfHealthUpgrades;
    // This field is static, so it can be called from the CharacterAnimationController
    private static int amountOfAttackspeedUpgrades;

    // Constructor
    public Player(String name, int health, int image){
        this.name = name;
        this.health = health;
        this.score = 0;
        this.highScore = 0;
        this.image = image;
        this.experience = 0;
        this.damage = 1;
        this.gold = 0;
        this.attackspeed = 5;
        this.amountOfDamageUpgrades = 0;
        this.amountOfHealthUpgrades = 0;
        this.amountOfAttackspeedUpgrades = 0;
    }

    // Methods
    public void setAmountOfDamageUpgrades(int amountOfDamageUpgrades){
        this.amountOfDamageUpgrades += amountOfDamageUpgrades;
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getStaticAmountOfDamageUpgrades(){
        return amountOfDamageUpgrades;
    }

    public void setAmountOfHealthUpgrades(int amountOfHealthUpgrades){
        this.amountOfHealthUpgrades += amountOfHealthUpgrades;
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getStaticAmountOfHealthUpgrades(){
        return amountOfHealthUpgrades;
    }

    public void setAmountOfAttackspeedUpgrades(int amountOfAttackspeedUpgrades){
        this.amountOfAttackspeedUpgrades += amountOfAttackspeedUpgrades;
    }

    // This method is static, so it can be called from the CharacterAnimationController
    public static int getStaticAmountOfAttackspeedUpgrades(){
        return amountOfAttackspeedUpgrades;
    }

    public void setGold(int gold){
        this.gold += gold;
    }

    public int getGold(){
        return this.gold;
    }

    public void setBuyUpgrade(int gold){
        this.gold -= gold;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return this.experience;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setHighScore(int score){
        this.highScore = score;
    }

    public int getHighScore(){
        return this.highScore;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setUpgradeHealth(int health){
        this.health += health;
    }

    public int getStartHealth(){
        return this.health = 3;
    }

    public void setUpgradeDamage(int health){
        this.damage += damage;
    }

    public void setAttackspeed(int attackspeed){
        this.attackspeed = attackspeed;
    }

    public int getAttackspeed(){
        return this.attackspeed;
    }

    public void setUpgradeAttackspeed(int attackspeed){
        this.attackspeed += attackspeed;
    }

    public int getHealth(){
        return this.health;
    }

    public void setImage(int image){
        this.image = image;
    }

    public int getImage(){
        return this.image;
    }
}
