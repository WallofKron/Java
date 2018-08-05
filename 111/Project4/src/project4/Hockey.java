package project4;
import java.util.Scanner;
/**
 * @author RobertFlorence 
 * Comp Sci 111 
 * Project 4 
 * Prof. Ferguson 
 * Fall 2012
 */
public class Hockey {

    private String team;
    int players;
    private double wlr;
    static Scanner Robert = new Scanner(System.in);
    static Scanner strinput = new Scanner(System.in);

    public Hockey() {
        team = null;
        players = 0;
        wlr = 0.0;
    }

    public Hockey(String team, int players, double wlr) {
        this.team = team;
        this.players = players;
        this.wlr = wlr;
    }
    public void setTeam(String team) {
        if (!(team.length() < 0) && !(team.length() > 50)) {
            this.team = team;
        } else {
            System.out.println("Try again, that is not a real team name!");
        }
    }
    public void setPlayers(int players) {
        if (!(players < 0) && !(players > 55)) {
            this.players = players;
        } else {
            System.out.println("Not enough/Too many players!");
        }
    }
    public void setWlr(double wlr) {
        if (!(wlr < -5.0) && !(wlr > 5.0)) {
            this.wlr = wlr;
        } else {
            System.out.println("Win/Loss ratio too high/too low");
        }
    }
    public String getTeam() {
        return team;
    }
    public int getPlayers() {
        return players;
    }
    public double getWlr() {
        return wlr;
    }

    @Override
    public String toString() {

  return "Hockey [team = " + team + ", players = " + players + ", W/L Ratio = " 
          + wlr + ", getTeam() = " + getTeam() + ", getPlayers() = " 
          + getPlayers() + ", getWlr() = " + getWlr() + "]";
    }

    public static void main(String[] args) {
        Hockey check = new Hockey();
        
        System.out.print("HOCKEY!\n\nPlease Enter Name of Team: ");
        check.setTeam(strinput.nextLine());

        System.out.print("How many players are on this team: ");
        check.setPlayers(Robert.nextInt());
        
        System.out.print("What is their win/loss ratio: ");
        check.setWlr(Robert.nextDouble());
        
        System.out.println(check.toString());
        
        Robert.close();
        strinput.close();
        
        System.out.println("\n\n\nReality Show object!");        
        
        Realityshow knockknock = new Realityshow();
        knockknock.setShowtitle("JOYsey Shore!");
        knockknock.setLength(2);
        knockknock.actors = 7;
        
        System.out.println(knockknock.toString());
    }
}