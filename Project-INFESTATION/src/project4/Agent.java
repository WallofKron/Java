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
public class Agent {

    private String id;
    private int x_position;
    private int y_position;
    private int agentAP;
    Random r = new Random();

    public Agent(int x, int y) {                         //constructor with parameters
        setX(x);
        setY(y);
    }

    public Agent() {                                    //default constructor
        setX(r.nextInt(451));
        setY(r.nextInt(451));
    }

    public String getID() {
        return id;
    }

    public void setID(String tmp) {                     //overloaded method, one string one int
        id = tmp;
    }

    public void setID(int tmp) {
        id = "Agent " + tmp;
    }

    public int getX() {
        return x_position;
    }

    public void setX(int tmp) {                         //set x with a check for accuracy
        if (tmp >= 0 && tmp <= 451) {
            x_position = tmp;
        } else {
            System.out.println("Not proper X coordinate");
        }
    }

    public int getY() {
        return y_position;
    }

    public void setY(int tmp) {                           //set y with a check for accuracy
        if (tmp >= 0 && tmp <= 451) {
            y_position = tmp;
        } else {
            System.out.println("Not proper Y coordinate");
        }
    }

    public void attack() {                  //selects a random value between 2 and 10 assigns it to value
        int tmp = (r.nextInt(9)+1);
        setAttack(tmp);
    }

    public int getAttack() {    
        return agentAP;
    }

    public void setAttack(int tmp) {
        agentAP = tmp;
    }

    public void move() {                        //randomly moves position, species in unpredictable
        x_position = r.nextInt(451) + 1;
        y_position = r.nextInt(451) + 1;
    }

    @Override
    public String toString() {                  //print string with info on battle win
        String tostring = id + " killed human";
        return tostring;
    }
}