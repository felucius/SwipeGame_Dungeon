package maximedelange.clickgame.Domain;

import java.util.Random;

/**
 * Created by M on 1/29/2017.
 */

public class DamageCoordinates {

    // Fields
    private int xPos;
    private int yPos;
    private int[] left;
    private int[] right;
    private int[] bottom;
    private Random randomNumber;

    // Constructor
    public DamageCoordinates(){
        //randomNumber = new Random();
        left = new int[]{475, 900};
        right = new int[]{475, 900};
        bottom = new int[]{475, 900};
    }

    // Methods
    public int createCoordinates(int direction){
        //int number = randomNumber.nextInt(3);

        switch (direction){
            case 0:
                setxPos(left[0]);
                setyPos(left[1]);
                break;
            case 1:
                setxPos(right[0]);
                setyPos(right[1]);
                break;
            case 2:
                setxPos(bottom[0]);
                setyPos(bottom[1]);
                break;
        }

        return direction;
    }

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
}
