package proyectofive;
/*
 * Robert Florence
 * Project 5
 * Professor Fergy Ferg
 * Spring 2013
 * 5-21-13
 * This Project creates a Binary Tree data structure and displays it in a 
 * GUI window and on the console.
 */
public class Node {

    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}