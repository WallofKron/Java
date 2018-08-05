package project3;

/**
 * @author RobertFlorence 
 * Project 3 - Stack Game - trying to help kirk find his mas macho by
 * using a stack to jump from 'moon to moon.
 * CS 182 - Ferguson
 * April 2013
 */

public class Moon {
    
    private String name;
    private String passcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public Moon(String name, String passcode) {
        this.name = name;
        this.passcode = passcode;
    }
      
}