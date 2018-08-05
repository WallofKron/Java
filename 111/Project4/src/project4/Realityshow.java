package project4;
import java.util.Scanner;
/**
 * @author RobertFlorence 
 * Comp Sci 111 
 * Project 4 
 * Prof. Ferguson Fall 2012
 */
public class Realityshow {

    int actors;
    private double length;
    private String showtitle;
    static Scanner Robert = new Scanner(System.in);
    static Scanner strinput = new Scanner(System.in);

    public Realityshow() {
        showtitle = null;
        length = 0.0;
        actors = 0;

    }
    public Realityshow(String showtitle, double length, int actors) {
        this.length = length;
        this.showtitle = showtitle;
        this.actors = actors;

    }
    public void setShowtitle(String showtitle) {
        if (!(showtitle.length() < 0) && !(showtitle.length() > 45)) {
            this.showtitle = showtitle;
        } else {
            System.out.println("Thats not a title of a reality show, retry");
        }
    }
    public void setActors(int actors) {
        if (!(actors < 0) && !(actors > 60)) {
            this.actors = actors;
        } else {
            System.out.println("Too many/Too few actors/actresses");
        }
    }
    public void setLength(double length) {
        if (!(length < 0) && !(length > 100)) {
            this.length = length;
        } else {
            System.out.println("Show length is too long/short!");
        }
    }
    public double getLength() {
        return length;
    }
    public int getActors() {
        return actors;
    }
    public String getShowtitle() {
        return showtitle;
    }
    @Override
    public String toString() {

return "RealityShow [Title = " + showtitle + ", actors = " + actors + 
     ", length = " + length + ", getShowtitle() = " + getShowtitle() + 
     ", getActors() = " + getActors() + ", getLength() = " + getLength() + "]";
    }
    
    public static void main(String[] args) {
        Realityshow dumb = new Realityshow();

        System.out.print("EMTVH1 REALITY SHOW!\n\n");
        System.out.print("Please enter name of reality show: ");
        dumb.setShowtitle(strinput.nextLine());

        System.out.print("How many Actors/actresses in your show (0-60): ");
        dumb.setActors(Robert.nextInt());

        System.out.print("How long is the show going to be (0-100 minutes): ");
        dumb.setLength(Robert.nextDouble());

        System.out.println(dumb.toString());

        Robert.close();
        strinput.close();

        System.out.println("\n\n\nTree object!");
        Tree bark = new Tree();
        bark.setType("Ipswich Pine");
        bark.setHeight(42);
        bark.age = 11;

        System.out.println(bark.toString());
    }
}