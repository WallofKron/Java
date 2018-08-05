package project4;
import java.util.Scanner;
/**
 * @author RobertFlorence 
 * Comp Sci 111 
 * Project 4 
 * Prof. Ferguson 
 * Fall 2012
 */
public class Tree {

    private String type;
    private double height;
    int age;
    static Scanner Robert = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);

    public Tree() {
        type = null;
        height = 0.0;
        age = 0;
    }
    public Tree(String type, double height, int age) {
        this.type = type;
        this.height = height;
        this.age = age;
    }
    public void setType(String type) {
        if (!(type.length() < 0) && !(type.length() > 25)) {
            this.type = type;
        } else {
            System.out.println("Try again, thats not a type of tree");
        }
    }
    public void setAge(int age) {
        if (!(age < 0) && !(age > 150)) {
            this.age = age;
        } else {
            System.out.println("Trees dont live that long, try again");
        }
    }
    public void setHeight(double height) {
        if (!(height < 0) && !(height > 120)) {
            this.height = height;
        } else {
            System.out.println("Trees aren't that tall/short!");
        }
    }
    public double getHeight() {
        return height;
    }
    public int getAge() {
        return age;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {

   return "Tree [type = " + type + ", age = " + age + ", height = " + height
         + ", getType() = " + getType() + ", getAge() = " + getAge() + 
           ", getheight() = " + getHeight() + "]";
    }
  
    public static void main(String[] args) {
        Tree jax = new Tree();

        System.out.print("-Tree Creator-\n\n");
        System.out.print("Please enter age of tree(0-150 years old): ");
        jax.setAge(Robert.nextInt());

        System.out.print("Please enter the height of tree (0-120 feet): ");
        jax.setHeight(Robert.nextDouble());

        System.out.print("Please enter a type of tree: ");
        jax.setType(input.nextLine());

        System.out.println(jax.toString());

        Robert.close();
        input.close();

        System.out.println("\n\n\nHockey object!");

        Hockey slapshot = new Hockey();
        slapshot.setTeam("Los Angeles Kings");
        slapshot.setWlr(-5.0);
        slapshot.players = 42;

        System.out.println(slapshot.toString());
    }
}