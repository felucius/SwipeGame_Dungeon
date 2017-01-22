package maximedelange.clickgame.Domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;

import maximedelange.clickgame.R;

/**
 * Created by M on 1/10/2017.
 */

public class Enemy {

    // Fields
    private int xPos;
    private int yPos;
    private int health;
    private int gold;
    private int image;
    private int damage;
    private ImageView imageView;
    private Rect size;

    // Constructor
    public Enemy(int xPos, int yPos, int gold, int damage){
        this.xPos = xPos;
        this.yPos = yPos;
        this.gold = gold;
        this.damage = damage;
        this.imageView = imageView;
        this.health = 1;
        this.size = new Rect();
        size.set(100, 100, 100, 100);
        this.image = R.mipmap.ic_launcher;
    }

    // Methods
    public void setxPos(int xPos){
        this.xPos = xPos;
    }

    public int getxPos(){
        return this.xPos;
    }

    public void setyPos(int yPos){
        this.yPos = yPos;
    }

    public int getyPos(){
        return this.yPos;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

    public int getGold(){
        return this.gold;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setHealth(int health){
        this.health = health;
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

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    public ImageView getImageView(){
        return this.imageView;
    }
}
