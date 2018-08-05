package project4;
import java.util.Random;
/**
 * Ryan Alexiadis 
 * Prof. Bible 
 * Project 4
 *
 * Infestation
 * 
 * Comp. Sci. 111 
 * 4-20-15
 *
 */
public class Human {

    private String name;
    private int x_position;
    private int y_position;
    private String weapon;
    private String type;
    Random r = new Random();
    int humanType;
    int humanWeapon;

    public Human() {                           //default constructor randomly places all generated humans at beginning
        setName("Human");
        setX(r.nextInt(451) + 1);
        setY(r.nextInt(451) + 1);
        type();
        weapon();

    }

    public Human(String tmp, int x, int y, String type, String weapon) {               //constructor
        setName(tmp);
        setY(y);
        setX(x);
        type();
        weapon();

    }

    public String getType() {
        return type;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setType(String tmp) {
        type = tmp;
    }

    public void setWeapon(String tmp) {
        weapon = tmp;
    }

    public String getName() {
        return name;
    }

    public void setName(String tmp) {
        name = tmp;
    }

    public int getX() {
        return x_position;
    }

    public int getY() {
        return y_position;
    }

    public void setX(int tmp) {
        if (tmp >= 0 && tmp <= 451) {
            x_position = tmp;
        } else {
            System.out.println("Not proper X coordinate");
        }
    }

    public void setY(int tmp) {
        if (tmp >= 0 && tmp <= 451) {
            y_position = tmp;
        } else {
            System.out.println("Not proper Y coordinate");
        }
    }

    public void move(int x, int y) {            //humans move method, takes an x and y for change
        x_position = x_position + x;
        y_position = y_position + y;
    }                                           //  - for x is west, y is south, + is east and north

    public int attack() {                                   //human attack power is determined by human type and weapon
        int humanAP = humanType + humanWeapon;
        return humanAP;
    }

    @Override
    public String toString() {
        String tostring = name + ", who is a " + type + " person, killed an agent with a " + weapon;
        return tostring;
    }                                                              //print string with info on battle win

    public void type() {                                //human type is decided randomly
        humanType = r.nextInt(5) + 1;
        if (humanType == 1) {
            setType("Baby");
        } else if (humanType == 2) {
            setType("Kid");
        } else if (humanType == 3) {
            setType("Teen");
        } else if (humanType == 4) {
            setType("Geezer");
        } else if (humanType == 5) {
            setType("Adult");
        }
    }

    public void weapon() {                              //the humans weapon is decided randomly
        humanWeapon = r.nextInt(5) + 1;
        if (humanWeapon == 1) {
            setWeapon("Fist");
        } else if (humanWeapon == 2) {
            setWeapon("Knife");
        } else if (humanWeapon == 3) {
            setWeapon("Pistol");
        } else if (humanWeapon == 4) {
            setWeapon("Shotgun");
        } else if (humanWeapon == 5) {
            setWeapon("Rocket");
        }
    }
}